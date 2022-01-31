package tmsdkdual;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tmsdk.dual.TMSDualSDKContext;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k
{
  private static k aa;
  private CertificateFactory ab = null;
  private Context mContext = null;
  private PackageManager mPackageManager = null;
  
  public k(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPackageManager = paramContext.getPackageManager();
    try
    {
      this.ab = CertificateFactory.getInstance("X.509");
      return;
    }
    catch (CertificateException paramContext) {}
  }
  
  /* Error */
  private void a(PackageInfo paramPackageInfo, j paramj, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_m1
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 7
    //   9: aload_1
    //   10: ifnull +7 -> 17
    //   13: aload_2
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: iload_3
    //   19: iconst_1
    //   20: iand
    //   21: ifeq +91 -> 112
    //   24: aload_2
    //   25: ldc 52
    //   27: aload_1
    //   28: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   31: getfield 64	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   34: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   37: aload_2
    //   38: ldc 72
    //   40: aload_0
    //   41: getfield 21	tmsdkdual/k:mPackageManager	Landroid/content/pm/PackageManager;
    //   44: aload_1
    //   45: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   48: invokevirtual 78	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   51: invokeinterface 84 1 0
    //   56: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   59: aload_1
    //   60: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   63: getfield 88	android/content/pm/ApplicationInfo:flags	I
    //   66: iconst_1
    //   67: iand
    //   68: ifeq +422 -> 490
    //   71: iconst_1
    //   72: istore 6
    //   74: aload_2
    //   75: ldc 90
    //   77: iload 6
    //   79: invokestatic 96	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   82: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   85: aload_1
    //   86: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   89: ifnull +407 -> 496
    //   92: aload_1
    //   93: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   96: getfield 99	android/content/pm/ApplicationInfo:uid	I
    //   99: istore 4
    //   101: aload_2
    //   102: ldc 100
    //   104: iload 4
    //   106: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   112: iload_3
    //   113: iconst_2
    //   114: iand
    //   115: ifeq +77 -> 192
    //   118: aload_2
    //   119: ldc 52
    //   121: aload_1
    //   122: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   125: getfield 64	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   128: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   131: iload 7
    //   133: istore 6
    //   135: aload_1
    //   136: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   139: getfield 88	android/content/pm/ApplicationInfo:flags	I
    //   142: iconst_1
    //   143: iand
    //   144: ifeq +6 -> 150
    //   147: iconst_1
    //   148: istore 6
    //   150: aload_2
    //   151: ldc 90
    //   153: iload 6
    //   155: invokestatic 96	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   158: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   161: iload 5
    //   163: istore 4
    //   165: aload_1
    //   166: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   169: ifnull +12 -> 181
    //   172: aload_1
    //   173: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   176: getfield 99	android/content/pm/ApplicationInfo:uid	I
    //   179: istore 4
    //   181: aload_2
    //   182: ldc 100
    //   184: iload 4
    //   186: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   192: iload_3
    //   193: iconst_4
    //   194: iand
    //   195: ifeq +20 -> 215
    //   198: aload_2
    //   199: ldc 107
    //   201: aload_1
    //   202: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   205: aload_0
    //   206: getfield 21	tmsdkdual/k:mPackageManager	Landroid/content/pm/PackageManager;
    //   209: invokevirtual 111	android/content/pm/ApplicationInfo:loadIcon	(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
    //   212: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   215: iload_3
    //   216: bipush 8
    //   218: iand
    //   219: ifeq +87 -> 306
    //   222: aload_2
    //   223: ldc 113
    //   225: aload_1
    //   226: getfield 116	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   229: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   232: aload_2
    //   233: ldc 118
    //   235: aload_1
    //   236: getfield 120	android/content/pm/PackageInfo:versionCode	I
    //   239: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   245: aload_1
    //   246: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   249: ifnull +57 -> 306
    //   252: aload_1
    //   253: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   256: getfield 123	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   259: ifnull +47 -> 306
    //   262: new 125	java/io/File
    //   265: dup
    //   266: aload_1
    //   267: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   270: getfield 123	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   273: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore 8
    //   278: aload_2
    //   279: ldc 130
    //   281: aload 8
    //   283: invokevirtual 134	java/io/File:length	()J
    //   286: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   289: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   292: aload_2
    //   293: ldc 141
    //   295: aload 8
    //   297: invokevirtual 143	java/io/File:lastModified	()J
    //   300: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   303: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   306: iload_3
    //   307: bipush 16
    //   309: iand
    //   310: ifeq +123 -> 433
    //   313: aload_1
    //   314: ifnull +119 -> 433
    //   317: aload_1
    //   318: getfield 147	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   321: ifnull +112 -> 433
    //   324: aload_1
    //   325: getfield 147	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   328: arraylength
    //   329: iconst_1
    //   330: if_icmpge +103 -> 433
    //   333: aload_1
    //   334: getfield 147	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   337: iconst_0
    //   338: aaload
    //   339: ifnull +94 -> 433
    //   342: aload_1
    //   343: getfield 147	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   346: iconst_0
    //   347: aaload
    //   348: ldc 149
    //   350: invokevirtual 155	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   353: istore 6
    //   355: iload 6
    //   357: ifne +76 -> 433
    //   360: new 157	java/io/ByteArrayInputStream
    //   363: dup
    //   364: aload_1
    //   365: getfield 147	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   368: iconst_0
    //   369: aaload
    //   370: invokevirtual 161	android/content/pm/Signature:toByteArray	()[B
    //   373: invokespecial 164	java/io/ByteArrayInputStream:<init>	([B)V
    //   376: astore 11
    //   378: aload_0
    //   379: getfield 25	tmsdkdual/k:ab	Ljava/security/cert/CertificateFactory;
    //   382: aload 11
    //   384: invokevirtual 168	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   387: checkcast 170	java/security/cert/X509Certificate
    //   390: astore 10
    //   392: aload 10
    //   394: astore 8
    //   396: aload 11
    //   398: ifnull +12 -> 410
    //   401: aload 11
    //   403: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   406: aload 10
    //   408: astore 8
    //   410: aload 8
    //   412: ifnull +21 -> 433
    //   415: aload 8
    //   417: invokevirtual 176	java/security/cert/X509Certificate:getEncoded	()[B
    //   420: invokestatic 182	tmsdkdual/l:b	([B)Ljava/lang/String;
    //   423: astore 8
    //   425: aload_2
    //   426: ldc 184
    //   428: aload 8
    //   430: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   433: iload_3
    //   434: bipush 32
    //   436: iand
    //   437: ifeq +13 -> 450
    //   440: aload_2
    //   441: ldc 186
    //   443: aload_1
    //   444: getfield 190	android/content/pm/PackageInfo:requestedPermissions	[Ljava/lang/String;
    //   447: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   450: iload_3
    //   451: bipush 64
    //   453: iand
    //   454: ifeq -437 -> 17
    //   457: aload_1
    //   458: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   461: ifnull -444 -> 17
    //   464: aload_2
    //   465: ldc 192
    //   467: aload_1
    //   468: getfield 58	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   471: getfield 123	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   474: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   477: aload_2
    //   478: ldc 194
    //   480: iconst_0
    //   481: invokestatic 96	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   484: invokevirtual 70	tmsdkdual/j:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   487: return
    //   488: astore_1
    //   489: return
    //   490: iconst_0
    //   491: istore 6
    //   493: goto -419 -> 74
    //   496: iconst_m1
    //   497: istore 4
    //   499: goto -398 -> 101
    //   502: astore 8
    //   504: aload 8
    //   506: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   509: aload 10
    //   511: astore 8
    //   513: goto -103 -> 410
    //   516: astore 8
    //   518: aload 10
    //   520: astore 8
    //   522: goto -112 -> 410
    //   525: astore 8
    //   527: aload 8
    //   529: invokevirtual 198	java/security/cert/CertificateException:printStackTrace	()V
    //   532: aload 11
    //   534: ifnull +107 -> 641
    //   537: aload 11
    //   539: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   542: aconst_null
    //   543: astore 8
    //   545: goto -135 -> 410
    //   548: astore 8
    //   550: aload 8
    //   552: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   555: aconst_null
    //   556: astore 8
    //   558: goto -148 -> 410
    //   561: astore 8
    //   563: aload 8
    //   565: invokevirtual 199	java/lang/Exception:printStackTrace	()V
    //   568: aload 11
    //   570: ifnull +71 -> 641
    //   573: aload 11
    //   575: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   578: aconst_null
    //   579: astore 8
    //   581: goto -171 -> 410
    //   584: astore 8
    //   586: aload 8
    //   588: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   591: aconst_null
    //   592: astore 8
    //   594: goto -184 -> 410
    //   597: astore 8
    //   599: aload 11
    //   601: ifnull +8 -> 609
    //   604: aload 11
    //   606: invokevirtual 173	java/io/ByteArrayInputStream:close	()V
    //   609: aload 8
    //   611: athrow
    //   612: astore 10
    //   614: aload 10
    //   616: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   619: goto -10 -> 609
    //   622: astore 8
    //   624: aload 8
    //   626: invokevirtual 200	java/security/cert/CertificateEncodingException:printStackTrace	()V
    //   629: aload 9
    //   631: astore 8
    //   633: goto -208 -> 425
    //   636: astore 8
    //   638: goto -205 -> 433
    //   641: aconst_null
    //   642: astore 8
    //   644: goto -234 -> 410
    //   647: astore 8
    //   649: aconst_null
    //   650: astore 8
    //   652: goto -242 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	k
    //   0	655	1	paramPackageInfo	PackageInfo
    //   0	655	2	paramj	j
    //   0	655	3	paramInt	int
    //   99	399	4	i	int
    //   4	158	5	j	int
    //   72	420	6	bool1	boolean
    //   7	125	7	bool2	boolean
    //   276	153	8	localObject1	Object
    //   502	3	8	localIOException1	java.io.IOException
    //   511	1	8	localObject2	Object
    //   516	1	8	localThrowable1	Throwable
    //   520	1	8	localObject3	Object
    //   525	3	8	localCertificateException	CertificateException
    //   543	1	8	localObject4	Object
    //   548	3	8	localIOException2	java.io.IOException
    //   556	1	8	localObject5	Object
    //   561	3	8	localException	java.lang.Exception
    //   579	1	8	localObject6	Object
    //   584	3	8	localIOException3	java.io.IOException
    //   592	1	8	localObject7	Object
    //   597	13	8	localObject8	Object
    //   622	3	8	localCertificateEncodingException	java.security.cert.CertificateEncodingException
    //   631	1	8	localObject9	Object
    //   636	1	8	localThrowable2	Throwable
    //   642	1	8	localObject10	Object
    //   647	1	8	localThrowable3	Throwable
    //   650	1	8	localObject11	Object
    //   1	629	9	localObject12	Object
    //   390	129	10	localX509Certificate	java.security.cert.X509Certificate
    //   612	3	10	localIOException4	java.io.IOException
    //   376	229	11	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   24	71	488	java/lang/Throwable
    //   74	101	488	java/lang/Throwable
    //   101	112	488	java/lang/Throwable
    //   118	131	488	java/lang/Throwable
    //   135	147	488	java/lang/Throwable
    //   150	161	488	java/lang/Throwable
    //   165	181	488	java/lang/Throwable
    //   181	192	488	java/lang/Throwable
    //   198	215	488	java/lang/Throwable
    //   222	306	488	java/lang/Throwable
    //   440	450	488	java/lang/Throwable
    //   457	487	488	java/lang/Throwable
    //   401	406	502	java/io/IOException
    //   401	406	516	java/lang/Throwable
    //   504	509	516	java/lang/Throwable
    //   378	392	525	java/security/cert/CertificateException
    //   537	542	548	java/io/IOException
    //   378	392	561	java/lang/Exception
    //   573	578	584	java/io/IOException
    //   378	392	597	finally
    //   527	532	597	finally
    //   563	568	597	finally
    //   604	609	612	java/io/IOException
    //   415	425	622	java/security/cert/CertificateEncodingException
    //   317	355	636	java/lang/Throwable
    //   415	425	636	java/lang/Throwable
    //   425	433	636	java/lang/Throwable
    //   624	629	636	java/lang/Throwable
    //   360	378	647	java/lang/Throwable
    //   537	542	647	java/lang/Throwable
    //   550	555	647	java/lang/Throwable
    //   573	578	647	java/lang/Throwable
    //   586	591	647	java/lang/Throwable
    //   604	609	647	java/lang/Throwable
    //   609	612	647	java/lang/Throwable
    //   614	619	647	java/lang/Throwable
  }
  
  public static k q()
  {
    if (aa == null) {}
    try
    {
      if (aa == null) {
        aa = new k(TMSDualSDKContext.getApplicaionContext());
      }
      return aa;
    }
    finally {}
  }
  
  public ArrayList<j> a(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    int i;
    if ((paramInt1 & 0x10) != 0)
    {
      i = 64;
      int j = i;
      if ((paramInt1 & 0x20) != 0) {
        j = i | 0x1000;
      }
      try
      {
        localObject2 = this.mPackageManager.getInstalledPackages(j);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          localThrowable2.printStackTrace();
          continue;
          i = 0;
        }
      }
      localObject2 = new ArrayList();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      PackageInfo localPackageInfo;
      try
      {
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label158;
        }
        localPackageInfo = (PackageInfo)((Iterator)localObject1).next();
        if ((localPackageInfo.applicationInfo.flags & 0x1) == 0) {
          break label171;
        }
        i = 1;
        localObject3 = localPackageInfo.applicationInfo.packageName;
        if (i != 0) {
          break label181;
        }
        if (paramInt2 == 1) {
          continue;
        }
      }
      catch (Throwable localThrowable1) {}
      Object localObject3 = new j();
      a(localPackageInfo, (j)localObject3, paramInt1);
      ((ArrayList)localObject2).add(localObject3);
      continue;
      label158:
      return localObject2;
      label171:
      i = 0;
      break;
      label181:
      if (i != 0) {
        if (paramInt2 == 0) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.k
 * JD-Core Version:    0.7.0.1
 */