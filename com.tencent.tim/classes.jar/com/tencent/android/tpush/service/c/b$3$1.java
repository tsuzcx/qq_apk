package com.tencent.android.tpush.service.c;

import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

class b$3$1
  extends OnMqttCallback
{
  b$3$1(b.3 param3) {}
  
  public void callback(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.a.a.a();
      return;
    }
    this.a.a.a(paramInt, "mqtt connect error:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.c.b.3.1
 * JD-Core Version:    0.7.0.1
 */