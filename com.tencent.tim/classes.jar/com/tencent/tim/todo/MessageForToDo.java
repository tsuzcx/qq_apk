package com.tencent.tim.todo;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import com.trunk.Qworkflow.Qworkflow.TimTodoNotification;

public class MessageForToDo
  extends ChatMessage
{
  @notColumn
  public long authorUin;
  @notColumn
  public long changedBeginTime;
  @notColumn
  public long changedEndTime;
  @notColumn
  public int notificationType;
  @notColumn
  public String title;
  @notColumn
  public String todoId;
  
  public void doParse()
  {
    Qworkflow.TimTodoNotification localTimTodoNotification = new Qworkflow.TimTodoNotification();
    try
    {
      localTimTodoNotification.mergeFrom(this.msgData);
      this.notificationType = localTimTodoNotification.enum_notice_type.get();
      if (this.notificationType == 1)
      {
        this.todoId = localTimTodoNotification.bytes_todo_id.get().toStringUtf8();
        this.authorUin = localTimTodoNotification.uint64_author_uin.get();
        this.title = localTimTodoNotification.bytes_title.get().toStringUtf8();
        this.changedBeginTime = localTimTodoNotification.uint64_remind_start.get();
        this.changedEndTime = localTimTodoNotification.uint64_remind_end.get();
        this.msg = this.title;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(MessageForDingdongSchedule.class.getSimpleName(), 1, "doParse error:" + localException.toString() + ".");
    }
  }
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.MessageForToDo
 * JD-Core Version:    0.7.0.1
 */