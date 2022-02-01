import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.chatroom.ChatRoomMng.2;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.NewIntent;
import tencent.av.chatroom.chatroom_sso.Msg;
import tencent.av.chatroom.chatroom_sso.PushMsg;
import tencent.av.chatroom.chatroom_sso.ReqGetMsg;
import tencent.av.chatroom.chatroom_sso.ReqSendMsg;
import tencent.av.chatroom.chatroom_sso.RoomKey;

public class ilu
  implements Handler.Callback
{
  private final ConcurrentHashMap<ChatRoomInfo, ConcurrentLinkedQueue<ilw>> aD = new ConcurrentHashMap();
  private int aoR = 0;
  private final ConcurrentLinkedQueue<ChatRoomInfo> k = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<ilx> l = new ConcurrentLinkedQueue();
  private final VideoAppInterface mApp;
  private final Handler mHandler;
  Comparator<ilw> p = new ilv(this);
  
  public ilu(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private ChatRoomInfo a(chatroom_sso.RoomKey paramRoomKey)
  {
    Object localObject1 = igv.a().a();
    int i = ((iiv)localObject1).kN();
    long l5 = ((iiv)localObject1).bz();
    long l3 = ((iiv)localObject1).getRoomId();
    long l4 = ((iiv)localObject1).kO();
    long l2 = l4;
    long l1 = l3;
    Object localObject2;
    if (i == paramRoomKey.type.get())
    {
      l2 = l4;
      l1 = l3;
      if (l5 == paramRoomKey.id.get())
      {
        localObject2 = this.mApp.b();
        if (localObject2 != null) {
          ((VideoController)localObject2).a("pushMsg", (iiv)localObject1);
        }
        l1 = ((iiv)localObject1).getRoomId();
        l2 = ((iiv)localObject1).kO();
      }
    }
    if ((i == paramRoomKey.type.get()) && (l5 == paramRoomKey.id.get()) && (l1 == paramRoomKey.room_id.get()) && (l2 == paramRoomKey.create_ts.get())) {}
    for (localObject1 = a((iiv)localObject1);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Iterator localIterator = this.k.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (ChatRoomInfo)localIterator.next();
        } while ((localObject2 == null) || (((ChatRoomInfo)localObject2).type != paramRoomKey.type.get()) || (((ChatRoomInfo)localObject2).id != paramRoomKey.id.get()) || (((ChatRoomInfo)localObject2).createTime != paramRoomKey.create_ts.get()) || (((ChatRoomInfo)localObject2).lJ == paramRoomKey.room_id.get()));
      }
      for (paramRoomKey = (chatroom_sso.RoomKey)localObject2;; paramRoomKey = null)
      {
        if (paramRoomKey != localObject1) {
          a(paramRoomKey);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomMng", 2, "checkFromPushMsg, curRoomInfo[" + localObject1 + "]");
        }
        return localObject1;
      }
    }
  }
  
  private ConcurrentLinkedQueue<ilw> a(ChatRoomInfo paramChatRoomInfo)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)this.aD.get(paramChatRoomInfo);
    ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
    if (localConcurrentLinkedQueue2 == null)
    {
      localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
      this.aD.put(paramChatRoomInfo, localConcurrentLinkedQueue1);
    }
    return localConcurrentLinkedQueue1;
  }
  
  private void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    this.aoR |= paramInt;
    if (!this.mHandler.hasMessages(1, paramChatRoomInfo))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramChatRoomInfo;
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo, long paramLong)
  {
    if (paramChatRoomInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomMng", 2, "doRetryGetMsgList, room[" + paramChatRoomInfo + "], retryDelay[" + paramLong + "], canRetry[" + paramChatRoomInfo.tV() + "]");
      }
      paramLong = Math.max(paramLong, 1000L);
    } while (!paramChatRoomInfo.tV());
    Message localMessage = Message.obtain();
    localMessage.obj = paramChatRoomInfo;
    localMessage.what = 3;
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void a(ilw paramilw)
  {
    if ((paramilw == null) || (paramilw.b == null)) {}
    ChatRoomInfo localChatRoomInfo;
    do
    {
      return;
      localChatRoomInfo = paramilw.b;
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(this.mApp.getCurrentAccountUin());
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          long l2;
          Object localObject;
          chatroom_sso.Msg localMsg;
          chatroom_sso.ReqSendMsg localReqSendMsg;
          QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
        }
      }
      l2 = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomMng", 2, "sendMsg, seq[" + l2 + "], room[" + localChatRoomInfo + "], msg[" + paramilw + "]");
      }
      paramilw.aod();
      localObject = new chatroom_sso.RoomKey();
      ((chatroom_sso.RoomKey)localObject).type.set(localChatRoomInfo.type);
      ((chatroom_sso.RoomKey)localObject).room_id.set(localChatRoomInfo.lJ);
      ((chatroom_sso.RoomKey)localObject).id.set(localChatRoomInfo.id);
      ((chatroom_sso.RoomKey)localObject).create_ts.set((int)localChatRoomInfo.createTime);
      localMsg = new chatroom_sso.Msg();
      localMsg.msg.set(paramilw.msg);
      localMsg.uin.set(l1);
      localReqSendMsg = new chatroom_sso.ReqSendMsg();
      localReqSendMsg.room_key.set((MessageMicro)localObject);
      localReqSendMsg.msg.set(localMsg);
      localObject = new NewIntent(this.mApp.getApplication(), iho.class);
      ((NewIntent)localObject).putExtra("reqType", 21);
      ((NewIntent)localObject).putExtra("vMsg", localReqSendMsg.toByteArray());
      ((NewIntent)localObject).putExtra("room_key", localChatRoomInfo);
      ((NewIntent)localObject).putExtra("localSeq", paramilw.lN);
      jlc.a((Intent)localObject, l2);
      this.mApp.startServlet((NewIntent)localObject);
    } while (paramilw.state != ilw.STATE_SENDING);
    a(1, localChatRoomInfo);
  }
  
  private void b(ilw paramilw)
  {
    if (!this.mHandler.hasMessages(2, paramilw))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.obj = paramilw;
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  public ChatRoomInfo a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      ChatRoomInfo localChatRoomInfo = (ChatRoomInfo)localIterator.next();
      if ((localChatRoomInfo != null) && (localChatRoomInfo.a(paramInt, paramLong1, paramLong2, paramLong3))) {
        return localChatRoomInfo;
      }
    }
    return null;
  }
  
  public ChatRoomInfo a(iiv paramiiv)
  {
    ChatRoomInfo localChatRoomInfo = a(paramiiv, true);
    Object localObject;
    if (localChatRoomInfo != null)
    {
      localObject = (ConcurrentLinkedQueue)this.aD.get(localChatRoomInfo);
      if (localObject != null) {
        break label189;
      }
      localObject = new ConcurrentLinkedQueue();
      this.aD.put(localChatRoomInfo, localObject);
    }
    for (;;)
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = localChatRoomInfo;
      ((Message)localObject).what = 3;
      this.mHandler.sendMessage((Message)localObject);
      if ((QLog.isDevelopLevel()) && (paramiiv != null)) {
        QLog.i("ChatRoomMng", 4, "enterChatRoom, SessionType[" + paramiiv.amI + "], relationType[" + paramiiv.relationType + "], relationId[" + paramiiv.ll + "], peerUin[" + paramiiv.peerUin + "], extraUin[" + paramiiv.MP + "], isDoubleVideoMeeting[" + paramiiv.Qw + "], room[" + localChatRoomInfo + "]");
      }
      return localChatRoomInfo;
      label189:
      ((ConcurrentLinkedQueue)localObject).clear();
    }
  }
  
  public ChatRoomInfo a(iiv paramiiv, boolean paramBoolean)
  {
    Object localObject = null;
    int i;
    long l5;
    long l2;
    long l1;
    if (paramiiv != null)
    {
      i = paramiiv.kN();
      l5 = paramiiv.bz();
      long l3 = paramiiv.getRoomId();
      long l4 = paramiiv.kO();
      l2 = l3;
      l1 = l4;
      if (paramBoolean) {
        if (l3 != 0L)
        {
          l2 = l3;
          l1 = l4;
          if (i == 1)
          {
            l2 = l3;
            l1 = l4;
            if (l4 != 0L) {}
          }
        }
        else
        {
          if (i != 2) {
            break label359;
          }
          VideoController.a().bv();
        }
      }
    }
    for (;;)
    {
      l2 = paramiiv.getRoomId();
      l1 = paramiiv.kO();
      ChatRoomInfo localChatRoomInfo2 = a(i, l2, l5, l1);
      localObject = localChatRoomInfo2;
      if (localChatRoomInfo2 == null)
      {
        localObject = localChatRoomInfo2;
        if (paramBoolean)
        {
          ChatRoomInfo localChatRoomInfo1 = localChatRoomInfo2;
          if (l2 != 0L)
          {
            localChatRoomInfo1 = localChatRoomInfo2;
            if (l5 != 0L)
            {
              localChatRoomInfo1 = localChatRoomInfo2;
              if (i != 0)
              {
                localChatRoomInfo1 = new ChatRoomInfo(i, l2, l5, l1);
                this.k.add(localChatRoomInfo1);
              }
            }
          }
          localObject = localChatRoomInfo1;
          if (QLog.isDevelopLevel())
          {
            QLog.i("ChatRoomMng", 4, "getRoomInfo, SessionType[" + paramiiv.amI + "], relationType[" + paramiiv.relationType + "], relationId[" + paramiiv.ll + "], peerUin[" + paramiiv.peerUin + "], extraUin[" + paramiiv.MP + "], isDoubleVideoMeeting[" + paramiiv.Qw + "], type[" + i + "], roomID[" + l2 + "], id[" + l5 + "], createTime[" + l1 + "], room[" + localChatRoomInfo1 + "]");
            localObject = localChatRoomInfo1;
          }
        }
      }
      return localObject;
      label359:
      if (i == 1) {
        VideoController.a().bw();
      }
    }
  }
  
  public ilw a(ChatRoomInfo paramChatRoomInfo, long paramLong)
  {
    if (paramChatRoomInfo == null) {
      return null;
    }
    paramChatRoomInfo = a(paramChatRoomInfo);
    if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0))
    {
      Iterator localIterator = paramChatRoomInfo.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramChatRoomInfo = (ilw)localIterator.next();
      } while ((paramChatRoomInfo == null) || (paramChatRoomInfo.lN != paramLong));
    }
    for (;;)
    {
      return paramChatRoomInfo;
      paramChatRoomInfo = null;
    }
  }
  
  /* Error */
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, Intent paramIntent, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokestatic 469	jlc:a	(Landroid/content/Intent;)J
    //   5: lstore 6
    //   7: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +65 -> 75
    //   13: ldc 170
    //   15: iconst_2
    //   16: new 172	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 471
    //   26: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_1
    //   30: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 473
    //   36: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_2
    //   40: invokevirtual 240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: ldc_w 475
    //   46: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_3
    //   50: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: ldc_w 477
    //   56: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload 6
    //   61: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: ldc 184
    //   66: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iload_1
    //   76: bipush 21
    //   78: if_icmpne +470 -> 548
    //   81: aload 4
    //   83: ldc_w 350
    //   86: invokevirtual 483	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   89: checkcast 149	com/tencent/av/chatroom/ChatRoomInfo
    //   92: astore 12
    //   94: aload 4
    //   96: ldc_w 355
    //   99: lconst_0
    //   100: invokevirtual 487	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   103: lstore 8
    //   105: aload 12
    //   107: ifnull +879 -> 986
    //   110: aload_0
    //   111: aload 12
    //   113: getfield 151	com/tencent/av/chatroom/ChatRoomInfo:type	I
    //   116: aload 12
    //   118: getfield 160	com/tencent/av/chatroom/ChatRoomInfo:lJ	J
    //   121: aload 12
    //   123: getfield 154	com/tencent/av/chatroom/ChatRoomInfo:id	J
    //   126: aload 12
    //   128: getfield 157	com/tencent/av/chatroom/ChatRoomInfo:createTime	J
    //   131: invokevirtual 437	ilu:a	(IJJJ)Lcom/tencent/av/chatroom/ChatRoomInfo;
    //   134: astore 10
    //   136: aload 10
    //   138: ifnull +842 -> 980
    //   141: aload_0
    //   142: aload 10
    //   144: lload 8
    //   146: invokevirtual 489	ilu:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)Lilw;
    //   149: astore 11
    //   151: aload 10
    //   153: ifnull +8 -> 161
    //   156: aload 11
    //   158: ifnonnull +47 -> 205
    //   161: ldc 170
    //   163: iconst_1
    //   164: new 172	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 491
    //   174: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: lload 8
    //   179: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: ldc_w 278
    //   185: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 12
    //   190: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: ldc 184
    //   195: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: return
    //   205: iload_2
    //   206: ifeq +289 -> 495
    //   209: aload 5
    //   211: ifnull +284 -> 495
    //   214: aload 5
    //   216: arraylength
    //   217: ifle +278 -> 495
    //   220: iconst_m1
    //   221: istore_1
    //   222: lconst_0
    //   223: lstore 6
    //   225: new 493	tencent/av/chatroom/chatroom_sso$RspSendMsg
    //   228: dup
    //   229: invokespecial 494	tencent/av/chatroom/chatroom_sso$RspSendMsg:<init>	()V
    //   232: astore 12
    //   234: iload_1
    //   235: istore_3
    //   236: aload 12
    //   238: aload 5
    //   240: invokevirtual 498	tencent/av/chatroom/chatroom_sso$RspSendMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   243: pop
    //   244: iload_1
    //   245: istore_3
    //   246: aload 12
    //   248: getfield 501	tencent/av/chatroom/chatroom_sso$RspSendMsg:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   251: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   254: istore_1
    //   255: iload_1
    //   256: istore_3
    //   257: aload 12
    //   259: getfield 504	tencent/av/chatroom/chatroom_sso$RspSendMsg:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   262: invokevirtual 506	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   265: astore 4
    //   267: aload 12
    //   269: getfield 509	tencent/av/chatroom/chatroom_sso$RspSendMsg:msg_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   272: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   275: istore_3
    //   276: iload_3
    //   277: i2l
    //   278: lstore 6
    //   280: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +47 -> 330
    //   286: ldc 170
    //   288: iconst_2
    //   289: ldc_w 511
    //   292: iconst_4
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: iload_1
    //   299: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: aastore
    //   303: dup
    //   304: iconst_1
    //   305: lload 6
    //   307: invokestatic 520	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   310: aastore
    //   311: dup
    //   312: iconst_2
    //   313: aload 4
    //   315: aastore
    //   316: dup
    //   317: iconst_3
    //   318: lload 8
    //   320: invokestatic 520	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   323: aastore
    //   324: invokestatic 526	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   327: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: iload_1
    //   331: ifeq +78 -> 409
    //   334: aload 11
    //   336: getstatic 529	ilw:aoS	I
    //   339: invokevirtual 532	ilw:kX	(I)V
    //   342: aload_0
    //   343: aload 11
    //   345: invokespecial 534	ilu:b	(Lilw;)V
    //   348: aload 11
    //   350: invokevirtual 537	ilw:tX	()Z
    //   353: ifeq -149 -> 204
    //   356: invokestatic 213	android/os/Message:obtain	()Landroid/os/Message;
    //   359: astore 4
    //   361: aload 4
    //   363: iconst_4
    //   364: putfield 216	android/os/Message:what	I
    //   367: aload 4
    //   369: aload 11
    //   371: putfield 220	android/os/Message:obj	Ljava/lang/Object;
    //   374: aload_0
    //   375: getfield 64	ilu:mHandler	Landroid/os/Handler;
    //   378: aload 4
    //   380: ldc2_w 538
    //   383: invokevirtual 252	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   386: pop
    //   387: return
    //   388: astore 5
    //   390: aconst_null
    //   391: astore 4
    //   393: iload_3
    //   394: istore_1
    //   395: ldc 170
    //   397: iconst_1
    //   398: ldc_w 541
    //   401: aload 5
    //   403: invokestatic 383	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   406: goto -126 -> 280
    //   409: aload 11
    //   411: lload 6
    //   413: putfield 544	ilw:lO	J
    //   416: aload 11
    //   418: getstatic 547	ilw:aoT	I
    //   421: invokevirtual 532	ilw:kX	(I)V
    //   424: aload_0
    //   425: aload 11
    //   427: invokespecial 534	ilu:b	(Lilw;)V
    //   430: aload 10
    //   432: getfield 550	com/tencent/av/chatroom/ChatRoomInfo:Sq	Z
    //   435: ifne +15 -> 450
    //   438: ldc_w 552
    //   441: invokestatic 557	ily:report	(Ljava/lang/String;)V
    //   444: aload 10
    //   446: iconst_1
    //   447: putfield 550	com/tencent/av/chatroom/ChatRoomInfo:Sq	Z
    //   450: aload 10
    //   452: getfield 560	com/tencent/av/chatroom/ChatRoomInfo:Sr	Z
    //   455: ifne -251 -> 204
    //   458: aload 11
    //   460: getfield 301	ilw:msg	Ljava/lang/String;
    //   463: invokestatic 566	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   466: ifne -262 -> 204
    //   469: aload 11
    //   471: getfield 301	ilw:msg	Ljava/lang/String;
    //   474: bipush 20
    //   476: invokevirtual 570	java/lang/String:indexOf	(I)I
    //   479: iflt -275 -> 204
    //   482: ldc_w 572
    //   485: invokestatic 557	ily:report	(Ljava/lang/String;)V
    //   488: aload 10
    //   490: iconst_1
    //   491: putfield 560	com/tencent/av/chatroom/ChatRoomInfo:Sr	Z
    //   494: return
    //   495: aload 11
    //   497: getstatic 529	ilw:aoS	I
    //   500: invokevirtual 532	ilw:kX	(I)V
    //   503: aload_0
    //   504: aload 11
    //   506: invokespecial 534	ilu:b	(Lilw;)V
    //   509: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   512: ifeq -308 -> 204
    //   515: ldc 170
    //   517: iconst_2
    //   518: new 172	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 574
    //   528: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: lload 8
    //   533: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   536: ldc 184
    //   538: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: return
    //   548: iload_1
    //   549: bipush 22
    //   551: if_icmpne -347 -> 204
    //   554: aload 4
    //   556: ldc_w 350
    //   559: invokevirtual 483	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   562: checkcast 149	com/tencent/av/chatroom/ChatRoomInfo
    //   565: astore 4
    //   567: aload 4
    //   569: ifnull +405 -> 974
    //   572: aload_0
    //   573: aload 4
    //   575: getfield 151	com/tencent/av/chatroom/ChatRoomInfo:type	I
    //   578: aload 4
    //   580: getfield 160	com/tencent/av/chatroom/ChatRoomInfo:lJ	J
    //   583: aload 4
    //   585: getfield 154	com/tencent/av/chatroom/ChatRoomInfo:id	J
    //   588: aload 4
    //   590: getfield 157	com/tencent/av/chatroom/ChatRoomInfo:createTime	J
    //   593: invokevirtual 437	ilu:a	(IJJJ)Lcom/tencent/av/chatroom/ChatRoomInfo;
    //   596: astore 11
    //   598: aload 11
    //   600: ifnonnull +36 -> 636
    //   603: ldc 170
    //   605: iconst_1
    //   606: new 172	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   613: ldc_w 576
    //   616: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 4
    //   621: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   624: ldc 184
    //   626: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: return
    //   636: iload_2
    //   637: ifeq +254 -> 891
    //   640: aload 5
    //   642: ifnull +249 -> 891
    //   645: aload 5
    //   647: arraylength
    //   648: ifle +243 -> 891
    //   651: aconst_null
    //   652: astore 10
    //   654: aconst_null
    //   655: astore 4
    //   657: ldc2_w 241
    //   660: lstore 6
    //   662: new 578	tencent/av/chatroom/chatroom_sso$RspGetMsg
    //   665: dup
    //   666: invokespecial 579	tencent/av/chatroom/chatroom_sso$RspGetMsg:<init>	()V
    //   669: astore 12
    //   671: aload 12
    //   673: aload 5
    //   675: invokevirtual 580	tencent/av/chatroom/chatroom_sso$RspGetMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   678: pop
    //   679: aload 12
    //   681: getfield 581	tencent/av/chatroom/chatroom_sso$RspGetMsg:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   684: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   687: istore_1
    //   688: aload 12
    //   690: getfield 582	tencent/av/chatroom/chatroom_sso$RspGetMsg:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   693: invokevirtual 506	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   696: astore 5
    //   698: aload 5
    //   700: astore 10
    //   702: aload 12
    //   704: getfield 586	tencent/av/chatroom/chatroom_sso$RspGetMsg:msg_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   707: invokevirtual 591	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   710: astore 4
    //   712: aload 12
    //   714: getfield 595	tencent/av/chatroom/chatroom_sso$RspGetMsg:retry	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   717: invokevirtual 599	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   720: istore_2
    //   721: aload 12
    //   723: getfield 602	tencent/av/chatroom/chatroom_sso$RspGetMsg:retry_delay	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   726: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   729: lstore 8
    //   731: lload 8
    //   733: lstore 6
    //   735: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +60 -> 798
    //   741: aload 4
    //   743: ifnonnull +118 -> 861
    //   746: iconst_0
    //   747: istore_3
    //   748: ldc 170
    //   750: iconst_2
    //   751: ldc_w 604
    //   754: iconst_5
    //   755: anewarray 4	java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: iload_1
    //   761: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   764: aastore
    //   765: dup
    //   766: iconst_1
    //   767: aload 5
    //   769: aastore
    //   770: dup
    //   771: iconst_2
    //   772: iload_3
    //   773: invokestatic 517	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: dup
    //   778: iconst_3
    //   779: iload_2
    //   780: invokestatic 609	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   783: aastore
    //   784: dup
    //   785: iconst_4
    //   786: lload 6
    //   788: invokestatic 520	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   791: aastore
    //   792: invokestatic 526	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   795: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: iload_1
    //   799: ifne +83 -> 882
    //   802: iload_2
    //   803: ifeq +69 -> 872
    //   806: aload 4
    //   808: ifnull +13 -> 821
    //   811: aload 4
    //   813: invokeinterface 612 1 0
    //   818: ifne +54 -> 872
    //   821: aload_0
    //   822: aload 11
    //   824: lload 6
    //   826: invokespecial 614	ilu:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   829: return
    //   830: astore 10
    //   832: iconst_m1
    //   833: istore_1
    //   834: aconst_null
    //   835: astore 12
    //   837: iconst_0
    //   838: istore_2
    //   839: aload 4
    //   841: astore 5
    //   843: aload 12
    //   845: astore 4
    //   847: ldc 170
    //   849: iconst_1
    //   850: ldc_w 616
    //   853: aload 10
    //   855: invokestatic 383	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   858: goto -123 -> 735
    //   861: aload 4
    //   863: invokeinterface 612 1 0
    //   868: istore_3
    //   869: goto -121 -> 748
    //   872: aload_0
    //   873: aload 11
    //   875: aload 4
    //   877: iconst_0
    //   878: invokevirtual 619	ilu:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;Ljava/util/List;Z)V
    //   881: return
    //   882: aload_0
    //   883: aload 11
    //   885: lload 6
    //   887: invokespecial 614	ilu:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   890: return
    //   891: aload_0
    //   892: aload 11
    //   894: ldc2_w 241
    //   897: invokespecial 614	ilu:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   900: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   903: ifeq -699 -> 204
    //   906: ldc 170
    //   908: iconst_2
    //   909: new 172	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   916: ldc_w 621
    //   919: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: lload 6
    //   924: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   927: ldc 184
    //   929: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   938: return
    //   939: astore 12
    //   941: aconst_null
    //   942: astore 4
    //   944: iconst_0
    //   945: istore_2
    //   946: aload 10
    //   948: astore 5
    //   950: aload 12
    //   952: astore 10
    //   954: goto -107 -> 847
    //   957: astore 10
    //   959: iconst_0
    //   960: istore_2
    //   961: goto -114 -> 847
    //   964: astore 10
    //   966: goto -119 -> 847
    //   969: astore 5
    //   971: goto -576 -> 395
    //   974: aconst_null
    //   975: astore 11
    //   977: goto -379 -> 598
    //   980: aconst_null
    //   981: astore 11
    //   983: goto -832 -> 151
    //   986: aconst_null
    //   987: astore 10
    //   989: goto -853 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	992	0	this	ilu
    //   0	992	1	paramInt1	int
    //   0	992	2	paramBoolean	boolean
    //   0	992	3	paramInt2	int
    //   0	992	4	paramIntent	Intent
    //   0	992	5	paramArrayOfByte	byte[]
    //   5	918	6	l1	long
    //   103	629	8	l2	long
    //   134	567	10	localObject1	Object
    //   830	117	10	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   952	1	10	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   957	1	10	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   964	1	10	localInvalidProtocolBufferMicroException4	InvalidProtocolBufferMicroException
    //   987	1	10	localObject2	Object
    //   149	833	11	localObject3	Object
    //   92	752	12	localObject4	Object
    //   939	12	12	localInvalidProtocolBufferMicroException5	InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   236	244	388	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   246	255	388	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   257	267	388	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   671	688	830	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   688	698	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   702	712	939	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   712	721	957	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   721	731	964	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   267	276	969	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a(VideoController paramVideoController, iiv paramiiv)
  {
    ChatRoomInfo localChatRoomInfo2 = a(paramiiv, false);
    boolean bool = paramVideoController.a("onSwitchTerminalSuccess", paramiiv);
    ChatRoomInfo localChatRoomInfo1 = a(paramiiv, false);
    paramVideoController = localChatRoomInfo1;
    if (localChatRoomInfo1 == null) {
      paramVideoController = a(paramiiv);
    }
    if (paramVideoController != null)
    {
      if (localChatRoomInfo2 != paramVideoController) {
        a(localChatRoomInfo2);
      }
      paramVideoController.Ss = true;
      if ((localChatRoomInfo2 != paramVideoController) && (localChatRoomInfo2 != null)) {
        paramVideoController.lK = localChatRoomInfo2.lJ;
      }
      this.mHandler.removeMessages(3, paramVideoController);
      paramiiv = Message.obtain();
      paramiiv.obj = paramVideoController;
      paramiiv.what = 3;
      this.mHandler.sendMessage(paramiiv);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, String.format("onSwitchTerminalSuccess, ret[%s], pre[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), localChatRoomInfo2, paramVideoController }));
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo != null)
    {
      this.k.remove(paramChatRoomInfo);
      this.aD.remove(paramChatRoomInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "removeChatRoom, room[" + paramChatRoomInfo + "]");
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, String paramString, long paramLong)
  {
    if ((paramChatRoomInfo == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.mApp.getCurrentAccountUin());
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
      }
    }
    paramString = new ilw(paramChatRoomInfo, l1, paramString, paramLong, -9223372036854775808L, ilw.STATE_SENDING);
    a(paramChatRoomInfo).add(paramString);
    a(paramString);
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<ilw> paramList)
  {
    if ((paramChatRoomInfo == null) || (paramList == null)) {
      return;
    }
    paramChatRoomInfo = (ConcurrentLinkedQueue)this.aD.get(paramChatRoomInfo);
    if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0)) {
      paramList.addAll(paramChatRoomInfo);
    }
    Collections.sort(paramList, this.p);
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<chatroom_sso.Msg> paramList, boolean paramBoolean)
  {
    if ((paramChatRoomInfo == null) || (paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomMng", 4, "onRecvMsg, room[" + paramChatRoomInfo + "], size[" + paramList.size() + "]");
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        chatroom_sso.Msg localMsg = (chatroom_sso.Msg)paramList.next();
        if (localMsg != null) {
          a(paramChatRoomInfo, localMsg, paramBoolean);
        }
      }
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, chatroom_sso.Msg paramMsg, boolean paramBoolean)
  {
    if ((paramChatRoomInfo == null) || (paramMsg == null)) {
      return;
    }
    long l1 = paramMsg.uin.get();
    ConcurrentLinkedQueue localConcurrentLinkedQueue = a(paramChatRoomInfo);
    Object localObject = null;
    Iterator localIterator = localConcurrentLinkedQueue.iterator();
    label35:
    ilw localilw;
    boolean bool;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localilw = (ilw)localIterator.next();
        if (localilw != null) {
          if (localilw.a(paramMsg))
          {
            bool = true;
            localilw.time = paramMsg.msg_time.get();
            localilw.kX(ilw.aoU);
          }
        }
      }
    }
    for (;;)
    {
      if ((!bool) && (localObject != null))
      {
        bool = true;
        ((ilw)localObject).lO = paramMsg.msg_id.get();
        ((ilw)localObject).time = paramMsg.msg_time.get();
        ((ilw)localObject).kX(ilw.aoU);
        label140:
        if (!bool)
        {
          localObject = new ilw(paramChatRoomInfo, paramMsg.uin.get(), paramMsg.msg.get(), paramMsg.msg_time.get(), paramMsg.msg_id.get(), ilw.aoU);
          localConcurrentLinkedQueue.add(localObject);
          if (paramBoolean) {
            a(4, paramChatRoomInfo);
          }
        }
        else
        {
          label205:
          if (!QLog.isDevelopLevel()) {
            break label320;
          }
          QLog.i("ChatRoomMng", 4, "onRecvMsg, isDuplicatedMsg[" + bool + "], msg[" + localObject + "], isFromPush[" + paramBoolean + "]");
          return;
          if ((localilw.lO != -9223372036854775808L) || (localilw.senderUin != l1) || (!TextUtils.equals(localilw.msg, paramMsg.msg.get()))) {
            break label329;
          }
          localObject = localilw;
        }
      }
      label320:
      label329:
      for (;;)
      {
        break label35;
        a(2, paramChatRoomInfo);
        break label205;
        break;
        localObject = localilw;
        break label140;
      }
      localilw = null;
      bool = false;
    }
  }
  
  public void a(iiv paramiiv)
  {
    ChatRoomInfo localChatRoomInfo = a(paramiiv, false);
    a(localChatRoomInfo);
    if ((QLog.isDevelopLevel()) && (paramiiv != null)) {
      QLog.i("ChatRoomMng", 4, "quitChatRoom, SessionType[" + paramiiv.amI + "], relationType[" + paramiiv.relationType + "], relationId[" + paramiiv.ll + "], peerUin[" + paramiiv.peerUin + "], extraUin[" + paramiiv.MP + "], isDoubleVideoMeeting[" + paramiiv.Qw + "], room[" + localChatRoomInfo + "]");
    }
  }
  
  public void a(ilx paramilx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "addObserver, observer[" + paramilx + "]");
    }
    if ((paramilx != null) && (!this.l.contains(paramilx))) {
      this.l.add(paramilx);
    }
  }
  
  public void aoc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "clearObserver");
    }
    this.l.clear();
  }
  
  public void b(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null)
    {
      QLog.i("ChatRoomMng", 1, "reqGetMsgFromServer, no room info.");
      return;
    }
    long l1 = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "reqGetMsgFromServer, seq[" + l1 + "], curRoomInfo[" + paramChatRoomInfo + "]");
    }
    int i = (int)paramChatRoomInfo.createTime;
    Object localObject = new chatroom_sso.RoomKey();
    ((chatroom_sso.RoomKey)localObject).type.set(paramChatRoomInfo.type);
    ((chatroom_sso.RoomKey)localObject).room_id.set(paramChatRoomInfo.lJ);
    ((chatroom_sso.RoomKey)localObject).id.set(paramChatRoomInfo.id);
    ((chatroom_sso.RoomKey)localObject).create_ts.set(i);
    chatroom_sso.ReqGetMsg localReqGetMsg = new chatroom_sso.ReqGetMsg();
    localReqGetMsg.room_key.set((MessageMicro)localObject);
    if (paramChatRoomInfo.Ss)
    {
      localReqGetMsg.is_terminal_switch.set(true);
      if (paramChatRoomInfo.lK != 0L) {
        localReqGetMsg.room_id.set(paramChatRoomInfo.lK);
      }
    }
    paramChatRoomInfo.aob();
    localObject = new NewIntent(this.mApp.getApplication(), iho.class);
    ((NewIntent)localObject).putExtra("reqType", 22);
    ((NewIntent)localObject).putExtra("vMsg", localReqGetMsg.toByteArray());
    ((NewIntent)localObject).putExtra("room_key", paramChatRoomInfo);
    jlc.a((Intent)localObject, l1);
    this.mApp.startServlet((NewIntent)localObject);
  }
  
  public void b(ilx paramilx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "removeObserver, observer[" + paramilx + "]");
    }
    if (paramilx != null) {
      this.l.remove(paramilx);
    }
  }
  
  public void e(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt != 2) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomMng", 4, "onReceivePushMsg params error.");
      }
      return;
    }
    localObject1 = null;
    Object localObject2 = new chatroom_sso.PushMsg();
    for (;;)
    {
      try
      {
        ((chatroom_sso.PushMsg)localObject2).mergeFrom(paramArrayOfByte);
        if (((chatroom_sso.PushMsg)localObject2).room_key.has())
        {
          paramArrayOfByte = (chatroom_sso.RoomKey)((chatroom_sso.PushMsg)localObject2).room_key.get();
          paramInt = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        ChatRoomInfo localChatRoomInfo;
        paramArrayOfByte = (byte[])localObject1;
        localObject1 = localInvalidProtocolBufferMicroException2;
        paramInt = 1;
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomMng", 2, "processAVChatRoomMsgPush parse fail.", (Throwable)localObject1);
        }
        Object localObject3 = null;
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = localObject3;
        continue;
        int i = 4;
        paramInt = i;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("ChatRoomMng", 4, String.format("onReceivePushMsg, [type: %s, room_id: %s, id: %s, create_ts: %s", new Object[] { Integer.valueOf(((chatroom_sso.RoomKey)localObject1).type.get()), Long.valueOf(((chatroom_sso.RoomKey)localObject1).room_id.get()), Long.valueOf(((chatroom_sso.RoomKey)localObject1).id.get()), Integer.valueOf(((chatroom_sso.RoomKey)localObject1).create_ts.get()) }));
        paramInt = i;
        continue;
      }
      try
      {
        if (!((chatroom_sso.PushMsg)localObject2).msg.has()) {
          continue;
        }
        localObject1 = (chatroom_sso.Msg)((chatroom_sso.PushMsg)localObject2).msg.get();
        localObject2 = localObject1;
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = (byte[])localObject2;
        if ((localObject1 == null) || (paramArrayOfByte == null)) {
          break label371;
        }
        localChatRoomInfo = a(((chatroom_sso.RoomKey)localObject1).type.get(), ((chatroom_sso.RoomKey)localObject1).room_id.get(), ((chatroom_sso.RoomKey)localObject1).id.get(), ((chatroom_sso.RoomKey)localObject1).create_ts.get());
        localObject2 = localChatRoomInfo;
        if (localChatRoomInfo == null) {
          localObject2 = a((chatroom_sso.RoomKey)localObject1);
        }
        if (localObject2 == null) {
          continue;
        }
        a((ChatRoomInfo)localObject2, paramArrayOfByte, true);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        continue;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatRoomMng", 2, "onReceivePushMsg, ret[" + paramInt + "]");
      return;
      paramArrayOfByte = null;
      paramInt = 2;
      continue;
      paramInt = 3;
      localObject1 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Iterator localIterator;
    ilx localilx;
    if (paramMessage.what == 1)
    {
      int i = this.aoR;
      this.aoR = 0;
      paramMessage = (ChatRoomInfo)paramMessage.obj;
      localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        localilx = (ilx)localIterator.next();
        if (localilx != null) {
          localilx.b(i, paramMessage);
        }
      }
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (ilw)paramMessage.obj;
      localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        localilx = (ilx)localIterator.next();
        if (localilx != null) {
          localilx.c(paramMessage);
        }
      }
    }
    if (paramMessage.what == 3) {
      ThreadManagerV2.excute(new ChatRoomMng.2(this, (ChatRoomInfo)paramMessage.obj), 16, null, true);
    }
    do
    {
      do
      {
        return true;
      } while (paramMessage.what != 4);
      paramMessage = (ilw)paramMessage.obj;
    } while ((paramMessage == null) || (!paramMessage.tX()));
    a(paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ilu
 * JD-Core Version:    0.7.0.1
 */