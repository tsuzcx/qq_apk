import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;

public class wrr
  implements View.OnClickListener
{
  public wrr(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onClick, id = " + i);
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem == null) {
      return;
    }
    switch (i)
    {
    default: 
      return;
    case 2131363517: 
      paramView = new Bundle();
      paramView.putInt("forward_type", -1);
      paramView.putString("forward_text", ((MessageItem)localObject).a.msg);
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramView);
      ForwardBaseOption.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      return;
    }
    ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(((MessageItem)localObject).a.msg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */