import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.ActionGridActivity;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import java.util.ArrayList;

public class eay
  extends GridListView.GridListAdapter
{
  private eay(ActionGridActivity paramActionGridActivity) {}
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public int getCount()
  {
    return ActionGridActivity.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ActionGridActivity.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903653, null);
      paramView = new eaz(null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298195));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298196));
      paramViewGroup.setTag(paramView);
    }
    paramView = (eaz)paramViewGroup.getTag();
    ActionInfo localActionInfo = (ActionInfo)ActionGridActivity.a(this.a).get(paramInt);
    if (paramView.jdField_a_of_type_Int != localActionInfo.i)
    {
      paramView.jdField_a_of_type_Int = localActionInfo.i;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(this.a.getResources(), ActionGridActivity.a(this.a).a(localActionInfo.i, 201), false, false));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localActionInfo.c);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     eay
 * JD-Core Version:    0.7.0.1
 */