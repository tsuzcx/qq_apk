package com.tencent.mobileqq.transfile;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
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
import com.tencent.qphone.base.util.QLog;
import grn;
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
  private static final String c = AppConstants.bi + "fmtSrvAddr.ini";
  private static final String d = AppConstants.bi + "srvAddr.ini";
  private long jdField_a_of_type_Long = -1L;
  private FileStoragePushFSSvcList jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = a();
  private grn jdField_a_of_type_Grn = new grn(this);
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private String b = "";
  
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
    //   3: invokestatic 89	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 95	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +20 -> 33
    //   16: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +148 -> 167
    //   22: ldc 9
    //   24: iconst_2
    //   25: ldc 103
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: goto +137 -> 167
    //   33: new 108	java/io/FileInputStream
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_3
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_2
    //   48: new 113	java/io/ByteArrayOutputStream
    //   51: dup
    //   52: invokespecial 114	java/io/ByteArrayOutputStream:<init>	()V
    //   55: astore 4
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 118	java/io/FileInputStream:read	([B)I
    //   62: istore_1
    //   63: iload_1
    //   64: iconst_m1
    //   65: if_icmpeq +37 -> 102
    //   68: aload 4
    //   70: aload_2
    //   71: iconst_0
    //   72: iload_1
    //   73: invokevirtual 122	java/io/ByteArrayOutputStream:write	([BII)V
    //   76: goto -19 -> 57
    //   79: astore_3
    //   80: aconst_null
    //   81: astore_2
    //   82: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +11 -> 96
    //   88: ldc 9
    //   90: iconst_2
    //   91: ldc 124
    //   93: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_3
    //   97: invokevirtual 127	java/io/FileNotFoundException:printStackTrace	()V
    //   100: aload_2
    //   101: areturn
    //   102: new 129	com/qq/taf/jce/JceInputStream
    //   105: dup
    //   106: aload 4
    //   108: invokevirtual 133	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: invokespecial 136	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   114: astore 4
    //   116: new 138	ConfigPush/FileStoragePushFSSvcList
    //   119: dup
    //   120: invokespecial 139	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: aload 4
    //   127: invokevirtual 143	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   130: aload_3
    //   131: invokevirtual 146	java/io/FileInputStream:close	()V
    //   134: aload_2
    //   135: areturn
    //   136: astore_3
    //   137: goto -55 -> 82
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +11 -> 157
    //   149: ldc 9
    //   151: iconst_2
    //   152: ldc 148
    //   154: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_3
    //   158: invokevirtual 149	java/lang/Exception:printStackTrace	()V
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
  
  private ArrayList b(int paramInt)
  {
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null)
    {
      if (paramInt == 0) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUpLoadList;
      }
      if (paramInt == 1) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vPicDownLoadList;
      }
      if (paramInt == 2) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList;
      }
      if (paramInt == 3) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vQzoneProxyServiceList;
      }
      if (paramInt == 4) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUrlEncodeServiceList;
      }
      if (paramInt == 5) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vVipEmotionList;
      }
      if (paramInt == 11) {
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList;
      }
      return c(a(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  private void b()
  {
    int i = 1;
    while (i < 7)
    {
      c(i);
      i += 1;
    }
    this.jdField_a_of_type_Grn.a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList);
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo != null))
    {
      this.b = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.sGateIp;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null)
    {
      this.jdField_a_of_type_Long = -1L;
      this.b = "";
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
    //   4: invokespecial 183	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:b	(I)Ljava/util/ArrayList;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +52 -> 61
    //   12: aload_3
    //   13: invokevirtual 267	java/util/ArrayList:size	()I
    //   16: ifle +45 -> 61
    //   19: new 363	com/tencent/mobileqq/transfile/ServerAddr
    //   22: dup
    //   23: invokespecial 364	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokevirtual 270	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   33: checkcast 281	ConfigPush/FileStorageServerListInfo
    //   36: getfield 290	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   39: putfield 366	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 270	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 281	ConfigPush/FileStorageServerListInfo
    //   51: getfield 297	ConfigPush/FileStorageServerListInfo:iPort	I
    //   54: putfield 368	com/tencent/mobileqq/transfile/ServerAddr:b	I
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
    return this.b;
  }
  
  /* Error */
  public String a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_Grn	Lgrn;
    //   6: iload_1
    //   7: invokevirtual 372	grn:a	(I)LConfigPush/FileStorageServerListInfo;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +70 -> 82
    //   15: new 374	java/lang/StringBuffer
    //   18: dup
    //   19: sipush 200
    //   22: invokespecial 377	java/lang/StringBuffer:<init>	(I)V
    //   25: astore_3
    //   26: aload_3
    //   27: ldc_w 379
    //   30: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   33: aload_2
    //   34: getfield 290	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   37: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   40: pop
    //   41: aload_2
    //   42: getfield 297	ConfigPush/FileStorageServerListInfo:iPort	I
    //   45: bipush 80
    //   47: if_icmpeq +18 -> 65
    //   50: aload_3
    //   51: ldc_w 384
    //   54: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: aload_2
    //   58: getfield 297	ConfigPush/FileStorageServerListInfo:iPort	I
    //   61: invokevirtual 387	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   64: pop
    //   65: aload_3
    //   66: ldc_w 389
    //   69: invokevirtual 382	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   72: pop
    //   73: aload_3
    //   74: invokevirtual 390	java/lang/StringBuffer:toString	()Ljava/lang/String;
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
    //   25	49	3	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   2	11	87	finally
    //   15	65	87	finally
    //   65	78	87	finally
  }
  
  /* Error */
  public ArrayList a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 74	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_Grn	Lgrn;
    //   6: iload_1
    //   7: invokevirtual 392	grn:a	(I)Ljava/util/ArrayList;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +91 -> 105
    //   17: new 254	java/util/ArrayList
    //   20: dup
    //   21: aload 4
    //   23: invokevirtual 267	java/util/ArrayList:size	()I
    //   26: invokespecial 393	java/util/ArrayList:<init>	(I)V
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_2
    //   32: iload_2
    //   33: aload 4
    //   35: invokevirtual 267	java/util/ArrayList:size	()I
    //   38: if_icmpge +63 -> 101
    //   41: aload 4
    //   43: iload_2
    //   44: invokevirtual 270	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   47: checkcast 281	ConfigPush/FileStorageServerListInfo
    //   50: astore 5
    //   52: new 395	gsa
    //   55: dup
    //   56: invokespecial 396	gsa:<init>	()V
    //   59: astore 6
    //   61: aload 6
    //   63: aload 5
    //   65: getfield 290	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   68: putfield 397	gsa:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: aload 6
    //   73: aload 5
    //   75: getfield 297	ConfigPush/FileStorageServerListInfo:iPort	I
    //   78: putfield 398	gsa:b	I
    //   81: aload 6
    //   83: iload_1
    //   84: putfield 400	gsa:jdField_a_of_type_Int	I
    //   87: aload_3
    //   88: iload_2
    //   89: aload 6
    //   91: invokevirtual 403	java/util/ArrayList:add	(ILjava/lang/Object;)V
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
    //   59	31	6	localgsa	gsa
    // Exception table:
    //   from	to	target	type
    //   2	12	110	finally
    //   17	30	110	finally
    //   32	94	110	finally
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "FMT SERVER LIST CLEARED!!!");
      }
      a(null);
      this.jdField_a_of_type_Grn.a();
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      this.jdField_a_of_type_Grn.a(paramInt, paramString);
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
    //   3: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 258	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 258	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 425	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 258	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 428	ConfigPush/BigDataChannel:sBigdata_sig_session	[B
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
  public byte[] b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 258	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 258	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 425	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 67	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 258	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 431	ConfigPush/BigDataChannel:sBigdata_key_session	[B
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */