import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import java.util.List;

public class dcb
  extends BaseAdapter
{
  private dcb(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return this.a.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.a.getLayoutInflater().inflate(2130903283, null);
    }
    int i = (byte)((Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).group_id;
    paramView = (ImageView)paramViewGroup.findViewById(2131231935);
    if (i == this.a.jdField_a_of_type_Byte) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      paramView = (TextView)paramViewGroup.findViewById(2131231934);
      LocaleString.a(((Groups)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).group_name, paramView);
      return paramViewGroup;
      paramView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dcb
 * JD-Core Version:    0.7.0.1
 */