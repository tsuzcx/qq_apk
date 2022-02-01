package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDelFeedReq;
import feedcloud.FeedCloudWrite.StDelFeedRsp;
import ovd;

public class QCircleDeleteFeedRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDelFeedReq req;
  
  public QCircleDeleteFeedRequest(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.req = new FeedCloudWrite.StDelFeedReq();
    this.req.from.set(0);
    this.req.feed.set(ovd.a(paramStFeed));
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudWrite.StDelFeedRsp localStDelFeedRsp = new FeedCloudWrite.StDelFeedRsp();
    localStDelFeedRsp.mergeFrom(paramArrayOfByte);
    return localStDelFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DelFeed";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest
 * JD-Core Version:    0.7.0.1
 */