package com.tencent.android.tpush.service.c;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.MessageType;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import org.json.JSONObject;

class b$2
  implements b.b
{
  b$2(b paramb, d paramd, Context paramContext, a parama) {}
  
  public void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", b.a(this.d));
      localJSONObject.put("cmd", this.a.a().getStr());
      localJSONObject.put("params", this.a.a(this.b));
      MqttChannel.getInstance(this.b).sendPublishData("_xg/device/statistics", localJSONObject.toString(), new b.a(this.b, this.c, this.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        TLogger.ee("XGMqttChannel", "sendStatMsg throwable: ", localThrowable);
      } while (this.c == null);
      this.c.b(-101, "sendStatMsg request error", this.a);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c != null) {
      this.c.b(paramInt, paramString, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.c.b.2
 * JD-Core Version:    0.7.0.1
 */