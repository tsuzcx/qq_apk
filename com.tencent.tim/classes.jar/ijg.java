import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Random;
import mqq.app.MobileQQ;

public abstract class ijg
  extends accg
{
  static long lr;
  private boolean RG;
  private ijh.a a = ijh.a.a();
  private ijf b = ijf.a();
  private Random mRandom = new Random();
  
  public ijg(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  abstract void D(long paramLong1, long paramLong2);
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg(paramString2);
    AudioTransClientTransInfo.InfoHead localInfoHead = new AudioTransClientTransInfo.InfoHead();
    Object localObject2 = localInfoHead.str_session_id;
    if (TextUtils.isEmpty(paramString3)) {}
    for (Object localObject1 = "0";; localObject1 = paramString3)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localInfoHead.str_uin.set(this.mApp.getCurrentAccountUin());
      localInfoHead.uint32_seq.set((int)paramLong);
      localInfoHead.enum_body_type.set(1);
      localObject1 = new AudioTransClientTransInfo.InfoReqBody();
      localObject2 = new AudioTransClientTransInfo.InfoC2SCreateSessionReq();
      String str = ay();
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_business_type.set(1);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).rpt_member_list.set(Arrays.asList(new String[] { localInfoHead.str_uin.get(), str }));
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_business_direction.set(4);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_term.set(4);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).uint32_client_ver.set(getVersion());
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_net_type.set(getNetType());
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).bool_translate.set(ts());
      ((AudioTransClientTransInfo.InfoReqBody)localObject1).msg_create_session_req.set((MessageMicro)localObject2);
      localObject2 = this.b;
      localToServiceMsg.putWupBuffer(ijf.g(localInfoHead.toByteArray(), ((AudioTransClientTransInfo.InfoReqBody)localObject1).toByteArray()));
      boolean bool = aqiw.isNetworkAvailable(this.mApp.getApplication().getApplicationContext());
      if (bool) {
        sendPbReq(localToServiceMsg);
      }
      long l1 = System.currentTimeMillis();
      long l2 = lr;
      lr = l1;
      QLog.w("AudioTransClientInfoHandler", 1, "sendCmdToService, cmd[" + paramString2 + "], seq[" + paramLong + "], sessionID[" + paramString3 + "], isNetworkAvailable[" + bool + "], from[" + paramString1 + "], sendInterval[" + (l1 - l2) + "]");
      return;
    }
  }
  
  public void anc()
  {
    this.RG = false;
  }
  
  abstract String ay();
  
  abstract int getNetType();
  
  public String getSessionId()
  {
    return String.valueOf(this.a.mSessionId);
  }
  
  abstract int getVersion();
  
  abstract boolean isSender();
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  /* Error */
  public void onReceive(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 276	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +641 -> 645
    //   7: aload_0
    //   8: getfield 32	ijg:b	Lijf;
    //   11: astore_1
    //   12: aload_2
    //   13: invokevirtual 279	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   16: invokestatic 282	ijf:a	([B)Lijf$a;
    //   19: astore_2
    //   20: aload_2
    //   21: getfield 288	ijf$a:head	[B
    //   24: astore_1
    //   25: aload_2
    //   26: getfield 291	ijf$a:body	[B
    //   29: astore_2
    //   30: new 49	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   33: dup
    //   34: invokespecial 50	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 295	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: checkcast 49	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   46: astore_1
    //   47: aload_1
    //   48: getfield 85	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   51: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   54: istore 4
    //   56: aload_1
    //   57: getfield 300	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 303	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   63: ifeq +572 -> 635
    //   66: new 305	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   69: dup
    //   70: invokespecial 306	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:<init>	()V
    //   73: aload_2
    //   74: invokevirtual 307	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 305	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   80: astore_2
    //   81: aload_1
    //   82: getfield 300	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   85: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   88: ifne +462 -> 550
    //   91: aload_2
    //   92: getfield 311	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_create_session_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp;
    //   95: invokevirtual 316	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 313	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 39	ijg:a	Lijh$a;
    //   106: aload_2
    //   107: getfield 319	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_channel_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   110: invokevirtual 320	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   113: putfield 324	ijh$a:mChannelType	I
    //   116: aload_0
    //   117: getfield 39	ijg:a	Lijh$a;
    //   120: aload_2
    //   121: getfield 327	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_translator_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   124: invokevirtual 320	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   127: putfield 330	ijh$a:anH	I
    //   130: aload_0
    //   131: getfield 39	ijg:a	Lijh$a;
    //   134: aload_1
    //   135: getfield 54	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:str_session_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   138: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   141: invokestatic 335	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   144: invokevirtual 338	java/lang/Long:longValue	()J
    //   147: putfield 256	ijh$a:mSessionId	J
    //   150: aload_2
    //   151: getfield 342	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:rpt_msg_interface_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: invokevirtual 347	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 39	ijg:a	Lijh$a;
    //   162: new 349	java/util/ArrayList
    //   165: dup
    //   166: invokespecial 350	java/util/ArrayList:<init>	()V
    //   169: putfield 354	ijh$a:eM	Ljava/util/List;
    //   172: aload_0
    //   173: invokevirtual 356	ijg:isSender	()Z
    //   176: istore 5
    //   178: ldc 213
    //   180: iconst_1
    //   181: new 215	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 358
    //   191: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 4
    //   196: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 363
    //   202: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 39	ijg:a	Lijh$a;
    //   209: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: ldc_w 368
    //   215: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 5
    //   220: invokevirtual 234	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: ldc_w 370
    //   226: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 252	ijg:RG	Z
    //   233: invokevirtual 234	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   236: ldc 240
    //   238: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 249	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_1
    //   248: invokeinterface 376 1 0
    //   253: astore_1
    //   254: aload_1
    //   255: invokeinterface 381 1 0
    //   260: ifeq +233 -> 493
    //   263: aload_1
    //   264: invokeinterface 385 1 0
    //   269: checkcast 387	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr
    //   272: astore_2
    //   273: new 389	com/tencent/av/business/handler/NetAddr
    //   276: dup
    //   277: invokespecial 390	com/tencent/av/business/handler/NetAddr:<init>	()V
    //   280: astore_3
    //   281: aload_3
    //   282: aload_2
    //   283: getfield 394	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   286: invokevirtual 397	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   289: putfield 399	com/tencent/av/business/handler/NetAddr:fixed32_IP	I
    //   292: aload_3
    //   293: aload_2
    //   294: getfield 402	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   300: putfield 404	com/tencent/av/business/handler/NetAddr:uint32_port	I
    //   303: aload_3
    //   304: aload_2
    //   305: getfield 407	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   308: invokevirtual 320	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   311: putfield 409	com/tencent/av/business/handler/NetAddr:enum_proto_type	I
    //   314: aload_3
    //   315: aload_2
    //   316: getfield 412	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   319: invokevirtual 397	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   322: putfield 414	com/tencent/av/business/handler/NetAddr:fixed32_inner_IP	I
    //   325: aload_0
    //   326: getfield 39	ijg:a	Lijh$a;
    //   329: getfield 354	ijh$a:eM	Ljava/util/List;
    //   332: aload_3
    //   333: invokeinterface 418 2 0
    //   338: pop
    //   339: new 215	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 420
    //   349: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: astore_3
    //   353: aload_0
    //   354: getfield 32	ijg:b	Lijf;
    //   357: astore 6
    //   359: aload_3
    //   360: aload_2
    //   361: getfield 394	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   364: invokevirtual 397	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   367: invokestatic 424	ijf:aH	(I)Ljava/lang/String;
    //   370: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 426
    //   376: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_2
    //   380: getfield 402	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   386: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc_w 426
    //   392: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_2
    //   396: getfield 407	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   399: invokevirtual 320	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   402: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc_w 426
    //   408: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: astore_3
    //   412: aload_0
    //   413: getfield 32	ijg:b	Lijf;
    //   416: astore 6
    //   418: ldc 213
    //   420: iconst_2
    //   421: aload_3
    //   422: aload_2
    //   423: getfield 412	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   426: invokevirtual 397	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   429: invokestatic 424	ijf:aH	(I)Ljava/lang/String;
    //   432: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: goto -187 -> 254
    //   444: astore_1
    //   445: aload_1
    //   446: invokevirtual 432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   449: ldc 213
    //   451: iconst_2
    //   452: new 215	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 434
    //   462: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 437	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: return
    //   479: astore_1
    //   480: ldc 213
    //   482: iconst_1
    //   483: ldc_w 442
    //   486: aload_1
    //   487: invokestatic 445	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: goto -340 -> 150
    //   493: aload_0
    //   494: getfield 75	ijg:mApp	Lcom/tencent/common/app/AppInterface;
    //   497: iconst_0
    //   498: invokevirtual 449	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   501: checkcast 451	iji
    //   504: iload 4
    //   506: i2l
    //   507: iconst_1
    //   508: aload_0
    //   509: getfield 39	ijg:a	Lijh$a;
    //   512: getfield 354	ijh$a:eM	Ljava/util/List;
    //   515: aload_0
    //   516: getfield 39	ijg:a	Lijh$a;
    //   519: getfield 256	ijh$a:mSessionId	J
    //   522: invokevirtual 454	iji:a	(JZLjava/util/List;J)V
    //   525: aload_0
    //   526: iconst_1
    //   527: putfield 252	ijg:RG	Z
    //   530: iload 5
    //   532: ifeq -54 -> 478
    //   535: aload_0
    //   536: iload 4
    //   538: i2l
    //   539: aload_0
    //   540: getfield 39	ijg:a	Lijh$a;
    //   543: getfield 256	ijh$a:mSessionId	J
    //   546: invokevirtual 456	ijg:D	(JJ)V
    //   549: return
    //   550: aload_2
    //   551: getfield 460	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_failed_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp;
    //   554: invokevirtual 463	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   557: checkcast 462	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp
    //   560: astore_1
    //   561: ldc 213
    //   563: iconst_2
    //   564: ldc_w 465
    //   567: invokestatic 429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: ldc 213
    //   572: iconst_2
    //   573: new 215	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 467
    //   583: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_1
    //   587: getfield 470	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:uint32_errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   590: invokevirtual 297	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   593: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: ldc 213
    //   604: iconst_2
    //   605: new 215	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 472
    //   615: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_1
    //   619: getfield 475	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:str_errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   622: invokevirtual 118	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   625: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 429	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: return
    //   635: ldc 213
    //   637: iconst_2
    //   638: ldc_w 477
    //   641: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: return
    //   645: ldc 213
    //   647: iconst_2
    //   648: new 215	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 479
    //   658: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_2
    //   662: invokevirtual 482	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   665: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 440	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	ijg
    //   0	675	1	paramToServiceMsg	ToServiceMsg
    //   0	675	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	675	3	paramObject	Object
    //   54	483	4	i	int
    //   176	355	5	bool	boolean
    //   357	60	6	localijf	ijf
    // Exception table:
    //   from	to	target	type
    //   38	130	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	150	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   150	254	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   254	441	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   480	490	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   493	530	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   535	549	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   550	634	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   635	644	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	150	479	java/lang/Exception
  }
  
  public boolean tr()
  {
    return this.RG;
  }
  
  abstract boolean ts();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijg
 * JD-Core Version:    0.7.0.1
 */