package com.tencent.mobileqq.activity.contact.troop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cdl;
import cdm;
import cdn;
import cdo;
import cdp;
import cdq;
import cdr;
import cds;
import cdt;
import cdu;
import cdv;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
  public static final int f = 0;
  protected static final String f = "noti_and_rec_last_tab_mode";
  public static final int g = 1;
  private static final String g = "last_tab_mode";
  public static final int h = 2;
  public static final int k = 1234;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cdt(this);
  protected Animation a;
  RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseTroopView.ITroopContext jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext;
  private BaseTroopView jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new cds(this);
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public ArrayList a;
  protected Animation b;
  RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected boolean b;
  protected boolean c = false;
  boolean d;
  protected String e = "DEFAULT";
  public int i = 0;
  public int j = 0;
  private int l = 0;
  private int m = 0;
  
  public TroopActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
  }
  
  private int a()
  {
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.a(), 0)) {
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
        localObject = new TroopView(this, false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext);
      return localObject;
      localObject = new TroopView(this, false);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 0: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    TroopCreateLogic localTroopCreateLogic = (TroopCreateLogic)this.app.getManager(29);
    if (localTroopCreateLogic != null) {
      localTroopCreateLogic.a(this, paramInt, paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if (this.j == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.a(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.a(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = new cdl(this);
  }
  
  private void f()
  {
    TextView localTextView1 = (TextView)findViewById(2131296901);
    getIntent();
    localTextView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296906));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131297116));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296912));
    TextView localTextView2;
    if (this.j != 2) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838049);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new cdo(this));
        localTextView2 = (TextView)findViewById(2131296895);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131297595).setVisibility(8);
          if (this.i != 0) {
            break label410;
          }
          localTextView2.setText(2131362940);
          localTextView1.setText(2131362940);
        }
        label171:
        if (this.j == 2) {
          break label435;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131362940));
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, getString(2131362942));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297596));
      h();
      i();
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription("搜索");
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("更多");
      localTextView1.setContentDescription(getString(2131364541));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838044);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838049);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new cdp(this));
      break;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838044);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new cdq(this));
      break;
      label410:
      if (1 != this.i) {
        break label171;
      }
      localTextView2.setText(2131362942);
      localTextView1.setText(2131362942);
      break label171;
      label435:
      localTextView2.setText(2131362941);
      localTextView1.setText(2131362941);
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, getString(2131362815));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
    }
  }
  
  private void g()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(2131362585, 5);
    localActionSheet.d(2131362790);
    localActionSheet.a(new cdr(this, localActionSheet));
    if ((!localActionSheet.isShowing()) && (this != null) && (!isFinishing())) {}
    try
    {
      localActionSheet.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  private void h()
  {
    if (this.j != 2) {}
    BaseTroopView localBaseTroopView1;
    do
    {
      NewFriendManager localNewFriendManager;
      do
      {
        return;
        localBaseTroopView1 = a(1);
        localNewFriendManager = (NewFriendManager)this.app.getManager(31);
        BaseTroopView localBaseTroopView2 = a(0);
        if (this.i == 1)
        {
          int n = GroupSystemMsgController.a().a(this.app);
          if ((!localBaseTroopView2.a()) && (n > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(true);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(false);
          return;
        }
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
  
  private void i()
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
  
  private void j()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 49);
    startActivityForResult(localIntent, 1300);
    ReportController.b(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
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
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      if (this.i != 0) {
        break label99;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131362838));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131363771));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131363823));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new cdu(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
      label99:
      if (this.i == 1)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(getString(2131363357));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new cdv(this));
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
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
    super.setContentView(2130903302);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    this.jdField_a_of_type_JavaUtilArrayList.add(null);
    paramBundle = (NewFriendManager)this.app.getManager(31);
    if (paramBundle != null) {
      paramBundle.addObserver(this);
    }
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("fromH5", false);
    this.e = getIntent().getStringExtra("troopType");
    this.j = getIntent().getIntExtra("key_tab_mode", 0);
    this.i = getIntent().getIntExtra("_key_mode", a());
    if (this.i == 4) {
      this.i = a();
    }
    if (this.j == 2)
    {
      if (GroupSystemMsgController.a().a(this.app) > 0) {
        this.i = 0;
      }
      if (this.i != 1) {
        break label261;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.j = getIntent().getIntExtra("key_tab_mode", 0);
      e();
      f();
      return true;
      label261:
      if (this.i == 0) {
        ReportController.b(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    ((NewFriendManager)this.app.getManager(31)).deleteObserver(this);
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
    this.d = false;
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
    this.d = true;
    h();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.d();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      a(4, this.e);
      this.jdField_b_of_type_Boolean = false;
      this.e = "DEFAULT";
    }
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.g();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968587, 2130968588);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new cdm(this));
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
      i();
      if (paramIntent != null)
      {
        String str1 = paramIntent.getStringExtra("roomId");
        if (str1 != null)
        {
          String str2 = ContactUtils.a(this.app, getApplicationContext(), str1);
          Intent localIntent = new Intent(getActivity(), ChatActivity.class);
          localIntent.putExtra("uin", str1);
          localIntent.putExtra("uintype", 3000);
          localIntent.putExtra("uinname", str2);
          startActivity(localIntent);
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new cdn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */