package com.ssy.test.board.notice;

import java.io.File;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssy.test.board.impl.BoardDAO;
import com.ssy.test.board.impl.BoardDTO;
import com.ssy.test.board.impl.BoardFileDTO;
import com.ssy.test.board.impl.BoardService;
import com.ssy.test.util.FileManger;
import com.ssy.test.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManger fileManger;
	
//	@Autowired
//	private ServletContext servletContext;
	
	
	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception {
		//디테일 불러온 후 파일을 DB에서 먼저 지우고 ? 삭제
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);
		System.out.println("FileNum : "+boardFileDTO.getFileNum());
		
		int result = noticeDAO.setFileDelete(boardFileDTO);
		String path = "resources/upload/notice";
		System.out.println("DB DELETE : "+result);
		
		if(result>0) {
			boolean check = fileManger.delteFile(servletContext, path, boardFileDTO);
			System.out.println("fileDelete : "+check);
		}
		return result;
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
//		System.out.println("Service Page : "+page);
//		
//		Long perPage = 15L; //한 페이지에 출력할 목록의 갯수
//		// 페이지에 15개씩 출력 기준
//		// page      startRow      lastRow
//		//  1            1            15
//		//  2           16            30
//		
//		Long startRow=(page-1)*perPage+1;
//		Long lastRow=page*perPage;
//		
//		System.out.println("StartRow : "+startRow);
//		System.out.println("LastRow : "+lastRow);
//		Map<String, Long> map= new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		/***************************
//		 * JSP에 페이지 번호를 출력 1-?
//		 * 1. 글의 총 갯수
//		 * *************************/
//		Long totalCount = noticeDAO.getCount();
//		
//		/**************************
//		 * 2. 글의 총 페이지수
//		 **************************/
//		Long totalPage = totalCount/perPage;
//		if(totalCount%perPage != 0) {
//			totalPage++;
//		}
//		
//		/**************************
//		 * 3. totalBock 갯수 구하기
//		 * Bolck : 
//		 * perBlock  : 한 페이지에 출력할 번호와 수 
//		 **************************/
//		
//		
//		
//		/****************************
//		 * 4.
//		 */
//		Long curBlock = page/perBlock;
//		if(page%perBlock !=0) {}
//		curBlock++;
//		
//		/****************************
//		 * 5. curBlock 으로 시작번호와 끝번호 알아내기
//		 */
//		Long startNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;
		
		return noticeDAO.getList(pager);		
	}

	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";
		
//		//1. 실제 경로
//		String realPath = servletContext.getRealPath("resources/upload/notice");
//		System.out.println(realPath);
//		
//		//2. 폴더 확인
//		File file = new File(realPath);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
		
		//3. 저장할 파일명 만들기
		//비어있으면 다음으로 넘어감
		for(MultipartFile mf:files) {
			if(mf.isEmpty()) {
				continue;
			}
			//안 비어있으면 저장하는 코드
//			String fileName = UUID.randomUUID().toString();
//			fileName = fileName+"_"+mf.getOriginalFilename();
			String fileName = fileManger.saveFile(servletContext, path, mf);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(mf.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		
		return result;//noticeDAO.setAdd(boardDTO);
	}

	
	// 글 수정
	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		
		String path = "resources/upload/notice";
		int result = noticeDAO.setUpdate(boardDTO);
		
		if(result<1) {
			return result;
		}
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManger.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		
		return noticeDAO.setUpdate(boardDTO);
	}

	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	

}
