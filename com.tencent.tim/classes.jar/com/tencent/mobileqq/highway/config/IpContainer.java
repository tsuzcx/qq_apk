package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.iplearning.IpLearning;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class IpContainer
{
  private static final String SUB_TAG = "IpContainer";
  public static ConcurrentHashMap<String, IpLearning> mIpLearners = new ConcurrentHashMap();
  private PersistentConfig mCfg;
  private String mFileName;
  
  public IpContainer(Context paramContext, String paramString, AppRuntime paramAppRuntime)
  {
    this.mFileName = paramString;
    this.mCfg = readDiskOrCreateNew(paramContext, paramString);
  }
  
  private boolean findNRemove(ArrayList<EndPoint> paramArrayList, String paramString)
  {
    boolean bool2;
    if (paramArrayList == null)
    {
      bool2 = false;
      return bool2;
    }
    EndPoint localEndPoint = null;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayList.size()) {
          break label120;
        }
        localEndPoint = (EndPoint)paramArrayList.get(i);
        if (!localEndPoint.host.equalsIgnoreCase(paramString)) {
          break label113;
        }
        if (paramArrayList.size() <= i) {
          break label129;
        }
        paramArrayList.remove(i);
      }
      finally {}
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (paramString.protoType != 1) {
        break;
      }
      paramString.protoType = 2;
      paramArrayList.add(paramArrayList.size(), paramString);
      bool2 = bool1;
      break;
      label113:
      i += 1;
      continue;
      label120:
      boolean bool1 = false;
      paramString = localEndPoint;
      continue;
      label129:
      paramString = localEndPoint;
      bool1 = true;
    }
  }
  
  private IpLearning getOrCreateIpLearnerByKey(String paramString)
  {
    if (IpLearningImpl.sEnableIpLearning == 1)
    {
      IpLearningImpl localIpLearningImpl = new IpLearningImpl();
      paramString = (IpLearning)mIpLearners.putIfAbsent(paramString, localIpLearningImpl);
      if (paramString != null) {
        return paramString;
      }
      return localIpLearningImpl;
    }
    return null;
  }
  
  private void insertOrReplace(Context paramContext, ConcurrentHashMap<String, ArrayList<EndPoint>> paramConcurrentHashMap, ArrayList<EndPoint> paramArrayList, boolean paramBoolean)
  {
    paramContext = BdhUtils.getCurNetKey(paramContext).iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject;
      if (paramArrayList != null)
      {
        localObject = paramArrayList.iterator();
        int i = 0;
        while (((Iterator)localObject).hasNext())
        {
          EndPoint localEndPoint1 = (EndPoint)((Iterator)localObject).next();
          EndPoint localEndPoint2 = new EndPoint(localEndPoint1.host, localEndPoint1.port, localEndPoint1.type);
          localEndPoint2.ipIndex = i;
          localEndPoint2.keyOfAPN = str;
          localEndPoint2.isSameIsp = localEndPoint1.isSameIsp;
          localEndPoint2.timestamp = localEndPoint1.timestamp;
          localArrayList.add(localEndPoint2);
          BdhLogUtil.LogEvent("C", "IpContainer, insert() key= " + str + "   value= " + localEndPoint2.toString());
          i += 1;
        }
      }
      if (paramBoolean)
      {
        localObject = getOrCreateIpLearnerByKey(str);
        if (localObject != null) {
          paramConcurrentHashMap.put(str, ((IpLearning)localObject).adjustNewIpList(localArrayList));
        }
      }
      else
      {
        paramConcurrentHashMap.put(str, localArrayList);
      }
    }
  }
  
  /* Error */
  private PersistentConfig loadFromDisk(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 177	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 183	android/content/Context:getFilesDir	()Ljava/io/File;
    //   8: invokevirtual 186	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: aload_2
    //   12: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: invokevirtual 191	java/io/File:exists	()Z
    //   18: ifne +33 -> 51
    //   21: ldc 138
    //   23: new 140	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   30: ldc 193
    //   32: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 160	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: astore 5
    //   48: aload 5
    //   50: areturn
    //   51: new 195	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
    //   54: dup
    //   55: invokespecial 196	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
    //   58: astore 5
    //   60: aload_1
    //   61: aload_2
    //   62: invokevirtual 200	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   65: astore_1
    //   66: new 202	java/io/ByteArrayOutputStream
    //   69: dup
    //   70: invokespecial 203	java/io/ByteArrayOutputStream:<init>	()V
    //   73: astore 4
    //   75: aload 4
    //   77: astore 6
    //   79: aload_1
    //   80: astore 7
    //   82: sipush 1024
    //   85: newarray byte
    //   87: astore_2
    //   88: aload 4
    //   90: astore 6
    //   92: aload_1
    //   93: astore 7
    //   95: aload_1
    //   96: aload_2
    //   97: iconst_0
    //   98: aload_2
    //   99: arraylength
    //   100: invokevirtual 209	java/io/FileInputStream:read	([BII)I
    //   103: istore_3
    //   104: iload_3
    //   105: iconst_m1
    //   106: if_icmpeq +74 -> 180
    //   109: aload 4
    //   111: astore 6
    //   113: aload_1
    //   114: astore 7
    //   116: aload 4
    //   118: aload_2
    //   119: iconst_0
    //   120: iload_3
    //   121: invokevirtual 213	java/io/ByteArrayOutputStream:write	([BII)V
    //   124: goto -36 -> 88
    //   127: astore 5
    //   129: aload 4
    //   131: astore_2
    //   132: aconst_null
    //   133: astore 6
    //   135: aload_1
    //   136: astore 4
    //   138: aload 6
    //   140: astore_1
    //   141: ldc 138
    //   143: ldc 215
    //   145: aload 5
    //   147: invokestatic 219	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 222	java/io/FileInputStream:close	()V
    //   160: aload_1
    //   161: astore 5
    //   163: aload_2
    //   164: ifnull -116 -> 48
    //   167: aload_2
    //   168: invokevirtual 223	java/io/ByteArrayOutputStream:close	()V
    //   171: aload_1
    //   172: areturn
    //   173: astore_2
    //   174: aload_2
    //   175: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   178: aload_1
    //   179: areturn
    //   180: aload 4
    //   182: astore 6
    //   184: aload_1
    //   185: astore 7
    //   187: aload 4
    //   189: invokevirtual 229	java/io/ByteArrayOutputStream:flush	()V
    //   192: aload 4
    //   194: astore 6
    //   196: aload_1
    //   197: astore 7
    //   199: aload 5
    //   201: aload 4
    //   203: invokevirtual 233	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: invokevirtual 237	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   209: pop
    //   210: aload 4
    //   212: astore 6
    //   214: aload_1
    //   215: astore 7
    //   217: new 6	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig
    //   220: dup
    //   221: aload_0
    //   222: aconst_null
    //   223: invokespecial 240	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:<init>	(Lcom/tencent/mobileqq/highway/config/IpContainer;Lcom/tencent/mobileqq/highway/config/IpContainer$1;)V
    //   226: astore_2
    //   227: aload 4
    //   229: astore 6
    //   231: aload_1
    //   232: astore 7
    //   234: aload_2
    //   235: new 21	java/util/concurrent/ConcurrentHashMap
    //   238: dup
    //   239: invokespecial 24	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   242: putfield 243	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   245: aload 4
    //   247: astore 6
    //   249: aload_1
    //   250: astore 7
    //   252: aload_2
    //   253: new 21	java/util/concurrent/ConcurrentHashMap
    //   256: dup
    //   257: invokespecial 24	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   260: putfield 246	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   263: aload 4
    //   265: astore 6
    //   267: aload_1
    //   268: astore 7
    //   270: aload_2
    //   271: new 41	java/util/ArrayList
    //   274: dup
    //   275: invokespecial 110	java/util/ArrayList:<init>	()V
    //   278: putfield 250	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   281: aload 4
    //   283: astore 6
    //   285: aload_1
    //   286: astore 7
    //   288: aload_2
    //   289: new 41	java/util/ArrayList
    //   292: dup
    //   293: invokespecial 110	java/util/ArrayList:<init>	()V
    //   296: putfield 253	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
    //   299: aload 4
    //   301: astore 6
    //   303: aload_1
    //   304: astore 7
    //   306: aload 5
    //   308: getfield 257	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   311: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   314: invokeinterface 265 1 0
    //   319: astore 8
    //   321: aload 4
    //   323: astore 6
    //   325: aload_1
    //   326: astore 7
    //   328: aload 8
    //   330: invokeinterface 105 1 0
    //   335: ifeq +243 -> 578
    //   338: aload 4
    //   340: astore 6
    //   342: aload_1
    //   343: astore 7
    //   345: aload 8
    //   347: invokeinterface 109 1 0
    //   352: checkcast 267	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   355: astore 10
    //   357: aload 4
    //   359: astore 6
    //   361: aload_1
    //   362: astore 7
    //   364: aload 10
    //   366: getfield 271	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   369: invokevirtual 275	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   372: astore 9
    //   374: aload 4
    //   376: astore 6
    //   378: aload_1
    //   379: astore 7
    //   381: aload 10
    //   383: getfield 278	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   386: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   389: checkcast 41	java/util/ArrayList
    //   392: astore 11
    //   394: aload 4
    //   396: astore 6
    //   398: aload_1
    //   399: astore 7
    //   401: new 41	java/util/ArrayList
    //   404: dup
    //   405: invokespecial 110	java/util/ArrayList:<init>	()V
    //   408: astore 10
    //   410: aload 4
    //   412: astore 6
    //   414: aload_1
    //   415: astore 7
    //   417: aload 11
    //   419: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   422: astore 11
    //   424: aload 4
    //   426: astore 6
    //   428: aload_1
    //   429: astore 7
    //   431: aload 11
    //   433: invokeinterface 105 1 0
    //   438: ifeq +69 -> 507
    //   441: aload 4
    //   443: astore 6
    //   445: aload_1
    //   446: astore 7
    //   448: aload 11
    //   450: invokeinterface 109 1 0
    //   455: checkcast 280	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   458: astore 12
    //   460: aload 4
    //   462: astore 6
    //   464: aload_1
    //   465: astore 7
    //   467: aload 10
    //   469: new 51	com/tencent/mobileqq/highway/utils/EndPoint
    //   472: dup
    //   473: aload 12
    //   475: getfield 283	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   478: invokevirtual 275	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   481: aload 12
    //   483: getfield 287	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   486: invokevirtual 291	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   489: aload 12
    //   491: getfield 295	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   494: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   497: invokespecial 303	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
    //   500: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   503: pop
    //   504: goto -80 -> 424
    //   507: aload 4
    //   509: astore 6
    //   511: aload_1
    //   512: astore 7
    //   514: aload_2
    //   515: getfield 243	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   518: aload 9
    //   520: aload 10
    //   522: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   525: pop
    //   526: goto -205 -> 321
    //   529: astore 5
    //   531: aload 4
    //   533: astore 6
    //   535: aload_1
    //   536: astore 7
    //   538: ldc 138
    //   540: ldc_w 305
    //   543: aload 5
    //   545: invokestatic 219	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   548: aload_1
    //   549: ifnull +7 -> 556
    //   552: aload_1
    //   553: invokevirtual 222	java/io/FileInputStream:close	()V
    //   556: aload_2
    //   557: astore 5
    //   559: aload 4
    //   561: ifnull -513 -> 48
    //   564: aload 4
    //   566: invokevirtual 223	java/io/ByteArrayOutputStream:close	()V
    //   569: aload_2
    //   570: areturn
    //   571: astore_1
    //   572: aload_1
    //   573: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   576: aload_2
    //   577: areturn
    //   578: aload 4
    //   580: astore 6
    //   582: aload_1
    //   583: astore 7
    //   585: aload 5
    //   587: getfield 308	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   590: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   593: invokeinterface 265 1 0
    //   598: astore 8
    //   600: aload 4
    //   602: astore 6
    //   604: aload_1
    //   605: astore 7
    //   607: aload 8
    //   609: invokeinterface 105 1 0
    //   614: ifeq +222 -> 836
    //   617: aload 4
    //   619: astore 6
    //   621: aload_1
    //   622: astore 7
    //   624: aload 8
    //   626: invokeinterface 109 1 0
    //   631: checkcast 267	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   634: astore 10
    //   636: aload 4
    //   638: astore 6
    //   640: aload_1
    //   641: astore 7
    //   643: aload 10
    //   645: getfield 271	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   648: invokevirtual 275	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   651: astore 9
    //   653: aload 4
    //   655: astore 6
    //   657: aload_1
    //   658: astore 7
    //   660: aload 10
    //   662: getfield 278	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   665: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   668: checkcast 41	java/util/ArrayList
    //   671: astore 11
    //   673: aload 4
    //   675: astore 6
    //   677: aload_1
    //   678: astore 7
    //   680: new 41	java/util/ArrayList
    //   683: dup
    //   684: invokespecial 110	java/util/ArrayList:<init>	()V
    //   687: astore 10
    //   689: aload 4
    //   691: astore 6
    //   693: aload_1
    //   694: astore 7
    //   696: aload 11
    //   698: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   701: astore 11
    //   703: aload 4
    //   705: astore 6
    //   707: aload_1
    //   708: astore 7
    //   710: aload 11
    //   712: invokeinterface 105 1 0
    //   717: ifeq +97 -> 814
    //   720: aload 4
    //   722: astore 6
    //   724: aload_1
    //   725: astore 7
    //   727: aload 11
    //   729: invokeinterface 109 1 0
    //   734: checkcast 280	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   737: astore 12
    //   739: aload 4
    //   741: astore 6
    //   743: aload_1
    //   744: astore 7
    //   746: aload 10
    //   748: new 51	com/tencent/mobileqq/highway/utils/EndPoint
    //   751: dup
    //   752: aload 12
    //   754: getfield 283	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   757: invokevirtual 275	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   760: aload 12
    //   762: getfield 287	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   765: invokevirtual 291	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   768: aload 12
    //   770: getfield 295	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   773: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   776: invokespecial 303	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
    //   779: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   782: pop
    //   783: goto -80 -> 703
    //   786: astore_2
    //   787: aload 7
    //   789: astore_1
    //   790: aload 6
    //   792: astore 4
    //   794: aload_1
    //   795: ifnull +7 -> 802
    //   798: aload_1
    //   799: invokevirtual 222	java/io/FileInputStream:close	()V
    //   802: aload 4
    //   804: ifnull +8 -> 812
    //   807: aload 4
    //   809: invokevirtual 223	java/io/ByteArrayOutputStream:close	()V
    //   812: aload_2
    //   813: athrow
    //   814: aload 4
    //   816: astore 6
    //   818: aload_1
    //   819: astore 7
    //   821: aload_2
    //   822: getfield 246	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   825: aload 9
    //   827: aload 10
    //   829: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   832: pop
    //   833: goto -233 -> 600
    //   836: aload 4
    //   838: astore 6
    //   840: aload_1
    //   841: astore 7
    //   843: aload 5
    //   845: getfield 311	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   848: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   851: invokeinterface 265 1 0
    //   856: astore 8
    //   858: aload 4
    //   860: astore 6
    //   862: aload_1
    //   863: astore 7
    //   865: aload 8
    //   867: invokeinterface 105 1 0
    //   872: ifeq +90 -> 962
    //   875: aload 4
    //   877: astore 6
    //   879: aload_1
    //   880: astore 7
    //   882: aload 8
    //   884: invokeinterface 109 1 0
    //   889: checkcast 313	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   892: astore 9
    //   894: aload 4
    //   896: astore 6
    //   898: aload_1
    //   899: astore 7
    //   901: new 315	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   904: dup
    //   905: aload 9
    //   907: getfield 318	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   910: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   913: aload 9
    //   915: getfield 321	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   918: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   921: aload 9
    //   923: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   926: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   929: aload 9
    //   931: getfield 327	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   934: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   937: invokespecial 330	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
    //   940: astore 9
    //   942: aload 4
    //   944: astore 6
    //   946: aload_1
    //   947: astore 7
    //   949: aload_2
    //   950: getfield 250	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   953: aload 9
    //   955: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   958: pop
    //   959: goto -101 -> 858
    //   962: aload 4
    //   964: astore 6
    //   966: aload_1
    //   967: astore 7
    //   969: aload 5
    //   971: getfield 333	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   974: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   977: invokeinterface 265 1 0
    //   982: astore 5
    //   984: aload 4
    //   986: astore 6
    //   988: aload_1
    //   989: astore 7
    //   991: aload 5
    //   993: invokeinterface 105 1 0
    //   998: ifeq +90 -> 1088
    //   1001: aload 4
    //   1003: astore 6
    //   1005: aload_1
    //   1006: astore 7
    //   1008: aload 5
    //   1010: invokeinterface 109 1 0
    //   1015: checkcast 313	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   1018: astore 8
    //   1020: aload 4
    //   1022: astore 6
    //   1024: aload_1
    //   1025: astore 7
    //   1027: new 315	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   1030: dup
    //   1031: aload 8
    //   1033: getfield 318	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1036: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1039: aload 8
    //   1041: getfield 321	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1044: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1047: aload 8
    //   1049: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1052: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1055: aload 8
    //   1057: getfield 327	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   1060: invokevirtual 300	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   1063: invokespecial 330	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
    //   1066: astore 8
    //   1068: aload 4
    //   1070: astore 6
    //   1072: aload_1
    //   1073: astore 7
    //   1075: aload_2
    //   1076: getfield 253	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
    //   1079: aload 8
    //   1081: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1084: pop
    //   1085: goto -101 -> 984
    //   1088: aload_1
    //   1089: ifnull +7 -> 1096
    //   1092: aload_1
    //   1093: invokevirtual 222	java/io/FileInputStream:close	()V
    //   1096: aload 4
    //   1098: ifnull +152 -> 1250
    //   1101: aload 4
    //   1103: invokevirtual 223	java/io/ByteArrayOutputStream:close	()V
    //   1106: aload_2
    //   1107: areturn
    //   1108: astore_1
    //   1109: aload_1
    //   1110: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   1113: goto -17 -> 1096
    //   1116: astore_1
    //   1117: aload_1
    //   1118: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   1121: aload_2
    //   1122: areturn
    //   1123: astore 4
    //   1125: aload 4
    //   1127: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   1130: goto -970 -> 160
    //   1133: astore_1
    //   1134: aload_1
    //   1135: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   1138: goto -582 -> 556
    //   1141: astore_1
    //   1142: aload_1
    //   1143: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   1146: goto -344 -> 802
    //   1149: astore_1
    //   1150: aload_1
    //   1151: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   1154: goto -342 -> 812
    //   1157: astore_2
    //   1158: aconst_null
    //   1159: astore 4
    //   1161: aconst_null
    //   1162: astore_1
    //   1163: goto -369 -> 794
    //   1166: astore_2
    //   1167: aconst_null
    //   1168: astore 4
    //   1170: goto -376 -> 794
    //   1173: astore 6
    //   1175: aload_2
    //   1176: astore_1
    //   1177: aload 4
    //   1179: astore 5
    //   1181: aload 6
    //   1183: astore_2
    //   1184: aload_1
    //   1185: astore 4
    //   1187: aload 5
    //   1189: astore_1
    //   1190: goto -396 -> 794
    //   1193: astore 5
    //   1195: aconst_null
    //   1196: astore 4
    //   1198: aconst_null
    //   1199: astore_1
    //   1200: aconst_null
    //   1201: astore_2
    //   1202: goto -671 -> 531
    //   1205: astore 5
    //   1207: aconst_null
    //   1208: astore 4
    //   1210: aconst_null
    //   1211: astore_2
    //   1212: goto -681 -> 531
    //   1215: astore 5
    //   1217: aconst_null
    //   1218: astore_2
    //   1219: goto -688 -> 531
    //   1222: astore 5
    //   1224: aconst_null
    //   1225: astore_1
    //   1226: aconst_null
    //   1227: astore 4
    //   1229: aconst_null
    //   1230: astore_2
    //   1231: goto -1090 -> 141
    //   1234: astore 5
    //   1236: aconst_null
    //   1237: astore_2
    //   1238: aconst_null
    //   1239: astore 6
    //   1241: aload_1
    //   1242: astore 4
    //   1244: aload 6
    //   1246: astore_1
    //   1247: goto -1106 -> 141
    //   1250: aload_2
    //   1251: areturn
    //   1252: astore 5
    //   1254: aload_1
    //   1255: astore 6
    //   1257: aload_2
    //   1258: astore_1
    //   1259: aload 4
    //   1261: astore_2
    //   1262: aload 6
    //   1264: astore 4
    //   1266: goto -1125 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1269	0	this	IpContainer
    //   0	1269	1	paramContext	Context
    //   0	1269	2	paramString	String
    //   103	18	3	i	int
    //   73	1029	4	localObject1	Object
    //   1123	3	4	localIOException1	java.io.IOException
    //   1159	106	4	localObject2	Object
    //   46	13	5	localObject3	Object
    //   127	19	5	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   161	146	5	localContext1	Context
    //   529	15	5	localIOException2	java.io.IOException
    //   557	631	5	localObject4	Object
    //   1193	1	5	localIOException3	java.io.IOException
    //   1205	1	5	localIOException4	java.io.IOException
    //   1215	1	5	localIOException5	java.io.IOException
    //   1222	1	5	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1234	1	5	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1252	1	5	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   77	994	6	localObject5	Object
    //   1173	9	6	localObject6	Object
    //   1239	24	6	localContext2	Context
    //   80	994	7	localContext3	Context
    //   319	761	8	localObject7	Object
    //   372	582	9	localObject8	Object
    //   355	473	10	localObject9	Object
    //   392	336	11	localObject10	Object
    //   458	311	12	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
    // Exception table:
    //   from	to	target	type
    //   82	88	127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   95	104	127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   116	124	127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   187	192	127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   199	210	127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   217	227	127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   167	171	173	java/io/IOException
    //   234	245	529	java/io/IOException
    //   252	263	529	java/io/IOException
    //   270	281	529	java/io/IOException
    //   288	299	529	java/io/IOException
    //   306	321	529	java/io/IOException
    //   328	338	529	java/io/IOException
    //   345	357	529	java/io/IOException
    //   364	374	529	java/io/IOException
    //   381	394	529	java/io/IOException
    //   401	410	529	java/io/IOException
    //   417	424	529	java/io/IOException
    //   431	441	529	java/io/IOException
    //   448	460	529	java/io/IOException
    //   467	504	529	java/io/IOException
    //   514	526	529	java/io/IOException
    //   585	600	529	java/io/IOException
    //   607	617	529	java/io/IOException
    //   624	636	529	java/io/IOException
    //   643	653	529	java/io/IOException
    //   660	673	529	java/io/IOException
    //   680	689	529	java/io/IOException
    //   696	703	529	java/io/IOException
    //   710	720	529	java/io/IOException
    //   727	739	529	java/io/IOException
    //   746	783	529	java/io/IOException
    //   821	833	529	java/io/IOException
    //   843	858	529	java/io/IOException
    //   865	875	529	java/io/IOException
    //   882	894	529	java/io/IOException
    //   901	942	529	java/io/IOException
    //   949	959	529	java/io/IOException
    //   969	984	529	java/io/IOException
    //   991	1001	529	java/io/IOException
    //   1008	1020	529	java/io/IOException
    //   1027	1068	529	java/io/IOException
    //   1075	1085	529	java/io/IOException
    //   564	569	571	java/io/IOException
    //   82	88	786	finally
    //   95	104	786	finally
    //   116	124	786	finally
    //   187	192	786	finally
    //   199	210	786	finally
    //   217	227	786	finally
    //   234	245	786	finally
    //   252	263	786	finally
    //   270	281	786	finally
    //   288	299	786	finally
    //   306	321	786	finally
    //   328	338	786	finally
    //   345	357	786	finally
    //   364	374	786	finally
    //   381	394	786	finally
    //   401	410	786	finally
    //   417	424	786	finally
    //   431	441	786	finally
    //   448	460	786	finally
    //   467	504	786	finally
    //   514	526	786	finally
    //   538	548	786	finally
    //   585	600	786	finally
    //   607	617	786	finally
    //   624	636	786	finally
    //   643	653	786	finally
    //   660	673	786	finally
    //   680	689	786	finally
    //   696	703	786	finally
    //   710	720	786	finally
    //   727	739	786	finally
    //   746	783	786	finally
    //   821	833	786	finally
    //   843	858	786	finally
    //   865	875	786	finally
    //   882	894	786	finally
    //   901	942	786	finally
    //   949	959	786	finally
    //   969	984	786	finally
    //   991	1001	786	finally
    //   1008	1020	786	finally
    //   1027	1068	786	finally
    //   1075	1085	786	finally
    //   1092	1096	1108	java/io/IOException
    //   1101	1106	1116	java/io/IOException
    //   155	160	1123	java/io/IOException
    //   552	556	1133	java/io/IOException
    //   798	802	1141	java/io/IOException
    //   807	812	1149	java/io/IOException
    //   60	66	1157	finally
    //   66	75	1166	finally
    //   141	150	1173	finally
    //   60	66	1193	java/io/IOException
    //   66	75	1205	java/io/IOException
    //   82	88	1215	java/io/IOException
    //   95	104	1215	java/io/IOException
    //   116	124	1215	java/io/IOException
    //   187	192	1215	java/io/IOException
    //   199	210	1215	java/io/IOException
    //   217	227	1215	java/io/IOException
    //   60	66	1222	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   66	75	1234	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   234	245	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   252	263	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   270	281	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   288	299	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   306	321	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   328	338	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   345	357	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   364	374	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   381	394	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   401	410	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   417	424	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   431	441	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   448	460	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   467	504	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   514	526	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   585	600	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   607	617	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   624	636	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   643	653	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   660	673	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   680	689	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   696	703	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   710	720	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   727	739	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   746	783	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   821	833	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   843	858	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   865	875	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   882	894	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   901	942	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   949	959	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   969	984	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   991	1001	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1008	1020	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1027	1068	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1075	1085	1252	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private PersistentConfig readDiskOrCreateNew(Context paramContext, String paramString)
  {
    paramContext = loadFromDisk(paramContext, paramString);
    if (paramContext == null)
    {
      paramContext = new PersistentConfig(null);
      paramContext.mIpList = new ConcurrentHashMap();
      paramContext.mIpv6List = new ConcurrentHashMap();
      paramContext.mSegConf = new ArrayList();
      paramContext.mShortVideoSegConf = new ArrayList();
      BdhLogUtil.LogEvent("C", "IpContainer, " + paramString + " does NOT exists.");
      return paramContext;
    }
    BdhLogUtil.LogEvent("C", "IpContainer, " + paramString + " does exists.");
    return paramContext;
  }
  
  public static void refreshIpLearning()
  {
    if (mIpLearners != null) {
      mIpLearners.clear();
    }
  }
  
  /* Error */
  private void write2disk(Context paramContext, String paramString, PersistentConfig paramPersistentConfig)
  {
    // Byte code:
    //   0: new 195	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
    //   3: dup
    //   4: invokespecial 196	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
    //   7: astore 4
    //   9: aload_3
    //   10: getfield 243	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 353	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   16: invokeinterface 356 1 0
    //   21: astore 5
    //   23: aload 5
    //   25: invokeinterface 105 1 0
    //   30: ifeq +178 -> 208
    //   33: aload 5
    //   35: invokeinterface 109 1 0
    //   40: checkcast 358	java/util/Map$Entry
    //   43: astore 7
    //   45: aload 7
    //   47: invokeinterface 361 1 0
    //   52: checkcast 56	java/lang/String
    //   55: astore 6
    //   57: aload 7
    //   59: invokeinterface 364 1 0
    //   64: checkcast 41	java/util/ArrayList
    //   67: astore 8
    //   69: new 41	java/util/ArrayList
    //   72: dup
    //   73: invokespecial 110	java/util/ArrayList:<init>	()V
    //   76: astore 7
    //   78: aload 8
    //   80: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   83: astore 8
    //   85: aload 8
    //   87: invokeinterface 105 1 0
    //   92: ifeq +74 -> 166
    //   95: aload 8
    //   97: invokeinterface 109 1 0
    //   102: checkcast 51	com/tencent/mobileqq/highway/utils/EndPoint
    //   105: astore 9
    //   107: new 280	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   110: dup
    //   111: invokespecial 365	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
    //   114: astore 10
    //   116: aload 10
    //   118: getfield 283	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   121: aload 9
    //   123: getfield 54	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   126: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   129: aload 10
    //   131: getfield 287	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   134: aload 9
    //   136: getfield 113	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   139: invokevirtual 372	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   142: aload 10
    //   144: getfield 295	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   147: aload 9
    //   149: getfield 133	com/tencent/mobileqq/highway/utils/EndPoint:timestamp	J
    //   152: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   155: aload 7
    //   157: aload 10
    //   159: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   162: pop
    //   163: goto -78 -> 85
    //   166: new 267	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   169: dup
    //   170: invokespecial 376	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
    //   173: astore 8
    //   175: aload 8
    //   177: getfield 271	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   180: aload 6
    //   182: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   185: aload 8
    //   187: getfield 278	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   190: aload 7
    //   192: invokevirtual 379	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   195: aload 4
    //   197: getfield 257	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   200: aload 8
    //   202: invokevirtual 382	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   205: goto -182 -> 23
    //   208: aload_3
    //   209: getfield 246	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   212: invokevirtual 353	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   215: invokeinterface 356 1 0
    //   220: astore 5
    //   222: aload 5
    //   224: invokeinterface 105 1 0
    //   229: ifeq +178 -> 407
    //   232: aload 5
    //   234: invokeinterface 109 1 0
    //   239: checkcast 358	java/util/Map$Entry
    //   242: astore 7
    //   244: aload 7
    //   246: invokeinterface 361 1 0
    //   251: checkcast 56	java/lang/String
    //   254: astore 6
    //   256: aload 7
    //   258: invokeinterface 364 1 0
    //   263: checkcast 41	java/util/ArrayList
    //   266: astore 8
    //   268: new 41	java/util/ArrayList
    //   271: dup
    //   272: invokespecial 110	java/util/ArrayList:<init>	()V
    //   275: astore 7
    //   277: aload 8
    //   279: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   282: astore 8
    //   284: aload 8
    //   286: invokeinterface 105 1 0
    //   291: ifeq +74 -> 365
    //   294: aload 8
    //   296: invokeinterface 109 1 0
    //   301: checkcast 51	com/tencent/mobileqq/highway/utils/EndPoint
    //   304: astore 9
    //   306: new 280	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   309: dup
    //   310: invokespecial 365	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
    //   313: astore 10
    //   315: aload 10
    //   317: getfield 283	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   320: aload 9
    //   322: getfield 54	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   325: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   328: aload 10
    //   330: getfield 287	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   333: aload 9
    //   335: getfield 113	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   338: invokevirtual 372	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   341: aload 10
    //   343: getfield 295	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   346: aload 9
    //   348: getfield 133	com/tencent/mobileqq/highway/utils/EndPoint:timestamp	J
    //   351: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   354: aload 7
    //   356: aload 10
    //   358: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   361: pop
    //   362: goto -78 -> 284
    //   365: new 267	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   368: dup
    //   369: invokespecial 376	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
    //   372: astore 8
    //   374: aload 8
    //   376: getfield 271	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   379: aload 6
    //   381: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   384: aload 8
    //   386: getfield 278	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   389: aload 7
    //   391: invokevirtual 379	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   394: aload 4
    //   396: getfield 308	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   399: aload 8
    //   401: invokevirtual 382	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   404: goto -182 -> 222
    //   407: new 41	java/util/ArrayList
    //   410: dup
    //   411: invokespecial 110	java/util/ArrayList:<init>	()V
    //   414: astore 5
    //   416: aload_3
    //   417: getfield 250	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   420: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   423: astore 6
    //   425: aload 6
    //   427: invokeinterface 105 1 0
    //   432: ifeq +87 -> 519
    //   435: aload 6
    //   437: invokeinterface 109 1 0
    //   442: checkcast 315	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   445: astore 7
    //   447: new 313	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   450: dup
    //   451: invokespecial 383	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
    //   454: astore 8
    //   456: aload 8
    //   458: getfield 318	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   461: aload 7
    //   463: getfield 386	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
    //   466: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   469: aload 8
    //   471: getfield 321	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   474: aload 7
    //   476: getfield 389	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
    //   479: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   482: aload 8
    //   484: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   487: aload 7
    //   489: getfield 392	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
    //   492: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   495: aload 8
    //   497: getfield 327	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   500: aload 7
    //   502: getfield 395	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
    //   505: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   508: aload 5
    //   510: aload 8
    //   512: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   515: pop
    //   516: goto -91 -> 425
    //   519: aload 4
    //   521: getfield 311	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   524: aload 5
    //   526: invokevirtual 379	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   529: new 41	java/util/ArrayList
    //   532: dup
    //   533: invokespecial 110	java/util/ArrayList:<init>	()V
    //   536: astore 5
    //   538: aload_3
    //   539: getfield 250	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   542: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   545: astore_3
    //   546: aload_3
    //   547: invokeinterface 105 1 0
    //   552: ifeq +86 -> 638
    //   555: aload_3
    //   556: invokeinterface 109 1 0
    //   561: checkcast 315	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   564: astore 6
    //   566: new 313	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   569: dup
    //   570: invokespecial 383	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
    //   573: astore 7
    //   575: aload 7
    //   577: getfield 318	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   580: aload 6
    //   582: getfield 386	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
    //   585: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   588: aload 7
    //   590: getfield 321	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   593: aload 6
    //   595: getfield 389	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
    //   598: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   601: aload 7
    //   603: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   606: aload 6
    //   608: getfield 392	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
    //   611: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   614: aload 7
    //   616: getfield 327	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   619: aload 6
    //   621: getfield 395	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
    //   624: invokevirtual 375	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   627: aload 5
    //   629: aload 7
    //   631: invokevirtual 136	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   634: pop
    //   635: goto -89 -> 546
    //   638: aload 4
    //   640: getfield 333	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   643: aload 5
    //   645: invokevirtual 379	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   648: new 177	java/io/File
    //   651: dup
    //   652: aload_1
    //   653: invokevirtual 183	android/content/Context:getFilesDir	()Ljava/io/File;
    //   656: invokevirtual 186	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   659: aload_2
    //   660: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: astore_1
    //   664: new 397	java/io/FileOutputStream
    //   667: dup
    //   668: aload_1
    //   669: invokespecial 400	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   672: astore_3
    //   673: aload_3
    //   674: astore_1
    //   675: aload_3
    //   676: aload 4
    //   678: invokevirtual 401	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:toByteArray	()[B
    //   681: invokevirtual 404	java/io/FileOutputStream:write	([B)V
    //   684: aload_3
    //   685: astore_1
    //   686: ldc 138
    //   688: new 140	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 406
    //   698: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_2
    //   702: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 160	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   711: aload_3
    //   712: ifnull +7 -> 719
    //   715: aload_3
    //   716: invokevirtual 407	java/io/FileOutputStream:close	()V
    //   719: return
    //   720: astore_1
    //   721: aload_1
    //   722: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   725: return
    //   726: astore 4
    //   728: aconst_null
    //   729: astore_3
    //   730: aload_3
    //   731: astore_1
    //   732: ldc 138
    //   734: new 140	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 409
    //   744: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload_2
    //   748: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: aload 4
    //   756: invokestatic 219	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   759: aload_3
    //   760: ifnull -41 -> 719
    //   763: aload_3
    //   764: invokevirtual 407	java/io/FileOutputStream:close	()V
    //   767: return
    //   768: astore_1
    //   769: aload_1
    //   770: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   773: return
    //   774: astore_2
    //   775: aconst_null
    //   776: astore_3
    //   777: aload_3
    //   778: astore_1
    //   779: ldc 138
    //   781: ldc_w 411
    //   784: aload_2
    //   785: invokestatic 219	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   788: aload_3
    //   789: ifnull -70 -> 719
    //   792: aload_3
    //   793: invokevirtual 407	java/io/FileOutputStream:close	()V
    //   796: return
    //   797: astore_1
    //   798: aload_1
    //   799: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   802: return
    //   803: astore_2
    //   804: aconst_null
    //   805: astore_1
    //   806: aload_1
    //   807: ifnull +7 -> 814
    //   810: aload_1
    //   811: invokevirtual 407	java/io/FileOutputStream:close	()V
    //   814: aload_2
    //   815: athrow
    //   816: astore_1
    //   817: aload_1
    //   818: invokevirtual 226	java/io/IOException:printStackTrace	()V
    //   821: goto -7 -> 814
    //   824: astore_2
    //   825: goto -19 -> 806
    //   828: astore_2
    //   829: goto -52 -> 777
    //   832: astore 4
    //   834: goto -104 -> 730
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	IpContainer
    //   0	837	1	paramContext	Context
    //   0	837	2	paramString	String
    //   0	837	3	paramPersistentConfig	PersistentConfig
    //   7	670	4	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
    //   726	29	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   832	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   21	623	5	localObject1	Object
    //   55	565	6	localObject2	Object
    //   43	587	7	localObject3	Object
    //   67	444	8	localObject4	Object
    //   105	242	9	localEndPoint	EndPoint
    //   114	243	10	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
    // Exception table:
    //   from	to	target	type
    //   715	719	720	java/io/IOException
    //   664	673	726	java/io/FileNotFoundException
    //   763	767	768	java/io/IOException
    //   664	673	774	java/io/IOException
    //   792	796	797	java/io/IOException
    //   664	673	803	finally
    //   810	814	816	java/io/IOException
    //   675	684	824	finally
    //   686	711	824	finally
    //   732	759	824	finally
    //   779	788	824	finally
    //   675	684	828	java/io/IOException
    //   686	711	828	java/io/IOException
    //   675	684	832	java/io/FileNotFoundException
    //   686	711	832	java/io/FileNotFoundException
  }
  
  public boolean addNew(Context paramContext, HwConfig paramHwConfig, AppRuntime paramAppRuntime, ConfigManager paramConfigManager)
  {
    try
    {
      BdhLogUtil.LogEvent("C", "IpContainer, addNew() " + paramHwConfig.ipList2String());
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = paramHwConfig.ipList.iterator();
      while (paramAppRuntime.hasNext()) {
        ((EndPoint)paramAppRuntime.next()).timestamp = l;
      }
      paramAppRuntime = readDiskOrCreateNew(paramContext, this.mFileName);
    }
    finally {}
    if ((paramHwConfig != null) && (paramHwConfig.ipList != null) && (!paramHwConfig.ipList.isEmpty()))
    {
      insertOrReplace(paramContext, paramAppRuntime.mIpList, paramHwConfig.ipList, false);
      insertOrReplace(paramContext, this.mCfg.mIpList, paramHwConfig.ipList, true);
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (paramHwConfig != null)
      {
        bool1 = bool2;
        if (paramHwConfig.ipv6List != null)
        {
          bool1 = bool2;
          if (!paramHwConfig.ipv6List.isEmpty())
          {
            insertOrReplace(paramContext, paramAppRuntime.mIpv6List, paramHwConfig.ipv6List, false);
            insertOrReplace(paramContext, this.mCfg.mIpv6List, paramHwConfig.ipv6List, true);
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if (paramHwConfig != null)
      {
        bool2 = bool1;
        if (paramHwConfig.ipList != null)
        {
          bool2 = bool1;
          if (!paramHwConfig.ipList.isEmpty()) {
            if (paramHwConfig.ipv6List != null)
            {
              bool2 = bool1;
              if (!paramHwConfig.ipv6List.isEmpty()) {}
            }
            else
            {
              insertOrReplace(paramContext, paramAppRuntime.mIpv6List, paramHwConfig.ipv6List, false);
              insertOrReplace(paramContext, this.mCfg.mIpv6List, paramHwConfig.ipv6List, true);
              bool2 = true;
            }
          }
        }
      }
      bool1 = bool2;
      if (paramHwConfig != null)
      {
        bool1 = bool2;
        if (paramHwConfig.netSegConfList != null)
        {
          bool1 = bool2;
          if (!paramHwConfig.netSegConfList.isEmpty())
          {
            paramAppRuntime.mSegConf = paramHwConfig.netSegConfList;
            paramAppRuntime.mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
            this.mCfg.mSegConf = paramHwConfig.netSegConfList;
            this.mCfg.mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
            bool1 = true;
          }
        }
      }
      if (bool1) {
        write2disk(paramContext, this.mFileName, paramAppRuntime);
      }
      return bool1;
    }
  }
  
  public void cleanIpv6Cfg(Context paramContext)
  {
    this.mCfg.mIpv6List.clear();
    write2disk(paramContext, this.mFileName, this.mCfg);
  }
  
  public boolean fail(String paramString, boolean paramBoolean)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (this.mCfg == null)
        {
          BdhLogUtil.LogEvent("C", "IpContainer, fail() found due to mCfg == null");
          paramBoolean = bool1;
          return paramBoolean;
        }
        if ((paramBoolean) && ((this.mCfg.mIpv6List == null) || (this.mCfg.mIpv6List.isEmpty())))
        {
          BdhLogUtil.LogEvent("C", "IpContainer, fail() found due to mCfg.mIpv6List == null || mCfg.mIpv6List.isEmpty()");
          paramBoolean = bool1;
          continue;
        }
        if (paramBoolean) {
          break label110;
        }
      }
      finally {}
      if ((this.mCfg.mIpList == null) || (this.mCfg.mIpList.isEmpty()))
      {
        BdhLogUtil.LogEvent("C", "IpContainer, fail() found due to mCfg.mIpList == null || mCfg.mIpList.isEmpty()");
        paramBoolean = bool1;
      }
      else
      {
        label110:
        ArrayList localArrayList2 = new ArrayList();
        Object localObject;
        String str;
        if (paramBoolean)
        {
          localObject = this.mCfg.mIpv6List.keySet().iterator();
          bool1 = false;
          if (!((Iterator)localObject).hasNext()) {
            break label326;
          }
          str = (String)((Iterator)localObject).next();
          if (!paramBoolean) {
            break label306;
          }
        }
        label306:
        for (ArrayList localArrayList1 = (ArrayList)this.mCfg.mIpv6List.get(str);; localArrayList1 = (ArrayList)this.mCfg.mIpList.get(str))
        {
          boolean bool2 = bool1;
          if (findNRemove(localArrayList1, paramString))
          {
            bool2 = true;
            BdhLogUtil.LogEvent("C", "IpContainer, fail() remove ip " + paramString + " in " + str + " which has " + (localArrayList1.size() + 1) + " IPs");
          }
          bool1 = bool2;
          if (!localArrayList1.isEmpty()) {
            break;
          }
          localArrayList2.add(str);
          bool1 = bool2;
          break;
          localObject = this.mCfg.mIpList.keySet().iterator();
          bool1 = false;
          break;
        }
        label326:
        paramString = localArrayList2.iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          BdhLogUtil.LogEvent("C", "IpContainer, fail() " + (String)localObject + " is empty, remove it");
          if (paramBoolean) {
            this.mCfg.mIpv6List.remove(localObject);
          } else {
            this.mCfg.mIpList.remove(localObject);
          }
        }
        if (!bool1) {
          BdhLogUtil.LogEvent("C", "IpContainer, fail() found NONE");
        }
        paramBoolean = bool1;
      }
    }
  }
  
  /* Error */
  public EndPoint findIpCurNet(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 95	com/tencent/mobileqq/highway/utils/BdhUtils:getCurNetKey	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   6: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 105 1 0
    //   16: ifeq +74 -> 90
    //   19: aload_3
    //   20: invokeinterface 109 1 0
    //   25: checkcast 56	java/lang/String
    //   28: astore_1
    //   29: iload_2
    //   30: ifeq +42 -> 72
    //   33: aload_0
    //   34: getfield 37	com/tencent/mobileqq/highway/config/IpContainer:mCfg	Lcom/tencent/mobileqq/highway/config/IpContainer$PersistentConfig;
    //   37: getfield 246	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload_1
    //   41: invokevirtual 461	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 41	java/util/ArrayList
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull -39 -> 10
    //   52: aload_1
    //   53: invokevirtual 431	java/util/ArrayList:isEmpty	()Z
    //   56: ifne -46 -> 10
    //   59: aload_1
    //   60: iconst_0
    //   61: invokevirtual 49	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   64: checkcast 51	com/tencent/mobileqq/highway/utils/EndPoint
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: areturn
    //   72: aload_0
    //   73: getfield 37	com/tencent/mobileqq/highway/config/IpContainer:mCfg	Lcom/tencent/mobileqq/highway/config/IpContainer$PersistentConfig;
    //   76: getfield 243	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   79: aload_1
    //   80: invokevirtual 461	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 41	java/util/ArrayList
    //   86: astore_1
    //   87: goto -39 -> 48
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -24 -> 68
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	IpContainer
    //   0	100	1	paramContext	Context
    //   0	100	2	paramBoolean	boolean
    //   9	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	10	95	finally
    //   10	29	95	finally
    //   33	48	95	finally
    //   52	68	95	finally
    //   72	87	95	finally
  }
  
  /* Error */
  public ArrayList<EndPoint> findIpCurNetList(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 95	com/tencent/mobileqq/highway/utils/BdhUtils:getCurNetKey	(Landroid/content/Context;)Ljava/util/ArrayList;
    //   6: invokevirtual 99	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 4
    //   11: aload 4
    //   13: invokeinterface 105 1 0
    //   18: ifeq +68 -> 86
    //   21: aload 4
    //   23: invokeinterface 109 1 0
    //   28: checkcast 56	java/lang/String
    //   31: astore_1
    //   32: iload_2
    //   33: ifeq +35 -> 68
    //   36: aload_0
    //   37: getfield 37	com/tencent/mobileqq/highway/config/IpContainer:mCfg	Lcom/tencent/mobileqq/highway/config/IpContainer$PersistentConfig;
    //   40: getfield 246	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: aload_1
    //   44: invokevirtual 461	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 41	java/util/ArrayList
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull -41 -> 11
    //   55: aload_1
    //   56: invokevirtual 431	java/util/ArrayList:isEmpty	()Z
    //   59: istore_3
    //   60: iload_3
    //   61: ifne -50 -> 11
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: aload_0
    //   69: getfield 37	com/tencent/mobileqq/highway/config/IpContainer:mCfg	Lcom/tencent/mobileqq/highway/config/IpContainer$PersistentConfig;
    //   72: getfield 243	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: aload_1
    //   76: invokevirtual 461	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 41	java/util/ArrayList
    //   82: astore_1
    //   83: goto -32 -> 51
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -24 -> 64
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	IpContainer
    //   0	96	1	paramContext	Context
    //   0	96	2	paramBoolean	boolean
    //   59	2	3	bool	boolean
    //   9	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	11	91	finally
    //   11	32	91	finally
    //   36	51	91	finally
    //   55	60	91	finally
    //   68	83	91	finally
  }
  
  public EndPoint findIpRecent(Context paramContext, boolean paramBoolean)
  {
    long l = -1L;
    paramContext = null;
    if (paramBoolean) {}
    label139:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.mCfg.mIpv6List.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (ArrayList)((Map.Entry)localIterator.next()).getValue();
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            localObject = (EndPoint)((ArrayList)localObject).get(0);
            if ((localObject != null) && (((EndPoint)localObject).timestamp > l))
            {
              l = ((EndPoint)localObject).timestamp;
              paramContext = (Context)localObject;
              break label139;
              localIterator = this.mCfg.mIpList.entrySet().iterator();
            }
          }
        }
        else
        {
          return paramContext;
        }
      }
      finally {}
    }
  }
  
  public ArrayList<HwNetSegConf> getNetSegConf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.mCfg.mSegConf;
    case 0: 
      return this.mCfg.mSegConf;
    }
    return this.mCfg.mShortVideoSegConf;
  }
  
  public ArrayList<HwNetSegConf> getNetSegConf(Context paramContext)
  {
    return getNetSegConf(0);
  }
  
  public boolean isEmpty()
  {
    if (this.mCfg == null) {}
    while (((this.mCfg.mIpv6List == null) || (this.mCfg.mIpv6List.isEmpty())) && ((this.mCfg.mIpList == null) || (this.mCfg.mIpList.isEmpty()))) {
      return true;
    }
    return false;
  }
  
  public boolean isEmpty(boolean paramBoolean)
  {
    if (this.mCfg == null) {}
    do
    {
      return true;
      if (!paramBoolean) {
        break;
      }
    } while ((this.mCfg.mIpv6List == null) || (this.mCfg.mIpv6List.isEmpty()));
    do
    {
      return false;
      if (this.mCfg.mIpList == null) {
        break;
      }
    } while (!this.mCfg.mIpList.isEmpty());
    return true;
  }
  
  public void onConnFailed(EndPoint paramEndPoint)
  {
    if ((paramEndPoint == null) || ("".equalsIgnoreCase(paramEndPoint.keyOfAPN))) {}
    IpLearning localIpLearning;
    do
    {
      return;
      localIpLearning = getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN);
    } while (localIpLearning == null);
    localIpLearning.onIpConnFail(paramEndPoint.host, paramEndPoint.port);
  }
  
  public void onConnSuccess(EndPoint paramEndPoint)
  {
    if ((paramEndPoint == null) || ("".equalsIgnoreCase(paramEndPoint.keyOfAPN))) {}
    IpLearning localIpLearning;
    do
    {
      return;
      localIpLearning = getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN);
    } while (localIpLearning == null);
    localIpLearning.onIpConnSucc(paramEndPoint.host, paramEndPoint.port, paramEndPoint.isSameIsp);
  }
  
  class PersistentConfig
  {
    public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpList;
    public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpv6List;
    public ArrayList<HwNetSegConf> mSegConf;
    public ArrayList<HwNetSegConf> mShortVideoSegConf;
    
    private PersistentConfig() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.IpContainer
 * JD-Core Version:    0.7.0.1
 */