package com.tencent.mobileqq.data;

import afad;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class PrecoverResource
  extends Entity
  implements Parcelable
{
  public static final Parcelable.Creator<PrecoverResource> CREATOR = new afad();
  @notColumn
  public int arg1;
  @notColumn
  public int arg2;
  public String businessId;
  public String md5;
  @unique
  public String pk;
  public String resId;
  @notColumn
  public String thirdPartDownloadPath;
  public String url;
  
  public PrecoverResource() {}
  
  public PrecoverResource(Parcel paramParcel)
  {
    this.pk = paramParcel.readString();
    this.businessId = paramParcel.readString();
    this.resId = paramParcel.readString();
    this.url = paramParcel.readString();
    this.md5 = paramParcel.readString();
  }
  
  public PrecoverResource(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.businessId = paramString1;
    this.resId = paramString2;
    this.url = paramString3;
    this.md5 = paramString4;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.pk = (paramString1 + "_" + paramString2);
      return;
    }
    this.pk = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof PrecoverResource))) {}
    do
    {
      return false;
      paramObject = (PrecoverResource)paramObject;
    } while ((!paramObject.isValid()) || (!isValid()) || (!this.md5.equals(paramObject.md5)) || (!this.url.equals(paramObject.url)) || (!this.businessId.equals(paramObject.businessId)) || (!this.resId.equals(paramObject.resId)));
    return true;
  }
  
  public String getPk()
  {
    if (TextUtils.isEmpty(this.pk)) {
      if ((TextUtils.isEmpty(this.businessId)) || (TextUtils.isEmpty(this.resId))) {
        break label68;
      }
    }
    label68:
    for (this.pk = (this.businessId + "_" + this.resId);; this.pk = null) {
      return this.pk;
    }
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.businessId)) && (!TextUtils.isEmpty(this.resId)) && (!TextUtils.isEmpty(this.url)) && (!TextUtils.isEmpty(this.md5));
  }
  
  public void postRead()
  {
    super.postRead();
  }
  
  public void postwrite()
  {
    super.postwrite();
  }
  
  public void prewrite()
  {
    super.prewrite();
    if ((!TextUtils.isEmpty(this.businessId)) && (!TextUtils.isEmpty(this.resId)))
    {
      this.pk = (this.businessId + "_" + this.resId);
      return;
    }
    this.pk = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrecoverResource:pk=").append(this.pk);
    localStringBuilder.append(",businessId=").append(this.businessId);
    localStringBuilder.append(",resId=").append(this.resId);
    localStringBuilder.append(",url=").append(this.url);
    localStringBuilder.append(",md5=").append(this.md5);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.pk);
    paramParcel.writeString(this.businessId);
    paramParcel.writeString(this.resId);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.md5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PrecoverResource
 * JD-Core Version:    0.7.0.1
 */