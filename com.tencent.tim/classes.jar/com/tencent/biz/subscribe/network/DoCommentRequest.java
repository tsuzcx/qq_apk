package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class DoCommentRequest
  extends VSBaseRequest
{
  public static final int OPER_TYPE_ADD = 1;
  public static final int OPER_TYPE_DELETE = 0;
  CertifiedAccountWrite.StDoCommentReq req = new CertifiedAccountWrite.StDoCommentReq();
  
  public DoCommentRequest(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, int paramInt)
  {
    this.req.feed.set(paramStFeed);
    this.req.comment.set(paramStComment);
    this.req.commentType.set(paramInt);
    if (paramInt == 1) {
      this.req.comment.id.set("");
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    CertifiedAccountWrite.StDoCommentRsp localStDoCommentRsp = new CertifiedAccountWrite.StDoCommentRsp();
    localStDoCommentRsp.mergeFrom(paramArrayOfByte);
    return localStDoCommentRsp;
  }
  
  public String getCmdName()
  {
    return "CertifiedAccountSvc.certified_account_write.DoComment";
  }
  
  public byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.network.DoCommentRequest
 * JD-Core Version:    0.7.0.1
 */