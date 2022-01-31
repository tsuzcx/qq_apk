package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cko;
import ckp;
import ckq;
import ckr;
import cks;
import ckt;
import cku;
import ckv;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter.ViewTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Contacts
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, RadioGroup.OnCheckedChangeListener, CommonLoadingView.OnFirstDrawListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, OverScrollViewListener
{
  public static final int A = 15;
  public static final int B = 16;
  private static final int C = 1400;
  private static final int D = 9527;
  private static final int E = 9528;
  private static final int F = 1;
  private static final int G = 2;
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "last_buddy_list_refresh_time";
  public static int b = 0;
  private static final String jdField_b_of_type_JavaLangString = "Contacts";
  public static int c = 0;
  public static int d = 0;
  static final int f = 1;
  static final int g = 2;
  static final int h = 3;
  static final int i = 4;
  static final int j = 800;
  static final int k = 1000;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static final int p = 4;
  public static final int q = 5;
  public static final int r = 6;
  public static final int s = 7;
  public static final int t = 8;
  public static final int u = 9;
  public static final int v = 10;
  public static final int w = 11;
  public static final int x = 12;
  public static final int y = 13;
  public static final int z = 14;
  public Dialog a;
  public Handler a;
  public View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private cks jdField_a_of_type_Cks = new cks(this, null);
  private ckt jdField_a_of_type_Ckt = new ckt(this, null);
  private cku jdField_a_of_type_Cku = new cku(this, null);
  private ckv jdField_a_of_type_Ckv = new ckv(this, null);
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private AllBuddyListAdapter jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter;
  public BuddyListAdapter a;
  public FPSPinnedHeaderExpandableListView a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public PullRefreshHeader a;
  private RedDotTextView jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public boolean a;
  public View b;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public PullRefreshHeader b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  public int e;
  private boolean e;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
  }
  
  public Contacts()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Boolean = false;
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void a(PublicAccountInfo paramPublicAccountInfo)
  {
    PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountInfo.getUin(), "Pb_account_lifeservice", "mp_msg_sys_4", "contacts_aio");
    if (paramPublicAccountInfo.extendType == 2) {}
    for (Intent localIntent = new Intent(a(), ChatForEnterpriseActivity.class);; localIntent = new Intent(a(), PublicAccountChatActivity.class))
    {
      localIntent.putExtra("uin", String.valueOf(paramPublicAccountInfo.uin));
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramPublicAccountInfo.name);
      a(localIntent);
      return;
    }
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView) {
      if (paramListView.q() > 0) {
        super.a(new cko(this));
      }
    }
    while (paramListView.q() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent();
    if (AppConstants.P.equals(paramString1))
    {
      paramString1 = new FileManagerReporter.fileAssistantReportData();
      paramString1.jdField_a_of_type_JavaLangString = "file_assistant_in";
      paramString1.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1);
      localIntent.setClass(a(), LiteActivity.class);
    }
    for (;;)
    {
      a(localIntent);
      return;
      localIntent.setClass(a(), ChatActivity.class);
      Friends localFriends = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString1 + "");
      if (localFriends != null)
      {
        localIntent.putExtra("cSpecialFlag", localFriends.cSpecialFlag);
        if (localFriends.cSpecialFlag == 1) {
          localIntent.setClass(a(), ChatForEnterpriseActivity.class);
        }
      }
      localIntent.putExtra("uin", paramString1);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt) > 0) {
        localIntent.putExtra("has_new_message", true);
      }
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("entrance", 1);
    }
  }
  
  private boolean a(Object paramObject)
  {
    if ((paramObject instanceof Friends))
    {
      localFriends = (Friends)paramObject;
      if ((localFriends.remark == null) || (localFriends.remark == ""))
      {
        paramObject = localFriends.name;
        if (paramObject != null)
        {
          localObject = paramObject;
          if (paramObject != "") {}
        }
        else
        {
          localObject = String.valueOf(localFriends.uin);
        }
        a(String.valueOf(localFriends.uin), 0, (String)localObject);
      }
    }
    while (!(paramObject instanceof PublicAccountInfo)) {
      for (;;)
      {
        Friends localFriends;
        Object localObject;
        return false;
        paramObject = localFriends.remark;
      }
    }
    paramObject = (PublicAccountInfo)paramObject;
    if (PublicAccountInfo.isLooker(paramObject))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Clk_lifeservice", 49, 0, "", "", "", "");
      AddContactsActivity.b(a());
    }
    for (;;)
    {
      return true;
      a(paramObject);
    }
  }
  
  private boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean);
    }
    if (NetworkUtil.f(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true);
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).a();
      }
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("Contacts", 2, "updateBuddyList succeeded");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList falied");
    }
    return false;
  }
  
  private void h()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    int i2;
    if ((localPhoneContactManager != null) && (localPhoneContactManager.f()))
    {
      i2 = 0;
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ckp(this);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
    }
    for (int i1 = i2;; i1 = 8)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(i1);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(i1);
      }
      return;
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131231116));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131231374));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131231375));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)a(2131231380));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription("进入添加界面");
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131561588);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)a(2131231377));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131231376));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    IphoneTitleBarActivity.b(this.jdField_b_of_type_AndroidWidgetTextView);
    IphoneTitleBarActivity.b(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter = new BuddyListAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView, this);
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter = new AllBuddyListAdapter(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter);
    }
  }
  
  private void l()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.r();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a().getCount();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(0) == this.jdField_c_of_type_AndroidViewView) && (i1 == i2 - 1))
    {
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, (int)DisplayUtils.a(a(), 25.0F), 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
  }
  
  private void m()
  {
    if (!SettingCloneUtil.readValue(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_all_contacts_key", false)) {}
    for (int i1 = 2131231378;; i1 = 2131231379)
    {
      this.jdField_a_of_type_AndroidWidgetRadioGroup.check(i1);
      return;
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return LayoutInflater.from(a()).inflate(2130903138, null);
  }
  
  protected String a()
  {
    return a().getString(2131561870);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_e_of_type_Int > 0) {}
    do
    {
      return;
      this.jdField_e_of_type_Int = (a().d() - (int)DisplayUtils.a(a(), 5.0F));
      i();
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)a(2131231370));
      this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
      if (this.jdField_a_of_type_AndroidViewViewStub == null)
      {
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131231381));
        this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
      }
    } while (this.jdField_b_of_type_AndroidViewViewStub != null);
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)a(2131231382));
    this.jdField_b_of_type_AndroidViewViewStub.setOnInflateListener(this);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_AndroidAppDialog = new ckq(this, a(), 2131624528, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramInt);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new ckr(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      p();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.k();
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onNotCompleteVisable");
    }
    ((PullRefreshHeader)paramView).c(a());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i1 = 9527;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9527);
    }
    while (paramLong == 0L)
    {
      b(paramBoolean);
      return;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(9527)) {
        return;
      }
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (;;)
    {
      localHandler.sendEmptyMessageDelayed(i1, paramLong);
      return;
      i1 = 4;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    l();
  }
  
  public void a(String paramString)
  {
    char c1 = paramString.charAt(0);
    if ((!paramString.equals("$")) && (c1 != '+'))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.a(c1);
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i1 + 3);
      }
      return;
    }
    if (c1 == '+')
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a(1400L, true);
    h();
    m();
    if (paramBoolean) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (byte)1);
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewCompleteVisableAndReleased");
    }
    ((PullRefreshHeader)paramView).a(a());
    paramView = (Contacts.OverScrollViewTag)paramView.getTag();
    if (!c())
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      localMessage.obj = paramListView;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      paramView.jdField_a_of_type_Boolean = false;
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() != 2131231378) {
        break label139;
      }
    }
    label139:
    for (paramInt = 51;; paramInt = 52)
    {
      ReportController.b(paramView, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", paramInt, 0, "", "", "", "");
      return true;
      paramView.jdField_a_of_type_Boolean = true;
      break;
    }
  }
  
  public boolean a(Menu paramMenu)
  {
    paramMenu.clear();
    Object localObject = a();
    if ((localObject != null) && ((localObject instanceof SplashActivity))) {}
    for (boolean bool = ((SplashActivity)localObject).c();; bool = false)
    {
      localObject = paramMenu.add(0, 1, 0, a(2131561588));
      if (bool)
      {
        i1 = 2130837617;
        ((MenuItem)localObject).setIcon(i1);
        MenuItemCompat.setShowAsAction((MenuItem)localObject, 2);
        paramMenu = paramMenu.add(0, 2, 0, a().getString(2131562830));
        if (!bool) {
          break label125;
        }
      }
      label125:
      for (int i1 = 2130839695;; i1 = 2130839692)
      {
        paramMenu.setIcon(i1);
        MenuItemCompat.setShowAsAction(paramMenu, 2);
        return true;
        i1 = 2130837616;
        break;
      }
    }
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return true;
      AddContactsActivity.a(a());
      continue;
      a(0);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewCompleteVisable");
    }
    ((PullRefreshHeader)paramView).b(a());
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JustGo", 2, "<<--doRefreshBuddyList");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
    {
      if (!paramBoolean) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter != null)
      {
        if (!paramBoolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.notifyDataSetChanged();
      }
      return;
      label53:
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.a();
  }
  
  protected void c()
  {
    super.c();
    if (!this.jdField_e_of_type_Boolean) {}
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId();
      if (i1 == 2131231378)
      {
        int i2 = this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.getGroupCount();
        i1 = 0;
        while (i1 < i2)
        {
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.d(i1);
          i1 += 1;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
        return;
      }
      if (i1 == 2131231379)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Contacts", 2, "onFrameTabClick: " + i1);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "onViewNotCompleteVisableAndReleased");
    }
  }
  
  protected void d()
  {
    super.d();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.a();
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Ckt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Cks);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Cku);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_Ckv);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Ckt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Cks);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Cku);
    Object localObject = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    if (localObject != null)
    {
      ((StatusManager)localObject).b(this.jdField_a_of_type_Ckv);
      ((StatusManager)localObject).a(this.jdField_a_of_type_Ckv);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
      return;
    }
    localObject = BaseApplication.getContext().getSharedPreferences("share", 0).edit();
    ((SharedPreferences.Editor)localObject).putString("no_auto_reply" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
    if (Build.VERSION.SDK_INT < 9) {
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      k();
      return;
      try
      {
        SharedPreferences.Editor.class.getMethod("apply", new Class[0]).invoke(localObject, new Object[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          return true;
          this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.B();
          return true;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.B();
          return true;
          QQToast.a(a(), 1, 2131562097, 0).b(this.jdField_e_of_type_Int);
        } while (!(paramMessage.obj instanceof ListView));
        ((ListView)paramMessage.obj).B();
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      a(0L, false);
      return true;
    case 9527: 
      a(0L, true);
      c();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setVisibility(8);
    f();
    if (!this.jdField_e_of_type_Boolean) {
      a(true);
    }
    this.jdField_e_of_type_Boolean = true;
    return true;
  }
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131231379)
    {
      this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = (BuddyListAdapter.ViewTag)paramView.getTag();
      if ((paramView != null) && (paramView.a != null)) {
        a(paramView.a);
      }
      return;
    case 2131233085: 
      a(0);
      return;
    case 2131231419: 
      paramView = new Intent(a(), TroopActivity.class);
      paramView.putExtra("_key_mode", 0);
      a(paramView);
      return;
    case 2131231391: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Contacts_tab", "Clk_grp", 0, 0, "", "", "", "");
      paramView = new Intent(a(), TroopActivity.class);
      paramView.putExtra("_key_mode", 1);
      a(paramView);
      return;
    case 2131231375: 
      GroupManagerActivity.a(a());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
      return;
    }
    AddContactsActivity.a(a());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    int i1 = paramViewStub.getId();
    View localView1;
    Object localObject;
    if (i1 == 2131231381)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView = ((FPSPinnedHeaderExpandableListView)paramView.findViewById(2131231393));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setSelector(2131361815);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130837887));
      float f1 = a().getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setIndicatorBounds((int)(26.0F * f1), (int)(f1 * 50.0F));
      paramViewStub = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView;
      paramView = LayoutInflater.from(a());
      localView1 = paramView.inflate(2130903942, paramViewStub, false);
      localView1.findViewById(2131233084).setVisibility(8);
      localObject = (EditText)localView1.findViewById(2131233085);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnClickListener(this);
      ((EditText)localObject).setCursorVisible(false);
      localObject = new View(a());
      ((View)localObject).setBackgroundResource(2130837891);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      paramViewStub.a((View)localObject);
      localObject = paramView.inflate(2130903151, paramViewStub, false);
      paramViewStub.a((View)localObject);
      View localView2 = paramView.inflate(2130903142, paramViewStub, false);
      paramViewStub.a(localView2);
      ((View)localObject).setOnClickListener(this);
      localView2.setOnClickListener(this);
      paramView.inflate(2130903140, paramViewStub, false).setOnClickListener(this);
      localObject = (PullRefreshHeader)paramView.inflate(2130903323, paramViewStub, false);
      ((PullRefreshHeader)localObject).setTag(new Contacts.OverScrollViewTag());
      paramViewStub.setOverScrollHeader((View)localObject);
      paramViewStub.setOverScrollListener(this);
      if (i1 != 2131231381) {
        break label640;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localObject);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    for (;;)
    {
      paramViewStub.setContentBackground(2130838136);
      paramViewStub.b(paramView.inflate(2130903134, paramViewStub, false));
      paramViewStub.setDescendantFocusability(393216);
      k();
      h();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)paramView.findViewById(2131231384));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)paramView.findViewById(2131231385));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131230734));
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setTextView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
      paramViewStub = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      break;
      label640:
      this.jdField_c_of_type_AndroidViewView = localView1;
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, (int)DisplayUtils.a(a(), 25.0F), 0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localObject);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  public void x_()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9528);
  }
  
  public void y_()
  {
    long l1 = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Contacts
 * JD-Core Version:    0.7.0.1
 */