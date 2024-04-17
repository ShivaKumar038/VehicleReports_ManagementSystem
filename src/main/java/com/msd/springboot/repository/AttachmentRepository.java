package com.msd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msd.springboot.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{

}
