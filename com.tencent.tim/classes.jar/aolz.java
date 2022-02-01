import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class aolz
  extends aoji
{
  private String clR;
  private byte[] fQ = this.h.cmp.getBytes();
  private byte[] fR;
  private byte[] fS;
  private int mChannelType;
  private int mUinType = this.h.mUinType;
  
  public aolz(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
  }
  
  private void dVP()
  {
    this.jdField_a_of_type_Aojn$a.dVf();
    aoql.a.f localf = new aoql.a.f();
    localf.selfUin = this.h.mSelfUin;
    localf.peerUin = this.h.mPeerUin;
    localf.cmC = this.h.cmn;
    localf.uinType = this.h.mUinType;
    localf.gd = this.fQ;
    localf.dPD = this.h.dPD;
    aoql.a locala = new aoql.a();
    locala.b = this;
    locala.cmy = "multi_msg_dw";
    locala.He.add(localf);
    locala.a = this.app.getProtoReqManager();
    if (!azQ())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Aojn$a);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        hM("requestStart", locala.toString());
      }
    } while (!azR());
    this.jdField_a_of_type_Aoql$a = locala;
    aoqm.c(locala);
  }
  
  private void dVr()
  {
    aoll localaoll = new aoll();
    aonh localaonh = (aonh)this.xp.get(0);
    String str = "http://";
    Object localObject;
    if (this.mChannelType == 2)
    {
      str = "https://";
      localaoll.mIsHttps = true;
      localaoll.cML = true;
      if (localaonh.isIpv6)
      {
        localaoll.clP = "sslv6.htdata.qq.com";
        localObject = new aonh();
        ((aonh)localObject).mIp = localaoll.clP;
        ((aonh)localObject).port = 443;
        this.xp.add(localObject);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiMsg_TAG", 2, "Multimsg download recieveFile  url =" + str);
      }
      if ((!localaonh.isIpv6) || (localaonh.mIp.startsWith("["))) {
        break label420;
      }
    }
    label420:
    for (str = str + "[" + localaonh.mIp + "]";; str = str + localaonh.mIp)
    {
      localObject = str;
      if (localaonh.port != 80) {
        localObject = str + ":" + localaonh.port;
      }
      str = (String)localObject + this.ckX;
      hM("MultimsgDownload.recieveFile", " url:" + str);
      this.clR = aoiz.getFilePath(str);
      localaoll.f = this;
      localaoll.bZ = str;
      localaoll.mHttpMethod = 0;
      localaoll.P = this.xp;
      localaoll.atY = this.clR;
      localaoll.mMsgId = String.valueOf(this.h.mUniseq);
      localaoll.dPG = this.h.mUinType;
      localaoll.mFileType = this.h.mFileType;
      localaoll.apS = 0L;
      localaoll.cMU = true;
      localaoll.u.put("Accept-Encoding", "identity");
      hM("httpDown", "url:" + str + ",downOffset:" + localaoll.apS);
      if (azR()) {
        break label446;
      }
      return;
      localaoll.clP = "ssl.htdata.qq.com";
      break;
    }
    label446:
    this.jdField_a_of_type_Aomg = localaoll;
    dVe();
    this.jdField_c_of_type_Aolm.a(localaoll);
  }
  
  /* Error */
  private boolean qd(String paramString)
  {
    // Byte code:
    //   0: new 332	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 335	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 338	java/io/File:exists	()Z
    //   11: ifne +32 -> 43
    //   14: aload_0
    //   15: ldc_w 340
    //   18: new 204	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 342
    //   28: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_0
    //   42: ireturn
    //   43: new 344	java/io/RandomAccessFile
    //   46: dup
    //   47: aload_1
    //   48: ldc_w 346
    //   51: invokespecial 348	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore 6
    //   56: aload 6
    //   58: astore 5
    //   60: aload 6
    //   62: invokevirtual 352	java/io/RandomAccessFile:length	()J
    //   65: l2i
    //   66: newarray byte
    //   68: astore 7
    //   70: aload 6
    //   72: astore 5
    //   74: aload 6
    //   76: aload 7
    //   78: invokevirtual 356	java/io/RandomAccessFile:read	([B)I
    //   81: istore_2
    //   82: aload 6
    //   84: ifnull +8 -> 92
    //   87: aload 6
    //   89: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   92: aload 7
    //   94: ifnull +13 -> 107
    //   97: aload 7
    //   99: arraylength
    //   100: ifle +7 -> 107
    //   103: iload_2
    //   104: ifgt +160 -> 264
    //   107: aload_0
    //   108: ldc_w 340
    //   111: ldc_w 361
    //   114: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   124: goto -32 -> 92
    //   127: astore 7
    //   129: aconst_null
    //   130: astore 6
    //   132: aload 6
    //   134: astore 5
    //   136: aload 7
    //   138: invokevirtual 365	java/io/FileNotFoundException:printStackTrace	()V
    //   141: aload 6
    //   143: astore 5
    //   145: aload_0
    //   146: ldc_w 340
    //   149: new 204	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 342
    //   159: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 6
    //   174: ifnull +8 -> 182
    //   177: aload 6
    //   179: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   189: goto -7 -> 182
    //   192: astore_1
    //   193: aconst_null
    //   194: astore 6
    //   196: aload 6
    //   198: astore 5
    //   200: aload_0
    //   201: ldc_w 340
    //   204: ldc_w 367
    //   207: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 6
    //   212: astore 5
    //   214: aload_1
    //   215: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   218: aload 6
    //   220: ifnull +8 -> 228
    //   223: aload 6
    //   225: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   235: goto -7 -> 228
    //   238: astore_1
    //   239: aconst_null
    //   240: astore 5
    //   242: aload 5
    //   244: ifnull +8 -> 252
    //   247: aload 5
    //   249: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore 5
    //   256: aload 5
    //   258: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   261: goto -9 -> 252
    //   264: aload 7
    //   266: arraylength
    //   267: istore_2
    //   268: aload 7
    //   270: iconst_0
    //   271: baload
    //   272: bipush 40
    //   274: if_icmpne +14 -> 288
    //   277: aload 7
    //   279: iload_2
    //   280: iconst_1
    //   281: isub
    //   282: baload
    //   283: bipush 41
    //   285: if_icmpeq +90 -> 375
    //   288: new 204	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 369
    //   298: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: iload_2
    //   302: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc_w 371
    //   308: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore_1
    //   315: aload 7
    //   317: invokevirtual 374	java/lang/Object:toString	()Ljava/lang/String;
    //   320: astore 5
    //   322: new 204	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   329: aload_1
    //   330: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: astore 6
    //   335: aload 5
    //   337: astore_1
    //   338: aload 5
    //   340: invokevirtual 377	java/lang/String:length	()I
    //   343: bipush 20
    //   345: if_icmple +12 -> 357
    //   348: aload 5
    //   350: iconst_0
    //   351: bipush 20
    //   353: invokevirtual 381	java/lang/String:substring	(II)Ljava/lang/String;
    //   356: astore_1
    //   357: aload_0
    //   358: ldc_w 340
    //   361: aload 6
    //   363: aload_1
    //   364: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: iconst_0
    //   374: ireturn
    //   375: new 383	java/io/DataInputStream
    //   378: dup
    //   379: new 385	java/io/ByteArrayInputStream
    //   382: dup
    //   383: aload 7
    //   385: invokespecial 388	java/io/ByteArrayInputStream:<init>	([B)V
    //   388: invokespecial 391	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   391: astore 5
    //   393: aload 5
    //   395: invokevirtual 395	java/io/DataInputStream:readByte	()B
    //   398: pop
    //   399: aload 5
    //   401: invokevirtual 398	java/io/DataInputStream:readInt	()I
    //   404: istore 4
    //   406: aload 5
    //   408: invokevirtual 398	java/io/DataInputStream:readInt	()I
    //   411: istore_3
    //   412: iload 4
    //   414: iload_2
    //   415: if_icmpgt +8 -> 423
    //   418: iload_3
    //   419: iload_2
    //   420: if_icmple +43 -> 463
    //   423: aload_0
    //   424: ldc_w 340
    //   427: new 204	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 400
    //   437: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload 4
    //   442: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 402
    //   448: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: iload_3
    //   452: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: iconst_0
    //   462: ireturn
    //   463: iload 4
    //   465: ifle +475 -> 940
    //   468: iload 4
    //   470: newarray byte
    //   472: astore_1
    //   473: aload 5
    //   475: aload_1
    //   476: invokevirtual 403	java/io/DataInputStream:read	([B)I
    //   479: pop
    //   480: new 405	tencent/im/msg/im_msg_head$Head
    //   483: dup
    //   484: invokespecial 406	tencent/im/msg/im_msg_head$Head:<init>	()V
    //   487: astore 6
    //   489: aload 6
    //   491: aload_1
    //   492: invokevirtual 410	tencent/im/msg/im_msg_head$Head:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   495: pop
    //   496: aload 6
    //   498: getfield 414	tencent/im/msg/im_msg_head$Head:msg_httpconn_head	Ltencent/im/msg/im_msg_head$HttpConnHead;
    //   501: invokevirtual 419	tencent/im/msg/im_msg_head$HttpConnHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   504: checkcast 416	tencent/im/msg/im_msg_head$HttpConnHead
    //   507: getfield 423	tencent/im/msg/im_msg_head$HttpConnHead:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   510: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   513: istore_2
    //   514: goto +428 -> 942
    //   517: aload_0
    //   518: ldc_w 340
    //   521: new 204	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 429
    //   531: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: iload_3
    //   535: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 431
    //   541: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: iload_2
    //   545: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: iconst_0
    //   555: ireturn
    //   556: iload_3
    //   557: newarray byte
    //   559: astore_1
    //   560: aload 5
    //   562: aload_1
    //   563: invokevirtual 403	java/io/DataInputStream:read	([B)I
    //   566: pop
    //   567: new 433	com/tencent/qphone/base/util/Cryptor
    //   570: dup
    //   571: invokespecial 434	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   574: aload_1
    //   575: aload_0
    //   576: getfield 436	aolz:fR	[B
    //   579: invokevirtual 440	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   582: astore 5
    //   584: aload 5
    //   586: ifnull +9 -> 595
    //   589: aload 5
    //   591: arraylength
    //   592: ifgt +15 -> 607
    //   595: aload_0
    //   596: ldc_w 340
    //   599: ldc_w 442
    //   602: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: iconst_0
    //   606: ireturn
    //   607: new 444	tencent/im/longconn/longmsg/LongMsg$RspBody
    //   610: dup
    //   611: invokespecial 445	tencent/im/longconn/longmsg/LongMsg$RspBody:<init>	()V
    //   614: astore 6
    //   616: aload 6
    //   618: aload 5
    //   620: invokevirtual 446	tencent/im/longconn/longmsg/LongMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   623: pop
    //   624: aload 6
    //   626: getfield 450	tencent/im/longconn/longmsg/LongMsg$RspBody:rpt_msg_down_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   629: iconst_0
    //   630: invokevirtual 455	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   633: checkcast 457	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp
    //   636: astore 5
    //   638: aload 5
    //   640: ifnonnull +15 -> 655
    //   643: aload_0
    //   644: ldc_w 340
    //   647: ldc_w 459
    //   650: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: iconst_0
    //   654: ireturn
    //   655: aload 5
    //   657: getfield 462	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   660: invokevirtual 465	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   663: ifne +15 -> 678
    //   666: aload_0
    //   667: ldc_w 340
    //   670: ldc_w 467
    //   673: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: iconst_0
    //   677: ireturn
    //   678: aload 5
    //   680: getfield 462	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   683: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   686: ifeq +15 -> 701
    //   689: aload_0
    //   690: ldc_w 340
    //   693: ldc_w 469
    //   696: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: iconst_0
    //   700: ireturn
    //   701: aload 5
    //   703: getfield 473	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   706: invokevirtual 476	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   709: ifne +15 -> 724
    //   712: aload_0
    //   713: ldc_w 340
    //   716: ldc_w 478
    //   719: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   722: iconst_0
    //   723: ireturn
    //   724: aload_0
    //   725: aload 5
    //   727: getfield 473	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   730: invokevirtual 481	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   733: invokevirtual 486	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   736: putfield 488	aolz:fS	[B
    //   739: aload_0
    //   740: getfield 488	aolz:fS	[B
    //   743: ifnull +11 -> 754
    //   746: aload_0
    //   747: getfield 488	aolz:fS	[B
    //   750: arraylength
    //   751: ifgt +15 -> 766
    //   754: aload_0
    //   755: ldc_w 340
    //   758: ldc_w 490
    //   761: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: iconst_0
    //   765: ireturn
    //   766: aload_0
    //   767: ldc_w 340
    //   770: new 204	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 492
    //   780: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_1
    //   784: invokestatic 498	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   787: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: aload_0
    //   797: ldc_w 340
    //   800: new 204	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   807: ldc_w 500
    //   810: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_1
    //   814: arraylength
    //   815: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   818: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: aload_0
    //   825: ldc_w 340
    //   828: new 204	java/lang/StringBuilder
    //   831: dup
    //   832: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   835: ldc_w 502
    //   838: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload_0
    //   842: getfield 488	aolz:fS	[B
    //   845: invokestatic 498	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   848: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: aload_0
    //   858: ldc_w 340
    //   861: new 204	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   868: ldc_w 504
    //   871: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload_0
    //   875: getfield 488	aolz:fS	[B
    //   878: arraylength
    //   879: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: iconst_1
    //   889: ireturn
    //   890: astore_1
    //   891: aload_1
    //   892: invokevirtual 505	java/lang/Exception:printStackTrace	()V
    //   895: aload_0
    //   896: ldc_w 340
    //   899: new 204	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   906: ldc_w 507
    //   909: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload_1
    //   913: invokevirtual 510	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   916: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   922: invokevirtual 143	aolz:hM	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: iconst_0
    //   926: ireturn
    //   927: astore_1
    //   928: goto -686 -> 242
    //   931: astore_1
    //   932: goto -736 -> 196
    //   935: astore 7
    //   937: goto -805 -> 132
    //   940: iconst_0
    //   941: istore_2
    //   942: iload_3
    //   943: ifle -426 -> 517
    //   946: iload_2
    //   947: ifeq -391 -> 556
    //   950: goto -433 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	953	0	this	aolz
    //   0	953	1	paramString	String
    //   81	866	2	i	int
    //   411	532	3	j	int
    //   404	65	4	k	int
    //   58	190	5	localObject1	Object
    //   254	3	5	localIOException	java.io.IOException
    //   320	406	5	localObject2	Object
    //   54	571	6	localObject3	Object
    //   68	30	7	arrayOfByte	byte[]
    //   127	257	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   935	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   87	92	119	java/io/IOException
    //   43	56	127	java/io/FileNotFoundException
    //   177	182	184	java/io/IOException
    //   43	56	192	java/io/IOException
    //   223	228	230	java/io/IOException
    //   43	56	238	finally
    //   247	252	254	java/io/IOException
    //   375	412	890	java/lang/Exception
    //   423	461	890	java/lang/Exception
    //   468	514	890	java/lang/Exception
    //   517	554	890	java/lang/Exception
    //   556	584	890	java/lang/Exception
    //   589	595	890	java/lang/Exception
    //   595	605	890	java/lang/Exception
    //   607	638	890	java/lang/Exception
    //   643	653	890	java/lang/Exception
    //   655	676	890	java/lang/Exception
    //   678	699	890	java/lang/Exception
    //   701	722	890	java/lang/Exception
    //   724	754	890	java/lang/Exception
    //   754	764	890	java/lang/Exception
    //   766	888	890	java/lang/Exception
    //   60	70	927	finally
    //   74	82	927	finally
    //   136	141	927	finally
    //   145	172	927	finally
    //   200	210	927	finally
    //   214	218	927	finally
    //   60	70	931	java/io/IOException
    //   74	82	931	java/io/IOException
    //   60	70	935	java/io/FileNotFoundException
    //   74	82	935	java/io/FileNotFoundException
  }
  
  protected String AJ()
  {
    return "actMultiMsgDownload";
  }
  
  public int KH()
  {
    hM("uiParam", this.h.toString());
    return 0;
  }
  
  public void a(aoql.a parama, aoql.b paramb)
  {
    this.jdField_a_of_type_Aoql$a = null;
    if (paramb == null) {
      onError();
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramb.Hf.size())
      {
        parama = (aoql.b.i)paramb.Hf.get(i);
        if (QLog.isColorLevel()) {
          hM("procUrl", parama.toString());
        }
        a(this.jdField_a_of_type_Aojn$a, parama);
        if (parama.result != 0) {
          break label127;
        }
        this.xp = i(parama.Bw, parama.ipList);
        this.ckX = parama.cmH;
        this.fR = parama.gi;
        this.mChannelType = parama.mChannelType;
        dVr();
        i += 1;
      }
    }
    label127:
    onError();
  }
  
  protected void dVe()
  {
    String str;
    if ((this.jdField_a_of_type_Aomg != null) && ((this.jdField_a_of_type_Aomg instanceof aoll)))
    {
      if (!top.fv(this.mUinType)) {
        break label56;
      }
      str = "multimsgCd";
    }
    for (;;)
    {
      ((aoll)this.jdField_a_of_type_Aomg).bZ = MsfSdkUtils.insertMtype(str, ((aoll)this.jdField_a_of_type_Aomg).bZ);
      return;
      label56:
      if (this.mUinType == 1) {
        str = "multimsgGd";
      } else {
        str = "multimsgDd";
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (aona.lQ(this.errCode))) {}
    while ((this.cLT) || ((paramBoolean) && ((this.dOZ & 0x2) > 0)) || ((!paramBoolean) && ((this.dOZ & 0x1) > 0))) {
      return;
    }
    int j = this.dOZ;
    int i;
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.dOZ = (i | j);
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      String str = this.jdField_a_of_type_Aojn$a.fB(1) + ";" + this.jdField_b_of_type_Aojn$a.fB(2) + ";" + this.jdField_c_of_type_Aojn$a.fB(3);
      this.mM.put("param_step", str);
      this.mM.put("param_grpUin", this.h.mPeerUin);
      this.mM.put("param_uuid", this.h.cmo);
      if (!paramBoolean) {
        break label235;
      }
      P(true, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), true, l, this.apq, this.mM, "");
    }
    for (;;)
    {
      dVc();
      return;
      i = 1;
      break;
      label235:
      if (this.errCode != -9527) {
        this.mM.remove("param_rspHeader");
      }
      this.mM.put("param_FailCode", String.valueOf(this.errCode));
      this.mM.put("param_errorDesc", this.errDesc);
      P(false, l);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, AJ(), false, l, 0L, this.mM, "");
    }
  }
  
  void onError()
  {
    super.onError();
    if (this.h.b != null)
    {
      akxb.a locala = new akxb.a();
      locala.errCode = -1;
      locala.a = new akxn.a();
      locala.a.bUJ = "[MultiMsgDownloadProcessor] download failed";
      locala.data = null;
      this.h.b.a(locala);
    }
    this.fS = null;
    VR(2005);
  }
  
  public void onResp(aomh paramaomh)
  {
    boolean bool2 = true;
    Object localObject = this.jdField_b_of_type_Aojn$a;
    if (paramaomh.mResult == 0)
    {
      bool1 = true;
      a((aojn.a)localObject, paramaomh, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramaomh.mResult != 0) {
        break label154;
      }
    }
    label154:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hM("onHttpResp", bool1);
      this.apq = paramaomh.apU;
      this.jdField_a_of_type_Aomg = null;
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.jdField_b_of_type_Aoko.a.clF = ((String)paramaomh.nR.get("param_rspHeader"));
      if ((paramaomh.mResult != 0) || (!qd(this.clR))) {
        break label159;
      }
      onSuccess();
      return;
      bool1 = false;
      break;
    }
    label159:
    if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
    {
      hM("[netChg]", "failed.but net change detect.so retry");
      this.dOY += 1;
      dVd();
      dVP();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    Object localObject1;
    if (this.h.b != null)
    {
      localObject1 = new akxb.a();
      ((akxb.a)localObject1).errCode = 0;
      ((akxb.a)localObject1).data = this.fS;
      ((akxb.a)localObject1).md5 = this.h.mMd5;
      ((akxb.a)localObject1).dpA = this.h.mFileType;
      ((akxb.a)localObject1).dpB = this.h.dpB;
      ((akxb.a)localObject1).bQY = this.h.ckW;
      ((akxb.a)localObject1).uniseq = this.h.mUniseq;
      ((akxb.a)localObject1).resid = this.h.cmp;
      this.h.b.a((akxb.a)localObject1);
    }
    for (;;)
    {
      this.fS = null;
      VR(2003);
      return;
      localObject1 = new HashMap();
      Object localObject2 = this.app.b().a(this.h.mPeerUin, this.h.mUinType, this.h.mUniseq);
      localObject2 = this.app.a().b().a(this.fS, (HashMap)localObject1, (MessageRecord)localObject2, null);
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        ajlc.a().a((HashMap)localObject1, this.h.mUniseq, this.app);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "BaseTransProcessoronSuccess.onDownload,MultiMsg ");
        }
      }
    }
  }
  
  public void start()
  {
    VR(1000);
    VR(2001);
    dVP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aolz
 * JD-Core Version:    0.7.0.1
 */