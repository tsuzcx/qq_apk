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
import flk;
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
    //   72: istore 5
    //   74: aload 6
    //   76: getfield 132	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 137	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 4
    //   87: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 19
    //   95: iconst_2
    //   96: new 139	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   103: ldc 142
    //   105: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 5
    //   110: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 151
    //   115: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 5
    //   131: iload 4
    //   133: if_icmpeq +478 -> 611
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
    //   169: iload 5
    //   171: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc 151
    //   176: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 4
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
    //   225: ifnonnull +436 -> 661
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
    //   254: ifeq +195 -> 449
    //   257: aload 8
    //   259: invokeinterface 208 1 0
    //   264: checkcast 210	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   267: astore 7
    //   269: aload 7
    //   271: getfield 214	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   274: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   277: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   280: astore_3
    //   281: aload 7
    //   283: getfield 228	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   286: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   289: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   292: astore 9
    //   294: aload_2
    //   295: ldc 187
    //   297: aload_3
    //   298: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   301: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   304: astore 7
    //   306: aload 7
    //   308: ifnonnull +66 -> 374
    //   311: new 187	com/tencent/mobileqq/data/Stranger
    //   314: dup
    //   315: invokespecial 235	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   318: astore 7
    //   320: aload 7
    //   322: aload_3
    //   323: putfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   326: aload 7
    //   328: aload 9
    //   330: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   333: aload_2
    //   334: aload 7
    //   336: invokevirtual 243	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   339: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +322 -> 664
    //   345: ldc 19
    //   347: iconst_2
    //   348: new 139	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   355: ldc 245
    //   357: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 7
    //   362: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto +293 -> 664
    //   374: aload 7
    //   376: aload 9
    //   378: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   381: aload_2
    //   382: aload 7
    //   384: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   387: pop
    //   388: aload 6
    //   390: invokeinterface 199 1 0
    //   395: astore 9
    //   397: aload_1
    //   398: astore_3
    //   399: aload 9
    //   401: invokeinterface 204 1 0
    //   406: ifeq +29 -> 435
    //   409: aload 9
    //   411: invokeinterface 208 1 0
    //   416: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   419: astore_3
    //   420: aload_3
    //   421: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   424: aload 7
    //   426: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   429: invokestatic 257	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   432: ifeq -35 -> 397
    //   435: aload 6
    //   437: aload_3
    //   438: invokeinterface 261 2 0
    //   443: pop
    //   444: aload_3
    //   445: astore_1
    //   446: goto -107 -> 339
    //   449: aload 6
    //   451: invokeinterface 199 1 0
    //   456: astore_3
    //   457: aload_3
    //   458: invokeinterface 204 1 0
    //   463: ifeq +79 -> 542
    //   466: aload_3
    //   467: invokeinterface 208 1 0
    //   472: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   475: astore_1
    //   476: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +29 -> 508
    //   482: ldc 19
    //   484: iconst_2
    //   485: new 139	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 263
    //   495: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: aload_2
    //   509: aload_1
    //   510: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   513: pop
    //   514: goto -57 -> 457
    //   517: astore_3
    //   518: aload_2
    //   519: astore_1
    //   520: aload_3
    //   521: astore_2
    //   522: aload_2
    //   523: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   526: aload_1
    //   527: ifnull +7 -> 534
    //   530: aload_1
    //   531: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   534: aload_0
    //   535: iconst_2
    //   536: iconst_0
    //   537: aconst_null
    //   538: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   541: return
    //   542: aload_0
    //   543: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   546: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   549: invokeinterface 280 1 0
    //   554: astore_1
    //   555: aload_1
    //   556: ldc_w 282
    //   559: iload 4
    //   561: invokeinterface 288 3 0
    //   566: pop
    //   567: aload_1
    //   568: invokeinterface 291 1 0
    //   573: pop
    //   574: aload_2
    //   575: ldc 187
    //   577: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   580: astore_3
    //   581: aload_3
    //   582: astore_1
    //   583: aload_3
    //   584: ifnonnull +11 -> 595
    //   587: new 194	java/util/ArrayList
    //   590: dup
    //   591: invokespecial 195	java/util/ArrayList:<init>	()V
    //   594: astore_1
    //   595: aload_0
    //   596: iconst_2
    //   597: iconst_1
    //   598: aload_1
    //   599: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   602: aload_2
    //   603: ifnull -571 -> 32
    //   606: aload_2
    //   607: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   610: return
    //   611: aload_0
    //   612: iconst_2
    //   613: iconst_1
    //   614: aconst_null
    //   615: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   618: iconst_0
    //   619: ifeq -587 -> 32
    //   622: new 293	java/lang/NullPointerException
    //   625: dup
    //   626: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   629: athrow
    //   630: astore_1
    //   631: aconst_null
    //   632: astore_2
    //   633: aload_2
    //   634: ifnull +7 -> 641
    //   637: aload_2
    //   638: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   641: aload_1
    //   642: athrow
    //   643: astore_1
    //   644: goto -11 -> 633
    //   647: astore_3
    //   648: aload_1
    //   649: astore_2
    //   650: aload_3
    //   651: astore_1
    //   652: goto -19 -> 633
    //   655: astore_2
    //   656: aload_3
    //   657: astore_1
    //   658: goto -136 -> 522
    //   661: goto -424 -> 237
    //   664: goto -417 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	StrangerHandler
    //   0	667	1	paramToServiceMsg	ToServiceMsg
    //   0	667	2	paramFromServiceMsg	FromServiceMsg
    //   0	667	3	paramObject	Object
    //   85	475	4	j	int
    //   72	98	5	k	int
    //   40	410	6	localObject1	Object
    //   267	158	7	localObject2	Object
    //   243	15	8	localIterator	Iterator
    //   292	118	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   215	223	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   228	237	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   237	245	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   247	306	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   311	339	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   339	371	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   374	397	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   399	435	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   435	444	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   449	457	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   457	508	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   508	514	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   542	581	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   587	595	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   595	602	517	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   44	129	630	finally
    //   136	204	630	finally
    //   204	215	630	finally
    //   611	618	630	finally
    //   215	223	643	finally
    //   228	237	643	finally
    //   237	245	643	finally
    //   247	306	643	finally
    //   311	339	643	finally
    //   339	371	643	finally
    //   374	397	643	finally
    //   399	435	643	finally
    //   435	444	643	finally
    //   449	457	643	finally
    //   457	508	643	finally
    //   508	514	643	finally
    //   542	581	643	finally
    //   587	595	643	finally
    //   595	602	643	finally
    //   522	526	647	finally
    //   44	129	655	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	204	655	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	215	655	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   611	618	655	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
    //   74: ifeq +327 -> 401
    //   77: aload_3
    //   78: getfield 300	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_info	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;
    //   81: astore 5
    //   83: aload_0
    //   84: aload 5
    //   86: invokevirtual 308	com/tencent/mobileqq/app/StrangerHandler:a	(Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo;)V
    //   89: new 194	java/util/ArrayList
    //   92: dup
    //   93: invokespecial 195	java/util/ArrayList:<init>	()V
    //   96: astore 4
    //   98: aload_0
    //   99: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   102: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   105: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: astore_3
    //   109: aload_3
    //   110: astore_2
    //   111: aload 5
    //   113: getfield 311	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:frd_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   116: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   119: invokeinterface 199 1 0
    //   124: astore_3
    //   125: aload_3
    //   126: invokeinterface 204 1 0
    //   131: ifeq +244 -> 375
    //   134: aload_3
    //   135: invokeinterface 208 1 0
    //   140: checkcast 313	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo
    //   143: astore 7
    //   145: aload_2
    //   146: ldc 187
    //   148: aload 7
    //   150: getfield 314	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   153: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   156: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   159: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   162: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   165: astore 6
    //   167: aload 6
    //   169: ifnull -44 -> 125
    //   172: aload 6
    //   174: aload 7
    //   176: getfield 317	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: i2b
    //   183: putfield 320	com/tencent/mobileqq/data/Stranger:age	B
    //   186: aload 6
    //   188: aload 7
    //   190: getfield 323	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   193: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   196: i2b
    //   197: putfield 325	com/tencent/mobileqq/data/Stranger:gender	B
    //   200: aload 6
    //   202: aload_0
    //   203: getfield 42	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   206: aload 7
    //   208: getfield 328	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   211: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   214: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: invokevirtual 336	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   220: checkcast 221	java/lang/String
    //   223: putfield 339	com/tencent/mobileqq/data/Stranger:groupName	Ljava/lang/String;
    //   226: aload 6
    //   228: aload_0
    //   229: getfield 44	com/tencent/mobileqq/app/StrangerHandler:b	Ljava/util/HashMap;
    //   232: aload 7
    //   234: getfield 342	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   237: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   240: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: invokevirtual 336	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   246: checkcast 221	java/lang/String
    //   249: putfield 344	com/tencent/mobileqq/data/Stranger:login	Ljava/lang/String;
    //   252: aload 6
    //   254: aload 7
    //   256: getfield 342	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   259: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   262: i2b
    //   263: putfield 347	com/tencent/mobileqq/data/Stranger:loginId	B
    //   266: aload 6
    //   268: aload 5
    //   270: getfield 350	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   273: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   276: i2l
    //   277: putfield 353	com/tencent/mobileqq/data/Stranger:time	J
    //   280: aload 6
    //   282: aload 7
    //   284: getfield 356	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendInfo:remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   287: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   290: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   293: putfield 358	com/tencent/mobileqq/data/Stranger:remark	Ljava/lang/String;
    //   296: aload_2
    //   297: aload 6
    //   299: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   302: pop
    //   303: aload 4
    //   305: aload 6
    //   307: invokeinterface 361 2 0
    //   312: pop
    //   313: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq -191 -> 125
    //   319: ldc 19
    //   321: iconst_2
    //   322: new 139	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 363
    //   332: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 6
    //   337: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: goto -221 -> 125
    //   349: astore_3
    //   350: aload_3
    //   351: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   354: aload_2
    //   355: ifnull +7 -> 362
    //   358: aload_2
    //   359: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   362: aload_0
    //   363: iconst_1
    //   364: iconst_0
    //   365: aload_1
    //   366: ldc 30
    //   368: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   371: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   374: return
    //   375: aload_0
    //   376: iconst_1
    //   377: iconst_1
    //   378: aload 4
    //   380: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   383: aload 5
    //   385: getfield 367	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetInfo:frd_delete	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   388: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   391: pop
    //   392: aload_2
    //   393: ifnull -353 -> 40
    //   396: aload_2
    //   397: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   400: return
    //   401: iconst_0
    //   402: ifeq -40 -> 362
    //   405: new 293	java/lang/NullPointerException
    //   408: dup
    //   409: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   412: athrow
    //   413: astore_1
    //   414: aconst_null
    //   415: astore_2
    //   416: aload_2
    //   417: ifnull +7 -> 424
    //   420: aload_2
    //   421: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   424: aload_1
    //   425: athrow
    //   426: astore_1
    //   427: goto -11 -> 416
    //   430: astore_1
    //   431: goto -15 -> 416
    //   434: astore_3
    //   435: goto -85 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	StrangerHandler
    //   0	438	1	paramToServiceMsg	ToServiceMsg
    //   0	438	2	paramFromServiceMsg	FromServiceMsg
    //   0	438	3	paramObject	Object
    //   6	373	4	localObject	Object
    //   81	303	5	localRspGetInfo	oidb_0x5d2.RspGetInfo
    //   165	171	6	localStranger	com.tencent.mobileqq.data.Stranger
    //   143	140	7	localFriendInfo	tencent.im.oidb.cmd0x5d2.oidb_0x5d2.FriendInfo
    // Exception table:
    //   from	to	target	type
    //   111	125	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   125	167	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   172	346	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   375	392	349	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   51	109	413	finally
    //   111	125	426	finally
    //   125	167	426	finally
    //   172	346	426	finally
    //   375	392	426	finally
    //   350	354	430	finally
    //   51	109	434	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
    flk localflk = new flk(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localflk);
      return;
    }
    localflk.run();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler
 * JD-Core Version:    0.7.0.1
 */