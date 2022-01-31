package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import clp;
import clq;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  private int jdField_a_of_type_Int = -2147483648;
  private clp jdField_a_of_type_Clp;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private int b;
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131298767));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131298768));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    Object localObject1 = (ContactFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    String str;
    if ((localObject2 != null) && (localObject1 != null))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      Object localObject3 = ((ContactFacade)localObject1).a(String.valueOf(this.b));
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Entity)((Iterator)localObject3).next();
          if (localObject4 != null)
          {
            localObject4 = (Friends)localObject4;
            if (((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j) || (!((Friends)localObject4).uin.equals(str))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(((Friends)localObject4).uin))) {
              this.jdField_a_of_type_JavaUtilList.add(localObject4);
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j) && (this.b == 0))
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
        ((Friends)localObject1).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
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
    setContentView(2130903624);
    g();
    this.jdField_a_of_type_Clp = new clp(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Clp);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.q() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Clp.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
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
      i = this.jdField_a_of_type_Clp.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.k());
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.b = paramBundle.getInt("friend_team_id");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363994), this.jdField_a_of_type_JavaLangString);
    if (this.b != this.jdField_a_of_type_Int)
    {
      h();
      this.jdField_a_of_type_Clp.a();
      this.jdField_a_of_type_Int = this.b;
    }
    while (this.jdField_a_of_type_Clp == null) {
      return;
    }
    this.jdField_a_of_type_Clp.notifyDataSetChanged();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Clp != null) {
      this.jdField_a_of_type_Clp.b();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Clp.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    clq localclq = (clq)paramView.getTag();
    if ((localclq != null) && (localclq.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localclq.c != null) && (localclq.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localclq.jdField_a_of_type_JavaLangString, localclq.c.getText().toString(), 0, "-1");
      localclq.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (localclq.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        paramView.setContentDescription(localclq.c.getText().toString() + "已选中");
      }
    }
    else
    {
      return;
    }
    paramView.setContentDescription(localclq.c.getText().toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendListInnerFrame
 * JD-Core Version:    0.7.0.1
 */