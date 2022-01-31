package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cls;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  public static final int a = -1;
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private cls jdField_a_of_type_Cls;
  public XListView a;
  public List a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  List jdField_b_of_type_JavaUtilList;
  private Button jdField_c_of_type_AndroidWidgetButton;
  
  public FriendTeamListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297776));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903623, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localLinearLayout.findViewById(2131298763));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131298764));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131298765));
    this.c = ((Button)localLinearLayout.findViewById(2131298766));
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131298762);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("通讯录");
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("群");
      this.c.setContentDescription("讨论组");
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131427345);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localLinearLayout);
      this.jdField_a_of_type_AndroidWidgetTextView = ((Button)localLinearLayout.findViewById(2131298760));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363772));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        localLinearLayout.findViewById(2131298761).setVisibility(8);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        label257:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) {
          break label345;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d) {
          break label356;
        }
        this.c.setEnabled(false);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("select_member_contacts_flag", 0) == 1)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          break label257;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        break label257;
        label345:
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      label356:
      this.c.setOnClickListener(this);
    }
  }
  
  private void h()
  {
    Object localObject = new Groups();
    ((Groups)localObject).group_id = -1;
    ((Groups)localObject).group_name = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363990);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null) {}
    for (localObject = ((FriendManager)localObject).c();; localObject = null)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      }
      return;
    }
  }
  
  public String a()
  {
    return null;
  }
  
  public List a()
  {
    Object localObject2 = null;
    int i = 1;
    Object localObject1;
    boolean bool;
    Object localObject3;
    if ((this.jdField_b_of_type_JavaUtilList == null) && ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8) != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {
        break label238;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j) {
        break label233;
      }
      bool = true;
      localObject1 = SearchResultDialog.a((Context)localObject1, (QQAppInterface)localObject2, 34359738368L, 0, bool, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject3 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!((ContactSearchableFriend)((Iterator)localObject3).next()).a().uin.equals(localObject2));
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((Friends)localObject2).groupid = 0;
        ((Friends)localObject2).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        ((List)localObject1).add(new ContactSearchableFriend(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject2, "我的好友", 0L, 34359738368L));
      }
      this.jdField_b_of_type_JavaUtilList = ((List)localObject1);
      return this.jdField_b_of_type_JavaUtilList;
      label233:
      bool = false;
      break;
      label238:
      localObject3 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 34359738368L, 0, true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d) {}
      for (localObject1 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 25769803776L, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);; localObject1 = null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Boolean) {
          localObject2 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 30064771072L);
        }
        if (localObject3 != null) {}
        for (int j = ((List)localObject3).size() + 0;; j = 0)
        {
          i = j;
          if (localObject1 != null) {
            i = j + ((List)localObject1).size();
          }
          j = i;
          if (localObject2 != null) {
            j = i + ((List)localObject2).size();
          }
          if (j <= 0) {
            break;
          }
          this.jdField_b_of_type_JavaUtilList = new ArrayList(j);
          if (localObject3 != null) {
            this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject3);
          }
          if (localObject1 != null) {
            this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject1);
          }
          if (localObject2 == null) {
            break;
          }
          this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject2);
          break;
        }
      }
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903647);
    g();
    h();
    this.jdField_a_of_type_Cls = new cls(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cls);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131363993), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.G);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Cls.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
    }
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "2", "", "", "");
        return;
      }
      if (paramView == this.c)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(4);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "3", "", "", "");
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetTextView);
    a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A7", "0X80041A7", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */