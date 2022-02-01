package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mig;

public class TopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TopicInfo> CREATOR = new mig();
  private String aiC;
  private String aiD;
  private String aiE;
  private String aiF;
  private String aiG;
  private boolean amP;
  private long topicId;
  private long vU;
  
  public TopicInfo(Parcel paramParcel)
  {
    this.topicId = paramParcel.readLong();
    this.aiC = paramParcel.readString();
    this.aiD = paramParcel.readString();
    this.aiE = paramParcel.readString();
    this.aiF = paramParcel.readString();
    this.vU = paramParcel.readLong();
    this.aiG = paramParcel.readString();
  }
  
  private TopicInfo(a parama)
  {
    this.topicId = a.a(parama);
    this.aiC = a.a(parama);
    this.aiD = a.b(parama);
    this.aiE = a.c(parama);
    this.aiF = a.d(parama);
    this.vU = a.b(parama);
    this.amP = a.a(parama);
  }
  
  public static a a()
  {
    return new a(null);
  }
  
  public boolean DF()
  {
    return this.amP;
  }
  
  public long cO()
  {
    return this.topicId;
  }
  
  public long cP()
  {
    return this.vU;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String jS()
  {
    return this.aiC;
  }
  
  public String jT()
  {
    return this.aiD;
  }
  
  public String jU()
  {
    return this.aiE;
  }
  
  public String jV()
  {
    return this.aiF;
  }
  
  public String toString()
  {
    return "TopicInfo{topicId=" + this.topicId + ", topicTitle='" + this.aiC + '\'' + ", topicSummary='" + this.aiD + '\'' + ", topicCoverUrl='" + this.aiE + '\'' + ", topicJumpUrl='" + this.aiF + '\'' + ", topicUin='" + this.vU + '\'' + ", topicBannerUrl='" + this.aiG + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.topicId);
    paramParcel.writeString(this.aiC);
    paramParcel.writeString(this.aiD);
    paramParcel.writeString(this.aiE);
    paramParcel.writeString(this.aiF);
    paramParcel.writeString(this.aiF);
    paramParcel.writeLong(this.vU);
    paramParcel.writeString(this.aiG);
  }
  
  public static final class a
  {
    private String aiC;
    private String aiD;
    private String aiE;
    private String aiF;
    private boolean amP;
    private long topicId;
    private long vU;
    
    public a a(long paramLong)
    {
      this.topicId = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.aiC = paramString;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.amP = paramBoolean;
      return this;
    }
    
    public TopicInfo a()
    {
      return new TopicInfo(this, null);
    }
    
    public a b(long paramLong)
    {
      this.vU = paramLong;
      return this;
    }
    
    public a b(String paramString)
    {
      this.aiD = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.aiE = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.aiF = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo
 * JD-Core Version:    0.7.0.1
 */