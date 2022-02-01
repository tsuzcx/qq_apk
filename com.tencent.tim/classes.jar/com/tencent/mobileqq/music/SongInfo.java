package com.tencent.mobileqq.music;

import ajmo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cooperation.qzone.music.BroadcastMusicInfo;

public class SongInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SongInfo> CREATOR = new ajmo();
  public String album;
  public BroadcastMusicInfo b;
  public String coverUrl;
  public String detailUrl;
  public long duration;
  public boolean fromMini;
  public long id;
  public String mid;
  public String singer;
  public long singerId;
  public int startTime;
  public String summary;
  public String title;
  public int type;
  public long uin;
  public String url;
  
  public SongInfo() {}
  
  public SongInfo(long paramLong, String paramString1, String paramString2)
  {
    this.id = paramLong;
    this.album = paramString1;
    this.url = paramString2;
    this.b = null;
  }
  
  private SongInfo(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.coverUrl = paramParcel.readString();
    this.detailUrl = paramParcel.readString();
    this.id = paramParcel.readLong();
    this.album = paramParcel.readString();
    this.singer = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.singerId = paramParcel.readLong();
    this.b = ((BroadcastMusicInfo)paramParcel.readParcelable(BroadcastMusicInfo.class.getClassLoader()));
    this.startTime = paramParcel.readInt();
    if (paramParcel.readFloat() != 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      this.fromMini = bool;
      this.duration = paramParcel.readLong();
      this.uin = paramParcel.readLong();
      this.mid = paramParcel.readString();
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.coverUrl);
    paramParcel.writeString(this.detailUrl);
    paramParcel.writeLong(this.id);
    paramParcel.writeString(this.album);
    paramParcel.writeString(this.singer);
    paramParcel.writeInt(this.type);
    paramParcel.writeLong(this.singerId);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeInt(this.startTime);
    if (this.fromMini) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      paramParcel.writeFloat(f);
      paramParcel.writeLong(this.duration);
      paramParcel.writeLong(this.uin);
      paramParcel.writeString(this.mid);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.SongInfo
 * JD-Core Version:    0.7.0.1
 */