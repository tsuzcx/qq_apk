import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class xyv
  extends CharDividedFacePreloadBaseAdapter
{
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public xyv(FriendListInnerFrame paramFriendListInnerFrame)
  {
    super(paramFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    b();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame.jdField_a_of_type_JavaUtilList.iterator();
    label66:
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      Friends localFriends = (Friends)((Iterator)localObject2).next();
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        localObject1 = "#";
        i = ((String)localObject1).charAt(0);
        if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
          break label171;
        }
      }
      label171:
      for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
      {
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localFriends);
        break;
        localObject1 = localFriends.mCompareSpell.substring(0, 1);
        break label66;
      }
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
      if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
      }
    }
    if (((LinkedHashMap)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject1).get("#"));
    }
    ((LinkedHashMap)localObject1).clear();
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
    localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      i = 1;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfInt;
        int j = localObject2[i];
        int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
        localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
        i += 1;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return 2130969056;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramInt = paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1;
    if ((paramInt >= 0) && (paramInt < localList.size())) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971560, paramViewGroup, false);
      paramView = new xyw(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame, null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363938));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363937));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131363939));
      paramView.c = ((ImageView)localView.findViewById(2131362719));
      paramView.b = ((TextView)localView.findViewById(2131362754));
    }
    paramView = (xyw)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramViewGroup = (Friends)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramViewGroup.uin))
      {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramView.c.setImageBitmap(a(paramViewGroup.uin));
        paramView.b.setText(paramViewGroup.getFriendNick());
        paramView.jdField_a_of_type_JavaLangString = paramViewGroup.uin;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f.contains(paramViewGroup.uin))) {
          break label376;
        }
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        label299:
        if ((AppSetting.b) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
        {
          if (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label387;
          }
          localView.setContentDescription(paramViewGroup.getFriendNick() + "已选中");
        }
      }
      for (;;)
      {
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame);
        return localView;
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        label376:
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label299;
        label387:
        localView.setContentDescription(paramViewGroup.getFriendNick() + "未选中");
      }
    }
    paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewGroup = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberFriendListInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435997), new Object[] { paramViewGroup.toLowerCase() }));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyv
 * JD-Core Version:    0.7.0.1
 */