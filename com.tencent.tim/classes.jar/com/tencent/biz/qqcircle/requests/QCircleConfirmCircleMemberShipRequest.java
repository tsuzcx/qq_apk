package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudCommon.StCommonExt;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleRead.ConfidentCircleMemberReq;
import qqcircle.QQCircleRead.ConfidentCircleMemberRsp;

public class QCircleConfirmCircleMemberShipRequest
  extends QCircleBaseRequest
{
  private QQCircleRead.ConfidentCircleMemberReq mReq = new QQCircleRead.ConfidentCircleMemberReq();
  
  public QCircleConfirmCircleMemberShipRequest(FeedCloudCommon.StCommonExt paramStCommonExt, QQCircleBase.UserCircleInfo paramUserCircleInfo)
  {
    if (paramStCommonExt != null) {
      this.mReq.extInfo.set(paramStCommonExt);
    }
    if (paramUserCircleInfo != null) {
      this.mReq.circleInfo.set(paramUserCircleInfo);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    QQCircleRead.ConfidentCircleMemberRsp localConfidentCircleMemberRsp = new QQCircleRead.ConfidentCircleMemberRsp();
    localConfidentCircleMemberRsp.mergeFrom(paramArrayOfByte);
    return localConfidentCircleMemberRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleread.CircleRead.ConfidentCircleMember";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleConfirmCircleMemberShipRequest
 * JD-Core Version:    0.7.0.1
 */