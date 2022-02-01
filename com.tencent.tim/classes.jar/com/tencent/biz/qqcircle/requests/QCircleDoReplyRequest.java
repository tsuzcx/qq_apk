package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoReplyReq;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.ArrayList;
import java.util.List;
import ovd;
import pcr;

public class QCircleDoReplyRequest
  extends QCircleBaseRequest
{
  public static final int OPER_TYPE_ADD = 1;
  public static final int OPER_TYPE_DELETE = 0;
  public static final int OPER_TYPE_OWNER_DELETE = 2;
  FeedCloudWrite.StDoReplyReq req;
  
  public QCircleDoReplyRequest(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt)
  {
    if (paramStFeed == null)
    {
      QLog.w("VSBaseRequest", 1, "stfeed is null");
      return;
    }
    this.req = new FeedCloudWrite.StDoReplyReq();
    this.req.feed.set(ovd.a(paramStFeed));
    this.req.comment.set(paramStComment);
    this.req.reply.set(paramStReply);
    this.req.from.set(0);
    this.req.replyType.set(paramInt);
    if (paramInt == 1) {
      this.req.reply.id.set("");
    }
    paramStFeed = new FeedCloudCommon.Entry();
    paramStFeed.key.set("ext_source");
    if (((pcr.a().ez(61)) && (pcr.a().eA(57))) || (pcr.a().ez(57))) {
      paramStFeed.value.set("2");
    }
    for (;;)
    {
      paramStComment = new FeedCloudCommon.StCommonExt();
      paramStReply = new ArrayList();
      paramStReply.add(paramStFeed);
      paramStComment.mapInfo.set(paramStReply);
      this.req.extInfo.set(paramStComment);
      return;
      paramStFeed.value.set("1");
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudWrite.StDoReplyRsp localStDoReplyRsp = new FeedCloudWrite.StDoReplyRsp();
    localStDoReplyRsp.mergeFrom(paramArrayOfByte);
    return localStDoReplyRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReply";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest
 * JD-Core Version:    0.7.0.1
 */