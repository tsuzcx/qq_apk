package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public class FirstPageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FirstPageInfo> CREATOR = new FirstPageInfo.1();
  public String pagePath;
  public String subPkgName;
  
  public static boolean equals(FirstPageInfo paramFirstPageInfo1, FirstPageInfo paramFirstPageInfo2)
  {
    if (paramFirstPageInfo1 == paramFirstPageInfo2) {
      return true;
    }
    if (paramFirstPageInfo1 != null) {
      return paramFirstPageInfo1.equals(paramFirstPageInfo2);
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (!(paramObject instanceof FirstPageInfo));
      paramObject = (FirstPageInfo)paramObject;
    } while ((!TextUtils.equals(paramObject.pagePath, this.pagePath)) || (!TextUtils.equals(paramObject.subPkgName, this.pagePath)));
    return true;
  }
  
  public String getPagePath()
  {
    return this.pagePath;
  }
  
  public String getSubPkgName()
  {
    return this.subPkgName;
  }
  
  public void setPagePath(String paramString)
  {
    this.pagePath = paramString;
  }
  
  public void setSubPkgName(String paramString)
  {
    this.subPkgName = paramString;
  }
  
  public String toString()
  {
    return "FirstPageInfo{pagePath='" + this.pagePath + '\'' + ", subPkgName='" + this.subPkgName + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pagePath);
    paramParcel.writeString(this.subPkgName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.FirstPageInfo
 * JD-Core Version:    0.7.0.1
 */