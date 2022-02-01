package com.tencent.token.core.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.token.cd;
import com.tencent.token.ck;
import com.tencent.token.cr;
import com.tencent.token.dr;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.encrypt.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class b
{
  private static String[] A;
  private static int[] B;
  static b a;
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
  private final dr h = new dr("B8008767A628A4F53BCB84C13C961A55BF87607DAA5BE0BA3AC2E0CB778E494579BD444F699885F4968CD9028BB3FC6FA657D532F1718F581669BDC333F83DC3", 16);
  private dr i = new dr("-1");
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
          i2 = 1;
          i3 = ck.a(arrayOfByte, 1);
          if (i3 <= 42)
          {
            paramInputStream = new StringBuilder();
            paramInputStream.append("socket rsp msg len not correct: ");
            paramInputStream.append(i3);
            com.tencent.token.global.g.c(paramInputStream.toString());
            return -1;
          }
          i4 = ck.a(arrayOfByte, 3);
          localObject = new byte[i3];
          i1 = 0;
        }
        catch (Exception paramInputStream)
        {
          int i2;
          int i3;
          int i4;
          paramInputStream.printStackTrace();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("socket decodeInputSream failed");
          ((StringBuilder)localObject).append(paramInputStream.toString());
          com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
          d();
          return -2;
        }
        catch (IOException paramInputStream)
        {
          label276:
          paramInputStream.printStackTrace();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("socket decodeInputSream failed");
          ((StringBuilder)localObject).append(paramInputStream.toString());
          com.tencent.token.global.g.c(((StringBuilder)localObject).toString());
          d();
          return -2;
        }
        paramInputStream.read((byte[])localObject, 5, i3 - 5);
        paramInputStream = new StringBuilder();
        paramInputStream.append("socket pkg type: ");
        paramInputStream.append(i4);
        com.tencent.token.global.g.a(paramInputStream.toString());
        if (i4 != 4) {}
        switch (i4)
        {
        case 202: 
          paramInputStream = new h();
          i1 = d.a((byte[])localObject, i3, paramInputStream);
          if (i1 == 0)
          {
            i1 = d.a((byte[])localObject, i3, paramInputStream);
            if ((i1 == 0) || (paramInputStream.n <= 0L)) {
              break label605;
            }
            long l1 = System.currentTimeMillis();
            long l2 = paramInputStream.n;
            localObject = cd.c();
            ((cd)localObject).a(l2 * 1000L - l1);
            ((cd)localObject).i();
            break label605;
            this.k = new String(paramInputStream.p);
          }
          break;
        case 201: 
          paramInputStream = new e();
          i1 = d.a((byte[])localObject, i3, paramInputStream);
          if (i1 == 0)
          {
            i1 = d.a((byte[])localObject, i3, paramInputStream);
            if (i1 != 0) {
              break label612;
            }
            paramInputStream = new dr(new String(paramInputStream.m), 16);
            this.j = com.tencent.token.utils.encrypt.b.a(this.i, paramInputStream, this.h);
            if (this.j != null) {
              break label612;
            }
            i1 = i2;
            break;
            paramInputStream = new g();
            i1 = d.a((byte[])localObject, i3, paramInputStream);
            if (i1 == 0)
            {
              i1 = d.a((byte[])localObject, i3, paramInputStream);
              if (i1 == 0)
              {
                this.d = b(paramInputStream.n);
                if (this.d == null) {
                  this.d = b(paramInputStream.n);
                }
                if (this.d == null) {
                  i1 = 101;
                }
              }
            }
          }
          break;
        }
      }
    }
    label605:
    label612:
    for (;;)
    {
      if (i1 != 0) {
        c(i1);
      }
      return i1;
      d();
      return -2;
      while (i1 < 5)
      {
        localObject[i1] = arrayOfByte[i1];
        i1 += 1;
      }
      i1 = 101;
      continue;
      if (i1 == 0) {
        break label276;
      }
    }
  }
  
  public static b a()
  {
    if (a == null)
    {
      a = new b();
      x = 0;
    }
    return a;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new a().b(paramArrayOfByte, this.j);
    if (paramArrayOfByte == null)
    {
      com.tencent.token.global.g.c("encrypt data failed");
      return null;
    }
    return paramArrayOfByte;
  }
  
  private f b(final Handler paramHandler)
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
        public void run()
        {
          if (b.c(b.this) == null)
          {
            b.this.d();
            return;
          }
          Object localObject1 = b.this;
          ((b)localObject1).d = null;
          try
          {
            localObject1 = b.c((b)localObject1).getOutputStream();
            localObject2 = b.c(b.this).getInputStream();
            long l = System.currentTimeMillis();
            Object localObject3;
            if (l - b.j(b.this) >= b.k(b.this))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("socket send heart break: ");
              ((StringBuilder)localObject3).append(l);
              com.tencent.token.global.g.a(((StringBuilder)localObject3).toString());
              b.b(b.this, l);
              ((OutputStream)localObject1).write(d.a((byte)0));
              ((OutputStream)localObject1).flush();
            }
            if ((((InputStream)localObject2).available() > 0) && (b.a(b.this, (InputStream)localObject2, false) != 0)) {
              return;
            }
            if (b.this.d != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("socket decrypt len: ");
              ((StringBuilder)localObject2).append(b.this.d.length);
              com.tencent.token.global.g.a(((StringBuilder)localObject2).toString());
              localObject2 = new f();
              ((f)localObject2).a = ck.c(b.this.d, 0);
              int i = ck.a(b.this.d, 8);
              ((f)localObject2).b = new byte[i];
              ck.b(b.this.d, 10, ((f)localObject2).b, i);
              i = 10 + i;
              ((f)localObject2).c = ck.b(b.this.d, i);
              i += 4;
              ((f)localObject2).d = b.this.d[i];
              i += 1;
              ((f)localObject2).e = b.this.d[i];
              i += 1;
              ((f)localObject2).f = ck.b(b.this.d, i);
              int j = i + 4;
              i = ck.a(b.this.d, j);
              j += 2;
              ((f)localObject2).g = new byte[i];
              ck.b(b.this.d, j, ((f)localObject2).g, i);
              i = j + i;
              j = ck.a(b.this.d, i);
              ((f)localObject2).h = new byte[j];
              ck.b(b.this.d, i + 2, ((f)localObject2).h, j);
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("socket msg time: ");
              ((StringBuilder)localObject3).append(((f)localObject2).f);
              ((StringBuilder)localObject3).append(" id: ");
              ((StringBuilder)localObject3).append(((f)localObject2).c);
              ((StringBuilder)localObject3).append(" uin: ");
              ((StringBuilder)localObject3).append(new String(((f)localObject2).b));
              ((StringBuilder)localObject3).append(" type: ");
              ((StringBuilder)localObject3).append(((f)localObject2).d);
              ((StringBuilder)localObject3).append(" subType: ");
              ((StringBuilder)localObject3).append(((f)localObject2).e);
              ((StringBuilder)localObject3).append(" title: ");
              ((StringBuilder)localObject3).append(new String(((f)localObject2).g));
              ((StringBuilder)localObject3).append(" content: ");
              ((StringBuilder)localObject3).append(new String(((f)localObject2).h));
              com.tencent.token.global.g.a(((StringBuilder)localObject3).toString());
              localObject3 = d.a(0, (short)0, "");
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
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("socket client goToHeartBreakAndGetPushMsgfailed");
            ((StringBuilder)localObject2).append(localException2.toString());
            com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
            b.this.d();
            return;
          }
          catch (IOException localIOException2)
          {
            localIOException2.printStackTrace();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("socket client goToHeartBreakAndGetPushMsg failed");
            ((StringBuilder)localObject2).append(localIOException2.toString());
            com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
            b.this.d();
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
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new a().a(paramArrayOfByte, this.j);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      com.tencent.token.global.g.c(paramArrayOfByte.toString());
    }
    return null;
  }
  
  private void c(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 103))
    {
      if (paramInt != 106)
      {
        if (paramInt != 109)
        {
          c();
          x = 7;
          return;
        }
        d();
        return;
      }
      c();
      x = 8;
      return;
    }
    c();
    x = 6;
    this.z = System.currentTimeMillis();
  }
  
  private void g()
  {
    try
    {
      new UserTask()
      {
        public com.tencent.token.global.e a(String... paramAnonymousVarArgs)
        {
          return cr.a().b();
        }
        
        public void a(com.tencent.token.global.e paramAnonymouse)
        {
          if (paramAnonymouse.b())
          {
            b.b(1);
            return;
          }
          com.tencent.token.global.g.c("socket get config failed");
          b.b(6);
          b.a(b.this, System.currentTimeMillis());
        }
      }.c(new String[] { "" });
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
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   4: invokevirtual 26	com/tencent/token/core/push/b:c	()V
          //   7: invokestatic 30	com/tencent/token/core/push/b:e	()[Ljava/lang/String;
          //   10: ifnull +335 -> 345
          //   13: invokestatic 34	com/tencent/token/core/push/b:f	()[I
          //   16: ifnull +329 -> 345
          //   19: invokestatic 30	com/tencent/token/core/push/b:e	()[Ljava/lang/String;
          //   22: arraylength
          //   23: ifeq +322 -> 345
          //   26: invokestatic 34	com/tencent/token/core/push/b:f	()[I
          //   29: arraylength
          //   30: ifne +6 -> 36
          //   33: goto +312 -> 345
          //   36: aload_0
          //   37: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   40: invokestatic 37	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;)I
          //   43: aload_0
          //   44: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   47: invokestatic 40	com/tencent/token/core/push/b:b	(Lcom/tencent/token/core/push/b;)I
          //   50: if_icmplt +18 -> 68
          //   53: iconst_0
          //   54: invokestatic 43	com/tencent/token/core/push/b:b	(I)I
          //   57: pop
          //   58: aload_0
          //   59: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   62: iconst_0
          //   63: invokestatic 46	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;I)I
          //   66: pop
          //   67: return
          //   68: ldc 48
          //   70: invokestatic 53	com/tencent/token/global/g:a	(Ljava/lang/String;)V
          //   73: aload_0
          //   74: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   77: invokestatic 37	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;)I
          //   80: invokestatic 30	com/tencent/token/core/push/b:e	()[Ljava/lang/String;
          //   83: arraylength
          //   84: irem
          //   85: istore_1
          //   86: new 55	java/lang/StringBuilder
          //   89: dup
          //   90: invokespecial 56	java/lang/StringBuilder:<init>	()V
          //   93: astore_2
          //   94: aload_2
          //   95: ldc 58
          //   97: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   100: pop
          //   101: aload_2
          //   102: invokestatic 30	com/tencent/token/core/push/b:e	()[Ljava/lang/String;
          //   105: iload_1
          //   106: aaload
          //   107: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   110: pop
          //   111: aload_2
          //   112: ldc 64
          //   114: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   117: pop
          //   118: aload_2
          //   119: invokestatic 34	com/tencent/token/core/push/b:f	()[I
          //   122: iload_1
          //   123: iaload
          //   124: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   127: pop
          //   128: aload_2
          //   129: ldc 69
          //   131: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   134: pop
          //   135: aload_2
          //   136: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   139: invokestatic 53	com/tencent/token/global/g:a	(Ljava/lang/String;)V
          //   142: aload_0
          //   143: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   146: lconst_0
          //   147: invokestatic 76	com/tencent/token/core/push/b:b	(Lcom/tencent/token/core/push/b;J)J
          //   150: pop2
          //   151: aload_0
          //   152: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   155: new 78	java/net/Socket
          //   158: dup
          //   159: invokespecial 79	java/net/Socket:<init>	()V
          //   162: invokestatic 82	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;Ljava/net/Socket;)Ljava/net/Socket;
          //   165: pop
          //   166: new 84	java/net/InetSocketAddress
          //   169: dup
          //   170: invokestatic 30	com/tencent/token/core/push/b:e	()[Ljava/lang/String;
          //   173: iload_1
          //   174: aaload
          //   175: invokestatic 34	com/tencent/token/core/push/b:f	()[I
          //   178: iload_1
          //   179: iaload
          //   180: invokespecial 87	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
          //   183: astore_2
          //   184: aload_0
          //   185: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   188: invokestatic 90	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
          //   191: aload_2
          //   192: sipush 3000
          //   195: invokevirtual 94	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
          //   198: aload_0
          //   199: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   202: invokestatic 90	com/tencent/token/core/push/b:c	(Lcom/tencent/token/core/push/b;)Ljava/net/Socket;
          //   205: iconst_1
          //   206: invokevirtual 98	java/net/Socket:setKeepAlive	(Z)V
          //   209: new 55	java/lang/StringBuilder
          //   212: dup
          //   213: invokespecial 56	java/lang/StringBuilder:<init>	()V
          //   216: astore_2
          //   217: aload_2
          //   218: ldc 58
          //   220: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   223: pop
          //   224: aload_2
          //   225: invokestatic 30	com/tencent/token/core/push/b:e	()[Ljava/lang/String;
          //   228: iload_1
          //   229: aaload
          //   230: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   233: pop
          //   234: aload_2
          //   235: ldc 64
          //   237: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   240: pop
          //   241: aload_2
          //   242: invokestatic 34	com/tencent/token/core/push/b:f	()[I
          //   245: iload_1
          //   246: iaload
          //   247: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   250: pop
          //   251: aload_2
          //   252: ldc 69
          //   254: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   257: pop
          //   258: aload_2
          //   259: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   262: invokestatic 53	com/tencent/token/global/g:a	(Ljava/lang/String;)V
          //   265: aload_0
          //   266: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   269: invokestatic 101	com/tencent/token/core/push/b:d	(Lcom/tencent/token/core/push/b;)I
          //   272: pop
          //   273: iconst_2
          //   274: invokestatic 43	com/tencent/token/core/push/b:b	(I)I
          //   277: pop
          //   278: aload_0
          //   279: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   282: invokestatic 103	com/tencent/token/core/push/b:e	(Lcom/tencent/token/core/push/b;)V
          //   285: return
          //   286: astore_2
          //   287: goto +48 -> 335
          //   290: astore_2
          //   291: aload_2
          //   292: invokevirtual 106	java/lang/Exception:printStackTrace	()V
          //   295: aload_2
          //   296: invokevirtual 107	java/lang/Exception:toString	()Ljava/lang/String;
          //   299: invokestatic 109	com/tencent/token/global/g:c	(Ljava/lang/String;)V
          //   302: aload_0
          //   303: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   306: invokevirtual 26	com/tencent/token/core/push/b:c	()V
          //   309: bipush 6
          //   311: invokestatic 43	com/tencent/token/core/push/b:b	(I)I
          //   314: pop
          //   315: aload_0
          //   316: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   319: invokestatic 115	java/lang/System:currentTimeMillis	()J
          //   322: invokestatic 117	com/tencent/token/core/push/b:a	(Lcom/tencent/token/core/push/b;J)J
          //   325: pop2
          //   326: aload_0
          //   327: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   330: invokestatic 101	com/tencent/token/core/push/b:d	(Lcom/tencent/token/core/push/b;)I
          //   333: pop
          //   334: return
          //   335: aload_0
          //   336: getfield 17	com/tencent/token/core/push/b$2:a	Lcom/tencent/token/core/push/b;
          //   339: invokestatic 101	com/tencent/token/core/push/b:d	(Lcom/tencent/token/core/push/b;)I
          //   342: pop
          //   343: aload_2
          //   344: athrow
          //   345: iconst_0
          //   346: invokestatic 43	com/tencent/token/core/push/b:b	(I)I
          //   349: pop
          //   350: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	351	0	this	2
          //   85	161	1	i	int
          //   93	166	2	localObject1	Object
          //   286	1	2	localObject2	Object
          //   290	54	2	localException	Exception
          // Exception table:
          //   from	to	target	type
          //   73	265	286	finally
          //   291	326	286	finally
          //   73	265	290	java/lang/Exception
        }
      });
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
  }
  
  private void i()
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
        public void run()
        {
          if (b.c(b.this) == null)
          {
            b.this.d();
            return;
          }
          b.a(b.this, com.tencent.token.utils.encrypt.b.a());
          Object localObject1 = com.tencent.token.utils.encrypt.b.a(b.f(b.this), 2L, b.g(b.this));
          if ((b.f(b.this) != null) && (localObject1 != null) && (((String)localObject1).length() != 0))
          {
            Object localObject2 = d.a((String)localObject1);
            try
            {
              OutputStream localOutputStream = b.c(b.this).getOutputStream();
              localObject1 = b.c(b.this).getInputStream();
              localOutputStream.write((byte[])localObject2);
              localOutputStream.flush();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("socket available: ");
              ((StringBuilder)localObject2).append(((InputStream)localObject1).available());
              com.tencent.token.global.g.a(((StringBuilder)localObject2).toString());
              int i = b.a(b.this, (InputStream)localObject1, false);
              if (i != 0) {
                return;
              }
              b.b(3);
              b.h(b.this);
              return;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("socket exchange key failed");
              ((StringBuilder)localObject2).append(localException.toString());
              com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
              b.this.d();
              return;
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("socket exchange key failed");
              ((StringBuilder)localObject2).append(localIOException.toString());
              com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
              b.this.d();
              return;
            }
          }
          b.this.c();
          b.b(6);
          b.a(b.this, System.currentTimeMillis());
        }
      });
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
  }
  
  private void j()
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
        public void run()
        {
          if (b.c(b.this) == null)
          {
            b.this.d();
            return;
          }
          Object localObject2 = cd.c();
          ((cd)localObject2).m();
          long l = ((cd)localObject2).k();
          Object localObject1 = cd.b();
          localObject2 = ((cd)localObject2).o();
          Object localObject3 = new byte[((String)localObject2).length() + 10 + 2 + ((String)localObject1).length() + 2 + b.i(b.this).length()];
          ck.b((byte[])localObject3, 0, l);
          ck.a((byte[])localObject3, 8, (short)((String)localObject2).length());
          ck.a((byte[])localObject3, 10, ((String)localObject2).getBytes(), ((String)localObject2).length());
          int i = 10 + ((String)localObject2).length();
          ck.a((byte[])localObject3, i, (short)((String)localObject1).length());
          i += 2;
          ck.a((byte[])localObject3, i, ((String)localObject1).getBytes(), ((String)localObject1).length());
          i += ((String)localObject1).length();
          ck.a((byte[])localObject3, i, (short)b.i(b.this).length());
          ck.a((byte[])localObject3, i + 2, b.i(b.this).getBytes(), b.i(b.this).length());
          localObject2 = b.a(b.this, (byte[])localObject3);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = b.a(b.this, (byte[])localObject3);
          }
          if (localObject1 == null)
          {
            b.this.c();
            b.b(7);
            return;
          }
          localObject2 = d.a((byte[])localObject1);
          try
          {
            localObject3 = b.c(b.this).getOutputStream();
            localObject1 = b.c(b.this).getInputStream();
            ((OutputStream)localObject3).write((byte[])localObject2);
            ((OutputStream)localObject3).flush();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("socket available: ");
            ((StringBuilder)localObject2).append(((InputStream)localObject1).available());
            com.tencent.token.global.g.a(((StringBuilder)localObject2).toString());
            i = b.a(b.this, (InputStream)localObject1, true);
            if (i != 0) {
              return;
            }
            b.b(4);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("socket client verify failed");
            ((StringBuilder)localObject2).append(localException.toString());
            com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
            b.this.d();
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("socket client verify failed");
            ((StringBuilder)localObject2).append(localIOException.toString());
            com.tencent.token.global.g.c(((StringBuilder)localObject2).toString());
            b.this.d();
          }
        }
      });
      return;
    }
    catch (Error localError) {}catch (Exception localException) {}
  }
  
  private int k()
  {
    int i1 = this.F;
    int[] arrayOfInt = this.G;
    if (i1 < arrayOfInt.length) {
      return arrayOfInt[i1];
    }
    return arrayOfInt[(arrayOfInt.length - 1)];
  }
  
  public f a(Handler paramHandler)
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
      if (System.currentTimeMillis() - this.z > k()) {
        x = 1;
      }
      return null;
    case 3: 
      j();
      break;
    case 2: 
      i();
      break;
    case 1: 
    case 5: 
      h();
      break;
    case 0: 
      g();
    }
    if (4 == x) {
      return b(paramHandler);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 1) {
      switch (paramInt)
      {
      default: 
        return;
      case 8: 
        if (x != 8) {
          break;
        }
        x = 1;
        return;
      case 7: 
        c();
        x = paramInt;
        return;
      }
    } else {
      x = paramInt;
    }
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    A = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      A[i1] = paramArrayOfString[i1];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("socket server ip[");
      localStringBuilder.append(i1);
      localStringBuilder.append("]=");
      localStringBuilder.append(A[i1]);
      com.tencent.token.global.g.a(localStringBuilder.toString());
      i1 += 1;
    }
    B = new int[paramArrayOfInt.length];
    i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      B[i1] = paramArrayOfInt[i1];
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("socket server port[");
      paramArrayOfString.append(i1);
      paramArrayOfString.append("]=");
      paramArrayOfString.append(B[i1]);
      com.tencent.token.global.g.a(paramArrayOfString.toString());
      i1 += 1;
    }
    this.C = paramInt1;
    this.E = paramInt2;
    this.D = paramInt3;
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("socket reconn params reconn_count: ");
    paramArrayOfString.append(this.C);
    paramArrayOfString.append(", reconn_time_interval: ");
    paramArrayOfString.append(this.E);
    paramArrayOfString.append(", heart_break_time: ");
    paramArrayOfString.append(this.D);
    com.tencent.token.global.g.a(paramArrayOfString.toString());
    this.F = 0;
  }
  
  public void c()
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("socket close connection failed");
      localStringBuilder.append(localException.toString());
      com.tencent.token.global.g.c(localStringBuilder.toString());
      localException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("socket close connection failed");
      localStringBuilder.append(localIOException.toString());
      com.tencent.token.global.g.c(localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    x = 5;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.b
 * JD-Core Version:    0.7.0.1
 */