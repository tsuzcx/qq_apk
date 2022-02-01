package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.token.pp;

public class WXVideoObject
  implements WXMediaMessage.a
{
  public String videoLowBandUrl;
  public String videoUrl;
  
  public boolean checkArgs()
  {
    String str = this.videoUrl;
    if ((str == null) || (str.length() == 0))
    {
      str = this.videoLowBandUrl;
      if ((str == null) || (str.length() == 0)) {}
    }
    else
    {
      str = this.videoUrl;
      if ((str != null) && (str.length() > 10240)) {
        str = "checkArgs fail, videoUrl is too long";
      }
    }
    for (;;)
    {
      pp.a("MicroMsg.SDK.WXVideoObject", str);
      return false;
      str = this.videoLowBandUrl;
      if ((str != null) && (str.length() > 10240))
      {
        str = "checkArgs fail, videoLowBandUrl is too long";
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
    paramBundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
    paramBundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
  }
  
  public int type()
  {
    return 4;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.videoUrl = paramBundle.getString("_wxvideoobject_videoUrl");
    this.videoLowBandUrl = paramBundle.getString("_wxvideoobject_videoLowBandUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXVideoObject
 * JD-Core Version:    0.7.0.1
 */