import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.data.Groups;
import java.util.List;

public class cls
  extends BaseAdapter
{
  private cls(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
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
      clv localclv = (clv)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localclv;
    }
    for (;;)
    {
      paramView.a.setText(((Groups)getItem(paramInt)).group_name);
      paramView.a.setContentDescription(((Groups)getItem(paramInt)).group_name + "分组");
      if (paramInt != 0) {
        break;
      }
      paramView.a.setOnClickListener(new clt(this));
      return paramViewGroup;
      paramView = new clv(this, null);
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903634, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.a = ((Button)paramViewGroup.findViewById(2131297534));
      paramViewGroup.setTag(paramView);
    }
    paramView.a.setOnClickListener(new clu(this, paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cls
 * JD-Core Version:    0.7.0.1
 */