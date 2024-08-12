package com.coding404.myweb.topic.impl;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.topic.TopicMapper;
import com.coding404.myweb.topic.TopicService;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public int topicInsert(TopicVO vo) {
        return topicMapper.topicInsert(vo);
    }

    @Override
    public List<TopicVO> getList(Criteria cri) {
        return topicMapper.getList(cri);
    }

    @Override
    public int getTotal() {
        return topicMapper.getTotal();
    }

    @Override
    public TopicVO getDetail(int topicId) {
        return topicMapper.getDetail(topicId);
    }

    @Override
    public List<TopicVO> getListMe(String topicWriter, Criteria cri) {
        return topicMapper.getListMe(topicWriter, cri);
    }

    @Override
    public int getTotalMe(String topicWriter) {
        return topicMapper.getTotalMe(topicWriter);
    }

    @Override
    public int topicUpdate(TopicVO vo) {
        return topicMapper.topicUpdate(vo);
    }

    @Override
    public int topicDelete(int topicId) {
        return topicMapper.topicDelete(topicId);
    }
}
