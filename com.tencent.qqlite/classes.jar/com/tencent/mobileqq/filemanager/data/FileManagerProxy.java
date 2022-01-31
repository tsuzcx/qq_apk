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
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import drb;
import drc;
import drd;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FileManagerProxy
  extends BaseProxy
{
  public static final int a = 30;
  private static final String jdField_a_of_type_JavaLangString = "FileManagerProxy<FileAssistant>";
  SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  List jdField_a_of_type_JavaUtilList = null;
  private Map jdField_a_of_type_JavaUtilMap = null;
  List b = new ArrayList();
  private List c = null;
  
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
        if (this.c == null) {
          a();
        }
        int i = this.c.size();
        if (i == 0)
        {
          bool = false;
          return bool;
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " where srvTime <= " + String.valueOf(((FileManagerEntity)this.c.get(this.c.size() - 1)).srvTime) + " and " + " nSessionId != " + String.valueOf(((FileManagerEntity)this.c.get(this.c.size() - 1)).nSessionId) + " and bDelInFM = 0  order by srvTime desc limit " + paramInt + ") order by srvTime desc";
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
        List localList = FileCategoryUtil.a(BaseApplicationImpl.getContext());
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
      this.c.add(this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)));
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
    if (this.c == null) {
      a();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramLong3), paramInt);
    Object localObject2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("------->FileManager findUinSeqForCache :msgIsTroop:").append(paramInt).append(",peerUin:").append(FileManagerUtil.e(String.valueOf(paramLong3))).append(",list size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.i("FileManagerProxy<FileAssistant>", 2, i);
      }
    }
    else
    {
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label251;
      }
      localObject1 = ((List)localObject1).iterator();
    }
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
    label251:
    localObject1 = this.c.iterator();
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
    //   3: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 139	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   17: invokeinterface 59 1 0
    //   22: astore 6
    //   24: aload 6
    //   26: invokeinterface 65 1 0
    //   31: ifeq +32 -> 63
    //   34: aload 6
    //   36: invokeinterface 69 1 0
    //   41: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 177	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
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
    //   64: getfield 26	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   67: ifnull +49 -> 116
    //   70: aload_0
    //   71: getfield 26	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   74: invokeinterface 59 1 0
    //   79: astore 6
    //   81: aload 6
    //   83: invokeinterface 65 1 0
    //   88: ifeq +28 -> 116
    //   91: aload 6
    //   93: invokeinterface 69 1 0
    //   98: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   101: astore 5
    //   103: aload 5
    //   105: getfield 177	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   108: lload_1
    //   109: lcmp
    //   110: ifne -29 -> 81
    //   113: goto -55 -> 58
    //   116: aload_0
    //   117: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   120: lload_1
    //   121: invokestatic 257	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokeinterface 260 2 0
    //   129: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   132: astore 5
    //   134: goto -76 -> 58
    //   137: astore 5
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 5
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	FileManagerProxy
    //   0	144	1	paramLong	long
    //   51	2	3	l	long
    //   44	89	5	localFileManagerEntity	FileManagerEntity
    //   137	5	5	localObject	Object
    //   22	70	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	137	finally
    //   13	24	137	finally
    //   24	52	137	finally
    //   63	81	137	finally
    //   81	113	137	finally
    //   116	134	137	finally
  }
  
  /* Error */
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lload_1
    //   3: ldc2_w 342
    //   6: lcmp
    //   7: ifeq +18 -> 25
    //   10: aload_3
    //   11: ifnull +14 -> 25
    //   14: aload_3
    //   15: invokevirtual 237	java/lang/String:length	()I
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
    //   32: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   35: ifnonnull +7 -> 42
    //   38: aload_0
    //   39: invokevirtual 139	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   42: aload_0
    //   43: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   46: invokeinterface 59 1 0
    //   51: astore 7
    //   53: aload 7
    //   55: invokeinterface 65 1 0
    //   60: ifeq +51 -> 111
    //   63: aload 7
    //   65: invokeinterface 69 1 0
    //   70: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   73: astore 6
    //   75: aload 6
    //   77: getfield 340	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   80: ifnull -27 -> 53
    //   83: aload 6
    //   85: getfield 341	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   88: lload_1
    //   89: lcmp
    //   90: ifne -37 -> 53
    //   93: aload 6
    //   95: getfield 340	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   98: aload_3
    //   99: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq -49 -> 53
    //   105: aload 6
    //   107: astore_3
    //   108: goto -81 -> 27
    //   111: aload_0
    //   112: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   115: ifnull +99 -> 214
    //   118: aload_0
    //   119: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   122: invokeinterface 349 1 0
    //   127: invokeinterface 352 1 0
    //   132: astore 7
    //   134: aload 7
    //   136: invokeinterface 65 1 0
    //   141: ifeq +73 -> 214
    //   144: aload 7
    //   146: invokeinterface 69 1 0
    //   151: checkcast 354	java/util/Map$Entry
    //   154: invokeinterface 357 1 0
    //   159: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   162: astore 6
    //   164: aload 6
    //   166: getfield 341	com/tencent/mobileqq/filemanager/data/FileManagerEntity:uniseq	J
    //   169: lload_1
    //   170: lcmp
    //   171: ifne -37 -> 134
    //   174: aload 6
    //   176: getfield 340	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   179: ifnull -45 -> 134
    //   182: aload 6
    //   184: getfield 340	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   187: aload_3
    //   188: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifeq -57 -> 134
    //   194: aload 6
    //   196: getfield 333	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerType	I
    //   199: istore 5
    //   201: iload 4
    //   203: iload 5
    //   205: if_icmpne -71 -> 134
    //   208: aload 6
    //   210: astore_3
    //   211: goto -184 -> 27
    //   214: aconst_null
    //   215: astore_3
    //   216: goto -189 -> 27
    //   219: astore_3
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_3
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FileManagerProxy
    //   0	224	1	paramLong	long
    //   0	224	3	paramString	String
    //   0	224	4	paramInt	int
    //   18	188	5	i	int
    //   73	136	6	localFileManagerEntity	FileManagerEntity
    //   51	94	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   14	20	219	finally
    //   31	42	219	finally
    //   42	53	219	finally
    //   53	105	219	finally
    //   111	134	219	finally
    //   134	201	219	finally
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 139	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   17: invokeinterface 59 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 65 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 69 1 0
    //   41: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 226	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 226	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   75: invokeinterface 361 1 0
    //   80: invokeinterface 352 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 65 1 0
    //   94: ifeq +53 -> 147
    //   97: aload 4
    //   99: invokeinterface 69 1 0
    //   104: checkcast 98	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 260 2 0
    //   118: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: getfield 226	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   126: ifnull -39 -> 87
    //   129: aload_3
    //   130: getfield 226	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFilePath	Ljava/lang/String;
    //   133: aload_1
    //   134: invokevirtual 245	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   137: istore_2
    //   138: iload_2
    //   139: ifeq -52 -> 87
    //   142: aload_3
    //   143: astore_1
    //   144: goto -77 -> 67
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -82 -> 67
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	FileManagerProxy
    //   0	157	1	paramString	String
    //   60	79	2	bool	boolean
    //   44	99	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	152	finally
    //   13	24	152	finally
    //   24	61	152	finally
    //   71	87	152	finally
    //   87	138	152	finally
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    for (;;)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.c == null) {
          a();
        }
        if ((paramString == null) || (paramLong <= 0L))
        {
          localObject = null;
          return localObject;
        }
        localIterator = this.c.iterator();
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
    try
    {
      this.jdField_a_of_type_JavaUtilList = a(200);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  public List a(int paramInt)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    for (;;)
    {
      long l1;
      try
      {
        if ((this.c == null) || (this.c.isEmpty())) {
          a();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0 " + " order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject3).a(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 != null) {
              continue;
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
          }
          localObject3 = localFileManagerEntity1;
          if (localObject1 != null)
          {
            paramInt = ((List)localObject1).size();
            if (paramInt != 0) {
              break label241;
            }
            localObject3 = localFileManagerEntity1;
          }
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label498;
          }
        }
        QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt + " data,is oom!");
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localOutOfMemoryError.size() + "]");
      continue;
      label241:
      Object localObject3 = new ArrayList();
      Iterator localIterator1 = localObject2.iterator();
      label259:
      label496:
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localFileManagerEntity1 = (FileManagerEntity)localIterator1.next();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId)) == true)
          {
            localFileManagerEntity1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator2 = this.c.iterator();
            while (localIterator2.hasNext())
            {
              FileManagerEntity localFileManagerEntity2 = (FileManagerEntity)localIterator2.next();
              if (localFileManagerEntity2.nSessionId == localFileManagerEntity1.nSessionId)
              {
                FileManagerUtil.a(localFileManagerEntity2);
                ((List)localObject3).add(localFileManagerEntity2);
              }
            }
          }
        }
        else
        {
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label496;
            }
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
            break label259;
            long l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 2, "QueryMoreEntity cost[" + (l2 - l1) + "], size[" + ((List)localObject3).size() + "]");
            }
            break;
          }
        }
      }
      label498:
      localIterator1 = null;
    }
  }
  
  protected void a()
  {
    if (this.c != null) {
      return;
    }
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " where bDelInFM = 0 " + " order by srvTime desc limit " + 30 + ") order by srvTime desc";
    Object localObject3 = "update  " + FileManagerEntity.tableName() + " set bDelInFM = 1 " + " where ( srvTime + " + 604800000L + " ) < " + MessageCache.a() * 1000L + " and cloudType = " + 1;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b((String)localObject3);
    this.c = localEntityManager.a(FileManagerEntity.class, (String)localObject2, null);
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "init , buf fmList is null,maybe is not data!,sql[" + (String)localObject2 + "]");
      }
      this.c = new ArrayList();
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        localObject2 = this.c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          FileManagerUtil.a((FileManagerEntity)localObject3);
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((FileManagerEntity)localObject3).nSessionId), localObject3);
        }
      }
    }
    finally {}
    localObject1.a();
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (paramLong == ((FileManagerEntity)((Map.Entry)localIterator.next()).getValue()).nSessionId) {
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramString == null) || (paramLong1 < 0L) || (paramLong2 <= 0L)) {}
    do
    {
      return;
      if (this.b.size() > 30) {
        this.b.remove(0);
      }
      drd localdrd = new drd(this);
      localdrd.jdField_a_of_type_Long = paramLong1;
      localdrd.jdField_a_of_type_JavaLangString = paramString;
      localdrd.b = paramLong2;
      this.b.add(localdrd);
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerProxy<FileAssistant>", 2, "saveDeletedEntity nSessionId=" + paramLong1 + " nOlSessionId=" + paramLong2);
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
      if (this.c == null) {
        a();
      }
      localObject1 = this.c.iterator();
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
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (((drd)localIterator.next()).jdField_a_of_type_Long == paramLong) {
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
          this.c.remove(paramFileManagerEntity);
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            if (((Iterator)localObject).hasNext())
            {
              if (((Iterator)localObject).next() != paramFileManagerEntity) {
                continue;
              }
              ((Iterator)localObject).remove();
              continue;
            }
          }
          localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            if (paramFileManagerEntity.nSessionId == ((FileManagerEntity)localEntry.getValue()).nSessionId) {
              ((Iterator)localObject).remove();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Delete FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for memory and db:" + FileManagerUtil.a(paramFileManagerEntity));
          }
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
          if (paramFileManagerEntity.bDelInFM)
          {
            this.c.remove(paramFileManagerEntity);
            if (this.jdField_a_of_type_JavaUtilList != null)
            {
              localObject = this.jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject).hasNext()) {
                if (((Iterator)localObject).next() == paramFileManagerEntity) {
                  ((Iterator)localObject).remove();
                }
              }
            }
          }
          bool1 = true;
        }
      }
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      drd localdrd = (drd)localIterator.next();
      if ((localdrd.b == paramLong) && (localdrd.jdField_a_of_type_JavaLangString != null) && (localdrd.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
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
  
  public FileManagerEntity b(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject2;
      try
      {
        if (this.c == null) {
          a();
        }
        localArrayList = new ArrayList();
        localObject2 = this.c.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          if ((((FileManagerEntity)localObject1).WeiYunFileId == null) || (!((FileManagerEntity)localObject1).WeiYunFileId.equalsIgnoreCase(paramString))) {
            continue;
          }
          if (((FileManagerEntity)localObject1).status == 1)
          {
            boolean bool = FileUtil.b(((FileManagerEntity)localObject1).strFilePath);
            if (bool) {
              return localObject1;
            }
          }
          localArrayList.add(localObject1);
          continue;
        }
        localObject2 = localArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          if (((FileManagerEntity)localObject1).nOpType == 5) {
            break;
          }
        }
      }
      localArrayList.clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label273;
        }
        localObject1 = (Long)localIterator.next();
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if ((((FileManagerEntity)localObject2).WeiYunFileId != null) && (((FileManagerEntity)localObject2).WeiYunFileId.equalsIgnoreCase(paramString)))
        {
          if (((FileManagerEntity)localObject2).status == 1)
          {
            localObject1 = localObject2;
            if (FileUtil.b(((FileManagerEntity)localObject2).strFilePath)) {
              break;
            }
          }
          localArrayList.add(localObject2);
        }
      }
      label273:
      paramString = localArrayList.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          localObject1 = (FileManagerEntity)paramString.next();
          int i = ((FileManagerEntity)localObject1).nOpType;
          if (i == 5) {
            break;
          }
        }
      }
      Object localObject1 = null;
    }
  }
  
  public List b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "queryMaxRecentRecords size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
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
      new Handler(localLooper).post(new drb(this, paramFileManagerEntity));
    }
  }
  
  public List c()
  {
    if ((this.c == null) || (this.c.isEmpty())) {
      a();
    }
    return this.c;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   18: invokeinterface 143 1 0
    //   23: iconst_1
    //   24: isub
    //   25: istore_1
    //   26: iload_1
    //   27: bipush 30
    //   29: if_icmplt -18 -> 11
    //   32: aload_0
    //   33: getfield 22	com/tencent/mobileqq/filemanager/data/FileManagerProxy:c	Ljava/util/List;
    //   36: iload_1
    //   37: invokeinterface 454 2 0
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
    int i;
    label270:
    try
    {
      if (this.c == null) {
        a();
      }
      if ((!this.c.contains(paramFileManagerEntity)) || (!QLog.isColorLevel())) {
        break label312;
      }
      QLog.e("FileManagerProxy<FileAssistant>", 2, "!!!!!!!!!!!fmList has one!!!!!!!!!!!!");
    }
    finally {}
    if (i < this.c.size())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.c.get(i);
      if (paramFileManagerEntity.srvTime >= localFileManagerEntity.srvTime)
      {
        this.c.add(i, paramFileManagerEntity);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label317;
        }
        this.jdField_a_of_type_JavaUtilList.add(i, paramFileManagerEntity);
        break label317;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (this.c.size() != 0) {
          break label270;
        }
        this.c.add(0, paramFileManagerEntity);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.add(0, paramFileManagerEntity);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FileManagerProxy<FileAssistant>", 4, "insertToList, is add" + bool + " entityInfo:" + FileManagerUtil.a(paramFileManagerEntity));
        }
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
        if (this.c.size() > 30) {
          this.c.remove(this.c.size() - 1);
        }
        return;
        i += 1;
        break;
        this.c.add(paramFileManagerEntity);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
        }
      }
      boolean bool = false;
      continue;
      label312:
      i = 0;
      break;
      label317:
      bool = true;
    }
  }
  
  public void d()
  {
    if (this.c == null) {
      a();
    }
    Object localObject2 = this.c.iterator();
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
    new Handler(paramFileManagerEntity).post(new drc(this, localContentValues, l));
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 24	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   18: invokeinterface 349 1 0
    //   23: invokeinterface 352 1 0
    //   28: astore_3
    //   29: aload_3
    //   30: invokeinterface 65 1 0
    //   35: ifeq -24 -> 11
    //   38: aload_3
    //   39: invokeinterface 69 1 0
    //   44: checkcast 354	java/util/Map$Entry
    //   47: astore 4
    //   49: aload 4
    //   51: invokeinterface 357 1 0
    //   56: checkcast 154	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   59: astore 5
    //   61: aload 5
    //   63: getfield 475	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   66: iconst_2
    //   67: if_icmpeq -38 -> 29
    //   70: aload 5
    //   72: getfield 475	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   75: bipush 14
    //   77: if_icmpeq -48 -> 29
    //   80: aload 5
    //   82: getfield 475	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   85: bipush 15
    //   87: if_icmpeq -58 -> 29
    //   90: aload 5
    //   92: getfield 475	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   95: iconst_4
    //   96: if_icmpeq -67 -> 29
    //   99: aload 4
    //   101: invokeinterface 712 1 0
    //   106: checkcast 98	java/lang/Long
    //   109: invokevirtual 715	java/lang/Long:longValue	()J
    //   112: lstore_1
    //   113: aload_3
    //   114: invokeinterface 451 1 0
    //   119: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -93 -> 29
    //   125: ldc 10
    //   127: iconst_2
    //   128: new 145	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 717
    //   138: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: lload_1
    //   142: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: ldc_w 719
    //   148: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 330	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   47	53	4	localEntry	Map.Entry
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy
 * JD-Core Version:    0.7.0.1
 */