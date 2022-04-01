package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberServiceTest {
	
	
	@Autowired
    MemberService memberService;
	
	
	@Test
	void ListTest() {
		List<Member> memberList = memberService.getMemberList();
		for (Member member : memberList) {
			log.info("member 의 값  : {}", member.toString() );
		}
	}
	
	@Test
	void MemberDetailTest() {
		Member memberDetail = memberService.getMember(1);
		log.info("1번 member의 정보 :  {}" ,memberDetail.toString());
	}
	
	@Test
	void MemberInsert() {

		Member member = new Member();
		member.setId(4);
		member.setName("name4");
		
		int result = memberService.createMember(member);
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	void MemberDelete() {
		int result = memberService.deleteMember(1);
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	void MemberUpdate() {
		
		

		Member memberDetail = memberService.getMember(1);
		log.info("수정 전 : {} " , memberDetail);
		memberDetail.setName("hi");
		memberDetail.setId(50);
		
		log.info("수정 후 : {}" , memberDetail);
	}
	
}
