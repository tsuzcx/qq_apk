import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleGroup;
import java.util.ArrayList;

public class eqn
  extends BaseAdapter
{
  private eqn(RenMaiQuanTeamListInnerFrame paramRenMaiQuanTeamListInnerFrame) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (CircleGroup)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CircleGroup)getItem(paramInt);
    paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903972, RenMaiQuanTeamListInnerFrame.a(this.a), false);
    ((ImageView)paramViewGroup.findViewById(2131230985)).setImageResource(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(paramView.groupId));
    ((TextView)paramViewGroup.findViewById(2131232317)).setText(paramView.groupName);
    paramViewGroup.setOnClickListener(new eqo(this, paramView));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqn
 * JD-Core Version:    0.7.0.1
 */