import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectActivityViewHolder;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.GridViewAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class ygd
  extends CharDividedFacePreloadBaseAdapter
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new yge(this);
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  
  public ygd(PhoneContactTabView paramPhoneContactTabView, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramBoolean);
  }
  
  private void a(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.r();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j();
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b()
  {
    int k = 1;
    int j = 0;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.d != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.d.size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get("@") == null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put("@", new ArrayList());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.d.iterator();
    }
    label142:
    label455:
    label850:
    label851:
    for (;;)
    {
      label96:
      Object localObject2;
      Object localObject3;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject3).next();
          if (!((String)localObject2).equals(localPhoneContact.mobileNo)) {
            break label850;
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get("@")).add(localPhoneContact);
          i = 1;
        }
      }
      for (;;)
      {
        break label142;
        if (i != 0) {
          break label851;
        }
        localObject3 = new PhoneContact();
        ((PhoneContact)localObject3).mobileNo = ((String)localObject2);
        ((PhoneContact)localObject3).uin = null;
        ((PhoneContact)localObject3).name = ((String)localObject2);
        ((PhoneContact)localObject3).nickName = ((String)localObject2);
        ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get("@")).add(localObject3);
        break label96;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PhoneContact)((Iterator)localObject2).next();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.d == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.d.contains(((PhoneContact)localObject3).mobileNo)))
          {
            if (TextUtils.isEmpty(((PhoneContact)localObject3).pinyinFirst))
            {
              localObject1 = "#";
              label350:
              i = ((String)localObject1).charAt(0);
              if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
                break label455;
              }
            }
            for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
            {
              if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
                this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
              }
              ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localObject3);
              break;
              localObject1 = ((PhoneContact)localObject3).pinyinFirst.substring(0, 1);
              break label350;
            }
          }
        }
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        localObject3 = (List)((LinkedHashMap)localObject1).get("@");
        if (localObject3 != null)
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(PhoneContactTabView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView), localObject3);
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_Boolean)
          {
            localObject2 = new ArrayList();
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((List)localObject2).add(a((PhoneContact)((Iterator)localObject3).next()));
            }
            a((List)localObject2);
          }
        }
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
        if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
          break;
        }
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        i = k;
        while (i < this.jdField_a_of_type_ArrayOfInt.length)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfInt;
          k = localObject2[i];
          int m = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
          localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + m + 1 + k);
          i += 1;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        i = j;
        while (((Iterator)localObject1).hasNext())
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
          i += 1;
        }
        break;
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2130969059;
    }
    return 0;
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
  
  public ResultRecord a(PhoneContact paramPhoneContact)
  {
    String str2 = paramPhoneContact.name;
    String str1;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      str1 = "pstn" + paramPhoneContact.mobileNo;
    }
    while ((str1.startsWith("pstn")) && (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(str1, str2, 5, "-1")))
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str1, str2, 5, "-1", paramPhoneContact.mobileNo);
      if (paramPhoneContact.uin.equals("0")) {
        str1 = paramPhoneContact.nationCode + paramPhoneContact.mobileCode;
      } else {
        str1 = paramPhoneContact.uin;
      }
    }
    if (str1.startsWith("+")) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str1, str2, 4, "-1", paramPhoneContact.mobileNo);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(str1, str2, 0, "-1", paramPhoneContact.mobileNo);
  }
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramInt < 0) {
      paramInt = -(paramInt + 1);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  protected boolean a(FacePreloadBaseAdapter.ViewHolder paramViewHolder)
  {
    boolean bool2 = super.a(paramViewHolder);
    boolean bool1 = bool2;
    if ((paramViewHolder instanceof SelectActivityViewHolder))
    {
      paramViewHolder = (SelectActivityViewHolder)paramViewHolder;
      if ((bool2) && (!paramViewHolder.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
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
    return (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = SelectActivityViewHolder.a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_AndroidViewLayoutInflater, 2130968825);
    }
    paramView = (SelectActivityViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramViewGroup = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      SelectActivityViewHolder.a(this, paramView, paramViewGroup);
      paramView.b.setText(paramViewGroup.name);
      paramView.d.setText(paramViewGroup.mobileNo);
      paramView.d.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(paramView.jdField_a_of_type_JavaLangString))
      {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.jdField_a_of_type_JavaUtilArrayList;
        if (localObject == null) {
          break label463;
        }
        localObject = ((ArrayList)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!PhoneContactSelectActivity.a((String)((Iterator)localObject).next(), paramViewGroup.mobileNo));
      }
    }
    label276:
    label463:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        label222:
        if ((AppSetting.b) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
        {
          if (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label347;
          }
          localView.setContentDescription(paramViewGroup.name + "已选中,双击取消");
        }
        paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramViewGroup;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactSelectActivity.a()) {
          break label378;
        }
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      for (;;)
      {
        paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return localView;
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        break;
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        break label222;
        label347:
        localView.setContentDescription(paramViewGroup.name + "未选中,双击选中");
        break label276;
        label378:
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberPhoneContactTabView.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131436015), new Object[] { paramViewGroup.toLowerCase() }));
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygd
 * JD-Core Version:    0.7.0.1
 */