import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class afeu
{
  static final String bvQ = acbn.SDCARD_PATH + "pddata/prd/early";
  public QQAppInterface app;
  private XmlData b;
  protected boolean bXM;
  protected boolean bXN;
  protected boolean bXO;
  protected String strResName;
  protected ArrayList<afem.b> wa;
  
  public afeu(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.strResName = paramString;
    this.app = paramQQAppInterface;
  }
  
  public void HL(boolean paramBoolean)
  {
    new File(up()).delete();
    XmlData localXmlData = b();
    localXmlData.Version = 0;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    localXmlData.hasResDownloaded = false;
    afel.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload(), this.strResName=" + this.strResName + ", resName=" + localXmlData.strResName + ", user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = g();
    if (localGetResourceReqInfo != null)
    {
      afem localafem = (afem)this.app.getManager(77);
      if ((localafem != null) && (!localafem.lN(localXmlData.getStrResName())))
      {
        localIntent.putExtra("reqResult", true);
        localafem.HL(localXmlData.getStrResName());
        ((accy)this.app.getBusinessHandler(4)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
      }
    }
    for (;;)
    {
      if (this.bXO)
      {
        localIntent.setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
        localIntent.putExtra("strResName", this.strResName);
        localIntent.putExtra("strPkgName", localXmlData.strPkgName);
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.qqhead.permission.getheadresp");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, String.format("restartDownload() res[%s] is downloading", new Object[] { localXmlData.getStrResName() }));
      }
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
      continue;
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
    }
  }
  
  public void HM(boolean paramBoolean)
  {
    if (this.bXO != paramBoolean)
    {
      this.bXO = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "setIsBroadcast() " + paramBoolean);
      }
    }
  }
  
  public void HN(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "setFail() resName:" + this.strResName);
    }
    XmlData localXmlData = b();
    if (localXmlData != null)
    {
      if (localXmlData.loadState != 1) {
        break label90;
      }
      localXmlData.loadState = 0;
      localXmlData.Version = 0;
    }
    for (;;)
    {
      localXmlData.hasResDownloaded = false;
      afel.a(localXmlData, new String[] { "loadState", "Version", "hasResDownloaded" });
      return;
      label90:
      if ((localXmlData.loadState == 2) && (paramBoolean)) {
        localXmlData.loadState = 0;
      }
    }
  }
  
  public void HO(String paramString)
  {
    if ((this.wa != null) && (this.wa.size() > 0))
    {
      Iterator localIterator = this.wa.iterator();
      while (localIterator.hasNext()) {
        ((afem.b)localIterator.next()).a(b(), true, 0, aiV(), paramString);
      }
    }
  }
  
  public void HO(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.bXM)
        {
          this.bXM = true;
          i = 1;
        }
        if (i == 1)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_strResName", this.strResName);
          anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "statisticUsage() strResName=" + this.strResName + " inUse=" + paramBoolean);
          }
        }
        return;
      }
      finally {}
      if (!this.bXN)
      {
        this.bXN = true;
        i = 1;
      }
    }
  }
  
  public void HP(boolean paramBoolean) {}
  
  public GetResourceReqInfoV2 a(String paramString)
  {
    long l = 0L;
    XmlData localXmlData = b();
    GetResourceReqInfoV2 localGetResourceReqInfoV2;
    if (localXmlData == null)
    {
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      localGetResourceReqInfoV2.uiCurVer = 0L;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuffer("getResourceReqInfoV2(), strPkgName=" + paramString);
        if (localXmlData != null) {
          break label170;
        }
        paramString.append(",data==null");
      }
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, paramString.toString());
      return localGetResourceReqInfoV2;
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      if (aiZ()) {}
      for (;;)
      {
        localGetResourceReqInfoV2.uiCurVer = l;
        break;
        l = getVersion();
      }
      label170:
      paramString.append(",this.strResName=[" + this.strResName);
      paramString.append("], resName=[" + localXmlData.strResName);
      paramString.append("], pkgName=[" + localXmlData.strPkgName);
      paramString.append("], version=[" + localXmlData.Version);
    }
  }
  
  public void a(afem.b paramb)
  {
    if (paramb != null)
    {
      if (this.wa == null) {
        this.wa = new ArrayList();
      }
      if (!this.wa.contains(paramb)) {
        this.wa.add(paramb);
      }
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    if (this.wa != null)
    {
      Iterator localIterator = this.wa.iterator();
      while (localIterator.hasNext()) {
        ((afem.b)localIterator.next()).a(paramXmlData);
      }
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + paramBoolean + " filePath=" + paramString);
    }
    Object localObject;
    if (paramBoolean)
    {
      paramXmlData.hasResDownloaded = true;
      afel.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.strResName + "this=" + this);
      }
      HO(paramString);
      ((aopo)this.app.getManager(193)).be(paramXmlData.strResURL_big, paramXmlData.downSize);
      if (this.bXO)
      {
        localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
        if (paramInt != 9037) {
          break label390;
        }
        ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("strResName", this.strResName);
      ((Intent)localObject).putExtra("strPkgName", b().strPkgName);
      ((Intent)localObject).putExtra("loadState", b().loadState);
      ((Intent)localObject).putExtra("totalSize", paramXmlData.totalSize);
      ((Intent)localObject).putExtra("downSize", paramXmlData.downSize);
      ((Intent)localObject).putExtra("errCode", paramInt);
      ((Intent)localObject).putExtra("resPath", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.tim.qqhead.permission.getheadresp");
      this.bXO = false;
      return;
      paramXmlData.hasResDownloaded = false;
      afel.a(paramXmlData, new String[] { "hasResDownloaded" });
      QLog.d("EarlyDown", 1, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.strResName);
      if ((this.wa == null) || (this.wa.size() <= 0)) {
        break;
      }
      localObject = this.wa.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((afem.b)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, aiV(), paramString);
      }
      break;
      label390:
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
    }
  }
  
  public abstract boolean aiV();
  
  public boolean aiW()
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    XmlData localXmlData = b();
    if (localXmlData != null) {
      if (aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {
        if (!localXmlData.loadWifi) {
          break label310;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " isWifiConn=true, " + localXmlData.strResName + ":loadWifi=" + localXmlData.loadWifi);
        bool1 = bool2;
      }
      return bool1;
      if (aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) {
        if (aqiw.is3Gor4G(BaseApplicationImpl.getContext())) {
          if (!localXmlData.load3G) {
            break label305;
          }
        }
      }
      label305:
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is3Gor4G=true, " + localXmlData.strResName + ":load3G=" + localXmlData.load3G);
        return bool2;
        if (localXmlData.load2G) {}
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is2G=true, " + localXmlData.strResName + ":load2G=" + localXmlData.load2G);
          return bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
            }
          }
          return false;
        }
      }
      label310:
      bool2 = false;
    }
  }
  
  public boolean aiX()
  {
    return this.bXO;
  }
  
  public boolean aiY()
  {
    boolean bool2 = false;
    XmlData localXmlData = b();
    boolean bool3 = aiW();
    boolean bool1;
    if (!isTimeValid()) {
      if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
      {
        if (!QLog.isColorLevel()) {
          break label141;
        }
        QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((afem)this.app.getManager(77)).a(localXmlData, up());
        bool2 = true;
      }
      while (!QLog.isColorLevel())
      {
        return bool2;
        bool1 = false;
        break;
      }
      QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + bool3 + " timeValid=" + bool1 + " strResName=" + this.strResName);
      return false;
      label141:
      bool1 = true;
    }
  }
  
  public boolean aiZ()
  {
    boolean bool2 = false;
    int i = 1;
    XmlData localXmlData = b();
    int j = -1;
    boolean bool1;
    if (localXmlData == null)
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "isNeedServerInfo(), " + b().strResName + ", need=" + bool1 + ", needTrueReasonCode =" + i);
      }
      return bool1;
    }
    System.currentTimeMillis();
    if (localXmlData.loadState == 1)
    {
      i = j;
      bool1 = bool2;
      if (!aiV())
      {
        i = j;
        bool1 = bool2;
        if (!new File(up()).exists())
        {
          HN(false);
          cYM();
          i = 2;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (!localXmlData.hasResDownloaded)
      {
        bool1 = true;
        i = 4;
        break;
        if ((localXmlData.Version == 0) || (localXmlData.loadState == 2)) {
          break label202;
        }
        localXmlData.Version = 0;
        afel.a(localXmlData, new String[] { "Version" });
        i = 3;
        bool1 = true;
        continue;
      }
      break;
      label202:
      bool1 = true;
      i = j;
    }
  }
  
  public boolean aja()
  {
    return true;
  }
  
  public void aq(long paramLong1, long paramLong2)
  {
    if (this.wa != null)
    {
      XmlData localXmlData = b();
      Iterator localIterator = this.wa.iterator();
      while (localIterator.hasNext()) {
        ((afem.b)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public final XmlData b()
  {
    if (this.b == null) {
      this.b = afel.a(g());
    }
    return this.b;
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    if (this.wa != null)
    {
      Iterator localIterator = this.wa.iterator();
      while (localIterator.hasNext()) {
        ((afem.b)localIterator.next()).b(paramXmlData);
      }
    }
  }
  
  public void cYL() {}
  
  public void cYM()
  {
    if (!aiV()) {
      new File(up()).delete();
    }
  }
  
  public void destroy()
  {
    if (this.wa != null) {
      this.wa.clear();
    }
  }
  
  public void doAfterFinish()
  {
    if (aiV())
    {
      File localFile = new File(up());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + localFile.getAbsolutePath() + " bool=" + bool);
        }
      }
    }
  }
  
  /* Error */
  public void f(XmlData paramXmlData)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 104
    //   6: iconst_1
    //   7: ldc_w 501
    //   10: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 66	afeu:b	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   18: astore 10
    //   20: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +97 -> 120
    //   26: ldc 104
    //   28: iconst_2
    //   29: new 22	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 503
    //   39: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: getfield 109	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   46: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 505
    //   52: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   59: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 507
    //   65: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 10
    //   70: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   73: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: ldc_w 509
    //   79: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 10
    //   84: getfield 79	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   87: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc_w 511
    //   93: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 10
    //   98: getfield 349	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   101: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc_w 513
    //   107: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aconst_null
    //   121: astore 8
    //   123: aconst_null
    //   124: astore 6
    //   126: aconst_null
    //   127: astore 9
    //   129: new 53	java/io/File
    //   132: dup
    //   133: aload_0
    //   134: invokevirtual 56	afeu:up	()Ljava/lang/String;
    //   137: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: astore 7
    //   142: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +47 -> 192
    //   148: ldc 104
    //   150: iconst_2
    //   151: new 22	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 515
    //   161: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   169: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 517
    //   175: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 7
    //   180: invokevirtual 451	java/io/File:exists	()Z
    //   183: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload 8
    //   194: astore 5
    //   196: aload 7
    //   198: invokevirtual 451	java/io/File:exists	()Z
    //   201: ifeq +90 -> 291
    //   204: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +33 -> 240
    //   210: ldc 104
    //   212: iconst_2
    //   213: new 22	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 519
    //   223: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 7
    //   228: invokevirtual 522	java/io/File:length	()J
    //   231: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   234: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload 7
    //   242: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   245: invokestatic 531	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   248: invokestatic 537	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull +735 -> 990
    //   258: aload_1
    //   259: getfield 540	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   262: ifnull +728 -> 990
    //   265: aload 4
    //   267: invokevirtual 543	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   270: aload_1
    //   271: getfield 540	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   274: invokevirtual 543	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   277: invokevirtual 546	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +710 -> 990
    //   283: aload 7
    //   285: astore 5
    //   287: aload 4
    //   289: astore 6
    //   291: new 53	java/io/File
    //   294: dup
    //   295: aload_0
    //   296: invokevirtual 549	afeu:uq	()Ljava/lang/String;
    //   299: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   302: astore 8
    //   304: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +47 -> 354
    //   310: ldc 104
    //   312: iconst_2
    //   313: new 22	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 551
    //   323: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 8
    //   328: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   331: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w 517
    //   337: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload 8
    //   342: invokevirtual 451	java/io/File:exists	()Z
    //   345: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   348: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 5
    //   356: ifnonnull +892 -> 1248
    //   359: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +33 -> 395
    //   365: ldc 104
    //   367: iconst_2
    //   368: new 22	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 553
    //   378: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 8
    //   383: invokevirtual 522	java/io/File:length	()J
    //   386: invokevirtual 525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: new 53	java/io/File
    //   398: dup
    //   399: new 22	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   406: getstatic 30	acbn:SDCARD_PATH	Ljava/lang/String;
    //   409: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: ldc_w 555
    //   415: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_0
    //   419: getfield 47	afeu:strResName	Ljava/lang/String;
    //   422: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   431: astore 4
    //   433: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +47 -> 483
    //   439: ldc 104
    //   441: iconst_2
    //   442: new 22	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 557
    //   452: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 4
    //   457: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   460: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc_w 517
    //   466: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 4
    //   471: invokevirtual 451	java/io/File:exists	()Z
    //   474: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   477: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: aload 8
    //   485: invokevirtual 451	java/io/File:exists	()Z
    //   488: ifne +51 -> 539
    //   491: aload 4
    //   493: invokevirtual 451	java/io/File:exists	()Z
    //   496: ifeq +43 -> 539
    //   499: aload 4
    //   501: aload 8
    //   503: invokestatic 563	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   506: istore_2
    //   507: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +29 -> 539
    //   513: ldc 104
    //   515: iconst_2
    //   516: new 22	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 565
    //   526: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload_2
    //   530: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload 4
    //   541: invokevirtual 451	java/io/File:exists	()Z
    //   544: ifeq +41 -> 585
    //   547: aload 4
    //   549: invokevirtual 63	java/io/File:delete	()Z
    //   552: istore_2
    //   553: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +29 -> 585
    //   559: ldc 104
    //   561: iconst_2
    //   562: new 22	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 567
    //   572: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload_2
    //   576: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: aload 8
    //   587: invokevirtual 451	java/io/File:exists	()Z
    //   590: ifeq +658 -> 1248
    //   593: aload 8
    //   595: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   598: invokestatic 531	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   601: invokestatic 537	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   604: astore 4
    //   606: aload 4
    //   608: ifnull +630 -> 1238
    //   611: aload_1
    //   612: getfield 540	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   615: ifnull +623 -> 1238
    //   618: aload 4
    //   620: invokevirtual 543	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   623: aload_1
    //   624: getfield 540	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   627: invokevirtual 543	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   630: invokevirtual 546	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   633: ifeq +605 -> 1238
    //   636: aload 8
    //   638: astore 4
    //   640: aload 4
    //   642: ifnonnull +959 -> 1601
    //   645: aload 10
    //   647: iconst_0
    //   648: putfield 82	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   651: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq +32 -> 686
    //   657: ldc 104
    //   659: iconst_2
    //   660: new 22	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 569
    //   670: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_0
    //   674: getfield 47	afeu:strResName	Ljava/lang/String;
    //   677: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aload 10
    //   688: iconst_1
    //   689: anewarray 84	java/lang/String
    //   692: dup
    //   693: iconst_0
    //   694: ldc 88
    //   696: aastore
    //   697: invokestatic 94	afel:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   700: iconst_0
    //   701: istore_3
    //   702: aload_0
    //   703: invokevirtual 571	afeu:aja	()Z
    //   706: ifne +549 -> 1255
    //   709: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +32 -> 744
    //   715: ldc 104
    //   717: iconst_2
    //   718: new 22	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 573
    //   728: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload_0
    //   732: getfield 47	afeu:strResName	Ljava/lang/String;
    //   735: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload 10
    //   746: aload_1
    //   747: invokevirtual 576	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   750: aload 10
    //   752: iconst_1
    //   753: putfield 79	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   756: aload 10
    //   758: iconst_0
    //   759: anewarray 84	java/lang/String
    //   762: invokestatic 94	afel:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   765: iload_3
    //   766: istore_2
    //   767: iload_2
    //   768: ifne -755 -> 13
    //   771: aload_0
    //   772: getfield 49	afeu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   775: bipush 77
    //   777: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   780: checkcast 133	afem
    //   783: aload 10
    //   785: invokevirtual 136	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   788: invokevirtual 578	afem:HM	(Ljava/lang/String;)V
    //   791: aload_0
    //   792: aload 10
    //   794: invokevirtual 580	afeu:g	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   797: return
    //   798: astore 4
    //   800: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   803: ifeq +32 -> 835
    //   806: ldc 104
    //   808: iconst_2
    //   809: iconst_2
    //   810: anewarray 4	java/lang/Object
    //   813: dup
    //   814: iconst_0
    //   815: ldc_w 582
    //   818: aastore
    //   819: dup
    //   820: iconst_1
    //   821: aload 4
    //   823: invokevirtual 585	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   826: aastore
    //   827: invokestatic 588	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   830: aload 4
    //   832: invokevirtual 591	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   835: aload 7
    //   837: invokestatic 597	aszr:getFileMD5String	(Ljava/io/File;)Ljava/lang/String;
    //   840: astore 4
    //   842: goto -589 -> 253
    //   845: astore 4
    //   847: aload 9
    //   849: astore 4
    //   851: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   854: ifeq -601 -> 253
    //   857: ldc 104
    //   859: iconst_2
    //   860: new 22	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   867: ldc_w 599
    //   870: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 7
    //   875: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   878: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: aload 9
    //   889: astore 4
    //   891: goto -638 -> 253
    //   894: astore 4
    //   896: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   899: ifeq +32 -> 931
    //   902: ldc 104
    //   904: iconst_2
    //   905: iconst_2
    //   906: anewarray 4	java/lang/Object
    //   909: dup
    //   910: iconst_0
    //   911: ldc_w 601
    //   914: aastore
    //   915: dup
    //   916: iconst_1
    //   917: aload 4
    //   919: invokevirtual 602	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   922: aastore
    //   923: invokestatic 588	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   926: aload 4
    //   928: invokevirtual 603	java/lang/OutOfMemoryError:printStackTrace	()V
    //   931: aload 7
    //   933: invokestatic 597	aszr:getFileMD5String	(Ljava/io/File;)Ljava/lang/String;
    //   936: astore 4
    //   938: goto -685 -> 253
    //   941: astore 4
    //   943: aload 9
    //   945: astore 4
    //   947: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   950: ifeq -697 -> 253
    //   953: ldc 104
    //   955: iconst_2
    //   956: new 22	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   963: ldc_w 599
    //   966: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: aload 7
    //   971: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   974: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   983: aload 9
    //   985: astore 4
    //   987: goto -734 -> 253
    //   990: aload 7
    //   992: invokevirtual 63	java/io/File:delete	()Z
    //   995: pop
    //   996: aload_0
    //   997: invokevirtual 605	afeu:cYL	()V
    //   1000: aload 4
    //   1002: astore 6
    //   1004: aload 8
    //   1006: astore 5
    //   1008: goto -717 -> 291
    //   1011: astore 4
    //   1013: ldc 104
    //   1015: iconst_1
    //   1016: new 22	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1023: ldc_w 607
    //   1026: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload 4
    //   1031: invokevirtual 608	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1034: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: goto -458 -> 585
    //   1046: astore 4
    //   1048: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1051: ifeq +32 -> 1083
    //   1054: ldc 104
    //   1056: iconst_2
    //   1057: iconst_2
    //   1058: anewarray 4	java/lang/Object
    //   1061: dup
    //   1062: iconst_0
    //   1063: ldc_w 610
    //   1066: aastore
    //   1067: dup
    //   1068: iconst_1
    //   1069: aload 4
    //   1071: invokevirtual 585	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   1074: aastore
    //   1075: invokestatic 588	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1078: aload 4
    //   1080: invokevirtual 591	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   1083: aload 8
    //   1085: invokestatic 597	aszr:getFileMD5String	(Ljava/io/File;)Ljava/lang/String;
    //   1088: astore 4
    //   1090: goto -484 -> 606
    //   1093: astore 4
    //   1095: aload 6
    //   1097: astore 4
    //   1099: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1102: ifeq -496 -> 606
    //   1105: ldc 104
    //   1107: iconst_2
    //   1108: new 22	java/lang/StringBuilder
    //   1111: dup
    //   1112: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1115: ldc_w 599
    //   1118: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload 8
    //   1123: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1126: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: aload 6
    //   1137: astore 4
    //   1139: goto -533 -> 606
    //   1142: astore 4
    //   1144: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1147: ifeq +32 -> 1179
    //   1150: ldc 104
    //   1152: iconst_2
    //   1153: iconst_2
    //   1154: anewarray 4	java/lang/Object
    //   1157: dup
    //   1158: iconst_0
    //   1159: ldc_w 612
    //   1162: aastore
    //   1163: dup
    //   1164: iconst_1
    //   1165: aload 4
    //   1167: invokevirtual 602	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1170: aastore
    //   1171: invokestatic 588	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1174: aload 4
    //   1176: invokevirtual 603	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1179: aload 8
    //   1181: invokestatic 597	aszr:getFileMD5String	(Ljava/io/File;)Ljava/lang/String;
    //   1184: astore 4
    //   1186: goto -580 -> 606
    //   1189: astore 4
    //   1191: aload 6
    //   1193: astore 4
    //   1195: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1198: ifeq -592 -> 606
    //   1201: ldc 104
    //   1203: iconst_2
    //   1204: new 22	java/lang/StringBuilder
    //   1207: dup
    //   1208: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1211: ldc_w 599
    //   1214: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: aload 8
    //   1219: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1222: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokestatic 475	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1231: aload 6
    //   1233: astore 4
    //   1235: goto -629 -> 606
    //   1238: aload 8
    //   1240: invokevirtual 63	java/io/File:delete	()Z
    //   1243: pop
    //   1244: aload_0
    //   1245: invokevirtual 605	afeu:cYL	()V
    //   1248: aload 5
    //   1250: astore 4
    //   1252: goto -612 -> 640
    //   1255: iload_3
    //   1256: istore_2
    //   1257: aload_1
    //   1258: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1261: aload 10
    //   1263: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1266: if_icmplt -499 -> 767
    //   1269: aload_1
    //   1270: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1273: aload 10
    //   1275: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1278: if_icmpne +185 -> 1463
    //   1281: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1284: ifeq +46 -> 1330
    //   1287: ldc 104
    //   1289: iconst_2
    //   1290: new 22	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1297: ldc_w 614
    //   1300: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: aload 10
    //   1305: getfield 79	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1308: invokevirtual 316	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1311: ldc_w 616
    //   1314: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload_0
    //   1318: getfield 47	afeu:strResName	Ljava/lang/String;
    //   1321: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1330: iload_3
    //   1331: istore_2
    //   1332: aload 10
    //   1334: getfield 79	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1337: iconst_1
    //   1338: if_icmpeq -571 -> 767
    //   1341: aload 10
    //   1343: aload_1
    //   1344: invokevirtual 576	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1347: aload 10
    //   1349: iconst_0
    //   1350: anewarray 84	java/lang/String
    //   1353: invokestatic 94	afel:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1356: aload_0
    //   1357: getfield 49	afeu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1360: bipush 77
    //   1362: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1365: checkcast 133	afem
    //   1368: astore_1
    //   1369: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1372: ifeq +60 -> 1432
    //   1375: ldc 104
    //   1377: iconst_2
    //   1378: new 22	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1385: ldc_w 618
    //   1388: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload 10
    //   1393: getfield 97	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1396: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1399: ldc_w 620
    //   1402: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: aload 10
    //   1407: getfield 623	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1410: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1413: ldc_w 625
    //   1416: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: aload_1
    //   1420: invokevirtual 628	afem:aiU	()Z
    //   1423: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1426: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1429: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1432: aload 10
    //   1434: getfield 97	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1437: ifne +18 -> 1455
    //   1440: aload 10
    //   1442: getfield 623	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1445: ifeq +10 -> 1455
    //   1448: aload_1
    //   1449: invokevirtual 628	afem:aiU	()Z
    //   1452: ifne +719 -> 2171
    //   1455: aload_0
    //   1456: invokevirtual 630	afeu:aiY	()Z
    //   1459: istore_2
    //   1460: goto -693 -> 767
    //   1463: iload_3
    //   1464: istore_2
    //   1465: aload_1
    //   1466: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1469: aload 10
    //   1471: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1474: if_icmple -707 -> 767
    //   1477: aload 10
    //   1479: aload_1
    //   1480: invokevirtual 576	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1483: aload 10
    //   1485: iconst_0
    //   1486: anewarray 84	java/lang/String
    //   1489: invokestatic 94	afel:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1492: aload_0
    //   1493: getfield 49	afeu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1496: bipush 77
    //   1498: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1501: checkcast 133	afem
    //   1504: astore_1
    //   1505: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1508: ifeq +60 -> 1568
    //   1511: ldc 104
    //   1513: iconst_2
    //   1514: new 22	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1521: ldc_w 632
    //   1524: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1527: aload 10
    //   1529: getfield 97	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1532: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1535: ldc_w 620
    //   1538: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: aload 10
    //   1543: getfield 623	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1546: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1549: ldc_w 625
    //   1552: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: aload_1
    //   1556: invokevirtual 628	afem:aiU	()Z
    //   1559: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1562: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1565: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1568: aload 10
    //   1570: getfield 97	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   1573: ifne +20 -> 1593
    //   1576: aload 10
    //   1578: getfield 623	com/tencent/mobileqq/earlydownload/xmldata/XmlData:notPreDownloadInLowEndPhone	Z
    //   1581: ifeq +12 -> 1593
    //   1584: iload_3
    //   1585: istore_2
    //   1586: aload_1
    //   1587: invokevirtual 628	afem:aiU	()Z
    //   1590: ifne -823 -> 767
    //   1593: aload_0
    //   1594: invokevirtual 630	afeu:aiY	()Z
    //   1597: istore_2
    //   1598: goto -831 -> 767
    //   1601: aload 10
    //   1603: aload_1
    //   1604: invokevirtual 576	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1607: aload 10
    //   1609: aload_1
    //   1610: getfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1613: putfield 72	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1616: aload 10
    //   1618: iconst_1
    //   1619: putfield 79	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1622: aload 10
    //   1624: iconst_1
    //   1625: putfield 82	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1628: aload 10
    //   1630: iconst_1
    //   1631: anewarray 84	java/lang/String
    //   1634: dup
    //   1635: iconst_0
    //   1636: ldc 88
    //   1638: aastore
    //   1639: invokestatic 94	afel:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1642: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1645: ifeq +32 -> 1677
    //   1648: ldc 104
    //   1650: iconst_2
    //   1651: new 22	java/lang/StringBuilder
    //   1654: dup
    //   1655: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1658: ldc_w 634
    //   1661: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: aload_0
    //   1665: getfield 47	afeu:strResName	Ljava/lang/String;
    //   1668: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1677: aload 7
    //   1679: invokevirtual 451	java/io/File:exists	()Z
    //   1682: ifne +74 -> 1756
    //   1685: aload_0
    //   1686: invokevirtual 232	afeu:aiV	()Z
    //   1689: ifne +67 -> 1756
    //   1692: aload 4
    //   1694: aload 7
    //   1696: invokestatic 563	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   1699: pop
    //   1700: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1703: ifeq +53 -> 1756
    //   1706: ldc 104
    //   1708: iconst_2
    //   1709: new 22	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1716: ldc_w 636
    //   1719: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: aload 4
    //   1724: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1727: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1730: ldc_w 638
    //   1733: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1736: aload 7
    //   1738: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1741: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: ldc_w 640
    //   1747: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1756: aload 10
    //   1758: iconst_0
    //   1759: anewarray 84	java/lang/String
    //   1762: invokestatic 94	afel:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1765: aload_0
    //   1766: aload 4
    //   1768: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1771: invokevirtual 344	afeu:HO	(Ljava/lang/String;)V
    //   1774: aload_0
    //   1775: getfield 49	afeu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1778: bipush 77
    //   1780: invokevirtual 131	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1783: checkcast 133	afem
    //   1786: aload 10
    //   1788: invokevirtual 136	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   1791: invokevirtual 578	afem:HM	(Ljava/lang/String;)V
    //   1794: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1797: ifeq +53 -> 1850
    //   1800: ldc 104
    //   1802: iconst_2
    //   1803: new 22	java/lang/StringBuilder
    //   1806: dup
    //   1807: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1810: ldc_w 642
    //   1813: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: aload 10
    //   1818: getfield 109	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1821: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: ldc_w 644
    //   1827: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1830: aload 4
    //   1832: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1835: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: ldc_w 640
    //   1841: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1847: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1850: aload_0
    //   1851: getfield 161	afeu:bXO	Z
    //   1854: ifeq +141 -> 1995
    //   1857: new 120	android/content/Intent
    //   1860: dup
    //   1861: ldc_w 358
    //   1864: invokespecial 359	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1867: astore 5
    //   1869: aload 5
    //   1871: ldc 168
    //   1873: aload_0
    //   1874: getfield 47	afeu:strResName	Ljava/lang/String;
    //   1877: invokevirtual 171	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1880: pop
    //   1881: aload 5
    //   1883: ldc 173
    //   1885: aload 10
    //   1887: getfield 175	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1890: invokevirtual 171	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1893: pop
    //   1894: aload 5
    //   1896: ldc 86
    //   1898: iconst_1
    //   1899: invokevirtual 364	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1902: pop
    //   1903: aload 5
    //   1905: ldc_w 366
    //   1908: aload 10
    //   1910: getfield 368	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1913: invokevirtual 371	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1916: pop
    //   1917: aload 5
    //   1919: ldc_w 372
    //   1922: aload 10
    //   1924: getfield 352	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   1927: invokevirtual 371	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1930: pop
    //   1931: aload 5
    //   1933: ldc_w 376
    //   1936: aload 4
    //   1938: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1941: invokevirtual 171	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1944: pop
    //   1945: invokestatic 181	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1948: aload 5
    //   1950: ldc 183
    //   1952: invokevirtual 189	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1955: aload_0
    //   1956: iconst_0
    //   1957: putfield 161	afeu:bXO	Z
    //   1960: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1963: ifeq +32 -> 1995
    //   1966: ldc 104
    //   1968: iconst_2
    //   1969: new 22	java/lang/StringBuilder
    //   1972: dup
    //   1973: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1976: ldc_w 646
    //   1979: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: aload_0
    //   1983: getfield 47	afeu:strResName	Ljava/lang/String;
    //   1986: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1992: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1995: new 239	java/util/HashMap
    //   1998: dup
    //   1999: invokespecial 240	java/util/HashMap:<init>	()V
    //   2002: astore 5
    //   2004: aload 5
    //   2006: ldc_w 648
    //   2009: aload 10
    //   2011: getfield 175	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   2014: invokevirtual 246	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2017: pop
    //   2018: aload 5
    //   2020: ldc_w 650
    //   2023: getstatic 656	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2026: invokevirtual 657	java/lang/Boolean:toString	()Ljava/lang/String;
    //   2029: invokevirtual 246	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2032: pop
    //   2033: aload_0
    //   2034: invokevirtual 660	afeu:un	()Ljava/lang/String;
    //   2037: astore 6
    //   2039: aload 6
    //   2041: ifnull +43 -> 2084
    //   2044: aload 6
    //   2046: invokevirtual 662	java/lang/String:length	()I
    //   2049: ifle +35 -> 2084
    //   2052: invokestatic 181	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2055: invokestatic 251	anpc:a	(Landroid/content/Context;)Lanpc;
    //   2058: aload_0
    //   2059: getfield 49	afeu:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2062: invokevirtual 254	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2065: aload 6
    //   2067: iconst_1
    //   2068: ldc2_w 663
    //   2071: aload 7
    //   2073: invokevirtual 522	java/io/File:length	()J
    //   2076: aload 5
    //   2078: ldc_w 258
    //   2081: invokevirtual 262	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2084: aload 8
    //   2086: invokevirtual 451	java/io/File:exists	()Z
    //   2089: ifne -2076 -> 13
    //   2092: aload_1
    //   2093: getfield 667	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   2096: ifeq -2083 -> 13
    //   2099: aload 4
    //   2101: aload 8
    //   2103: invokestatic 563	aqhq:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   2106: pop
    //   2107: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2110: ifeq -2097 -> 13
    //   2113: ldc 104
    //   2115: iconst_2
    //   2116: new 22	java/lang/StringBuilder
    //   2119: dup
    //   2120: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   2123: ldc_w 636
    //   2126: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: aload 4
    //   2131: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2134: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2137: ldc_w 638
    //   2140: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: aload 8
    //   2145: invokevirtual 488	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2148: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2151: ldc_w 640
    //   2154: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2160: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2163: return
    //   2164: astore_1
    //   2165: return
    //   2166: astore 5
    //   2168: goto -412 -> 1756
    //   2171: iconst_0
    //   2172: istore_2
    //   2173: goto -713 -> 1460
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2176	0	this	afeu
    //   0	2176	1	paramXmlData	XmlData
    //   506	1667	2	bool1	boolean
    //   701	884	3	bool2	boolean
    //   251	390	4	localObject1	Object
    //   798	33	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   840	1	4	str1	String
    //   845	1	4	localException1	Exception
    //   849	41	4	localObject2	Object
    //   894	33	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   936	1	4	str2	String
    //   941	1	4	localException2	Exception
    //   945	56	4	localObject3	Object
    //   1011	19	4	localThrowable	java.lang.Throwable
    //   1046	33	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   1088	1	4	str3	String
    //   1093	1	4	localException3	Exception
    //   1097	41	4	localObject4	Object
    //   1142	33	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1184	1	4	str4	String
    //   1189	1	4	localException4	Exception
    //   1193	937	4	localObject5	Object
    //   194	1883	5	localObject6	Object
    //   2166	1	5	localException5	Exception
    //   124	1942	6	localObject7	Object
    //   140	1932	7	localFile1	File
    //   121	2023	8	localFile2	File
    //   127	857	9	localObject8	Object
    //   18	1992	10	localXmlData	XmlData
    // Exception table:
    //   from	to	target	type
    //   240	253	798	java/lang/UnsatisfiedLinkError
    //   835	842	845	java/lang/Exception
    //   240	253	894	java/lang/OutOfMemoryError
    //   931	938	941	java/lang/Exception
    //   395	483	1011	java/lang/Throwable
    //   483	539	1011	java/lang/Throwable
    //   539	585	1011	java/lang/Throwable
    //   593	606	1046	java/lang/UnsatisfiedLinkError
    //   1083	1090	1093	java/lang/Exception
    //   593	606	1142	java/lang/OutOfMemoryError
    //   1179	1186	1189	java/lang/Exception
    //   2099	2163	2164	java/lang/Exception
    //   1692	1756	2166	java/lang/Exception
  }
  
  public void freeResource()
  {
    String str = up();
    try
    {
      new File(str).delete();
      label17:
      afel.c(b());
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public abstract Class<? extends XmlData> g();
  
  public GetResourceReqInfo g()
  {
    Object localObject = null;
    XmlData localXmlData = b();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = localXmlData.strPkgName;
      ((GetResourceReqInfo)localObject).uiCurVer = getVersion();
      ((GetResourceReqInfo)localObject).sResType = 512;
      ((GetResourceReqInfo)localObject).sLanType = 1;
      ((GetResourceReqInfo)localObject).sReqType = 1;
    }
    while (!QLog.isColorLevel()) {
      return localObject;
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public void g(XmlData paramXmlData) {}
  
  public abstract int getBusinessId();
  
  public int getVersion()
  {
    int i = 0;
    XmlData localXmlData = b();
    if (localXmlData != null) {
      i = localXmlData.Version;
    }
    return i;
  }
  
  public boolean isSuccess()
  {
    XmlData localXmlData = b();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
  
  public boolean isTimeValid()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    XmlData localXmlData = b();
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      boolean bool1;
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool3;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool3;
          if (localXmlData.tLoadFail + 43200000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isTimeValid() " + bool1 + " res=" + localXmlData.strResName + " tLoadFail=" + localXmlData.tLoadFail);
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() = false,  data = null");
    }
    return bool2;
  }
  
  public abstract String un();
  
  public abstract String uo();
  
  public String up()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd/early");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.strResName;
  }
  
  public String uq()
  {
    String str = aqul.getSDKPrivatePath(bvQ);
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath() + File.separator + this.strResName;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyHandler", 2, "getBackupPath ,SDCARD_DIR = " + bvQ + ",vfsDir = " + str + ",filepath = " + (String)localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afeu
 * JD-Core Version:    0.7.0.1
 */