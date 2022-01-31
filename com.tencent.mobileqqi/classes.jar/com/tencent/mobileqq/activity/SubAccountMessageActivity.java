package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.adapter.SubAccountMessageAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountMessageData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.OverScrollViewListener;
import drg;
import drh;
import dri;
import drj;
import drk;
import drl;
import drm;
import drn;
import dro;
import drp;
import drq;
import drs;
import drv;
import drw;
import drx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;

public class SubAccountMessageActivity
  extends SubAccountBaseActivity
  implements DragRelativeLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1011;
  private static final boolean jdField_c_of_type_Boolean = true;
  private Handler jdField_a_of_type_AndroidOsHandler = new drg(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dro(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DragRelativeLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
  private SubAccountMessageAdapter jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new drp(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new drq(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new drs(this);
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new drv(this);
  private String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountMessageActivity";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private final int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final int jdField_c_of_type_Int;
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  public SubAccountMessageActivity()
  {
    this.c = 1;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    int i = 2131562539;
    String str = getString(2131562518);
    switch (paramInt)
    {
    }
    for (paramInt = i;; paramInt = 2131563155)
    {
      a(str, paramString1, 2131561746, paramInt, new drx(this, paramString2), new drh(this));
      return;
      str = getString(2131563202);
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new dri(this), paramLong);
  }
  
  private void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 2131561746, 2131562539, new drw(this), null);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (paramBoolean)) {
      SubAccountDataControll.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    if (paramBoolean1)
    {
      localActionSheet.a(2131561668);
      localActionSheet.a(2131562539, 3);
    }
    for (;;)
    {
      localActionSheet.d(2131561746);
      localActionSheet.a(new drk(this, localActionSheet, paramBoolean1, paramBoolean2));
      localActionSheet.show();
      return;
      if (paramBoolean2)
      {
        localActionSheet.a(2131561628);
        localActionSheet.a(2131561946, 3);
      }
    }
  }
  
  private boolean g()
  {
    if (!i()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      String str = ContactUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, true);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 4, "initData:set subaccount nickname=" + this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        }
      }
    }
    k();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter = new SubAccountMessageAdapter(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter);
    m();
    return true;
  }
  
  private void i()
  {
    setTitle(2131562836);
    h();
    Object localObject = this.p;
    ((ImageView)localObject).setVisibility(0);
    ((ImageView)localObject).setImageResource(2130838009);
    ((ImageView)localObject).setOnClickListener(new drn(this));
    ((ImageView)localObject).setContentDescription(getText(2131562407));
    localObject = LayoutInflater.from(a());
    View localView = ((LayoutInflater)localObject).inflate(2130904003, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131234559));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131234560));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131234561));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131234562));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131234557));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)((LayoutInflater)localObject).inflate(2130903323, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837729);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private boolean i()
  {
    Object localObject = SubAccountDataControll.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localObject != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = new SubAccountInfo();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.cookie = ((SubAccountInfo)localObject).cookie;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.isbind = ((SubAccountInfo)localObject).isbind;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.lasttime = ((SubAccountInfo)localObject).lasttime;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorMsg = ((SubAccountInfo)localObject).serverErrorMsg;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.serverErrorType = ((SubAccountInfo)localObject).serverErrorType;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname = ((SubAccountInfo)localObject).subname;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin = ((SubAccountInfo)localObject).subuin;
      this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.trunkuin = ((SubAccountInfo)localObject).trunkuin;
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, "refreshAccountInfo: set subaccount nickname=" + this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return true;
        localObject = ContactUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "subaccount refreshAccountInfo but mSubAccountInfo is null??");
    }
    a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563222));
    finish();
    return false;
  }
  
  private void j()
  {
    Object localObject = getAppRuntime().getApplication().getAllAccounts();
    String str = SubAccountAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (SimpleAccount)localIterator.next();
      } while (!((SimpleAccount)localObject).getUin().equalsIgnoreCase(str));
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.switchAccount((SimpleAccount)localObject);
      }
      return;
      e();
      localObject = null;
    }
  }
  
  private void k()
  {
    if (SubAccountDataControll.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface) > 0)
    {
      this.f = true;
      return;
    }
    this.f = false;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
      SubAccountDataControll.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshMessageList:refreshMessageList");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)))
    {
      localObject = SubAccountDataControll.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label138;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSubAccountMessageAdapter.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshMessageList:refreshMessageList.finish");
      }
      return;
      label138:
      localObject = new SubAccountMessageData();
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(a().getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("fromsubaccount", true);
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
    }
    localIntent.putExtra("befault_uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    a().startActivityForResult(localIntent, 1011);
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dologoutWhenSwitch:onlogout");
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(a().getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("fromsubaccount", true);
    localIntent.putExtra("logout_intent", true);
    startActivity(localIntent);
    finish();
  }
  
  private void p()
  {
    boolean bool = SubAccountAssistantImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (bool) {}
    for (String str = getResources().getString(2131563121);; str = getResources().getString(2131562893))
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.a(str, 1);
      localActionSheet.a(getResources().getString(2131561833), 1);
      localActionSheet.a(getResources().getString(2131563128), 3);
      localActionSheet.d(2131561746);
      localActionSheet.a(new drj(this, localActionSheet, bool));
      localActionSheet.show();
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout) {}
  
  protected boolean b()
  {
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onBackEvent: this is subaccountmessageactivity");
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(AccountManageActivity.class);
      if (localObject != null) {
        ((Handler)localObject).sendEmptyMessage(9875);
      }
      jdField_a_of_type_Boolean = false;
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(1134023, null).sendToTarget();
    }
    if (this.f) {
      ((MessageHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, null);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.O, 7000);
    l();
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).setFlags(67108864);
    startActivity((Intent)localObject);
    return super.b();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904001);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = DragRelativeLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, false);
    i();
    if (!g()) {
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    SubAccountAssistantForward.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantForward.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantForward.e(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantForward.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    m();
  }
  
  public void h()
  {
    if (this.k != null)
    {
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject == null) {
        break label131;
      }
      int j = ((QQMessageFacade)localObject).f();
      int i = 0;
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        i = ((ConversationFacade)localObject).a(AppConstants.O, 7000);
      }
      i = j - i;
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        this.k.setText(getString(2131561807) + "(" + (String)localObject + ")");
      }
    }
    else
    {
      return;
    }
    this.k.setText(getString(2131561807));
    return;
    label131:
    this.k.setText(getString(2131561807));
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    e();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    l();
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.u();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(String.valueOf(9992L), 7000) != null) {
        SubAccountAssistantImpl.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis() / 1000L);
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.saveLastAccountState();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
    }
    finish();
  }
  
  protected void onAccoutChangeFailed()
  {
    e();
    n();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    e();
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onLogout:zsw onLogout");
      }
      o();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      if (!((MessageRecord)paramObject).isSendFromLocal()) {
        runOnUiThread(new drl(this));
      }
    }
    while (!AppConstants.O.equals(String.valueOf(paramObject))) {
      return;
    }
    runOnUiThread(new drm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountMessageActivity
 * JD-Core Version:    0.7.0.1
 */