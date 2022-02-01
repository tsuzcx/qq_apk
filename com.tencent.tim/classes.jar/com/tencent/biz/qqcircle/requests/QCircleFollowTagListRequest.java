package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudRead.StGetFollowTagListReq;
import feedcloud.FeedCloudRead.StGetFollowTagListRsp;

public class QCircleFollowTagListRequest
  extends QCircleBaseRequest
{
  private int mListNum = 20;
  public final FeedCloudRead.StGetFollowTagListReq mRequest = new FeedCloudRead.StGetFollowTagListReq();
  
  public QCircleFollowTagListRequest(String paramString1, String paramString2)
  {
    if (paramString1 != null) {
      this.mRequest.attachInfo.set(paramString1);
    }
    this.mRequest.count.set(this.mListNum);
    this.mRequest.userId.set(paramString2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    FeedCloudRead.StGetFollowTagListRsp localStGetFollowTagListRsp = new FeedCloudRead.StGetFollowTagListRsp();
    localStGetFollowTagListRsp.mergeFrom(paramArrayOfByte);
    return localStGetFollowTagListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFollowTagList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleFollowTagListRequest
 * JD-Core Version:    0.7.0.1
 */