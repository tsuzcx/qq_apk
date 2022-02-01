package com.tencent.mobileqq.data;

import aafi;
import android.graphics.Bitmap;
import android.text.TextUtils;
import avoz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import zxj;

public class MessageForQQWalletMsg
  extends ChatMessage
{
  public static final int MSG_TYPE_AA_PAY = 16;
  public static final int MSG_TYPE_COMMAND_REDPACKET = 6;
  public static final int MSG_TYPE_COMMON_REDPACKET = 2;
  public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY = 7;
  public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY_OVER_3 = 11;
  public static final int MSG_TYPE_COMMON_THEME_REDPACKET = 4;
  public static final int MSG_TYPE_DRAW_REDPACKET = 22;
  public static final int MSG_TYPE_EMOJI_REDPACKET = 19;
  public static final int MSG_TYPE_GOLD_REDPACKET = 23;
  public static final int MSG_TYPE_H5_COMMON_REDPACKET = 20;
  public static final int MSG_TYPE_H5_REDPACKET = 17;
  public static final int MSG_TYPE_IDIOM_SOLITAIRE = 21;
  public static final int MSG_TYPE_INDIVIDUAL_REDPACKET = 2001;
  public static final int MSG_TYPE_KEYWORD = 25;
  public static final int MSG_TYPE_KSONG_REDPACKET = 18;
  public static final int MSG_TYPE_LOOK_REDPACKET = 14;
  public static final int MSG_TYPE_LUCY_REDPACKET = 3;
  public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY = 8;
  public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY_OVER_3 = 12;
  public static final int MSG_TYPE_LUCY_THEME_REDPACKET = 5;
  public static final int MSG_TYPE_PAYER = 9;
  public static final int MSG_TYPE_PAYER_NOTIFY = 10;
  public static final int MSG_TYPE_PUBLIC_ACCOUNT_REDPACKET = 2002;
  public static final int MSG_TYPE_TRANSFER = 1;
  public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET = 13;
  public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET_C2C = 15;
  public static final int MSG_TYPE_WORDCHAIN = 24;
  public static final int QQWALLET_TYPE_REDPACKET = 2;
  public static final int QQWALLET_TYPE_TRANSFER = 1;
  public static final int SUBVERSION_REDPACKET = 2;
  public static final int SUBVERSION_TRANSFER = 4;
  public static final int VERSION1 = 1;
  public static final int VERSION17 = 17;
  public static final int VERSION2 = 2;
  public static final int VERSION32 = 32;
  public static int[] mMsgType = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 2002, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
  public int fromHBList;
  public boolean isLoadFinish;
  public QQWalletRedPacketMsg mQQWalletRedPacketMsg;
  public QQWalletTransferMsg mQQWalletTransferMsg;
  public int messageType;
  public Bitmap specifyIcon;
  
  public MessageForQQWalletMsg() {}
  
  public MessageForQQWalletMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[QQWallet Msg]", paramLong4, -2025, paramInt, paramLong5);
  }
  
  public static boolean isCommandRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (((MessageForQQWalletMsg)paramMessageRecord).messageType == 6);
  }
  
  public static boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    boolean bool1 = true;
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)paramMessageRecord;
      Object localObject = null;
      if ((localMessageForQQWalletMsg.mQQWalletTransferMsg != null) && (localMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null))
      {
        localMessageForQQWalletMsg.parse();
        paramMessageRecord = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
      }
      boolean bool2;
      while (paramMessageRecord == null)
      {
        bool2 = false;
        return bool2;
        paramMessageRecord = localObject;
        if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null)
        {
          paramMessageRecord = localObject;
          if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
            return true;
          }
        }
      }
      paramMessageRecord = paramMessageRecord.nativeAndroid;
      if (TextUtils.isEmpty(paramMessageRecord)) {
        return false;
      }
      paramMessageRecord = paramMessageRecord.split("\\?");
      if ((!TextUtils.isEmpty(paramMessageRecord[0])) && (paramMessageRecord[0].equals("red"))) {}
      for (;;)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MessageForQQWaletMsg", 2, "isRedPacketMsg : " + bool1);
        return bool1;
        bool1 = false;
      }
    }
    return false;
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 175	avpa
    //   3: dup
    //   4: aload_0
    //   5: getfield 179	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   8: invokespecial 182	avpa:<init>	([B)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: invokevirtual 186	avpa:readInt	()I
    //   18: istore_1
    //   19: iload_1
    //   20: iconst_1
    //   21: if_icmpeq +8 -> 29
    //   24: iload_1
    //   25: iconst_2
    //   26: if_icmpne +45 -> 71
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 186	avpa:readInt	()I
    //   35: iconst_1
    //   36: if_icmpne +26 -> 62
    //   39: aload_3
    //   40: astore_2
    //   41: aload_0
    //   42: new 104	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   45: dup
    //   46: invokespecial 187	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   49: putfield 102	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   52: aload_3
    //   53: astore_2
    //   54: aload_0
    //   55: getfield 102	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   58: aload_3
    //   59: invokevirtual 191	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(Lavpa;)V
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 194	avpa:close	()V
    //   70: return
    //   71: iload_1
    //   72: bipush 17
    //   74: if_icmpne +80 -> 154
    //   77: aload_3
    //   78: astore_2
    //   79: aload_0
    //   80: new 115	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   83: dup
    //   84: invokespecial 195	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   87: putfield 113	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   90: aload_3
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 113	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   96: aload_3
    //   97: invokevirtual 196	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Lavpa;)V
    //   100: goto -38 -> 62
    //   103: astore 4
    //   105: aload_3
    //   106: astore_2
    //   107: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +15 -> 125
    //   113: aload_3
    //   114: astore_2
    //   115: ldc 198
    //   117: iconst_2
    //   118: ldc 200
    //   120: aload 4
    //   122: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_3
    //   126: astore_2
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 102	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   132: aload_3
    //   133: astore_2
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 113	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   139: aload_3
    //   140: ifnull -70 -> 70
    //   143: aload_3
    //   144: invokevirtual 194	avpa:close	()V
    //   147: return
    //   148: astore_2
    //   149: aload_2
    //   150: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   153: return
    //   154: iload_1
    //   155: bipush 32
    //   157: if_icmplt -95 -> 62
    //   160: aload_3
    //   161: astore_2
    //   162: aload_3
    //   163: invokevirtual 186	avpa:readInt	()I
    //   166: istore_1
    //   167: aload_3
    //   168: astore_2
    //   169: aload_3
    //   170: invokevirtual 186	avpa:readInt	()I
    //   173: pop
    //   174: aload_3
    //   175: astore_2
    //   176: aload_0
    //   177: aload_3
    //   178: invokevirtual 186	avpa:readInt	()I
    //   181: putfield 99	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   184: iload_1
    //   185: iconst_1
    //   186: if_icmpne +46 -> 232
    //   189: aload_3
    //   190: astore_2
    //   191: aload_0
    //   192: new 104	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   195: dup
    //   196: invokespecial 187	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   199: putfield 102	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   202: aload_3
    //   203: astore_2
    //   204: aload_0
    //   205: getfield 102	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   208: aload_3
    //   209: invokevirtual 191	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(Lavpa;)V
    //   212: goto -150 -> 62
    //   215: astore 4
    //   217: aload_2
    //   218: astore_3
    //   219: aload 4
    //   221: astore_2
    //   222: aload_3
    //   223: ifnull +7 -> 230
    //   226: aload_3
    //   227: invokevirtual 194	avpa:close	()V
    //   230: aload_2
    //   231: athrow
    //   232: iload_1
    //   233: iconst_2
    //   234: if_icmpne -172 -> 62
    //   237: aload_3
    //   238: astore_2
    //   239: aload_0
    //   240: new 115	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   243: dup
    //   244: invokespecial 195	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   247: putfield 113	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   250: aload_3
    //   251: astore_2
    //   252: aload_0
    //   253: getfield 113	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   256: aload_3
    //   257: invokevirtual 196	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Lavpa;)V
    //   260: goto -198 -> 62
    //   263: astore_2
    //   264: aload_2
    //   265: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   268: return
    //   269: astore_3
    //   270: aload_3
    //   271: invokevirtual 206	java/lang/Exception:printStackTrace	()V
    //   274: goto -44 -> 230
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_3
    //   280: goto -58 -> 222
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_3
    //   287: goto -182 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	MessageForQQWalletMsg
    //   18	217	1	i	int
    //   13	121	2	localObject1	Object
    //   148	2	2	localException1	Exception
    //   161	91	2	localObject2	Object
    //   263	2	2	localException2	Exception
    //   277	1	2	localObject3	Object
    //   11	246	3	localObject4	Object
    //   269	2	3	localException3	Exception
    //   279	8	3	localObject5	Object
    //   103	18	4	localException4	Exception
    //   215	5	4	localObject6	Object
    //   283	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   14	19	103	java/lang/Exception
    //   31	39	103	java/lang/Exception
    //   41	52	103	java/lang/Exception
    //   54	62	103	java/lang/Exception
    //   79	90	103	java/lang/Exception
    //   92	100	103	java/lang/Exception
    //   162	167	103	java/lang/Exception
    //   169	174	103	java/lang/Exception
    //   176	184	103	java/lang/Exception
    //   191	202	103	java/lang/Exception
    //   204	212	103	java/lang/Exception
    //   239	250	103	java/lang/Exception
    //   252	260	103	java/lang/Exception
    //   143	147	148	java/lang/Exception
    //   14	19	215	finally
    //   31	39	215	finally
    //   41	52	215	finally
    //   54	62	215	finally
    //   79	90	215	finally
    //   92	100	215	finally
    //   107	113	215	finally
    //   115	125	215	finally
    //   127	132	215	finally
    //   134	139	215	finally
    //   162	167	215	finally
    //   169	174	215	finally
    //   176	184	215	finally
    //   191	202	215	finally
    //   204	212	215	finally
    //   239	250	215	finally
    //   252	260	215	finally
    //   66	70	263	java/lang/Exception
    //   226	230	269	java/lang/Exception
    //   0	12	277	finally
    //   0	12	283	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public int getIsHideTitleDefault()
  {
    if ((this.mQQWalletRedPacketMsg == null) || (this.mQQWalletRedPacketMsg.elem == null) || (this.mQQWalletRedPacketMsg.elem.skinId <= 0) || (this.messageType == 18) || (this.messageType == 17) || (this.messageType == 19) || (this.messageType == 21) || (this.messageType == 22) || (this.messageType == 23) || (this.messageType == 24) || (this.messageType == 25)) {
      return 0;
    }
    return 1;
  }
  
  public String getMsgSummary()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.notice;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.notice;
    }
    return "";
  }
  
  public String getSummaryMsg()
  {
    return getMsgSummary();
  }
  
  public boolean isMsgEmpty()
  {
    if ((this.mQQWalletTransferMsg == null) && (this.mQQWalletRedPacketMsg == null)) {}
    while (this.msgData == null) {
      return true;
    }
    return false;
  }
  
  public boolean isRedPackExpired()
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    return this.time + 90000L < l;
  }
  
  public boolean isSender()
  {
    return (this.senderuin != null) && (this.senderuin.equalsIgnoreCase(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void onDecodeFinish(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg)
  {
    int i = paramMsg.msg_head.msg_type.get();
    long l;
    if ((i == 82) || (i == 43)) {
      l = paramMsg.msg_head.group_info.group_code.get();
    }
    for (;;)
    {
      this.frienduin = String.valueOf(l);
      this.time = paramMsg.msg_head.msg_time.get();
      aafi.a(paramQQAppInterface, this);
      RedPacketEmojiFragment.a(paramQQAppInterface, this);
      return;
      if ((i == 83) || (i == 42)) {
        l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      } else if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {
        l = paramMsg.msg_head.from_uin.get();
      } else {
        l = paramMsg.msg_head.to_uin.get();
      }
    }
  }
  
  public HashMap<String, String> parseUrlParams(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int i = 0;
      if (i < paramString.length)
      {
        if (TextUtils.isEmpty(paramString[i])) {}
        for (;;)
        {
          i += 1;
          break;
          String[] arrayOfString = paramString[i].split("=");
          if (arrayOfString.length == 2)
          {
            try
            {
              arrayOfString[1] = URLDecoder.decode(arrayOfString[1], "UTF-8");
              localHashMap.put(arrayOfString[0], arrayOfString[1]);
            }
            catch (Exception localException)
            {
              if (QLog.isDevelopLevel()) {
                localException.printStackTrace();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:" + arrayOfString[0] + ",tmps[1] is:" + arrayOfString[1], localException);
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public void postRead()
  {
    parse();
    try
    {
      ((zxj)BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin).getManager(125)).BX(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.qqwalletmsg", 2, "postRead init read status");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void prewrite()
  {
    Object localObject = null;
    if (this.mQQWalletTransferMsg != null) {}
    do
    {
      localObject = this.mQQWalletTransferMsg;
      while (localObject != null)
      {
        localObject = ((avoz)localObject).flushMsgData(this.messageType);
        if (localObject != null) {
          this.msgData = ((byte[])localObject);
        }
        return;
        if (this.mQQWalletRedPacketMsg != null) {
          localObject = this.mQQWalletRedPacketMsg;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.qqwalletmsg", 2, "prewrite... ssp is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletMsg
 * JD-Core Version:    0.7.0.1
 */