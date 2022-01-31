import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.qphone.base.util.QLog;

public class yvh
  implements Runnable
{
  public yvh(ApolloPanel paramApolloPanel, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_AndroidWidgetImageView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "holder.apolloInfo == null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a.a.getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvh
 * JD-Core Version:    0.7.0.1
 */