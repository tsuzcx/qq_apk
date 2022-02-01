package com.tencent.mobileqq.troop.utils;

import acbn;
import accc;
import aghw;
import agib;
import agkf;
import agkw;
import aglf;
import agoy;
import agtf;
import ahav;
import ahbj;
import ahbm;
import ahbr;
import anaz;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import apbr;
import apcy;
import apdz;
import apef;
import apef.b;
import aprk;
import apsd;
import apsd.a;
import apsf;
import apsm;
import apsn;
import apso;
import apsp;
import apsq;
import apsr;
import apss;
import apst;
import apsv;
import apue;
import aqgv;
import aqhq;
import aqhs;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.ProxyIpManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import smq;
import smq.h;
import smq.l;
import smq.m;
import smq.n;
import smq.o;
import smq.q;

public class TroopFileTransferManager
  implements INetInfoHandler
{
  private static Map<Long, TroopFileTransferManager> nN;
  private ProxyIpManager jdField_a_of_type_MqqManagerProxyIpManager;
  private smq.l jdField_a_of_type_Smq$l = new apsn(this);
  private smq.m jdField_a_of_type_Smq$m = new apss(this);
  private smq.n jdField_a_of_type_Smq$n = new apsq(this);
  private smq.o jdField_a_of_type_Smq$o = new apso(this);
  private smq.q jdField_a_of_type_Smq$q = new apsp(this);
  public c[] a;
  protected long arV;
  protected long arW;
  protected long arX;
  protected long arY;
  private volatile long arZ;
  protected long are;
  private smq.h jdField_b_of_type_Smq$h = new apsr(this);
  private smq.l jdField_b_of_type_Smq$l = new apsm(this);
  protected boolean cvp;
  private apsf d;
  public QQAppInterface mApp;
  public long mTroopUin;
  public Map<UUID, Item> nC;
  public Map<UUID, Integer> nF;
  
  static
  {
    if (!TroopFileTransferManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TroopFileTransferManager()
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c = new c[] { new c(1), new c(1), new c(2), new c(2), new c(2) };
  }
  
  public static TroopFileTransferManager a(long paramLong)
  {
    try
    {
      TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)nN.get(Long.valueOf(paramLong));
      return localTroopFileTransferManager;
    }
    finally {}
  }
  
  public static TroopFileTransferManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if (nN == null)
      {
        nN = new HashMap();
        ThreadManager.post(new TroopFileTransferManager.1(), 2, null, true);
      }
      apst.a(paramQQAppInterface);
      Object localObject2 = (TroopFileTransferManager)nN.get(Long.valueOf(paramLong));
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((TroopFileTransferManager)localObject2).mApp != paramQQAppInterface)
        {
          ((TroopFileTransferManager)localObject2).release();
          localObject1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new apdz(paramQQAppInterface, paramLong);
        ((TroopFileTransferManager)localObject2).init();
        ThreadManager.post(new TroopFileTransferManager.2((TroopFileTransferManager)localObject2), 8, null, true);
        nN.put(Long.valueOf(paramLong), localObject2);
      }
      return localObject2;
    }
    finally {}
  }
  
  private void av(int paramInt, long paramLong)
  {
    try
    {
      if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
      {
        if (paramInt == 0) {
          this.arW += paramLong;
        }
        for (;;)
        {
          return;
          if (paramInt == 1) {
            this.arV += paramLong;
          }
        }
      }
      if (paramInt != 0) {
        break label75;
      }
    }
    finally {}
    this.arY += paramLong;
    for (;;)
    {
      ebG();
      break;
      label75:
      if (paramInt == 1) {
        this.arX += paramLong;
      }
    }
  }
  
  private void b(Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem == null) {
      return;
    }
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
    case 6: 
      apsv.a(this.mApp, "upload", true, paramItem.transferBeginTime, paramItem.UploadIp, this.mTroopUin + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 10: 
      apsv.a(this.mApp, "download", false, paramItem.transferBeginTime, paramItem.DownloadIp, this.mTroopUin + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 9: 
    case 11: 
      apsv.a(this.mApp, "download", true, paramItem.transferBeginTime, paramItem.DownloadIp, this.mTroopUin + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    }
    apsv.a(this.mApp, "upload", false, paramItem.transferBeginTime, paramItem.UploadIp, this.mTroopUin + "", ahbj.getExtension(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
  }
  
  private final void d(Item paramItem, int paramInt)
  {
    apsd.a(this.mApp, this.mTroopUin, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  public static void ebE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileTransferManager", 2, "TroopFileTransferManager.ReleaseAll called!");
    }
    try
    {
      if (nN == null) {
        return;
      }
      Iterator localIterator = nN.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).release();
      }
      nN.clear();
    }
    finally {}
  }
  
  public static void ebI()
  {
    try
    {
      Iterator localIterator = nN.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).ebJ();
      }
    }
    finally {}
  }
  
  private final void g(Item paramItem)
  {
    paramItem.ErrorCode = 0;
    c(paramItem, 12);
  }
  
  public static void lS(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = nN.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        if (localTroopFileTransferManager.mTroopUin == paramLong) {
          localTroopFileTransferManager.dYQ();
        } else {
          localTroopFileTransferManager.ebJ();
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final apcy a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lapsf;
    //   6: aload_1
    //   7: getfield 355	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileName	Ljava/lang/String;
    //   10: aload_1
    //   11: getfield 358	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   14: bipush 102
    //   16: invokevirtual 363	apsf:a	(Ljava/lang/String;JI)Lapbr;
    //   19: astore 6
    //   21: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +34 -> 58
    //   27: ldc_w 305
    //   30: iconst_2
    //   31: new 232	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 365
    //   41: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload 6
    //   46: invokevirtual 368	apbr:toString	()Ljava/lang/String;
    //   49: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload 6
    //   60: ifnonnull +9 -> 69
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:dYP	()V
    //   73: new 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   76: dup
    //   77: aload 6
    //   79: invokespecial 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   82: astore 6
    //   84: aload_0
    //   85: aload 6
    //   87: invokevirtual 376	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   90: aload 6
    //   92: iload_3
    //   93: putfield 379	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   96: aload 6
    //   98: lload 4
    //   100: putfield 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   103: aload 6
    //   105: iload_2
    //   106: putfield 385	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   109: aload 6
    //   111: iconst_4
    //   112: putfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   115: aload 6
    //   117: aload_1
    //   118: invokevirtual 388	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   121: putfield 391	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   124: aload 6
    //   126: aload_1
    //   127: getfield 394	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   130: putfield 397	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:entrySessionID	J
    //   133: aload_1
    //   134: ifnull +21 -> 155
    //   137: aload 6
    //   139: aload_1
    //   140: getfield 400	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   143: putfield 403	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   146: aload 6
    //   148: aload_1
    //   149: getfield 406	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   152: putfield 409	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   155: aload_0
    //   156: aload 6
    //   158: iconst_4
    //   159: iconst_0
    //   160: invokevirtual 411	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   163: aload 6
    //   165: aload_0
    //   166: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   169: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   172: astore_1
    //   173: goto -108 -> 65
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	TroopFileTransferManager
    //   0	181	1	paramFileManagerEntity	FileManagerEntity
    //   0	181	2	paramInt1	int
    //   0	181	3	paramInt2	int
    //   0	181	4	paramLong	long
    //   19	145	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	58	176	finally
    //   69	133	176	finally
    //   137	155	176	finally
    //   155	173	176	finally
  }
  
  public final apcy a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        dYP();
        str = apef.oD(paramString);
        if (str == null) {
          break label120;
        }
        if (str.length() != 0) {
          break label117;
        }
      }
      finally {}
      Iterator localIterator = this.nC.values().iterator();
      if (localIterator.hasNext())
      {
        Item localItem = (Item)localIterator.next();
        if ((!paramString.equals(localItem.FilePath)) && (!str.equals(localItem.FilePath))) {
          continue;
        }
        paramString = localItem.getInfo(this.mTroopUin);
        break;
      }
      paramString = null;
      break;
      label117:
      continue;
      label120:
      String str = "0";
    }
  }
  
  public apcy a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
  }
  
  /* Error */
  public apcy a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lapsf;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 7
    //   13: aload_1
    //   14: aload_2
    //   15: lload_3
    //   16: iload 5
    //   18: invokevirtual 465	apsf:a	(Ljava/lang/String;Ljava/lang/String;JI)Lapbr;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 7
    //   32: monitorexit
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +34 -> 72
    //   41: ldc_w 305
    //   44: iconst_2
    //   45: new 232	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 467
    //   55: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 8
    //   60: invokevirtual 368	apbr:toString	()Ljava/lang/String;
    //   63: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:dYP	()V
    //   76: aload_0
    //   77: getfield 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
    //   80: aload 8
    //   82: getfield 471	apbr:Id	Ljava/util/UUID;
    //   85: invokeinterface 141 2 0
    //   90: checkcast 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   93: astore 6
    //   95: aload 6
    //   97: ifnonnull +162 -> 259
    //   100: new 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   103: dup
    //   104: aload 8
    //   106: invokespecial 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   109: astore_1
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual 376	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   115: aload_1
    //   116: aload_2
    //   117: putfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   120: aload_1
    //   121: lload_3
    //   122: putfield 266	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   125: aload_1
    //   126: lconst_0
    //   127: putfield 474	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   130: aload_2
    //   131: invokestatic 257	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_2
    //   135: aload_1
    //   136: getfield 251	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   139: invokestatic 480	ahav:getFileType	(Ljava/lang/String;)I
    //   142: iconst_2
    //   143: if_icmpne +184 -> 327
    //   146: aload_0
    //   147: getfield 161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   150: invokestatic 486	ahbr:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   153: ifeq +174 -> 327
    //   156: aload_1
    //   157: aload_0
    //   158: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   161: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   164: astore 6
    //   166: new 488	agtf
    //   169: dup
    //   170: aload_0
    //   171: getfield 161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: aload 6
    //   176: invokespecial 491	agtf:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lapcy;)V
    //   179: invokestatic 496	agkw:a	(Lagsw;)Laglf;
    //   182: invokeinterface 501 1 0
    //   187: pop
    //   188: aload_0
    //   189: getfield 161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   192: ldc_w 503
    //   195: ldc 241
    //   197: ldc 241
    //   199: ldc_w 505
    //   202: ldc_w 507
    //   205: iconst_0
    //   206: iconst_0
    //   207: ldc 241
    //   209: new 232	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   216: aload_0
    //   217: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   220: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: ldc 241
    //   225: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: aload_2
    //   232: ldc 241
    //   234: invokestatic 512	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_1
    //   238: aload_0
    //   239: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   242: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   245: astore_1
    //   246: aload_0
    //   247: monitorexit
    //   248: aload 7
    //   250: monitorexit
    //   251: aload_1
    //   252: areturn
    //   253: astore_1
    //   254: aload 7
    //   256: monitorexit
    //   257: aload_1
    //   258: athrow
    //   259: aload 6
    //   261: astore_1
    //   262: aload 6
    //   264: getfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   267: bipush 7
    //   269: if_icmpeq -154 -> 115
    //   272: aload 6
    //   274: getfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   277: bipush 11
    //   279: if_icmpne +17 -> 296
    //   282: aload 6
    //   284: astore_1
    //   285: aload 8
    //   287: getfield 513	apbr:LocalFile	Ljava/lang/String;
    //   290: invokestatic 519	aqhq:fileExists	(Ljava/lang/String;)Z
    //   293: ifeq -178 -> 115
    //   296: aload 6
    //   298: getfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   301: bipush 6
    //   303: if_icmpne +17 -> 320
    //   306: aload 6
    //   308: astore_1
    //   309: aload 8
    //   311: getfield 513	apbr:LocalFile	Ljava/lang/String;
    //   314: invokestatic 519	aqhq:fileExists	(Ljava/lang/String;)Z
    //   317: ifeq -202 -> 115
    //   320: aload_0
    //   321: monitorexit
    //   322: aload 7
    //   324: monitorexit
    //   325: aconst_null
    //   326: areturn
    //   327: aload_0
    //   328: aload_1
    //   329: iconst_0
    //   330: iconst_0
    //   331: invokevirtual 522	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IZ)V
    //   334: goto -146 -> 188
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	TroopFileTransferManager
    //   0	342	1	paramString1	String
    //   0	342	2	paramString2	String
    //   0	342	3	paramLong	long
    //   0	342	5	paramInt	int
    //   93	214	6	localObject	Object
    //   4	319	7	localapsf	apsf
    //   21	289	8	localapbr	apbr
    // Exception table:
    //   from	to	target	type
    //   9	11	253	finally
    //   30	33	253	finally
    //   248	251	253	finally
    //   254	257	253	finally
    //   322	325	253	finally
    //   340	342	253	finally
    //   11	23	337	finally
    //   28	30	337	finally
    //   35	72	337	finally
    //   72	95	337	finally
    //   100	115	337	finally
    //   115	188	337	finally
    //   188	248	337	finally
    //   262	282	337	finally
    //   285	296	337	finally
    //   296	306	337	finally
    //   309	320	337	finally
    //   320	322	337	finally
    //   327	334	337	finally
    //   338	340	337	finally
  }
  
  /* Error */
  public final apcy a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lapsf;
    //   6: aload_1
    //   7: aload_2
    //   8: lload 4
    //   10: bipush 102
    //   12: invokevirtual 525	apsf:c	(Ljava/lang/String;Ljava/lang/String;JI)Lapbr;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:dYP	()V
    //   30: new 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   38: astore_1
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 376	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   44: aload_1
    //   45: iload 7
    //   47: putfield 379	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   50: aload_1
    //   51: lload 8
    //   53: putfield 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   56: aload_1
    //   57: iload 6
    //   59: putfield 385	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   62: aload_1
    //   63: iconst_4
    //   64: putfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   67: aload_1
    //   68: aload_3
    //   69: putfield 391	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   72: aload_0
    //   73: aload_1
    //   74: iconst_4
    //   75: iconst_0
    //   76: invokevirtual 411	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   79: aload_1
    //   80: aload_0
    //   81: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   84: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   87: astore_1
    //   88: goto -66 -> 22
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	TroopFileTransferManager
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   0	96	3	paramString3	String
    //   0	96	4	paramLong1	long
    //   0	96	6	paramInt1	int
    //   0	96	7	paramInt2	int
    //   0	96	8	paramLong2	long
    // Exception table:
    //   from	to	target	type
    //   2	16	91	finally
    //   26	88	91	finally
  }
  
  /* Error */
  public final apcy a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, FileManagerEntity paramFileManagerEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 350	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lapsf;
    //   6: aload_2
    //   7: lload 4
    //   9: bipush 102
    //   11: invokevirtual 363	apsf:a	(Ljava/lang/String;JI)Lapbr;
    //   14: astore_1
    //   15: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +33 -> 51
    //   21: ldc_w 305
    //   24: iconst_2
    //   25: new 232	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 528
    //   35: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 368	apbr:toString	()Ljava/lang/String;
    //   42: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_1
    //   52: ifnonnull +9 -> 61
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: aload_0
    //   62: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:dYP	()V
    //   65: new 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   73: astore_1
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 376	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   79: aload_1
    //   80: iload 7
    //   82: putfield 379	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   85: aload_1
    //   86: lload 8
    //   88: putfield 382	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   91: aload_1
    //   92: iload 6
    //   94: putfield 385	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   97: aload_1
    //   98: iconst_4
    //   99: putfield 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   102: aload_1
    //   103: aload_3
    //   104: putfield 391	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   107: aload_1
    //   108: lload 10
    //   110: putfield 397	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:entrySessionID	J
    //   113: aload 12
    //   115: ifnull +48 -> 163
    //   118: aload_1
    //   119: aload 12
    //   121: getfield 400	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   124: putfield 403	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   127: aload_1
    //   128: aload 12
    //   130: getfield 406	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   133: putfield 409	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   136: aload_1
    //   137: aload 12
    //   139: getfield 531	com/tencent/mobileqq/filemanager/data/FileManagerEntity:yybApkPackageName	Ljava/lang/String;
    //   142: putfield 532	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkPackageName	Ljava/lang/String;
    //   145: aload_1
    //   146: aload 12
    //   148: getfield 535	com/tencent/mobileqq/filemanager/data/FileManagerEntity:yybApkName	Ljava/lang/String;
    //   151: putfield 536	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkName	Ljava/lang/String;
    //   154: aload_1
    //   155: aload 12
    //   157: getfield 539	com/tencent/mobileqq/filemanager/data/FileManagerEntity:yybApkIconUrl	Ljava/lang/String;
    //   160: putfield 540	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:yybApkIconUrl	Ljava/lang/String;
    //   163: aload_0
    //   164: aload_1
    //   165: iconst_4
    //   166: iconst_0
    //   167: invokevirtual 411	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   170: aload_1
    //   171: aload_0
    //   172: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   175: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   178: astore_1
    //   179: goto -122 -> 57
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	TroopFileTransferManager
    //   0	187	1	paramString1	String
    //   0	187	2	paramString2	String
    //   0	187	3	paramString3	String
    //   0	187	4	paramLong1	long
    //   0	187	6	paramInt1	int
    //   0	187	7	paramInt2	int
    //   0	187	8	paramLong2	long
    //   0	187	10	paramLong3	long
    //   0	187	12	paramFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	51	182	finally
    //   61	113	182	finally
    //   118	163	182	finally
    //   163	179	182	finally
  }
  
  public apcy a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      paramString = ???.b(paramString);
      if (paramString == null) {
        return null;
      }
      dYP();
      paramString = new Item(paramString);
      a(paramString);
      paramString.BusId = 102;
      paramString.isFromAIO = paramBoolean;
      paramString.RandomNum = paramInt;
      if (aqiw.getSystemNetwork(BaseApplication.getContext()) == 0)
      {
        a(paramString, 3, 106);
        paramString = paramString.getInfo(this.mTroopUin);
        return paramString;
        paramString = finally;
        throw paramString;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[0].a(new TaskScan(paramString));
      paramString = paramString.getInfo(this.mTroopUin);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final apcy a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:dYP	()V
    //   6: aload_0
    //   7: getfield 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 141 2 0
    //   16: checkcast 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +9 -> 30
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   35: invokevirtual 415	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   38: astore_1
    //   39: goto -13 -> 26
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TroopFileTransferManager
    //   0	47	1	paramUUID	UUID
    // Exception table:
    //   from	to	target	type
    //   2	20	42	finally
    //   30	39	42	finally
  }
  
  public apsf a()
  {
    if (this.d == null) {
      this.d = apsf.a(this.mApp, this.mTroopUin);
    }
    return this.d;
  }
  
  public Item a(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        Map localMap = this.nC;
        if (localMap == null)
        {
          paramUUID = null;
          return paramUUID;
        }
        if (paramUUID == null) {
          throw new NullPointerException("TroopFileTransferManager getItem id is Null");
        }
      }
      finally {}
      paramUUID = (Item)this.nC.get(paramUUID);
    }
  }
  
  public Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileTransferManager", 1, Thread.currentThread().getName() + "removeitem:[" + paramUUID + "]");
      }
      paramUUID = (Item)this.nC.remove(paramUUID);
      if ((paramBoolean) && (paramUUID != null)) {
        ebH();
      }
      return paramUUID;
    }
    finally {}
  }
  
  protected ProxyIpManager a()
  {
    if (this.mApp == null) {
      return null;
    }
    if (this.jdField_a_of_type_MqqManagerProxyIpManager == null) {
      this.jdField_a_of_type_MqqManagerProxyIpManager = ((ProxyIpManager)this.mApp.getManager(3));
    }
    return this.jdField_a_of_type_MqqManagerProxyIpManager;
  }
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, ahbm paramahbm)
  {
    a(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramString1, paramString2, paramLong3, paramString3, paramBoolean, paramLong4, paramahbm, 0L, 0, null);
  }
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, ahbm paramahbm, long paramLong5, int paramInt4, Bundle paramBundle)
  {
    int j = Math.abs(new Random().nextInt());
    synchronized (a())
    {
      if ((paramInt2 == 102) || (paramInt2 == 104)) {}
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.d == null) {
          this.d = a();
        }
        Object localObject = this.d.a(paramString3);
        if (localObject != null)
        {
          paramInt2 = ((apbr)localObject).dTg;
          break label372;
          localObject = ???.a(paramString1, paramLong3, paramInt2);
          if (localObject != null) {}
        }
        else
        {
          paramInt2 = 102;
          break label372;
          if ((paramInt3 != 7) && (paramInt3 != 6003)) {
            break label366;
          }
          i = 38;
          continue;
        }
        dYP();
        localObject = new Item((apbr)localObject);
        a((Item)localObject);
        ((Item)localObject).RandomNum = j;
        ((Item)localObject).ForwardPath = paramString3;
        ((Item)localObject).ForwardTroopuin = paramLong1;
        ((Item)localObject).mForwardCallback = paramahbm;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("yyb_apk_package_name_key")) {
            ((Item)localObject).yybApkPackageName = paramBundle.getString("yyb_apk_package_name_key", "");
          }
          if (paramBundle.containsKey("yyb_apk_name_key")) {
            ((Item)localObject).yybApkName = paramBundle.getString("yyb_apk_name_key", "");
          }
          if (paramBundle.containsKey("yyb_apk_icon_url_key")) {
            ((Item)localObject).yybApkIconUrl = paramBundle.getString("yyb_apk_icon_url_key", "");
          }
        }
        if (!paramBoolean)
        {
          paramLong1 = paramahbm.a(String.valueOf(paramLong2), paramInt3, String.valueOf(paramLong1), paramInt2, paramString3, paramString1, paramString2, paramLong3, paramInt1, paramLong5, paramInt4);
          ((Item)localObject).ForwardBusId = paramInt2;
          ((Item)localObject).BusId = i;
          smq.a(this.mApp, false, this.mTroopUin, (Item)localObject, paramLong2, paramLong1, this.jdField_a_of_type_Smq$l);
          return;
          paramString1 = finally;
          throw paramString1;
        }
        paramLong1 = paramLong4;
        continue;
        i = 3;
      }
      finally {}
      label366:
      continue;
      label372:
      if (paramInt3 == 3000) {
        i = 106;
      }
    }
  }
  
  protected final void a(apcy paramapcy, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    FileManagerEntity localFileManagerEntity = ahav.a(paramapcy);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramapcy.TroopUin);
    localFileManagerEntity.peerNick = aqgv.F(this.mApp, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = paramBoolean;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = this.mTroopUin;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = agoy.t(ahav.A(paramapcy.LocalFile));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = agoy.t(ahav.x(paramapcy.LocalFile));
      }
    }
    localFileManagerEntity.str10Md5 = aqhs.bytes2HexStr(ahav.t(paramapcy.LocalFile));
    try
    {
      localFileManagerEntity.localModifyTime = new File(paramapcy.LocalFile).lastModified();
      label221:
      this.mApp.a().s(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.mApp.a().u(localFileManagerEntity);
      return;
    }
    catch (Exception paramapcy)
    {
      break label221;
    }
  }
  
  protected void a(Item paramItem)
  {
    try
    {
      this.nC.put(paramItem.Id, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(Item paramItem, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt1) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      if (paramItem.IsNewStatus) {
        b(paramItem, paramInt1, paramInt2);
      }
      paramItem.Status = paramInt1;
      paramItem.ErrorCode = paramInt2;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == 1) {
        paramItem.W2MPause = 0;
      }
      ebH();
      paramItem.StatusUpdateTimeMs = 0L;
      d(paramItem);
      paramItem.IsNewStatus = false;
      d(paramItem, paramInt2);
      return;
    }
    finally {}
  }
  
  public void a(Item paramItem, int paramInt, apsd.a parama)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      paramItem.Status = paramInt;
      paramItem.ErrorCode = parama.errorCode;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == 1) {
        paramItem.W2MPause = 0;
      }
      ebH();
      paramItem.StatusUpdateTimeMs = 0L;
      d(paramItem);
      paramItem.IsNewStatus = false;
      apsd.a(this.mApp, parama);
      return;
    }
    finally {}
  }
  
  protected void a(Item paramItem, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = paramItem.FilePath;
      if (localObject == null) {}
      for (;;)
      {
        return;
        if (paramInt == 0) {
          break;
        }
        if ((1 == aqiw.getSystemNetwork(BaseApplication.getContext())) || (paramInt != 128)) {
          break label59;
        }
        paramItem.ThumbnailDownloading_Small = false;
        paramItem.ThumbnailFileTimeMS_Small = 0L;
      }
      if (!paramBoolean) {}
    }
    finally {}
    for (;;)
    {
      label59:
      smq.a(this.mApp, this.mTroopUin, paramItem, paramInt, paramBoolean, false, this.jdField_a_of_type_Smq$m);
      if ((paramBoolean) || (paramInt != 0)) {
        break;
      }
      apue.ebR();
      break;
      c(paramItem, 8);
      localObject = (apbr)a().nO.get(paramItem.FilePath);
      if (localObject != null)
      {
        apbr localapbr = (apbr)a().nO.get(((apbr)localObject).mParentId);
        if (localapbr != null)
        {
          ((apbr)localObject).Status = 8;
          localapbr.a((apbr)localObject);
        }
      }
    }
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      synchronized (a())
      {
        try
        {
          if (aqiw.getSystemNetwork(BaseApplication.getContext()) == 0)
          {
            i = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            localObject = ???.b((String)paramCollection.next());
            if (localObject == null) {
              continue;
            }
            dYP();
            localObject = new Item((apbr)localObject);
            a((Item)localObject);
            ((Item)localObject).BusId = 102;
            ((Item)localObject).isFromAIO = paramBoolean;
            if (i == 0) {
              break label125;
            }
            a((Item)localObject, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label125:
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[0].a(new TaskScan((Item)localObject));
    }
  }
  
  public final void a(UUID paramUUID, String paramString)
  {
    try
    {
      paramUUID = (Item)this.nC.get(paramUUID);
      if (paramUUID != null)
      {
        paramUUID.FilePath = paramString;
        paramUUID.BusId = 102;
      }
      return;
    }
    finally {}
  }
  
  public boolean a(long paramLong, UUID paramUUID, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    String str;
    synchronized (a())
    {
      str = paramString2;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          str = paramString2;
          if (!paramString2.startsWith("/")) {
            str = "/" + paramString2;
          }
        }
        if (QLog.isColorLevel())
        {
          paramString2 = "";
          if (paramUUID != null) {
            paramString2 = paramUUID.toString();
          }
          QLog.d("TroopFileTransferManager", 2, String.format("finishCopyFrom - sessionId: %s, UUID: %s retCode: %d strNewPath:%s strErrorMsg:%s", new Object[] { paramLong + "", paramString2, Integer.valueOf(paramInt), str, paramString3 }));
        }
        paramString2 = null;
        if (paramUUID != null) {
          paramString2 = ???.b(paramUUID);
        }
        if (paramString1 == null) {
          break label1025;
        }
        paramUUID = ???.a(paramString1);
        if (paramUUID == null) {
          return false;
        }
        dYP();
        paramString1 = (Item)this.nC.get(paramUUID.Id);
        if (paramString1 == null)
        {
          return false;
          paramUUID = finally;
          throw paramUUID;
        }
        if (paramString1.Status != 4) {
          return false;
        }
        if (paramInt >= 0) {
          break label820;
        }
        i = 207;
        switch (paramInt)
        {
        default: 
          if (TextUtils.isEmpty(str))
          {
            if (!TextUtils.isEmpty(paramString3)) {
              break label794;
            }
            paramUUID = new apsd.a(paramString1.FileName, this.mTroopUin, 5, 207);
            a(paramString1, 5, paramUUID);
            return true;
          }
        case -20001: 
        case -20000: 
        case -403: 
          paramUUID = this.mApp.a().b(paramLong);
          if (paramUUID == null)
          {
            if (!TextUtils.isEmpty(paramString3))
            {
              a(paramString1, 5, new apsd.a(paramString1.FileName, this.mTroopUin, 5, 704, paramString3));
              return false;
            }
            QLog.e("TroopFileTransferManager", 1, "finishCopyFrom, but entity is null!!!sessionId:" + paramLong);
            a(paramString1, 5, i);
            return true;
          }
          if (paramUUID.busId == 104) {
            continue;
          }
          paramUUID.busId = 104;
          paramString1.BusId = 104;
          if (paramUUID.nOpType == 27)
          {
            this.mApp.a().a(paramUUID, 27);
            if (QLog.isColorLevel()) {
              QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", new Object[] { Integer.valueOf(paramInt) }));
            }
            return true;
          }
          if (paramUUID.nOpType != 26) {
            continue;
          }
          this.mApp.a().a(104, paramUUID);
          break;
        case -3: 
          i = 202;
        }
      }
      finally {}
      continue;
      int i = 600;
      continue;
      i = 701;
      continue;
      new Handler(Looper.getMainLooper()).postDelayed(new TroopFileTransferManager.12(this, paramString1), 1000L);
      return true;
      if ((!TextUtils.isEmpty(paramString1.LocalFile)) && (new File(paramString1.LocalFile).exists()))
      {
        c(paramString1, 0);
        paramString1.BusId = 102;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[0].a(new TaskScan(paramString1));
        return true;
      }
      i = 603;
      continue;
      i = 705;
      continue;
      a(paramString1, 5, new apsd.a(paramString1.FileName, this.mTroopUin, 5, 704, paramString3));
      return true;
      label794:
      paramUUID = new apsd.a(paramString1.FileName, this.mTroopUin, 5, 704, paramString3);
      continue;
      label820:
      if (TextUtils.isEmpty(str))
      {
        if (TextUtils.isEmpty(paramString3)) {}
        for (paramUUID = new apsd.a(paramString1.FileName, this.mTroopUin, 5, 207);; paramUUID = new apsd.a(paramString1.FileName, this.mTroopUin, 5, 704, paramString3))
        {
          a(paramString1, 5, paramUUID);
          return true;
        }
      }
      paramUUID.mFileId = str;
      paramString1.FilePath = str;
      paramString2 = paramString1.getInfo(this.mTroopUin);
      if (paramString2 != null) {
        paramString2.FilePath = str;
      }
      paramString2 = this.mApp.a().b(paramString1.entrySessionID);
      if (paramString2 != null)
      {
        paramString2.strTroopFilePath = str;
        paramString3 = ahav.h(paramString2);
        paramString2.strQRUrl = paramString3;
        paramString1.strQRUrl = paramString3;
      }
      if (this.d != null) {
        this.d.a(paramUUID.mFileId, paramUUID);
      }
      a(paramString1, 6, 0);
      c(paramString1);
      return true;
      label1025:
      paramUUID = paramString2;
    }
  }
  
  protected final boolean a(Item paramItem)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = true;
    if (paramItem == null) {}
    do
    {
      do
      {
        do
        {
          return bool2;
          switch (paramItem.Status)
          {
          default: 
            bool2 = bool1;
          }
        } while (paramItem.ThumbnailDownloading_Small);
        bool2 = bool1;
      } while (paramItem.ThumbnailDownloading_Large);
      bool2 = bool1;
    } while (paramItem.ThumbnailDownloading_Middle);
    if ((paramItem.HasThumbnailFile_Small) && (!a(paramItem, 128))) {
      bool2 = bool3;
    }
    for (;;)
    {
      return bool2;
      if (!TextUtils.isEmpty(paramItem.LocalFile))
      {
        if (new File(paramItem.LocalFile).exists()) {
          break;
        }
        i = apef.b.USR;
        localStringBuilder = new StringBuilder().append("[");
        if (paramItem.Id != null) {}
        for (str = paramItem.Id.toString();; str = "null")
        {
          apef.b.w("TroopFileTransferManager", i, str + "] check localfile is not exsit. set to nodownload state");
          c(paramItem, 7);
          bool1 = true;
          break;
        }
      }
      int i = apef.b.USR;
      StringBuilder localStringBuilder = new StringBuilder().append("[");
      if (paramItem.Id != null) {}
      for (String str = paramItem.Id.toString();; str = "null")
      {
        apef.b.w("TroopFileTransferManager", i, str + "] check localfile=null. set to nodownload state");
        c(paramItem, 7);
        bool1 = true;
        break;
      }
      if (paramItem.HasThumbnailFile_Large)
      {
        bool2 = bool3;
        if (!a(paramItem, 640)) {}
      }
      else if (paramItem.HasThumbnailFile_Middle)
      {
        bool2 = bool3;
        if (!a(paramItem, 383)) {}
      }
      else
      {
        bool2 = bool1;
      }
    }
  }
  
  protected boolean a(Item paramItem, int paramInt)
  {
    String str = paramItem.getThumbnailFile(this.mTroopUin, paramInt);
    if (paramInt == 128)
    {
      paramItem.HasThumbnailFile_Small = aqhq.fileExistsAndNotEmpty(str);
      if (paramItem.HasThumbnailFile_Small) {
        paramItem.ThumbnailFileTimeMS_Small = 0L;
      }
      return paramItem.HasThumbnailFile_Small;
    }
    if (paramInt == 640)
    {
      paramItem.HasThumbnailFile_Large = aqhq.fileExistsAndNotEmpty(str);
      if (paramItem.HasThumbnailFile_Large) {
        paramItem.ThumbnailFileTimeMS_Large = 0L;
      }
      return paramItem.HasThumbnailFile_Large;
    }
    if (paramInt == 383)
    {
      paramItem.HasThumbnailFile_Middle = aqhq.fileExistsAndNotEmpty(str);
      if (paramItem.HasThumbnailFile_Middle) {
        paramItem.ThumbnailFileTimeMS_Middle = 0L;
      }
      return paramItem.HasThumbnailFile_Middle;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt, smq.m paramm)
  {
    synchronized (a()) {}
    label168:
    for (;;)
    {
      try
      {
        apbr localapbr = ???.a(paramString1, paramString2, paramLong, paramInt);
        if (localapbr == null) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileTransferManager", 2, "startDownload==>" + localapbr.toString());
        }
        dYP();
        paramString1 = (Item)this.nC.get(localapbr.Id);
        if (paramString1 != null) {
          break label168;
        }
        paramString1 = new Item(localapbr);
        a(paramString1);
        paramString1.FileName = paramString2;
        paramString1.ProgressTotal = paramLong;
        paramString1.ProgressValue = localapbr.ProgressValue;
        smq.a(this.mApp, this.mTroopUin, paramString1, 0, false, true, paramm);
        return true;
      }
      finally {}
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean a(UUID arg1)
  {
    for (;;)
    {
      Item localItem;
      try
      {
        dYP();
        localItem = (Item)this.nC.get(???);
        if (localItem == null)
        {
          bool = false;
          return bool;
        }
        switch (localItem.Status)
        {
        case 0: 
          if (!QLog.isDevelopLevel()) {
            break label213;
          }
          QLog.d("TroopFileTransferManager", 4, "error status SuspendUpload");
        }
      }
      finally {}
      c[] arrayOfc = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c;
      int j = arrayOfc.length;
      int i = 0;
      if (i < j) {
        synchronized (arrayOfc[i])
        {
          Iterator localIterator = ???.al.iterator();
          if (localIterator.hasNext())
          {
            Task localTask = (Task)localIterator.next();
            if ((localTask.e != localItem) || (!localTask.cSh)) {
              continue;
            }
            ???.al.remove(localTask);
            c(localItem, 2);
            bool = true;
            continue;
          }
          i += 1;
        }
      }
      localObject.Pausing = 1;
      boolean bool = true;
      continue;
      continue;
      label213:
      bool = false;
    }
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      apbr localapbr = ???.b(paramUUID);
      if (localapbr == null) {
        return false;
      }
      int i = ahav.getFileType(ahbj.getExtension(localapbr.str_file_name));
      if ((i != 0) && (i != 2))
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      ThreadManager.post(new TroopFileTransferManager.8(this, paramUUID, localapbr, paramInt, i), 5, null, true);
      return true;
    }
    finally {}
  }
  
  public final boolean a(UUID paramUUID, int paramInt, String paramString1, String paramString2)
  {
    return a(0L, paramUUID, null, paramInt, paramString1, paramString2);
  }
  
  /* Error */
  protected boolean aAU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1010	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:cvp	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: aload_0
    //   22: getfield 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
    //   25: aload_0
    //   26: getfield 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
    //   29: invokestatic 1015	aprk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Map;J)Z
    //   32: istore_1
    //   33: goto -20 -> 13
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	TroopFileTransferManager
    //   6	27	1	bool	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   17	33	36	finally
  }
  
  /* Error */
  public final boolean aBu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1010	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:cvp	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 1019	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:aBv	()Z
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	TroopFileTransferManager
    //   6	16	1	bool	boolean
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public final boolean aBv()
  {
    try
    {
      Object localObject1 = this.nC.values();
      localObject1 = ((Collection)localObject1).iterator();
      for (boolean bool = false; ((Iterator)localObject1).hasNext(); bool = a((Item)((Iterator)localObject1).next()) | bool) {}
      return bool;
    }
    finally {}
  }
  
  public boolean aBw()
  {
    return this.mApp == null;
  }
  
  public final int[] ae()
  {
    for (;;)
    {
      try
      {
        dYP();
        int[] arrayOfInt1 = new int[2];
        int[] tmp11_10 = arrayOfInt1;
        tmp11_10[0] = 0;
        int[] tmp15_11 = tmp11_10;
        tmp15_11[1] = 0;
        tmp15_11;
        Iterator localIterator = this.nC.values().iterator();
        if (!localIterator.hasNext()) {
          break label127;
        }
        Item localItem = (Item)localIterator.next();
        if (localItem == null) {
          continue;
        }
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
          arrayOfInt1[0] += 1;
          arrayOfInt1[1] += 1;
          break;
        case 2: 
        case 3: 
          arrayOfInt2[0] += 1;
        }
      }
      finally {}
      continue;
      label127:
      return arrayOfInt2;
    }
  }
  
  public void b(Item paramItem)
  {
    ebH();
  }
  
  /* Error */
  public final boolean b(Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 776	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +28 -> 36
    //   11: aload_1
    //   12: getfield 776	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +15 -> 31
    //   19: iconst_2
    //   20: istore_2
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: iconst_3
    //   32: istore_2
    //   33: goto -12 -> 21
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -11 -> 27
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	TroopFileTransferManager
    //   0	46	1	paramItem	Item
    //   20	13	2	i	int
    //   1	37	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	41	finally
    //   21	27	41	finally
  }
  
  public boolean b(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        dYP();
        paramUUID = (Item)this.nC.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 2: 
          if (!QLog.isDevelopLevel()) {
            break label134;
          }
          QLog.d("TroopFileTransferManager", 4, "error status ResumeUpload");
        }
      }
      finally {}
      if (paramUUID.Md5 == null)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[0].a(new TaskScan(paramUUID));
      }
      else if (paramUUID.FilePath == null)
      {
        e(paramUUID);
      }
      else
      {
        f(paramUUID);
        break label139;
        continue;
        label134:
        bool = false;
        continue;
      }
      label139:
      boolean bool = true;
    }
  }
  
  public void c(Item paramItem)
  {
    smq.a(this.mApp, this.mTroopUin, paramItem, this.jdField_a_of_type_Smq$n);
  }
  
  public final void c(Item paramItem, int paramInt)
  {
    a(paramItem, paramInt, 0);
  }
  
  protected final void c(Item paramItem, int paramInt1, int paramInt2)
  {
    if (!paramItem.canFetchThumbnailFile(paramInt1)) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopFileTransferManager", 1, "_fetchThumbnail error, times limit. fileId[" + paramItem.Id + "] thumbSize[" + paramInt1 + "]");
      }
    }
    do
    {
      return;
      if (!a(paramItem, paramInt1)) {
        break;
      }
      paramItem.StatusUpdateTimeMs = 0L;
      d(paramItem);
    } while (!QLog.isColorLevel());
    QLog.e("TroopFileTransferManager", 1, "_fetchThumbnail error, thumb already exist. fileId[" + paramItem.Id + "] thumbSize[" + paramInt1 + "]");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("TroopFileTransferManager", 1, "_fetchThumbnail request suc: fileId[" + paramItem.Id + "] thumbSize[" + paramInt1 + "]");
    }
    if (paramInt1 == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (QLog.isColorLevel())) {
        QLog.d(".troop.troop_file_video.thumb", 2, "_fetchThumbnail:" + paramItem.FileName + ", localFile=" + paramItem.LocalFile);
      }
      if ((paramItem.LocalFile == null) || (!new File(paramItem.LocalFile).exists())) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[1].a(new TaskGenThumbnail(paramItem, paramInt1));
      return;
      if (paramInt1 == 640)
      {
        paramItem.ThumbnailDownloading_Large = true;
        paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
      }
      else if (paramInt1 == 383)
      {
        paramItem.ThumbnailDownloading_Middle = true;
        paramItem.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
      }
    }
    if ((paramInt1 == 383) && (ahbj.fileExistsAndNotEmpty(paramItem.getThumbnailFile(this.mTroopUin, 640))))
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[1].a(new TaskGenThumbnail(paramItem, paramInt1));
      return;
    }
    a(paramItem, paramInt1, false);
  }
  
  /* Error */
  public void c(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 371	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:dYP	()V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 429	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 141 2 0
    //   18: checkcast 8	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: new 1070	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 1071	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$3:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   33: iconst_5
    //   34: aconst_null
    //   35: iconst_0
    //   36: invokestatic 154	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	TroopFileTransferManager
    //   0	52	1	paramUUID	UUID
    // Exception table:
    //   from	to	target	type
    //   8	24	42	finally
    //   43	45	42	finally
    //   2	8	47	finally
    //   24	39	47	finally
    //   45	47	47	finally
  }
  
  /* Error */
  public final boolean c(Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 776	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +30 -> 38
    //   11: aload_1
    //   12: getfield 776	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +16 -> 32
    //   19: bipush 9
    //   21: istore_2
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: bipush 10
    //   34: istore_2
    //   35: goto -13 -> 22
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -12 -> 28
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TroopFileTransferManager
    //   0	48	1	paramItem	Item
    //   21	14	2	i	int
    //   1	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	43	finally
    //   22	28	43	finally
  }
  
  public boolean c(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        dYP();
        paramUUID = (Item)this.nC.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 9: 
        case 10: 
          if (paramUUID.isZipInnerFile)
          {
            c(paramUUID, 8);
            this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c[3].a(new TaskHttpDownload(paramUUID));
          }
          else if ((ahav.getFileType(paramUUID.FileName) == 2) && (ahbr.aM(this.mApp)))
          {
            paramUUID = paramUUID.getInfo(this.mTroopUin);
            agkw.a(new agtf(this.mApp, paramUUID)).ZE();
          }
          break;
        }
      }
      finally {}
      a(paramUUID, 0, false);
      break label165;
      boolean bool = false;
      continue;
      label165:
      bool = true;
    }
  }
  
  public void d(Item paramItem)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis() - this.are;
      long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
      if ((this.are == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
      {
        this.are = (l1 + this.are);
        paramItem.StatusUpdateTimeMs += l2;
        ((accc)this.mApp.getBusinessHandler(22)).aQ(paramItem.getInfo(this.mTroopUin));
      }
      return;
    }
    finally {}
  }
  
  public boolean d(UUID arg1)
  {
    try
    {
      dYP();
      Item localItem = (Item)this.nC.get(???);
      if (localItem == null) {}
      for (boolean bool = false;; bool = false)
      {
        return bool;
        if (localItem.Status == 8) {
          break;
        }
      }
      c[] arrayOfc = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$c;
      int k = arrayOfc.length;
      int j = 0;
      int i = 0;
      if (j < k) {}
      for (;;)
      {
        synchronized (arrayOfc[j])
        {
          Iterator localIterator = ???.al.iterator();
          if (localIterator.hasNext())
          {
            Task localTask = (Task)localIterator.next();
            if ((localTask.e == localItem) && (localTask.cSi))
            {
              ???.al.remove(localTask);
              c(localItem, 9);
              i = 1;
              if (i != 0)
              {
                if ((ahav.getFileType(localItem.FileName) == 2) && (ahbr.aM(this.mApp)))
                {
                  agkw.IM(localItem.FilePath);
                  c(localItem, 9);
                }
                localItem.Pausing = 1;
                bool = true;
                break;
              }
              j += 1;
            }
          }
        }
      }
    }
    finally {}
  }
  
  public void dYP()
  {
    try
    {
      boolean bool = this.cvp;
      if (bool) {
        label11:
        return;
      }
      this.cvp = true;
      List localList = aprk.b(this.mApp, this.mTroopUin);
      this.nC = new ConcurrentHashMap();
      this.nF = new ConcurrentHashMap();
      if ((!$assertionsDisabled) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if ((((TroopFileTansferItemEntity)localObject2).Id != null) && ((TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).FilePath)) || (((TroopFileTansferItemEntity)localObject2).FilePath.startsWith("/")))) {
          this.nC.put(((TroopFileTansferItemEntity)localObject2).Id, new Item((TroopFileTansferItemEntity)localObject2));
        }
      }
    }
    Iterator localIterator = this.nC.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (Item)localIterator.next();
      }
      switch (((Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((Item)localObject2).Status = 3;
        break;
      case 8: 
        ((Item)localObject2).Status = 10;
        continue;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ThreadManager.post(new TroopFileTransferManager.13(this), 8, null, true);
          break label11;
        }
        if (!aBv()) {
          break label11;
        }
        ebH();
        break label11;
      }
    }
  }
  
  protected void dYQ()
  {
    for (;;)
    {
      Item localItem;
      try
      {
        dYP();
        Iterator localIterator = this.nC.values().iterator();
        if (!localIterator.hasNext()) {
          break label149;
        }
        localItem = (Item)localIterator.next();
        if (localItem.W2MPause != 2) {
          continue;
        }
        localItem.W2MPause = 0;
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          b(localItem.Id);
        }
      }
      finally {}
      continue;
      c(localItem.Id);
      continue;
      label149:
      return;
    }
  }
  
  protected void dYR()
  {
    for (;;)
    {
      try
      {
        if (this.nC != null)
        {
          Iterator localIterator = this.nC.values().iterator();
          if (localIterator.hasNext())
          {
            Item localItem = (Item)localIterator.next();
            switch (localItem.Status)
            {
            case 0: 
            case 1: 
            case 8: 
              localItem.Pausing = -1;
              continue;
            }
          }
        }
      }
      finally {}
      return;
    }
  }
  
  public void e(Item paramItem)
  {
    c(paramItem, 1);
    smq.a(this.mApp, this.mTroopUin, paramItem, this.jdField_a_of_type_Smq$q);
  }
  
  public boolean e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
    try
    {
      int i = ahav.getFileType(ahbj.getExtension(paramString2));
      if ((i != 0) && (i != 2)) {
        return false;
      }
      apbr localapbr = ???.a(paramString1, paramString2, 0L, paramInt1);
      if (localapbr == null)
      {
        return false;
        paramString1 = finally;
        throw paramString1;
      }
      dYP();
      paramString2 = (Item)this.nC.get(localapbr.Id);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new Item(localapbr);
        a(paramString1);
      }
      c(paramString1, paramInt2, i);
      return true;
    }
    finally {}
  }
  
  public boolean e(UUID paramUUID)
  {
    apbr localapbr;
    Item localItem;
    synchronized (a()) {}
  }
  
  public void ebG()
  {
    if (this.mApp == null) {}
    do
    {
      return;
      if (this.arV != 0L)
      {
        localQQAppInterface = this.mApp;
        str = this.mApp.getCurrentAccountUin();
        l1 = this.arV;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_WIFIGroupFileDownloadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_WIFIGroupFileDownloadFlow", 4, this.arV + "");
        }
        this.arV = 0L;
      }
      if (this.arW != 0L)
      {
        localQQAppInterface = this.mApp;
        str = this.mApp.getCurrentAccountUin();
        l1 = this.arW;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_WIFIGroupFileUploadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        this.arW = 0L;
      }
      if ((this.arY != 0L) || (this.arX != 0L))
      {
        localQQAppInterface = this.mApp;
        str = this.mApp.getCurrentAccountUin();
        l1 = this.arX;
        long l2 = this.arY;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_XGFileFlow", "param_XGFlow", "param_Flow" }, l1 + l2);
      }
      if (this.arX != 0L)
      {
        localQQAppInterface = this.mApp;
        str = this.mApp.getCurrentAccountUin();
        l1 = this.arX;
        localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_XGGroupFileDownloadFlow", "param_XGFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_XGGroupFileDownloadFlow", 4, this.arX + "");
        }
        this.arX = 0L;
      }
    } while (this.arY == 0L);
    QQAppInterface localQQAppInterface = this.mApp;
    String str = this.mApp.getCurrentAccountUin();
    long l1 = this.arY;
    localQQAppInterface.sendAppDataIncerment(str, new String[] { "param_XGGroupFileUploadFlow", "param_XGFlow", "param_Flow" }, l1);
    if (QLog.isDevelopLevel()) {
      QLog.d("param_XGGroupFileUploadFlow", 4, this.arY + "");
    }
    this.arY = 0L;
  }
  
  /* Error */
  protected final void ebH()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 125	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:arZ	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +31 -> 41
    //   13: aload_0
    //   14: invokestatic 1058	android/os/SystemClock:uptimeMillis	()J
    //   17: putfield 125	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:arZ	J
    //   20: iload_1
    //   21: ifeq +17 -> 38
    //   24: new 1160	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$14
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 1161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$14:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   32: iconst_5
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokestatic 154	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: iconst_0
    //   42: istore_1
    //   43: goto -30 -> 13
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TroopFileTransferManager
    //   1	42	1	i	int
    //   46	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	46	finally
    //   13	20	46	finally
    //   24	38	46	finally
  }
  
  protected void ebJ()
  {
    try
    {
      dYP();
      Iterator localIterator = this.nC.values().iterator();
      while (localIterator.hasNext())
      {
        Item localItem = (Item)localIterator.next();
        if (localItem.W2MPause == 2) {
          localItem.W2MPause = 1;
        }
      }
    }
    finally {}
  }
  
  public int f(FileManagerEntity paramFileManagerEntity)
  {
    return 0;
  }
  
  public final Collection<apcy> f()
  {
    try
    {
      dYP();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.nC.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Item)localIterator.next()).getInfo(this.mTroopUin));
      }
    }
    finally {}
    return localCollection;
  }
  
  protected void f(Item paramItem)
  {
    c(paramItem, 1);
    smq.a(this.mApp, this.mTroopUin, paramItem, this.jdField_a_of_type_Smq$o);
  }
  
  public final boolean g(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        dYP();
        paramUUID = (Item)this.nC.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 4: 
        case 5: 
        case 8: 
          if (!QLog.isDevelopLevel()) {
            break label262;
          }
          QLog.e("TroopFileTransferManager", 4, "deleteItem error, status:" + paramUUID.Status);
        }
      }
      finally {}
      if (paramUUID.TmpFile != null) {
        new File(paramUUID.TmpFile).delete();
      }
      paramUUID.deleteThumbnailFile(this.mTroopUin, 128);
      paramUUID.deleteThumbnailFile(this.mTroopUin, 640);
      paramUUID.deleteThumbnailFile(this.mTroopUin, 383);
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "delete " + paramUUID.Id + "[" + paramUUID.FilePath + "]" + paramUUID.Status);
      }
      g(paramUUID);
      boolean bool = true;
      continue;
      continue;
      label262:
      bool = false;
    }
  }
  
  public final List<apcy> gE()
  {
    try
    {
      dYP();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.nC.values().iterator();
      while (localIterator.hasNext())
      {
        Item localItem = (Item)localIterator.next();
        if ((localItem != null) && (localItem.FilePath != null)) {
          localArrayList.add(localItem.getInfo(this.mTroopUin));
        }
      }
    }
    finally {}
    return localList;
  }
  
  protected final void h(Item paramItem)
  {
    a(paramItem, 0, true);
  }
  
  public boolean i(String paramString1, String paramString2, int paramInt)
  {
    apbr localapbr;
    synchronized (a()) {}
  }
  
  protected void init() {}
  
  public void j(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      paramString2 = ???.a(paramString2, paramLong, 25);
      if (paramString2 == null)
      {
        return;
        paramString1 = finally;
        throw paramString1;
      }
      dYP();
      paramString2 = new Item(paramString2);
      a(paramString2);
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
      paramString2.ForwardBusId = paramInt;
      paramString2.Status = 4;
      paramString2.BusId = 25;
      smq.a(this.mApp, true, this.mTroopUin, paramString2, this.mApp.getLongAccountUin(), 0L, this.jdField_a_of_type_Smq$l);
      return;
    }
    finally {}
  }
  
  public void mN(List<apcy> paramList) {}
  
  public void o(apbr paramapbr) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "onNetWifi2Mobile");
      }
      boolean bool = this.cvp;
      if (!bool) {
        label27:
        return;
      }
      int i = 0;
      paramString = this.nC.values().iterator();
      for (;;)
      {
        Item localItem;
        if (paramString.hasNext()) {
          localItem = (Item)paramString.next();
        }
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          if (localItem.Pausing == 0)
          {
            localItem.Pausing = 1;
            localItem.W2MPause = 2;
            i = 1;
            break label158;
            if (i == 0) {
              break label27;
            }
            apsd.e(this.mApp, this.mTroopUin, 107);
            break label27;
          }
          break;
        }
      }
    }
    finally {}
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetWifi2None");
    }
  }
  
  protected void release()
  {
    dYR();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public final boolean renameFile(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramString1 = UUID.fromString(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        dYP();
        paramString1 = (Item)this.nC.get(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        paramString1.NameForSave = paramString2;
        paramString1.LocalFile = (acbn.bmg + paramString2);
        b(paramString1);
        ((accc)this.mApp.getBusinessHandler(22)).aQ(paramString1.getInfo(this.mTroopUin));
        bool = true;
      }
      finally {}
    }
  }
  
  public static class Item
    extends TroopFileTansferItemEntity
  {
    public static final String ThumbnailFilePrefix = "[Thumb]";
    public static final int W2M_PAUSE_CAN_RESUME = 2;
    public static final int W2M_PAUSE_NONE = 0;
    public static final int W2M_PAUSE_NO_RESUME = 1;
    public transient byte[] CheckKey;
    public transient MessageDigest DigestMd5;
    public transient MessageDigest DigestSha;
    public transient MessageDigest DigestSha3;
    public transient String DownloadDNS;
    public transient String DownloadIp;
    public transient String DownloadUrl;
    public transient boolean IsNewStatus;
    public transient int Pausing;
    public transient long ScanPos;
    public transient String ServerDns;
    public transient long StatusUpdateTimeMs;
    public transient boolean ThumbnailDownloading_Large;
    public transient boolean ThumbnailDownloading_Middle;
    public transient boolean ThumbnailDownloading_Middle_Fail;
    public transient boolean ThumbnailDownloading_Small;
    public transient String TmpFile;
    public transient String UploadIp;
    public transient int W2MPause;
    public transient boolean bExtfTransfer;
    public transient String cookieValue;
    public transient String downUrlStr4Report;
    public transient boolean genThumb_Middle_OnGettedLargeOrOrigPic;
    public transient boolean isFileExist;
    public transient String mExcitingSpeed;
    public ahbm mForwardCallback;
    public transient int retryTimes;
    public transient String rspHeadStr;
    public transient int thumbInvalidCode;
    public transient long transferBeginTime;
    public transient long transferedSize;
    public transient String uploadUrl;
    
    public Item() {}
    
    public Item(apbr paramapbr)
    {
      this.Id = paramapbr.Id;
      this.LocalFile = paramapbr.LocalFile;
      this.Status = paramapbr.Status;
      this.FilePath = paramapbr.mFileId;
      this.FileName = paramapbr.str_file_name;
      this.ProgressTotal = paramapbr.uint64_file_size;
      this.UploadTime = paramapbr.Lg();
      this.BusId = paramapbr.dTg;
      if ((paramapbr.ThumbnailFile_Small != null) && (paramapbr.ThumbnailFile_Small.length() > 0))
      {
        bool1 = true;
        this.HasThumbnailFile_Small = bool1;
        if ((paramapbr.ThumbnailFile_Large == null) || (paramapbr.ThumbnailFile_Large.length() <= 0)) {
          break label140;
        }
      }
      label140:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.HasThumbnailFile_Large = bool1;
        this.NickName = paramapbr.NickName;
        this.mParentId = paramapbr.mParentId;
        return;
        bool1 = false;
        break;
      }
    }
    
    public Item(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
    {
      this.Id = paramTroopFileTansferItemEntity.Id;
      this.LocalFile = paramTroopFileTansferItemEntity.LocalFile;
      this.Status = paramTroopFileTansferItemEntity.Status;
      this.FilePath = paramTroopFileTansferItemEntity.FilePath;
      this.FileName = paramTroopFileTansferItemEntity.FileName;
      this.ProgressTotal = paramTroopFileTansferItemEntity.ProgressTotal;
      this.UploadTime = paramTroopFileTansferItemEntity.UploadTime;
      this.BusId = paramTroopFileTansferItemEntity.BusId;
      this.ErrorCode = paramTroopFileTansferItemEntity.ErrorCode;
      this.ProgressValue = paramTroopFileTansferItemEntity.ProgressValue;
      this.Md5 = paramTroopFileTansferItemEntity.Md5;
      this.Sha = paramTroopFileTansferItemEntity.Sha;
      this.isFromAIO = paramTroopFileTansferItemEntity.isFromAIO;
      this.HasThumbnailFile_Small = paramTroopFileTansferItemEntity.HasThumbnailFile_Small;
      this.ThumbnailFileTimeMS_Small = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Small;
      this.HasThumbnailFile_Large = paramTroopFileTansferItemEntity.HasThumbnailFile_Large;
      this.ThumbnailFileTimeMS_Large = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Large;
      this.HasThumbnailFile_Middle = paramTroopFileTansferItemEntity.HasThumbnailFile_Middle;
      this.ThumbnailFileTimeMS_Middle = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Middle;
      this.PreviewUrl = paramTroopFileTansferItemEntity.PreviewUrl;
      this.NickName = paramTroopFileTansferItemEntity.NickName;
      this.RandomNum = paramTroopFileTansferItemEntity.RandomNum;
      this.NameForSave = paramTroopFileTansferItemEntity.NameForSave;
      this.SafeCheckRes = paramTroopFileTansferItemEntity.SafeCheckRes;
      this.ForwardPath = paramTroopFileTansferItemEntity.ForwardPath;
      this.ForwardBusId = paramTroopFileTansferItemEntity.ForwardBusId;
      this.ForwardTroopuin = paramTroopFileTansferItemEntity.ForwardTroopuin;
      this.mParentId = paramTroopFileTansferItemEntity.mParentId;
      this.width = paramTroopFileTansferItemEntity.width;
      this.height = paramTroopFileTansferItemEntity.height;
      this.duration = paramTroopFileTansferItemEntity.duration;
      this.isZipInnerFile = paramTroopFileTansferItemEntity.isZipInnerFile;
      this.zipType = paramTroopFileTansferItemEntity.zipType;
      this.zipFilePath = paramTroopFileTansferItemEntity.zipFilePath;
      this.zipBusId = paramTroopFileTansferItemEntity.zipBusId;
      this.zipInnerPath = paramTroopFileTansferItemEntity.zipInnerPath;
      this.smallThumbFile = paramTroopFileTansferItemEntity.smallThumbFile;
      this.largeThumbnailFile = paramTroopFileTansferItemEntity.largeThumbnailFile;
      this.middleThumbnailFile = paramTroopFileTansferItemEntity.middleThumbnailFile;
      this.yybApkPackageName = paramTroopFileTansferItemEntity.yybApkPackageName;
      this.yybApkName = paramTroopFileTansferItemEntity.yybApkName;
      this.yybApkIconUrl = paramTroopFileTansferItemEntity.yybApkIconUrl;
    }
    
    public final boolean canFetchThumbnailFile(int paramInt)
    {
      if (this.Status == 4) {}
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                  if (QLog.isColorLevel()) {
                    QLog.i("TroopFileTransferManager", 1, "canFetchThumbnailFile : fileId[" + this.Id + "] thumbSize[" + paramInt + "]");
                  }
                  if (paramInt != 128) {
                    break;
                  }
                } while (this.ThumbnailDownloading_Small);
                l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Small;
              } while ((this.ThumbnailFileTimeMS_Small != 0L) && (l <= 300000L) && (l >= 0L));
              return true;
              if (paramInt != 640) {
                break;
              }
            } while (this.ThumbnailDownloading_Large);
            l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Large;
          } while ((this.ThumbnailFileTimeMS_Large != 0L) && (l <= 300000L) && (l >= 0L));
          return true;
        } while (paramInt != 383);
        l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Middle;
        if (l > 30000L) {
          this.ThumbnailDownloading_Middle = false;
        }
      } while ((this.ThumbnailDownloading_Middle) || ((this.ThumbnailFileTimeMS_Middle != 0L) && (l <= 300000L) && (l >= 0L)));
      return true;
    }
    
    public final void deleteThumbnailFile(long paramLong, int paramInt)
    {
      if (paramInt == 128) {
        if (this.HasThumbnailFile_Small) {
          new File(getThumbnailFile(paramLong, 128)).delete();
        }
      }
      do
      {
        do
        {
          return;
          if (paramInt != 383) {
            break;
          }
        } while (!this.HasThumbnailFile_Middle);
        new File(getThumbnailFile(paramLong, 383)).delete();
        return;
      } while ((paramInt != 640) || (!this.HasThumbnailFile_Large));
      new File(getThumbnailFile(paramLong, 640)).delete();
    }
    
    public final apcy getInfo(long paramLong)
    {
      apcy localapcy = new apcy();
      localapcy.TroopUin = paramLong;
      localapcy.Id = this.Id;
      localapcy.ProgressValue = this.ProgressValue;
      localapcy.Status = this.Status;
      localapcy.IsNewStatus = this.IsNewStatus;
      localapcy.ErrorCode = this.ErrorCode;
      localapcy.BusId = this.BusId;
      if (this.HasThumbnailFile_Small)
      {
        str = getThumbnailFile(paramLong, 128);
        localapcy.ThumbnailFile_Small = str;
        if (!this.HasThumbnailFile_Large) {
          break label376;
        }
        str = getThumbnailFile(paramLong, 640);
        label107:
        localapcy.ThumbnailFile_Large = str;
        if (!this.HasThumbnailFile_Middle) {
          break label398;
        }
        str = getThumbnailFile(paramLong, 383);
        label129:
        localapcy.coc = str;
        localapcy.ProgressTotal = this.ProgressTotal;
        localapcy.UploadTime = this.UploadTime;
        localapcy.FilePath = this.FilePath;
        if ((TextUtils.isEmpty(this.NameForSave)) || (this.SafeCheckRes != 2)) {
          break label420;
        }
        localapcy.FileName = this.NameForSave;
        label189:
        localapcy.LocalFile = this.LocalFile;
        localapcy.NickName = this.NickName;
        localapcy.entrySessionID = this.entrySessionID;
        if (!TextUtils.isEmpty(this.mParentId)) {
          break label432;
        }
      }
      label398:
      label420:
      label432:
      for (String str = "/";; str = this.mParentId)
      {
        localapcy.mParentId = str;
        localapcy.cPV = this.ThumbnailDownloading_Middle_Fail;
        if ((localapcy.cPV) && (!ahbj.fileExistsAndNotEmpty(localapcy.coc))) {
          localapcy.coc = null;
        }
        localapcy.dTo = this.width;
        localapcy.dTp = this.height;
        localapcy.dTq = this.duration;
        localapcy.mExcitingSpeed = this.mExcitingSpeed;
        localapcy.thumbInvalidCode = this.thumbInvalidCode;
        localapcy.genThumb_Middle_OnGettedLargeOrOrigPic = this.genThumb_Middle_OnGettedLargeOrOrigPic;
        localapcy.yybApkPackageName = this.yybApkPackageName;
        localapcy.yybApkName = this.yybApkName;
        localapcy.yybApkIconUrl = this.yybApkIconUrl;
        return localapcy;
        if (canFetchThumbnailFile(128))
        {
          str = null;
          break;
        }
        str = "";
        break;
        label376:
        if (canFetchThumbnailFile(640))
        {
          str = null;
          break label107;
        }
        str = "";
        break label107;
        if (canFetchThumbnailFile(383))
        {
          str = null;
          break label129;
        }
        str = "";
        break label129;
        localapcy.FileName = this.FileName;
        break label189;
      }
    }
    
    public final String getThumbnailFile(long paramLong, int paramInt)
    {
      if (paramInt == 128) {
        return acbn.bmj + "[Thumb]" + paramLong + "-" + this.Id.toString();
      }
      if (paramInt == 383) {
        return acbn.bmj + "[Thumb]" + 320 + paramLong + "-" + this.Id.toString();
      }
      return acbn.bmj + "[Thumb]" + paramInt + paramLong + "-" + this.Id.toString();
    }
  }
  
  public abstract class Task
    implements Runnable
  {
    public boolean cSh;
    public boolean cSi;
    public TroopFileTransferManager.Item e;
    public int type;
    
    protected Task(TroopFileTransferManager.Item paramItem, int paramInt)
    {
      this.e = paramItem;
      this.type = paramInt;
    }
  }
  
  public class TaskGenThumbnail
    extends TroopFileTransferManager.Task
  {
    public int dVJ;
    
    public TaskGenThumbnail(TroopFileTransferManager.Item paramItem, int paramInt)
    {
      super(paramItem, 1);
      this.dVJ = paramInt;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: iconst_1
      //   4: istore 5
      //   6: iconst_1
      //   7: istore_3
      //   8: aload_0
      //   9: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   12: getfield 40	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   15: invokestatic 46	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
      //   18: invokestatic 52	ahav:getFileType	(Ljava/lang/String;)I
      //   21: istore_1
      //   22: aload_0
      //   23: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   26: astore 6
      //   28: aload 6
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   35: getfield 55	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
      //   38: bipush 12
      //   40: if_icmpne +7 -> 47
      //   43: aload 6
      //   45: monitorexit
      //   46: return
      //   47: aload_0
      //   48: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   51: aload_0
      //   52: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   55: getfield 59	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   58: aload_0
      //   59: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   62: invokevirtual 63	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
      //   65: astore 9
      //   67: new 65	java/lang/StringBuilder
      //   70: dup
      //   71: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   74: aload 9
      //   76: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: ldc 73
      //   81: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   84: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   87: astore 10
      //   89: aload 6
      //   91: monitorexit
      //   92: iload_1
      //   93: iconst_2
      //   94: if_icmpne +575 -> 669
      //   97: aconst_null
      //   98: aload_0
      //   99: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   102: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   105: invokestatic 86	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   108: astore 8
      //   110: aload 8
      //   112: ifnull +855 -> 967
      //   115: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   118: ifeq +60 -> 178
      //   121: ldc 94
      //   123: iconst_2
      //   124: new 65	java/lang/StringBuilder
      //   127: dup
      //   128: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   131: ldc 96
      //   133: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   136: aload_0
      //   137: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   140: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   143: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   146: ldc 98
      //   148: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   151: aload 8
      //   153: invokevirtual 104	android/graphics/Bitmap:getWidth	()I
      //   156: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   159: ldc 109
      //   161: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: aload 8
      //   166: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
      //   169: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   172: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   175: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   178: new 118	java/io/File
      //   181: dup
      //   182: aload 10
      //   184: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
      //   187: astore 6
      //   189: aload 6
      //   191: invokevirtual 124	java/io/File:exists	()Z
      //   194: ifeq +9 -> 203
      //   197: aload 6
      //   199: invokevirtual 127	java/io/File:delete	()Z
      //   202: pop
      //   203: aload 6
      //   205: invokevirtual 130	java/io/File:createNewFile	()Z
      //   208: pop
      //   209: new 132	java/io/BufferedOutputStream
      //   212: dup
      //   213: new 134	java/io/FileOutputStream
      //   216: dup
      //   217: aload 6
      //   219: invokespecial 137	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   222: invokespecial 140	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   225: astore 7
      //   227: aload 7
      //   229: astore 6
      //   231: aload 8
      //   233: getstatic 146	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
      //   236: bipush 100
      //   238: aload 7
      //   240: invokevirtual 150	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   243: pop
      //   244: aload 7
      //   246: astore 6
      //   248: aload 8
      //   250: invokevirtual 153	android/graphics/Bitmap:recycle	()V
      //   253: aload 7
      //   255: astore 6
      //   257: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   260: ifeq +48 -> 308
      //   263: aload 7
      //   265: astore 6
      //   267: ldc 94
      //   269: iconst_2
      //   270: new 65	java/lang/StringBuilder
      //   273: dup
      //   274: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   277: ldc 155
      //   279: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   282: aload_0
      //   283: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   286: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   289: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   292: ldc 157
      //   294: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   297: aload 10
      //   299: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   302: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   305: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   308: aload 7
      //   310: astore 6
      //   312: aload 7
      //   314: invokevirtual 160	java/io/BufferedOutputStream:flush	()V
      //   317: iload_3
      //   318: istore_2
      //   319: aload 7
      //   321: ifnull +10 -> 331
      //   324: aload 7
      //   326: invokevirtual 163	java/io/BufferedOutputStream:close	()V
      //   329: iload_3
      //   330: istore_2
      //   331: aload_0
      //   332: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   335: astore 6
      //   337: aload 6
      //   339: monitorenter
      //   340: iload_2
      //   341: ifeq +485 -> 826
      //   344: new 118	java/io/File
      //   347: dup
      //   348: aload 10
      //   350: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
      //   353: astore 7
      //   355: aload 7
      //   357: new 118	java/io/File
      //   360: dup
      //   361: aload 9
      //   363: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
      //   366: invokevirtual 167	java/io/File:renameTo	(Ljava/io/File;)Z
      //   369: pop
      //   370: aload 7
      //   372: invokevirtual 170	java/io/File:deleteOnExit	()V
      //   375: aload_0
      //   376: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   379: sipush 128
      //   382: if_icmpne +520 -> 902
      //   385: aload_0
      //   386: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   389: iconst_0
      //   390: putfield 174	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   393: aload_0
      //   394: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   397: aload_0
      //   398: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   401: aload_0
      //   402: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   405: invokevirtual 178	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
      //   408: pop
      //   409: aload_0
      //   410: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   413: lconst_0
      //   414: putfield 181	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
      //   417: aload_0
      //   418: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   421: getfield 185	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
      //   424: aload_0
      //   425: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   428: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
      //   431: invokeinterface 195 2 0
      //   436: ifeq +14 -> 450
      //   439: aload_0
      //   440: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   443: aload_0
      //   444: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   447: invokevirtual 198	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   450: aload 6
      //   452: monitorexit
      //   453: return
      //   454: astore 7
      //   456: aload 6
      //   458: monitorexit
      //   459: aload 7
      //   461: athrow
      //   462: astore 7
      //   464: aload 6
      //   466: monitorexit
      //   467: aload 7
      //   469: athrow
      //   470: astore 7
      //   472: aload 7
      //   474: invokevirtual 201	java/io/IOException:printStackTrace	()V
      //   477: goto -268 -> 209
      //   480: astore 6
      //   482: iconst_0
      //   483: istore_3
      //   484: iload_3
      //   485: istore_2
      //   486: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   489: ifeq -158 -> 331
      //   492: ldc 94
      //   494: iconst_2
      //   495: new 65	java/lang/StringBuilder
      //   498: dup
      //   499: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   502: ldc 96
      //   504: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   507: aload_0
      //   508: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   511: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   514: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   517: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   520: aload 6
      //   522: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   525: iload_3
      //   526: istore_2
      //   527: goto -196 -> 331
      //   530: astore 6
      //   532: aload 6
      //   534: invokevirtual 205	java/lang/Exception:printStackTrace	()V
      //   537: iload_3
      //   538: istore_2
      //   539: goto -208 -> 331
      //   542: astore 6
      //   544: iload 4
      //   546: istore_3
      //   547: goto -63 -> 484
      //   550: astore 8
      //   552: aconst_null
      //   553: astore 7
      //   555: aload 7
      //   557: astore 6
      //   559: aload 8
      //   561: invokevirtual 206	java/io/FileNotFoundException:printStackTrace	()V
      //   564: aload 7
      //   566: ifnull +401 -> 967
      //   569: aload 7
      //   571: invokevirtual 163	java/io/BufferedOutputStream:close	()V
      //   574: iconst_0
      //   575: istore_2
      //   576: goto -245 -> 331
      //   579: astore 6
      //   581: aload 6
      //   583: invokevirtual 205	java/lang/Exception:printStackTrace	()V
      //   586: iconst_0
      //   587: istore_2
      //   588: goto -257 -> 331
      //   591: astore 7
      //   593: aconst_null
      //   594: astore 6
      //   596: aload 6
      //   598: ifnull +8 -> 606
      //   601: aload 6
      //   603: invokevirtual 163	java/io/BufferedOutputStream:close	()V
      //   606: aload 7
      //   608: athrow
      //   609: astore 6
      //   611: iconst_0
      //   612: istore_3
      //   613: iload_3
      //   614: istore_2
      //   615: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   618: ifeq -287 -> 331
      //   621: ldc 94
      //   623: iconst_2
      //   624: new 65	java/lang/StringBuilder
      //   627: dup
      //   628: invokespecial 67	java/lang/StringBuilder:<init>	()V
      //   631: ldc 96
      //   633: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   636: aload_0
      //   637: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   640: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   643: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   646: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   649: aload 6
      //   651: invokestatic 204	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   654: iload_3
      //   655: istore_2
      //   656: goto -325 -> 331
      //   659: astore 6
      //   661: aload 6
      //   663: invokevirtual 205	java/lang/Exception:printStackTrace	()V
      //   666: goto -60 -> 606
      //   669: aload_0
      //   670: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   673: sipush 383
      //   676: if_icmpeq +13 -> 689
      //   679: aload_0
      //   680: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   683: sipush 640
      //   686: if_icmpne +116 -> 802
      //   689: aload_0
      //   690: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   693: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   696: astore 6
      //   698: aload_0
      //   699: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   702: sipush 383
      //   705: if_icmpne +43 -> 748
      //   708: aload_0
      //   709: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   712: aload_0
      //   713: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   716: getfield 59	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   719: sipush 640
      //   722: invokevirtual 63	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
      //   725: astore 7
      //   727: aload 7
      //   729: astore 6
      //   731: aload 7
      //   733: invokestatic 210	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
      //   736: ifne +12 -> 748
      //   739: aload_0
      //   740: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   743: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   746: astore 6
      //   748: aload_0
      //   749: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   752: sipush 640
      //   755: if_icmpne +207 -> 962
      //   758: iconst_2
      //   759: istore_1
      //   760: aload 6
      //   762: invokestatic 210	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
      //   765: ifeq +32 -> 797
      //   768: aload 6
      //   770: aload 10
      //   772: iconst_1
      //   773: ldc 212
      //   775: iload_1
      //   776: invokestatic 217	akyr:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;I)Z
      //   779: pop
      //   780: iload_3
      //   781: istore_2
      //   782: goto -451 -> 331
      //   785: astore 6
      //   787: aload 6
      //   789: invokevirtual 205	java/lang/Exception:printStackTrace	()V
      //   792: iconst_0
      //   793: istore_2
      //   794: goto -463 -> 331
      //   797: iconst_0
      //   798: istore_2
      //   799: goto -468 -> 331
      //   802: aload_0
      //   803: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   806: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   809: aload 10
      //   811: aload_0
      //   812: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   815: aload_0
      //   816: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   819: invokestatic 223	apsv:f	(Ljava/lang/String;Ljava/lang/String;II)Z
      //   822: istore_2
      //   823: goto -492 -> 331
      //   826: new 118	java/io/File
      //   829: dup
      //   830: aload 10
      //   832: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
      //   835: invokevirtual 127	java/io/File:delete	()Z
      //   838: pop
      //   839: aload_0
      //   840: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   843: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
      //   846: ifnull -471 -> 375
      //   849: aload_0
      //   850: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   853: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   856: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   859: ifne +23 -> 882
      //   862: new 118	java/io/File
      //   865: dup
      //   866: aload_0
      //   867: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   870: getfield 80	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   873: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
      //   876: invokevirtual 124	java/io/File:exists	()Z
      //   879: ifne -504 -> 375
      //   882: aload_0
      //   883: getfield 15	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   886: aload_0
      //   887: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   890: aload_0
      //   891: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   894: iconst_0
      //   895: invokevirtual 235	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;IZ)V
      //   898: aload 6
      //   900: monitorexit
      //   901: return
      //   902: aload_0
      //   903: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   906: sipush 640
      //   909: if_icmpne +14 -> 923
      //   912: aload_0
      //   913: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   916: iconst_0
      //   917: putfield 238	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   920: goto -527 -> 393
      //   923: aload_0
      //   924: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:dVJ	I
      //   927: sipush 383
      //   930: if_icmpne -537 -> 393
      //   933: aload_0
      //   934: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskGenThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   937: iconst_0
      //   938: putfield 241	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   941: goto -548 -> 393
      //   944: astore 6
      //   946: iload 5
      //   948: istore_3
      //   949: goto -336 -> 613
      //   952: astore 7
      //   954: goto -358 -> 596
      //   957: astore 8
      //   959: goto -404 -> 555
      //   962: iconst_1
      //   963: istore_1
      //   964: goto -204 -> 760
      //   967: iconst_0
      //   968: istore_2
      //   969: goto -638 -> 331
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	972	0	this	TaskGenThumbnail
      //   21	943	1	i	int
      //   318	651	2	bool1	boolean
      //   7	942	3	bool2	boolean
      //   1	544	4	bool3	boolean
      //   4	943	5	bool4	boolean
      //   26	439	6	localObject1	Object
      //   480	41	6	localException1	Exception
      //   530	3	6	localException2	Exception
      //   542	1	6	localException3	Exception
      //   557	1	6	localObject2	Object
      //   579	3	6	localException4	Exception
      //   594	8	6	localObject3	Object
      //   609	41	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
      //   659	3	6	localException5	Exception
      //   696	73	6	localObject4	Object
      //   785	114	6	localException6	Exception
      //   944	1	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
      //   225	146	7	localObject5	Object
      //   454	6	7	localObject6	Object
      //   462	6	7	localObject7	Object
      //   470	3	7	localIOException	IOException
      //   553	17	7	localObject8	Object
      //   591	16	7	localObject9	Object
      //   725	7	7	str1	String
      //   952	1	7	localObject10	Object
      //   108	141	8	localBitmap	android.graphics.Bitmap
      //   550	10	8	localFileNotFoundException1	java.io.FileNotFoundException
      //   957	1	8	localFileNotFoundException2	java.io.FileNotFoundException
      //   65	297	9	str2	String
      //   87	744	10	str3	String
      // Exception table:
      //   from	to	target	type
      //   344	375	454	finally
      //   375	393	454	finally
      //   393	450	454	finally
      //   450	453	454	finally
      //   456	459	454	finally
      //   826	882	454	finally
      //   882	901	454	finally
      //   902	920	454	finally
      //   923	941	454	finally
      //   31	46	462	finally
      //   47	92	462	finally
      //   464	467	462	finally
      //   203	209	470	java/io/IOException
      //   97	110	480	java/lang/Exception
      //   115	178	480	java/lang/Exception
      //   178	203	480	java/lang/Exception
      //   203	209	480	java/lang/Exception
      //   472	477	480	java/lang/Exception
      //   581	586	480	java/lang/Exception
      //   606	609	480	java/lang/Exception
      //   661	666	480	java/lang/Exception
      //   324	329	530	java/lang/Exception
      //   532	537	542	java/lang/Exception
      //   209	227	550	java/io/FileNotFoundException
      //   569	574	579	java/lang/Exception
      //   209	227	591	finally
      //   97	110	609	java/lang/OutOfMemoryError
      //   115	178	609	java/lang/OutOfMemoryError
      //   178	203	609	java/lang/OutOfMemoryError
      //   203	209	609	java/lang/OutOfMemoryError
      //   472	477	609	java/lang/OutOfMemoryError
      //   569	574	609	java/lang/OutOfMemoryError
      //   581	586	609	java/lang/OutOfMemoryError
      //   601	606	609	java/lang/OutOfMemoryError
      //   606	609	609	java/lang/OutOfMemoryError
      //   661	666	609	java/lang/OutOfMemoryError
      //   601	606	659	java/lang/Exception
      //   760	780	785	java/lang/Exception
      //   324	329	944	java/lang/OutOfMemoryError
      //   532	537	944	java/lang/OutOfMemoryError
      //   231	244	952	finally
      //   248	253	952	finally
      //   257	263	952	finally
      //   267	308	952	finally
      //   312	317	952	finally
      //   559	564	952	finally
      //   231	244	957	java/io/FileNotFoundException
      //   248	253	957	java/io/FileNotFoundException
      //   257	263	957	java/io/FileNotFoundException
      //   267	308	957	java/io/FileNotFoundException
      //   312	317	957	java/io/FileNotFoundException
    }
  }
  
  public class TaskHttpDownload
    extends TroopFileTransferManager.Task
  {
    public TaskHttpDownload(TroopFileTransferManager.Item paramItem)
    {
      super(paramItem, 3);
      this.cSi = true;
    }
    
    /* Error */
    private java.net.HttpURLConnection a(String paramString1, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean, TroopFileTransferManager.a parama)
    {
      // Byte code:
      //   0: new 31	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   7: lload_2
      //   8: invokevirtual 38	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   11: ldc 40
      //   13: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   19: astore 10
      //   21: new 31	java/lang/StringBuilder
      //   24: dup
      //   25: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   28: aload_1
      //   29: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: ldc 49
      //   34: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: lload_2
      //   38: invokevirtual 38	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   41: ldc 51
      //   43: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   49: astore 9
      //   51: ldc 53
      //   53: iconst_1
      //   54: new 31	java/lang/StringBuilder
      //   57: dup
      //   58: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   61: ldc 55
      //   63: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: aload 9
      //   68: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   71: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   74: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   77: aload_0
      //   78: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   81: aload 9
      //   83: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
      //   86: aload_0
      //   87: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   90: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   93: putfield 81	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
      //   96: new 83	java/net/URL
      //   99: dup
      //   100: aload 9
      //   102: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
      //   105: astore_1
      //   106: aload_1
      //   107: invokevirtual 90	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   110: checkcast 92	java/net/HttpURLConnection
      //   113: astore 6
      //   115: aload 6
      //   117: ifnonnull +30 -> 147
      //   120: aconst_null
      //   121: astore_1
      //   122: aload_1
      //   123: areturn
      //   124: astore_1
      //   125: iload 7
      //   127: ifeq +18 -> 145
      //   130: aload_0
      //   131: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   134: aload_0
      //   135: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   138: bipush 10
      //   140: bipush 102
      //   142: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   145: aconst_null
      //   146: areturn
      //   147: aload 6
      //   149: sipush 30000
      //   152: invokevirtual 99	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   155: aload 6
      //   157: sipush 30000
      //   160: invokevirtual 102	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   163: aload 6
      //   165: ldc 104
      //   167: invokevirtual 107	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   170: aload 6
      //   172: ldc 109
      //   174: ldc 111
      //   176: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   179: lload 4
      //   181: lconst_0
      //   182: lcmp
      //   183: ifeq +30 -> 213
      //   186: aload 6
      //   188: ldc 117
      //   190: new 31	java/lang/StringBuilder
      //   193: dup
      //   194: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   197: ldc 119
      //   199: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   202: aload 10
      //   204: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   210: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   213: aload 6
      //   215: ldc 121
      //   217: ldc 123
      //   219: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   222: aload 8
      //   224: ifnull +13 -> 237
      //   227: aload 8
      //   229: aload 6
      //   231: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   234: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:dVI	I
      //   237: aload 6
      //   239: astore_1
      //   240: aload 6
      //   242: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   245: sipush 200
      //   248: if_icmpeq -126 -> 122
      //   251: aload 6
      //   253: astore_1
      //   254: aload 6
      //   256: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   259: sipush 206
      //   262: if_icmpeq -140 -> 122
      //   265: aload 6
      //   267: ldc 135
      //   269: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   272: astore_1
      //   273: aload_1
      //   274: ifnull +14 -> 288
      //   277: aload 8
      //   279: ifnull +9 -> 288
      //   282: aload 8
      //   284: aload_1
      //   285: putfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:crb	Ljava/lang/String;
      //   288: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   291: ifeq +41 -> 332
      //   294: ldc 53
      //   296: iconst_2
      //   297: new 31	java/lang/StringBuilder
      //   300: dup
      //   301: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   304: ldc 148
      //   306: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   309: aload 6
      //   311: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   314: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   317: ldc 153
      //   319: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   322: aload_1
      //   323: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   329: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   332: aconst_null
      //   333: areturn
      //   334: astore_1
      //   335: aload_1
      //   336: invokevirtual 158	java/io/IOException:printStackTrace	()V
      //   339: aconst_null
      //   340: areturn
      //   341: astore_1
      //   342: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   345: ifeq +41 -> 386
      //   348: ldc 53
      //   350: iconst_2
      //   351: new 31	java/lang/StringBuilder
      //   354: dup
      //   355: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   358: ldc 160
      //   360: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   363: aload 9
      //   365: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   368: ldc 162
      //   370: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   373: aload_1
      //   374: invokevirtual 165	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
      //   377: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   380: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   383: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   386: aconst_null
      //   387: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	388	0	this	TaskHttpDownload
      //   0	388	1	paramString1	String
      //   0	388	2	paramLong1	long
      //   0	388	4	paramLong2	long
      //   0	388	6	paramString2	String
      //   0	388	7	paramBoolean	boolean
      //   0	388	8	parama	TroopFileTransferManager.a
      //   49	315	9	str1	String
      //   19	184	10	str2	String
      // Exception table:
      //   from	to	target	type
      //   96	106	124	java/net/MalformedURLException
      //   106	115	334	java/io/IOException
      //   147	179	334	java/io/IOException
      //   186	213	334	java/io/IOException
      //   213	222	334	java/io/IOException
      //   227	237	334	java/io/IOException
      //   240	251	334	java/io/IOException
      //   254	273	334	java/io/IOException
      //   282	288	334	java/io/IOException
      //   288	332	334	java/io/IOException
      //   106	115	341	java/lang/NullPointerException
      //   147	179	341	java/lang/NullPointerException
      //   186	213	341	java/lang/NullPointerException
      //   213	222	341	java/lang/NullPointerException
      //   227	237	341	java/lang/NullPointerException
      //   240	251	341	java/lang/NullPointerException
      //   254	273	341	java/lang/NullPointerException
      //   282	288	341	java/lang/NullPointerException
      //   288	332	341	java/lang/NullPointerException
    }
    
    /* Error */
    private java.net.HttpURLConnection a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4, String paramString5, boolean paramBoolean, TroopFileTransferManager.a parama)
    {
      // Byte code:
      //   0: new 31	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   7: lload 4
      //   9: invokevirtual 38	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   12: ldc 40
      //   14: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   17: lload 6
      //   19: lconst_1
      //   20: lsub
      //   21: invokevirtual 38	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   24: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   27: astore 12
      //   29: lload 4
      //   31: lconst_0
      //   32: lcmp
      //   33: ifne +117 -> 150
      //   36: new 31	java/lang/StringBuilder
      //   39: dup
      //   40: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   43: ldc 170
      //   45: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: aload_1
      //   49: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: ldc 172
      //   54: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   57: aload_2
      //   58: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   61: ldc 174
      //   63: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: aload_3
      //   67: invokestatic 179	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
      //   70: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: aload 9
      //   75: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   81: astore_1
      //   82: ldc 53
      //   84: iconst_1
      //   85: new 31	java/lang/StringBuilder
      //   88: dup
      //   89: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   92: ldc 181
      //   94: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: aload_1
      //   98: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   101: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   104: invokestatic 61	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   107: aload_0
      //   108: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   111: aload_1
      //   112: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:downUrlStr4Report	Ljava/lang/String;
      //   115: aload_0
      //   116: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   119: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   122: putfield 81	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
      //   125: new 83	java/net/URL
      //   128: dup
      //   129: aload_1
      //   130: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
      //   133: astore_2
      //   134: aload_2
      //   135: invokevirtual 90	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   138: checkcast 92	java/net/HttpURLConnection
      //   141: astore_3
      //   142: aload_3
      //   143: ifnonnull +89 -> 232
      //   146: aconst_null
      //   147: astore_2
      //   148: aload_2
      //   149: areturn
      //   150: new 31	java/lang/StringBuilder
      //   153: dup
      //   154: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   157: ldc 170
      //   159: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: aload_1
      //   163: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: ldc 172
      //   168: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   171: aload_2
      //   172: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: ldc 174
      //   177: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   180: aload_3
      //   181: invokestatic 179	aqhs:String2HexString	(Ljava/lang/String;)Ljava/lang/String;
      //   184: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: ldc 183
      //   189: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   192: aload 12
      //   194: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   197: aload 9
      //   199: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   202: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   205: astore_1
      //   206: goto -124 -> 82
      //   209: astore_1
      //   210: iload 10
      //   212: ifeq +18 -> 230
      //   215: aload_0
      //   216: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   219: aload_0
      //   220: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   223: bipush 10
      //   225: bipush 102
      //   227: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   230: aconst_null
      //   231: areturn
      //   232: aload_3
      //   233: sipush 30000
      //   236: invokevirtual 99	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   239: aload_3
      //   240: sipush 30000
      //   243: invokevirtual 102	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   246: aload_3
      //   247: ldc 104
      //   249: invokevirtual 107	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   252: aload_3
      //   253: ldc 109
      //   255: ldc 185
      //   257: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   260: lload 6
      //   262: lconst_0
      //   263: lcmp
      //   264: ifeq +29 -> 293
      //   267: aload_3
      //   268: ldc 117
      //   270: new 31	java/lang/StringBuilder
      //   273: dup
      //   274: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   277: ldc 119
      //   279: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   282: aload 12
      //   284: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   287: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   290: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   293: aload_3
      //   294: ldc 121
      //   296: ldc 123
      //   298: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   301: aload_3
      //   302: ldc 187
      //   304: new 31	java/lang/StringBuilder
      //   307: dup
      //   308: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   311: ldc 189
      //   313: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: aload 8
      //   318: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   321: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   324: invokevirtual 115	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   327: aload 11
      //   329: ifnull +12 -> 341
      //   332: aload 11
      //   334: aload_3
      //   335: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   338: putfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:dVI	I
      //   341: aload_3
      //   342: astore_2
      //   343: aload_3
      //   344: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   347: sipush 200
      //   350: if_icmpeq -202 -> 148
      //   353: aload_3
      //   354: astore_2
      //   355: aload_3
      //   356: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   359: sipush 206
      //   362: if_icmpeq -214 -> 148
      //   365: aload_3
      //   366: ldc 135
      //   368: invokevirtual 139	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   371: astore_2
      //   372: aload_2
      //   373: ifnull +14 -> 387
      //   376: aload 11
      //   378: ifnull +9 -> 387
      //   381: aload 11
      //   383: aload_2
      //   384: putfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:crb	Ljava/lang/String;
      //   387: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   390: ifeq +40 -> 430
      //   393: ldc 53
      //   395: iconst_2
      //   396: new 31	java/lang/StringBuilder
      //   399: dup
      //   400: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   403: ldc 148
      //   405: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   408: aload_3
      //   409: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   412: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   415: ldc 153
      //   417: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   420: aload_2
      //   421: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   424: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   427: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   430: aconst_null
      //   431: areturn
      //   432: astore_2
      //   433: ldc 53
      //   435: iconst_1
      //   436: new 31	java/lang/StringBuilder
      //   439: dup
      //   440: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   443: ldc 191
      //   445: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   448: aload_1
      //   449: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   452: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   455: aload_2
      //   456: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   459: aconst_null
      //   460: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	461	0	this	TaskHttpDownload
      //   0	461	1	paramString1	String
      //   0	461	2	paramString2	String
      //   0	461	3	paramString3	String
      //   0	461	4	paramLong1	long
      //   0	461	6	paramLong2	long
      //   0	461	8	paramString4	String
      //   0	461	9	paramString5	String
      //   0	461	10	paramBoolean	boolean
      //   0	461	11	parama	TroopFileTransferManager.a
      //   27	256	12	str	String
      // Exception table:
      //   from	to	target	type
      //   125	134	209	java/net/MalformedURLException
      //   134	142	432	java/lang/Exception
      //   232	260	432	java/lang/Exception
      //   267	293	432	java/lang/Exception
      //   293	327	432	java/lang/Exception
      //   332	341	432	java/lang/Exception
      //   343	353	432	java/lang/Exception
      //   355	372	432	java/lang/Exception
      //   381	387	432	java/lang/Exception
      //   387	430	432	java/lang/Exception
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   4: aload_0
      //   5: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   8: invokevirtual 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   11: ifeq +4 -> 15
      //   14: return
      //   15: invokestatic 208	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   18: ifeq +11 -> 29
      //   21: ldc 53
      //   23: iconst_4
      //   24: ldc 210
      //   26: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   29: invokestatic 218	arug:cC	()Z
      //   32: ifne +29 -> 61
      //   35: aload_0
      //   36: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   39: aload_0
      //   40: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   43: bipush 10
      //   45: sipush 308
      //   48: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   51: getstatic 223	apue$a:dVY	I
      //   54: getstatic 226	apue$a:dWk	I
      //   57: invokestatic 232	apue:jZ	(II)V
      //   60: return
      //   61: new 234	java/io/File
      //   64: dup
      //   65: getstatic 239	acbn:bmj	Ljava/lang/String;
      //   68: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
      //   71: astore 10
      //   73: aload 10
      //   75: invokevirtual 243	java/io/File:exists	()Z
      //   78: ifne +9 -> 87
      //   81: aload 10
      //   83: invokevirtual 246	java/io/File:mkdirs	()Z
      //   86: pop
      //   87: aload_0
      //   88: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   91: new 31	java/lang/StringBuilder
      //   94: dup
      //   95: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   98: getstatic 239	acbn:bmj	Ljava/lang/String;
      //   101: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: aload_0
      //   105: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   108: getfield 249	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
      //   111: invokevirtual 255	java/lang/String:getBytes	()[B
      //   114: invokestatic 259	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   117: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   120: ldc_w 261
      //   123: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   129: putfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
      //   132: new 234	java/io/File
      //   135: dup
      //   136: aload_0
      //   137: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   140: getfield 264	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:TmpFile	Ljava/lang/String;
      //   143: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
      //   146: astore 13
      //   148: aload 13
      //   150: invokevirtual 243	java/io/File:exists	()Z
      //   153: ifne +9 -> 162
      //   156: aload 13
      //   158: invokevirtual 267	java/io/File:createNewFile	()Z
      //   161: pop
      //   162: aload_0
      //   163: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   166: aload 13
      //   168: invokevirtual 270	java/io/File:length	()J
      //   171: putfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   174: aload_0
      //   175: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   178: iconst_0
      //   179: putfield 276	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
      //   182: aload_0
      //   183: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   186: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   189: aload_0
      //   190: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   193: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   196: lcmp
      //   197: ifgt +15 -> 212
      //   200: aload_0
      //   201: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   204: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   207: lconst_0
      //   208: lcmp
      //   209: ifne +25 -> 234
      //   212: iconst_0
      //   213: istore_3
      //   214: iconst_0
      //   215: istore_1
      //   216: aload_0
      //   217: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   220: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   223: aload_0
      //   224: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   227: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   230: lcmp
      //   231: ifne +353 -> 584
      //   234: aload_0
      //   235: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   238: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   241: invokevirtual 284	java/lang/String:length	()I
      //   244: bipush 85
      //   246: if_icmple +62 -> 308
      //   249: aload_0
      //   250: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   253: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   256: bipush 46
      //   258: invokevirtual 288	java/lang/String:lastIndexOf	(I)I
      //   261: istore_2
      //   262: iload_2
      //   263: istore_1
      //   264: iload_2
      //   265: ifge +5 -> 270
      //   268: iconst_0
      //   269: istore_1
      //   270: aload_0
      //   271: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   274: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   277: invokevirtual 284	java/lang/String:length	()I
      //   280: bipush 85
      //   282: isub
      //   283: istore_2
      //   284: iload_1
      //   285: ifne +1724 -> 2009
      //   288: aload_0
      //   289: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   292: aload_0
      //   293: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   296: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   299: iconst_0
      //   300: bipush 85
      //   302: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
      //   305: putfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   308: aload_0
      //   309: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   312: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   315: astore 11
      //   317: aload 11
      //   319: astore 10
      //   321: aload_0
      //   322: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   325: getfield 295	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
      //   328: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   331: ifne +27 -> 358
      //   334: aload 11
      //   336: astore 10
      //   338: aload_0
      //   339: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   342: getfield 304	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:SafeCheckRes	I
      //   345: iconst_2
      //   346: if_icmpne +12 -> 358
      //   349: aload_0
      //   350: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   353: getfield 295	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:NameForSave	Ljava/lang/String;
      //   356: astore 10
      //   358: iconst_0
      //   359: istore_1
      //   360: iload_1
      //   361: sipush 1000
      //   364: if_icmpge +1738 -> 2102
      //   367: iload_1
      //   368: ifle +1701 -> 2069
      //   371: aload 10
      //   373: bipush 46
      //   375: invokevirtual 288	java/lang/String:lastIndexOf	(I)I
      //   378: istore_3
      //   379: iload_3
      //   380: istore_2
      //   381: iload_3
      //   382: ifge +5 -> 387
      //   385: iconst_0
      //   386: istore_2
      //   387: new 31	java/lang/StringBuilder
      //   390: dup
      //   391: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   394: getstatic 307	acbn:bmg	Ljava/lang/String;
      //   397: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: aload 10
      //   402: iconst_0
      //   403: iload_2
      //   404: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
      //   407: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   410: ldc_w 309
      //   413: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   416: iload_1
      //   417: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   420: ldc_w 311
      //   423: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   426: aload 10
      //   428: iload_2
      //   429: invokevirtual 314	java/lang/String:substring	(I)Ljava/lang/String;
      //   432: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   435: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   438: astore 11
      //   440: new 234	java/io/File
      //   443: dup
      //   444: aload 11
      //   446: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
      //   449: astore 12
      //   451: aload 12
      //   453: invokevirtual 243	java/io/File:exists	()Z
      //   456: ifne +1639 -> 2095
      //   459: aload 13
      //   461: aload 12
      //   463: invokevirtual 318	java/io/File:renameTo	(Ljava/io/File;)Z
      //   466: ifeq +1629 -> 2095
      //   469: aload_0
      //   470: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   473: aload 11
      //   475: putfield 321	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   478: aload_0
      //   479: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   482: aload_0
      //   483: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   486: bipush 11
      //   488: invokevirtual 324	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
      //   491: aload_0
      //   492: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   495: getfield 328	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
      //   498: invokestatic 259	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   501: astore 10
      //   503: aload_0
      //   504: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   507: getfield 331	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   510: invokestatic 259	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   513: astore 11
      //   515: aload_0
      //   516: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   519: aload_0
      //   520: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   523: aload_0
      //   524: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   527: getfield 334	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   530: invokevirtual 338	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
      //   533: iconst_0
      //   534: aload 10
      //   536: aload 11
      //   538: aload_0
      //   539: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   542: getfield 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
      //   545: invokevirtual 344	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lapcy;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   548: getstatic 347	apue$a:RESULT_SUCCESS	I
      //   551: iconst_0
      //   552: invokestatic 232	apue:jZ	(II)V
      //   555: return
      //   556: astore 10
      //   558: aload_0
      //   559: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   562: aload_0
      //   563: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   566: bipush 10
      //   568: sipush 303
      //   571: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   574: getstatic 223	apue$a:dVY	I
      //   577: getstatic 350	apue$a:dWe	I
      //   580: invokestatic 232	apue:jZ	(II)V
      //   583: return
      //   584: iload_1
      //   585: iconst_3
      //   586: if_icmplt +77 -> 663
      //   589: aload_0
      //   590: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   593: aload_0
      //   594: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   597: bipush 10
      //   599: bipush 105
      //   601: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   604: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   607: ifeq +35 -> 642
      //   610: ldc 53
      //   612: iconst_2
      //   613: new 31	java/lang/StringBuilder
      //   616: dup
      //   617: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   620: ldc_w 352
      //   623: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   626: aload_0
      //   627: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   630: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   633: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   636: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   639: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   642: iload_3
      //   643: ifne -629 -> 14
      //   646: getstatic 358	apue$a:dWa	I
      //   649: getstatic 361	apue$a:dWm	I
      //   652: aload_0
      //   653: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   656: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   659: invokestatic 365	apue:N	(IILjava/lang/String;)V
      //   662: return
      //   663: iload_1
      //   664: ifle +118 -> 782
      //   667: invokestatic 371	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   670: invokestatic 377	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
      //   673: ifne +28 -> 701
      //   676: aload_0
      //   677: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   680: aload_0
      //   681: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   684: bipush 10
      //   686: bipush 106
      //   688: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   691: getstatic 223	apue$a:dVY	I
      //   694: getstatic 380	apue$a:dWh	I
      //   697: invokestatic 232	apue:jZ	(II)V
      //   700: return
      //   701: iconst_0
      //   702: istore_2
      //   703: iload_2
      //   704: iload_1
      //   705: bipush 100
      //   707: imul
      //   708: if_icmpge +74 -> 782
      //   711: ldc2_w 381
      //   714: invokestatic 388	java/lang/Thread:sleep	(J)V
      //   717: aload_0
      //   718: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   721: aload_0
      //   722: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   725: invokevirtual 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   728: ifne -714 -> 14
      //   731: invokestatic 371	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   734: invokestatic 377	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
      //   737: ifne +38 -> 775
      //   740: aload_0
      //   741: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   744: aload_0
      //   745: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   748: bipush 10
      //   750: bipush 106
      //   752: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   755: getstatic 223	apue$a:dVY	I
      //   758: getstatic 380	apue$a:dWh	I
      //   761: invokestatic 232	apue:jZ	(II)V
      //   764: return
      //   765: astore 10
      //   767: aload 10
      //   769: invokevirtual 389	java/lang/InterruptedException:printStackTrace	()V
      //   772: goto -55 -> 717
      //   775: iload_2
      //   776: iconst_1
      //   777: iadd
      //   778: istore_2
      //   779: goto -76 -> 703
      //   782: aload_0
      //   783: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   786: aload_0
      //   787: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   790: invokevirtual 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   793: ifne -779 -> 14
      //   796: iload_1
      //   797: iconst_1
      //   798: iadd
      //   799: istore_1
      //   800: aload_0
      //   801: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   804: iload_1
      //   805: putfield 276	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
      //   808: aconst_null
      //   809: astore 12
      //   811: aconst_null
      //   812: astore 11
      //   814: new 129	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a
      //   817: dup
      //   818: aload_0
      //   819: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   822: invokespecial 392	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
      //   825: astore 14
      //   827: aload 12
      //   829: astore 10
      //   831: aload_0
      //   832: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   835: invokevirtual 395	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
      //   838: ifnull +251 -> 1089
      //   841: aload 12
      //   843: astore 10
      //   845: aload_0
      //   846: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   849: getfield 398	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
      //   852: ifne +237 -> 1089
      //   855: aload_0
      //   856: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   859: invokevirtual 395	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
      //   862: iconst_5
      //   863: invokeinterface 404 2 0
      //   868: astore 15
      //   870: aload 12
      //   872: astore 10
      //   874: aload 15
      //   876: ifnull +213 -> 1089
      //   879: aload 12
      //   881: astore 10
      //   883: aload 15
      //   885: invokeinterface 408 1 0
      //   890: ifne +199 -> 1089
      //   893: aload 15
      //   895: invokeinterface 412 1 0
      //   900: astore 12
      //   902: aload 11
      //   904: astore 10
      //   906: aload 12
      //   908: invokeinterface 417 1 0
      //   913: ifeq +176 -> 1089
      //   916: aload 12
      //   918: invokeinterface 421 1 0
      //   923: checkcast 423	mqq/manager/ProxyIpManager$ProxyIp
      //   926: astore 10
      //   928: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   931: ifeq +38 -> 969
      //   934: ldc 53
      //   936: iconst_2
      //   937: ldc_w 425
      //   940: iconst_2
      //   941: anewarray 427	java/lang/Object
      //   944: dup
      //   945: iconst_0
      //   946: aload 10
      //   948: getfield 430	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
      //   951: aastore
      //   952: dup
      //   953: iconst_1
      //   954: aload 10
      //   956: getfield 433	mqq/manager/ProxyIpManager$ProxyIp:port	I
      //   959: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   962: aastore
      //   963: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   966: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   969: ldc_w 445
      //   972: iconst_2
      //   973: anewarray 427	java/lang/Object
      //   976: dup
      //   977: iconst_0
      //   978: aload_0
      //   979: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   982: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   985: aastore
      //   986: dup
      //   987: iconst_1
      //   988: bipush 80
      //   990: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   993: aastore
      //   994: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   997: astore 11
      //   999: aload_0
      //   1000: aload 10
      //   1002: getfield 430	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
      //   1005: aload_0
      //   1006: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1009: getfield 448	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
      //   1012: aload_0
      //   1013: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1016: getfield 249	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
      //   1019: aload_0
      //   1020: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1023: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1026: aload_0
      //   1027: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1030: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1033: aload_0
      //   1034: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1037: getfield 451	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
      //   1040: aload 11
      //   1042: iconst_0
      //   1043: aload 14
      //   1045: invokespecial 453	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$a;)Ljava/net/HttpURLConnection;
      //   1048: astore 11
      //   1050: aload 11
      //   1052: astore 10
      //   1054: aload 11
      //   1056: ifnull -150 -> 906
      //   1059: aload 11
      //   1061: astore 10
      //   1063: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1066: ifeq +23 -> 1089
      //   1069: ldc 53
      //   1071: iconst_2
      //   1072: ldc_w 455
      //   1075: iconst_0
      //   1076: anewarray 427	java/lang/Object
      //   1079: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1082: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1085: aload 11
      //   1087: astore 10
      //   1089: aload 10
      //   1091: astore 11
      //   1093: aload 10
      //   1095: ifnonnull +315 -> 1410
      //   1098: aload_0
      //   1099: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1102: getfield 398	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
      //   1105: ifeq +218 -> 1323
      //   1108: aload_0
      //   1109: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1112: getfield 458	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
      //   1115: ifnull +208 -> 1323
      //   1118: aload_0
      //   1119: aload_0
      //   1120: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1123: getfield 458	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:PreviewUrl	Ljava/lang/String;
      //   1126: aload_0
      //   1127: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1130: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1133: aload_0
      //   1134: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1137: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1140: aload_0
      //   1141: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1144: getfield 451	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
      //   1147: iconst_0
      //   1148: aload 14
      //   1150: invokespecial 460	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;JJLjava/lang/String;ZLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$a;)Ljava/net/HttpURLConnection;
      //   1153: astore 10
      //   1155: aload 10
      //   1157: ifnonnull +223 -> 1380
      //   1160: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1163: ifeq +65 -> 1228
      //   1166: new 31	java/lang/StringBuilder
      //   1169: dup
      //   1170: ldc_w 462
      //   1173: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1176: astore 10
      //   1178: aload 10
      //   1180: iload_1
      //   1181: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1184: ldc_w 465
      //   1187: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1190: aload_0
      //   1191: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1194: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   1197: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1200: ldc_w 467
      //   1203: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1206: aload_0
      //   1207: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1210: getfield 448	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
      //   1213: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1216: pop
      //   1217: ldc 53
      //   1219: iconst_2
      //   1220: aload 10
      //   1222: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1225: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1228: iload_1
      //   1229: iconst_3
      //   1230: if_icmpne +942 -> 2172
      //   1233: getstatic 470	apue$a:dWw	I
      //   1236: istore_3
      //   1237: iload_3
      //   1238: istore_2
      //   1239: aload 14
      //   1241: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:dVI	I
      //   1244: sipush 200
      //   1247: if_icmpeq +22 -> 1269
      //   1250: iload_3
      //   1251: istore_2
      //   1252: aload 14
      //   1254: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:dVI	I
      //   1257: sipush 206
      //   1260: if_icmpeq +9 -> 1269
      //   1263: aload 14
      //   1265: getfield 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:dVI	I
      //   1268: istore_2
      //   1269: iload_2
      //   1270: istore_3
      //   1271: aload 14
      //   1273: getfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:crb	Ljava/lang/String;
      //   1276: ifnull +28 -> 1304
      //   1279: iload_2
      //   1280: istore_3
      //   1281: aload 14
      //   1283: getfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:crb	Ljava/lang/String;
      //   1286: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   1289: ifne +15 -> 1304
      //   1292: aload 14
      //   1294: getfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$a:crb	Ljava/lang/String;
      //   1297: invokestatic 473	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   1300: invokevirtual 476	java/lang/Integer:intValue	()I
      //   1303: istore_3
      //   1304: getstatic 358	apue$a:dWa	I
      //   1307: iload_3
      //   1308: aload_0
      //   1309: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1312: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   1315: invokestatic 365	apue:N	(IILjava/lang/String;)V
      //   1318: iconst_1
      //   1319: istore_3
      //   1320: goto -1104 -> 216
      //   1323: aload_0
      //   1324: aload_0
      //   1325: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1328: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   1331: aload_0
      //   1332: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1335: getfield 448	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
      //   1338: aload_0
      //   1339: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1342: getfield 249	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
      //   1345: aload_0
      //   1346: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1349: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1352: aload_0
      //   1353: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1356: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1359: aload_0
      //   1360: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1363: getfield 451	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
      //   1366: ldc_w 478
      //   1369: iconst_1
      //   1370: aload 14
      //   1372: invokespecial 453	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$a;)Ljava/net/HttpURLConnection;
      //   1375: astore 10
      //   1377: goto -222 -> 1155
      //   1380: aload 10
      //   1382: astore 11
      //   1384: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1387: ifeq +23 -> 1410
      //   1390: ldc 53
      //   1392: iconst_2
      //   1393: ldc_w 480
      //   1396: iconst_0
      //   1397: anewarray 427	java/lang/Object
      //   1400: invokestatic 443	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1403: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1406: aload 10
      //   1408: astore 11
      //   1410: iload_1
      //   1411: istore_2
      //   1412: new 482	java/io/BufferedInputStream
      //   1415: dup
      //   1416: aload 11
      //   1418: invokevirtual 486	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   1421: invokespecial 489	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   1424: astore 12
      //   1426: iload_1
      //   1427: istore_2
      //   1428: aload_0
      //   1429: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1432: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1435: lconst_0
      //   1436: lcmp
      //   1437: ifne +18 -> 1455
      //   1440: iload_1
      //   1441: istore_2
      //   1442: aload_0
      //   1443: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1446: aload 11
      //   1448: invokevirtual 492	java/net/HttpURLConnection:getContentLength	()I
      //   1451: i2l
      //   1452: putfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1455: iload_1
      //   1456: istore_2
      //   1457: new 494	java/io/FileOutputStream
      //   1460: dup
      //   1461: aload 13
      //   1463: iconst_1
      //   1464: invokespecial 497	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   1467: astore 10
      //   1469: iload_1
      //   1470: istore_2
      //   1471: sipush 8192
      //   1474: newarray byte
      //   1476: astore 14
      //   1478: iload_1
      //   1479: istore_2
      //   1480: aload 12
      //   1482: aload 14
      //   1484: invokevirtual 503	java/io/InputStream:read	([B)I
      //   1487: istore 4
      //   1489: iload 4
      //   1491: iconst_m1
      //   1492: if_icmpeq +484 -> 1976
      //   1495: iload_1
      //   1496: istore_2
      //   1497: aload_0
      //   1498: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1501: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1504: iload 4
      //   1506: i2l
      //   1507: ladd
      //   1508: aload_0
      //   1509: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1512: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1515: lcmp
      //   1516: ifle +246 -> 1762
      //   1519: iload_1
      //   1520: istore_2
      //   1521: aload_0
      //   1522: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1525: aload_0
      //   1526: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1529: bipush 10
      //   1531: sipush 305
      //   1534: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1537: iload_1
      //   1538: istore_2
      //   1539: getstatic 223	apue$a:dVY	I
      //   1542: getstatic 506	apue$a:dWn	I
      //   1545: invokestatic 232	apue:jZ	(II)V
      //   1548: aload 12
      //   1550: invokevirtual 509	java/io/InputStream:close	()V
      //   1553: aload 10
      //   1555: invokevirtual 510	java/io/FileOutputStream:close	()V
      //   1558: return
      //   1559: astore 10
      //   1561: return
      //   1562: astore 10
      //   1564: iload_1
      //   1565: istore_2
      //   1566: aload_0
      //   1567: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1570: aload_0
      //   1571: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1574: bipush 10
      //   1576: sipush 304
      //   1579: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1582: iload_1
      //   1583: istore_2
      //   1584: getstatic 223	apue$a:dVY	I
      //   1587: getstatic 513	apue$a:dWd	I
      //   1590: invokestatic 232	apue:jZ	(II)V
      //   1593: return
      //   1594: astore 10
      //   1596: invokestatic 208	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   1599: ifeq +33 -> 1632
      //   1602: ldc 53
      //   1604: iconst_4
      //   1605: new 31	java/lang/StringBuilder
      //   1608: dup
      //   1609: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   1612: ldc_w 515
      //   1615: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1618: aload 10
      //   1620: invokevirtual 516	java/io/IOException:toString	()Ljava/lang/String;
      //   1623: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1626: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1629: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1632: aload 10
      //   1634: instanceof 518
      //   1637: ifeq +86 -> 1723
      //   1640: sipush 206
      //   1643: aload 11
      //   1645: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   1648: if_icmpne +75 -> 1723
      //   1651: aload_0
      //   1652: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1655: aload_0
      //   1656: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1659: bipush 10
      //   1661: bipush 105
      //   1663: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1666: getstatic 358	apue$a:dWa	I
      //   1669: aload 11
      //   1671: invokevirtual 127	java/net/HttpURLConnection:getResponseCode	()I
      //   1674: aload_0
      //   1675: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1678: getfield 355	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   1681: invokestatic 365	apue:N	(IILjava/lang/String;)V
      //   1684: return
      //   1685: astore 11
      //   1687: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1690: ifeq +33 -> 1723
      //   1693: ldc 53
      //   1695: iconst_4
      //   1696: new 31	java/lang/StringBuilder
      //   1699: dup
      //   1700: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   1703: ldc_w 515
      //   1706: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1709: aload 10
      //   1711: invokevirtual 516	java/io/IOException:toString	()Ljava/lang/String;
      //   1714: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1717: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1720: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1723: iload_2
      //   1724: istore_1
      //   1725: invokestatic 208	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   1728: ifeq -1512 -> 216
      //   1731: ldc 53
      //   1733: iconst_4
      //   1734: new 31	java/lang/StringBuilder
      //   1737: dup
      //   1738: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   1741: ldc_w 520
      //   1744: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1747: iload_2
      //   1748: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1751: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1754: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1757: iload_2
      //   1758: istore_1
      //   1759: goto -1543 -> 216
      //   1762: iload_1
      //   1763: istore_2
      //   1764: aload 10
      //   1766: aload 14
      //   1768: iconst_0
      //   1769: iload 4
      //   1771: invokevirtual 524	java/io/FileOutputStream:write	([BII)V
      //   1774: iload_1
      //   1775: istore_2
      //   1776: aload_0
      //   1777: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1780: astore 15
      //   1782: iload_1
      //   1783: istore_2
      //   1784: aload 15
      //   1786: aload 15
      //   1788: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1791: iload 4
      //   1793: i2l
      //   1794: ladd
      //   1795: putfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1798: iload_1
      //   1799: istore_2
      //   1800: aload_0
      //   1801: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1804: astore 15
      //   1806: iload_1
      //   1807: istore_2
      //   1808: aload 15
      //   1810: aload 15
      //   1812: getfield 527	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
      //   1815: iload 4
      //   1817: i2l
      //   1818: ladd
      //   1819: putfield 527	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
      //   1822: iload_1
      //   1823: istore_2
      //   1824: aload_0
      //   1825: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1828: iconst_1
      //   1829: iload 4
      //   1831: i2l
      //   1832: invokestatic 530	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
      //   1835: iload_1
      //   1836: istore_2
      //   1837: aload_0
      //   1838: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1841: aload_0
      //   1842: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1845: invokevirtual 205	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   1848: istore 5
      //   1850: iload 5
      //   1852: ifeq +62 -> 1914
      //   1855: aload 12
      //   1857: invokevirtual 509	java/io/InputStream:close	()V
      //   1860: aload 10
      //   1862: invokevirtual 510	java/io/FileOutputStream:close	()V
      //   1865: return
      //   1866: astore 10
      //   1868: return
      //   1869: astore 14
      //   1871: iload_1
      //   1872: istore_2
      //   1873: aload_0
      //   1874: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1877: aload_0
      //   1878: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1881: bipush 10
      //   1883: sipush 306
      //   1886: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1889: iload_1
      //   1890: istore_2
      //   1891: getstatic 223	apue$a:dVY	I
      //   1894: getstatic 533	apue$a:dWf	I
      //   1897: invokestatic 232	apue:jZ	(II)V
      //   1900: aload 12
      //   1902: invokevirtual 509	java/io/InputStream:close	()V
      //   1905: aload 10
      //   1907: invokevirtual 510	java/io/FileOutputStream:close	()V
      //   1910: return
      //   1911: astore 10
      //   1913: return
      //   1914: iconst_0
      //   1915: istore 4
      //   1917: iconst_0
      //   1918: istore_1
      //   1919: iload 4
      //   1921: istore_2
      //   1922: aload_0
      //   1923: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1926: iconst_0
      //   1927: putfield 276	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
      //   1930: iload 4
      //   1932: istore_2
      //   1933: aload_0
      //   1934: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1937: aload_0
      //   1938: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1941: invokevirtual 536	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   1944: iload 4
      //   1946: istore_2
      //   1947: aload_0
      //   1948: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1951: getfield 273	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   1954: lstore 6
      //   1956: iload 4
      //   1958: istore_2
      //   1959: aload_0
      //   1960: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1963: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1966: lstore 8
      //   1968: lload 6
      //   1970: lload 8
      //   1972: lcmp
      //   1973: ifne -495 -> 1478
      //   1976: aload 12
      //   1978: invokevirtual 509	java/io/InputStream:close	()V
      //   1981: aload 10
      //   1983: invokevirtual 510	java/io/FileOutputStream:close	()V
      //   1986: goto -1752 -> 234
      //   1989: astore 10
      //   1991: goto -1757 -> 234
      //   1994: astore 14
      //   1996: aload 12
      //   1998: invokevirtual 509	java/io/InputStream:close	()V
      //   2001: aload 10
      //   2003: invokevirtual 510	java/io/FileOutputStream:close	()V
      //   2006: aload 14
      //   2008: athrow
      //   2009: iload_1
      //   2010: iload_2
      //   2011: if_icmple -1703 -> 308
      //   2014: new 31	java/lang/StringBuilder
      //   2017: dup
      //   2018: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   2021: aload_0
      //   2022: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2025: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   2028: iconst_0
      //   2029: iload_1
      //   2030: iload_2
      //   2031: isub
      //   2032: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
      //   2035: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2038: aload_0
      //   2039: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2042: getfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   2045: iload_1
      //   2046: invokevirtual 314	java/lang/String:substring	(I)Ljava/lang/String;
      //   2049: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2052: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2055: astore 10
      //   2057: aload_0
      //   2058: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2061: aload 10
      //   2063: putfield 282	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   2066: goto -1758 -> 308
      //   2069: new 31	java/lang/StringBuilder
      //   2072: dup
      //   2073: invokespecial 34	java/lang/StringBuilder:<init>	()V
      //   2076: getstatic 307	acbn:bmg	Ljava/lang/String;
      //   2079: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2082: aload 10
      //   2084: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2087: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2090: astore 11
      //   2092: goto -1652 -> 440
      //   2095: iload_1
      //   2096: iconst_1
      //   2097: iadd
      //   2098: istore_1
      //   2099: goto -1739 -> 360
      //   2102: aload_0
      //   2103: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   2106: aload_0
      //   2107: getfield 65	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2110: bipush 10
      //   2112: sipush 307
      //   2115: invokevirtual 95	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   2118: getstatic 223	apue$a:dVY	I
      //   2121: getstatic 539	apue$a:dWl	I
      //   2124: invokestatic 232	apue:jZ	(II)V
      //   2127: return
      //   2128: astore 11
      //   2130: goto -577 -> 1553
      //   2133: astore 11
      //   2135: goto -230 -> 1905
      //   2138: astore 11
      //   2140: goto -280 -> 1860
      //   2143: astore 11
      //   2145: goto -164 -> 1981
      //   2148: astore 12
      //   2150: goto -149 -> 2001
      //   2153: astore 10
      //   2155: goto -149 -> 2006
      //   2158: astore 10
      //   2160: iload_2
      //   2161: istore_3
      //   2162: goto -858 -> 1304
      //   2165: astore 10
      //   2167: iload_2
      //   2168: istore_3
      //   2169: goto -865 -> 1304
      //   2172: goto -1956 -> 216
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2175	0	this	TaskHttpDownload
      //   215	1884	1	i	int
      //   261	1907	2	j	int
      //   213	1956	3	k	int
      //   1487	470	4	m	int
      //   1848	3	5	bool	boolean
      //   1954	15	6	l1	long
      //   1966	5	8	l2	long
      //   71	464	10	localObject1	Object
      //   556	1	10	localIOException1	IOException
      //   765	3	10	localInterruptedException	java.lang.InterruptedException
      //   829	725	10	localObject2	Object
      //   1559	1	10	localIOException2	IOException
      //   1562	1	10	localFileNotFoundException	java.io.FileNotFoundException
      //   1594	267	10	localIOException3	IOException
      //   1866	40	10	localIOException4	IOException
      //   1911	71	10	localIOException5	IOException
      //   1989	13	10	localIOException6	IOException
      //   2055	28	10	str1	String
      //   2153	1	10	localIOException7	IOException
      //   2158	1	10	localException	Exception
      //   2165	1	10	localNumberFormatException	java.lang.NumberFormatException
      //   315	1355	11	localObject3	Object
      //   1685	1	11	localIOException8	IOException
      //   2090	1	11	str2	String
      //   2128	1	11	localIOException9	IOException
      //   2133	1	11	localIOException10	IOException
      //   2138	1	11	localIOException11	IOException
      //   2143	1	11	localIOException12	IOException
      //   449	1548	12	localObject4	Object
      //   2148	1	12	localIOException13	IOException
      //   146	1316	13	localFile	File
      //   825	942	14	localObject5	Object
      //   1869	1	14	localIOException14	IOException
      //   1994	13	14	localObject6	Object
      //   868	943	15	localObject7	Object
      // Exception table:
      //   from	to	target	type
      //   156	162	556	java/io/IOException
      //   711	717	765	java/lang/InterruptedException
      //   1553	1558	1559	java/io/IOException
      //   1457	1469	1562	java/io/FileNotFoundException
      //   1412	1426	1594	java/io/IOException
      //   1428	1440	1594	java/io/IOException
      //   1442	1455	1594	java/io/IOException
      //   1457	1469	1594	java/io/IOException
      //   1566	1582	1594	java/io/IOException
      //   1584	1593	1594	java/io/IOException
      //   2006	2009	1594	java/io/IOException
      //   1632	1684	1685	java/io/IOException
      //   1860	1865	1866	java/io/IOException
      //   1764	1774	1869	java/io/IOException
      //   1905	1910	1911	java/io/IOException
      //   1981	1986	1989	java/io/IOException
      //   1471	1478	1994	finally
      //   1480	1489	1994	finally
      //   1497	1519	1994	finally
      //   1521	1537	1994	finally
      //   1539	1548	1994	finally
      //   1764	1774	1994	finally
      //   1776	1782	1994	finally
      //   1784	1798	1994	finally
      //   1800	1806	1994	finally
      //   1808	1822	1994	finally
      //   1824	1835	1994	finally
      //   1837	1850	1994	finally
      //   1873	1889	1994	finally
      //   1891	1900	1994	finally
      //   1922	1930	1994	finally
      //   1933	1944	1994	finally
      //   1947	1956	1994	finally
      //   1959	1968	1994	finally
      //   1548	1553	2128	java/io/IOException
      //   1900	1905	2133	java/io/IOException
      //   1855	1860	2138	java/io/IOException
      //   1976	1981	2143	java/io/IOException
      //   1996	2001	2148	java/io/IOException
      //   2001	2006	2153	java/io/IOException
      //   1271	1279	2158	java/lang/Exception
      //   1281	1304	2158	java/lang/Exception
      //   1271	1279	2165	java/lang/NumberFormatException
      //   1281	1304	2165	java/lang/NumberFormatException
    }
  }
  
  public class TaskHttpDownloadThumbnail
    extends TroopFileTransferManager.Task
  {
    public String crc = "80";
    public int dVJ;
    
    public TaskHttpDownloadThumbnail(TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
    {
      super(paramItem, 4);
      this.dVJ = paramInt;
      this.crc = paramString;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 47	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
      //   3: ifeq +11 -> 14
      //   6: ldc 49
      //   8: iconst_4
      //   9: ldc 51
      //   11: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   14: new 57	java/io/File
      //   17: dup
      //   18: getstatic 62	acbn:bmj	Ljava/lang/String;
      //   21: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
      //   24: astore 12
      //   26: aload 12
      //   28: invokevirtual 68	java/io/File:exists	()Z
      //   31: ifne +9 -> 40
      //   34: aload 12
      //   36: invokevirtual 71	java/io/File:mkdir	()Z
      //   39: pop
      //   40: aload_0
      //   41: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   44: aload_0
      //   45: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   48: getfield 79	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   51: aload_0
      //   52: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   55: invokevirtual 85	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getThumbnailFile	(JI)Ljava/lang/String;
      //   58: astore 16
      //   60: new 87	java/lang/StringBuilder
      //   63: dup
      //   64: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   67: aload 16
      //   69: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: ldc 95
      //   74: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: astore 17
      //   82: aload_0
      //   83: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   86: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   89: invokestatic 108	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
      //   92: invokestatic 114	ahav:getFileType	(Ljava/lang/String;)I
      //   95: istore 6
      //   97: iload 6
      //   99: iconst_2
      //   100: if_icmpne +334 -> 434
      //   103: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   106: ifeq +43 -> 149
      //   109: ldc 49
      //   111: iconst_2
      //   112: new 87	java/lang/StringBuilder
      //   115: dup
      //   116: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   119: ldc 119
      //   121: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   124: aload_0
      //   125: getfield 24	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:crc	Ljava/lang/String;
      //   128: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: ldc 121
      //   133: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   136: aload_0
      //   137: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   140: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   143: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   146: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   149: aload_0
      //   150: getfield 24	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:crc	Ljava/lang/String;
      //   153: invokestatic 133	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   156: invokevirtual 137	java/lang/Integer:intValue	()I
      //   159: istore_1
      //   160: iload_1
      //   161: istore_2
      //   162: iload_1
      //   163: ifgt +7 -> 170
      //   166: sipush 443
      //   169: istore_2
      //   170: aload_0
      //   171: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   174: ifgt +10 -> 184
      //   177: aload_0
      //   178: sipush 383
      //   181: putfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   184: new 87	java/lang/StringBuilder
      //   187: dup
      //   188: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   191: ldc 139
      //   193: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   196: aload_0
      //   197: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   200: getfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   203: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: ldc 144
      //   208: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   211: iload_2
      //   212: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   215: ldc 146
      //   217: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: aload_0
      //   221: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   224: getfield 149	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
      //   227: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   230: ldc 151
      //   232: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   235: aload_0
      //   236: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   239: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   242: ldc 153
      //   244: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   247: aload_0
      //   248: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   251: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   254: ldc 155
      //   256: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   262: astore 13
      //   264: aload 13
      //   266: astore 12
      //   268: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   271: ifeq +48 -> 319
      //   274: ldc 157
      //   276: iconst_2
      //   277: new 87	java/lang/StringBuilder
      //   280: dup
      //   281: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   284: ldc 159
      //   286: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   289: aload_0
      //   290: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   293: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   296: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   299: ldc 161
      //   301: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   304: aload 13
      //   306: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   309: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   312: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   315: aload 13
      //   317: astore 12
      //   319: new 163	java/net/URL
      //   322: dup
      //   323: aload 12
      //   325: invokespecial 164	java/net/URL:<init>	(Ljava/lang/String;)V
      //   328: astore 18
      //   330: iconst_0
      //   331: istore_3
      //   332: iconst_0
      //   333: istore_1
      //   334: iload_1
      //   335: sipush 1000
      //   338: imul
      //   339: i2l
      //   340: lstore 8
      //   342: lload 8
      //   344: invokestatic 170	java/lang/Thread:sleep	(J)V
      //   347: new 57	java/io/File
      //   350: dup
      //   351: aload 17
      //   353: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
      //   356: astore 15
      //   358: aload 15
      //   360: invokevirtual 173	java/io/File:delete	()Z
      //   363: pop
      //   364: iload_1
      //   365: iconst_1
      //   366: iadd
      //   367: istore_1
      //   368: iload_1
      //   369: iconst_3
      //   370: if_icmple +323 -> 693
      //   373: aload_0
      //   374: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   377: sipush 128
      //   380: if_icmpne +256 -> 636
      //   383: aload_0
      //   384: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   387: iconst_0
      //   388: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   391: return
      //   392: astore 12
      //   394: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   397: ifeq +32 -> 429
      //   400: ldc 49
      //   402: iconst_2
      //   403: new 87	java/lang/StringBuilder
      //   406: dup
      //   407: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   410: ldc 179
      //   412: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   415: aload 12
      //   417: invokevirtual 180	java/lang/NumberFormatException:toString	()Ljava/lang/String;
      //   420: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   423: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   426: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   429: iconst_0
      //   430: istore_1
      //   431: goto -271 -> 160
      //   434: new 87	java/lang/StringBuilder
      //   437: dup
      //   438: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   441: ldc 139
      //   443: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   446: aload_0
      //   447: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   450: getfield 142	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadIp	Ljava/lang/String;
      //   453: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   456: ldc 184
      //   458: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   461: aload_0
      //   462: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   465: getfield 149	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DownloadUrl	Ljava/lang/String;
      //   468: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   471: ldc 186
      //   473: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   476: aload_0
      //   477: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   480: getfield 189	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
      //   483: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   486: ldc 191
      //   488: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   491: aload_0
      //   492: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   495: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   498: ldc 153
      //   500: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   503: aload_0
      //   504: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   507: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   510: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   513: astore 12
      //   515: goto -196 -> 319
      //   518: astore 12
      //   520: aload_0
      //   521: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   524: sipush 128
      //   527: if_icmpne +12 -> 539
      //   530: aload_0
      //   531: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   534: iconst_0
      //   535: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   538: return
      //   539: aload_0
      //   540: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   543: sipush 640
      //   546: if_icmpne +12 -> 558
      //   549: aload_0
      //   550: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   553: iconst_0
      //   554: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   557: return
      //   558: aload_0
      //   559: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   562: sipush 383
      //   565: if_icmpne -174 -> 391
      //   568: aload_0
      //   569: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   572: iconst_0
      //   573: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   576: return
      //   577: astore 12
      //   579: aload_0
      //   580: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   583: sipush 128
      //   586: if_icmpne +12 -> 598
      //   589: aload_0
      //   590: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   593: iconst_0
      //   594: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   597: return
      //   598: aload_0
      //   599: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   602: sipush 640
      //   605: if_icmpne +12 -> 617
      //   608: aload_0
      //   609: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   612: iconst_0
      //   613: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   616: return
      //   617: aload_0
      //   618: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   621: sipush 383
      //   624: if_icmpne -233 -> 391
      //   627: aload_0
      //   628: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   631: iconst_0
      //   632: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   635: return
      //   636: aload_0
      //   637: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   640: sipush 640
      //   643: if_icmpne +12 -> 655
      //   646: aload_0
      //   647: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   650: iconst_0
      //   651: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   654: return
      //   655: aload_0
      //   656: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   659: sipush 383
      //   662: if_icmpne -271 -> 391
      //   665: aload_0
      //   666: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   669: iconst_0
      //   670: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   673: aload_0
      //   674: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   677: iconst_1
      //   678: putfield 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
      //   681: aload_0
      //   682: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   685: aload_0
      //   686: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   689: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   692: return
      //   693: aload 15
      //   695: invokevirtual 206	java/io/File:createNewFile	()Z
      //   698: pop
      //   699: aconst_null
      //   700: astore 14
      //   702: aload 18
      //   704: invokevirtual 210	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   707: checkcast 212	java/net/HttpURLConnection
      //   710: astore 12
      //   712: iload_3
      //   713: istore 4
      //   715: aload 12
      //   717: sipush 30000
      //   720: invokevirtual 216	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   723: iload_3
      //   724: istore 4
      //   726: aload 12
      //   728: ldc 218
      //   730: invokevirtual 221	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   733: iload_3
      //   734: istore 4
      //   736: aload 12
      //   738: ldc 223
      //   740: ldc 225
      //   742: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   745: iload_3
      //   746: istore 4
      //   748: aload 12
      //   750: ldc 231
      //   752: ldc 233
      //   754: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   757: iload_3
      //   758: istore 4
      //   760: aload 12
      //   762: ldc 235
      //   764: new 87	java/lang/StringBuilder
      //   767: dup
      //   768: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   771: ldc 237
      //   773: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   776: aload_0
      //   777: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   780: getfield 240	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:cookieValue	Ljava/lang/String;
      //   783: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   786: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   789: invokevirtual 229	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   792: iload_3
      //   793: istore 4
      //   795: aload 12
      //   797: invokevirtual 243	java/net/HttpURLConnection:getResponseCode	()I
      //   800: istore 7
      //   802: iload_3
      //   803: istore_2
      //   804: iload 6
      //   806: iconst_2
      //   807: if_icmpne +224 -> 1031
      //   810: iload_3
      //   811: istore 4
      //   813: aload 12
      //   815: ldc 245
      //   817: invokevirtual 248	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   820: astore 13
      //   822: iload_3
      //   823: istore 4
      //   825: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   828: ifeq +66 -> 894
      //   831: iload_3
      //   832: istore 4
      //   834: ldc 157
      //   836: iconst_2
      //   837: new 87	java/lang/StringBuilder
      //   840: dup
      //   841: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   844: ldc 159
      //   846: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   849: aload_0
      //   850: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   853: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   856: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   859: ldc 250
      //   861: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   864: iload 7
      //   866: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   869: ldc 252
      //   871: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   874: aload 13
      //   876: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   879: ldc 254
      //   881: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   884: iload_1
      //   885: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   888: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   891: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   894: iload_3
      //   895: istore_2
      //   896: iload_3
      //   897: istore 4
      //   899: aload 13
      //   901: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   904: ifne +127 -> 1031
      //   907: iload_3
      //   908: istore_2
      //   909: iload_3
      //   910: istore 4
      //   912: aload 13
      //   914: ldc_w 262
      //   917: invokevirtual 267	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   920: ifeq +111 -> 1031
      //   923: iload_3
      //   924: istore 4
      //   926: aload 13
      //   928: invokevirtual 270	java/lang/String:trim	()Ljava/lang/String;
      //   931: ldc_w 272
      //   934: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   937: astore 13
      //   939: iload_3
      //   940: istore_2
      //   941: aload 13
      //   943: ifnull +88 -> 1031
      //   946: iload_3
      //   947: istore_2
      //   948: iload_3
      //   949: istore 4
      //   951: aload 13
      //   953: arraylength
      //   954: ifle +77 -> 1031
      //   957: iconst_0
      //   958: istore 5
      //   960: iload_3
      //   961: istore_2
      //   962: iload_3
      //   963: istore 4
      //   965: iload 5
      //   967: aload 13
      //   969: arraylength
      //   970: if_icmpge +61 -> 1031
      //   973: iload_3
      //   974: istore 4
      //   976: aload 13
      //   978: iload 5
      //   980: aaload
      //   981: ldc_w 278
      //   984: invokevirtual 276	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   987: astore 14
      //   989: aload 14
      //   991: ifnull +183 -> 1174
      //   994: iload_3
      //   995: istore 4
      //   997: aload 14
      //   999: arraylength
      //   1000: iconst_2
      //   1001: if_icmpne +173 -> 1174
      //   1004: iload_3
      //   1005: istore 4
      //   1007: ldc_w 262
      //   1010: aload 14
      //   1012: iconst_0
      //   1013: aaload
      //   1014: invokevirtual 282	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1017: ifeq +157 -> 1174
      //   1020: iload_3
      //   1021: istore 4
      //   1023: aload 14
      //   1025: iconst_1
      //   1026: aaload
      //   1027: invokestatic 285	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   1030: istore_2
      //   1031: iload 7
      //   1033: sipush 200
      //   1036: if_icmpeq +11 -> 1047
      //   1039: iload 7
      //   1041: sipush 206
      //   1044: if_icmpne +774 -> 1818
      //   1047: iload_2
      //   1048: istore 4
      //   1050: aload 12
      //   1052: invokevirtual 289	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   1055: astore 19
      //   1057: iload_2
      //   1058: istore 4
      //   1060: new 291	java/io/FileOutputStream
      //   1063: dup
      //   1064: aload 15
      //   1066: invokespecial 294	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   1069: astore 14
      //   1071: sipush 8192
      //   1074: newarray byte
      //   1076: astore 13
      //   1078: aload 19
      //   1080: aload 13
      //   1082: invokevirtual 300	java/io/InputStream:read	([B)I
      //   1085: istore_3
      //   1086: iload_3
      //   1087: iconst_m1
      //   1088: if_icmpeq +390 -> 1478
      //   1091: aload 14
      //   1093: aload 13
      //   1095: iconst_0
      //   1096: iload_3
      //   1097: invokevirtual 304	java/io/FileOutputStream:write	([BII)V
      //   1100: aload_0
      //   1101: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1104: iconst_1
      //   1105: iload_3
      //   1106: i2l
      //   1107: invokestatic 308	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
      //   1110: iconst_0
      //   1111: istore_1
      //   1112: goto -34 -> 1078
      //   1115: astore 12
      //   1117: aload_0
      //   1118: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1121: sipush 128
      //   1124: if_icmpne +12 -> 1136
      //   1127: aload_0
      //   1128: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1131: iconst_0
      //   1132: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   1135: return
      //   1136: aload_0
      //   1137: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1140: sipush 640
      //   1143: if_icmpne +12 -> 1155
      //   1146: aload_0
      //   1147: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1150: iconst_0
      //   1151: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   1154: return
      //   1155: aload_0
      //   1156: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1159: sipush 383
      //   1162: if_icmpne -771 -> 391
      //   1165: aload_0
      //   1166: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1169: iconst_0
      //   1170: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   1173: return
      //   1174: iload 5
      //   1176: iconst_1
      //   1177: iadd
      //   1178: istore 5
      //   1180: goto -220 -> 960
      //   1183: astore 13
      //   1185: iload_3
      //   1186: istore_2
      //   1187: iload_3
      //   1188: istore 4
      //   1190: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1193: ifeq -162 -> 1031
      //   1196: iload_3
      //   1197: istore 4
      //   1199: ldc 157
      //   1201: iconst_2
      //   1202: ldc_w 310
      //   1205: aload 13
      //   1207: invokestatic 313	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1210: iload_3
      //   1211: istore_2
      //   1212: goto -181 -> 1031
      //   1215: astore 13
      //   1217: iload_1
      //   1218: istore_2
      //   1219: iload 4
      //   1221: istore_1
      //   1222: aload 12
      //   1224: ifnull +8 -> 1232
      //   1227: aload 12
      //   1229: invokevirtual 316	java/net/HttpURLConnection:disconnect	()V
      //   1232: aload 15
      //   1234: invokevirtual 173	java/io/File:delete	()Z
      //   1237: pop
      //   1238: iload_1
      //   1239: istore_3
      //   1240: iload_2
      //   1241: istore_1
      //   1242: goto -908 -> 334
      //   1245: astore 13
      //   1247: iload_2
      //   1248: istore 4
      //   1250: aload_0
      //   1251: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1254: sipush 128
      //   1257: if_icmpne +31 -> 1288
      //   1260: iload_2
      //   1261: istore 4
      //   1263: aload_0
      //   1264: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1267: iconst_0
      //   1268: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   1271: aload 12
      //   1273: ifnull +8 -> 1281
      //   1276: aload 12
      //   1278: invokevirtual 316	java/net/HttpURLConnection:disconnect	()V
      //   1281: aload 15
      //   1283: invokevirtual 173	java/io/File:delete	()Z
      //   1286: pop
      //   1287: return
      //   1288: iload_2
      //   1289: istore 4
      //   1291: aload_0
      //   1292: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1295: sipush 640
      //   1298: if_icmpne +38 -> 1336
      //   1301: iload_2
      //   1302: istore 4
      //   1304: aload_0
      //   1305: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1308: iconst_0
      //   1309: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   1312: goto -41 -> 1271
      //   1315: astore 13
      //   1317: aload 12
      //   1319: ifnull +8 -> 1327
      //   1322: aload 12
      //   1324: invokevirtual 316	java/net/HttpURLConnection:disconnect	()V
      //   1327: aload 15
      //   1329: invokevirtual 173	java/io/File:delete	()Z
      //   1332: pop
      //   1333: aload 13
      //   1335: athrow
      //   1336: iload_2
      //   1337: istore 4
      //   1339: aload_0
      //   1340: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1343: sipush 383
      //   1346: if_icmpne -75 -> 1271
      //   1349: iload_2
      //   1350: istore 4
      //   1352: aload_0
      //   1353: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1356: iconst_0
      //   1357: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   1360: goto -89 -> 1271
      //   1363: astore 13
      //   1365: aload_0
      //   1366: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1369: sipush 128
      //   1372: if_icmpne +38 -> 1410
      //   1375: aload_0
      //   1376: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1379: iconst_0
      //   1380: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   1383: aload 19
      //   1385: invokevirtual 319	java/io/InputStream:close	()V
      //   1388: aload 14
      //   1390: invokevirtual 320	java/io/FileOutputStream:close	()V
      //   1393: aload 12
      //   1395: ifnull +8 -> 1403
      //   1398: aload 12
      //   1400: invokevirtual 316	java/net/HttpURLConnection:disconnect	()V
      //   1403: aload 15
      //   1405: invokevirtual 173	java/io/File:delete	()Z
      //   1408: pop
      //   1409: return
      //   1410: aload_0
      //   1411: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1414: sipush 640
      //   1417: if_icmpne +40 -> 1457
      //   1420: aload_0
      //   1421: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1424: iconst_0
      //   1425: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   1428: goto -45 -> 1383
      //   1431: astore 13
      //   1433: aload 19
      //   1435: invokevirtual 319	java/io/InputStream:close	()V
      //   1438: aload 14
      //   1440: invokevirtual 320	java/io/FileOutputStream:close	()V
      //   1443: iload_1
      //   1444: istore_3
      //   1445: aload 13
      //   1447: athrow
      //   1448: astore 13
      //   1450: iload_2
      //   1451: istore_1
      //   1452: iload_3
      //   1453: istore_2
      //   1454: goto -232 -> 1222
      //   1457: aload_0
      //   1458: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1461: sipush 383
      //   1464: if_icmpne -81 -> 1383
      //   1467: aload_0
      //   1468: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1471: iconst_0
      //   1472: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   1475: goto -92 -> 1383
      //   1478: aload 19
      //   1480: invokevirtual 319	java/io/InputStream:close	()V
      //   1483: aload 14
      //   1485: invokevirtual 320	java/io/FileOutputStream:close	()V
      //   1488: iload_1
      //   1489: istore_3
      //   1490: new 57	java/io/File
      //   1493: dup
      //   1494: aload 17
      //   1496: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
      //   1499: astore 13
      //   1501: iload_1
      //   1502: istore_3
      //   1503: aload 13
      //   1505: new 57	java/io/File
      //   1508: dup
      //   1509: aload 16
      //   1511: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
      //   1514: invokevirtual 324	java/io/File:renameTo	(Ljava/io/File;)Z
      //   1517: pop
      //   1518: iload_1
      //   1519: istore_3
      //   1520: aload 13
      //   1522: invokevirtual 327	java/io/File:deleteOnExit	()V
      //   1525: iload_1
      //   1526: istore_3
      //   1527: aload_0
      //   1528: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1531: astore 13
      //   1533: iload_1
      //   1534: istore_3
      //   1535: aload 13
      //   1537: monitorenter
      //   1538: aload_0
      //   1539: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1542: sipush 128
      //   1545: if_icmpne +87 -> 1632
      //   1548: aload_0
      //   1549: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1552: iconst_0
      //   1553: putfield 177	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Small	Z
      //   1556: aload_0
      //   1557: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1560: aload_0
      //   1561: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1564: sipush 128
      //   1567: invokevirtual 330	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
      //   1570: pop
      //   1571: aload_0
      //   1572: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1575: lconst_0
      //   1576: putfield 333	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:StatusUpdateTimeMs	J
      //   1579: aload_0
      //   1580: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1583: getfield 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
      //   1586: aload_0
      //   1587: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1590: getfield 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
      //   1593: invokeinterface 346 2 0
      //   1598: ifeq +14 -> 1612
      //   1601: aload_0
      //   1602: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1605: aload_0
      //   1606: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1609: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   1612: aload 13
      //   1614: monitorexit
      //   1615: aload 12
      //   1617: ifnull +8 -> 1625
      //   1620: aload 12
      //   1622: invokevirtual 316	java/net/HttpURLConnection:disconnect	()V
      //   1625: aload 15
      //   1627: invokevirtual 173	java/io/File:delete	()Z
      //   1630: pop
      //   1631: return
      //   1632: aload_0
      //   1633: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1636: sipush 640
      //   1639: if_icmpne +39 -> 1678
      //   1642: aload_0
      //   1643: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1646: iconst_0
      //   1647: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Large	Z
      //   1650: aload_0
      //   1651: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1654: aload_0
      //   1655: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1658: sipush 640
      //   1661: invokevirtual 330	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
      //   1664: pop
      //   1665: goto -94 -> 1571
      //   1668: astore 14
      //   1670: aload 13
      //   1672: monitorexit
      //   1673: iload_1
      //   1674: istore_3
      //   1675: aload 14
      //   1677: athrow
      //   1678: aload_0
      //   1679: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1682: sipush 383
      //   1685: if_icmpne -114 -> 1571
      //   1688: aload_0
      //   1689: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1692: iconst_0
      //   1693: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   1696: aload_0
      //   1697: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1700: aload_0
      //   1701: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1704: sipush 383
      //   1707: invokevirtual 330	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)Z
      //   1710: istore 11
      //   1712: aload_0
      //   1713: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1716: astore 14
      //   1718: iload 11
      //   1720: ifne +92 -> 1812
      //   1723: iconst_1
      //   1724: istore 10
      //   1726: aload 14
      //   1728: iload 10
      //   1730: putfield 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
      //   1733: iload 6
      //   1735: iconst_2
      //   1736: if_icmpne -165 -> 1571
      //   1739: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1742: ifeq +45 -> 1787
      //   1745: ldc 157
      //   1747: iconst_2
      //   1748: new 87	java/lang/StringBuilder
      //   1751: dup
      //   1752: invokespecial 89	java/lang/StringBuilder:<init>	()V
      //   1755: ldc 159
      //   1757: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1760: aload_0
      //   1761: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1764: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
      //   1767: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1770: ldc_w 348
      //   1773: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1776: iload 11
      //   1778: invokevirtual 351	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1781: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1784: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1787: aload_0
      //   1788: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1791: getfield 353	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
      //   1794: ifne -223 -> 1571
      //   1797: iload_2
      //   1798: ifeq -227 -> 1571
      //   1801: aload_0
      //   1802: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1805: iload_2
      //   1806: putfield 353	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
      //   1809: goto -238 -> 1571
      //   1812: iconst_0
      //   1813: istore 10
      //   1815: goto -89 -> 1726
      //   1818: iload_2
      //   1819: istore 4
      //   1821: aload_0
      //   1822: getfield 26	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:dVJ	I
      //   1825: sipush 383
      //   1828: if_icmpne +64 -> 1892
      //   1831: iload_2
      //   1832: istore 4
      //   1834: aload_0
      //   1835: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1838: iconst_1
      //   1839: putfield 200	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle_Fail	Z
      //   1842: iload_2
      //   1843: istore 4
      //   1845: aload_0
      //   1846: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1849: iconst_0
      //   1850: putfield 197	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ThumbnailDownloading_Middle	Z
      //   1853: iload_2
      //   1854: istore 4
      //   1856: aload_0
      //   1857: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1860: getfield 337	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:nC	Ljava/util/Map;
      //   1863: aload_0
      //   1864: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1867: getfield 341	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
      //   1870: invokeinterface 346 2 0
      //   1875: ifeq +17 -> 1892
      //   1878: iload_2
      //   1879: istore 4
      //   1881: aload_0
      //   1882: getfield 17	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1885: aload_0
      //   1886: getfield 75	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpDownloadThumbnail:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1889: invokevirtual 203	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   1892: aload 12
      //   1894: ifnull +8 -> 1902
      //   1897: aload 12
      //   1899: invokevirtual 316	java/net/HttpURLConnection:disconnect	()V
      //   1902: aload 15
      //   1904: invokevirtual 173	java/io/File:delete	()Z
      //   1907: pop
      //   1908: iload_1
      //   1909: istore_3
      //   1910: iload_2
      //   1911: istore_1
      //   1912: iload_3
      //   1913: istore_2
      //   1914: goto -676 -> 1238
      //   1917: astore 13
      //   1919: goto -531 -> 1388
      //   1922: astore 13
      //   1924: goto -531 -> 1393
      //   1927: astore 13
      //   1929: goto -446 -> 1483
      //   1932: astore 13
      //   1934: goto -446 -> 1488
      //   1937: astore 19
      //   1939: goto -501 -> 1438
      //   1942: astore 14
      //   1944: goto -501 -> 1443
      //   1947: astore 13
      //   1949: aload 14
      //   1951: astore 12
      //   1953: goto -636 -> 1317
      //   1956: astore 12
      //   1958: iload_1
      //   1959: istore_2
      //   1960: aconst_null
      //   1961: astore 12
      //   1963: iload_3
      //   1964: istore_1
      //   1965: goto -743 -> 1222
      //   1968: astore 13
      //   1970: goto -537 -> 1433
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1973	0	this	TaskHttpDownloadThumbnail
      //   159	1806	1	i	int
      //   161	1799	2	j	int
      //   331	1633	3	k	int
      //   713	1167	4	m	int
      //   958	221	5	n	int
      //   95	1642	6	i1	int
      //   800	245	7	i2	int
      //   340	3	8	l	long
      //   1724	90	10	bool1	boolean
      //   1710	67	11	bool2	boolean
      //   24	300	12	localObject1	Object
      //   392	24	12	localNumberFormatException	java.lang.NumberFormatException
      //   513	1	12	str1	String
      //   518	1	12	localMalformedURLException	java.net.MalformedURLException
      //   577	1	12	localInterruptedException	java.lang.InterruptedException
      //   710	341	12	localHttpURLConnection	java.net.HttpURLConnection
      //   1115	783	12	localIOException1	IOException
      //   1951	1	12	localObject2	Object
      //   1956	1	12	localIOException2	IOException
      //   1961	1	12	localObject3	Object
      //   262	832	13	localObject4	Object
      //   1183	23	13	localException	Exception
      //   1215	1	13	localIOException3	IOException
      //   1245	1	13	localFileNotFoundException	java.io.FileNotFoundException
      //   1315	19	13	localObject5	Object
      //   1363	1	13	localIOException4	IOException
      //   1431	15	13	localObject6	Object
      //   1448	1	13	localIOException5	IOException
      //   1499	172	13	localObject7	Object
      //   1917	1	13	localIOException6	IOException
      //   1922	1	13	localIOException7	IOException
      //   1927	1	13	localIOException8	IOException
      //   1932	1	13	localIOException9	IOException
      //   1947	1	13	localObject8	Object
      //   1968	1	13	localObject9	Object
      //   700	784	14	localObject10	Object
      //   1668	8	14	localObject11	Object
      //   1716	11	14	localItem	TroopFileTransferManager.Item
      //   1942	8	14	localIOException10	IOException
      //   356	1547	15	localFile	File
      //   58	1452	16	str2	String
      //   80	1415	17	str3	String
      //   328	375	18	localURL	java.net.URL
      //   1055	424	19	localInputStream	java.io.InputStream
      //   1937	1	19	localIOException11	IOException
      // Exception table:
      //   from	to	target	type
      //   149	160	392	java/lang/NumberFormatException
      //   319	330	518	java/net/MalformedURLException
      //   342	347	577	java/lang/InterruptedException
      //   693	699	1115	java/io/IOException
      //   899	907	1183	java/lang/Exception
      //   912	923	1183	java/lang/Exception
      //   926	939	1183	java/lang/Exception
      //   951	957	1183	java/lang/Exception
      //   965	973	1183	java/lang/Exception
      //   976	989	1183	java/lang/Exception
      //   997	1004	1183	java/lang/Exception
      //   1007	1020	1183	java/lang/Exception
      //   1023	1031	1183	java/lang/Exception
      //   715	723	1215	java/io/IOException
      //   726	733	1215	java/io/IOException
      //   736	745	1215	java/io/IOException
      //   748	757	1215	java/io/IOException
      //   760	792	1215	java/io/IOException
      //   795	802	1215	java/io/IOException
      //   813	822	1215	java/io/IOException
      //   825	831	1215	java/io/IOException
      //   834	894	1215	java/io/IOException
      //   899	907	1215	java/io/IOException
      //   912	923	1215	java/io/IOException
      //   926	939	1215	java/io/IOException
      //   951	957	1215	java/io/IOException
      //   965	973	1215	java/io/IOException
      //   976	989	1215	java/io/IOException
      //   997	1004	1215	java/io/IOException
      //   1007	1020	1215	java/io/IOException
      //   1023	1031	1215	java/io/IOException
      //   1050	1057	1215	java/io/IOException
      //   1060	1071	1215	java/io/IOException
      //   1190	1196	1215	java/io/IOException
      //   1199	1210	1215	java/io/IOException
      //   1250	1260	1215	java/io/IOException
      //   1263	1271	1215	java/io/IOException
      //   1291	1301	1215	java/io/IOException
      //   1304	1312	1215	java/io/IOException
      //   1339	1349	1215	java/io/IOException
      //   1352	1360	1215	java/io/IOException
      //   1821	1831	1215	java/io/IOException
      //   1834	1842	1215	java/io/IOException
      //   1845	1853	1215	java/io/IOException
      //   1856	1878	1215	java/io/IOException
      //   1881	1892	1215	java/io/IOException
      //   1060	1071	1245	java/io/FileNotFoundException
      //   715	723	1315	finally
      //   726	733	1315	finally
      //   736	745	1315	finally
      //   748	757	1315	finally
      //   760	792	1315	finally
      //   795	802	1315	finally
      //   813	822	1315	finally
      //   825	831	1315	finally
      //   834	894	1315	finally
      //   899	907	1315	finally
      //   912	923	1315	finally
      //   926	939	1315	finally
      //   951	957	1315	finally
      //   965	973	1315	finally
      //   976	989	1315	finally
      //   997	1004	1315	finally
      //   1007	1020	1315	finally
      //   1023	1031	1315	finally
      //   1050	1057	1315	finally
      //   1060	1071	1315	finally
      //   1190	1196	1315	finally
      //   1199	1210	1315	finally
      //   1250	1260	1315	finally
      //   1263	1271	1315	finally
      //   1291	1301	1315	finally
      //   1304	1312	1315	finally
      //   1339	1349	1315	finally
      //   1352	1360	1315	finally
      //   1383	1388	1315	finally
      //   1388	1393	1315	finally
      //   1433	1438	1315	finally
      //   1438	1443	1315	finally
      //   1445	1448	1315	finally
      //   1478	1483	1315	finally
      //   1483	1488	1315	finally
      //   1490	1501	1315	finally
      //   1503	1518	1315	finally
      //   1520	1525	1315	finally
      //   1527	1533	1315	finally
      //   1535	1538	1315	finally
      //   1675	1678	1315	finally
      //   1821	1831	1315	finally
      //   1834	1842	1315	finally
      //   1845	1853	1315	finally
      //   1856	1878	1315	finally
      //   1881	1892	1315	finally
      //   1091	1110	1363	java/io/IOException
      //   1078	1086	1431	finally
      //   1091	1110	1431	finally
      //   1365	1383	1431	finally
      //   1410	1428	1431	finally
      //   1457	1475	1431	finally
      //   1445	1448	1448	java/io/IOException
      //   1490	1501	1448	java/io/IOException
      //   1503	1518	1448	java/io/IOException
      //   1520	1525	1448	java/io/IOException
      //   1527	1533	1448	java/io/IOException
      //   1535	1538	1448	java/io/IOException
      //   1675	1678	1448	java/io/IOException
      //   1538	1571	1668	finally
      //   1571	1612	1668	finally
      //   1612	1615	1668	finally
      //   1632	1665	1668	finally
      //   1670	1673	1668	finally
      //   1678	1718	1668	finally
      //   1726	1733	1668	finally
      //   1739	1787	1668	finally
      //   1787	1797	1668	finally
      //   1801	1809	1668	finally
      //   1383	1388	1917	java/io/IOException
      //   1388	1393	1922	java/io/IOException
      //   1478	1483	1927	java/io/IOException
      //   1483	1488	1932	java/io/IOException
      //   1433	1438	1937	java/io/IOException
      //   1438	1443	1942	java/io/IOException
      //   702	712	1947	finally
      //   702	712	1956	java/io/IOException
      //   1071	1078	1968	finally
    }
  }
  
  public class TaskHttpUpload
    extends TroopFileTransferManager.Task
  {
    public TaskHttpUpload(TroopFileTransferManager.Item paramItem)
    {
      super(paramItem, 2);
      this.cSh = true;
    }
    
    private HttpResponse a(HttpClient paramHttpClient, String paramString, byte[] paramArrayOfByte)
    {
      if ((paramHttpClient == null) || (paramString == null) || (paramArrayOfByte == null)) {}
      do
      {
        for (;;)
        {
          return null;
          HttpPost localHttpPost = new HttpPost(paramString);
          localHttpPost.setHeader("User-Agent", "TroopFile");
          localHttpPost.setHeader("Content-Type", "text/octet");
          localHttpPost.setHeader("Connection", "keep-alive");
          if (aqiw.isWifiConnected(BaseApplication.getContext()))
          {
            localHttpPost.setHeader("Net-type", "Wifi");
            localHttpPost.setEntity(new ByteArrayEntity(paramArrayOfByte));
          }
          try
          {
            paramHttpClient = paramHttpClient.execute(localHttpPost);
            return paramHttpClient;
            localHttpPost.setHeader("Net-type", "gprs");
          }
          catch (ClientProtocolException paramHttpClient)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopFileTransferManager", 2, "ClientProtocolException, url" + paramString);
            }
            paramHttpClient.printStackTrace();
            return null;
          }
          catch (IOException paramHttpClient)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopFileTransferManager", 2, "IOException, url" + paramString);
            }
            paramHttpClient.printStackTrace();
            return null;
          }
          catch (IllegalArgumentException paramHttpClient)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("TroopFileTransferManager", 2, "IllegalArgumentException, url" + paramString);
              return null;
            }
          }
          catch (Exception paramHttpClient) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopFileTransferManager", 2, "Exception, url" + paramString);
      return null;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   4: getfield 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   7: lstore 8
      //   9: aload_0
      //   10: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   13: aload_0
      //   14: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   17: invokevirtual 145	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   20: ifeq +4 -> 24
      //   23: return
      //   24: new 147	java/io/File
      //   27: dup
      //   28: aload_0
      //   29: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   32: getfield 151	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   35: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
      //   38: astore 26
      //   40: aload_0
      //   41: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   44: iconst_0
      //   45: putfield 156	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
      //   48: aload_0
      //   49: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   52: invokevirtual 159	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
      //   55: ifnull +3666 -> 3721
      //   58: aload_0
      //   59: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   62: invokevirtual 159	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lmqq/manager/ProxyIpManager;
      //   65: iconst_5
      //   66: invokeinterface 165 2 0
      //   71: astore 24
      //   73: iconst_0
      //   74: istore 4
      //   76: aload 24
      //   78: ifnull +184 -> 262
      //   81: aload 24
      //   83: invokeinterface 171 1 0
      //   88: ifle +174 -> 262
      //   91: aload 24
      //   93: iconst_0
      //   94: invokeinterface 175 2 0
      //   99: ifnull +163 -> 262
      //   102: iconst_0
      //   103: aload 24
      //   105: iconst_0
      //   106: invokeinterface 175 2 0
      //   111: checkcast 177	mqq/manager/ProxyIpManager$ProxyIp
      //   114: getfield 180	mqq/manager/ProxyIpManager$ProxyIp:port	I
      //   117: sipush 10000
      //   120: sipush 20000
      //   123: invokestatic 185	dj:a	(ZIII)Lorg/apache/http/client/HttpClient;
      //   126: astore 25
      //   128: iconst_1
      //   129: istore 4
      //   131: aconst_null
      //   132: astore 19
      //   134: iconst_m1
      //   135: istore_3
      //   136: sipush 1024
      //   139: istore_2
      //   140: lload 8
      //   142: lstore 6
      //   144: iconst_0
      //   145: istore_1
      //   146: iload_1
      //   147: iconst_3
      //   148: if_icmpgt +3557 -> 3705
      //   151: iload_1
      //   152: ifle +361 -> 513
      //   155: aload 19
      //   157: astore 22
      //   159: aload 19
      //   161: astore 21
      //   163: invokestatic 58	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   166: invokestatic 188	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
      //   169: ifne +125 -> 294
      //   172: aload 19
      //   174: astore 22
      //   176: aload 19
      //   178: astore 21
      //   180: aload_0
      //   181: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   184: aload_0
      //   185: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   188: iconst_3
      //   189: bipush 106
      //   191: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   194: aload 19
      //   196: astore 22
      //   198: aload 19
      //   200: astore 21
      //   202: getstatic 196	apue$a:dVY	I
      //   205: getstatic 199	apue$a:dWh	I
      //   208: invokestatic 205	apue:jY	(II)V
      //   211: aload 19
      //   213: ifnull -190 -> 23
      //   216: aload 19
      //   218: invokevirtual 210	java/io/FileInputStream:close	()V
      //   221: return
      //   222: astore 19
      //   224: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   227: ifeq -204 -> 23
      //   230: ldc 93
      //   232: iconst_2
      //   233: new 95	java/lang/StringBuilder
      //   236: dup
      //   237: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   240: ldc 212
      //   242: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: aload 19
      //   247: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   250: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   253: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   256: aload 19
      //   258: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   261: return
      //   262: invokestatic 220	dj:a	()Ldj$a;
      //   265: ifnull +23 -> 288
      //   268: iconst_1
      //   269: istore 18
      //   271: iconst_0
      //   272: iload 18
      //   274: sipush 10000
      //   277: sipush 20000
      //   280: invokestatic 223	dj:a	(ZZII)Lorg/apache/http/client/HttpClient;
      //   283: astore 25
      //   285: goto -154 -> 131
      //   288: iconst_0
      //   289: istore 18
      //   291: goto -20 -> 271
      //   294: iconst_0
      //   295: istore 5
      //   297: iload 5
      //   299: iload_1
      //   300: bipush 100
      //   302: imul
      //   303: if_icmpge +210 -> 513
      //   306: aload 19
      //   308: astore 22
      //   310: aload 19
      //   312: astore 21
      //   314: ldc2_w 224
      //   317: invokestatic 231	java/lang/Thread:sleep	(J)V
      //   320: aload 19
      //   322: astore 22
      //   324: aload 19
      //   326: astore 21
      //   328: aload_0
      //   329: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   332: aload_0
      //   333: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   336: invokevirtual 145	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   339: istore 18
      //   341: iload 18
      //   343: ifeq +54 -> 397
      //   346: aload 19
      //   348: ifnull -325 -> 23
      //   351: aload 19
      //   353: invokevirtual 210	java/io/FileInputStream:close	()V
      //   356: return
      //   357: astore 19
      //   359: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   362: ifeq -339 -> 23
      //   365: ldc 93
      //   367: iconst_2
      //   368: new 95	java/lang/StringBuilder
      //   371: dup
      //   372: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   375: ldc 212
      //   377: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   380: aload 19
      //   382: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   385: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   388: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   391: aload 19
      //   393: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   396: return
      //   397: aload 19
      //   399: astore 22
      //   401: aload 19
      //   403: astore 21
      //   405: invokestatic 58	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   408: invokestatic 188	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
      //   411: ifne +93 -> 504
      //   414: aload 19
      //   416: astore 22
      //   418: aload 19
      //   420: astore 21
      //   422: aload_0
      //   423: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   426: aload_0
      //   427: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   430: iconst_3
      //   431: bipush 106
      //   433: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   436: aload 19
      //   438: astore 22
      //   440: aload 19
      //   442: astore 21
      //   444: getstatic 196	apue$a:dVY	I
      //   447: getstatic 199	apue$a:dWh	I
      //   450: invokestatic 205	apue:jY	(II)V
      //   453: aload 19
      //   455: ifnull -432 -> 23
      //   458: aload 19
      //   460: invokevirtual 210	java/io/FileInputStream:close	()V
      //   463: return
      //   464: astore 19
      //   466: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   469: ifeq -446 -> 23
      //   472: ldc 93
      //   474: iconst_2
      //   475: new 95	java/lang/StringBuilder
      //   478: dup
      //   479: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   482: ldc 212
      //   484: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   487: aload 19
      //   489: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   492: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   495: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   498: aload 19
      //   500: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   503: return
      //   504: iload 5
      //   506: iconst_1
      //   507: iadd
      //   508: istore 5
      //   510: goto -213 -> 297
      //   513: aload 19
      //   515: astore 22
      //   517: aload 19
      //   519: astore 21
      //   521: aload_0
      //   522: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   525: aload_0
      //   526: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   529: invokevirtual 145	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   532: istore 18
      //   534: iload 18
      //   536: ifeq +54 -> 590
      //   539: aload 19
      //   541: ifnull -518 -> 23
      //   544: aload 19
      //   546: invokevirtual 210	java/io/FileInputStream:close	()V
      //   549: return
      //   550: astore 19
      //   552: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   555: ifeq -532 -> 23
      //   558: ldc 93
      //   560: iconst_2
      //   561: new 95	java/lang/StringBuilder
      //   564: dup
      //   565: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   568: ldc 212
      //   570: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   573: aload 19
      //   575: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   578: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   581: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   584: aload 19
      //   586: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   589: return
      //   590: aload 19
      //   592: astore 22
      //   594: aload 19
      //   596: astore 21
      //   598: aload 26
      //   600: invokevirtual 235	java/io/File:length	()J
      //   603: aload_0
      //   604: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   607: getfield 238	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   610: lcmp
      //   611: ifeq +94 -> 705
      //   614: aload 19
      //   616: astore 22
      //   618: aload 19
      //   620: astore 21
      //   622: aload_0
      //   623: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   626: aload_0
      //   627: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   630: iconst_3
      //   631: sipush 206
      //   634: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   637: aload 19
      //   639: astore 22
      //   641: aload 19
      //   643: astore 21
      //   645: getstatic 196	apue$a:dVY	I
      //   648: getstatic 241	apue$a:dWq	I
      //   651: invokestatic 205	apue:jY	(II)V
      //   654: aload 19
      //   656: ifnull -633 -> 23
      //   659: aload 19
      //   661: invokevirtual 210	java/io/FileInputStream:close	()V
      //   664: return
      //   665: astore 19
      //   667: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   670: ifeq -647 -> 23
      //   673: ldc 93
      //   675: iconst_2
      //   676: new 95	java/lang/StringBuilder
      //   679: dup
      //   680: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   683: ldc 212
      //   685: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   688: aload 19
      //   690: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   693: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   696: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   699: aload 19
      //   701: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   704: return
      //   705: aload 19
      //   707: astore 20
      //   709: aload 19
      //   711: ifnonnull +22 -> 733
      //   714: aload 19
      //   716: astore 22
      //   718: aload 19
      //   720: astore 21
      //   722: new 207	java/io/FileInputStream
      //   725: dup
      //   726: aload 26
      //   728: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   731: astore 20
      //   733: iload_1
      //   734: iconst_1
      //   735: iadd
      //   736: istore_1
      //   737: aload 20
      //   739: astore 22
      //   741: aload 20
      //   743: astore 21
      //   745: aload_0
      //   746: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   749: iload_1
      //   750: putfield 156	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:retryTimes	I
      //   753: aload 20
      //   755: astore 22
      //   757: aload 20
      //   759: astore 21
      //   761: iload_2
      //   762: newarray byte
      //   764: astore 27
      //   766: lload 8
      //   768: lload 6
      //   770: lcmp
      //   771: ifle +261 -> 1032
      //   774: aload 20
      //   776: astore 23
      //   778: aload 20
      //   780: astore 22
      //   782: aload 20
      //   784: astore 21
      //   786: aload 20
      //   788: lload 8
      //   790: lload 6
      //   792: lsub
      //   793: invokevirtual 248	java/io/FileInputStream:skip	(J)J
      //   796: pop2
      //   797: aload 20
      //   799: astore 19
      //   801: aload 19
      //   803: astore 23
      //   805: aload 19
      //   807: astore 22
      //   809: aload 19
      //   811: astore 21
      //   813: aload 19
      //   815: aload 27
      //   817: invokevirtual 252	java/io/FileInputStream:read	([B)I
      //   820: istore_2
      //   821: iload_2
      //   822: ifle +2892 -> 3714
      //   825: iload_2
      //   826: i2l
      //   827: lload 8
      //   829: ladd
      //   830: lstore 6
      //   832: iload_2
      //   833: ifge +381 -> 1214
      //   836: aload 19
      //   838: astore 21
      //   840: iload_3
      //   841: istore_2
      //   842: aload 21
      //   844: ifnull +8 -> 852
      //   847: aload 21
      //   849: invokevirtual 210	java/io/FileInputStream:close	()V
      //   852: iload_1
      //   853: iconst_3
      //   854: if_icmple +2404 -> 3258
      //   857: aload_0
      //   858: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   861: aload_0
      //   862: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   865: iconst_3
      //   866: bipush 105
      //   868: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   871: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   874: ifeq +34 -> 908
      //   877: ldc 93
      //   879: iconst_2
      //   880: new 95	java/lang/StringBuilder
      //   883: dup
      //   884: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   887: ldc 254
      //   889: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   892: aload_0
      //   893: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   896: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   899: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   902: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   905: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   908: getstatic 260	apue$a:dWa	I
      //   911: iload_2
      //   912: aload_0
      //   913: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   916: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   919: invokestatic 264	apue:M	(IILjava/lang/String;)V
      //   922: aload_0
      //   923: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   926: aconst_null
      //   927: putfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
      //   930: aload_0
      //   931: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   934: aconst_null
      //   935: putfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   938: return
      //   939: astore 20
      //   941: aload 19
      //   943: astore 22
      //   945: aload 19
      //   947: astore 21
      //   949: aload_0
      //   950: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   953: aload_0
      //   954: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   957: iconst_3
      //   958: sipush 201
      //   961: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   964: aload 19
      //   966: astore 22
      //   968: aload 19
      //   970: astore 21
      //   972: getstatic 196	apue$a:dVY	I
      //   975: getstatic 271	apue$a:dWd	I
      //   978: invokestatic 205	apue:jY	(II)V
      //   981: aload 19
      //   983: ifnull -960 -> 23
      //   986: aload 19
      //   988: invokevirtual 210	java/io/FileInputStream:close	()V
      //   991: return
      //   992: astore 19
      //   994: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   997: ifeq -974 -> 23
      //   1000: ldc 93
      //   1002: iconst_2
      //   1003: new 95	java/lang/StringBuilder
      //   1006: dup
      //   1007: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1010: ldc 212
      //   1012: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1015: aload 19
      //   1017: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   1020: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1023: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1026: aload 19
      //   1028: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1031: return
      //   1032: aload 20
      //   1034: astore 19
      //   1036: lload 8
      //   1038: lload 6
      //   1040: lcmp
      //   1041: ifge -240 -> 801
      //   1044: aload 20
      //   1046: astore 23
      //   1048: aload 20
      //   1050: astore 22
      //   1052: aload 20
      //   1054: astore 21
      //   1056: aload 20
      //   1058: invokevirtual 210	java/io/FileInputStream:close	()V
      //   1061: aload 20
      //   1063: astore 23
      //   1065: aload 20
      //   1067: astore 22
      //   1069: aload 20
      //   1071: astore 21
      //   1073: new 207	java/io/FileInputStream
      //   1076: dup
      //   1077: aload 26
      //   1079: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   1082: astore 19
      //   1084: aload 19
      //   1086: lload 8
      //   1088: invokevirtual 248	java/io/FileInputStream:skip	(J)J
      //   1091: pop2
      //   1092: goto -291 -> 801
      //   1095: astore 20
      //   1097: aload 23
      //   1099: astore 19
      //   1101: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1104: ifeq +35 -> 1139
      //   1107: ldc 93
      //   1109: iconst_2
      //   1110: new 95	java/lang/StringBuilder
      //   1113: dup
      //   1114: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1117: ldc_w 273
      //   1120: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1123: aload 20
      //   1125: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   1128: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1131: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1134: aload 20
      //   1136: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1139: aload_0
      //   1140: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1143: aload_0
      //   1144: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1147: iconst_3
      //   1148: sipush 203
      //   1151: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1154: getstatic 196	apue$a:dVY	I
      //   1157: getstatic 276	apue$a:dWg	I
      //   1160: invokestatic 205	apue:jY	(II)V
      //   1163: aload 19
      //   1165: ifnull -1142 -> 23
      //   1168: aload 19
      //   1170: invokevirtual 210	java/io/FileInputStream:close	()V
      //   1173: return
      //   1174: astore 19
      //   1176: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1179: ifeq -1156 -> 23
      //   1182: ldc 93
      //   1184: iconst_2
      //   1185: new 95	java/lang/StringBuilder
      //   1188: dup
      //   1189: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1192: ldc 212
      //   1194: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1197: aload 19
      //   1199: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   1202: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1205: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1208: aload 19
      //   1210: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1213: return
      //   1214: aload 19
      //   1216: astore 22
      //   1218: aload 19
      //   1220: astore 21
      //   1222: aload_0
      //   1223: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1226: getfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
      //   1229: arraylength
      //   1230: iconst_2
      //   1231: iadd
      //   1232: iconst_2
      //   1233: iadd
      //   1234: aload_0
      //   1235: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1238: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   1241: arraylength
      //   1242: iadd
      //   1243: bipush 20
      //   1245: iadd
      //   1246: iload_2
      //   1247: iadd
      //   1248: istore_3
      //   1249: aload 19
      //   1251: astore 22
      //   1253: aload 19
      //   1255: astore 21
      //   1257: new 281	java/io/ByteArrayOutputStream
      //   1260: dup
      //   1261: iload_3
      //   1262: bipush 16
      //   1264: iadd
      //   1265: invokespecial 284	java/io/ByteArrayOutputStream:<init>	(I)V
      //   1268: astore 20
      //   1270: aload 19
      //   1272: astore 22
      //   1274: aload 19
      //   1276: astore 21
      //   1278: new 286	java/io/DataOutputStream
      //   1281: dup
      //   1282: aload 20
      //   1284: invokespecial 289	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   1287: astore 28
      //   1289: aload 28
      //   1291: ldc_w 290
      //   1294: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1297: aload 28
      //   1299: sipush 1007
      //   1302: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1305: aload 28
      //   1307: iconst_0
      //   1308: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1311: aload 28
      //   1313: iload_3
      //   1314: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1317: aload 28
      //   1319: aload_0
      //   1320: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1323: getfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
      //   1326: arraylength
      //   1327: invokevirtual 296	java/io/DataOutputStream:writeShort	(I)V
      //   1330: aload 28
      //   1332: aload_0
      //   1333: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1336: getfield 268	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:CheckKey	[B
      //   1339: invokevirtual 299	java/io/DataOutputStream:write	([B)V
      //   1342: aload 28
      //   1344: aload_0
      //   1345: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1348: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   1351: arraylength
      //   1352: invokevirtual 296	java/io/DataOutputStream:writeShort	(I)V
      //   1355: aload 28
      //   1357: aload_0
      //   1358: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1361: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   1364: invokevirtual 299	java/io/DataOutputStream:write	([B)V
      //   1367: aload 28
      //   1369: aload_0
      //   1370: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1373: getfield 238	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1376: ldc2_w 300
      //   1379: land
      //   1380: l2i
      //   1381: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1384: aload 28
      //   1386: ldc2_w 300
      //   1389: lload 8
      //   1391: land
      //   1392: l2i
      //   1393: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1396: aload 28
      //   1398: iload_2
      //   1399: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1402: aload 28
      //   1404: aload_0
      //   1405: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1408: getfield 238	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   1411: bipush 32
      //   1413: lshr
      //   1414: l2i
      //   1415: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1418: aload 28
      //   1420: lload 8
      //   1422: bipush 32
      //   1424: lshr
      //   1425: l2i
      //   1426: invokevirtual 293	java/io/DataOutputStream:writeInt	(I)V
      //   1429: aload 28
      //   1431: aload 27
      //   1433: iconst_0
      //   1434: iload_2
      //   1435: invokevirtual 304	java/io/DataOutputStream:write	([BII)V
      //   1438: aload 20
      //   1440: invokevirtual 308	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   1443: astore 23
      //   1445: aload 19
      //   1447: astore 22
      //   1449: aload 19
      //   1451: astore 21
      //   1453: aload 20
      //   1455: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
      //   1458: aload 19
      //   1460: astore 22
      //   1462: aload 19
      //   1464: astore 21
      //   1466: aload 28
      //   1468: invokevirtual 310	java/io/DataOutputStream:close	()V
      //   1471: iload 4
      //   1473: ifeq +452 -> 1925
      //   1476: aload 19
      //   1478: astore 22
      //   1480: aload 19
      //   1482: astore 21
      //   1484: ldc_w 312
      //   1487: iconst_5
      //   1488: anewarray 314	java/lang/Object
      //   1491: dup
      //   1492: iconst_0
      //   1493: aload 24
      //   1495: iconst_0
      //   1496: invokeinterface 175 2 0
      //   1501: checkcast 177	mqq/manager/ProxyIpManager$ProxyIp
      //   1504: getfield 317	mqq/manager/ProxyIpManager$ProxyIp:ip	Ljava/lang/String;
      //   1507: aastore
      //   1508: dup
      //   1509: iconst_1
      //   1510: lload 8
      //   1512: invokestatic 323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1515: aastore
      //   1516: dup
      //   1517: iconst_2
      //   1518: iload_2
      //   1519: i2l
      //   1520: lload 8
      //   1522: ladd
      //   1523: invokestatic 323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1526: aastore
      //   1527: dup
      //   1528: iconst_3
      //   1529: aload_0
      //   1530: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1533: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   1536: aastore
      //   1537: dup
      //   1538: iconst_4
      //   1539: bipush 80
      //   1541: invokestatic 328	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1544: aastore
      //   1545: invokestatic 334	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1548: astore 20
      //   1550: aload 19
      //   1552: astore 22
      //   1554: aload 19
      //   1556: astore 21
      //   1558: aload_0
      //   1559: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1562: invokestatic 339	java/lang/System:currentTimeMillis	()J
      //   1565: putfield 342	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferBeginTime	J
      //   1568: aload 19
      //   1570: astore 22
      //   1572: aload 19
      //   1574: astore 21
      //   1576: aload_0
      //   1577: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1580: aload 20
      //   1582: putfield 345	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:uploadUrl	Ljava/lang/String;
      //   1585: aload 19
      //   1587: astore 22
      //   1589: aload 19
      //   1591: astore 21
      //   1593: aload_0
      //   1594: aload 25
      //   1596: aload 20
      //   1598: aload 23
      //   1600: invokespecial 347	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:a	(Lorg/apache/http/client/HttpClient;Ljava/lang/String;[B)Lorg/apache/http/HttpResponse;
      //   1603: astore 27
      //   1605: aload 27
      //   1607: ifnonnull +370 -> 1977
      //   1610: aload 19
      //   1612: astore 22
      //   1614: aload 19
      //   1616: astore 21
      //   1618: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1621: ifeq +27 -> 1648
      //   1624: aload 19
      //   1626: astore 22
      //   1628: aload 19
      //   1630: astore 21
      //   1632: ldc 93
      //   1634: iconst_2
      //   1635: ldc_w 349
      //   1638: iconst_0
      //   1639: anewarray 314	java/lang/Object
      //   1642: invokestatic 334	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1645: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1648: aload 19
      //   1650: astore 22
      //   1652: aload 19
      //   1654: astore 21
      //   1656: getstatic 352	apue$a:dWw	I
      //   1659: istore_3
      //   1660: sipush 16384
      //   1663: istore_2
      //   1664: goto -1518 -> 146
      //   1667: astore 21
      //   1669: ldc 93
      //   1671: iconst_1
      //   1672: ldc_w 354
      //   1675: aload 21
      //   1677: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1680: aload_0
      //   1681: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1684: aload_0
      //   1685: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1688: iconst_3
      //   1689: bipush 102
      //   1691: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1694: getstatic 196	apue$a:dVY	I
      //   1697: getstatic 359	apue$a:dWj	I
      //   1700: invokestatic 205	apue:jY	(II)V
      //   1703: aload 19
      //   1705: astore 22
      //   1707: aload 19
      //   1709: astore 21
      //   1711: aload 20
      //   1713: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
      //   1716: aload 19
      //   1718: astore 22
      //   1720: aload 19
      //   1722: astore 21
      //   1724: aload 28
      //   1726: invokevirtual 310	java/io/DataOutputStream:close	()V
      //   1729: aload 19
      //   1731: ifnull -1708 -> 23
      //   1734: aload 19
      //   1736: invokevirtual 210	java/io/FileInputStream:close	()V
      //   1739: return
      //   1740: astore 19
      //   1742: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1745: ifeq -1722 -> 23
      //   1748: ldc 93
      //   1750: iconst_2
      //   1751: new 95	java/lang/StringBuilder
      //   1754: dup
      //   1755: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1758: ldc 212
      //   1760: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1763: aload 19
      //   1765: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   1768: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1771: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1774: aload 19
      //   1776: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1779: return
      //   1780: astore 23
      //   1782: aload 19
      //   1784: astore 22
      //   1786: aload 19
      //   1788: astore 21
      //   1790: aload 20
      //   1792: invokevirtual 309	java/io/ByteArrayOutputStream:close	()V
      //   1795: aload 19
      //   1797: astore 22
      //   1799: aload 19
      //   1801: astore 21
      //   1803: aload 28
      //   1805: invokevirtual 310	java/io/DataOutputStream:close	()V
      //   1808: aload 19
      //   1810: astore 22
      //   1812: aload 19
      //   1814: astore 21
      //   1816: aload 23
      //   1818: athrow
      //   1819: astore 19
      //   1821: aload 22
      //   1823: astore 21
      //   1825: ldc 93
      //   1827: iconst_1
      //   1828: ldc_w 361
      //   1831: aload 19
      //   1833: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1836: aload 22
      //   1838: astore 21
      //   1840: aload_0
      //   1841: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   1844: aload_0
      //   1845: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1848: iconst_3
      //   1849: bipush 102
      //   1851: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   1854: aload 22
      //   1856: astore 21
      //   1858: getstatic 196	apue$a:dVY	I
      //   1861: getstatic 364	apue$a:dWr	I
      //   1864: aload_0
      //   1865: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1868: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   1871: invokestatic 264	apue:M	(IILjava/lang/String;)V
      //   1874: aload 22
      //   1876: ifnull -1853 -> 23
      //   1879: aload 22
      //   1881: invokevirtual 210	java/io/FileInputStream:close	()V
      //   1884: return
      //   1885: astore 19
      //   1887: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1890: ifeq -1867 -> 23
      //   1893: ldc 93
      //   1895: iconst_2
      //   1896: new 95	java/lang/StringBuilder
      //   1899: dup
      //   1900: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   1903: ldc 212
      //   1905: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1908: aload 19
      //   1910: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   1913: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1916: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1919: aload 19
      //   1921: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1924: return
      //   1925: aload 19
      //   1927: astore 22
      //   1929: aload 19
      //   1931: astore 21
      //   1933: ldc_w 366
      //   1936: iconst_3
      //   1937: anewarray 314	java/lang/Object
      //   1940: dup
      //   1941: iconst_0
      //   1942: aload_0
      //   1943: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   1946: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   1949: aastore
      //   1950: dup
      //   1951: iconst_1
      //   1952: lload 8
      //   1954: invokestatic 323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1957: aastore
      //   1958: dup
      //   1959: iconst_2
      //   1960: iload_2
      //   1961: i2l
      //   1962: lload 8
      //   1964: ladd
      //   1965: invokestatic 323	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1968: aastore
      //   1969: invokestatic 334	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   1972: astore 20
      //   1974: goto -424 -> 1550
      //   1977: aload 19
      //   1979: astore 22
      //   1981: aload 19
      //   1983: astore 21
      //   1985: aload 27
      //   1987: invokeinterface 372 1 0
      //   1992: invokeinterface 377 1 0
      //   1997: istore_3
      //   1998: iload_3
      //   1999: sipush 200
      //   2002: if_icmpeq +514 -> 2516
      //   2005: iload_3
      //   2006: sipush 206
      //   2009: if_icmpeq +507 -> 2516
      //   2012: aload 19
      //   2014: astore 22
      //   2016: aload 19
      //   2018: astore 21
      //   2020: aload 27
      //   2022: invokeinterface 381 1 0
      //   2027: astore 20
      //   2029: aload 20
      //   2031: ifnull +123 -> 2154
      //   2034: aload 19
      //   2036: astore 22
      //   2038: aload 19
      //   2040: astore 21
      //   2042: new 95	java/lang/StringBuilder
      //   2045: dup
      //   2046: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   2049: astore 23
      //   2051: aload 19
      //   2053: astore 22
      //   2055: aload 19
      //   2057: astore 21
      //   2059: aload 20
      //   2061: arraylength
      //   2062: istore 5
      //   2064: iconst_0
      //   2065: istore_2
      //   2066: iload_2
      //   2067: iload 5
      //   2069: if_icmpge +65 -> 2134
      //   2072: aload 20
      //   2074: iload_2
      //   2075: aaload
      //   2076: astore 28
      //   2078: aload 19
      //   2080: astore 22
      //   2082: aload 19
      //   2084: astore 21
      //   2086: aload 23
      //   2088: ldc_w 383
      //   2091: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2094: aload 28
      //   2096: invokeinterface 388 1 0
      //   2101: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2104: ldc_w 390
      //   2107: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2110: aload 28
      //   2112: invokeinterface 393 1 0
      //   2117: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2120: ldc_w 395
      //   2123: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2126: pop
      //   2127: iload_2
      //   2128: iconst_1
      //   2129: iadd
      //   2130: istore_2
      //   2131: goto -65 -> 2066
      //   2134: aload 19
      //   2136: astore 22
      //   2138: aload 19
      //   2140: astore 21
      //   2142: aload_0
      //   2143: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2146: aload 23
      //   2148: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2151: putfield 398	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:rspHeadStr	Ljava/lang/String;
      //   2154: aload 19
      //   2156: astore 22
      //   2158: aload 19
      //   2160: astore 21
      //   2162: aload 27
      //   2164: ldc_w 400
      //   2167: invokeinterface 404 2 0
      //   2172: astore 20
      //   2174: iload_3
      //   2175: istore_2
      //   2176: lload 8
      //   2178: lstore 10
      //   2180: aload 20
      //   2182: ifnull +1499 -> 3681
      //   2185: aload 19
      //   2187: astore 22
      //   2189: aload 19
      //   2191: astore 21
      //   2193: iload_3
      //   2194: istore_2
      //   2195: lload 8
      //   2197: lstore 10
      //   2199: aload 20
      //   2201: invokeinterface 393 1 0
      //   2206: ifnull +1475 -> 3681
      //   2209: aload 19
      //   2211: astore 22
      //   2213: aload 19
      //   2215: astore 21
      //   2217: aload 20
      //   2219: invokeinterface 393 1 0
      //   2224: ldc_w 406
      //   2227: invokevirtual 410	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2230: ifeq +16 -> 2246
      //   2233: iconst_4
      //   2234: istore_1
      //   2235: sipush -6101
      //   2238: istore_2
      //   2239: aload 19
      //   2241: astore 21
      //   2243: goto -1401 -> 842
      //   2246: aload 19
      //   2248: astore 22
      //   2250: aload 19
      //   2252: astore 21
      //   2254: aload 20
      //   2256: invokeinterface 393 1 0
      //   2261: ldc_w 412
      //   2264: invokevirtual 410	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2267: ifne +51 -> 2318
      //   2270: aload 19
      //   2272: astore 22
      //   2274: aload 19
      //   2276: astore 21
      //   2278: aload 20
      //   2280: invokeinterface 393 1 0
      //   2285: ldc_w 414
      //   2288: invokevirtual 410	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2291: ifne +27 -> 2318
      //   2294: aload 19
      //   2296: astore 22
      //   2298: aload 19
      //   2300: astore 21
      //   2302: aload 20
      //   2304: invokeinterface 393 1 0
      //   2309: ldc_w 416
      //   2312: invokevirtual 410	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2315: ifeq +111 -> 2426
      //   2318: aload 19
      //   2320: astore 22
      //   2322: aload 19
      //   2324: astore 21
      //   2326: aload_0
      //   2327: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   2330: aload_0
      //   2331: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2334: iconst_3
      //   2335: sipush 206
      //   2338: invokevirtual 191	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   2341: aload 19
      //   2343: astore 22
      //   2345: aload 19
      //   2347: astore 21
      //   2349: getstatic 260	apue$a:dWa	I
      //   2352: aload 20
      //   2354: invokeinterface 393 1 0
      //   2359: invokestatic 419	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   2362: invokevirtual 422	java/lang/Integer:intValue	()I
      //   2365: aload_0
      //   2366: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2369: getfield 257	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:UploadIp	Ljava/lang/String;
      //   2372: invokestatic 264	apue:M	(IILjava/lang/String;)V
      //   2375: aload 19
      //   2377: ifnull -2354 -> 23
      //   2380: aload 19
      //   2382: invokevirtual 210	java/io/FileInputStream:close	()V
      //   2385: return
      //   2386: astore 19
      //   2388: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2391: ifeq -2368 -> 23
      //   2394: ldc 93
      //   2396: iconst_2
      //   2397: new 95	java/lang/StringBuilder
      //   2400: dup
      //   2401: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   2404: ldc 212
      //   2406: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2409: aload 19
      //   2411: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   2414: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2417: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2420: aload 19
      //   2422: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2425: return
      //   2426: aload 19
      //   2428: astore 22
      //   2430: aload 19
      //   2432: astore 21
      //   2434: aload 20
      //   2436: invokeinterface 393 1 0
      //   2441: astore 20
      //   2443: iload_3
      //   2444: istore_2
      //   2445: aload 20
      //   2447: ifnull +38 -> 2485
      //   2450: aload 19
      //   2452: astore 22
      //   2454: iload_3
      //   2455: istore_2
      //   2456: aload 19
      //   2458: astore 21
      //   2460: aload 20
      //   2462: invokestatic 428	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   2465: ifne +20 -> 2485
      //   2468: aload 19
      //   2470: astore 22
      //   2472: aload 19
      //   2474: astore 21
      //   2476: aload 20
      //   2478: invokestatic 419	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   2481: invokevirtual 422	java/lang/Integer:intValue	()I
      //   2484: istore_2
      //   2485: sipush 16384
      //   2488: istore 5
      //   2490: iload_2
      //   2491: istore_3
      //   2492: iload 5
      //   2494: istore_2
      //   2495: goto -2349 -> 146
      //   2498: astore 20
      //   2500: sipush 16384
      //   2503: istore_2
      //   2504: goto -2358 -> 146
      //   2507: astore 20
      //   2509: sipush 16384
      //   2512: istore_2
      //   2513: goto -2367 -> 146
      //   2516: aload 19
      //   2518: astore 22
      //   2520: aload 19
      //   2522: astore 21
      //   2524: aload_0
      //   2525: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   2528: iconst_0
      //   2529: aload 23
      //   2531: arraylength
      //   2532: i2l
      //   2533: invokestatic 431	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;IJ)V
      //   2536: new 433	java/io/DataInputStream
      //   2539: dup
      //   2540: aload 27
      //   2542: invokeinterface 437 1 0
      //   2547: invokeinterface 443 1 0
      //   2552: invokespecial 446	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
      //   2555: astore 20
      //   2557: aload 20
      //   2559: astore 21
      //   2561: lload 8
      //   2563: lstore 10
      //   2565: lload 8
      //   2567: lstore 12
      //   2569: aload 20
      //   2571: ldc2_w 447
      //   2574: invokevirtual 449	java/io/DataInputStream:skip	(J)J
      //   2577: pop2
      //   2578: aload 20
      //   2580: astore 21
      //   2582: lload 8
      //   2584: lstore 10
      //   2586: lload 8
      //   2588: lstore 12
      //   2590: aload 20
      //   2592: invokevirtual 453	java/io/DataInputStream:readByte	()B
      //   2595: istore_2
      //   2596: iload_2
      //   2597: ifeq +87 -> 2684
      //   2600: iconst_0
      //   2601: istore 4
      //   2603: iload_3
      //   2604: istore_2
      //   2605: iload 4
      //   2607: istore_1
      //   2608: aload 19
      //   2610: astore 21
      //   2612: aload 20
      //   2614: ifnull -1772 -> 842
      //   2617: aload 19
      //   2619: astore 22
      //   2621: aload 19
      //   2623: astore 21
      //   2625: aload 20
      //   2627: invokevirtual 454	java/io/DataInputStream:close	()V
      //   2630: iload_3
      //   2631: istore_2
      //   2632: iload 4
      //   2634: istore_1
      //   2635: aload 19
      //   2637: astore 21
      //   2639: goto -1797 -> 842
      //   2642: astore 20
      //   2644: aload 19
      //   2646: astore 22
      //   2648: aload 19
      //   2650: astore 21
      //   2652: aload 20
      //   2654: invokevirtual 118	java/io/IOException:printStackTrace	()V
      //   2657: iload_3
      //   2658: istore_2
      //   2659: iload 4
      //   2661: istore_1
      //   2662: aload 19
      //   2664: astore 21
      //   2666: goto -1824 -> 842
      //   2669: astore 19
      //   2671: aload 21
      //   2673: ifnull +8 -> 2681
      //   2676: aload 21
      //   2678: invokevirtual 210	java/io/FileInputStream:close	()V
      //   2681: aload 19
      //   2683: athrow
      //   2684: aload 20
      //   2686: astore 21
      //   2688: lload 8
      //   2690: lstore 10
      //   2692: lload 8
      //   2694: lstore 12
      //   2696: aload 20
      //   2698: invokevirtual 457	java/io/DataInputStream:readInt	()I
      //   2701: i2l
      //   2702: lstore 14
      //   2704: aload 20
      //   2706: astore 21
      //   2708: lload 8
      //   2710: lstore 10
      //   2712: lload 8
      //   2714: lstore 12
      //   2716: aload 20
      //   2718: invokevirtual 457	java/io/DataInputStream:readInt	()I
      //   2721: i2l
      //   2722: lstore 16
      //   2724: aload 20
      //   2726: astore 21
      //   2728: lload 8
      //   2730: lstore 10
      //   2732: lload 8
      //   2734: lstore 12
      //   2736: aload 27
      //   2738: invokeinterface 437 1 0
      //   2743: invokeinterface 460 1 0
      //   2748: lload 16
      //   2750: bipush 32
      //   2752: lshl
      //   2753: lload 14
      //   2755: lor
      //   2756: lstore 8
      //   2758: aload 20
      //   2760: astore 21
      //   2762: lload 8
      //   2764: lstore 10
      //   2766: lload 8
      //   2768: lstore 12
      //   2770: aload_0
      //   2771: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2774: getfield 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   2777: lload 8
      //   2779: lcmp
      //   2780: ifgt +73 -> 2853
      //   2783: aload 20
      //   2785: astore 21
      //   2787: lload 8
      //   2789: lstore 10
      //   2791: lload 8
      //   2793: lstore 12
      //   2795: aload_0
      //   2796: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2799: lload 8
      //   2801: putfield 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   2804: aload 20
      //   2806: astore 21
      //   2808: lload 8
      //   2810: lstore 10
      //   2812: lload 8
      //   2814: lstore 12
      //   2816: aload_0
      //   2817: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2820: aload_0
      //   2821: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2824: getfield 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   2827: putfield 463	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:transferedSize	J
      //   2830: aload 20
      //   2832: astore 21
      //   2834: lload 8
      //   2836: lstore 10
      //   2838: lload 8
      //   2840: lstore 12
      //   2842: aload_0
      //   2843: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   2846: aload_0
      //   2847: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   2850: invokevirtual 466	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   2853: lload 8
      //   2855: lload 6
      //   2857: lcmp
      //   2858: ifeq +71 -> 2929
      //   2861: aload 20
      //   2863: astore 21
      //   2865: lload 8
      //   2867: lstore 10
      //   2869: lload 8
      //   2871: lstore 12
      //   2873: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2876: ifeq +53 -> 2929
      //   2879: aload 20
      //   2881: astore 21
      //   2883: lload 8
      //   2885: lstore 10
      //   2887: lload 8
      //   2889: lstore 12
      //   2891: ldc 93
      //   2893: iconst_2
      //   2894: new 95	java/lang/StringBuilder
      //   2897: dup
      //   2898: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   2901: ldc_w 468
      //   2904: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2907: lload 8
      //   2909: invokevirtual 471	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2912: ldc_w 473
      //   2915: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2918: lload 6
      //   2920: invokevirtual 471	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   2923: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2926: invokestatic 475	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   2929: aload 20
      //   2931: ifnull +16 -> 2947
      //   2934: aload 19
      //   2936: astore 22
      //   2938: aload 19
      //   2940: astore 21
      //   2942: aload 20
      //   2944: invokevirtual 454	java/io/DataInputStream:close	()V
      //   2947: sipush 16384
      //   2950: istore_2
      //   2951: iconst_0
      //   2952: istore_1
      //   2953: goto -2807 -> 146
      //   2956: astore 20
      //   2958: aload 19
      //   2960: astore 22
      //   2962: aload 19
      //   2964: astore 21
      //   2966: aload 20
      //   2968: invokevirtual 118	java/io/IOException:printStackTrace	()V
      //   2971: goto -24 -> 2947
      //   2974: astore 21
      //   2976: aconst_null
      //   2977: astore 20
      //   2979: ldc 93
      //   2981: iconst_1
      //   2982: ldc_w 477
      //   2985: aload 21
      //   2987: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2990: getstatic 352	apue$a:dWw	I
      //   2993: istore_3
      //   2994: aload 20
      //   2996: ifnull +702 -> 3698
      //   2999: aload 19
      //   3001: astore 22
      //   3003: aload 19
      //   3005: astore 21
      //   3007: aload 20
      //   3009: invokevirtual 454	java/io/DataInputStream:close	()V
      //   3012: sipush 16384
      //   3015: istore_2
      //   3016: goto -2870 -> 146
      //   3019: astore 20
      //   3021: aload 19
      //   3023: astore 22
      //   3025: aload 19
      //   3027: astore 21
      //   3029: aload 20
      //   3031: invokevirtual 118	java/io/IOException:printStackTrace	()V
      //   3034: sipush 16384
      //   3037: istore_2
      //   3038: goto -2892 -> 146
      //   3041: astore 22
      //   3043: aconst_null
      //   3044: astore 20
      //   3046: aload 20
      //   3048: astore 21
      //   3050: ldc 93
      //   3052: iconst_1
      //   3053: ldc_w 479
      //   3056: aload 22
      //   3058: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   3061: aload 20
      //   3063: astore 21
      //   3065: getstatic 352	apue$a:dWw	I
      //   3068: istore_3
      //   3069: iload_3
      //   3070: istore_2
      //   3071: lload 8
      //   3073: lstore 10
      //   3075: aload 20
      //   3077: ifnull +604 -> 3681
      //   3080: aload 19
      //   3082: astore 22
      //   3084: aload 19
      //   3086: astore 21
      //   3088: aload 20
      //   3090: invokevirtual 454	java/io/DataInputStream:close	()V
      //   3093: sipush 16384
      //   3096: istore_2
      //   3097: goto -2951 -> 146
      //   3100: astore 20
      //   3102: aload 19
      //   3104: astore 22
      //   3106: aload 19
      //   3108: astore 21
      //   3110: aload 20
      //   3112: invokevirtual 118	java/io/IOException:printStackTrace	()V
      //   3115: sipush 16384
      //   3118: istore_2
      //   3119: goto -2973 -> 146
      //   3122: astore 20
      //   3124: aconst_null
      //   3125: astore 23
      //   3127: aload 23
      //   3129: ifnull +16 -> 3145
      //   3132: aload 19
      //   3134: astore 22
      //   3136: aload 19
      //   3138: astore 21
      //   3140: aload 23
      //   3142: invokevirtual 454	java/io/DataInputStream:close	()V
      //   3145: aload 19
      //   3147: astore 22
      //   3149: aload 19
      //   3151: astore 21
      //   3153: aload 20
      //   3155: athrow
      //   3156: astore 23
      //   3158: aload 19
      //   3160: astore 22
      //   3162: aload 19
      //   3164: astore 21
      //   3166: aload 23
      //   3168: invokevirtual 118	java/io/IOException:printStackTrace	()V
      //   3171: goto -26 -> 3145
      //   3174: astore 19
      //   3176: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3179: ifeq -2327 -> 852
      //   3182: ldc 93
      //   3184: iconst_2
      //   3185: new 95	java/lang/StringBuilder
      //   3188: dup
      //   3189: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   3192: ldc 212
      //   3194: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3197: aload 19
      //   3199: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   3202: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3205: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3208: aload 19
      //   3210: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   3213: goto -2361 -> 852
      //   3216: astore 20
      //   3218: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3221: ifeq -540 -> 2681
      //   3224: ldc 93
      //   3226: iconst_2
      //   3227: new 95	java/lang/StringBuilder
      //   3230: dup
      //   3231: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   3234: ldc 212
      //   3236: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3239: aload 20
      //   3241: invokevirtual 213	java/io/IOException:toString	()Ljava/lang/String;
      //   3244: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3247: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3250: aload 20
      //   3252: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   3255: goto -574 -> 2681
      //   3258: aload_0
      //   3259: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3262: aload_0
      //   3263: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3266: getfield 238	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   3269: putfield 141	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
      //   3272: aload_0
      //   3273: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3276: aload_0
      //   3277: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3280: bipush 6
      //   3282: invokevirtual 483	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
      //   3285: aload_0
      //   3286: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3289: aload_0
      //   3290: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3293: invokevirtual 485	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   3296: aload_0
      //   3297: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3300: getfield 488	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
      //   3303: invokestatic 494	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   3306: astore 19
      //   3308: aload_0
      //   3309: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3312: getfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   3315: invokestatic 494	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   3318: astore 20
      //   3320: aload_0
      //   3321: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3324: aload_0
      //   3325: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3328: aload_0
      //   3329: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3332: getfield 497	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   3335: invokevirtual 501	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
      //   3338: iconst_1
      //   3339: aload 19
      //   3341: aload 20
      //   3343: aload_0
      //   3344: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3347: getfield 504	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
      //   3350: invokevirtual 507	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lapcy;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   3353: aload_0
      //   3354: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3357: aconst_null
      //   3358: putfield 488	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
      //   3361: aload_0
      //   3362: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3365: aconst_null
      //   3366: putfield 279	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   3369: aload_0
      //   3370: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3373: getfield 511	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
      //   3376: astore 19
      //   3378: new 95	java/lang/StringBuilder
      //   3381: dup
      //   3382: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   3385: aload_0
      //   3386: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3389: getfield 497	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   3392: invokevirtual 471	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3395: ldc_w 513
      //   3398: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3401: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3404: astore 20
      //   3406: new 95	java/lang/StringBuilder
      //   3409: dup
      //   3410: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   3413: astore 21
      //   3415: ldc_w 515
      //   3418: aload_0
      //   3419: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3422: getfield 518	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
      //   3425: invokevirtual 410	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3428: ifeq +131 -> 3559
      //   3431: iconst_0
      //   3432: istore_1
      //   3433: aload 19
      //   3435: ldc_w 520
      //   3438: ldc_w 522
      //   3441: ldc_w 513
      //   3444: ldc_w 524
      //   3447: ldc_w 526
      //   3450: iconst_0
      //   3451: iconst_0
      //   3452: aload 20
      //   3454: aload 21
      //   3456: iload_1
      //   3457: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3460: ldc_w 513
      //   3463: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3466: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3469: ldc_w 513
      //   3472: ldc_w 513
      //   3475: invokestatic 534	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   3478: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3481: ifeq +68 -> 3549
      //   3484: new 95	java/lang/StringBuilder
      //   3487: dup
      //   3488: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   3491: ldc_w 536
      //   3494: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3497: aload_0
      //   3498: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   3501: getfield 497	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:mTroopUin	J
      //   3504: invokevirtual 471	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   3507: ldc_w 538
      //   3510: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3513: astore 19
      //   3515: ldc_w 515
      //   3518: aload_0
      //   3519: getfield 135	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskHttpUpload:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   3522: getfield 518	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mParentId	Ljava/lang/String;
      //   3525: invokevirtual 410	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3528: ifeq +36 -> 3564
      //   3531: iconst_0
      //   3532: istore_1
      //   3533: ldc_w 540
      //   3536: iconst_2
      //   3537: aload 19
      //   3539: iload_1
      //   3540: invokevirtual 529	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   3543: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3546: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   3549: getstatic 543	apue$a:RESULT_SUCCESS	I
      //   3552: iconst_0
      //   3553: invokestatic 205	apue:jY	(II)V
      //   3556: goto -2634 -> 922
      //   3559: iconst_1
      //   3560: istore_1
      //   3561: goto -128 -> 3433
      //   3564: iconst_1
      //   3565: istore_1
      //   3566: goto -33 -> 3533
      //   3569: astore 20
      //   3571: aload 19
      //   3573: astore 21
      //   3575: aload 20
      //   3577: astore 19
      //   3579: goto -908 -> 2671
      //   3582: astore 20
      //   3584: aload 19
      //   3586: astore 21
      //   3588: aload 20
      //   3590: astore 19
      //   3592: goto -921 -> 2671
      //   3595: astore 20
      //   3597: aload 19
      //   3599: astore 22
      //   3601: aload 20
      //   3603: astore 19
      //   3605: goto -1784 -> 1821
      //   3608: astore 20
      //   3610: aload 19
      //   3612: astore 22
      //   3614: aload 20
      //   3616: astore 19
      //   3618: goto -1797 -> 1821
      //   3621: astore 20
      //   3623: aload 21
      //   3625: astore 23
      //   3627: goto -500 -> 3127
      //   3630: astore 21
      //   3632: aload 20
      //   3634: astore 23
      //   3636: aload 21
      //   3638: astore 20
      //   3640: goto -513 -> 3127
      //   3643: astore 22
      //   3645: lload 10
      //   3647: lstore 8
      //   3649: goto -603 -> 3046
      //   3652: astore 21
      //   3654: lload 12
      //   3656: lstore 8
      //   3658: goto -679 -> 2979
      //   3661: astore 20
      //   3663: goto -1855 -> 1808
      //   3666: astore 20
      //   3668: goto -1939 -> 1729
      //   3671: astore 20
      //   3673: goto -2202 -> 1471
      //   3676: astore 20
      //   3678: goto -2577 -> 1101
      //   3681: sipush 16384
      //   3684: istore 5
      //   3686: iload_2
      //   3687: istore_3
      //   3688: lload 10
      //   3690: lstore 8
      //   3692: iload 5
      //   3694: istore_2
      //   3695: goto -3549 -> 146
      //   3698: sipush 16384
      //   3701: istore_2
      //   3702: goto -3556 -> 146
      //   3705: iload_3
      //   3706: istore_2
      //   3707: aload 19
      //   3709: astore 21
      //   3711: goto -2869 -> 842
      //   3714: lload 8
      //   3716: lstore 6
      //   3718: goto -2886 -> 832
      //   3721: aconst_null
      //   3722: astore 24
      //   3724: goto -3651 -> 73
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	3727	0	this	TaskHttpUpload
      //   145	3421	1	i	int
      //   139	3568	2	j	int
      //   135	3571	3	k	int
      //   74	2586	4	m	int
      //   295	3398	5	n	int
      //   142	3575	6	l1	long
      //   7	3708	8	l2	long
      //   2178	1511	10	l3	long
      //   2567	1088	12	l4	long
      //   2702	52	14	l5	long
      //   2722	27	16	l6	long
      //   269	266	18	bool	boolean
      //   132	85	19	localObject1	Object
      //   222	130	19	localIOException1	IOException
      //   357	102	19	localIOException2	IOException
      //   464	81	19	localIOException3	IOException
      //   550	110	19	localIOException4	IOException
      //   665	54	19	localIOException5	IOException
      //   799	188	19	localObject2	Object
      //   992	35	19	localIOException6	IOException
      //   1034	135	19	localObject3	Object
      //   1174	561	19	localIOException7	IOException
      //   1740	73	19	localIOException8	IOException
      //   1819	13	19	localInterruptedException1	java.lang.InterruptedException
      //   1885	496	19	localIOException9	IOException
      //   2386	277	19	localIOException10	IOException
      //   2669	494	19	localObject4	Object
      //   3174	35	19	localIOException11	IOException
      //   3306	402	19	localObject5	Object
      //   707	91	20	localObject6	Object
      //   939	131	20	localFileNotFoundException	java.io.FileNotFoundException
      //   1095	40	20	localIOException12	IOException
      //   1268	1209	20	localObject7	Object
      //   2498	1	20	localNumberFormatException	java.lang.NumberFormatException
      //   2507	1	20	localException1	Exception
      //   2555	71	20	localDataInputStream	java.io.DataInputStream
      //   2642	301	20	localIOException13	IOException
      //   2956	11	20	localIOException14	IOException
      //   2977	31	20	localObject8	Object
      //   3019	11	20	localIOException15	IOException
      //   3044	45	20	localObject9	Object
      //   3100	11	20	localIOException16	IOException
      //   3122	32	20	localObject10	Object
      //   3216	35	20	localIOException17	IOException
      //   3318	135	20	str	String
      //   3569	7	20	localObject11	Object
      //   3582	7	20	localObject12	Object
      //   3595	7	20	localInterruptedException2	java.lang.InterruptedException
      //   3608	7	20	localInterruptedException3	java.lang.InterruptedException
      //   3621	12	20	localObject13	Object
      //   3638	1	20	localObject14	Object
      //   3661	1	20	localException2	Exception
      //   3666	1	20	localException3	Exception
      //   3671	1	20	localException4	Exception
      //   3676	1	20	localIOException18	IOException
      //   161	1494	21	localObject15	Object
      //   1667	9	21	localIOException19	IOException
      //   1709	1256	21	localObject16	Object
      //   2974	12	21	localIllegalStateException1	java.lang.IllegalStateException
      //   3005	619	21	localObject17	Object
      //   3630	7	21	localObject18	Object
      //   3652	1	21	localIllegalStateException2	java.lang.IllegalStateException
      //   3709	1	21	localObject19	Object
      //   157	2867	22	localObject20	Object
      //   3041	16	22	localIOException20	IOException
      //   3082	531	22	localObject21	Object
      //   3643	1	22	localIOException21	IOException
      //   776	823	23	localObject22	Object
      //   1780	37	23	localObject23	Object
      //   2049	1092	23	localStringBuilder	StringBuilder
      //   3156	11	23	localIOException22	IOException
      //   3625	10	23	localObject24	Object
      //   71	3652	24	localList	List
      //   126	1469	25	localHttpClient	HttpClient
      //   38	1040	26	localFile	File
      //   764	1973	27	localObject25	Object
      //   1287	824	28	localDataOutputStream	java.io.DataOutputStream
      // Exception table:
      //   from	to	target	type
      //   216	221	222	java/io/IOException
      //   351	356	357	java/io/IOException
      //   458	463	464	java/io/IOException
      //   544	549	550	java/io/IOException
      //   659	664	665	java/io/IOException
      //   722	733	939	java/io/FileNotFoundException
      //   986	991	992	java/io/IOException
      //   786	797	1095	java/io/IOException
      //   813	821	1095	java/io/IOException
      //   1056	1061	1095	java/io/IOException
      //   1073	1084	1095	java/io/IOException
      //   1168	1173	1174	java/io/IOException
      //   1289	1445	1667	java/io/IOException
      //   1734	1739	1740	java/io/IOException
      //   1289	1445	1780	finally
      //   1669	1703	1780	finally
      //   163	172	1819	java/lang/InterruptedException
      //   180	194	1819	java/lang/InterruptedException
      //   202	211	1819	java/lang/InterruptedException
      //   314	320	1819	java/lang/InterruptedException
      //   328	341	1819	java/lang/InterruptedException
      //   405	414	1819	java/lang/InterruptedException
      //   422	436	1819	java/lang/InterruptedException
      //   444	453	1819	java/lang/InterruptedException
      //   521	534	1819	java/lang/InterruptedException
      //   598	614	1819	java/lang/InterruptedException
      //   622	637	1819	java/lang/InterruptedException
      //   645	654	1819	java/lang/InterruptedException
      //   722	733	1819	java/lang/InterruptedException
      //   745	753	1819	java/lang/InterruptedException
      //   761	766	1819	java/lang/InterruptedException
      //   786	797	1819	java/lang/InterruptedException
      //   813	821	1819	java/lang/InterruptedException
      //   949	964	1819	java/lang/InterruptedException
      //   972	981	1819	java/lang/InterruptedException
      //   1056	1061	1819	java/lang/InterruptedException
      //   1073	1084	1819	java/lang/InterruptedException
      //   1222	1249	1819	java/lang/InterruptedException
      //   1257	1270	1819	java/lang/InterruptedException
      //   1278	1289	1819	java/lang/InterruptedException
      //   1453	1458	1819	java/lang/InterruptedException
      //   1466	1471	1819	java/lang/InterruptedException
      //   1484	1550	1819	java/lang/InterruptedException
      //   1558	1568	1819	java/lang/InterruptedException
      //   1576	1585	1819	java/lang/InterruptedException
      //   1593	1605	1819	java/lang/InterruptedException
      //   1618	1624	1819	java/lang/InterruptedException
      //   1632	1648	1819	java/lang/InterruptedException
      //   1656	1660	1819	java/lang/InterruptedException
      //   1711	1716	1819	java/lang/InterruptedException
      //   1724	1729	1819	java/lang/InterruptedException
      //   1790	1795	1819	java/lang/InterruptedException
      //   1803	1808	1819	java/lang/InterruptedException
      //   1816	1819	1819	java/lang/InterruptedException
      //   1933	1974	1819	java/lang/InterruptedException
      //   1985	1998	1819	java/lang/InterruptedException
      //   2020	2029	1819	java/lang/InterruptedException
      //   2042	2051	1819	java/lang/InterruptedException
      //   2059	2064	1819	java/lang/InterruptedException
      //   2086	2127	1819	java/lang/InterruptedException
      //   2142	2154	1819	java/lang/InterruptedException
      //   2162	2174	1819	java/lang/InterruptedException
      //   2199	2209	1819	java/lang/InterruptedException
      //   2217	2233	1819	java/lang/InterruptedException
      //   2254	2270	1819	java/lang/InterruptedException
      //   2278	2294	1819	java/lang/InterruptedException
      //   2302	2318	1819	java/lang/InterruptedException
      //   2326	2341	1819	java/lang/InterruptedException
      //   2349	2375	1819	java/lang/InterruptedException
      //   2434	2443	1819	java/lang/InterruptedException
      //   2460	2468	1819	java/lang/InterruptedException
      //   2476	2485	1819	java/lang/InterruptedException
      //   2524	2536	1819	java/lang/InterruptedException
      //   2625	2630	1819	java/lang/InterruptedException
      //   2652	2657	1819	java/lang/InterruptedException
      //   2942	2947	1819	java/lang/InterruptedException
      //   2966	2971	1819	java/lang/InterruptedException
      //   3007	3012	1819	java/lang/InterruptedException
      //   3029	3034	1819	java/lang/InterruptedException
      //   3088	3093	1819	java/lang/InterruptedException
      //   3110	3115	1819	java/lang/InterruptedException
      //   3140	3145	1819	java/lang/InterruptedException
      //   3153	3156	1819	java/lang/InterruptedException
      //   3166	3171	1819	java/lang/InterruptedException
      //   1879	1884	1885	java/io/IOException
      //   2380	2385	2386	java/io/IOException
      //   2434	2443	2498	java/lang/NumberFormatException
      //   2460	2468	2498	java/lang/NumberFormatException
      //   2476	2485	2498	java/lang/NumberFormatException
      //   2434	2443	2507	java/lang/Exception
      //   2460	2468	2507	java/lang/Exception
      //   2476	2485	2507	java/lang/Exception
      //   2625	2630	2642	java/io/IOException
      //   163	172	2669	finally
      //   180	194	2669	finally
      //   202	211	2669	finally
      //   314	320	2669	finally
      //   328	341	2669	finally
      //   405	414	2669	finally
      //   422	436	2669	finally
      //   444	453	2669	finally
      //   521	534	2669	finally
      //   598	614	2669	finally
      //   622	637	2669	finally
      //   645	654	2669	finally
      //   722	733	2669	finally
      //   745	753	2669	finally
      //   761	766	2669	finally
      //   786	797	2669	finally
      //   813	821	2669	finally
      //   949	964	2669	finally
      //   972	981	2669	finally
      //   1056	1061	2669	finally
      //   1073	1084	2669	finally
      //   1222	1249	2669	finally
      //   1257	1270	2669	finally
      //   1278	1289	2669	finally
      //   1453	1458	2669	finally
      //   1466	1471	2669	finally
      //   1484	1550	2669	finally
      //   1558	1568	2669	finally
      //   1576	1585	2669	finally
      //   1593	1605	2669	finally
      //   1618	1624	2669	finally
      //   1632	1648	2669	finally
      //   1656	1660	2669	finally
      //   1711	1716	2669	finally
      //   1724	1729	2669	finally
      //   1790	1795	2669	finally
      //   1803	1808	2669	finally
      //   1816	1819	2669	finally
      //   1825	1836	2669	finally
      //   1840	1854	2669	finally
      //   1858	1874	2669	finally
      //   1933	1974	2669	finally
      //   1985	1998	2669	finally
      //   2020	2029	2669	finally
      //   2042	2051	2669	finally
      //   2059	2064	2669	finally
      //   2086	2127	2669	finally
      //   2142	2154	2669	finally
      //   2162	2174	2669	finally
      //   2199	2209	2669	finally
      //   2217	2233	2669	finally
      //   2254	2270	2669	finally
      //   2278	2294	2669	finally
      //   2302	2318	2669	finally
      //   2326	2341	2669	finally
      //   2349	2375	2669	finally
      //   2434	2443	2669	finally
      //   2460	2468	2669	finally
      //   2476	2485	2669	finally
      //   2524	2536	2669	finally
      //   2625	2630	2669	finally
      //   2652	2657	2669	finally
      //   2942	2947	2669	finally
      //   2966	2971	2669	finally
      //   3007	3012	2669	finally
      //   3029	3034	2669	finally
      //   3088	3093	2669	finally
      //   3110	3115	2669	finally
      //   3140	3145	2669	finally
      //   3153	3156	2669	finally
      //   3166	3171	2669	finally
      //   2942	2947	2956	java/io/IOException
      //   2536	2557	2974	java/lang/IllegalStateException
      //   3007	3012	3019	java/io/IOException
      //   2536	2557	3041	java/io/IOException
      //   3088	3093	3100	java/io/IOException
      //   2536	2557	3122	finally
      //   3140	3145	3156	java/io/IOException
      //   847	852	3174	java/io/IOException
      //   2676	2681	3216	java/io/IOException
      //   1084	1092	3569	finally
      //   1101	1139	3582	finally
      //   1139	1163	3582	finally
      //   1084	1092	3595	java/lang/InterruptedException
      //   1101	1139	3608	java/lang/InterruptedException
      //   1139	1163	3608	java/lang/InterruptedException
      //   2569	2578	3621	finally
      //   2590	2596	3621	finally
      //   2696	2704	3621	finally
      //   2716	2724	3621	finally
      //   2736	2748	3621	finally
      //   2770	2783	3621	finally
      //   2795	2804	3621	finally
      //   2816	2830	3621	finally
      //   2842	2853	3621	finally
      //   2873	2879	3621	finally
      //   2891	2929	3621	finally
      //   3050	3061	3621	finally
      //   3065	3069	3621	finally
      //   2979	2994	3630	finally
      //   2569	2578	3643	java/io/IOException
      //   2590	2596	3643	java/io/IOException
      //   2696	2704	3643	java/io/IOException
      //   2716	2724	3643	java/io/IOException
      //   2736	2748	3643	java/io/IOException
      //   2770	2783	3643	java/io/IOException
      //   2795	2804	3643	java/io/IOException
      //   2816	2830	3643	java/io/IOException
      //   2842	2853	3643	java/io/IOException
      //   2873	2879	3643	java/io/IOException
      //   2891	2929	3643	java/io/IOException
      //   2569	2578	3652	java/lang/IllegalStateException
      //   2590	2596	3652	java/lang/IllegalStateException
      //   2696	2704	3652	java/lang/IllegalStateException
      //   2716	2724	3652	java/lang/IllegalStateException
      //   2736	2748	3652	java/lang/IllegalStateException
      //   2770	2783	3652	java/lang/IllegalStateException
      //   2795	2804	3652	java/lang/IllegalStateException
      //   2816	2830	3652	java/lang/IllegalStateException
      //   2842	2853	3652	java/lang/IllegalStateException
      //   2873	2879	3652	java/lang/IllegalStateException
      //   2891	2929	3652	java/lang/IllegalStateException
      //   1790	1795	3661	java/lang/Exception
      //   1803	1808	3661	java/lang/Exception
      //   1711	1716	3666	java/lang/Exception
      //   1724	1729	3666	java/lang/Exception
      //   1453	1458	3671	java/lang/Exception
      //   1466	1471	3671	java/lang/Exception
      //   1084	1092	3676	java/io/IOException
    }
  }
  
  public class TaskScan
    extends TroopFileTransferManager.Task
  {
    public TaskScan(TroopFileTransferManager.Item paramItem)
    {
      super(paramItem, 0);
      TroopFileTransferManager.this.c(paramItem, 0);
      this.cSh = true;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   4: aload_0
      //   5: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   8: invokevirtual 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   11: ifeq +4 -> 15
      //   14: return
      //   15: invokestatic 48	apue:ebQ	()V
      //   18: aload_0
      //   19: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   22: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
      //   25: ifnonnull +35 -> 60
      //   28: aload_0
      //   29: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   32: lconst_0
      //   33: putfield 58	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
      //   36: aload_0
      //   37: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   40: ldc 60
      //   42: invokestatic 66	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
      //   45: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
      //   48: aload_0
      //   49: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   52: ldc 68
      //   54: invokestatic 66	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
      //   57: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
      //   60: new 73	java/io/File
      //   63: dup
      //   64: aload_0
      //   65: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   68: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   71: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   74: astore_3
      //   75: aload_3
      //   76: invokevirtual 84	java/io/File:exists	()Z
      //   79: ifeq +30 -> 109
      //   82: aload_3
      //   83: invokevirtual 87	java/io/File:isFile	()Z
      //   86: ifeq +23 -> 109
      //   89: aload_3
      //   90: invokevirtual 91	java/io/File:length	()J
      //   93: lconst_0
      //   94: lcmp
      //   95: ifle +14 -> 109
      //   98: aload_0
      //   99: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   102: aload_3
      //   103: invokevirtual 91	java/io/File:length	()J
      //   106: putfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   109: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   112: ifeq +58 -> 170
      //   115: ldc 101
      //   117: iconst_2
      //   118: new 103	java/lang/StringBuilder
      //   121: dup
      //   122: invokespecial 105	java/lang/StringBuilder:<init>	()V
      //   125: ldc 107
      //   127: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   130: aload_0
      //   131: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   134: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   137: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: ldc 113
      //   142: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: aload_3
      //   146: invokevirtual 84	java/io/File:exists	()Z
      //   149: invokevirtual 116	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   152: ldc 118
      //   154: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   157: aload_3
      //   158: invokevirtual 91	java/io/File:length	()J
      //   161: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   164: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   167: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   170: aload_0
      //   171: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   174: aload_0
      //   175: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   178: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   181: aload_0
      //   182: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   185: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
      //   188: ldc2_w 133
      //   191: lcmp
      //   192: ifle +62 -> 254
      //   195: aload_0
      //   196: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   199: aload_0
      //   200: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   203: iconst_3
      //   204: sipush 205
      //   207: invokevirtual 138	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   210: getstatic 144	apue$a:dVY	I
      //   213: getstatic 147	apue$a:dWb	I
      //   216: invokestatic 151	apue:jY	(II)V
      //   219: return
      //   220: astore_3
      //   221: ldc 101
      //   223: iconst_1
      //   224: ldc 153
      //   226: aload_3
      //   227: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   230: aload_0
      //   231: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   234: aload_0
      //   235: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   238: iconst_3
      //   239: bipush 102
      //   241: invokevirtual 138	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   244: getstatic 144	apue$a:dVY	I
      //   247: getstatic 159	apue$a:dWp	I
      //   250: invokestatic 151	apue:jY	(II)V
      //   253: return
      //   254: new 161	java/io/FileInputStream
      //   257: dup
      //   258: aload_3
      //   259: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   262: astore_3
      //   263: aload_3
      //   264: aload_0
      //   265: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   268: getfield 58	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
      //   271: invokevirtual 168	java/io/FileInputStream:skip	(J)J
      //   274: pop2
      //   275: ldc 169
      //   277: newarray byte
      //   279: astore 4
      //   281: aload_3
      //   282: aload 4
      //   284: invokevirtual 173	java/io/FileInputStream:read	([B)I
      //   287: istore_1
      //   288: iload_1
      //   289: ifge +342 -> 631
      //   292: aload_3
      //   293: invokevirtual 176	java/io/FileInputStream:close	()V
      //   296: aload_0
      //   297: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   300: aload_0
      //   301: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   304: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
      //   307: invokevirtual 180	java/security/MessageDigest:digest	()[B
      //   310: putfield 184	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
      //   313: aload_0
      //   314: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   317: aload_0
      //   318: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   321: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
      //   324: invokevirtual 180	java/security/MessageDigest:digest	()[B
      //   327: putfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   330: aload_0
      //   331: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   334: aload_0
      //   335: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   338: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   341: invokestatic 193	ahav:B	(Ljava/lang/String;)[B
      //   344: invokestatic 199	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   347: putfield 202	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
      //   350: aload_0
      //   351: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   354: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   357: invokestatic 205	ahav:A	(Ljava/lang/String;)[B
      //   360: invokestatic 199	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   363: pop
      //   364: aload_0
      //   365: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   368: aconst_null
      //   369: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
      //   372: aload_0
      //   373: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   376: aconst_null
      //   377: putfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
      //   380: aload_0
      //   381: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   384: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   387: invokestatic 209	ahav:getFileType	(Ljava/lang/String;)I
      //   390: ifne +382 -> 772
      //   393: new 211	android/graphics/BitmapFactory$Options
      //   396: dup
      //   397: invokespecial 212	android/graphics/BitmapFactory$Options:<init>	()V
      //   400: astore_3
      //   401: aload_3
      //   402: iconst_1
      //   403: putfield 215	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   406: aload_0
      //   407: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   410: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   413: aload_3
      //   414: invokestatic 220	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   417: pop
      //   418: aload_0
      //   419: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   422: aload_3
      //   423: getfield 223	android/graphics/BitmapFactory$Options:outWidth	I
      //   426: putfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
      //   429: aload_0
      //   430: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   433: aload_3
      //   434: getfield 229	android/graphics/BitmapFactory$Options:outHeight	I
      //   437: putfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
      //   440: aload_0
      //   441: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   444: aload_0
      //   445: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   448: invokevirtual 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   451: ifne -437 -> 14
      //   454: aload_0
      //   455: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   458: getfield 184	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
      //   461: invokestatic 199	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   464: astore_3
      //   465: aload_0
      //   466: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   469: getfield 187	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
      //   472: invokestatic 199	aqhs:bytes2HexStr	([B)Ljava/lang/String;
      //   475: astore 4
      //   477: ldc 101
      //   479: iconst_1
      //   480: new 103	java/lang/StringBuilder
      //   483: dup
      //   484: invokespecial 105	java/lang/StringBuilder:<init>	()V
      //   487: ldc 234
      //   489: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   492: aload_3
      //   493: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   496: ldc 236
      //   498: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   501: aload 4
      //   503: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   506: ldc 238
      //   508: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   511: aload_0
      //   512: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   515: getfield 202	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha3	Ljava/lang/String;
      //   518: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   521: ldc 240
      //   523: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   526: aload_0
      //   527: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   530: getfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
      //   533: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   536: ldc 245
      //   538: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   541: aload_0
      //   542: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   545: getfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
      //   548: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   551: ldc 247
      //   553: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   556: aload_0
      //   557: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   560: getfield 250	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
      //   563: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   566: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   569: invokestatic 253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   572: aload_0
      //   573: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   576: aload_0
      //   577: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   580: invokevirtual 132	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   583: aload_0
      //   584: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   587: aload_0
      //   588: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   591: invokevirtual 255	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
      //   594: return
      //   595: astore_3
      //   596: ldc 101
      //   598: iconst_1
      //   599: ldc_w 257
      //   602: aload_3
      //   603: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   606: aload_0
      //   607: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   610: aload_0
      //   611: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   614: iconst_3
      //   615: sipush 201
      //   618: invokevirtual 138	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   621: getstatic 144	apue$a:dVY	I
      //   624: getstatic 260	apue$a:dWd	I
      //   627: invokestatic 151	apue:jY	(II)V
      //   630: return
      //   631: aload_0
      //   632: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   635: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
      //   638: aload 4
      //   640: iconst_0
      //   641: iload_1
      //   642: invokevirtual 264	java/security/MessageDigest:update	([BII)V
      //   645: aload_0
      //   646: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   649: getfield 71	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
      //   652: aload 4
      //   654: iconst_0
      //   655: iload_1
      //   656: invokevirtual 264	java/security/MessageDigest:update	([BII)V
      //   659: aload_0
      //   660: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   663: astore 5
      //   665: aload 5
      //   667: aload 5
      //   669: getfield 58	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
      //   672: iload_1
      //   673: i2l
      //   674: ladd
      //   675: putfield 58	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
      //   678: aload_0
      //   679: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   682: aload_0
      //   683: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   686: invokevirtual 43	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
      //   689: istore_2
      //   690: iload_2
      //   691: ifeq -410 -> 281
      //   694: aload_3
      //   695: invokevirtual 176	java/io/FileInputStream:close	()V
      //   698: return
      //   699: astore_3
      //   700: aload_3
      //   701: invokevirtual 267	java/io/IOException:printStackTrace	()V
      //   704: return
      //   705: astore_3
      //   706: aload_3
      //   707: invokevirtual 267	java/io/IOException:printStackTrace	()V
      //   710: goto -414 -> 296
      //   713: astore 4
      //   715: aload 4
      //   717: invokevirtual 267	java/io/IOException:printStackTrace	()V
      //   720: aload_0
      //   721: getfield 13	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:this$0	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
      //   724: aload_0
      //   725: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   728: iconst_3
      //   729: sipush 203
      //   732: invokevirtual 138	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
      //   735: getstatic 144	apue$a:dVY	I
      //   738: getstatic 270	apue$a:dWg	I
      //   741: invokestatic 151	apue:jY	(II)V
      //   744: aload_3
      //   745: invokevirtual 176	java/io/FileInputStream:close	()V
      //   748: return
      //   749: astore_3
      //   750: aload_3
      //   751: invokevirtual 267	java/io/IOException:printStackTrace	()V
      //   754: return
      //   755: astore 4
      //   757: aload_3
      //   758: invokevirtual 176	java/io/FileInputStream:close	()V
      //   761: aload 4
      //   763: athrow
      //   764: astore_3
      //   765: aload_3
      //   766: invokevirtual 267	java/io/IOException:printStackTrace	()V
      //   769: goto -8 -> 761
      //   772: aload_0
      //   773: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   776: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   779: invokestatic 209	ahav:getFileType	(Ljava/lang/String;)I
      //   782: iconst_2
      //   783: if_icmpne -343 -> 440
      //   786: aload_0
      //   787: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   790: getfield 77	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
      //   793: invokestatic 276	com/tencent/mobileqq/shortvideo/ShortVideoUtils:n	(Ljava/lang/String;)[I
      //   796: astore_3
      //   797: aload_0
      //   798: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   801: aload_3
      //   802: iconst_0
      //   803: iaload
      //   804: putfield 226	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
      //   807: aload_0
      //   808: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   811: aload_3
      //   812: iconst_1
      //   813: iaload
      //   814: putfield 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
      //   817: aload_0
      //   818: getfield 39	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:e	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
      //   821: aload_3
      //   822: iconst_2
      //   823: iaload
      //   824: putfield 250	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:duration	I
      //   827: goto -387 -> 440
      //   830: astore_3
      //   831: goto -391 -> 440
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	834	0	this	TaskScan
      //   287	386	1	i	int
      //   689	2	2	bool	boolean
      //   74	84	3	localFile	File
      //   220	39	3	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
      //   262	231	3	localObject1	Object
      //   595	100	3	localFileNotFoundException	java.io.FileNotFoundException
      //   699	2	3	localIOException1	IOException
      //   705	40	3	localIOException2	IOException
      //   749	9	3	localIOException3	IOException
      //   764	2	3	localIOException4	IOException
      //   796	26	3	arrayOfInt	int[]
      //   830	1	3	localException	Exception
      //   279	374	4	localObject2	Object
      //   713	3	4	localIOException5	IOException
      //   755	7	4	localObject3	Object
      //   663	5	5	localItem	TroopFileTransferManager.Item
      // Exception table:
      //   from	to	target	type
      //   36	60	220	java/security/NoSuchAlgorithmException
      //   254	263	595	java/io/FileNotFoundException
      //   694	698	699	java/io/IOException
      //   292	296	705	java/io/IOException
      //   263	281	713	java/io/IOException
      //   281	288	713	java/io/IOException
      //   631	690	713	java/io/IOException
      //   744	748	749	java/io/IOException
      //   263	281	755	finally
      //   281	288	755	finally
      //   631	690	755	finally
      //   715	744	755	finally
      //   757	761	764	java/io/IOException
      //   393	440	830	java/lang/Exception
    }
  }
  
  class a
  {
    String crb;
    int dVI;
    
    a() {}
  }
  
  public static class b
  {
    public short ah;
    public String bGu;
    public String bGv;
    public boolean cew;
    public String downloadKey;
    public String httpsDomain;
    public int retCode;
    public String retMsg;
    public String strId;
  }
  
  public static class c
  {
    public LinkedList<TroopFileTransferManager.Task> al = new LinkedList();
    public AtomicInteger cf = new AtomicInteger();
    public int dVK;
    
    public c(int paramInt)
    {
      this.dVK = paramInt;
    }
    
    /* Error */
    public void a(TroopFileTransferManager.Task paramTask)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 29	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$c:al	Ljava/util/LinkedList;
      //   6: aload_1
      //   7: invokevirtual 38	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   10: pop
      //   11: aload_0
      //   12: getfield 24	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$c:cf	Ljava/util/concurrent/atomic/AtomicInteger;
      //   15: invokevirtual 42	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
      //   18: aload_0
      //   19: getfield 31	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$c:dVK	I
      //   22: if_icmple +14 -> 36
      //   25: aload_0
      //   26: getfield 24	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$c:cf	Ljava/util/concurrent/atomic/AtomicInteger;
      //   29: invokevirtual 45	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
      //   32: pop
      //   33: aload_0
      //   34: monitorexit
      //   35: return
      //   36: new 47	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool$1
      //   39: dup
      //   40: aload_0
      //   41: invokespecial 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool$1:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$c;)V
      //   44: iconst_5
      //   45: aconst_null
      //   46: iconst_1
      //   47: invokestatic 56	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
      //   50: goto -17 -> 33
      //   53: astore_1
      //   54: aload_0
      //   55: monitorexit
      //   56: aload_1
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	c
      //   0	58	1	paramTask	TroopFileTransferManager.Task
      // Exception table:
      //   from	to	target	type
      //   2	33	53	finally
      //   36	50	53	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager
 * JD-Core Version:    0.7.0.1
 */