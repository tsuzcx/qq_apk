package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.Utils;
import fug;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class FileManagerRSCenter
{
  private static final int jdField_a_of_type_Int = 2;
  private static final String jdField_a_of_type_JavaLangString = "FileManagerRSCenter<FileAssistant>";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fug(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public FileManagerRSCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  /* Error */
  public int a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload 5
    //   8: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   11: invokevirtual 55	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 57	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +17 -> 38
    //   24: aload 7
    //   26: invokeinterface 61 1 0
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   45: lload_1
    //   46: aload_3
    //   47: iload 4
    //   49: lload 5
    //   51: invokevirtual 69	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +9 -> 65
    //   59: iconst_m1
    //   60: istore 4
    //   62: goto -29 -> 33
    //   65: aload_0
    //   66: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   69: aload_3
    //   70: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   73: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 55	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 57	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   82: ifnull +12 -> 94
    //   85: aload_3
    //   86: getfield 78	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   89: istore 4
    //   91: goto -58 -> 33
    //   94: iconst_m1
    //   95: istore 4
    //   97: goto -64 -> 33
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	FileManagerRSCenter
    //   0	105	1	paramLong1	long
    //   0	105	3	paramString	String
    //   0	105	4	paramInt	int
    //   0	105	5	paramLong2	long
    //   17	8	7	localIFileHttpBase	IFileHttpBase
    // Exception table:
    //   from	to	target	type
    //   2	19	100	finally
    //   24	33	100	finally
    //   38	55	100	finally
    //   65	91	100	finally
  }
  
  /* Error */
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload 4
    //   11: aload_1
    //   12: iload 6
    //   14: invokevirtual 82	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +45 -> 66
    //   24: aload_0
    //   25: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   28: aload 7
    //   30: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   33: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 55	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 57	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +20 -> 66
    //   49: aload 7
    //   51: invokeinterface 85 1 0
    //   56: istore 6
    //   58: iload 6
    //   60: i2l
    //   61: lstore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: lload_2
    //   65: lreturn
    //   66: aload_0
    //   67: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   73: aload_1
    //   74: lload_2
    //   75: lload 4
    //   77: iload 6
    //   79: invokevirtual 87	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(Ljava/lang/String;JJI)J
    //   82: lstore_2
    //   83: goto -21 -> 62
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	FileManagerRSCenter
    //   0	91	1	paramString	String
    //   0	91	2	paramLong1	long
    //   0	91	4	paramLong2	long
    //   0	91	6	paramInt	int
    //   17	33	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	86	finally
    //   24	44	86	finally
    //   49	58	86	finally
    //   66	83	86	finally
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 91	java/util/LinkedHashMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpge +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   25: invokevirtual 95	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   28: invokeinterface 101 1 0
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 107 1 0
    //   40: ifeq +53 -> 93
    //   43: aload_3
    //   44: invokeinterface 111 1 0
    //   49: checkcast 47	java/lang/Long
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   58: aload 4
    //   60: invokevirtual 55	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 57	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   66: astore 4
    //   68: aload_1
    //   69: aload 4
    //   71: invokeinterface 115 1 0
    //   76: invokevirtual 121	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   79: ifeq -45 -> 34
    //   82: aload 4
    //   84: invokeinterface 124 1 0
    //   89: astore_1
    //   90: goto -73 -> 17
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -78 -> 17
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	FileManagerRSCenter
    //   0	103	1	paramString	String
    //   9	4	2	i	int
    //   33	11	3	localIterator	Iterator
    //   52	31	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	98	finally
    //   21	34	98	finally
    //   34	90	98	finally
  }
  
  public void a()
  {
    int i;
    try
    {
      i = Utils.a(BaseApplication.getContext());
      if (i == 1) {
        break label606;
      }
      if (i != 2) {
        break label601;
      }
    }
    finally {}
    int[] arrayOfInt = new int[2];
    long[] arrayOfLong = new long[2];
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    for (;;)
    {
      label46:
      Long localLong;
      IFileHttpBase localIFileHttpBase;
      label153:
      int j;
      if (localIterator.hasNext())
      {
        localLong = (Long)localIterator.next();
        localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localLong);
        if (localIFileHttpBase == null)
        {
          QLog.e("FileManagerRSCenter<FileAssistant>", 1, "!!!!runRSWorker error, get worker null!!! sessionID[" + localLong + "]");
          continue;
        }
        if (localIFileHttpBase.a() == 0) {
          break label611;
        }
        if (localIFileHttpBase.a() != 6) {
          break label294;
        }
        break label611;
        if (!localIFileHttpBase.a()) {
          break label525;
        }
        if (localObject[j] >= i) {
          break label443;
        }
        if (!QLog.isColorLevel()) {
          break label616;
        }
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "type[" + localIFileHttpBase.a() + "] worker[" + localObject[j] + "] < maxCount[" + String.valueOf(i) + "], so run task sessionId[" + String.valueOf(localLong) + "]");
        break label616;
      }
      for (;;)
      {
        int k;
        if ((k >= localObject[j]) || (arrayOfLong[k] == localIFileHttpBase.b()))
        {
          if (k == localObject[j])
          {
            localIFileHttpBase.f();
            label291:
            return;
            label294:
            if ((localIFileHttpBase.a() == 1) || (localIFileHttpBase.a() == 8) || (localIFileHttpBase.a() == 5)) {
              break label626;
            }
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, "type[" + localIFileHttpBase.a() + "] is not processed, maxtype is " + 8);
            break label46;
          }
          if (!QLog.isColorLevel()) {
            break label46;
          }
          QLog.d("FileManagerRSCenter<FileAssistant>", 2, "type[" + localIFileHttpBase.a() + "] task sessionId[" + String.valueOf(localLong) + "] md5 is same with previous, so can't run task");
          break label46;
          label443:
          label601:
          label606:
          label611:
          label616:
          do
          {
            localIFileHttpBase.f();
            break label291;
            if (!QLog.isColorLevel()) {
              break label46;
            }
            QLog.d("FileManagerRSCenter<FileAssistant>", 2, "type[" + localIFileHttpBase.a() + "] worker[" + localObject[j] + "] > maxCount[" + String.valueOf(i) + "], so can't run task sessionId[" + String.valueOf(localLong) + "]");
            break label46;
            if (j != 1) {
              break label638;
            }
            if (localObject[j] >= 2)
            {
              QLog.i("FileManagerRSCenter<FileAssistant>", 1, "type[" + localIFileHttpBase.a() + "] count is " + localObject[j]);
              break label638;
            }
            arrayOfLong[localObject[j]] = localIFileHttpBase.b();
            break label638;
            i = 2;
            break;
            i = 1;
            break;
            j = 1;
            break label153;
          } while (j != 1);
          label525:
          k = 0;
          continue;
          label626:
          j = 0;
          break label153;
        }
        k += 1;
      }
      label638:
      localObject[j] += 1;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localIFileHttpBase != null) {
        localIFileHttpBase.c();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "remove worker, sessionId[" + String.valueOf(paramLong) + "]");
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      a();
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2, paramString, paramInt1);
    }
    if (localFileManagerEntity1 == null)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entity is null ,why you can choose!!!");
      return;
    }
    localFileManagerEntity1.nOpType = paramInt2;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong1)) == true)
    {
      QLog.w("FileManagerRSCenter<FileAssistant>", 1, "woker is process!");
      return;
    }
    b(localFileManagerEntity1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    Object localObject;
    int i;
    if (!FileUtils.b(paramFileManagerEntity.strFilePath))
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]file is not exist or empty,path[" + paramFileManagerEntity.strFilePath + "], please check file!");
      localObject = FileManagerUtil.a();
      if ((paramFileManagerEntity.strFilePath == null) || (paramFileManagerEntity.strFilePath.length() == 0))
      {
        localObject = "filePathNull:" + (String)localObject;
        i = 9005;
      }
    }
    for (;;)
    {
      switch (paramFileManagerEntity.nOpType)
      {
      }
      for (;;)
      {
        paramFileManagerEntity.status = 16;
        paramFileManagerEntity.fProgress = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        return;
        if (!FileManagerUtil.a(paramFileManagerEntity.strFilePath))
        {
          localObject = "fileNotExists:" + (String)localObject;
          i = 9042;
          break;
        }
        if (FileManagerUtil.a(paramFileManagerEntity.strFilePath) != 0L) {
          break label642;
        }
        localObject = "fileExistsEmpty:" + (String)localObject;
        i = 9071;
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, 1, null);
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUpDetail", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        continue;
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 38, null, 1, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWyUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
      }
      if (paramFileManagerEntity.peerType == 3000) {}
      for (localObject = new DiscFileOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);; localObject = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity)) {
        try
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localObject);
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Send Work!, sessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
          }
          a();
          return;
        }
        finally {}
      }
      label642:
      i = 0;
    }
  }
  
  /* Error */
  public void a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 333
    //   16: invokevirtual 69	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   19: astore 5
    //   21: aload 5
    //   23: ifnonnull +50 -> 73
    //   26: ldc 10
    //   28: iconst_1
    //   29: new 137	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 336
    //   39: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 338
    //   49: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: lload_2
    //   53: invokestatic 213	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   56: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 149
    //   61: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: aload 5
    //   76: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   79: invokevirtual 340	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(J)V
    //   82: goto -12 -> 70
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	FileManagerRSCenter
    //   0	90	1	paramString	String
    //   0	90	2	paramLong	long
    //   0	90	4	paramInt	int
    //   19	56	5	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	21	85	finally
    //   26	70	85	finally
    //   73	82	85	finally
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload_1
    //   7: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 55	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 57	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   16: astore 4
    //   18: aload 4
    //   20: ifnull +26 -> 46
    //   23: aload 4
    //   25: invokeinterface 208 1 0
    //   30: aload_0
    //   31: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   34: lload_1
    //   35: invokestatic 51	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   38: invokevirtual 216	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: aload_0
    //   43: invokevirtual 218	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	()V
    //   46: aload_0
    //   47: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   53: lload_1
    //   54: invokevirtual 222	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(J)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +36 -> 97
    //   64: aload 4
    //   66: getfield 78	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   69: iconst_2
    //   70: if_icmpne +27 -> 97
    //   73: aload 4
    //   75: iconst_3
    //   76: putfield 78	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   79: aload_0
    //   80: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   86: aload 4
    //   88: invokevirtual 275	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   91: iconst_1
    //   92: istore_3
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_3
    //   96: ireturn
    //   97: iconst_0
    //   98: istore_3
    //   99: goto -6 -> 93
    //   102: astore 4
    //   104: aload_0
    //   105: monitorexit
    //   106: aload 4
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	FileManagerRSCenter
    //   0	109	1	paramLong	long
    //   92	7	3	bool	boolean
    //   16	71	4	localObject1	Object
    //   102	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	102	finally
    //   23	46	102	finally
    //   46	59	102	finally
    //   64	91	102	finally
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 333
    //   16: invokevirtual 69	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +11 -> 32
    //   24: iconst_0
    //   25: istore 5
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 5
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: getfield 75	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   37: invokevirtual 344	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(J)Z
    //   40: istore 5
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FileManagerRSCenter
    //   0	50	1	paramString	String
    //   0	50	2	paramLong	long
    //   0	50	4	paramInt	int
    //   25	16	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	45	finally
    //   32	42	45	finally
  }
  
  /* Error */
  public FileManagerEntity b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 91	java/util/LinkedHashMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpge +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   25: invokevirtual 95	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   28: invokeinterface 101 1 0
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 107 1 0
    //   40: ifeq +53 -> 93
    //   43: aload_3
    //   44: invokeinterface 111 1 0
    //   49: checkcast 47	java/lang/Long
    //   52: astore 4
    //   54: aload_0
    //   55: getfield 30	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   58: aload 4
    //   60: invokevirtual 55	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 57	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   66: astore 4
    //   68: aload_1
    //   69: aload 4
    //   71: invokeinterface 346 1 0
    //   76: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq -45 -> 34
    //   82: aload 4
    //   84: invokeinterface 124 1 0
    //   89: astore_1
    //   90: goto -73 -> 17
    //   93: aconst_null
    //   94: astore_1
    //   95: goto -78 -> 17
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	FileManagerRSCenter
    //   0	103	1	paramString	String
    //   9	4	2	i	int
    //   33	11	3	localIterator	Iterator
    //   52	31	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	98	finally
    //   21	34	98	finally
    //   34	90	98	finally
  }
  
  public void b()
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        if (i < 1) {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localArrayList.add(0, (IFileHttpBase)((Iterator)localObject2).next());
          continue;
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      }
      finally {}
      Iterator localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (IFileHttpBase)localIterator.next();
        ((IFileHttpBase)localObject2).d();
        ((IFileHttpBase)localObject2).a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    FileManagerRSWorker localFileManagerRSWorker = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localFileManagerRSWorker);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Recv Work!, sessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
      }
      a();
      return;
    }
    finally {}
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entry is null, retry ge mao!");
        return;
      }
      finally {}
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      if ((localIFileHttpBase == null) || (localIFileHttpBase.a())) {
        break;
      }
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "uniseq[ " + String.valueOf(paramFileManagerEntity.uniseq) + " ],sessionid[ " + String.valueOf(paramFileManagerEntity.nSessionId) + " ] work,is procressing!");
    }
    switch (paramFileManagerEntity.nOpType)
    {
    }
    for (;;)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "Unknow actionType!");
      break;
      a(paramFileManagerEntity);
      break;
      b(paramFileManagerEntity);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSCenter
 * JD-Core Version:    0.7.0.1
 */