package com.tencent.qmsp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.a.e;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;
import com.tencent.qmsp.sdk.f.m;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class c
  implements Handler.Callback
{
  private ConcurrentHashMap<String, com.tencent.qmsp.sdk.b.b> a = new ConcurrentHashMap();
  private Handler b = new Handler(com.tencent.qmsp.sdk.app.b.e().b(), this);
  final Object c = new Object();
  private int d = 0;
  private d.b e = null;
  private String f = "";
  private String g = "";
  private SharedPreferences h = null;
  private b i = null;
  private int j = 0;
  
  public c(Context paramContext)
  {
    this.h = paramContext.getSharedPreferences(com.tencent.qmsp.sdk.c.b.a + a(d.b), 0);
    this.i = new b();
  }
  
  private int a(int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    try
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "No matched update from server.");
      return -1;
    }
    catch (Exception paramString)
    {
      String str;
      boolean bool;
      paramString.printStackTrace();
    }
    if (this.h.getInt(a(d.d), 0) < paramInt) {
      return 0;
    }
    str = c();
    if (!new File(str).exists()) {
      return 0;
    }
    str = a.a(str);
    if ((str != null) && (str.equalsIgnoreCase(paramString)))
    {
      if (str != null)
      {
        bool = str.equalsIgnoreCase(paramString);
        if (bool) {
          return 1;
        }
      }
      return -1;
    }
    return 0;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = com.tencent.qmsp.sdk.a.d.a(2);
      if (localObject2 == null) {
        return;
      }
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put(e.a(20), paramInt1);
      localJSONObject2.put(e.a(21), paramInt2);
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put(e.a(15), localObject2);
      localJSONObject1.put(e.a(16), localJSONObject2);
      localObject2 = new StringBuilder();
      com.tencent.qmsp.sdk.f.g.d("Qp.QUM", 0, "[SFU] request : " + localJSONObject1.toString());
      com.tencent.qmsp.sdk.b.g.b().a(2, QmspSDK.getAppID(), 2, localJSONObject1, new c.b(this));
      int k = this.j;
      a("0X80078AA", paramInt1, k, "", "");
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] send update query: fileid=%d, localversion=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return;
    }
    finally
    {
      localObject1.printStackTrace();
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    String str = String.format("%d", new Object[] { Integer.valueOf(paramInt1) });
    Object localObject = this.e;
    if (localObject != null)
    {
      paramInt1 = (int)((d.b)localObject).b;
      localObject = this.e;
      if (localObject == null) {
        break label194;
      }
    }
    label194:
    for (localObject = String.format("%d", new Object[] { Long.valueOf(((d.b)localObject).a) });; localObject = "")
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(this.d), localObject, str, "", "" }));
      com.tencent.qmsp.sdk.a.g localg = new com.tencent.qmsp.sdk.a.g();
      try
      {
        localg.a(paramString1).a(str).a((String)localObject).a(this.d).a(paramInt2).a(paramString2).a(paramString3);
        com.tencent.qmsp.sdk.a.f.a(localg.toString(), 2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        com.tencent.qmsp.sdk.f.g.b(com.tencent.qmsp.sdk.f.g.a, 0, "onReport error! <JsonObject userData>!");
      }
      paramInt1 = 0;
      break;
    }
  }
  
  private void a(boolean paramBoolean, com.tencent.qmsp.sdk.b.b paramb)
  {
    if ((!paramBoolean) || (paramb == null)) {
      a(3);
    }
    c localc;
    int k;
    do
    {
      return;
      localFile = new File(paramb.b);
      localc = (c)paramb.a();
      if ((!localFile.exists()) || (localc == null))
      {
        a(3);
        return;
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] http download complete: %s, %s", new Object[] { paramb.b, localc.e }));
      k = localc.a;
      if (k == 1) {
        break;
      }
    } while (k != 2);
    a("0X80078AE", localc.g, this.j, "", "");
    b(7);
    return;
    File localFile = new File(c());
    new File(paramb.b).renameTo(localFile);
    a("0X80078AC", localc.g, this.j, "", "");
    if (this.i.a(localFile.toString()))
    {
      this.h.edit().putInt(a(d.d), localc.g).commit();
      if (this.i.a().isEmpty())
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] config ok but without any sections");
        b(16);
        return;
      }
      b(5);
      return;
    }
    a("0X80078AD", localc.g, this.j, localc.d, localc.e);
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] invalid config (sig not accepted)");
    a(1);
  }
  
  private boolean a(c paramc)
  {
    if (paramc == null) {}
    do
    {
      return false;
      if ((paramc.a == 2) && (paramc.k != 1) && (!com.tencent.qmsp.sdk.f.f.b(QmspSDK.getContext())))
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] donot download file because not using wifi");
        com.tencent.qmsp.sdk.a.a.a(3, 3);
        return false;
      }
    } while ((paramc.i < 3) && (this.a.contains(paramc.f.toLowerCase())));
    com.tencent.qmsp.sdk.b.b localb = new com.tencent.qmsp.sdk.b.b();
    localb.a = paramc.e;
    localb.b = (paramc.c + paramc.d);
    localb.d = paramc.d;
    localb.c = paramc.c;
    paramc.i += 1;
    localb.a(paramc);
    this.a.put(paramc.f.toLowerCase(), localb);
    try
    {
      com.tencent.qmsp.sdk.b.d.a(localb);
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] begin http download %s", new Object[] { paramc.e }));
      return true;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private boolean a(d.b paramb)
  {
    int k;
    boolean bool;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] backup: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      k = paramb.r < 0L;
      if (k == 0)
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] no files need to backup");
        bool = true;
      }
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] backup result: %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      if (k > 0)
      {
        String str1 = f(paramb);
        long l1 = 0L;
        k = 0;
        while (k < paramb.q.size())
        {
          d.a locala = (d.a)paramb.q.get(k);
          long l2 = l1;
          if (1 == locala.j)
          {
            String str2 = str1 + locala.c;
            a(new File(locala.f), new File(str2));
            l2 = l1 + 1L;
          }
          int m;
          k += 1;
          l1 = l2;
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] backup %d files of %d", new Object[] { Long.valueOf(l1), Integer.valueOf(paramb.q.size()) }));
        if (paramb.r == l1) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  /* Error */
  private boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: invokevirtual 134	java/io/File:exists	()Z
    //   7: ifeq +12 -> 19
    //   10: aload_2
    //   11: invokevirtual 406	java/io/File:delete	()Z
    //   14: ifne +34 -> 48
    //   17: iconst_0
    //   18: ireturn
    //   19: new 127	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: invokevirtual 409	java/io/File:getParent	()Ljava/lang/String;
    //   27: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 5
    //   32: aload 5
    //   34: invokevirtual 134	java/io/File:exists	()Z
    //   37: ifne +11 -> 48
    //   40: aload 5
    //   42: invokevirtual 412	java/io/File:mkdirs	()Z
    //   45: ifeq +194 -> 239
    //   48: new 414	java/io/FileOutputStream
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: new 419	java/io/BufferedInputStream
    //   60: dup
    //   61: new 421	java/io/FileInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 422	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 425	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore_1
    //   73: invokestatic 430	com/tencent/qmsp/sdk/f/a:a	()Lcom/tencent/qmsp/sdk/f/a;
    //   76: sipush 4096
    //   79: invokevirtual 433	com/tencent/qmsp/sdk/f/a:a	(I)[B
    //   82: astore 4
    //   84: aload_1
    //   85: aload 4
    //   87: invokevirtual 437	java/io/BufferedInputStream:read	([B)I
    //   90: istore_3
    //   91: iload_3
    //   92: iconst_m1
    //   93: if_icmpeq +46 -> 139
    //   96: aload_2
    //   97: aload 4
    //   99: iconst_0
    //   100: iload_3
    //   101: invokevirtual 441	java/io/FileOutputStream:write	([BII)V
    //   104: aload_2
    //   105: invokevirtual 444	java/io/FileOutputStream:flush	()V
    //   108: goto -24 -> 84
    //   111: astore 4
    //   113: aload 4
    //   115: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   118: aload_2
    //   119: ifnull +7 -> 126
    //   122: aload_2
    //   123: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   126: aload_1
    //   127: ifnull +112 -> 239
    //   130: aload_1
    //   131: invokevirtual 448	java/io/BufferedInputStream:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_1
    //   137: iconst_0
    //   138: ireturn
    //   139: invokestatic 430	com/tencent/qmsp/sdk/f/a:a	()Lcom/tencent/qmsp/sdk/f/a;
    //   142: aload 4
    //   144: invokevirtual 451	com/tencent/qmsp/sdk/f/a:a	([B)V
    //   147: aload_2
    //   148: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   151: aload_1
    //   152: invokevirtual 448	java/io/BufferedInputStream:close	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: astore_1
    //   158: iconst_1
    //   159: ireturn
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -51 -> 113
    //   167: astore_1
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   178: aload 4
    //   180: ifnull +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 448	java/io/BufferedInputStream:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_2
    //   196: goto -83 -> 113
    //   199: astore 4
    //   201: aload_1
    //   202: astore 5
    //   204: aload 4
    //   206: astore_1
    //   207: aload 5
    //   209: astore 4
    //   211: goto -41 -> 170
    //   214: astore_2
    //   215: goto -64 -> 151
    //   218: astore_2
    //   219: goto -93 -> 126
    //   222: astore_2
    //   223: goto -45 -> 178
    //   226: astore_2
    //   227: goto -39 -> 188
    //   230: astore 4
    //   232: goto -31 -> 201
    //   235: astore_1
    //   236: goto -66 -> 170
    //   239: iconst_0
    //   240: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	c
    //   0	241	1	paramFile1	File
    //   0	241	2	paramFile2	File
    //   90	11	3	k	int
    //   1	97	4	arrayOfByte	byte[]
    //   111	32	4	localIOException1	IOException
    //   160	24	4	localIOException2	IOException
    //   190	1	4	localIOException3	IOException
    //   199	6	4	localObject1	Object
    //   209	1	4	localObject2	Object
    //   230	1	4	localObject3	Object
    //   30	178	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   73	84	111	java/io/IOException
    //   84	91	111	java/io/IOException
    //   96	108	111	java/io/IOException
    //   139	147	111	java/io/IOException
    //   130	134	136	java/io/IOException
    //   151	155	157	java/io/IOException
    //   57	73	160	java/io/IOException
    //   3	17	167	finally
    //   19	48	167	finally
    //   48	57	167	finally
    //   3	17	190	java/io/IOException
    //   19	48	190	java/io/IOException
    //   48	57	190	java/io/IOException
    //   73	84	199	finally
    //   84	91	199	finally
    //   96	108	199	finally
    //   139	147	199	finally
    //   147	151	214	java/io/IOException
    //   122	126	218	java/io/IOException
    //   174	178	222	java/io/IOException
    //   183	188	226	java/io/IOException
    //   113	118	230	finally
    //   57	73	235	finally
  }
  
  private void b()
  {
    try
    {
      this.h.edit().putLong(a(d.c), System.currentTimeMillis()).commit();
      b(2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(int paramInt)
  {
    int k = 8;
    int m = 5;
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 2, String.format("[SFU] update event: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 17: 
      try
      {
        h();
        return;
      }
      finally
      {
        localObject.printStackTrace();
        return;
      }
    case 16: 
      g();
      paramInt = 17;
    case 15: 
      do
      {
        b(paramInt);
        return;
        i(this.e);
        this.e = null;
        paramInt = m;
      } while (!f());
      break;
    case 14: 
      if (this.e != null) {
        b(this.e);
      }
      break;
    case 13: 
      label133:
      if ((this.e == null) || (!j(this.e))) {}
      break;
    }
    for (;;)
    {
      label203:
      a(paramInt);
      return;
      paramInt = this.j;
      a("0X80078B3", 0, paramInt, "", "");
      paramInt = 10;
      continue;
      if (this.e != null) {
        if (!c(this.e))
        {
          break label563;
          if ((this.e == null) || (!m(this.e))) {
            break label569;
          }
          paramInt = 12;
          break label133;
        }
      }
      for (;;)
      {
        c(paramInt);
        paramInt = 13;
        break label133;
        if ((this.e != null) && (l(this.e)))
        {
          paramInt = 11;
          break label133;
          boolean bool;
          if (this.e != null)
          {
            bool = a(this.e);
            if (bool)
            {
              paramInt = 10;
              break label133;
            }
          }
          paramInt = this.j;
          a("0X80078B1", 0, paramInt, "", "");
          paramInt = 6;
          break label203;
          if (this.e != null)
          {
            bool = k(this.e);
            if (bool)
            {
              paramInt = 9;
              break label133;
            }
          }
          paramInt = this.j;
          a("0X80078B0", 0, paramInt, "", "");
          paramInt = 5;
          break label203;
          if (this.e != null)
          {
            bool = n(this.e);
            if (bool)
            {
              paramInt = 8;
              break label133;
            }
          }
          paramInt = this.j;
          a("0X80078AF", 0, paramInt, "", "");
          paramInt = 4;
          break label203;
          if (this.e == null) {
            break label580;
          }
          if (d(this.e)) {
            break;
          }
          break label580;
          if ((d()) && (this.e != null))
          {
            if (!e(this.e)) {
              break label552;
            }
            paramInt = 6;
            break label133;
            i();
            return;
            paramInt = this.d;
            if (paramInt == 1)
            {
              paramInt = 17;
              break label133;
            }
            paramInt = 14;
            break label133;
          }
          paramInt = 16;
          break label133;
          label552:
          paramInt = 15;
          break label133;
          paramInt = 0;
          break label203;
          label563:
          paramInt = 9;
          break label203;
          label569:
          paramInt = k;
          continue;
        }
        paramInt = 7;
      }
      label580:
      paramInt = 3;
    }
  }
  
  private void b(com.tencent.qmsp.sdk.b.c paramc)
  {
    boolean bool = true;
    if (paramc == null) {}
    int k;
    c localc;
    do
    {
      return;
      k = paramc.a;
      if (k == 2)
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] http download error=%d", new Object[] { Integer.valueOf(k) }));
        return;
      }
      localc = (c)paramc.b.a();
    } while (localc == null);
    if (paramc.a == 0) {}
    while (!bool)
    {
      try
      {
        k = localc.i;
        if (k >= 3) {
          break label141;
        }
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", new Object[] { Integer.valueOf(localc.i), Boolean.valueOf(bool), localc.e }));
        a(localc);
        return;
      }
      finally
      {
        paramc.printStackTrace();
        return;
      }
      bool = false;
      continue;
      label141:
      File localFile = new File(paramc.b.b);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    this.a.remove(localc.f.toLowerCase());
    a(bool, paramc.b);
  }
  
  private void b(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] cleanup: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      com.tencent.qmsp.sdk.f.d.a(g(paramb), false);
    }
  }
  
  private String c()
  {
    return e() + a(d.a);
  }
  
  private void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  private boolean c(d.b paramb)
  {
    return true;
  }
  
  private boolean d()
  {
    this.e = null;
    List localList = this.i.a();
    int k = 0;
    if (k < localList.size())
    {
      d.b localb = (d.b)localList.get(k);
      if (localb.a()) {}
      for (;;)
      {
        k += 1;
        break;
        if ((localb.m) && (localb.l) && (localb.n)) {
          break label144;
        }
        com.tencent.qmsp.sdk.f.g.d("Qp.QUM", 1, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", new Object[] { Long.valueOf(localb.a), Boolean.valueOf(localb.m), Boolean.valueOf(localb.l), Boolean.valueOf(localb.n) }));
        localb.b();
      }
      label144:
      this.e = localb;
      c(0);
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] next update: sid=%d", new Object[] { Long.valueOf(this.e.a) }));
    }
    for (boolean bool = true;; bool = false)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] get next section result? %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  private boolean d(d.b paramb)
  {
    boolean bool = false;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] download package: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      bool = a(new c(2, 0, g(paramb), paramb.c, paramb.e, paramb.d, 0, true, 0, System.currentTimeMillis(), paramb.u));
    }
    return bool;
  }
  
  private String e()
  {
    String str = com.tencent.qmsp.sdk.a.b.c();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
  
  private boolean e(d.b paramb)
  {
    boolean bool = false;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] get different: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      List localList = paramb.o;
      int k = 0;
      if (k < localList.size())
      {
        d.a locala = (d.a)localList.get(k);
        if (!new File(locala.f).exists())
        {
          locala.j = 2;
          paramb.q.add(locala);
        }
        String str;
        do
        {
          k += 1;
          break;
          str = a.a(locala.f);
        } while ((str != null) && (str.equalsIgnoreCase(locala.b)));
        locala.j = 1;
        if (str != null) {}
        for (;;)
        {
          locala.c = str;
          paramb.q.add(locala);
          paramb.r += 1L;
          break;
          str = "";
        }
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] need to update %d files of %d", new Object[] { Integer.valueOf(paramb.q.size()), Integer.valueOf(paramb.o.size()) }));
      bool = paramb.q.isEmpty() ^ true;
    }
    return bool;
  }
  
  private String f(d.b paramb)
  {
    paramb = g(paramb) + "bak" + File.separator;
    File localFile = new File(paramb);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramb;
  }
  
  private boolean f()
  {
    Object localObject = this.i.a();
    int k = 0;
    if (k < ((List)localObject).size()) {
      if (((d.b)((List)localObject).get(k)).a()) {}
    }
    for (boolean bool = false;; bool = true)
    {
      if (bool) {}
      for (localObject = "yes";; localObject = "no")
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] all complete: %s", new Object[] { localObject }));
        return bool;
        k += 1;
        break;
      }
    }
  }
  
  private String g(d.b paramb)
  {
    paramb = e() + paramb.a + File.separator;
    File localFile = new File(paramb);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramb;
  }
  
  private void g()
  {
    com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] all sections update complete");
    try
    {
      if (!TextUtils.isEmpty(this.f))
      {
        com.tencent.qmsp.sdk.c.f.i().e();
        this.h.edit().putString(a(d.e), this.f).putString(a(d.f), this.g).commit();
        a("0X80078B6", 0, this.j, this.f, this.g);
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] notify update complete: %s", new Object[] { this.f }));
      return;
    }
    finally
    {
      localObject.printStackTrace();
    }
  }
  
  private String h(d.b paramb)
  {
    return g(paramb) + paramb.c;
  }
  
  private void h()
  {
    synchronized (this.c)
    {
      int k = this.j;
      a("0X80078B5", 0, k, "", "");
      this.e = null;
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] update ended");
      return;
    }
  }
  
  private void i()
  {
    a(1, this.h.getInt(a(d.d), 0));
    this.h.edit().remove(a(d.e)).commit();
  }
  
  private void i(d.b paramb)
  {
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] update complete: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      paramb.b();
      if (j())
      {
        this.f += String.format("#%d#", new Object[] { Long.valueOf(paramb.b) });
        this.g += String.format("#%d#", new Object[] { Long.valueOf(paramb.a) });
      }
      a("0X80078B4", 0, this.j, "", "");
    }
  }
  
  private boolean j()
  {
    return this.d == 0;
  }
  
  private boolean j(d.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] rollback: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      if (paramb.p.isEmpty())
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] no files need to rollback");
        bool = true;
      }
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] rollback result: %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      String str = f(paramb);
      long l2 = 0L;
      int k = 0;
      while (k < paramb.p.size())
      {
        Object localObject = (d.a)paramb.p.get(k);
        File localFile1 = new File(((d.a)localObject).f);
        File localFile2 = new File(((d.a)localObject).g);
        long l1 = l2;
        if (localFile2.exists())
        {
          if (!localFile2.delete()) {
            localFile2.deleteOnExit();
          }
          l1 = l2 + 1L;
        }
        l2 = l1;
        if (((d.a)localObject).j == 2)
        {
          l2 = l1;
          if (localFile1.exists())
          {
            if (!localFile1.delete()) {
              localFile1.deleteOnExit();
            }
            l2 = l1 + 1L;
          }
        }
        localObject = new File(str, ((d.a)localObject).c);
        l1 = l2;
        if (((File)localObject).exists())
        {
          l1 = l2;
          if (((File)localObject).canRead())
          {
            l1 = l2;
            if (localFile1.exists())
            {
              l1 = l2;
              if (localFile1.canWrite())
              {
                a((File)localObject, localFile1);
                l1 = l2 + 1L;
              }
            }
          }
        }
        k += 1;
        l2 = l1;
      }
      if (l2 == paramb.p.size())
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private boolean k(d.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] unzip package: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      String str = g(paramb);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (m.a(h(paramb), str) == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] unzip result: %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private boolean l(d.b paramb)
  {
    boolean bool1;
    if ((paramb != null) && (!paramb.q.isEmpty()))
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] do update files: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      String str = g(paramb);
      int k = 0;
      if (k < paramb.q.size())
      {
        d.a locala = (d.a)paramb.q.get(k);
        File localFile1 = new File(str, locala.b);
        Object localObject = new File(locala.f);
        if ((!localFile1.exists()) || (!localFile1.canRead())) {
          com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] copied failed, src not existed or cannot read: %s", new Object[] { localFile1.toString() }));
        }
        for (;;)
        {
          k += 1;
          break;
          boolean bool2 = a(localFile1, (File)localObject);
          bool1 = bool2;
          if (!bool2)
          {
            localObject = locala.f + ".1";
            File localFile2 = new File((String)localObject);
            locala.j = 3;
            locala.g = ((String)localObject);
            bool2 = a(localFile1, localFile2);
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] copied failed, renamed to: %s", new Object[] { locala.g }));
            bool1 = bool2;
            if (bool2)
            {
              this.h.edit().putString(locala.f, locala.g).commit();
              bool1 = bool2;
            }
          }
          if (!bool1) {
            break label352;
          }
          com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] success copied: %s", new Object[] { locala.f }));
          paramb.p.add(locala);
          paramb.s += 1L;
        }
        label352:
        a("0X80078B2", (int)locala.h, this.j, locala.a, locala.b);
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] failed copied: %s", new Object[] { locala.f }));
      }
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] update %d files of %d", new Object[] { Long.valueOf(paramb.s), Integer.valueOf(paramb.q.size()) }));
      if (paramb.s == paramb.q.size()) {
        bool1 = true;
      }
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] update result: %b", new Object[] { Boolean.valueOf(bool1) }));
      return bool1;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  private boolean m(d.b paramb)
  {
    boolean bool;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      if (paramb.q.isEmpty())
      {
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] no diff: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
        bool = true;
      }
    }
    for (;;)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      int k = 0;
      for (;;)
      {
        if (k >= paramb.q.size()) {
          break label229;
        }
        d.a locala = (d.a)paramb.q.get(k);
        if (TextUtils.isEmpty(locala.g)) {}
        for (String str = locala.f;; str = locala.g)
        {
          str = a.a(str);
          if ((str != null) && (str.equalsIgnoreCase(locala.b))) {
            break label222;
          }
          com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] not matched: %s!=%s, sid=%d", new Object[] { str, locala.b, Long.valueOf(paramb.a) }));
          bool = false;
          break;
        }
        label222:
        k += 1;
      }
      label229:
      bool = true;
    }
  }
  
  private boolean n(d.b paramb)
  {
    String str;
    if (paramb != null)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify package: sid=%d", new Object[] { Long.valueOf(paramb.a) }));
      str = a.a(h(paramb));
      if (str == null) {
        return false;
      }
    }
    for (boolean bool = str.equalsIgnoreCase(paramb.d);; bool = false)
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public void a()
  {
    long l1 = 0L;
    if (!QmspSDK.getTaskStatus())
    {
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, "[SFU] Plugin Update Task Finish！");
      return;
    }
    if (!com.tencent.qmsp.sdk.c.f.i().a(1001).booleanValue())
    {
      a(QmspSDK.getAtomUpdateInterval().get());
      return;
    }
    long l3 = this.h.getLong(a(d.c), 0L);
    long l2 = System.currentTimeMillis() - l3;
    if (l2 < 0L) {}
    for (;;)
    {
      l2 = QmspSDK.getAtomUpdateInterval().get();
      com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 2, String.format("[SFU] startSFU last time: %d, interval: %d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) }));
      if (l1 >= QmspSDK.getAtomUpdateInterval().get())
      {
        b();
        l1 = l2;
      }
      for (;;)
      {
        a(l1);
        return;
        l1 = QmspSDK.getAtomUpdateInterval().get() - l1;
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 0, "[SFU] next time: " + l1);
      }
      l1 = l2;
    }
  }
  
  protected void a(int paramInt)
  {
    com.tencent.qmsp.sdk.f.g.b("Qp.QUM", 2, String.format("[SFU] update error: %d", new Object[] { Integer.valueOf(paramInt) }));
    switch (paramInt)
    {
    }
    for (;;)
    {
      b(1);
      return;
      c(paramInt);
      continue;
      File localFile = new File(c());
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = (JSONObject)paramObject;
        Object localObject = new StringBuilder();
        com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 0, "[SFU] rcv : " + paramObject);
        if (localJSONObject != null)
        {
          paramInt = localJSONObject.optInt("st");
          this.j = Integer.valueOf(localJSONObject.optString("tsi")).intValue();
          int k = this.j;
          a("0X80078B8", paramInt, k, "", "");
          if (paramInt == 0)
          {
            int n = localJSONObject.optInt("sc");
            k = localJSONObject.optInt("fi");
            int m = localJSONObject.optInt("fv");
            paramObject = (String)localJSONObject.opt("fh");
            localObject = (String)localJSONObject.opt("fu");
            int i1 = localJSONObject.optInt("zf");
            if (i1 != 1) {
              break label456;
            }
            bool = true;
            int i2 = a(m, paramObject);
            com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(m), paramObject, localObject, Integer.valueOf(i1) }));
            if (i2 == 0)
            {
              paramInt = this.j;
              a("0X80078AB", k, paramInt, "", "");
              com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, String.format("Need to update config file, fileid=%d", new Object[] { Integer.valueOf(k) }));
              bool = a(new c(1, k, e(), a(d.a), (String)localObject, paramObject, m, bool, 0, System.currentTimeMillis(), 1));
              if (bool) {
                break label455;
              }
              b(17);
              return;
            }
            if (i2 == 1)
            {
              paramObject = new File(c());
              if (this.i.a(paramObject.toString()))
              {
                if (this.i.a().isEmpty())
                {
                  paramInt = 16;
                  b(paramInt);
                  bool = true;
                  continue;
                }
                paramInt = 5;
                continue;
              }
            }
            else
            {
              paramObject = "[SFU] NO Need UPDATE";
              com.tencent.qmsp.sdk.f.g.a("Qp.QUM", 1, paramObject);
              bool = false;
              continue;
            }
          }
          else
          {
            paramObject = String.format("[SFU] Server replied with error, status=%d", new Object[] { Integer.valueOf(paramInt) });
            continue;
          }
        }
        bool = false;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        b(17);
        return;
      }
      continue;
      label455:
      return;
      label456:
      boolean bool = false;
    }
  }
  
  public void a(long paramLong)
  {
    com.tencent.qmsp.sdk.c.f.i().c().postDelayed(new c.a(this), paramLong);
  }
  
  public void a(com.tencent.qmsp.sdk.b.c paramc)
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.obtainMessage(1052688, paramc).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1052688) {}
    for (;;)
    {
      return false;
      b((com.tencent.qmsp.sdk.b.c)paramMessage.obj);
    }
  }
  
  static class c
  {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public boolean h;
    public int i;
    public long j;
    public int k;
    
    public c(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, boolean paramBoolean, int paramInt4, long paramLong, int paramInt5)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramString3;
      this.f = paramString4;
      this.g = paramInt3;
      this.h = paramBoolean;
      this.i = paramInt4;
      this.j = paramLong;
      this.k = paramInt5;
    }
    
    public String toString()
    {
      return "filePath=" + this.c + ",fileName=" + this.d + ",fileId=" + this.b + ",fileUrl=" + this.e + ",fileHash=" + this.f + ",fileVersion=" + this.g + ",zipFlag=" + this.h + ",startTime=" + this.j + ",tryTimes=" + this.i + ",downloadFlag=" + this.k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */