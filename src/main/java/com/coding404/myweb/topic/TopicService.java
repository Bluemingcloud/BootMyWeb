package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;

import java.util.List;

public interface TopicService {

    public int topicInsert(TopicVO vo);
    public List<TopicVO> getList(Criteria cri);
    public int getTotal();
    public List<TopicVO> getListMe(String topicWriter, Criteria cri);
    public int getTotalMe(String topicWriter);
    public TopicVO getDetail(int topicId);
    public int topicUpdate(TopicVO vo);
    public int topicDelete(int topicId);

}
