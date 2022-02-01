package cooperation.qzone.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import avtx;

public class CertifiedFakeFeed
  implements Parcelable
{
  public static final Parcelable.Creator<CertifiedFakeFeed> CREATOR = new avtx();
  private String clientKey;
  private String content;
  private String coverPath;
  private long createTime;
  private int duration;
  private String feedId;
  private int feedType;
  private int height;
  private String puin;
  private String title;
  private int width;
  
  private CertifiedFakeFeed() {}
  
  public CertifiedFakeFeed(Parcel paramParcel)
  {
    this.feedId = paramParcel.readString();
    this.clientKey = paramParcel.readString();
    this.feedType = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.coverPath = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.createTime = paramParcel.readLong();
    this.puin = paramParcel.readString();
  }
  
  public String Gy()
  {
    return this.puin;
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
  
  public String getTitle()
  {
    return this.title;
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
    paramParcel.writeString(this.coverPath);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.duration);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeString(this.puin);
  }
  
  public static class a
  {
    private CertifiedFakeFeed a = new CertifiedFakeFeed(null);
    
    public a a(int paramInt)
    {
      CertifiedFakeFeed.a(this.a, paramInt);
      return this;
    }
    
    public a a(long paramLong)
    {
      CertifiedFakeFeed.a(this.a, paramLong);
      return this;
    }
    
    public a a(String paramString)
    {
      CertifiedFakeFeed.a(this.a, paramString);
      return this;
    }
    
    public CertifiedFakeFeed a()
    {
      return this.a;
    }
    
    public a b(int paramInt)
    {
      CertifiedFakeFeed.b(this.a, paramInt);
      return this;
    }
    
    public a b(String paramString)
    {
      CertifiedFakeFeed.b(this.a, paramString);
      return this;
    }
    
    public a c(int paramInt)
    {
      CertifiedFakeFeed.c(this.a, paramInt);
      return this;
    }
    
    public a c(String paramString)
    {
      CertifiedFakeFeed.c(this.a, paramString);
      return this;
    }
    
    public a d(int paramInt)
    {
      CertifiedFakeFeed.d(this.a, paramInt);
      return this;
    }
    
    public a d(String paramString)
    {
      CertifiedFakeFeed.d(this.a, paramString);
      return this;
    }
    
    public a e(String paramString)
    {
      CertifiedFakeFeed.e(this.a, paramString);
      return this;
    }
    
    public a f(String paramString)
    {
      CertifiedFakeFeed.f(this.a, paramString);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.feed.CertifiedFakeFeed
 * JD-Core Version:    0.7.0.1
 */