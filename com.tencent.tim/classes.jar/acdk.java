import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class acdk
  extends acde
{
  public acdk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type == 1L) {
      d(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
    }
  }
  
  private void d(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {}
    amzx localamzx;
    do
    {
      return;
      if (!this.iE.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
      {
        localamzx = new amzx(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
        this.iE.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localamzx);
      }
      for (;;)
      {
        Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
        localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
        localObject = new String();
        int i = 0;
        while (i < localType_1_QQDataTextMsg.msg_item.size())
        {
          String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i)).bytes_text);
          localObject = (String)localObject + str;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, str);
          }
          i += 1;
        }
        localamzx = (amzx)this.iE.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      }
      localamzx.dG((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    } while (!localamzx.awr());
    this.iE.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    Object localObject = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).msg = localamzx.zr();
    ((DataLineMsgRecord)localObject).msgtype = -1000;
    ((DataLineMsgRecord)localObject).issend = 0;
    ((DataLineMsgRecord)localObject).isread = false;
    ((DataLineMsgRecord)localObject).time = paramInt;
    ((DataLineMsgRecord)localObject).issuc = true;
    ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
    ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
    paramShort = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject).sessionid);
    this.app.b().a(paramShort).a((DataLineMsgRecord)localObject, true);
    this.app.q(1, true, true);
    e(8, true, new Object[] { Integer.valueOf(paramInt), localamzx.zr(), Long.valueOf(((DataLineMsgRecord)localObject).sessionid) });
  }
  
  /* Error */
  public void b(msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 210	acde:b	(Lmsf/msgcomm/msg_comm$Msg;)V
    //   5: new 212	msf/msgcomm/msg_comm$MsgType0x210
    //   8: dup
    //   9: invokespecial 213	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_1
    //   15: getfield 219	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   18: invokevirtual 224	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 221	tencent/im/msg/im_msg_body$MsgBody
    //   24: getfield 228	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   27: invokevirtual 233	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   30: invokevirtual 239	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   33: invokevirtual 243	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   36: checkcast 212	msf/msgcomm/msg_comm$MsgType0x210
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 111
    //   50: iconst_2
    //   51: ldc 245
    //   53: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 58	com/qq/taf/jce/JceInputStream
    //   59: dup
    //   60: aload_2
    //   61: getfield 246	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   64: invokevirtual 233	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   67: invokevirtual 239	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   70: invokespecial 65	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   73: astore_3
    //   74: new 248	IMMsgBodyPack/MsgType0x210
    //   77: dup
    //   78: invokespecial 249	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   81: astore_2
    //   82: aload_2
    //   83: aload_3
    //   84: invokevirtual 250	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   87: new 132	com/tencent/mobileqq/data/DataLineMsgRecord
    //   90: dup
    //   91: invokespecial 133	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_1
    //   97: getfield 254	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   100: invokevirtual 257	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 256	msf/msgcomm/msg_comm$MsgHead
    //   106: getfield 261	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 265	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: i2l
    //   113: putfield 166	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   116: aload_3
    //   117: aload_1
    //   118: getfield 254	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   121: invokevirtual 257	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: checkcast 256	msf/msgcomm/msg_comm$MsgHead
    //   127: getfield 268	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 265	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: i2l
    //   134: putfield 160	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   137: aload_3
    //   138: aload_1
    //   139: getfield 254	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   142: invokevirtual 257	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   145: checkcast 256	msf/msgcomm/msg_comm$MsgHead
    //   148: getfield 272	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 277	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: putfield 136	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   157: aload_0
    //   158: aload_3
    //   159: iconst_1
    //   160: invokevirtual 280	acdk:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   163: ifeq +78 -> 241
    //   166: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +51 -> 220
    //   172: ldc 111
    //   174: iconst_2
    //   175: new 94	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 282
    //   185: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: getfield 166	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   192: invokevirtual 285	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc_w 287
    //   198: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: getfield 160	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   205: invokevirtual 285	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc_w 289
    //   211: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_3
    //   222: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +13 -> 238
    //   228: ldc 111
    //   230: iconst_2
    //   231: ldc_w 291
    //   234: aload_3
    //   235: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: goto -196 -> 42
    //   241: aload_0
    //   242: getfield 174	acdk:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   245: bipush 10
    //   247: invokevirtual 298	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   250: checkcast 300	ackv
    //   253: astore_1
    //   254: aload_1
    //   255: ifnull +16 -> 271
    //   258: aload_1
    //   259: invokevirtual 303	ackv:AO	()I
    //   262: iconst_1
    //   263: if_icmpeq +8 -> 271
    //   266: aload_1
    //   267: iconst_1
    //   268: invokevirtual 307	ackv:ac	(I)V
    //   271: aload_2
    //   272: getfield 310	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   275: ldc2_w 311
    //   278: lcmp
    //   279: ifne +69 -> 348
    //   282: aload_0
    //   283: aload_2
    //   284: getfield 316	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   287: getfield 319	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   290: l2i
    //   291: aload_2
    //   292: getfield 316	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   295: getfield 322	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   298: l2i
    //   299: invokevirtual 325	acdk:e	(II)Z
    //   302: ifne -82 -> 220
    //   305: aload_0
    //   306: aload_2
    //   307: getfield 316	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   310: getfield 328	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   313: l2i
    //   314: aload_2
    //   315: getfield 316	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   318: getfield 331	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   321: l2i
    //   322: invokevirtual 333	acdk:q	(II)Z
    //   325: ifeq -105 -> 220
    //   328: aload_0
    //   329: aload_3
    //   330: getfield 160	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   333: l2i
    //   334: aload_3
    //   335: getfield 166	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   338: l2i
    //   339: i2s
    //   340: aload_2
    //   341: getfield 316	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   344: invokespecial 335	acdk:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   347: return
    //   348: aload_2
    //   349: getfield 310	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   352: ldc2_w 336
    //   355: lcmp
    //   356: ifne +161 -> 517
    //   359: aload_0
    //   360: aload_2
    //   361: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   364: getfield 346	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   367: l2i
    //   368: aload_2
    //   369: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   372: getfield 349	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   375: l2i
    //   376: invokevirtual 325	acdk:e	(II)Z
    //   379: ifne -159 -> 220
    //   382: aload_0
    //   383: aload_2
    //   384: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   387: getfield 352	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   390: l2i
    //   391: aload_2
    //   392: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   395: getfield 355	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   398: l2i
    //   399: invokevirtual 333	acdk:q	(II)Z
    //   402: ifeq -182 -> 220
    //   405: aload_0
    //   406: getfield 358	acdk:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   409: aload_2
    //   410: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   413: getfield 361	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   416: aload_2
    //   417: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   420: getfield 364	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   423: aload_2
    //   424: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   427: getfield 367	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   430: new 71	java/lang/String
    //   433: dup
    //   434: aload_2
    //   435: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   438: getfield 370	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   441: invokespecial 92	java/lang/String:<init>	([B)V
    //   444: aload_2
    //   445: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   448: getfield 373	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   451: aload_2
    //   452: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   455: getfield 376	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   458: new 71	java/lang/String
    //   461: dup
    //   462: aload_2
    //   463: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   466: getfield 379	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   469: invokespecial 92	java/lang/String:<init>	([B)V
    //   472: aload_2
    //   473: getfield 341	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   476: getfield 382	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   479: iconst_0
    //   480: iconst_0
    //   481: iconst_0
    //   482: iconst_0
    //   483: aload_3
    //   484: getfield 160	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   487: l2i
    //   488: i2l
    //   489: aload_3
    //   490: getfield 166	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   493: l2i
    //   494: i2s
    //   495: i2l
    //   496: aload_3
    //   497: getfield 136	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   500: iconst_0
    //   501: invokevirtual 388	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFTNNotify_0x210	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   504: astore_1
    //   505: aload_0
    //   506: getfield 391	acdk:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   509: aload_1
    //   510: invokevirtual 397	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   513: return
    //   514: astore_1
    //   515: aload_1
    //   516: athrow
    //   517: aload_2
    //   518: getfield 310	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   521: ldc2_w 398
    //   524: lcmp
    //   525: ifne +172 -> 697
    //   528: aload_0
    //   529: aload_2
    //   530: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   533: getfield 406	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   536: l2i
    //   537: aload_2
    //   538: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   541: getfield 407	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   544: l2i
    //   545: invokevirtual 325	acdk:e	(II)Z
    //   548: ifne -328 -> 220
    //   551: aload_0
    //   552: aload_2
    //   553: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   556: getfield 408	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   559: l2i
    //   560: aload_2
    //   561: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   564: getfield 409	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   567: l2i
    //   568: invokevirtual 333	acdk:q	(II)Z
    //   571: ifeq -351 -> 220
    //   574: aload_0
    //   575: getfield 358	acdk:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   578: aload_2
    //   579: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   582: getfield 410	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   585: aload_2
    //   586: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   589: getfield 411	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   592: aload_2
    //   593: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   596: getfield 412	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   599: new 71	java/lang/String
    //   602: dup
    //   603: aload_2
    //   604: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   607: getfield 413	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   610: invokespecial 92	java/lang/String:<init>	([B)V
    //   613: aload_2
    //   614: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   617: getfield 416	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   620: aload_2
    //   621: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   624: getfield 419	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   627: aload_2
    //   628: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   631: getfield 422	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   634: aload_2
    //   635: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   638: getfield 425	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   641: aload_2
    //   642: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   645: getfield 428	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   648: aload_2
    //   649: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   652: getfield 431	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   655: aload_2
    //   656: getfield 403	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   659: getfield 432	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   662: iconst_0
    //   663: iconst_0
    //   664: iconst_0
    //   665: iconst_0
    //   666: aload_3
    //   667: getfield 160	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   670: l2i
    //   671: i2l
    //   672: aload_3
    //   673: getfield 166	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   676: l2i
    //   677: i2s
    //   678: i2l
    //   679: aload_3
    //   680: getfield 136	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   683: iconst_0
    //   684: invokevirtual 436	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromNFCNotify_0x210	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   687: astore_1
    //   688: aload_0
    //   689: getfield 391	acdk:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   692: aload_1
    //   693: invokevirtual 397	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   696: return
    //   697: aload_2
    //   698: getfield 310	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   701: ldc2_w 437
    //   704: lcmp
    //   705: ifne -485 -> 220
    //   708: aload_0
    //   709: aload_2
    //   710: getfield 442	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   713: getfield 445	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   716: l2i
    //   717: aload_2
    //   718: getfield 442	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   721: getfield 446	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   724: l2i
    //   725: invokevirtual 325	acdk:e	(II)Z
    //   728: ifne -508 -> 220
    //   731: aload_0
    //   732: aload_2
    //   733: getfield 442	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   736: getfield 447	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   739: l2i
    //   740: aload_2
    //   741: getfield 442	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   744: getfield 448	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   747: l2i
    //   748: invokevirtual 333	acdk:q	(II)Z
    //   751: ifeq -531 -> 220
    //   754: aload_0
    //   755: getfield 358	acdk:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   758: aload_2
    //   759: getfield 442	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   762: getfield 449	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   765: aload_2
    //   766: getfield 442	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   769: getfield 452	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   772: iconst_0
    //   773: aload_3
    //   774: getfield 160	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   777: l2i
    //   778: aload_3
    //   779: getfield 166	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   782: l2i
    //   783: i2s
    //   784: invokevirtual 456	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFileControl_0x210	(JJIIS)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   787: astore_1
    //   788: aload_0
    //   789: getfield 391	acdk:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   792: aload_1
    //   793: invokevirtual 397	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   796: return
    //   797: astore_1
    //   798: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	acdk
    //   0	799	1	paramMsg	msf.msgcomm.msg_comm.Msg
    //   12	754	2	localObject1	Object
    //   39	163	3	localObject2	Object
    //   221	558	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   13	40	221	java/lang/Exception
    //   82	220	514	finally
    //   241	254	514	finally
    //   258	271	514	finally
    //   271	347	514	finally
    //   348	513	514	finally
    //   517	696	514	finally
    //   697	796	514	finally
    //   82	220	797	java/lang/Exception
    //   241	254	797	java/lang/Exception
    //   258	271	797	java/lang/Exception
    //   271	347	797	java/lang/Exception
    //   348	513	797	java/lang/Exception
    //   517	696	797	java/lang/Exception
    //   697	796	797	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdk
 * JD-Core Version:    0.7.0.1
 */