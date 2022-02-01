import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView;

public class ejs
  implements AdapterView.OnItemLongClickListener
{
  public ejs(MessageSearchDialog paramMessageSearchDialog) {}
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = MessageSearchDialog.a(this.a).a();
    if (paramAdapterView == this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem = ((MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getItem(paramInt));
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131234878, MessageSearchDialog.a(this.a).getString(17039361));
      paramAdapterView.a(2131231189, MessageSearchDialog.a(this.a).getString(2131562129));
      MessageSearchDialog.a(this.a, BubbleContextMenu.a(paramView, paramAdapterView, MessageSearchDialog.a(this.a), null));
    }
    for (;;)
    {
      return true;
      if (paramAdapterView != this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ejs
 * JD-Core Version:    0.7.0.1
 */