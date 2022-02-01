package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoTopReq;
import feedcloud.FeedCloudWrite.StDoTopRsp;
import ovd;

public class QCircleDoStickyRequest
  extends QCircleBaseRequest
{
  public static final int OPER_TYPE_DO_CANCLE_TOP = 2;
  public static final int OPER_TYPE_DO_TOP = 1;
  private FeedCloudWrite.StDoTopReq mReq;
  
  public QCircleDoStickyRequest(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt)
  {
    if (paramStFeed == null) {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
    }
    do
    {
      return;
      this.mReq = new FeedCloudWrite.StDoTopReq();
      this.mReq.feed.set(ovd.a(paramStFeed));
      this.mReq.comment.set(ovd.a(paramStComment));
      this.mReq.topType.set(paramInt);
    } while (paramStComment == null);
    this.mReq.comment.set(paramStComment);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudWrite.StDoTopRsp localStDoTopRsp = new FeedCloudWrite.StDoTopRsp();
    localStDoTopRsp.mergeFrom(paramArrayOfByte);
    return localStDoTopRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoTop";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoStickyRequest
 * JD-Core Version:    0.7.0.1
 */