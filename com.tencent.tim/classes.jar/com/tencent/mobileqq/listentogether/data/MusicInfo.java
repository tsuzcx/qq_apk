package com.tencent.mobileqq.listentogether.data;

import acfp;
import aiof;
import aipz;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import aqgv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.aio.media.aio_media.Song;

public class MusicInfo
  implements ISong
{
  public static final Parcelable.Creator<MusicInfo> CREATOR = new aiof();
  public List<String> CB;
  public List<String> CC;
  public long abP;
  public long abQ;
  public String album;
  public long duration;
  public String id;
  public String lyric;
  public String name;
  public long shareUin;
  public int source;
  public String subTitle;
  public long timeStamp;
  
  public MusicInfo() {}
  
  private MusicInfo(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.name = paramParcel.readString();
    this.subTitle = paramParcel.readString();
    this.CC = new ArrayList();
    paramParcel.readStringList(this.CC);
    this.lyric = paramParcel.readString();
    this.album = paramParcel.readString();
    this.abP = paramParcel.readLong();
    this.CB = new ArrayList();
    paramParcel.readStringList(this.CB);
    this.duration = paramParcel.readLong();
    this.source = paramParcel.readInt();
    this.shareUin = paramParcel.readLong();
  }
  
  public static MusicInfo a(aio_media.Song paramSong)
  {
    if (paramSong == null) {
      return null;
    }
    MusicInfo localMusicInfo = new MusicInfo();
    localMusicInfo.id = paramSong.str_song_id.get();
    if (paramSong.bytes_name.get() != null)
    {
      localObject1 = paramSong.bytes_name.get().toStringUtf8();
      localMusicInfo.name = ((String)localObject1);
      if (paramSong.bytes_sub_title.get() == null) {
        break label149;
      }
    }
    Object localObject2;
    label149:
    for (Object localObject1 = paramSong.bytes_sub_title.get().toStringUtf8();; localObject1 = "")
    {
      localMusicInfo.subTitle = ((String)localObject1);
      localObject1 = paramSong.rpt_bytes_singer.get();
      localMusicInfo.CB = new ArrayList();
      if (localObject1 == null) {
        break label155;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
        localMusicInfo.CB.add(((ByteStringMicro)localObject2).toStringUtf8());
      }
      localObject1 = "";
      break;
    }
    label155:
    localMusicInfo.CC = new ArrayList();
    if (paramSong.rpt_bytes_download_url.get() != null)
    {
      localObject1 = paramSong.rpt_bytes_download_url.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ByteStringMicro)((Iterator)localObject1).next();
          localMusicInfo.CC.add(((ByteStringMicro)localObject2).toStringUtf8());
        }
      }
    }
    if (paramSong.bytes_lyric.get() != null)
    {
      localObject1 = paramSong.bytes_lyric.get().toStringUtf8();
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ((String)localObject1).replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
      }
      localMusicInfo.lyric = ((String)localObject2);
      if (paramSong.bytes_cover.get() == null) {
        break label387;
      }
    }
    label387:
    for (localObject1 = paramSong.bytes_cover.get().toStringUtf8();; localObject1 = "")
    {
      localMusicInfo.album = ((String)localObject1);
      localMusicInfo.duration = paramSong.uint32_duration.get();
      localMusicInfo.source = paramSong.enum_song_source.get();
      localMusicInfo.shareUin = paramSong.uint64_sharer_uin.get();
      return localMusicInfo;
      localObject1 = "";
      break;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramLong < 0L)) {
      return "";
    }
    if (paramInt == 2) {}
    for (paramQQAppInterface = aqgv.b(paramQQAppInterface, String.valueOf(paramLong), true);; paramQQAppInterface = aqgv.h(paramQQAppInterface, paramString, String.valueOf(paramLong)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic", 2, " getSourceStr() type = " + paramInt + " sessionUin = " + paramString + " shareUin =" + paramLong + " nickName =" + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break;
      }
      return "";
    }
    paramString = new StringBuilder();
    paramString.append("来自").append(paramQQAppInterface).append("分享");
    return paramString.toString();
  }
  
  public static String ev(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "QQ音乐";
    }
    return acfp.m(2131708597);
  }
  
  public static int ie(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    }
    return 2130841342;
  }
  
  public int FJ()
  {
    if (this.abP < 0L) {
      return 0;
    }
    return (int)this.abP;
  }
  
  public int FK()
  {
    return this.source;
  }
  
  public int FL()
  {
    return 1;
  }
  
  public boolean api()
  {
    return (this.CC != null) && (!this.CC.isEmpty());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MusicInfo)) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.id)) && (this.id.equals(((MusicInfo)paramObject).getId())) && (FL() == ((MusicInfo)paramObject).FL())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public List<String> fo()
  {
    return this.CC;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getTitle()
  {
    return this.name;
  }
  
  public long gl()
  {
    return this.shareUin;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("SongInfo{id='").append(this.id).append('\'').append(", name='").append(this.name).append('\'').append(", subTitle='").append(this.subTitle).append('\'').append(", singers=").append(this.CB).append(", urls='");
    if (this.CC == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append('\'').append(", lyric='");
      if (this.lyric != null) {
        break label240;
      }
    }
    label240:
    for (int i = j;; i = this.lyric.length())
    {
      return i + '\'' + ", album='" + this.album + '\'' + ", seek='" + this.abP + '\'' + "ms, duration='" + this.duration + '\'' + ", source='" + this.source + '\'' + ", shareUin='" + this.shareUin + '\'' + '}';
      i = this.CC.size();
      break;
    }
  }
  
  public String wX()
  {
    return aipz.lE(this.id);
  }
  
  public String wY()
  {
    return this.album;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.subTitle);
    paramParcel.writeStringList(this.CC);
    paramParcel.writeString(this.lyric);
    paramParcel.writeString(this.album);
    paramParcel.writeLong(this.abP);
    paramParcel.writeStringList(this.CB);
    paramParcel.writeLong(this.duration);
    paramParcel.writeInt(this.source);
    paramParcel.writeLong(this.shareUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.data.MusicInfo
 * JD-Core Version:    0.7.0.1
 */