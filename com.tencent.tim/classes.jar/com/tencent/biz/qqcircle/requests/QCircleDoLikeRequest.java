package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoLikeReq;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oum;
import ovd;
import pcr;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;

public class QCircleDoLikeRequest
  extends QCircleBaseRequest
{
  private FeedCloudWrite.StDoLikeReq mReq;
  
  public QCircleDoLikeRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt, FeedCloudMeta.StLike paramStLike, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mReq = new FeedCloudWrite.StDoLikeReq();
    this.mReq.feed.set(ovd.a(paramStFeed));
    this.mReq.likeType.set(paramInt);
    if (paramStLike != null)
    {
      paramStLike.vecUser.set(Arrays.asList(new FeedCloudMeta.StUser[] { oum.a() }));
      paramStLike.postUser.set(oum.a());
      this.mReq.like.set(paramStLike);
    }
    if (paramStComment != null) {
      this.mReq.comment.set(paramStComment);
    }
    if (paramStReply != null) {
      this.mReq.reply.set(paramStReply);
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (((pcr.a().ez(61)) && (pcr.a().eA(57))) || (pcr.a().ez(57))) {
      paramStFeed.value.set("2");
    }
    for (;;)
    {
      paramStLike = new FeedCloudCommon.StCommonExt();
      paramStComment = new ArrayList();
      paramStComment.add(paramStFeed);
      paramStLike.mapInfo.set(paramStComment);
      this.mReq.extInfo.set(paramStLike);
      return;
      paramStFeed.value.set("1");
    }
  }
  
  public QCircleDoLikeRequest(FeedCloudMeta.StFeed paramStFeed, int paramInt, FeedCloudMeta.StLike paramStLike, QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData paramStDoLikeReqDoPolyLikeBusiReqData)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.mReq = new FeedCloudWrite.StDoLikeReq();
    this.mReq.feed.set(ovd.a(paramStFeed));
    this.mReq.likeType.set(paramInt);
    if (paramStLike != null)
    {
      paramStLike.vecUser.set(Arrays.asList(new FeedCloudMeta.StUser[] { oum.a() }));
      paramStLike.postUser.set(oum.a());
      this.mReq.like.set(paramStLike);
    }
    if (paramStDoLikeReqDoPolyLikeBusiReqData != null) {
      this.mReq.busiReqData.set(ByteStringMicro.copyFrom(paramStDoLikeReqDoPolyLikeBusiReqData.toByteArray()));
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (((pcr.a().ez(61)) && (pcr.a().eA(57))) || (pcr.a().ez(57))) {
      paramStFeed.value.set("2");
    }
    for (;;)
    {
      paramStLike = new FeedCloudCommon.StCommonExt();
      paramStDoLikeReqDoPolyLikeBusiReqData = new ArrayList();
      paramStDoLikeReqDoPolyLikeBusiReqData.add(paramStFeed);
      paramStLike.mapInfo.set(paramStDoLikeReqDoPolyLikeBusiReqData);
      this.mReq.extInfo.set(paramStLike);
      return;
      paramStFeed.value.set("1");
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudWrite.StDoLikeRsp localStDoLikeRsp = new FeedCloudWrite.StDoLikeRsp();
    localStDoLikeRsp.mergeFrom(paramArrayOfByte);
    return localStDoLikeRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoLike";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest
 * JD-Core Version:    0.7.0.1
 */