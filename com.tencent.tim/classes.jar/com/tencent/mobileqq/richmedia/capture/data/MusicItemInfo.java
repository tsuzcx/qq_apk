package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.Utils;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicItemInfo
  implements Parcelable
{
  public static final int CAPTURE_VIDEO_LENGTH = 10000;
  public static final Parcelable.Creator<MusicItemInfo> CREATOR = new MusicItemInfo.1();
  public static final int ITEM_ID_ADD = -3;
  public static final int ITEM_ID_BGM_RECOGNITION = -6;
  public static final int ITEM_ID_HUM_HUNT = -4;
  public static final int ITEM_ID_MOCK = -5;
  public static final int ITEM_ID_MUTE = -2;
  public static final int ITEM_ID_ORIGIN = -1;
  public static final int ITEM_ID_WS_BANNER = -7;
  public static final float NOT_RECOGNITION_RESULT_OFFSET = -1.0F;
  public static final int TYPE_ADD = 4;
  public static final int TYPE_BGM_RECOGNITION_TAB = 8;
  public static final int TYPE_COMMON = 1;
  public static final int TYPE_DOV_BANNER = 11;
  public static final int TYPE_HUM_NO_MATCH = 7;
  public static final int TYPE_HUM_RECOGNITION_TAB = 6;
  public static final int TYPE_MUTE = 3;
  public static final int TYPE_ORIGIN = 2;
  public static final int TYPE_QQ_MUSIC = 5;
  public static final int TYPE_WS_BANNER = 10;
  public int downLv = 0;
  public long fileSize = 0L;
  public String jumpWs;
  public int mAccuracy;
  public String mAlbumUrl;
  public boolean mHasCopyright;
  public int mItemId;
  public String mMusicName;
  private String mPath;
  public int mProgress = -1;
  public float mRecognitionOffset = -1.0F;
  public String mSingername;
  public String mSongMid;
  public String mTagName;
  public int mType = 1;
  public String mUrl;
  public int musicDuration = 0;
  public int musicEnd = 0;
  public int musicStart = 0;
  
  public MusicItemInfo() {}
  
  public MusicItemInfo(Parcel paramParcel)
  {
    this.mMusicName = paramParcel.readString();
    this.mSingername = paramParcel.readString();
    this.mUrl = paramParcel.readString();
    this.mTagName = paramParcel.readString();
    this.mItemId = paramParcel.readInt();
    this.mType = paramParcel.readInt();
    this.musicStart = paramParcel.readInt();
    this.musicEnd = paramParcel.readInt();
    this.musicDuration = paramParcel.readInt();
    this.mSongMid = paramParcel.readString();
    this.mRecognitionOffset = paramParcel.readFloat();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.mHasCopyright = bool;
      this.mAccuracy = paramParcel.readInt();
      this.jumpWs = paramParcel.readString();
      this.downLv = paramParcel.readInt();
      this.mAlbumUrl = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public MusicItemInfo(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    this.mMusicName = paramString.optString("title");
    this.mUrl = paramString.optString("audio_url");
    this.mSingername = paramString.optString("author");
    this.mItemId = paramString.optInt("item_id");
    if (paramString.has("type")) {}
    for (this.mType = paramString.optInt("type");; this.mType = 1)
    {
      this.jumpWs = paramString.optString("jump_ws");
      this.downLv = paramString.optInt("downLv", 0);
      this.mAlbumUrl = paramString.optString("image_url");
      return;
    }
  }
  
  public MusicItemInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.mType = 5;
    this.mMusicName = paramString1;
    this.mUrl = paramString2;
    this.mSingername = paramString3;
    this.mItemId = paramInt1;
    this.mSongMid = paramString4;
    this.musicStart = paramInt2;
    this.musicEnd = paramInt3;
    this.musicDuration = paramInt4;
    this.mHasCopyright = paramBoolean;
  }
  
  public MusicItemInfo(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("mMusicName")) {
        this.mMusicName = paramJSONObject.getString("mMusicName");
      }
      if (paramJSONObject.has("mSingername")) {
        this.mSingername = paramJSONObject.getString("mSingername");
      }
      if (paramJSONObject.has("mUrl")) {
        this.mUrl = paramJSONObject.getString("mUrl");
      }
      if (paramJSONObject.has("mTagName")) {
        this.mTagName = paramJSONObject.getString("mTagName");
      }
      if (paramJSONObject.has("mPath")) {
        this.mPath = paramJSONObject.getString("mPath");
      }
      this.mItemId = paramJSONObject.getInt("mItemId");
      this.mType = paramJSONObject.getInt("mType");
      this.musicStart = paramJSONObject.getInt("musicStart");
      this.musicEnd = paramJSONObject.getInt("musicEnd");
      this.musicDuration = paramJSONObject.getInt("musicDuration");
      if (paramJSONObject.has("mSongMid")) {
        this.mSongMid = paramJSONObject.getString("mSongMid");
      }
      this.mRecognitionOffset = ((float)paramJSONObject.getDouble("mRecognitionOffset"));
      this.mHasCopyright = paramJSONObject.getBoolean("mHasCopyright");
      this.mAccuracy = paramJSONObject.getInt("mAccuracy");
      if (paramJSONObject.has("jump_ws")) {
        this.jumpWs = paramJSONObject.getString("jump_ws");
      }
      this.downLv = paramJSONObject.optInt("downLv", 0);
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  private String getMusicSuffix()
  {
    if (this.mType == 5) {
      for (String str1 = ".mp3";; str2 = ".mp3")
      {
        try
        {
          int i = this.mUrl.indexOf(".m4a");
          if (i >= 0) {}
          if (!SLog.isEnable()) {
            break label114;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            str1 = this.mUrl.substring(i, i + 4);
            if (SLog.isEnable()) {
              SLog.d("MusicItemInfo", "getMusicSuffix " + str1 + " vIndex=" + i);
            }
            return str1;
          }
          catch (Exception localException2)
          {
            String str2;
            break label81;
          }
          localException1 = localException1;
          i = -1;
        }
        label81:
        SLog.d("MusicItemInfo", "getMusicSuffix e:" + localException1.toString());
        label114:
        if (SLog.isEnable()) {
          SLog.d("MusicItemInfo", "getMusicSuffix e:" + localException1.toString());
        }
      }
    } else {
      return ".mp3";
    }
  }
  
  public static MusicItemInfo mock()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mMusicName = "稻香";
    localMusicItemInfo.mSingername = "周杰伦";
    return localMusicItemInfo;
  }
  
  public JSONObject convertToJSON()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.mMusicName != null) {
        localJSONObject.put("mMusicName", this.mMusicName);
      }
      if (this.mSingername != null) {
        localJSONObject.put("mSingername", this.mSingername);
      }
      if (this.mUrl != null) {
        localJSONObject.put("mUrl", this.mUrl);
      }
      if (this.mTagName != null) {
        localJSONObject.put("mTagName", this.mTagName);
      }
      if (this.mPath != null) {
        localJSONObject.put("mPath", this.mPath);
      }
      localJSONObject.put("mItemId", this.mItemId);
      localJSONObject.put("mType", this.mType);
      localJSONObject.put("musicStart", this.musicStart);
      localJSONObject.put("musicEnd", this.musicEnd);
      localJSONObject.put("musicDuration", this.musicDuration);
      if (this.mSongMid != null) {
        localJSONObject.put("mSongMid", this.mSongMid);
      }
      localJSONObject.put("mRecognitionOffset", this.mRecognitionOffset);
      localJSONObject.put("mHasCopyright", this.mHasCopyright);
      localJSONObject.put("mAccuracy", this.mAccuracy);
      localJSONObject.put("downLv", this.downLv);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public MusicItemInfo copy()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mMusicName = this.mMusicName;
    localMusicItemInfo.mSingername = this.mSingername;
    localMusicItemInfo.mUrl = this.mUrl;
    localMusicItemInfo.mTagName = this.mTagName;
    localMusicItemInfo.mItemId = this.mItemId;
    localMusicItemInfo.mType = this.mType;
    localMusicItemInfo.musicStart = this.musicStart;
    localMusicItemInfo.musicEnd = this.musicEnd;
    localMusicItemInfo.musicDuration = this.musicDuration;
    localMusicItemInfo.mSongMid = this.mSongMid;
    localMusicItemInfo.mPath = this.mPath;
    localMusicItemInfo.mRecognitionOffset = this.mRecognitionOffset;
    localMusicItemInfo.mHasCopyright = this.mHasCopyright;
    localMusicItemInfo.mAccuracy = this.mAccuracy;
    localMusicItemInfo.jumpWs = this.jumpWs;
    return localMusicItemInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(MusicItemInfo paramMusicItemInfo)
  {
    if ((paramMusicItemInfo != null) && (paramMusicItemInfo.mType != 1) && (paramMusicItemInfo.mType != 5)) {
      if (this.mType != paramMusicItemInfo.mType) {}
    }
    while ((paramMusicItemInfo != null) && (paramMusicItemInfo.mItemId == this.mItemId) && (paramMusicItemInfo.mType == this.mType) && ((paramMusicItemInfo.mMusicName == this.mMusicName) || ((paramMusicItemInfo.mMusicName != null) && (paramMusicItemInfo.mMusicName.equals(this.mMusicName)))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String getLocalPath()
  {
    try
    {
      if (TextUtils.isEmpty(this.mPath))
      {
        StringBuilder localStringBuilder = new StringBuilder(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
        if ((this.mType == 5) && (TextUtils.isEmpty(this.mUrl)))
        {
          this.mPath = null;
          return this.mPath;
        }
        if ((!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.mMusicName))) {
          localStringBuilder.append(Utils.Crc64String(this.mUrl)).append("_").append(this.mMusicName.hashCode()).append(getMusicSuffix());
        }
        this.mPath = localStringBuilder.toString();
      }
    }
    catch (Exception localException)
    {
      label125:
      break label125;
    }
    return this.mPath;
  }
  
  public int hashCode()
  {
    if ((!TextUtils.isEmpty(this.mMusicName)) && (!TextUtils.isEmpty(this.mSongMid))) {
      return this.mMusicName.hashCode() + this.mSongMid.hashCode() + this.mItemId + this.mType;
    }
    return this.mItemId + this.mType;
  }
  
  public boolean isDownloading()
  {
    return (this.mProgress > -1) && (this.mProgress < 100);
  }
  
  public boolean isFileExist()
  {
    return ((this.mType == 5) || (this.mType == 1)) && (FileUtil.fileExistsAndNotEmpty(getLocalPath()));
  }
  
  public boolean isMute()
  {
    return this.mType != 2;
  }
  
  public boolean isMyMusicInfo()
  {
    return this.mType == 5;
  }
  
  public boolean isWsBanner()
  {
    return (this.mType == 10) || (this.mType == 11);
  }
  
  public boolean needPlay()
  {
    return (this.mType == 1) || (this.mType == 5);
  }
  
  public void setPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mPath = paramString;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicItemInfo: ").append(this.mSingername).append(" - ").append(this.mMusicName).append(" - ").append("mRecognitionOffset=").append(this.mRecognitionOffset);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mMusicName);
    paramParcel.writeString(this.mSingername);
    paramParcel.writeString(this.mUrl);
    paramParcel.writeString(this.mTagName);
    paramParcel.writeInt(this.mItemId);
    paramParcel.writeInt(this.mType);
    paramParcel.writeInt(this.musicStart);
    paramParcel.writeInt(this.musicEnd);
    paramParcel.writeInt(this.musicDuration);
    paramParcel.writeString(this.mSongMid);
    paramParcel.writeFloat(this.mRecognitionOffset);
    if (this.mHasCopyright) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.mAccuracy);
      paramParcel.writeString(this.jumpWs);
      paramParcel.writeInt(this.downLv);
      paramParcel.writeString(this.mAlbumUrl);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo
 * JD-Core Version:    0.7.0.1
 */