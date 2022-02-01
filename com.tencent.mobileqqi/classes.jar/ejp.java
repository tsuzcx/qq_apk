import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class ejp
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  public ejp(MessageSearchDialog paramMessageSearchDialog) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (MessageSearchDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog).a() == this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, scrollState = " + paramInt + ", lastItem = " + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b);
      }
    } while ((this.b == 0) || (this.jdField_a_of_type_Int != this.b) || (paramInt != 0));
    if (QLog.isColorLevel()) {
      QLog.i(MessageSearchDialog.jdField_a_of_type_JavaLangString, 2, "onScrollStateChanged, reach bottom, lastItem = " + this.jdField_a_of_type_Int + ", totalItemCount = " + this.b);
    }
    MessageSearchDialog.b(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageSearchDialog);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ejp
 * JD-Core Version:    0.7.0.1
 */