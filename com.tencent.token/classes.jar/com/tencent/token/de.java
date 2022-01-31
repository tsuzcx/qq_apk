package com.tencent.token;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.CommonImgResult;
import com.tencent.token.global.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class de
  extends bm
{
  private String c;
  private CommonImgResult d;
  
  protected final String a()
  {
    return this.c;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((String)paramfs.c.get("param.common.img.url"));
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    paramJSONObject = (Bitmap)paramJSONObject.get("img");
    if ((paramJSONObject == null) || (paramJSONObject.getWidth() == 0) || (paramJSONObject.getHeight() == 0))
    {
      this.a.a(104, null, null);
      return;
    }
    this.a.a = 0;
    this.d = new CommonImgResult(this.c, paramJSONObject);
  }
  
  protected final void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.d;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.de
 * JD-Core Version:    0.7.0.1
 */