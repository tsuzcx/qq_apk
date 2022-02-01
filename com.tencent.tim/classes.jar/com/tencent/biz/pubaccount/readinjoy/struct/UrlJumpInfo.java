package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import kxm;
import mik;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;

public class UrlJumpInfo
  implements Parcelable
{
  public static final Parcelable.Creator<UrlJumpInfo> CREATOR = new mik();
  public String WT;
  public String aiM;
  public String aiN;
  public String jumpSchema;
  public int jumpType;
  public String jumpUrl;
  
  public UrlJumpInfo() {}
  
  public UrlJumpInfo(Parcel paramParcel)
  {
    this.jumpType = paramParcel.readInt();
    this.jumpUrl = paramParcel.readString();
    this.aiM = paramParcel.readString();
    this.jumpSchema = paramParcel.readString();
    this.aiN = paramParcel.readString();
    this.WT = paramParcel.readString();
  }
  
  public static UrlJumpInfo a(articlesummary.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      if (paramUrlJumpInfo.uint32_jump_type.has()) {}
      for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
      {
        localUrlJumpInfo.jumpType = i;
        localUrlJumpInfo.jumpSchema = kxm.a(paramUrlJumpInfo.bytes_jump_schema);
        localUrlJumpInfo.aiM = kxm.a(paramUrlJumpInfo.bytes_jump_bundle);
        localUrlJumpInfo.jumpUrl = kxm.a(paramUrlJumpInfo.bytes_jump_url);
        localUrlJumpInfo.aiN = kxm.a(paramUrlJumpInfo.bytes_clipboard_info);
        localUrlJumpInfo.WT = kxm.a(paramUrlJumpInfo.bytes_common_data);
        return localUrlJumpInfo;
      }
    }
    return null;
  }
  
  public articlesummary.UrlJumpInfo a()
  {
    articlesummary.UrlJumpInfo localUrlJumpInfo = new articlesummary.UrlJumpInfo();
    localUrlJumpInfo.uint32_jump_type.set(this.jumpType);
    if (!TextUtils.isEmpty(this.jumpUrl)) {
      localUrlJumpInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jumpUrl));
    }
    if (!TextUtils.isEmpty(this.aiM)) {
      localUrlJumpInfo.bytes_jump_bundle.set(ByteStringMicro.copyFromUtf8(this.aiM));
    }
    if (!TextUtils.isEmpty(this.jumpSchema)) {
      localUrlJumpInfo.bytes_jump_schema.set(ByteStringMicro.copyFromUtf8(this.jumpSchema));
    }
    if (!TextUtils.isEmpty(this.aiN)) {
      localUrlJumpInfo.bytes_clipboard_info.set(ByteStringMicro.copyFromUtf8(this.aiN));
    }
    if (!TextUtils.isEmpty(this.WT)) {
      localUrlJumpInfo.bytes_common_data.set(ByteStringMicro.copyFromUtf8(this.WT));
    }
    return localUrlJumpInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "UrlJumpInfo{jumpType=" + this.jumpType + ", jumpUrl='" + this.jumpUrl + '\'' + ", jumpBundle='" + this.aiM + '\'' + ", jumpSchema='" + this.jumpSchema + '\'' + ", clipboardInfo='" + this.aiN + '\'' + ", commonData='" + this.WT + "'" + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jumpType);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.aiM);
    paramParcel.writeString(this.jumpSchema);
    paramParcel.writeString(this.aiN);
    paramParcel.writeString(this.WT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo
 * JD-Core Version:    0.7.0.1
 */