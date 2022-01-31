package com.tencent.securemodule;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.securemodule.f;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class s
{
  private Context a;
  private Map<Long, r> b;
  
  public s() {}
  
  public s(Context paramContext)
  {
    this.a = paramContext;
    this.b = new HashMap();
  }
  
  public static r a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageInfo(paramString, 64);
      paramContext = new r();
      label78:
      label87:
      label96:
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      try
      {
        paramContext.a(paramString);
        paramContext.d(localPackageInfo.versionName);
        paramContext.a(localPackageInfo.versionCode);
        paramString = (X509Certificate)a(localPackageInfo.signatures[0]);
        if (paramString == null) {
          return paramContext;
        }
        paramContext.c(ac.a.a(ac.a.b(paramString.getEncoded())));
        return paramContext;
      }
      catch (Exception paramString)
      {
        break label96;
      }
      catch (CertificateEncodingException paramString)
      {
        break label87;
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        break label78;
      }
      paramString = paramString;
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (CertificateEncodingException paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
    catch (Exception paramString)
    {
      paramContext = null;
      paramString.printStackTrace();
      return paramContext;
    }
  }
  
  /* Error */
  private static java.security.cert.Certificate a(android.content.pm.Signature paramSignature)
  {
    // Byte code:
    //   0: new 98	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 103	android/content/pm/Signature:toByteArray	()[B
    //   8: invokespecial 106	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_0
    //   12: ldc 108
    //   14: invokestatic 114	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   17: aload_0
    //   18: invokevirtual 118	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   21: checkcast 72	java/security/cert/X509Certificate
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 121	java/io/ByteArrayInputStream:close	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 122	java/security/cert/CertificateException:printStackTrace	()V
    //   36: aload_0
    //   37: invokevirtual 121	java/io/ByteArrayInputStream:close	()V
    //   40: aconst_null
    //   41: areturn
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   54: aload_0
    //   55: invokevirtual 121	java/io/ByteArrayInputStream:close	()V
    //   58: aconst_null
    //   59: areturn
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: aload_0
    //   69: invokevirtual 121	java/io/ByteArrayInputStream:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   79: goto -7 -> 72
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   87: aload_1
    //   88: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramSignature	android.content.pm.Signature
    //   24	6	1	localX509Certificate	X509Certificate
    //   31	2	1	localCertificateException	java.security.cert.CertificateException
    //   49	2	1	localException	Exception
    //   67	21	1	localCertificate	java.security.cert.Certificate
    // Exception table:
    //   from	to	target	type
    //   12	25	31	java/security/cert/CertificateException
    //   36	40	42	java/io/IOException
    //   12	25	49	java/lang/Exception
    //   54	58	60	java/io/IOException
    //   12	25	67	finally
    //   32	36	67	finally
    //   50	54	67	finally
    //   68	72	74	java/io/IOException
    //   25	29	82	java/io/IOException
  }
  
  private ArrayList<r> a(ArrayList<f> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return localArrayList;
      }
      Object localObject = (f)paramArrayList.next();
      if (((f)localObject).b() == 3)
      {
        localObject = (r)this.b.get(Long.valueOf(((f)localObject).a()));
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
  }
  
  private static HashMap<Long, r> a(List<r> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        return localHashMap;
      }
      r localr = (r)paramList.get(i);
      localHashMap.put(Long.valueOf(ac.a.a(localr)), localr);
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 8192);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        int i = paramContext.flags;
        bool1 = bool2;
        if ((i & 0x1) != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private ArrayList<g> b(ArrayList<f> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    r localr;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          return localArrayList;
        }
        paramArrayList = (f)localIterator.next();
      } while (paramArrayList.b() != 6);
      localr = (r)this.b.get(Long.valueOf(paramArrayList.a()));
    } while (localr == null);
    Object localObject1 = localr.a();
    paramArrayList = (ArrayList<f>)localObject1;
    if (localObject1 == null) {
      paramArrayList = "";
    }
    Object localObject2 = localr.c();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i = (int)localr.g();
    Object localObject3 = localr.d();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    int j = localr.e();
    String str = localr.b();
    localObject3 = str;
    if (str == null) {
      localObject3 = "";
    }
    if (localr.f() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localArrayList.add(new g(paramArrayList, (String)localObject1, i, (String)localObject2, j, (String)localObject3, bool));
      break;
    }
  }
  
  /* Error */
  public final void a(u paramu)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +7 -> 10
    //   6: aload_1
    //   7: invokevirtual 230	com/tencent/securemodule/u:a	()V
    //   10: invokestatic 235	java/lang/System:currentTimeMillis	()J
    //   13: lstore 4
    //   15: aload_0
    //   16: getfield 17	com/tencent/securemodule/s:a	Landroid/content/Context;
    //   19: astore 11
    //   21: new 126	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 127	java/util/ArrayList:<init>	()V
    //   28: astore 12
    //   30: aload 11
    //   32: invokevirtual 35	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   35: astore 13
    //   37: aload 13
    //   39: iconst_0
    //   40: invokevirtual 239	android/content/pm/PackageManager:getInstalledApplications	(I)Ljava/util/List;
    //   43: invokeinterface 240 1 0
    //   48: astore 14
    //   50: aload 14
    //   52: invokeinterface 137 1 0
    //   57: ifne +266 -> 323
    //   60: aload_0
    //   61: aload 12
    //   63: invokestatic 242	com/tencent/securemodule/s:a	(Ljava/util/List;)Ljava/util/HashMap;
    //   66: putfield 22	com/tencent/securemodule/s:b	Ljava/util/Map;
    //   69: new 126	java/util/ArrayList
    //   72: dup
    //   73: invokespecial 127	java/util/ArrayList:<init>	()V
    //   76: astore 10
    //   78: aload_0
    //   79: getfield 22	com/tencent/securemodule/s:b	Ljava/util/Map;
    //   82: invokeinterface 246 1 0
    //   87: invokeinterface 249 1 0
    //   92: astore 9
    //   94: aload 9
    //   96: invokeinterface 137 1 0
    //   101: ifne +367 -> 468
    //   104: new 126	java/util/ArrayList
    //   107: dup
    //   108: invokespecial 127	java/util/ArrayList:<init>	()V
    //   111: astore 11
    //   113: new 126	java/util/ArrayList
    //   116: dup
    //   117: invokespecial 127	java/util/ArrayList:<init>	()V
    //   120: astore 9
    //   122: aload_0
    //   123: getfield 17	com/tencent/securemodule/s:a	Landroid/content/Context;
    //   126: astore 12
    //   128: getstatic 254	com/tencent/securemodule/ac:a	Lcom/tencent/securemodule/ac;
    //   131: ifnonnull +15 -> 146
    //   134: new 251	com/tencent/securemodule/ac
    //   137: dup
    //   138: aload 12
    //   140: invokespecial 256	com/tencent/securemodule/ac:<init>	(Landroid/content/Context;)V
    //   143: putstatic 254	com/tencent/securemodule/ac:a	Lcom/tencent/securemodule/ac;
    //   146: getstatic 254	com/tencent/securemodule/ac:a	Lcom/tencent/securemodule/ac;
    //   149: astore 13
    //   151: new 258	com/qq/jce/wup/UniPacket
    //   154: dup
    //   155: iconst_1
    //   156: invokespecial 261	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   159: astore 14
    //   161: new 258	com/qq/jce/wup/UniPacket
    //   164: dup
    //   165: iconst_1
    //   166: invokespecial 261	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   169: astore 12
    //   171: aload 13
    //   173: iconst_3
    //   174: aload 14
    //   176: aload 12
    //   178: invokevirtual 264	com/tencent/securemodule/ac:a	(ILcom/qq/jce/wup/UniPacket;Lcom/qq/jce/wup/UniPacket;)I
    //   181: istore_2
    //   182: iload_2
    //   183: ifeq +357 -> 540
    //   186: iload_2
    //   187: ifne +585 -> 772
    //   190: aload_0
    //   191: aload 11
    //   193: invokespecial 266	com/tencent/securemodule/s:a	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   196: astore 9
    //   198: aload_0
    //   199: aload 11
    //   201: invokespecial 268	com/tencent/securemodule/s:b	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   204: astore 11
    //   206: new 126	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 127	java/util/ArrayList:<init>	()V
    //   213: astore 10
    //   215: aload_0
    //   216: getfield 17	com/tencent/securemodule/s:a	Landroid/content/Context;
    //   219: astore 12
    //   221: getstatic 254	com/tencent/securemodule/ac:a	Lcom/tencent/securemodule/ac;
    //   224: ifnonnull +15 -> 239
    //   227: new 251	com/tencent/securemodule/ac
    //   230: dup
    //   231: aload 12
    //   233: invokespecial 256	com/tencent/securemodule/ac:<init>	(Landroid/content/Context;)V
    //   236: putstatic 254	com/tencent/securemodule/ac:a	Lcom/tencent/securemodule/ac;
    //   239: getstatic 254	com/tencent/securemodule/ac:a	Lcom/tencent/securemodule/ac;
    //   242: astore 13
    //   244: new 258	com/qq/jce/wup/UniPacket
    //   247: dup
    //   248: iconst_1
    //   249: invokespecial 261	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   252: astore 14
    //   254: new 258	com/qq/jce/wup/UniPacket
    //   257: dup
    //   258: iconst_1
    //   259: invokespecial 261	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   262: astore 12
    //   264: aload 13
    //   266: iconst_4
    //   267: aload 14
    //   269: aload 12
    //   271: invokevirtual 264	com/tencent/securemodule/ac:a	(ILcom/qq/jce/wup/UniPacket;Lcom/qq/jce/wup/UniPacket;)I
    //   274: istore_2
    //   275: iload_2
    //   276: ifeq +380 -> 656
    //   279: goto +524 -> 803
    //   282: invokestatic 235	java/lang/System:currentTimeMillis	()J
    //   285: lstore 6
    //   287: ldc2_w 269
    //   290: lload 6
    //   292: lload 4
    //   294: lsub
    //   295: lsub
    //   296: lstore 4
    //   298: lload 4
    //   300: lconst_0
    //   301: lcmp
    //   302: ifle +8 -> 310
    //   305: lload 4
    //   307: invokestatic 276	java/lang/Thread:sleep	(J)V
    //   310: aload_1
    //   311: ifnull +9 -> 320
    //   314: aload_1
    //   315: aload 9
    //   317: invokevirtual 279	com/tencent/securemodule/u:a	(Ljava/util/ArrayList;)V
    //   320: aload_0
    //   321: monitorexit
    //   322: return
    //   323: aload 14
    //   325: invokeinterface 141 1 0
    //   330: checkcast 195	android/content/pm/ApplicationInfo
    //   333: astore 16
    //   335: aload 16
    //   337: getfield 198	android/content/pm/ApplicationInfo:flags	I
    //   340: iconst_1
    //   341: iand
    //   342: ifeq +116 -> 458
    //   345: iconst_1
    //   346: istore_2
    //   347: aload 11
    //   349: aload 16
    //   351: getfield 282	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   354: invokestatic 284	com/tencent/securemodule/s:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/securemodule/r;
    //   357: astore 15
    //   359: aload 15
    //   361: ifnull -311 -> 50
    //   364: aload 13
    //   366: aload 16
    //   368: invokevirtual 288	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   371: invokeinterface 293 1 0
    //   376: astore 10
    //   378: aload 10
    //   380: astore 9
    //   382: aload 10
    //   384: ifnonnull +7 -> 391
    //   387: ldc 202
    //   389: astore 9
    //   391: aload 15
    //   393: aload 9
    //   395: invokevirtual 295	com/tencent/securemodule/r:b	(Ljava/lang/String;)V
    //   398: iload_2
    //   399: ifeq +64 -> 463
    //   402: iconst_1
    //   403: istore_2
    //   404: aload 15
    //   406: iload_2
    //   407: invokevirtual 297	com/tencent/securemodule/r:b	(I)V
    //   410: aload 15
    //   412: new 299	java/io/File
    //   415: dup
    //   416: aload 16
    //   418: getfield 302	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   421: invokespecial 304	java/io/File:<init>	(Ljava/lang/String;)V
    //   424: invokevirtual 307	java/io/File:length	()J
    //   427: invokevirtual 309	com/tencent/securemodule/r:a	(J)V
    //   430: aload 16
    //   432: getfield 302	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   435: astore 9
    //   437: invokestatic 312	com/tencent/securemodule/r:h	()V
    //   440: aload 12
    //   442: aload 15
    //   444: invokeinterface 313 2 0
    //   449: pop
    //   450: goto -400 -> 50
    //   453: astore_1
    //   454: aload_0
    //   455: monitorexit
    //   456: aload_1
    //   457: athrow
    //   458: iconst_0
    //   459: istore_2
    //   460: goto -113 -> 347
    //   463: iconst_0
    //   464: istore_2
    //   465: goto -61 -> 404
    //   468: aload 9
    //   470: invokeinterface 141 1 0
    //   475: checkcast 315	java/util/Map$Entry
    //   478: astore 11
    //   480: aload 11
    //   482: invokeinterface 318 1 0
    //   487: checkcast 43	com/tencent/securemodule/r
    //   490: astore 12
    //   492: aload 12
    //   494: ifnull +303 -> 797
    //   497: aload 12
    //   499: invokevirtual 217	com/tencent/securemodule/r:f	()I
    //   502: iconst_1
    //   503: if_icmpne +294 -> 797
    //   506: iconst_1
    //   507: istore 8
    //   509: aload 10
    //   511: new 320	com/tencent/securemodule/d
    //   514: dup
    //   515: aload 11
    //   517: invokeinterface 323 1 0
    //   522: checkcast 151	java/lang/Long
    //   525: invokevirtual 326	java/lang/Long:longValue	()J
    //   528: iload 8
    //   530: invokespecial 329	com/tencent/securemodule/d:<init>	(JZ)V
    //   533: invokevirtual 165	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   536: pop
    //   537: goto -443 -> 94
    //   540: aload 14
    //   542: ldc_w 331
    //   545: aload 13
    //   547: getfield 334	com/tencent/securemodule/ac:b	Lcom/tencent/securemodule/ab;
    //   550: invokevirtual 339	com/tencent/securemodule/ab:a	()Lcom/tencent/securemodule/k;
    //   553: invokevirtual 342	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   556: aload 14
    //   558: ldc_w 344
    //   561: aload 13
    //   563: getfield 334	com/tencent/securemodule/ac:b	Lcom/tencent/securemodule/ab;
    //   566: invokevirtual 347	com/tencent/securemodule/ab:b	()Lcom/tencent/securemodule/q;
    //   569: invokevirtual 342	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   572: aload 14
    //   574: ldc_w 349
    //   577: aload 10
    //   579: invokevirtual 342	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   582: aload 13
    //   584: aload 14
    //   586: aload 12
    //   588: invokevirtual 352	com/tencent/securemodule/ac:a	(Lcom/qq/jce/wup/UniPacket;Lcom/qq/jce/wup/UniPacket;)I
    //   591: istore_3
    //   592: iload_3
    //   593: istore_2
    //   594: iload_3
    //   595: ifne -409 -> 186
    //   598: new 126	java/util/ArrayList
    //   601: dup
    //   602: invokespecial 127	java/util/ArrayList:<init>	()V
    //   605: astore 10
    //   607: aload 10
    //   609: new 143	com/tencent/securemodule/f
    //   612: dup
    //   613: invokespecial 353	com/tencent/securemodule/f:<init>	()V
    //   616: invokevirtual 165	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   619: pop
    //   620: aload 12
    //   622: ldc_w 355
    //   625: aload 10
    //   627: invokevirtual 359	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   630: checkcast 126	java/util/ArrayList
    //   633: astore 10
    //   635: aload 10
    //   637: ifnull +173 -> 810
    //   640: aload 11
    //   642: invokevirtual 362	java/util/ArrayList:clear	()V
    //   645: aload 11
    //   647: aload 10
    //   649: invokevirtual 366	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   652: pop
    //   653: goto +157 -> 810
    //   656: aload 14
    //   658: ldc_w 331
    //   661: aload 13
    //   663: getfield 334	com/tencent/securemodule/ac:b	Lcom/tencent/securemodule/ab;
    //   666: invokevirtual 339	com/tencent/securemodule/ab:a	()Lcom/tencent/securemodule/k;
    //   669: invokevirtual 342	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   672: aload 14
    //   674: ldc_w 344
    //   677: aload 13
    //   679: getfield 334	com/tencent/securemodule/ac:b	Lcom/tencent/securemodule/ab;
    //   682: invokevirtual 347	com/tencent/securemodule/ab:b	()Lcom/tencent/securemodule/q;
    //   685: invokevirtual 342	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   688: aload 14
    //   690: ldc_w 368
    //   693: aload 11
    //   695: invokevirtual 342	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   698: aload 13
    //   700: aload 14
    //   702: aload 12
    //   704: invokevirtual 352	com/tencent/securemodule/ac:a	(Lcom/qq/jce/wup/UniPacket;Lcom/qq/jce/wup/UniPacket;)I
    //   707: istore_3
    //   708: iload_3
    //   709: istore_2
    //   710: iload_3
    //   711: ifne +92 -> 803
    //   714: new 126	java/util/ArrayList
    //   717: dup
    //   718: invokespecial 127	java/util/ArrayList:<init>	()V
    //   721: astore 11
    //   723: aload 11
    //   725: new 143	com/tencent/securemodule/f
    //   728: dup
    //   729: invokespecial 353	com/tencent/securemodule/f:<init>	()V
    //   732: invokevirtual 165	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   735: pop
    //   736: aload 12
    //   738: ldc_w 355
    //   741: aload 11
    //   743: invokevirtual 359	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   746: checkcast 126	java/util/ArrayList
    //   749: astore 11
    //   751: aload 11
    //   753: ifnull +62 -> 815
    //   756: aload 10
    //   758: invokevirtual 362	java/util/ArrayList:clear	()V
    //   761: aload 10
    //   763: aload 11
    //   765: invokevirtual 366	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   768: pop
    //   769: goto +46 -> 815
    //   772: aload_1
    //   773: ifnull +47 -> 820
    //   776: aload_1
    //   777: iload_2
    //   778: invokevirtual 369	com/tencent/securemodule/u:a	(I)V
    //   781: goto +39 -> 820
    //   784: astore 10
    //   786: aload 10
    //   788: invokevirtual 370	java/lang/InterruptedException:printStackTrace	()V
    //   791: goto -481 -> 310
    //   794: goto -512 -> 282
    //   797: iconst_0
    //   798: istore 8
    //   800: goto -291 -> 509
    //   803: iload_2
    //   804: ifne -10 -> 794
    //   807: goto -525 -> 282
    //   810: iconst_0
    //   811: istore_2
    //   812: goto -626 -> 186
    //   815: iconst_0
    //   816: istore_2
    //   817: goto -14 -> 803
    //   820: goto -538 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	s
    //   0	823	1	paramu	u
    //   181	636	2	i	int
    //   591	120	3	j	int
    //   13	293	4	l1	long
    //   285	6	6	l2	long
    //   507	292	8	bool	boolean
    //   92	377	9	localObject1	Object
    //   76	686	10	localObject2	Object
    //   784	3	10	localInterruptedException	java.lang.InterruptedException
    //   19	745	11	localObject3	Object
    //   28	709	12	localObject4	Object
    //   35	664	13	localObject5	Object
    //   48	653	14	localObject6	Object
    //   357	86	15	localr	r
    //   333	98	16	localApplicationInfo	ApplicationInfo
    // Exception table:
    //   from	to	target	type
    //   6	10	453	finally
    //   10	50	453	finally
    //   50	94	453	finally
    //   94	146	453	finally
    //   146	182	453	finally
    //   190	239	453	finally
    //   239	275	453	finally
    //   282	287	453	finally
    //   305	310	453	finally
    //   314	320	453	finally
    //   323	345	453	finally
    //   347	359	453	finally
    //   364	378	453	finally
    //   391	398	453	finally
    //   404	450	453	finally
    //   468	492	453	finally
    //   497	506	453	finally
    //   509	537	453	finally
    //   540	592	453	finally
    //   598	635	453	finally
    //   640	653	453	finally
    //   656	708	453	finally
    //   714	751	453	finally
    //   756	769	453	finally
    //   776	781	453	finally
    //   786	791	453	finally
    //   305	310	784	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.s
 * JD-Core Version:    0.7.0.1
 */