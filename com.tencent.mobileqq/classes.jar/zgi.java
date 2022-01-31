import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelAdapter;
import com.tencent.mobileqq.apollo.view.ApolloViewBinder;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class zgi
  implements Runnable
{
  public zgi(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b.clear();
      int i = 0;
      int k;
      for (int j = 0; i < this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.size(); j = k)
      {
        k = j;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b != null)
        {
          k = j + ((ApolloViewBinder)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_JavaUtilList.get(i)).a();
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b.add(Integer.valueOf(k - 1));
        }
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(ApolloPanel.jdField_a_of_type_Int, false);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(ApolloPanel.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new zgj(this), 500L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zgi
 * JD-Core Version:    0.7.0.1
 */