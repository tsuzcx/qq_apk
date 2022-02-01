package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META.StMusic;
import acfp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import org.json.JSONObject;

public class VsMusicItemInfo
  extends MusicItemInfo
{
  public String aGd;
  public String aGe;
  public boolean aMO = true;
  public int from = 1;
  public String mErrorMsg = acfp.m(2131716888);
  
  public VsMusicItemInfo() {}
  
  public VsMusicItemInfo(META.StMusic paramStMusic)
  {
    if (paramStMusic == null) {
      return;
    }
    a(paramStMusic);
  }
  
  public VsMusicItemInfo(JSONObject paramJSONObject)
  {
    this.mType = 5;
    this.mMusicName = paramJSONObject.optString("title");
    this.mSingername = paramJSONObject.optString("desc");
    this.mItemId = paramJSONObject.optInt("id");
    this.mAlbumUrl = paramJSONObject.optString("image_url");
    this.mSongMid = paramJSONObject.optString("mid");
    this.mMusicName = paramJSONObject.optString("strSongName");
    this.mHasCopyright = true;
    this.from = 2;
    this.mUrl = paramJSONObject.optString("strPlayUrl");
    this.musicDuration = (paramJSONObject.optInt("iPlayTime") * 1000);
  }
  
  public void a(META.StMusic paramStMusic)
  {
    boolean bool = true;
    this.mSongMid = paramStMusic.strSongMid.get();
    this.mType = 5;
    this.mUrl = paramStMusic.strPlayUrl.get();
    if (paramStMusic.copyright.get() == 1) {}
    for (;;)
    {
      this.mHasCopyright = bool;
      this.mSingername = paramStMusic.strSingerName.get();
      this.mMusicName = paramStMusic.strSongName.get();
      this.mAlbumUrl = paramStMusic.strAlbumPic.get();
      this.aGe = paramStMusic.strLyric.get();
      this.musicStart = ((int)paramStMusic.iStartPos.get());
      this.musicEnd = 0;
      this.aGd = paramStMusic.strFormat.get();
      this.mItemId = ((int)paramStMusic.uiSongId.get());
      this.musicDuration = (paramStMusic.iPlayTime.get() * 1000);
      this.fileSize = paramStMusic.iSize.get();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo
 * JD-Core Version:    0.7.0.1
 */