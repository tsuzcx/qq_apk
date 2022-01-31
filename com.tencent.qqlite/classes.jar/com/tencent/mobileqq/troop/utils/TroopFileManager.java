package com.tencent.mobileqq.troop.utils;

import android.database.Observable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eop;
import eoq;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import mqq.app.MobileQQ;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyDelFileReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListV2ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyTransFileRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.ReqBody;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class TroopFileManager
  extends Observable
{
  public static final int a = 15;
  public static final long a = 30000L;
  public static final String a = "TroopFileManager";
  public static Map a;
  public static final int b = 10;
  public static final int c = 50;
  public static final int d = 172800;
  public static final int e = 20;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int q = 1;
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 4;
  public static final int u = 5;
  public Handler a;
  public BizTroopObserver a;
  public QQAppInterface a;
  public TroopFileManager.FileTimestamp a;
  public TroopFileManager.Filter a;
  public TroopFileTransferManager a;
  public Set a;
  public boolean a;
  public long b;
  public TroopFileManager.FileTimestamp b;
  public TroopFileManager.Filter b;
  public Map b;
  public boolean b;
  public long c;
  public Map c;
  public boolean c;
  public long d;
  public int f;
  public int g;
  public int h;
  public int p;
  
  static
  {
    if (!TroopFileManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_d_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilMap = new HashMap();
      return;
    }
  }
  
  public TroopFileManager(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter = new TroopFileManager.NormalFileFilter();
    this.jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter = new TroopFileManager.UploadingFileFilter();
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new eoq(this);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a().iterator();
    while (localIterator.hasNext())
    {
      TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)localIterator.next();
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
      localTroopFileInfo.a(localTroopFileStatusInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      if (localTroopFileInfo.jdField_b_of_type_JavaLangString != null) {
        this.jdField_c_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_b_of_type_JavaLangString, localTroopFileInfo);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new eop(this, paramQQAppInterface.getApplication().getMainLooper());
  }
  
  public static TroopFileManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      TroopFileManager localTroopFileManager2 = (TroopFileManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      TroopFileManager localTroopFileManager1;
      if (localTroopFileManager2 != null)
      {
        localTroopFileManager1 = localTroopFileManager2;
        if (localTroopFileManager2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localTroopFileManager1 = new TroopFileManager(paramQQAppInterface, paramLong);
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopFileManager1);
      }
      return localTroopFileManager1;
    }
    finally {}
  }
  
  public static Collection a(Collection paramCollection, TroopFileManager.Filter paramFilter)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramCollection.next();
      if (paramFilter.a(localTroopFileInfo)) {
        localArrayList.add(localTroopFileInfo);
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileManager)localIterator.next()).c();
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    for (;;)
    {
      try
      {
        TroopFileManager localTroopFileManager = (TroopFileManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
        if (localTroopFileManager == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileManager", 4, "bad troopUin" + l1);
          }
          return;
        }
        try
        {
          if ((!localTroopFileManager.a(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!localTroopFileManager.d(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!localTroopFileManager.c(paramToServiceMsg, paramFromServiceMsg, paramObject)) && (!localTroopFileManager.b(paramToServiceMsg, paramFromServiceMsg, paramObject)))
          {
            i1 = 0;
            if ((i1 == 0) && (QLog.isDevelopLevel())) {
              QLog.i("TroopFileManager", 4, "bad subcmd" + paramFromServiceMsg.getServiceCmd());
            }
            return;
          }
        }
        finally {}
        int i1 = 1;
      }
      finally {}
    }
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    return this.p;
  }
  
  /* Error */
  public TroopFileInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 180 2 0
    //   19: checkcast 136	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	TroopFileManager
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public TroopFileInfo a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      TroopFileInfo localTroopFileInfo = new TroopFileInfo();
      localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
      localTroopFileInfo.jdField_c_of_type_JavaLangString = paramString;
      localTroopFileInfo.jdField_a_of_type_Long = paramLong;
      localTroopFileInfo.jdField_a_of_type_Int = paramInt;
      localTroopFileInfo.jdField_c_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
      this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
      return localTroopFileInfo;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public TroopFileInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    Object localObject;
    if (paramString1 == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.jdField_c_of_type_JavaUtilMap.get(paramString1);
        localObject = localTroopFileInfo;
        if (localTroopFileInfo != null) {
          continue;
        }
        if (paramInt == 0)
        {
          localObject = null;
          continue;
        }
        localObject = new TroopFileInfo();
        ((TroopFileInfo)localObject).jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        ((TroopFileInfo)localObject).jdField_b_of_type_JavaLangString = paramString1;
        ((TroopFileInfo)localObject).jdField_c_of_type_JavaLangString = paramString2;
        ((TroopFileInfo)localObject).jdField_a_of_type_Long = paramLong;
        ((TroopFileInfo)localObject).jdField_a_of_type_Int = paramInt;
        this.jdField_b_of_type_JavaUtilMap.put(((TroopFileInfo)localObject).jdField_a_of_type_JavaUtilUUID, localObject);
        this.jdField_c_of_type_JavaUtilMap.put(paramString1, localObject);
      }
      finally {}
    }
  }
  
  public TroopFileInfo a(UUID paramUUID)
  {
    try
    {
      paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public final Collection a()
  {
    try
    {
      Collection localCollection = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter);
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, paramInt, 0).sendToTarget();
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        if (QLog.isDevelopLevel())
        {
          QLog.d("TroopFileManager", 4, "doReqTroopFileList--begin");
          QLog.d("TroopFileManager", 4, "QUN_UIN:" + this.jdField_b_of_type_Long);
        }
        cmd0x383.ReqBody localReqBody = new cmd0x383.ReqBody();
        localReqBody.uint64_groupcode.set(this.jdField_b_of_type_Long);
        localReqBody.uint32_app_id.set(3);
        localObject2 = (cmd0x383.ApplyGetFileListReqBody)localReqBody.msg_get_file_list_req_body.get();
        if (localObject2 == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopFileManager", 4, "getFileListReqBody == null" + this.jdField_b_of_type_Long);
          }
          return;
        }
        if (paramInt1 == 3)
        {
          ((cmd0x383.ApplyGetFileListReqBody)localObject2).uint32_start_index.set(0);
          ((cmd0x383.ApplyGetFileListReqBody)localObject2).uint32_file_count.set(1);
          ((cmd0x383.ApplyGetFileListReqBody)localObject2).uint32_req_from.set(2);
          localReqBody.msg_get_file_list_req_body.set((MessageMicro)localObject2);
          localReqBody.setHasFlag(true);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putLong("troopUin", this.jdField_b_of_type_Long);
          ((Bundle)localObject2).putInt("reqFor", paramInt1);
          ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a("GroupFileAppSvr.GetFileList", localReqBody.toByteArray(), (Bundle)localObject2);
          this.f += 1;
          continue;
        }
        ((cmd0x383.ApplyGetFileListReqBody)localObject2).uint32_start_index.set(paramInt2);
      }
      finally {}
      ((cmd0x383.ApplyGetFileListReqBody)localObject2).uint32_file_count.set(paramInt3);
      ((cmd0x383.ApplyGetFileListReqBody)localObject2).uint32_req_from.set(3);
    }
  }
  
  public final void a(int paramInt1, TroopFileManager.FileTimestamp paramFileTimestamp, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramFileTimestamp == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopFileManager", 4, "doReqTroopFileListV2--begin:" + this.jdField_b_of_type_Long + ",reqFor:" + paramInt1 + ",reqFrom:" + paramInt3 + ",count:" + paramInt2 + ",firstPage:" + bool);
        }
        Object localObject = new cmd0x383.ApplyGetFileListV2ReqBody();
        TroopFileManager.FileTimestamp.a(paramFileTimestamp, ((cmd0x383.ApplyGetFileListV2ReqBody)localObject).msg_start_timestamp);
        if (bool)
        {
          TroopFileManager.FileTimestamp.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp, ((cmd0x383.ApplyGetFileListV2ReqBody)localObject).msg_max_timestamp);
          ((cmd0x383.ApplyGetFileListV2ReqBody)localObject).uint32_all_file_count.set(this.h);
        }
        ((cmd0x383.ApplyGetFileListV2ReqBody)localObject).uint32_file_count.set(paramInt2);
        ((cmd0x383.ApplyGetFileListV2ReqBody)localObject).uint32_req_from.set(paramInt3);
        paramFileTimestamp = new cmd0x383.ReqBody();
        paramFileTimestamp.uint64_groupcode.set(this.jdField_b_of_type_Long);
        paramFileTimestamp.uint32_app_id.set(3);
        paramFileTimestamp.msg_get_file_list_v2_req_body.set((MessageMicro)localObject);
        paramFileTimestamp.setHasFlag(true);
        localObject = new Bundle();
        ((Bundle)localObject).putLong("troopUin", this.jdField_b_of_type_Long);
        ((Bundle)localObject).putInt("reqFor", paramInt1);
        ((Bundle)localObject).putInt("reqFrom", paramInt3);
        ((Bundle)localObject).putBoolean("firstPage", bool);
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a("GroupFileAppSvr.GetFileListV2", paramFileTimestamp.toByteArray(), (Bundle)localObject);
        this.f += 1;
        return;
      }
      finally {}
      bool = false;
    }
  }
  
  public final void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
        if (localObject1 == null) {
          return;
        }
        if (paramTroopFileInfo.jdField_b_of_type_JavaLangString == null)
        {
          b(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
          continue;
        }
        if (paramTroopFileInfo.jdField_a_of_type_Int == 0) {
          continue;
        }
      }
      finally {}
      if (QLog.isDevelopLevel())
      {
        QLog.d("TroopFileManager", 4, "delTroopFile--begin");
        QLog.d("TroopFileManager", 4, "QUN_UIN:" + this.jdField_b_of_type_Long);
      }
      Object localObject1 = new cmd0x383.ReqBody();
      ((cmd0x383.ReqBody)localObject1).uint64_groupcode.set(this.jdField_b_of_type_Long);
      ((cmd0x383.ReqBody)localObject1).uint32_app_id.set(3);
      Object localObject2 = new cmd0x383.ApplyDelFileReqBody();
      ((cmd0x383.ApplyDelFileReqBody)localObject2).uint32_bus_id.set(paramTroopFileInfo.jdField_a_of_type_Int);
      ((cmd0x383.ApplyDelFileReqBody)localObject2).str_file_path.set(paramTroopFileInfo.jdField_b_of_type_JavaLangString);
      ((cmd0x383.ReqBody)localObject1).msg_del_file_req_body.set((MessageMicro)localObject2);
      ((cmd0x383.ReqBody)localObject1).setHasFlag(true);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("troopUin", this.jdField_b_of_type_Long);
      ((Bundle)localObject2).putString("filePath", paramTroopFileInfo.jdField_b_of_type_JavaLangString);
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a("GroupFileAppSvr.DelFile", ((cmd0x383.ReqBody)localObject1).toByteArray(), (Bundle)localObject2);
      this.f += 1;
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, int paramInt)
  {
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long, paramTroopFileInfo.jdField_c_of_type_JavaLangString, paramTroopFileInfo.g, paramInt);
  }
  
  public void a(TroopFileObserver paramTroopFileObserver)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      TroopFileObserver localTroopFileObserver = (TroopFileObserver)localIterator.next();
      if (localTroopFileObserver == paramTroopFileObserver) {
        this.mObservers.remove(localTroopFileObserver);
      }
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 81	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface 499 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   17: ifne +25 -> 42
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   25: aload_0
    //   26: iconst_2
    //   27: aconst_null
    //   28: bipush 10
    //   30: iconst_1
    //   31: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   34: aload_0
    //   35: iconst_1
    //   36: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   47: goto -8 -> 39
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	TroopFileManager
    //   0	55	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	39	50	finally
    //   42	47	50	finally
  }
  
  public void a(Collection paramCollection, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean) }).sendToTarget();
  }
  
  public final void a(UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (;;)
    {
      return;
      try
      {
        paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if ((paramUUID == null) || (!paramUUID.jdField_a_of_type_Boolean)) {
          continue;
        }
        paramUUID.jdField_a_of_type_Boolean = false;
        c(paramUUID);
      }
      finally {}
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   7: lstore_3
    //   8: aload_0
    //   9: getfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   12: lstore 5
    //   14: lload_3
    //   15: lload 5
    //   17: lsub
    //   18: lstore_3
    //   19: lconst_0
    //   20: lload_3
    //   21: lcmp
    //   22: ifge +20 -> 42
    //   25: lload_3
    //   26: iload_1
    //   27: i2l
    //   28: ldc2_w 286
    //   31: lmul
    //   32: lcmp
    //   33: ifge +9 -> 42
    //   36: iconst_0
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: aload_0
    //   43: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   46: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   49: aload_0
    //   50: iconst_1
    //   51: aconst_null
    //   52: bipush 15
    //   54: iconst_1
    //   55: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   58: goto -20 -> 38
    //   61: astore 7
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 7
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	TroopFileManager
    //   0	68	1	paramInt	int
    //   1	40	2	bool	boolean
    //   7	19	3	l1	long
    //   12	4	5	l2	long
    //   61	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	61	finally
    //   42	58	61	finally
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_c_of_type_Long;
      l1 -= l2;
      if ((0L < l1) && (l1 < paramInt1 * 1000L)) {
        return bool;
      }
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      switch (paramInt2)
      {
      }
      for (;;)
      {
        a(0, null, 50, paramInt2);
        bool = true;
        break;
        paramInt2 = 1;
        continue;
        paramInt2 = 2;
        continue;
        paramInt2 = 3;
      }
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(TroopFileInfo paramTroopFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 279	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_Int	I
    //   6: ifeq +12 -> 18
    //   9: aload_1
    //   10: getfield 152	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +9 -> 24
    //   18: iconst_0
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_2
    //   23: ireturn
    //   24: new 314	tencent/im/cs/cmd0x383/cmd0x383$ReqBody
    //   27: dup
    //   28: invokespecial 315	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:<init>	()V
    //   31: astore_3
    //   32: aload_3
    //   33: getfield 329	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:uint32_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   36: iconst_3
    //   37: invokevirtual 333	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   40: aload_3
    //   41: getfield 319	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:uint64_groupcode	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   44: aload_0
    //   45: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Long	J
    //   48: invokevirtual 325	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   51: new 530	tencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody
    //   54: dup
    //   55: invokespecial 531	tencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody:<init>	()V
    //   58: astore 4
    //   60: aload 4
    //   62: getfield 532	tencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody:uint32_bus_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: aload_1
    //   66: getfield 279	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_Int	I
    //   69: invokevirtual 333	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   72: aload 4
    //   74: getfield 533	tencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   77: aload_1
    //   78: getfield 152	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   81: invokevirtual 464	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   84: aload_3
    //   85: getfield 537	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:msg_trans_file_req_body	Ltencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody;
    //   88: aload 4
    //   90: invokevirtual 538	tencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   93: aload_3
    //   94: getfield 537	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:msg_trans_file_req_body	Ltencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody;
    //   97: iconst_1
    //   98: invokevirtual 539	tencent/im/cs/cmd0x383/cmd0x383$ApplyTransFileReqBody:setHasFlag	(Z)V
    //   101: aload_0
    //   102: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: bipush 19
    //   107: invokevirtual 374	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   110: checkcast 376	com/tencent/mobileqq/app/BizTroopHandler
    //   113: astore 4
    //   115: new 216	android/os/Bundle
    //   118: dup
    //   119: invokespecial 361	android/os/Bundle:<init>	()V
    //   122: astore 5
    //   124: aload 5
    //   126: ldc 214
    //   128: aload_0
    //   129: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Long	J
    //   132: invokevirtual 365	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   135: aload 5
    //   137: ldc_w 471
    //   140: aload_1
    //   141: getfield 152	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   144: invokevirtual 475	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 4
    //   149: ldc_w 541
    //   152: aload_3
    //   153: invokevirtual 382	tencent/im/cs/cmd0x383/cmd0x383$ReqBody:toByteArray	()[B
    //   156: aload 5
    //   158: invokevirtual 385	com/tencent/mobileqq/app/BizTroopHandler:a	(Ljava/lang/String;[BLandroid/os/Bundle;)V
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 387	com/tencent/mobileqq/troop/utils/TroopFileManager:f	I
    //   166: iconst_1
    //   167: iadd
    //   168: putfield 387	com/tencent/mobileqq/troop/utils/TroopFileManager:f	I
    //   171: iconst_1
    //   172: istore_2
    //   173: goto -153 -> 20
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	TroopFileManager
    //   0	181	1	paramTroopFileInfo	TroopFileInfo
    //   19	154	2	bool	boolean
    //   13	140	3	localObject1	Object
    //   58	90	4	localObject2	Object
    //   122	35	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   2	14	176	finally
    //   24	171	176	finally
  }
  
  public final boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    int i2;
    for (;;)
    {
      try
      {
        boolean bool2 = "GroupFileAppSvr.DelFile".equals(paramFromServiceMsg.getServiceCmd());
        if (!bool2) {
          return bool1;
        }
        this.f -= 1;
        if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
          break label242;
        }
        paramObject = (byte[])paramObject;
        paramFromServiceMsg = new cmd0x383.RspBody();
      }
      finally {}
      try
      {
        paramObject = (cmd0x383.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        continue;
      }
      if (paramFromServiceMsg == null)
      {
        bool1 = true;
      }
      else
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getString("filePath");
        paramObject = (TroopFileInfo)this.jdField_c_of_type_JavaUtilMap.get(paramToServiceMsg);
        if (paramObject == null)
        {
          bool1 = true;
        }
        else
        {
          i2 = paramFromServiceMsg.int32_ret_code.get();
          if (!QLog.isDevelopLevel()) {
            break label248;
          }
          QLog.e("TroopFileManager", 4, String.format("onRspDelete - retCode: %d", new Object[] { Integer.valueOf(i2) }));
          break label248;
        }
      }
    }
    for (;;)
    {
      int i1;
      a(paramObject, i1);
      bool1 = true;
      break;
      if (QLog.isDevelopLevel())
      {
        QLog.e("TroopFileManager", 4, "不是上传者，群主或管理员不能删除文件");
        break label299;
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopFileManager", 4, "文件不存在或者已经过期");
        }
        b(paramToServiceMsg);
        bool1 = true;
        break;
        label242:
        label248:
        do
        {
          b(paramToServiceMsg);
          bool1 = true;
          break;
          bool1 = true;
          break;
        } while (i2 >= 0);
        i1 = 401;
      }
      switch (i2)
      {
      case -2: 
      case -6101: 
      default: 
        continue;
        i1 = 402;
        break;
      case -22: 
        label299:
        i1 = 101;
      }
    }
  }
  
  public TroopFileInfo b(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        TroopFileInfo localTroopFileInfo = new TroopFileInfo();
        localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
        localTroopFileInfo.f = paramString;
        paramString = new File(paramString);
        localTroopFileInfo.jdField_a_of_type_Long = paramString.length();
        localTroopFileInfo.jdField_c_of_type_JavaLangString = paramString.getName();
        localTroopFileInfo.jdField_c_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
        this.jdField_b_of_type_JavaUtilMap.put(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID, localTroopFileInfo);
        paramString = localTroopFileInfo;
      }
      finally {}
    }
  }
  
  public final Collection b()
  {
    try
    {
      Collection localCollection = a(this.jdField_b_of_type_JavaUtilMap.values(), this.jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$Filter);
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b()
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileInfo)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramInt);
    }
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b(paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public final void b(String paramString)
  {
    try
    {
      paramString = (TroopFileInfo)this.jdField_c_of_type_JavaUtilMap.remove(paramString);
      if ((!jdField_d_of_type_Boolean) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramString.jdField_a_of_type_JavaUtilUUID);
      b(paramString);
    }
  }
  
  public void b(Collection paramCollection, boolean paramBoolean)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramCollection, paramBoolean);
    }
  }
  
  public final void b(UUID paramUUID)
  {
    try
    {
      paramUUID = (TroopFileInfo)this.jdField_b_of_type_JavaUtilMap.remove(paramUUID);
      if (paramUUID != null)
      {
        if (paramUUID.jdField_b_of_type_JavaLangString != null) {
          this.jdField_c_of_type_JavaUtilMap.remove(paramUUID.jdField_b_of_type_JavaLangString);
        }
        b(paramUUID);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: iconst_1
    //   21: aload_0
    //   22: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   25: bipush 15
    //   27: iconst_1
    //   28: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   31: goto -16 -> 15
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	TroopFileManager
    //   1	17	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   34	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	34	finally
    //   19	31	34	finally
  }
  
  public final boolean b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        boolean bool2 = "GroupFileAppSvr.TransFile".equals(paramFromServiceMsg.getServiceCmd());
        if (!bool2) {
          return bool1;
        }
        this.f -= 1;
        if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
        {
          if (!QLog.isDevelopLevel()) {
            break label343;
          }
          QLog.e("TroopFileManager", 4, "onRspTransFile unsuccess");
          break label343;
        }
        paramFromServiceMsg = (byte[])paramObject;
        paramObject = new cmd0x383.RspBody();
        try
        {
          paramObject = (cmd0x383.RspBody)paramObject.mergeFrom(paramFromServiceMsg);
          if (paramObject != null) {
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            break label349;
          }
          QLog.e("TroopFileManager", 4, "onRspTransFile BigRsp null");
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (!QLog.isDevelopLevel()) {
            break label355;
          }
        }
        QLog.e("TroopFileManager", 4, "onRspTransFile BigRsp format error");
      }
      finally {}
      paramToServiceMsg = paramToServiceMsg.extraData.getString("filePath");
      paramFromServiceMsg = (TroopFileInfo)this.jdField_c_of_type_JavaUtilMap.get(paramToServiceMsg);
      label343:
      label349:
      label481:
      if (paramFromServiceMsg == null)
      {
        bool1 = true;
      }
      else
      {
        int i2 = paramObject.int32_ret_code.get();
        int i1;
        if (QLog.isDevelopLevel())
        {
          QLog.e("TroopFileManager", 4, String.format("onRspTransFile - retCode: %d", new Object[] { Integer.valueOf(i2) }));
          break label361;
          a(paramFromServiceMsg, i1);
          bool1 = true;
          continue;
          paramObject = (cmd0x383.ApplyTransFileRspBody)paramObject.msg_trans_file_rsp_body.get();
          if (paramObject == null)
          {
            if (!QLog.isDevelopLevel()) {
              break label481;
            }
            QLog.e("TroopFileManager", 4, "onRspTransFile rsp null");
            break label481;
          }
          paramObject = paramObject.str_save_file_path.get();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramFromServiceMsg.jdField_a_of_type_JavaUtilUUID, paramObject);
          paramFromServiceMsg.jdField_b_of_type_JavaLangString = paramObject;
          paramFromServiceMsg.jdField_a_of_type_Int = 102;
          paramFromServiceMsg.d = 0;
          this.jdField_c_of_type_JavaUtilMap.remove(paramToServiceMsg);
          this.jdField_c_of_type_JavaUtilMap.put(paramObject, paramFromServiceMsg);
          c(paramFromServiceMsg);
          a(paramObject);
          a(paramFromServiceMsg, 505);
          bool1 = true;
          continue;
          bool1 = true;
          continue;
          bool1 = true;
          continue;
          label355:
          bool1 = true;
          continue;
        }
        label361:
        if (i2 < 0)
        {
          i1 = 501;
          switch (i2)
          {
          default: 
            break;
          case -3: 
            i1 = 504;
            break;
          case -4: 
            i1 = 103;
            break;
          case -22: 
            i1 = 101;
            break;
          case -25086: 
          case -20001: 
          case -20000: 
            i1 = 503;
            break;
          case -6101: 
            i1 = 502;
            break;
          }
          bool1 = true;
        }
      }
    }
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  /* Error */
  public final boolean c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 443
    //   5: aload_2
    //   6: invokevirtual 260	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   9: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: istore 8
    //   14: iload 8
    //   16: ifne +11 -> 27
    //   19: iconst_0
    //   20: istore 8
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 8
    //   26: ireturn
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 387	com/tencent/mobileqq/troop/utils/TroopFileManager:f	I
    //   32: iconst_1
    //   33: isub
    //   34: putfield 387	com/tencent/mobileqq/troop/utils/TroopFileManager:f	I
    //   37: aload_1
    //   38: getfield 212	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   41: ldc_w 367
    //   44: invokevirtual 654	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   47: istore 6
    //   49: aload_1
    //   50: getfield 212	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   53: ldc_w 435
    //   56: invokevirtual 654	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   59: istore 7
    //   61: aload_1
    //   62: getfield 212	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   65: ldc_w 437
    //   68: invokevirtual 658	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   71: istore 8
    //   73: iconst_0
    //   74: istore 10
    //   76: iconst_0
    //   77: istore 9
    //   79: aload_3
    //   80: ifnull +14 -> 94
    //   83: aload_2
    //   84: invokevirtual 551	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   87: istore 11
    //   89: iload 11
    //   91: ifne +88 -> 179
    //   94: iconst_1
    //   95: istore 8
    //   97: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   100: ifeq +3091 -> 3191
    //   103: ldc 13
    //   105: iconst_4
    //   106: new 227	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 660
    //   116: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload 6
    //   121: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: goto +3061 -> 3191
    //   133: aload_0
    //   134: lconst_0
    //   135: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   138: aload_0
    //   139: aconst_null
    //   140: iconst_0
    //   141: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   144: goto -122 -> 22
    //   147: astore_1
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    //   152: aload_0
    //   153: lconst_0
    //   154: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   157: aload_0
    //   158: aconst_null
    //   159: iconst_0
    //   160: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   163: goto -141 -> 22
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   171: aload_0
    //   172: iconst_0
    //   173: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   176: goto -154 -> 22
    //   179: aload_3
    //   180: checkcast 553	[B
    //   183: checkcast 553	[B
    //   186: astore_1
    //   187: new 555	tencent/im/cs/cmd0x383/cmd0x383$RspBody
    //   190: dup
    //   191: invokespecial 556	tencent/im/cs/cmd0x383/cmd0x383$RspBody:<init>	()V
    //   194: astore_2
    //   195: aload_2
    //   196: aload_1
    //   197: invokevirtual 560	tencent/im/cs/cmd0x383/cmd0x383$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   200: checkcast 555	tencent/im/cs/cmd0x383/cmd0x383$RspBody
    //   203: astore_1
    //   204: aload_1
    //   205: ifnonnull +164 -> 369
    //   208: iconst_1
    //   209: istore 8
    //   211: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   214: ifeq +3009 -> 3223
    //   217: ldc 13
    //   219: iconst_4
    //   220: new 227	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 660
    //   230: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 6
    //   235: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto +2979 -> 3223
    //   247: aload_0
    //   248: lconst_0
    //   249: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   252: aload_0
    //   253: aconst_null
    //   254: iconst_0
    //   255: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   258: goto -236 -> 22
    //   261: astore_1
    //   262: iconst_1
    //   263: istore 8
    //   265: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   268: ifeq +2987 -> 3255
    //   271: ldc 13
    //   273: iconst_4
    //   274: new 227	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 660
    //   284: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 6
    //   289: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: goto +2957 -> 3255
    //   301: aload_0
    //   302: lconst_0
    //   303: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   306: aload_0
    //   307: aconst_null
    //   308: iconst_0
    //   309: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   312: goto -290 -> 22
    //   315: aload_0
    //   316: lconst_0
    //   317: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   320: aload_0
    //   321: aconst_null
    //   322: iconst_0
    //   323: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   326: goto -304 -> 22
    //   329: aload_0
    //   330: iconst_0
    //   331: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   334: aload_0
    //   335: iconst_0
    //   336: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   339: goto -317 -> 22
    //   342: aload_0
    //   343: lconst_0
    //   344: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   347: aload_0
    //   348: aconst_null
    //   349: iconst_0
    //   350: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   353: goto -331 -> 22
    //   356: aload_0
    //   357: iconst_0
    //   358: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   361: aload_0
    //   362: iconst_0
    //   363: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   366: goto -344 -> 22
    //   369: aload_1
    //   370: getfield 568	tencent/im/cs/cmd0x383/cmd0x383$RspBody:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   373: invokevirtual 572	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   376: istore 4
    //   378: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   381: ifeq +27 -> 408
    //   384: ldc 13
    //   386: iconst_4
    //   387: ldc_w 663
    //   390: iconst_1
    //   391: anewarray 509	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: iload 4
    //   398: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   401: aastore
    //   402: invokestatic 583	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   405: invokestatic 585	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload 4
    //   410: ifge +89 -> 499
    //   413: iload 4
    //   415: iconst_m1
    //   416: if_icmpne +3 -> 419
    //   419: iconst_1
    //   420: istore 8
    //   422: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   425: ifeq +2862 -> 3287
    //   428: ldc 13
    //   430: iconst_4
    //   431: new 227	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 660
    //   441: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto +2832 -> 3287
    //   458: aload_0
    //   459: lconst_0
    //   460: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   463: aload_0
    //   464: aconst_null
    //   465: iconst_0
    //   466: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   469: goto -447 -> 22
    //   472: aload_0
    //   473: lconst_0
    //   474: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   477: aload_0
    //   478: aconst_null
    //   479: iconst_0
    //   480: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   483: goto -461 -> 22
    //   486: aload_0
    //   487: iconst_0
    //   488: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   491: aload_0
    //   492: iconst_0
    //   493: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   496: goto -474 -> 22
    //   499: aload_1
    //   500: getfield 667	tencent/im/cs/cmd0x383/cmd0x383$RspBody:msg_get_file_list_v2_rsp_body	Ltencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody;
    //   503: invokevirtual 670	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   506: checkcast 669	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody
    //   509: astore_1
    //   510: aload_1
    //   511: ifnonnull +83 -> 594
    //   514: iconst_1
    //   515: istore 8
    //   517: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   520: ifeq +2799 -> 3319
    //   523: ldc 13
    //   525: iconst_4
    //   526: new 227	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 660
    //   536: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: iload 6
    //   541: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   544: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: goto +2769 -> 3319
    //   553: aload_0
    //   554: lconst_0
    //   555: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   558: aload_0
    //   559: aconst_null
    //   560: iconst_0
    //   561: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   564: goto -542 -> 22
    //   567: aload_0
    //   568: lconst_0
    //   569: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   572: aload_0
    //   573: aconst_null
    //   574: iconst_0
    //   575: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   578: goto -556 -> 22
    //   581: aload_0
    //   582: iconst_0
    //   583: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   586: aload_0
    //   587: iconst_0
    //   588: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   591: goto -569 -> 22
    //   594: aload_1
    //   595: getfield 674	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:rpt_msg_file_info_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   598: invokevirtual 679	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   601: astore_2
    //   602: aload_2
    //   603: ifnonnull +83 -> 686
    //   606: iconst_1
    //   607: istore 8
    //   609: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   612: ifeq +2739 -> 3351
    //   615: ldc 13
    //   617: iconst_4
    //   618: new 227	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   625: ldc_w 660
    //   628: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: iload 6
    //   633: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: goto +2709 -> 3351
    //   645: aload_0
    //   646: lconst_0
    //   647: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   650: aload_0
    //   651: aconst_null
    //   652: iconst_0
    //   653: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   656: goto -634 -> 22
    //   659: aload_0
    //   660: lconst_0
    //   661: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   664: aload_0
    //   665: aconst_null
    //   666: iconst_0
    //   667: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   670: goto -648 -> 22
    //   673: aload_0
    //   674: iconst_0
    //   675: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   678: aload_0
    //   679: iconst_0
    //   680: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   683: goto -661 -> 22
    //   686: iload 8
    //   688: ifeq +2727 -> 3415
    //   691: iload 6
    //   693: iconst_2
    //   694: if_icmpeq +2721 -> 3415
    //   697: iload 9
    //   699: istore 8
    //   701: aload_0
    //   702: getfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   705: ifnull +627 -> 1332
    //   708: iload 9
    //   710: istore 8
    //   712: aload_0
    //   713: getfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   716: getfield 680	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_Int	I
    //   719: aload_1
    //   720: getfield 681	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:msg_max_timestamp	Ltencent/im/cs/cmd0x383/cmd0x383$FileTimestamp;
    //   723: getfield 686	tencent/im/cs/cmd0x383/cmd0x383$FileTimestamp:uint32_upload_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   726: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   729: if_icmpne +603 -> 1332
    //   732: iload 9
    //   734: istore 8
    //   736: aload_0
    //   737: getfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   740: getfield 689	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   743: aload_1
    //   744: getfield 681	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:msg_max_timestamp	Ltencent/im/cs/cmd0x383/cmd0x383$FileTimestamp;
    //   747: getfield 690	tencent/im/cs/cmd0x383/cmd0x383$FileTimestamp:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   750: invokevirtual 643	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   753: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   756: ifeq +576 -> 1332
    //   759: iload 9
    //   761: istore 8
    //   763: aload_0
    //   764: getfield 426	com/tencent/mobileqq/troop/utils/TroopFileManager:h	I
    //   767: aload_1
    //   768: getfield 691	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:uint32_all_file_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   771: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   774: if_icmpne +558 -> 1332
    //   777: iload 9
    //   779: istore 8
    //   781: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   784: ifeq +16 -> 800
    //   787: iload 9
    //   789: istore 8
    //   791: ldc 13
    //   793: iconst_4
    //   794: ldc_w 693
    //   797: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: iconst_1
    //   801: istore 9
    //   803: iload 6
    //   805: tableswitch	default:+27 -> 832, 0:+34->839, 1:+196->1001, 2:+375->1180
    //   833: lconst_0
    //   834: istore 8
    //   836: goto -814 -> 22
    //   839: aload_0
    //   840: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   843: ifne +69 -> 912
    //   846: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   849: ifeq +43 -> 892
    //   852: ldc 13
    //   854: iconst_4
    //   855: new 227	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 695
    //   865: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_0
    //   869: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   872: invokeinterface 698 1 0
    //   877: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: ldc_w 700
    //   883: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   892: aload_0
    //   893: iconst_0
    //   894: aload_0
    //   895: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   898: bipush 50
    //   900: iload 7
    //   902: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   905: iload 9
    //   907: istore 8
    //   909: goto -887 -> 22
    //   912: aload_0
    //   913: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   916: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   919: aload_0
    //   920: invokevirtual 701	com/tencent/mobileqq/troop/utils/TroopFileManager:a	()Ljava/util/Collection;
    //   923: astore_1
    //   924: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   927: ifeq +58 -> 985
    //   930: ldc 13
    //   932: iconst_4
    //   933: new 227	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 695
    //   943: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload_0
    //   947: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   950: invokeinterface 698 1 0
    //   955: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   958: ldc_w 703
    //   961: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload_1
    //   965: invokeinterface 704 1 0
    //   970: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   973: ldc_w 706
    //   976: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: aload_0
    //   986: aload_1
    //   987: aload_0
    //   988: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   991: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   994: iload 9
    //   996: istore 8
    //   998: goto -976 -> 22
    //   1001: aload_0
    //   1002: invokevirtual 701	com/tencent/mobileqq/troop/utils/TroopFileManager:a	()Ljava/util/Collection;
    //   1005: astore_1
    //   1006: aload_1
    //   1007: invokeinterface 709 1 0
    //   1012: ifeq +91 -> 1103
    //   1015: aload_0
    //   1016: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   1019: ifne +84 -> 1103
    //   1022: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1025: ifeq +58 -> 1083
    //   1028: ldc 13
    //   1030: iconst_4
    //   1031: new 227	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 711
    //   1041: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_0
    //   1045: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1048: invokeinterface 698 1 0
    //   1053: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1056: ldc_w 703
    //   1059: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: aload_1
    //   1063: invokeinterface 704 1 0
    //   1068: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: ldc_w 700
    //   1074: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: aload_0
    //   1084: iconst_1
    //   1085: aload_0
    //   1086: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1089: bipush 15
    //   1091: iload 7
    //   1093: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   1096: iload 9
    //   1098: istore 8
    //   1100: goto -1078 -> 22
    //   1103: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1106: ifeq +58 -> 1164
    //   1109: ldc 13
    //   1111: iconst_4
    //   1112: new 227	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   1119: ldc_w 711
    //   1122: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: aload_0
    //   1126: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1129: invokeinterface 698 1 0
    //   1134: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1137: ldc_w 703
    //   1140: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: aload_1
    //   1144: invokeinterface 704 1 0
    //   1149: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1152: ldc_w 706
    //   1155: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1164: aload_0
    //   1165: aload_1
    //   1166: aload_0
    //   1167: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   1170: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   1173: iload 9
    //   1175: istore 8
    //   1177: goto -1155 -> 22
    //   1180: aload_0
    //   1181: iconst_0
    //   1182: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   1185: aload_0
    //   1186: getfield 81	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1189: invokeinterface 712 1 0
    //   1194: ifne +107 -> 1301
    //   1197: aload_0
    //   1198: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   1201: bipush 20
    //   1203: if_icmpge +98 -> 1301
    //   1206: aload_0
    //   1207: aload_0
    //   1208: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   1211: iconst_1
    //   1212: iadd
    //   1213: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   1216: aload_0
    //   1217: iconst_1
    //   1218: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   1221: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1224: ifeq +37 -> 1261
    //   1227: ldc 13
    //   1229: iconst_4
    //   1230: ldc_w 714
    //   1233: iconst_2
    //   1234: anewarray 509	java/lang/Object
    //   1237: dup
    //   1238: iconst_0
    //   1239: aload_0
    //   1240: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   1243: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1246: aastore
    //   1247: dup
    //   1248: iconst_1
    //   1249: bipush 20
    //   1251: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1254: aastore
    //   1255: invokestatic 583	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1258: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1261: aload_0
    //   1262: getfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   1265: ifne +23 -> 1288
    //   1268: aload_0
    //   1269: iconst_2
    //   1270: aload_0
    //   1271: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1274: bipush 10
    //   1276: iload 7
    //   1278: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   1281: iload 9
    //   1283: istore 8
    //   1285: goto -1263 -> 22
    //   1288: aload_0
    //   1289: aconst_null
    //   1290: putfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1293: aload_0
    //   1294: iconst_0
    //   1295: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   1298: goto -30 -> 1268
    //   1301: aload_0
    //   1302: iconst_0
    //   1303: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   1306: iload 9
    //   1308: istore 8
    //   1310: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1313: ifeq -1291 -> 22
    //   1316: ldc 13
    //   1318: iconst_4
    //   1319: ldc_w 716
    //   1322: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1325: iload 9
    //   1327: istore 8
    //   1329: goto -1307 -> 22
    //   1332: iload 9
    //   1334: istore 8
    //   1336: aload_0
    //   1337: aload_1
    //   1338: getfield 691	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:uint32_all_file_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1341: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1344: putfield 426	com/tencent/mobileqq/troop/utils/TroopFileManager:h	I
    //   1347: iload 9
    //   1349: istore 8
    //   1351: aload_0
    //   1352: getfield 426	com/tencent/mobileqq/troop/utils/TroopFileManager:h	I
    //   1355: ifne +187 -> 1542
    //   1358: iload 9
    //   1360: istore 8
    //   1362: aload_0
    //   1363: aconst_null
    //   1364: putfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1367: iload 9
    //   1369: istore 8
    //   1371: aload_0
    //   1372: aconst_null
    //   1373: putfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1376: iload 9
    //   1378: istore 8
    //   1380: aload_0
    //   1381: invokevirtual 718	com/tencent/mobileqq/troop/utils/TroopFileManager:b	()Ljava/util/Collection;
    //   1384: astore_3
    //   1385: iload 9
    //   1387: istore 8
    //   1389: aload_0
    //   1390: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1393: invokeinterface 205 1 0
    //   1398: iload 9
    //   1400: istore 8
    //   1402: aload_0
    //   1403: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   1406: invokeinterface 205 1 0
    //   1411: iload 9
    //   1413: istore 8
    //   1415: aload_3
    //   1416: invokeinterface 123 1 0
    //   1421: astore_3
    //   1422: iload 9
    //   1424: istore 8
    //   1426: aload_3
    //   1427: invokeinterface 128 1 0
    //   1432: ifeq +1983 -> 3415
    //   1435: iload 9
    //   1437: istore 8
    //   1439: aload_3
    //   1440: invokeinterface 132 1 0
    //   1445: checkcast 136	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   1448: astore 12
    //   1450: iload 9
    //   1452: istore 8
    //   1454: aload_0
    //   1455: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   1458: aload 12
    //   1460: getfield 141	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   1463: aload 12
    //   1465: invokeinterface 150 3 0
    //   1470: pop
    //   1471: iload 9
    //   1473: istore 8
    //   1475: aload_0
    //   1476: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   1479: aload 12
    //   1481: getfield 152	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1484: aload 12
    //   1486: invokeinterface 150 3 0
    //   1491: pop
    //   1492: goto -70 -> 1422
    //   1495: astore_1
    //   1496: iconst_0
    //   1497: istore 4
    //   1499: iload 4
    //   1501: ifeq +1953 -> 3454
    //   1504: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1507: ifeq +1876 -> 3383
    //   1510: ldc 13
    //   1512: iconst_4
    //   1513: new 227	java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   1520: ldc_w 660
    //   1523: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: iload 6
    //   1528: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1537: goto +1846 -> 3383
    //   1540: aload_1
    //   1541: athrow
    //   1542: iload 9
    //   1544: istore 8
    //   1546: aload_0
    //   1547: new 413	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp
    //   1550: dup
    //   1551: invokespecial 719	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:<init>	()V
    //   1554: putfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1557: iload 9
    //   1559: istore 8
    //   1561: aload_0
    //   1562: getfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1565: aload_1
    //   1566: getfield 681	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:msg_max_timestamp	Ltencent/im/cs/cmd0x383/cmd0x383$FileTimestamp;
    //   1569: getfield 686	tencent/im/cs/cmd0x383/cmd0x383$FileTimestamp:uint32_upload_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1572: invokevirtual 687	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1575: putfield 680	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_Int	I
    //   1578: iload 9
    //   1580: istore 8
    //   1582: aload_0
    //   1583: getfield 418	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1586: aload_1
    //   1587: getfield 681	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:msg_max_timestamp	Ltencent/im/cs/cmd0x383/cmd0x383$FileTimestamp;
    //   1590: getfield 690	tencent/im/cs/cmd0x383/cmd0x383$FileTimestamp:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1593: invokevirtual 643	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1596: putfield 689	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1599: goto -232 -> 1367
    //   1602: iconst_0
    //   1603: istore 5
    //   1605: iconst_0
    //   1606: istore 4
    //   1608: iload 9
    //   1610: istore 8
    //   1612: aload_2
    //   1613: invokeinterface 722 1 0
    //   1618: astore_2
    //   1619: iload 9
    //   1621: istore 8
    //   1623: aload_2
    //   1624: invokeinterface 128 1 0
    //   1629: ifeq +466 -> 2095
    //   1632: iload 9
    //   1634: istore 8
    //   1636: aload_2
    //   1637: invokeinterface 132 1 0
    //   1642: checkcast 724	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListRspBody$FileInfo
    //   1645: astore 12
    //   1647: iload 9
    //   1649: istore 8
    //   1651: aload 12
    //   1653: getfield 725	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListRspBody$FileInfo:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1656: invokevirtual 643	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1659: astore_3
    //   1660: iload 9
    //   1662: istore 8
    //   1664: aload_0
    //   1665: getfield 81	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1668: aload_3
    //   1669: invokeinterface 726 2 0
    //   1674: pop
    //   1675: iload 9
    //   1677: istore 8
    //   1679: aload_0
    //   1680: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   1683: aload_3
    //   1684: invokeinterface 180 2 0
    //   1689: checkcast 136	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   1692: astore_1
    //   1693: aload_1
    //   1694: ifnull +182 -> 1876
    //   1697: iload 9
    //   1699: istore 8
    //   1701: aload_1
    //   1702: aload 12
    //   1704: invokevirtual 729	com/tencent/mobileqq/troop/data/TroopFileInfo:a	(Ltencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListRspBody$FileInfo;)V
    //   1707: iload 9
    //   1709: istore 8
    //   1711: aload_0
    //   1712: aload_1
    //   1713: invokevirtual 521	com/tencent/mobileqq/troop/utils/TroopFileManager:c	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   1716: iload 5
    //   1718: iconst_1
    //   1719: iadd
    //   1720: istore 5
    //   1722: iload 9
    //   1724: istore 8
    //   1726: aload_0
    //   1727: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1730: ifnull +60 -> 1790
    //   1733: iload 9
    //   1735: istore 8
    //   1737: aload_0
    //   1738: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1741: getfield 680	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_Int	I
    //   1744: aload_1
    //   1745: getfield 289	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_c_of_type_Int	I
    //   1748: if_icmpgt +42 -> 1790
    //   1751: iload 9
    //   1753: istore 8
    //   1755: aload_0
    //   1756: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1759: getfield 680	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_Int	I
    //   1762: aload_1
    //   1763: getfield 289	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_c_of_type_Int	I
    //   1766: if_icmpne +1685 -> 3451
    //   1769: iload 9
    //   1771: istore 8
    //   1773: aload_0
    //   1774: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1777: getfield 689	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1780: aload_1
    //   1781: getfield 152	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1784: invokevirtual 732	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   1787: ifle +1664 -> 3451
    //   1790: iload 9
    //   1792: istore 8
    //   1794: aload_0
    //   1795: new 413	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp
    //   1798: dup
    //   1799: invokespecial 719	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:<init>	()V
    //   1802: putfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1805: iload 9
    //   1807: istore 8
    //   1809: aload_0
    //   1810: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1813: aload_1
    //   1814: getfield 289	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_c_of_type_Int	I
    //   1817: putfield 680	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_Int	I
    //   1820: iload 9
    //   1822: istore 8
    //   1824: aload_0
    //   1825: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   1828: aload_1
    //   1829: getfield 152	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1832: putfield 689	com/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1835: goto +1616 -> 3451
    //   1838: iload 9
    //   1840: istore 8
    //   1842: aload_0
    //   1843: aload_1
    //   1844: getfield 736	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:bool_is_end	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1847: invokevirtual 740	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1850: putfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   1853: iload 10
    //   1855: istore 9
    //   1857: goto -255 -> 1602
    //   1860: iload 9
    //   1862: istore 8
    //   1864: aload_1
    //   1865: getfield 736	tencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListV2RspBody:bool_is_end	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1868: invokevirtual 740	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1871: istore 9
    //   1873: goto -271 -> 1602
    //   1876: iload 9
    //   1878: istore 8
    //   1880: new 136	com/tencent/mobileqq/troop/data/TroopFileInfo
    //   1883: dup
    //   1884: aload 12
    //   1886: invokespecial 742	com/tencent/mobileqq/troop/data/TroopFileInfo:<init>	(Ltencent/im/cs/cmd0x383/cmd0x383$ApplyGetFileListRspBody$FileInfo;)V
    //   1889: astore_1
    //   1890: iload 9
    //   1892: istore 8
    //   1894: aload_0
    //   1895: getfield 109	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   1898: aload_3
    //   1899: invokevirtual 745	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   1902: astore 12
    //   1904: aload 12
    //   1906: ifnonnull +159 -> 2065
    //   1909: iload 9
    //   1911: istore 8
    //   1913: aload_1
    //   1914: invokestatic 273	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   1917: putfield 141	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   1920: iload 9
    //   1922: istore 8
    //   1924: aload_1
    //   1925: aload_1
    //   1926: getfield 746	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_Long	J
    //   1929: putfield 747	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_c_of_type_Long	J
    //   1932: iload 9
    //   1934: istore 8
    //   1936: aload_1
    //   1937: getfield 746	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_b_of_type_Long	J
    //   1940: aload_1
    //   1941: getfield 277	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_Long	J
    //   1944: lcmp
    //   1945: ifeq +76 -> 2021
    //   1948: iload 9
    //   1950: istore 8
    //   1952: aload_0
    //   1953: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1956: invokevirtual 749	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1959: aload_1
    //   1960: invokevirtual 751	com/tencent/mobileqq/troop/data/TroopFileInfo:c	()Ljava/lang/String;
    //   1963: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1966: ifne +21 -> 1987
    //   1969: iload 9
    //   1971: istore 8
    //   1973: aload_0
    //   1974: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1977: aload_0
    //   1978: getfield 100	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Long	J
    //   1981: invokestatic 756	com/tencent/mobileqq/troop/utils/TroopFileUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Z
    //   1984: ifeq -365 -> 1619
    //   1987: iload 9
    //   1989: istore 8
    //   1991: aload_1
    //   1992: getfield 289	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_c_of_type_Int	I
    //   1995: i2l
    //   1996: ldc2_w 757
    //   1999: ladd
    //   2000: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   2003: ldc2_w 286
    //   2006: ldiv
    //   2007: lcmp
    //   2008: ifge -389 -> 1619
    //   2011: iload 9
    //   2013: istore 8
    //   2015: aload_1
    //   2016: bipush 13
    //   2018: putfield 480	com/tencent/mobileqq/troop/data/TroopFileInfo:g	I
    //   2021: iload 9
    //   2023: istore 8
    //   2025: aload_0
    //   2026: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2029: aload_1
    //   2030: getfield 141	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   2033: aload_1
    //   2034: invokeinterface 150 3 0
    //   2039: pop
    //   2040: iload 9
    //   2042: istore 8
    //   2044: aload_0
    //   2045: getfield 76	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_JavaUtilMap	Ljava/util/Map;
    //   2048: aload_3
    //   2049: aload_1
    //   2050: invokeinterface 150 3 0
    //   2055: pop
    //   2056: iload 4
    //   2058: iconst_1
    //   2059: iadd
    //   2060: istore 4
    //   2062: goto -340 -> 1722
    //   2065: iload 9
    //   2067: istore 8
    //   2069: aload_1
    //   2070: aload 12
    //   2072: getfield 140	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   2075: putfield 141	com/tencent/mobileqq/troop/data/TroopFileInfo:jdField_a_of_type_JavaUtilUUID	Ljava/util/UUID;
    //   2078: iload 9
    //   2080: istore 8
    //   2082: aload_1
    //   2083: aload 12
    //   2085: aload_0
    //   2086: getfield 102	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2089: invokevirtual 144	com/tencent/mobileqq/troop/data/TroopFileInfo:a	(Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   2092: goto -160 -> 1932
    //   2095: iload 9
    //   2097: istore 8
    //   2099: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2102: ifeq +69 -> 2171
    //   2105: iload 9
    //   2107: istore 8
    //   2109: ldc 13
    //   2111: iconst_4
    //   2112: new 227	java/lang/StringBuilder
    //   2115: dup
    //   2116: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2119: ldc_w 760
    //   2122: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: iload 5
    //   2127: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2130: ldc_w 762
    //   2133: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: iload 4
    //   2138: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2141: ldc_w 764
    //   2144: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2147: aload_0
    //   2148: getfield 81	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2151: invokeinterface 765 1 0
    //   2156: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2159: ldc_w 767
    //   2162: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2168: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2171: iload 6
    //   2173: tableswitch	default:+27 -> 2200, 0:+33->2206, 1:+187->2360, 2:+358->2531
    //   2201: istore 8
    //   2203: goto -2181 -> 22
    //   2206: aload_0
    //   2207: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2210: ifne +65 -> 2275
    //   2213: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2216: ifeq +43 -> 2259
    //   2219: ldc 13
    //   2221: iconst_4
    //   2222: new 227	java/lang/StringBuilder
    //   2225: dup
    //   2226: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2229: ldc_w 695
    //   2232: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: aload_0
    //   2236: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2239: invokeinterface 698 1 0
    //   2244: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2247: ldc_w 700
    //   2250: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2256: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2259: aload_0
    //   2260: iconst_0
    //   2261: aload_0
    //   2262: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   2265: bipush 50
    //   2267: iload 7
    //   2269: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   2272: goto -72 -> 2200
    //   2275: aload_0
    //   2276: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   2279: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   2282: aload_0
    //   2283: invokevirtual 701	com/tencent/mobileqq/troop/utils/TroopFileManager:a	()Ljava/util/Collection;
    //   2286: astore_1
    //   2287: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2290: ifeq +58 -> 2348
    //   2293: ldc 13
    //   2295: iconst_4
    //   2296: new 227	java/lang/StringBuilder
    //   2299: dup
    //   2300: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2303: ldc_w 695
    //   2306: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: aload_0
    //   2310: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2313: invokeinterface 698 1 0
    //   2318: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2321: ldc_w 703
    //   2324: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2327: aload_1
    //   2328: invokeinterface 704 1 0
    //   2333: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2336: ldc_w 706
    //   2339: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2342: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2345: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2348: aload_0
    //   2349: aload_1
    //   2350: aload_0
    //   2351: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2354: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   2357: goto -157 -> 2200
    //   2360: aload_0
    //   2361: invokevirtual 701	com/tencent/mobileqq/troop/utils/TroopFileManager:a	()Ljava/util/Collection;
    //   2364: astore_1
    //   2365: aload_1
    //   2366: invokeinterface 709 1 0
    //   2371: ifeq +87 -> 2458
    //   2374: aload_0
    //   2375: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2378: ifne +80 -> 2458
    //   2381: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2384: ifeq +58 -> 2442
    //   2387: ldc 13
    //   2389: iconst_4
    //   2390: new 227	java/lang/StringBuilder
    //   2393: dup
    //   2394: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2397: ldc_w 711
    //   2400: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2403: aload_0
    //   2404: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2407: invokeinterface 698 1 0
    //   2412: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2415: ldc_w 703
    //   2418: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2421: aload_1
    //   2422: invokeinterface 704 1 0
    //   2427: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2430: ldc_w 700
    //   2433: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2439: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2442: aload_0
    //   2443: iconst_1
    //   2444: aload_0
    //   2445: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   2448: bipush 15
    //   2450: iload 7
    //   2452: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   2455: goto -255 -> 2200
    //   2458: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2461: ifeq +58 -> 2519
    //   2464: ldc 13
    //   2466: iconst_4
    //   2467: new 227	java/lang/StringBuilder
    //   2470: dup
    //   2471: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2474: ldc_w 711
    //   2477: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2480: aload_0
    //   2481: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2484: invokeinterface 698 1 0
    //   2489: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2492: ldc_w 703
    //   2495: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: aload_1
    //   2499: invokeinterface 704 1 0
    //   2504: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2507: ldc_w 706
    //   2510: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2513: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2516: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2519: aload_0
    //   2520: aload_1
    //   2521: aload_0
    //   2522: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2525: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   2528: goto -328 -> 2200
    //   2531: aload_0
    //   2532: iconst_0
    //   2533: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   2536: aload_0
    //   2537: getfield 81	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2540: invokeinterface 712 1 0
    //   2545: ifne +105 -> 2650
    //   2548: aload_0
    //   2549: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   2552: bipush 20
    //   2554: if_icmpge +96 -> 2650
    //   2557: aload_0
    //   2558: aload_0
    //   2559: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   2562: iconst_1
    //   2563: iadd
    //   2564: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   2567: aload_0
    //   2568: iconst_1
    //   2569: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   2572: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2575: ifeq +37 -> 2612
    //   2578: ldc 13
    //   2580: iconst_4
    //   2581: ldc_w 714
    //   2584: iconst_2
    //   2585: anewarray 509	java/lang/Object
    //   2588: dup
    //   2589: iconst_0
    //   2590: aload_0
    //   2591: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   2594: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2597: aastore
    //   2598: dup
    //   2599: iconst_1
    //   2600: bipush 20
    //   2602: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2605: aastore
    //   2606: invokestatic 583	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2609: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2612: aload_0
    //   2613: getfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   2616: ifne +8 -> 2624
    //   2619: iload 9
    //   2621: ifeq +13 -> 2634
    //   2624: aload_0
    //   2625: aconst_null
    //   2626: putfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   2629: aload_0
    //   2630: iconst_0
    //   2631: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   2634: aload_0
    //   2635: iconst_2
    //   2636: aload_0
    //   2637: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   2640: bipush 10
    //   2642: iload 7
    //   2644: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   2647: goto -447 -> 2200
    //   2650: aload_0
    //   2651: iconst_0
    //   2652: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   2655: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2658: ifeq -458 -> 2200
    //   2661: ldc 13
    //   2663: iconst_4
    //   2664: ldc_w 716
    //   2667: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2670: goto -470 -> 2200
    //   2673: aload_0
    //   2674: lconst_0
    //   2675: putfield 525	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_d_of_type_Long	J
    //   2678: aload_0
    //   2679: aconst_null
    //   2680: iconst_0
    //   2681: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   2684: goto -1144 -> 1540
    //   2687: aload_0
    //   2688: lconst_0
    //   2689: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   2692: aload_0
    //   2693: aconst_null
    //   2694: iconst_0
    //   2695: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   2698: goto -1158 -> 1540
    //   2701: aload_0
    //   2702: iconst_0
    //   2703: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   2706: aload_0
    //   2707: iconst_0
    //   2708: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   2711: goto -1171 -> 1540
    //   2714: aload_0
    //   2715: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2718: ifne +65 -> 2783
    //   2721: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2724: ifeq +43 -> 2767
    //   2727: ldc 13
    //   2729: iconst_4
    //   2730: new 227	java/lang/StringBuilder
    //   2733: dup
    //   2734: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2737: ldc_w 695
    //   2740: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2743: aload_0
    //   2744: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2747: invokeinterface 698 1 0
    //   2752: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2755: ldc_w 700
    //   2758: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2761: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2764: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2767: aload_0
    //   2768: iconst_0
    //   2769: aload_0
    //   2770: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   2773: bipush 50
    //   2775: iload 7
    //   2777: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   2780: goto -1240 -> 1540
    //   2783: aload_0
    //   2784: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   2787: putfield 528	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Long	J
    //   2790: aload_0
    //   2791: invokevirtual 701	com/tencent/mobileqq/troop/utils/TroopFileManager:a	()Ljava/util/Collection;
    //   2794: astore_2
    //   2795: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2798: ifeq +58 -> 2856
    //   2801: ldc 13
    //   2803: iconst_4
    //   2804: new 227	java/lang/StringBuilder
    //   2807: dup
    //   2808: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2811: ldc_w 695
    //   2814: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2817: aload_0
    //   2818: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2821: invokeinterface 698 1 0
    //   2826: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2829: ldc_w 703
    //   2832: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2835: aload_2
    //   2836: invokeinterface 704 1 0
    //   2841: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2844: ldc_w 706
    //   2847: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2850: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2853: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2856: aload_0
    //   2857: aload_2
    //   2858: aload_0
    //   2859: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2862: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   2865: goto -1325 -> 1540
    //   2868: aload_0
    //   2869: invokevirtual 701	com/tencent/mobileqq/troop/utils/TroopFileManager:a	()Ljava/util/Collection;
    //   2872: astore_2
    //   2873: aload_2
    //   2874: invokeinterface 709 1 0
    //   2879: ifeq +87 -> 2966
    //   2882: aload_0
    //   2883: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   2886: ifne +80 -> 2966
    //   2889: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2892: ifeq +58 -> 2950
    //   2895: ldc 13
    //   2897: iconst_4
    //   2898: new 227	java/lang/StringBuilder
    //   2901: dup
    //   2902: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2905: ldc_w 711
    //   2908: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2911: aload_0
    //   2912: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2915: invokeinterface 698 1 0
    //   2920: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2923: ldc_w 703
    //   2926: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: aload_2
    //   2930: invokeinterface 704 1 0
    //   2935: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2938: ldc_w 700
    //   2941: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2944: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2947: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2950: aload_0
    //   2951: iconst_1
    //   2952: aload_0
    //   2953: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   2956: bipush 15
    //   2958: iload 7
    //   2960: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   2963: goto -1423 -> 1540
    //   2966: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2969: ifeq +58 -> 3027
    //   2972: ldc 13
    //   2974: iconst_4
    //   2975: new 227	java/lang/StringBuilder
    //   2978: dup
    //   2979: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   2982: ldc_w 711
    //   2985: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2988: aload_0
    //   2989: getfield 74	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   2992: invokeinterface 698 1 0
    //   2997: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3000: ldc_w 703
    //   3003: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3006: aload_2
    //   3007: invokeinterface 704 1 0
    //   3012: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3015: ldc_w 706
    //   3018: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3024: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3027: aload_0
    //   3028: aload_2
    //   3029: aload_0
    //   3030: getfield 522	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_Boolean	Z
    //   3033: invokevirtual 661	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/util/Collection;Z)V
    //   3036: goto -1496 -> 1540
    //   3039: aload_0
    //   3040: iconst_0
    //   3041: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   3044: aload_0
    //   3045: getfield 81	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   3048: invokeinterface 712 1 0
    //   3053: ifne +105 -> 3158
    //   3056: aload_0
    //   3057: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   3060: bipush 20
    //   3062: if_icmpge +96 -> 3158
    //   3065: aload_0
    //   3066: aload_0
    //   3067: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   3070: iconst_1
    //   3071: iadd
    //   3072: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   3075: aload_0
    //   3076: iconst_1
    //   3077: putfield 501	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_Boolean	Z
    //   3080: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3083: ifeq +37 -> 3120
    //   3086: ldc 13
    //   3088: iconst_4
    //   3089: ldc_w 714
    //   3092: iconst_2
    //   3093: anewarray 509	java/lang/Object
    //   3096: dup
    //   3097: iconst_0
    //   3098: aload_0
    //   3099: getfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   3102: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3105: aastore
    //   3106: dup
    //   3107: iconst_1
    //   3108: bipush 20
    //   3110: invokestatic 579	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3113: aastore
    //   3114: invokestatic 583	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3117: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3120: aload_0
    //   3121: getfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   3124: ifne +8 -> 3132
    //   3127: iload 8
    //   3129: ifeq +13 -> 3142
    //   3132: aload_0
    //   3133: aconst_null
    //   3134: putfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   3137: aload_0
    //   3138: iconst_0
    //   3139: putfield 506	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_c_of_type_Boolean	Z
    //   3142: aload_0
    //   3143: iconst_2
    //   3144: aload_0
    //   3145: getfield 621	com/tencent/mobileqq/troop/utils/TroopFileManager:jdField_b_of_type_ComTencentMobileqqTroopUtilsTroopFileManager$FileTimestamp	Lcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;
    //   3148: bipush 10
    //   3150: iload 7
    //   3152: invokevirtual 504	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(ILcom/tencent/mobileqq/troop/utils/TroopFileManager$FileTimestamp;II)V
    //   3155: goto -1615 -> 1540
    //   3158: aload_0
    //   3159: iconst_0
    //   3160: putfield 502	com/tencent/mobileqq/troop/utils/TroopFileManager:g	I
    //   3163: invokestatic 225	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3166: ifeq -1626 -> 1540
    //   3169: ldc 13
    //   3171: iconst_4
    //   3172: ldc_w 716
    //   3175: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3178: goto -1638 -> 1540
    //   3181: astore_1
    //   3182: iconst_1
    //   3183: istore 4
    //   3185: iconst_0
    //   3186: istore 8
    //   3188: goto -1689 -> 1499
    //   3191: iload 6
    //   3193: tableswitch	default:+27 -> 3220, 0:+-3060->133, 1:+-3041->152, 2:+-3027->166
    //   3221: <illegal opcode>
    //   3222: ixor
    //   3223: iload 6
    //   3225: tableswitch	default:+27 -> 3252, 0:+-2978->247, 1:+-2883->342, 2:+-2869->356
    //   3253: <illegal opcode>
    //   3254: fadd
    //   3255: iload 6
    //   3257: tableswitch	default:+27 -> 3284, 0:+-2956->301, 1:+-2942->315, 2:+-2928->329
    //   3285: <illegal opcode>
    //   3286: lstore_3
    //   3287: iload 6
    //   3289: tableswitch	default:+27 -> 3316, 0:+-2831->458, 1:+-2817->472, 2:+-2803->486
    //   3317: <illegal opcode>
    //   3318: fload_0
    //   3319: iload 6
    //   3321: tableswitch	default:+27 -> 3348, 0:+-2768->553, 1:+-2754->567, 2:+-2740->581
    //   3349: <illegal opcode>
    //   3350: iconst_m1
    //   3351: iload 6
    //   3353: tableswitch	default:+27 -> 3380, 0:+-2708->645, 1:+-2694->659, 2:+-2680->673
    //   3381: <illegal opcode>
    //   3382: <illegal opcode>
    //   3383: iload 6
    //   3385: tableswitch	default:+27 -> 3412, 0:+-698->2687, 1:+-712->2673, 2:+-684->2701
    //   3413: <illegal opcode>
    //   3414: areturn
    //   3415: iload 6
    //   3417: tableswitch	default:+27 -> 3444, 0:+-1579->1838, 1:+-1579->1838, 2:+-1557->1860
    //   3445: lconst_1
    //   3446: istore 9
    //   3448: goto -1846 -> 1602
    //   3451: goto -1832 -> 1619
    //   3454: iload 6
    //   3456: tableswitch	default:+28 -> 3484, 0:+-742->2714, 1:+-588->2868, 2:+-417->3039
    //   3485: <illegal opcode>
    //   3486: imul
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3487	0	this	TroopFileManager
    //   0	3487	1	paramToServiceMsg	ToServiceMsg
    //   0	3487	2	paramFromServiceMsg	FromServiceMsg
    //   0	3487	3	paramObject	Object
    //   376	2808	4	i1	int
    //   1603	523	5	i2	int
    //   47	3408	6	i3	int
    //   59	3092	7	i4	int
    //   12	3175	8	bool1	boolean
    //   77	3370	9	bool2	boolean
    //   74	3371	10	bool3	boolean
    //   87	3	11	bool4	boolean
    //   1448	636	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	147	finally
    //   27	73	147	finally
    //   97	130	147	finally
    //   133	144	147	finally
    //   152	163	147	finally
    //   166	176	147	finally
    //   211	244	147	finally
    //   247	258	147	finally
    //   265	298	147	finally
    //   301	312	147	finally
    //   315	326	147	finally
    //   329	339	147	finally
    //   342	353	147	finally
    //   356	366	147	finally
    //   422	455	147	finally
    //   458	469	147	finally
    //   472	483	147	finally
    //   486	496	147	finally
    //   517	550	147	finally
    //   553	564	147	finally
    //   567	578	147	finally
    //   581	591	147	finally
    //   609	642	147	finally
    //   645	656	147	finally
    //   659	670	147	finally
    //   673	683	147	finally
    //   839	892	147	finally
    //   892	905	147	finally
    //   912	985	147	finally
    //   985	994	147	finally
    //   1001	1083	147	finally
    //   1083	1096	147	finally
    //   1103	1164	147	finally
    //   1164	1173	147	finally
    //   1180	1261	147	finally
    //   1261	1268	147	finally
    //   1268	1281	147	finally
    //   1288	1298	147	finally
    //   1301	1306	147	finally
    //   1310	1325	147	finally
    //   1504	1537	147	finally
    //   1540	1542	147	finally
    //   2206	2259	147	finally
    //   2259	2272	147	finally
    //   2275	2348	147	finally
    //   2348	2357	147	finally
    //   2360	2442	147	finally
    //   2442	2455	147	finally
    //   2458	2519	147	finally
    //   2519	2528	147	finally
    //   2531	2612	147	finally
    //   2612	2619	147	finally
    //   2624	2634	147	finally
    //   2634	2647	147	finally
    //   2650	2670	147	finally
    //   2673	2684	147	finally
    //   2687	2698	147	finally
    //   2701	2711	147	finally
    //   2714	2767	147	finally
    //   2767	2780	147	finally
    //   2783	2856	147	finally
    //   2856	2865	147	finally
    //   2868	2950	147	finally
    //   2950	2963	147	finally
    //   2966	3027	147	finally
    //   3027	3036	147	finally
    //   3039	3120	147	finally
    //   3120	3127	147	finally
    //   3132	3142	147	finally
    //   3142	3155	147	finally
    //   3158	3178	147	finally
    //   195	204	261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   701	708	1495	finally
    //   712	732	1495	finally
    //   736	759	1495	finally
    //   763	777	1495	finally
    //   781	787	1495	finally
    //   791	800	1495	finally
    //   1336	1347	1495	finally
    //   1351	1358	1495	finally
    //   1362	1367	1495	finally
    //   1371	1376	1495	finally
    //   1380	1385	1495	finally
    //   1389	1398	1495	finally
    //   1402	1411	1495	finally
    //   1415	1422	1495	finally
    //   1426	1435	1495	finally
    //   1439	1450	1495	finally
    //   1454	1471	1495	finally
    //   1475	1492	1495	finally
    //   1546	1557	1495	finally
    //   1561	1578	1495	finally
    //   1582	1599	1495	finally
    //   1612	1619	1495	finally
    //   1623	1632	1495	finally
    //   1636	1647	1495	finally
    //   1651	1660	1495	finally
    //   1664	1675	1495	finally
    //   1679	1693	1495	finally
    //   1701	1707	1495	finally
    //   1711	1716	1495	finally
    //   1726	1733	1495	finally
    //   1737	1751	1495	finally
    //   1755	1769	1495	finally
    //   1773	1790	1495	finally
    //   1794	1805	1495	finally
    //   1809	1820	1495	finally
    //   1824	1835	1495	finally
    //   1842	1853	1495	finally
    //   1864	1873	1495	finally
    //   1880	1890	1495	finally
    //   1894	1904	1495	finally
    //   1913	1920	1495	finally
    //   1924	1932	1495	finally
    //   1936	1948	1495	finally
    //   1952	1969	1495	finally
    //   1973	1987	1495	finally
    //   1991	2011	1495	finally
    //   2015	2021	1495	finally
    //   2025	2040	1495	finally
    //   2044	2056	1495	finally
    //   2069	2078	1495	finally
    //   2082	2092	1495	finally
    //   2099	2105	1495	finally
    //   2109	2171	1495	finally
    //   83	89	3181	finally
    //   179	195	3181	finally
    //   195	204	3181	finally
    //   369	408	3181	finally
    //   499	510	3181	finally
    //   594	602	3181	finally
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, new Object[] { paramTroopFileInfo }).sendToTarget();
  }
  
  public final boolean d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    for (;;)
    {
      int i1;
      int i2;
      try
      {
        boolean bool2 = "GroupFileAppSvr.GetFileList".equals(paramFromServiceMsg.getServiceCmd());
        if (!bool2) {
          return bool1;
        }
        this.f -= 1;
        i1 = paramToServiceMsg.extraData.getInt("reqFor");
        if (paramObject == null) {
          break label293;
        }
        try
        {
          if (!paramFromServiceMsg.isSuccess()) {
            break label293;
          }
          paramToServiceMsg = (byte[])paramObject;
          paramFromServiceMsg = new cmd0x383.RspBody();
          try
          {
            paramToServiceMsg = (cmd0x383.RspBody)paramFromServiceMsg.mergeFrom(paramToServiceMsg);
            if (paramToServiceMsg != null) {
              continue;
            }
            bool1 = true;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            bool1 = true;
          }
          continue;
        }
        finally {}
        i2 = paramToServiceMsg.int32_ret_code.get();
        if (!QLog.isDevelopLevel()) {
          break label299;
        }
        QLog.e("TroopFileManager", 4, "onRspFileList - retCode: " + i2);
      }
      finally {}
      paramToServiceMsg = (cmd0x383.ApplyGetFileListRspBody)paramToServiceMsg.msg_get_file_list_rsp_body.get();
      if (paramToServiceMsg == null)
      {
        bool1 = true;
      }
      else
      {
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_file_info_list.get();
        if (paramFromServiceMsg == null)
        {
          bool1 = true;
        }
        else
        {
          bool1 = paramToServiceMsg.bool_is_end.get();
          this.p = paramToServiceMsg.uint32_all_file_count.get();
          a(this.p);
          if ((!bool1) && (paramFromServiceMsg.size() == 0))
          {
            bool1 = true;
          }
          else if (i1 == 3)
          {
            if (paramFromServiceMsg.size() > 0) {
              d(new TroopFileInfo((cmd0x383.ApplyGetFileListRspBody.FileInfo)paramFromServiceMsg.get(0)));
            }
            bool1 = true;
          }
          else
          {
            bool1 = true;
            continue;
            label293:
            bool1 = true;
            continue;
            label299:
            if (i2 < 0)
            {
              if (i2 == -1) {}
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).a(paramTroopFileInfo);
    }
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).b(paramTroopFileInfo);
    }
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileObserver)localIterator.next()).c(paramTroopFileInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager
 * JD-Core Version:    0.7.0.1
 */