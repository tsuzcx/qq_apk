package com.tencent.mobileqq.msf.core.b;

import android.content.Context;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
{
  public static String D = "";
  private static String F;
  public static final String a = "MSF.C.NetConnTag";
  public static final int b = -10008;
  public static final int c = 300000;
  public static final int e = 302;
  static CopyOnWriteArraySet f = new CopyOnWriteArraySet();
  boolean A = false;
  boolean B = false;
  long C = 0L;
  private h E = null;
  Runnable d = null;
  MsfCore g;
  String h = "";
  long i = 0L;
  ArrayList j = new ArrayList();
  long k = 0L;
  long l = 0L;
  long m = 0L;
  public int n = 2;
  ArrayList o = new ArrayList();
  ArrayList p = new ArrayList();
  Thread q = null;
  long r = 0L;
  boolean s = false;
  Thread t = null;
  long u = 0L;
  public long v = 0L;
  final long w = 30L;
  Thread x = null;
  AtomicBoolean y = new AtomicBoolean(false);
  int z = 0;
  
  static
  {
    F = "UTF-8";
  }
  
  public i(MsfCore paramMsfCore)
  {
    this.g = paramMsfCore;
    this.E = new h(paramMsfCore, true);
  }
  
  private a a(ArrayList paramArrayList, boolean paramBoolean, com.tencent.mobileqq.msf.core.d paramd)
  {
    a locala = new a();
    locala.i = System.currentTimeMillis();
    locala.b = paramd.a();
    locala.g = NetConnInfoCenterImpl.getSystemNetworkType();
    locala.j = 0;
    locala.k = 0;
    locala.l = 0;
    locala.m = 0;
    a(paramd, paramBoolean, locala);
    paramArrayList.add(locala);
    return locala;
  }
  
  static void a()
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.setUseSimpleHead((String)localIterator.next(), false);
    }
    f.clear();
  }
  
  private void a(com.tencent.mobileqq.msf.core.d paramd, boolean paramBoolean, a parama)
  {
    if (paramd.b().equalsIgnoreCase("http")) {
      this.E.a(paramd, 2048, 10000, new b(this.g), paramBoolean, parama);
    }
    for (;;)
    {
      D = parama.f;
      return;
      this.E.a(paramd, 2048, 10000, new s(this.g), paramBoolean, parama);
    }
  }
  
  static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      f.add(paramString);
    }
    for (;;)
    {
      CodecWarpper.setUseSimpleHead(paramString, paramBoolean);
      return;
      f.remove(paramString);
    }
  }
  
  private boolean a(CopyOnWriteArrayList paramCopyOnWriteArrayList1, CopyOnWriteArrayList paramCopyOnWriteArrayList2, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "NetChanged selectAndConnect...");
    }
    int i1 = 1;
    int i2;
    label49:
    int i3;
    label213:
    label349:
    int i4;
    for (;;)
    {
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "NetChanged start connect...");
        }
        try
        {
          if (t())
          {
            i2 = 0;
            i1 = 0;
            if (i2 >= paramCopyOnWriteArrayList1.size()) {
              break label1144;
            }
            localObject = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList1.get(i2));
            if (((a)localObject).e == t.c)
            {
              if (this.y.get()) {
                this.y.set(false);
              }
              this.v = 0L;
              return true;
            }
            if (((a)localObject).e == t.m)
            {
              this.v = 0L;
              i2 -= 1;
              i3 = i1 + 1;
              i1 = i3;
              if (i3 > 3)
              {
                this.y.set(false);
                return false;
              }
            }
            else
            {
              if ((((a)localObject).e != t.t) && (((a)localObject).e != t.q)) {
                break label1162;
              }
              if ((i2 == 0) && (!this.y.get())) {
                b(((a)localObject).b);
              }
              s();
              break label1162;
            }
            if (((a)localObject).h <= 0) {
              break label1171;
            }
            Thread.sleep(((a)localObject).h);
            if (t()) {
              break label1171;
            }
            if (!QLog.isColorLevel()) {
              break label1165;
            }
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from wifi to mobile connect again");
            break label1165;
          }
          if (r() == null) {
            break label813;
          }
          i2 = 0;
          i1 = 0;
          if (i2 >= paramCopyOnWriteArrayList2.size()) {
            break label1156;
          }
          Object localObject = (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i2);
          if (((com.tencent.mobileqq.msf.core.d)localObject).g != 1) {
            break label633;
          }
          localObject = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)localObject);
          if (((a)localObject).e != t.c) {
            break label387;
          }
          if (this.y.get()) {
            this.y.set(false);
          }
          this.v = 0L;
          return true;
        }
        catch (Exception localException1)
        {
          i1 = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "selectAndConnect error " + localException1, localException1);
        }
        continue;
        label387:
        if (localException1.e == t.m)
        {
          this.v = 0L;
          i4 = i2 - 1;
          i1 += 1;
          i3 = i1;
          if (i1 <= 3) {
            break label572;
          }
          i1 = 0;
          label428:
          i4 = 0;
        }
        for (i3 = 0;; i3 = i2)
        {
          for (;;)
          {
            i2 = i1;
            try
            {
              if (i4 >= paramCopyOnWriteArrayList2.size()) {
                break label793;
              }
              a locala1 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i4));
              if (locala1.e != t.c) {
                break label642;
              }
              if (this.y.get()) {
                this.y.set(false);
              }
              this.v = 0L;
              return true;
            }
            catch (Exception localException2) {}
            break label349;
            if (localException2.e != t.t)
            {
              i4 = i2;
              i3 = i1;
              if (localException2.e != t.q) {}
            }
            else
            {
              if ((i2 == 0) && (!this.y.get())) {
                b(localException2.b);
              }
              s();
              i3 = i1;
              i4 = i2;
            }
            label572:
            i2 = i4;
            i1 = i3;
            if (localException2.h > 0)
            {
              Thread.sleep(localException2.h);
              i2 = i4;
              i1 = i3;
              if (t())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
                }
                i1 = 1;
                break label428;
              }
            }
            label633:
            i2 += 1;
            break;
            label642:
            if (localException2.e == t.m)
            {
              this.v = 0L;
              i2 = i4 - 1;
              i4 = i3 + 1;
              i3 = i2;
              i2 = i4;
              if (i4 > 3)
              {
                this.y.set(false);
                return false;
              }
            }
            else
            {
              if ((localException2.e != t.t) && (localException2.e != t.q)) {
                break label1180;
              }
              if ((i4 == 0) && (!this.y.get())) {
                b(localException2.b);
              }
              s();
              break label1180;
            }
            label747:
            if (localException2.h > 0)
            {
              Thread.sleep(localException2.h);
              boolean bool = t();
              if (!bool) {}
            }
            try
            {
              if (!QLog.isColorLevel()) {
                break label1150;
              }
              QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
              i2 = 1;
              label793:
              i1 = i2;
            }
            catch (Exception localException3)
            {
              a locala2;
              i1 = 1;
            }
          }
          i4 = i3 + 1;
        }
        label813:
        i2 = 0;
        i1 = 0;
        label819:
        if (i2 >= paramCopyOnWriteArrayList2.size()) {
          break label1144;
        }
        locala2 = a(paramArrayList, paramBoolean, (com.tencent.mobileqq.msf.core.d)paramCopyOnWriteArrayList2.get(i2));
        if (locala2.e == t.c)
        {
          if (this.y.get()) {
            this.y.set(false);
          }
          this.v = 0L;
          return true;
        }
        if (locala2.e == t.m)
        {
          this.v = 0L;
          i2 -= 1;
          i3 = i1 + 1;
          i1 = i3;
          if (i3 > 3)
          {
            this.y.set(false);
            return false;
          }
        }
        else
        {
          if ((locala2.e != t.t) && (locala2.e != t.q)) {
            break label1191;
          }
          if ((i2 == 0) && (!this.y.get())) {
            b(locala2.b);
          }
          s();
          break label1191;
        }
      }
    }
    label1156:
    label1162:
    label1165:
    label1171:
    label1180:
    label1191:
    for (;;)
    {
      if (locala2.h > 0)
      {
        Thread.sleep(locala2.h);
        if (t())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "NetChanged from mobile to wifi connect again");
          }
          i1 = 1;
          break;
        }
      }
      i2 += 1;
      break label819;
      if ((this.y.get()) && (this.A) && (!this.B) && (this.p.size() > 0))
      {
        this.y.set(false);
        this.A = false;
        this.B = false;
        long l1 = System.currentTimeMillis();
        long l2 = this.C;
        this.g.getStatReporter().a(b(), this.z, l1 - l2, this.p);
        this.p.clear();
      }
      return false;
      break label349;
      label1144:
      i1 = 0;
      break;
      label1150:
      i2 = 1;
      break label793;
      i1 = 0;
      break label428;
      break label213;
      i1 = 1;
      break;
      i2 += 1;
      break label49;
      i2 = i3;
      i3 = i4;
      break label747;
    }
  }
  
  private int b(int paramInt1, int paramInt2, String paramString1, String paramString2, MsfCommand paramMsfCommand, String paramString3, int paramInt3, byte[] paramArrayOfByte)
    throws Exception
  {
    if (!this.E.r.get()) {
      f();
    }
    return this.E.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, paramArrayOfByte);
  }
  
  /* Error */
  private static void b(Context paramContext)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 12
    //   12: iconst_2
    //   13: ldc_w 346
    //   16: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 352	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: ldc_w 354
    //   26: invokevirtual 360	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_2
    //   34: new 362	java/io/FileOutputStream
    //   37: dup
    //   38: new 303	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 366	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 371	java/io/File:getParent	()Ljava/lang/String;
    //   52: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 373
    //   58: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 375	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: sipush 1024
    //   71: newarray byte
    //   73: astore_3
    //   74: aload_2
    //   75: aload_3
    //   76: invokevirtual 381	java/io/InputStream:read	([B)I
    //   79: istore_1
    //   80: iload_1
    //   81: ifle +64 -> 145
    //   84: aload_0
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 387	java/io/OutputStream:write	([BII)V
    //   91: goto -17 -> 74
    //   94: astore_3
    //   95: invokestatic 246	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +30 -> 128
    //   101: ldc 12
    //   103: iconst_2
    //   104: new 303	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 389
    //   114: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: invokevirtual 313	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_3
    //   125: invokestatic 319	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 392	java/io/InputStream:close	()V
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 393	java/io/OutputStream:close	()V
    //   144: return
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 392	java/io/InputStream:close	()V
    //   153: aload_0
    //   154: ifnull -10 -> 144
    //   157: aload_0
    //   158: invokevirtual 393	java/io/OutputStream:close	()V
    //   161: return
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 392	java/io/InputStream:close	()V
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 393	java/io/OutputStream:close	()V
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -19 -> 165
    //   187: astore 4
    //   189: aload_0
    //   190: astore_3
    //   191: aload 4
    //   193: astore_0
    //   194: goto -29 -> 165
    //   197: astore 4
    //   199: aload_0
    //   200: astore_3
    //   201: aload 4
    //   203: astore_0
    //   204: goto -39 -> 165
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_0
    //   210: goto -115 -> 95
    //   213: astore_3
    //   214: aconst_null
    //   215: astore_0
    //   216: goto -121 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	Context
    //   79	9	1	i1	int
    //   3	167	2	localObject1	Object
    //   1	85	3	arrayOfByte	byte[]
    //   94	84	3	localException1	Exception
    //   190	11	3	localContext	Context
    //   207	1	3	localException2	Exception
    //   213	1	3	localException3	Exception
    //   29	3	4	localInputStream	java.io.InputStream
    //   187	5	4	localObject2	Object
    //   197	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   68	74	94	java/lang/Exception
    //   74	80	94	java/lang/Exception
    //   84	91	94	java/lang/Exception
    //   19	31	162	finally
    //   34	68	183	finally
    //   68	74	187	finally
    //   74	80	187	finally
    //   84	91	187	finally
    //   95	128	197	finally
    //   19	31	207	java/lang/Exception
    //   34	68	213	java/lang/Exception
  }
  
  public static boolean h()
  {
    return i() != null;
  }
  
  public static String i()
  {
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("ps").getInputStream()));
      localObject = localBufferedReader.readLine().split("\\s+");
      i4 = localObject.length;
      i2 = 0;
      i3 = 1;
      i1 = 0;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        BufferedReader localBufferedReader;
        Object localObject;
        int i4;
        int i2;
        int i3;
        int i1;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "Error killing tcpdump, msg=" + localIOException.getMessage());
          continue;
          i2 += 1;
          i1 += 1;
        }
      }
    }
    if (i2 < i4)
    {
      if (localObject[i2].equalsIgnoreCase("PID")) {
        i3 = i1;
      }
    }
    else
    {
      do
      {
        localObject = localBufferedReader.readLine();
        if (localObject == null) {
          break;
        }
      } while ((!((String)localObject).contains(BaseApplication.getContext().getFilesDir().getParent() + "/txlib/" + "tcpdump")) || (((String)localObject).contains("sh -c")));
      localObject = ((String)localObject).split("\\s+");
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump uid:" + localObject[i3]);
      }
      localBufferedReader.close();
      return localObject[i3];
      localBufferedReader.close();
      return null;
    }
  }
  
  public static void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump begin");
    }
    try
    {
      Object localObject = i();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "tcpdump: stopTCPDump pid not find");
        }
      }
      else
      {
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "su", "-c", "kill " + (String)localObject }).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "tcpdump kill error=" + str);
          }
        }
      }
      return;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump Error killing tcpdump, msg=" + localIOException.getMessage());
        return;
        localIOException.close();
      }
    }
  }
  
  private void q()
  {
    long l1 = SystemClock.elapsedRealtime();
    StringBuffer localStringBuffer;
    if ((this.i == 0L) || (l1 - this.i > Long.parseLong(com.tencent.mobileqq.msf.core.a.a.d())))
    {
      this.i = l1;
      localStringBuffer = new StringBuffer();
      com.tencent.mobileqq.msf.core.d locald;
      if (NetConnInfoCenterImpl.isWifiConn())
      {
        localIterator = this.g.getSsoListManager().h().iterator();
        while (localIterator.hasNext())
        {
          locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
          localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
        }
      }
      Iterator localIterator = this.g.getSsoListManager().i().iterator();
      while (localIterator.hasNext())
      {
        locald = (com.tencent.mobileqq.msf.core.d)localIterator.next();
        localStringBuffer.append(locald.b() + "//" + locald.c() + ":" + locald.d() + ",");
      }
    }
    try
    {
      this.g.configManager.a(this.g.sender.h(), this.g.sender.g(), 60000L, NetConnInfoCenterImpl.isWifiConn(), localStringBuffer.toString());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MSF.C.NetConnTag", 2, localException.toString(), localException);
    }
  }
  
  private String r()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return System.getProperty("http.proxyHost");
    }
    return Proxy.getDefaultHost();
  }
  
  private void s()
  {
    if ((!NetConnInfoCenterImpl.isWifiConn()) || (!NetConnInfoCenterImpl.isNetSupport())) {
      this.v = 0L;
    }
    long l1;
    do
    {
      do
      {
        return;
      } while (this.x != null);
      l1 = System.currentTimeMillis();
    } while ((this.v != 0L) && (l1 - this.v < 30000L));
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "start checkIfNeedSignonNet");
    }
    this.x = new q(this);
    this.x.setName("checkIfNeedSignonNet");
    this.x.start();
  }
  
  private boolean t()
  {
    return (NetConnInfoCenterImpl.isWifiConn()) || ((!NetConnInfoCenterImpl.isWifiOrMobileConn()) && (NetConnInfoCenterImpl.getCurrentAPN() == null));
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.E.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    long l3 = 0L;
    long l1;
    if (this.k != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "firstResponseGetted getted Report now");
      }
      l1 = -1L;
      if (this.l >= this.k) {
        l1 = this.l - this.k;
      }
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "from msg TIMESTAMP_NET2MSF not find return");
        }
        c();
      }
    }
    else
    {
      return;
    }
    long l5 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue();
    long l6 = this.l;
    long l2;
    if (paramToServiceMsg.getAttribute("__timestamp_msf2net") == null)
    {
      l2 = l3;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, "to msg TIMESTAMP_MSF2NET not find set nFirstPacketTimeElapse to 0");
        l2 = l3;
      }
    }
    for (;;)
    {
      boolean bool = false;
      if (paramFromServiceMsg.getServiceCmd().equals("login.auth")) {
        bool = true;
      }
      if (this.j.size() > 0)
      {
        paramFromServiceMsg = (a)this.j.get(this.j.size() - 1);
        paramFromServiceMsg.m = 1;
        paramFromServiceMsg.l = 1;
        this.g.getStatReporter().a(true, l1, l5 - l6, l2, bool, this.j, this.n);
      }
      c();
      NetConnInfoCenter.onRecvFirstResp();
      return;
      l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      long l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - l2;
      if ((l4 < 0L) || (l2 == 0L))
      {
        l2 = l3;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.C.NetConnTag", 2, "nFirstPacketTimeElapse:" + l4 + " reset 0 now TIMESTAMP_NET2MSF:" + this.g.timeFormatter.format(paramFromServiceMsg.getAttribute("__timestamp_net2msf")) + " TIMESTAMP_MSF2NET:" + this.g.timeFormatter.format(paramToServiceMsg.getAttribute("__timestamp_msf2net")));
          l2 = l3;
        }
      }
      else
      {
        l2 = l4;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.h = paramString;
      com.tencent.qphone.base.BaseConstants.isUseDebugSso = true;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new j(this, paramString, paramInt);
    paramString.setName("checkNetConnectBySocketThread");
    paramString.start();
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, MsfCommand paramMsfCommand, String paramString3, int paramInt3, byte[] paramArrayOfByte)
    throws Exception
  {
    if (b(paramInt1, paramInt2, paramString1, paramString2, paramMsfCommand, paramString3, paramInt3, paramArrayOfByte) == -100)
    {
      f();
      if (this.E.a(paramInt1, paramInt2, paramInt3, paramString3, paramString1, paramString2, paramMsfCommand, paramArrayOfByte) == -100) {
        return false;
      }
      if ((this.m == 0L) && (this.k != 0L) && (this.l != 0L)) {
        this.m = System.currentTimeMillis();
      }
      return true;
    }
    if ((this.m == 0L) && (this.k != 0L) && (this.l != 0L)) {
      this.m = System.currentTimeMillis();
    }
    return true;
  }
  
  public void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.r > 180000L)
    {
      l();
      this.r = l1;
      m();
      a("www.baidu.com", 80);
      a("115.239.210.27", 80);
      g();
      c(paramString.split(":")[0].trim());
    }
  }
  
  public boolean b()
  {
    return this.E.r.get();
  }
  
  public void c()
  {
    this.m = 0L;
    this.k = 0L;
    this.l = 0L;
    this.j.clear();
    this.n = 2;
    if (this.d != null)
    {
      this.g.getMsfAlarmer().a(this.d);
      this.d = null;
    }
  }
  
  public void c(String paramString)
  {
    paramString = new o(this, paramString);
    paramString.setName("pingServerThread");
    paramString.start();
  }
  
  public void d()
  {
    if (this.k != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut Report now");
      }
      if (this.l < this.k) {
        break label153;
      }
      if (this.m == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut. m_firstPacketSendTimeAfterConnect == 0");
        }
        c();
        return;
      }
    }
    label153:
    for (long l1 = this.l - this.k;; l1 = -1L)
    {
      this.g.getStatReporter().a(false, l1, -1L, -1L, false, this.j, this.n);
      c();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "loginConnectTimeOut m_startConnectTime : " + this.k + "no need Report");
      }
      c();
      return;
    }
  }
  
  public void e()
  {
    if (this.j.size() > 0)
    {
      a locala = (a)this.j.get(this.j.size() - 1);
      if (locala != null)
      {
        locala.e = t.y;
        locala.d = false;
        locala.l = 0;
        locala.m = 1;
      }
    }
  }
  
  protected boolean f()
    throws Exception
  {
    if (this.h.length() > 0) {}
    long l1;
    boolean bool1;
    Object localObject2;
    label446:
    do
    {
      do
      {
        try
        {
          this.k = System.currentTimeMillis();
          this.l = this.k;
          a locala = new a();
          locala.b = this.h;
          locala.g = NetConnInfoCenterImpl.getSystemNetworkType();
          locala.j = 0;
          locala.k = 0;
          locala.l = 0;
          locala.m = 0;
          a(com.tencent.mobileqq.msf.core.d.a(this.h), true, locala);
          bool2 = true;
          return bool2;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "conn assigned server " + this.h + " error " + localException, localException);
          }
          return false;
        }
        long l2 = SystemClock.elapsedRealtime();
        l1 = 0L;
        localObject1 = new ArrayList();
        this.k = System.currentTimeMillis();
        this.l = this.k;
        int i1;
        if ((this.g.getSsoListManager().h().size() > 0) || (this.g.getSsoListManager().i().size() > 0))
        {
          bool1 = a(this.g.getSsoListManager().h(), this.g.getSsoListManager().i(), (ArrayList)localObject1, false);
          l1 = SystemClock.elapsedRealtime() - l2;
          i1 = 1;
          localIterator = ((ArrayList)localObject1).iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label446;
          }
          localObject2 = (a)localIterator.next();
          if ((((a)localObject2).e == t.m) || (((a)localObject2).e == t.s) || (((a)localObject2).e == t.i) || (((a)localObject2).e == t.o) || (((a)localObject2).e == t.p) || (((a)localObject2).e == t.q) || (((a)localObject2).e == t.y))
          {
            c();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "sso list is null.");
            }
            bool1 = false;
            i1 = 0;
            break;
          }
          if (this.k == 0L)
          {
            this.k = ((a)localObject2).i;
            this.l = this.k;
          }
          if (this.d == null) {
            this.d = this.g.getMsfAlarmer().a(this, 300000L);
          }
          this.j.add(localObject2);
        }
        if (bool1) {
          break label777;
        }
        l1 = SystemClock.elapsedRealtime();
        if ((NetConnInfoCenterImpl.isWifiOrMobileConn()) && (i1 != 0))
        {
          q();
          this.g.getStatReporter().a(false, false, false, l1 - l2, (ArrayList)localObject1);
        }
        NetConnInfoCenter.onOepnConnAllFailed();
        l1 = System.currentTimeMillis();
        if ((!NetConnInfoCenterImpl.isWifiConn()) && ((NetConnInfoCenterImpl.isWifiOrMobileConn()) || (NetConnInfoCenterImpl.getCurrentAPN() != null))) {
          break;
        }
        bool2 = bool1;
      } while (l1 - com.tencent.mobileqq.msf.core.a.a.E >= 60000L);
      localObject1 = new StringBuffer();
      localIterator = this.g.getSsoListManager().h().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (com.tencent.mobileqq.msf.core.d)localIterator.next();
        if (localObject2 != null) {
          ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
        }
      }
      localObject1 = ((StringBuffer)localObject1).toString();
      this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.E, (String)localObject1);
      com.tencent.mobileqq.msf.core.a.a.E = 0L;
      return bool1;
      boolean bool2 = bool1;
    } while (l1 - com.tencent.mobileqq.msf.core.a.a.F >= 60000L);
    Object localObject1 = new StringBuffer();
    Iterator localIterator = this.g.getSsoListManager().i().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (com.tencent.mobileqq.msf.core.d)localIterator.next();
      if (localObject2 != null) {
        ((StringBuffer)localObject1).append(((com.tencent.mobileqq.msf.core.d)localObject2).toString() + ";");
      }
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    this.g.getStatReporter().a(false, l1 - com.tencent.mobileqq.msf.core.a.a.F, (String)localObject1);
    com.tencent.mobileqq.msf.core.a.a.F = 0L;
    return bool1;
    label777:
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    if (!NetConnInfoCenterImpl.isWifiOrMobileConn()) {
      NetConnInfoCenterImpl.setLastConnSuccWithoutNet();
    }
    if (NetConnInfoCenterImpl.isWifiOrMobileConn()) {
      this.g.getStatReporter().a(false, false, bool1, l1, (ArrayList)localObject1);
    }
    return true;
  }
  
  public void g()
  {
    if (this.q != null) {}
    do
    {
      do
      {
        return;
      } while (com.tencent.mobileqq.msf.core.a.a.n() == 0);
      localObject1 = com.tencent.mobileqq.msf.core.a.a.m();
    } while (localObject1 == null);
    this.o.clear();
    Object localObject1 = ((String)localObject1).split(";");
    int i2 = localObject1.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = localObject1[i1];
      a locala = new a();
      locala.a = localObject2;
      locala.b = 1;
      locala.c = "";
      this.o.add(locala);
      i1 += 1;
    }
    this.q = new k(this);
    this.q.setName("checkNetConnectByConnectSSOThread");
    this.q.start();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "tcpdump Report begin");
    }
    if (this.t != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump tcpDumpReportThread started return");
      }
      return;
    }
    this.t = new l(this);
    this.t.setName("tcpDumpReportThread");
    this.t.start();
  }
  
  public void l()
  {
    if (h())
    {
      if (System.currentTimeMillis() - this.u > 120000L) {
        j();
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "tcpdump is running return");
      }
      return;
    }
    n localn = new n(this);
    localn.setName("tcpDumpThread");
    localn.start();
  }
  
  public void m()
  {
    p localp = new p(this);
    localp.setName("checkNetConnectByHttpThread");
    localp.start();
    this.y.set(true);
  }
  
  public h n()
  {
    return this.E;
  }
  
  public String o()
  {
    return this.h;
  }
  
  public class a
  {
    public String a = "";
    public byte b = 1;
    public String c = "";
    
    public a() {}
    
    public void a()
    {
      this.b = 1;
      this.c = "";
      Object localObject = this.a;
      if (localObject == null) {}
      for (;;)
      {
        return;
        String str = localObject.split(":")[0].trim();
        int i = Integer.parseInt(localObject.split(":")[1].trim());
        this.b = 2;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "start send checkNetConnectByConnectSSO server:" + str + " port:" + i);
          }
          localObject = new Socket();
          InetSocketAddress localInetSocketAddress = new InetSocketAddress(str, i);
          ((Socket)localObject).setSoTimeout(10000);
          ((Socket)localObject).setTcpNoDelay(true);
          ((Socket)localObject).setKeepAlive(true);
          ((Socket)localObject).connect(localInetSocketAddress, 10000);
          this.b = 3;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO connect server:" + str + " port:" + i + " success");
          }
          ((Socket)localObject).close();
          return;
        }
        catch (Throwable localThrowable)
        {
          if (localThrowable != null) {
            this.c = localThrowable.toString().toLowerCase();
          }
          if (this.c.indexOf("timeoutexception") > -1) {
            break label235;
          }
        }
        if (this.c.indexOf(") after") > -1) {}
        label235:
        for (this.b = 5; QLog.isColorLevel(); this.b = 4)
        {
          QLog.d("MSF.C.NetConnTag", 2, "checkNetConnectByConnectSSO Throwable connect server:" + str + " port:" + i + " failed" + localThrowable, localThrowable);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.i
 * JD-Core Version:    0.7.0.1
 */