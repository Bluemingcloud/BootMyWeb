package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicMapper {

    public int topicInsert(TopicVO vo);
    public List<TopicVO> getList(Criteria cri);
    public int getTotal();
    public TopicVO getDetail(int topicId);
    public List<TopicVO> getListMe(@Param("topicWriter") String topicWriter, @Param("cri") Criteria cri);
    public int getTotalMe(String topicWriter);
    public int topicUpdate(TopicVO vo);
    public int topicDelete(int topicId);
}
