package btmsdkobf;

import android.content.Context;
import android.net.NetworkInfo;
import com.tmsdk.base.utils.NetworkUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
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
  private a nt;
  private boolean nu = false;
  
  public ds(Context paramContext, byte paramByte, boolean paramBoolean, a parama, dp paramdp)
  {
    this.mContext = paramContext;
    this.nk = paramByte;
    this.nl = paramBoolean;
    this.nt = parama;
    this.hf = paramdp;
  }
  
  public ds(Context paramContext, a parama, dp paramdp)
  {
    this(paramContext, (byte)0, false, parama, paramdp);
  }
  
  private int a(dp paramdp)
  {
    eh.e("TcpNetwork", "[tcp_control] checkSocketWithRetry()");
    long l3 = System.currentTimeMillis();
    int m = 1;
    paramdp.n(true);
    int n = paramdp.q(true);
    Object localObject1 = null;
    long l1 = 0L;
    int j = 0;
    int i = 0;
    int k;
    while (j < n)
    {
      localObject1 = paramdp.l(true);
      if (localObject1 != null)
      {
        l1 = System.currentTimeMillis();
        k = b((dq.b)localObject1);
        l1 = System.currentTimeMillis() - l1;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkSocketWithRetry(), ipPoint ");
        ((StringBuilder)localObject2).append(((dq.b)localObject1).toString());
        ((StringBuilder)localObject2).append(" localIp ");
        ((StringBuilder)localObject2).append(cJ());
        ((StringBuilder)localObject2).append(" localPort ");
        ((StringBuilder)localObject2).append(cK());
        ((StringBuilder)localObject2).append(" ret: ");
        ((StringBuilder)localObject2).append(k);
        eh.f("TcpNetwork", ((StringBuilder)localObject2).toString());
        l2 = l1;
        i = k;
        localObject2 = localObject1;
        if (k == 0) {
          break label264;
        }
        if (!bz.q(k))
        {
          l2 = l1;
          i = k;
          localObject2 = localObject1;
          break label264;
        }
        if ((j == 0) && (cx.y("tcp connect")))
        {
          i = -160000;
          l2 = l1;
          localObject2 = localObject1;
          break label264;
        }
        paramdp.m(true);
        i = k;
      }
      j += 1;
    }
    Object localObject2 = localObject1;
    long l2 = l1;
    label264:
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramdp.o(bool);
    if (localObject2 != null)
    {
      localObject1 = new dg();
      ((dg)localObject1).mi = ((dq.b)localObject2).getIp();
      ((dg)localObject1).mj = String.valueOf(((dq.b)localObject2).getPort());
      ((dg)localObject1).ml = String.valueOf(cd.e(this.mContext));
      ((dg)localObject1).mn = l2;
      ((dg)localObject1).errorCode = i;
      ((dg)localObject1).mo = this.nm;
      if (j < n) {
        k = j + 1;
      } else {
        k = n;
      }
      ((dg)localObject1).mk = k;
      ((dg)localObject1).f(paramdp.p(true));
      if (j == n) {
        j = m;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        ee.cT().addTask(new Runnable()
        {
          public void run()
          {
            Object localObject = this.a;
            ((dg)localObject).ms = true;
            ((dg)localObject).mt = cx.z("tcp connect");
            this.a.mp = "true";
            localObject = db.bZ();
            if (localObject != null) {
              this.a.d(((db)localObject).bL());
            }
          }
        }, "uploadConnectInfo");
      }
      else
      {
        ((dg)localObject1).ms = false;
        ((dg)localObject1).mp = "false";
        paramdp = db.bZ();
        if (paramdp != null) {
          ((dg)localObject1).d(paramdp.bL());
        }
      }
    }
    paramdp = new StringBuilder();
    paramdp.append("[tcp_control] checkSocketWithRetry(), ret: ");
    paramdp.append(i);
    paramdp.append(" time: ");
    paramdp.append(System.currentTimeMillis() - l3);
    eh.f("TcpNetwork", paramdp.toString());
    return i;
  }
  
  private Socket a(InetAddress paramInetAddress, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("acquireSocketWithTimeOut, addr: ");
    ((StringBuilder)localObject).append(paramInetAddress);
    ((StringBuilder)localObject).append(", port: ");
    ((StringBuilder)localObject).append(paramInt);
    eh.f("TcpNetwork", ((StringBuilder)localObject).toString());
    localObject = new Socket();
    ((Socket)localObject).setSoLinger(false, 0);
    ((Socket)localObject).connect(new InetSocketAddress(paramInetAddress, paramInt), 15000);
    eh.f("TcpNetwork", "acquireSocketWithTimeOut end");
    return localObject;
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
    default: 
      break;
    case 1: 
      this.nq.setSoTimeout(15000);
      break;
    case 0: 
      this.nr = new DataOutputStream(this.nq.getOutputStream());
      eh.f("TcpNetwork", "startSocket() 5");
      this.ns = new DataInputStream(this.nq.getInputStream());
    }
    eh.f("TcpNetwork", "startSocket() 6");
    return cH();
  }
  
  private int b(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = new StringBuilder();
      paramContext.append("[tcp_control]start() isRestart ");
      paramContext.append(paramBoolean);
      eh.e("TcpNetwork", paramContext.toString());
      if (isStarted())
      {
        eh.e("TcpNetwork", "start() already started");
        return 0;
      }
      if (!isNetworkConnected())
      {
        eh.e("TcpNetwork", "start(), no connect");
        return -220000;
      }
      if (this.nt != null) {
        this.nt.L(3);
      }
      int i = a(this.hf);
      if (i != 0)
      {
        eh.g("TcpNetwork", "[tcp_control]connect failed, donot startRcvThread()");
        return i;
      }
      this.nn = false;
      if (this.nk == 0)
      {
        eh.e("TcpNetwork", "[tcp_control]connect succ, startRcvThread()");
        cD();
      }
      if (this.nt != null) {
        if (paramBoolean) {
          this.nt.L(5);
        } else {
          this.nt.L(4);
        }
      }
      return 0;
    }
    finally {}
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[tcp_control]sendDataInAsync(), bf [tcp send] bytes: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.length);
        eh.f("TcpNetwork", ((StringBuilder)localObject).toString());
        this.nr.write(paramArrayOfByte);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[flow_control][tcp_control]sendDataInAsync(), [tcp send] bytes: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.length);
        eh.e("TcpNetwork", ((StringBuilder)localObject).toString());
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
        this.nm = "";
        eh.f("TcpNetwork", "sendDataInAsync() succ");
        return 0;
      }
      return -330000;
    }
    catch (Throwable paramf)
    {
      this.nm = paramf.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("sendDataInAsync() Throwable: ");
      paramArrayOfByte.append(paramf.toString());
      eh.h("TcpNetwork", paramArrayOfByte.toString());
      return -320000;
    }
    catch (SocketException paramf)
    {
      this.nm = paramf.toString();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("sendDataInAsync() SocketException: ");
      paramArrayOfByte.append(paramf.toString());
      eh.h("TcpNetwork", paramArrayOfByte.toString());
    }
  }
  
  private int b(dq.b paramb)
  {
    eh.e("TcpNetwork", "[tcp_control]checkSocket()");
    if (paramb == null) {
      return -10;
    }
    boolean bool = cH();
    int i = 0;
    if (bool)
    {
      eh.g("TcpNetwork", "[tcp_control]checkSocket(), already contected");
      return 0;
    }
    for (;;)
    {
      try
      {
        try
        {
          if (!a(paramb)) {
            break label372;
          }
          eh.i("TcpNetwork", "[tcp_control]checkSocket(), startSocket succ, set: mIsIgnoreStopExption = false");
          this.nu = false;
          this.nm = "";
          return i;
        }
        catch (Throwable localThrowable)
        {
          i = -900000;
          eh.a("TcpNetwork", "checkSocket(), Throwable: ", localThrowable);
          locala = this.nt;
          if (locala != null) {
            locala.a(9, paramb);
          }
          paramb = localThrowable.toString();
        }
        catch (SecurityException localSecurityException)
        {
          i = bz.a(localSecurityException.toString(), -440000);
          eh.a("TcpNetwork", "checkSocket(), SecurityException: ", localSecurityException);
          locala = this.nt;
          if (locala != null) {
            locala.a(9, paramb);
          }
          paramb = localSecurityException.toString();
        }
        catch (SocketException localSocketException)
        {
          i = bz.a(localSocketException.toString(), -420000);
          eh.a("TcpNetwork", "checkSocket(), SocketException: ", localSocketException);
          locala = this.nt;
          if (locala != null) {
            locala.a(9, paramb);
          }
          paramb = localSocketException.toString();
        }
        catch (ConnectException localConnectException)
        {
          i = bz.a(localConnectException.toString(), -500000);
          eh.a("TcpNetwork", "checkSocket(), ConnectException: ", localConnectException);
          locala = this.nt;
          if (locala != null) {
            locala.a(9, paramb);
          }
          paramb = localConnectException.toString();
        }
        this.nm = paramb;
        return i;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        eh.a("TcpNetwork", "checkSocket(), SocketTimeoutException: ", localSocketTimeoutException);
        locala = this.nt;
        if (locala != null) {
          locala.a(8, paramb);
        }
        this.nm = localSocketTimeoutException.toString();
        return -130000;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        eh.a("TcpNetwork", "checkSocket(), UnknownHostException: ", localUnknownHostException);
        a locala = this.nt;
        if (locala != null) {
          locala.a(7, paramb);
        }
        this.nm = localUnknownHostException.toString();
        return -70000;
      }
      label372:
      i = -340000;
    }
  }
  
  private void cD()
  {
    this.no = new Thread("RcvThread")
    {
      public void run()
      {
        eh.e("TcpNetwork", "[tcp_control]RcvThread start...");
        ds.a(ds.this);
        eh.e("TcpNetwork", "[tcp_control]RcvThread end!");
      }
    };
    this.no.setPriority(10);
    this.no.start();
  }
  
  private void cE()
  {
    eh.e("TcpNetwork", "[tcp_control]recv()...");
    if (!this.nn) {}
    for (;;)
    {
      try
      {
        if (!this.nl) {
          break label438;
        }
        i = this.ns.readInt();
        int j = this.ns.readInt();
        if (j >= 1000000)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[flow_control][tcp_control]包有误，数据过大，size >= 1000000, [tcp receive] bytes: ");
          ((StringBuilder)localObject).append(j);
          eh.h("TcpNetwork", ((StringBuilder)localObject).toString());
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[flow_control][tcp_control]recv(), [tcp receive] bytes: ");
        ((StringBuilder)localObject).append(j + 4);
        eh.e("TcpNetwork", ((StringBuilder)localObject).toString());
        localObject = dq.a(this.ns, 0, j, null);
        if (localObject == null)
        {
          eh.h("TcpNetwork", "[tcp_control]recv(), respData == null");
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[tcp_control]notifyOnReceiveData(), respData.length(): ");
        localStringBuilder.append(localObject.length);
        eh.e("TcpNetwork", localStringBuilder.toString());
        d(i, (byte[])localObject);
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[tcp_control]recv() Throwable: ");
        ((StringBuilder)localObject).append(localThrowable);
        eh.b("TcpNetwork", ((StringBuilder)localObject).toString(), localThrowable);
        if (!this.nu)
        {
          d(true, false);
          localObject = this.nt;
          if (localObject != null)
          {
            i = 12;
            ((a)localObject).a(i, localThrowable);
          }
        }
        else
        {
          eh.e("TcpNetwork", "[tcp_control]ignore stop exption");
          this.nn = true;
        }
      }
      catch (EOFException localEOFException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[tcp_control]recv() EOFException: ");
        ((StringBuilder)localObject).append(localEOFException);
        eh.b("TcpNetwork", ((StringBuilder)localObject).toString(), localEOFException);
        if (this.nu) {
          continue;
        }
        d(true, false);
        localObject = this.nt;
        if (localObject != null)
        {
          i = 11;
          continue;
        }
      }
      catch (SocketException localSocketException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[tcp_control]recv(), SocketException: ");
        ((StringBuilder)localObject).append(localSocketException);
        eh.b("TcpNetwork", ((StringBuilder)localObject).toString(), localSocketException);
        if (this.nu) {
          continue;
        }
        d(true, false);
        localObject = this.nt;
        if (localObject != null)
        {
          i = 10;
          continue;
        }
      }
      if (!this.nu) {
        stop();
      }
      eh.e("TcpNetwork", "[tcp_control]recv(), recv thread is stopped, set: mIsIgnoreStopExption = false");
      this.nu = false;
      eh.e("TcpNetwork", "[tcp_control]recv(), end!!!");
      return;
      label438:
      int i = 0;
    }
  }
  
  private int cF()
  {
    eh.f("TcpNetwork", "[tcp_control]stopSocket()");
    long l = System.currentTimeMillis();
    Object localObject2;
    synchronized (this.np)
    {
      Socket localSocket = this.nq;
      int i = 0;
      if (localSocket == null)
      {
        eh.g("TcpNetwork", "[tcp_control]stopSocket(), mSocket is null");
        return 0;
      }
      eh.f("TcpNetwork", "stopSocket() 1");
      if (cG())
      {
        eh.g("TcpNetwork", "[tcp_control]stopSocket(), already closed");
        return 0;
      }
      eh.f("TcpNetwork", "stopSocket() 2");
      synchronized (this.np)
      {
        eh.f("TcpNetwork", "stopSocket() 3");
        StringBuilder localStringBuilder2;
        try
        {
          if (!this.nq.isInputShutdown()) {
            this.nq.shutdownInput();
          }
        }
        catch (Throwable localThrowable2)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("stopSocket(), mSocket.shutdownInput() ");
          localStringBuilder2.append(localThrowable2);
          eh.e("TcpNetwork", localStringBuilder2.toString());
        }
        eh.f("TcpNetwork", "stopSocket() 4");
        try
        {
          this.ns.close();
        }
        catch (Throwable localThrowable3)
        {
          eh.e("TcpNetwork", localThrowable3.getMessage());
        }
        eh.f("TcpNetwork", "stopSocket() 5");
        try
        {
          if (!this.nq.isOutputShutdown()) {
            this.nq.shutdownOutput();
          }
        }
        catch (Throwable localThrowable4)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("stopSocket(), mSocket.shutdownOutput() ");
          localStringBuilder2.append(localThrowable4);
          eh.e("TcpNetwork", localStringBuilder2.toString());
        }
        eh.f("TcpNetwork", "stopSocket() 6");
        try
        {
          this.nr.close();
        }
        catch (Throwable localThrowable5)
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("stopSocket(), mSocketWriter.close() ");
          localStringBuilder2.append(localThrowable5);
          eh.e("TcpNetwork", localStringBuilder2.toString());
        }
        try
        {
          eh.f("TcpNetwork", "stopSocket() 7");
          synchronized (this.np)
          {
            eh.f("TcpNetwork", "stopSocket() 8");
            this.nq.close();
            this.nq = null;
            eh.f("TcpNetwork", "stopSocket() 9");
            Thread.sleep(2000L);
            this.nm = "";
          }
          StringBuilder localStringBuilder1;
          String str1;
          String str2;
          this.nm = ((String)localObject2);
        }
        catch (Throwable localThrowable1)
        {
          i = -900000;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("stopSocket(), Throwable: ");
          localStringBuilder1.append(localThrowable1);
          eh.e("TcpNetwork", localStringBuilder1.toString());
          str1 = localThrowable1.toString();
        }
        catch (IOException localIOException)
        {
          i = -140000;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("stopSocket(), IOException: ");
          localStringBuilder1.append(localIOException);
          eh.e("TcpNetwork", localStringBuilder1.toString());
          str2 = localIOException.toString();
        }
        catch (InterruptedException localInterruptedException)
        {
          i = -270000;
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("stopSocket(), InterruptedException: ");
          localStringBuilder1.append(localInterruptedException);
          eh.e("TcpNetwork", localStringBuilder1.toString());
          localObject2 = localInterruptedException.toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[tcp_control]stopSocket(), ret: ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" stop action use(ms): ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        eh.f("TcpNetwork", ((StringBuilder)localObject2).toString());
        return i;
      }
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getActiveNetworkInfo--- \n");
      localStringBuilder.append(localThrowable.getMessage());
      eh.g("TcpNetwork", localStringBuilder.toString());
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
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[tcp_control]stop(),  bySvr: ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(" isRestart: ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      eh.f("TcpNetwork", ((StringBuilder)localObject1).toString());
      if (!paramBoolean1)
      {
        eh.e("TcpNetwork", "[tcp_control]stop(), !bySvr, set: mIsIgnoreStopExption = true");
        this.nu = true;
      }
      this.nn = true;
      int i = cF();
      if (i != 0)
      {
        if (this.nt != null)
        {
          localObject1 = this.nt;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("stop socket failed: ");
          localStringBuilder.append(this.nm);
          ((a)localObject1).a(6, localStringBuilder.toString());
        }
      }
      else if (this.nt != null) {
        if (paramBoolean1) {
          this.nt.L(0);
        } else if (paramBoolean2) {
          this.nt.L(2);
        } else {
          this.nt.L(1);
        }
      }
      return i;
    }
    finally {}
  }
  
  private void d(final int paramInt, final byte[] paramArrayOfByte)
  {
    if (this.nt != null) {
      ee.cT().addTask(new Runnable()
      {
        public void run()
        {
          try
          {
            ds.b(ds.this).c(paramInt, paramArrayOfByte);
            return;
          }
          catch (Throwable localThrowable)
          {
            eh.h("TcpNetwork", localThrowable.getMessage());
          }
        }
      }, "shark-onreceive-callback");
    }
  }
  
  private boolean isStarted()
  {
    return this.nn ^ true;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendDataInSync() Throwable: ");
      localStringBuilder.append(paramArrayOfByte.toString());
      eh.h("TcpNetwork", localStringBuilder.toString());
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
    case 1: 
      return j(paramArrayOfByte);
    }
    return b(paramf, paramArrayOfByte);
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
    eh.f("TcpNetwork", "isSocketConnected()");
    synchronized (this.np)
    {
      eh.f("TcpNetwork", "isSocketConnected() 1");
      Socket localSocket = this.nq;
      boolean bool2 = false;
      if (localSocket == null) {
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
  
  public static abstract interface a
  {
    public abstract void L(int paramInt);
    
    public abstract void a(int paramInt, Object paramObject);
    
    public abstract void c(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ds
 * JD-Core Version:    0.7.0.1
 */