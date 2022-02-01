package com.tencent.mobileqq.activity;

import aajb;
import aajg;
import aalb;
import abgj;
import accc;
import accd;
import acfd;
import acff;
import acfp;
import achq;
import acnd;
import aizp;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anov;
import anpg;
import aojs;
import aojv;
import aokp;
import aooi;
import aook;
import apwk;
import aqft;
import aqlz;
import arib;
import asgx;
import ausj;
import auss;
import auuw;
import auuw.a;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupDynamicEntrancePicture;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import inh;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import jnm;
import jqs;
import mqq.os.MqqHandler;
import ppf;
import psu;
import psx;
import ptf;
import rar;
import rnt;
import rnu;
import vxz;
import vya;
import vyb;
import vyc;
import vyd;
import vye;
import vyf;
import vyg;
import vyh;
import vyi;
import vyj;
import vyk;
import vyl;
import vym;
import vyn;
import vyo;
import vyp;
import wja;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements aajb, GestureDetector.OnGestureListener, View.OnTouchListener, DragFrameLayout.c, Observer
{
  public static final String aQr = ppf.fQ("StoryGroupSvc.get_dynamic_entrance_info");
  protected TextView FV;
  public long GZ;
  public abgj a;
  protected accd a;
  protected achq a;
  protected acnd a;
  protected apwk a;
  public aqlz a;
  public arib a;
  protected DragFrameLayout a;
  public String aQs;
  protected boolean aey;
  private int akk;
  public aajg b;
  protected auuw b;
  ThreadExcutor.IThreadListener jdField_b_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new vyf(this);
  private inh jdField_b_of_type_Inh = new vyn(this);
  public MqqHandler b;
  boolean baS;
  protected boolean baT;
  public boolean baU = true;
  public boolean baV;
  private boolean baW;
  protected boolean baX = true;
  private boolean baY = true;
  protected acfd c = new vya(this);
  protected Button dC;
  public Button dD;
  protected aook h = new vyo(this);
  private float lB;
  Comparator<RecentBaseData> mComparator = new vyi(this);
  GestureDetector mGestureDetector;
  protected View mHeadView;
  private boolean mIsRefreshing;
  public List<Long> rk;
  public ImageView rq;
  XListView u;
  XListView v;
  protected View vk;
  protected View vl;
  protected View vm;
  
  public TroopAssistantActivity()
  {
    this.jdField_a_of_type_Achq = new vyp(this);
    this.jdField_a_of_type_Accd = new vxz(this);
    this.jdField_a_of_type_Acnd = new vyb(this);
    this.jdField_b_of_type_MqqOsMqqHandler = new vye(this);
  }
  
  private boolean QO()
  {
    int j = this.u.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.u.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131381288);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.baT = false;
          return this.baT;
        }
      }
      i += 1;
    }
    this.baT = true;
    return this.baT;
  }
  
  private void aC()
  {
    QLog.e("TroopAssistantActivity", 2, "initTitleBar");
    setTitle(2131721314);
    Object localObject = this.rightViewImg;
    int i = 2130840663;
    if (this.aey)
    {
      ((TextView)findViewById(2131369627)).setTextColor(getResources().getColorStateList(2131167302));
      i = 2130844509;
    }
    ((ImageView)localObject).setImageResource(i);
    ((ImageView)localObject).setContentDescription(getString(2131721474));
    ((ImageView)localObject).setOnClickListener(new vyc(this));
    this.FV = ((TextView)findViewById(2131369619));
    aQ();
    if ("batch_setting".equals(this.aQs)) {
      ((ImageView)localObject).setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout)findViewById(2131377361);
      if (!this.aey) {
        break;
      }
      ((RelativeLayout)localObject).setBackgroundResource(2130851106);
      return;
      ((ImageView)localObject).setVisibility(0);
    }
    ((RelativeLayout)localObject).setBackgroundResource(2130851105);
  }
  
  private void aXH()
  {
    this.baV = aizp.a().aqe();
    Object localObject;
    if (this.baV) {
      localObject = getString(2131721466);
    }
    for (int i = 2130843329;; i = 2130843330)
    {
      String str = getString(2131721475);
      ArrayList localArrayList = new ArrayList();
      auuw.a locala = new auuw.a();
      locala.id = 0;
      locala.title = ((String)localObject);
      locala.contentDescription = locala.title;
      locala.iconId = i;
      localArrayList.add(locala);
      localObject = new auuw.a();
      ((auuw.a)localObject).id = 1;
      ((auuw.a)localObject).title = str;
      ((auuw.a)localObject).contentDescription = ((auuw.a)localObject).title;
      ((auuw.a)localObject).iconId = 2130843327;
      localArrayList.add(localObject);
      this.jdField_b_of_type_Auuw = auuw.a(this, localArrayList, new vyd(this));
      localObject = super.getTitleBarView();
      this.jdField_b_of_type_Auuw.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131299279) - getResources().getDimensionPixelSize(2131299275), getResources().getDimensionPixelSize(2131299276));
      return;
      localObject = getString(2131721467);
    }
  }
  
  private void bWp()
  {
    this.aQs = "normal";
    this.u = ((XListView)findViewById(2131380328));
    this.vk = findViewById(2131380234);
    this.u.setVisibility(0);
    this.vk.setVisibility(8);
    if (!this.baW)
    {
      this.mHeadView = View.inflate(this, 2131563242, null);
      ViewCompat.setImportantForAccessibility(this.mHeadView, 2);
      this.vm = this.mHeadView.findViewById(2131380231);
      this.vl = this.mHeadView.findViewById(2131380230);
      this.rq = ((ImageView)this.mHeadView.findViewById(2131377302));
      this.u.addHeaderView(this.mHeadView);
      View localView = View.inflate(this, 2131559027, null);
      this.u.addFooterView(localView);
      this.jdField_b_of_type_Aajg = new aajg(this, this.app, this.u, this, 1);
      this.jdField_b_of_type_Aajg.FX(4);
      this.u.setAdapter(this.jdField_b_of_type_Aajg);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      }
      this.jdField_b_of_type_Aajg.setDragHost(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.baW = true;
    }
    bWr();
  }
  
  private void bWq()
  {
    this.aQs = "batch_setting";
    this.u = ((XListView)findViewById(2131380328));
    this.vk = findViewById(2131380234);
    this.u.setVisibility(8);
    this.vk.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    int j = wja.dp2px(154.0F, getBaseContext().getResources());
    int k = getTitleBarHeight();
    int m = ImmersiveUtils.getStatusBarHeight(getBaseContext());
    this.v = ((XListView)findViewById(2131380235));
    this.v.setMaxHeight(i - j - k - m);
    this.mHeadView = this.vk.findViewById(2131380229);
    this.vl = this.mHeadView.findViewById(2131380230);
    this.vm = this.vk.findViewById(2131380231);
    this.rq = ((ImageView)this.mHeadView.findViewById(2131377302));
    localObject = (TextView)this.vm;
    ((TextView)localObject).setText(2131721298);
    ((TextView)localObject).setVisibility(0);
    this.dC = ((Button)this.vk.findViewById(2131380232));
    this.dD = ((Button)this.vk.findViewById(2131380228));
    this.dC.setOnClickListener(new vyg(this));
    this.dD.setOnClickListener(new vyj(this));
    this.jdField_a_of_type_Abgj = new abgj(this, this.app, null);
    this.v.setAdapter(this.jdField_a_of_type_Abgj);
    localObject = aizp.a();
    ((aizp)localObject).a(this.app, new vyk(this, (aizp)localObject));
    bWr();
  }
  
  private void bWr()
  {
    Object localObject = (rnu)this.app.getManager(208);
    if ((localObject != null) && (((rnu)localObject).a != null) && (((rnu)localObject).a.aJb))
    {
      this.vl.setVisibility(0);
      this.vl.setOnClickListener(new vyl(this));
      if (this.rq != null)
      {
        this.rq.setVisibility(8);
        localObject = new qqstory_group.ReqGetGroupDynamicEntrancePicture();
        ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
        jnm.a(this.app, new vym(this), ((qqstory_group.ReqGetGroupDynamicEntrancePicture)localObject).toByteArray(), aQr);
      }
      return;
    }
    this.vl.setVisibility(8);
  }
  
  private void bWs()
  {
    bWp();
    this.rightViewImg.setVisibility(0);
    bOm();
  }
  
  private void bWt()
  {
    this.h.addFilter(new Class[] { aojs.class, aojv.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, aokp.class });
    this.app.a().a(this.h);
  }
  
  private void dx(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ausj localausj = (ausj)auss.a(this, null);
    localausj.setMainTitle(localResources.getString(2131720791, new Object[] { paramString2 }));
    localausj.addRadioButton(localResources.getString(2131699863), false);
    localausj.addRadioButton(localResources.getString(2131699868), false);
    localausj.addRadioButton(localResources.getString(2131699864), false);
    localausj.addRadioButton(localResources.getString(2131699860), false);
    int i = this.app.cs(String.valueOf(paramString1));
    switch (i)
    {
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new vyh(this, i, paramString1, localausj));
      localausj.show();
      return;
      localausj.setRadioButtonChecked(0);
      continue;
      localausj.setRadioButtonChecked(1);
      continue;
      localausj.setRadioButtonChecked(2);
      continue;
      localausj.setRadioButtonChecked(3);
    }
  }
  
  private void initContentView()
  {
    QLog.e("TroopAssistantActivity", 2, "initContentView");
    if (aizp.a().aY(this.app))
    {
      QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewSettingModal");
      bWq();
      anot.a(this.app, "dc00899", "Grp_msg", "", "helper-guide", "exp_guide", 0, 0, "", "", "", "");
      return;
    }
    QLog.e("TroopAssistantActivity", 2, "initContentView, initContentViewNormalModal");
    bWp();
  }
  
  void E(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    if (paramInt == 1)
    {
      paramString1 = ((TroopManager)this.app.getManager(52)).b(paramString1);
      if ((paramString1 != null) && (paramString1.troopcode != null)) {
        localIntent.putExtra("troop_uin", paramString1.troopcode);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      startActivity(localIntent);
      this.jdField_a_of_type_Apwk.stop();
      return;
      if (paramInt == 0)
      {
        paramString1 = ((acff)this.app.getManager(51)).e(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if ((jqs.cU(paramString1.cSpecialFlag)) || (asgx.mS(paramString1.cSpecialFlag)))
          {
            localIntent.setClass(this, ChatActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      else if (paramInt != 3000) {}
    }
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    String str = ((TroopManager)localObject).jr(paramRecentBaseData.qx());
    if (!TextUtils.isEmpty(str))
    {
      localaccc = (accc)this.app.getBusinessHandler(22);
      if (paramBoolean)
      {
        paramInt = 0;
        if (localaccc.N(str, paramInt)) {
          break label70;
        }
      }
    }
    label70:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        accc localaccc;
        return;
        paramInt = 1;
      }
      localObject = ((TroopManager)localObject).c(paramRecentBaseData.qx());
      if (localObject != null) {}
      switch (((TroopInfo)localObject).troopmask)
      {
      default: 
        paramInt = 0;
        localObject = new anov(this.app).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        str = paramRecentBaseData.qx();
        if (!paramBoolean) {
          break;
        }
      }
      for (paramRecentBaseData = "0";; paramRecentBaseData = "1")
      {
        ((anov)localObject).a(new String[] { str, String.valueOf(paramInt), paramRecentBaseData }).report();
        return;
        paramInt = 1;
        break;
        paramInt = 2;
        break;
      }
    }
    QLog.e("TroopAssistantActivity", 2, "TroopManage.getTroopCodeByTroopUin return null...");
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.wU() > 0) {
      this.baS = true;
    }
    E(paramRecentBaseData.qx(), paramRecentBaseData.ng(), paramString);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    wI(paramRecentBaseData.qx());
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    int i = paramRecentBaseData.ng();
    if (i == 1) {
      if (aqft.equalsWithNullCheck(paramString1, paramString2.getString(aakb.fy[2]))) {
        a(i, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.ng() != 1) || (!aqft.equalsWithNullCheck(paramString2.getString(aakb.fy[1]), paramString1)))
    {
      do
      {
        return;
      } while (!aqft.equalsWithNullCheck(paramString1, paramString2.getString(aakb.fy[3])));
      a(i, paramRecentBaseData, true);
      return;
    }
    dx(paramRecentBaseData.qx(), paramRecentBaseData.getTitleName());
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      anot.a(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1)) {
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  void aQ()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {}
    label102:
    do
    {
      return;
      if (!this.aey) {
        break;
      }
      this.FV.setVisibility(8);
      this.leftView.setVisibility(8);
      this.mLeftBackIcon.setVisibility(0);
      this.mLeftBackIcon.setContentDescription(acfp.m(2131715560));
      this.mLeftBackText.setVisibility(0);
      localObject1 = this.mLeftBackText;
      i((View)localObject1, 0, 0, 0, (int)(30.0F * this.mDensity + 0.5F));
      if (localObject1 == null) {
        break label321;
      }
      ((TextView)localObject1).setTextColor(getResources().getColor(2131167298));
      localObject2 = this.app.b();
    } while (localObject2 == null);
    ThreadManager.post(new TroopAssistantActivity.15(this, (QQMessageFacade)localObject2, (TextView)localObject1), 8, null, true);
    return;
    this.FV.setVisibility(0);
    this.leftView.setVisibility(0);
    Object localObject1 = getResources().getColorStateList(2131167301);
    this.FV.setTextColor((ColorStateList)localObject1);
    Object localObject2 = (GradientDrawable)this.FV.getBackground();
    if (localObject2 != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label323;
      }
      ((GradientDrawable)localObject2).setColor((ColorStateList)localObject1);
    }
    for (;;)
    {
      ((GradientDrawable)localObject2).setAlpha(46);
      if (!ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        localObject1 = (RelativeLayout.LayoutParams)this.FV.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(28.0F, getResources());
        this.FV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (RelativeLayout.LayoutParams)this.leftView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = wja.dp2px(5.0F, getResources());
        this.leftView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.mLeftBackIcon.setVisibility(8);
      this.mLeftBackText.setVisibility(8);
      localObject1 = this.FV;
      break label102;
      label321:
      break;
      label323:
      ((GradientDrawable)localObject2).setColor(((ColorStateList)localObject1).getDefaultColor());
    }
  }
  
  public void bOm()
  {
    QLog.e("TroopAssistantActivity", 2, "refreshTroopList:" + new Exception("this is a log").getStackTrace());
    QLog.e("TroopAssistantActivity", 2, "mIsRefreshing:" + this.mIsRefreshing);
    if (this.mIsRefreshing) {
      return;
    }
    ThreadManager.excute(new TroopAssistantActivity.18(this), 32, this.jdField_b_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
  }
  
  public void bWu()
  {
    if ((this.u != null) && (this.jdField_b_of_type_Aajg != null) && (this.vm != null))
    {
      if (!this.jdField_b_of_type_Aajg.Wy()) {
        break label41;
      }
      this.vm.setVisibility(8);
    }
    label41:
    while (this.vm.getVisibility() == 0) {
      return;
    }
    this.vm.setVisibility(0);
  }
  
  public void bcH()
  {
    if (aizp.a().aV(this.app) == true) {
      aizp.a().c(this.app.a().createEntityManager(), this.app);
    }
    addObserver(this.c);
    addObserver(this.jdField_a_of_type_Achq);
    addObserver(this.jdField_a_of_type_Acnd);
    addObserver(this.jdField_a_of_type_Accd);
    this.app.setHandler(getClass(), this.jdField_b_of_type_MqqOsMqqHandler);
    this.app.b().addObserver(this);
    this.app.a().addObserver(this.jdField_b_of_type_Inh);
    if (this.jdField_b_of_type_Aajg != null) {
      this.jdField_b_of_type_Aajg.onAccountChanged(this.app);
    }
  }
  
  protected List<RecentBaseData> cJ()
  {
    QLog.e("TroopAssistantActivity", 2, "makeRecetBaseData");
    List localList = aizp.a().l(this.app);
    int i;
    ArrayList localArrayList;
    HashSet localHashSet;
    int j;
    label81:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      localArrayList = new ArrayList(i);
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, "makeRecetBaseData before, data.size:" + i);
      }
      localHashSet = new HashSet();
      j = 0;
      if (j >= i) {
        break label263;
      }
      localObject = (TroopAssistantData)localList.get(j);
      if (localObject != null) {
        break label122;
      }
    }
    for (;;)
    {
      j += 1;
      break label81;
      i = localList.size();
      break;
      label122:
      if (!localHashSet.contains(((TroopAssistantData)localObject).troopUin))
      {
        localHashSet.add(((TroopAssistantData)localObject).troopUin);
        localObject = new RecentTroopAssistantItem((TroopAssistantData)localObject);
        ((RecentTroopAssistantItem)localObject).c(this.app, BaseApplication.getContext());
        if (QLog.isColorLevel())
        {
          long l = System.currentTimeMillis();
          QLog.i("Q.recent.cost", 2, "[" + (l - 0L) + ", " + ((RecentTroopAssistantItem)localObject).qx() + "," + localObject.getClass().getName() + "]");
          ((RecentTroopAssistantItem)localObject).cuP();
        }
        localArrayList.add(localObject);
      }
    }
    label263:
    if (QLog.isColorLevel()) {
      QLog.i("TroopAssistantActivity", 2, "makeRecetBaseData end, items.size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void cr(String paramString, int paramInt)
  {
    aizp.a().y(this.app, paramString, paramInt);
    this.jdField_a_of_type_Aqlz.jb.put(paramString, Boolean.valueOf(true));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mGestureDetector != null) && (this.mGestureDetector.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.e("TroopAssistantActivity", 2, "doOnCreate");
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.lB = (ViewConfiguration.get(this).getScaledTouchSlop() * 2);
    try
    {
      super.setContentView(2131563240);
      getWindow().setBackgroundDrawable(null);
      setStatusBarBlue();
      this.aey = ThemeUtil.isDefaultOrDIYTheme(false);
      this.mGestureDetector = new GestureDetector(this);
      paramBundle = (LinearLayout)findViewById(2131380385);
      paramBundle.setOnTouchListener(this);
      paramBundle.setLongClickable(true);
      initContentView();
      aC();
      bcH();
      bWt();
      rar.a("grp_help", "exp", 0, 0, new String[] { "", "", "", "" });
      this.jdField_a_of_type_Apwk = new apwk(this.app, null, "Grp_time", "helper", "visit_time");
      return true;
    }
    catch (Exception paramBundle)
    {
      QLog.e("TroopAssistantActivity", 1, "doOnCreateFailed", paramBundle);
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Apwk != null) {
      this.jdField_a_of_type_Apwk.stop();
    }
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    this.app.a().b(this.h);
    this.app.a().deleteObserver(this.jdField_b_of_type_Inh);
    removeObserver(this.c);
    removeObserver(this.jdField_a_of_type_Acnd);
    removeObserver(this.jdField_a_of_type_Achq);
    removeObserver(this.jdField_a_of_type_Accd);
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_b_of_type_Aajg != null) {
      this.jdField_b_of_type_Aajg.onDestory();
    }
    if (this.u != null) {
      this.u.setAdapter(null);
    }
    this.jdField_b_of_type_Aajg = null;
    ((psu)psx.a(5)).bmH();
    ((ptf)psx.a(2)).bmH();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.onPause();
    }
    if ((this.app != null) && (this.jdField_b_of_type_Aajg != null))
    {
      Object localObject = this.jdField_b_of_type_Aajg.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.b().a(((RecentBaseData)localObject).qx(), ((RecentBaseData)localObject).ng());
        if (localObject != null)
        {
          aizp.a().f(this.app, ((QQMessageFacade.Message)localObject).time);
          localObject = this.app.getHandler(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  public void doOnResume()
  {
    QLog.e("TroopAssistantActivity", 2, "doOnResume");
    super.doOnResume();
    bOm();
    this.jdField_a_of_type_Apwk.start();
  }
  
  public boolean hasGestureFlag(int paramInt)
  {
    return (!isGestureEnd()) && ((this.akk & paramInt) == paramInt);
  }
  
  public void i(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new TroopAssistantActivity.1(this, paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public boolean isGestureEnd()
  {
    return this.akk == -1;
  }
  
  public boolean isGestureIdle()
  {
    return this.akk == 0;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (!this.baS) {
      anpg.bX(this, this.app.getCurrentAccountUin());
    }
    for (;;)
    {
      return super.onBackEvent();
      QO();
      if (this.baT) {
        anpg.bV(this, this.app.getCurrentAccountUin());
      } else {
        anpg.bW(this, this.app.getCurrentAccountUin());
      }
    }
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = paramView.getId();
      if (i == 2131380234)
      {
        this.baU = false;
        if (this.jdField_b_of_type_Aajg != null)
        {
          this.jdField_b_of_type_Aajg.FX(4);
          bWu();
          this.jdField_b_of_type_Aajg.notifyDataSetChanged();
        }
        paramView = new Intent(this, TroopAssisSettingActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (aizp.a().aqf()) {
          aizp.a().dl(this.app);
        }
        anot.a(this.app, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2131380233);
    this.baU = false;
    if (this.jdField_b_of_type_Aajg != null)
    {
      this.jdField_b_of_type_Aajg.FX(4);
      bWu();
      this.jdField_b_of_type_Aajg.notifyDataSetChanged();
      bOm();
    }
    aizp.a().dl(this.app);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    setGestureFlag(0);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((isGestureIdle()) || (isGestureEnd())) {
      return false;
    }
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return false;
    }
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    if (hasGestureFlag(1))
    {
      if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.5F))
      {
        setGestureFlag(-1);
        if (this.baY)
        {
          finish();
          return true;
        }
        this.baY = true;
        return false;
      }
    }
    else if ((hasGestureFlag(2)) && (paramFloat1 > 0.0F) && (paramFloat2 < 0.5F))
    {
      setGestureFlag(-1);
      this.baY = false;
      return false;
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (isGestureEnd()) {}
    float f;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while ((paramMotionEvent1 == null) || (paramMotionEvent2 == null));
            paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
            f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
            if (!isGestureIdle()) {
              break;
            }
          } while (Math.abs(paramFloat2) <= this.lB);
          if ((paramFloat1 < 0.0F) && (f < 0.5F))
          {
            setGestureFlag(1);
            return true;
          }
        } while ((paramFloat1 <= 0.0F) || (f >= 0.5F));
        setGestureFlag(2);
        return true;
        if (!hasGestureFlag(1)) {
          break;
        }
      } while ((paramFloat1 <= 0.0F) && (f < 0.5F));
      setGestureFlag(-1);
      return false;
    } while ((!hasGestureFlag(2)) || ((paramFloat1 >= 0.0F) && (f < 0.5F)));
    setGestureFlag(-1);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    setGestureFlag(-1);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (this.mGestureDetector != null) && (this.mGestureDetector.onTouchEvent(paramMotionEvent));
  }
  
  public void setGestureFlag(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.akk = paramInt;
      return;
    }
    this.akk = (this.akk & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  public String setLastActivityName()
  {
    return "";
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new TroopAssistantActivity.19(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  void wI(String paramString)
  {
    aizp.a().k(paramString, this.app);
    bOm();
    aalb.l(this.app, paramString, 1);
    this.app.b().ca(paramString, 1);
    paramString = this.app.getHandler(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity
 * JD-Core Version:    0.7.0.1
 */