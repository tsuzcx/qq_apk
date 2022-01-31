import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.XListView;

public class cgx
  implements AdapterView.OnItemLongClickListener
{
  public cgx(MessageSearchDialog paramMessageSearchDialog) {}
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onLongClick, position = " + paramInt);
    }
    paramAdapterView = MessageSearchDialog.a(this.a).a();
    if (paramAdapterView == this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem = ((MessageItem)this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getItem(paramInt));
      paramView.setSelected(true);
      paramAdapterView = new QQCustomMenu();
      paramAdapterView.a(2131298963, "复制");
      paramAdapterView.a(2131296655, MessageSearchDialog.a(this.a).getString(2131363573));
      this.a.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, MessageSearchDialog.a(this.a).getString(2131363287), paramAdapterView, MessageSearchDialog.a(this.a), new cgy(this, paramView));
    }
    while (paramAdapterView != this.a.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cgx
 * JD-Core Version:    0.7.0.1
 */