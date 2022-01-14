package kr.co.repository;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.ItemVO;
import kr.co.domain.PageTO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private final String NS = "kr.co.item";

	@Override
	public void insert(ItemVO vo) {
		sqlSession.insert(NS+".insert", vo);
	}

	@Override
	public ItemVO read(int item_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".read", item_no);
	}

	@Override
	public ItemVO updateUI(int item_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".updateUI", item_no);
	}

	@Override
	public void update(ItemVO vo) {
		sqlSession.update(NS+".update", vo);
	}

	@Override
	public int getAmount() {
		
		return sqlSession.selectOne(NS+".getAmount");
	}

	@Override
	public List<ItemVO> list(PageTO<ItemVO> pt) {
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".list", null, rbs);
	}

	@Override
	public void delete(int item_no) {
		sqlSession.delete(NS+".delete", item_no);
	}

	@Override
	   public List<ItemVO> searchitem(Map<String, Object> map) {
	      return sqlSession.selectList(NS + ".searchitem", map);
	   }

	@Override
	public List<ItemVO> getItem_size(String item_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + ".getItem_size", item_name);
	}

	@Override
	public List<ItemVO> getItem_color(String item_name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS + ".getItem_color", item_name);
	}

	@Override
	public int getAmountbycategory(String item_category) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+".getAmountbycategory",item_category);
	}

	@Override
	public List<ItemVO> listbycategory(PageTO<ItemVO> pt, String item_category) {
		// TODO Auto-generated method stub
		RowBounds rbs = new RowBounds(pt.getStartNum()-1, pt.getPerPage());
		return sqlSession.selectList(NS+".listbycategory", item_category, rbs);
	}
}
