package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.token.utils.UserTask;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class xh
{
  private static String[] A;
  private static int[] B;
  static xh a;
  private static int x;
  private int C = 10;
  private int D = 300000;
  private int E = 300000;
  private int F = 0;
  private final int[] G = { 1000, 10000, 30000, 90000, 180000, 300000 };
  private final int H = 3000;
  private final int I = 3000;
  public final byte b = 0;
  public final byte c = 1;
  byte[] d = null;
  HandlerThread e;
  Handler f;
  private final long g = 2L;
  private final abo h = new abo("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private abo i = new abo("-1");
  private byte[] j;
  private String k = "";
  private final int l = 0;
  private final int m = 1;
  private final int n = 101;
  private final int o = 102;
  private final int p = 103;
  private final int q = 104;
  private final int r = 105;
  private final int s = 106;
  private final int t = 107;
  private final int u = 108;
  private final int v = 109;
  private Socket w = null;
  private long y;
  private long z;
  
  private int a(InputStream paramInputStream, boolean paramBoolean)
  {
    Object localObject;
    byte[] arrayOfByte;
    int i2;
    int i1;
    if (paramInputStream != null)
    {
      localObject = this.w;
      if (localObject != null)
      {
        try
        {
          ((Socket)localObject).setSoTimeout(3000);
          if (paramBoolean) {
            paramInputStream.skip(paramInputStream.available());
          }
          arrayOfByte = new byte[5];
          paramInputStream.read(arrayOfByte);
          i3 = tl.a(arrayOfByte, 1);
          if (i3 <= 42)
          {
            xv.c("socket rsp msg len not correct: ".concat(String.valueOf(i3)));
            return -1;
          }
          i2 = tl.a(arrayOfByte, 3);
          localObject = new byte[i3];
          i1 = 0;
        }
        catch (Exception paramInputStream)
        {
          int i3;
          paramInputStream.printStackTrace();
          localObject = new StringBuilder("socket decodeInputSream failed");
          ((StringBuilder)localObject).append(paramInputStream.toString());
          xv.c(((StringBuilder)localObject).toString());
          d();
          return -2;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          localObject = new StringBuilder("socket decodeInputSream failed");
          ((StringBuilder)localObject).append(paramInputStream.toString());
          xv.c(((StringBuilder)localObject).toString());
          d();
          return -2;
        }
        paramInputStream.read((byte[])localObject, 5, i3 - 5);
        xv.a("socket pkg type: ".concat(String.valueOf(i2)));
        i1 = -4;
        if (i2 != 4) {}
        switch (i2)
        {
        case 202: 
          paramInputStream = new xn();
          i2 = xj.a((byte[])localObject, i3, paramInputStream);
          if (i2 == 0)
          {
            if (i3 > 434)
            {
              i2 = i1;
            }
            else
            {
              paramInputStream.m = tl.b((byte[])localObject, 41);
              paramInputStream.n = tl.b((byte[])localObject, 45);
              i1 = tl.a((byte[])localObject, 49);
              paramInputStream.o = new byte[i1];
              tl.b((byte[])localObject, 51, paramInputStream.o, i1);
              i1 += 51;
              i2 = tl.a((byte[])localObject, i1);
              paramInputStream.p = new byte[i2];
              tl.b((byte[])localObject, i1 + 2, paramInputStream.p, i2);
              localObject = new StringBuilder("socket parse client verify: ret[");
              ((StringBuilder)localObject).append(paramInputStream.m);
              ((StringBuilder)localObject).append("] server_time[");
              ((StringBuilder)localObject).append(paramInputStream.n);
              ((StringBuilder)localObject).append("] sig_len[");
              ((StringBuilder)localObject).append(i2);
              ((StringBuilder)localObject).append("] sig[");
              ((StringBuilder)localObject).append(new String(paramInputStream.p));
              ((StringBuilder)localObject).append("]");
              xv.a(((StringBuilder)localObject).toString());
              i2 = (int)paramInputStream.m;
            }
            if ((i2 != 0) && (paramInputStream.n > 0L))
            {
              System.currentTimeMillis();
              rt.a().a(paramInputStream.n);
            }
            i1 = i2;
            if (i2 == 0)
            {
              this.k = new String(paramInputStream.p);
              i1 = i2;
            }
          }
          break;
        case 201: 
          paramInputStream = new xk();
          i2 = xj.a((byte[])localObject, i3, paramInputStream);
          if (i2 == 0)
          {
            if (i3 > 434)
            {
              i2 = i1;
            }
            else
            {
              paramInputStream.n = tl.b((byte[])localObject, 41);
              i1 = tl.a((byte[])localObject, 45);
              paramInputStream.o = new byte[i1];
              tl.b((byte[])localObject, 47, paramInputStream.o, i1);
              i1 += 47;
              i2 = tl.a((byte[])localObject, i1);
              paramInputStream.m = new byte[i2];
              tl.b((byte[])localObject, i1 + 2, paramInputStream.m, i2);
              localObject = new StringBuilder("socket parse exchange key: ret[");
              ((StringBuilder)localObject).append(paramInputStream.n);
              ((StringBuilder)localObject).append("] spKeyLen[");
              ((StringBuilder)localObject).append(i2);
              ((StringBuilder)localObject).append("] spKey[");
              ((StringBuilder)localObject).append(new String(paramInputStream.m));
              ((StringBuilder)localObject).append("]");
              xv.a(((StringBuilder)localObject).toString());
              i2 = (int)paramInputStream.n;
            }
            i1 = i2;
            if (i2 == 0)
            {
              paramInputStream = new abo(new String(paramInputStream.m), 16);
              this.j = abs.a(this.i, paramInputStream, this.h);
              i1 = i2;
              if (this.j == null)
              {
                i1 = 1;
                break;
                paramInputStream = new xm();
                i2 = xj.a((byte[])localObject, i3, paramInputStream);
                if (i2 != 0) {
                  break label1032;
                }
                if (i3 > 1102)
                {
                  i2 = i1;
                }
                else
                {
                  paramInputStream.m = tl.a((byte[])localObject, 41);
                  paramInputStream.n = new byte[paramInputStream.m];
                  tl.b((byte[])localObject, 43, paramInputStream.n, paramInputStream.m);
                  i2 = 0;
                }
                i1 = i2;
                if (i2 == 0)
                {
                  this.d = a(paramInputStream.n);
                  if (this.d == null) {
                    this.d = a(paramInputStream.n);
                  }
                  i1 = i2;
                  if (this.d == null) {
                    break label1026;
                  }
                }
              }
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        if ((i1 != 1) && (i1 != 103))
        {
          if (i1 != 106)
          {
            if (i1 != 109)
            {
              c();
              x = 7;
              return i1;
            }
            d();
            return i1;
          }
          c();
          x = 8;
          return i1;
        }
        c();
        x = 6;
        this.z = System.currentTimeMillis();
      }
      return i1;
      d();
      return -2;
      while (i1 < 5)
      {
        localObject[i1] = arrayOfByte[i1];
        i1 += 1;
      }
      break label1026;
      i1 = i2;
      continue;
      i1 = i2;
      continue;
      label1026:
      i1 = 101;
      continue;
      label1032:
      i1 = i2;
    }
  }
  
  public static xh a()
  {
    if (a == null)
    {
      a = new xh();
      x = 0;
    }
    return a;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new abr().a(paramArrayOfByte, this.j);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      xv.c(paramArrayOfByte.toString());
    }
    return null;
  }
  
  private xl b(final Handler paramHandler)
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        public final void run()
        {
          if (xh.d(xh.this) == null)
          {
            xh.this.d();
            return;
          }
          Object localObject1 = xh.this;
          ((xh)localObject1).d = null;
          try
          {
            localObject1 = xh.d((xh)localObject1).getOutputStream();
            localObject2 = xh.d(xh.this).getInputStream();
            long l = System.currentTimeMillis();
            Object localObject3;
            if (l - xh.k(xh.this) >= xh.l(xh.this))
            {
              xv.a("socket send heart break: ".concat(String.valueOf(l)));
              xh.b(xh.this, l);
              localObject3 = new xi((short)3, (byte)0);
              ((xi)localObject3).l = new byte[5];
              byte[] arrayOfByte = ((xi)localObject3).l;
              xr.b();
              arrayOfByte[0] = 4;
              arrayOfByte = ((xi)localObject3).l;
              xr.c();
              arrayOfByte[1] = 2;
              tl.a(((xi)localObject3).l, 2, xr.d());
              ((xi)localObject3).l[4] = 0;
              ((OutputStream)localObject1).write(((xi)localObject3).a());
              ((OutputStream)localObject1).flush();
            }
            if ((((InputStream)localObject2).available() > 0) && (xh.a(xh.this, (InputStream)localObject2, false) != 0)) {
              return;
            }
            if (xh.this.d != null)
            {
              localObject2 = new StringBuilder("socket decrypt len: ");
              ((StringBuilder)localObject2).append(xh.this.d.length);
              xv.a(((StringBuilder)localObject2).toString());
              localObject2 = new xl();
              localObject3 = xh.this.d;
              ((xl)localObject2).a = (((localObject3[4] & 0xFF) << 56) + ((localObject3[5] & 0xFF) << 48) + ((localObject3[6] & 0xFF) << 40) + ((localObject3[7] & 0xFF) << 32) + ((localObject3[0] & 0xFF) << 24) + ((localObject3[1] & 0xFF) << 16) + ((localObject3[2] & 0xFF) << 8) + (0xFF & localObject3[3]));
              int i = tl.a(xh.this.d, 8);
              ((xl)localObject2).b = new byte[i];
              tl.b(xh.this.d, 10, ((xl)localObject2).b, i);
              i += 10;
              ((xl)localObject2).c = tl.b(xh.this.d, i);
              i += 4;
              ((xl)localObject2).d = xh.this.d[i];
              i += 1;
              ((xl)localObject2).e = xh.this.d[i];
              i += 1;
              ((xl)localObject2).f = tl.b(xh.this.d, i);
              int j = i + 4;
              i = tl.a(xh.this.d, j);
              j += 2;
              ((xl)localObject2).g = new byte[i];
              tl.b(xh.this.d, j, ((xl)localObject2).g, i);
              i = j + i;
              j = tl.a(xh.this.d, i);
              ((xl)localObject2).h = new byte[j];
              tl.b(xh.this.d, i + 2, ((xl)localObject2).h, j);
              localObject3 = new StringBuilder("socket msg time: ");
              ((StringBuilder)localObject3).append(((xl)localObject2).f);
              ((StringBuilder)localObject3).append(" id: ");
              ((StringBuilder)localObject3).append(((xl)localObject2).c);
              ((StringBuilder)localObject3).append(" uin: ");
              ((StringBuilder)localObject3).append(new String(((xl)localObject2).b));
              ((StringBuilder)localObject3).append(" type: ");
              ((StringBuilder)localObject3).append(((xl)localObject2).d);
              ((StringBuilder)localObject3).append(" subType: ");
              ((StringBuilder)localObject3).append(((xl)localObject2).e);
              ((StringBuilder)localObject3).append(" title: ");
              ((StringBuilder)localObject3).append(new String(((xl)localObject2).g));
              ((StringBuilder)localObject3).append(" content: ");
              ((StringBuilder)localObject3).append(new String(((xl)localObject2).h));
              xv.a(((StringBuilder)localObject3).toString());
              localObject3 = new xi((short)203, (byte)0);
              ((xi)localObject3).l = new byte[6];
              tl.a(((xi)localObject3).l, 0, 0L);
              tl.a(((xi)localObject3).l, 4, (short)0);
              tl.a(((xi)localObject3).l, 6, "".getBytes(), 0);
              localObject3 = ((xi)localObject3).a();
              try
              {
                ((OutputStream)localObject1).write((byte[])localObject3);
                ((OutputStream)localObject1).flush();
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
              catch (IOException localIOException1)
              {
                localIOException1.printStackTrace();
              }
              if (paramHandler != null)
              {
                Message localMessage = new Message();
                localMessage.what = 4014;
                localMessage.obj = localObject2;
                paramHandler.sendMessage(localMessage);
              }
              return;
            }
            return;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            localObject2 = new StringBuilder("socket client goToHeartBreakAndGetPushMsgfailed");
            ((StringBuilder)localObject2).append(localException2.toString());
            xv.c(((StringBuilder)localObject2).toString());
            xh.this.d();
            return;
          }
          catch (IOException localIOException2)
          {
            localIOException2.printStackTrace();
            Object localObject2 = new StringBuilder("socket client goToHeartBreakAndGetPushMsg failed");
            ((StringBuilder)localObject2).append(localIOException2.toString());
            xv.c(((StringBuilder)localObject2).toString());
            xh.this.d();
          }
        }
      });
      return null;
    }
    catch (Error paramHandler)
    {
      return null;
    }
    catch (Exception paramHandler) {}
    return null;
  }
  
  public static void b()
  {
    a = null;
  }
  
  private void g()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        public final void run()
        {
          if (xh.d(xh.this) == null)
          {
            xh.this.d();
            return;
          }
          xh.a(xh.this, abs.a());
          Object localObject1 = abs.a(xh.g(xh.this), xh.h(xh.this));
          if ((xh.g(xh.this) != null) && (localObject1 != null) && (((String)localObject1).length() != 0))
          {
            Object localObject2 = new xi((short)1, (byte)0);
            int i = ((String)localObject1).length();
            Object localObject3 = new StringBuilder("socket make exchange key req pubkey: ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", len:");
            ((StringBuilder)localObject3).append(((String)localObject1).length());
            xv.a(((StringBuilder)localObject3).toString());
            ((xi)localObject2).l = new byte[i + 6];
            localObject3 = ((xi)localObject2).l;
            xr.b();
            localObject3[0] = 4;
            localObject3 = ((xi)localObject2).l;
            xr.c();
            localObject3[1] = 2;
            tl.a(((xi)localObject2).l, 2, xr.d());
            tl.a(((xi)localObject2).l, 4, (short)((String)localObject1).length());
            tl.a(((xi)localObject2).l, 6, ((String)localObject1).getBytes(), ((String)localObject1).length());
            localObject2 = ((xi)localObject2).a();
            try
            {
              localObject3 = xh.d(xh.this).getOutputStream();
              localObject1 = xh.d(xh.this).getInputStream();
              ((OutputStream)localObject3).write((byte[])localObject2);
              ((OutputStream)localObject3).flush();
              localObject2 = new StringBuilder("socket available: ");
              ((StringBuilder)localObject2).append(((InputStream)localObject1).available());
              xv.a(((StringBuilder)localObject2).toString());
              i = xh.a(xh.this, (InputStream)localObject1, false);
              if (i != 0) {
                return;
              }
              xh.b(3);
              xh.i(xh.this);
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localObject2 = new StringBuilder("socket exchange key failed");
              ((StringBuilder)localObject2).append(localException.toString());
              xv.c(((StringBuilder)localObject2).toString());
              xh.this.d();
              return;
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
              localObject2 = new StringBuilder("socket exchange key failed");
              ((StringBuilder)localObject2).append(localIOException.toString());
              xv.c(((StringBuilder)localObject2).toString());
              xh.this.d();
              return;
            }
          }
          xh.this.c();
          xh.b(6);
          xh.a(xh.this, System.currentTimeMillis());
        }
      });
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
  }
  
  private void h()
  {
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        public final void run()
        {
          if (xh.d(xh.this) == null)
          {
            xh.this.d();
            return;
          }
          long l = Long.parseLong(rt.a().b());
          Object localObject1 = sv.a();
          Object localObject2 = rt.a().e();
          Object localObject3 = new byte[((String)localObject2).length() + 10 + 2 + ((String)localObject1).length() + 2 + xh.j(xh.this).length()];
          localObject3[0] = ((byte)(int)(l >> 56));
          localObject3[1] = ((byte)(int)(l >> 48));
          localObject3[2] = ((byte)(int)(l >> 40));
          localObject3[3] = ((byte)(int)(l >> 32));
          localObject3[4] = ((byte)(int)(l >> 24));
          localObject3[5] = ((byte)(int)(l >> 16));
          localObject3[6] = ((byte)(int)(l >> 8));
          localObject3[7] = ((byte)(int)l);
          tl.a((byte[])localObject3, 8, (short)((String)localObject2).length());
          tl.a((byte[])localObject3, 10, ((String)localObject2).getBytes(), ((String)localObject2).length());
          int i = ((String)localObject2).length() + 10;
          tl.a((byte[])localObject3, i, (short)((String)localObject1).length());
          i += 2;
          tl.a((byte[])localObject3, i, ((String)localObject1).getBytes(), ((String)localObject1).length());
          i += ((String)localObject1).length();
          tl.a((byte[])localObject3, i, (short)xh.j(xh.this).length());
          tl.a((byte[])localObject3, i + 2, xh.j(xh.this).getBytes(), xh.j(xh.this).length());
          localObject2 = xh.a(xh.this, (byte[])localObject3);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = xh.a(xh.this, (byte[])localObject3);
          }
          if (localObject1 == null)
          {
            xh.this.c();
            xh.b(7);
            return;
          }
          localObject2 = new xi((short)2, (byte)1);
          ((xi)localObject2).l = new byte[localObject1.length + 2];
          tl.a(((xi)localObject2).l, 0, (short)localObject1.length);
          tl.a(((xi)localObject2).l, 2, (byte[])localObject1, localObject1.length);
          localObject2 = ((xi)localObject2).a();
          try
          {
            localObject3 = xh.d(xh.this).getOutputStream();
            localObject1 = xh.d(xh.this).getInputStream();
            ((OutputStream)localObject3).write((byte[])localObject2);
            ((OutputStream)localObject3).flush();
            localObject2 = new StringBuilder("socket available: ");
            ((StringBuilder)localObject2).append(((InputStream)localObject1).available());
            xv.a(((StringBuilder)localObject2).toString());
            i = xh.a(xh.this, (InputStream)localObject1, true);
            if (i != 0) {
              return;
            }
            xh.b(4);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = new StringBuilder("socket client verify failed");
            ((StringBuilder)localObject2).append(localException.toString());
            xv.c(((StringBuilder)localObject2).toString());
            xh.this.d();
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            localObject2 = new StringBuilder("socket client verify failed");
            ((StringBuilder)localObject2).append(localIOException.toString());
            xv.c(((StringBuilder)localObject2).toString());
            xh.this.d();
          }
        }
      });
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
  }
  
  public final xl a(Handler paramHandler)
  {
    switch (x)
    {
    case 4: 
    default: 
      break;
    case 8: 
      return null;
    case 7: 
      return null;
    case 6: 
      long l1 = System.currentTimeMillis();
      long l2 = this.z;
      int i1 = this.F;
      paramHandler = this.G;
      if (i1 < paramHandler.length) {
        i1 = paramHandler[i1];
      } else {
        i1 = paramHandler[(paramHandler.length - 1)];
      }
      if (l1 - l2 > i1) {
        x = 1;
      }
      return null;
    case 3: 
      h();
      break;
    case 2: 
      g();
      break;
    }
    try
    {
      if (this.e == null)
      {
        this.e = new HandlerThread("pushserviceconnect", 5);
        this.e.start();
      }
      if (this.f == null) {
        this.f = new Handler(this.e.getLooper());
      }
      this.f.post(new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   4: invokevirtual 24	com/tencent/token/xh:c	()V
          //   7: invokestatic 28	com/tencent/token/xh:e	()[Ljava/lang/String;
          //   10: ifnull +324 -> 334
          //   13: invokestatic 32	com/tencent/token/xh:f	()[I
          //   16: ifnull +318 -> 334
          //   19: invokestatic 28	com/tencent/token/xh:e	()[Ljava/lang/String;
          //   22: arraylength
          //   23: ifeq +311 -> 334
          //   26: invokestatic 32	com/tencent/token/xh:f	()[I
          //   29: arraylength
          //   30: ifne +6 -> 36
          //   33: goto +301 -> 334
          //   36: aload_0
          //   37: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   40: invokestatic 35	com/tencent/token/xh:a	(Lcom/tencent/token/xh;)I
          //   43: aload_0
          //   44: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   47: invokestatic 38	com/tencent/token/xh:b	(Lcom/tencent/token/xh;)I
          //   50: if_icmplt +17 -> 67
          //   53: iconst_0
          //   54: invokestatic 41	com/tencent/token/xh:b	(I)I
          //   57: pop
          //   58: aload_0
          //   59: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   62: invokestatic 43	com/tencent/token/xh:c	(Lcom/tencent/token/xh;)I
          //   65: pop
          //   66: return
          //   67: ldc 45
          //   69: invokestatic 50	com/tencent/token/xv:a	(Ljava/lang/String;)V
          //   72: aload_0
          //   73: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   76: invokestatic 35	com/tencent/token/xh:a	(Lcom/tencent/token/xh;)I
          //   79: invokestatic 28	com/tencent/token/xh:e	()[Ljava/lang/String;
          //   82: arraylength
          //   83: irem
          //   84: istore_1
          //   85: new 52	java/lang/StringBuilder
          //   88: dup
          //   89: ldc 54
          //   91: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   94: astore_2
          //   95: aload_2
          //   96: invokestatic 28	com/tencent/token/xh:e	()[Ljava/lang/String;
          //   99: iload_1
          //   100: aaload
          //   101: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   104: pop
          //   105: aload_2
          //   106: ldc 62
          //   108: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   111: pop
          //   112: aload_2
          //   113: invokestatic 32	com/tencent/token/xh:f	()[I
          //   116: iload_1
          //   117: iaload
          //   118: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   121: pop
          //   122: aload_2
          //   123: ldc 67
          //   125: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   128: pop
          //   129: aload_2
          //   130: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   133: invokestatic 50	com/tencent/token/xv:a	(Ljava/lang/String;)V
          //   136: aload_0
          //   137: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   140: lconst_0
          //   141: invokestatic 74	com/tencent/token/xh:b	(Lcom/tencent/token/xh;J)J
          //   144: pop2
          //   145: aload_0
          //   146: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   149: new 76	java/net/Socket
          //   152: dup
          //   153: invokespecial 77	java/net/Socket:<init>	()V
          //   156: invokestatic 80	com/tencent/token/xh:a	(Lcom/tencent/token/xh;Ljava/net/Socket;)Ljava/net/Socket;
          //   159: pop
          //   160: new 82	java/net/InetSocketAddress
          //   163: dup
          //   164: invokestatic 28	com/tencent/token/xh:e	()[Ljava/lang/String;
          //   167: iload_1
          //   168: aaload
          //   169: invokestatic 32	com/tencent/token/xh:f	()[I
          //   172: iload_1
          //   173: iaload
          //   174: invokespecial 85	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
          //   177: astore_2
          //   178: aload_0
          //   179: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   182: invokestatic 89	com/tencent/token/xh:d	(Lcom/tencent/token/xh;)Ljava/net/Socket;
          //   185: aload_2
          //   186: sipush 3000
          //   189: invokevirtual 93	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
          //   192: aload_0
          //   193: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   196: invokestatic 89	com/tencent/token/xh:d	(Lcom/tencent/token/xh;)Ljava/net/Socket;
          //   199: iconst_1
          //   200: invokevirtual 97	java/net/Socket:setKeepAlive	(Z)V
          //   203: new 52	java/lang/StringBuilder
          //   206: dup
          //   207: ldc 54
          //   209: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   212: astore_2
          //   213: aload_2
          //   214: invokestatic 28	com/tencent/token/xh:e	()[Ljava/lang/String;
          //   217: iload_1
          //   218: aaload
          //   219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   222: pop
          //   223: aload_2
          //   224: ldc 62
          //   226: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   229: pop
          //   230: aload_2
          //   231: invokestatic 32	com/tencent/token/xh:f	()[I
          //   234: iload_1
          //   235: iaload
          //   236: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   239: pop
          //   240: aload_2
          //   241: ldc 67
          //   243: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   246: pop
          //   247: aload_2
          //   248: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   251: invokestatic 50	com/tencent/token/xv:a	(Ljava/lang/String;)V
          //   254: aload_0
          //   255: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   258: invokestatic 99	com/tencent/token/xh:e	(Lcom/tencent/token/xh;)I
          //   261: pop
          //   262: iconst_2
          //   263: invokestatic 41	com/tencent/token/xh:b	(I)I
          //   266: pop
          //   267: aload_0
          //   268: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   271: invokestatic 101	com/tencent/token/xh:f	(Lcom/tencent/token/xh;)V
          //   274: return
          //   275: astore_2
          //   276: goto +48 -> 324
          //   279: astore_2
          //   280: aload_2
          //   281: invokevirtual 104	java/lang/Exception:printStackTrace	()V
          //   284: aload_2
          //   285: invokevirtual 105	java/lang/Exception:toString	()Ljava/lang/String;
          //   288: invokestatic 107	com/tencent/token/xv:c	(Ljava/lang/String;)V
          //   291: aload_0
          //   292: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   295: invokevirtual 24	com/tencent/token/xh:c	()V
          //   298: bipush 6
          //   300: invokestatic 41	com/tencent/token/xh:b	(I)I
          //   303: pop
          //   304: aload_0
          //   305: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   308: invokestatic 113	java/lang/System:currentTimeMillis	()J
          //   311: invokestatic 115	com/tencent/token/xh:a	(Lcom/tencent/token/xh;J)J
          //   314: pop2
          //   315: aload_0
          //   316: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   319: invokestatic 99	com/tencent/token/xh:e	(Lcom/tencent/token/xh;)I
          //   322: pop
          //   323: return
          //   324: aload_0
          //   325: getfield 14	com/tencent/token/xh$2:a	Lcom/tencent/token/xh;
          //   328: invokestatic 99	com/tencent/token/xh:e	(Lcom/tencent/token/xh;)I
          //   331: pop
          //   332: aload_2
          //   333: athrow
          //   334: iconst_0
          //   335: invokestatic 41	com/tencent/token/xh:b	(I)I
          //   338: pop
          //   339: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	340	0	this	2
          //   84	151	1	i	int
          //   94	154	2	localObject1	Object
          //   275	1	2	localObject2	Object
          //   279	54	2	localException	Exception
          // Exception table:
          //   from	to	target	type
          //   72	254	275	finally
          //   280	315	275	finally
          //   72	254	279	java/lang/Exception
        }
      });
    }
    catch (Error localError1)
    {
      break label205;
    }
    catch (Exception localException1)
    {
      label202:
      label205:
      label232:
      label235:
      break label202;
    }
    try
    {
      new UserTask() {}.a(new String[] { "" });
    }
    catch (Error localError2)
    {
      break label235;
    }
    catch (Exception localException2)
    {
      break label232;
    }
    if (4 == x) {
      return b(paramHandler);
    }
    return null;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != 1)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 8: 
        if (x == 8) {
          x = 1;
        }
        return;
      }
      c();
      x = paramInt;
      return;
    }
    x = paramInt;
  }
  
  public final void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    A = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      A[i1] = paramArrayOfString[i1];
      StringBuilder localStringBuilder = new StringBuilder("socket server ip[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]=");
      localStringBuilder.append(A[i1]);
      xv.a(localStringBuilder.toString());
      i1 += 1;
    }
    B = new int[paramArrayOfInt.length];
    i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      B[i1] = paramArrayOfInt[i1];
      paramArrayOfString = new StringBuilder("socket server port[");
      paramArrayOfString.append(i1);
      paramArrayOfString.append("]=");
      paramArrayOfString.append(B[i1]);
      xv.a(paramArrayOfString.toString());
      i1 += 1;
    }
    this.C = paramInt1;
    this.E = paramInt2;
    this.D = paramInt3;
    paramArrayOfString = new StringBuilder("socket reconn params reconn_count: ");
    paramArrayOfString.append(this.C);
    paramArrayOfString.append(", reconn_time_interval: ");
    paramArrayOfString.append(this.E);
    paramArrayOfString.append(", heart_break_time: ");
    paramArrayOfString.append(this.D);
    xv.a(paramArrayOfString.toString());
    this.F = 0;
  }
  
  public final void c()
  {
    Socket localSocket = this.w;
    if (localSocket == null) {
      return;
    }
    try
    {
      localSocket.close();
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder("socket close connection failed");
      localStringBuilder.append(localException.toString());
      xv.c(localStringBuilder.toString());
      localException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("socket close connection failed");
      localStringBuilder.append(localIOException.toString());
      xv.c(localStringBuilder.toString());
    }
  }
  
  public final void d()
  {
    x = 5;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xh
 * JD-Core Version:    0.7.0.1
 */