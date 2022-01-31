import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloTabAdapter;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.HorizontalListView;
import java.util.Iterator;
import java.util.List;

public class zgh
  implements Runnable
{
  public zgh(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.a(this.jdField_a_of_type_JavaUtilList);
      if (!ApolloPanel.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel)) {
        break label111;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqApolloViewApolloTabAdapter.notifyDataSetChanged();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null)) {
        break;
      }
      return;
      label111:
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label135:
    ApolloActionPackage localApolloActionPackage;
    while (localIterator.hasNext())
    {
      localApolloActionPackage = (ApolloActionPackage)localIterator.next();
      if ((localApolloActionPackage != null) && (localApolloActionPackage.isUpdate)) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a != 3000) {
          break label215;
        }
      }
    }
    label215:
    for (int i = 2;; i = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a)
    {
      VipUtils.a(null, "cmshow", "Apollo", "tabreddot", i, 0, new String[] { String.valueOf(localApolloActionPackage.packageId) });
      break label135;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zgh
 * JD-Core Version:    0.7.0.1
 */