package com.tencent.biz.qqcircle.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.PoiInfo;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;
import ovw;

public class QCircleFakeFeed
  implements Parcelable
{
  public static final Parcelable.Creator<QCircleFakeFeed> CREATOR = new ovw();
  private String arF;
  private String clientKey;
  private String content;
  private String coverPath;
  private long createTime;
  private int duration;
  private String feedId;
  private int feedType;
  private LbsDataV2.PoiInfo g;
  private int height;
  private ArrayList<LabelInfo> labelInfos;
  private ArrayList<String> mo;
  private String puin;
  private String title;
  private String videoPath;
  private int width;
  
  public QCircleFakeFeed() {}
  
  public QCircleFakeFeed(Parcel paramParcel)
  {
    this.feedId = paramParcel.readString();
    this.clientKey = paramParcel.readString();
    this.feedType = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.mo = paramParcel.createStringArrayList();
    this.coverPath = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.createTime = paramParcel.readLong();
    this.puin = paramParcel.readString();
    this.arF = paramParcel.readString();
    this.videoPath = paramParcel.readString();
    this.labelInfos = ((ArrayList)paramParcel.readSerializable());
    this.g = ((LbsDataV2.PoiInfo)paramParcel.readParcelable(LbsDataV2.PoiInfo.class.getClassLoader()));
  }
  
  public ArrayList<String> bk()
  {
    return this.mo;
  }
  
  public ArrayList<LabelInfo> bl()
  {
    return this.labelInfos;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getClientKey()
  {
    return this.clientKey;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getFeedType()
  {
    return this.feedType;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public LbsDataV2.PoiInfo getPoiInfo()
  {
    return this.g;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getVideoPath()
  {
    return this.videoPath;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public String lU()
  {
    return this.coverPath;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.feedId);
    paramParcel.writeString(this.clientKey);
    paramParcel.writeInt(this.feedType);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeStringList(this.mo);
    paramParcel.writeString(this.coverPath);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.duration);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeString(this.puin);
    paramParcel.writeString(this.arF);
    paramParcel.writeString(this.videoPath);
    paramParcel.writeSerializable(this.labelInfos);
    paramParcel.writeParcelable(this.g, 0);
  }
  
  public static class a
  {
    private QCircleFakeFeed a = new QCircleFakeFeed();
    
    public a a(int paramInt)
    {
      QCircleFakeFeed.a(this.a, paramInt);
      return this;
    }
    
    public a a(long paramLong)
    {
      QCircleFakeFeed.a(this.a, paramLong);
      return this;
    }
    
    public a a(LbsDataV2.PoiInfo paramPoiInfo)
    {
      QCircleFakeFeed.a(this.a, paramPoiInfo);
      return this;
    }
    
    public a a(String paramString)
    {
      QCircleFakeFeed.a(this.a, paramString);
      return this;
    }
    
    public a a(ArrayList<String> paramArrayList)
    {
      QCircleFakeFeed.a(this.a, paramArrayList);
      return this;
    }
    
    public QCircleFakeFeed a()
    {
      return this.a;
    }
    
    public a b(int paramInt)
    {
      QCircleFakeFeed.b(this.a, paramInt);
      return this;
    }
    
    public a b(String paramString)
    {
      QCircleFakeFeed.b(this.a, paramString);
      return this;
    }
    
    public a b(ArrayList<LabelInfo> paramArrayList)
    {
      QCircleFakeFeed.b(this.a, paramArrayList);
      return this;
    }
    
    public a c(int paramInt)
    {
      QCircleFakeFeed.c(this.a, paramInt);
      return this;
    }
    
    public a c(String paramString)
    {
      QCircleFakeFeed.c(this.a, paramString);
      return this;
    }
    
    public a d(int paramInt)
    {
      QCircleFakeFeed.d(this.a, paramInt);
      return this;
    }
    
    public a d(String paramString)
    {
      QCircleFakeFeed.d(this.a, paramString);
      return this;
    }
    
    public a e(String paramString)
    {
      QCircleFakeFeed.e(this.a, paramString);
      return this;
    }
    
    public a f(String paramString)
    {
      QCircleFakeFeed.f(this.a, paramString);
      return this;
    }
    
    public a g(String paramString)
    {
      QCircleFakeFeed.g(this.a, paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleFakeFeed
 * JD-Core Version:    0.7.0.1
 */