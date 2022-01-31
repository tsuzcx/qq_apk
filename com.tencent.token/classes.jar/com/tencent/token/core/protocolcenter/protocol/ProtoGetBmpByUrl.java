package com.tencent.token.core.protocolcenter.protocol;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.CommonImgResult;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.ev;
import com.tencent.token.global.f;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetBmpByUrl
  extends e
{
  private String d;
  private CommonImgResult e;
  
  protected String a()
  {
    return this.d;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((String)paramev.c.get("param.common.img.url"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    paramJSONObject = (Bitmap)paramJSONObject.get("img");
    if ((paramJSONObject == null) || (paramJSONObject.getWidth() == 0) || (paramJSONObject.getHeight() == 0))
    {
      this.a.b(104);
      return;
    }
    this.a.c();
    this.e = new CommonImgResult(this.d, paramJSONObject);
  }
  
  protected void b()
  {
    if (!this.b.e)
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
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetBmpByUrl
 * JD-Core Version:    0.7.0.1
 */