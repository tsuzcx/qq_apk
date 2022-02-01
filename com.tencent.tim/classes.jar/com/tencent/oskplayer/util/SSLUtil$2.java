package com.tencent.oskplayer.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class SSLUtil$2
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    PlayerUtils.log(3, "SSLUtil", "verifying " + paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.SSLUtil.2
 * JD-Core Version:    0.7.0.1
 */