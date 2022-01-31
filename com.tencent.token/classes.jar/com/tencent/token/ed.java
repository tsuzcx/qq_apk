package com.tencent.token;

import android.graphics.Bitmap;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.global.d;
import com.tencent.token.utils.t;
import java.util.HashMap;
import org.json.JSONObject;

public final class ed
  extends bm
{
  private ConfigResult c;
  
  protected final String a()
  {
    if (this.c == null) {
      return null;
    }
    return this.c.mStartUpImgUrl;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((ConfigResult)paramfs.c.get("param.startup.img.result"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    this.c.mStartUpImg = ((Bitmap)paramJSONObject.get("startup_img"));
    if ((this.c.mStartUpImg == null) || (this.c.mStartUpImg.getWidth() == 0) || (this.c.mStartUpImg.getHeight() == 0))
    {
      this.a.a(10000, null, null);
      return;
    }
    this.a.a = 0;
    t.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ed
 * JD-Core Version:    0.7.0.1
 */