package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;
import ovd;

public class QCircleDoRecommendRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDoPushReq mReq;
  
  public QCircleDoRecommendRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt, FeedCloudMeta.StPushList paramStPushList)
  {
    if (paramStFeed == null) {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
    }
    do
    {
      return;
      this.mReq = new FeedCloudWrite.StDoPushReq();
      this.mReq.feed.set(ovd.a(paramStFeed));
      this.mReq.comboCount.set(paramInt);
    } while (paramStPushList == null);
    this.mReq.push.set(paramStPushList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudWrite.StDoPushRsp localStDoPushRsp = new FeedCloudWrite.StDoPushRsp();
    localStDoPushRsp.mergeFrom(paramArrayOfByte);
    return localStDoPushRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoPush";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest
 * JD-Core Version:    0.7.0.1
 */