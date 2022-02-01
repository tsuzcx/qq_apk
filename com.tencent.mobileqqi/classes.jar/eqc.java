import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import java.util.List;

public class eqc
  extends BaseAdapter
{
  private eqc(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
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
      eqf localeqf = (eqf)paramView.getTag();
      paramViewGroup = paramView;
      paramView = localeqf;
    }
    for (;;)
    {
      LocaleString.a(((Groups)getItem(paramInt)).group_name, paramView.a);
      paramView.a.setContentDescription(((Groups)getItem(paramInt)).group_name + ",双击进入分组选择");
      if (paramInt != 0) {
        break;
      }
      paramView.a.setOnClickListener(new eqd(this));
      return paramViewGroup;
      paramView = new eqf(this, null);
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903963, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.a = ((Button)paramViewGroup.findViewById(2131232179));
      paramViewGroup.setTag(paramView);
    }
    paramView.a.setOnClickListener(new eqe(this, paramInt));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqc
 * JD-Core Version:    0.7.0.1
 */