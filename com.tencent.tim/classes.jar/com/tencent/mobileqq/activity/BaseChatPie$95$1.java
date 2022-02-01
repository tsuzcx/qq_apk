package com.tencent.mobileqq.activity;

import aupd;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.todo.data.TodoInfo;
import ujp;

public class BaseChatPie$95$1
  implements Runnable
{
  public BaseChatPie$95$1(ujp paramujp, TodoInfo paramTodoInfo, String paramString) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_Ujp.this$0.app.b().a(String.valueOf(this.jdField_a_of_type_ComTencentTimTodoDataTodoInfo.fromUin), this.jdField_a_of_type_ComTencentTimTodoDataTodoInfo.istroop, this.jdField_a_of_type_ComTencentTimTodoDataTodoInfo.uniseq);
    if (localMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(aupd.TAG, 1, "get msg is null:!uniseq:" + this.jdField_a_of_type_ComTencentTimTodoDataTodoInfo.uniseq);
      }
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i(aupd.TAG, 1, "hasAddTodo Message:" + this.jdField_a_of_type_ComTencentTimTodoDataTodoInfo.uniseq + "findMsg:" + localMessageRecord.hashCode());
    }
    localMessageRecord.saveExtInfoToExtStr("message_ext_has_added_todo", "flag_has_added_todo");
    localMessageRecord.saveExtInfoToExtStr("message_ext_has_added_todo_id", this.val$id);
    this.jdField_a_of_type_Ujp.this$0.app.b().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "extStr", localMessageRecord.getExtInfoString());
    this.jdField_a_of_type_Ujp.this$0.app.b().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, "extLong", Integer.valueOf(localMessageRecord.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.95.1
 * JD-Core Version:    0.7.0.1
 */