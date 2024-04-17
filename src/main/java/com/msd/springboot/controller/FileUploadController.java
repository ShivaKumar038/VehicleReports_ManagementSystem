package com.msd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.msd.springboot.entity.Attachment;
import com.msd.springboot.service.AttachmentService;

@Controller
public class FileUploadController {

	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping("/home") 
	public String home() {
		System.out.println("hello world!!!!!!!!!!");
		return "home";
	}
	
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
	
	@GetMapping("/attachment/{id}") 
	public ResponseEntity<Resource> getAttachment(@PathVariable int id) {
	    try {
	        Attachment attachment = attachmentService.getAttachmentById(id);
	        ByteArrayResource resource = new ByteArrayResource(attachment.getData());

	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + attachment.getFileName())
	                .contentLength(attachment.getData().length)
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .body(resource);
	    } catch (Exception e) {
	        System.out.println("File not found: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
}

