package com.tencent.shadow.core.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.shadow.proguard.a;

public class InstalledApk
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  public final String apkFilePath;
  public final String libraryPath;
  public final String oDexPath;
  public final byte[] parcelExtras;
  
  public InstalledApk(Parcel paramParcel)
  {
    this.apkFilePath = paramParcel.readString();
    this.oDexPath = paramParcel.readString();
    this.libraryPath = paramParcel.readString();
    int i = paramParcel.readInt();
    if (i > 0) {}
    for (this.parcelExtras = new byte[i];; this.parcelExtras = null)
    {
      if (this.parcelExtras != null) {
        paramParcel.readByteArray(this.parcelExtras);
      }
      return;
    }
  }
  
  public InstalledApk(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public InstalledApk(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    this.apkFilePath = paramString1;
    this.oDexPath = paramString2;
    this.libraryPath = paramString3;
    this.parcelExtras = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.apkFilePath);
    paramParcel.writeString(this.oDexPath);
    paramParcel.writeString(this.libraryPath);
    if (this.parcelExtras == null) {}
    for (paramInt = 0;; paramInt = this.parcelExtras.length)
    {
      paramParcel.writeInt(paramInt);
      if (this.parcelExtras != null) {
        paramParcel.writeByteArray(this.parcelExtras);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.core.common.InstalledApk
 * JD-Core Version:    0.7.0.1
 */