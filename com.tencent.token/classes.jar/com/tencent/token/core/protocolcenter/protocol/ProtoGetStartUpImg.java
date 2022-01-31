package com.tencent.token.core.protocolcenter.protocol;

import android.graphics.Bitmap;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.ev;
import com.tencent.token.global.f;
import com.tencent.token.utils.x;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetStartUpImg
  extends e
{
  private ConfigResult d;
  
  public static void a(ev paramev, ConfigResult paramConfigResult)
  {
    paramev.c.put("param.startup.img.result", paramConfigResult);
  }
  
  protected String a()
  {
    if (this.d == null) {
      return null;
    }
    return this.d.mStartUpImgUrl;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((ConfigResult)paramev.c.get("param.startup.img.result"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    this.d.mStartUpImg = ((Bitmap)paramJSONObject.get("startup_img"));
    if ((this.d.mStartUpImg == null) || (this.d.mStartUpImg.getWidth() == 0) || (this.d.mStartUpImg.getHeight() == 0))
    {
      this.a.b(10000);
      return;
    }
    this.a.c();
    x.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetStartUpImg
 * JD-Core Version:    0.7.0.1
 */