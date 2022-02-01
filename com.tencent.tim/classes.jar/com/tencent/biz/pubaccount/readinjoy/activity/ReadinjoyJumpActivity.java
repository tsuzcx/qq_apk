package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import aqfo;
import arju;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import kbp;
import kjn;
import kxm;
import kxs;
import kys;
import kzc;
import lbz;
import lcc;
import lce;
import lhu.b;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyJumpActivity
  extends IphoneTitleBarFragment
  implements lhu.b
{
  private static Runnable cx;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private boolean afP;
  private boolean afQ;
  private boolean afR;
  private Runnable cw = new ReadinjoyJumpActivity.1(this);
  private lce d = new kjn(this);
  private int launchFrom = 0;
  private arju mProgressBarController;
  private long sg = -1L;
  
  private void aC()
  {
    if (this.afP) {
      return;
    }
    aCM();
    if (this.leftView != null)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130850369);
    }
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      if (!ThemeUtil.isInNightMode(kxm.getAppRuntime())) {
        break label79;
      }
      getTitleBarView().setBackgroundColor(Color.parseColor("#888888"));
    }
    for (;;)
    {
      this.afP = true;
      return;
      label79:
      getTitleBarView().setBackgroundColor(-1);
    }
  }
  
  private void aDC()
  {
    boolean bool1;
    try
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        bool1 = this.afR;
        if (!bool1) {
          break label25;
        }
      }
      for (;;)
      {
        return;
        label25:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          break;
        }
        localFragmentActivity.finish();
      }
      this.afQ = true;
    }
    finally {}
    this.afR = true;
    int i = kxs.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    switch (i)
    {
    }
    for (;;)
    {
      for (;;)
      {
        lbz.a().H(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
        Object localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("algorithm_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID);
          ((JSONObject)localObject).put("rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
          kxm.a(false, (JSONObject)localObject);
          kbp.a(null, "", "0X80094C3", "0X80094C3", 0, 0, "" + this.launchFrom, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId + "", ((JSONObject)localObject).toString(), false);
          QLog.d("ReadinjoyJumpActivity", 1, new Object[] { "do dump action, type : ", Integer.valueOf(i), ", needFinfishActivity : " + this.afQ });
          if (!this.afQ) {
            break;
          }
          localContext.finish();
          break;
          localObject = kxs.b(localContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          ((Intent)localObject).putExtra("from_native", true);
          if (!((Intent)localObject).getBooleanExtra("is_native_fast_web", false)) {
            this.afQ = false;
          }
          localContext.startActivity((Intent)localObject);
          localContext.overridePendingTransition(0, 0);
          continue;
          Intent localIntent = kxs.a(localContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          localIntent.putExtra("VIDEO_FROM_TYPE", 27);
          localObject = localIntent.getExtras();
          bool1 = false;
          try
          {
            boolean bool2 = kzc.b(((Bundle)localObject).getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(((Bundle)localObject).getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(((Bundle)localObject).getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(((Bundle)localObject).getString("VIDEO_TIME")).intValue());
            bool1 = bool2;
          }
          catch (Exception localException)
          {
            label453:
            break label453;
          }
          if (bool1)
          {
            localIntent = new Intent();
            localIntent.putExtras((Bundle)localObject);
            MultiVideoFragment.s(localContext, localIntent);
          }
          else
          {
            localContext.startActivity(localIntent);
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent, long paramLong)
  {
    if (cx != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(cx);
    }
    long l = paramIntent.getLongExtra("jump_article_param_ids", -1L);
    paramIntent.removeExtra("jump_article_param_ids");
    cx = new ReadinjoyJumpActivity.4(l, paramIntent, paramContext);
    if (l != -1L) {
      ThreadManager.getSubThreadHandler().postDelayed(cx, paramLong);
    }
    QLog.d("ReadinjoyJumpActivity", 1, "jump activity, ids : " + l + ", delay : " + paramLong);
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.mContentView.findViewById(2131373669));
    this.mProgressBarController = new arju();
    this.mProgressBarController.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.mProgressBarController);
    this.mProgressBarController.enterStatus((byte)0);
  }
  
  private void nK()
  {
    this.mProgressBarController.enterStatus((byte)2);
    if (this.mContentView != null) {
      this.mContentView.findViewById(2131366514).setVisibility(0);
    }
    QLog.d("ReadinjoyJumpActivity", 1, "show error page!");
  }
  
  public static boolean p(Intent paramIntent)
  {
    return paramIntent.hasExtra("jump_article_param_ids");
  }
  
  public static boolean q(Intent paramIntent)
  {
    return paramIntent.hasExtra("daily_lock_screen_flag");
  }
  
  public static boolean r(Intent paramIntent)
  {
    return paramIntent.hasExtra("kan_dian_lock_screen_flag");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    QLog.d("ReadinjoyJumpActivity", 2, "get fastWeb info resp, isSucc : " + paramBoolean1 + ", useWeb : " + paramBoolean2 + ", data : " + paramFastWebArticleInfo + ", needFinfish : " + this.afQ);
    if (this.afQ) {
      return;
    }
    if ((paramBoolean1) && (getActivity() != null))
    {
      aDC();
      return;
    }
    nK();
  }
  
  public void aCM()
  {
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact;
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(((PublicFragmentActivity)localFragmentActivity).getAppRuntime())) {
          break label95;
        }
        if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
          break label82;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label82:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label95:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      ((PublicFragmentActivity)localFragmentActivity).getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 0;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    getActivity().getWindow().setFlags(16777216, 16777216);
    initUI();
    this.sg = getActivity().getIntent().getLongExtra("jump_article_param_ids", -1L);
    this.launchFrom = getActivity().getIntent().getIntExtra("jump_activity_launch_from", 0);
    if (this.sg == -1L) {
      getActivity().finish();
    }
    do
    {
      return;
      paramLayoutInflater = new JSONObject();
      kxm.a(false, paramLayoutInflater);
      kbp.a(null, "", "0X80094C1", "0X80094C1", 0, 0, "" + this.launchFrom, this.sg + "", "", paramLayoutInflater.toString(), false);
      QLog.d("ReadinjoyJumpActivity", 1, "param_article_id : " + this.sg);
      if (getActivity().getIntent().getBooleanExtra("daily_lock_screen_param", false)) {
        i = kys.getChannelId();
      }
      int j = i;
      if (this.launchFrom == 0) {
        j = getActivity().getIntent().getIntExtra("arg_channel_cover_id", i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = lbz.a().b(j, this.sg);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null);
    ThreadManager.getUIHandler().postDelayed(this.cw, 60000L);
    lcc.a().b(this.d);
  }
  
  public int getContentLayoutId()
  {
    return 2131560403;
  }
  
  public boolean onBackEvent()
  {
    String str = this.sg + "";
    JSONObject localJSONObject = new JSONObject();
    kxm.a(false, localJSONObject);
    kbp.a(null, "", "0X80094C2", "0X80094C2", 0, 0, this.launchFrom + "", str, "", localJSONObject.toString(), false);
    this.afQ = true;
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.d);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    aC();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.afQ)
    {
      lcc.a().c(this.d);
      getActivity().finish();
    }
    QLog.d("ReadinjoyJumpActivity", 2, "onStop, needFinfish : " + this.afQ);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.afR)) {
      ThreadManager.getSubThreadHandler().post(new ReadinjoyJumpActivity.3(this));
    }
    if ((!paramBoolean) && (this.afR) && (this.afQ)) {
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity
 * JD-Core Version:    0.7.0.1
 */