package btmsdkobf;

import android.content.Context;
import android.net.NetworkInfo;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

public class ds
{
  protected dp hf;
  private Context mContext;
  private byte nk = 0;
  private boolean nl = true;
  private String nm = "";
  private volatile boolean nn = true;
  private Thread no;
  private final Object np = new Object();
  private Socket nq;
  private DataOutputStream nr;
  private DataInputStream ns;
  private ds.a nt;
  private boolean nu = false;
  
  public ds(Context paramContext, byte paramByte, boolean paramBoolean, ds.a parama, dp paramdp)
  {
    this.mContext = paramContext;
    this.nk = paramByte;
    this.nl = paramBoolean;
    this.nt = parama;
    this.hf = paramdp;
  }
  
  public ds(Context paramContext, ds.a parama, dp paramdp)
  {
    this(paramContext, (byte)0, false, parama, paramdp);
  }
  
  private int a(dp paramdp)
  {
    eh.e("TcpNetwork", "[tcp_control] checkSocketWithRetry()");
    long l3 = System.currentTimeMillis();
    int i = 0;
    paramdp.n(true);
    int m = paramdp.q(true);
    int k = 0;
    Object localObject1 = null;
    long l1 = 0L;
    for (;;)
    {
      l2 = l1;
      j = i;
      localObject2 = localObject1;
      if (k >= m) {
        break label450;
      }
      localObject1 = paramdp.l(true);
      if (localObject1 != null) {
        break;
      }
      k += 1;
    }
    l1 = System.currentTimeMillis();
    i = b((dq.b)localObject1);
    l1 = System.currentTimeMillis() - l1;
    eh.f("TcpNetwork", "checkSocketWithRetry(), ipPoint " + ((dq.b)localObject1).toString() + " localIp " + cJ() + " localPort " + cK() + " ret: " + i);
    long l2 = l1;
    int j = i;
    Object localObject2 = localObject1;
    if (i != 0) {
      if (bz.q(i)) {}
    }
    for (;;)
    {
      label181:
      boolean bool;
      if (i == 0)
      {
        bool = true;
        label188:
        paramdp.o(bool);
        if (localObject1 != null)
        {
          localObject2 = new dg();
          ((dg)localObject2).mi = ((dq.b)localObject1).getIp();
          ((dg)localObject2).mj = String.valueOf(((dq.b)localObject1).getPort());
          ((dg)localObject2).ml = String.valueOf(cd.e(this.mContext));
          ((dg)localObject2).mn = l1;
          ((dg)localObject2).errorCode = i;
          ((dg)localObject2).mo = this.nm;
          if (k >= m) {
            break label406;
          }
          j = k + 1;
          label282:
          ((dg)localObject2).mk = j;
          ((dg)localObject2).f(paramdp.p(true));
          if (k != m) {
            break label412;
          }
          j = 1;
          label309:
          if (j == 0) {
            break label417;
          }
          ee.cT().addTask(new il(this, (dg)localObject2), "uploadConnectInfo");
        }
      }
      for (;;)
      {
        eh.f("TcpNetwork", "[tcp_control] checkSocketWithRetry(), ret: " + i + " time: " + (System.currentTimeMillis() - l3));
        return i;
        if ((k == 0) && (cx.y("tcp connect")))
        {
          i = -160000;
          break label181;
        }
        paramdp.m(true);
        break;
        bool = false;
        break label188;
        label406:
        j = m;
        break label282;
        label412:
        j = 0;
        break label309;
        label417:
        ((dg)localObject2).ms = false;
        ((dg)localObject2).mp = "false";
        paramdp = db.bZ();
        if (paramdp != null) {
          ((dg)localObject2).d(paramdp.bL());
        }
      }
      label450:
      localObject1 = localObject2;
      l1 = l2;
      i = j;
    }
  }
  
  private Socket a(InetAddress paramInetAddress, int paramInt)
  {
    eh.f("TcpNetwork", "acquireSocketWithTimeOut, addr: " + paramInetAddress + ", port: " + paramInt);
    Socket localSocket = new Socket();
    localSocket.setSoLinger(false, 0);
    localSocket.connect(new InetSocketAddress(paramInetAddress, paramInt), 15000);
    eh.f("TcpNetwork", "acquireSocketWithTimeOut end");
    return localSocket;
  }
  
  private boolean a(dq.b paramb)
  {
    eh.e("TcpNetwork", "[tcp_control]startSocket()");
    if (!cG())
    {
      eh.f("TcpNetwork", "startSocket() 1");
      cF();
    }
    eh.f("TcpNetwork", "startSocket() 2");
    InetAddress localInetAddress = InetAddress.getByName(paramb.getIp());
    eh.f("TcpNetwork", "startSocket() 3");
    this.nq = a(localInetAddress, paramb.getPort());
    eh.f("TcpNetwork", "startSocket() 4");
    switch (this.nk)
    {
    }
    for (;;)
    {
      eh.f("TcpNetwork", "startSocket() 6");
      return cH();
      this.nr = new DataOutputStream(this.nq.getOutputStream());
      eh.f("TcpNetwork", "startSocket() 5");
      this.ns = new DataInputStream(this.nq.getInputStream());
      continue;
      this.nq.setSoTimeout(15000);
    }
  }
  
  private int b(Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        eh.e("TcpNetwork", "[tcp_control]start() isRestart " + paramBoolean);
        if (isStarted())
        {
          eh.e("TcpNetwork", "start() already started");
          i = j;
          return i;
        }
        if (!isNetworkConnected())
        {
          eh.e("TcpNetwork", "start(), no connect");
          i = -220000;
          continue;
        }
        if (this.nt != null) {
          this.nt.L(3);
        }
        i = a(this.hf);
        if (i != 0)
        {
          eh.g("TcpNetwork", "[tcp_control]connect failed, donot startRcvThread()");
          continue;
        }
        this.nn = false;
        if (this.nk == 0)
        {
          eh.e("TcpNetwork", "[tcp_control]connect succ, startRcvThread()");
          cD();
        }
        i = j;
        if (this.nt == null) {
          continue;
        }
        if (paramBoolean)
        {
          this.nt.L(5);
          i = j;
          continue;
        }
        this.nt.L(4);
      }
      finally {}
      int i = j;
    }
  }
  
  private int b(cy.f paramf, byte[] paramArrayOfByte)
  {
    try
    {
      synchronized (this.nq)
      {
        if (!cH()) {
          return -180000;
        }
        Object localObject = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
        localDataOutputStream.writeInt(paramArrayOfByte.length);
        localDataOutputStream.write(paramArrayOfByte);
        paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
        eh.f("TcpNetwork", "[tcp_control]sendDataInAsync(), bf [tcp send] bytes: " + paramArrayOfByte.length);
        this.nr.write(paramArrayOfByte);
        eh.e("TcpNetwork", "[flow_control][tcp_control]sendDataInAsync(), [tcp send] bytes: " + paramArrayOfByte.length);
        if ((paramf != null) && (paramf.jT != null) && (paramf.jT.size() > 0))
        {
          int i = paramf.jT.size();
          paramf = paramf.jT.iterator();
          while (paramf.hasNext())
          {
            localObject = (as)paramf.next();
            if (localObject != null)
            {
              cv.by().a("TcpNetwork", ((as)localObject).bM, ((as)localObject).dc, (as)localObject, 12, 0, String.format("%d/%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(i) }));
              if (((as)localObject).dd == 0) {
                dg.a(new dg(), ((as)localObject).dc);
              }
            }
          }
        }
      }
      return -320000;
    }
    catch (SocketException paramf)
    {
      this.nm = paramf.toString();
      eh.h("TcpNetwork", "sendDataInAsync() SocketException: " + paramf.toString());
      return -330000;
      this.nm = "";
      eh.f("TcpNetwork", "sendDataInAsync() succ");
      return 0;
    }
    catch (Throwable paramf)
    {
      this.nm = paramf.toString();
      eh.h("TcpNetwork", "sendDataInAsync() Throwable: " + paramf.toString());
    }
  }
  
  private int b(dq.b paramb)
  {
    int i = 0;
    eh.e("TcpNetwork", "[tcp_control]checkSocket()");
    if (paramb == null) {
      return -10;
    }
    if (cH())
    {
      eh.g("TcpNetwork", "[tcp_control]checkSocket(), already contected");
      return 0;
    }
    try
    {
      if (a(paramb))
      {
        eh.i("TcpNetwork", "[tcp_control]checkSocket(), startSocket succ, set: mIsIgnoreStopExption = false");
        this.nu = false;
        this.nm = "";
        return i;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        eh.a("TcpNetwork", "checkSocket(), UnknownHostException: ", localUnknownHostException);
        if (this.nt != null) {
          this.nt.a(7, paramb);
        }
        this.nm = localUnknownHostException.toString();
        return -70000;
        i = -340000;
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      eh.a("TcpNetwork", "checkSocket(), SocketTimeoutException: ", localSocketTimeoutException);
      if (this.nt != null) {
        this.nt.a(8, paramb);
      }
      this.nm = localSocketTimeoutException.toString();
      return -130000;
    }
    catch (ConnectException localConnectException)
    {
      i = bz.a(localConnectException.toString(), -500000);
      eh.a("TcpNetwork", "checkSocket(), ConnectException: ", localConnectException);
      if (this.nt != null) {
        this.nt.a(9, paramb);
      }
      this.nm = localConnectException.toString();
      return i;
    }
    catch (SocketException localSocketException)
    {
      i = bz.a(localSocketException.toString(), -420000);
      eh.a("TcpNetwork", "checkSocket(), SocketException: ", localSocketException);
      if (this.nt != null) {
        this.nt.a(9, paramb);
      }
      this.nm = localSocketException.toString();
      return i;
    }
    catch (SecurityException localSecurityException)
    {
      i = bz.a(localSecurityException.toString(), -440000);
      eh.a("TcpNetwork", "checkSocket(), SecurityException: ", localSecurityException);
      if (this.nt != null) {
        this.nt.a(9, paramb);
      }
      this.nm = localSecurityException.toString();
      return i;
    }
    catch (Throwable localThrowable)
    {
      eh.a("TcpNetwork", "checkSocket(), Throwable: ", localThrowable);
      if (this.nt != null) {
        this.nt.a(9, paramb);
      }
      this.nm = localThrowable.toString();
    }
    return -900000;
  }
  
  private void cD()
  {
    this.no = new ij(this, "RcvThread");
    this.no.setPriority(10);
    this.no.start();
  }
  
  private void cE()
  {
    eh.e("TcpNetwork", "[tcp_control]recv()...");
    for (;;)
    {
      if (!this.nn) {}
      try
      {
        if (this.nl)
        {
          i = this.ns.readInt();
          int j = this.ns.readInt();
          if (j >= 1000000)
          {
            eh.h("TcpNetwork", "[flow_control][tcp_control]包有误，数据过大，size >= 1000000, [tcp receive] bytes: " + j);
            return;
          }
          eh.e("TcpNetwork", "[flow_control][tcp_control]recv(), [tcp receive] bytes: " + (j + 4));
          byte[] arrayOfByte = dq.a(this.ns, 0, j, null);
          if (arrayOfByte == null) {
            eh.h("TcpNetwork", "[tcp_control]recv(), respData == null");
          }
        }
      }
      catch (SocketException localSocketException)
      {
        eh.b("TcpNetwork", "[tcp_control]recv(), SocketException: " + localSocketException, localSocketException);
        if (!this.nu)
        {
          d(true, false);
          if (this.nt != null) {
            this.nt.a(10, localSocketException);
          }
          if (!this.nu) {
            stop();
          }
          eh.e("TcpNetwork", "[tcp_control]recv(), recv thread is stopped, set: mIsIgnoreStopExption = false");
          this.nu = false;
          eh.e("TcpNetwork", "[tcp_control]recv(), end!!!");
          return;
          eh.e("TcpNetwork", "[tcp_control]notifyOnReceiveData(), respData.length(): " + localSocketException.length);
          d(i, localSocketException);
        }
      }
      catch (EOFException localEOFException)
      {
        for (;;)
        {
          eh.b("TcpNetwork", "[tcp_control]recv() EOFException: " + localEOFException, localEOFException);
          if (!this.nu)
          {
            d(true, false);
            if (this.nt != null)
            {
              this.nt.a(11, localEOFException);
              continue;
              eh.e("TcpNetwork", "[tcp_control]ignore stop exption");
              this.nn = true;
            }
          }
          else
          {
            eh.e("TcpNetwork", "[tcp_control]ignore stop exption");
            this.nn = true;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i;
          eh.b("TcpNetwork", "[tcp_control]recv() Throwable: " + localThrowable, localThrowable);
          if (!this.nu)
          {
            d(true, false);
            if (this.nt != null) {
              this.nt.a(12, localThrowable);
            }
          }
          else
          {
            eh.e("TcpNetwork", "[tcp_control]ignore stop exption");
            this.nn = true;
            continue;
            i = 0;
          }
        }
      }
    }
  }
  
  /* Error */
  private int cF()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 61
    //   4: ldc_w 583
    //   7: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   13: lstore_2
    //   14: aload_0
    //   15: getfield 45	btmsdkobf/ds:np	Ljava/lang/Object;
    //   18: astore 4
    //   20: aload 4
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   27: ifnonnull +16 -> 43
    //   30: ldc 61
    //   32: ldc_w 585
    //   35: invokestatic 364	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload 4
    //   40: monitorexit
    //   41: iconst_0
    //   42: ireturn
    //   43: aload 4
    //   45: monitorexit
    //   46: ldc 61
    //   48: ldc_w 587
    //   51: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: invokespecial 281	btmsdkobf/ds:cG	()Z
    //   58: ifeq +21 -> 79
    //   61: ldc 61
    //   63: ldc_w 589
    //   66: invokestatic 364	btmsdkobf/eh:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: astore 5
    //   73: aload 4
    //   75: monitorexit
    //   76: aload 5
    //   78: athrow
    //   79: ldc 61
    //   81: ldc_w 591
    //   84: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: getfield 45	btmsdkobf/ds:np	Ljava/lang/Object;
    //   91: astore 4
    //   93: aload 4
    //   95: monitorenter
    //   96: ldc 61
    //   98: ldc_w 593
    //   101: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: getfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   108: invokevirtual 596	java/net/Socket:isInputShutdown	()Z
    //   111: ifne +10 -> 121
    //   114: aload_0
    //   115: getfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   118: invokevirtual 599	java/net/Socket:shutdownInput	()V
    //   121: ldc 61
    //   123: ldc_w 601
    //   126: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: getfield 331	btmsdkobf/ds:ns	Ljava/io/DataInputStream;
    //   133: invokevirtual 604	java/io/DataInputStream:close	()V
    //   136: ldc 61
    //   138: ldc_w 606
    //   141: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   148: invokevirtual 609	java/net/Socket:isOutputShutdown	()Z
    //   151: ifne +10 -> 161
    //   154: aload_0
    //   155: getfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   158: invokevirtual 612	java/net/Socket:shutdownOutput	()V
    //   161: ldc 61
    //   163: ldc_w 614
    //   166: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: getfield 318	btmsdkobf/ds:nr	Ljava/io/DataOutputStream;
    //   173: invokevirtual 615	java/io/DataOutputStream:close	()V
    //   176: aload 4
    //   178: monitorexit
    //   179: ldc 61
    //   181: ldc_w 617
    //   184: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: getfield 45	btmsdkobf/ds:np	Ljava/lang/Object;
    //   191: astore 4
    //   193: aload 4
    //   195: monitorenter
    //   196: ldc 61
    //   198: ldc_w 619
    //   201: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_0
    //   205: getfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   208: invokevirtual 620	java/net/Socket:close	()V
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 300	btmsdkobf/ds:nq	Ljava/net/Socket;
    //   216: ldc 61
    //   218: ldc_w 622
    //   221: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 4
    //   226: monitorexit
    //   227: ldc2_w 623
    //   230: invokestatic 628	java/lang/Thread:sleep	(J)V
    //   233: aload_0
    //   234: ldc 39
    //   236: putfield 41	btmsdkobf/ds:nm	Ljava/lang/String;
    //   239: ldc 61
    //   241: new 95	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 630
    //   251: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: iload_1
    //   255: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc_w 632
    //   261: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   267: lload_2
    //   268: lsub
    //   269: invokevirtual 210	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 128	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: iload_1
    //   279: ireturn
    //   280: astore 5
    //   282: ldc 61
    //   284: new 95	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 634
    //   294: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 5
    //   299: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: goto -187 -> 121
    //   311: astore 5
    //   313: aload 4
    //   315: monitorexit
    //   316: aload 5
    //   318: athrow
    //   319: astore 5
    //   321: ldc 61
    //   323: aload 5
    //   325: invokevirtual 637	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   328: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto -195 -> 136
    //   334: astore 5
    //   336: ldc 61
    //   338: new 95	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   345: ldc_w 639
    //   348: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 5
    //   353: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -201 -> 161
    //   365: astore 5
    //   367: ldc 61
    //   369: new 95	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 641
    //   379: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload 5
    //   384: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto -217 -> 176
    //   396: astore 5
    //   398: aload 4
    //   400: monitorexit
    //   401: aload 5
    //   403: athrow
    //   404: astore 4
    //   406: ldc_w 642
    //   409: istore_1
    //   410: ldc 61
    //   412: new 95	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 644
    //   422: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 4
    //   427: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload_0
    //   437: aload 4
    //   439: invokevirtual 645	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   442: putfield 41	btmsdkobf/ds:nm	Ljava/lang/String;
    //   445: goto -206 -> 239
    //   448: astore 4
    //   450: ldc_w 646
    //   453: istore_1
    //   454: ldc 61
    //   456: new 95	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 648
    //   466: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 4
    //   471: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: aload_0
    //   481: aload 4
    //   483: invokevirtual 649	java/io/IOException:toString	()Ljava/lang/String;
    //   486: putfield 41	btmsdkobf/ds:nm	Ljava/lang/String;
    //   489: goto -250 -> 239
    //   492: astore 4
    //   494: ldc_w 515
    //   497: istore_1
    //   498: ldc 61
    //   500: new 95	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 651
    //   510: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload 4
    //   515: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   518: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 69	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   524: aload_0
    //   525: aload 4
    //   527: invokevirtual 461	java/lang/Throwable:toString	()Ljava/lang/String;
    //   530: putfield 41	btmsdkobf/ds:nm	Ljava/lang/String;
    //   533: goto -294 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	this	ds
    //   1	497	1	i	int
    //   13	255	2	l	long
    //   404	34	4	localInterruptedException	java.lang.InterruptedException
    //   448	34	4	localIOException	java.io.IOException
    //   492	34	4	localThrowable1	Throwable
    //   71	6	5	localObject2	Object
    //   280	18	5	localThrowable2	Throwable
    //   311	6	5	localObject3	Object
    //   319	5	5	localThrowable3	Throwable
    //   334	18	5	localThrowable4	Throwable
    //   365	18	5	localThrowable5	Throwable
    //   396	6	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   23	41	71	finally
    //   43	46	71	finally
    //   73	76	71	finally
    //   104	121	280	java/lang/Throwable
    //   96	104	311	finally
    //   104	121	311	finally
    //   121	129	311	finally
    //   129	136	311	finally
    //   136	144	311	finally
    //   144	161	311	finally
    //   161	169	311	finally
    //   169	176	311	finally
    //   176	179	311	finally
    //   282	308	311	finally
    //   313	316	311	finally
    //   321	331	311	finally
    //   336	362	311	finally
    //   367	393	311	finally
    //   129	136	319	java/lang/Throwable
    //   144	161	334	java/lang/Throwable
    //   169	176	365	java/lang/Throwable
    //   196	227	396	finally
    //   398	401	396	finally
    //   179	196	404	java/lang/InterruptedException
    //   227	239	404	java/lang/InterruptedException
    //   401	404	404	java/lang/InterruptedException
    //   179	196	448	java/io/IOException
    //   227	239	448	java/io/IOException
    //   401	404	448	java/io/IOException
    //   179	196	492	java/lang/Throwable
    //   227	239	492	java/lang/Throwable
    //   401	404	492	java/lang/Throwable
  }
  
  private boolean cG()
  {
    eh.f("TcpNetwork", "isSocketClosed()");
    synchronized (this.np)
    {
      eh.f("TcpNetwork", "isSocketClosed() 1");
      if (this.nq == null) {
        return true;
      }
      boolean bool = this.nq.isClosed();
      eh.f("TcpNetwork", "isSocketClosed() 2");
      return bool;
    }
  }
  
  private NetworkInfo cI()
  {
    try
    {
      NetworkInfo localNetworkInfo = NetworkUtil.getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Throwable localThrowable)
    {
      eh.g("TcpNetwork", "getActiveNetworkInfo--- \n" + localThrowable.getMessage());
    }
    return null;
  }
  
  private String cJ()
  {
    synchronized (this.np)
    {
      if (this.nq == null) {
        return "null";
      }
      String str = this.nq.getLocalAddress().toString();
      return str;
    }
  }
  
  private int cK()
  {
    synchronized (this.np)
    {
      if (this.nq == null) {
        return 0;
      }
      int i = this.nq.getLocalPort();
      return i;
    }
  }
  
  private int d(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        eh.f("TcpNetwork", "[tcp_control]stop(),  bySvr: " + paramBoolean1 + " isRestart: " + paramBoolean2);
        if (!paramBoolean1)
        {
          eh.e("TcpNetwork", "[tcp_control]stop(), !bySvr, set: mIsIgnoreStopExption = true");
          this.nu = true;
        }
        this.nn = true;
        int i = cF();
        if (i != 0)
        {
          if (this.nt != null) {
            this.nt.a(6, "stop socket failed: " + this.nm);
          }
          return i;
        }
        if (this.nt == null) {
          continue;
        }
        if (paramBoolean1)
        {
          this.nt.L(0);
          continue;
        }
        if (!paramBoolean2) {
          break label161;
        }
      }
      finally {}
      this.nt.L(2);
      continue;
      label161:
      this.nt.L(1);
    }
  }
  
  private void d(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.nt != null) {
      ee.cT().addTask(new ik(this, paramInt, paramArrayOfByte), "shark-onreceive-callback");
    }
  }
  
  private boolean isStarted()
  {
    return !this.nn;
  }
  
  private int j(byte[] paramArrayOfByte)
  {
    try
    {
      this.nr.writeInt(paramArrayOfByte.length);
      this.nr.write(paramArrayOfByte);
      return 0;
    }
    catch (Throwable paramArrayOfByte)
    {
      eh.h("TcpNetwork", "sendDataInSync() Throwable: " + paramArrayOfByte.toString());
    }
    return -310000;
  }
  
  public int a(cy.f paramf, byte[] paramArrayOfByte)
  {
    if (cG()) {
      return -190000;
    }
    if (!cH()) {
      return -180000;
    }
    if (paramf.bP())
    {
      eh.h("TcpNetwork", "[time_out]sendDataAsync(), send time out");
      return -17;
    }
    switch (this.nk)
    {
    default: 
      return -1;
    case 0: 
      return b(paramf, paramArrayOfByte);
    }
    return j(paramArrayOfByte);
  }
  
  public String cB()
  {
    return this.nm;
  }
  
  protected int cC()
  {
    if (d(false, true) != 0) {
      return -210000;
    }
    return b(this.mContext, true);
  }
  
  protected boolean cH()
  {
    boolean bool2 = false;
    eh.f("TcpNetwork", "isSocketConnected()");
    synchronized (this.np)
    {
      eh.f("TcpNetwork", "isSocketConnected() 1");
      if (this.nq == null) {
        return false;
      }
      eh.f("TcpNetwork", "isSocketConnected() 2");
      boolean bool1 = bool2;
      if (!cG())
      {
        bool1 = bool2;
        if (this.nq.isConnected()) {
          bool1 = true;
        }
      }
      eh.f("TcpNetwork", "isSocketConnected() 3");
      return bool1;
    }
  }
  
  public dp cq()
  {
    return this.hf;
  }
  
  public int i(Context paramContext)
  {
    return b(paramContext, false);
  }
  
  public boolean isNetworkConnected()
  {
    NetworkInfo localNetworkInfo = cI();
    if (localNetworkInfo == null) {
      return false;
    }
    return localNetworkInfo.isConnected();
  }
  
  public int stop()
  {
    return d(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ds
 * JD-Core Version:    0.7.0.1
 */