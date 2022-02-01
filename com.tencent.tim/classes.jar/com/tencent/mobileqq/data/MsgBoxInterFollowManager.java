package com.tencent.mobileqq.data;

import acbn;
import afcu;
import afcw;
import anbi;
import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import aqmj;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0xd7.SubMsgType0xd7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xfe.submsgtype0xfe.MsgBody;
import ton;

public class MsgBoxInterFollowManager
  implements Manager
{
  public QQAppInterface app;
  public int msgboxUnreadCount;
  
  public MsgBoxInterFollowManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.msgboxUnreadCount = aqmj.aI(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  private void addMessage(MessageForInteractAndFollow paramMessageForInteractAndFollow)
  {
    MessageRecord localMessageRecord = this.app.b().d(paramMessageForInteractAndFollow.senderuin, paramMessageForInteractAndFollow.istroop);
    if (localMessageRecord != null)
    {
      this.app.b().t(localMessageRecord.senderuin, localMessageRecord.istroop, localMessageRecord.uniseq);
      this.app.b().b(paramMessageForInteractAndFollow, this.app.getCurrentAccountUin());
      return;
    }
    this.app.b().b(paramMessageForInteractAndFollow, this.app.getCurrentAccountUin());
  }
  
  public void addMessage(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt3 != 1) && (paramInt3 != 2)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, "type=" + paramInt3);
      }
    }
    label399:
    label434:
    label437:
    for (;;)
    {
      return;
      MessageForInteractAndFollow localMessageForInteractAndFollow = (MessageForInteractAndFollow)anbi.d(-2055);
      localMessageForInteractAndFollow.rawContext = paramString;
      localMessageForInteractAndFollow.context = afcw.b(paramString, 14);
      localMessageForInteractAndFollow.unReadCount = paramInt2;
      localMessageForInteractAndFollow.msgBoxUnreadCount = paramInt1;
      localMessageForInteractAndFollow.timeStamp = paramLong;
      localMessageForInteractAndFollow.msgseq = paramLong;
      localMessageForInteractAndFollow.type = paramInt3;
      localMessageForInteractAndFollow.time = paramLong;
      localMessageForInteractAndFollow.shmsgseq = paramLong;
      localMessageForInteractAndFollow.msgUid = paramLong;
      localMessageForInteractAndFollow.selfuin = this.app.getCurrentAccountUin();
      localMessageForInteractAndFollow.istroop = 10002;
      if (localMessageForInteractAndFollow.type == 1)
      {
        paramString = acbn.bli;
        localMessageForInteractAndFollow.senderuin = paramString;
        localMessageForInteractAndFollow.frienduin = acbn.bkE;
        localMessageForInteractAndFollow.getBytes();
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder(20);
          paramString.append("msgBoxUnreadCount=").append(localMessageForInteractAndFollow.msgBoxUnreadCount).append(",unReadCount=").append(localMessageForInteractAndFollow.unReadCount).append(",context=").append(localMessageForInteractAndFollow.context).append("timeStamp=").append(localMessageForInteractAndFollow.timeStamp).append(",msgseq=").append(localMessageForInteractAndFollow.msgseq).append(",shmsgseq=").append(localMessageForInteractAndFollow.shmsgseq).append(",msgUid=").append(localMessageForInteractAndFollow.msgUid).append(",senderuin=").append(localMessageForInteractAndFollow.senderuin);
          QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, paramString.toString());
        }
        if (localMessageForInteractAndFollow.unReadCount <= 0) {
          break label399;
        }
        if (aqmj.j(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) != 1) {
          break label434;
        }
        aqmj.h(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin, 0);
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 == 0) {
          break label437;
        }
        ThreadManager.post(new MsgBoxInterFollowManager.2(this, localMessageForInteractAndFollow), 8, null, true);
        return;
        paramString = acbn.blj;
        break;
        if (aqmj.j(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) == 0)
        {
          paramInt1 = 1;
        }
        else
        {
          paramInt1 = 0;
          continue;
          paramInt1 = 1;
        }
      }
    }
  }
  
  public void addMomentMessage(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    MessageForInteractAndFollow localMessageForInteractAndFollow = (MessageForInteractAndFollow)anbi.d(-2055);
    localMessageForInteractAndFollow.rawContext = paramString;
    localMessageForInteractAndFollow.context = afcw.b(paramString, 14);
    localMessageForInteractAndFollow.unReadCount = paramInt2;
    localMessageForInteractAndFollow.msgBoxUnreadCount = paramInt1;
    localMessageForInteractAndFollow.timeStamp = paramLong;
    localMessageForInteractAndFollow.msgseq = paramLong;
    localMessageForInteractAndFollow.type = 3;
    localMessageForInteractAndFollow.time = paramLong;
    localMessageForInteractAndFollow.shmsgseq = paramLong;
    localMessageForInteractAndFollow.msgUid = paramLong;
    localMessageForInteractAndFollow.selfuin = this.app.getCurrentAccountUin();
    localMessageForInteractAndFollow.istroop = 1001;
    localMessageForInteractAndFollow.senderuin = acbn.blk;
    localMessageForInteractAndFollow.frienduin = acbn.bkE;
    localMessageForInteractAndFollow.getBytes();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(20);
      paramString.append("msgBoxUnreadCount=").append(localMessageForInteractAndFollow.msgBoxUnreadCount).append(",unReadCount=").append(localMessageForInteractAndFollow.unReadCount).append(",context=").append(localMessageForInteractAndFollow.context).append("timeStamp=").append(localMessageForInteractAndFollow.timeStamp).append(",msgseq=").append(localMessageForInteractAndFollow.msgseq).append(",shmsgseq=").append(localMessageForInteractAndFollow.shmsgseq).append(",msgUid=").append(localMessageForInteractAndFollow.msgUid).append(",senderuin=").append(localMessageForInteractAndFollow.senderuin);
      QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, paramString.toString());
    }
    if (localMessageForInteractAndFollow.unReadCount > 0)
    {
      if (aqmj.j(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) != 1) {
        break label371;
      }
      aqmj.h(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin, 0);
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        ThreadManager.post(new MsgBoxInterFollowManager.1(this, localMessageForInteractAndFollow), 8, null, true);
      }
      return;
      paramInt1 = i;
      if (aqmj.j(this.app.getApp(), this.app.getCurrentAccountUin(), localMessageForInteractAndFollow.senderuin) == 0)
      {
        paramInt1 = 1;
        continue;
        label371:
        paramInt1 = 1;
      }
    }
  }
  
  public void clearMsgBoxUnreadCount()
  {
    if (this.msgboxUnreadCount > 0)
    {
      this.msgboxUnreadCount = 0;
      afcu.a(this.app, 0, null);
      aqmj.ad(this.app.getApp(), this.app.getCurrentAccountUin(), 0);
    }
  }
  
  public void decode0xd7InteractAndFollowMsg(byte[] paramArrayOfByte)
  {
    SubMsgType0xd7.MsgBody localMsgBody = new SubMsgType0xd7.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new StringBuilder();
      if (localMsgBody.msg_content.bytes_from_user.has()) {
        paramArrayOfByte.append(localMsgBody.msg_content.bytes_from_user.get().toStringUtf8());
      }
      if (localMsgBody.msg_content.bytes_buluo_word.has())
      {
        paramArrayOfByte.append(afcw.kv(afcw.ku(localMsgBody.msg_content.bytes_buluo_word.get().toStringUtf8())));
        if (localMsgBody.uint32_msgbox_unread_count.has())
        {
          this.msgboxUnreadCount = localMsgBody.uint32_msgbox_unread_count.get();
          aqmj.ad(this.app.getApp(), this.app.getCurrentAccountUin(), localMsgBody.uint32_msgbox_unread_count.get());
        }
        addMessage(paramArrayOfByte.toString(), localMsgBody.uint32_msgbox_unread_count.get(), localMsgBody.uint32_unread_count.get(), localMsgBody.uint64_timestamp.get(), localMsgBody.uint32_type.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg_box.MsgBoxInterFollowManager", 2, "decode0xd7InteractAndFollowMsg decode failed:" + paramArrayOfByte.toString(), paramArrayOfByte);
          continue;
          if (localMsgBody.msg_content.rich_fresh_word.has()) {
            paramArrayOfByte.append(afcw.a((appoint_define.RichText)localMsgBody.msg_content.rich_fresh_word.get()));
          } else {
            paramArrayOfByte.append(localMsgBody.msg_content.bytes_plain_text.get().toStringUtf8());
          }
        }
      }
    }
  }
  
  public void decode0xfeInteractAndFollowMsg(byte[] paramArrayOfByte)
  {
    submsgtype0xfe.MsgBody localMsgBody = new submsgtype0xfe.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (localMsgBody.uint32_box_unread_num.has())
      {
        this.msgboxUnreadCount = localMsgBody.uint32_box_unread_num.get();
        aqmj.ad(this.app.getApp(), this.app.getCurrentAccountUin(), localMsgBody.uint32_box_unread_num.get());
      }
      addMomentMessage(localMsgBody.bytes_wording.get().toStringUtf8(), localMsgBody.uint32_box_unread_num.get(), localMsgBody.uint32_inner_unread_num.get(), localMsgBody.uint32_update_time.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg_box.MsgBoxInterFollowManager", 2, "decode0xd7InteractAndFollowMsg decode failed:" + paramArrayOfByte.toString(), paramArrayOfByte);
        }
      }
    }
  }
  
  public int getInterFollowMsgBoxUnreadCount()
  {
    return this.msgboxUnreadCount;
  }
  
  public boolean isInMsgBoxRecentList(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box.MsgBoxInterFollowManager", 2, "isInMsgBoxRecentList, uin=" + paramString);
      }
      return false;
    }
    Object localObject = this.app.a(paramInt).h(paramString, paramInt);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((MessageRecord)((Iterator)localObject).next()).senderuin)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.msgboxUnreadCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MsgBoxInterFollowManager
 * JD-Core Version:    0.7.0.1
 */