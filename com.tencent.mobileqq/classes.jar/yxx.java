import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;

public class yxx
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public yxx(ApolloLinearLayout paramApolloLinearLayout) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = ApolloLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout);
  }
  
  public void run()
  {
    ViewParent localViewParent = ApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout);
    ApolloLinearLayout.ViewHolder localViewHolder;
    if ((localViewParent != null) && (this.jdField_a_of_type_Int == ApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout)) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_AndroidViewView != null))
    {
      localViewHolder = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_AndroidViewView.getTag();
      if ((localViewHolder != null) && (localViewHolder.a != null) && (localViewHolder.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (localViewHolder.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status == 1)) {
        break label86;
      }
    }
    label86:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.b = true;
        localViewParent.requestDisallowInterceptTouchEvent(true);
        ApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout, 2);
      } while ((localViewHolder.a == null) || (localViewHolder.a.b == 1) || (localViewHolder.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_AndroidViewView, localViewHolder.a);
    } while ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "cmshow", "Apollo", "long_press_icon", this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localViewHolder.a.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "" + localViewHolder.a.jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxx
 * JD-Core Version:    0.7.0.1
 */