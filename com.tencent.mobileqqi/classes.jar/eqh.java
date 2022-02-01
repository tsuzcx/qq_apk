import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.List;

public class eqh
  extends FacePreloadBaseAdapter
{
  public eqh(RecentMemberInnerFrame paramRecentMemberInnerFrame)
  {
    super(paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, RecentMemberInnerFrame.a(paramRecentMemberInnerFrame), 1, true);
  }
  
  protected Object a(int paramInt)
  {
    RecentUser localRecentUser = (RecentUser)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localRecentUser != null)
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = localRecentUser.uin;
      localFaceInfo.jdField_a_of_type_Int = 1;
    }
    return localFaceInfo;
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
      localObject = (eqi)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      RecentUser localRecentUser = (RecentUser)getItem(paramInt);
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localRecentUser.uin)) {
        break label296;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label61:
      paramView.c.setImageBitmap(a(1, localRecentUser.uin));
      localObject = RecentMemberInnerFrame.a(this.a).a(localRecentUser.uin);
      if (localObject != null) {
        break label307;
      }
      localObject = "";
      label104:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_JavaLangString = localRecentUser.uin;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.contains(localRecentUser.uin))) {
        break label317;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      label164:
      if ((!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
        break label328;
      }
      paramViewGroup.setContentDescription((String)localObject + "已选中,双击取消");
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(this.a);
      return paramViewGroup;
      paramView = new eqi(this.a, null);
      paramViewGroup = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903964, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131230943));
      paramView.c = ((ImageView)paramViewGroup.findViewById(2131230940));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231000));
      paramViewGroup.setTag(paramView);
      break;
      label296:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label61;
      label307:
      localObject = ContactUtils.a((Friends)localObject);
      break label104;
      label317:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label164;
      label328:
      paramViewGroup.setContentDescription((String)localObject + "未选中,双击选中");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqh
 * JD-Core Version:    0.7.0.1
 */