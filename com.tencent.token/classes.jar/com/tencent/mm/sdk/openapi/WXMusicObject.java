package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.token.qk;

public class WXMusicObject
  implements WXMediaMessage.a
{
  public String musicDataUrl;
  public String musicLowBandDataUrl;
  public String musicLowBandUrl;
  public String musicUrl;
  
  public boolean checkArgs()
  {
    String str = this.musicUrl;
    if ((str == null) || (str.length() == 0))
    {
      str = this.musicLowBandUrl;
      if ((str == null) || (str.length() == 0)) {}
    }
    else
    {
      str = this.musicUrl;
      if ((str != null) && (str.length() > 10240)) {
        str = "checkArgs fail, musicUrl is too long";
      }
    }
    for (;;)
    {
      qk.a("MicroMsg.SDK.WXMusicObject", str);
      return false;
      str = this.musicLowBandUrl;
      if ((str != null) && (str.length() > 10240))
      {
        str = "checkArgs fail, musicLowBandUrl is too long";
      }
      else
      {
        return true;
        str = "both arguments are null";
      }
    }
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXMusicObject
 * JD-Core Version:    0.7.0.1
 */