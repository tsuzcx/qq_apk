package com.tencent.mobileqq.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageForLongMsg
  extends ChatMessage
{
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
    if ((this.longMsgFragmentList != null) && (!this.longMsgFragmentList.isEmpty()))
    {
      Iterator localIterator = this.longMsgFragmentList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if ((localMessageRecord instanceof ChatMessage))
        {
          ((ChatMessage)localMessageRecord).doParse();
          if ((localMessageRecord instanceof MessageForText)) {
            localStringBuilder.append(((MessageForText)localMessageRecord).msg);
          } else if ((localMessageRecord instanceof MessageForMixedMsg)) {
            localStringBuilder.append(((MessageForMixedMsg)localMessageRecord).msg);
          } else if ((localMessageRecord instanceof MessageForPic)) {
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131561543));
          }
        }
      }
    }
    this.msg = localStringBuilder.toString();
    this.sb = new QQText(this.msg, 13, 32, this.istroop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForLongMsg
 * JD-Core Version:    0.7.0.1
 */