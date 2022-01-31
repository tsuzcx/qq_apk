import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.List;

public class dhi
  extends TroopObserver
{
  private int jdField_a_of_type_Int = -2;
  
  public dhi(SearchTroopListActivity paramSearchTroopListActivity) {}
  
  protected void a(int paramInt1, boolean paramBoolean, int paramInt2, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.b(SearchTroopListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity));
    Object localObject;
    if (paramInt1 == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidAppDialog != null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_b_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_JavaUtilList.clear();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity;
      ((SearchTroopListActivity)localObject).jdField_b_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.setTitle(2131562734);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetTextView.setText(2131562926);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.c();
      paramList = (ProgressBar)this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131231066);
      localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131231868);
      paramList.setVisibility(8);
      ((ImageView)localObject).setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_Dhj);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_Dhj.notifyDataSetChanged();
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131231066).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131231868).setVisibility(8);
        paramList = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.findViewById(2131231869);
        paramList.setVisibility(0);
        paramList.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.getString(2131559113));
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.c();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.jdField_b_of_type_AndroidWidgetTextView.setText(2131562495);
        this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.c();
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.getString(2131559114), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivitySearchTroopListActivity.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhi
 * JD-Core Version:    0.7.0.1
 */