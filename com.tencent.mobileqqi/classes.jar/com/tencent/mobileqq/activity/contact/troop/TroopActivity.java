package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ell;
import elm;
import eln;
import elo;
import elp;
import elq;
import elr;
import els;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback, Observer
{
  public static final int a = 0;
  public static final String a = "onlyOneSegement";
  public static final int b = 0;
  public static final String b = "_key_mode";
  public static final int c = 1;
  public static final String c = "messageTab";
  public static final int d = 1;
  public static final String d = "key_tab_mode";
  public static final int e = 4;
  protected static final String e = "noti_and_rec_last_tab_mode";
  public static final int f = 0;
  private static final String f = "last_tab_mode";
  public static final int g = 1;
  public static final int h = 2;
  public static final int k = 1234;
  private static final int n = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new elq(this);
  public View a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new elp(this);
  protected Animation a;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected LinearLayout a;
  protected RelativeLayout a;
  private BaseTroopView.ITroopContext jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext;
  private BaseTroopView jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new elo(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected View b;
  protected Animation b;
  RotateAnimation b;
  protected LinearLayout b;
  protected boolean b;
  protected LinearLayout c;
  boolean c;
  protected LinearLayout d;
  public int i = 0;
  public int j = 0;
  private int l = 0;
  private int m = 0;
  
  public TroopActivity()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  private int a()
  {
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0)) {
      return localSharedPreferences.getInt("last_tab_mode", 0);
    }
  }
  
  private BaseTroopView a(int paramInt)
  {
    Object localObject;
    if (paramInt >= 4) {
      localObject = null;
    }
    BaseTroopView localBaseTroopView;
    do
    {
      return localObject;
      localBaseTroopView = (BaseTroopView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject = localBaseTroopView;
    } while (localBaseTroopView != null);
    if (this.j != 2) {
      switch (paramInt)
      {
      default: 
        localObject = new TroopView(this);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext);
      return localObject;
      localObject = new TroopView(this);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 1: 
        localObject = new RecommendTroopView(this);
        break;
      case 0: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = new ell(this);
  }
  
  private void g()
  {
    TextView localTextView = (TextView)findViewById(2131231456);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (str == null) {
      localObject = getString(2131561692);
    }
    localTextView.setText((CharSequence)localObject);
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231461));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131231377));
    if (this.j != 2) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131232304).setVisibility(8);
          localObject = (TextView)findViewById(2131231376);
          if (this.i != 0) {
            break label418;
          }
          ((TextView)localObject).setText(2131562205);
          getSupportActionBar().setTitle(2131562205);
        }
        label158:
        if (this.j == 2) {
          break label480;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131562205));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131561955));
        if (this.i != 0) {
          break label446;
        }
        getSupportActionBar().setTitle(2131562203);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232305));
      k();
      i();
      j();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840332);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837917);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int i1 = ((DisplayMetrics)localObject).densityDpi * 36 / 160;
      i1 = ((DisplayMetrics)localObject).densityDpi * 100 / 160;
      this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838009);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new elm(this));
      break;
      label418:
      if (1 != this.i) {
        break label158;
      }
      ((TextView)localObject).setText(2131561955);
      getSupportActionBar().setTitle(2131561955);
      break label158;
      label446:
      if (1 == this.i)
      {
        getSupportActionBar().setTitle(2131561955);
      }
      else
      {
        getSupportActionBar().setTitle(2131562178);
        continue;
        label480:
        ((TextView)findViewById(2131231376)).setText(2131562195);
        getSupportActionBar().setTitle(2131562195);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131562248));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131562199));
      }
    }
  }
  
  private void h()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131560750, 5);
    localActionSheet.a(2131560751, 5);
    localActionSheet.d(2131561746);
    localActionSheet.a(new eln(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void i()
  {
    BaseTroopView localBaseTroopView1 = a(1);
    NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    BaseTroopView localBaseTroopView2 = a(0);
    if (this.i == 1)
    {
      int i1 = GroupSystemMsgController.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((!localBaseTroopView2.a()) && (i1 > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(true);
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(false);
        return;
      } while (this.i != 0);
      this.l = localNewFriendManager.a(3);
    } while (this.j != 0);
    if ((!localBaseTroopView1.a()) && (this.l > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(false);
  }
  
  private void j()
  {
    if (this.j != 2)
    {
      switch (this.i)
      {
      default: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    switch (this.i)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232626);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131232627);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232628));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968628);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130968626);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232629));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232631));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232633));
    this.d = ((LinearLayout)findViewById(2131232635));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("创建群");
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription("添加群");
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setContentDescription("群消息设置");
    this.d.setContentDescription("创建讨论组");
  }
  
  private void l()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 49);
    startActivityForResult(localIntent, 1300);
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    BaseTroopView localBaseTroopView = a(paramInt);
    if (localBaseTroopView == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == localBaseTroopView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView = localBaseTroopView;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    if (isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(AnimationUtils.loadAnimation(a(), 2130968627));
    this.jdField_b_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(a(), 2130968625));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903367);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    paramBundle = (NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.j = getIntent().getIntExtra("key_tab_mode", 0);
    this.i = getIntent().getIntExtra("_key_mode", a());
    if (this.i == 4) {
      this.i = a();
    }
    if (this.j == 2)
    {
      if (GroupSystemMsgController.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
        break label232;
      }
      this.i = 0;
      if (this.i != 1) {
        break label261;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.j = getIntent().getIntExtra("key_tab_mode", 0);
      f();
      g();
      return true;
      label232:
      if (RecommendTroopManagerImp.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface) > 0)
      {
        this.i = 1;
        break;
      }
      this.i = a();
      break;
      label261:
      if (this.i == 0) {
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    ((NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32)).deleteObserver(this);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.h();
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
      b(this.i);
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = null;
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.f();
    }
    this.jdField_c_of_type_Boolean = false;
    if (!this.jdField_a_of_type_Boolean) {
      b(this.i);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.e();
    }
    this.jdField_c_of_type_Boolean = true;
    i();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
    }
    super.doOnStop();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968593, 2130968594);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new elr(this));
    }
    for (;;)
    {
      return true;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
        if (localBaseTroopView != null) {
          localBaseTroopView.a(paramMessage);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.i = 1;
      j();
      if (paramIntent != null)
      {
        String str1 = paramIntent.getStringExtra("roomId");
        if (str1 != null)
        {
          String str2 = ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, getApplicationContext(), str1);
          Intent localIntent = new Intent(a(), ChatActivity.class);
          localIntent.putExtra("uin", str1);
          localIntent.putExtra("uintype", 3000);
          localIntent.putExtra("uinname", str2);
          startActivity(localIntent);
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "onOptionsItemSelected");
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
      paramMenuItem = (TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      if (paramMenuItem != null) {
        paramMenuItem.a(this, 0);
      }
      return true;
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "feature_external", "grp_search_in_external", 40, 1, 0);
      startActivity(new Intent(a(), AddFriendActivity.class).putExtra("btroop", true).putExtra("param_return_addr", Leba.class.getName()));
      return true;
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_msgset", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "grplist_plus_setting", 0, 0, "", "", "", "");
      startActivity(new Intent(this, TroopAssisSettingActivity.class));
      return true;
      l();
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.performClick();
      return true;
      if (((this.i == 0) || (this.i == 1)) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.j();
      }
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "onPrepareOptionsMenu");
    }
    paramMenu.clear();
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null))
    {
      if (this.j == 2) {
        break label318;
      }
      if (this.i != 0) {
        break label261;
      }
      if (paramMenu.findItem(2131232630) == null)
      {
        localMenuItem = paramMenu.add(0, 2131232630, 0, getString(2131560286));
        localMenuItem.setIcon(2130838383);
        MenuItemCompat.setShowAsAction(localMenuItem, 0);
      }
      if (paramMenu.findItem(2131232632) == null)
      {
        localMenuItem = paramMenu.add(0, 2131232632, 0, getString(2131562115));
        localMenuItem.setIcon(2130838385);
        MenuItemCompat.setShowAsAction(localMenuItem, 0);
      }
      if (paramMenu.findItem(2131232634) == null)
      {
        localMenuItem = paramMenu.add(0, 2131232634, 0, getString(2131560287));
        localMenuItem.setIcon(2130838384);
        MenuItemCompat.setShowAsAction(localMenuItem, 0);
      }
    }
    for (;;)
    {
      if (((this.i == 0) || (this.i == 1)) && (paramMenu.findItem(0) == null))
      {
        paramMenu = paramMenu.add(0, 0, 0, getString(2131562830));
        paramMenu.setIcon(2130839696);
        MenuItemCompat.setShowAsAction(paramMenu, 1);
      }
      return true;
      label261:
      if ((this.i == 1) && (paramMenu.findItem(2131232636) == null))
      {
        localMenuItem = paramMenu.add(0, 2131232636, 0, getString(2131560288));
        localMenuItem.setIcon(2130838382);
        MenuItemCompat.setShowAsAction(localMenuItem, 0);
      }
    }
    label318:
    MenuItem localMenuItem = paramMenu.findItem(this.jdField_a_of_type_AndroidWidgetImageView.getId());
    if (localMenuItem != null)
    {
      localMenuItem.setIcon(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
      return true;
    }
    paramMenu = paramMenu.add(0, this.jdField_a_of_type_AndroidWidgetImageView.getId(), 0, "");
    paramMenu.setIcon(this.jdField_a_of_type_AndroidWidgetImageView.getDrawable());
    MenuItemCompat.setShowAsAction(paramMenu, 1);
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new els(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */