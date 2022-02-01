package com.tencent.mm.sdk.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.token.pq;
import java.util.HashMap;
import java.util.Map;

public final class MMessage
{
  public static final class Receiver
    extends BroadcastReceiver
  {
    public static final Map<String, MMessage.a> a = new HashMap();
    private final MMessage.a b = null;
    
    public Receiver()
    {
      this((byte)0);
    }
    
    private Receiver(byte paramByte) {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      pq.c("MicroMsg.SDK.MMessage", "receive intent=".concat(String.valueOf(paramIntent)));
      if (this.b != null)
      {
        pq.c("MicroMsg.SDK.MMessage", "mm message self-handled");
        return;
      }
      if ((MMessage.a)a.get(paramIntent.getAction()) != null) {
        pq.c("MicroMsg.SDK.MMessage", "mm message handled");
      }
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessage
 * JD-Core Version:    0.7.0.1
 */