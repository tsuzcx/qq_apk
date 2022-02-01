package com.tencent.tpns.mqttchannel.core.b;

import android.os.Handler;
import android.util.Pair;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.Map;
import org.json.JSONObject;

class a$17
  implements IMqttActionListener
{
  a$17(a parama, com.tencent.tpns.mqttchannel.core.common.a.a parama1, String paramString, JSONObject paramJSONObject, com.tencent.tpns.mqttchannel.core.common.b.a parama2) {}
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    a.a(this.e, 1010, this.a);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendRequest -> callback onFailure:", paramThrowable);
    paramIMqttToken = (Pair)a.o(this.e).remove(Long.valueOf(this.a.a()));
    if (paramIMqttToken != null)
    {
      CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable)paramIMqttToken.second);
      a.a(this.e, this.d, -7, "sendRequest onFailure: " + paramThrowable.toString());
      return;
    }
    com.tencent.tpns.mqttchannel.core.common.c.a.d("IMqttServiceImpl", "onFailure but Not found the rpc Request id");
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    this.a.b = true;
    a.d(this.e, 0);
    a.a(this.e, 1010, this.a);
    com.tencent.tpns.mqttchannel.core.common.c.a.a("IMqttServiceImpl", "sendRequest onSuccess topic:" + this.b + " body: " + this.c.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.b.a.17
 * JD-Core Version:    0.7.0.1
 */