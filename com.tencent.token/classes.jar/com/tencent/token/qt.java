package com.tencent.token;

import com.tencent.mm.sdk.plugin.MMPluginOAuth;
import com.tencent.mm.sdk.plugin.MMPluginOAuth.Receiver;

public final class qt
  implements Runnable
{
  public qt(MMPluginOAuth.Receiver paramReceiver, MMPluginOAuth paramMMPluginOAuth, String paramString) {}
  
  public final void run()
  {
    MMPluginOAuth localMMPluginOAuth = this.a;
    String str = this.b;
    MMPluginOAuth.Receiver.a(localMMPluginOAuth.b);
    localMMPluginOAuth.a = str;
    qk.b("MicroMsg.SDK.MMPluginOAuth", "access token: ".concat(String.valueOf(str)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qt
 * JD-Core Version:    0.7.0.1
 */