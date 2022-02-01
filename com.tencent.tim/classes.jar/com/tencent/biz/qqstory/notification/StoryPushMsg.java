package com.tencent.biz.qqstory.notification;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import qed;

public class StoryPushMsg
  implements Parcelable
{
  public static final Parcelable.Creator<StoryPushMsg> CREATOR = new qed();
  public Bundle I = new Bundle();
  public String awY;
  public String awZ;
  public String axa;
  public int blO;
  public String mFeedId;
  public String mThumbUrl;
  public int mUnreadNum;
  public String mVid;
  public String subType;
  public int type;
  public long uin;
  public String unionId;
  
  public StoryPushMsg(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, int paramInt2, String paramString5, String paramString6, String paramString7)
  {
    this.type = paramInt1;
    this.subType = paramString1;
    this.awY = paramString2;
    this.uin = paramLong;
    this.unionId = paramString3;
    this.mUnreadNum = paramInt2;
    this.mFeedId = paramString4;
    this.mVid = paramString5;
    this.mThumbUrl = paramString6;
    this.axa = paramString7;
  }
  
  public StoryPushMsg(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    this(paramInt, paramString1, paramString2, paramLong, paramString3, paramString4, 1, null, paramString5, null);
  }
  
  public StoryPushMsg(int paramInt1, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, String paramString7, String paramString8)
  {
    this(paramInt1, paramString1, paramString2, paramLong, paramString3, paramString4, 1, null, paramString6, paramString7);
    this.blO = paramInt2;
    this.awZ = paramString5;
    this.mVid = paramString8;
  }
  
  public StoryPushMsg(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramInt, paramString1, paramString2, paramLong, paramString3, paramString4, 1, paramString5, paramString6, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getUid()
  {
    return this.unionId;
  }
  
  public String toString()
  {
    return "StoryPushMsg{mCommentId=" + this.blO + ", type=" + this.type + ", subType='" + this.subType + '\'' + ", msgInfo='" + this.awY + '\'' + ", uin=" + this.uin + ", unionId='" + this.unionId + '\'' + ", feedId='" + this.mFeedId + '\'' + ", mUnreadNum=" + this.mUnreadNum + ", mVid='" + this.mVid + '\'' + ", mThumbUrl='" + this.mThumbUrl + '\'' + ", mFeedLikeUserUnionId='" + this.awZ + '\'' + ", reserveBundle=" + this.I + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.type);
    paramParcel.writeString(this.subType);
    paramParcel.writeString(this.awY);
    paramParcel.writeLong(this.uin);
    paramParcel.writeString(this.axa);
    paramParcel.writeString(this.unionId);
    paramParcel.writeInt(this.mUnreadNum);
    paramParcel.writeString(this.mFeedId);
    paramParcel.writeString(this.mVid);
    paramParcel.writeString(this.mThumbUrl);
    paramParcel.writeBundle(this.I);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryPushMsg
 * JD-Core Version:    0.7.0.1
 */