import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.data.Groups;
import java.util.List;

public class cmz
  extends BaseAdapter
{
  private cmz(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())) {
      return this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      cnc localcnc = (cnc)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localcnc;
    }
    for (;;)
    {
      paramView.a.setText(((Groups)getItem(paramInt)).group_name);
      paramView.a.setContentDescription(((Groups)getItem(paramInt)).group_name + "分组");
      if (paramInt != 0) {
        break;
      }
      paramView.a.setOnClickListener(new cna(this));
      return paramViewGroup;
      paramView = new cnc(this, null);
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903627, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.a = ((Button)paramViewGroup.findViewById(2131297530));
      paramViewGroup.setTag(paramView);
    }
    paramView.a.setOnClickListener(new cnb(this, paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmz
 * JD-Core Version:    0.7.0.1
 */