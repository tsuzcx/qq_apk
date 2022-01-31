package com.tencent.mobileqq.transfile;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.FmtIPInfo;
import ConfigPush.NetSegConf;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import eid;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class FMTSrvAddrProvider
{
  private static FMTSrvAddrProvider jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider;
  public static final String a = "FMT_ADDR";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  private static final String c = AppConstants.bs + "fmtSrvAddr.ini";
  private static final String d = AppConstants.bs + "srvAddr.ini";
  private long jdField_a_of_type_Long = -1L;
  private FileStoragePushFSSvcList jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = a();
  private eid jdField_a_of_type_Eid = new eid(this);
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private String jdField_b_of_type_JavaLangString = "";
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  
  private FMTSrvAddrProvider()
  {
    b();
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 6) {}
    do
    {
      return 1;
      if (paramInt == 7) {
        return 2;
      }
      if (paramInt == 8) {
        return 3;
      }
      if (paramInt == 9) {
        return 4;
      }
    } while (paramInt != 10);
    return 5;
  }
  
  /* Error */
  private FileStoragePushFSSvcList a()
  {
    // Byte code:
    //   0: getstatic 47	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:d	Ljava/lang/String;
    //   3: invokestatic 91	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 97	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +20 -> 33
    //   16: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +148 -> 167
    //   22: ldc 9
    //   24: iconst_2
    //   25: ldc 105
    //   27: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: goto +137 -> 167
    //   33: new 110	java/io/FileInputStream
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_3
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_2
    //   48: new 115	java/io/ByteArrayOutputStream
    //   51: dup
    //   52: invokespecial 116	java/io/ByteArrayOutputStream:<init>	()V
    //   55: astore 4
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 120	java/io/FileInputStream:read	([B)I
    //   62: istore_1
    //   63: iload_1
    //   64: iconst_m1
    //   65: if_icmpeq +37 -> 102
    //   68: aload 4
    //   70: aload_2
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 124	java/io/ByteArrayOutputStream:write	([BII)V
    //   76: goto -19 -> 57
    //   79: astore_3
    //   80: aconst_null
    //   81: astore_2
    //   82: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +11 -> 96
    //   88: ldc 9
    //   90: iconst_2
    //   91: ldc 126
    //   93: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_3
    //   97: invokevirtual 129	java/io/FileNotFoundException:printStackTrace	()V
    //   100: aload_2
    //   101: areturn
    //   102: new 131	com/qq/taf/jce/JceInputStream
    //   105: dup
    //   106: aload 4
    //   108: invokevirtual 135	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: invokespecial 138	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   114: astore 4
    //   116: new 140	ConfigPush/FileStoragePushFSSvcList
    //   119: dup
    //   120: invokespecial 141	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: aload 4
    //   127: invokevirtual 145	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   130: aload_3
    //   131: invokevirtual 148	java/io/FileInputStream:close	()V
    //   134: aload_2
    //   135: areturn
    //   136: astore_3
    //   137: goto -55 -> 82
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +11 -> 157
    //   149: ldc 9
    //   151: iconst_2
    //   152: ldc 150
    //   154: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_3
    //   158: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   161: aload_2
    //   162: areturn
    //   163: astore_3
    //   164: goto -21 -> 143
    //   167: aconst_null
    //   168: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	FMTSrvAddrProvider
    //   62	11	1	i	int
    //   6	156	2	localObject1	Object
    //   41	17	3	localFileInputStream	java.io.FileInputStream
    //   79	52	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   136	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   140	18	3	localException1	Exception
    //   163	1	3	localException2	Exception
    //   55	71	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	30	79	java/io/FileNotFoundException
    //   33	57	79	java/io/FileNotFoundException
    //   57	63	79	java/io/FileNotFoundException
    //   68	76	79	java/io/FileNotFoundException
    //   102	124	79	java/io/FileNotFoundException
    //   124	134	136	java/io/FileNotFoundException
    //   0	30	140	java/lang/Exception
    //   33	57	140	java/lang/Exception
    //   57	63	140	java/lang/Exception
    //   68	76	140	java/lang/Exception
    //   102	124	140	java/lang/Exception
    //   124	134	163	java/lang/Exception
  }
  
  public static FMTSrvAddrProvider a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider == null) {
        jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider = new FMTSrvAddrProvider();
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileFMTSrvAddrProvider;
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 12: 
      return 1;
    case 13: 
      return 2;
    case 14: 
      return 3;
    }
    return 7;
  }
  
  private void b()
  {
    int i = 1;
    while (i < 7)
    {
      d(i);
      i += 1;
    }
    this.jdField_a_of_type_Eid.a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList);
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo != null))
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.sGateIp;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null)
    {
      this.jdField_a_of_type_Long = -1L;
      this.jdField_b_of_type_JavaLangString = "";
    }
  }
  
  private void b(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      File localFile = FileUtils.a(c);
      if (paramFileStoragePushFSSvcList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "FMT SERVER writeToFile list==null");
        }
        if ((localFile == null) || (!localFile.exists())) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "FMT SERVER writeToFile list==null,delete old file?");
        }
        localFile.delete();
        return;
      }
      Object localObject = new JceOutputStream();
      paramFileStoragePushFSSvcList.writeTo((JceOutputStream)localObject);
      localObject = ((JceOutputStream)localObject).toByteArray();
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile, false);
      localFileOutputStream.write((byte[])localObject);
      localFileOutputStream.close();
      localObject = new File(d);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localFile.renameTo((File)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "FMT SERVER,writeToFile error", localException);
        }
      }
    }
    if ((paramFileStoragePushFSSvcList != null) && (QLog.isColorLevel()))
    {
      QLog.d("FMT_ADDR", 2, "FMT SERVER,writeToFile LIST persist OK");
      return;
    }
  }
  
  private ArrayList c(int paramInt)
  {
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null)
    {
      switch (paramInt)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        return d(a(paramInt));
      case 0: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUpLoadList;
      case 1: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vPicDownLoadList;
      case 2: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList;
      case 3: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vQzoneProxyServiceList;
      case 4: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUrlEncodeServiceList;
      case 5: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vVipEmotionList;
      case 11: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList;
      }
      return e(b(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  private ArrayList d(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilHashtable.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    }
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.size())
      {
        Object localObject = (BigDataIpList)this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.get(i);
        if (((BigDataIpList)localObject).uService_type == paramInt)
        {
          localObject = ((BigDataIpList)localObject).vIplist;
          ArrayList localArrayList = new ArrayList();
          i = j;
          while (i < ((ArrayList)localObject).size())
          {
            FileStorageServerListInfo localFileStorageServerListInfo = new FileStorageServerListInfo();
            localFileStorageServerListInfo.sIP = ((BigDataIpInfo)((ArrayList)localObject).get(i)).sIp;
            localFileStorageServerListInfo.iPort = ((int)((BigDataIpInfo)((ArrayList)localObject).get(i)).uPort);
            localArrayList.add(localFileStorageServerListInfo);
            i += 1;
          }
          this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localArrayList);
          return localArrayList;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private ArrayList e(int paramInt)
  {
    int j = 0;
    if (this.jdField_b_of_type_JavaUtilHashtable.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.jdField_b_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
        {
          i = 0;
          if (i < this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.size())
          {
            Object localObject1 = (DomainIpList)this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.get(i);
            if (((DomainIpList)localObject1).uDomain_type != paramInt) {
              break label352;
            }
            localObject2 = ((DomainIpList)localObject1).vIplist;
            localObject1 = new ArrayList();
            i = j;
            if (i < ((ArrayList)localObject2).size())
            {
              localObject3 = new FileStorageServerListInfo();
              ((FileStorageServerListInfo)localObject3).sIP = NetworkUtil.a(((DomainIpInfo)((ArrayList)localObject2).get(i)).uIp);
              ((FileStorageServerListInfo)localObject3).iPort = ((DomainIpInfo)((ArrayList)localObject2).get(i)).uPort;
              ((ArrayList)localObject1).add(localObject3);
              i += 1;
              continue;
            }
            this.jdField_b_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localObject1);
            if (!QLog.isColorLevel()) {
              break label349;
            }
            localObject2 = new StringBuffer();
            Object localObject3 = ((ArrayList)localObject1).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label309;
            }
            FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject3).next();
            ((StringBuffer)localObject2).append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append(",");
            continue;
          }
        }
        return null;
      }
      catch (NoSuchFieldError localNoSuchFieldError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMT_ADDR", 2, localNoSuchFieldError.getMessage());
        }
      }
      label309:
      QLog.d("FMT_ADDR", 2, "Domain type=" + paramInt + ",iplist=" + ((StringBuffer)localObject2).toString());
      label349:
      return localNoSuchFieldError;
      label352:
      i += 1;
    }
  }
  
  public long a()
  {
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = a();
    if ((localFileStoragePushFSSvcList != null) && (localFileStoragePushFSSvcList.fmtIPInfo != null)) {
      return localFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    return -1L;
  }
  
  public HwConfig a()
  {
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists != null))
    {
      Object localObject1 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (BigDataIpList)((Iterator)localObject1).next();
        if ((((BigDataIpList)localObject2).uService_type == 10L) && (((BigDataIpList)localObject2).vIplist != null) && (((BigDataIpList)localObject2).netSegConfs != null))
        {
          localObject1 = new HwConfig();
          ((HwConfig)localObject1).ipList = new ArrayList();
          Object localObject3 = ((BigDataIpList)localObject2).vIplist.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            BigDataIpInfo localBigDataIpInfo = (BigDataIpInfo)((Iterator)localObject3).next();
            ((HwConfig)localObject1).ipList.add(new EndPoint(localBigDataIpInfo.sIp, (int)localBigDataIpInfo.uPort));
          }
          ((HwConfig)localObject1).netSegConfList = new ArrayList();
          if (((BigDataIpList)localObject2).netSegConfs != null)
          {
            localObject2 = ((BigDataIpList)localObject2).netSegConfs.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (NetSegConf)((Iterator)localObject2).next();
              ((HwConfig)localObject1).netSegConfList.add(new HwNetSegConf(((NetSegConf)localObject3).uint32_net_type, ((NetSegConf)localObject3).uint32_segsize, ((NetSegConf)localObject3).uint32_segnum, ((NetSegConf)localObject3).uint32_curconnnum));
            }
          }
          QLog.d("FMT_ADDR", 1, "getBigDataDefaultIpList() successfully got channel(service type = 10)");
          return localObject1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 1, "getBigDataDefaultIpList() cannot find channel(service type = 10)");
    }
    return null;
  }
  
  /* Error */
  public ServerAddr a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 245	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:c	(I)Ljava/util/ArrayList;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +52 -> 61
    //   12: aload_3
    //   13: invokevirtual 274	java/util/ArrayList:size	()I
    //   16: ifle +45 -> 61
    //   19: new 425	com/tencent/mobileqq/transfile/ServerAddr
    //   22: dup
    //   23: invokespecial 426	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokevirtual 277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   33: checkcast 288	ConfigPush/FileStorageServerListInfo
    //   36: getfield 297	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   39: putfield 428	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 288	ConfigPush/FileStorageServerListInfo
    //   51: getfield 304	ConfigPush/FileStorageServerListInfo:iPort	I
    //   54: putfield 430	com/tencent/mobileqq/transfile/ServerAddr:b	I
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: areturn
    //   61: aconst_null
    //   62: astore_2
    //   63: goto -6 -> 57
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	FMTSrvAddrProvider
    //   0	71	1	paramInt	int
    //   26	37	2	localServerAddr	ServerAddr
    //   66	4	2	localObject	Object
    //   7	37	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	8	66	finally
    //   12	57	66	finally
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  /* Error */
  public String a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_Eid	Leid;
    //   6: iload_1
    //   7: invokevirtual 433	eid:a	(I)LConfigPush/FileStorageServerListInfo;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +70 -> 82
    //   15: new 342	java/lang/StringBuffer
    //   18: dup
    //   19: sipush 200
    //   22: invokespecial 436	java/lang/StringBuffer:<init>	(I)V
    //   25: astore_3
    //   26: aload_3
    //   27: ldc_w 438
    //   30: invokevirtual 359	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   33: aload_2
    //   34: getfield 297	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   37: invokevirtual 359	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   40: pop
    //   41: aload_2
    //   42: getfield 304	ConfigPush/FileStorageServerListInfo:iPort	I
    //   45: bipush 80
    //   47: if_icmpeq +18 -> 65
    //   50: aload_3
    //   51: ldc_w 361
    //   54: invokevirtual 359	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: aload_2
    //   58: getfield 304	ConfigPush/FileStorageServerListInfo:iPort	I
    //   61: invokevirtual 364	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: aload_3
    //   66: ldc_w 440
    //   69: invokevirtual 359	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: aload_3
    //   74: invokevirtual 379	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: areturn
    //   82: aconst_null
    //   83: astore_2
    //   84: goto -6 -> 78
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	FMTSrvAddrProvider
    //   0	92	1	paramInt	int
    //   10	74	2	localObject1	Object
    //   87	4	2	localObject2	Object
    //   25	49	3	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   2	11	87	finally
    //   15	65	87	finally
    //   65	78	87	finally
  }
  
  public ArrayList a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = c(paramInt);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "FMT SERVER LIST CLEARED!!!");
      }
      a(null);
      this.jdField_a_of_type_Eid.a();
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      this.jdField_b_of_type_JavaUtilHashtable.clear();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Eid.a(paramInt, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "set svclist" + paramFileStoragePushFSSvcList);
      }
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = paramFileStoragePushFSSvcList;
      b();
      b(paramFileStoragePushFSSvcList);
      return;
    }
    finally {}
  }
  
  /* Error */
  public byte[] a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 265	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 265	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 462	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 265	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 465	ConfigPush/BigDataChannel:sBigdata_sig_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FMTSrvAddrProvider
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  /* Error */
  public ArrayList b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_Eid	Leid;
    //   6: iload_1
    //   7: invokevirtual 467	eid:a	(I)Ljava/util/ArrayList;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +91 -> 105
    //   17: new 261	java/util/ArrayList
    //   20: dup
    //   21: aload 4
    //   23: invokevirtual 274	java/util/ArrayList:size	()I
    //   26: invokespecial 468	java/util/ArrayList:<init>	(I)V
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: aload 4
    //   35: invokevirtual 274	java/util/ArrayList:size	()I
    //   38: if_icmpge +63 -> 101
    //   41: aload 4
    //   43: iload_2
    //   44: invokevirtual 277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 288	ConfigPush/FileStorageServerListInfo
    //   50: astore 5
    //   52: new 470	eiv
    //   55: dup
    //   56: invokespecial 471	eiv:<init>	()V
    //   59: astore 6
    //   61: aload 6
    //   63: aload 5
    //   65: getfield 297	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   68: putfield 472	eiv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: aload 6
    //   73: aload 5
    //   75: getfield 304	ConfigPush/FileStorageServerListInfo:iPort	I
    //   78: putfield 473	eiv:b	I
    //   81: aload 6
    //   83: iload_1
    //   84: putfield 475	eiv:jdField_a_of_type_Int	I
    //   87: aload_3
    //   88: iload_2
    //   89: aload 6
    //   91: invokevirtual 478	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: istore_2
    //   98: goto -66 -> 32
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: areturn
    //   105: aconst_null
    //   106: astore_3
    //   107: goto -6 -> 101
    //   110: astore_3
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_3
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	FMTSrvAddrProvider
    //   0	115	1	paramInt	int
    //   31	67	2	i	int
    //   29	78	3	localArrayList1	ArrayList
    //   110	4	3	localObject	Object
    //   10	32	4	localArrayList2	ArrayList
    //   50	24	5	localFileStorageServerListInfo	FileStorageServerListInfo
    //   59	31	6	localeiv	eiv
    // Exception table:
    //   from	to	target	type
    //   2	12	110	finally
    //   17	30	110	finally
    //   32	94	110	finally
  }
  
  /* Error */
  public byte[] b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 265	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 265	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 462	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 69	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 265	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 481	ConfigPush/BigDataChannel:sBigdata_key_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FMTSrvAddrProvider
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */