package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentPedestrianData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class az
{
  private static SparseArray<String> n;
  private be A;
  private bj B;
  private bn C;
  private bk D;
  private bl E;
  private final ap F;
  private String G = "stop";
  private boolean H = false;
  private final Object I = new Object();
  private final TencentLocationRequest J = TencentLocationRequest.create();
  private double K;
  private double L;
  private by M;
  private final boolean N;
  private boolean O;
  private long P;
  private long Q;
  private long R;
  private String S;
  private boolean T;
  public int a = 1;
  public final aw b;
  public final ba c;
  public TencentLocationListener d;
  public boolean e = false;
  public double f = 0.0D;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public TencentLocation j;
  public TencentDistanceListener k;
  public by l;
  public int m = 404;
  private a o;
  private final au p;
  private final bc q;
  private final boolean r;
  private final ay s;
  private final bf t;
  private final bb u;
  private final bd v;
  private a w;
  private volatile boolean x = false;
  private HandlerThread y;
  private int z = 0;
  
  static
  {
    Object localObject = new SparseArray();
    n = (SparseArray)localObject;
    ((SparseArray)localObject).put(0, "OK");
    n.put(1, "ERROR_NETWORK");
    n.put(2, "BAD_JSON");
    n.put(4, "DEFLECT_FAILED");
    n.put(5, "VERIFYKEY_ERROR_NETWORK");
    localObject = new HashMap();
    ((HashMap)localObject).put("https", "true");
    ((HashMap)localObject).put("up_apps", "true");
    ((HashMap)localObject).put("start_daemon", "false");
    ((HashMap)localObject).put("up_daemon_delay", "600000");
    ((HashMap)localObject).put("gps_kalman", "false");
    ((HashMap)localObject).put("min_wifi_scan_interval", "8000");
    ((HashMap)localObject).put("f_coll_item", "2");
    ((HashMap)localObject).put("f_coll_up_net", "w");
    m.a((HashMap)localObject);
  }
  
  public az(ap paramap)
  {
    this.F = paramap;
    this.u = new bb(this.F);
    this.v = new bd(this.F);
    this.A = new be();
    this.b = aw.a(paramap.a);
    this.c = ba.b();
    if (Build.VERSION.SDK_INT >= 18) {}
    for (boolean bool = true;; bool = false)
    {
      this.r = bool;
      if (this.r)
      {
        this.p = null;
        this.t = h();
        if (!this.F.b()) {}
        for (paramap = null;; paramap = new bc(this.F))
        {
          this.q = paramap;
          this.s = g();
          this.N = false;
          this.F.a(this);
          try
          {
            m.a(this.F.a, "txsdk", this.F.b.d());
            return;
          }
          catch (Throwable paramap)
          {
            return;
          }
        }
      }
      else
      {
        this.q = null;
        this.t = h();
        if (!this.F.b()) {}
        for (paramap = localObject;; paramap = new au(this.F))
        {
          this.p = paramap;
          this.s = g();
          this.N = false;
          break;
        }
      }
    }
  }
  
  private static String a(String paramString)
  {
    int i1 = 1;
    if (paramString.contains(",")) {}
    try
    {
      paramString = paramString.split(",");
      if ((paramString == null) || (paramString.length <= 1) || (paramString[0] == null) || (paramString[1] == null) || (com.tencent.tencentmap.lbssdk.service.e.w(paramString[0], paramString[1]) <= 0)) {
        break label86;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      return null;
    }
    i1 = com.tencent.tencentmap.lbssdk.service.e.v(paramString);
    if (i1 >= 0) {
      return Integer.toString(i1);
    }
    return "";
    while (i1 != 0)
    {
      return paramString[0];
      label86:
      i1 = 0;
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (this.o != null) {
      this.o.sendEmptyMessage(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    Object localObject3;
    switch (paramInt1)
    {
    default: 
      localObject3 = null;
      paramInt1 = paramInt2;
    }
    synchronized (this.I)
    {
      for (;;)
      {
        if (this.d != null) {
          this.d.onStatusUpdate((String)localObject3, paramInt1, (String)localObject1);
        }
        return;
        localObject3 = "gps";
        switch (paramInt2)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          localObject1 = "unknown";
          paramInt1 = paramInt2;
          break;
        case 1: 
          localObject1 = "gps enabled";
          paramInt1 = paramInt2;
          break;
        case 0: 
          localObject1 = "gps disabled";
          paramInt1 = paramInt2;
          break;
        case 5: 
          localObject1 = "location permission denied";
          a(3999);
          paramInt1 = paramInt2;
          continue;
          localObject3 = "gps";
          switch (paramInt2)
          {
          default: 
            localObject1 = "unknown";
            paramInt1 = paramInt2;
            break;
          case 3: 
            localObject1 = "gps available";
            paramInt1 = paramInt2;
            break;
          case 4: 
            localObject1 = "gps unavailable";
            paramInt1 = paramInt2;
          }
          break;
        }
      }
      ??? = "cell";
      if (paramInt2 == 1) {
        localObject1 = "cell enabled";
      }
      for (;;)
      {
        localObject3 = ???;
        paramInt1 = paramInt2;
        if (!bz.a) {
          break;
        }
        localObject1 = "location permission denied";
        a(3999);
        paramInt1 = 2;
        localObject3 = ???;
        break;
        if (paramInt2 == 0) {
          localObject1 = "cell disabled";
        } else {
          localObject1 = "unknown";
        }
      }
      String str = "wifi";
      switch (paramInt2)
      {
      case 2: 
      case 3: 
      case 4: 
      default: 
        ??? = "unknown";
      case 0: 
      case 1: 
        for (;;)
        {
          localObject1 = ???;
          localObject3 = str;
          paramInt1 = paramInt2;
          if (paramInt2 == 5) {
            break;
          }
          localObject1 = ???;
          localObject3 = str;
          paramInt1 = paramInt2;
          if (!cg.a) {
            break;
          }
          localObject1 = "location permission denied";
          paramInt1 = 2;
          localObject3 = str;
          break;
          ??? = "wifi disabled";
          continue;
          ??? = "wifi enabled";
        }
      }
      ??? = "location service switch is off";
      a(3999);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.o != null)
    {
      this.o.removeMessages(paramInt);
      this.o.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, by paramby)
  {
    int i3 = 1;
    if (paramby == null) {
      return;
    }
    if ((paramInt == 0) && (paramby.getLatitude() != 0.0D) && (paramby.getLongitude() != 0.0D)) {
      if ((this.a != 1) || (!ca.a(paramby.getLatitude(), paramby.getLongitude()))) {
        break label767;
      }
    }
    label246:
    label761:
    label767:
    for (int i1 = 1;; i1 = 0)
    {
      by.a(paramby, i1);
      if (m()) {
        if ((this.m == 0) || (paramInt != 0)) {
          break label761;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        this.m = paramInt;
        this.l = paramby;
        if ((paramby.getAccuracy() < 500.0F) && (paramby.getAccuracy() > 0.0F))
        {
          this.A.a(paramby);
          if (this.e) {
            this.j = paramby;
          }
        }
        this.K = paramby.getLatitude();
        this.L = paramby.getLongitude();
        int i2;
        if (this.d != null)
        {
          i2 = 1;
          if ((i2 != 0) && (this.J.getInterval() > 0L) && (!this.J.getExtras().getBoolean("daemon")))
          {
            a(11999, this.J.getInterval());
            if (this.J.getCheckInterval() != -1L) {
              a(3998, this.J.getCheckInterval());
            }
          }
          if (i1 != 0) {
            a(11998);
          }
          if ((this.m == 0) || (paramInt != 0)) {
            break label755;
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          i2 = i1;
          if (this.m == 0)
          {
            i2 = i1;
            if (this.l != null)
            {
              i2 = i1;
              if (this.l.getProvider().equals("network"))
              {
                i2 = i1;
                if (paramInt == 0)
                {
                  i2 = i1;
                  if (paramby != null)
                  {
                    i2 = i1;
                    if (paramby.getProvider().equals("gps")) {
                      i2 = 1;
                    }
                  }
                }
              }
            }
          }
          this.m = paramInt;
          this.l = paramby;
          new StringBuilder("updateLast").append(paramby.getLatitude()).append(",").append(paramby.getLongitude());
          if (this.J.getInterval() == 0L)
          {
            if (this.d == null) {
              break label745;
            }
            paramInt = 1;
            if (paramInt != 0) {
              a(11998);
            }
          }
          if (i2 == 0) {
            break;
          }
          if (this.d != null) {}
          for (paramInt = i3;; paramInt = 0)
          {
            if (paramInt == 0) {
              break label753;
            }
            a(11998);
            return;
            i2 = 0;
            break;
            if ((paramInt != 0) || (paramby.getLatitude() == 0.0D) || (paramby.getLongitude() == 0.0D) || (Math.abs(paramby.getLatitude() - this.K) < 1.0E-007D) || (Math.abs(paramby.getLongitude() - this.L) < 1.0E-007D)) {
              break label246;
            }
            if (!this.A.a(paramby, this.F))
            {
              new StringBuilder("discard ").append(paramby);
              return;
            }
            this.K = paramby.getLatitude();
            this.L = paramby.getLongitude();
            if ((paramby.getAccuracy() >= 500.0F) || (paramby.getAccuracy() <= 0.0F)) {
              break label246;
            }
            this.A.a(paramby);
            this.A.a(paramby);
            if (!this.e) {
              break label246;
            }
            if (this.j != null)
            {
              double d1 = cf.a(this.j.getLatitude(), this.j.getLongitude(), paramby.getLatitude(), paramby.getLongitude());
              if (((!paramby.getProvider().equalsIgnoreCase("network")) || (d1 <= 10.0D)) && ((!paramby.getProvider().equalsIgnoreCase("gps")) || (d1 <= 3.0D))) {
                break label246;
              }
              this.f = (d1 + this.f);
              if (paramby.getProvider().equalsIgnoreCase("network")) {
                this.h += 1;
              }
              for (;;)
              {
                this.i += 1;
                this.j = paramby;
                break;
                this.g += 1;
              }
            }
            this.j = paramby;
            break label246;
            paramInt = 0;
            break label400;
          }
          break;
        }
      }
    }
  }
  
  @Nullable
  private ay g()
  {
    if (!this.F.d()) {
      return null;
    }
    return new ay(this.F);
  }
  
  @Nullable
  private bf h()
  {
    if (!this.F.c()) {
      return null;
    }
    return new bf(this.F);
  }
  
  private aj i()
  {
    try
    {
      Object localObject = this.F.b;
      localObject = new aj(((al)localObject).j, ((al)localObject).d(), ((al)localObject).f());
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return new aj("unknown", "unknown", "unknown");
  }
  
  private void j()
  {
    if ((this.z != 0) || (!n.a().d("start_daemon"))) {}
    for (;;)
    {
      return;
      this.P = n.a().c("up_daemon_delay");
      if (this.P < 120000L) {
        this.P = 120000L;
      }
      try
      {
        if (cg.c(this.F).equalsIgnoreCase("{}"))
        {
          TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create().setInterval(this.P).setRequestLevel(0);
          localTencentLocationRequest.getExtras().putBoolean("daemon", true);
          az.2 local2 = new az.2(this);
          this.y = new HandlerThread("daemonthread");
          this.y.start();
          a(localTencentLocationRequest, local2, this.y.getLooper());
          this.z = 1;
          this.Q = System.currentTimeMillis();
          return;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private void k()
  {
    int i2 = 1;
    bz.a = false;
    this.u.a();
    this.v.a();
    this.A.a();
    if (this.t != null)
    {
      i1 = 1;
      if (i1 != 0) {
        this.t.a();
      }
      if (!this.r) {
        break label200;
      }
      if (this.q == null) {
        break label195;
      }
      i1 = 1;
      label63:
      if (i1 != 0) {
        this.q.a();
      }
      label74:
      if (this.s == null) {
        break label228;
      }
      i1 = 1;
      label83:
      if (i1 != 0) {
        this.s.a();
      }
      if ((this.J.isAllowDirection()) && (!this.b.a)) {
        this.b.a();
      }
      if (!this.J.getExtras().getBoolean("daemon")) {
        if (this.c == null) {
          break label233;
        }
      }
    }
    label195:
    label200:
    label226:
    label228:
    label233:
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 != 0) {
        this.c.c();
      }
      if (this.x)
      {
        m.a().c();
        this.x = false;
      }
      if (this.w != null) {
        this.w.a();
      }
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label63;
      if (this.p != null) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label226;
        }
        this.p.a();
        break;
      }
      break label74;
      i1 = 0;
      break label83;
    }
  }
  
  private void l()
  {
    this.l = null;
    this.m = 404;
    this.C = null;
    this.B = null;
    this.D = null;
    this.H = false;
    this.T = false;
    bl.a = 0;
    this.F.a("cell").a();
  }
  
  private boolean m()
  {
    return this.m == 404;
  }
  
  private boolean n()
  {
    if (this.s != null)
    {
      int i1;
      if (this.s.b())
      {
        ay localay = this.s;
        if ((localay.c & 0x2) != 2) {
          break label65;
        }
        if (System.currentTimeMillis() - localay.a < ax.a().b()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          return true;
          i1 = 0;
        }
        else
        {
          return false;
          label65:
          i1 = 0;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper arg3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 151	c/t/m/g/az:z	I
    //   4: iconst_1
    //   5: if_icmpne +32 -> 37
    //   8: aload_0
    //   9: invokevirtual 713	c/t/m/g/az:d	()V
    //   12: aload_0
    //   13: getfield 570	c/t/m/g/az:y	Landroid/os/HandlerThread;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: getfield 570	c/t/m/g/az:y	Landroid/os/HandlerThread;
    //   23: invokevirtual 716	android/os/HandlerThread:quit	()Z
    //   26: pop
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 570	c/t/m/g/az:y	Landroid/os/HandlerThread;
    //   32: aload_0
    //   33: iconst_0
    //   34: putfield 151	c/t/m/g/az:z	I
    //   37: invokestatic 721	com/tencent/map/geolocation/TencentLocationManagerOptions:isLoadLibraryEnabled	()Z
    //   40: ifeq +15 -> 55
    //   43: ldc_w 723
    //   46: invokestatic 726	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   49: ldc_w 728
    //   52: invokestatic 726	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 181	c/t/m/g/az:F	Lc/t/m/g/ap;
    //   59: astore 10
    //   61: aload 10
    //   63: getfield 250	c/t/m/g/ap:b	Lc/t/m/g/al;
    //   66: astore 9
    //   68: ldc_w 730
    //   71: aload 9
    //   73: invokevirtual 732	c/t/m/g/al:a	()Ljava/lang/String;
    //   76: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +22 -> 101
    //   82: ldc_w 730
    //   85: aload 9
    //   87: invokevirtual 734	c/t/m/g/al:b	()Ljava/lang/String;
    //   90: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +8 -> 101
    //   96: aload 10
    //   98: invokevirtual 735	c/t/m/g/ap:a	()V
    //   101: aload 9
    //   103: getfield 737	c/t/m/g/al:g	Ljava/lang/String;
    //   106: invokestatic 741	c/t/m/g/ai:e	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 10
    //   111: aload_0
    //   112: aload 10
    //   114: invokestatic 743	c/t/m/g/az:a	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 703	c/t/m/g/az:S	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 703	c/t/m/g/az:S	Ljava/lang/String;
    //   124: invokestatic 748	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifeq +30 -> 157
    //   130: new 437	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 750
    //   137: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload 10
    //   142: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 752
    //   148: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: iconst_2
    //   153: ireturn
    //   154: astore_1
    //   155: iconst_3
    //   156: ireturn
    //   157: aload_0
    //   158: invokespecial 754	c/t/m/g/az:l	()V
    //   161: aload_0
    //   162: getfield 169	c/t/m/g/az:I	Ljava/lang/Object;
    //   165: astore 10
    //   167: aload 10
    //   169: monitorenter
    //   170: aload_0
    //   171: aload_2
    //   172: putfield 316	c/t/m/g/az:d	Lcom/tencent/map/geolocation/TencentLocationListener;
    //   175: aload 10
    //   177: monitorexit
    //   178: aload_0
    //   179: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   182: aload_1
    //   183: invokestatic 758	com/tencent/map/geolocation/TencentLocationRequest:copy	(Lcom/tencent/map/geolocation/TencentLocationRequest;Lcom/tencent/map/geolocation/TencentLocationRequest;)V
    //   186: aload 9
    //   188: aload_1
    //   189: invokevirtual 761	com/tencent/map/geolocation/TencentLocationRequest:getQQ	()Ljava/lang/String;
    //   192: putfield 763	c/t/m/g/al:f	Ljava/lang/String;
    //   195: aload 9
    //   197: getfield 765	c/t/m/g/al:d	Ljava/lang/String;
    //   200: invokestatic 741	c/t/m/g/ai:e	(Ljava/lang/String;)Ljava/lang/String;
    //   203: invokestatic 748	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifeq +12 -> 218
    //   209: aload 9
    //   211: aload_1
    //   212: invokevirtual 768	com/tencent/map/geolocation/TencentLocationRequest:getPhoneNumber	()Ljava/lang/String;
    //   215: putfield 765	c/t/m/g/al:d	Ljava/lang/String;
    //   218: aload_1
    //   219: invokevirtual 407	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   222: lconst_0
    //   223: lcmp
    //   224: ifne +1300 -> 1524
    //   227: ldc2_w 769
    //   230: lstore 5
    //   232: aload 9
    //   234: invokestatic 532	c/t/m/g/n:a	()Lc/t/m/g/n;
    //   237: ldc 126
    //   239: invokevirtual 537	c/t/m/g/n:c	(Ljava/lang/String;)J
    //   242: lload 5
    //   244: invokestatic 774	java/lang/Math:max	(JJ)J
    //   247: putfield 776	c/t/m/g/al:k	J
    //   250: invokestatic 781	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   253: ifnonnull +6 -> 259
    //   256: invokestatic 784	android/os/Looper:prepare	()V
    //   259: aload_0
    //   260: getfield 309	c/t/m/g/az:o	Lc/t/m/g/az$a;
    //   263: ifnonnull +1270 -> 1533
    //   266: iconst_1
    //   267: istore 4
    //   269: iload 4
    //   271: ifeq +1268 -> 1539
    //   274: aload_0
    //   275: new 6	c/t/m/g/az$a
    //   278: dup
    //   279: aload_0
    //   280: aload_3
    //   281: invokespecial 787	c/t/m/g/az$a:<init>	(Lc/t/m/g/az;Landroid/os/Looper;)V
    //   284: putfield 309	c/t/m/g/az:o	Lc/t/m/g/az$a;
    //   287: aload_0
    //   288: invokespecial 789	c/t/m/g/az:k	()V
    //   291: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   294: lstore 5
    //   296: new 437	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 791
    //   303: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   309: lload 5
    //   311: lsub
    //   312: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   320: invokevirtual 411	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   323: ldc_w 796
    //   326: iconst_1
    //   327: invokevirtual 799	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   330: istore 7
    //   332: aload_0
    //   333: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   336: invokevirtual 411	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
    //   339: ldc_w 413
    //   342: invokevirtual 419	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   345: istore 8
    //   347: aload_0
    //   348: getfield 309	c/t/m/g/az:o	Lc/t/m/g/az$a;
    //   351: astore_1
    //   352: aload_0
    //   353: getfield 187	c/t/m/g/az:u	Lc/t/m/g/bb;
    //   356: astore_2
    //   357: aload_2
    //   358: getfield 801	c/t/m/g/bb:b	Z
    //   361: ifne +34 -> 395
    //   364: aload_2
    //   365: iconst_1
    //   366: putfield 801	c/t/m/g/bb:b	Z
    //   369: new 803	android/content/IntentFilter
    //   372: dup
    //   373: ldc_w 805
    //   376: invokespecial 806	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   379: astore_3
    //   380: aload_2
    //   381: getfield 808	c/t/m/g/bb:a	Lc/t/m/g/ap;
    //   384: getfield 202	c/t/m/g/ap:a	Landroid/content/Context;
    //   387: aload_2
    //   388: aload_3
    //   389: aconst_null
    //   390: aload_1
    //   391: invokevirtual 814	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   394: pop
    //   395: aload_0
    //   396: getfield 192	c/t/m/g/az:v	Lc/t/m/g/bd;
    //   399: astore_2
    //   400: aload_2
    //   401: getfield 816	c/t/m/g/bd:g	Z
    //   404: ifne +36 -> 440
    //   407: aload_2
    //   408: iconst_1
    //   409: putfield 816	c/t/m/g/bd:g	Z
    //   412: aload_2
    //   413: getfield 818	c/t/m/g/bd:b	Lc/t/m/g/ap;
    //   416: getfield 821	c/t/m/g/ap:d	Ljava/util/concurrent/ExecutorService;
    //   419: new 823	c/t/m/g/bd$1
    //   422: dup
    //   423: aload_2
    //   424: aload_1
    //   425: invokespecial 826	c/t/m/g/bd$1:<init>	(Lc/t/m/g/bd;Landroid/os/Handler;)V
    //   428: invokeinterface 832 2 0
    //   433: aload_2
    //   434: invokestatic 837	android/os/SystemClock:elapsedRealtime	()J
    //   437: putfield 839	c/t/m/g/bd:f	J
    //   440: new 437	java/lang/StringBuilder
    //   443: dup
    //   444: ldc_w 841
    //   447: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   453: lload 5
    //   455: lsub
    //   456: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: iload 8
    //   462: ifeq +18 -> 480
    //   465: aload_0
    //   466: getfield 192	c/t/m/g/az:v	Lc/t/m/g/bd;
    //   469: aload_0
    //   470: getfield 181	c/t/m/g/az:F	Lc/t/m/g/ap;
    //   473: iconst_1
    //   474: invokevirtual 844	c/t/m/g/ap:a	(Z)Ljava/lang/String;
    //   477: invokevirtual 846	c/t/m/g/bd:a	(Ljava/lang/String;)V
    //   480: new 437	java/lang/StringBuilder
    //   483: dup
    //   484: ldc_w 848
    //   487: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   490: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   493: lload 5
    //   495: lsub
    //   496: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_0
    //   501: getfield 223	c/t/m/g/az:r	Z
    //   504: ifeq +1100 -> 1604
    //   507: iload 7
    //   509: ifeq +129 -> 638
    //   512: aload_0
    //   513: getfield 235	c/t/m/g/az:q	Lc/t/m/g/bc;
    //   516: ifnull +1058 -> 1574
    //   519: iconst_1
    //   520: istore 4
    //   522: iload 4
    //   524: ifeq +114 -> 638
    //   527: aload_0
    //   528: getfield 235	c/t/m/g/az:q	Lc/t/m/g/bc;
    //   531: astore_2
    //   532: aload_2
    //   533: getfield 849	c/t/m/g/bc:a	Z
    //   536: ifne +102 -> 638
    //   539: aload_2
    //   540: aload_1
    //   541: putfield 852	c/t/m/g/bc:i	Landroid/os/Handler;
    //   544: aload_2
    //   545: new 565	android/os/HandlerThread
    //   548: dup
    //   549: ldc_w 854
    //   552: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   555: putfield 856	c/t/m/g/bc:f	Landroid/os/HandlerThread;
    //   558: aload_2
    //   559: getfield 856	c/t/m/g/bc:f	Landroid/os/HandlerThread;
    //   562: ifnull +76 -> 638
    //   565: aload_2
    //   566: getfield 852	c/t/m/g/bc:i	Landroid/os/Handler;
    //   569: ifnull +69 -> 638
    //   572: aload_2
    //   573: getfield 856	c/t/m/g/bc:f	Landroid/os/HandlerThread;
    //   576: invokevirtual 573	android/os/HandlerThread:start	()V
    //   579: aload_2
    //   580: new 858	c/t/m/g/bc$a
    //   583: dup
    //   584: aload_2
    //   585: aload_2
    //   586: getfield 856	c/t/m/g/bc:f	Landroid/os/HandlerThread;
    //   589: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   592: iconst_0
    //   593: invokespecial 861	c/t/m/g/bc$a:<init>	(Lc/t/m/g/bc;Landroid/os/Looper;B)V
    //   596: putfield 864	c/t/m/g/bc:g	Lc/t/m/g/bc$a;
    //   599: aload_2
    //   600: iconst_1
    //   601: putfield 849	c/t/m/g/bc:a	Z
    //   604: iload 8
    //   606: ifne +13 -> 619
    //   609: aload_2
    //   610: getfield 864	c/t/m/g/bc:g	Lc/t/m/g/bc$a;
    //   613: iconst_0
    //   614: lconst_0
    //   615: invokestatic 867	c/t/m/g/ai:a	(Landroid/os/Handler;IJ)Z
    //   618: pop
    //   619: aload_2
    //   620: getfield 864	c/t/m/g/bc:g	Lc/t/m/g/bc$a;
    //   623: new 869	c/t/m/g/bc$1
    //   626: dup
    //   627: aload_2
    //   628: invokespecial 872	c/t/m/g/bc$1:<init>	(Lc/t/m/g/bc;)V
    //   631: ldc2_w 873
    //   634: invokevirtual 878	c/t/m/g/bc$a:postDelayed	(Ljava/lang/Runnable;J)Z
    //   637: pop
    //   638: new 437	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 880
    //   645: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   651: lload 5
    //   653: lsub
    //   654: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: iload 7
    //   660: ifeq +99 -> 759
    //   663: aload_0
    //   664: getfield 230	c/t/m/g/az:t	Lc/t/m/g/bf;
    //   667: ifnull +1089 -> 1756
    //   670: iconst_1
    //   671: istore 4
    //   673: iload 4
    //   675: ifeq +84 -> 759
    //   678: aload_0
    //   679: getfield 230	c/t/m/g/az:t	Lc/t/m/g/bf;
    //   682: astore_2
    //   683: aload_2
    //   684: getfield 881	c/t/m/g/bf:a	Z
    //   687: ifne +72 -> 759
    //   690: aload_2
    //   691: iconst_1
    //   692: putfield 881	c/t/m/g/bf:a	Z
    //   695: aload_2
    //   696: iconst_0
    //   697: putfield 883	c/t/m/g/bf:d	Z
    //   700: aload_2
    //   701: iload 8
    //   703: putfield 885	c/t/m/g/bf:c	Z
    //   706: aload_1
    //   707: putstatic 887	c/t/m/g/bf:e	Landroid/os/Handler;
    //   710: new 803	android/content/IntentFilter
    //   713: dup
    //   714: invokespecial 888	android/content/IntentFilter:<init>	()V
    //   717: astore_3
    //   718: aload_3
    //   719: ldc_w 890
    //   722: invokevirtual 893	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   725: aload_3
    //   726: ldc_w 895
    //   729: invokevirtual 893	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   732: aload_2
    //   733: getfield 896	c/t/m/g/bf:b	Lc/t/m/g/ap;
    //   736: getfield 202	c/t/m/g/ap:a	Landroid/content/Context;
    //   739: aload_2
    //   740: aload_3
    //   741: aconst_null
    //   742: aload_1
    //   743: invokevirtual 814	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   746: pop
    //   747: aload_2
    //   748: getfield 885	c/t/m/g/bf:c	Z
    //   751: ifne +8 -> 759
    //   754: aload_2
    //   755: lconst_0
    //   756: invokevirtual 899	c/t/m/g/bf:a	(J)V
    //   759: new 437	java/lang/StringBuilder
    //   762: dup
    //   763: ldc_w 901
    //   766: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   769: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   772: lload 5
    //   774: lsub
    //   775: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: iload 8
    //   781: ifne +8 -> 789
    //   784: aload_0
    //   785: iconst_1
    //   786: putfield 706	c/t/m/g/az:O	Z
    //   789: aload_0
    //   790: getfield 240	c/t/m/g/az:s	Lc/t/m/g/ay;
    //   793: ifnull +969 -> 1762
    //   796: iconst_1
    //   797: istore 4
    //   799: iload 4
    //   801: ifeq +175 -> 976
    //   804: aload_0
    //   805: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   808: invokevirtual 904	com/tencent/map/geolocation/TencentLocationRequest:isAllowGPS	()Z
    //   811: ifeq +165 -> 976
    //   814: aload_0
    //   815: getfield 240	c/t/m/g/az:s	Lc/t/m/g/ay;
    //   818: astore_2
    //   819: aload_0
    //   820: getfield 147	c/t/m/g/az:a	I
    //   823: iconst_1
    //   824: if_icmpne +944 -> 1768
    //   827: iconst_1
    //   828: istore 7
    //   830: aload_2
    //   831: iload 7
    //   833: putfield 906	c/t/m/g/ay:f	Z
    //   836: aload_0
    //   837: getfield 240	c/t/m/g/az:s	Lc/t/m/g/ay;
    //   840: astore_2
    //   841: aload_0
    //   842: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   845: invokevirtual 407	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   848: pop2
    //   849: aload_2
    //   850: getfield 907	c/t/m/g/ay:d	Z
    //   853: ifne +123 -> 976
    //   856: aload_2
    //   857: iconst_1
    //   858: putfield 907	c/t/m/g/ay:d	Z
    //   861: aload_2
    //   862: new 565	android/os/HandlerThread
    //   865: dup
    //   866: ldc_w 909
    //   869: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   872: putfield 911	c/t/m/g/ay:g	Landroid/os/HandlerThread;
    //   875: aload_2
    //   876: getfield 912	c/t/m/g/ay:b	Lc/t/m/g/ap;
    //   879: getfield 915	c/t/m/g/ap:h	Landroid/location/LocationManager;
    //   882: astore_3
    //   883: aload_2
    //   884: getfield 911	c/t/m/g/ay:g	Landroid/os/HandlerThread;
    //   887: invokevirtual 573	android/os/HandlerThread:start	()V
    //   890: aload_2
    //   891: new 917	android/os/Handler
    //   894: dup
    //   895: aload_2
    //   896: getfield 911	c/t/m/g/ay:g	Landroid/os/HandlerThread;
    //   899: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   902: invokespecial 920	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   905: putfield 921	c/t/m/g/ay:i	Landroid/os/Handler;
    //   908: iload 8
    //   910: ifne +864 -> 1774
    //   913: aload_2
    //   914: getfield 912	c/t/m/g/ay:b	Lc/t/m/g/ap;
    //   917: getfield 915	c/t/m/g/ap:h	Landroid/location/LocationManager;
    //   920: ldc_w 324
    //   923: ldc2_w 873
    //   926: fconst_0
    //   927: aload_2
    //   928: getfield 923	c/t/m/g/ay:j	Lc/t/m/g/ay;
    //   931: aload_2
    //   932: getfield 911	c/t/m/g/ay:g	Landroid/os/HandlerThread;
    //   935: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   938: invokestatic 928	alky:a	(Landroid/location/LocationManager;Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   941: aload_2
    //   942: getfield 921	c/t/m/g/ay:i	Landroid/os/Handler;
    //   945: aload_2
    //   946: getfield 931	c/t/m/g/ay:h	Ljava/lang/Runnable;
    //   949: invokevirtual 935	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   952: pop
    //   953: aload_2
    //   954: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   957: putfield 937	c/t/m/g/ay:e	J
    //   960: aload_2
    //   961: invokevirtual 629	c/t/m/g/ay:b	()Z
    //   964: ifeq +12 -> 976
    //   967: aload_2
    //   968: iconst_4
    //   969: putfield 631	c/t/m/g/ay:c	I
    //   972: aload_2
    //   973: invokevirtual 938	c/t/m/g/ay:c	()V
    //   976: new 437	java/lang/StringBuilder
    //   979: dup
    //   980: ldc_w 940
    //   983: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   986: invokestatic 585	java/lang/System:currentTimeMillis	()J
    //   989: lload 5
    //   991: lsub
    //   992: invokevirtual 794	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload_0
    //   997: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1000: invokevirtual 598	com/tencent/map/geolocation/TencentLocationRequest:isAllowDirection	()Z
    //   1003: ifeq +23 -> 1026
    //   1006: aload_0
    //   1007: getfield 209	c/t/m/g/az:b	Lc/t/m/g/aw;
    //   1010: getfield 599	c/t/m/g/aw:a	Z
    //   1013: ifne +13 -> 1026
    //   1016: aload_0
    //   1017: getfield 209	c/t/m/g/az:b	Lc/t/m/g/aw;
    //   1020: aload_1
    //   1021: aconst_null
    //   1022: invokevirtual 943	c/t/m/g/aw:a	(Landroid/os/Handler;Lcom/tencent/map/geolocation/TencentDirectionListener;)I
    //   1025: pop
    //   1026: iload 8
    //   1028: ifne +147 -> 1175
    //   1031: aload_0
    //   1032: getfield 177	c/t/m/g/az:J	Lcom/tencent/map/geolocation/TencentLocationRequest;
    //   1035: invokevirtual 946	com/tencent/map/geolocation/TencentLocationRequest:isAllowPedometer	()Z
    //   1038: ifeq +137 -> 1175
    //   1041: aload_0
    //   1042: getfield 216	c/t/m/g/az:c	Lc/t/m/g/ba;
    //   1045: astore_2
    //   1046: aload_0
    //   1047: getfield 181	c/t/m/g/az:F	Lc/t/m/g/ap;
    //   1050: getfield 202	c/t/m/g/ap:a	Landroid/content/Context;
    //   1053: putstatic 948	c/t/m/g/ba:f	Landroid/content/Context;
    //   1056: ldc_w 950
    //   1059: invokestatic 955	c/t/m/g/am:a	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   1062: putstatic 958	c/t/m/g/ba:i	Landroid/content/SharedPreferences;
    //   1065: aload_2
    //   1066: new 565	android/os/HandlerThread
    //   1069: dup
    //   1070: ldc_w 960
    //   1073: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1076: putfield 961	c/t/m/g/ba:g	Landroid/os/HandlerThread;
    //   1079: aload_2
    //   1080: getfield 961	c/t/m/g/ba:g	Landroid/os/HandlerThread;
    //   1083: invokevirtual 573	android/os/HandlerThread:start	()V
    //   1086: aload_2
    //   1087: getfield 964	c/t/m/g/ba:a	Lc/t/m/g/ao;
    //   1090: aload_2
    //   1091: putfield 969	c/t/m/g/ao:i	Lc/t/m/g/at;
    //   1094: getstatic 221	android/os/Build$VERSION:SDK_INT	I
    //   1097: bipush 23
    //   1099: if_icmpeq +19 -> 1118
    //   1102: aload_2
    //   1103: getstatic 948	c/t/m/g/ba:f	Landroid/content/Context;
    //   1106: ldc_w 971
    //   1109: invokevirtual 975	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1112: checkcast 977	android/hardware/SensorManager
    //   1115: putfield 980	c/t/m/g/ba:b	Landroid/hardware/SensorManager;
    //   1118: aload_2
    //   1119: getfield 980	c/t/m/g/ba:b	Landroid/hardware/SensorManager;
    //   1122: ifnull +49 -> 1171
    //   1125: aload_2
    //   1126: aload_2
    //   1127: getfield 980	c/t/m/g/ba:b	Landroid/hardware/SensorManager;
    //   1130: iconst_1
    //   1131: invokevirtual 984	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1134: putfield 987	c/t/m/g/ba:c	Landroid/hardware/Sensor;
    //   1137: aload_2
    //   1138: aload_2
    //   1139: getfield 980	c/t/m/g/ba:b	Landroid/hardware/SensorManager;
    //   1142: bipush 10
    //   1144: invokevirtual 984	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1147: putfield 989	c/t/m/g/ba:d	Landroid/hardware/Sensor;
    //   1150: getstatic 221	android/os/Build$VERSION:SDK_INT	I
    //   1153: bipush 19
    //   1155: if_icmplt +16 -> 1171
    //   1158: aload_2
    //   1159: aload_2
    //   1160: getfield 980	c/t/m/g/ba:b	Landroid/hardware/SensorManager;
    //   1163: bipush 19
    //   1165: invokevirtual 984	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   1168: putfield 991	c/t/m/g/ba:e	Landroid/hardware/Sensor;
    //   1171: aload_2
    //   1172: invokevirtual 992	c/t/m/g/ba:d	()V
    //   1175: invokestatic 532	c/t/m/g/n:a	()Lc/t/m/g/n;
    //   1178: ldc 130
    //   1180: invokevirtual 994	c/t/m/g/n:b	(Ljava/lang/String;)I
    //   1183: istore 4
    //   1185: iload 4
    //   1187: iconst_1
    //   1188: if_icmpeq +9 -> 1197
    //   1191: iload 4
    //   1193: iconst_2
    //   1194: if_icmpne +28 -> 1222
    //   1197: aload_0
    //   1198: getfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1201: ifnonnull +21 -> 1222
    //   1204: aload_0
    //   1205: new 610	c/t/m/g/a
    //   1208: dup
    //   1209: aload_0
    //   1210: getfield 181	c/t/m/g/az:F	Lc/t/m/g/ap;
    //   1213: getfield 202	c/t/m/g/ap:a	Landroid/content/Context;
    //   1216: invokespecial 997	c/t/m/g/a:<init>	(Landroid/content/Context;)V
    //   1219: putfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1222: aload_0
    //   1223: getfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1226: ifnull +276 -> 1502
    //   1229: aload_1
    //   1230: ifnull +272 -> 1502
    //   1233: new 437	java/lang/StringBuilder
    //   1236: dup
    //   1237: ldc_w 999
    //   1240: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1243: iload 4
    //   1245: invokevirtual 696	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1248: ldc_w 1001
    //   1251: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: iload 8
    //   1256: invokevirtual 1004	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1259: ldc_w 1006
    //   1262: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1265: invokestatic 1008	c/t/m/g/a:e	()Ljava/lang/String;
    //   1268: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: iload 4
    //   1274: iconst_2
    //   1275: if_icmpeq +14 -> 1289
    //   1278: iload 4
    //   1280: iconst_1
    //   1281: if_icmpne +221 -> 1502
    //   1284: iload 8
    //   1286: ifne +216 -> 1502
    //   1289: aload_0
    //   1290: getfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1293: astore_3
    //   1294: aload_0
    //   1295: invokespecial 1010	c/t/m/g/az:i	()Lc/t/m/g/aj;
    //   1298: astore_2
    //   1299: aload_3
    //   1300: getfield 1013	c/t/m/g/a:a	[B
    //   1303: astore_3
    //   1304: aload_3
    //   1305: monitorenter
    //   1306: aload_2
    //   1307: putstatic 1018	c/t/m/g/h:i	Lc/t/m/g/aj;
    //   1310: invokestatic 1020	c/t/m/g/ai:a	()Z
    //   1313: ifeq +80 -> 1393
    //   1316: iconst_3
    //   1317: ldc_w 1022
    //   1320: new 437	java/lang/StringBuilder
    //   1323: dup
    //   1324: ldc_w 1024
    //   1327: invokespecial 442	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1330: aload_2
    //   1331: getfield 1026	c/t/m/g/aj:b	Ljava/lang/String;
    //   1334: invokestatic 1027	c/t/m/g/aj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1337: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: ldc_w 1029
    //   1343: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1346: aload_2
    //   1347: getfield 1031	c/t/m/g/aj:a	Ljava/lang/String;
    //   1350: invokestatic 1027	c/t/m/g/aj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1353: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1356: ldc_w 280
    //   1359: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: getstatic 1036	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1365: invokestatic 1027	c/t/m/g/aj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1368: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: ldc_w 280
    //   1374: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: invokestatic 1040	c/t/m/g/an:g	()Ljava/lang/String;
    //   1380: invokestatic 1027	c/t/m/g/aj:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1383: invokevirtual 449	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 1042	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: aconst_null
    //   1390: invokestatic 1045	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1393: aload_3
    //   1394: monitorexit
    //   1395: aload_0
    //   1396: getfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1399: ldc_w 1047
    //   1402: invokestatic 532	c/t/m/g/n:a	()Lc/t/m/g/n;
    //   1405: ldc 134
    //   1407: invokevirtual 1048	c/t/m/g/n:e	(Ljava/lang/String;)Ljava/lang/String;
    //   1410: invokevirtual 1051	c/t/m/g/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1413: aload_0
    //   1414: getfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1417: ldc_w 1053
    //   1420: ldc 118
    //   1422: invokevirtual 1051	c/t/m/g/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1425: aload_0
    //   1426: getfield 608	c/t/m/g/az:w	Lc/t/m/g/a;
    //   1429: astore_3
    //   1430: aload_1
    //   1431: invokevirtual 1054	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1434: astore_2
    //   1435: aload_3
    //   1436: getfield 1013	c/t/m/g/a:a	[B
    //   1439: astore 9
    //   1441: aload 9
    //   1443: monitorenter
    //   1444: iconst_3
    //   1445: ldc_w 1022
    //   1448: ldc_w 1056
    //   1451: aconst_null
    //   1452: invokestatic 1045	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1455: aload_3
    //   1456: invokevirtual 1057	c/t/m/g/a:d	()V
    //   1459: aload_3
    //   1460: getfield 1060	c/t/m/g/a:b	Lc/t/m/g/c;
    //   1463: ifnull +36 -> 1499
    //   1466: aload_2
    //   1467: astore_1
    //   1468: aload_2
    //   1469: ifnonnull +21 -> 1490
    //   1472: aload_3
    //   1473: ldc_w 1062
    //   1476: invokestatic 1067	c/t/m/g/ah:a	(Ljava/lang/String;)Landroid/os/HandlerThread;
    //   1479: putfield 1069	c/t/m/g/a:c	Landroid/os/HandlerThread;
    //   1482: aload_3
    //   1483: getfield 1069	c/t/m/g/a:c	Landroid/os/HandlerThread;
    //   1486: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1489: astore_1
    //   1490: aload_3
    //   1491: getfield 1060	c/t/m/g/a:b	Lc/t/m/g/c;
    //   1494: aload_1
    //   1495: invokevirtual 1074	c/t/m/g/c:b	(Landroid/os/Looper;)I
    //   1498: pop
    //   1499: aload 9
    //   1501: monitorexit
    //   1502: aload_0
    //   1503: ldc_w 1075
    //   1506: putfield 155	c/t/m/g/az:G	Ljava/lang/String;
    //   1509: aload_0
    //   1510: getfield 703	c/t/m/g/az:S	Ljava/lang/String;
    //   1513: invokestatic 1076	c/t/m/g/m:a	(Ljava/lang/String;)V
    //   1516: iconst_0
    //   1517: ireturn
    //   1518: astore_1
    //   1519: aload 10
    //   1521: monitorexit
    //   1522: aload_1
    //   1523: athrow
    //   1524: aload_1
    //   1525: invokevirtual 407	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
    //   1528: lstore 5
    //   1530: goto -1298 -> 232
    //   1533: iconst_0
    //   1534: istore 4
    //   1536: goto -1267 -> 269
    //   1539: aload_0
    //   1540: getfield 309	c/t/m/g/az:o	Lc/t/m/g/az$a;
    //   1543: aconst_null
    //   1544: invokevirtual 1079	c/t/m/g/az$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   1547: aload_0
    //   1548: getfield 309	c/t/m/g/az:o	Lc/t/m/g/az$a;
    //   1551: invokevirtual 1080	c/t/m/g/az$a:getLooper	()Landroid/os/Looper;
    //   1554: aload_3
    //   1555: if_acmpeq -1268 -> 287
    //   1558: aload_0
    //   1559: new 6	c/t/m/g/az$a
    //   1562: dup
    //   1563: aload_0
    //   1564: aload_3
    //   1565: invokespecial 787	c/t/m/g/az$a:<init>	(Lc/t/m/g/az;Landroid/os/Looper;)V
    //   1568: putfield 309	c/t/m/g/az:o	Lc/t/m/g/az$a;
    //   1571: goto -1284 -> 287
    //   1574: iconst_0
    //   1575: istore 4
    //   1577: goto -1055 -> 522
    //   1580: astore_3
    //   1581: aload_2
    //   1582: new 858	c/t/m/g/bc$a
    //   1585: dup
    //   1586: aload_2
    //   1587: aload_2
    //   1588: getfield 852	c/t/m/g/bc:i	Landroid/os/Handler;
    //   1591: invokevirtual 1054	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   1594: iconst_0
    //   1595: invokespecial 861	c/t/m/g/bc$a:<init>	(Lc/t/m/g/bc;Landroid/os/Looper;B)V
    //   1598: putfield 864	c/t/m/g/bc:g	Lc/t/m/g/bc$a;
    //   1601: goto -1002 -> 599
    //   1604: iload 7
    //   1606: ifeq -968 -> 638
    //   1609: aload_0
    //   1610: getfield 225	c/t/m/g/az:p	Lc/t/m/g/au;
    //   1613: ifnull +137 -> 1750
    //   1616: iconst_1
    //   1617: istore 4
    //   1619: iload 4
    //   1621: ifeq -983 -> 638
    //   1624: aload_0
    //   1625: getfield 225	c/t/m/g/az:p	Lc/t/m/g/au;
    //   1628: astore_2
    //   1629: aload_2
    //   1630: getfield 1081	c/t/m/g/au:a	Z
    //   1633: ifne -995 -> 638
    //   1636: aload_2
    //   1637: iconst_1
    //   1638: putfield 1081	c/t/m/g/au:a	Z
    //   1641: aload_2
    //   1642: new 565	android/os/HandlerThread
    //   1645: dup
    //   1646: ldc_w 1083
    //   1649: invokespecial 568	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   1652: putfield 1085	c/t/m/g/au:d	Landroid/os/HandlerThread;
    //   1655: aload_2
    //   1656: getfield 1085	c/t/m/g/au:d	Landroid/os/HandlerThread;
    //   1659: invokevirtual 573	android/os/HandlerThread:start	()V
    //   1662: aload_2
    //   1663: new 1087	c/t/m/g/au$a
    //   1666: dup
    //   1667: aload_2
    //   1668: aload_2
    //   1669: getfield 1085	c/t/m/g/au:d	Landroid/os/HandlerThread;
    //   1672: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1675: iconst_0
    //   1676: invokespecial 1090	c/t/m/g/au$a:<init>	(Lc/t/m/g/au;Landroid/os/Looper;B)V
    //   1679: putfield 1091	c/t/m/g/au:e	Landroid/os/Handler;
    //   1682: aload_2
    //   1683: getfield 1091	c/t/m/g/au:e	Landroid/os/Handler;
    //   1686: iconst_0
    //   1687: ldc2_w 1092
    //   1690: invokevirtual 1094	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   1693: pop
    //   1694: aload_2
    //   1695: getfield 1095	c/t/m/g/au:b	Lc/t/m/g/ap;
    //   1698: invokestatic 654	c/t/m/g/bz:a	(Lc/t/m/g/ap;)Landroid/telephony/CellLocation;
    //   1701: astore_3
    //   1702: aload_2
    //   1703: aload_3
    //   1704: invokevirtual 1098	c/t/m/g/au:a	(Landroid/telephony/CellLocation;)Z
    //   1707: ifeq +33 -> 1740
    //   1710: aload_2
    //   1711: getfield 1095	c/t/m/g/au:b	Lc/t/m/g/ap;
    //   1714: aload_3
    //   1715: aconst_null
    //   1716: invokestatic 657	c/t/m/g/bj:a	(Lc/t/m/g/ap;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/m/g/bj;
    //   1719: astore 9
    //   1721: aload 9
    //   1723: ifnull +17 -> 1740
    //   1726: aload_2
    //   1727: aload_3
    //   1728: putfield 1101	c/t/m/g/au:c	Landroid/telephony/CellLocation;
    //   1731: aload_2
    //   1732: getfield 1095	c/t/m/g/au:b	Lc/t/m/g/ap;
    //   1735: aload 9
    //   1737: invokevirtual 1103	c/t/m/g/ap:b	(Ljava/lang/Object;)V
    //   1740: aload_2
    //   1741: sipush 273
    //   1744: invokevirtual 1104	c/t/m/g/au:a	(I)V
    //   1747: goto -1109 -> 638
    //   1750: iconst_0
    //   1751: istore 4
    //   1753: goto -134 -> 1619
    //   1756: iconst_0
    //   1757: istore 4
    //   1759: goto -1086 -> 673
    //   1762: iconst_0
    //   1763: istore 4
    //   1765: goto -966 -> 799
    //   1768: iconst_0
    //   1769: istore 7
    //   1771: goto -941 -> 830
    //   1774: aload_3
    //   1775: ldc_w 1106
    //   1778: ldc2_w 1107
    //   1781: fconst_0
    //   1782: aload_2
    //   1783: aload_2
    //   1784: getfield 911	c/t/m/g/ay:g	Landroid/os/HandlerThread;
    //   1787: invokevirtual 577	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   1790: invokestatic 928	alky:a	(Landroid/location/LocationManager;Ljava/lang/String;JFLandroid/location/LocationListener;Landroid/os/Looper;)V
    //   1793: goto -833 -> 960
    //   1796: astore_3
    //   1797: iconst_1
    //   1798: putstatic 346	c/t/m/g/bz:a	Z
    //   1801: goto -841 -> 960
    //   1804: astore_1
    //   1805: aload_3
    //   1806: monitorexit
    //   1807: aload_1
    //   1808: athrow
    //   1809: astore_1
    //   1810: aload 9
    //   1812: monitorexit
    //   1813: aload_1
    //   1814: athrow
    //   1815: astore_3
    //   1816: goto -875 -> 941
    //   1819: astore_3
    //   1820: goto -1073 -> 747
    //   1823: astore_2
    //   1824: goto -1429 -> 395
    //   1827: astore 9
    //   1829: goto -1780 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1832	0	this	az
    //   0	1832	1	paramTencentLocationRequest	TencentLocationRequest
    //   0	1832	2	paramTencentLocationListener	TencentLocationListener
    //   267	1497	4	i1	int
    //   230	1299	5	l1	long
    //   330	1440	7	bool1	boolean
    //   345	940	8	bool2	boolean
    //   1827	1	9	localThrowable	Throwable
    //   59	1461	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	154	java/lang/Throwable
    //   170	178	1518	finally
    //   1519	1522	1518	finally
    //   572	599	1580	java/lang/Throwable
    //   913	941	1796	java/lang/Exception
    //   941	960	1796	java/lang/Exception
    //   1774	1793	1796	java/lang/Exception
    //   1306	1393	1804	finally
    //   1393	1395	1804	finally
    //   1805	1807	1804	finally
    //   1444	1466	1809	finally
    //   1472	1490	1809	finally
    //   1490	1499	1809	finally
    //   1499	1502	1809	finally
    //   1810	1813	1809	finally
    //   913	941	1815	java/lang/Throwable
    //   732	747	1819	java/lang/Exception
    //   369	395	1823	java/lang/Exception
    //   43	49	1827	java/lang/Throwable
  }
  
  public final void a(by paramby)
  {
    if (paramby != null) {}
    try
    {
      if (this.J.isAllowDirection()) {
        paramby.getExtra().putDouble("direction", this.b.b());
      }
      paramby.getExtra().putString("motion", this.c.e());
      paramby.getExtra().putAll(this.J.getExtras());
      return;
    }
    catch (Throwable paramby) {}
  }
  
  @TargetApi(19)
  public final boolean a()
  {
    if ((Build.VERSION.SDK_INT >= 19) || (Build.VERSION.SDK_INT != 23)) {
      try
      {
        Sensor localSensor = ((SensorManager)this.F.a.getSystemService("sensor")).getDefaultSensor(19);
        return localSensor != null;
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return false;
  }
  
  public final int b()
  {
    try
    {
      SharedPreferences localSharedPreferences = this.F.c;
      Object localObject = localSharedPreferences.getString("stepStr", "");
      float f1 = 0.0F;
      long l1 = 0L;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        f1 = Float.valueOf(localObject[0]).floatValue();
        l1 = Long.valueOf(localObject[1]).longValue();
      }
      localSharedPreferences.edit().putString("stepStr", f1 + "," + l1 + ",0").apply();
      return 0;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  public final TencentPedestrianData c()
  {
    float f1 = 0.0F;
    Object localObject1 = this.F.c;
    if (localObject1 == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = ((SharedPreferences)localObject1).getString("stepStr", "");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        localObject3 = ((String)localObject3).split(",");
        f1 = Float.valueOf(localObject3[0]).floatValue();
        l1 = Long.valueOf(localObject3[1]).longValue();
        f2 = Float.valueOf(localObject3[2]).floatValue();
        ((SharedPreferences)localObject1).edit().putString("stepStr", f1 + "," + l1 + "," + f2).apply();
        localObject1 = new az.1(this, f2, l1);
      }
      catch (Throwable localThrowable)
      {
        long l1;
        float f2;
        Object localObject2 = null;
        continue;
      }
      return localObject1;
      l1 = 0L;
      f2 = 0.0F;
    }
  }
  
  public final void d()
  {
    k();
    int i1;
    if (this.o != null) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 != 0) {
        this.o.a();
      }
      synchronized (this.I)
      {
        this.d = null;
        l();
        this.G = "stop";
        j();
        return;
        i1 = 0;
      }
    }
  }
  
  public final void onCellInfoEvent(bj parambj)
  {
    new StringBuilder("cellCallback:").append(System.currentTimeMillis());
    int i4 = parambj.e;
    int i5 = parambj.f;
    Object localObject = this.B;
    int i2;
    if (localObject != null) {
      i2 = ((bj)localObject).f;
    }
    for (int i3 = ((bj)localObject).e;; i3 = 0)
    {
      this.B = parambj;
      int i1;
      if (this.t != null) {
        if (this.t.b()) {
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          this.C = null;
        }
        if ((i1 == 0) && ((this.C == null) || (this.C.a(System.currentTimeMillis(), 30000L))))
        {
          if (this.o != null)
          {
            localObject = this.o.obtainMessage(3999, "wifi_not_received");
            this.o.sendMessageDelayed((Message)localObject, 2000L);
          }
          label148:
          if (i1 != 0) {
            break label372;
          }
        }
        ArrayList localArrayList;
        label372:
        for (localObject = "scan wifi";; localObject = "prepare json. wifi is not scannable?")
        {
          String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i1), localObject });
          if (this.w == null) {
            break label391;
          }
          localObject = new b(parambj.b, parambj.c, parambj.d, parambj.e, parambj.f, parambj.a.ordinal());
          localArrayList = new ArrayList();
          localArrayList.add(localObject);
          parambj = parambj.b().iterator();
          while (parambj.hasNext())
          {
            bj localbj = (bj)parambj.next();
            localArrayList.add(new b(localbj.b, localbj.c, localbj.d, localbj.e, localbj.f, localbj.a.ordinal()));
          }
          i1 = 1;
          break;
          a(3999);
          break label148;
        }
        this.w.a((b)localObject, localArrayList);
        label391:
        return;
        i1 = 1;
      }
      i2 = 0;
    }
  }
  
  public final void onGpsInfoEvent(bk arg1)
  {
    int i4;
    int i3;
    Object localObject1;
    Location localLocation;
    Object localObject3;
    double d2;
    double d1;
    int i2;
    int i1;
    if (???.a != av.a)
    {
      this.D = ???;
      if (!this.J.getExtras().getBoolean("daemon"))
      {
        int i5 = ax.a().a(???);
        i4 = this.a;
        i3 = this.J.getRequestLevel();
        localObject1 = this.M;
        localLocation = new Location(???.a);
        localObject3 = localLocation.getExtras();
        d2 = 0.0D;
        d1 = 0.0D;
        i2 = 0;
        i1 = 0;
        if (localObject3 != null)
        {
          d2 = ((Bundle)localObject3).getDouble("lat");
          d1 = ((Bundle)localObject3).getDouble("lng");
          i2 = ((Bundle)localObject3).getInt("fakeCode");
        }
        if (i2 != 0)
        {
          this.T = true;
          i1 = (int)(Math.pow(2.0D, i2 + 3) + 4.0D);
        }
        if (i5 != -1) {
          break label694;
        }
        this.T = true;
        i1 += 2;
      }
    }
    label694:
    for (;;)
    {
      if (i4 == 0) {
        i2 = 1;
      }
      for (;;)
      {
        if (i2 != 0)
        {
          localObject3 = new by.a();
          ((by.a)localObject3).b = ((by)localObject1);
          ((by.a)localObject3).d = "gps";
          if (this.T)
          {
            localObject1 = "fake";
            label220:
            ((by.a)localObject3).e = ((String)localObject1);
            ((by.a)localObject3).c = i3;
            localObject1 = ((by.a)localObject3).a(new Location(???.a)).a();
            localLocation.setLatitude(d2);
            localLocation.setLongitude(d1);
            ((by)localObject1).a(localLocation);
            ((by)localObject1).a(i1);
            a(0, (by)localObject1);
            if (this.w != null)
            {
              localObject1 = this.w;
              localLocation = ???.a;
            }
          }
        }
        synchronized (((a)localObject1).a)
        {
          if (!((a)localObject1).c())
          {
            return;
            i2 = 0;
            continue;
            localObject1 = "gps";
            break label220;
            if (m()) {
              a(3999);
            }
            localObject3 = new by.a();
            ((by.a)localObject3).b = ((by)localObject1);
            ((by.a)localObject3).d = "gps";
            if (this.T) {}
            for (localObject1 = "fake";; localObject1 = "gps")
            {
              ((by.a)localObject3).e = ((String)localObject1);
              ((by.a)localObject3).c = i3;
              localObject1 = ((by.a)localObject3).a(new Location(???.a)).a();
              localLocation.setLatitude(d2);
              localLocation.setLongitude(d1);
              ((by)localObject1).a(localLocation);
              ((by)localObject1).a(i1);
              a(0, (by)localObject1);
              a(12004, 3);
              break;
            }
          }
          else if ((localLocation == null) || (!"gps".equals(localLocation.getProvider())))
          {
            return;
          }
        }
      }
      boolean bool = h.h;
      if ((Build.VERSION.SDK_INT >= 18) && (localLocation.isFromMockProvider())) {
        return;
      }
      ai.a(3, "TxCoreDC", "setGpsLocation", null);
      if (localObject2.b != null)
      {
        localObject3 = localObject2.b;
        if (((c)localObject3).m != null) {
          ((c)localObject3).m.a(localLocation);
        }
        if (((c)localObject3).n != null) {
          ((c)localObject3).n.a(localLocation);
        }
      }
      if ((!ai.b(localLocation.getAltitude())) || (!ai.b(localLocation.getSpeed())))
      {
        localObject2.d = a.a(localObject2.d, localLocation);
        if ((localObject2.e == null) || ((localObject2.d != null) && (localObject2.d.distanceTo(localObject2.e) >= 50.0F) && (System.currentTimeMillis() - localObject2.k >= 5000L))) {
          localObject2.b();
        }
      }
      return;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    int i1 = cd.a(this.F.a);
    String str;
    if (i1 != -1) {
      if (i1 == 0) {
        str = "mobile";
      }
    }
    for (;;)
    {
      switch (paramInteger.intValue())
      {
      case -1: 
      default: 
        return;
        if (i1 == 1) {
          str = "wifi";
        } else {
          str = "none";
        }
        break;
      }
    }
    new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
    return;
    new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
    a(7999, 1000L);
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    a(paramMessage.arg1, paramMessage.arg2);
  }
  
  public final void onWifiInfoEvent(bn parambn)
  {
    new StringBuilder("wifiCallback:").append(System.currentTimeMillis());
    if (this.o != null) {
      this.o.removeMessages(3999, "wifi_not_received");
    }
    if (parambn == bn.a) {
      a(555, 1500L);
    }
    a locala;
    List localList;
    for (;;)
    {
      if (this.w != null)
      {
        locala = this.w;
        localList = Collections.unmodifiableList(parambn.b);
      }
      synchronized (locala.a)
      {
        if (!locala.c())
        {
          return;
          if ((this.C == null) || (!this.H) || (Collections.unmodifiableList(parambn.b).size() < 3) || (!this.C.a(parambn))) {
            a(3999);
          }
          this.C = parambn;
        }
      }
    }
    long l1;
    boolean bool1;
    long l2;
    boolean bool2;
    try
    {
      l1 = System.currentTimeMillis();
      bool1 = l.a(locala.g, localList);
      if (ai.a()) {
        ai.a(3, "TxCoreDC", "setWifiResults, same pre:".concat(String.valueOf(bool1)), null);
      }
      if (bool1)
      {
        l2 = locala.j;
        if (l1 - l2 > 30000L)
        {
          return;
          parambn = finally;
          throw parambn;
        }
      }
      if (locala.b != null)
      {
        parambn = locala.b;
        if (parambn.l != null)
        {
          parambn = parambn.l;
          if ((parambn.f()) && (!ai.a(localList))) {
            break label338;
          }
        }
      }
      while ((locala.b != null) && (locala.d != null) && (!ai.a(localList)))
      {
        if (localList.size() != 1) {
          break label381;
        }
        bool2 = "123456789abc".equals(((ScanResult)localList.get(0)).BSSID.toLowerCase());
        if (!bool2) {
          break label408;
        }
        return;
        label338:
        Message localMessage = parambn.e().obtainMessage(102);
        localMessage.obj = localList;
        parambn.b(localMessage);
      }
    }
    catch (Throwable parambn)
    {
      ai.a("TxCoreDC", "setWifiResults error.", parambn);
    }
    return;
    label381:
    if (localList.size() > 1)
    {
      bool2 = l.a(localList);
      if (bool2) {
        return;
      }
    }
    label408:
    if (h.f)
    {
      l2 = locala.j;
      if (l1 - l2 < 5000L) {
        return;
      }
    }
    if (!bool1)
    {
      locala.j = l1;
      locala.g = localList;
    }
    if (l1 - locala.i < locala.h) {}
    for (parambn = locala.f;; parambn = null)
    {
      locala.b.a(locala.d, localList, parambn);
      break;
    }
  }
  
  final class a
    extends Handler
  {
    private int a = 0;
    private boolean b = true;
    
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void a()
    {
      removeCallbacksAndMessages(null);
      this.b = true;
      this.a = 0;
    }
    
    /* Error */
    public final void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   4: invokestatic 42	c/t/m/g/az:a	(Lc/t/m/g/az;)Ljava/lang/Object;
      //   7: astore 12
      //   9: aload 12
      //   11: monitorenter
      //   12: aload_0
      //   13: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   16: invokestatic 45	c/t/m/g/az:b	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationListener;
      //   19: ifnonnull +7 -> 26
      //   22: aload 12
      //   24: monitorexit
      //   25: return
      //   26: aload_0
      //   27: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   30: invokestatic 45	c/t/m/g/az:b	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationListener;
      //   33: astore 11
      //   35: aload 12
      //   37: monitorexit
      //   38: aload_0
      //   39: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   42: invokestatic 48	c/t/m/g/az:c	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   45: astore 13
      //   47: aload 13
      //   49: invokevirtual 54	com/tencent/map/geolocation/TencentLocationRequest:getRequestLevel	()I
      //   52: istore 4
      //   54: aload 13
      //   56: invokevirtual 58	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
      //   59: lstore 5
      //   61: aload 13
      //   63: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   66: ldc 64
      //   68: invokevirtual 70	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
      //   71: istore 10
      //   73: aload_1
      //   74: getfield 75	android/os/Message:what	I
      //   77: lookupswitch	default:+91->168, 555:+92->169, 3998:+1253->1330, 3999:+550->627, 4996:+2602->2679, 4997:+2131->2208, 4998:+2571->2648, 4999:+1427->1504, 7999:+540->617, 11998:+401->478, 11999:+115->192
      //   169: aload_0
      //   170: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   173: invokestatic 79	c/t/m/g/az:C	(Lc/t/m/g/az;)Lc/t/m/g/bn;
      //   176: pop
      //   177: aload_0
      //   178: sipush 3999
      //   181: invokevirtual 83	c/t/m/g/az$a:sendEmptyMessage	(I)Z
      //   184: pop
      //   185: return
      //   186: astore_1
      //   187: aload 12
      //   189: monitorexit
      //   190: aload_1
      //   191: athrow
      //   192: aload_0
      //   193: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   196: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   199: ifnull +207 -> 406
      //   202: aload 13
      //   204: invokevirtual 58	com/tencent/map/geolocation/TencentLocationRequest:getInterval	()J
      //   207: lconst_0
      //   208: lcmp
      //   209: ifle +197 -> 406
      //   212: aload_0
      //   213: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   216: invokestatic 91	c/t/m/g/az:e	(Lc/t/m/g/az;)Ljava/lang/String;
      //   219: ifnull +187 -> 406
      //   222: aload_0
      //   223: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   226: invokestatic 91	c/t/m/g/az:e	(Lc/t/m/g/az;)Ljava/lang/String;
      //   229: ldc 93
      //   231: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   234: ifeq +172 -> 406
      //   237: aload_0
      //   238: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   241: aload_0
      //   242: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   245: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   248: invokestatic 101	c/t/m/g/az:a	(Lc/t/m/g/az;Lc/t/m/g/by;)V
      //   251: new 103	java/lang/StringBuilder
      //   254: dup
      //   255: ldc 105
      //   257: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   260: aload_0
      //   261: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   264: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   267: invokevirtual 114	c/t/m/g/by:getLatitude	()D
      //   270: invokevirtual 118	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   273: ldc 120
      //   275: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   278: aload_0
      //   279: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   282: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   285: invokevirtual 126	c/t/m/g/by:getLongitude	()D
      //   288: invokevirtual 118	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
      //   291: pop
      //   292: aload 11
      //   294: aload_0
      //   295: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   298: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   301: aload_0
      //   302: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   305: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   308: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   311: aload_0
      //   312: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   315: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   318: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   321: checkcast 95	java/lang/String
      //   324: invokeinterface 145 4 0
      //   329: aload_0
      //   330: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   333: invokestatic 149	c/t/m/g/az:g	(Lc/t/m/g/az;)Z
      //   336: ifeq +70 -> 406
      //   339: aload_0
      //   340: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   343: invokestatic 153	c/t/m/g/az:h	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   346: ifnull +60 -> 406
      //   349: aload_0
      //   350: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   353: invokestatic 153	c/t/m/g/az:h	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   356: aload_0
      //   357: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   360: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   363: aload_0
      //   364: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   367: invokestatic 157	c/t/m/g/az:i	(Lc/t/m/g/az;)D
      //   370: ldc2_w 158
      //   373: ddiv
      //   374: iconst_2
      //   375: invokestatic 164	c/t/m/g/cf:a	(DI)D
      //   378: aload_0
      //   379: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   382: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   385: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   388: aload_0
      //   389: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   392: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   395: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   398: checkcast 95	java/lang/String
      //   401: invokeinterface 170 6 0
      //   406: lload 5
      //   408: lconst_0
      //   409: lcmp
      //   410: ifle +18 -> 428
      //   413: iload 10
      //   415: ifne +13 -> 428
      //   418: aload_0
      //   419: sipush 11999
      //   422: lload 5
      //   424: invokevirtual 174	c/t/m/g/az$a:sendEmptyMessageDelayed	(IJ)Z
      //   427: pop
      //   428: aload_0
      //   429: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   432: invokestatic 177	c/t/m/g/az:j	(Lc/t/m/g/az;)Z
      //   435: istore 9
      //   437: aload_0
      //   438: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   441: invokestatic 181	c/t/m/g/az:k	(Lc/t/m/g/az;)Lc/t/m/g/bf;
      //   444: iload 9
      //   446: putfield 185	c/t/m/g/bf:d	Z
      //   449: iload 9
      //   451: ifeq +2293 -> 2744
      //   454: lload 5
      //   456: ldc2_w 186
      //   459: lcmp
      //   460: ifle +2284 -> 2744
      //   463: aload_0
      //   464: sipush 3999
      //   467: lload 5
      //   469: ldc2_w 188
      //   472: lsub
      //   473: invokevirtual 174	c/t/m/g/az$a:sendEmptyMessageDelayed	(IJ)Z
      //   476: pop
      //   477: return
      //   478: aload_0
      //   479: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   482: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   485: ifnull +2259 -> 2744
      //   488: aload_0
      //   489: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   492: aload_0
      //   493: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   496: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   499: invokestatic 101	c/t/m/g/az:a	(Lc/t/m/g/az;Lc/t/m/g/by;)V
      //   502: aload 11
      //   504: aload_0
      //   505: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   508: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   511: aload_0
      //   512: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   515: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   518: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   521: aload_0
      //   522: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   525: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   528: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   531: checkcast 95	java/lang/String
      //   534: invokeinterface 145 4 0
      //   539: aload_0
      //   540: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   543: invokestatic 149	c/t/m/g/az:g	(Lc/t/m/g/az;)Z
      //   546: ifeq +2198 -> 2744
      //   549: aload_0
      //   550: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   553: invokestatic 153	c/t/m/g/az:h	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   556: ifnull +2188 -> 2744
      //   559: aload_0
      //   560: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   563: invokestatic 153	c/t/m/g/az:h	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentDistanceListener;
      //   566: aload_0
      //   567: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   570: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   573: aload_0
      //   574: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   577: invokestatic 157	c/t/m/g/az:i	(Lc/t/m/g/az;)D
      //   580: ldc2_w 158
      //   583: ddiv
      //   584: iconst_2
      //   585: invokestatic 164	c/t/m/g/cf:a	(DI)D
      //   588: aload_0
      //   589: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   592: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   595: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   598: aload_0
      //   599: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   602: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   605: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   608: checkcast 95	java/lang/String
      //   611: invokeinterface 170 6 0
      //   616: return
      //   617: aload_0
      //   618: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   621: invokestatic 192	c/t/m/g/az:l	(Lc/t/m/g/az;)Z
      //   624: ifne +2120 -> 2744
      //   627: new 103	java/lang/StringBuilder
      //   630: dup
      //   631: ldc 194
      //   633: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   636: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   639: invokestatic 201	c/t/m/g/az:f	()J
      //   642: lsub
      //   643: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   646: pop
      //   647: iload 10
      //   649: ifeq +244 -> 893
      //   652: new 103	java/lang/StringBuilder
      //   655: dup
      //   656: ldc 206
      //   658: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   661: aload_0
      //   662: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   665: invokestatic 210	c/t/m/g/az:m	(Lc/t/m/g/az;)J
      //   668: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   671: ldc 120
      //   673: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   676: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   679: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   682: ldc 120
      //   684: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   687: aload_0
      //   688: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   691: invokestatic 213	c/t/m/g/az:n	(Lc/t/m/g/az;)J
      //   694: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   697: pop
      //   698: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   701: aload_0
      //   702: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   705: invokestatic 213	c/t/m/g/az:n	(Lc/t/m/g/az;)J
      //   708: lsub
      //   709: aload_0
      //   710: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   713: invokestatic 210	c/t/m/g/az:m	(Lc/t/m/g/az;)J
      //   716: lcmp
      //   717: iflt +2027 -> 2744
      //   720: aload_0
      //   721: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   724: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   727: invokestatic 216	c/t/m/g/az:a	(Lc/t/m/g/az;J)J
      //   730: pop2
      //   731: aload_1
      //   732: getfield 220	android/os/Message:obj	Ljava/lang/Object;
      //   735: ifnull +23 -> 758
      //   738: new 103	java/lang/StringBuilder
      //   741: dup
      //   742: ldc 222
      //   744: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   747: aload_1
      //   748: getfield 220	android/os/Message:obj	Ljava/lang/Object;
      //   751: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
      //   754: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   757: pop
      //   758: aload_0
      //   759: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   762: invokestatic 231	c/t/m/g/az:p	(Lc/t/m/g/az;)I
      //   765: istore_3
      //   766: aload_0
      //   767: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   770: invokestatic 235	c/t/m/g/az:q	(Lc/t/m/g/az;)Lc/t/m/g/bl;
      //   773: astore 12
      //   775: aload_0
      //   776: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   779: invokestatic 238	c/t/m/g/az:r	(Lc/t/m/g/az;)Ljava/lang/String;
      //   782: astore_1
      //   783: aload_0
      //   784: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   787: invokestatic 242	c/t/m/g/az:s	(Lc/t/m/g/az;)Lc/t/m/g/ap;
      //   790: astore 14
      //   792: aload_0
      //   793: getfield 23	c/t/m/g/az$a:b	Z
      //   796: ifeq +170 -> 966
      //   799: iload 10
      //   801: ifne +165 -> 966
      //   804: iconst_1
      //   805: istore 9
      //   807: aload 12
      //   809: iload 4
      //   811: aload_1
      //   812: aload 14
      //   814: iload 9
      //   816: aload_0
      //   817: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   820: invokestatic 245	c/t/m/g/az:t	(Lc/t/m/g/az;)Z
      //   823: iload 10
      //   825: invokevirtual 250	c/t/m/g/bl:a	(ILjava/lang/String;Lc/t/m/g/ap;ZZZ)Ljava/lang/String;
      //   828: astore_1
      //   829: aload_1
      //   830: invokestatic 252	c/t/m/g/cf:a	(Ljava/lang/String;)Z
      //   833: ifne +139 -> 972
      //   836: iconst_1
      //   837: istore_2
      //   838: iload_2
      //   839: ifeq +138 -> 977
      //   842: aload_0
      //   843: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   846: invokestatic 177	c/t/m/g/az:j	(Lc/t/m/g/az;)Z
      //   849: istore 9
      //   851: new 103	java/lang/StringBuilder
      //   854: dup
      //   855: ldc 254
      //   857: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   860: iload 9
      //   862: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   865: ldc_w 259
      //   868: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   871: aload_1
      //   872: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   875: pop
      //   876: iload 9
      //   878: ifne +1866 -> 2744
      //   881: aload_0
      //   882: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   885: iconst_2
      //   886: getstatic 262	c/t/m/g/by:a	Lc/t/m/g/by;
      //   889: invokestatic 265	c/t/m/g/az:a	(Lc/t/m/g/az;ILc/t/m/g/by;)V
      //   892: return
      //   893: aload_0
      //   894: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   897: invokestatic 177	c/t/m/g/az:j	(Lc/t/m/g/az;)Z
      //   900: istore 9
      //   902: aload_0
      //   903: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   906: invokestatic 181	c/t/m/g/az:k	(Lc/t/m/g/az;)Lc/t/m/g/bf;
      //   909: iload 9
      //   911: putfield 185	c/t/m/g/bf:d	Z
      //   914: iload 9
      //   916: ifeq -185 -> 731
      //   919: lload 5
      //   921: ldc2_w 186
      //   924: lcmp
      //   925: ifle -194 -> 731
      //   928: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   931: lstore 7
      //   933: lload 7
      //   935: aload_0
      //   936: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   939: invokestatic 268	c/t/m/g/az:o	(Lc/t/m/g/az;)J
      //   942: lsub
      //   943: lload 5
      //   945: ldc2_w 188
      //   948: lsub
      //   949: lcmp
      //   950: iflt +1794 -> 2744
      //   953: aload_0
      //   954: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   957: lload 7
      //   959: invokestatic 270	c/t/m/g/az:b	(Lc/t/m/g/az;J)J
      //   962: pop2
      //   963: goto -232 -> 731
      //   966: iconst_0
      //   967: istore 9
      //   969: goto -162 -> 807
      //   972: iconst_0
      //   973: istore_2
      //   974: goto -136 -> 838
      //   977: iload 10
      //   979: ifne +80 -> 1059
      //   982: aload 13
      //   984: invokestatic 276	com/tencent/map/geolocation/internal/TencentExtraKeys:isRequestRawData	(Lcom/tencent/map/geolocation/TencentLocationRequest;)Z
      //   987: ifeq +72 -> 1059
      //   990: new 278	c/t/m/g/by$a
      //   993: dup
      //   994: invokespecial 280	c/t/m/g/by$a:<init>	()V
      //   997: astore 12
      //   999: aload 12
      //   1001: aconst_null
      //   1002: putfield 282	c/t/m/g/by$a:b	Lc/t/m/g/by;
      //   1005: aload 12
      //   1007: iload 4
      //   1009: putfield 284	c/t/m/g/by$a:c	I
      //   1012: aload 12
      //   1014: invokevirtual 287	c/t/m/g/by$a:a	()Lc/t/m/g/by;
      //   1017: astore 12
      //   1019: aload 12
      //   1021: aload_1
      //   1022: invokevirtual 291	java/lang/String:getBytes	()[B
      //   1025: invokestatic 295	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawData	(Lcom/tencent/map/geolocation/TencentLocation;[B)Lcom/tencent/map/geolocation/TencentLocation;
      //   1028: pop
      //   1029: aload_0
      //   1030: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1033: aload 12
      //   1035: invokestatic 101	c/t/m/g/az:a	(Lc/t/m/g/az;Lc/t/m/g/by;)V
      //   1038: aload 11
      //   1040: aload 12
      //   1042: iconst_0
      //   1043: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   1046: iconst_0
      //   1047: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   1050: checkcast 95	java/lang/String
      //   1053: invokeinterface 145 4 0
      //   1058: return
      //   1059: new 103	java/lang/StringBuilder
      //   1062: dup
      //   1063: ldc_w 297
      //   1066: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1069: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   1072: invokestatic 201	c/t/m/g/az:f	()J
      //   1075: lsub
      //   1076: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1079: pop
      //   1080: aload_0
      //   1081: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1084: invokestatic 300	c/t/m/g/az:u	(Lc/t/m/g/az;)Lc/t/m/g/bl;
      //   1087: astore 11
      //   1089: aload 11
      //   1091: ifnull +159 -> 1250
      //   1094: aload 11
      //   1096: invokevirtual 303	c/t/m/g/bl:b	()Z
      //   1099: ifeq +92 -> 1191
      //   1102: aload 12
      //   1104: invokevirtual 303	c/t/m/g/bl:b	()Z
      //   1107: ifeq +84 -> 1191
      //   1110: aload 12
      //   1112: getfield 306	c/t/m/g/bl:b	Lc/t/m/g/bn;
      //   1115: aload 11
      //   1117: getfield 306	c/t/m/g/bl:b	Lc/t/m/g/bn;
      //   1120: invokevirtual 311	c/t/m/g/bn:a	(Lc/t/m/g/bn;)Z
      //   1123: ifeq +68 -> 1191
      //   1126: iconst_2
      //   1127: istore_2
      //   1128: aload_0
      //   1129: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1132: invokestatic 130	c/t/m/g/az:f	(Lc/t/m/g/az;)I
      //   1135: ifne +120 -> 1255
      //   1138: aload_0
      //   1139: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1142: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   1145: ifnull +110 -> 1255
      //   1148: iload_2
      //   1149: iconst_1
      //   1150: if_icmpeq +25 -> 1175
      //   1153: iload_2
      //   1154: iconst_2
      //   1155: if_icmplt +100 -> 1255
      //   1158: aload_0
      //   1159: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1162: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   1165: invokevirtual 315	c/t/m/g/by:getAccuracy	()F
      //   1168: ldc_w 316
      //   1171: fcmpg
      //   1172: ifge +83 -> 1255
      //   1175: aload_0
      //   1176: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1179: iconst_0
      //   1180: aload_0
      //   1181: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1184: invokestatic 87	c/t/m/g/az:d	(Lc/t/m/g/az;)Lc/t/m/g/by;
      //   1187: invokestatic 265	c/t/m/g/az:a	(Lc/t/m/g/az;ILc/t/m/g/by;)V
      //   1190: return
      //   1191: aload 11
      //   1193: invokevirtual 303	c/t/m/g/bl:b	()Z
      //   1196: ifne +54 -> 1250
      //   1199: aload 12
      //   1201: invokevirtual 303	c/t/m/g/bl:b	()Z
      //   1204: ifne +46 -> 1250
      //   1207: aload 11
      //   1209: invokevirtual 318	c/t/m/g/bl:a	()Z
      //   1212: ifeq +38 -> 1250
      //   1215: aload 12
      //   1217: invokevirtual 318	c/t/m/g/bl:a	()Z
      //   1220: ifeq +30 -> 1250
      //   1223: aload 12
      //   1225: getfield 321	c/t/m/g/bl:c	Lc/t/m/g/bj;
      //   1228: invokevirtual 325	c/t/m/g/bj:c	()Ljava/lang/String;
      //   1231: aload 11
      //   1233: getfield 321	c/t/m/g/bl:c	Lc/t/m/g/bj;
      //   1236: invokevirtual 325	c/t/m/g/bj:c	()Ljava/lang/String;
      //   1239: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   1242: ifeq +8 -> 1250
      //   1245: iconst_1
      //   1246: istore_2
      //   1247: goto -119 -> 1128
      //   1250: iconst_0
      //   1251: istore_2
      //   1252: goto -124 -> 1128
      //   1255: aload_0
      //   1256: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1259: invokestatic 329	c/t/m/g/az:v	(Lc/t/m/g/az;)Lc/t/m/g/bd;
      //   1262: astore 11
      //   1264: aload_1
      //   1265: ldc_w 331
      //   1268: invokevirtual 334	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   1271: invokestatic 339	c/t/m/g/ai:c	([B)[B
      //   1274: astore 13
      //   1276: new 341	c/t/m/g/bd$a
      //   1279: dup
      //   1280: iconst_1
      //   1281: aload 13
      //   1283: aload 13
      //   1285: iload_3
      //   1286: invokestatic 346	c/t/m/g/bd:a	([BI)Ljava/lang/String;
      //   1289: aload 12
      //   1291: invokespecial 349	c/t/m/g/bd$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
      //   1294: astore 12
      //   1296: aload 12
      //   1298: aload_1
      //   1299: putfield 352	c/t/m/g/bd$a:b	Ljava/lang/String;
      //   1302: aload 12
      //   1304: iload_3
      //   1305: putfield 354	c/t/m/g/bd$a:d	I
      //   1308: aload 12
      //   1310: invokestatic 357	c/t/m/g/bd$a:a	(Lc/t/m/g/bd$a;)[B
      //   1313: ifnull +1431 -> 2744
      //   1316: aload 11
      //   1318: getfield 360	c/t/m/g/bd:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1321: aload 12
      //   1323: invokevirtual 366	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
      //   1326: pop
      //   1327: return
      //   1328: astore_1
      //   1329: return
      //   1330: aload_0
      //   1331: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1334: invokestatic 235	c/t/m/g/az:q	(Lc/t/m/g/az;)Lc/t/m/g/bl;
      //   1337: astore 12
      //   1339: aload 12
      //   1341: iload 4
      //   1343: aload_0
      //   1344: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1347: invokestatic 238	c/t/m/g/az:r	(Lc/t/m/g/az;)Ljava/lang/String;
      //   1350: aload_0
      //   1351: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1354: invokestatic 242	c/t/m/g/az:s	(Lc/t/m/g/az;)Lc/t/m/g/ap;
      //   1357: iconst_1
      //   1358: iconst_0
      //   1359: iconst_0
      //   1360: invokevirtual 250	c/t/m/g/bl:a	(ILjava/lang/String;Lc/t/m/g/ap;ZZZ)Ljava/lang/String;
      //   1363: astore_1
      //   1364: aload_1
      //   1365: invokestatic 252	c/t/m/g/cf:a	(Ljava/lang/String;)Z
      //   1368: ifne +131 -> 1499
      //   1371: iconst_1
      //   1372: istore_2
      //   1373: iload_2
      //   1374: ifne +1370 -> 2744
      //   1377: aload_0
      //   1378: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1381: invokestatic 329	c/t/m/g/az:v	(Lc/t/m/g/az;)Lc/t/m/g/bd;
      //   1384: astore 11
      //   1386: aload_0
      //   1387: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1390: invokestatic 231	c/t/m/g/az:p	(Lc/t/m/g/az;)I
      //   1393: istore_2
      //   1394: invokestatic 371	android/os/SystemClock:elapsedRealtime	()J
      //   1397: lstore 5
      //   1399: aload_1
      //   1400: ldc_w 331
      //   1403: invokevirtual 334	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   1406: invokestatic 339	c/t/m/g/ai:c	([B)[B
      //   1409: astore 13
      //   1411: new 341	c/t/m/g/bd$a
      //   1414: dup
      //   1415: iconst_3
      //   1416: aload 13
      //   1418: aload 13
      //   1420: iload_2
      //   1421: invokestatic 346	c/t/m/g/bd:a	([BI)Ljava/lang/String;
      //   1424: aload 12
      //   1426: invokespecial 349	c/t/m/g/bd$a:<init>	(I[BLjava/lang/String;Ljava/lang/Object;)V
      //   1429: astore 12
      //   1431: aload 12
      //   1433: aload_1
      //   1434: putfield 352	c/t/m/g/bd$a:b	Ljava/lang/String;
      //   1437: iconst_0
      //   1438: istore 9
      //   1440: aload 12
      //   1442: invokestatic 357	c/t/m/g/bd$a:a	(Lc/t/m/g/bd$a;)[B
      //   1445: ifnull +23 -> 1468
      //   1448: aload 11
      //   1450: getfield 360	c/t/m/g/bd:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1453: invokevirtual 374	java/util/concurrent/LinkedBlockingQueue:clear	()V
      //   1456: aload 11
      //   1458: getfield 360	c/t/m/g/bd:a	Ljava/util/concurrent/LinkedBlockingQueue;
      //   1461: aload 12
      //   1463: invokevirtual 366	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
      //   1466: istore 9
      //   1468: iload 9
      //   1470: ifeq +10 -> 1480
      //   1473: aload 11
      //   1475: lload 5
      //   1477: putfield 377	c/t/m/g/bd:h	J
      //   1480: aload_0
      //   1481: sipush 3998
      //   1484: aload_0
      //   1485: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1488: invokestatic 48	c/t/m/g/az:c	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1491: invokevirtual 380	com/tencent/map/geolocation/TencentLocationRequest:getCheckInterval	()J
      //   1494: invokevirtual 174	c/t/m/g/az$a:sendEmptyMessageDelayed	(IJ)Z
      //   1497: pop
      //   1498: return
      //   1499: iconst_0
      //   1500: istore_2
      //   1501: goto -128 -> 1373
      //   1504: aload_0
      //   1505: sipush 4998
      //   1508: invokevirtual 384	c/t/m/g/az$a:removeMessages	(I)V
      //   1511: aload_0
      //   1512: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1515: invokestatic 48	c/t/m/g/az:c	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1518: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   1521: ldc 64
      //   1523: invokevirtual 70	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
      //   1526: ifeq +13 -> 1539
      //   1529: aload_0
      //   1530: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1533: iconst_1
      //   1534: invokestatic 387	c/t/m/g/az:a	(Lc/t/m/g/az;Z)Z
      //   1537: pop
      //   1538: return
      //   1539: new 103	java/lang/StringBuilder
      //   1542: dup
      //   1543: ldc_w 389
      //   1546: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1549: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   1552: invokestatic 201	c/t/m/g/az:f	()J
      //   1555: lsub
      //   1556: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1559: pop
      //   1560: aload_1
      //   1561: getfield 220	android/os/Message:obj	Ljava/lang/Object;
      //   1564: checkcast 391	android/util/Pair
      //   1567: astore 12
      //   1569: aload 12
      //   1571: getfield 394	android/util/Pair:first	Ljava/lang/Object;
      //   1574: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
      //   1577: astore 13
      //   1579: aload 12
      //   1581: getfield 397	android/util/Pair:second	Ljava/lang/Object;
      //   1584: checkcast 341	c/t/m/g/bd$a
      //   1587: astore 12
      //   1589: aload 12
      //   1591: getfield 399	c/t/m/g/bd$a:a	Ljava/lang/Object;
      //   1594: checkcast 247	c/t/m/g/bl
      //   1597: astore 14
      //   1599: aload_0
      //   1600: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1603: aload 14
      //   1605: invokestatic 402	c/t/m/g/az:a	(Lc/t/m/g/az;Lc/t/m/g/bl;)Lc/t/m/g/bl;
      //   1608: pop
      //   1609: aload 12
      //   1611: getfield 352	c/t/m/g/bd$a:b	Ljava/lang/String;
      //   1614: astore 14
      //   1616: new 278	c/t/m/g/by$a
      //   1619: dup
      //   1620: invokespecial 280	c/t/m/g/by$a:<init>	()V
      //   1623: astore 12
      //   1625: aload 12
      //   1627: aload 13
      //   1629: putfield 404	c/t/m/g/by$a:a	Ljava/lang/String;
      //   1632: aload 12
      //   1634: iload 4
      //   1636: putfield 284	c/t/m/g/by$a:c	I
      //   1639: aload 12
      //   1641: invokevirtual 287	c/t/m/g/by$a:a	()Lc/t/m/g/by;
      //   1644: astore 12
      //   1646: aload 12
      //   1648: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1651: ldc_w 409
      //   1654: aload 13
      //   1656: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   1659: aload 12
      //   1661: invokestatic 416	c/t/m/g/by:a	(Lc/t/m/g/by;)V
      //   1664: aload 12
      //   1666: aload_0
      //   1667: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1670: invokestatic 420	c/t/m/g/az:w	(Lc/t/m/g/az;)Lc/t/m/g/bj;
      //   1673: iconst_0
      //   1674: invokestatic 423	c/t/m/g/by:a	(Lc/t/m/g/by;Lc/t/m/g/bj;Z)Lc/t/m/g/by;
      //   1677: pop
      //   1678: aload 12
      //   1680: aload 14
      //   1682: invokestatic 427	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
      //   1685: aload 12
      //   1687: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1690: ldc_w 429
      //   1693: aload_1
      //   1694: getfield 432	android/os/Message:arg1	I
      //   1697: i2l
      //   1698: invokevirtual 436	android/os/Bundle:putLong	(Ljava/lang/String;J)V
      //   1701: getstatic 439	com/tencent/map/geolocation/internal/TencentExtraKeys:COMPHTTPIO	Z
      //   1704: ifeq +19 -> 1723
      //   1707: aload 12
      //   1709: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1712: ldc_w 441
      //   1715: aload_1
      //   1716: getfield 444	android/os/Message:arg2	I
      //   1719: i2l
      //   1720: invokevirtual 436	android/os/Bundle:putLong	(Ljava/lang/String;J)V
      //   1723: aload_0
      //   1724: iconst_0
      //   1725: putfield 23	c/t/m/g/az$a:b	Z
      //   1728: aload 12
      //   1730: invokevirtual 447	c/t/m/g/by:getVerifyKey	()Ljava/lang/String;
      //   1733: ifnull +235 -> 1968
      //   1736: aload 12
      //   1738: invokevirtual 447	c/t/m/g/by:getVerifyKey	()Ljava/lang/String;
      //   1741: ldc_w 449
      //   1744: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   1747: ifne +221 -> 1968
      //   1750: aload 14
      //   1752: ifnull +116 -> 1868
      //   1755: new 451	org/json/JSONObject
      //   1758: dup
      //   1759: aload 14
      //   1761: invokespecial 452	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   1764: astore_1
      //   1765: aload_1
      //   1766: ldc_w 454
      //   1769: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1772: pop
      //   1773: aload_1
      //   1774: ldc_w 460
      //   1777: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1780: pop
      //   1781: aload_1
      //   1782: ldc_w 462
      //   1785: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1788: pop
      //   1789: aload_1
      //   1790: ldc_w 464
      //   1793: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1796: pop
      //   1797: aload_1
      //   1798: ldc_w 466
      //   1801: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1804: pop
      //   1805: aload_1
      //   1806: ldc_w 468
      //   1809: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1812: pop
      //   1813: aload_1
      //   1814: ldc_w 470
      //   1817: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1820: pop
      //   1821: aload_1
      //   1822: ldc_w 472
      //   1825: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1828: pop
      //   1829: aload_1
      //   1830: ldc_w 474
      //   1833: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1836: pop
      //   1837: aload_1
      //   1838: ldc_w 476
      //   1841: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1844: pop
      //   1845: aload_1
      //   1846: ldc_w 478
      //   1849: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   1852: pop
      //   1853: aload 12
      //   1855: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1858: ldc_w 480
      //   1861: aload_1
      //   1862: invokevirtual 481	org/json/JSONObject:toString	()Ljava/lang/String;
      //   1865: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   1868: aload 12
      //   1870: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1873: ldc_w 483
      //   1876: aload_0
      //   1877: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1880: invokestatic 487	c/t/m/g/az:x	(Lc/t/m/g/az;)Lc/t/m/g/ba;
      //   1883: invokevirtual 491	c/t/m/g/ba:e	()Ljava/lang/String;
      //   1886: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   1889: aload 12
      //   1891: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1894: aload_0
      //   1895: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1898: invokestatic 48	c/t/m/g/az:c	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   1901: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   1904: invokevirtual 495	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
      //   1907: aload 12
      //   1909: invokevirtual 315	c/t/m/g/by:getAccuracy	()F
      //   1912: f2d
      //   1913: ldc2_w 496
      //   1916: dcmpl
      //   1917: ifne +266 -> 2183
      //   1920: aload_0
      //   1921: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1924: invokestatic 500	c/t/m/g/az:y	(Lc/t/m/g/az;)Z
      //   1927: ifeq +256 -> 2183
      //   1930: iconst_1
      //   1931: istore 9
      //   1933: aload 12
      //   1935: aload_0
      //   1936: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1939: invokestatic 420	c/t/m/g/az:w	(Lc/t/m/g/az;)Lc/t/m/g/bj;
      //   1942: iload 9
      //   1944: invokestatic 423	c/t/m/g/by:a	(Lc/t/m/g/by;Lc/t/m/g/bj;Z)Lc/t/m/g/by;
      //   1947: pop
      //   1948: aload 11
      //   1950: aload 12
      //   1952: iconst_0
      //   1953: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   1956: iconst_0
      //   1957: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   1960: checkcast 95	java/lang/String
      //   1963: invokeinterface 145 4 0
      //   1968: aload_0
      //   1969: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1972: iconst_1
      //   1973: invokestatic 387	c/t/m/g/az:a	(Lc/t/m/g/az;Z)Z
      //   1976: pop
      //   1977: aload_0
      //   1978: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   1981: invokestatic 177	c/t/m/g/az:j	(Lc/t/m/g/az;)Z
      //   1984: ifne +54 -> 2038
      //   1987: aload 12
      //   1989: aconst_null
      //   1990: putfield 502	c/t/m/g/by:c	Ljava/lang/String;
      //   1993: aload 12
      //   1995: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   1998: ldc_w 480
      //   2001: ldc_w 504
      //   2004: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2007: aload_0
      //   2008: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2011: iconst_0
      //   2012: aload 12
      //   2014: invokestatic 265	c/t/m/g/az:a	(Lc/t/m/g/az;ILc/t/m/g/by;)V
      //   2017: new 103	java/lang/StringBuilder
      //   2020: dup
      //   2021: ldc_w 389
      //   2024: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2027: invokestatic 199	java/lang/System:currentTimeMillis	()J
      //   2030: invokestatic 201	c/t/m/g/az:f	()J
      //   2033: lsub
      //   2034: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2037: pop
      //   2038: aload_0
      //   2039: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2042: invokestatic 245	c/t/m/g/az:t	(Lc/t/m/g/az;)Z
      //   2045: ifeq +59 -> 2104
      //   2048: aload 12
      //   2050: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   2053: astore_1
      //   2054: aload_1
      //   2055: ifnull +41 -> 2096
      //   2058: aload_1
      //   2059: ldc_w 506
      //   2062: iconst_m1
      //   2063: invokevirtual 510	android/os/Bundle:getInt	(Ljava/lang/String;I)I
      //   2066: istore_2
      //   2067: aload_0
      //   2068: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2071: invokestatic 242	c/t/m/g/az:s	(Lc/t/m/g/az;)Lc/t/m/g/ap;
      //   2074: getfield 515	c/t/m/g/ap:c	Landroid/content/SharedPreferences;
      //   2077: invokeinterface 521 1 0
      //   2082: ldc_w 466
      //   2085: iload_2
      //   2086: invokeinterface 527 3 0
      //   2091: invokeinterface 530 1 0
      //   2096: aload_0
      //   2097: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2100: invokestatic 533	c/t/m/g/az:z	(Lc/t/m/g/az;)Z
      //   2103: pop
      //   2104: aload_0
      //   2105: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2108: aload 12
      //   2110: invokestatic 536	c/t/m/g/az:b	(Lc/t/m/g/az;Lc/t/m/g/by;)Lc/t/m/g/by;
      //   2113: pop
      //   2114: aload_0
      //   2115: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2118: invokestatic 539	c/t/m/g/az:A	(Lc/t/m/g/az;)Z
      //   2121: ifne +17 -> 2138
      //   2124: invokestatic 544	c/t/m/g/m:a	()Lc/t/m/g/m;
      //   2127: invokevirtual 546	c/t/m/g/m:b	()V
      //   2130: aload_0
      //   2131: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2134: invokestatic 549	c/t/m/g/az:B	(Lc/t/m/g/az;)Z
      //   2137: pop
      //   2138: aload_0
      //   2139: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2142: invokestatic 329	c/t/m/g/az:v	(Lc/t/m/g/az;)Lc/t/m/g/bd;
      //   2145: aload_0
      //   2146: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2149: invokestatic 242	c/t/m/g/az:s	(Lc/t/m/g/az;)Lc/t/m/g/ap;
      //   2152: iconst_0
      //   2153: invokevirtual 552	c/t/m/g/ap:a	(Z)Ljava/lang/String;
      //   2156: invokevirtual 554	c/t/m/g/bd:a	(Ljava/lang/String;)V
      //   2159: return
      //   2160: astore_1
      //   2161: aload_0
      //   2162: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2165: invokestatic 192	c/t/m/g/az:l	(Lc/t/m/g/az;)Z
      //   2168: ifeq +576 -> 2744
      //   2171: aload_0
      //   2172: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2175: iconst_2
      //   2176: getstatic 262	c/t/m/g/by:a	Lc/t/m/g/by;
      //   2179: invokestatic 265	c/t/m/g/az:a	(Lc/t/m/g/az;ILc/t/m/g/by;)V
      //   2182: return
      //   2183: iconst_0
      //   2184: istore 9
      //   2186: goto -253 -> 1933
      //   2189: astore_1
      //   2190: new 103	java/lang/StringBuilder
      //   2193: dup
      //   2194: ldc_w 556
      //   2197: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2200: aload_1
      //   2201: invokevirtual 559	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   2204: pop
      //   2205: goto -109 -> 2096
      //   2208: aload_1
      //   2209: getfield 220	android/os/Message:obj	Ljava/lang/Object;
      //   2212: checkcast 391	android/util/Pair
      //   2215: astore 12
      //   2217: aload 12
      //   2219: getfield 394	android/util/Pair:first	Ljava/lang/Object;
      //   2222: invokevirtual 228	java/lang/Object:toString	()Ljava/lang/String;
      //   2225: astore_1
      //   2226: aload 12
      //   2228: getfield 397	android/util/Pair:second	Ljava/lang/Object;
      //   2231: checkcast 341	c/t/m/g/bd$a
      //   2234: astore 12
      //   2236: aload 12
      //   2238: getfield 399	c/t/m/g/bd$a:a	Ljava/lang/Object;
      //   2241: checkcast 247	c/t/m/g/bl
      //   2244: astore 13
      //   2246: aload 12
      //   2248: getfield 352	c/t/m/g/bd$a:b	Ljava/lang/String;
      //   2251: astore 14
      //   2253: aload_0
      //   2254: iconst_0
      //   2255: putfield 21	c/t/m/g/az$a:a	I
      //   2258: new 278	c/t/m/g/by$a
      //   2261: dup
      //   2262: invokespecial 280	c/t/m/g/by$a:<init>	()V
      //   2265: astore 12
      //   2267: aload 12
      //   2269: aload_1
      //   2270: putfield 404	c/t/m/g/by$a:a	Ljava/lang/String;
      //   2273: aload 12
      //   2275: iload 4
      //   2277: putfield 284	c/t/m/g/by$a:c	I
      //   2280: aload 12
      //   2282: invokevirtual 287	c/t/m/g/by$a:a	()Lc/t/m/g/by;
      //   2285: astore 12
      //   2287: aload 12
      //   2289: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   2292: ldc_w 409
      //   2295: aload_1
      //   2296: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2299: aload 12
      //   2301: invokestatic 416	c/t/m/g/by:a	(Lc/t/m/g/by;)V
      //   2304: aload 12
      //   2306: invokevirtual 315	c/t/m/g/by:getAccuracy	()F
      //   2309: f2d
      //   2310: ldc2_w 496
      //   2313: dcmpl
      //   2314: ifne +320 -> 2634
      //   2317: aload_0
      //   2318: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2321: invokestatic 500	c/t/m/g/az:y	(Lc/t/m/g/az;)Z
      //   2324: ifeq +310 -> 2634
      //   2327: iconst_1
      //   2328: istore 9
      //   2330: aload 12
      //   2332: aload_0
      //   2333: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2336: invokestatic 420	c/t/m/g/az:w	(Lc/t/m/g/az;)Lc/t/m/g/bj;
      //   2339: iload 9
      //   2341: invokestatic 423	c/t/m/g/by:a	(Lc/t/m/g/by;Lc/t/m/g/bj;Z)Lc/t/m/g/by;
      //   2344: pop
      //   2345: aload 12
      //   2347: aload 14
      //   2349: invokestatic 427	com/tencent/map/geolocation/internal/TencentExtraKeys:setRawQuery	(Lcom/tencent/map/geolocation/TencentLocation;Ljava/lang/String;)V
      //   2352: iconst_0
      //   2353: istore_2
      //   2354: aload 13
      //   2356: getfield 562	c/t/m/g/bl:d	Lc/t/m/g/bk;
      //   2359: ifnull +12 -> 2371
      //   2362: aload 13
      //   2364: getfield 562	c/t/m/g/bl:d	Lc/t/m/g/bk;
      //   2367: getfield 565	c/t/m/g/bk:c	I
      //   2370: istore_2
      //   2371: aload 12
      //   2373: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   2376: ldc_w 567
      //   2379: iload_2
      //   2380: invokevirtual 570	android/os/Bundle:putInt	(Ljava/lang/String;I)V
      //   2383: aload 12
      //   2385: invokevirtual 447	c/t/m/g/by:getVerifyKey	()Ljava/lang/String;
      //   2388: ifnull +356 -> 2744
      //   2391: aload 12
      //   2393: invokevirtual 447	c/t/m/g/by:getVerifyKey	()Ljava/lang/String;
      //   2396: ldc_w 449
      //   2399: invokevirtual 98	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
      //   2402: ifne +342 -> 2744
      //   2405: aload 14
      //   2407: ifnull +134 -> 2541
      //   2410: new 451	org/json/JSONObject
      //   2413: dup
      //   2414: aload 14
      //   2416: invokespecial 452	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   2419: astore_1
      //   2420: aload_1
      //   2421: ldc_w 454
      //   2424: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2427: pop
      //   2428: aload_1
      //   2429: ldc_w 460
      //   2432: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2435: pop
      //   2436: aload_1
      //   2437: ldc_w 462
      //   2440: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2443: pop
      //   2444: aload_1
      //   2445: ldc_w 464
      //   2448: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2451: pop
      //   2452: aload_1
      //   2453: ldc_w 466
      //   2456: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2459: pop
      //   2460: aload_1
      //   2461: ldc_w 468
      //   2464: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2467: pop
      //   2468: aload_1
      //   2469: ldc_w 470
      //   2472: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2475: pop
      //   2476: aload_1
      //   2477: ldc_w 472
      //   2480: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2483: pop
      //   2484: aload_1
      //   2485: ldc_w 474
      //   2488: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2491: pop
      //   2492: aload_1
      //   2493: ldc_w 476
      //   2496: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2499: pop
      //   2500: aload_1
      //   2501: ldc_w 478
      //   2504: invokevirtual 458	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   2507: pop
      //   2508: aload_1
      //   2509: ldc_w 483
      //   2512: aload_0
      //   2513: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2516: invokestatic 487	c/t/m/g/az:x	(Lc/t/m/g/az;)Lc/t/m/g/ba;
      //   2519: invokevirtual 491	c/t/m/g/ba:e	()Ljava/lang/String;
      //   2522: invokevirtual 574	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   2525: pop
      //   2526: aload 12
      //   2528: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   2531: ldc_w 480
      //   2534: aload_1
      //   2535: invokevirtual 481	org/json/JSONObject:toString	()Ljava/lang/String;
      //   2538: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2541: aload 12
      //   2543: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   2546: ldc_w 483
      //   2549: aload_0
      //   2550: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2553: invokestatic 487	c/t/m/g/az:x	(Lc/t/m/g/az;)Lc/t/m/g/ba;
      //   2556: invokevirtual 491	c/t/m/g/ba:e	()Ljava/lang/String;
      //   2559: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
      //   2562: aload 12
      //   2564: invokevirtual 407	c/t/m/g/by:getExtra	()Landroid/os/Bundle;
      //   2567: aload_0
      //   2568: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2571: invokestatic 48	c/t/m/g/az:c	(Lc/t/m/g/az;)Lcom/tencent/map/geolocation/TencentLocationRequest;
      //   2574: invokevirtual 62	com/tencent/map/geolocation/TencentLocationRequest:getExtras	()Landroid/os/Bundle;
      //   2577: invokevirtual 495	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
      //   2580: aload_0
      //   2581: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2584: aload 12
      //   2586: invokestatic 536	c/t/m/g/az:b	(Lc/t/m/g/az;Lc/t/m/g/by;)Lc/t/m/g/by;
      //   2589: pop
      //   2590: aload 11
      //   2592: aload 12
      //   2594: iconst_0
      //   2595: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   2598: iconst_0
      //   2599: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2602: checkcast 95	java/lang/String
      //   2605: invokeinterface 145 4 0
      //   2610: return
      //   2611: astore_1
      //   2612: aload_0
      //   2613: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2616: invokestatic 192	c/t/m/g/az:l	(Lc/t/m/g/az;)Z
      //   2619: ifeq +125 -> 2744
      //   2622: aload_0
      //   2623: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2626: iconst_2
      //   2627: getstatic 262	c/t/m/g/by:a	Lc/t/m/g/by;
      //   2630: invokestatic 265	c/t/m/g/az:a	(Lc/t/m/g/az;ILc/t/m/g/by;)V
      //   2633: return
      //   2634: iconst_0
      //   2635: istore 9
      //   2637: goto -307 -> 2330
      //   2640: astore_1
      //   2641: aload_1
      //   2642: invokevirtual 577	java/lang/Exception:printStackTrace	()V
      //   2645: goto -104 -> 2541
      //   2648: aload_0
      //   2649: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2652: iconst_0
      //   2653: invokestatic 387	c/t/m/g/az:a	(Lc/t/m/g/az;Z)Z
      //   2656: pop
      //   2657: aload_0
      //   2658: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2661: invokestatic 177	c/t/m/g/az:j	(Lc/t/m/g/az;)Z
      //   2664: ifne +80 -> 2744
      //   2667: aload_0
      //   2668: getfield 16	c/t/m/g/az$a:c	Lc/t/m/g/az;
      //   2671: iconst_1
      //   2672: getstatic 262	c/t/m/g/by:a	Lc/t/m/g/by;
      //   2675: invokestatic 265	c/t/m/g/az:a	(Lc/t/m/g/az;ILc/t/m/g/by;)V
      //   2678: return
      //   2679: aload_0
      //   2680: aload_0
      //   2681: getfield 21	c/t/m/g/az$a:a	I
      //   2684: iconst_1
      //   2685: iadd
      //   2686: putfield 21	c/t/m/g/az$a:a	I
      //   2689: aload_0
      //   2690: getfield 21	c/t/m/g/az$a:a	I
      //   2693: iconst_3
      //   2694: if_icmpne +50 -> 2744
      //   2697: aload 11
      //   2699: getstatic 262	c/t/m/g/by:a	Lc/t/m/g/by;
      //   2702: iconst_5
      //   2703: invokestatic 133	c/t/m/g/az:e	()Landroid/util/SparseArray;
      //   2706: iconst_5
      //   2707: invokevirtual 139	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   2710: checkcast 95	java/lang/String
      //   2713: invokeinterface 145 4 0
      //   2718: aload_0
      //   2719: iconst_0
      //   2720: putfield 21	c/t/m/g/az$a:a	I
      //   2723: return
      //   2724: astore_1
      //   2725: goto -145 -> 2580
      //   2728: astore_1
      //   2729: goto -633 -> 2096
      //   2732: astore_1
      //   2733: goto -826 -> 1907
      //   2736: astore_1
      //   2737: goto -869 -> 1868
      //   2740: astore_1
      //   2741: goto -1261 -> 1480
      //   2744: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2745	0	this	a
      //   0	2745	1	paramMessage	Message
      //   837	1543	2	i	int
      //   765	540	3	j	int
      //   52	2224	4	k	int
      //   59	1417	5	l1	long
      //   931	27	7	l2	long
      //   435	2201	9	bool1	boolean
      //   71	907	10	bool2	boolean
      //   33	2665	11	localObject1	Object
      //   7	2586	12	localObject2	Object
      //   45	2318	13	localObject3	Object
      //   790	1625	14	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   12	25	186	finally
      //   26	38	186	finally
      //   187	190	186	finally
      //   1264	1327	1328	java/io/UnsupportedEncodingException
      //   1616	1664	2160	org/json/JSONException
      //   2048	2054	2189	java/lang/Exception
      //   2058	2096	2189	java/lang/Exception
      //   2258	2304	2611	org/json/JSONException
      //   2410	2541	2640	java/lang/Exception
      //   2541	2580	2724	java/lang/Exception
      //   2048	2054	2728	java/lang/Error
      //   2058	2096	2728	java/lang/Error
      //   1868	1907	2732	java/lang/Exception
      //   1755	1868	2736	java/lang/Exception
      //   1399	1437	2740	java/io/UnsupportedEncodingException
      //   1440	1468	2740	java/io/UnsupportedEncodingException
      //   1473	1480	2740	java/io/UnsupportedEncodingException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.az
 * JD-Core Version:    0.7.0.1
 */