import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.ArkAppBabyQNoResultBuilder;
import com.tencent.mobileqq.ark.ArkAppDataReport;

public class uud
  implements View.OnClickListener
{
  public uud(ArkAppBabyQNoResultBuilder paramArkAppBabyQNoResultBuilder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getText();
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "@babyQ " + paramView);
      ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uud
 * JD-Core Version:    0.7.0.1
 */