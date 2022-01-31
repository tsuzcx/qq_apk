import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.ItemViewHolder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class cbz
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  private cbz(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Int != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    cby localcby;
    do
    {
      do
      {
        return paramView;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.getLayoutInflater().inflate(2130903454, null);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity);
          paramView = new SearchBaseActivity.ItemViewHolder();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298092));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298093));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131298096));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298094));
          paramView.c = ((TextView)paramViewGroup.findViewById(2131298095));
          paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
          paramView.jdField_b_of_type_Int = ClassificationSearchActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity);
          paramViewGroup.setTag(paramView);
        }
        paramView = (SearchBaseActivity.ItemViewHolder)paramViewGroup.getTag();
        paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
        paramViewGroup.setContentDescription(ClassificationSearchActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity, paramView, (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
        return paramViewGroup;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.getLayoutInflater().inflate(2130903239, null);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity);
          paramView = new cby();
          paramViewGroup.setTag(paramView);
          paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296558));
          paramViewGroup.findViewById(2131297310).setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297311));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.g();
        localcby = (cby)paramViewGroup.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Int != 3) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Boolean = true;
          localcby.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localcby.jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请稍后再试");
          return paramViewGroup;
        }
        paramView = paramViewGroup;
      } while (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Boolean = false;
      localcby.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localcby.jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.b = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.f();
      return paramViewGroup;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Int == 2)
      {
        localcby.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localcby.jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchActivity.jdField_a_of_type_Int != 4);
    localcby.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    localcby.jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请检查网络连接");
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbz
 * JD-Core Version:    0.7.0.1
 */