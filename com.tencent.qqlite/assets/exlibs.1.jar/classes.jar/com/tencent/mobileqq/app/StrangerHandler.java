package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cwq;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.GroupInfo;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.LoginInfo;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqBody;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetInfo;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetList;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.RspGetInfo;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StrangerHandler
  extends BusinessHandler
{
  public static final int a = 1;
  public static final String a = "OidbSvc.0x5d2_0";
  private static final boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  public static final String b = "OidbSvc.0x5d4_0";
  public static final int c = 1;
  private static final String c = "StrangerHandler";
  public static final int d = 2;
  private static final String d = "StrangerHandlerSubCmd";
  public static final int e = 3;
  private static final String e = "StrangerHandlerSeqId";
  public static final int f = 4;
  private static final String f = "StrangerHandlerGetInfoList";
  public static final int g = 0;
  public static final int h = 1;
  private static final int i = 60000;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  private HashMap b = null;
  
  StrangerHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StrangerHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 102	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +25 -> 33
    //   11: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 19
    //   19: iconst_2
    //   20: ldc 104
    //   22: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: iconst_2
    //   27: iconst_0
    //   28: aconst_null
    //   29: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   32: return
    //   33: new 109	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   36: dup
    //   37: invokespecial 110	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   40: astore 6
    //   42: aconst_null
    //   43: astore_3
    //   44: aload 6
    //   46: aload_2
    //   47: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   50: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   53: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   56: invokevirtual 117	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   59: pop
    //   60: aload_1
    //   61: ldc 26
    //   63: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   66: checkcast 125	java/lang/Integer
    //   69: invokevirtual 128	java/lang/Integer:intValue	()I
    //   72: istore 4
    //   74: aload 6
    //   76: getfield 132	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 137	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 5
    //   87: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 19
    //   95: iconst_2
    //   96: new 139	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   103: ldc 142
    //   105: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 4
    //   110: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 151
    //   115: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 5
    //   120: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 4
    //   131: iload 5
    //   133: if_icmpeq +476 -> 609
    //   136: aload 6
    //   138: getfield 132	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   141: getfield 159	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   147: astore_1
    //   148: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +53 -> 204
    //   154: ldc 19
    //   156: iconst_2
    //   157: new 139	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   164: ldc 142
    //   166: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload 4
    //   171: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc 151
    //   176: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 166
    //   186: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokeinterface 171 1 0
    //   195: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   211: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 187
    //   218: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   221: astore 6
    //   223: aload 6
    //   225: ifnonnull +434 -> 659
    //   228: new 194	java/util/ArrayList
    //   231: dup
    //   232: invokespecial 195	java/util/ArrayList:<init>	()V
    //   235: astore 6
    //   237: aload_1
    //   238: invokeinterface 199 1 0
    //   243: astore 8
    //   245: aconst_null
    //   246: astore_1
    //   247: aload 8
    //   249: invokeinterface 204 1 0
    //   254: ifeq +193 -> 447
    //   257: aload 8
    //   259: invokeinterface 208 1 0
    //   264: checkcast 210	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   267: astore_3
    //   268: aload_3
    //   269: getfield 214	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   272: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   275: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   278: astore 9
    //   280: aload_3
    //   281: getfield 228	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   284: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   287: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   290: astore 10
    //   292: aload_2
    //   293: ldc 187
    //   295: aload 9
    //   297: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   300: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   303: astore 7
    //   305: aload 7
    //   307: ifnonnull +62 -> 369
    //   310: new 187	com/tencent/mobileqq/data/Stranger
    //   313: dup
    //   314: invokespecial 235	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   317: astore_3
    //   318: aload_3
    //   319: aload 9
    //   321: putfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   324: aload_3
    //   325: aload 10
    //   327: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   330: aload_2
    //   331: aload_3
    //   332: invokevirtual 243	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   335: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +324 -> 662
    //   341: ldc 19
    //   343: iconst_2
    //   344: new 139	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   351: ldc 245
    //   353: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_3
    //   357: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: goto +296 -> 662
    //   369: aload 7
    //   371: aload 10
    //   373: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   376: aload_2
    //   377: aload 7
    //   379: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   382: pop
    //   383: aload 6
    //   385: invokeinterface 199 1 0
    //   390: astore 9
    //   392: aload_1
    //   393: astore_3
    //   394: aload 9
    //   396: invokeinterface 204 1 0
    //   401: ifeq +29 -> 430
    //   404: aload 9
    //   406: invokeinterface 208 1 0
    //   411: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   414: astore_3
    //   415: aload_3
    //   416: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   419: aload 7
    //   421: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   424: invokestatic 257	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   427: ifeq -35 -> 392
    //   430: aload 6
    //   432: aload_3
    //   433: invokeinterface 261 2 0
    //   438: pop
    //   439: aload_3
    //   440: astore_1
    //   441: aload 7
    //   443: astore_3
    //   444: goto -109 -> 335
    //   447: aload 6
    //   449: invokeinterface 199 1 0
    //   454: astore_3
    //   455: aload_3
    //   456: invokeinterface 204 1 0
    //   461: ifeq +79 -> 540
    //   464: aload_3
    //   465: invokeinterface 208 1 0
    //   470: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   473: astore_1
    //   474: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +29 -> 506
    //   480: ldc 19
    //   482: iconst_2
    //   483: new 139	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 263
    //   493: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_1
    //   497: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: aload_2
    //   507: aload_1
    //   508: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   511: pop
    //   512: goto -57 -> 455
    //   515: astore_3
    //   516: aload_2
    //   517: astore_1
    //   518: aload_3
    //   519: astore_2
    //   520: aload_2
    //   521: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   524: aload_1
    //   525: ifnull +7 -> 532
    //   528: aload_1
    //   529: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   532: aload_0
    //   533: iconst_2
    //   534: iconst_0
    //   535: aconst_null
    //   536: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   539: return
    //   540: aload_0
    //   541: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   547: invokeinterface 280 1 0
    //   552: astore_1
    //   553: aload_1
    //   554: ldc_w 282
    //   557: iload 5
    //   559: invokeinterface 288 3 0
    //   564: pop
    //   565: aload_1
    //   566: invokeinterface 291 1 0
    //   571: pop
    //   572: aload_2
    //   573: ldc 187
    //   575: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   578: astore_3
    //   579: aload_3
    //   580: astore_1
    //   581: aload_3
    //   582: ifnonnull +11 -> 593
    //   585: new 194	java/util/ArrayList
    //   588: dup
    //   589: invokespecial 195	java/util/ArrayList:<init>	()V
    //   592: astore_1
    //   593: aload_0
    //   594: iconst_2
    //   595: iconst_1
    //   596: aload_1
    //   597: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   600: aload_2
    //   601: ifnull -569 -> 32
    //   604: aload_2
    //   605: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   608: return
    //   609: aload_0
    //   610: iconst_2
    //   611: iconst_1
    //   612: aconst_null
    //   613: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   616: iconst_0
    //   617: ifeq -585 -> 32
    //   620: new 293	java/lang/NullPointerException
    //   623: dup
    //   624: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   627: athrow
    //   628: astore_1
    //   629: aconst_null
    //   630: astore_2
    //   631: aload_2
    //   632: ifnull +7 -> 639
    //   635: aload_2
    //   636: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   639: aload_1
    //   640: athrow
    //   641: astore_1
    //   642: goto -11 -> 631
    //   645: astore_3
    //   646: aload_1
    //   647: astore_2
    //   648: aload_3
    //   649: astore_1
    //   650: goto -19 -> 631
    //   653: astore_2
    //   654: aload_3
    //   655: astore_1
    //   656: goto -136 -> 520
    //   659: goto -422 -> 237
    //   662: goto -415 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	this	StrangerHandler
    //   0	665	1	paramToServiceMsg	ToServiceMsg
    //   0	665	2	paramFromServiceMsg	FromServiceMsg
    //   0	665	3	paramObject	Object
    //   72	98	4	j	int
    //   85	473	5	k	int
    //   40	408	6	localObject1	Object
    //   303	139	7	localStranger	com.tencent.mobileqq.data.Stranger
    //   243	15	8	localIterator	Iterator
    //   278	127	9	localObject2	Object
    //   290	82	10	str	String
    // Exception table:
    //   from	to	target	type
    //   215	223	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   228	237	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   237	245	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   247	305	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	335	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   335	366	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   369	392	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   394	430	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   430	439	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   447	455	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   455	506	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   506	512	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   540	579	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   585	593	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   593	600	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   44	129	628	finally
    //   136	204	628	finally
    //   204	215	628	finally
    //   609	616	628	finally
    //   215	223	641	finally
    //   228	237	641	finally
    //   237	245	641	finally
    //   247	305	641	finally
    //   310	335	641	finally
    //   335	366	641	finally
    //   369	392	641	finally
    //   394	430	641	finally
    //   430	439	641	finally
    //   447	455	641	finally
    //   455	506	641	finally
    //   506	512	641	finally
    //   540	579	641	finally
    //   585	593	641	finally
    //   593	600	641	finally
    //   520	524	645	finally
    //   44	129	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	204	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	215	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   609	616	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 102	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +31 -> 41
    //   13: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 19
    //   21: iconst_2
    //   22: ldc_w 296
    //   25: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: iconst_0
    //   31: aload_1
    //   32: ldc 30
    //   34: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   40: return
    //   41: new 109	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   44: dup
    //   45: invokespecial 110	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   48: astore_3
    //   49: aconst_null
    //   50: astore_2
    //   51: aload_3
    //   52: aload 4
    //   54: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   57: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   60: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   63: invokevirtual 117	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   66: pop
    //   67: aload_3
    //   68: getfield 300	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_info	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;
    //   71: invokevirtual 305	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:has	()Z
    //   74: ifeq +322 -> 396
    //   77: aload_3
    //   78: getfield 300	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_info	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;
    //   81: astore 4
    //   83: aload_0
    //   84: aload 4
    //   86: invokevirtual 308	com/tencent/mobileqq/app/StrangerHandler:a	(Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;)V
    //   89: new 194	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 195	java/util/ArrayList:<init>	()V
    //   96: astore 5
    //   98: aload_0
    //   99: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   105: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: aload 4
    //   113: getfield 311	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:frd_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   119: invokeinterface 199 1 0
    //   124: astore 6
    //   126: aload 6
    //   128: invokeinterface 204 1 0
    //   133: ifeq +237 -> 370
    //   136: aload 6
    //   138: invokeinterface 208 1 0
    //   143: checkcast 313	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo
    //   146: astore_3
    //   147: aload_2
    //   148: ldc 187
    //   150: aload_3
    //   151: getfield 314	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   154: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   157: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   160: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   163: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   166: astore 7
    //   168: aload 7
    //   170: ifnull -44 -> 126
    //   173: aload 7
    //   175: aload_3
    //   176: getfield 317	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: i2b
    //   183: putfield 320	com/tencent/mobileqq/data/Stranger:age	B
    //   186: aload 7
    //   188: aload_3
    //   189: getfield 323	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   192: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   195: i2b
    //   196: putfield 325	com/tencent/mobileqq/data/Stranger:gender	B
    //   199: aload 7
    //   201: aload_0
    //   202: getfield 42	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   205: aload_3
    //   206: getfield 328	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   209: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   212: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: invokevirtual 336	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast 221	java/lang/String
    //   221: putfield 339	com/tencent/mobileqq/data/Stranger:groupName	Ljava/lang/String;
    //   224: aload 7
    //   226: aload_0
    //   227: getfield 44	com/tencent/mobileqq/app/StrangerHandler:b	Ljava/util/HashMap;
    //   230: aload_3
    //   231: getfield 342	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   234: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   237: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: invokevirtual 336	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   243: checkcast 221	java/lang/String
    //   246: putfield 344	com/tencent/mobileqq/data/Stranger:login	Ljava/lang/String;
    //   249: aload 7
    //   251: aload_3
    //   252: getfield 342	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   255: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   258: i2b
    //   259: putfield 347	com/tencent/mobileqq/data/Stranger:loginId	B
    //   262: aload 7
    //   264: aload 4
    //   266: getfield 350	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   269: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   272: i2l
    //   273: putfield 353	com/tencent/mobileqq/data/Stranger:time	J
    //   276: aload 7
    //   278: aload_3
    //   279: getfield 356	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   285: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   288: putfield 358	com/tencent/mobileqq/data/Stranger:remark	Ljava/lang/String;
    //   291: aload_2
    //   292: aload 7
    //   294: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   297: pop
    //   298: aload 5
    //   300: aload 7
    //   302: invokeinterface 361 2 0
    //   307: pop
    //   308: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq -185 -> 126
    //   314: ldc 19
    //   316: iconst_2
    //   317: new 139	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 363
    //   327: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 7
    //   332: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -215 -> 126
    //   344: astore_3
    //   345: aload_3
    //   346: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   349: aload_2
    //   350: ifnull +7 -> 357
    //   353: aload_2
    //   354: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   357: aload_0
    //   358: iconst_1
    //   359: iconst_0
    //   360: aload_1
    //   361: ldc 30
    //   363: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   366: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   369: return
    //   370: aload_0
    //   371: iconst_1
    //   372: iconst_1
    //   373: aload 5
    //   375: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   378: aload 4
    //   380: getfield 367	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:frd_delete	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   383: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   386: pop
    //   387: aload_2
    //   388: ifnull -348 -> 40
    //   391: aload_2
    //   392: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   395: return
    //   396: iconst_0
    //   397: ifeq -40 -> 357
    //   400: new 293	java/lang/NullPointerException
    //   403: dup
    //   404: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   407: athrow
    //   408: astore_1
    //   409: aconst_null
    //   410: astore_2
    //   411: aload_2
    //   412: ifnull +7 -> 419
    //   415: aload_2
    //   416: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   419: aload_1
    //   420: athrow
    //   421: astore_1
    //   422: goto -11 -> 411
    //   425: astore_1
    //   426: goto -15 -> 411
    //   429: astore_3
    //   430: goto -85 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	StrangerHandler
    //   0	433	1	paramToServiceMsg	ToServiceMsg
    //   0	433	2	paramFromServiceMsg	FromServiceMsg
    //   0	433	3	paramObject	Object
    //   6	373	4	localObject	Object
    //   96	278	5	localArrayList	java.util.ArrayList
    //   124	13	6	localIterator	Iterator
    //   166	165	7	localStranger	com.tencent.mobileqq.data.Stranger
    // Exception table:
    //   from	to	target	type
    //   111	126	344	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   126	168	344	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   173	341	344	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   370	387	344	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   51	109	408	finally
    //   111	126	421	finally
    //   126	168	421	finally
    //   173	341	421	finally
    //   370	387	421	finally
    //   345	349	425	finally
    //   51	109	429	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  protected Class a()
  {
    return StrangerObserver.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListLocal ");
    }
    cwq localcwq = new cwq(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localcwq);
      return;
    }
    localcwq.run();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5d2_0".equalsIgnoreCase(str))
    {
      j = ((Integer)paramToServiceMsg.getAttribute("StrangerHandlerSubCmd", Integer.valueOf(1))).intValue();
      if (1 == j) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    while (!"OidbSvc.0x5d4_0".equalsIgnoreCase(str))
    {
      int j;
      do
      {
        return;
      } while (2 != j);
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(oidb_0x5d2.RspGetInfo paramRspGetInfo)
  {
    HashMap localHashMap;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      localHashMap = new HashMap();
      localObject = paramRspGetInfo.group_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        oidb_0x5d2.GroupInfo localGroupInfo = (oidb_0x5d2.GroupInfo)((Iterator)localObject).next();
        localHashMap.put(Integer.valueOf(localGroupInfo.id.get()), localGroupInfo.name.get().toStringUtf8());
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    }
    if ((this.b == null) || (this.b.isEmpty()))
    {
      localHashMap = new HashMap();
      paramRspGetInfo = paramRspGetInfo.login_info.get().iterator();
      while (paramRspGetInfo.hasNext())
      {
        localObject = (oidb_0x5d2.LoginInfo)paramRspGetInfo.next();
        localHashMap.put(Integer.valueOf(((oidb_0x5d2.LoginInfo)localObject).id.get()), ((oidb_0x5d2.LoginInfo)localObject).name.get().toStringUtf8());
      }
      this.b = localHashMap;
    }
  }
  
  public boolean a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getInfo list = " + Arrays.toString(paramList.toArray()));
    }
    if (paramList.isEmpty()) {
      return false;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(2);
    ((oidb_0x5d2.ReqBody)localObject).req_get_info.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_info.uin_list.set(paramList);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(2));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerGetInfoList", paramList);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListRemote force = " + paramBoolean);
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("strange_oidb_get_list_seq_id", 0);
    if (paramBoolean) {
      j = 0;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(1);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.seq.set(j);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSeqId", Integer.valueOf(j));
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 102	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +26 -> 34
    //   11: aload_0
    //   12: iconst_4
    //   13: iconst_0
    //   14: aconst_null
    //   15: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   18: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 19
    //   26: iconst_2
    //   27: ldc_w 539
    //   30: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: new 541	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody
    //   37: dup
    //   38: invokespecial 542	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_1
    //   44: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   50: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   53: invokevirtual 543	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   56: pop
    //   57: aload_0
    //   58: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   64: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_0
    //   71: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   74: invokevirtual 546	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   77: invokevirtual 551	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   80: astore 7
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: getfield 554	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:result	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   88: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   91: invokeinterface 199 1 0
    //   96: astore 8
    //   98: aload_2
    //   99: astore_1
    //   100: aload 8
    //   102: invokeinterface 204 1 0
    //   107: ifeq +135 -> 242
    //   110: aload_2
    //   111: astore_1
    //   112: aload 8
    //   114: invokeinterface 208 1 0
    //   119: checkcast 556	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult
    //   122: astore 9
    //   124: aload_2
    //   125: astore_1
    //   126: aload 9
    //   128: getfield 560	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult:res	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   131: invokevirtual 563	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   134: ifne -36 -> 98
    //   137: aload_2
    //   138: astore_1
    //   139: aload 9
    //   141: getfield 564	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   144: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   147: lstore 5
    //   149: aload_2
    //   150: astore_1
    //   151: aload_2
    //   152: ldc 187
    //   154: aload 9
    //   156: getfield 564	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$DelResult:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   162: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   165: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   168: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   171: astore 9
    //   173: aload 9
    //   175: ifnull +12 -> 187
    //   178: aload_2
    //   179: astore_1
    //   180: aload_2
    //   181: aload 9
    //   183: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   186: pop
    //   187: aload_2
    //   188: astore_1
    //   189: aload 7
    //   191: lload 5
    //   193: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: iconst_0
    //   197: invokevirtual 569	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/RecentUser;
    //   200: astore 9
    //   202: aload 9
    //   204: ifnull -106 -> 98
    //   207: aload_2
    //   208: astore_1
    //   209: aload 7
    //   211: aload 9
    //   213: invokevirtual 572	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Lcom/tencent/mobileqq/data/RecentUser;)V
    //   216: goto -118 -> 98
    //   219: astore_3
    //   220: aload_2
    //   221: astore_1
    //   222: aload_3
    //   223: invokevirtual 573	java/lang/Exception:printStackTrace	()V
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   234: aload_0
    //   235: iconst_4
    //   236: iconst_0
    //   237: aconst_null
    //   238: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   241: return
    //   242: aload_2
    //   243: astore_1
    //   244: aload_3
    //   245: getfield 574	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   248: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   251: istore 4
    //   253: aload_2
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   259: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   262: invokeinterface 280 1 0
    //   267: astore 7
    //   269: aload_2
    //   270: astore_1
    //   271: aload 7
    //   273: ldc_w 282
    //   276: iload 4
    //   278: invokeinterface 288 3 0
    //   283: pop
    //   284: aload_2
    //   285: astore_1
    //   286: aload 7
    //   288: invokeinterface 291 1 0
    //   293: pop
    //   294: aload_2
    //   295: astore_1
    //   296: aload_0
    //   297: iconst_4
    //   298: iconst_1
    //   299: aload_3
    //   300: getfield 554	tencent/im/oidb/cmd0x5d4/oidb_0x5d4$RspBody:result	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   303: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   306: aload_2
    //   307: ifnull -274 -> 33
    //   310: aload_2
    //   311: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   314: return
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   326: aload_2
    //   327: athrow
    //   328: astore_2
    //   329: goto -11 -> 318
    //   332: astore_3
    //   333: aconst_null
    //   334: astore_2
    //   335: goto -115 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	StrangerHandler
    //   0	338	1	paramToServiceMsg	ToServiceMsg
    //   0	338	2	paramFromServiceMsg	FromServiceMsg
    //   0	338	3	paramObject	Object
    //   251	26	4	j	int
    //   147	45	5	l	long
    //   80	207	7	localObject1	Object
    //   96	17	8	localIterator	Iterator
    //   122	90	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	82	219	java/lang/Exception
    //   84	98	219	java/lang/Exception
    //   100	110	219	java/lang/Exception
    //   112	124	219	java/lang/Exception
    //   126	137	219	java/lang/Exception
    //   139	149	219	java/lang/Exception
    //   151	173	219	java/lang/Exception
    //   180	187	219	java/lang/Exception
    //   189	202	219	java/lang/Exception
    //   209	216	219	java/lang/Exception
    //   244	253	219	java/lang/Exception
    //   255	269	219	java/lang/Exception
    //   271	284	219	java/lang/Exception
    //   286	294	219	java/lang/Exception
    //   296	306	219	java/lang/Exception
    //   42	68	315	finally
    //   70	82	328	finally
    //   84	98	328	finally
    //   100	110	328	finally
    //   112	124	328	finally
    //   126	137	328	finally
    //   139	149	328	finally
    //   151	173	328	finally
    //   180	187	328	finally
    //   189	202	328	finally
    //   209	216	328	finally
    //   222	226	328	finally
    //   244	253	328	finally
    //   255	269	328	finally
    //   271	284	328	finally
    //   286	294	328	finally
    //   296	306	328	finally
    //   42	68	332	java/lang/Exception
  }
  
  public boolean b(List paramList)
  {
    Object localObject = new oidb_0x5d4.ReqBody();
    ((oidb_0x5d4.ReqBody)localObject).uin_list.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1492);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d4.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d4_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    b((ToServiceMsg)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler
 * JD-Core Version:    0.7.0.1
 */