import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.ActionListActivity;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import java.util.ArrayList;

public class ebc
  extends BaseAdapter
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public ebc(ActionListActivity paramActionListActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getLayoutInflater().inflate(2130903653, paramViewGroup, false);
      paramView = new ebb(null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298195));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298196));
      localView.setTag(paramView);
    }
    paramView = (ebb)localView.getTag();
    paramViewGroup = ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).intValue());
    if ((paramViewGroup != null) && (paramView.jdField_a_of_type_Int != paramViewGroup.i))
    {
      paramView.jdField_a_of_type_Int = paramViewGroup.i;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources(), ActionListActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity).a(paramViewGroup.i, 201), false, false));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.c);
      if (paramViewGroup.j != 1) {
        break label205;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    for (;;)
    {
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity);
      return localView;
      label205:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getResources().getDrawable(2130837717), null);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebc
 * JD-Core Version:    0.7.0.1
 */