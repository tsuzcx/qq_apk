import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity.ItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import java.util.ArrayList;

public class ccg
  extends BaseAdapter
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private ccg(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ccf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.getLayoutInflater().inflate(2130903468, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131298137);
      paramView.setText(((ccf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = ((ccf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      localView.setFocusable(true);
      localView.setContentDescription(paramView.getText() + "搜索结果");
      return localView;
    case 2: 
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.getLayoutInflater().inflate(2130903466, null);
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity);
        paramView = new SearchBaseActivity.ItemViewHolder();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298132));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298133));
        paramView.d = ((TextView)paramViewGroup.findViewById(2131298136));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298134));
        paramView.c = ((TextView)paramViewGroup.findViewById(2131298135));
        paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ccf)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        paramView.jdField_b_of_type_Int = ((ccf)getItem(paramInt)).jdField_b_of_type_Int;
        paramViewGroup.setTag(paramView);
      }
      paramView = (SearchBaseActivity.ItemViewHolder)paramViewGroup.getTag();
      paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ccf)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      paramView.jdField_b_of_type_Int = ((ccf)getItem(paramInt)).jdField_b_of_type_Int;
      paramViewGroup.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.a(paramView, (ccf)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)));
      return paramViewGroup;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.getLayoutInflater().inflate(2130903467, paramViewGroup, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.a = new cce(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity);
    }
    localView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.a);
    localView.setContentDescription("查看更多" + this.jdField_a_of_type_JavaLangString + "搜索结果按钮");
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ccg
 * JD-Core Version:    0.7.0.1
 */