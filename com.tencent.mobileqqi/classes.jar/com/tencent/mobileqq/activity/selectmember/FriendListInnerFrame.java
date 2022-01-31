package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import eun;
import euo;
import eup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private static final int jdField_a_of_type_Int = 1;
  private static final int b = 2;
  private Handler jdField_a_of_type_AndroidOsHandler = new eun(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  private euo jdField_a_of_type_Euo;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private int c = -2147483648;
  private int d;
  
  public FriendListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131234428));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131234429));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131230734));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131361815);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903942, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131233084)).setVisibility(8);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    String str;
    if ((localObject2 != null) && (localObject1 != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      Object localObject3 = ((ContactFacade)localObject1).a(String.valueOf(this.d));
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Entity)((Iterator)localObject3).next();
          if (localObject4 != null)
          {
            localObject4 = (Friends)localObject4;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) || (!((Friends)localObject4).uin.equals(str))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(((Friends)localObject4).uin))) {
              this.jdField_a_of_type_JavaUtilList.add(localObject4);
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) && (this.d == 0))
      {
        localObject2 = ((FriendManager)localObject2).c();
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          break label361;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        do
        {
          while (!((Iterator)localObject3).hasNext())
          {
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = ((ContactFacade)localObject1).a(String.valueOf(((Groups)((Iterator)localObject2).next()).group_id));
            } while ((localObject3 == null) || (((List)localObject3).size() <= 0));
            localObject3 = ((List)localObject3).iterator();
          }
        } while (!((Friends)((Iterator)localObject3).next()).uin.equals(str));
      }
    }
    label361:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = str;
        ((Friends)localObject1).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
        ((Friends)localObject1).mCompareSpell = ChnToSpell.a(ContactSorter.b((Friends)localObject1), 1);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      return;
    }
  }
  
  public String a()
  {
    return "-1";
  }
  
  public List a()
  {
    return ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getChildAt(1)).a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903951);
    g();
    this.jdField_a_of_type_Euo = new euo(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Euo);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Euo.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Euo.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.d = paramBundle.getInt("friend_team_id");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_JavaLangString = LocaleString.b(a(), this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangString = LocaleString.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131561693), this.jdField_a_of_type_JavaLangString);
    if (this.d != this.c)
    {
      h();
      this.jdField_a_of_type_Euo.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      this.c = this.d;
    }
    while (this.jdField_a_of_type_Euo == null) {
      return;
    }
    this.jdField_a_of_type_Euo.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Euo != null) {
      this.jdField_a_of_type_Euo.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Euo.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    eup localeup = (eup)paramView.getTag();
    if ((localeup != null) && (localeup.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localeup.c != null) && (localeup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localeup.jdField_a_of_type_JavaLangString, localeup.c.getText().toString(), 0, "-1");
      localeup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (localeup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramView.setContentDescription(localeup.c.getText().toString() + "已选中,双击取消");
      }
    }
    else
    {
      return;
    }
    paramView.setContentDescription(localeup.c.getText().toString() + "未选中,双击选中");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.g();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame
 * JD-Core Version:    0.7.0.1
 */