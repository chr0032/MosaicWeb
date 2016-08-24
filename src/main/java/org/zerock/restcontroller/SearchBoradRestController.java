package org.zerock.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

// jsp 제거 marshalling 작업 
@RestController
@RequestMapping("/rboard")
public class SearchBoradRestController {

	static Logger logger = LoggerFactory.getLogger(SearchBoradRestController.class);

	@Inject
	BoardService service;

	@RequestMapping(value = "/list")
	// 페이지 전송 하는 것 ↓
	public List<BoardVO> listPage(Criteria cri) throws Exception {

		logger.info(cri.toString());

		List<BoardVO> boards = service.listCriteria(cri);

		// List<BoardVO> boards = new ArrayList<>();
		// BoardVO b = new BoardVO();
		// b.setBno(10); b.setContent("xxxx"); b.setTitle("yyyy");
		// boards.add(b);

		return boards; // Marshalling

	}

	@RequestMapping(value = "/listAll")
	// 페이지 전송 하는 것 ↓
	public ResponseEntity<String> listAll(Criteria cri, HttpServletResponse response) throws Exception {

		logger.info(cri.toString());

		response.setContentType("application/json");

		// List<BoardVO> boards = service.listCriteria(cri);
		// List<BoardVO> boards = new ArrayList<>();
		// BoardVO b = new BoardVO();
		// b.setBno(10); b.setContent("xxxx"); b.setTitle("yyyy");
		// boards.add(b);

		// ResponseEntity 에러 선택권까지 처리할때, 응답 선택권
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK); // Marshalling

	}

}
