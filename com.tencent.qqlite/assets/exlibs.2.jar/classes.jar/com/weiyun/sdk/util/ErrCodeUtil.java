package com.weiyun.sdk.util;

import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrCodeUtil
{
  public static int getErrCodeFromIOException(IOException paramIOException)
  {
    int j = -30008;
    int i;
    if ((paramIOException instanceof ConnectException))
    {
      paramIOException = paramIOException.getMessage();
      if ((paramIOException != null) && (paramIOException.indexOf("Network is unreachable") >= 0)) {
        i = -10003;
      }
    }
    do
    {
      do
      {
        return i;
        return -30010;
        if ((paramIOException instanceof MalformedURLException)) {
          return -30026;
        }
        if ((paramIOException instanceof SocketTimeoutException)) {
          return -30002;
        }
        if ((paramIOException instanceof UnknownHostException)) {
          return -30012;
        }
        if ((paramIOException instanceof ProtocolException)) {
          return -30013;
        }
        if ((paramIOException instanceof PortUnreachableException)) {
          return -30014;
        }
        if ((paramIOException instanceof NoRouteToHostException)) {
          return -30015;
        }
        if ((paramIOException instanceof EOFException)) {
          return -30016;
        }
        i = j;
      } while ((paramIOException instanceof BindException));
      if (!(paramIOException instanceof SocketException)) {
        break;
      }
      paramIOException = paramIOException.getMessage();
      if (paramIOException == null) {
        return -30018;
      }
      paramIOException = paramIOException.toLowerCase();
      if (Pattern.compile("etimedout").matcher(paramIOException).matches()) {
        return -30001;
      }
      if (Pattern.compile("socket.*is.*closed").matcher(paramIOException).matches()) {
        return -30003;
      }
      if (Pattern.compile("connect.*reset.*by.*peer").matcher(paramIOException).matches()) {
        return -30005;
      }
      if (Pattern.compile("connect.*reset").matcher(paramIOException).matches()) {
        return -30004;
      }
      if (Pattern.compile("broken.*pipe").matcher(paramIOException).matches()) {
        return -30006;
      }
      if (Pattern.compile("connection.*refused").matcher(paramIOException).matches()) {
        return -30011;
      }
      if (Pattern.compile("too.*many.*open.*files").matcher(paramIOException).matches()) {
        return -30007;
      }
      if (Pattern.compile("address.*family").matcher(paramIOException).matches()) {
        return -30009;
      }
      i = j;
    } while (Pattern.compile("jvm_bind").matcher(paramIOException).matches());
    do
    {
      return -30023;
      if ((paramIOException instanceof ClosedByInterruptException)) {
        return -30020;
      }
      if ((paramIOException instanceof AsynchronousCloseException)) {
        return -30019;
      }
      if ((paramIOException instanceof ClosedChannelException)) {
        return -30022;
      }
      paramIOException = paramIOException.getMessage();
      if (paramIOException == null) {
        return -30023;
      }
      if (paramIOException.indexOf("unexpected end of stream") >= 0) {
        return -30027;
      }
    } while (!paramIOException.contains("No space left on device"));
    return -10008;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.ErrCodeUtil
 * JD-Core Version:    0.7.0.1
 */