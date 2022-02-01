package com.tencent.token;

import android.graphics.Bitmap;
import com.tencent.token.core.bean.ConfigResult;
import java.util.HashMap;
import org.json.JSONObject;

public final class vp
  extends tk
{
  private ConfigResult d;
  
  public final String a()
  {
    ConfigResult localConfigResult = this.d;
    if (localConfigResult == null) {
      return null;
    }
    return localConfigResult.mStartUpImgUrl;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((ConfigResult)paramaar.c.get("param.startup.img.result"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    this.d.mStartUpImg = ((Bitmap)paramJSONObject.get("startup_img"));
    if ((this.d.mStartUpImg != null) && (this.d.mStartUpImg.getWidth() != 0) && (this.d.mStartUpImg.getHeight() != 0))
    {
      this.a.a = 0;
      aae.a(this.d);
      return;
    }
    this.a.a(10000, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.vp
 * JD-Core Version:    0.7.0.1
 */