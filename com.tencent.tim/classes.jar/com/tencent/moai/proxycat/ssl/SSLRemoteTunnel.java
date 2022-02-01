package com.tencent.moai.proxycat.ssl;

import com.tencent.moai.proxycat.tunnel.RemoteTunnel;
import java.io.IOException;
import java.nio.channels.Selector;

public class SSLRemoteTunnel
  extends RemoteTunnel
{
  private static final String TAG = "SSLRemoteTunnel";
  
  public SSLRemoteTunnel(Selector paramSelector)
    throws IOException
  {
    super(paramSelector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.ssl.SSLRemoteTunnel
 * JD-Core Version:    0.7.0.1
 */