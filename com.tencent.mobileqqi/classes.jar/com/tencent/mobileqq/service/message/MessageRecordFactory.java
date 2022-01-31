package com.tencent.mobileqq.service.message;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class MessageRecordFactory
{
  private static final String a = "MessageRecordFactory";
  
  public static MessageForMarketFace a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, MarkFaceMessage paramMarkFaceMessage)
  {
    MessageForMarketFace localMessageForMarketFace = (MessageForMarketFace)a(-2007);
    localMessageForMarketFace.msgtype = -2007;
    localMessageForMarketFace.mMarkFaceMessage = paramMarkFaceMessage;
    localMessageForMarketFace.mIsParsed = true;
    a(paramQQAppInterface, localMessageForMarketFace, paramString1, paramString2, paramInt);
    try
    {
      localMessageForMarketFace.msgData = MessagePkgUtils.a(paramMarkFaceMessage);
      return localMessageForMarketFace;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localMessageForMarketFace;
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.msgtype = -2000;
    a(paramQQAppInterface, localMessageForPic, paramString1, paramString2, paramInt);
    localMessageForPic.longMsgCount = 1;
    localMessageForPic.longMsgIndex = 0;
    localMessageForPic.longMsgId = ((short)(int)localMessageForPic.shmsgseq);
    return localMessageForPic;
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, long paramLong1, String paramString3, long paramLong2, String paramString4)
  {
    paramString4 = new MessageForPic();
    paramString4.msgtype = -3000;
    paramString4.msg = paramString3;
    a(paramQQAppInterface, paramString4, paramString1, paramString2, paramInt);
    paramString4.longMsgCount = 1;
    paramString4.longMsgIndex = 0;
    paramString4.longMsgId = ((short)(int)paramString4.shmsgseq);
    return paramString4;
  }
  
  @Deprecated
  private static MessageForPic a(MessageForPic paramMessageForPic)
  {
    MessageForPic localMessageForPic = new MessageForPic();
    localMessageForPic.msgtype = -2000;
    a(localMessageForPic, paramMessageForPic);
    localMessageForPic.path = paramMessageForPic.path;
    localMessageForPic.size = 0L;
    localMessageForPic.type = 1;
    localMessageForPic.serial();
    return localMessageForPic;
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return null;
    }
    int i = (int)MessageCache.a();
    int j = MobileQQService.c;
    MobileQQService.c = j + 1;
    long l = j;
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.init(Long.valueOf(paramMessageForPtt.selfuin).longValue(), 0L, 0L, null, i, -2002, paramMessageForPtt.istroop, l);
    localMessageForPtt.frienduin = paramMessageForPtt.frienduin;
    localMessageForPtt.senderuin = paramMessageForPtt.senderuin;
    localMessageForPtt.msgtype = -2002;
    localMessageForPtt.isread = true;
    localMessageForPtt.issend = 1;
    localMessageForPtt.istroop = paramMessageForPtt.istroop;
    localMessageForPtt.msgseq = paramMessageForPtt.msgseq;
    localMessageForPtt.shmsgseq = paramMessageForPtt.shmsgseq;
    localMessageForPtt.msgUid = paramMessageForPtt.msgUid;
    byte[] arrayOfByte = new byte[3];
    PkgTools.a(paramMessageForPtt.url.length(), arrayOfByte, 0, 3, "utf-8");
    localMessageForPtt.url = paramMessageForPtt.url;
    localMessageForPtt.fileSize = -3L;
    localMessageForPtt.itemType = 2;
    if ((SttManager.a(paramMessageForPtt.istroop)) && (SttManager.a(paramQQAppInterface))) {}
    for (i = 1;; i = 0)
    {
      localMessageForPtt.sttAbility = i;
      localMessageForPtt.longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
      localMessageForPtt.serial();
      return localMessageForPtt;
    }
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.msgtype = -2002;
    a(paramQQAppInterface, localMessageForPtt, paramString1, paramString2, paramInt);
    localMessageForPtt.longMsgCount = 1;
    localMessageForPtt.longMsgIndex = 0;
    localMessageForPtt.longMsgId = ((short)(int)localMessageForPtt.shmsgseq);
    return localMessageForPtt;
  }
  
  public static MessageForShakeWindow a(String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    paramString1 = new MessageForShakeWindow(Long.valueOf(paramString1).longValue(), Long.valueOf(paramString2).longValue(), Long.valueOf(paramString3).longValue(), j, paramInt, paramLong);
    paramString2 = new ShakeWindowMsg();
    paramString2.shake = true;
    paramString2.onlineFlag = 1;
    paramString2.mType = 0;
    paramString2.mReserve = 0;
    paramString1.msgData = paramString2.getBytes();
    paramString1.mShakeWindowMsg = paramString2;
    paramString1.mIsParsed = true;
    paramString1.issend = 1;
    paramString1.isread = true;
    paramString1.msgUid = MessageUtils.a(i);
    paramString1.shmsgseq = MessageUtils.a(paramLong, paramInt);
    paramString1.longMsgCount = 1;
    paramString1.longMsgIndex = 0;
    paramString1.longMsgId = ((short)(int)paramLong);
    return paramString1;
  }
  
  public static MessageForStructing a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, AbsStructMsg paramAbsStructMsg)
  {
    paramString1 = (MessageForStructing)a(-2011);
    paramString1.msgtype = -2011;
    paramString1.structingMsg = paramAbsStructMsg;
    paramString1.mIsParsed = true;
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
    try
    {
      paramString1.msgData = paramAbsStructMsg.getBytes();
      return paramString1;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("structMsg", 2, paramQQAppInterface.getMessage(), paramQQAppInterface);
    }
    return paramString1;
  }
  
  public static MessageForText a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, byte paramByte1, byte paramByte2, short paramShort, String paramString4)
  {
    paramString1 = (MessageForText)a(-1000);
    paramString1.msgtype = -1000;
    paramString1.longMsgCount = paramByte1;
    paramString1.longMsgIndex = paramByte2;
    paramString1.longMsgId = paramShort;
    paramString1.msg = paramString4;
    try
    {
      paramString1.msgData = paramString4.getBytes("utf-8");
      a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt);
      paramString1.parse();
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString4)
    {
      for (;;)
      {
        paramString4.printStackTrace();
      }
    }
  }
  
  public static MessageRecord a(int paramInt)
  {
    MessageRecord localMessageRecord = b(paramInt);
    Object localObject = localMessageRecord;
    if (localMessageRecord == null)
    {
      localObject = new MessageForText();
      ((MessageRecord)localObject).msgtype = paramInt;
    }
    return localObject;
  }
  
  public static MessageRecord a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = b(paramInt);
    if (localObject != null)
    {
      ((MessageRecord)localObject).msgtype = paramInt;
      paramArrayOfByte = (byte[])localObject;
    }
    for (;;)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null)
      {
        localObject = new MessageForText();
        ((MessageRecord)localObject).msgtype = paramInt;
      }
      return localObject;
      if (paramArrayOfByte != null) {
        for (;;)
        {
          for (;;)
          {
            try
            {
              for (;;)
              {
                paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
                if ((paramArrayOfByte == null) || (paramArrayOfByte.length() <= 0) || (paramArrayOfByte.charAt(0) != '\026')) {
                  break label173;
                }
                paramArrayOfByte = paramArrayOfByte.split("\\|");
                if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {
                  break label173;
                }
                i = Integer.parseInt(paramArrayOfByte[2]);
                if (i != 3) {
                  break label132;
                }
                paramArrayOfByte = new MessageForGrayTips();
                try
                {
                  paramArrayOfByte.msgtype = -1001;
                }
                catch (Exception localException1) {}
              }
            }
            catch (Exception localException3)
            {
              int i;
              label132:
              paramArrayOfByte = (byte[])localObject;
              continue;
            }
            localException1.printStackTrace();
            break;
            if ((i != 2) && (i != 8)) {
              break label173;
            }
            paramArrayOfByte = new MessageForPtt();
            try
            {
              paramArrayOfByte.msgtype = -2002;
            }
            catch (Exception localException2) {}
          }
        }
      }
      label173:
      paramArrayOfByte = (byte[])localObject;
    }
  }
  
  public static MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      paramMessageRecord = null;
    }
    MessageRecord localMessageRecord;
    do
    {
      return paramMessageRecord;
      localMessageRecord = a(paramMessageRecord.msgtype);
      localMessageRecord.msgtype = paramMessageRecord.msgtype;
      a(localMessageRecord, paramMessageRecord);
      if (paramMessageRecord.msgData != null) {
        localMessageRecord.msgData = paramMessageRecord.msgData;
      }
      if (paramMessageRecord.msg != null) {
        localMessageRecord.msg = paramMessageRecord.msg;
      }
      paramMessageRecord = localMessageRecord;
    } while (!(localMessageRecord instanceof ChatMessage));
    ((ChatMessage)localMessageRecord).parse();
    return localMessageRecord;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    int i = MessageUtils.a();
    int j = (int)MessageCache.a();
    int k = MobileQQService.c;
    MobileQQService.c = k + 1;
    long l = k;
    String str = paramQQAppInterface.a();
    if ((paramInt == 1000) || (paramInt == 1020) || (paramInt == 1004)) {
      if (paramString2 != null)
      {
        paramQQAppInterface = paramString2;
        if (paramString2.length() != 0) {}
      }
      else
      {
        paramQQAppInterface = paramString2;
        if (QLog.isColorLevel())
        {
          QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error groupUin:" + paramString2);
          paramQQAppInterface = paramString2;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord.frienduin = paramString1;
      paramMessageRecord.istroop = paramInt;
      paramMessageRecord.selfuin = str;
      paramMessageRecord.senderuin = paramQQAppInterface;
      paramMessageRecord.isread = true;
      paramMessageRecord.time = j;
      paramMessageRecord.msgseq = l;
      paramMessageRecord.msgUid = MessageUtils.a(i);
      paramMessageRecord.shmsgseq = MessageUtils.a(l, paramInt);
      paramMessageRecord.issend = 1;
      return;
      if (paramInt == 1006)
      {
        paramQQAppInterface = ((PhoneContactManager)paramQQAppInterface.getManager(10)).a();
        if (paramQQAppInterface != null)
        {
          paramString2 = paramQQAppInterface.nationCode + paramQQAppInterface.mobileNo;
          if (paramString2 != null)
          {
            paramQQAppInterface = paramString2;
            if (paramString2.length() > 0) {
              continue;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("MessageRecordFactory", 2, "createPicMessageToShow : error selfPhoneNum:" + paramString2);
          }
        }
      }
      paramQQAppInterface = str;
    }
  }
  
  private static void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    paramMessageRecord1.selfuin = paramMessageRecord2.selfuin;
    paramMessageRecord1.frienduin = paramMessageRecord2.frienduin;
    paramMessageRecord1.senderuin = paramMessageRecord2.senderuin;
    paramMessageRecord1.istroop = paramMessageRecord2.istroop;
    paramMessageRecord1.longMsgCount = paramMessageRecord2.longMsgCount;
    paramMessageRecord1.longMsgId = paramMessageRecord2.longMsgId;
    paramMessageRecord1.longMsgIndex = paramMessageRecord2.longMsgIndex;
    paramMessageRecord1.isread = true;
    paramMessageRecord1.issend = 1;
    paramMessageRecord1.msgseq = paramMessageRecord2.msgseq;
    paramMessageRecord1.shmsgseq = paramMessageRecord2.shmsgseq;
    paramMessageRecord1.msgUid = paramMessageRecord2.msgUid;
    paramMessageRecord1.time = ((int)MessageCache.a());
  }
  
  @Deprecated
  private static MessageForPtt b(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int j = 0;
    if (paramMessageForPtt == null) {
      return null;
    }
    MessageForPtt localMessageForPtt = new MessageForPtt();
    localMessageForPtt.msgtype = -2002;
    a(localMessageForPtt, paramMessageForPtt);
    byte[] arrayOfByte = new byte[3];
    PkgTools.a(paramMessageForPtt.url.length(), arrayOfByte, 0, 3, "utf-8");
    localMessageForPtt.url = paramMessageForPtt.url;
    localMessageForPtt.fileSize = -3L;
    localMessageForPtt.itemType = 2;
    int i = j;
    if (SttManager.a(paramMessageForPtt.istroop))
    {
      i = j;
      if (SttManager.a(paramQQAppInterface)) {
        i = 1;
      }
    }
    localMessageForPtt.sttAbility = i;
    localMessageForPtt.longPttVipFlag = MessageUtils.a(paramQQAppInterface, paramQQAppInterface.a());
    localMessageForPtt.serial();
    return localMessageForPtt;
  }
  
  private static MessageRecord b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    case -2010: 
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (!MessageUtils.a(paramInt)) {
          break label543;
        }
        if (paramInt != -1002) {
          break label532;
        }
        localObject2 = new MessageForSafeGrayTips();
      }
      break;
    }
    for (;;)
    {
      if (localObject2 != null) {
        ((MessageRecord)localObject2).msgtype = paramInt;
      }
      return localObject2;
      localObject1 = new MessageForText();
      break;
      localObject1 = new MessageForPic();
      break;
      localObject1 = new MessageForStructing();
      break;
      localObject1 = new MessageForTroopNotification();
      break;
      localObject1 = new MessageForMarketFace();
      break;
      localObject1 = new MessageForPubAccount();
      break;
      localObject1 = new MessageForPtt();
      break;
      localObject1 = new MessageForFile();
      break;
      localObject1 = new MessageForRichState();
      break;
      localObject1 = new MessageForVideo();
      break;
      localObject1 = new MessageForActivity();
      break;
      localObject1 = new MessageForEnterTroop();
      break;
      localObject1 = new MessageForMixedMsg();
      break;
      localObject1 = new MessageForQzoneFeed();
      break;
      localObject1 = new MessageForSystemMsg();
      break;
      localObject1 = new MessageForMyEnterTroop();
      break;
      localObject1 = new MessageForTroopFile();
      break;
      localObject1 = new MessageForShakeWindow();
      ((MessageRecord)localObject1).msgtype = -2020;
      break;
      localObject1 = new MessageForTroopUnreadTips();
      break;
      localObject1 = new MessageForText();
      break;
      label532:
      localObject2 = new MessageForGrayTips();
      continue;
      label543:
      localObject2 = localObject1;
      if (paramInt == -1038) {
        localObject2 = new MessageForPlayTogetherResult();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageRecordFactory
 * JD-Core Version:    0.7.0.1
 */