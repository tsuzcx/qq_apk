package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import localpb.richMsg.MarketFaceMsg.MarketFaceRec;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;

public class MessageForMixedMsg
  extends ChatMessage
{
  private static final String TAG = "MessageForMixedMsg";
  public Object elemListSyncLock = new Object();
  public List msgElemList;
  
  public static void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForPic.senderuin = paramMessageForMixedMsg.senderuin;
    paramMessageForPic.selfuin = paramMessageForMixedMsg.selfuin;
    paramMessageForPic.frienduin = paramMessageForMixedMsg.frienduin;
    paramMessageForPic.time = paramMessageForMixedMsg.time;
    paramMessageForPic.issend = paramMessageForMixedMsg.issend;
    paramMessageForPic.istroop = paramMessageForMixedMsg.istroop;
    paramMessageForPic.shmsgseq = paramMessageForMixedMsg.shmsgseq;
    paramMessageForPic.msgtype = -2000;
    paramMessageForPic.uniseq = paramMessageForMixedMsg.uniseq;
    paramMessageForPic.msgseq = paramMessageForMixedMsg.msgseq;
  }
  
  public static CharSequence getTextFromMixedMsg(ChatMessage arg0)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    int j;
    if ((??? instanceof MessageForMixedMsg))
    {
      localObject4 = (MessageForMixedMsg)???;
      synchronized (((MessageForMixedMsg)localObject4).elemListSyncLock)
      {
        j = ((MessageForMixedMsg)localObject4).msgElemList.size();
        if (i < j)
        {
          ??? = (MessageRecord)((MessageForMixedMsg)localObject4).msgElemList.get(i);
          if ((??? instanceof MessageForText)) {
            localStringBuilder.append(((MessageForText)???).msg);
          } else if ((??? instanceof MessageForPic)) {
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131362792));
          }
        }
      }
    }
    label125:
    while (!(??? instanceof MessageForLongMsg)) {
      return localObject1.toString();
    }
    Object localObject4 = (MessageForLongMsg)???;
    for (;;)
    {
      synchronized (((MessageForLongMsg)localObject4).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)localObject4).longMsgFragmentList.size();
        i = 0;
        if (i >= k) {
          break label343;
        }
        ??? = (MessageRecord)((MessageForLongMsg)localObject4).longMsgFragmentList.get(i);
        if ((??? instanceof MessageForText))
        {
          localObject1.append(((MessageForText)???).msg);
          break label355;
        }
        if (!(??? instanceof MessageForMixedMsg)) {
          break label355;
        }
        MessageForMixedMsg localMessageForMixedMsg = (MessageForMixedMsg)???;
        synchronized (localMessageForMixedMsg.elemListSyncLock)
        {
          int m = localMessageForMixedMsg.msgElemList.size();
          j = 0;
          if (j < m)
          {
            MessageRecord localMessageRecord = (MessageRecord)localMessageForMixedMsg.msgElemList.get(j);
            if ((localMessageRecord instanceof MessageForText)) {
              localObject1.append(((MessageForText)localMessageRecord).msg);
            } else if ((localMessageRecord instanceof MessageForPic)) {
              localObject1.append(BaseApplicationImpl.getContext().getString(2131362792));
            }
          }
        }
      }
      break label355;
      label343:
      break label125;
      i += 1;
      break;
      label355:
      i += 1;
      continue;
      j += 1;
    }
  }
  
  public void doParse()
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    Object localObject2;
    int i;
    try
    {
      localMsg.mergeFrom(this.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse");
      }
      this.msgElemList = new CopyOnWriteArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list created");
      }
      if (localMsg.elems.get().size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse no element");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      j = localMsg.elems.get().size();
      localObject2 = this.elemListSyncLock;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        MixedMsg.Elem localElem;
        try
        {
          localElem = (MixedMsg.Elem)localMsg.elems.get().get(i);
          Object localObject3;
          if (localElem.textMsg.has())
          {
            localObject3 = new MessageForText();
            ((MessageForText)localObject3).msg = localElem.textMsg.get();
            ((MessageForText)localObject3).msgData = ((MessageForText)localObject3).msg.getBytes();
            ((MessageForText)localObject3).doParse();
            this.msgElemList.add(localObject3);
            localStringBuilder.append(((MessageForText)localObject3).msg);
          }
          else if (localElem.picMsg.has())
          {
            localObject3 = new MessageForPic();
            ((MessageForPic)localObject3).msgData = ((RichMsg.PicRec)localElem.picMsg.get()).toByteArray();
            ((MessageForPic)localObject3).doParse();
            ((MessageForPic)localObject3).subMsgId = i;
            copyBaseInfoFromMixedToPic((MessageForPic)localObject3, this);
            this.msgElemList.add(localObject3);
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131362792));
          }
        }
        finally {}
        if (!localElem.markfaceMsg.has()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list size is " + this.msgElemList.size());
        }
        this.msg = localStringBuilder.toString();
        return;
      }
      i += 1;
    }
  }
  
  public MessageRecord getSubMessage(long paramLong)
  {
    if ((this.msgElemList == null) || (paramLong < 0L) || (paramLong >= this.msgElemList.size())) {
      return null;
    }
    return (MessageRecord)this.msgElemList.get((int)paramLong);
  }
  
  public void parse()
  {
    super.parse();
    synchronized (this.elemListSyncLock)
    {
      Iterator localIterator = this.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (((localMessageRecord instanceof MessageForPic)) && (localMessageRecord.uniseq != this.uniseq))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageForMixedMsg", 2, " Error : Info not Equals : child : " + localMessageRecord.uniseq + " parent:" + this.uniseq);
          }
          copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, this);
        }
      }
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  protected void prewrite()
  {
    if (this.msgElemList == null) {
      return;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    for (;;)
    {
      MessageRecord localMessageRecord;
      MixedMsg.Elem localElem;
      synchronized (this.elemListSyncLock)
      {
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        localElem = new MixedMsg.Elem();
        if ((localMessageRecord instanceof MessageForText))
        {
          localElem.textMsg.set(((MessageForText)localMessageRecord).msg);
          localMsg.elems.get().add(localElem);
        }
      }
      if ((localMessageRecord instanceof MessageForPic)) {
        localElem.picMsg.set(((MessageForPic)localMessageRecord).getSerialPB());
      } else if (!(localMessageRecord instanceof MessageForMarketFace)) {}
    }
    this.msgData = localObject2.toByteArray();
  }
  
  public byte[] upateMessageForPic(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return this.msgData;
    }
    if (this.msgElemList == null) {
      return this.msgData;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    for (;;)
    {
      Object localObject2;
      MixedMsg.Elem localElem;
      synchronized (this.elemListSyncLock)
      {
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)localIterator.next();
        localElem = new MixedMsg.Elem();
        if ((localObject2 instanceof MessageForText))
        {
          localElem.textMsg.set(((MessageForText)localObject2).msg);
          localMsg.elems.get().add(localElem);
        }
      }
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject2;
        if ((((MessageForPic)localObject2).uniseq == paramMessageForPic.uniseq) && (((MessageForPic)localObject2).subMsgId == paramMessageForPic.subMsgId)) {
          localElem.picMsg.set(paramMessageForPic.getSerialPB());
        } else {
          localElem.picMsg.set(((MessageForPic)localObject2).getSerialPB());
        }
      }
      else if (!(localObject2 instanceof MessageForMarketFace)) {}
    }
    this.msgData = localMsg.toByteArray();
    return this.msgData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMixedMsg
 * JD-Core Version:    0.7.0.1
 */