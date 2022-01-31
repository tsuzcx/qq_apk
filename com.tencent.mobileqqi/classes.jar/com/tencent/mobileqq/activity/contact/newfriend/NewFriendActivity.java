package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.service.circle.ISwitchObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import eee;
import eef;
import eeg;
import eej;
import eek;
import eel;
import eem;
import een;
import eeo;
import eep;
import java.util.Observable;
import java.util.Observer;

public class NewFriendActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 0;
  public static final String a = "_key_mode";
  public static final int b = 1;
  public static final String b = "enter_cricle_view";
  static final boolean jdField_b_of_type_Boolean = true;
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "NewFriendManager";
  public static final int d = 3;
  private static final String jdField_d_of_type_JavaLangString = "newfriend_";
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = -1000;
  public static final int h = 1001;
  public static final int i = 1002;
  public static final int j = 1003;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseNewFriendView.INewFriendContext jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext;
  private BaseNewFriendView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView;
  private CircleGroupListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView;
  private RecommendListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  public CircleManager a;
  private ISwitchObserver jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver = new eej(this);
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new eef(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  boolean jdField_d_of_type_Boolean;
  private boolean e;
  private int k = 0;
  private int l = 0;
  private int m = 3;
  private int n;
  
  private int a()
  {
    return getSharedPreferences("newfriend_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("_key_mode", -1000);
  }
  
  private void a(int paramInt)
  {
    getSharedPreferences("newfriend_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putInt("_key_mode", paramInt).commit();
  }
  
  private void a(boolean paramBoolean)
  {
    NewFriendManager localNewFriendManager = (NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    if (paramBoolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      localNewFriendManager.addObserver(this);
    }
    do
    {
      return;
      localNewFriendManager.deleteObserver(this);
    } while (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getWindow().getDecorView().findViewById(2131231116);
        } while (localObject == null);
        localObject = ((View)localObject).getParent();
      } while ((localObject == null) || (!(localObject instanceof FrameLayout)));
      localObject = (FrameLayout)localObject;
      if (paramBoolean1) {
        ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -1));
      }
    } while (!paramBoolean2);
    ((FrameLayout)localObject).removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) || (!paramBoolean)) {
      a(false, true);
    }
    SharedPreferences localSharedPreferences;
    long l1;
    do
    {
      return;
      localSharedPreferences = getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      l1 = localSharedPreferences.getLong("newfriend_enter_time", -100L);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendManager", 2, "enterTime: " + l1);
      }
    } while ((l1 != -100L) || ((this.jdField_a_of_type_AndroidViewView != null) && (paramBoolean)));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getApplicationContext()).inflate(2130903596, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new eem(this, localSharedPreferences));
    a(true, false);
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.n);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837862);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.n = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = new eee(this);
  }
  
  private void i()
  {
    setContentView(2130903595);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231116));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232307));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131231377));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131232308));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231374));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231376));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231456));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231461));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231380));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131562135));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131562731));
    this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558939));
      setTitle(getResources().getString(2131558939));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131561692);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131561746);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      k();
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription("取消本次转发");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131563183));
      return;
    }
    this.e = getIntent().getBooleanExtra("enter_cricle_view", false);
    label490:
    RelativeLayout localRelativeLayout;
    if (this.e)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558939));
      setTitle(getResources().getString(2131558939));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558940));
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(this.jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Circle_grplist_exp", 0, 0, "", "", "", "");
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!this.e) {
        break label623;
      }
    }
    label623:
    for (int i1 = 8;; i1 = 0)
    {
      localRelativeLayout.setVisibility(i1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838011);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new eep(this));
      a(true);
      l();
      m();
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558941));
      j();
      setTitle(getResources().getString(2131558941));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558942));
      break label490;
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject != null)
    {
      int i1 = ((QQMessageFacade)localObject).f();
      if (i1 > 0)
      {
        if (i1 > 99) {}
        for (localObject = "99+";; localObject = "" + i1)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131561807) + "(" + (String)localObject + ")");
          return;
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131561807));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131561807));
  }
  
  private void k()
  {
    b(true);
    d();
  }
  
  private void l()
  {
    boolean bool2 = true;
    Object localObject = (NewFriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    this.k = ((NewFriendManager)localObject).a(0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView)
    {
      RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1);
      if (this.k > 0)
      {
        bool1 = true;
        localRedDotTextView.a(bool1);
      }
    }
    else
    {
      this.l = ((NewFriendManager)localObject).a(1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
        if (this.l <= 0) {
          break label109;
        }
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((RedDotTextView)localObject).a(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void m()
  {
    if (this.e)
    {
      k();
      return;
    }
    switch (getIntent().getIntExtra("_key_mode", -1000))
    {
    }
    do
    {
      n();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
      if (this.l > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
        this.l = 0;
        return;
      }
    } while (this.k <= 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
    this.k = 0;
  }
  
  private void n()
  {
    switch (a())
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
  }
  
  public View a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView;
    case 0: 
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  }
  
  void a(BaseNewFriendView paramBaseNewFriendView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != paramBaseNewFriendView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null)
      {
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.f();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView = paramBaseNewFriendView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.d();
        if (isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.e();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView);
      }
    }
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView = new CircleGroupListView(this, this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putLong("newfriend_enter_time", System.currentTimeMillis()).commit();
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130903595);
    j(2130837729);
    h();
    i();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendCircleGroupListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.h();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.b(this.jdField_a_of_type_ComTencentMobileqqServiceCircleISwitchObserver);
    }
    a(false);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    m();
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.f();
    }
    this.d = false;
    if (!this.e) {
      a(this.m);
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.e();
    }
    this.d = true;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.d();
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView.g();
    }
    super.doOnStop();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView = new RecommendListView(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = new SystemMsgListView(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView);
  }
  
  public void g()
  {
    boolean bool = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    if (!this.e)
    {
      localActionSheet.a(getString(2131561821), 0, false, false);
      localActionSheet.a(getString(2131561830), 0, false, false);
    }
    for (;;)
    {
      localActionSheet.a(new eeg(this, localActionSheet));
      localActionSheet.d(2131561746);
      localActionSheet.show();
      return;
      String str = getString(2131562508);
      if (!this.jdField_c_of_type_Boolean) {
        bool = true;
      }
      localActionSheet.a(str, bool);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      finish();
      return;
    } while (!this.jdField_a_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.u == 11))
    {
      ForwardOperations.a(this, false, "shareToQQ", this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a);
      com.tencent.mobileqq.app.PhoneContactManagerImp.jdField_c_of_type_Boolean = false;
    }
    setResult(1);
    finish();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131231380: 
      this.jdField_c_of_type_AndroidWidgetTextView.performClick();
      return true;
    case 2131231461: 
      this.jdField_a_of_type_AndroidWidgetImageView.performClick();
      return true;
    case 1001: 
      paramMenuItem = new een(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMenuItem);
      return true;
    case 1002: 
      paramMenuItem = new eeo(this);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMenuItem);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCircleManager = ((CircleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    }
    boolean bool;
    label170:
    QQAppInterface localQQAppInterface;
    if (NetworkUtil.e(this))
    {
      paramMenuItem = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager;
      if (!this.jdField_c_of_type_Boolean)
      {
        bool = true;
        paramMenuItem.a(bool, true);
        localQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!this.jdField_c_of_type_Boolean) {
          break label262;
        }
      }
    }
    label262:
    for (paramMenuItem = "0";; paramMenuItem = "1")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Network_circle", "Network_circle_setting", 59, 0, paramMenuItem, "", "", "");
      return true;
      bool = false;
      break;
      if ((isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext == null)) {
        break label170;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a(getResources().getString(2131562449), 1);
      break label170;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if ((this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_c_of_type_AndroidWidgetTextView.getText() != null))
    {
      MenuItem localMenuItem = paramMenu.findItem(2131231380);
      if (localMenuItem == null) {
        break label141;
      }
      localMenuItem.setTitle(this.jdField_c_of_type_AndroidWidgetTextView.getText());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null))
      {
        paramMenu.clear();
        if (this.e) {
          break;
        }
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1001, 0, getString(2131561821)), 0);
        MenuItemCompat.setShowAsAction(paramMenu.add(0, 1002, 0, getString(2131561830)), 0);
      }
      return true;
      label141:
      MenuItemCompat.setShowAsAction(paramMenu.add(0, 2131231380, 0, this.jdField_c_of_type_AndroidWidgetTextView.getText()), 1);
    }
    MenuItemCompat.setShowAsAction(paramMenu.add(0, 1003, 0, getString(2131562508)), 0);
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof NewFriendMessage)) {
      runOnUiThread(new eek(this, paramObject));
    }
    int i1;
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      int i2 = 1;
      i1 = i2;
      if ((paramObject instanceof ChatMessage))
      {
        i1 = i2;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          i1 = 0;
        }
      }
    } while (i1 == 0);
    runOnUiThread(new eel(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */