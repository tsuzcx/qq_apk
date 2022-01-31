import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yyg
  implements Runnable
{
  public yyg(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "func showGameViewOnly begins. Thread id = " + Thread.currentThread().getId());
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_JavaUtilList.clear();
      this.a.jdField_a_of_type_JavaUtilList.add(this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameViewBinder);
      ApolloPanel.b(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yyg
 * JD-Core Version:    0.7.0.1
 */