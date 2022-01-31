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
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +25 -> 35
    //   13: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 19
    //   21: iconst_2
    //   22: ldc 104
    //   24: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: iconst_2
    //   29: iconst_0
    //   30: aconst_null
    //   31: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   34: return
    //   35: new 109	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   38: dup
    //   39: invokespecial 110	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_2
    //   46: aload 6
    //   48: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 117	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_1
    //   62: ldc 26
    //   64: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   67: checkcast 125	java/lang/Integer
    //   70: invokevirtual 128	java/lang/Integer:intValue	()I
    //   73: istore 5
    //   75: aload_2
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
    //   133: if_icmpeq +475 -> 608
    //   136: aload_2
    //   137: getfield 132	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   140: getfield 159	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   143: invokevirtual 164	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   146: astore_1
    //   147: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +53 -> 203
    //   153: ldc 19
    //   155: iconst_2
    //   156: new 139	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   163: ldc 142
    //   165: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 5
    //   170: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 151
    //   175: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 4
    //   180: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 166
    //   185: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokeinterface 171 1 0
    //   194: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   207: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   210: invokevirtual 185	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   213: astore_2
    //   214: aload_2
    //   215: ldc 187
    //   217: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   220: astore 6
    //   222: aload 6
    //   224: ifnonnull +434 -> 658
    //   227: new 194	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 195	java/util/ArrayList:<init>	()V
    //   234: astore 6
    //   236: aload_1
    //   237: invokeinterface 199 1 0
    //   242: astore 8
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 8
    //   248: invokeinterface 204 1 0
    //   253: ifeq +193 -> 446
    //   256: aload 8
    //   258: invokeinterface 208 1 0
    //   263: checkcast 210	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   266: astore_3
    //   267: aload_3
    //   268: getfield 214	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   271: invokevirtual 219	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   274: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: astore 9
    //   279: aload_3
    //   280: getfield 228	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   283: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   286: invokevirtual 231	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   289: astore 10
    //   291: aload_2
    //   292: ldc 187
    //   294: aload 9
    //   296: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   299: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   302: astore 7
    //   304: aload 7
    //   306: ifnonnull +62 -> 368
    //   309: new 187	com/tencent/mobileqq/data/Stranger
    //   312: dup
    //   313: invokespecial 235	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   316: astore_3
    //   317: aload_3
    //   318: aload 9
    //   320: putfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   323: aload_3
    //   324: aload 10
    //   326: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   329: aload_2
    //   330: aload_3
    //   331: invokevirtual 243	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   334: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +324 -> 661
    //   340: ldc 19
    //   342: iconst_2
    //   343: new 139	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   350: ldc 245
    //   352: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: goto +296 -> 661
    //   368: aload 7
    //   370: aload 10
    //   372: putfield 240	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   375: aload_2
    //   376: aload 7
    //   378: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   381: pop
    //   382: aload 6
    //   384: invokeinterface 199 1 0
    //   389: astore 9
    //   391: aload_1
    //   392: astore_3
    //   393: aload 9
    //   395: invokeinterface 204 1 0
    //   400: ifeq +29 -> 429
    //   403: aload 9
    //   405: invokeinterface 208 1 0
    //   410: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   413: astore_3
    //   414: aload_3
    //   415: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   418: aload 7
    //   420: getfield 237	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   423: invokestatic 257	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   426: ifeq -35 -> 391
    //   429: aload 6
    //   431: aload_3
    //   432: invokeinterface 261 2 0
    //   437: pop
    //   438: aload_3
    //   439: astore_1
    //   440: aload 7
    //   442: astore_3
    //   443: goto -109 -> 334
    //   446: aload 6
    //   448: invokeinterface 199 1 0
    //   453: astore_3
    //   454: aload_3
    //   455: invokeinterface 204 1 0
    //   460: ifeq +79 -> 539
    //   463: aload_3
    //   464: invokeinterface 208 1 0
    //   469: checkcast 187	com/tencent/mobileqq/data/Stranger
    //   472: astore_1
    //   473: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +29 -> 505
    //   479: ldc 19
    //   481: iconst_2
    //   482: new 139	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 263
    //   492: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_1
    //   496: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_2
    //   506: aload_1
    //   507: invokevirtual 265	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   510: pop
    //   511: goto -57 -> 454
    //   514: astore_3
    //   515: aload_2
    //   516: astore_1
    //   517: aload_3
    //   518: astore_2
    //   519: aload_2
    //   520: invokevirtual 268	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   523: aload_1
    //   524: ifnull +7 -> 531
    //   527: aload_1
    //   528: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   531: aload_0
    //   532: iconst_2
    //   533: iconst_0
    //   534: aconst_null
    //   535: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   538: return
    //   539: aload_0
    //   540: getfield 174	com/tencent/mobileqq/app/StrangerHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   543: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   546: invokeinterface 280 1 0
    //   551: astore_1
    //   552: aload_1
    //   553: ldc_w 282
    //   556: iload 4
    //   558: invokeinterface 288 3 0
    //   563: pop
    //   564: aload_1
    //   565: invokeinterface 291 1 0
    //   570: pop
    //   571: aload_2
    //   572: ldc 187
    //   574: invokevirtual 192	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   577: astore_3
    //   578: aload_3
    //   579: astore_1
    //   580: aload_3
    //   581: ifnonnull +11 -> 592
    //   584: new 194	java/util/ArrayList
    //   587: dup
    //   588: invokespecial 195	java/util/ArrayList:<init>	()V
    //   591: astore_1
    //   592: aload_0
    //   593: iconst_2
    //   594: iconst_1
    //   595: aload_1
    //   596: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   599: aload_2
    //   600: ifnull -566 -> 34
    //   603: aload_2
    //   604: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   607: return
    //   608: aload_0
    //   609: iconst_2
    //   610: iconst_1
    //   611: aconst_null
    //   612: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   615: iconst_0
    //   616: ifeq -582 -> 34
    //   619: new 293	java/lang/NullPointerException
    //   622: dup
    //   623: invokespecial 294	java/lang/NullPointerException:<init>	()V
    //   626: athrow
    //   627: astore_1
    //   628: aconst_null
    //   629: astore_2
    //   630: aload_2
    //   631: ifnull +7 -> 638
    //   634: aload_2
    //   635: invokevirtual 270	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   638: aload_1
    //   639: athrow
    //   640: astore_1
    //   641: goto -11 -> 630
    //   644: astore_3
    //   645: aload_1
    //   646: astore_2
    //   647: aload_3
    //   648: astore_1
    //   649: goto -19 -> 630
    //   652: astore_2
    //   653: aload_3
    //   654: astore_1
    //   655: goto -136 -> 519
    //   658: goto -422 -> 236
    //   661: goto -415 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	StrangerHandler
    //   0	664	1	paramToServiceMsg	ToServiceMsg
    //   0	664	2	paramFromServiceMsg	FromServiceMsg
    //   0	664	3	paramObject	Object
    //   85	472	4	j	int
    //   73	96	5	k	int
    //   6	441	6	localObject1	Object
    //   302	139	7	localStranger	com.tencent.mobileqq.data.Stranger
    //   242	15	8	localIterator	Iterator
    //   277	127	9	localObject2	Object
    //   289	82	10	str	String
    // Exception table:
    //   from	to	target	type
    //   214	222	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	236	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   236	244	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   246	304	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   309	334	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   334	365	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   368	391	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   393	429	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   429	438	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   446	454	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   454	505	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   505	511	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   539	578	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   584	592	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   592	599	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	129	627	finally
    //   136	203	627	finally
    //   203	214	627	finally
    //   608	615	627	finally
    //   214	222	640	finally
    //   227	236	640	finally
    //   236	244	640	finally
    //   246	304	640	finally
    //   309	334	640	finally
    //   334	365	640	finally
    //   368	391	640	finally
    //   393	429	640	finally
    //   429	438	640	finally
    //   446	454	640	finally
    //   454	505	640	finally
    //   505	511	640	finally
    //   539	578	640	finally
    //   584	592	640	finally
    //   592	599	640	finally
    //   519	523	644	finally
    //   45	129	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	203	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	214	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   608	615	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
    //   264: aload 5
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
    //   298: aload 4
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
    //   373: aload 4
    //   375: invokevirtual 107	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   378: aload 5
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
    //   6	368	4	localObject	Object
    //   81	298	5	localRspGetInfo	oidb_0x5d2.RspGetInfo
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