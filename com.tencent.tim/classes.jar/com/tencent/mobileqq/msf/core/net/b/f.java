package com.tencent.mobileqq.msf.core.net.b;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ak;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  extends Thread
{
  private static final String f = "ReqAllFailSocket";
  private static final int g = 10000;
  protected boolean a = false;
  protected boolean b = false;
  protected boolean c = false;
  protected long d = 0L;
  protected long e = 0L;
  private Socket h;
  private OutputStream i;
  private InputStream j;
  private AtomicBoolean k = new AtomicBoolean(false);
  private AtomicBoolean l = new AtomicBoolean(false);
  private d m;
  private LinkedBlockingDeque n = new LinkedBlockingDeque(1000);
  private long o = 0L;
  private String p = "";
  private MsfCore q;
  private int r;
  
  public f(MsfCore paramMsfCore, d paramd, int paramInt)
  {
    this.q = paramMsfCore;
    this.m = paramd;
    this.r = paramInt;
  }
  
  private int a(String paramString, MsfCommand paramMsfCommand, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      try
      {
        this.i.write(paramArrayOfByte);
        this.i.flush();
        QLog.d("ReqAllFailSocket", 1, this.r + " send " + paramString);
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        d();
      }
    }
  }
  
  private boolean c()
  {
    InetSocketAddress localInetSocketAddress = new InetSocketAddress(this.m.c(), this.m.f());
    try
    {
      this.h = new Socket();
      this.h.setTcpNoDelay(true);
      this.h.setKeepAlive(true);
      this.h.connect(localInetSocketAddress, this.m.g());
      this.i = this.h.getOutputStream();
      this.j = this.h.getInputStream();
      this.k.set(true);
      this.c = true;
      this.o = SystemClock.elapsedRealtime();
      QLog.d("ReqAllFailSocket", 1, this.r + " conn " + this.m.c() + ":" + this.m.f() + " succ");
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.p = "connFail";
      QLog.d("ReqAllFailSocket", 1, this.r + " conn " + this.m.c() + ":" + this.m.f() + " fail");
    }
    return false;
  }
  
  private void d()
  {
    QLog.d("ReqAllFailSocket", 1, this.r + " closeConn");
    if (this.h != null) {}
    try
    {
      this.h.close();
      this.h = null;
      localAtomicBoolean1 = this.k;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AtomicBoolean localAtomicBoolean1;
        localException.printStackTrace();
        this.h = null;
        AtomicBoolean localAtomicBoolean2 = this.k;
      }
    }
    finally
    {
      this.h = null;
      this.k.set(false);
    }
    localAtomicBoolean1.set(false);
  }
  
  private void e()
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
    localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
    localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    localToServiceMsg.setAppId(this.q.getMsfAppid());
    localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
    a(localToServiceMsg);
  }
  
  private void f()
  {
    int i1 = "MSF".getBytes().length + 13 + 1 + 0 + 4;
    int i2 = StringUtils.str2Int(MsfService.getCore().getAccountCenter().i(), 0);
    byte b1 = (byte)"MSF".getBytes().length;
    Object localObject = ByteBuffer.allocate(i1);
    ((ByteBuffer)localObject).putInt(i1).putInt(20200918).putInt(i2).put(b1).put("MSF".getBytes()).put((byte)0).putInt(0);
    localObject = ((ByteBuffer)localObject).array();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Crypt.ping.ReqAllFailSocket", 2, "sendSSOPing, cmd = " + "MSF" + ", s = " + StringUtils.bytes2Str((byte[])localObject));
      }
      a("MSF", MsfCommand.msf_ssoping, (byte[])localObject);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a()
  {
    d();
    this.l.set(true);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      this.n.add(paramToServiceMsg);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      QLog.d("ReqAllFailSocket", 1, "addSendQueu fail,", paramToServiceMsg);
    }
  }
  
  public String b()
  {
    return this.m.c() + "|" + this.m.f() + "|" + this.a + "|" + this.b + "|" + this.p + "|" + this.c + "|" + this.d + "|" + this.e;
  }
  
  public void run()
  {
    if (c())
    {
      new b(null).start();
      new a(null).start();
      f();
      e();
    }
  }
  
  class a
    extends Thread
  {
    private a() {}
    
    public void run()
    {
      for (;;)
      {
        int j;
        try
        {
          DataInputStream localDataInputStream = new DataInputStream(f.e(f.this));
          i = 0;
          if ((f.c(f.this).get()) || (!f.a(f.this).get()))
          {
            if (i > 0) {
              break label215;
            }
            j = localDataInputStream.readInt() - 4;
            if (j <= 33)
            {
              f.this.a = true;
              f.this.d = (SystemClock.elapsedRealtime() - f.f(f.this));
              QLog.d("ReqAllFailSocket", 1, f.g(f.this) + " recv sso ping");
              i = j;
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          f.a(f.this, "readError");
          f.d(f.this);
        }
        int i = j;
        if (j == 62)
        {
          f.this.b = true;
          f.this.e = (SystemClock.elapsedRealtime() - f.f(f.this));
          QLog.d("ReqAllFailSocket", 1, f.g(f.this) + " recv heartbeat ping");
          i = j;
          continue;
          label215:
          localThrowable.readByte();
          i -= 1;
        }
      }
    }
  }
  
  class b
    extends Thread
  {
    private b() {}
    
    public void run()
    {
      ToServiceMsg localToServiceMsg;
      String str;
      for (;;)
      {
        if (f.a(f.this).get()) {
          return;
        }
        try
        {
          localToServiceMsg = (ToServiceMsg)f.b(f.this).take();
          str = localToServiceMsg.getServiceCmd();
          localObject = null;
        }
        catch (Throwable localThrowable)
        {
          Object localObject;
          byte[] arrayOfByte2;
          label43:
          label90:
          localThrowable.printStackTrace();
          f.d(f.this);
        }
        try
        {
          arrayOfByte2 = ak.b(localToServiceMsg, 0);
          localObject = arrayOfByte2;
        }
        catch (Exception localException)
        {
          QLog.d("ReqAllFailSocket", 1, "", localException);
          break label43;
          if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion())) {
            break label212;
          }
          byte[] arrayOfByte1 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, localThrowable, null, localToServiceMsg.getWupBuffer(), true);
          break label90;
          arrayOfByte1 = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, (byte)0, arrayOfByte1, null, localToServiceMsg.getWupBuffer(), true);
          break label90;
        }
        if (591 != CodecWarpper.getSharedObjectVersion()) {
          break;
        }
        localObject = CodecWarpper.nativeEncodeRequest(localToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", str, null, localToServiceMsg.getAppId(), 0, localToServiceMsg.getUin(), (byte)0, (byte)0, localToServiceMsg.getWupBuffer(), true);
        if (f.c(f.this).get()) {
          f.a(f.this, localToServiceMsg.getServiceCmd(), localToServiceMsg.getMsfCommand(), (byte[])localObject);
        }
      }
      label212:
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.f
 * JD-Core Version:    0.7.0.1
 */