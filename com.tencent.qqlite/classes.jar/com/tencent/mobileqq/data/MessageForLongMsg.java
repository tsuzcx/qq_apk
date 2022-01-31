package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageForLongMsg
  extends ChatMessage
{
  public Object fragmentListSyncLock = new Object();
  public List longMsgFragmentList;
  public CharSequence sb;
  
  public MessageForLongMsg()
  {
    this.longMsgFragmentList = new ArrayList();
  }
  
  public MessageForLongMsg(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.longMsgFragmentList = new ArrayList();
      this.longMsgFragmentList.addAll(paramArrayList);
      MessageRecord.copyMessageRecordBaseField(this, (MessageRecord)this.longMsgFragmentList.get(0));
      this.msgtype = -1037;
      paramArrayList = this.longMsgFragmentList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        if (!(localMessageRecord instanceof MessageForText)) {
          this.msgtype = -1036;
        }
        if ((localMessageRecord.extraflag == 32768) && (localMessageRecord.isSendFromLocal())) {
          this.extraflag = 32768;
        }
      }
    }
  }
  
  protected void doParse()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      MessageRecord localMessageRecord;
      synchronized (this.fragmentListSyncLock)
      {
        if ((this.longMsgFragmentList == null) || (this.longMsgFragmentList.isEmpty())) {
          break;
        }
        Iterator localIterator = this.longMsgFragmentList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)localIterator.next();
        if (!(localMessageRecord instanceof ChatMessage)) {
          continue;
        }
        ((ChatMessage)localMessageRecord).doParse();
        if ((localMessageRecord instanceof MessageForText)) {
          localStringBuilder.append(((MessageForText)localMessageRecord).msg);
        }
      }
      if ((localMessageRecord instanceof MessageForMixedMsg)) {
        localObject2.append(((MessageForMixedMsg)localMessageRecord).msg);
      } else if ((localMessageRecord instanceof MessageForPic)) {
        localObject2.append(BaseApplicationImpl.getContext().getString(2131362796));
      }
    }
    this.msg = localObject2.toString();
    this.sb = new QQText(this.msg, 13, 32, this.istroop);
  }
  
  public MessageRecord rebuildLongMsg()
  {
    Object localObject3;
    if (this.msgtype == -1037)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      synchronized (this.fragmentListSyncLock)
      {
        localObject3 = this.longMsgFragmentList.iterator();
        if (((Iterator)localObject3).hasNext()) {
          localStringBuilder.append(((MessageForText)((Iterator)localObject3).next()).msg);
        }
      }
      ??? = (MessageForText)MessageRecordFactory.a(-1000);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForText)???).msgtype = -1000;
      ((MessageForText)???).msg = localObject1.toString();
      return ???;
    }
    if (this.msgtype == -1036)
    {
      ??? = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject3 = new StringBuffer();
      for (;;)
      {
        Object localObject5;
        synchronized (this.fragmentListSyncLock)
        {
          Iterator localIterator = this.longMsgFragmentList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject5 = (MessageRecord)localIterator.next();
          if ((localObject5 instanceof MessageForText)) {
            ((List)???).add(localObject5);
          }
        }
        if ((localObject5 instanceof MessageForMixedMsg))
        {
          localObject5 = ((MessageForMixedMsg)localObject5).msgElemList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
            if ((localMessageRecord instanceof MessageForText))
            {
              ((List)???).add(localMessageRecord);
            }
            else if ((localMessageRecord instanceof MessageForPic))
            {
              if (!((List)???).isEmpty())
              {
                Object localObject6 = ((List)???).iterator();
                while (((Iterator)localObject6).hasNext()) {
                  ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)localObject6).next()).msg);
                }
                localObject6 = (MessageForText)MessageRecordFactory.a(-1000);
                ((MessageForText)localObject6).msgtype = -1000;
                ((MessageForText)localObject6).msg = ((StringBuffer)localObject3).toString();
                ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
                localCollection.add(localObject6);
                ((List)???).clear();
              }
              localCollection.add((MessageForPic)localMessageRecord.deepCopyByReflect());
            }
          }
        }
      }
      if (!((List)???).isEmpty())
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)???).next()).msg);
        }
        ??? = (MessageForText)MessageRecordFactory.a(-1000);
        ((MessageForText)???).msgtype = -1000;
        ((MessageForText)???).msg = ((StringBuffer)localObject3).toString();
        ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
        localCollection.add(???);
        ((List)???).clear();
      }
      ??? = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForMixedMsg)???).msgtype = -1035;
      ((MessageForMixedMsg)???).msgElemList = new CopyOnWriteArrayList();
      ((MessageForMixedMsg)???).msgElemList.addAll(localCollection);
      ((MessageForMixedMsg)???).prewrite();
      return ???;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongMsg
 * JD-Core Version:    0.7.0.1
 */