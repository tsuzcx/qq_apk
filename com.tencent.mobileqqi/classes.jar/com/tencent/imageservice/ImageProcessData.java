package com.tencent.imageservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ImageProcessData
  implements Parcelable
{
  public static final Parcelable.Creator<ImageProcessData> CREATOR = new Parcelable.Creator()
  {
    public ImageProcessData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ImageProcessData(paramAnonymousParcel, null);
    }
    
    public ImageProcessData[] newArray(int paramAnonymousInt)
    {
      return new ImageProcessData[paramAnonymousInt];
    }
  };
  public boolean autoRotate;
  public boolean compressToWebp;
  public int id;
  public String msg;
  public String originalFilePath;
  public String targetFilePath;
  public int targetHeight;
  public int targetQuality;
  public int targetWidth;
  
  public ImageProcessData(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    this.id = paramInt1;
    this.originalFilePath = paramString1;
    this.targetFilePath = paramString2;
    this.targetWidth = paramInt2;
    this.targetHeight = paramInt3;
    this.targetQuality = paramInt4;
    this.autoRotate = paramBoolean1;
    this.compressToWebp = paramBoolean2;
    this.msg = paramString3;
  }
  
  private ImageProcessData(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.originalFilePath = paramParcel.readString();
    this.targetFilePath = paramParcel.readString();
    this.targetWidth = paramParcel.readInt();
    this.targetHeight = paramParcel.readInt();
    this.targetQuality = paramParcel.readInt();
    if (paramParcel.readByte() == 1)
    {
      bool1 = true;
      this.autoRotate = bool1;
      if (paramParcel.readByte() != 1) {
        break label98;
      }
    }
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.compressToWebp = bool1;
      this.msg = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.originalFilePath);
    paramParcel.writeString(this.targetFilePath);
    paramParcel.writeInt(this.targetWidth);
    paramParcel.writeInt(this.targetHeight);
    paramParcel.writeInt(this.targetQuality);
    if (this.autoRotate)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.compressToWebp) {
        break label94;
      }
    }
    label94:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.msg);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.imageservice.ImageProcessData
 * JD-Core Version:    0.7.0.1
 */