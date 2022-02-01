package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class SubPkgInfo
  implements Parcelable, Serializable
{
  public static final Parcelable.Creator<SubPkgInfo> CREATOR = new SubPkgInfo.1();
  public String downloadUrl;
  public int fileSize = -1;
  public int independent;
  public String subPkgName;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDownloadUrl()
  {
    return this.downloadUrl;
  }
  
  public int getIndependent()
  {
    return this.independent;
  }
  
  public String getSubPkgName()
  {
    return this.subPkgName;
  }
  
  public void setDownloadUrl(String paramString)
  {
    this.downloadUrl = paramString;
  }
  
  public void setIndependent(int paramInt)
  {
    this.independent = paramInt;
  }
  
  public void setSubPkgName(String paramString)
  {
    this.subPkgName = paramString;
  }
  
  public String toString()
  {
    return "SubPkgInfo{subPkgName='" + this.subPkgName + '\'' + ", downloadUrl='" + this.downloadUrl + '\'' + ", independent=" + this.independent + ", fileSize=" + this.fileSize + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.subPkgName);
    paramParcel.writeString(this.downloadUrl);
    paramParcel.writeInt(this.independent);
    paramParcel.writeInt(this.fileSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.SubPkgInfo
 * JD-Core Version:    0.7.0.1
 */