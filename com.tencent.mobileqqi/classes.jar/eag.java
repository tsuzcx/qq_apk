import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class eag
  implements ActionSheet.OnButtonClickListener
{
  public eag(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ChatActivityFacade.a(PttItemBuilder.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    paramView = ChatActivityFacade.a(PttItemBuilder.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), PttItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if (paramView != null) {}
    try
    {
      ChatActivityFacade.a(PttItemBuilder.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, paramView.uniseq, true);
      PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        Toast.makeText(PttItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder), paramView.getMessage(), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eag
 * JD-Core Version:    0.7.0.1
 */