import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import java.util.List;

public class eqd
  extends BaseAdapter
{
  private eqd(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
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
      eqg localeqg = (eqg)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localeqg;
    }
    for (;;)
    {
      LocaleString.a(((Groups)getItem(paramInt)).group_name, paramView.a);
      paramView.a.setContentDescription(((Groups)getItem(paramInt)).group_name + ",双击进入分组选择");
      if (paramInt != 0) {
        break;
      }
      paramView.a.setOnClickListener(new eqe(this));
      return paramViewGroup;
      paramView = new eqg(this, null);
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903963, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.a = ((Button)paramViewGroup.findViewById(2131232180));
      paramViewGroup.setTag(paramView);
    }
    paramView.a.setOnClickListener(new eqf(this, paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqd
 * JD-Core Version:    0.7.0.1
 */