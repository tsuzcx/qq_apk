package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MarketFaceMsg.MarketFaceRec;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;

public class MessageForMixedMsg
  extends ChatMessage
{
  private static final String TAG = "MessageForMixedMsg";
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
  }
  
  public static CharSequence getTextFromMixedMsg(ChatMessage paramChatMessage)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    int j;
    Object localObject;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramChatMessage = (MessageForMixedMsg)paramChatMessage;
      j = paramChatMessage.msgElemList.size();
      if (i < j)
      {
        localObject = (MessageRecord)paramChatMessage.msgElemList.get(i);
        if ((localObject instanceof MessageForText)) {
          localStringBuilder.append(((MessageForText)localObject).msg);
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof MessageForPic)) {
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131561543));
          }
        }
      }
    }
    else if ((paramChatMessage instanceof MessageForLongMsg))
    {
      paramChatMessage = (MessageForLongMsg)paramChatMessage;
      int k = paramChatMessage.longMsgFragmentList.size();
      i = 0;
      if (i < k)
      {
        localObject = (MessageRecord)paramChatMessage.longMsgFragmentList.get(i);
        if ((localObject instanceof MessageForText)) {
          localStringBuilder.append(((MessageForText)localObject).msg);
        }
        while (!(localObject instanceof MessageForMixedMsg))
        {
          i += 1;
          break;
        }
        localObject = (MessageForMixedMsg)localObject;
        int m = ((MessageForMixedMsg)localObject).msgElemList.size();
        j = 0;
        label211:
        MessageRecord localMessageRecord;
        if (j < m)
        {
          localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(j);
          if (!(localMessageRecord instanceof MessageForText)) {
            break label262;
          }
          localStringBuilder.append(((MessageForText)localMessageRecord).msg);
        }
        for (;;)
        {
          j += 1;
          break label211;
          break;
          label262:
          if ((localMessageRecord instanceof MessageForPic)) {
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131561543));
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void doParse()
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localMsg.mergeFrom(this.msgData);
      this.msgElemList = new ArrayList();
      if (localMsg.elems.get().size() <= 0) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      int j = localMsg.elems.get().size();
      int i = 0;
      if (i < j)
      {
        MixedMsg.Elem localElem = (MixedMsg.Elem)localMsg.elems.get().get(i);
        Object localObject;
        if (localElem.textMsg.has())
        {
          localObject = new MessageForText();
          ((MessageForText)localObject).msg = localElem.textMsg.get();
          ((MessageForText)localObject).msgData = ((MessageForText)localObject).msg.getBytes();
          ((MessageForText)localObject).doParse();
          this.msgElemList.add(localObject);
          localStringBuilder.append(((MessageForText)localObject).msg);
        }
        for (;;)
        {
          i += 1;
          break;
          if (localElem.picMsg.has())
          {
            localObject = new MessageForPic();
            ((MessageForPic)localObject).msgData = ((RichMsg.PicRec)localElem.picMsg.get()).toByteArray();
            ((MessageForPic)localObject).doParse();
            ((MessageForPic)localObject).subMsgId = i;
            copyBaseInfoFromMixedToPic((MessageForPic)localObject, this);
            this.msgElemList.add(localObject);
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131561543));
          }
          else if (!localElem.markfaceMsg.has()) {}
        }
      }
      this.msg = localStringBuilder.toString();
    }
  }
  
  public void parse()
  {
    super.parse();
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
    Iterator localIterator = this.msgElemList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      if ((localObject instanceof MessageForText)) {
        localElem.textMsg.set(((MessageForText)localObject).msg);
      }
      for (;;)
      {
        localMsg.elems.get().add(localElem);
        break;
        if ((localObject instanceof MessageForPic)) {
          localElem.picMsg.set(((MessageForPic)localObject).getSerialPB());
        } else if (!(localObject instanceof MessageForMarketFace)) {}
      }
    }
    this.msgData = localMsg.toByteArray();
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
    Iterator localIterator = this.msgElemList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      if ((localObject instanceof MessageForText)) {
        localElem.textMsg.set(((MessageForText)localObject).msg);
      }
      for (;;)
      {
        localMsg.elems.get().add(localElem);
        break;
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          if ((((MessageForPic)localObject).uniseq == paramMessageForPic.uniseq) && (((MessageForPic)localObject).subMsgId == paramMessageForPic.subMsgId)) {
            localElem.picMsg.set(paramMessageForPic.getSerialPB());
          } else {
            localElem.picMsg.set(((MessageForPic)localObject).getSerialPB());
          }
        }
        else if (!(localObject instanceof MessageForMarketFace)) {}
      }
    }
    this.msgData = localMsg.toByteArray();
    return this.msgData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForMixedMsg
 * JD-Core Version:    0.7.0.1
 */