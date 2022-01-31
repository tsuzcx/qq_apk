import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class cnq
  extends CharDividedFacePreloadBaseAdapter
{
  public cnq(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    super(paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemberListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public int a()
  {
    return 2130903225;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.a.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.a.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label65;
      }
      if (!this.a.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.a.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label65:
      i = -1;
    }
  }
  
  protected Object a(int paramInt)
  {
    TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)getItem(paramInt);
    CharDividedFacePreloadBaseAdapter.FaceInfo localFaceInfo = new CharDividedFacePreloadBaseAdapter.FaceInfo(this);
    if (localTroopMemberInfo != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localTroopMemberInfo.memberuin;
    }
    return localFaceInfo;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    ((TextView)paramView).setText(String.valueOf(this.a.jdField_a_of_type_ArrayOfJavaLangString[paramInt]));
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.a.jdField_a_of_type_ArrayOfInt[(this.a.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[(this.a.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.a.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903620, paramViewGroup, false);
      paramView = new cnr(this.a, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131297010));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297009));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131298744));
      paramView.b = ((ImageView)localView.findViewById(2131296453));
      paramView.c = ((TextView)localView.findViewById(2131296455));
    }
    paramView = (cnr)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramViewGroup = (TroopMemberInfo)((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.a.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.a.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramViewGroup.memberuin))
      {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramView.b.setImageBitmap(a(paramViewGroup.memberuin));
        paramView.c.setText(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(paramViewGroup));
        paramView.jdField_a_of_type_JavaLangString = paramViewGroup.memberuin;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.contains(paramViewGroup.memberuin))) {
          break label395;
        }
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        label318:
        if (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          if (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label406;
          }
          localView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(paramViewGroup) + "已选中");
        }
      }
      for (;;)
      {
        localView.setOnClickListener(this.a);
        return localView;
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label395:
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label318;
        label406:
        localView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManagerImp.a(paramViewGroup));
      }
    }
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup = String.valueOf(this.a.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363986), new Object[] { paramViewGroup.toLowerCase() }));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cnq
 * JD-Core Version:    0.7.0.1
 */