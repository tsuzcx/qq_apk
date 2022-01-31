package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.ScanDataResult;
import com.tencent.token.core.bean.UtilFucntionItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.MyViewPaper;
import com.tencent.token.ui.base.RoundImageView;
import com.tencent.token.utils.bugscanuitl.DetectActivity;
import com.tencent.token.utils.k;
import com.tencent.token.utils.t;
import java.util.ArrayList;

public class SettingPageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String ACTION_GET_ACTIVITY_FLAG = "com.tencent.token.activity_flag";
  public static boolean mNeedRefreshMbInfo = true;
  public static boolean mShowConfigNew = false;
  public static boolean mShowQRNew;
  public static boolean mShowQueryNew;
  public static boolean mShowSafeNew = false;
  public static boolean mShowUtilNew;
  public PagerAdapter adapter = new zm(this);
  FrameLayout banner;
  ArrayList bannerlist;
  private int bannersize;
  private int currentPage = 0;
  TextView hot_promote_txt;
  private RelativeLayout hotpromoteLayout;
  private ImageView[] imageViews;
  private ConfigResult mConfig = new ConfigResult();
  private ImageView mConfigNew;
  private ImageView mConfigSafe;
  protected String mErr;
  public Handler mHandler = new zp(this);
  private RoundImageView mQQFace;
  private View.OnClickListener mQQFaceListener = new zx(this);
  private ImageView mQQFace_zzb;
  private RelativeLayout mQRCodeLayout;
  private ImageView mQRNew;
  private ImageView mQueryNew;
  private RelativeLayout mQueryqqLayout;
  private BroadcastReceiver mReceiver = new zl(this);
  private RelativeLayout mUtilLayout;
  private ImageView mUtilNew;
  private boolean needgotologobyprotect;
  TextView qqFaceNotVerify;
  private ImageView qqface_not_verify;
  private TextView qrtext;
  private TextView queryqqtext;
  private RelativeLayout safenewsLayout;
  TextView safenews_txt;
  private TextView scanutil;
  
  static
  {
    mShowQRNew = false;
    mShowQueryNew = false;
    mShowUtilNew = false;
  }
  
  public static int dip(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, RqdApplication.i().getResources().getDisplayMetrics());
  }
  
  private void gotoDetectActivity(ScanDataResult paramScanDataResult)
  {
    Intent localIntent = new Intent(getApplicationContext(), DetectActivity.class);
    localIntent.putExtra("result", paramScanDataResult);
    startActivity(localIntent);
  }
  
  private void gotoMbMobileProtect()
  {
    QQUser localQQUser = ax.a().e();
    if (localQQUser == null) {
      return;
    }
    Intent localIntent = new Intent(this, WtLoginAccountInput.class);
    localIntent.putExtra("page_id", 9);
    localIntent.putExtra("intent.uin", localQQUser.mRealUin);
    startActivity(localIntent);
  }
  
  private void initBanner()
  {
    MyViewPaper localMyViewPaper = (MyViewPaper)findViewById(2131297064);
    localMyViewPaper.setAdapter(this.adapter);
    localMyViewPaper.setOnPageChangeListener(new zy(this));
  }
  
  private void initConfig()
  {
    t.b(this.mConfig);
    if (t.m() != null)
    {
      this.banner.setVisibility(0);
      this.bannerlist = t.m();
      initpoint();
      this.adapter.notifyDataSetChanged();
      if (this.mConfig.mActivityName != null) {
        this.hot_promote_txt.setText(this.mConfig.mActivityName);
      }
      if (this.mConfig.mActivityUrl != null) {
        this.hotpromoteLayout.setOnClickListener(new zs(this));
      }
      if (this.mConfig.headlinetip != null) {
        this.safenews_txt.setText(this.mConfig.headlinetip);
      }
      if (this.mConfig.headlineurl != null) {
        this.safenewsLayout.setOnClickListener(new zt(this));
      }
      if ((t.n() != null) && (t.n().size() != 0)) {
        break label287;
      }
      this.mUtilLayout.setVisibility(8);
      this.mQueryqqLayout.setVisibility(8);
      this.mQRCodeLayout.setVisibility(8);
      e.a("need refresh mbinfo: " + mNeedRefreshMbInfo);
      if (!mShowQRNew) {
        break label555;
      }
      this.mQRNew.setVisibility(0);
      label218:
      if (!mShowQueryNew) {
        break label566;
      }
      this.mQueryNew.setVisibility(0);
      label232:
      if (!mShowUtilNew) {
        break label577;
      }
      this.mUtilNew.setVisibility(0);
      label246:
      if (!mShowSafeNew) {
        break label588;
      }
      this.mConfigSafe.setVisibility(0);
    }
    for (;;)
    {
      if (!mShowConfigNew) {
        break label599;
      }
      this.mConfigNew.setVisibility(0);
      return;
      this.banner.setVisibility(8);
      break;
      label287:
      ArrayList localArrayList = t.n();
      int i = 0;
      label293:
      UtilFucntionItem localUtilFucntionItem;
      if (i < localArrayList.size())
      {
        localUtilFucntionItem = (UtilFucntionItem)localArrayList.get(i);
        if (localUtilFucntionItem.a().equals("101"))
        {
          this.mQRCodeLayout.setVisibility(0);
          if (!mShowQRNew) {
            break label522;
          }
          this.mQRNew.setVisibility(0);
          label345:
          if (localUtilFucntionItem.c() != null) {
            this.qrtext.setText(localUtilFucntionItem.c());
          }
          this.mQRCodeLayout.setOnClickListener(new zu(this));
        }
        if (localUtilFucntionItem.a().equals("102"))
        {
          this.mQueryqqLayout.setVisibility(0);
          if (!mShowQueryNew) {
            break label533;
          }
          this.mQueryNew.setVisibility(0);
          label413:
          if (localUtilFucntionItem.c() != null) {
            this.queryqqtext.setText(localUtilFucntionItem.c());
          }
          this.mQueryqqLayout.setOnClickListener(new zv(this, localUtilFucntionItem));
        }
        if (localUtilFucntionItem.a().equals("103"))
        {
          this.mUtilLayout.setVisibility(0);
          if (!mShowUtilNew) {
            break label544;
          }
          this.mUtilNew.setVisibility(0);
        }
      }
      for (;;)
      {
        if (localUtilFucntionItem.c() != null) {
          this.scanutil.setText(localUtilFucntionItem.c());
        }
        this.mUtilLayout.setOnClickListener(new zw(this));
        i += 1;
        break label293;
        break;
        label522:
        this.mQRNew.setVisibility(4);
        break label345;
        label533:
        this.mQueryNew.setVisibility(4);
        break label413;
        label544:
        this.mUtilNew.setVisibility(4);
      }
      label555:
      this.mQRNew.setVisibility(4);
      break label218;
      label566:
      this.mQueryNew.setVisibility(4);
      break label232;
      label577:
      this.mUtilNew.setVisibility(4);
      break label246;
      label588:
      this.mConfigSafe.setVisibility(4);
    }
    label599:
    this.mConfigNew.setVisibility(4);
  }
  
  private void initFace()
  {
    QQUser localQQUser = ax.a().e();
    this.mQQFace.setOnClickListener(this.mQQFaceListener);
    this.mQQFace.setVisibility(0);
    this.qqface_not_verify.setVisibility(0);
    this.qqFaceNotVerify = ((TextView)findViewById(2131296349));
    if (localQQUser != null)
    {
      this.mQQFace.setVisibility(0);
      this.mQQFace.setImageDrawable(k.a(localQQUser.mRealUin + "", localQQUser.mUin + ""));
      if (!localQQUser.mIsBinded)
      {
        this.qqface_not_verify.setVisibility(8);
        this.qqFaceNotVerify.setVisibility(0);
        this.mQQFace_zzb.setVisibility(8);
        return;
      }
      this.qqFaceNotVerify.setVisibility(8);
      if (localQQUser.mIsZzb)
      {
        this.mQQFace_zzb.setVisibility(0);
        this.qqface_not_verify.setImageResource(2130838024);
        return;
      }
      this.mQQFace_zzb.setVisibility(8);
      this.qqface_not_verify.setImageResource(2130837522);
      return;
    }
    this.qqFaceNotVerify.setVisibility(8);
    this.mQQFace_zzb.setVisibility(8);
    this.mQQFace.setImageResource(2130837654);
    this.qqface_not_verify.setImageResource(2130837522);
  }
  
  private void initpoint()
  {
    if ((this.bannerlist == null) || (this.bannerlist.size() < 2)) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131297065);
    localLinearLayout.removeAllViewsInLayout();
    this.bannersize = this.bannerlist.size();
    this.imageViews = new ImageView[this.bannersize];
    int i = 0;
    label58:
    if (i < this.bannersize)
    {
      this.imageViews[i] = new ImageView(this);
      if (i != 0) {
        break label155;
      }
      this.imageViews[i].setBackgroundResource(2130837542);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(dip(8), dip(8)));
      localLayoutParams.leftMargin = dip(5);
      localLayoutParams.rightMargin = dip(5);
      localLinearLayout.addView(this.imageViews[i], localLayoutParams);
      i += 1;
      break label58;
      break;
      label155:
      this.imageViews[i].setBackgroundResource(2130837541);
    }
  }
  
  private boolean isBindUin()
  {
    QQUser localQQUser = ax.a().e();
    return (localQQUser == null) || (localQQUser.mIsBinded);
  }
  
  public void cancelRequest() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if ((b.d()) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      exitToken();
      return true;
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    mNeedRefreshMbInfo = true;
    super.onCreate(paramBundle);
    t.b(this.mConfig);
    setNeverShowLockVerifyView();
    setContentView(2130903194);
    RqdApplication.i().getSharedPreferences("sp_name_global", 0);
    this.mConfigNew = ((ImageView)findViewById(2131297084));
    this.mConfigSafe = ((ImageView)findViewById(2131297080));
    this.mUtilLayout = ((RelativeLayout)findViewById(2131297074));
    this.mQueryqqLayout = ((RelativeLayout)findViewById(2131297070));
    this.mQRCodeLayout = ((RelativeLayout)findViewById(2131297066));
    this.safenewsLayout = ((RelativeLayout)findViewById(2131297078));
    this.hotpromoteLayout = ((RelativeLayout)findViewById(2131297082));
    this.safenews_txt = ((TextView)findViewById(2131297081));
    this.hot_promote_txt = ((TextView)findViewById(2131297085));
    this.scanutil = ((TextView)findViewById(2131297075));
    this.queryqqtext = ((TextView)findViewById(2131297071));
    this.qrtext = ((TextView)findViewById(2131297067));
    paramBundle = (ImageView)findViewById(2131296421);
    if (paramBundle != null) {
      paramBundle.setImageResource(2130837768);
    }
    this.mQQFace = ((RoundImageView)findViewById(2131297141));
    this.mQQFace.setOnClickListener(this.mQQFaceListener);
    this.mQQFace_zzb = ((ImageView)findViewById(2131297143));
    this.qqface_not_verify = ((ImageView)findViewById(2131297142));
    paramBundle = (TextView)findViewById(2131296419);
    Object localObject = (MyViewPaper)findViewById(2131297064);
    ((MyViewPaper)localObject).setAdapter(this.adapter);
    ((MyViewPaper)localObject).setOnPageChangeListener(new zy(this));
    initpoint();
    this.banner = ((FrameLayout)findViewById(2131296707));
    this.mUtilNew = ((ImageView)findViewById(2131297076));
    this.mQRNew = ((ImageView)findViewById(2131297068));
    this.mQueryNew = ((ImageView)findViewById(2131297072));
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.token.activity_flag");
    LocalBroadcastManager.getInstance(this).registerReceiver(this.mReceiver, (IntentFilter)localObject);
    if (RqdApplication.g) {
      paramBundle.setOnClickListener(new zo(this, new long[2]));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    mNeedRefreshMbInfo = true;
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mReceiver);
  }
  
  protected void onResume()
  {
    if ((!RqdApplication.b) && (this.needgotologobyprotect))
    {
      gotoMbMobileProtect();
      this.needgotologobyprotect = false;
      super.onResume();
      return;
    }
    initFace();
    initConfig();
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SettingPageActivity
 * JD-Core Version:    0.7.0.1
 */