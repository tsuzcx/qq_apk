import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.AddFrdHolder;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class yik
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  
  public yik(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame)
  {
    super(paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramTroopAddFrdsInnerFrame.b = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131559383);
    paramTroopAddFrdsInnerFrame.c = paramTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getResources().getDimensionPixelOffset(2131559384);
  }
  
  private boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(i);
        if (TextUtils.equals(paramTroopMemberInfo.memberuin, localResultRecord.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2130969059;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label65;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label65:
      i = -1;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.equals(paramResultRecord.jdField_a_of_type_JavaLangString, localResultRecord.jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (paramBoolean) {
        if (i == -1)
        {
          this.jdField_a_of_type_JavaUtilList.add(paramResultRecord);
          notifyDataSetChanged();
        }
      }
      while (i == -1)
      {
        return;
        i += 1;
        break;
      }
      this.jdField_a_of_type_JavaUtilList.remove(i);
      notifyDataSetChanged();
      return;
      i = -1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    boolean bool = true;
    int i = 0;
    int j = Arrays.binarySearch(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    Object localObject2;
    TroopAddFrdsInnerFrame.AddFrdHolder localAddFrdHolder;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970308, paramViewGroup, false);
      paramView = new TroopAddFrdsInnerFrame.AddFrdHolder();
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131363948);
      paramView.jdField_a_of_type_AndroidViewView.setId(2131362467);
      paramViewGroup = localView.findViewById(2131369989);
      localObject2 = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131362467);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources());
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366543));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369991));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362899));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369993));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131368974));
      paramView.d = ((TextView)localView.findViewById(2131368975));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131368495));
      paramView.e = ((TextView)localView.findViewById(2131363962));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131369981);
      paramView.e.setFocusableInTouchMode(false);
      paramView.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(false);
      paramView.e.setFocusable(false);
      paramView.jdField_b_of_type_AndroidViewView.setFocusable(false);
      paramView.jdField_a_of_type_AndroidViewView.setDuplicateParentStateEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetButton.setDuplicateParentStateEnabled(true);
      paramView.d.setDuplicateParentStateEnabled(false);
      paramView.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.a(2.0F, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources()), 0, 0);
      if ((TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame) != null) && (TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame).getVisibility() == 0))
      {
        localView.findViewById(2131362467).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.b, 0);
        localView.setTag(paramView);
      }
    }
    else
    {
      localAddFrdHolder = (TroopAddFrdsInnerFrame.AddFrdHolder)localView.getTag();
      if (j >= 0) {
        break label1292;
      }
      j = -(j + 1) - 1;
      localObject2 = (TroopMemberInfo)((List)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[j])).get(paramInt - this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfInt[j] - 1);
      localAddFrdHolder.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = ((TroopMemberInfo)localObject2);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(((TroopMemberInfo)localObject2).memberuin)) {
        break label1039;
      }
      localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label485:
      if (!AppSetting.b) {
        break label1409;
      }
      paramView = new StringBuilder(256);
      paramView.append("群成员");
    }
    for (;;)
    {
      localAddFrdHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      localAddFrdHolder.e.setVisibility(8);
      localAddFrdHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((TroopMemberInfo)localObject2).memberuin));
      Object localObject3 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      paramViewGroup = (ViewGroup)localObject3;
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).recommendRemark))
      {
        paramViewGroup = (ViewGroup)localObject3;
        if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, ((TroopMemberInfo)localObject2).memberuin))
        {
          paramViewGroup = (ViewGroup)localObject3;
          if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, (CharSequence)localObject3))
          {
            paramViewGroup = (ViewGroup)localObject3;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(((TroopMemberInfo)localObject2).memberuin)) {
              paramViewGroup = (String)localObject3 + " (" + ((TroopMemberInfo)localObject2).recommendRemark + ")";
            }
          }
        }
      }
      localAddFrdHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      localAddFrdHolder.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
      localAddFrdHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.b) {
        paramView.append(paramViewGroup);
      }
      if (((TroopMemberInfo)localObject2).commonFrdCnt > 0)
      {
        localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.getResources().getString(2131435531, new Object[] { Integer.valueOf(((TroopMemberInfo)localObject2).commonFrdCnt) }));
        localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (AppSetting.b) {
          paramView.append(localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
        label784:
        if (!this.jdField_a_of_type_Boolean) {
          localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(true);
        }
        if (((TroopMemberInfo)localObject2).addState != 3) {
          break label1064;
        }
        localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localAddFrdHolder.d.setVisibility(0);
        localAddFrdHolder.d.setText("已添加");
        if (this.jdField_a_of_type_Boolean)
        {
          localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(false);
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (!AppSetting.b) {
          break label1404;
        }
        localAddFrdHolder.d.setContentDescription("已添加");
        paramInt = 0;
      }
      for (;;)
      {
        label892:
        localObject3 = localAddFrdHolder.jdField_a_of_type_AndroidViewView;
        if (paramInt != 0)
        {
          paramViewGroup = (ViewGroup)localObject2;
          label906:
          ((View)localObject3).setTag(paramViewGroup);
          localObject2 = localAddFrdHolder.jdField_a_of_type_AndroidViewView;
          paramViewGroup = localObject1;
          if (paramInt != 0) {
            paramViewGroup = this;
          }
          ((View)localObject2).setOnClickListener(paramViewGroup);
          paramViewGroup = localAddFrdHolder.jdField_a_of_type_AndroidViewView;
          if (paramInt == 0) {
            break label1280;
          }
          label944:
          paramViewGroup.setClickable(bool);
          localView.setBackgroundResource(2130838591);
          paramViewGroup = localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox;
          if (!this.jdField_a_of_type_Boolean) {
            break label1286;
          }
        }
        label1280:
        label1286:
        for (paramInt = i;; paramInt = 8)
        {
          paramViewGroup.setVisibility(paramInt);
          localAddFrdHolder.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          localAddFrdHolder.jdField_b_of_type_AndroidViewView.setTag(localAddFrdHolder);
          if (AppSetting.b) {
            localView.setContentDescription(paramView.toString());
          }
          return localView;
          localView.findViewById(2131362467).setPadding(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.c, 0);
          break;
          label1039:
          localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          break label485;
          localAddFrdHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label784;
          label1064:
          if (((TroopMemberInfo)localObject2).addState == 2)
          {
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            localAddFrdHolder.d.setVisibility(0);
            localAddFrdHolder.d.setText("等待验证");
            if (this.jdField_a_of_type_Boolean)
            {
              localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(false);
              localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
              localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            }
            if (!AppSetting.b) {
              break label1404;
            }
            localAddFrdHolder.d.setContentDescription("等待验证");
            paramInt = 0;
            break label892;
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localAddFrdHolder.jdField_b_of_type_AndroidViewView.setEnabled(true);
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((TroopMemberInfo)localObject2));
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetCheckBox.setTag(localAddFrdHolder);
          }
          for (paramInt = 0;; paramInt = 1)
          {
            localAddFrdHolder.d.setVisibility(8);
            break;
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setText("添加");
            if (AppSetting.b) {
              localAddFrdHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription("添加");
            }
          }
          paramViewGroup = null;
          break label906;
          bool = false;
          break label944;
        }
        label1292:
        localAddFrdHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.f == TroopAddFrdsInnerFrame.d)
        {
          localAddFrdHolder.e.setVisibility(0);
          paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ArrayOfJavaLangString[j]);
          localAddFrdHolder.e.setText(paramView);
          localAddFrdHolder.e.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131436015), new Object[] { paramView.toLowerCase() }));
          return localView;
        }
        localAddFrdHolder.e.setVisibility(8);
        localView.setBackgroundResource(0);
        return localView;
        label1404:
        paramInt = 0;
      }
      label1409:
      paramView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131362467: 
      paramView = (TroopMemberInfo)localObject;
      TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramView, TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame), false);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramView = (TroopAddFrdsInnerFrame.AddFrdHolder)localObject;
      boolean bool = a(paramView.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
      localObject = new ResultRecord();
      ((ResultRecord)localObject).jdField_a_of_type_JavaLangString = paramView.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false);
      }
      for (;;)
      {
        notifyDataSetChanged();
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e(paramView.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a((ResultRecord)localObject, false);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(false);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j();
      }
    }
    paramView = ((TroopAddFrdsInnerFrame.AddFrdHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
    localObject = new Bundle();
    ((Bundle)localObject).putString("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131433123));
    ((Bundle)localObject).putString("custom_leftbackbutton_name", this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131433712));
    TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramView.troopuin, paramView.memberuin, 1, -1, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yik
 * JD-Core Version:    0.7.0.1
 */