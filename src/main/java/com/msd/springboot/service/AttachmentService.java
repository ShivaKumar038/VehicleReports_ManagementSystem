package com.msd.springboot.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.msd.springboot.entity.Attachment;
import com.msd.springboot.repository.AttachmentRepository;

@Service
public class AttachmentService {
	
	@Autowired
	private AttachmentRepository attachmentRepository;

	public Attachment savefile(MultipartFile file, String uploadedBy, String date) throws Exception {
		
		try {
			LocalDate date1 = LocalDate.parse(date);
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			
			if(fileName.contains("...")) {
				throw new Exception("inavalid sequence"+fileName);
			}
			
			Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes(), uploadedBy, date1);
			return attachmentRepository.save(attachment);
		} catch (IOException e) {
			throw new Exception("could not save file");
		} 
	}

}
