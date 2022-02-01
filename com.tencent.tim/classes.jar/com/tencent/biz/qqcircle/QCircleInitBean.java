package com.tencent.biz.qqcircle;

import android.text.TextUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.io.Serializable;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class QCircleInitBean
  implements Serializable
{
  public boolean isSingleFeed;
  public QCircleActionBean mActionBean;
  private byte[] mBusiInfoDataByteArray;
  public int mDataPosInList;
  private ExtraTypeInfo mExtraTypeInfo;
  private byte[] mFeedByteArray;
  private byte[] mFeedListBusiReqByteArray;
  private byte[] mTagInfoByteArray;
  private byte[] mUserByteArray;
  public long mVideoCurrentPosition;
  
  private QCircleInitBean(a parama)
  {
    if (a.a(parama) != null) {
      this.mFeedByteArray = a.a(parama).toByteArray();
    }
    if (a.a(parama) != null) {
      this.mUserByteArray = a.a(parama).toByteArray();
    }
    if (a.a(parama) != null) {
      this.mTagInfoByteArray = a.a(parama).toByteArray();
    }
    if (a.a(parama) != null) {
      this.mFeedListBusiReqByteArray = a.a(parama).toByteArray();
    }
    this.mBusiInfoDataByteArray = a.a(parama);
    if (a.a(parama) == null) {}
    for (ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();; localExtraTypeInfo = a.a(parama))
    {
      this.mExtraTypeInfo = localExtraTypeInfo;
      this.mDataPosInList = a.a(parama);
      this.mActionBean = a.a(parama);
      return;
    }
  }
  
  public byte[] getBusiInfoData()
  {
    return this.mBusiInfoDataByteArray;
  }
  
  public int getDataPosInList()
  {
    return this.mDataPosInList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public FeedCloudMeta.StFeed getFeed()
  {
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    try
    {
      localStFeed.mergeFrom(this.mFeedByteArray);
      return localStFeed;
    }
    catch (Exception localException) {}
    return localStFeed;
  }
  
  public QQCircleFeedBase.StFeedListBusiReqData getFeedListBusiReq()
  {
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    if (this.mFeedListBusiReqByteArray != null) {}
    try
    {
      localStFeedListBusiReqData.mergeFrom(this.mFeedListBusiReqByteArray);
      return localStFeedListBusiReqData;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    return localStFeedListBusiReqData;
  }
  
  public FeedCloudMeta.StTagInfo getTagInfo()
  {
    FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
    try
    {
      localStTagInfo.mergeFrom(this.mTagInfoByteArray);
      return localStTagInfo;
    }
    catch (Exception localException) {}
    return localStTagInfo;
  }
  
  public FeedCloudMeta.StUser getUser()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    try
    {
      localStUser.mergeFrom(this.mUserByteArray);
      return localStUser;
    }
    catch (Exception localException) {}
    return localStUser;
  }
  
  public static class QCircleActionBean
    implements Serializable
  {
    public boolean mShowInputKeyboard;
  }
  
  public static class a
  {
    private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
    private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
    private QQCircleFeedBase.StFeedListBusiReqData jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiReqData;
    private byte[] bw;
    private QCircleInitBean.QCircleActionBean mActionBean;
    private int mDataPosInList;
    private ExtraTypeInfo mExtraTypeInfo;
    private FeedCloudMeta.StFeed mFeed;
    
    public a a(int paramInt)
    {
      if (this.mExtraTypeInfo == null) {
        this.mExtraTypeInfo = new ExtraTypeInfo();
      }
      this.mExtraTypeInfo.sourceType = paramInt;
      return this;
    }
    
    public a a(ExtraTypeInfo paramExtraTypeInfo)
    {
      this.mExtraTypeInfo = paramExtraTypeInfo;
      return this;
    }
    
    public a a(FeedCloudMeta.StFeed paramStFeed)
    {
      this.mFeed = new FeedCloudMeta.StFeed();
      this.mFeed.set(paramStFeed);
      return this;
    }
    
    public a a(FeedCloudMeta.StUser paramStUser)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.set(paramStUser);
      return this;
    }
    
    public a a(String paramString)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = new FeedCloudMeta.StUser();
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.set(paramString);
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = new FeedCloudMeta.StTagInfo();
      if (!TextUtils.isEmpty(paramString1)) {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.set(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.set(paramString2);
      }
      return this;
    }
    
    public a a(QQCircleFeedBase.StFeedListBusiReqData paramStFeedListBusiReqData)
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiReqData.set(paramStFeedListBusiReqData);
      return this;
    }
    
    public a a(byte[] paramArrayOfByte)
    {
      this.bw = paramArrayOfByte;
      return this;
    }
    
    public QCircleInitBean a()
    {
      return new QCircleInitBean(this, null);
    }
    
    public a b(int paramInt)
    {
      this.mDataPosInList = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleInitBean
 * JD-Core Version:    0.7.0.1
 */