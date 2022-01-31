package com.tencent.mobileqq.activity;

import aga;
import agb;
import agc;
import agd;
import age;
import agf;
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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.main.CommonLoadingView;
import com.tencent.mobileqq.activity.main.CommonLoadingView.OnFirstDrawListener;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.adapter.BuddyListAdapter.ViewTag;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Contacts
  extends Frame
  implements Handler.Callback, View.OnClickListener, ViewStub.OnInflateListener, CommonLoadingView.OnFirstDrawListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, OverScrollViewListener
{
  public static final int A = 15;
  private static final int B = 1400;
  private static final int C = 9527;
  private static final int D = 9528;
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "last_buddy_list_refresh_time";
  public static int b = 0;
  private static final String b = "Contacts";
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
  private agc jdField_a_of_type_Agc = new agc(this, null);
  private agd jdField_a_of_type_Agd = new agd(this, null);
  private age jdField_a_of_type_Age = new age(this, null);
  private agf jdField_a_of_type_Agf = new agf(this, null);
  public Handler a;
  public View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private CommonLoadingView jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView;
  private AllBuddyListAdapter jdField_a_of_type_ComTencentMobileqqAdapterAllBuddyListAdapter;
  public BuddyListAdapter a;
  public FPSPinnedHeaderExpandableListView a;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public PullRefreshHeader a;
  public boolean a;
  public View b;
  public PullRefreshHeader b;
  public boolean b;
  private View c;
  public boolean c;
  private View d;
  public int e;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 0;
    jdField_d_of_type_Int = 0;
  }
  
  public Contacts()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private long a()
  {
    return a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private void a(ProfileActivity.AllInOne paramAllInOne)
  {
    int i1 = ProfileCardUtil.a(paramAllInOne);
    Object localObject1 = paramAllInOne.a;
    Intent localIntent = new Intent(a(), ChatActivity.class);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramAllInOne.a);
    localIntent.putExtra("uin", (String)localObject1);
    localIntent.putExtra("uintype", i1);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramAllInOne.jdField_i_of_type_Int != 0) {
      localIntent.putExtra("entrance", paramAllInOne.jdField_i_of_type_Int);
    }
    if ((i1 == 0) && (!TextUtils.isEmpty(paramAllInOne.jdField_i_of_type_JavaLangString)))
    {
      localIntent.putExtra("uinname", paramAllInOne.jdField_i_of_type_JavaLangString);
      localIntent.addFlags(67108864);
      if (TextUtils.isEmpty(paramAllInOne.d)) {
        break label443;
      }
      localIntent.putExtra("troop_uin", paramAllInOne.d);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAllInOne.c)) {
        localIntent.putExtra("troop_code", paramAllInOne.c);
      }
      if (i1 == 1009) {
        localIntent.putExtra("rich_status_sig", paramAllInOne.b);
      }
      if (i1 == 1001)
      {
        localIntent.putExtra("rich_accost_sig", paramAllInOne.b);
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "资料卡accost_uin = " + paramAllInOne.a + "accost_sig = " + paramAllInOne.b);
        }
      }
      localObject1 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject1 != null)
      {
        paramAllInOne = ((FriendManager)localObject1).c(paramAllInOne.a);
        if ((paramAllInOne != null) && (paramAllInOne.cSpecialFlag == 1))
        {
          localIntent.setClass(a(), ChatActivity.class);
          localIntent.putExtra("chat_subType", 1);
        }
      }
      a(localIntent);
      return;
      if (((i1 == 1000) || (i1 == 1020)) && (!TextUtils.isEmpty(paramAllInOne.m)))
      {
        localIntent.putExtra("uinname", paramAllInOne.m);
        break;
      }
      if (i1 == 1004)
      {
        localObject1 = null;
        if (paramAllInOne.d != null) {
          localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAllInOne.d, paramAllInOne.a);
        }
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = paramAllInOne.h;
        }
        localIntent.putExtra("uinname", (String)localObject2);
        break;
      }
      localIntent.putExtra("uinname", paramAllInOne.h);
      break;
      label443:
      if (!TextUtils.isEmpty(paramAllInOne.e)) {
        localIntent.putExtra("troop_uin", paramAllInOne.e);
      }
    }
  }
  
  private void a(ListView paramListView)
  {
    if (paramListView == this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView) {
      if (paramListView.q() > 0) {
        super.a(new aga(this));
      }
    }
    while (paramListView.q() <= 0) {
      return;
    }
    paramListView.setSelection(0);
  }
  
  private boolean a(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Friends))
    {
      paramObject = (Friends)paramObject;
      if (!AppConstants.T.equals(paramObject.uin)) {}
    }
    else
    {
      for (;;)
      {
        try
        {
          List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          i1 = 0;
          if (i1 < localList.size())
          {
            ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)localList.get(i1);
            if ((localResourcePluginInfo == null) || (!localResourcePluginInfo.strPkgName.equals(paramObject.uin))) {
              continue;
            }
            paramObject = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), localResourcePluginInfo.strGotoUrl);
            if (paramObject != null) {
              paramObject.b();
            }
          }
        }
        catch (Exception paramObject)
        {
          int i1;
          continue;
        }
        bool = true;
        return bool;
        i1 += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Hyim", 2, "onItemClick:" + paramObject.name + paramObject.uin + "--[" + paramObject.detalStatusFlag + "] [" + paramObject.iTermType + "] [" + paramObject.getLastLoginType() + "] [" + paramObject.showLoginClient + "]");
    }
    paramObject = new ProfileActivity.AllInOne(paramObject.uin, 1);
    paramObject.g = 59;
    paramObject.jdField_i_of_type_Int = 2;
    a(paramObject);
    return true;
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts", 2, "updateBuddyList " + this.jdField_a_of_type_Boolean + " " + this.jdField_b_of_type_Boolean);
    }
    if (NetworkUtil.f(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_Boolean) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true);
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
  
  private void j()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    int i2;
    if ((localPhoneContactManager != null) && (localPhoneContactManager.e()))
    {
      i2 = 0;
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new agb(this);
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
  
  private void m()
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
  
  private void n()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.r();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a().getCount();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildAt(0) == this.jdField_c_of_type_AndroidViewView) && (i1 == i2 - 1))
    {
      this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      this.jdField_d_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      this.jdField_e_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setPadding(0, 0, (int)DisplayUtils.a(a(), 25.0F), 0);
    this.jdField_d_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    this.jdField_e_of_type_AndroidViewView.setPadding(0, 0, 40, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return LayoutInflater.from(a()).inflate(2130903117, null);
  }
  
  protected String a()
  {
    return a().getString(2131362941);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_e_of_type_Int > 0) {
      return;
    }
    this.jdField_e_of_type_Int = (a().getTitleBarHeight() - (int)DisplayUtils.a(a(), 5.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView = ((CommonLoadingView)a(2131296836));
    this.jdField_a_of_type_ComTencentMobileqqActivityMainCommonLoadingView.setOnFirstDrawListener(this);
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131296840));
      this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1000) && (paramInt2 == 0))
    {
      r();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
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
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    if (localObject != null)
    {
      if (((FriendsManager)localObject).d() <= 0) {
        break label111;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C4D", "0X8004C4D", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView == null)) {}
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(9527);
    }
    for (;;)
    {
      if (paramLong == 0L)
      {
        b(paramBoolean);
        return;
        label111:
        if ((this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView == null)) {
          break;
        }
        break;
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(9527)) {
          return;
        }
      }
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i1 = 9527;; i1 = 4)
    {
      ((Handler)localObject).sendEmptyMessageDelayed(i1, paramLong);
      return;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    n();
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
    j();
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
    if (!b())
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      localMessage.obj = paramListView;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
    }
    for (paramView.jdField_a_of_type_Boolean = false;; paramView.jdField_a_of_type_Boolean = true)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Refresh_contacts", 51, 0, "", "", "", "");
      return true;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9528);
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
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.getGroupCount();
    int i1 = 0;
    while (i1 < i2)
    {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.d(i1);
      i1 += 1;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView);
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
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.a();
    }
  }
  
  public void d_()
  {
    long l1 = System.currentTimeMillis();
    a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l1).commit();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Agd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Agc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_Age);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localStatusManager != null) {
      localStatusManager.b(this.jdField_a_of_type_Agf);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Agd);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Agc);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Age);
    Object localObject = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localObject != null)
    {
      ((StatusManager)localObject).b(this.jdField_a_of_type_Agf);
      ((StatusManager)localObject).a(this.jdField_a_of_type_Agf);
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
      m();
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
  
  public void h()
  {
    a(true);
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
          QQToast.a(a(), 1, 2131363356, 0).b(this.jdField_e_of_type_Int);
        } while (!(paramMessage.obj instanceof ListView));
        ((ListView)paramMessage.obj).B();
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      a(0L, false);
      return true;
    case 9527: 
      a(0L, true);
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
  
  public void i()
  {
    d();
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
    case 2131296856: 
      do
      {
        return;
        paramView = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      } while (paramView == null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Clk_contactslist", 51, 0, "0", "", "", "");
      Intent localIntent = new Intent(a(), PhoneFrameActivity.class);
      localIntent.putExtra("key_req_type", 0);
      a(localIntent);
      paramView.i();
      return;
    case 2131296860: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Contacts_tab", "Clk_grp", 0, 0, "", "", "", "");
      paramView = new Intent(a(), TroopActivity.class);
      paramView.putExtra("onlyOneSegement", true);
      paramView.putExtra("_key_mode", 0);
      a(paramView);
      return;
    case 2131296862: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Contacts_tab", "Clk_grp", 0, 0, "", "", "", "");
      paramView = new Intent(a(), TroopActivity.class);
      paramView.putExtra("onlyOneSegement", true);
      paramView.putExtra("_key_mode", 1);
      a(paramView);
      return;
    }
    AddContactsActivity.a(a());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView = ((FPSPinnedHeaderExpandableListView)paramView.findViewById(2131296846));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setActTAG("actFPSFriend");
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setSelector(2131427345);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130837934));
    paramViewStub = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSPinnedHeaderExpandableListView;
    paramView = LayoutInflater.from(a());
    Object localObject = paramView.inflate(2130903122, paramViewStub, false);
    paramViewStub.a((View)localObject);
    View localView1 = ((View)localObject).findViewById(2131296856);
    View localView2 = ((View)localObject).findViewById(2131296860);
    View localView3 = ((View)localObject).findViewById(2131296862);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131296859);
    localView1.setOnClickListener(this);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    ((View)localObject).findViewById(2131296851).setOnClickListener(this);
    localObject = (PullRefreshHeader)paramView.inflate(2130903274, paramViewStub, false);
    ((PullRefreshHeader)localObject).setTag(new Contacts.OverScrollViewTag());
    paramViewStub.setOverScrollHeader((View)localObject);
    paramViewStub.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localObject);
    this.jdField_a_of_type_AndroidViewView = localImageView;
    paramViewStub.setContentBackground(2130837635);
    paramViewStub.b(paramView.inflate(2130903113, paramViewStub, false));
    m();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Contacts
 * JD-Core Version:    0.7.0.1
 */