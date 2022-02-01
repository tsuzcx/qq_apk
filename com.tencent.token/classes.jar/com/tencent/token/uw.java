package com.tencent.token;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.CommonImgResult;
import java.util.HashMap;
import org.json.JSONObject;

public final class uw
  extends tk
{
  private String d;
  private CommonImgResult e;
  
  public final String a()
  {
    return this.d;
  }
  
  public final void a(aar paramaar)
  {
    this.d = ((String)paramaar.c.get("param.common.img.url"));
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = (Bitmap)paramJSONObject.get("img");
    if ((paramJSONObject != null) && (paramJSONObject.getWidth() != 0) && (paramJSONObject.getHeight() != 0))
    {
      this.a.a = 0;
      this.e = new CommonImgResult(this.d, paramJSONObject);
      return;
    }
    this.a.a(104, null, null);
  }
  
  public final void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.uw
 * JD-Core Version:    0.7.0.1
 */