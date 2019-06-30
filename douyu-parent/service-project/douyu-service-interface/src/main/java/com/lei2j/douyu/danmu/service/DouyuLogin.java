package com.lei2j.douyu.danmu.service;

import com.lei2j.douyu.vo.RoomDetailVo;

import java.io.IOException;

/**
 * @author lei2j
 * Created by lei2j on 2018/8/28.
 */
public interface  DouyuLogin {

    /**
     * 登录
     * @throws IOException IOException
     * @return -1 is connect failed,1 is connect success
     */
    int login()throws IOException;

    /**
     * 退出房间
     */
    void logout();

    /**
     * 获取房间号
     */
    Integer getRoom();

    /**
     * 重连
     */
    void retry();

    RoomDetailVo getRoomDetail();
    
}
