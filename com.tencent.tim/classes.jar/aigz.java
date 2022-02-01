import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.aio.video.aio_video.ReqGetOpenIdByUin;

public class aigz
  extends MSFServlet
{
  public static NewIntent a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    int i = aqft.ag(paramLong2);
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), aigz.class);
    localNewIntent.putExtra("appId", i);
    localNewIntent.putExtra("sso_command", "QQAIOMediaSvc.get_openid_by_uin");
    localNewIntent.putExtra("req_type", 1);
    localNewIntent.putExtra("uin", paramLong1);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  /* Error */
  private void b(int paramInt, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_3
    //   4: invokevirtual 64	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   7: invokestatic 70	aqnv:J	([B)[B
    //   10: astore 9
    //   12: aload_3
    //   13: invokevirtual 74	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +326 -> 342
    //   19: aload 9
    //   21: ifnull +321 -> 342
    //   24: new 76	android/os/Bundle
    //   27: dup
    //   28: invokespecial 77	android/os/Bundle:<init>	()V
    //   31: astore 8
    //   33: aload_2
    //   34: ldc 30
    //   36: iconst_0
    //   37: invokevirtual 83	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   40: istore 4
    //   42: aload_2
    //   43: ldc 45
    //   45: lconst_0
    //   46: invokevirtual 87	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   49: lstore 6
    //   51: aload 8
    //   53: ldc 30
    //   55: iload 4
    //   57: invokevirtual 91	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: aload 8
    //   62: ldc 45
    //   64: lload 6
    //   66: invokevirtual 95	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   69: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +61 -> 133
    //   75: ldc 102
    //   77: iconst_2
    //   78: new 104	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   85: ldc 107
    //   87: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 5
    //   92: invokevirtual 114	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: ldc 116
    //   97: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 120	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   104: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc 125
    //   109: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 4
    //   114: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 127
    //   119: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 6
    //   124: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: iload 5
    //   135: ifeq +154 -> 289
    //   138: new 140	tencent/aio/video/aio_video$RspGetOpenIdByUin
    //   141: dup
    //   142: invokespecial 141	tencent/aio/video/aio_video$RspGetOpenIdByUin:<init>	()V
    //   145: astore_3
    //   146: aload_3
    //   147: aload 9
    //   149: invokevirtual 145	tencent/aio/video/aio_video$RspGetOpenIdByUin:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: pop
    //   153: aload_3
    //   154: getfield 149	tencent/aio/video/aio_video$RspGetOpenIdByUin:err_info	Ltencent/aio/video/aio_video$ErrInfo;
    //   157: getfield 155	tencent/aio/video/aio_video$ErrInfo:err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   160: invokevirtual 160	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   163: istore 4
    //   165: iload 4
    //   167: ifne +59 -> 226
    //   170: aload_3
    //   171: getfield 164	tencent/aio/video/aio_video$RspGetOpenIdByUin:open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   174: invokevirtual 169	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   177: invokevirtual 174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   180: astore_3
    //   181: aload 8
    //   183: ldc 176
    //   185: aload_3
    //   186: invokevirtual 180	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: ldc 102
    //   191: iconst_2
    //   192: new 104	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   199: ldc 182
    //   201: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_3
    //   205: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: aload_2
    //   216: iload_1
    //   217: iconst_1
    //   218: aload 8
    //   220: ldc 184
    //   222: invokevirtual 188	aigz:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   225: return
    //   226: aload_3
    //   227: getfield 149	tencent/aio/video/aio_video$RspGetOpenIdByUin:err_info	Ltencent/aio/video/aio_video$ErrInfo;
    //   230: getfield 191	tencent/aio/video/aio_video$ErrInfo:err_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 169	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   239: astore_3
    //   240: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +38 -> 281
    //   246: ldc 102
    //   248: iconst_2
    //   249: new 104	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   256: ldc 193
    //   258: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 4
    //   263: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc 195
    //   268: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_3
    //   272: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 198	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload 8
    //   283: ldc 200
    //   285: aload_3
    //   286: invokevirtual 180	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_0
    //   290: aload_2
    //   291: iload_1
    //   292: iconst_0
    //   293: aload 8
    //   295: ldc 184
    //   297: invokevirtual 188	aigz:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   300: return
    //   301: astore_3
    //   302: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq -16 -> 289
    //   308: ldc 102
    //   310: iconst_2
    //   311: ldc 202
    //   313: aload_3
    //   314: invokestatic 205	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: goto -28 -> 289
    //   320: astore_2
    //   321: aload_2
    //   322: athrow
    //   323: astore_3
    //   324: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -38 -> 289
    //   330: ldc 102
    //   332: iconst_2
    //   333: ldc 207
    //   335: aload_3
    //   336: invokestatic 205	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: goto -50 -> 289
    //   342: iconst_0
    //   343: istore 5
    //   345: goto -321 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	aigz
    //   0	348	1	paramInt	int
    //   0	348	2	paramIntent	Intent
    //   0	348	3	paramFromServiceMsg	FromServiceMsg
    //   40	222	4	i	int
    //   1	343	5	bool	boolean
    //   49	74	6	l	long
    //   31	263	8	localBundle	android.os.Bundle
    //   10	138	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   138	165	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   170	225	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   226	281	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   281	289	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   138	165	320	finally
    //   170	225	320	finally
    //   226	281	320	finally
    //   281	289	320	finally
    //   302	317	320	finally
    //   324	339	320	finally
    //   138	165	323	java/lang/Exception
    //   170	225	323	java/lang/Exception
    //   226	281	323	java/lang/Exception
    //   281	289	323	java/lang/Exception
  }
  
  private void i(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("uin", 0L);
    int i = paramIntent.getIntExtra("appId", 0);
    paramIntent = paramIntent.getStringExtra("sso_command");
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "sendPacket uin=" + l + " appId=" + i);
    }
    aio_video.ReqGetOpenIdByUin localReqGetOpenIdByUin = new aio_video.ReqGetOpenIdByUin();
    localReqGetOpenIdByUin.app_id.set(i);
    localReqGetOpenIdByUin.target_uin.set(l);
    paramPacket.setSSOCommand(paramIntent);
    paramPacket.putSendData(aqnv.I(localReqGetOpenIdByUin.toByteArray()));
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramIntent.getIntExtra("req_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "onReceive cmd:" + i);
    }
    b(i, paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "onSend");
    }
    i(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigz
 * JD-Core Version:    0.7.0.1
 */