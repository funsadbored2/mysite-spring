package com.mysite.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public String restore(MultipartFile file) {
		
		String saveDir = "D:\\JavaStudy\\file\\";
		
		//원 파일 이름 추출
		String orgName = file.getOriginalFilename();
		System.out.println("이름: " + orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("확장자명: " + exName);
		
		//파일 크기
		long fileSize = file.getSize();
		System.out.println("파일크기 :" + fileSize);
		
		//데이터 저장파일이름
		//데이터에 저장할 때는 유니크한 이름으로 바꿔 저장 해줘야한다.
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("저장 시 이름: " + saveName);
		
		//파일 패스 (저장 될 위치)
		String filePath = saveDir + saveName;
		System.out.println("파일 저장 경로: " + filePath);
		
		//파일 복사(저장 위해)
		try {
		
			byte[]  fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			
			if(bout != null) {
				bout.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
	}
	
}
