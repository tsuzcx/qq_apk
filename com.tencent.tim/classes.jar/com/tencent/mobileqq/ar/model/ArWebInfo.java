package com.tencent.mobileqq.ar.model;

import adks;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ArWebInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ArWebInfo> CREATOR = new adks();
  public boolean bNZ;
  public boolean bOa;
  public String but;
  public String buu;
  
  public ArWebInfo() {}
  
  public ArWebInfo(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.bNZ = bool1;
      if (paramParcel.readByte() == 0) {
        break label56;
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bOa = bool1;
      this.but = paramParcel.readString();
      this.buu = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean ael()
  {
    return this.bOa;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ArWebInfo{");
    localStringBuffer.append("isUrlAutoJump='").append(this.bNZ).append('\'');
    localStringBuffer.append(", isUrlTransparent=").append(this.bOa).append('\'');
    localStringBuffer.append(", webJumpUrl=").append(this.but).append('\'');
    localStringBuffer.append(", htmlOfflineBid=").append(this.buu).append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    if (this.bNZ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.bOa) {
        break label54;
      }
    }
    label54:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.but);
      paramParcel.writeString(this.buu);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.ArWebInfo
 * JD-Core Version:    0.7.0.1
 */