package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetNoticeListReq;
import feedcloud.FeedCloudRead.StGetNoticeListRsp;

public class QCircleMessageNoticeRequest
  extends QCircleBaseRequest
{
  public static final String ENTRY_KEY_IS_PRELOAD = "isPreGetNoticeList";
  public static final String ENTRY_VALUE_IS_PRELOAD = "1";
  private int mListNum = 20;
  public FeedCloudRead.StGetNoticeListReq mRequest = new FeedCloudRead.StGetNoticeListReq();
  
  public QCircleMessageNoticeRequest(String paramString, boolean paramBoolean)
  {
    this.mRequest.pageType.set(1);
    this.mRequest.listNum.set(this.mListNum);
    if (paramBoolean)
    {
      FeedCloudCommon.StCommonExt localStCommonExt = new FeedCloudCommon.StCommonExt();
      FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
      localEntry.key.set("isPreGetNoticeList");
      localEntry.value.set("1");
      localStCommonExt.mapInfo.add(localEntry);
      this.mRequest.extInfo.set(localStCommonExt);
    }
    if (paramString != null) {
      this.mRequest.feedAttchInfo.set(paramString);
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudRead.StGetNoticeListRsp localStGetNoticeListRsp = new FeedCloudRead.StGetNoticeListRsp();
    localStGetNoticeListRsp.mergeFrom(paramArrayOfByte);
    return localStGetNoticeListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNoticeList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleMessageNoticeRequest
 * JD-Core Version:    0.7.0.1
 */