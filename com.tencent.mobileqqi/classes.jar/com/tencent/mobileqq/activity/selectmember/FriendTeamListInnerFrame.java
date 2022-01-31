package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.ContactSearchableFriend;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.XListView;
import eqc;
import eqd;
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
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public XListView a;
  private eqd jdField_a_of_type_Eqd;
  public List a;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
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
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(1);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Entity localEntity = (Entity)paramArrayList.next();
      if (((Groups)localEntity).group_id != -1006) {
        localArrayList.add(localEntity);
      }
    }
    return localArrayList;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232612));
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2130903952, null);
    localLinearLayout.findViewById(2131233086).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localLinearLayout.findViewById(2131234423));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localLinearLayout.findViewById(2131234424));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localLinearLayout.findViewById(2131234426));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131234421));
    this.c = ((Button)localLinearLayout.findViewById(2131234422));
    TextView localTextView = (TextView)localLinearLayout.findViewById(2131234420);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("人脉圈,按钮");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription("通讯录,按钮");
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription("群,按钮");
      this.c.setContentDescription("讨论组,按钮");
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelector(2131361815);
      this.jdField_a_of_type_ComTencentWidgetXListView.a(localLinearLayout);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localLinearLayout.findViewById(2131233087));
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setInputType(0);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new eqc(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localLinearLayout.findViewById(2131234419));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131562264));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localTextView.setVisibility(8);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        label355:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) {
          break label423;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        label373:
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d) {
          break label472;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {
          break label483;
        }
        this.c.setEnabled(false);
        break;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        break label355;
        label423:
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("select_member_contacts_flag", 0) == 1)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          break label373;
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setEnabled(false);
        break label373;
        label472:
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      label483:
      this.c.setOnClickListener(this);
    }
  }
  
  private void h()
  {
    Object localObject = new Groups();
    ((Groups)localObject).group_id = -1;
    ((Groups)localObject).group_name = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131562726);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject != null) {}
    for (localObject = a(((FriendManager)localObject).c());; localObject = null)
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
    int i = 1;
    Object localObject1;
    Object localObject2;
    boolean bool;
    Object localObject3;
    if ((this.jdField_b_of_type_JavaUtilList == null) && ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8) != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f) {
        break label244;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k) {
        break label239;
      }
      bool = true;
      localObject1 = SearchResultDialog.a((Context)localObject1, (QQAppInterface)localObject2, 42949672960L, 0, bool, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.k)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (!((ContactSearchableFriend)((Iterator)localObject2).next()).a().uin.equals(localObject3));
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        ((Friends)localObject2).groupid = 0;
        ((Friends)localObject2).name = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e();
        ((List)localObject1).add(new ContactSearchableFriend(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject2, getResources().getString(2131559021), 131072L, 42949672960L));
      }
      this.jdField_b_of_type_JavaUtilList = ((List)localObject1);
      return this.jdField_b_of_type_JavaUtilList;
      label239:
      bool = false;
      break;
      label244:
      localObject3 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 42949672960L, 0, true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e) {}
      for (localObject1 = SearchResultDialog.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 34359738368L, 0, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_JavaUtilArrayList);; localObject1 = null)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.c) || (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_b_of_type_Boolean)) {}
        for (localObject2 = ((CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).a();; localObject2 = null)
        {
          if (localObject3 != null) {}
          for (int j = ((List)localObject3).size() + 0;; j = 0)
          {
            i = j;
            if (localObject1 != null) {
              i = j + ((List)localObject1).size();
            }
            if (0 != 0) {
              throw new NullPointerException();
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
            if (0 != 0) {
              this.jdField_b_of_type_JavaUtilList.addAll(null);
            }
            if (localObject2 == null) {
              break;
            }
            this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject2);
            break;
          }
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
    setContentView(2130903975);
    g();
    h();
    this.jdField_a_of_type_Eqd = new eqd(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Eqd);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(false, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131561750), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.F);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Eqd.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetRelativeLayout)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "0", "", "", "");
    }
    do
    {
      return;
      if (paramView == this.jdField_b_of_type_AndroidWidgetRelativeLayout)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
        return;
      }
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
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, CreateFaceToFaceDiscussionActivity.class));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A7", "0X80041A7", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */