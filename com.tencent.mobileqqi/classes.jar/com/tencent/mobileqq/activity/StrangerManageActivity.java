package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import dkq;
import dkr;
import dks;
import dkt;
import dku;
import dkv;
import dkw;
import dkx;
import dky;
import dkz;
import dla;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class StrangerManageActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AbsListView.OnScrollListener, ActionSheet.OnButtonClickListener, OverScrollViewListener
{
  public static final int a = 1;
  public static final String a = "uin";
  public static final int b = 500;
  public static final String b = "StrangerManageActivity";
  public Handler a;
  public View.OnClickListener a;
  public Button a;
  public LinearLayout a;
  public StrangerManageActivity.StrangeManagerListAdapter a;
  private FriendListObserver a;
  public StrangerObserver a;
  public PullRefreshHeader a;
  public QQProgressDialog a;
  public ActionSheet a;
  public XListView a;
  public Runnable a;
  public ArrayList a;
  public HashSet a;
  public boolean a;
  public View.OnClickListener b;
  public ArrayList b;
  public boolean b;
  public View.OnClickListener c;
  public String c;
  public boolean c;
  public View.OnClickListener d;
  private boolean d;
  
  public StrangerManageActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new dkr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dkt(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dku(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new dkv(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new dkw(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new dkx(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new dky(this));
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangRunnable = new dkz(this);
  }
  
  public static List a(String paramString, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    label93:
    for (;;)
    {
      return paramList;
      Collections.sort(paramList, new dks());
      int i = paramList.size() - 1;
      if (i >= 0) {
        if (!TextUtils.equals(paramString, ((Stranger)paramList.get(i)).uin)) {}
      }
      for (;;)
      {
        if (-1 == i) {
          break label93;
        }
        paramList.add(0, (Stranger)paramList.remove(i));
        return paramList;
        i -= 1;
        break;
        i = -1;
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, StrangerManageActivity.class));
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, StrangerManageActivity.class);
    localIntent.putExtra("uin", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b();
      }
      return;
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Manage_stranger_relieve", 0, 0, "", "", "", "");
      paramView = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Stranger localStranger = (Stranger)localIterator.next();
        if (localStranger.uiSelected) {
          paramView.add(Long.valueOf(localStranger.uin));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("StrangerManageActivity", 2, "deleteStranger onClick list = " + paramView.size());
      }
      ((StrangerHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(28)).b(paramView);
      a(2131562650);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0) {
      d();
    }
    for (;;)
    {
      return;
      int i = paramAbsListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        dkq localdkq = (dkq)paramAbsListView.getChildAt(paramInt).getTag();
        if ((localdkq != null) && (localdkq.jdField_a_of_type_JavaLangString != null) && (localdkq.jdField_a_of_type_JavaLangString.length() > 0)) {
          a(localdkq);
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(dkq paramdkq)
  {
    if (paramdkq == null) {}
    while ((paramdkq.jdField_a_of_type_Long * 1000L > System.currentTimeMillis()) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramdkq.jdField_a_of_type_JavaLangString))) {
      return;
    }
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(Long.valueOf(paramdkq.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaUtilHashSet.add(paramdkq.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    StrangerHandler localStrangerHandler = (StrangerHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
    this.jdField_b_of_type_Boolean = true;
    localStrangerHandler.a(paramBoolean);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    paramView = (StrangerHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
    this.jdField_b_of_type_Boolean = true;
    paramView.a(true);
    return true;
  }
  
  protected String a_()
  {
    return getString(2131562348);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.notifyDataSetChanged();
    }
    if (paramBoolean)
    {
      c(2131561746, new dla(this));
      a(2131561641, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(null);
      return;
    }
    e();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 0;
    boolean bool = true;
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Stranger)((Iterator)localObject).next()).uiSelected);
    }
    for (;;)
    {
      if (i != 0) {
        a(2131561937, this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
      return;
      a(2131561642, this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 1;
      if (((Iterator)localObject).hasNext())
      {
        if (!((Stranger)((Iterator)localObject).next()).uiSelected) {
          break label144;
        }
        i = 0;
      }
      label144:
      for (;;)
      {
        break;
        localObject = this.jdField_a_of_type_AndroidWidgetButton;
        if (i == 0) {}
        for (paramBoolean = bool;; paramBoolean = false)
        {
          ((Button)localObject).setEnabled(paramBoolean);
          return;
        }
      }
      i = 1;
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      this.jdField_a_of_type_JavaUtilHashSet.remove(String.valueOf(l).intern());
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public void e()
  {
    c(2131562001, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    Object localObject = this.m;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject).setEnabled(bool);
      this.k.setVisibility(8);
      this.k = ((TextView)findViewById(2131231456));
      b(this.k);
      this.k.setVisibility(0);
      this.k.setOnClickListener(this.f);
      c(getIntent());
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Stranger)((Iterator)localObject).next()).uiSelected = false;
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    paramView.getId();
    paramView = (dkq)paramView.getTag();
    int i;
    if (paramView != null)
    {
      i = paramView.jdField_a_of_type_Int;
      if (i != -1) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramView = paramView.b;
      localObject = (Stranger)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (!((Stranger)localObject).uiSelected) {
        bool = true;
      }
      ((Stranger)localObject).uiSelected = bool;
      if (((Stranger)localObject).uiSelected) {
        paramView.setImageResource(2130838085);
      }
      for (;;)
      {
        c(((Stranger)localObject).uiSelected);
        return;
        paramView.setImageResource(2130838084);
      }
    }
    paramView = (Stranger)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    Object localObject = new ProfileActivity.AllInOne(paramView.uin, 70);
    ((ProfileActivity.AllInOne)localObject).g = paramView.name;
    ((ProfileActivity.AllInOne)localObject).b = paramView.age;
    ((ProfileActivity.AllInOne)localObject).a = paramView.gender;
    ((ProfileActivity.AllInOne)localObject).e = 101;
    ((ProfileActivity.AllInOne)localObject).f = 9;
    ProfileActivity.a(this, (ProfileActivity.AllInOne)localObject);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Manage_stranger_prof", 0, 0, "", "", "", "");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903447);
    super.setTitle(2131562348);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232617));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232619));
    paramBundle = getLayoutInflater().inflate(2130903448, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter = new StrangerManageActivity.StrangeManagerListAdapter(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(a()).inflate(2130903325, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232618));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    c(2131562001, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.m.setEnabled(false);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("uin");
    ((StrangerHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(28)).a();
    a(false);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b();
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityStrangerManageActivity$StrangeManagerListAdapter.b();
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.StrangerManageActivity
 * JD-Core Version:    0.7.0.1
 */