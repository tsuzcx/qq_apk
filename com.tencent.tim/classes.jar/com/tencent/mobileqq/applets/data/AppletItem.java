package com.tencent.mobileqq.applets.data;

import adan;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppletItem
  implements Parcelable
{
  public static final Parcelable.Creator<AppletItem> CREATOR = new adan();
  private String icon;
  private long id;
  private String name;
  private String pUin;
  private int type;
  private int value;
  
  private AppletItem(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.id = paramLong;
    this.name = paramString1;
    this.icon = paramString2;
    this.type = paramInt1;
    this.value = paramInt2;
    this.pUin = paramString3;
  }
  
  public AppletItem(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.name = paramParcel.readString();
    this.icon = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.value = paramParcel.readInt();
    this.pUin = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public String sb()
  {
    return this.pUin;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppletItem:[").append("id = ").append(this.id).append(", name = ").append(this.name).append(" icon = ").append(this.icon).append(", type = ").append(this.type).append("(1:开, 0:关) ").append(", value = ").append(this.value).append("] ");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.icon);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.value);
    paramParcel.writeString(this.pUin);
  }
  
  public static class a
  {
    private String icon;
    private long id;
    private String name;
    private String pUin;
    private int type;
    private int value;
    
    public void Gm(String paramString)
    {
      this.pUin = paramString;
    }
    
    public a a(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.id = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.name = paramString;
      return this;
    }
    
    public AppletItem a()
    {
      return new AppletItem(this.id, this.name, this.icon, this.type, this.value, this.pUin, null);
    }
    
    public a b(int paramInt)
    {
      this.value = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.icon = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.data.AppletItem
 * JD-Core Version:    0.7.0.1
 */