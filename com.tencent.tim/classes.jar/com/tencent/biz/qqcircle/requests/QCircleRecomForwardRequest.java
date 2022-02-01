package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudWrite.StRecomForwardFeedReq;
import feedcloud.FeedCloudWrite.StRecomForwardFeedRsp;
import ovd;

public class QCircleRecomForwardRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StRecomForwardFeedReq mReq;
  
  public QCircleRecomForwardRequest(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if (paramStFeed == null) {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
    }
    do
    {
      return;
      this.mReq = new FeedCloudWrite.StRecomForwardFeedReq();
      this.mReq.feed.set(ovd.a(paramStFeed));
      this.mReq.feed.recomForward.set(paramStFeed.recomForward.get());
      this.mReq.from.set(0);
    } while (paramStComment == null);
    this.mReq.comment.set(paramStComment);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudWrite.StRecomForwardFeedRsp localStRecomForwardFeedRsp = new FeedCloudWrite.StRecomForwardFeedRsp();
    localStRecomForwardFeedRsp.mergeFrom(paramArrayOfByte);
    return localStRecomForwardFeedRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.RecomForwardFeed";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleRecomForwardRequest
 * JD-Core Version:    0.7.0.1
 */