package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MessageVO;
import org.zerock.persistence.MessageDAO;
import org.zerock.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {

  @Inject
  private MessageDAO messageDAO;

  @Inject
  private PointDAO pointDAO;

 @Transactional
  @Override
  public void addMessage(MessageVO vo) throws Exception {
	//Rollback 후  취소됨  
	//Transaction 처리 안하면 일부는 반영되어 일관성(consistency)이 깨진다!
    messageDAO.create(vo);
    pointDAO.updatePoint(vo.getSender(), 10);
  }

  @Transactional
  @Override
  public MessageVO readMessage(String uid, Integer mid) throws Exception {
	  
	// 하나로 묶여짐 하나의 커넥션으로 ↓  
    messageDAO.updateState(mid);

    pointDAO.updatePoint(uid, 5);

    return messageDAO.readMessage(mid);
  }
}
