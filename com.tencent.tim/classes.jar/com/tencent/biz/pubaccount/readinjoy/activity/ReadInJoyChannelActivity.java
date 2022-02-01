package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqfo;
import awit;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyWebProcessManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kbp;
import kct;
import kfr;
import kfs;
import khq;
import khr;
import khs;
import kht;
import khu;
import kxm;
import kya;
import lbz;
import lcc;
import lcd;
import lci;
import lcr;
import mqq.app.AppRuntime;
import muj;
import mye;
import mza;
import mzj;
import nha;
import npa;
import rpw;

public class ReadInJoyChannelActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private MessageForStructing a;
  public kfr a;
  private boolean afo;
  private boolean afp;
  String mChannelName = "";
  private long rV = -1L;
  protected long sd;
  
  private void aDc()
  {
    for (;;)
    {
      try
      {
        if (!getIntent().getBooleanExtra("is_daily_dynamic_child_channel", false)) {
          return;
        }
        HashMap localHashMap = (HashMap)getIntent().getSerializableExtra("channel_map_data");
        if (localHashMap != null)
        {
          this.mChannelName = ((String)localHashMap.get("channelName"));
          this.afp = "1".equals(localHashMap.get("canDownRefresh"));
          bool2 = "1".equals(localHashMap.get("canUpRefresh"));
          bool1 = "1".equals(localHashMap.get("isImmersive"));
          awit.nR(Integer.valueOf((String)localHashMap.get("channelID")).intValue());
          if (this.jdField_a_of_type_Kfr != null)
          {
            ((kfs)this.jdField_a_of_type_Kfr).j(this.afp, bool2, bool1);
            ((kfs)this.jdField_a_of_type_Kfr).refreshList();
          }
          QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh=", Boolean.valueOf(this.afp), " mCanPullUpRefresh=", Boolean.valueOf(bool2), " mChannelName=", this.mChannelName });
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("IphoneTitleBarActivity", 1, new Object[] { "handlerDynamicParams mCanPullDownRefresh error, e=", localException.toString() });
        return;
      }
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  private void aDd()
  {
    if (zh()) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = kya.b();
    }
  }
  
  private void aDe()
  {
    this.jdField_a_of_type_Kfr.lP(true);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.6(this));
  }
  
  private void initUI()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131376777);
    this.jdField_a_of_type_Kfr = new kfs(this);
    ((kfs)this.jdField_a_of_type_Kfr).setFrom(getIntent().getIntExtra("channel_from", -1));
    this.jdField_a_of_type_Kfr.i(localViewGroup);
    this.jdField_a_of_type_Kfr.onCreate();
    if ((zh()) && ((this.jdField_a_of_type_Kfr instanceof kfs))) {
      this.rightViewImg.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_Kfr);
    }
    if ((ThemeUtil.isInNightMode(kxm.getAppRuntime())) && (this.titleRoot != null)) {
      View.inflate(this, 2131560438, this.titleRoot);
    }
    aDd();
    k(localViewGroup);
  }
  
  private void j(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (this.afp)) {
      return;
    }
    paramViewGroup.setOnClickListener(new kht(this));
  }
  
  private void k(ViewGroup paramViewGroup)
  {
    if ((zh()) && (awit.U(kxm.getAppRuntime()))) {
      l(paramViewGroup);
    }
  }
  
  private void l(ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(2131560561, paramViewGroup, false);
      paramViewGroup.addView(localViewGroup);
      m(localViewGroup);
      kbp.a(null, "", "0X8009337", "0X8009337", 0, 0, "", "", "", kct.ie(), false);
      localViewGroup.setOnClickListener(new khu(this));
    }
  }
  
  private void m(ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramViewGroup.findViewById(2131374342);
    if (rpw.isWeishiInstalled(this)) {}
  }
  
  private void ma(boolean paramBoolean)
  {
    if ((zq()) && (this.sd != 0L) && (this.jdField_a_of_type_Kfr != null) && (this.jdField_a_of_type_Kfr.a() != null) && ((this.jdField_a_of_type_Kfr instanceof kfs)) && (((kfs)this.jdField_a_of_type_Kfr).ao() != null) && (((kfs)this.jdField_a_of_type_Kfr).ao().size() > 0)) {
      kxm.a(56, (System.currentTimeMillis() - this.sd) / 1000L, this.jdField_a_of_type_Kfr.a().c(), (BaseArticleInfo)((kfs)this.jdField_a_of_type_Kfr).ao().get(0), paramBoolean);
    }
  }
  
  private void oN(int paramInt)
  {
    runOnUiThread(new ReadInJoyChannelActivity.8(this, paramInt));
  }
  
  private void oO(int paramInt)
  {
    lcc.a().a(new khr(this, paramInt));
  }
  
  private boolean zh()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 40677) {
      bool = true;
    }
    return bool;
  }
  
  private boolean zq()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 56) {
      bool = true;
    }
    return bool;
  }
  
  private boolean zr()
  {
    boolean bool = false;
    if (getIntent().getIntExtra("channel_id", 0) == 40830) {
      bool = true;
    }
    return bool;
  }
  
  public void aDb()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131379881));
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label263;
      }
      if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
        break label242;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.centerView.setTextColor(-16777216);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
      if ((this.leftView != null) && (zr())) {}
      this.vg.setBackgroundColor(-1);
      j(this.vg);
      if ((getIntent().getBooleanExtra("is_need_show_animation_translate", false)) && (this.afo))
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(400L);
        this.vg.startAnimation(localAlphaAnimation);
      }
      return;
      label242:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label263:
      if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!aqfo.isFlyme())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void aQ()
  {
    if (this.leftView != null) {
      ThreadManager.post(new ReadInJoyChannelActivity.7(this), 5, null, true);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Kfr != null) {
      this.jdField_a_of_type_Kfr.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.sd = System.currentTimeMillis();
    mzj.a().aO(this);
    this.afo = muj.Eq();
    if (!this.afo) {
      setTheme(2131755342);
    }
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(-2147483648);
    }
    setContentView(2131560381);
    npa.tQ(getIntent().getIntExtra("channel_id", -1));
    paramBundle = (lcd)this.app.getManager(163);
    ReadInJoyWebProcessManager.R(this.app);
    setClickableTitle(getIntent().getStringExtra("channel_name"), new khq(this));
    initUI();
    if (zh())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.2(this));
      this.rV = System.currentTimeMillis();
      kya.b(getIntent().getIntExtra("channel_from", 9), kya.e(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), kya.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), kya.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), kya.ar(this.rV));
      if ((this.app != null) && (this.app.b() != null) && (!zr())) {
        this.app.b().addObserver(this);
      }
      lci.aJN();
      lci.aJO();
    }
    aDc();
    oO(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ((lcd)kxm.getAppRuntime().getManager(163)).b().qw(getIntent().getIntExtra("channel_id", 0));
    this.sd = 0L;
    if (this.jdField_a_of_type_Kfr != null) {
      this.jdField_a_of_type_Kfr.onDestroy();
    }
    mzj.a().aP(this);
    nha.a(this).doOnDestory();
    if (zh())
    {
      ThreadManager.executeOnSubThread(new ReadInJoyChannelActivity.3(this));
      kya.a(getIntent().getIntExtra("channel_from", 9), kya.e(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), kya.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), kya.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), kya.ar(this.rV), this.rV, "");
      this.rV = -1L;
      if ((this.app != null) && (this.app.b() != null)) {
        this.app.b().deleteObserver(this);
      }
    }
    oO(5);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Kfr.onPause();
    nha.a(this).aWY();
    oO(3);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    aDb();
    this.jdField_a_of_type_Kfr.onResume();
    nha.a(this).di(getIntent().getIntExtra("channel_type", 0), getIntent().getIntExtra("channel_id", 0));
    if ((awit.aMG()) && (zq())) {
      lbz.a().qo(56);
    }
    oO(2);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    awit.b(getAppRuntime());
    this.jdField_a_of_type_Kfr.onStart();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).mTopLayout.setOnFlingGesture(new khs(this));
    }
    oO(1);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    mzj.a().z(false, "ReadInJoyChannelActivity doOnStop");
    this.jdField_a_of_type_Kfr.onStop();
    oO(4);
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_Kfr.a();
    if ((localObject != null) && (((mye)localObject).a() != null))
    {
      localObject = ((mye)localObject).a();
      if (((mza)localObject).EV())
      {
        ((mza)localObject).aUp();
        return true;
      }
    }
    ma(false);
    finish();
    return true;
  }
  
  public View onCreateRightView()
  {
    Object localObject = super.onCreateRightView();
    if (zh())
    {
      this.rightViewImg.setImageResource(2130843713);
      this.rightViewImg.setVisibility(0);
      localObject = this.rightViewImg;
    }
    return localObject;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (!lcr.k(paramObservable))) {
        aQ();
      }
    }
  }
  
  public static class SerializableMap
    implements Serializable
  {
    private Map<String, Object> map;
    
    public Map<String, Object> getMap()
    {
      return this.map;
    }
    
    public void setMap(Map<String, Object> paramMap)
    {
      this.map = paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity
 * JD-Core Version:    0.7.0.1
 */