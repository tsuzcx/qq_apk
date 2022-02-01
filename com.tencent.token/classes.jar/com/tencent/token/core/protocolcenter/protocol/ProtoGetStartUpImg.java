package com.tencent.token.core.protocolcenter.protocol;

import android.graphics.Bitmap;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.e;
import com.tencent.token.utils.m;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetStartUpImg
  extends d
{
  private ConfigResult d;
  
  public static void a(dp paramdp, ConfigResult paramConfigResult)
  {
    paramdp.c.put("param.startup.img.result", paramConfigResult);
  }
  
  protected String a()
  {
    ConfigResult localConfigResult = this.d;
    if (localConfigResult == null) {
      return null;
    }
    return localConfigResult.mStartUpImgUrl;
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((ConfigResult)paramdp.c.get("param.startup.img.result"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.d.mStartUpImg = ((Bitmap)paramJSONObject.get("startup_img"));
    if ((this.d.mStartUpImg != null) && (this.d.mStartUpImg.getWidth() != 0) && (this.d.mStartUpImg.getHeight() != 0))
    {
      this.a.c();
      m.a(this.d);
      return;
    }
    this.a.b(10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetStartUpImg
 * JD-Core Version:    0.7.0.1
 */