package com.tencent.android.tpush.service.c;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.MessageType;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import org.json.JSONObject;

class b$1
  implements b.b
{
  b$1(b paramb, d paramd, Context paramContext, a parama) {}
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = this.a.a(this.b);
      MqttChannel.getInstance(this.b).sendRequest(this.a.a().getStr(), localJSONObject, new b.a(this.b, this.c, this.a));
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        TLogger.ee("XGMqttChannel", "sendMessage throwable: ", localThrowable);
        ServiceStat.reportErrCode(this.b, -101, "sendMessage request error", 0L, this.a.a().getStr());
      } while (this.c == null);
      this.c.b(-101, "sendMessage request error", this.a);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c != null) {
      this.c.b(paramInt, paramString, this.a);
    }
    b.a(this.b, paramInt, paramString, 0L, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.c.b.1
 * JD-Core Version:    0.7.0.1
 */