package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kxm;
import mim;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;

public class VideoColumnInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoColumnInfo> CREATOR = new mim();
  public static final String TAG = VideoColumnInfo.class.getSimpleName();
  public int aHc;
  public int aTl;
  public int aTm;
  public String ahk;
  public String aiO;
  public String aiP;
  public String aiQ;
  public String aiR;
  public String aiS;
  public boolean amw;
  public String appIconUrl;
  public String appName;
  public String columnName;
  public UrlJumpInfo h;
  public UrlJumpInfo i;
  public UrlJumpInfo j;
  public UrlJumpInfo k;
  public long lastUpdateTime;
  public int subscribeCount;
  public int videoCount;
  
  public VideoColumnInfo() {}
  
  public VideoColumnInfo(Parcel paramParcel)
  {
    this.aHc = paramParcel.readInt();
    this.columnName = paramParcel.readString();
    this.aiO = paramParcel.readString();
    this.lastUpdateTime = paramParcel.readLong();
    this.videoCount = paramParcel.readInt();
    this.subscribeCount = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.amw = bool;
      this.aiP = paramParcel.readString();
      this.aiQ = paramParcel.readString();
      this.ahk = paramParcel.readString();
      this.appName = paramParcel.readString();
      this.appIconUrl = paramParcel.readString();
      this.h = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.i = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.j = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.k = ((UrlJumpInfo)paramParcel.readParcelable(UrlJumpInfo.class.getClassLoader()));
      this.aTl = paramParcel.readInt();
      this.aiR = paramParcel.readString();
      this.aiS = paramParcel.readString();
      this.aTm = paramParcel.readInt();
      return;
    }
  }
  
  public static VideoColumnInfo a(articlesummary.VideoColumnInfo paramVideoColumnInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVideoColumnInfo != null)
    {
      localObject1 = localObject2;
      if (paramVideoColumnInfo.has())
      {
        localObject1 = localObject2;
        if (paramVideoColumnInfo.get() != null)
        {
          localObject1 = new VideoColumnInfo();
          ((VideoColumnInfo)localObject1).aHc = paramVideoColumnInfo.uint32_column_id.get();
          ((VideoColumnInfo)localObject1).columnName = kxm.a(paramVideoColumnInfo.bytes_column_name);
          ((VideoColumnInfo)localObject1).aiO = kxm.a(paramVideoColumnInfo.bytes_column_icon_url);
          ((VideoColumnInfo)localObject1).lastUpdateTime = paramVideoColumnInfo.uint64_last_update_time.get();
          ((VideoColumnInfo)localObject1).videoCount = paramVideoColumnInfo.uint32_video_count.get();
          ((VideoColumnInfo)localObject1).subscribeCount = paramVideoColumnInfo.uint32_subscribe_count.get();
          if (paramVideoColumnInfo.uint32_is_subscribed.get() <= 0) {
            break label251;
          }
        }
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      ((VideoColumnInfo)localObject1).amw = bool;
      ((VideoColumnInfo)localObject1).aiP = kxm.a(paramVideoColumnInfo.bytes_column_card_bg_url);
      ((VideoColumnInfo)localObject1).aiQ = kxm.a(paramVideoColumnInfo.bytes_column_card_bg_color);
      ((VideoColumnInfo)localObject1).ahk = kxm.a(paramVideoColumnInfo.bytes_column_card_icon_url);
      ((VideoColumnInfo)localObject1).appName = kxm.a(paramVideoColumnInfo.bytes_app_name);
      ((VideoColumnInfo)localObject1).appIconUrl = kxm.a(paramVideoColumnInfo.bytes_app_icon_url);
      ((VideoColumnInfo)localObject1).h = UrlJumpInfo.a(paramVideoColumnInfo.default_jump_info);
      ((VideoColumnInfo)localObject1).i = UrlJumpInfo.a(paramVideoColumnInfo.video_jump_info);
      ((VideoColumnInfo)localObject1).j = UrlJumpInfo.a(paramVideoColumnInfo.subscribe_jump_info);
      ((VideoColumnInfo)localObject1).k = UrlJumpInfo.a(paramVideoColumnInfo.app_jump_info);
      ((VideoColumnInfo)localObject1).aTl = paramVideoColumnInfo.uin32_column_card_bg_style.get();
      ((VideoColumnInfo)localObject1).aiR = kxm.a(paramVideoColumnInfo.bytes_from_txt);
      ((VideoColumnInfo)localObject1).aiS = kxm.a(paramVideoColumnInfo.bytes_column_name_color);
      return localObject1;
    }
  }
  
  public static List<VideoColumnInfo> a(@NotNull PBRepeatMessageField<articlesummary.VideoColumnInfo> paramPBRepeatMessageField)
  {
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < paramPBRepeatMessageField.size())
    {
      VideoColumnInfo localVideoColumnInfo = a((articlesummary.VideoColumnInfo)paramPBRepeatMessageField.get(m));
      if (localVideoColumnInfo != null) {
        localArrayList.add(localVideoColumnInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "convertArticleInfo(): convertPBToInfo Muilt:" + localVideoColumnInfo);
      }
      m += 1;
    }
    return localArrayList;
  }
  
  public byte[] E()
  {
    return a().toByteArray();
  }
  
  public articlesummary.VideoColumnInfo a()
  {
    articlesummary.VideoColumnInfo localVideoColumnInfo = new articlesummary.VideoColumnInfo();
    localVideoColumnInfo.uint32_column_id.set(this.aHc);
    if (!TextUtils.isEmpty(this.columnName)) {
      localVideoColumnInfo.bytes_column_name.set(ByteStringMicro.copyFromUtf8(this.columnName));
    }
    if (!TextUtils.isEmpty(this.aiO)) {
      localVideoColumnInfo.bytes_column_icon_url.set(ByteStringMicro.copyFromUtf8(this.aiO));
    }
    localVideoColumnInfo.uint64_last_update_time.set(this.lastUpdateTime);
    localVideoColumnInfo.uint32_video_count.set(this.videoCount);
    localVideoColumnInfo.uint32_subscribe_count.set(this.subscribeCount);
    PBUInt32Field localPBUInt32Field = localVideoColumnInfo.uint32_is_subscribed;
    if (this.amw) {}
    for (int m = 1;; m = 0)
    {
      localPBUInt32Field.set(m);
      if (!TextUtils.isEmpty(this.aiP)) {
        localVideoColumnInfo.bytes_column_card_bg_url.set(ByteStringMicro.copyFromUtf8(this.aiP));
      }
      if (!TextUtils.isEmpty(this.ahk)) {
        localVideoColumnInfo.bytes_column_card_icon_url.set(ByteStringMicro.copyFromUtf8(this.ahk));
      }
      if (!TextUtils.isEmpty(this.aiQ)) {
        localVideoColumnInfo.bytes_column_card_bg_color.set(ByteStringMicro.copyFromUtf8(this.aiQ));
      }
      if (!TextUtils.isEmpty(this.appName)) {
        localVideoColumnInfo.bytes_app_name.set(ByteStringMicro.copyFromUtf8(this.appName));
      }
      if (!TextUtils.isEmpty(this.appIconUrl)) {
        localVideoColumnInfo.bytes_app_icon_url.set(ByteStringMicro.copyFromUtf8(this.appIconUrl));
      }
      if (this.h != null) {
        localVideoColumnInfo.default_jump_info = this.h.a();
      }
      if (this.i != null) {
        localVideoColumnInfo.video_jump_info = this.i.a();
      }
      if (this.j != null) {
        localVideoColumnInfo.subscribe_jump_info = this.j.a();
      }
      if (this.k != null) {
        localVideoColumnInfo.app_jump_info = this.k.a();
      }
      localVideoColumnInfo.uin32_column_card_bg_style.set(this.aTl);
      if (!TextUtils.isEmpty(this.aiR)) {
        localVideoColumnInfo.bytes_from_txt.set(ByteStringMicro.copyFromUtf8(this.aiR));
      }
      if (!TextUtils.isEmpty(this.aiS)) {
        localVideoColumnInfo.bytes_column_name_color.set(ByteStringMicro.copyFromUtf8(this.aiS));
      }
      return localVideoColumnInfo;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String jW()
  {
    return "#" + this.columnName;
  }
  
  public String toString()
  {
    return "VideoColumnInfo{columnId=" + this.aHc + ", columnName='" + this.columnName + '\'' + ", columnIconUrl=" + this.aiO + '\'' + ", lastUpdateTime=" + this.lastUpdateTime + '\'' + ", videoCount=" + this.videoCount + '\'' + ", subscribeCount='" + this.subscribeCount + '\'' + ", isSubscribed='" + this.amw + '\'' + ", cardBgUrl=" + this.aiP + '\'' + ", cardBgColor=" + this.aiQ + '\'' + ", cardIconUrl=" + this.ahk + '\'' + ", appName=" + this.appName + ", appIconUrl='" + this.appIconUrl + '\'' + ", defaultJumpInfo=" + this.h + ", videoJumpInfo=" + this.i + ", subscribeJumpInfo=" + this.j + ", appJumpInfo='" + this.k + '\'' + ", cardBgStyle='" + this.aTl + '\'' + ", fromText='" + this.aiR + '\'' + ", columnNameColor='" + this.aiS + '\'' + ", columnStyle='" + this.aTm + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aHc);
    paramParcel.writeString(this.columnName);
    paramParcel.writeString(this.aiO);
    paramParcel.writeLong(this.lastUpdateTime);
    paramParcel.writeInt(this.videoCount);
    paramParcel.writeInt(this.subscribeCount);
    if (this.amw) {}
    for (int m = 1;; m = 0)
    {
      paramParcel.writeByte((byte)m);
      paramParcel.writeString(this.aiP);
      paramParcel.writeString(this.aiQ);
      paramParcel.writeString(this.ahk);
      paramParcel.writeString(this.appName);
      paramParcel.writeString(this.appIconUrl);
      paramParcel.writeParcelable(this.h, paramInt);
      paramParcel.writeParcelable(this.i, paramInt);
      paramParcel.writeParcelable(this.j, paramInt);
      paramParcel.writeParcelable(this.k, paramInt);
      paramParcel.writeInt(this.aTl);
      paramParcel.writeString(this.aiR);
      paramParcel.writeString(this.aiS);
      paramParcel.writeInt(this.aTm);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */