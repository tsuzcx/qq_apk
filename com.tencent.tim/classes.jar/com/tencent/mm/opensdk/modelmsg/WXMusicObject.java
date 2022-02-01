package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public class WXMusicObject
  implements WXMediaMessage.IMediaObject
{
  private static final int LENGTH_LIMIT = 10240;
  private static final int LYRIC_LENGTH_LIMIT = 32768;
  private static final String TAG = "MicroMsg.SDK.WXMusicObject";
  public String musicDataUrl;
  public String musicLowBandDataUrl;
  public String musicLowBandUrl;
  public String musicUrl;
  public String songAlbumUrl;
  public String songLyric;
  
  public boolean checkArgs()
  {
    if (((this.musicUrl == null) || (this.musicUrl.length() == 0)) && ((this.musicLowBandUrl == null) || (this.musicLowBandUrl.length() == 0)))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "both arguments are null");
      return false;
    }
    if ((this.musicUrl != null) && (this.musicUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicUrl is too long");
      return false;
    }
    if ((this.musicLowBandUrl != null) && (this.musicLowBandUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicLowBandUrl is too long");
      return false;
    }
    if ((this.songAlbumUrl != null) && (this.songAlbumUrl.length() > 10240))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, songAlbumUrl is too long");
      return false;
    }
    if ((this.songLyric != null) && (this.songLyric.length() > 32768))
    {
      Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, songLyric is too long");
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    paramBundle.putString("_wxmusicobject_musicAlbumUrl", this.songAlbumUrl);
    paramBundle.putString("_wxmusicobject_musicLyric", this.songLyric);
  }
  
  public int type()
  {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.musicUrl = paramBundle.getString("_wxmusicobject_musicUrl");
    this.musicLowBandUrl = paramBundle.getString("_wxmusicobject_musicLowBandUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicobject_musicDataUrl");
    this.musicLowBandDataUrl = paramBundle.getString("_wxmusicobject_musicLowBandDataUrl");
    this.songAlbumUrl = paramBundle.getString("_wxmusicobject_musicAlbumUrl");
    this.songLyric = paramBundle.getString("_wxmusicobject_musicLyric");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXMusicObject
 * JD-Core Version:    0.7.0.1
 */