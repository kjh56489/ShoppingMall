package kr.co.service;

import java.util.List;
import java.util.Map;

import kr.co.domain.PageTO;
import kr.co.domain.ReviewVO;

public interface ReviewService {

	void insert(Map<String, Object> map);

	PageTO<ReviewVO> getRepliesPage(PageTO<ReviewVO> pt, int board_no);

	List<ReviewVO> getAllReplies(int board_no);

	void updateReview(ReviewVO rvo);

}
