package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import qqcircle.QQCircleWrite.DoFollowTagReq;
import qqcircle.QQCircleWrite.DoFollowTagRsp;

public class QCircleDoFollowTagRequest
  extends QCircleBaseRequest
{
  private QQCircleWrite.DoFollowTagReq mRequest = new QQCircleWrite.DoFollowTagReq();
  
  public QCircleDoFollowTagRequest(String paramString, int paramInt, FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    this.mRequest.followType.set(paramInt);
    this.mRequest.tagNameList.add(paramString);
    if (paramStCommonExt != null) {
      this.mRequest.extInfo.set(paramStCommonExt);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    QQCircleWrite.DoFollowTagRsp localDoFollowTagRsp = new QQCircleWrite.DoFollowTagRsp();
    localDoFollowTagRsp.mergeFrom(paramArrayOfByte);
    return localDoFollowTagRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlewrite.CircleWriter.DoFollowTag";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleDoFollowTagRequest
 * JD-Core Version:    0.7.0.1
 */