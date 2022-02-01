package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import nac;
import nad;

public class DiscoveryInfo
  implements Parcelable
{
  public static final Parcelable.Creator<DiscoveryInfo> CREATOR = new nac();
  public String WT;
  public int aWR;
  public int aWS;
  public String akZ;
  public boolean aqV;
  public String coverUrl;
  public int[] dt = new int[2];
  public String jumpUrl;
  public ArrayList<TopicVideoCard> lA;
  public String subtitle;
  public String title;
  public long topicId;
  
  public DiscoveryInfo() {}
  
  public DiscoveryInfo(Parcel paramParcel)
  {
    this.topicId = paramParcel.readLong();
    this.title = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.subtitle = paramParcel.readString();
    this.akZ = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.aqV = bool;
      this.aWR = paramParcel.readInt();
      this.aWS = paramParcel.readInt();
      this.lA = paramParcel.createTypedArrayList(TopicVideoCard.CREATOR);
      this.WT = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "DiscoveryInfo{topicId=" + this.topicId + ", title='" + this.title + '\'' + ", coverUrl='" + this.coverUrl + '\'' + ", subtitle='" + this.subtitle + '\'' + ", playCounts=" + this.akZ + ", jumpUrl='" + this.jumpUrl + '\'' + ", hasRecomment=" + this.aqV + ", effectiveTime=" + this.aWR + ", expiationTime=" + this.aWS + ", commonData=" + this.WT + ", topicVideoCards=" + this.lA + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.topicId);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.subtitle);
    paramParcel.writeString(this.akZ);
    paramParcel.writeString(this.jumpUrl);
    if (this.aqV) {}
    for (paramInt = 1;; paramInt = 2)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.aWR);
      paramParcel.writeInt(this.aWS);
      paramParcel.writeTypedList(this.lA);
      paramParcel.writeString(this.WT);
      return;
    }
  }
  
  public static class TopicVideoCard
    implements Parcelable
  {
    public static final Parcelable.Creator<TopicVideoCard> CREATOR = new nad();
    public String WC;
    public String WT;
    public String accountName;
    public String ahq;
    public String ahr;
    public String ala;
    public String articleContentUrl;
    public String articleTitle;
    public int busiType;
    public String coverUrl;
    public int duration;
    public long feedsId;
    public int feedsType;
    public String hH;
    public int height;
    public boolean isUgc;
    public long rX;
    public String rowKey;
    public long ry;
    public String thirdAction;
    public String thirdUinName;
    public long time;
    public long topicId;
    public String vid;
    public String videoUrl;
    public int width;
    
    public TopicVideoCard() {}
    
    public TopicVideoCard(Parcel paramParcel)
    {
      this.ala = paramParcel.readString();
      this.coverUrl = paramParcel.readString();
      this.rX = paramParcel.readLong();
      this.topicId = paramParcel.readLong();
      this.vid = paramParcel.readString();
      this.rowKey = paramParcel.readString();
      this.accountName = paramParcel.readString();
      this.hH = paramParcel.readString();
      this.thirdAction = paramParcel.readString();
      this.WC = paramParcel.readString();
      this.thirdUinName = paramParcel.readString();
      this.articleTitle = paramParcel.readString();
      this.ahq = paramParcel.readString();
      this.ahr = paramParcel.readString();
      this.articleContentUrl = paramParcel.readString();
      this.videoUrl = paramParcel.readString();
      this.WT = paramParcel.readString();
      this.width = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.duration = paramParcel.readInt();
      this.busiType = paramParcel.readInt();
      this.feedsType = paramParcel.readInt();
      this.feedsId = paramParcel.readLong();
      this.ry = paramParcel.readLong();
      this.time = paramParcel.readLong();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.isUgc = bool;
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "TopicVideoCard{cornerIconUrl='" + this.ala + '\'' + ", coverUrl='" + this.coverUrl + '\'' + ", articleId=" + this.rX + ", topicId=" + this.topicId + ", vid='" + this.vid + '\'' + ", rowKey='" + this.rowKey + '\'' + ", accountName='" + this.accountName + '\'' + ", accountUin='" + this.hH + '\'' + ", thirdAction='" + this.thirdAction + '\'' + ", thirdIconUrl='" + this.WC + '\'' + ", thirdUinName='" + this.thirdUinName + '\'' + ", articleTitle='" + this.articleTitle + '\'' + ", articleSummary='" + this.ahq + '\'' + ", firstPagePicUrl='" + this.ahr + '\'' + ", articleContentUrl='" + this.articleContentUrl + '\'' + ", videoUrl='" + this.videoUrl + '\'' + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", busiType=" + this.busiType + ", feedsType=" + this.feedsType + ", feedsId=" + this.feedsId + ", XGFileSize=" + this.ry + ", time=" + this.time + ", isUgc=" + this.isUgc + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.ala);
      paramParcel.writeString(this.coverUrl);
      paramParcel.writeLong(this.rX);
      paramParcel.writeLong(this.topicId);
      paramParcel.writeString(this.vid);
      paramParcel.writeString(this.rowKey);
      paramParcel.writeString(this.accountName);
      paramParcel.writeString(this.hH);
      paramParcel.writeString(this.thirdAction);
      paramParcel.writeString(this.WC);
      paramParcel.writeString(this.thirdUinName);
      paramParcel.writeString(this.articleTitle);
      paramParcel.writeString(this.ahq);
      paramParcel.writeString(this.ahr);
      paramParcel.writeString(this.articleContentUrl);
      paramParcel.writeString(this.videoUrl);
      paramParcel.writeString(this.WT);
      paramParcel.writeInt(this.width);
      paramParcel.writeInt(this.height);
      paramParcel.writeInt(this.duration);
      paramParcel.writeInt(this.busiType);
      paramParcel.writeInt(this.feedsType);
      paramParcel.writeLong(this.feedsId);
      paramParcel.writeLong(this.ry);
      paramParcel.writeLong(this.time);
      if (this.isUgc) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.DiscoveryInfo
 * JD-Core Version:    0.7.0.1
 */