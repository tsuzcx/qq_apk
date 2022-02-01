package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mif;

public class TagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TagInfo> CREATOR = new mif();
  private final double aZ;
  private final long channel;
  private final long tagId;
  private final String tagName;
  
  public TagInfo(long paramLong1, String paramString, double paramDouble, long paramLong2)
  {
    this.tagId = paramLong1;
    this.tagName = paramString;
    this.aZ = paramDouble;
    this.channel = paramLong2;
  }
  
  public TagInfo(Parcel paramParcel)
  {
    this.tagId = paramParcel.readLong();
    this.tagName = paramParcel.readString();
    this.aZ = paramParcel.readDouble();
    this.channel = paramParcel.readLong();
  }
  
  public long cM()
  {
    return this.tagId;
  }
  
  public long cN()
  {
    return this.channel;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (getClass() != paramObject.getClass());
          paramObject = (TagInfo)paramObject;
          bool1 = bool2;
        } while (this.tagId != paramObject.tagId);
        bool1 = bool2;
      } while (Double.compare(paramObject.aZ, this.aZ) != 0);
      bool1 = bool2;
    } while (this.channel != paramObject.channel);
    return this.tagName.equals(paramObject.tagName);
  }
  
  public String getTagName()
  {
    return this.tagName;
  }
  
  public int hashCode()
  {
    int i = (int)(this.tagId ^ this.tagId >>> 32);
    int j = this.tagName.hashCode();
    long l = Double.doubleToLongBits(this.aZ);
    return ((i * 31 + j) * 31 + (int)(l ^ l >>> 32)) * 31 + (int)(this.channel ^ this.channel >>> 32);
  }
  
  public double s()
  {
    return this.aZ;
  }
  
  public String toString()
  {
    return this.tagName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.tagId);
    paramParcel.writeString(this.tagName);
    paramParcel.writeDouble(this.aZ);
    paramParcel.writeLong(this.channel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.TagInfo
 * JD-Core Version:    0.7.0.1
 */