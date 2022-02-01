import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.widget.CustomWidgetUtil;
import java.util.ArrayList;

public class dca
  extends BaseAdapter
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public dca(QQLSActivity paramQQLSActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2130903592, null);
      paramView = new dcc();
      paramView.a = ((TextView)paramViewGroup.findViewById(2131233004));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131233016));
      paramView.c = ((TextView)paramViewGroup.findViewById(2131233005));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131233008));
      paramViewGroup.setTag(paramView);
    }
    paramView = (dcc)paramViewGroup.getTag();
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView.a.setText(localRecentBaseData.a);
    paramView.b.setText(localRecentBaseData.jdField_b_of_type_JavaLangCharSequence);
    paramView.c.setText(localRecentBaseData.jdField_b_of_type_JavaLangString);
    CustomWidgetUtil.a(paramView.d, 3, localRecentBaseData.b(), 0);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dca
 * JD-Core Version:    0.7.0.1
 */