import android.os.Bundle;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;

class ttn
  implements zac<QQHeadUrl.QQHeadUrlRsp>
{
  ttn(ttl paramttl, String paramString, Bundle paramBundle) {}
  
  /* Error */
  public void a(boolean paramBoolean, long paramLong, String paramString, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	ttn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4: astore 4
    //   6: iload_1
    //   7: ifeq +244 -> 251
    //   10: lload_2
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +238 -> 251
    //   16: aload 5
    //   18: ifnull +233 -> 251
    //   21: aload 5
    //   23: getfield 32	com/tencent/avatarinfo/QQHeadUrl$QQHeadUrlRsp:dstHeadInfos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   26: invokevirtual 38	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +226 -> 259
    //   36: aload 6
    //   38: invokeinterface 44 1 0
    //   43: ifle +216 -> 259
    //   46: aload 6
    //   48: iconst_0
    //   49: invokeinterface 47 2 0
    //   54: checkcast 49	com/tencent/avatarinfo/QQHeadUrl$RspHeadInfo
    //   57: astore 6
    //   59: aload 6
    //   61: ifnull +198 -> 259
    //   64: aload 6
    //   66: getfield 53	com/tencent/avatarinfo/QQHeadUrl$RspHeadInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   69: invokevirtual 58	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   72: astore 7
    //   74: aload 7
    //   76: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +180 -> 259
    //   82: aload_0
    //   83: getfield 15	ttn:jdField_a_of_type_Ttl	Lttl;
    //   86: getfield 69	ttl:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: ifnull +170 -> 259
    //   92: aload_0
    //   93: getfield 15	ttn:jdField_a_of_type_Ttl	Lttl;
    //   96: getfield 69	ttl:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: iconst_1
    //   100: invokevirtual 74	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lalpd;
    //   103: checkcast 76	com/tencent/mobileqq/app/FriendListHandler
    //   106: invokevirtual 79	com/tencent/mobileqq/app/FriendListHandler:a	()Lcom/tencent/mobileqq/app/QQHeadDownloadHandler;
    //   109: aload 7
    //   111: aload 6
    //   113: getfield 83	com/tencent/avatarinfo/QQHeadUrl$RspHeadInfo:faceFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: i2b
    //   120: aload 5
    //   122: getfield 90	com/tencent/avatarinfo/QQHeadUrl$QQHeadUrlRsp:dstUsrType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: i2b
    //   129: iconst_0
    //   130: invokevirtual 95	com/tencent/mobileqq/app/QQHeadDownloadHandler:a	(Ljava/lang/String;BBI)Ljava/lang/String;
    //   133: astore 5
    //   135: aload 5
    //   137: astore 4
    //   139: ldc 97
    //   141: aload 5
    //   143: invokestatic 103	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 5
    //   148: aload 5
    //   150: astore 4
    //   152: new 105	java/util/ArrayList
    //   155: dup
    //   156: iconst_1
    //   157: invokespecial 108	java/util/ArrayList:<init>	(I)V
    //   160: astore 5
    //   162: aload 5
    //   164: aload 4
    //   166: invokevirtual 112	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   169: pop
    //   170: aload_0
    //   171: getfield 19	ttn:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   174: ldc 114
    //   176: aload 5
    //   178: invokevirtual 120	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   181: aload_0
    //   182: getfield 15	ttn:jdField_a_of_type_Ttl	Lttl;
    //   185: invokestatic 123	ttl:a	(Lttl;)Z
    //   188: ifeq +47 -> 235
    //   191: aload_0
    //   192: getfield 15	ttn:jdField_a_of_type_Ttl	Lttl;
    //   195: getfield 69	ttl:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   201: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: aload_0
    //   205: getfield 15	ttn:jdField_a_of_type_Ttl	Lttl;
    //   208: invokevirtual 135	ttl:a	()Landroid/app/Activity;
    //   211: aload_0
    //   212: getfield 19	ttn:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   215: aconst_null
    //   216: iconst_m1
    //   217: invokestatic 140	bjev:a	(Ljava/lang/String;Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnDismissListener;I)Z
    //   220: pop
    //   221: invokestatic 146	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   224: ifeq +11 -> 235
    //   227: ldc 148
    //   229: iconst_1
    //   230: ldc 150
    //   232: invokestatic 154	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: return
    //   236: astore 5
    //   238: ldc 148
    //   240: iconst_1
    //   241: ldc 156
    //   243: aload 5
    //   245: invokestatic 160	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   248: goto -96 -> 152
    //   251: ldc 148
    //   253: iconst_1
    //   254: ldc 162
    //   256: invokestatic 165	com/tencent/TMG/utils/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -107 -> 152
    //   262: astore 4
    //   264: ldc 148
    //   266: iconst_1
    //   267: ldc 167
    //   269: aload 4
    //   271: invokestatic 160	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   274: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ttn
    //   0	275	1	paramBoolean	boolean
    //   0	275	2	paramLong	long
    //   0	275	4	paramString	String
    //   0	275	5	paramQQHeadUrlRsp	QQHeadUrl.QQHeadUrlRsp
    //   29	83	6	localObject	Object
    //   72	38	7	str	String
    // Exception table:
    //   from	to	target	type
    //   92	135	236	java/lang/Exception
    //   139	148	236	java/lang/Exception
    //   191	235	262	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttn
 * JD-Core Version:    0.7.0.1
 */