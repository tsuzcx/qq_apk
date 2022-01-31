package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ContactFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import daj;
import dak;
import dal;
import dam;
import dan;
import dao;
import dap;
import daq;
import dar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicAccountActivity
  extends BaseActivity
  implements View.OnClickListener, OverScrollViewListener
{
  static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "PublicAccountActivity";
  static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "last_public_account_activity";
  static final boolean jdField_b_of_type_Boolean = true;
  static final int jdField_c_of_type_Int = 3;
  static final int d = 1200;
  static final int e = 1000;
  static final int f = 800;
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dan(this);
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new dao(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  dap jdField_a_of_type_Dap;
  private daq jdField_a_of_type_Daq = new daq(this);
  public final ArrayList a;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private View jdField_c_of_type_AndroidViewView;
  
  public PublicAccountActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_public_account_activity", 0).getLong("last_public_account_activity", 0L);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog != null) {
      return;
    }
    Contacts.a += 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = new daj(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setCanceledOnTouchOutside(true);
    paramInt = d();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -paramInt);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -paramInt, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new dak(this));
    localTranslateAnimation2.setAnimationListener(new dal(this, paramInt));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.setOnDismissListener(new dam(this, paramInt, localTranslateAnimation2));
    this.jdField_b_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, PublicAccountActivity.class));
  }
  
  private void a(PublicAccountInfo paramPublicAccountInfo)
  {
    if (paramPublicAccountInfo.extendType == 2) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramPublicAccountInfo.getUin(), "1", "", "");
    }
    for (Object localObject1 = new Intent(a(), ChatForEnterpriseActivity.class);; localObject1 = new Intent(a(), PublicAccountChatActivity.class))
    {
      ((Intent)localObject1).putExtra("uin", paramPublicAccountInfo.getUin());
      ((Intent)localObject1).putExtra("uintype", 1008);
      ((Intent)localObject1).putExtra("uinname", paramPublicAccountInfo.name);
      startActivity((Intent)localObject1);
      return;
      String str2 = paramPublicAccountInfo.getUin();
      Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str2, 1008);
      String str1 = "";
      localObject1 = str1;
      if (localObject2 != null)
      {
        localObject2 = XMLMessageUtils.a((MessageRecord)localObject2);
        localObject1 = str1;
        if (localObject2 != null) {
          localObject1 = Long.toString(((PAMessage)localObject2).mMsgId);
        }
      }
      PublicAccountHandler.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str2, "Pb_account_lifeservice", "mp_msg_sys_4", "contacts_aio", (String)localObject1);
    }
  }
  
  private boolean c()
  {
    if (NetworkUtil.f(this))
    {
      ((PublicAccountHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232072));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130837729);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this);
    View localView = localLayoutInflater.inflate(2130903944, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    localView.findViewById(2131233086).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131233087);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    localView = localLayoutInflater.inflate(2130903134, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903325, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232073);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131232075).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_a_of_type_AndroidViewView);
    a(true);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131231116));
    this.c = ((RelativeLayout)findViewById(2131231374));
    this.c.setVisibility(8);
    Object localObject = (TextView)findViewById(2131231376);
    ((TextView)localObject).setText(2131562981);
    setTitle(2131562981);
    ((TextView)localObject).setContentDescription(getResources().getString(2131562981));
    localObject = (TextView)findViewById(2131231456);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setText(2131561870);
    IphoneTitleBarActivity.b((View)localObject);
    ((TextView)findViewById(2131231457)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231380));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562332);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetTextView);
    localObject = (ImageView)findViewById(2131231461);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setImageResource(2130840117);
    ((ImageView)localObject).setOnClickListener(this);
    ((ImageView)localObject).setContentDescription(getResources().getString(2131562331));
    IphoneTitleBarActivity.b((View)localObject);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.a(this, paramInt1, getResources().getString(paramInt2), 0).b(d());
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(d());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      Object localObject = (ContactFacade)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
      if (localObject != null)
      {
        localObject = ((ContactFacade)localObject).a(String.valueOf(-1006));
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Entity localEntity = (Entity)((Iterator)localObject).next();
            this.jdField_a_of_type_JavaUtilArrayList.add((PublicAccountInfo)localEntity);
          }
        }
      }
    }
    if (this.jdField_a_of_type_Dap == null) {
      this.jdField_a_of_type_Dap = new dap(this, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    this.jdField_a_of_type_Dap.notifyDataSetChanged();
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      this.jdField_a_of_type_Daq.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("last_public_account_activity", 0).edit().putLong("last_public_account_activity", l).commit();
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903322);
    j(2130837729);
    e();
    d();
    a(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_Daq.removeCallbacksAndMessages(null);
    b(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Dap.b();
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      onBackPressed();
      return;
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Clk_lifeservice", 49, 0, "", "", "", "");
      AddContactsActivity.b(this);
      return;
      a(3);
      return;
      paramView = (dar)paramView.getTag();
    } while (paramView == null);
    a(paramView.a);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountActivity", 2, "onOptionsItemSelected");
    }
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.performClick();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountActivity", 2, "onPrepareOptionsMenu");
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView.getText() != null))
    {
      MenuItem localMenuItem = paramMenu.findItem(this.jdField_a_of_type_AndroidWidgetTextView.getId());
      if (localMenuItem == null) {
        break label80;
      }
      localMenuItem.setTitle(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
    for (;;)
    {
      return super.onPrepareOptionsMenu(paramMenu);
      label80:
      MenuItemCompat.setShowAsAction(paramMenu.add(0, this.jdField_a_of_type_AndroidWidgetTextView.getId(), 0, this.jdField_a_of_type_AndroidWidgetTextView.getText()), 1);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountActivity
 * JD-Core Version:    0.7.0.1
 */