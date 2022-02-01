package com.tencent.token;

import android.content.Context;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class aty
{
  Context a;
  protected atr b;
  public aua c;
  private byte e = 0;
  private boolean f = true;
  private boolean g = true;
  private Thread h;
  private Socket i;
  private DataOutputStream j;
  private DataInputStream k;
  private att l;
  
  private aty() {}
  
  public aty(byte paramByte)
  {
    this();
  }
  
  private boolean a(atr paramatr)
  {
    int m = 0;
    boolean bool = false;
    while (m < 3)
    {
      att localatt = paramatr.a();
      if (localatt == null) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder("checkSocketWithRetry() before checkSocket(ipPoint) ipPoint ");
      localStringBuilder.append(localatt.toString());
      localStringBuilder.append(" localIp ");
      localStringBuilder.append(e());
      localStringBuilder.append(" localPort ");
      localStringBuilder.append(f());
      bool = a(localatt);
      localStringBuilder = new StringBuilder("checkSocketWithRetry() after checkSocket(ipPoint) ipPoint ");
      localStringBuilder.append(localatt.toString());
      localStringBuilder.append(" localIp ");
      localStringBuilder.append(e());
      localStringBuilder.append(" localPort ");
      localStringBuilder.append(f());
      localStringBuilder.append(" ret ");
      localStringBuilder.append(bool);
      if (bool) {
        break;
      }
      m += 1;
    }
    return bool;
  }
  
  private boolean a(att paramatt)
  {
    if (paramatt == null) {
      return false;
    }
    if (a()) {
      return true;
    }
    for (;;)
    {
      try
      {
        if (!d()) {
          c();
        }
        this.l = paramatt;
        InetAddress localInetAddress = InetAddress.getByName(paramatt.b);
        int m = paramatt.a;
        paramatt = new StringBuilder("acquireSocketWithTimeOut, addr: ");
        paramatt.append(localInetAddress);
        paramatt.append(", port: ");
        paramatt.append(m);
        paramatt = new Socket();
        paramatt.setSoLinger(false, 0);
        paramatt.connect(new InetSocketAddress(localInetAddress, m), 60000);
        this.i = paramatt;
        if (this.i == null) {
          return false;
        }
        switch (this.e)
        {
        case 1: 
          this.i.setSoTimeout(60000);
          break;
        case 0: 
          this.j = new DataOutputStream(this.i.getOutputStream());
          this.k = new DataInputStream(this.i.getInputStream());
          boolean bool = a();
          return bool;
        }
      }
      catch (Throwable paramatt)
      {
        new StringBuilder("checkSocket() Throwable ").append(paramatt.toString());
        return false;
      }
      catch (SocketTimeoutException paramatt)
      {
        new StringBuilder("checkSocket() SocketTimeoutException ").append(paramatt.toString());
        return false;
      }
      catch (UnknownHostException paramatt)
      {
        new StringBuilder("checkSocket() UnknownHostException ").append(paramatt.toString());
        return false;
      }
    }
  }
  
  private static byte[] a(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i1 = 0;
    int m = paramInt;
    int n = 0;
    while ((i1 < paramInt) && (m > 0))
    {
      int i2 = paramInputStream.read(arrayOfByte, n, m);
      if (i2 < 0) {
        break;
      }
      i1 += i2;
      n += i2;
      m -= i2;
    }
    if (i1 != paramInt) {
      return null;
    }
    return arrayOfByte;
  }
  
  private int b(byte[] paramArrayOfByte)
  {
    if ((!d) && (this.e != 0)) {
      throw new AssertionError();
    }
    if ((!d) && (this.j == null)) {
      throw new AssertionError("mSocketWriter is null");
    }
    try
    {
      synchronized (this.i)
      {
        if (!a()) {
          return -180000;
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeInt(paramArrayOfByte.length);
        localDataOutputStream.write(paramArrayOfByte);
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        new StringBuilder("sendDataInAsync() realSendData.lenght ").append(paramArrayOfByte.length);
        this.j.write(paramArrayOfByte);
        return 0;
      }
      return -120000;
    }
    catch (Throwable paramArrayOfByte)
    {
      new StringBuilder("sendDataInAsync() has a Throwable when sendDataInAsync() t ").append(paramArrayOfByte.toString());
      return -150000;
    }
    catch (SocketException paramArrayOfByte)
    {
      new StringBuilder("sendDataInAsync() has a Throwable when sendDataInAsync() e ").append(paramArrayOfByte.toString());
    }
  }
  
  private boolean b()
  {
    return !this.g;
  }
  
  private int c(byte[] paramArrayOfByte)
  {
    if ((!d) && (1 != this.e)) {
      throw new AssertionError();
    }
    try
    {
      this.j.writeInt(paramArrayOfByte.length);
      this.j.write(paramArrayOfByte);
      return 0;
    }
    catch (Throwable paramArrayOfByte)
    {
      new StringBuilder("sendDataInSync() has a Throwable when sendDataInsync() ").append(paramArrayOfByte.toString());
    }
    return -150000;
  }
  
  private boolean c()
  {
    if (d()) {
      return true;
    }
    if (!this.i.isInputShutdown()) {
      try
      {
        this.i.shutdownInput();
      }
      catch (Exception localException1)
      {
        new StringBuilder("stopSocket() mSocket.shutdownInput() ").append(localException1);
      }
    }
    try
    {
      this.k.close();
      label52:
      if (!this.i.isOutputShutdown()) {
        try
        {
          this.i.shutdownOutput();
        }
        catch (Exception localException2)
        {
          new StringBuilder("stopSocket() mSocket.shutdownOutput() ").append(localException2);
        }
      }
      try
      {
        this.j.close();
      }
      catch (Exception localException3)
      {
        new StringBuilder("stopSocket() mSocketWriter.close() ").append(localException3);
      }
      try
      {
        this.i.close();
        this.i = null;
        Thread.sleep(2000L);
        return true;
      }
      catch (IOException localIOException)
      {
        new StringBuilder("stopSocket() mSocket.close() ").append(localIOException);
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        new StringBuilder("stopSocket() InterruptedException ").append(localInterruptedException);
        return true;
      }
    }
    catch (Exception localException4)
    {
      break label52;
    }
  }
  
  private boolean d()
  {
    Socket localSocket = this.i;
    if (localSocket == null) {
      return true;
    }
    return (localSocket != null) && (localSocket.isClosed());
  }
  
  private String e()
  {
    Socket localSocket = this.i;
    if (localSocket == null) {
      return "null";
    }
    return localSocket.getLocalAddress().toString();
  }
  
  private int f()
  {
    Socket localSocket = this.i;
    if (localSocket == null) {
      return 0;
    }
    return localSocket.getLocalPort();
  }
  
  private static NetworkInfo g()
  {
    try
    {
      NetworkInfo localNetworkInfo = arq.a().a();
      return localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      new StringBuilder(" getActiveNetworkInfo NullPointerException--- \n").append(localNullPointerException.getMessage());
    }
    return null;
  }
  
  public final int a(byte[] paramArrayOfByte)
  {
    if (d()) {
      return -190000;
    }
    if (!a()) {
      return -180000;
    }
    switch (this.e)
    {
    default: 
      return -200000;
    case 1: 
      return c(paramArrayOfByte);
    }
    return b(paramArrayOfByte);
  }
  
  protected final boolean a()
  {
    if (this.i == null) {
      return false;
    }
    return (!d()) && (this.i.isConnected());
  }
  
  public final boolean a(Context paramContext, atr paramatr)
  {
    try
    {
      if (b())
      {
        new StringBuilder("start() isStarted() ").append(b());
        return true;
      }
      if (paramatr == null) {
        return false;
      }
      this.a = paramContext;
      paramContext = g();
      if (paramContext == null) {
        bool = false;
      } else {
        bool = paramContext.isConnected();
      }
      if (!bool) {
        return false;
      }
      this.b = paramatr;
      boolean bool = a(this.b);
      if (!bool) {
        return false;
      }
      this.g = false;
      if (this.e == 0)
      {
        this.h = new atz(this, "RcvThread");
        this.h.setPriority(10);
        this.h.start();
      }
      return true;
    }
    finally {}
  }
  
  final boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("stop() bySvr ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isRestart ");
      localStringBuilder.append(paramBoolean2);
      boolean bool = c();
      if (!bool) {
        return false;
      }
      this.g = true;
      localStringBuilder = new StringBuilder("stop() bySvr ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isRestart ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" stop() done");
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aty
 * JD-Core Version:    0.7.0.1
 */