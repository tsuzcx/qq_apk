package com.tencent.mobileqq.activity;

import acep;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anlm;
import aoob;
import aqqx;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import pqy;
import psr;
import psx;
import ptb;
import ram;
import rar;
import vkn;
import vko;

public class Now
  extends acep
{
  public TextView Dj;
  protected QQStoryMainController a;
  protected psr a;
  protected boolean aEN;
  public String aOA;
  public boolean aYT;
  private MystoryListView jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView;
  ImmersiveTitleBar2 jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private final Runnable dW = new Now.1(this);
  RelativeLayout gM;
  private RelativeLayout gT;
  private RelativeLayout gw;
  private long ie = -1L;
  public TextView kn;
  public RelativeLayout mRootView;
  public TextView mTitle;
  public ImageView pW;
  protected ProgressBar u;
  
  public Now()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController = new QQStoryMainController(new vkn(this), QQStoryMainController.dP);
  }
  
  private void aC()
  {
    this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131379866));
    IphoneTitleBarActivity.setLayerType(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.gM = ((RelativeLayout)this.mRootView.findViewById(2131379791));
    IphoneTitleBarActivity.setLayerType((ViewGroup)findViewById(2131377361));
    this.gw = ((RelativeLayout)this.mRootView.findViewById(2131372560));
    this.gw.setOnClickListener(new vko(this));
    this.mTitle = ((TextView)findViewById(2131369627));
    this.kn = ((TextView)findViewById(2131363697));
    this.mTitle.setText(2131720742);
    this.kn.setVisibility(8);
    this.pW = ((ImageView)findViewById(2131369603));
    this.Dj = ((TextView)findViewById(2131380536));
    this.pW.setVisibility(8);
    this.Dj.setVisibility(8);
    this.u = ((ProgressBar)findViewById(2131375271));
    this.u.setVisibility(8);
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.gM, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.gw, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.gM.setBackgroundResource(2130851105);
      this.gw.setBackgroundResource(2130851105);
    }
  }
  
  private void bRX()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.tg(false);
  }
  
  @TargetApi(16)
  private void bRY()
  {
    int j = 1;
    if ((this.gT == null) || (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView == null)) {
      return;
    }
    Object localObject;
    if (ThemeUtil.isNowThemeIsDIY())
    {
      localObject = new ThemeBackground();
      ThemeBackground.getThemeBackground(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), (ThemeBackground)localObject);
      if (("null".equals(((ThemeBackground)localObject).path)) || (((ThemeBackground)localObject).img == null)) {
        break label261;
      }
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(((ThemeBackground)localObject).img);
      this.gT.setBackgroundColor(getResources().getColor(2131167363));
    }
    label261:
    for (int i = 1;; i = 0)
    {
      j = 0;
      while ((i == 0) && (j == 0))
      {
        if (ThemeUtil.isNowThemeIsDefault(this.app, false, null)) {
          this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(getResources().getDrawable(2130851099), false);
        }
        for (;;)
        {
          this.gT.setBackgroundColor(getResources().getColor(2131167363));
          return;
          if (!ThemeUtil.isNowThemeIsAnimate()) {
            break label254;
          }
          localObject = ThemeUtil.getAnimatePathByTag(2);
          Drawable localDrawable = super.getResources().getDrawable(2130851025);
          localObject = aqqx.a(this.app, (String)localObject, "-conversation-", localDrawable, aqqx.pd, "-now-", null);
          if (localObject == null) {
            break label254;
          }
          this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(null);
          this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(null);
          this.gT.setBackgroundDrawable((Drawable)localObject);
          i = 0;
          break;
          this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setContentBackground(getResources().getDrawable(2130838901), false);
        }
        label254:
        j = 0;
        i = 0;
      }
      break;
    }
  }
  
  private void bRZ()
  {
    if (this.u != null) {
      this.u.setVisibility(0);
    }
  }
  
  private void bSa()
  {
    if (this.u != null) {
      this.u.setVisibility(8);
    }
  }
  
  public static void fh(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    case 3: 
    case 12: 
    default: 
      paramInt2 = 2;
    }
    for (;;)
    {
      rar.a("home_page", "time_stay", paramInt2, paramInt1, new String[] { "1", "1" });
      return;
      paramInt2 = 4;
      continue;
      paramInt2 = 3;
    }
  }
  
  private void initContentView()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)findViewById(2131375248));
    this.gT = ((RelativeLayout)findViewById(2131375188));
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setIsNowTab(true);
    this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    ((ViewGroup)this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(getResources().getColor(2131167363));
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    ram.d("Q.qqstory.home:NowTab", "Now tab run onCreateView!");
    this.mRootView = ((RelativeLayout)paramLayoutInflater.inflate(2131561912, null));
    return this.mRootView;
  }
  
  public void bMf()
  {
    super.bMf();
    bMh();
    ram.d("Q.qqstory.home:NowTab", "Now tab onFrameTabClick--------------");
  }
  
  protected void bMh()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getFirstVisiblePosition() > 0) {
      this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setSelection(0);
    }
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onAccountChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.bpL();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.Ki()) {
      return true;
    }
    return super.onBackPressed();
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Psr = ((psr)psx.a(10));
    ram.w("Q.qqstory.home:NowTab", "Now tab run onCreate! action:%d", new Object[] { Integer.valueOf(a().getIntent().getIntExtra("action", 0)) });
    aC();
    initContentView();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onCreate(null);
    this.aEN = true;
    aoob.dWj();
    ((ptb)psx.a(26)).vV(0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ram.w("Q.qqstory.home:NowTab", "Now tab run onDestroy!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onDestroy(a());
    pqy.a().destory();
  }
  
  public void onPause()
  {
    super.onPause();
    ram.w("Q.qqstory.home:NowTab", "Now tab run onPause!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onPause();
    new Handler().removeCallbacks(this.dW);
    ApngImage.pauseByTag(5);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.Ki();
    if ((this.ie > 0L) && (a().isResume()))
    {
      int i = a().getIntent().getIntExtra("action", 0);
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.ie;
      this.ie = -1L;
      fh((int)(l1 - l2), i);
    }
  }
  
  public void onPostThemeChanged()
  {
    bRY();
    if (ThemeUtil.isDefaultOrDIYTheme(false))
    {
      E(this.gM, true);
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      E(this.gw, true);
    }
    for (;;)
    {
      anlm.a(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, a().getWindow());
      return;
      E(this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, false);
      this.gM.setBackgroundResource(2130851105);
      this.gw.setBackgroundResource(2130851105);
    }
  }
  
  public void onResume(boolean paramBoolean)
  {
    super.onResume(paramBoolean);
    ram.b("Q.qqstory.home:NowTab", "Now tab run onResume! tabChange=%s", Boolean.valueOf(paramBoolean));
    paramBoolean = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.Kj();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onResume(a());
    if (this.aYT)
    {
      if (FrameHelperActivity.ZW())
      {
        FrameHelperActivity.EO(true);
        FrameHelperActivity.cuA();
      }
      this.aYT = false;
    }
    if (!paramBoolean) {
      bRX();
    }
    Handler localHandler = new Handler();
    localHandler.removeCallbacks(this.dW);
    localHandler.postDelayed(this.dW, 100L);
    ApngImage.playByTag(5);
    Bosses.get().postLightWeightJob(new Now.3(this), 10);
    this.ie = SystemClock.elapsedRealtime();
  }
  
  public void onStop()
  {
    super.onStop();
    ram.w("Q.qqstory.home:NowTab", "Now tab run onStop!");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.be(a());
  }
  
  public void pE(boolean paramBoolean) {}
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    super.setActivity(paramBaseActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController.onAttach(paramBaseActivity);
  }
  
  public void xJ(boolean paramBoolean)
  {
    View localView1;
    View localView2;
    if (((Boolean)((psr)psx.a(10)).c("upload_video_use_bdh", Boolean.valueOf(false))).booleanValue())
    {
      localView1 = a().findViewById(16908307);
      localView2 = a().findViewById(16908305);
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 0;; i = 8)
    {
      if (paramBoolean) {
        getResources().getDimensionPixelSize(2131297695);
      }
      if (localView1 != null) {
        localView1.setVisibility(i);
      }
      if (localView2 != null) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now
 * JD-Core Version:    0.7.0.1
 */