package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.minigame.proxy.MiniGameCmdProxyImpl;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import java.util.HashMap;
import java.util.Map;

public final class GameProxyServiceScope
{
  public static final Map PROXY_SERVICES = new HashMap();
  
  static
  {
    PROXY_SERVICES.put(CmdProxy.class, MiniGameCmdProxyImpl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.GameProxyServiceScope
 * JD-Core Version:    0.7.0.1
 */