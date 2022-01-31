import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.data.ApolloActionData;

public class yvo
  implements View.OnClickListener
{
  public yvo(ApolloPanel paramApolloPanel, ApolloActionData paramApolloActionData) {}
  
  public void onClick(View paramView)
  {
    if (ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel) != null)
    {
      paramView = new ApolloInfo();
      paramView.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
      ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel).c(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvo
 * JD-Core Version:    0.7.0.1
 */