package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import fxn;
import fxo;
import fxp;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManagerProxy
  extends BaseProxy
{
  public static final int a = 30;
  private static final String jdField_a_of_type_JavaLangString = "FileManagerProxy<FileAssistant>";
  SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = null;
  private List b = null;
  
  public FileManagerProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = TableBuilder.a(paramEntity.getClass()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Field)localIterator.next();
      String str = ((Field)localObject1).getName();
      if (!((Field)localObject1).isAccessible()) {
        ((Field)localObject1).setAccessible(true);
      }
      Object localObject3;
      try
      {
        localObject1 = ((Field)localObject1).get(paramEntity);
        if ((localObject1 instanceof Integer)) {
          localContentValues.put(str, (Integer)localObject1);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          localIllegalArgumentException.printStackTrace();
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
          localObject3 = null;
        }
        if ((localObject3 instanceof Long))
        {
          localContentValues.put(str, (Long)localObject3);
          continue;
        }
        if ((localObject3 instanceof String))
        {
          localContentValues.put(str, (String)localObject3);
          continue;
        }
        if ((localObject3 instanceof byte[]))
        {
          localContentValues.put(str, (byte[])localObject3);
          continue;
        }
        if ((localObject3 instanceof Short))
        {
          localContentValues.put(str, (Short)localObject3);
          continue;
        }
        if ((localObject3 instanceof Boolean))
        {
          localContentValues.put(str, (Boolean)localObject3);
          continue;
        }
        if ((localObject3 instanceof Double))
        {
          localContentValues.put(str, (Double)localObject3);
          continue;
        }
        if ((localObject3 instanceof Float)) {
          localContentValues.put(str, (Float)localObject3);
        }
      }
      if ((localObject3 instanceof Byte)) {
        localContentValues.put(str, (Byte)localObject3);
      }
    }
    return localContentValues;
  }
  
  private boolean a(int paramInt)
  {
    for (;;)
    {
      boolean bool;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.b == null) {
          a();
        }
        int i = this.b.size();
        if (i == 0)
        {
          bool = false;
          return bool;
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " where srvTime <= " + String.valueOf(((FileManagerEntity)this.b.get(this.b.size() - 1)).srvTime) + " and " + " nSessionId != " + String.valueOf(((FileManagerEntity)this.b.get(this.b.size() - 1)).nSessionId) + " and bDelInFM = 0  order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(FileManagerEntity.class, (String)localObject1, null);
        if (localObject1 == null)
        {
          bool = false;
          continue;
        }
        if (((List)localObject1).size() == 0)
        {
          bool = false;
          continue;
        }
        List localList = FileCategoryUtil.d(BaseApplicationImpl.getContext());
        Iterator localIterator1 = ((List)localObject1).iterator();
        if (!localIterator1.hasNext()) {
          break label421;
        }
        localFileManagerEntity = (FileManagerEntity)localIterator1.next();
        if ((localFileManagerEntity.nFileType == 5) && (localFileManagerEntity.cloudType == 3) && (!FileUtil.a(localFileManagerEntity.strFilePath)) && (localFileManagerEntity.strApkPackageName != null) && (localFileManagerEntity.strApkPackageName.length() > 0))
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)localIterator2.next();
            if (!localFileManagerEntity.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName)) {
              continue;
            }
            localFileManagerEntity.strFilePath = localPackageInfo.applicationInfo.publicSourceDir;
            continue;
          }
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)) != null) {
          break label391;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      label391:
      this.b.add(this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)));
      continue;
      label421:
      paramInt = localObject2.size();
      if (paramInt < 30) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.b == null) {
      a();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramLong3), paramInt);
    Object localObject2 = new StringBuilder().append("------->FileManager findUinSeqForCache :msgIsTroop:").append(paramInt).append(",peerUin:").append(FileManagerUtil.e(String.valueOf(paramLong3))).append(",list size:");
    int i;
    if (localObject1 == null)
    {
      i = 0;
      QLog.i("FileManagerProxy<FileAssistant>", 1, i);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((((MessageRecord)localObject2).msgUid != 0L) && (((MessageRecord)localObject2).msgUid == paramLong4))
          {
            return ((MessageRecord)localObject2).uniseq;
            i = ((List)localObject1).size();
            break;
          }
          if ((Math.abs(((MessageRecord)localObject2).time - paramLong2) < 30L) && (((MessageRecord)localObject2).shmsgseq == paramLong1) && (((MessageRecord)localObject2).senderuin.equals(Long.valueOf(paramLong3))))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
            }
            return ((MessageRecord)localObject2).uniseq;
          }
        }
      }
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if ((((FileManagerEntity)localObject2).peerType == paramInt) && (((FileManagerEntity)localObject2).msgSeq == paramLong1) && (((FileManagerEntity)localObject2).msgUid == paramLong4) && (((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(Long.valueOf(paramLong3)))) {
        return ((FileManagerEntity)localObject2).uniseq;
      }
    }
    return -1L;
  }
  
  /* Error */
  public FileManagerEntity a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 136	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   17: invokeinterface 56 1 0
    //   22: astore 6
    //   24: aload 6
    //   26: invokeinterface 62 1 0
    //   31: ifeq +32 -> 63
    //   34: aload 6
    //   36: invokeinterface 66 1 0
    //   41: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 174	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   51: lstore_3
    //   52: lload_3
    //   53: lload_1
    //   54: lcmp
    //   55: ifne -31 -> 24
    //   58: aload_0
    //   59: monitorexit
    //   60: aload 5
    //   62: areturn
    //   63: aload_0
    //   64: getfield 23	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   67: lload_1
    //   68: invokestatic 255	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: invokeinterface 258 2 0
    //   76: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   79: astore 5
    //   81: goto -23 -> 58
    //   84: astore 5
    //   86: aload_0
    //   87: monitorexit
    //   88: aload 5
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	FileManagerProxy
    //   0	91	1	paramLong	long
    //   51	2	3	l	long
    //   44	36	5	localFileManagerEntity	FileManagerEntity
    //   84	5	5	localObject	Object
    //   22	13	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	84	finally
    //   13	24	84	finally
    //   24	52	84	finally
    //   63	81	84	finally
  }
  
  /* Error */
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: ldc2_w 339
    //   6: lcmp
    //   7: ifeq +18 -> 25
    //   10: aload_3
    //   11: ifnull +14 -> 25
    //   14: aload_3
    //   15: invokevirtual 235	java/lang/String:length	()I
    //   18: istore 5
    //   20: iload 5
    //   22: ifne +9 -> 31
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: areturn
    //   31: aload_0
    //   32: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   35: ifnonnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 136	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   42: aload_0
    //   43: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   46: invokeinterface 56 1 0
    //   51: astore 7
    //   53: aload 7
    //   55: invokeinterface 62 1 0
    //   60: ifeq +51 -> 111
    //   63: aload 7
    //   65: invokeinterface 66 1 0
    //   70: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   73: astore 6
    //   75: aload 6
    //   77: getfield 337	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   80: ifnull -27 -> 53
    //   83: aload 6
    //   85: getfield 338	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   88: lload_1
    //   89: lcmp
    //   90: ifne -37 -> 53
    //   93: aload 6
    //   95: getfield 337	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   98: aload_3
    //   99: invokevirtual 320	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq -49 -> 53
    //   105: aload 6
    //   107: astore_3
    //   108: goto -81 -> 27
    //   111: aload_0
    //   112: getfield 23	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: invokeinterface 346 1 0
    //   120: invokeinterface 349 1 0
    //   125: astore 7
    //   127: aload 7
    //   129: invokeinterface 62 1 0
    //   134: ifeq +81 -> 215
    //   137: aload 7
    //   139: invokeinterface 66 1 0
    //   144: checkcast 95	java/lang/Long
    //   147: astore 6
    //   149: aload_0
    //   150: getfield 23	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   153: aload 6
    //   155: invokeinterface 258 2 0
    //   160: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   163: astore 6
    //   165: aload 6
    //   167: getfield 338	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   170: lload_1
    //   171: lcmp
    //   172: ifne -45 -> 127
    //   175: aload 6
    //   177: getfield 337	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   180: ifnull -53 -> 127
    //   183: aload 6
    //   185: getfield 337	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   188: aload_3
    //   189: invokevirtual 320	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifeq -65 -> 127
    //   195: aload 6
    //   197: getfield 330	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerType	I
    //   200: istore 5
    //   202: iload 4
    //   204: iload 5
    //   206: if_icmpne -79 -> 127
    //   209: aload 6
    //   211: astore_3
    //   212: goto -185 -> 27
    //   215: aconst_null
    //   216: astore_3
    //   217: goto -190 -> 27
    //   220: astore_3
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_3
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	FileManagerProxy
    //   0	225	1	paramLong	long
    //   0	225	3	paramString	String
    //   0	225	4	paramInt	int
    //   18	189	5	i	int
    //   73	137	6	localObject	Object
    //   51	87	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   14	20	220	finally
    //   31	42	220	finally
    //   42	53	220	finally
    //   53	105	220	finally
    //   111	127	220	finally
    //   127	202	220	finally
  }
  
  public FileManagerEntity a(String paramString)
  {
    if (this.b == null) {
      a();
    }
    Iterator localIterator = this.b.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (FileManagerEntity)localIterator.next();
      if ((((FileManagerEntity)localObject).strFilePath != null) && (((FileManagerEntity)localObject).strFilePath.equalsIgnoreCase(paramString))) {
        return localObject;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Long)localIterator.next();
      localObject = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      if ((((FileManagerEntity)localObject).strFilePath != null) && (((FileManagerEntity)localObject).strFilePath.equalsIgnoreCase(paramString))) {
        return localObject;
      }
    }
    return null;
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    for (;;)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.b == null) {
          a();
        }
        if ((paramString == null) || (paramLong <= 0L))
        {
          localObject = null;
          return localObject;
        }
        localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              continue;
            }
          }
          if ((0L != localFileManagerEntity.nOLfileSessionId) || (paramLong != localFileManagerEntity.nSessionId) || (!paramString.equalsIgnoreCase(localFileManagerEntity.peerUin))) {
            continue;
          }
          localFileManagerEntity.nOLfileSessionId = paramLong;
          d(localFileManagerEntity);
          localObject = localFileManagerEntity;
          continue;
        }
        localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      }
      finally {}
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              break;
            }
          }
          if ((0L == localFileManagerEntity.nOLfileSessionId) && (paramLong == localFileManagerEntity.nSessionId) && (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)))
          {
            localFileManagerEntity.nOLfileSessionId = paramLong;
            d(localFileManagerEntity);
            localObject = localFileManagerEntity;
            break;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public List a()
  {
    if ((this.b == null) || (this.b.isEmpty())) {
      a();
    }
    return this.b;
  }
  
  protected void a()
  {
    if (this.b != null) {
      return;
    }
    Object localObject = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0 " + " order by srvTime desc limit " + 30 + ") order by srvTime desc";
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.b = localEntityManager.a(FileManagerEntity.class, (String)localObject, null);
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "init , buf fmList is null,maybe is not data!,sql[" + (String)localObject + "]");
      }
      this.b = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilMap == null)
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      localObject = this.b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        FileManagerUtil.a(localFileManagerEntity);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      }
    }
    localEntityManager.a();
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramString == null) || (paramLong1 < 0L) || (paramLong2 <= 0L)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 30) {
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    fxp localfxp = new fxp(this);
    localfxp.jdField_a_of_type_Long = paramLong1;
    localfxp.jdField_a_of_type_JavaLangString = paramString;
    localfxp.b = paramLong2;
    this.jdField_a_of_type_JavaUtilList.add(localfxp);
    QLog.i("FileManagerProxy<FileAssistant>", 1, "saveDeletedEntity nSessionId=" + paramLong1 + " nOlSessionId=" + paramLong2);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      a();
      FileManagerUtil.a(paramFileManagerEntity);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.status = paramInt;
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramInt));
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, float paramFloat)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "entity is null!");
      }
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramInt));
    localContentValues.put("fProgress", Float.valueOf(paramFloat));
    a(paramFileManagerEntity.getTableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ProxyListener paramProxyListener)
  {
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      try
      {
        paramProxyListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (paramProxyListener == null) {
          return;
        }
        localFileManagerEntity = new FileManagerEntity();
        paramFileManagerEntity.nFileType = FileManagerUtil.a(paramFileManagerEntity.fileName);
        localFileManagerEntity.copyFrom(paramFileManagerEntity);
        localFileManagerEntity.nSessionId = paramFileManagerEntity.nSessionId;
        localFileManagerEntity.bSend = paramFileManagerEntity.bSend;
        localFileManagerEntity.bDelInAio = paramFileManagerEntity.bDelInAio;
        localFileManagerEntity.bDelInFM = paramFileManagerEntity.bDelInFM;
        if ((localFileManagerEntity.status != -1) && (!localFileManagerEntity.bSend) && (localFileManagerEntity.status != 4)) {
          localFileManagerEntity.status = 0;
        }
        if ((localFileManagerEntity.status == 2) || (localFileManagerEntity.status == 18)) {
          localFileManagerEntity.status = 0;
        }
        if (localFileManagerEntity.getStatus() == 1000)
        {
          paramProxyListener.a(localFileManagerEntity);
          paramFileManagerEntity.setId(localFileManagerEntity.getId());
          paramFileManagerEntity.setStatus(localFileManagerEntity.getStatus());
          continue;
        }
        if (localFileManagerEntity.getStatus() != 1001) {
          break label184;
        }
      }
      finally {}
      paramProxyListener.a(localFileManagerEntity);
      continue;
      label184:
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "FileManagerEntity status[" + String.valueOf(localFileManagerEntity.getStatus()) + "] is wrong");
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.strFilePath = paramString;
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("strFilePath", paramString);
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2;
    try
    {
      if (this.b == null) {
        a();
      }
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
        {
          ((FileManagerEntity)localObject2).uniseq = -1L;
          ((FileManagerEntity)localObject2).bDelInAio = true;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    finally {}
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
      {
        ((FileManagerEntity)localObject2).uniseq = -1L;
        ((FileManagerEntity)localObject2).bDelInAio = true;
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("bDelInAio", Boolean.valueOf(true));
    ((ContentValues)localObject1).put("uniseq", Integer.valueOf(-1));
    a(FileManagerEntity.tableName(), (ContentValues)localObject1, " peerUin = ? and peerType = ? ", new String[] { paramString, String.valueOf(paramInt) }, null);
    a(FileManagerEntity.tableName(), " bDelInAio = ? and bDelInFM = ? ", new String[] { String.valueOf(1), String.valueOf(1) }, null);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public boolean a()
  {
    return a(30);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (((fxp)localIterator.next()).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFileManagerEntity == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "if item is null, why can choose???!!!");
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager() != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.uniseq);
        if ((paramFileManagerEntity.bDelInAio) && (paramFileManagerEntity.bDelInFM) && (localObject == null))
        {
          a(FileManagerEntity.tableName(), "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          this.b.remove(paramFileManagerEntity);
          this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramFileManagerEntity.nSessionId));
          QLog.i("FileManagerProxy<FileAssistant>", 1, "Delete FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for memory and db:" + FileManagerUtil.a(paramFileManagerEntity));
          a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.nOLfileSessionId);
          bool1 = a(1);
        }
        else
        {
          if (localObject != null) {
            paramFileManagerEntity.bDelInAio = false;
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("bDelInAio", Boolean.valueOf(paramFileManagerEntity.bDelInAio));
          ((ContentValues)localObject).put("bDelInFM", Boolean.valueOf(paramFileManagerEntity.bDelInFM));
          ((ContentValues)localObject).put("uniseq", Long.valueOf(paramFileManagerEntity.uniseq));
          a(FileManagerEntity.tableName(), (ContentValues)localObject, "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Update FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for db:" + FileManagerUtil.a(paramFileManagerEntity));
          }
          if (paramFileManagerEntity.bDelInFM) {
            this.b.remove(paramFileManagerEntity);
          }
          bool1 = a(1);
        }
      }
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      fxp localfxp = (fxp)localIterator.next();
      if ((localfxp.b == paramLong) && (localfxp.jdField_a_of_type_JavaLangString != null) && (localfxp.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    Object localObject = null;
    for (;;)
    {
      long l;
      try
      {
        paramString = "select * from " + FileManagerEntity.tableName() + " where uniseq = " + String.valueOf(paramLong);
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localEntityManager == null)
        {
          paramString = localObject;
          if (QLog.isColorLevel())
          {
            QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
            paramString = localObject;
          }
          return paramString;
        }
        paramLong = System.currentTimeMillis();
        paramString = localEntityManager.a(FileManagerEntity.class, paramString, null);
        l = System.currentTimeMillis();
        if (paramString == null)
        {
          paramString = localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
          paramString = localObject;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label190;
        }
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(paramLong) + "], overTime[" + String.valueOf(l) + "]");
      label190:
      if ((paramString.size() > 1) && (QLog.isColorLevel())) {
        QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(paramString.size()) + "] over 1?");
      }
      paramString = (FileManagerEntity)paramString.get(0);
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramString.nSessionId), paramString);
      FileCategoryUtil.a(paramString);
    }
  }
  
  protected void b() {}
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      Looper localLooper;
      try
      {
        a(paramFileManagerEntity);
        localLooper = Looper.getMainLooper();
        Thread localThread1 = Thread.currentThread();
        Thread localThread2 = localLooper.getThread();
        if (localThread1 == localThread2)
        {
          try
          {
            if (!paramFileManagerEntity.bDelInFM) {
              c(paramFileManagerEntity);
            }
            a(paramFileManagerEntity, null);
          }
          catch (Exception paramFileManagerEntity)
          {
            paramFileManagerEntity.printStackTrace();
            continue;
          }
          return;
        }
      }
      finally {}
      new Handler(localLooper).post(new fxn(this, paramFileManagerEntity));
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   18: invokeinterface 140 1 0
    //   23: iconst_1
    //   24: isub
    //   25: istore_1
    //   26: iload_1
    //   27: bipush 30
    //   29: if_icmplt -18 -> 11
    //   32: aload_0
    //   33: getfield 21	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   36: iload_1
    //   37: invokeinterface 389 2 0
    //   42: pop
    //   43: iload_1
    //   44: iconst_1
    //   45: isub
    //   46: istore_1
    //   47: goto -21 -> 26
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	FileManagerProxy
    //   25	22	1	i	int
    //   6	2	2	localList	List
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	26	50	finally
    //   32	43	50	finally
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        if (this.b == null) {
          a();
        }
        if ((!this.b.contains(paramFileManagerEntity)) || (!QLog.isColorLevel())) {
          break label257;
        }
        QLog.e("FileManagerProxy<FileAssistant>", 2, "!!!!!!!!!!!fmList has one!!!!!!!!!!!!");
      }
      finally {}
      if (i < this.b.size())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.b.get(i);
        if (paramFileManagerEntity.srvTime >= localFileManagerEntity.srvTime)
        {
          this.b.add(i, paramFileManagerEntity);
          bool = true;
          if (!bool)
          {
            if (this.b.size() == 0) {
              this.b.add(0, paramFileManagerEntity);
            }
          }
          else
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 4, "insertToList, is add" + bool + " entityInfo:" + FileManagerUtil.a(paramFileManagerEntity));
            }
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
            if (this.b.size() > 30) {
              this.b.remove(this.b.size() - 1);
            }
          }
        }
        else
        {
          i += 1;
          continue;
        }
        this.b.add(paramFileManagerEntity);
      }
      else
      {
        bool = false;
        continue;
        label257:
        i = 0;
      }
    }
  }
  
  public void d()
  {
    Object localObject2 = this.b.iterator();
    for (Object localObject1 = null; ((Iterator)localObject2).hasNext(); localObject1 = ((FileManagerEntity)localObject1).getTableName())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      ((FileManagerEntity)localObject1).isReaded = true;
    }
    if (localObject1 != null)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isReaded", Boolean.valueOf(true));
      a((String)localObject1, (ContentValues)localObject2, "isReaded=?", new String[] { "0" }, null);
    }
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    FileManagerUtil.a(paramFileManagerEntity);
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "updateFileEntity, Error : entity is null!!!");
      }
      return;
    }
    int i = paramFileManagerEntity.status;
    if (i == 2) {
      paramFileManagerEntity.status = 0;
    }
    ContentValues localContentValues = a(paramFileManagerEntity);
    paramFileManagerEntity.status = i;
    long l = paramFileManagerEntity.nSessionId;
    paramFileManagerEntity = Looper.getMainLooper();
    if (Thread.currentThread() == paramFileManagerEntity.getThread()) {
      try
      {
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(l) }, null);
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramFileManagerEntity.printStackTrace();
        return;
      }
    }
    new Handler(paramFileManagerEntity).post(new fxo(this, localContentValues, l));
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 23	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   18: invokeinterface 646 1 0
    //   23: invokeinterface 349 1 0
    //   28: astore_3
    //   29: aload_3
    //   30: invokeinterface 62 1 0
    //   35: ifeq -24 -> 11
    //   38: aload_3
    //   39: invokeinterface 66 1 0
    //   44: checkcast 648	java/util/Map$Entry
    //   47: astore 4
    //   49: aload 4
    //   51: invokeinterface 651 1 0
    //   56: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   59: astore 5
    //   61: aload 5
    //   63: getfield 415	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   66: iconst_2
    //   67: if_icmpeq -38 -> 29
    //   70: aload 5
    //   72: getfield 415	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   75: bipush 14
    //   77: if_icmpeq -48 -> 29
    //   80: aload 5
    //   82: getfield 415	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   85: bipush 15
    //   87: if_icmpeq -58 -> 29
    //   90: aload 5
    //   92: getfield 415	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   95: iconst_4
    //   96: if_icmpeq -67 -> 29
    //   99: aload 4
    //   101: invokeinterface 654 1 0
    //   106: checkcast 95	java/lang/Long
    //   109: invokevirtual 657	java/lang/Long:longValue	()J
    //   112: lstore_1
    //   113: aload_3
    //   114: invokeinterface 659 1 0
    //   119: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -93 -> 29
    //   125: ldc 10
    //   127: iconst_2
    //   128: new 142	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 661
    //   138: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: lload_1
    //   142: invokevirtual 405	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: ldc_w 663
    //   148: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 327	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: goto -128 -> 29
    //   160: astore_3
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_3
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	FileManagerProxy
    //   112	30	1	l	long
    //   6	108	3	localObject1	Object
    //   160	4	3	localObject2	Object
    //   47	53	4	localEntry	java.util.Map.Entry
    //   59	32	5	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	7	160	finally
    //   14	29	160	finally
    //   29	157	160	finally
  }
  
  public void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        if (paramFileManagerEntity.bDelInFM)
        {
          localContentValues.put("bDelInFM", Boolean.valueOf(true));
          a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          break;
        }
      }
      finally {}
      localContentValues.put("bDelInFM", Boolean.valueOf(false));
    }
  }
  
  public void f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      return;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("msgSeq", Long.valueOf(paramFileManagerEntity.msgSeq));
        localContentValues.put("msgUid", Long.valueOf(paramFileManagerEntity.msgUid));
        localContentValues.put("msgTime", Long.valueOf(paramFileManagerEntity.msgTime));
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy
 * JD-Core Version:    0.7.0.1
 */