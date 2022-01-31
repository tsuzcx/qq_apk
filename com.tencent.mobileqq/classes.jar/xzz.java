import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;

public class xzz
  extends FacePreloadBaseAdapter
{
  public xzz(RecentMemberInnerFrame paramRecentMemberInnerFrame)
  {
    super(paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, RecentMemberInnerFrame.a(paramRecentMemberInnerFrame), 1, true);
  }
  
  public int getCount()
  {
    if (RecentMemberInnerFrame.a(this.a) == null) {
      return 0;
    }
    return RecentMemberInnerFrame.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RecentMemberInnerFrame.a(this.a).size())) {
      return RecentMemberInnerFrame.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (yaa)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    RecentUser localRecentUser;
    for (;;)
    {
      localRecentUser = (RecentUser)getItem(paramInt);
      if (localRecentUser != null) {
        break;
      }
      return paramViewGroup;
      paramView = new yaa(this.a, null);
      paramViewGroup = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130971560, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131363939));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131362719));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131362754));
      paramViewGroup.setTag(paramView);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localRecentUser.uin))
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      paramView.c.setImageBitmap(a(1, localRecentUser.uin));
      localObject = RecentMemberInnerFrame.a(this.a).a(localRecentUser.uin);
      if (localObject != null) {
        break label320;
      }
      localObject = "";
      label189:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_JavaLangString = localRecentUser.uin;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f.contains(localRecentUser.uin))) {
        break label330;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      label249:
      if (AppSetting.b)
      {
        if ((!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label341;
        }
        paramViewGroup.setContentDescription((String)localObject + "已选中,双击取消");
      }
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(this.a);
      return paramViewGroup;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label320:
      localObject = ContactUtils.a((Friends)localObject);
      break label189;
      label330:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label249;
      label341:
      paramViewGroup.setContentDescription((String)localObject + "未选中,双击选中");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzz
 * JD-Core Version:    0.7.0.1
 */