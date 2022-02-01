package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

public class QCircleGetFeedDetailRequest
  extends QCircleBaseRequest
{
  public FeedCloudRead.StGetFeedDetailReq mRequest = new FeedCloudRead.StGetFeedDetailReq();
  
  public QCircleGetFeedDetailRequest(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this.mRequest.feedId.set(paramString1);
    this.mRequest.userId.set(paramString2);
    this.mRequest.createTime.set(paramLong);
    this.mRequest.useUGCStore.set(paramBoolean);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudRead.StGetFeedDetailRsp localStGetFeedDetailRsp = new FeedCloudRead.StGetFeedDetailRsp();
    localStGetFeedDetailRsp.mergeFrom(paramArrayOfByte);
    return localStGetFeedDetailRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest
 * JD-Core Version:    0.7.0.1
 */