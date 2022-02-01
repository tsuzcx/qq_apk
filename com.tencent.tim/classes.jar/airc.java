import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.net.RoomQueryHandler.1;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.location.RoomOperate.ReqRoomQuery;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class airc
  extends aiqp<aiqs>
{
  private static int intervalMillis = 5000;
  private long abS;
  private AtomicInteger bu = new AtomicInteger(0);
  private final Handler db = new Handler(ThreadManager.getSubThreadLooper());
  private AtomicBoolean jdField_do = new AtomicBoolean(true);
  private Runnable gS;
  
  public airc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void dm(int paramInt, String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", paramString);
      }
    }
    l(paramInt, l1, false);
  }
  
  private void dtX()
  {
    a().notifyUI(2, false, null);
  }
  
  private void l(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoom: invoked. ", " uinType: ", Integer.valueOf(paramInt), " sessionUin: ", Long.valueOf(paramLong), " noLimitReq: ", Boolean.valueOf(paramBoolean) });
    }
    long l = System.currentTimeMillis();
    if ((l - this.abS < this.bu.get() * 1000L) && (!paramBoolean))
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "[queryLocationRoom] requestQueryRoomNoLimit: invoked. frequency limited", " requestIntervalSecond: ", this.bu });
      return;
    }
    this.abS = l;
    RoomOperate.ReqRoomQuery localReqRoomQuery = new RoomOperate.ReqRoomQuery();
    localReqRoomQuery.no_limit.set(paramBoolean);
    Object localObject = aiuq.a(this.app, paramInt, paramLong);
    localReqRoomQuery.room_key.set((MessageMicro)localObject);
    localReqRoomQuery.room_key.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQLBSShareSvc.room_query");
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).putWupBuffer(localReqRoomQuery.toByteArray());
    a().sendPbReq((ToServiceMsg)localObject);
  }
  
  protected aiqs a()
  {
    return aiqs.a(this.app);
  }
  
  public void destroy()
  {
    dtY();
  }
  
  public void dn(int paramInt, String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", localNumberFormatException);
      }
    }
    aiqs.a(this.app).dj(paramInt, paramString);
    l(paramInt, l1, true);
  }
  
  public void jdField_do(int paramInt, String paramString)
  {
    if (!this.jdField_do.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoomInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.jdField_do.set(false);
    this.gS = new RoomQueryHandler.1(this, paramInt, paramString);
    this.db.post(this.gS);
  }
  
  public void dtY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] stopRequestQueryRoomInLoop: invoked. ", " loopQueryStopped: ", this.jdField_do });
    }
    this.jdField_do.set(true);
    if (this.jdField_do != null) {
      this.db.removeCallbacks(this.gS);
    }
  }
  
  /* Error */
  public void jS(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokevirtual 270	airc:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Z
    //   7: ifeq +287 -> 294
    //   10: new 272	tencent/im/oidb/location/RoomOperate$RspRoomQuery
    //   13: dup
    //   14: invokespecial 273	tencent/im/oidb/location/RoomOperate$RspRoomQuery:<init>	()V
    //   17: aload_3
    //   18: checkcast 275	[B
    //   21: checkcast 275	[B
    //   24: invokevirtual 279	tencent/im/oidb/location/RoomOperate$RspRoomQuery:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 272	tencent/im/oidb/location/RoomOperate$RspRoomQuery
    //   30: astore_2
    //   31: aload_2
    //   32: getfield 283	tencent/im/oidb/location/RoomOperate$RspRoomQuery:room_state	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   35: invokevirtual 286	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   38: istore 4
    //   40: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +118 -> 161
    //   46: aload_2
    //   47: getfield 290	tencent/im/oidb/location/RoomOperate$RspRoomQuery:user_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 295	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   53: astore 6
    //   55: new 297	java/util/ArrayList
    //   58: dup
    //   59: invokespecial 298	java/util/ArrayList:<init>	()V
    //   62: astore_3
    //   63: aload 6
    //   65: invokeinterface 304 1 0
    //   70: astore 6
    //   72: aload 6
    //   74: invokeinterface 309 1 0
    //   79: ifeq +42 -> 121
    //   82: aload_3
    //   83: aload 6
    //   85: invokeinterface 313 1 0
    //   90: checkcast 315	tencent/im/oidb/location/RoomOperate$UserData
    //   93: getfield 318	tencent/im/oidb/location/RoomOperate$UserData:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   96: invokevirtual 322	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   99: invokestatic 116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: invokevirtual 326	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: goto -34 -> 72
    //   109: astore_1
    //   110: ldc 77
    //   112: iconst_1
    //   113: ldc_w 328
    //   116: aload_1
    //   117: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: return
    //   121: ldc 77
    //   123: iconst_2
    //   124: iconst_5
    //   125: anewarray 101	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 330
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc_w 332
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload 4
    //   144: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_3
    //   150: ldc_w 334
    //   153: aastore
    //   154: dup
    //   155: iconst_4
    //   156: aload_3
    //   157: aastore
    //   158: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   161: aload_2
    //   162: getfield 338	tencent/im/oidb/location/RoomOperate$RspRoomQuery:msg_result	Ltencent/im/oidb/location/qq_lbs_share$ResultInfo;
    //   165: invokevirtual 343	tencent/im/oidb/location/qq_lbs_share$ResultInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   168: checkcast 340	tencent/im/oidb/location/qq_lbs_share$ResultInfo
    //   171: invokestatic 346	aiuq:a	(Ltencent/im/oidb/location/qq_lbs_share$ResultInfo;)Z
    //   174: ifeq +115 -> 289
    //   177: aload_2
    //   178: getfield 350	tencent/im/oidb/location/RoomOperate$RspRoomQuery:req_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 353	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore 5
    //   186: aload_0
    //   187: getfield 40	airc:bu	Ljava/util/concurrent/atomic/AtomicInteger;
    //   190: iload 5
    //   192: invokevirtual 355	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   195: aload_1
    //   196: getfield 197	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   199: ldc 199
    //   201: iconst_m1
    //   202: invokevirtual 359	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   205: istore 5
    //   207: aload_1
    //   208: getfield 197	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   211: ldc 207
    //   213: invokevirtual 363	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_1
    //   217: iload 4
    //   219: iconst_2
    //   220: if_icmpne +39 -> 259
    //   223: aload_0
    //   224: invokevirtual 235	airc:dtY	()V
    //   227: aload_0
    //   228: getfield 161	airc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: invokestatic 231	aiqs:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laiqs;
    //   234: new 365	com/tencent/mobileqq/location/data/LocationRoom$b
    //   237: dup
    //   238: iload 5
    //   240: aload_1
    //   241: invokespecial 367	com/tencent/mobileqq/location/data/LocationRoom$b:<init>	(ILjava/lang/String;)V
    //   244: iconst_m1
    //   245: invokevirtual 371	aiqs:c	(Lcom/tencent/mobileqq/location/data/LocationRoom$b;I)V
    //   248: aload_0
    //   249: getfield 161	airc:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   252: iload 5
    //   254: aload_1
    //   255: iconst_0
    //   256: invokestatic 374	aiuq:b	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Z)V
    //   259: aload_0
    //   260: invokevirtual 89	airc:a	()Laiqs;
    //   263: iconst_2
    //   264: iconst_1
    //   265: iconst_3
    //   266: anewarray 101	java/lang/Object
    //   269: dup
    //   270: iconst_0
    //   271: aload_2
    //   272: aastore
    //   273: dup
    //   274: iconst_1
    //   275: iload 5
    //   277: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_2
    //   283: aload_1
    //   284: aastore
    //   285: invokevirtual 95	aiqs:notifyUI	(IZLjava/lang/Object;)V
    //   288: return
    //   289: aload_0
    //   290: invokespecial 376	airc:dtX	()V
    //   293: return
    //   294: aload_2
    //   295: ifnull +45 -> 340
    //   298: aload_2
    //   299: invokevirtual 381	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   302: istore 4
    //   304: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +33 -> 340
    //   310: ldc 77
    //   312: iconst_2
    //   313: iconst_3
    //   314: anewarray 101	java/lang/Object
    //   317: dup
    //   318: iconst_0
    //   319: ldc_w 330
    //   322: aastore
    //   323: dup
    //   324: iconst_1
    //   325: ldc_w 383
    //   328: aastore
    //   329: dup
    //   330: iconst_2
    //   331: iload 4
    //   333: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   340: aload_0
    //   341: invokespecial 376	airc:dtX	()V
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	airc
    //   0	345	1	paramToServiceMsg	ToServiceMsg
    //   0	345	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	345	3	paramObject	Object
    //   38	294	4	i	int
    //   184	92	5	j	int
    //   53	31	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	72	109	java/lang/Exception
    //   72	106	109	java/lang/Exception
    //   121	161	109	java/lang/Exception
    //   161	217	109	java/lang/Exception
    //   223	259	109	java/lang/Exception
    //   259	288	109	java/lang/Exception
    //   289	293	109	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airc
 * JD-Core Version:    0.7.0.1
 */