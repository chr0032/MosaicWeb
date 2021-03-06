package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.MessageVO;
import org.zerock.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
  static Logger logger = LoggerFactory.getLogger(MessageController.class); 	
  @Inject
  private MessageService service;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<String> addMessage(@RequestBody MessageVO vo) {

    ResponseEntity<String> entity = null;
    try {
      service.addMessage(vo);
      entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    return entity;
  }
  //ReadMessage Service 참조 로직 짜야함!!!!! get 방식으로
  @RequestMapping(value="/", method=RequestMethod.GET)
  public ResponseEntity<String> readMessage(@RequestBody MessageVO vo) {
	  
	  ResponseEntity<String> entity = null;
	
	  return null;
	  
	  }
}
