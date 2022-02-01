package com.tencent.biz.richframework.part.demo;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.TaskCenterReader.TaskListReq;
import qqcircle.TaskCenterReader.TaskListRsp;

public class DemoBaseRequest
  extends VSBaseRequest
{
  TaskCenterReader.TaskListReq mRequest = new TaskCenterReader.TaskListReq();
  
  public DemoBaseRequest(String paramString)
  {
    this.mRequest.userId.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    TaskCenterReader.TaskListRsp localTaskListRsp = new TaskCenterReader.TaskListRsp();
    localTaskListRsp.mergeFrom(paramArrayOfByte);
    return localTaskListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circletaskcenter.TaskCenterReader.GetTaskList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.demo.DemoBaseRequest
 * JD-Core Version:    0.7.0.1
 */