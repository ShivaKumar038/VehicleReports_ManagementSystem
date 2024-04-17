package com.msd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.msd.springboot.entity.Attachment;
import com.msd.springboot.service.AttachmentService;

@Controller
public class FileUploadController {

	@Autowired
	private AttachmentService attachmentService;
	
	@PostMapping("/upload")
	public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("uploadedby") String uploadedBy,
			@RequestParam("uploadedDate") String date) {
		
		try {
			Attachment attachment = attachmentService.savefile(file,uploadedBy,date);
			return new ResponseEntity("file saved",HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("not saved"+e);
			return new ResponseEntity("file not saved",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
