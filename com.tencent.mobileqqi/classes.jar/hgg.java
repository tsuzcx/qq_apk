import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.CustomAlertDialog;
import com.tencent.mobileqq.widget.CustomAlertDialog.OnPrepareOptionMenuItem;
import java.util.HashMap;
import java.util.List;

public class hgg
  extends BaseAdapter
{
  List jdField_a_of_type_JavaUtilList;
  
  public hgg(CustomAlertDialog paramCustomAlertDialog, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2130903125, null);
    }
    ((TextView)paramViewGroup.findViewById(2131231294)).setText((String)((HashMap)this.jdField_a_of_type_JavaUtilList.get(paramInt)).get("optionStr"));
    paramViewGroup.setOnClickListener(new hgh(this, paramInt));
    ((ImageView)paramViewGroup.findViewById(2131231293)).setImageResource(((Integer)((HashMap)this.jdField_a_of_type_JavaUtilList.get(paramInt)).get("imgId")).intValue());
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog$OnPrepareOptionMenuItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog.jdField_a_of_type_ComTencentMobileqqWidgetCustomAlertDialog$OnPrepareOptionMenuItem.a(paramInt, paramViewGroup);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgg
 * JD-Core Version:    0.7.0.1
 */