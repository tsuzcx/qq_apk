package com.tencent.moai.mailsdk.protocol.auth;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.PrivilegedAction;

final class NtlmHandShakeAuthentionInterceptor$1
  implements PrivilegedAction<String>
{
  public String run()
  {
    try
    {
      String str = InetAddress.getLocalHost().getHostName();
      return str;
    }
    catch (UnknownHostException localUnknownHostException) {}
    return "localhost";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.auth.NtlmHandShakeAuthentionInterceptor.1
 * JD-Core Version:    0.7.0.1
 */