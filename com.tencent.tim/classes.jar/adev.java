import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class adev
  implements aolm.b
{
  protected static aolm.a b = new adew();
  private long Sw;
  public adex a;
  private aolm c;
  Set<String> cb = Collections.synchronizedSet(new HashSet());
  private final byte[] dd = new byte[0];
  private long downloadSize;
  private boolean hasReport;
  private boolean isDownloading;
  public AppInterface mApp;
  ArrayList<adev.a> uh = new ArrayList();
  
  public adev(AppInterface paramAppInterface, adex paramadex)
  {
    this.mApp = paramAppInterface;
    this.a = paramadex;
  }
  
  private void a(adev.a parama)
  {
    if ((TextUtils.isEmpty(parama.url)) || (TextUtils.isEmpty(parama.md5))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArResourceDownload", 2, "downLoad:url=" + parama.url + ",md5= " + parama.md5);
    }
    parama.downloadTimes += 1;
    if (this.c == null) {
      this.c = this.mApp.getNetEngine(0);
    }
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = parama.url;
    localaoll.mHttpMethod = 0;
    localaoll.atY = parama.fileName;
    localaoll.dPo = 1;
    localaoll.bw(parama);
    localaoll.a = b;
    this.c.a(localaoll);
    parama.f = localaoll;
  }
  
  private boolean a(ArConfigInfo paramArConfigInfo)
  {
    if (paramArConfigInfo == null) {
      return true;
    }
    try
    {
      if (!paramArConfigInfo.mArCloudConfigInfos.isEmpty())
      {
        paramArConfigInfo = paramArConfigInfo.mArCloudConfigInfos.iterator();
        while (paramArConfigInfo.hasNext())
        {
          ArCloudConfigInfo localArCloudConfigInfo = (ArCloudConfigInfo)paramArConfigInfo.next();
          if (!aqhq.fileExists(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.bue)) {
            return false;
          }
          if (((localArCloudConfigInfo.type == 0) || (localArCloudConfigInfo.type == 100)) && (localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null))
          {
            boolean bool = new File(localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.zipFileName).exists();
            if (!bool) {
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramArConfigInfo)
    {
      QLog.i("ArConfig_ArResourceDownload", 1, "isResourceReady e=" + paramArConfigInfo.getMessage());
      return true;
    }
    return true;
  }
  
  /* Error */
  public void a(ArConfigInfo paramArConfigInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 88
    //   10: iconst_2
    //   11: new 90	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   18: ldc 228
    //   20: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 230	adev:isDownloading	Z
    //   27: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 230	adev:isDownloading	Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +6 -> 48
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: getfield 46	adev:dd	[B
    //   52: astore 12
    //   54: aload 12
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   61: invokevirtual 236	java/util/ArrayList:clear	()V
    //   64: aload_1
    //   65: ifnull +121 -> 186
    //   68: aload_1
    //   69: getfield 166	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   72: ifnull +114 -> 186
    //   75: aload_1
    //   76: getfield 166	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   79: invokevirtual 240	java/util/ArrayList:size	()I
    //   82: ifle +104 -> 186
    //   85: iconst_0
    //   86: istore 4
    //   88: aload_1
    //   89: getfield 166	com/tencent/mobileqq/ar/aidl/ArConfigInfo:mArCloudConfigInfos	Ljava/util/ArrayList;
    //   92: invokevirtual 172	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   95: astore 13
    //   97: aload 13
    //   99: invokeinterface 177 1 0
    //   104: ifeq +1589 -> 1693
    //   107: aload 13
    //   109: invokeinterface 181 1 0
    //   114: checkcast 183	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo
    //   117: astore 14
    //   119: aload 14
    //   121: ifnull +25 -> 146
    //   124: aload 14
    //   126: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   129: ifnull +17 -> 146
    //   132: aload 14
    //   134: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   137: getfield 243	com/tencent/mobileqq/ar/model/ArFeatureInfo:bud	Ljava/lang/String;
    //   140: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifeq +223 -> 366
    //   146: ldc 88
    //   148: iconst_1
    //   149: ldc 245
    //   151: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -57 -> 97
    //   157: astore_1
    //   158: ldc 88
    //   160: iconst_2
    //   161: new 90	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   168: ldc 247
    //   170: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_1
    //   174: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_0
    //   187: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   190: invokevirtual 240	java/util/ArrayList:size	()I
    //   193: ifle +1777 -> 1970
    //   196: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +34 -> 233
    //   202: ldc 88
    //   204: iconst_2
    //   205: new 90	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   212: ldc 252
    //   214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_0
    //   218: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   221: invokevirtual 240	java/util/ArrayList:size	()I
    //   224: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: lconst_0
    //   235: putfield 257	adev:Sw	J
    //   238: aload_0
    //   239: lconst_0
    //   240: putfield 259	adev:downloadSize	J
    //   243: aload_0
    //   244: iconst_1
    //   245: putfield 230	adev:isDownloading	Z
    //   248: aload_0
    //   249: iconst_0
    //   250: putfield 261	adev:hasReport	Z
    //   253: iconst_0
    //   254: istore 5
    //   256: aload_0
    //   257: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   260: invokevirtual 240	java/util/ArrayList:size	()I
    //   263: istore 4
    //   265: iload 4
    //   267: iconst_1
    //   268: isub
    //   269: istore 6
    //   271: iconst_0
    //   272: istore 4
    //   274: iload 6
    //   276: iflt +63 -> 339
    //   279: aload_0
    //   280: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   283: iload 6
    //   285: invokevirtual 265	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   288: checkcast 8	adev$a
    //   291: astore_1
    //   292: iload_2
    //   293: ifeq +1417 -> 1710
    //   296: aload_1
    //   297: iconst_1
    //   298: putfield 268	adev$a:isAuto	Z
    //   301: aload_0
    //   302: getfield 66	adev:a	Ladex;
    //   305: aload_1
    //   306: getfield 80	adev$a:md5	Ljava/lang/String;
    //   309: invokevirtual 273	adex:kT	(Ljava/lang/String;)Z
    //   312: ifne +1398 -> 1710
    //   315: aload_0
    //   316: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   319: iload 6
    //   321: invokevirtual 276	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   324: pop
    //   325: aload_0
    //   326: getfield 57	adev:cb	Ljava/util/Set;
    //   329: aload_1
    //   330: getfield 80	adev$a:md5	Ljava/lang/String;
    //   333: invokeinterface 281 2 0
    //   338: pop
    //   339: iload 4
    //   341: ifne +8 -> 349
    //   344: aload_0
    //   345: iconst_0
    //   346: putfield 230	adev:isDownloading	Z
    //   349: aload 12
    //   351: monitorexit
    //   352: goto -307 -> 45
    //   355: astore_1
    //   356: aload 12
    //   358: monitorexit
    //   359: aload_1
    //   360: athrow
    //   361: astore_1
    //   362: aload_0
    //   363: monitorexit
    //   364: aload_1
    //   365: athrow
    //   366: aload 14
    //   368: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   371: getfield 191	com/tencent/mobileqq/ar/model/ArFeatureInfo:bue	Ljava/lang/String;
    //   374: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   377: ifne +132 -> 509
    //   380: aload 14
    //   382: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   385: getfield 191	com/tencent/mobileqq/ar/model/ArFeatureInfo:bue	Ljava/lang/String;
    //   388: invokestatic 197	aqhq:fileExists	(Ljava/lang/String;)Z
    //   391: ifne +118 -> 509
    //   394: new 8	adev$a
    //   397: dup
    //   398: invokespecial 282	adev$a:<init>	()V
    //   401: astore 8
    //   403: aload 8
    //   405: iconst_2
    //   406: putfield 283	adev$a:type	I
    //   409: aload 8
    //   411: aload 14
    //   413: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   416: getfield 243	com/tencent/mobileqq/ar/model/ArFeatureInfo:bud	Ljava/lang/String;
    //   419: putfield 71	adev$a:url	Ljava/lang/String;
    //   422: aload 8
    //   424: aload 14
    //   426: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   429: getfield 286	com/tencent/mobileqq/ar/model/ArFeatureInfo:buc	Ljava/lang/String;
    //   432: putfield 80	adev$a:md5	Ljava/lang/String;
    //   435: aload 8
    //   437: aload 14
    //   439: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   442: getfield 191	com/tencent/mobileqq/ar/model/ArFeatureInfo:bue	Ljava/lang/String;
    //   445: putfield 135	adev$a:fileName	Ljava/lang/String;
    //   448: aload 8
    //   450: aload 14
    //   452: getfield 186	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo	Lcom/tencent/mobileqq/ar/model/ArFeatureInfo;
    //   455: getfield 289	com/tencent/mobileqq/ar/model/ArFeatureInfo:Uq	J
    //   458: putfield 292	adev$a:fileSize	J
    //   461: aload 8
    //   463: iconst_1
    //   464: putfield 295	adev$a:bMr	Z
    //   467: aload_0
    //   468: getfield 57	adev:cb	Ljava/util/Set;
    //   471: aload 8
    //   473: getfield 80	adev$a:md5	Ljava/lang/String;
    //   476: invokeinterface 298 2 0
    //   481: ifne +28 -> 509
    //   484: aload_0
    //   485: getfield 57	adev:cb	Ljava/util/Set;
    //   488: aload 8
    //   490: getfield 80	adev$a:md5	Ljava/lang/String;
    //   493: invokeinterface 301 2 0
    //   498: pop
    //   499: aload_0
    //   500: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   503: aload 8
    //   505: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   508: pop
    //   509: aload 14
    //   511: getfield 200	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:type	I
    //   514: bipush 100
    //   516: if_icmpne +425 -> 941
    //   519: ldc_w 304
    //   522: astore 8
    //   524: aload 14
    //   526: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   529: ifnull +1473 -> 2002
    //   532: new 205	java/io/File
    //   535: dup
    //   536: aload 14
    //   538: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   541: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   544: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   547: astore 10
    //   549: new 90	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   556: invokestatic 309	aden:sl	()Ljava/lang/String;
    //   559: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: ldc_w 311
    //   565: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload 14
    //   570: getfield 200	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:type	I
    //   573: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: getstatic 314	java/io/File:separator	Ljava/lang/String;
    //   579: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 14
    //   584: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   587: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   590: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: ldc_w 319
    //   596: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: astore 8
    //   604: new 205	java/io/File
    //   607: dup
    //   608: aload 8
    //   610: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   613: astore 9
    //   615: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +44 -> 662
    //   621: ldc 88
    //   623: iconst_2
    //   624: new 90	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 321
    //   634: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload 8
    //   639: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: ldc_w 323
    //   645: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload 9
    //   650: invokevirtual 216	java/io/File:exists	()Z
    //   653: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   656: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: aload 9
    //   664: invokevirtual 216	java/io/File:exists	()Z
    //   667: ifeq +63 -> 730
    //   670: aload 10
    //   672: invokevirtual 216	java/io/File:exists	()Z
    //   675: ifne +55 -> 730
    //   678: aload 10
    //   680: invokevirtual 326	java/io/File:mkdirs	()Z
    //   683: istore_3
    //   684: aload 9
    //   686: aload 10
    //   688: invokestatic 330	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   691: istore 7
    //   693: ldc 88
    //   695: iconst_1
    //   696: new 90	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 332
    //   706: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iload 7
    //   711: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   714: ldc_w 334
    //   717: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: iload_3
    //   721: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   724: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: ldc_w 304
    //   733: astore 9
    //   735: aload 10
    //   737: invokevirtual 216	java/io/File:exists	()Z
    //   740: istore_3
    //   741: aload 9
    //   743: astore 8
    //   745: iload_3
    //   746: ifeq +109 -> 855
    //   749: aload 10
    //   751: invokevirtual 337	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   754: invokestatic 343	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   757: astore 11
    //   759: aload 11
    //   761: astore 9
    //   763: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +51 -> 817
    //   769: aload 11
    //   771: astore 9
    //   773: ldc 88
    //   775: iconst_2
    //   776: new 90	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   783: ldc_w 345
    //   786: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload 11
    //   791: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc_w 347
    //   797: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: aload 14
    //   802: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   805: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   808: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   817: aload 11
    //   819: astore 8
    //   821: aload 11
    //   823: astore 9
    //   825: aload 14
    //   827: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   830: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   833: aload 11
    //   835: invokevirtual 352	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   838: ifne +17 -> 855
    //   841: aload 11
    //   843: astore 9
    //   845: aload 10
    //   847: invokevirtual 355	java/io/File:delete	()Z
    //   850: pop
    //   851: aload 11
    //   853: astore 8
    //   855: aload 10
    //   857: invokevirtual 216	java/io/File:exists	()Z
    //   860: istore_3
    //   861: new 357	java/util/HashMap
    //   864: dup
    //   865: invokespecial 358	java/util/HashMap:<init>	()V
    //   868: astore 9
    //   870: aload 9
    //   872: ldc_w 359
    //   875: aload 8
    //   877: invokevirtual 363	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   880: pop
    //   881: aload 9
    //   883: ldc_w 365
    //   886: aload_0
    //   887: getfield 64	adev:mApp	Lcom/tencent/common/app/AppInterface;
    //   890: invokevirtual 368	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   893: invokevirtual 363	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   896: pop
    //   897: iload_3
    //   898: ifeq +1110 -> 2008
    //   901: ldc_w 370
    //   904: astore 8
    //   906: aload 9
    //   908: ldc_w 372
    //   911: aload 8
    //   913: invokevirtual 363	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   916: pop
    //   917: invokestatic 378	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   920: invokestatic 383	anpc:a	(Landroid/content/Context;)Lanpc;
    //   923: ldc_w 304
    //   926: ldc_w 385
    //   929: iload_3
    //   930: lconst_0
    //   931: lconst_0
    //   932: aload 9
    //   934: ldc_w 304
    //   937: iconst_1
    //   938: invokevirtual 389	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   941: aload 14
    //   943: getfield 200	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:type	I
    //   946: ifeq +13 -> 959
    //   949: aload 14
    //   951: getfield 200	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:type	I
    //   954: bipush 100
    //   956: if_icmpne +474 -> 1430
    //   959: aload 14
    //   961: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   964: ifnull +1032 -> 1996
    //   967: new 205	java/io/File
    //   970: dup
    //   971: aload 14
    //   973: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   976: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   979: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   982: astore 8
    //   984: aconst_null
    //   985: astore 10
    //   987: aload 10
    //   989: astore 9
    //   991: aload 8
    //   993: ifnull +25 -> 1018
    //   996: aload 10
    //   998: astore 9
    //   1000: aload 8
    //   1002: invokevirtual 216	java/io/File:exists	()Z
    //   1005: ifeq +13 -> 1018
    //   1008: aload 8
    //   1010: invokevirtual 337	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1013: invokestatic 343	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   1016: astore 9
    //   1018: aload 8
    //   1020: ifnull +292 -> 1312
    //   1023: aload 8
    //   1025: invokevirtual 216	java/io/File:exists	()Z
    //   1028: ifeq +284 -> 1312
    //   1031: aload 9
    //   1033: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1036: ifne +276 -> 1312
    //   1039: aload 9
    //   1041: aload 14
    //   1043: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1046: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   1049: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1052: istore_3
    //   1053: iload_3
    //   1054: ifeq +258 -> 1312
    //   1057: new 205	java/io/File
    //   1060: dup
    //   1061: aload 14
    //   1063: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1066: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   1069: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   1072: astore 8
    //   1074: aload 14
    //   1076: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1079: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   1082: new 90	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1089: aload 8
    //   1091: invokevirtual 396	java/io/File:getParentFile	()Ljava/io/File;
    //   1094: invokevirtual 337	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1097: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: getstatic 314	java/io/File:separator	Ljava/lang/String;
    //   1103: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload 14
    //   1108: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1111: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   1114: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: getstatic 314	java/io/File:separator	Ljava/lang/String;
    //   1120: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1126: invokestatic 402	adjg:fn	(Ljava/lang/String;Ljava/lang/String;)V
    //   1129: iconst_1
    //   1130: istore 5
    //   1132: iconst_1
    //   1133: istore 4
    //   1135: ldc 88
    //   1137: iconst_1
    //   1138: ldc_w 404
    //   1141: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1144: goto -1047 -> 97
    //   1147: astore 8
    //   1149: ldc 88
    //   1151: iconst_1
    //   1152: ldc_w 406
    //   1155: aload 8
    //   1157: invokestatic 409	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1160: aload 9
    //   1162: astore 8
    //   1164: goto -309 -> 855
    //   1167: new 205	java/io/File
    //   1170: dup
    //   1171: aload 14
    //   1173: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1176: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   1179: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   1182: invokevirtual 355	java/io/File:delete	()Z
    //   1185: pop
    //   1186: new 8	adev$a
    //   1189: dup
    //   1190: invokespecial 282	adev$a:<init>	()V
    //   1193: astore 8
    //   1195: aload 8
    //   1197: iconst_3
    //   1198: putfield 283	adev$a:type	I
    //   1201: aload 8
    //   1203: aload 14
    //   1205: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1208: getfield 412	com/tencent/mobileqq/ar/model/ArModelResource:bun	Ljava/lang/String;
    //   1211: putfield 71	adev$a:url	Ljava/lang/String;
    //   1214: aload 8
    //   1216: aload 14
    //   1218: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1221: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   1224: putfield 80	adev$a:md5	Ljava/lang/String;
    //   1227: aload 8
    //   1229: aload 14
    //   1231: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1234: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   1237: putfield 135	adev$a:fileName	Ljava/lang/String;
    //   1240: aload 8
    //   1242: aload 14
    //   1244: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1247: getfield 415	com/tencent/mobileqq/ar/model/ArModelResource:Ur	J
    //   1250: putfield 292	adev$a:fileSize	J
    //   1253: aload 8
    //   1255: iconst_1
    //   1256: putfield 295	adev$a:bMr	Z
    //   1259: iload 5
    //   1261: istore 4
    //   1263: aload_0
    //   1264: getfield 57	adev:cb	Ljava/util/Set;
    //   1267: aload 8
    //   1269: getfield 80	adev$a:md5	Ljava/lang/String;
    //   1272: invokeinterface 298 2 0
    //   1277: ifne -133 -> 1144
    //   1280: aload_0
    //   1281: getfield 57	adev:cb	Ljava/util/Set;
    //   1284: aload 8
    //   1286: getfield 80	adev$a:md5	Ljava/lang/String;
    //   1289: invokeinterface 301 2 0
    //   1294: pop
    //   1295: aload_0
    //   1296: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   1299: aload 8
    //   1301: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1304: pop
    //   1305: iload 5
    //   1307: istore 4
    //   1309: goto -165 -> 1144
    //   1312: new 8	adev$a
    //   1315: dup
    //   1316: invokespecial 282	adev$a:<init>	()V
    //   1319: astore 8
    //   1321: aload 8
    //   1323: iconst_3
    //   1324: putfield 283	adev$a:type	I
    //   1327: aload 8
    //   1329: aload 14
    //   1331: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1334: getfield 412	com/tencent/mobileqq/ar/model/ArModelResource:bun	Ljava/lang/String;
    //   1337: putfield 71	adev$a:url	Ljava/lang/String;
    //   1340: aload 8
    //   1342: aload 14
    //   1344: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1347: getfield 317	com/tencent/mobileqq/ar/model/ArModelResource:bum	Ljava/lang/String;
    //   1350: putfield 80	adev$a:md5	Ljava/lang/String;
    //   1353: aload 8
    //   1355: aload 14
    //   1357: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1360: getfield 210	com/tencent/mobileqq/ar/model/ArModelResource:zipFileName	Ljava/lang/String;
    //   1363: putfield 135	adev$a:fileName	Ljava/lang/String;
    //   1366: aload 8
    //   1368: aload 14
    //   1370: getfield 203	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_a_of_type_ComTencentMobileqqArModelArModelResource	Lcom/tencent/mobileqq/ar/model/ArModelResource;
    //   1373: getfield 415	com/tencent/mobileqq/ar/model/ArModelResource:Ur	J
    //   1376: putfield 292	adev$a:fileSize	J
    //   1379: aload 8
    //   1381: iconst_1
    //   1382: putfield 295	adev$a:bMr	Z
    //   1385: aload_0
    //   1386: getfield 57	adev:cb	Ljava/util/Set;
    //   1389: aload 8
    //   1391: getfield 80	adev$a:md5	Ljava/lang/String;
    //   1394: invokeinterface 298 2 0
    //   1399: ifne +626 -> 2025
    //   1402: aload_0
    //   1403: getfield 57	adev:cb	Ljava/util/Set;
    //   1406: aload 8
    //   1408: getfield 80	adev$a:md5	Ljava/lang/String;
    //   1411: invokeinterface 301 2 0
    //   1416: pop
    //   1417: aload_0
    //   1418: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   1421: aload 8
    //   1423: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1426: pop
    //   1427: goto +598 -> 2025
    //   1430: aload 14
    //   1432: getfield 418	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:uk	Ljava/util/ArrayList;
    //   1435: ifnull -1338 -> 97
    //   1438: aload 14
    //   1440: getfield 418	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:uk	Ljava/util/ArrayList;
    //   1443: invokevirtual 240	java/util/ArrayList:size	()I
    //   1446: ifle -1349 -> 97
    //   1449: aload 14
    //   1451: getfield 418	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:uk	Ljava/util/ArrayList;
    //   1454: invokevirtual 172	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1457: astore 9
    //   1459: aload 9
    //   1461: invokeinterface 177 1 0
    //   1466: ifeq -1369 -> 97
    //   1469: aload 9
    //   1471: invokeinterface 181 1 0
    //   1476: checkcast 420	com/tencent/mobileqq/ar/model/ArVideoResourceInfo
    //   1479: astore 10
    //   1481: aload 10
    //   1483: getfield 423	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoType	I
    //   1486: iconst_4
    //   1487: if_icmpeq -28 -> 1459
    //   1490: new 205	java/io/File
    //   1493: dup
    //   1494: aload 10
    //   1496: getfield 426	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:bus	Ljava/lang/String;
    //   1499: invokespecial 213	java/io/File:<init>	(Ljava/lang/String;)V
    //   1502: astore 11
    //   1504: aload 11
    //   1506: invokevirtual 216	java/io/File:exists	()Z
    //   1509: istore_3
    //   1510: iload_3
    //   1511: ifeq +517 -> 2028
    //   1514: aload 11
    //   1516: invokevirtual 337	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1519: invokestatic 343	alab:getFileMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   1522: astore 8
    //   1524: aload 11
    //   1526: invokevirtual 216	java/io/File:exists	()Z
    //   1529: ifeq +24 -> 1553
    //   1532: aload 8
    //   1534: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1537: ifne +16 -> 1553
    //   1540: aload 8
    //   1542: aload 10
    //   1544: getfield 429	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoMd5	Ljava/lang/String;
    //   1547: invokevirtual 392	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1550: ifne -91 -> 1459
    //   1553: aload_0
    //   1554: getfield 57	adev:cb	Ljava/util/Set;
    //   1557: aload 10
    //   1559: getfield 432	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoUrl	Ljava/lang/String;
    //   1562: invokeinterface 298 2 0
    //   1567: ifne -108 -> 1459
    //   1570: new 8	adev$a
    //   1573: dup
    //   1574: invokespecial 282	adev$a:<init>	()V
    //   1577: astore 8
    //   1579: aload 8
    //   1581: iconst_3
    //   1582: putfield 283	adev$a:type	I
    //   1585: aload 8
    //   1587: aload 10
    //   1589: getfield 432	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoUrl	Ljava/lang/String;
    //   1592: putfield 71	adev$a:url	Ljava/lang/String;
    //   1595: aload 8
    //   1597: aload 10
    //   1599: getfield 429	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoMd5	Ljava/lang/String;
    //   1602: putfield 80	adev$a:md5	Ljava/lang/String;
    //   1605: aload 8
    //   1607: aload 10
    //   1609: getfield 435	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoSize	J
    //   1612: putfield 292	adev$a:fileSize	J
    //   1615: aload 8
    //   1617: aload 10
    //   1619: getfield 426	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:bus	Ljava/lang/String;
    //   1622: putfield 135	adev$a:fileName	Ljava/lang/String;
    //   1625: aload 8
    //   1627: iconst_1
    //   1628: putfield 295	adev$a:bMr	Z
    //   1631: aload_0
    //   1632: getfield 62	adev:uh	Ljava/util/ArrayList;
    //   1635: aload 8
    //   1637: invokevirtual 302	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1640: pop
    //   1641: aload_0
    //   1642: getfield 57	adev:cb	Ljava/util/Set;
    //   1645: aload 10
    //   1647: getfield 429	com/tencent/mobileqq/ar/model/ArVideoResourceInfo:videoMd5	Ljava/lang/String;
    //   1650: invokeinterface 301 2 0
    //   1655: pop
    //   1656: goto -197 -> 1459
    //   1659: astore 8
    //   1661: ldc 88
    //   1663: iconst_1
    //   1664: new 90	java/lang/StringBuilder
    //   1667: dup
    //   1668: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1671: ldc 247
    //   1673: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: aload 8
    //   1678: invokevirtual 436	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1681: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1687: invokestatic 438	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1690: goto +338 -> 2028
    //   1693: iload 4
    //   1695: ifeq -1509 -> 186
    //   1698: aload_0
    //   1699: getfield 66	adev:a	Ladex;
    //   1702: aload_1
    //   1703: invokevirtual 440	adex:b	(Lcom/tencent/mobileqq/ar/aidl/ArConfigInfo;)Z
    //   1706: pop
    //   1707: goto -1521 -> 186
    //   1710: aload_0
    //   1711: aload_0
    //   1712: getfield 257	adev:Sw	J
    //   1715: aload_1
    //   1716: getfield 292	adev$a:fileSize	J
    //   1719: ladd
    //   1720: putfield 257	adev:Sw	J
    //   1723: aload_0
    //   1724: getfield 64	adev:mApp	Lcom/tencent/common/app/AppInterface;
    //   1727: sipush 168
    //   1730: invokevirtual 444	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1733: checkcast 270	adex
    //   1736: invokevirtual 447	adex:BB	()I
    //   1739: istore 5
    //   1741: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1744: ifeq +290 -> 2034
    //   1747: ldc 88
    //   1749: iconst_2
    //   1750: new 90	java/lang/StringBuilder
    //   1753: dup
    //   1754: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1757: ldc_w 449
    //   1760: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: iload 5
    //   1765: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1768: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1774: goto +260 -> 2034
    //   1777: new 11	adev$b
    //   1780: dup
    //   1781: aload_0
    //   1782: getfield 64	adev:mApp	Lcom/tencent/common/app/AppInterface;
    //   1785: checkcast 451	com/tencent/mobileqq/app/QQAppInterface
    //   1788: aload_1
    //   1789: aload_0
    //   1790: invokespecial 454	adev$b:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ladev$a;Ladev;)V
    //   1793: astore 8
    //   1795: aload_0
    //   1796: getfield 64	adev:mApp	Lcom/tencent/common/app/AppInterface;
    //   1799: sipush 193
    //   1802: invokevirtual 444	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1805: checkcast 456	aopo
    //   1808: sipush 10067
    //   1811: ldc_w 458
    //   1814: aload_1
    //   1815: getfield 80	adev$a:md5	Ljava/lang/String;
    //   1818: iconst_0
    //   1819: aload_1
    //   1820: getfield 71	adev$a:url	Ljava/lang/String;
    //   1823: aload_1
    //   1824: getfield 135	adev$a:fileName	Ljava/lang/String;
    //   1827: iload 5
    //   1829: iconst_0
    //   1830: iconst_1
    //   1831: aload 8
    //   1833: invokevirtual 461	aopo:a	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLaopm;)Z
    //   1836: istore_3
    //   1837: iload_3
    //   1838: ifeq +155 -> 1993
    //   1841: iload 4
    //   1843: iconst_1
    //   1844: iadd
    //   1845: istore 4
    //   1847: iload 4
    //   1849: istore 5
    //   1851: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1854: ifeq +33 -> 1887
    //   1857: iload 4
    //   1859: istore 5
    //   1861: ldc 88
    //   1863: iconst_2
    //   1864: new 90	java/lang/StringBuilder
    //   1867: dup
    //   1868: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1871: ldc_w 463
    //   1874: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: iload_3
    //   1878: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1881: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1884: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1887: iload 6
    //   1889: iconst_1
    //   1890: isub
    //   1891: istore 6
    //   1893: goto -1619 -> 274
    //   1896: iconst_2
    //   1897: istore 5
    //   1899: goto -122 -> 1777
    //   1902: iconst_3
    //   1903: istore 5
    //   1905: goto -128 -> 1777
    //   1908: iconst_1
    //   1909: istore 5
    //   1911: goto -134 -> 1777
    //   1914: astore_1
    //   1915: aload_0
    //   1916: getfield 57	adev:cb	Ljava/util/Set;
    //   1919: invokeinterface 464 1 0
    //   1924: iload 5
    //   1926: istore 4
    //   1928: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1931: ifeq -1592 -> 339
    //   1934: ldc 88
    //   1936: iconst_2
    //   1937: new 90	java/lang/StringBuilder
    //   1940: dup
    //   1941: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1944: ldc_w 466
    //   1947: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: aload_1
    //   1951: invokevirtual 221	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1954: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1957: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1960: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1963: iload 5
    //   1965: istore 4
    //   1967: goto -1628 -> 339
    //   1970: aload_0
    //   1971: getfield 66	adev:a	Ladex;
    //   1974: invokevirtual 469	adex:pt	()V
    //   1977: goto -1628 -> 349
    //   1980: astore_1
    //   1981: iload 4
    //   1983: istore 5
    //   1985: goto -70 -> 1915
    //   1988: astore 8
    //   1990: goto -823 -> 1167
    //   1993: goto -146 -> 1847
    //   1996: aconst_null
    //   1997: astore 8
    //   1999: goto -1015 -> 984
    //   2002: aconst_null
    //   2003: astore 10
    //   2005: goto -1401 -> 604
    //   2008: ldc_w 471
    //   2011: astore 8
    //   2013: goto -1107 -> 906
    //   2016: astore 8
    //   2018: iload 4
    //   2020: istore 5
    //   2022: goto -855 -> 1167
    //   2025: goto -881 -> 1144
    //   2028: aconst_null
    //   2029: astore 8
    //   2031: goto -507 -> 1524
    //   2034: iload 5
    //   2036: tableswitch	default:+28 -> 2064, 1:+-140->1896, 2:+-134->1902, 3:+-128->1908
    //   2065: istore 5
    //   2067: goto -290 -> 1777
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2070	0	this	adev
    //   0	2070	1	paramArConfigInfo	ArConfigInfo
    //   0	2070	2	paramBoolean1	boolean
    //   0	2070	3	paramBoolean2	boolean
    //   86	1933	4	i	int
    //   254	1812	5	j	int
    //   269	1623	6	k	int
    //   691	19	7	bool	boolean
    //   401	689	8	localObject1	Object
    //   1147	9	8	localThrowable	java.lang.Throwable
    //   1162	474	8	localObject2	Object
    //   1659	18	8	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   1793	39	8	localb	adev.b
    //   1988	1	8	localException1	Exception
    //   1997	15	8	str	String
    //   2016	1	8	localException2	Exception
    //   2029	1	8	localObject3	Object
    //   613	857	9	localObject4	Object
    //   547	1457	10	localObject5	Object
    //   757	768	11	localObject6	Object
    //   52	305	12	arrayOfByte	byte[]
    //   95	13	13	localIterator	Iterator
    //   117	1333	14	localArCloudConfigInfo	ArCloudConfigInfo
    // Exception table:
    //   from	to	target	type
    //   68	85	157	java/lang/Exception
    //   88	97	157	java/lang/Exception
    //   97	119	157	java/lang/Exception
    //   124	146	157	java/lang/Exception
    //   146	154	157	java/lang/Exception
    //   366	509	157	java/lang/Exception
    //   509	519	157	java/lang/Exception
    //   524	604	157	java/lang/Exception
    //   604	662	157	java/lang/Exception
    //   662	730	157	java/lang/Exception
    //   735	741	157	java/lang/Exception
    //   749	759	157	java/lang/Exception
    //   763	769	157	java/lang/Exception
    //   773	817	157	java/lang/Exception
    //   825	841	157	java/lang/Exception
    //   845	851	157	java/lang/Exception
    //   855	897	157	java/lang/Exception
    //   906	941	157	java/lang/Exception
    //   941	959	157	java/lang/Exception
    //   959	984	157	java/lang/Exception
    //   1000	1018	157	java/lang/Exception
    //   1023	1053	157	java/lang/Exception
    //   1149	1160	157	java/lang/Exception
    //   1167	1259	157	java/lang/Exception
    //   1263	1305	157	java/lang/Exception
    //   1312	1427	157	java/lang/Exception
    //   1430	1459	157	java/lang/Exception
    //   1459	1510	157	java/lang/Exception
    //   1514	1524	157	java/lang/Exception
    //   1524	1553	157	java/lang/Exception
    //   1553	1656	157	java/lang/Exception
    //   1661	1690	157	java/lang/Exception
    //   1698	1707	157	java/lang/Exception
    //   57	64	355	finally
    //   68	85	355	finally
    //   88	97	355	finally
    //   97	119	355	finally
    //   124	146	355	finally
    //   146	154	355	finally
    //   158	186	355	finally
    //   186	233	355	finally
    //   233	253	355	finally
    //   256	265	355	finally
    //   279	292	355	finally
    //   296	339	355	finally
    //   344	349	355	finally
    //   349	352	355	finally
    //   356	359	355	finally
    //   366	509	355	finally
    //   509	519	355	finally
    //   524	604	355	finally
    //   604	662	355	finally
    //   662	730	355	finally
    //   735	741	355	finally
    //   749	759	355	finally
    //   763	769	355	finally
    //   773	817	355	finally
    //   825	841	355	finally
    //   845	851	355	finally
    //   855	897	355	finally
    //   906	941	355	finally
    //   941	959	355	finally
    //   959	984	355	finally
    //   1000	1018	355	finally
    //   1023	1053	355	finally
    //   1057	1129	355	finally
    //   1135	1144	355	finally
    //   1149	1160	355	finally
    //   1167	1259	355	finally
    //   1263	1305	355	finally
    //   1312	1427	355	finally
    //   1430	1459	355	finally
    //   1459	1510	355	finally
    //   1514	1524	355	finally
    //   1524	1553	355	finally
    //   1553	1656	355	finally
    //   1661	1690	355	finally
    //   1698	1707	355	finally
    //   1710	1774	355	finally
    //   1777	1837	355	finally
    //   1851	1857	355	finally
    //   1861	1887	355	finally
    //   1915	1924	355	finally
    //   1928	1963	355	finally
    //   1970	1977	355	finally
    //   2	36	361	finally
    //   36	41	361	finally
    //   48	57	361	finally
    //   359	361	361	finally
    //   749	759	1147	java/lang/Throwable
    //   763	769	1147	java/lang/Throwable
    //   773	817	1147	java/lang/Throwable
    //   825	841	1147	java/lang/Throwable
    //   845	851	1147	java/lang/Throwable
    //   1514	1524	1659	java/lang/UnsatisfiedLinkError
    //   256	265	1914	java/lang/Exception
    //   1851	1857	1914	java/lang/Exception
    //   1861	1887	1914	java/lang/Exception
    //   279	292	1980	java/lang/Exception
    //   296	339	1980	java/lang/Exception
    //   1710	1774	1980	java/lang/Exception
    //   1777	1837	1980	java/lang/Exception
    //   1135	1144	1988	java/lang/Exception
    //   1057	1129	2016	java/lang/Exception
  }
  
  public void cancelDownload()
  {
    if (this.isDownloading)
    {
      synchronized (this.dd)
      {
        Iterator localIterator = this.uh.iterator();
        while (localIterator.hasNext())
        {
          adev.a locala = (adev.a)localIterator.next();
          if (locala.downloadSize < locala.fileSize) {
            this.c.b(locala.f);
          }
        }
      }
      this.uh.clear();
      this.isDownloading = false;
      this.cb.clear();
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3)
    {
      QLog.d("ArConfig_ArResourceDownload", 1, "doOnResp is downloading...");
      return;
    }
    boolean bool1;
    label28:
    int i;
    aoll localaoll;
    boolean bool2;
    Object localObject3;
    adev.a locala;
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      i = paramaomh.mErrCode;
      localaoll = (aoll)paramaomh.b;
      ??? = localaoll.U();
      bool2 = bool1;
      if (??? != null)
      {
        bool2 = bool1;
        if ((??? instanceof adev.a))
        {
          localObject3 = this.a.a();
          locala = (adev.a)???;
          if (!TextUtils.isEmpty(localaoll.atY)) {
            break label1267;
          }
          QLog.d("ArConfig_ArResourceDownload", 1, "req.mOutPath is null, md5=" + locala.md5);
          if (!bool1) {
            break label766;
          }
          i = 98765;
          label136:
          bool1 = false;
        }
      }
    }
    label264:
    label291:
    label1104:
    label1115:
    label1253:
    label1259:
    label1267:
    for (;;)
    {
      int j;
      if (bool1)
      {
        ??? = new File(localaoll.atY);
        ??? = alab.getFileMD5String(((File)???).getAbsolutePath());
        if ((!TextUtils.isEmpty((CharSequence)???)) && (!((String)???).equalsIgnoreCase(locala.md5)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArResourceDownload", 2, "Md5 error|fileMD5=" + (String)??? + ", type=" + locala.type);
          }
          j = i;
          bool2 = bool1;
          if (locala.type != 1)
          {
            ((File)???).delete();
            bool2 = false;
            j = -100001;
          }
          if (locala.isAuto) {
            this.a.bV(locala.md5, true);
          }
          bool1 = bool2;
          i = j;
          if (this.cb.contains(locala.md5)) {
            this.cb.remove(locala.md5);
          }
          if (this.cb.isEmpty()) {
            this.isDownloading = false;
          }
          if ((locala.type != 1) && (locala.type != 2) && (locala.type != 3) && (locala.type != 4)) {
            break label1104;
          }
          j = 1;
          ??? = "0";
          if (!TextUtils.isEmpty(paramaomh.clO))
          {
            ??? = paramaomh.clO;
            ??? = ???;
            if (QLog.isColorLevel())
            {
              QLog.d("ArConfig_ArResourceDownload", 2, "errDesc: " + (String)???);
              ??? = ???;
            }
          }
          ??? = new HashMap();
          ((HashMap)???).put("url", akrf.mD(localaoll.bZ));
          ((HashMap)???).put("resultCode", String.valueOf(paramaomh.mResult));
          ((HashMap)???).put("fileSize", String.valueOf(locala.fileSize));
          ((HashMap)???).put("param_errorDesc", ???);
          if (!bool1) {
            break label1115;
          }
          ((HashMap)???).put("param_FailCode", "0");
          if ((j == 0) || (this.isDownloading) || (!a((ArConfigInfo)localObject3))) {}
        }
      }
      for (;;)
      {
        synchronized (this.dd)
        {
          for (;;)
          {
            if (!this.hasReport)
            {
              this.a.pt();
              this.hasReport = true;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArConfig_ArResourceDownload", 2, "onResp:downloadSuccess!");
            }
            ??? = this.mApp.getCurrentAccountUin();
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance((String)???, "olympic_ar_download", bool1, 0L, 0L, (HashMap)???, null);
            bool2 = bool1;
            ??? = new File(localaoll.atY);
            if ((!bool2) || (!((File)???).exists())) {
              break label1253;
            }
            l = ((File)???).length();
            ??? = (aopo)this.mApp.getManager(193);
            ??? = localaoll.bZ;
            if (!bool2) {
              break label1259;
            }
            ((aopo)???).be((String)???, l);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ArConfig_ArResourceDownload", 2, "onResp:" + localaoll.bZ + ", " + paramaomh.mResult + ", " + paramaomh.mErrCode);
            return;
            bool1 = false;
            break label28;
            label766:
            break label136;
            j = i;
            bool2 = bool1;
            if (locala.type != 3) {
              break label264;
            }
            try
            {
              synchronized (this.dd)
              {
                Object localObject4 = ((ArConfigInfo)localObject3).getModelResByMd5(locala.md5);
                if ((!TextUtils.isEmpty(locala.fileName)) && (localObject4 != null) && ((((ArCloudConfigInfo)localObject4).type == 0) || (((ArCloudConfigInfo)localObject4).type == 100)))
                {
                  localObject4 = new File(locala.fileName);
                  adjg.fn(locala.fileName, ((File)localObject4).getParentFile().getAbsolutePath() + File.separator + locala.md5 + File.separator);
                  this.a.b((ArConfigInfo)localObject3);
                }
                j = i;
                bool2 = bool1;
              }
              if (!QLog.isColorLevel()) {
                break label264;
              }
            }
            catch (Exception localException)
            {
              ((File)???).delete();
              if (locala.bMr)
              {
                bool1 = false;
                i = -100002;
              }
              j = i;
              bool2 = bool1;
            }
          }
          QLog.d("ArConfig_ArResourceDownload", 2, "e= " + localException.getMessage());
          j = i;
          bool2 = bool1;
          break label264;
          if ((locala.downloadTimes <= 3) && (!locala.isAuto))
          {
            a(locala);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ArConfig_ArResourceDownload", 2, "retry downLoad:retryUrl=" + locala.url + ",retryMd5= " + locala.md5);
            return;
          }
          if (locala.isAuto) {
            this.a.bV(locala.md5, false);
          }
          break label291;
          j = 0;
        }
        localException.put("param_FailCode", String.valueOf(i));
        this.cb.clear();
        synchronized (this.dd)
        {
          this.isDownloading = false;
          localObject3 = this.uh.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            locala = (adev.a)((Iterator)localObject3).next();
            if (locala.downloadSize < locala.fileSize) {
              this.c.b(locala.f);
            }
          }
        }
        if ((j != 0) && (!this.hasReport))
        {
          this.a.hi(i, paramaomh.mResult);
          this.hasReport = true;
        }
        continue;
        long l = 0L;
        continue;
        l = -1L;
      }
    }
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.U();
    if ((??? != null) && ((??? instanceof adev.a)))
    {
      ??? = (adev.a)???;
      if (???.type != 1) {}
    }
    else
    {
      return;
    }
    String str = ???.md5;
    synchronized (this.dd)
    {
      Iterator localIterator = this.uh.iterator();
      while (localIterator.hasNext())
      {
        adev.a locala = (adev.a)localIterator.next();
        if (str.equals(locala.md5))
        {
          paramLong2 = locala.downloadSize;
          locala.downloadSize = paramLong1;
          this.downloadSize += paramLong1 - paramLong2;
        }
      }
      if (!this.hasReport) {
        this.a.ak(this.downloadSize, this.Sw);
      }
      return;
    }
  }
  
  public static class a
  {
    boolean bMr = false;
    long downloadSize;
    int downloadTimes;
    aoll f;
    String fileName;
    long fileSize;
    boolean isAuto = false;
    String md5;
    int type;
    String url;
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
      localStringBuffer.append("type=").append(this.type);
      localStringBuffer.append(", url='").append(this.url).append('\'');
      localStringBuffer.append(", md5='").append(this.md5).append('\'');
      localStringBuffer.append(", fileName='").append(this.fileName).append('\'');
      localStringBuffer.append(", fileSize=").append(this.fileSize);
      localStringBuffer.append(", downloadSize=").append(this.downloadSize);
      localStringBuffer.append(", req=").append(this.bMr);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
  
  public static class b
    extends aopm
  {
    adev.a jdField_a_of_type_Adev$a;
    adev jdField_a_of_type_Adev;
    
    public b(QQAppInterface paramQQAppInterface, adev.a parama, adev paramadev)
    {
      super(parama.md5);
      this.jdField_a_of_type_Adev$a = parama;
      this.jdField_a_of_type_Adev = paramadev;
    }
    
    protected void realCancel()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realCancel");
      }
    }
    
    protected void realStart()
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceDownload", 2, "DownloadTask realStart");
      }
      adev.a(this.jdField_a_of_type_Adev, this.jdField_a_of_type_Adev$a);
    }
    
    public String toString()
    {
      return "[DownloadTask] mInfo=" + this.jdField_a_of_type_Adev$a + ", mDownloader=" + this.jdField_a_of_type_Adev;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adev
 * JD-Core Version:    0.7.0.1
 */