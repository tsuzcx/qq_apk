import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import java.util.ArrayList;

public class dow
  extends BaseAdapter
{
  public dow(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130904025, null);
    }
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131234600);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131234602);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131234601);
    GroupCatalogBean localGroupCatalogBean2 = (GroupCatalogBean)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) && (localGroupCatalogBean2.jdField_a_of_type_Int < this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_Int))
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
      paramView = ((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
      if ((paramView == null) || (paramView.jdField_a_of_type_Int < localGroupCatalogBean2.jdField_a_of_type_Int)) {
        break label310;
      }
      if (!localGroupCatalogBean2.b.equals(paramView.b)) {}
    }
    label302:
    label310:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((GroupCatalogBean)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840347, 0);
      }
      for (;;)
      {
        localTextView1.setText(localGroupCatalogBean2.jdField_a_of_type_JavaLangString);
        if ((localGroupCatalogBean2.jdField_a_of_type_JavaUtilArrayList == null) || (localGroupCatalogBean2.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label302;
        }
        localImageView.setVisibility(0);
        return paramViewGroup;
        GroupCatalogBean localGroupCatalogBean1 = paramView.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
        localObject = paramView;
        paramView = localGroupCatalogBean1;
        break;
        localTextView2.setVisibility(4);
        continue;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) && (localGroupCatalogBean2.b.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b)))
        {
          localTextView2.setVisibility(0);
          localTextView2.setText("");
          localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840347, 0);
        }
        else
        {
          localTextView2.setVisibility(4);
        }
      }
      localImageView.setVisibility(4);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dow
 * JD-Core Version:    0.7.0.1
 */