package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gxw;
import gxy;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyToReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyDownloadReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyDownloadRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFeedMsgV2ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyResendReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyResendRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyUploadRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class TroopFileTransferManager
  implements INetInfoHandler
{
  public static final int a = 100;
  public static final String a = "TroopFileTransferManager";
  public static Map a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 32768;
  public static final int e = 8;
  public static final int f = 16;
  public static final long f = 4294967296L;
  public static final int g = 1007;
  public static final int h = 3;
  public static final int i = 1024;
  public static final int j = 16384;
  public static final int k = 4096;
  public static final int l = 3;
  public static final int m = 30000;
  public static final int n = 30000;
  public static final int o = 300000;
  public static final int p = 128;
  public static final int q = 640;
  public static final int r = 1000;
  public static final int s = 5000;
  public static final int t = 10000;
  private static final int u = 5000;
  public long a;
  public QQAppInterface a;
  private TroopFileManager a;
  public Timer a;
  public boolean a;
  public TroopFileTransferManager.TaskPool[] a;
  public long b;
  public Map b;
  public boolean b;
  public long c;
  public long d = 0L;
  public volatile long e;
  public long g;
  public long h;
  
  static
  {
    if (!TroopFileTransferManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  public TroopFileTransferManager(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool = new TroopFileTransferManager.TaskPool[] { new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2) };
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.g = paramLong;
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
  }
  
  public static TroopFileTransferManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilMap == null)
      {
        jdField_a_of_type_JavaUtilMap = new HashMap();
        new Thread(new gxw()).start();
      }
      TroopFileUploadingManager.a(paramQQAppInterface);
      TroopFileTransferManager localTroopFileTransferManager2 = (TroopFileTransferManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      TroopFileTransferManager localTroopFileTransferManager1;
      if (localTroopFileTransferManager2 != null)
      {
        localTroopFileTransferManager1 = localTroopFileTransferManager2;
        if (localTroopFileTransferManager2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localTroopFileTransferManager1 = new TroopFileTransferManager(paramQQAppInterface, paramLong);
        localTroopFileTransferManager1.c();
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopFileTransferManager1);
      }
      return localTroopFileTransferManager1;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).k();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        if (localTroopFileTransferManager.g == paramLong) {
          localTroopFileTransferManager.j();
        } else {
          localTroopFileTransferManager.i();
        }
      }
      finally {}
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l1);
        }
        return;
      }
      String str = paramToServiceMsg.extraData.getString("itemKey");
      if (str == null) {
        return;
      }
      localObject = UUID.fromString(str);
      try
      {
        localObject = (TroopFileTransferManager.Item)localTroopFileTransferManager.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          return;
        }
      }
      finally {}
      if (localTroopFileTransferManager.a((TroopFileTransferManager.Item)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject)) {
        break label281;
      }
    }
    finally {}
    if ((!localTroopFileTransferManager.b((TroopFileTransferManager.Item)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!localTroopFileTransferManager.d((TroopFileTransferManager.Item)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!localTroopFileTransferManager.c((TroopFileTransferManager.Item)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!localTroopFileTransferManager.e((TroopFileTransferManager.Item)localObject, paramToServiceMsg, paramFromServiceMsg, paramObject))) {}
    label281:
    for (int i1 = 0;; i1 = 1)
    {
      if ((i1 == 0) && (QLog.isDevelopLevel())) {
        QLog.i("TroopFileTransferManager", 4, "bad subcmd" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
  }
  
  public static void g()
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).i();
      }
    }
    finally {}
  }
  
  public static void h()
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).j();
      }
    }
    finally {}
  }
  
  private final void i(TroopFileTransferManager.Item paramItem)
  {
    paramItem.ErrorCode = 0;
    a(paramItem, 12);
  }
  
  private void k()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        if (localIterator.hasNext())
        {
          TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
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
      finally {}
      return;
    }
  }
  
  public final int a()
  {
    try
    {
      c();
      int i1 = 0;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      if (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem != null)
        {
          int i2 = localItem.Status;
          switch (i2)
          {
          }
        }
        for (;;)
        {
          break;
          i1 += 1;
        }
      }
      return i1;
    }
    finally {}
  }
  
  public final TroopFileStatusInfo a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        c();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
            if (paramString.equals(localItem.FilePath))
            {
              paramString = localItem.getInfo(this.g);
              break;
            }
          }
        }
        paramString = null;
      }
      finally {}
    }
  }
  
  public final TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
  }
  
  public final TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    for (;;)
    {
      synchronized (a())
      {
        try
        {
          TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, paramLong, paramInt);
          if (localTroopFileInfo == null) {
            return null;
          }
          c();
          paramString1 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.a);
          if (paramString1 == null)
          {
            paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
            this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
            paramString1.FileName = paramString2;
            paramString1.ProgressTotal = paramLong;
            paramString1.ProgressValue = 0L;
            a(paramString1, 0, false);
            paramString2 = FileUtil.a(paramString2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", this.g + "", paramString2, "");
            paramString1 = paramString1.getInfo(this.g);
            return paramString1;
          }
          if (paramString1.Status != 7) {
            return null;
          }
        }
        finally {}
      }
    }
  }
  
  /* Error */
  public final TroopFileStatusInfo a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 284	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   6: aload_2
    //   7: lload 4
    //   9: bipush 102
    //   11: invokevirtual 289	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +9 -> 25
    //   19: aconst_null
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 144	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   29: new 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 292	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   42: aload_1
    //   43: getfield 296	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   46: aload_1
    //   47: invokeinterface 148 3 0
    //   52: pop
    //   53: aload_1
    //   54: iload 7
    //   56: putfield 299	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   59: aload_1
    //   60: ldc2_w 355
    //   63: putfield 305	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   66: aload_1
    //   67: iload 6
    //   69: putfield 308	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   72: aload_1
    //   73: iconst_4
    //   74: putfield 262	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   77: aload_1
    //   78: aload_3
    //   79: putfield 311	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   82: aload_0
    //   83: aload_1
    //   84: iconst_4
    //   85: iconst_0
    //   86: invokevirtual 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   94: invokevirtual 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   97: astore_1
    //   98: goto -77 -> 21
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	TroopFileTransferManager
    //   0	106	1	paramString1	String
    //   0	106	2	paramString2	String
    //   0	106	3	paramString3	String
    //   0	106	4	paramLong	long
    //   0	106	6	paramInt1	int
    //   0	106	7	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	15	101	finally
    //   25	98	101	finally
  }
  
  public final TroopFileStatusInfo a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, Math.abs(new Random().nextInt()));
  }
  
  public final TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      paramString = ???.b(paramString);
      if (paramString == null) {
        return null;
      }
      c();
      paramString = new TroopFileTransferManager.Item(paramString);
      this.jdField_b_of_type_JavaUtilMap.put(paramString.Id, paramString);
      paramString.BusId = 102;
      paramString.isFromAIO = paramBoolean;
      paramString.RandomNum = paramInt;
      if (NetworkUtil.a(BaseApplication.getContext()) == 0)
      {
        a(paramString, 3, 106);
        paramString = paramString.getInfo(this.g);
        return paramString;
        paramString = finally;
        throw paramString;
      }
      new TroopFileTransferManager.TaskScan(this, paramString);
      paramString = paramString.getInfo(this.g);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final TroopFileStatusInfo a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 144	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   6: aload_0
    //   7: getfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 140 2 0
    //   16: checkcast 232	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
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
    //   32: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   35: invokevirtual 280	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
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
  
  public TroopFileManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  }
  
  public final Collection a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TroopFileTransferManager.Item)localIterator.next()).getInfo(this.g));
      }
    }
    finally {}
    return localCollection;
  }
  
  public final List a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem != null) && (localItem.FilePath == null)) {
          localArrayList.add(localItem.getInfo(this.g));
        }
      }
    }
    finally {}
    return localList;
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      if (NetworkUtil.b(BaseApplication.getContext()) == 1)
      {
        if (paramInt == 0) {
          this.jdField_b_of_type_Long += paramLong;
        }
        for (;;)
        {
          return;
          if (paramInt == 1) {
            this.jdField_a_of_type_Long += paramLong;
          }
        }
      }
      if (paramInt != 0) {
        break label75;
      }
    }
    finally {}
    this.d += paramLong;
    for (;;)
    {
      b();
      break;
      label75:
      if (paramInt == 1) {
        this.jdField_c_of_type_Long += paramLong;
      }
    }
  }
  
  public final void a(TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_a_of_type_Long);
      localFileManagerEntity.peerNick = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.peerUin);
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.cloudType = 3;
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.TroopUin = this.g;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    finally
    {
      paramTroopFileStatusInfo = finally;
      throw paramTroopFileStatusInfo;
    }
  }
  
  public final void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis() - this.h;
      long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
      if ((this.h == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
      {
        this.h = (l1 + this.h);
        paramItem.StatusUpdateTimeMs += l2;
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a(paramItem.getInfo(this.g));
      }
      return;
    }
    finally {}
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramItem, paramInt, 0);
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt1) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      paramItem.Status = paramInt1;
      paramItem.ErrorCode = paramInt2;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME) {
        paramItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
      }
      f();
      paramItem.StatusUpdateTimeMs = 0L;
      a(paramItem);
      paramItem.IsNewStatus = false;
      b(paramItem, paramInt2);
      return;
    }
    finally {}
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
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
        if ((1 == NetworkUtil.a(BaseApplication.getContext())) || (paramInt != 128)) {
          break label62;
        }
        paramItem.ThumbnailDownloading_Small = false;
        paramItem.ThumbnailFileTimeMS_Small = 0L;
      }
      if (!paramBoolean) {
        break label255;
      }
    }
    finally {}
    label62:
    Object localObject = new cmd0x383.ReqBody();
    ((cmd0x383.ReqBody)localObject).uint64_groupcode.set(this.g);
    ((cmd0x383.ReqBody)localObject).uint32_app_id.set(3);
    cmd0x383.ApplyDownloadReqBody localApplyDownloadReqBody = new cmd0x383.ApplyDownloadReqBody();
    localApplyDownloadReqBody.uint32_bus_id.set(paramItem.BusId);
    localApplyDownloadReqBody.str_file_path.set(paramItem.FilePath);
    PBBoolField localPBBoolField = localApplyDownloadReqBody.bool_thumbnail_req;
    if (paramInt != 0) {}
    for (;;)
    {
      localPBBoolField.set(bool);
      localApplyDownloadReqBody.bool_preview_req.set(paramBoolean);
      ((cmd0x383.ReqBody)localObject).msg_download_req_body.set(localApplyDownloadReqBody);
      ((cmd0x383.ReqBody)localObject).setHasFlag(true);
      paramItem = paramItem.createExtraData(this.g);
      paramItem.putInt("Thumbnail", paramInt);
      paramItem.putBoolean("bPreview", paramBoolean);
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("GroupFileAppSvr.Download", ((cmd0x383.ReqBody)localObject).toByteArray(), paramItem);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.e("TroopFileTransferManager", 4, "send download req with troopUin:" + this.g);
      break;
      label255:
      a(paramItem, 8);
      break label62;
      bool = false;
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, int paramInt)
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
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      this.jdField_b_of_type_JavaUtilMap.put(paramString2.Id, paramString2);
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      paramString2.ForwardBusId = paramInt;
      paramString2.Status = 4;
      f(paramString2);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    TroopFileInfo localTroopFileInfo;
    synchronized (a()) {}
  }
  
  public final void a(Collection paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      synchronized (a())
      {
        try
        {
          if (NetworkUtil.a(BaseApplication.getContext()) == 0)
          {
            i1 = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            localObject = ???.b((String)paramCollection.next());
            if (localObject == null) {
              continue;
            }
            c();
            localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
            this.jdField_b_of_type_JavaUtilMap.put(((TroopFileTransferManager.Item)localObject).Id, localObject);
            ((TroopFileTransferManager.Item)localObject).BusId = 102;
            ((TroopFileTransferManager.Item)localObject).isFromAIO = paramBoolean;
            if (i1 == 0) {
              break label136;
            }
            a((TroopFileTransferManager.Item)localObject, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i1 = 0;
      continue;
      label136:
      new TroopFileTransferManager.TaskScan(this, (TroopFileTransferManager.Item)localObject);
    }
  }
  
  public final void a(UUID paramUUID, String paramString)
  {
    try
    {
      paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      if (paramUUID != null)
      {
        paramUUID.FilePath = paramString;
        paramUUID.BusId = 102;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 638	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_Boolean	Z
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
    //   18: getfield 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: aload_0
    //   22: getfield 230	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   25: aload_0
    //   26: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   29: invokestatic 643	com/tencent/mobileqq/troop/utils/SerializableManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Map;J)Z
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
  public final boolean a(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +28 -> 36
    //   11: aload_1
    //   12: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +15 -> 31
    //   19: iconst_2
    //   20: istore_2
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
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
    //   0	46	1	paramItem	TroopFileTransferManager.Item
    //   20	13	2	i1	int
    //   1	37	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	41	finally
    //   21	27	41	finally
  }
  
  public final boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramInt == 128) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramItem.HasThumbnailFile_Small = new File(paramItem.getThumbnailFile(this.g, paramInt)).exists();
        if (paramItem.HasThumbnailFile_Small) {
          paramItem.ThumbnailFileTimeMS_Small = 0L;
        }
        bool = paramItem.HasThumbnailFile_Small;
        return bool;
      }
      finally {}
      if (paramInt == 640)
      {
        paramItem.HasThumbnailFile_Large = new File(paramItem.getThumbnailFile(this.g, paramInt)).exists();
        if (paramItem.HasThumbnailFile_Large) {
          paramItem.ThumbnailFileTimeMS_Large = 0L;
        }
        bool = paramItem.HasThumbnailFile_Large;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean a(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    for (;;)
    {
      int i2;
      try
      {
        boolean bool2 = "GroupFileAppSvr.Upload".equals(paramFromServiceMsg.getServiceCmd());
        if (!bool2) {
          return bool1;
        }
        if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
        {
          a(paramItem, 3, 103);
          bool1 = true;
          continue;
        }
        paramToServiceMsg = (byte[])paramObject;
        paramFromServiceMsg = new cmd0x383.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          i2 = paramFromServiceMsg.int32_ret_code.get();
          if (!QLog.isDevelopLevel()) {
            break label288;
          }
          QLog.e("TroopFileTransferManager", 4, String.format("onRspUpload - retCode: %d", new Object[] { Integer.valueOf(i2) }));
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
          a(paramItem, 3, 103);
          bool1 = true;
        }
        TroopFileError.a(new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.g, 3, i1), this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        a(paramItem, 3, 0);
        bool1 = true;
        continue;
        continue;
        if (paramItem.BusId == 104) {
          break label371;
        }
        paramItem.BusId = 104;
        b(paramItem);
        bool1 = true;
        continue;
        paramToServiceMsg = (cmd0x383.ApplyUploadRspBody)paramFromServiceMsg.msg_upload_rsp_body.get();
        paramItem.FilePath = paramToServiceMsg.str_file_path.get();
        paramItem.UploadIp = paramToServiceMsg.str_upload_ip.get();
        paramItem.CheckKey = paramToServiceMsg.bytes_check_key.get().toByteArray();
        if (!a(paramItem)) {
          new TroopFileTransferManager.TaskHttpUpload(this, paramItem);
        }
        bool1 = true;
        continue;
        if (i2 >= 0) {
          continue;
        }
      }
      finally {}
      label288:
      int i1 = 207;
      switch (i2)
      {
      case -20001: 
      case -20000: 
      default: 
        break;
      case -1: 
        i1 = 202;
        break;
      case -2: 
        i1 = 208;
        continue;
        i1 = 204;
        break;
      case -25126: 
        label371:
        i1 = 209;
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2)
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
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        paramString1.NameForSave = paramString2;
        paramString1.LocalFile = (AppConstants.as + paramString2);
        a();
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a(paramString1.getInfo(this.g));
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt)
  {
    synchronized (a())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.a);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
        }
        e(paramString1);
        return true;
      }
      finally {}
    }
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a())
    {
      try
      {
        if (FileManagerUtil.a(FileUtil.a(paramString2)) != 0) {
          return false;
        }
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt1);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.a);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
        }
        c(paramString1, paramInt2);
        return true;
      }
      finally {}
    }
  }
  
  public final boolean a(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        boolean bool;
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 9: 
        case 10: 
          if (paramUUID.TmpFile != null) {
            new File(paramUUID.TmpFile).delete();
          }
          this.jdField_b_of_type_JavaUtilMap.remove(paramUUID.Id);
          paramUUID.ErrorCode = 0;
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileTransferManager", 4, "cancel download " + paramUUID.Id + "[" + paramUUID.FilePath + "]" + paramUUID.Status);
          }
          a(paramUUID, 7);
          bool = true;
          break;
        case 11: 
          if (paramUUID.LocalFile != null) {
            new File(paramUUID.LocalFile).delete();
          }
          break;
        default: 
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
      if (localTroopFileInfo == null) {
        return false;
      }
      if (FileManagerUtil.a(FileUtil.a(localTroopFileInfo.c)) != 0)
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      c();
      TroopFileTransferManager.Item localItem2 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      TroopFileTransferManager.Item localItem1 = localItem2;
      if (localItem2 == null)
      {
        localItem1 = new TroopFileTransferManager.Item(localTroopFileInfo);
        this.jdField_b_of_type_JavaUtilMap.put(paramUUID, localItem1);
      }
      c(localItem1, paramInt);
      return true;
    }
    finally {}
  }
  
  public final boolean a(UUID paramUUID, int paramInt, String paramString1, String paramString2)
  {
    TroopFileTransferManager.Item localItem;
    synchronized (a())
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopFileTransferManager", 4, String.format("finishCopyFrom - retCode: %d strNewPath:%s strErrorMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }));
        }
        paramUUID = ???.a(paramUUID);
        if (paramUUID == null) {
          return false;
        }
        c();
        localItem = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID.a);
        if (localItem == null) {
          return false;
        }
        if (localItem.Status != 4) {
          return false;
        }
        if (paramInt < 0)
        {
          if (TextUtils.isEmpty(paramString2)) {}
          for (paramUUID = new TroopFileError.SimpleErrorInfo(localItem.FileName, this.g, 5, 207);; paramUUID = new TroopFileError.SimpleErrorInfo(localItem.FileName, this.g, 5, 704, paramString2))
          {
            TroopFileError.a(paramUUID, this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
            a(localItem, 5, 0);
            return true;
          }
          paramUUID = finally;
        }
      }
      finally {}
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramUUID = new TroopFileError.SimpleErrorInfo(localItem.FileName, this.g, 5, 207);; paramUUID = new TroopFileError.SimpleErrorInfo(localItem.FileName, this.g, 5, 704, paramString2))
      {
        TroopFileError.a(paramUUID, this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        a(localItem, 5, 0);
        return true;
      }
    }
    localItem.FilePath = paramString1;
    a(localItem, 7, 0);
    d(localItem);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_a_of_type_Long;
        localQQAppInterface.a(str, new String[] { "param_WIFIGroupFileDownloadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_WIFIGroupFileDownloadFlow", 4, this.jdField_a_of_type_Long + "");
        }
        this.jdField_a_of_type_Long = 0L;
      }
      if (this.jdField_b_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_b_of_type_Long;
        localQQAppInterface.a(str, new String[] { "param_WIFIGroupFileUploadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_WIFIGroupFileUploadFlow", 4, this.jdField_b_of_type_Long + "");
        }
        this.jdField_b_of_type_Long = 0L;
      }
      if ((this.d != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_c_of_type_Long;
        long l2 = this.d;
        localQQAppInterface.a(str, new String[] { "param_XGFileFlow", "param_XGFlow", "param_Flow" }, l1 + l2);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_XGFileFlow", 4, this.jdField_c_of_type_Long + this.d + "");
        }
      }
      if (this.jdField_c_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_c_of_type_Long;
        localQQAppInterface.a(str, new String[] { "param_XGGroupFileDownloadFlow", "param_XGFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_XGGroupFileDownloadFlow", 4, this.jdField_c_of_type_Long + "");
        }
        this.jdField_c_of_type_Long = 0L;
      }
    } while (this.d == 0L);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = this.d;
    localQQAppInterface.a(str, new String[] { "param_XGGroupFileUploadFlow", "param_XGFlow", "param_Flow" }, l1);
    if (QLog.isDevelopLevel()) {
      QLog.d("param_XGGroupFileUploadFlow", 4, this.d + "");
    }
    this.d = 0L;
  }
  
  /* Error */
  public final void b(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iconst_1
    //   5: invokevirtual 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   8: new 530	tencent/im/cs/cmd0x383/cmd0x383$ReqBody
    //   11: dup
    //   12: invokespecial 531	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: getfield 535	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:uint64_groupcode	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   24: invokevirtual 540	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   27: aload_3
    //   28: getfield 544	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   31: iconst_3
    //   32: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   35: new 830	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody
    //   38: dup
    //   39: invokespecial 831	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:<init>	()V
    //   42: astore 4
    //   44: aload 4
    //   46: getfield 834	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:bytes_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   49: aload_1
    //   50: getfield 837	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   53: invokestatic 841	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   56: invokevirtual 844	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   59: aload 4
    //   61: getfield 847	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:bytes_sha	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   64: aload_1
    //   65: getfield 850	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   68: invokestatic 841	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 844	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload 4
    //   76: getfield 851	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   79: ldc_w 853
    //   82: invokevirtual 563	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   85: aload 4
    //   87: getfield 856	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: aload_1
    //   91: getfield 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   94: invokevirtual 563	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   97: aload 4
    //   99: getfield 859	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:str_local_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   102: aload_1
    //   103: getfield 311	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   106: invokevirtual 563	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   109: aload 4
    //   111: getfield 860	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:uint32_bus_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: aload_1
    //   115: getfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   118: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   121: aload 4
    //   123: getfield 863	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:uint32_oper_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: astore 5
    //   128: aload_1
    //   129: getfield 381	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isFromAIO	Z
    //   132: ifeq +71 -> 203
    //   135: bipush 16
    //   137: istore_2
    //   138: aload 5
    //   140: iload_2
    //   141: invokevirtual 548	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   144: aload 4
    //   146: getfield 866	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   149: aload_1
    //   150: getfield 330	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   153: invokevirtual 540	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   156: aload_3
    //   157: getfield 870	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:msg_upload_req_body	Ltencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody;
    //   160: aload 4
    //   162: invokevirtual 871	tencent/im/cs/cmd0x383/cmd0x383$ApplyUploadReqBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   165: aload_3
    //   166: iconst_1
    //   167: invokevirtual 585	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:setHasFlag	(Z)V
    //   170: aload_0
    //   171: getfield 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   174: bipush 21
    //   176: invokevirtual 496	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   179: checkcast 498	com/tencent/mobileqq/app/BizTroopHandler
    //   182: ldc_w 669
    //   185: aload_3
    //   186: invokevirtual 607	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:toByteArray	()[B
    //   189: aload_1
    //   190: aload_0
    //   191: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   194: invokevirtual 589	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:createExtraData	(J)Landroid/os/Bundle;
    //   197: invokevirtual 610	com/tencent/mobileqq/app/BizTroopHandler:a	(Ljava/lang/String;[BLandroid/os/Bundle;)V
    //   200: aload_0
    //   201: monitorexit
    //   202: return
    //   203: bipush 8
    //   205: istore_2
    //   206: goto -68 -> 138
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	TroopFileTransferManager
    //   0	214	1	paramItem	TroopFileTransferManager.Item
    //   137	69	2	i1	int
    //   15	171	3	localReqBody	cmd0x383.ReqBody
    //   42	119	4	localApplyUploadReqBody	tencent.im.cs.cmd0x383.cmd0x383.ApplyUploadReqBody
    //   126	13	5	localPBUInt32Field	PBUInt32Field
    // Exception table:
    //   from	to	target	type
    //   2	135	209	finally
    //   138	200	209	finally
  }
  
  public final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 638	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_Boolean	Z
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
    //   18: invokevirtual 876	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()Z
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
  
  /* Error */
  public final boolean b(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +30 -> 38
    //   11: aload_1
    //   12: getfield 265	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +16 -> 32
    //   19: bipush 9
    //   21: istore_2
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
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
    //   0	48	1	paramItem	TroopFileTransferManager.Item
    //   21	14	2	i1	int
    //   1	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	43	finally
    //   22	28	43	finally
  }
  
  public final boolean b(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        bool = "GroupFileAppSvr.Resend".equals(paramFromServiceMsg.getServiceCmd());
        if (!bool)
        {
          bool = false;
          return bool;
        }
        if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
        {
          a(paramItem, 3, 103);
          bool = true;
          continue;
        }
        paramToServiceMsg = (byte[])paramObject;
        paramFromServiceMsg = new cmd0x383.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          if (paramFromServiceMsg.int32_ret_code.get() >= 0) {
            continue;
          }
          switch (paramFromServiceMsg.int32_ret_code.get())
          {
          case -6101: 
            a(paramItem, 3, i1);
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramItem)
        {
          paramItem.printStackTrace();
          if (!QLog.isDevelopLevel()) {
            break label255;
          }
        }
        QLog.i("TroopFileTransferManager", 4, "onRspResend parsing error");
      }
      finally {}
      b(paramItem, 206);
      i(paramItem);
      boolean bool = true;
      continue;
      paramToServiceMsg = (cmd0x383.ApplyResendRspBody)paramFromServiceMsg.msg_resend_rsp_body.get();
      paramItem.UploadIp = paramToServiceMsg.str_upload_ip.get();
      paramItem.CheckKey = paramToServiceMsg.bytes_check_key.get().toByteArray();
      if (!a(paramItem)) {
        new TroopFileTransferManager.TaskHttpUpload(this, paramItem);
      }
      bool = true;
      continue;
      int i1 = 1;
      continue;
      label255:
      bool = true;
      continue;
      i1 = 101;
      continue;
      i1 = 102;
    }
  }
  
  public final boolean b(UUID paramUUID)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 4: 
        case 5: 
        case 7: 
        case 8: 
          if (!QLog.isDevelopLevel()) {
            break label288;
          }
          QLog.e("TroopFileTransferManager", 4, "deleteItem error, status:" + paramUUID.Status);
        }
      }
      finally {}
      if (paramUUID.TmpFile != null) {
        new File(paramUUID.TmpFile).delete();
      }
      if (paramUUID.HasThumbnailFile_Small)
      {
        new File(paramUUID.getThumbnailFile(this.g, 128)).delete();
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopFileTransferManager", 4, "delete " + paramUUID.Id + "[" + paramUUID.FilePath + "]" + paramUUID.Status);
        }
        i(paramUUID);
        bool = true;
      }
      else if (paramUUID.HasThumbnailFile_Large)
      {
        new File(paramUUID.getThumbnailFile(this.g, 640)).delete();
        continue;
        continue;
        label288:
        bool = false;
      }
    }
  }
  
  public final void c()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        label11:
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      List localList = SerializableManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
      if ((!jdField_c_of_type_Boolean) && (localList == null)) {
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
        if (((TroopFileTansferItemEntity)localObject2).Id != null) {
          this.jdField_b_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        }
      }
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (!c()) {
          break label11;
        }
        f();
        break label11;
      }
    }
  }
  
  public final void c(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      a(paramItem, 1);
      cmd0x383.ReqBody localReqBody = new cmd0x383.ReqBody();
      localReqBody.uint64_groupcode.set(this.g);
      localReqBody.uint32_app_id.set(3);
      cmd0x383.ApplyResendReqBody localApplyResendReqBody = new cmd0x383.ApplyResendReqBody();
      localApplyResendReqBody.uint32_bus_id.set(paramItem.BusId);
      localApplyResendReqBody.str_file_path.set(paramItem.FilePath);
      localApplyResendReqBody.bytes_sha.set(ByteStringMicro.copyFrom(paramItem.Sha));
      localReqBody.msg_resend_req_body.set(localApplyResendReqBody);
      localReqBody.setHasFlag(true);
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("GroupFileAppSvr.Resend", localReqBody.toByteArray(), paramItem.createExtraData(this.g));
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final void c(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (!paramItem.canFetchThumbnailFile(paramInt)) {
      return;
    }
    if (a(paramItem, paramInt))
    {
      paramItem.StatusUpdateTimeMs = 0L;
      a(paramItem);
      return;
    }
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
    }
    while ((paramItem.LocalFile != null) && (new File(paramItem.LocalFile).exists()))
    {
      new TroopFileTransferManager.TaskGenThumbnail(this, paramItem, paramInt);
      return;
      if (paramInt == 640)
      {
        paramItem.ThumbnailDownloading_Large = true;
        paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
      }
    }
    a(paramItem, paramInt, false);
  }
  
  public final boolean c()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    boolean bool = false;
    TroopFileTransferManager.Item localItem;
    while (localIterator.hasNext())
    {
      localItem = (TroopFileTransferManager.Item)localIterator.next();
      if ((!localItem.ThumbnailDownloading_Small) && (!localItem.ThumbnailDownloading_Large)) {
        switch (localItem.Status)
        {
        }
      }
    }
    label158:
    for (;;)
    {
      label80:
      if ((localItem.HasThumbnailFile_Small) && (!a(localItem, 128))) {
        bool = true;
      }
      for (;;)
      {
        break;
        if (new File(localItem.LocalFile).exists()) {
          break label158;
        }
        a(localItem, 7);
        bool = true;
        break label80;
        if ((localItem.HasThumbnailFile_Large) && (!a(localItem, 640)))
        {
          bool = true;
          continue;
          return bool;
        }
      }
    }
  }
  
  /* Error */
  public final boolean c(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 935
    //   5: aload_3
    //   6: invokevirtual 252	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   9: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: istore 5
    //   14: iload 5
    //   16: ifne +11 -> 27
    //   19: iconst_0
    //   20: istore 5
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 5
    //   26: ireturn
    //   27: iconst_1
    //   28: istore 5
    //   30: goto -8 -> 22
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	TroopFileTransferManager
    //   0	38	1	paramItem	TroopFileTransferManager.Item
    //   0	38	2	paramToServiceMsg	ToServiceMsg
    //   0	38	3	paramFromServiceMsg	FromServiceMsg
    //   0	38	4	paramObject	Object
    //   12	17	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
  }
  
  public final boolean c(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 2: 
          if (!QLog.isDevelopLevel()) {
            break label125;
          }
          QLog.d("TroopFileTransferManager", 4, "error status ResumeUpload");
        }
      }
      finally {}
      if (paramUUID.Md5 == null)
      {
        new TroopFileTransferManager.TaskScan(this, paramUUID);
      }
      else if (paramUUID.FilePath == null)
      {
        b(paramUUID);
      }
      else
      {
        c(paramUUID);
        break label130;
        continue;
        label125:
        bool = false;
        continue;
      }
      label130:
      boolean bool = true;
    }
  }
  
  public final void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null)
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new gxy(this), 10000L, 10000L);
    }
  }
  
  public final void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      cmd0x383.ReqBody localReqBody = new cmd0x383.ReqBody();
      localReqBody.uint64_groupcode.set(this.g);
      localReqBody.uint32_app_id.set(3);
      cmd0x383.ApplyFeedMsgV2ReqBody localApplyFeedMsgV2ReqBody = new cmd0x383.ApplyFeedMsgV2ReqBody();
      localApplyFeedMsgV2ReqBody.bool_first_pkg_flag.set(true);
      localApplyFeedMsgV2ReqBody.uint32_total_file_num.set(1);
      localApplyFeedMsgV2ReqBody.uint32_file_num.set(1);
      localApplyFeedMsgV2ReqBody.uint32_bus_id.set(paramItem.BusId);
      localApplyFeedMsgV2ReqBody.str_file_path1.set(paramItem.FilePath);
      localApplyFeedMsgV2ReqBody.uint32_msg_random1.set(paramItem.RandomNum);
      localReqBody.msg_feed_msg_v2_req_body.set(localApplyFeedMsgV2ReqBody);
      localReqBody.setHasFlag(true);
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("GroupFileAppSvr.FeedMsgV2", localReqBody.toByteArray(), paramItem.createExtraData(this.g));
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final boolean d(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    label926:
    for (;;)
    {
      boolean bool;
      int i1;
      try
      {
        bool = "GroupFileAppSvr.Download".equals(paramFromServiceMsg.getServiceCmd());
        if (!bool)
        {
          bool = false;
          return bool;
        }
        i1 = paramToServiceMsg.extraData.getInt("Thumbnail", 0);
        bool = paramToServiceMsg.extraData.getBoolean("bPreview", false);
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopFileTransferManager", 4, paramFromServiceMsg.getServiceCmd() + "issuccess:" + paramFromServiceMsg.isSuccess());
        }
        paramToServiceMsg = new TroopFileTransferManager.PreviewInfo();
        paramToServiceMsg.jdField_a_of_type_Int = -1;
        if (paramItem.Id != null)
        {
          paramToServiceMsg.e = paramItem.Id.toString();
          if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
            break label241;
          }
          if (i1 == 128)
          {
            paramItem.ThumbnailDownloading_Small = false;
            break label977;
          }
        }
        else
        {
          paramToServiceMsg.e = null;
          continue;
        }
        if (i1 != 640) {
          break label183;
        }
      }
      finally {}
      paramItem.ThumbnailDownloading_Large = false;
      label183:
      if (bool)
      {
        TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, 700);
        paramToServiceMsg.jdField_a_of_type_Boolean = false;
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).c(paramToServiceMsg);
        bool = true;
      }
      else
      {
        a(paramItem, 10, 103);
        break label977;
        label241:
        paramFromServiceMsg = (byte[])paramObject;
        paramObject = new cmd0x383.RspBody();
        int i2;
        try
        {
          paramObject.mergeFrom(paramFromServiceMsg);
          i2 = paramObject.int32_ret_code.get();
          paramToServiceMsg.jdField_a_of_type_Int = i2;
          paramFromServiceMsg = (cmd0x383.ApplyDownloadRspBody)paramObject.msg_download_rsp_body.get();
          if (bool)
          {
            paramToServiceMsg.jdField_a_of_type_Boolean = false;
            paramToServiceMsg.jdField_a_of_type_JavaLangString = paramFromServiceMsg.str_download_ip.get();
            if ((TextUtils.isEmpty(paramToServiceMsg.jdField_a_of_type_JavaLangString)) || (paramToServiceMsg.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
              paramToServiceMsg.jdField_a_of_type_JavaLangString = paramFromServiceMsg.str_download_dns.get();
            }
            paramToServiceMsg.b = String.valueOf(paramFromServiceMsg.uint32_preview_port.get());
            paramToServiceMsg.c = paramFromServiceMsg.str_msg.get();
            paramToServiceMsg.d = HexUtil.a(paramFromServiceMsg.bytes_download_url.get().toByteArray());
          }
          if (QLog.isDevelopLevel()) {
            QLog.e("TroopFileTransferManager", 4, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(i2) }));
          }
          if (i2 >= 0) {
            break label621;
          }
          if (i1 == 128)
          {
            paramItem.ThumbnailDownloading_Small = false;
            bool = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          if (i1 == 128)
          {
            paramItem.ThumbnailDownloading_Small = false;
            break label983;
          }
          if (i1 == 640)
          {
            paramItem.ThumbnailDownloading_Large = false;
            break label983;
          }
          if (bool)
          {
            TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, 700);
            paramToServiceMsg.jdField_a_of_type_Boolean = false;
            ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).c(paramToServiceMsg);
            break label983;
          }
          a(paramItem, 10, 103);
          break label983;
        }
        if (i1 == 640)
        {
          paramItem.ThumbnailDownloading_Large = false;
          bool = true;
        }
        else if (bool)
        {
          TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, 700);
          if (TextUtils.isEmpty(paramToServiceMsg.c)) {
            paramToServiceMsg.c = BaseApplicationImpl.getContext().getString(2131559312);
          }
          paramToServiceMsg.jdField_a_of_type_Boolean = false;
          ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).c(paramToServiceMsg);
          bool = true;
        }
        else
        {
          for (;;)
          {
            label621:
            if (bool)
            {
              paramToServiceMsg.jdField_a_of_type_Boolean = true;
              ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).c(paramToServiceMsg);
              bool = true;
              break;
              a(paramItem, 10, 101);
              bool = true;
              break;
              b(paramItem, 301);
              if (paramItem.TmpFile != null) {
                new File(paramItem.TmpFile).delete();
              }
              if (paramItem.HasThumbnailFile_Small) {
                new File(paramItem.getThumbnailFile(this.g, 128)).delete();
              }
              for (;;)
              {
                i(paramItem);
                bool = true;
                break;
                if (paramItem.HasThumbnailFile_Large) {
                  new File(paramItem.getThumbnailFile(this.g, 640)).delete();
                }
              }
            }
            paramItem.cookieValue = HexUtil.a(paramFromServiceMsg.bytes_cookie_val.get().toByteArray());
            paramItem.cookieValue = paramItem.cookieValue.toLowerCase();
            paramItem.DownloadIp = paramFromServiceMsg.str_download_ip.get();
            paramItem.DownloadUrl = HexUtil.a(paramFromServiceMsg.bytes_download_url.get().toByteArray());
            paramItem.Md5 = paramFromServiceMsg.bytes_md5.get().toByteArray();
            paramItem.NameForSave = paramFromServiceMsg.str_save_file_name.get();
            paramItem.SafeCheckRes = paramFromServiceMsg.uint32_safe_check_res.get();
            if (i2 == -1)
            {
              if (paramItem.SafeCheckRes == 2) {
                a(paramItem, paramItem.Status, 309);
              }
            }
            else
            {
              if (i1 != 128) {
                break label926;
              }
              new TroopFileTransferManager.TaskHttpDownloadThumbnail(this, paramItem, 128);
              break label1027;
            }
            a(paramItem, 10, 1);
            bool = true;
            break;
            if (i1 == 640)
            {
              new TroopFileTransferManager.TaskHttpDownloadThumbnail(this, paramItem, 640);
              break label1027;
            }
            if (b(paramItem))
            {
              bool = true;
              break;
            }
            new TroopFileTransferManager.TaskHttpDownload(this, paramItem);
            break label1027;
            label977:
            bool = true;
            break;
            label983:
            bool = true;
            break;
            switch (i2)
            {
            }
          }
          bool = true;
        }
      }
    }
  }
  
  public final boolean d(UUID arg1)
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      try
      {
        c();
        localItem = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(???);
        if (localItem == null)
        {
          bool = false;
          return bool;
        }
        switch (localItem.Status)
        {
        case 0: 
          if (!QLog.isDevelopLevel()) {
            break label212;
          }
          QLog.d("TroopFileTransferManager", 4, "error status SuspendUpload");
        }
      }
      finally {}
      TroopFileTransferManager.TaskPool[] arrayOfTaskPool = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool;
      int i2 = arrayOfTaskPool.length;
      int i1 = 0;
      if (i1 < i2) {
        synchronized (arrayOfTaskPool[i1])
        {
          Iterator localIterator = ???.a.iterator();
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)localIterator.next();
            if ((localTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item != localItem) || (!localTask.jdField_a_of_type_Boolean)) {
              continue;
            }
            ???.a.remove(localTask);
            a(localItem, 2);
            bool = true;
            continue;
          }
          i1 += 1;
        }
      }
      localObject.Pausing = 1;
      boolean bool = true;
      continue;
      continue;
      label212:
      bool = false;
    }
  }
  
  public final void e()
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          label13:
          return;
        }
        TroopFileTransferManager.TaskPool[] arrayOfTaskPool = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool;
        int i2 = arrayOfTaskPool.length;
        if (i1 >= i2) {
          break;
        }
        if (!arrayOfTaskPool[i1].a.isEmpty()) {
          d();
        } else {
          i1 += 1;
        }
      }
      finally {}
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      if (localIterator.hasNext())
      {
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem.ThumbnailDownloading_Small) || (localItem.ThumbnailDownloading_Large))
        {
          d();
          break;
        }
      }
      switch (localItem.Status)
      {
      case 0: 
      case 1: 
      case 8: 
        d();
        break label13;
        if (!a()) {
          break label13;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "udmgr release mem");
        }
        this.jdField_b_of_type_JavaUtilMap = null;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaUtilTimer == null) {
          break label13;
        }
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        break label13;
      }
    }
  }
  
  public final void e(TroopFileTransferManager.Item paramItem)
  {
    a(paramItem, 0, true);
  }
  
  /* Error */
  public final boolean e(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc_w 1116
    //   8: aload_3
    //   9: invokevirtual 252	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   12: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: istore 6
    //   17: iload 6
    //   19: ifne +8 -> 27
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 5
    //   26: ireturn
    //   27: aload_1
    //   28: getfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   31: bipush 25
    //   33: if_icmpne +17 -> 50
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: aload 4
    //   42: invokevirtual 1118	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Z
    //   45: istore 5
    //   47: goto -25 -> 22
    //   50: aload_1
    //   51: getfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   54: bipush 102
    //   56: if_icmpeq +12 -> 68
    //   59: aload_1
    //   60: getfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   63: bipush 104
    //   65: if_icmpne -43 -> 22
    //   68: aload_0
    //   69: aload_1
    //   70: aload_2
    //   71: aload_3
    //   72: aload 4
    //   74: invokevirtual 1120	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:f	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Z
    //   77: istore 5
    //   79: goto -57 -> 22
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	TroopFileTransferManager
    //   0	87	1	paramItem	TroopFileTransferManager.Item
    //   0	87	2	paramToServiceMsg	ToServiceMsg
    //   0	87	3	paramFromServiceMsg	FromServiceMsg
    //   0	87	4	paramObject	Object
    //   1	77	5	bool1	boolean
    //   15	3	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   5	17	82	finally
    //   27	47	82	finally
    //   50	59	82	finally
    //   59	68	82	finally
    //   68	79	82	finally
  }
  
  public final boolean e(UUID paramUUID)
  {
    TroopFileInfo localTroopFileInfo;
    TroopFileTransferManager.Item localItem2;
    TroopFileTransferManager.Item localItem1;
    synchronized (a()) {}
  }
  
  /* Error */
  public final void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 1122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +37 -> 45
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: invokestatic 486	android/os/SystemClock:uptimeMillis	()J
    //   17: putfield 1122	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   20: iload_1
    //   21: ifeq +21 -> 42
    //   24: new 114	java/lang/Thread
    //   27: dup
    //   28: new 1124	gxz
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 1125	gxz:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   36: invokespecial 120	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   39: invokevirtual 123	java/lang/Thread:start	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: iconst_0
    //   46: istore_1
    //   47: goto -34 -> 13
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TroopFileTransferManager
    //   12	35	1	i1	int
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	50	finally
    //   13	20	50	finally
    //   24	42	50	finally
  }
  
  public final void f(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      cmd0x383.ReqBody localReqBody = new cmd0x383.ReqBody();
      localReqBody.uint64_groupcode.set(this.g);
      localReqBody.uint32_app_id.set(3);
      cmd0x383.ApplyCopyToReqBody localApplyCopyToReqBody = new cmd0x383.ApplyCopyToReqBody();
      localApplyCopyToReqBody.str_src_file_path.set(paramItem.ForwardPath);
      localApplyCopyToReqBody.uint32_src_bus_id.set(paramItem.ForwardBusId);
      localApplyCopyToReqBody.uint64_dst_uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
      localApplyCopyToReqBody.uint32_dst_bus_id.set(25);
      localReqBody.msg_copy_to_req_body.set(localApplyCopyToReqBody);
      localReqBody.setHasFlag(true);
      paramItem = paramItem.createExtraData(this.g);
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("GroupFileAppSvr.CopyTo", localReqBody.toByteArray(), paramItem);
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, "send CopyToWeiyun req from troopUin :" + this.g);
      }
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public final boolean f(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: sipush 207
    //   3: istore 5
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 197	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   10: ifeq +39 -> 49
    //   13: ldc 12
    //   15: iconst_4
    //   16: new 199	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   23: aload_3
    //   24: invokevirtual 252	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   27: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 989
    //   33: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 672	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   40: invokevirtual 992	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload 4
    //   51: ifnonnull +51 -> 102
    //   54: new 702	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo
    //   57: dup
    //   58: aload_1
    //   59: getfield 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   66: iconst_5
    //   67: sipush 207
    //   70: invokespecial 705	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo:<init>	(Ljava/lang/String;JII)V
    //   73: aload_0
    //   74: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   77: aload_0
    //   78: getfield 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   81: aload_0
    //   82: getfield 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   88: invokestatic 710	com/tencent/mobileqq/troop/utils/TroopFileError:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo;JLcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V
    //   91: aload_0
    //   92: aload_1
    //   93: iconst_5
    //   94: iconst_0
    //   95: invokevirtual 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   98: aload_0
    //   99: monitorexit
    //   100: iconst_1
    //   101: ireturn
    //   102: aload 4
    //   104: checkcast 674	[B
    //   107: checkcast 674	[B
    //   110: astore_2
    //   111: new 676	tencent/im/cs/cmd0x383/cmd0x383$RspBody
    //   114: dup
    //   115: invokespecial 677	tencent/im/cs/cmd0x383/cmd0x383$RspBody:<init>	()V
    //   118: astore_3
    //   119: aload_3
    //   120: aload_2
    //   121: invokevirtual 681	tencent/im/cs/cmd0x383/cmd0x383$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: pop
    //   125: aload_3
    //   126: getfield 685	tencent/im/cs/cmd0x383/cmd0x383$RspBody:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   129: invokevirtual 689	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   132: istore 6
    //   134: invokestatic 197	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   137: ifeq +205 -> 342
    //   140: ldc 12
    //   142: iconst_4
    //   143: ldc_w 1149
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: iload 6
    //   154: invokestatic 696	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokestatic 700	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokestatic 614	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto +178 -> 342
    //   167: aload_0
    //   168: aload_1
    //   169: iconst_5
    //   170: iload 5
    //   172: invokevirtual 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   175: goto -77 -> 98
    //   178: astore_1
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: astore_2
    //   184: new 702	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo
    //   187: dup
    //   188: aload_1
    //   189: getfield 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   192: aload_0
    //   193: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   196: iconst_5
    //   197: sipush 207
    //   200: invokespecial 705	com/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo:<init>	(Ljava/lang/String;JII)V
    //   203: aload_0
    //   204: getfield 94	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   207: aload_0
    //   208: getfield 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   211: aload_0
    //   212: getfield 92	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   215: invokevirtual 100	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   218: invokestatic 710	com/tencent/mobileqq/troop/utils/TroopFileError:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileError$SimpleErrorInfo;JLcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V
    //   221: aload_0
    //   222: aload_1
    //   223: iconst_5
    //   224: iconst_0
    //   225: invokevirtual 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   228: goto -130 -> 98
    //   231: aload_1
    //   232: getfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   235: bipush 102
    //   237: if_icmpne +214 -> 451
    //   240: aload_1
    //   241: bipush 104
    //   243: putfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   246: aload_0
    //   247: aload_1
    //   248: invokevirtual 313	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   251: goto -153 -> 98
    //   254: aload_1
    //   255: getfield 311	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   258: invokestatic 621	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifne +198 -> 459
    //   264: new 647	java/io/File
    //   267: dup
    //   268: aload_1
    //   269: getfield 311	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   272: invokespecial 653	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: invokevirtual 656	java/io/File:exists	()Z
    //   278: ifeq +181 -> 459
    //   281: aload_0
    //   282: aload_1
    //   283: iconst_0
    //   284: invokevirtual 259	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   287: aload_1
    //   288: bipush 102
    //   290: putfield 378	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   293: new 394	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan
    //   296: dup
    //   297: aload_0
    //   298: aload_1
    //   299: invokespecial 397	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   302: pop
    //   303: goto -205 -> 98
    //   306: aload_1
    //   307: aload_3
    //   308: getfield 1153	tencent/im/cs/cmd0x383/cmd0x383$RspBody:msg_copy_to_rsp_body	Ltencent/im/cs/cmd0x383/cmd0x383$ApplyCopyToRspBody;
    //   311: invokevirtual 1156	tencent/im/cs/cmd0x383/cmd0x383$ApplyCopyToRspBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   314: checkcast 1155	tencent/im/cs/cmd0x383/cmd0x383$ApplyCopyToRspBody
    //   317: getfield 1159	tencent/im/cs/cmd0x383/cmd0x383$ApplyCopyToRspBody:str_save_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   320: invokevirtual 727	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   323: putfield 270	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   326: aload_0
    //   327: aload_1
    //   328: bipush 7
    //   330: iconst_0
    //   331: invokevirtual 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   334: aload_0
    //   335: aload_1
    //   336: invokevirtual 634	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:d	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   339: goto -241 -> 98
    //   342: iload 6
    //   344: ifge -38 -> 306
    //   347: iload 6
    //   349: lookupswitch	default:+75->424, -20001:+-118->231, -20000:+-118->231, -6101:+-95->254, -30:+118->467, -25:+94->443, -22:+94->443, -4:+86->435, -3:+78->427
    //   425: impdep1
    //   426: impdep2
    //   427: sipush 202
    //   430: istore 5
    //   432: goto -265 -> 167
    //   435: sipush 600
    //   438: istore 5
    //   440: goto -273 -> 167
    //   443: sipush 701
    //   446: istore 5
    //   448: goto -281 -> 167
    //   451: sipush 204
    //   454: istore 5
    //   456: goto -289 -> 167
    //   459: sipush 603
    //   462: istore 5
    //   464: goto -297 -> 167
    //   467: sipush 705
    //   470: istore 5
    //   472: goto -305 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	TroopFileTransferManager
    //   0	475	1	paramItem	TroopFileTransferManager.Item
    //   0	475	2	paramToServiceMsg	ToServiceMsg
    //   0	475	3	paramFromServiceMsg	FromServiceMsg
    //   0	475	4	paramObject	Object
    //   3	468	5	i1	int
    //   132	216	6	i2	int
    // Exception table:
    //   from	to	target	type
    //   7	49	178	finally
    //   54	98	178	finally
    //   102	119	178	finally
    //   119	125	178	finally
    //   125	164	178	finally
    //   167	175	178	finally
    //   184	228	178	finally
    //   231	251	178	finally
    //   254	303	178	finally
    //   306	339	178	finally
    //   119	125	183	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public final boolean f(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        boolean bool;
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 9: 
        case 10: 
          a(paramUUID, 0, false);
          bool = true;
          break;
        default: 
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final void g(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      cmd0x383.ReqBody localReqBody = new cmd0x383.ReqBody();
      localReqBody.uint64_groupcode.set(paramItem.ForwardTroopuin);
      localReqBody.uint32_app_id.set(3);
      Object localObject = new cmd0x383.ApplyCopyToReqBody();
      ((cmd0x383.ApplyCopyToReqBody)localObject).str_src_file_path.set(paramItem.ForwardPath);
      ((cmd0x383.ApplyCopyToReqBody)localObject).uint32_src_bus_id.set(paramItem.ForwardBusId);
      ((cmd0x383.ApplyCopyToReqBody)localObject).uint64_dst_uin.set(this.g);
      ((cmd0x383.ApplyCopyToReqBody)localObject).uint32_dst_bus_id.set(paramItem.BusId);
      localReqBody.msg_copy_to_req_body.set((MessageMicro)localObject);
      localReqBody.setHasFlag(true);
      localObject = paramItem.createExtraData(this.g);
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21)).a("GroupFileAppSvr.CopyTo", localReqBody.toByteArray(), (Bundle)localObject);
      if (QLog.isDevelopLevel()) {
        QLog.e("TroopFileTransferManager", 4, "send CopyTo req from troopUin :" + paramItem.ForwardPath + "to Uin:" + this.g + "busId:" + paramItem.BusId);
      }
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final boolean g(TroopFileTransferManager.Item paramItem, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i2 = 702;
    if (paramObject == null) {}
    try
    {
      TroopFileError.a(new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.g, 5, 601), this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      a(paramItem, 5, 0);
      return true;
    }
    finally {}
    paramToServiceMsg = (byte[])paramObject;
    paramFromServiceMsg = new cmd0x383.RspBody();
    for (;;)
    {
      int i3;
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        i3 = paramFromServiceMsg.int32_ret_code.get();
        paramFromServiceMsg.str_ret_msg.get();
        if (!QLog.isDevelopLevel()) {
          break label299;
        }
        QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToWeiyun - retCode: %d", new Object[] { Integer.valueOf(i3) }));
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        TroopFileError.a(new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.g, 5, 601), this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
        a(paramItem, 5, 0);
      }
      TroopFileError.a(new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.g, 5, i1), this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      a(paramItem, 5, 0);
      break;
      break;
      int i1 = i2;
      if (paramItem.BusId == 102)
      {
        paramItem.BusId = 104;
        g(paramItem);
        break;
        label299:
        while (i3 == 0)
        {
          TroopFileError.a(new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.g, 5, 602), this.g, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
          break;
        }
        i1 = i2;
        switch (i3)
        {
        case 1053: 
        case -20001: 
        case -20000: 
        default: 
          i1 = 601;
          break;
        case -3: 
          i1 = 202;
          break;
        case -6101: 
          i1 = 703;
          break;
        case -25: 
        case -22: 
          i1 = 701;
          break;
        case -30: 
          i1 = 705;
        }
      }
    }
  }
  
  public final boolean g(UUID arg1)
  {
    for (;;)
    {
      try
      {
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(???);
        if (localItem == null)
        {
          bool = false;
          return bool;
        }
        if (localItem.Status != 8)
        {
          bool = false;
          continue;
        }
        TroopFileTransferManager.TaskPool[] arrayOfTaskPool = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool;
        int i2 = arrayOfTaskPool.length;
        int i1 = 0;
        if (i1 < i2) {
          synchronized (arrayOfTaskPool[i1])
          {
            Iterator localIterator = ???.a.iterator();
            if (localIterator.hasNext())
            {
              TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)localIterator.next();
              if ((localTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item != localItem) || (!localTask.jdField_b_of_type_Boolean)) {
                continue;
              }
              ???.a.remove(localTask);
              a(localItem, 9);
              bool = true;
              continue;
            }
            i1 += 1;
          }
        }
        localObject.Pausing = 1;
      }
      finally {}
      boolean bool = true;
    }
  }
  
  void h(TroopFileTransferManager.Item paramItem) {}
  
  public final void i()
  {
    try
    {
      c();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME) {
          localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME;
        }
      }
    }
    finally {}
  }
  
  public final void j()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      try
      {
        c();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label153;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME) {
          continue;
        }
        localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          c(localItem.Id);
        }
      }
      finally {}
      continue;
      f(localItem.Id);
      continue;
      label153:
      return;
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi() {}
  
  public void onNetNone2Mobile()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi() {}
  
  public void onNetWifi2Mobile()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "onNetWifi2Mobile");
      }
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {
        label26:
        return;
      }
      int i1 = 0;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      for (;;)
      {
        TroopFileTransferManager.Item localItem;
        if (localIterator.hasNext()) {
          localItem = (TroopFileTransferManager.Item)localIterator.next();
        }
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          if (localItem.Pausing == 0)
          {
            localItem.Pausing = 1;
            localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME;
            i1 = 1;
            break label156;
            if (i1 == 0) {
              break label26;
            }
            TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, 107);
            break label26;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager
 * JD-Core Version:    0.7.0.1
 */