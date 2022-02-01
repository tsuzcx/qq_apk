package com.tencent.mobileqq.activity.contact.troop;

import acfp;
import ackn;
import acmb;
import acmc;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import anot;
import anze;
import apbc;
import apuh;
import aurf;
import auuw;
import auuw.a;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import wja;
import ywv;
import yww;
import ywx;
import ywy;
import ywz;
import yxa;
import yxb;
import yya;

public class TroopActivity
  extends BaseForwardSelectionActivity
  implements Handler.Callback, Observer
{
  protected static final int[] eD = { 2131721476, 2131689911, 2131721477, 2131692294 };
  protected static final int[] eE = { 2130843326, 2130843332, 2130843327, 2130839793 };
  TextView Mg;
  public BaseTroopView a;
  protected ShowExternalTroopListActivity.a a;
  protected TabBarView.a a;
  public int aSR = 2;
  protected String aZO = "DEFAULT";
  boolean aey;
  acmc b;
  public aurf b;
  protected auuw b;
  protected BaseTroopView.a b;
  protected FrameLayout bg;
  public boolean bpv;
  protected boolean bpw;
  protected boolean bpx;
  boolean bpy;
  protected boolean bpz;
  public TabBarView c;
  public int cbH = 0;
  public HashMap<String, Boolean> hi;
  public int iMode = 0;
  boolean isResume;
  public int mFromType;
  ArrayList<BaseTroopView> mViews = new ArrayList();
  public List<Stranger> tw = new ArrayList();
  ImageView uG;
  protected View.OnClickListener x = new yww(this);
  
  public TroopActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a = new ywz(this);
    this.jdField_b_of_type_Acmc = new yxa(this);
  }
  
  private void EH(int paramInt)
  {
    if (this.bpz) {
      return;
    }
    this.bpz = true;
    if (this.cbH == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.getCurrentAccountUin(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.getCurrentAccountUin(), 0))
    {
      localSharedPreferences.edit().putInt("last_tab_mode", paramInt).commit();
      return;
    }
  }
  
  private void EI(int paramInt)
  {
    if (AppSetting.enableTalkBack)
    {
      int i = this.c.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        RedDotTextView localRedDotTextView = this.c.b(paramInt);
        StringBuilder localStringBuilder = new StringBuilder(24);
        localStringBuilder.append(localRedDotTextView.getText());
        localRedDotTextView.setContentDescription(localStringBuilder);
        paramInt += 1;
      }
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
      localBaseTroopView = (BaseTroopView)this.mViews.get(paramInt);
      localObject = localBaseTroopView;
    } while (localBaseTroopView != null);
    if (this.cbH != 2) {
      switch (paramInt)
      {
      default: 
        localObject = new TroopView(this, this.bpw, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a);
      }
    }
    for (;;)
    {
      this.mViews.set(paramInt, localObject);
      ((BaseTroopView)localObject).a(null, this.jdField_b_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a);
      return localObject;
      localObject = new TroopView(this, this.bpw, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a);
      continue;
      localObject = new DiscussionView(this);
      continue;
      switch (paramInt)
      {
      default: 
        localObject = new NotificationView(this);
        break;
      case 0: 
        if (this.aSR == 2) {
          localObject = new TroopNotifyAndRecommendView(this);
        } else {
          localObject = new NotificationView(this);
        }
        break;
      case 1: 
        localObject = new NotificationView(this);
      }
    }
  }
  
  private void bKu()
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_title", getString(2131692294));
    localIntent.putExtra("param_done_button_wording", getString(2131719439));
    localIntent.putExtra("param_done_button_highlight_wording", getString(2131719440));
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 99);
    startActivityForResult(localIntent, 1300);
    anot.a(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    anot.a(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
  }
  
  private void bw(int paramInt, String paramString)
  {
    apbc localapbc = (apbc)this.app.getManager(32);
    if (localapbc != null) {
      localapbc.a(this, paramInt, paramString);
    }
  }
  
  private void cmA()
  {
    if (this.cbH != 2)
    {
      switch (this.iMode)
      {
      default: 
        this.c.setSelectedTab(0, true);
        return;
      case 0: 
        this.c.setSelectedTab(0, true);
        return;
      }
      this.c.setSelectedTab(1, true);
      return;
    }
    switch (this.iMode)
    {
    default: 
      this.c.setSelectedTab(1, true);
      return;
    case 1: 
      this.c.setSelectedTab(1, true);
      return;
    }
    this.c.setSelectedTab(0, true);
  }
  
  private void cmB()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < eD.length)
    {
      auuw.a locala = new auuw.a();
      locala.id = i;
      locala.title = getString(eD[i]);
      locala.contentDescription = locala.title;
      locala.iconId = eE[i];
      localArrayList.add(locala);
      i += 1;
    }
    this.jdField_b_of_type_Auuw = auuw.a(this, localArrayList, new yxb(this));
  }
  
  private void cmz()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a = new ywx(this);
  }
  
  @TargetApi(14)
  private void initViews()
  {
    this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = findViewById(2131377546);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      ((View)localObject1).setFitsSystemWindows(true);
      ((View)localObject1).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    TextView localTextView = (TextView)findViewById(2131369579);
    localObject1 = getIntent();
    Object localObject2;
    if (((Intent)localObject1).getIntExtra("forward_type", 2147483647) == 23)
    {
      localObject2 = acfp.m(2131715501);
      localTextView.setMaxWidth(wja.dp2px(120.0F, getResources()));
      localTextView.setText("");
      localTextView.setOnClickListener(this.x);
      this.Mg = ((TextView)findViewById(2131369612));
      this.uG = ((ImageView)findViewById(2131369594));
      this.c = ((TabBarView)findViewById(2131377249));
      if (this.cbH == 2) {
        break label856;
      }
      if ((this.aTk) || (this.aTj))
      {
        this.uG.setVisibility(8);
        label190:
        localObject1 = (TextView)findViewById(2131369627);
        if (getIntent().getBooleanExtra("onlyOneSegement", false))
        {
          findViewById(2131377490).setVisibility(8);
          if (this.mFromType != 3) {
            break label927;
          }
          ((TextView)localObject1).setText(2131692099);
        }
        label242:
        if (this.cbH == 2) {
          break label962;
        }
        this.uG.setImageResource(2130840650);
        this.c.a(0, getString(2131692098));
        findViewById(2131377490).setVisibility(8);
        if (this.bpw)
        {
          this.uG.setVisibility(8);
          ((TextView)localObject1).setText(2131698442);
        }
        this.c.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$a);
        this.bg = ((FrameLayout)findViewById(2131369269));
        cmB();
        cmA();
        if (AppSetting.enableTalkBack)
        {
          if (!this.aTk) {
            break label1045;
          }
          localTextView.setContentDescription(((TextView)localObject1).getText() + acfp.m(2131715498) + (String)localObject2 + acfp.m(2131715500));
          localTextView.postDelayed(new TroopActivity.5(this, localTextView), 1000L);
          label420:
          if (this.uG.getVisibility() == 0) {
            this.uG.setContentDescription(acfp.m(2131715497));
          }
        }
        localObject1 = (acmb)this.app.getBusinessHandler(26);
        ((acmb)localObject1).cMA();
        ((acmb)localObject1).aW(false);
      }
    }
    else
    {
      localObject1 = ((Intent)localObject1).getExtras().getString("leftViewText");
      if (localObject1 != null) {
        break label1076;
      }
      localObject1 = getString(2131691039);
    }
    label927:
    label1076:
    for (;;)
    {
      localObject2 = localObject1;
      if (!this.aey) {
        break;
      }
      this.app.b().addObserver(this);
      int i = this.app.b().bl();
      localTextView.setVisibility(8);
      localObject2 = (TextView)findViewById(2131380514);
      Object localObject3 = (ImageView)findViewById(2131369967);
      ((TextView)localObject2).setVisibility(0);
      ((ImageView)localObject3).setVisibility(0);
      ((TextView)localObject2).setText("" + i);
      if (i <= 0) {
        ((TextView)localObject2).setVisibility(4);
      }
      i((View)localObject2, 0, 0, 0, wja.dp2px(30.5F, getResources()));
      ((TextView)localObject2).setOnClickListener(this.x);
      ((ImageView)localObject3).setOnClickListener(this.x);
      if (AppSetting.enableTalkBack)
      {
        ((TextView)localObject2).setContentDescription(acfp.m(2131715505) + i + acfp.m(2131715499));
        ((ImageView)localObject3).setContentDescription(acfp.m(2131715504) + i + acfp.m(2131715503));
      }
      findViewById(2131377498).setBackgroundResource(2130851106);
      this.bpy = true;
      localObject2 = localObject1;
      break;
      this.uG.setBackgroundResource(2130851767);
      this.uG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localObject1 = this.uG.getLayoutParams();
      localObject3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
      ((ViewGroup.LayoutParams)localObject1).width = (((DisplayMetrics)localObject3).densityDpi * 36 / 160);
      ((ViewGroup.LayoutParams)localObject1).height = -2;
      this.uG.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = ((DisplayMetrics)localObject3).densityDpi * 100 / 160;
      this.uG.setMaxWidth(i);
      this.uG.setVisibility(0);
      this.uG.setOnClickListener(this.x);
      break label190;
      label856:
      if ((this.aTk) || (this.aTj))
      {
        this.uG.setVisibility(8);
        break label190;
      }
      this.Mg.setVisibility(0);
      this.uG.setVisibility(8);
      this.Mg.setText(2131701777);
      this.Mg.setOnClickListener(new ywy(this));
      break label190;
      if (this.iMode == 0)
      {
        ((TextView)localObject1).setText(2131692098);
        break label242;
      }
      if (1 != this.iMode) {
        break label242;
      }
      ((TextView)localObject1).setText(2131692095);
      break label242;
      label962:
      this.uG.setImageResource(2130840663);
      if (this.bpy) {
        this.uG.setImageResource(2130844509);
      }
      if (this.aSR == 2) {
        ((TextView)localObject1).setText(2131692100);
      }
      for (;;)
      {
        this.c.a(0, getString(2131692101));
        this.c.setVisibility(8);
        break;
        ((TextView)localObject1).setText(acfp.m(2131715502));
      }
      localTextView.setContentDescription((String)localObject2 + acfp.m(2131715496));
      break label420;
    }
  }
  
  private int xP()
  {
    if (this.cbH == 2) {}
    for (SharedPreferences localSharedPreferences = getSharedPreferences("noti_and_rec_last_tab_mode_" + this.app.getCurrentAccountUin(), 0);; localSharedPreferences = getSharedPreferences("last_tab_mode_" + this.app.getCurrentAccountUin(), 0)) {
      return localSharedPreferences.getInt("last_tab_mode", 0);
    }
  }
  
  public void cmC()
  {
    if (isPopupShowing()) {
      this.jdField_b_of_type_Auuw.dismiss();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560073);
    super.getWindow().setBackgroundDrawable(null);
    this.jdField_b_of_type_Aurf = new aurf(this);
    this.mViews.add(null);
    this.mViews.add(null);
    this.mViews.add(null);
    this.mViews.add(null);
    this.mFromType = getIntent().getIntExtra("key_from", 0);
    this.bpw = getIntent().getBooleanExtra("is_from_show_ext_troop_list", false);
    if (this.bpw)
    {
      this.hi = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopShowExternalTroopListActivity$a = new ywv(this);
    }
    this.bpx = getIntent().getBooleanExtra("fromH5", false);
    this.aZO = getIntent().getStringExtra("troopType");
    this.cbH = getIntent().getIntExtra("key_tab_mode", 0);
    this.iMode = getIntent().getIntExtra("_key_mode", xP());
    this.aSR = getIntent().getIntExtra("show_mode", 2);
    this.aTj = getIntent().getBooleanExtra("is_select_troop", false);
    this.bpv = getIntent().getBooleanExtra("show_type", false);
    if (this.bpv)
    {
      yya.Bd(true);
      if (this.iMode == 4) {
        this.iMode = xP();
      }
      if (this.cbH == 2)
      {
        if (anze.a().af(this.app) <= 0) {
          break label375;
        }
        this.iMode = 1;
        label289:
        if (this.iMode != 0) {
          break label393;
        }
        anot.a(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.cbH = getIntent().getIntExtra("key_tab_mode", 0);
      cmz();
      initViews();
      this.app.addObserver(this.jdField_b_of_type_Acmc);
      return true;
      yya.Bd(false);
      break;
      label375:
      if (ackn.F(this.app) <= 0) {
        break label289;
      }
      this.iMode = 0;
      break label289;
      label393:
      if (this.iMode == 1) {
        anot.a(this.app, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.app.b().deleteObserver(this);
    Iterator localIterator = this.mViews.iterator();
    while (localIterator.hasNext())
    {
      BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
      if (localBaseTroopView != null) {
        localBaseTroopView.onDestroy();
      }
    }
    if (!this.aTk) {
      EH(this.iMode);
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Ahgq = null;
    this.app.removeObserver(this.jdField_b_of_type_Acmc);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Intent localIntent;
    if ((paramInt == 4) && (this.hi != null))
    {
      localIntent = new Intent();
      if (this.hi.isEmpty()) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("isDataChanged", bool);
      setResult(-1, localIntent);
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onPause();
    }
    if (this.jdField_b_of_type_Auuw != null) {
      this.jdField_b_of_type_Auuw.onPause();
    }
    this.isResume = false;
    if (!this.aTk) {
      EH(this.iMode);
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onResume();
    }
    this.isResume = true;
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onStart();
    }
    if (this.bpx)
    {
      bw(4, this.aZO);
      this.bpx = false;
      this.aZO = "DEFAULT";
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onStop();
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772000, 2130772001);
  }
  
  public void hG(int paramInt)
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
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onPause();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onStop();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView = localBaseTroopView;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onStart();
    if (isResume()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView.onResume();
    }
    this.bg.removeAllViews();
    this.bg.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1234) {
      runOnUiThread(new TroopActivity.11(this));
    }
    for (;;)
    {
      return true;
      Iterator localIterator = this.mViews.iterator();
      while (localIterator.hasNext())
      {
        BaseTroopView localBaseTroopView = (BaseTroopView)localIterator.next();
        if (localBaseTroopView != null) {
          localBaseTroopView.handleMessage(paramMessage);
        }
      }
    }
  }
  
  public void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopActivity.3(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public boolean isPopupShowing()
  {
    return (this.jdField_b_of_type_Auuw != null) && (this.jdField_b_of_type_Auuw.isShowing());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt1 == 1300))
    {
      this.iMode = 1;
      cmA();
      if (paramIntent != null) {
        apuh.f(this, paramIntent.getStringExtra("roomId"), true);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void showPopup()
  {
    this.jdField_b_of_type_Auuw.showAsDropDown(this.jdField_b_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.aT(), this.jdField_b_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$a.aT().getWidth() - getResources().getDimensionPixelSize(2131299279) - getResources().getDimensionPixelSize(2131299275), getResources().getDimensionPixelSize(2131299276));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new TroopActivity.12(this));
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity
 * JD-Core Version:    0.7.0.1
 */