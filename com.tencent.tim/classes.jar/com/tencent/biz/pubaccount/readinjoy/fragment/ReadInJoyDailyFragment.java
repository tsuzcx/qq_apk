package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import awix;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kfa;
import kge;
import kvs;
import kxm;
import kxy;
import kys;
import kzw;
import lal;
import lcc;
import lcm;
import ldt;
import ldu;
import ldv;
import lwg;
import meu;
import mqq.os.MqqHandler;
import oax;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  private static kxy jdField_b_of_type_Kxy = new kxy();
  public static List<String> gh = new ArrayList(1);
  private kfa a;
  private int aIV = 5;
  private boolean ajD;
  private BroadcastReceiver ak = new ldu(this);
  private kge jdField_b_of_type_Kge;
  private final View.OnClickListener ck = new ldt(this);
  private Runnable cv = new ReadInJoyDailyFragment.1(this);
  private View kf;
  private View mRoot;
  
  public static boolean BV()
  {
    return gh.size() > 0;
  }
  
  private boolean BW()
  {
    return (this.aIV == 6) || (this.aIV == 9);
  }
  
  private void aKL()
  {
    if (getActivity() != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("float_layer_finsh_action");
      getActivity().registerReceiver(this.ak, localIntentFilter);
    }
  }
  
  private void aKM()
  {
    if (getActivity() != null) {
      getActivity().unregisterReceiver(this.ak);
    }
  }
  
  private void aKO()
  {
    jdField_b_of_type_Kxy.reset();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public static void aKP()
  {
    if (jdField_b_of_type_Kxy != null)
    {
      jdField_b_of_type_Kxy.aIc();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  public static void aKQ()
  {
    if (jdField_b_of_type_Kxy != null)
    {
      jdField_b_of_type_Kxy.wakeUp();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void aR(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        kvs.aP(paramIntent);
      } while (!BW());
      paramIntent = kxm.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(162);
    localKandianMergeManager.aID();
    localKandianMergeManager.aIW();
    kxm.P(paramIntent);
    kxm.mO(false);
  }
  
  private void nb(String paramString)
  {
    if (kys.du(kys.getChannelId())) {}
    for (String str = "0X80089D1";; str = "0X80098B0")
    {
      ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.4(this, paramString, str));
      return;
    }
  }
  
  private void oO(int paramInt)
  {
    lcc.a().a(new ldv(this, paramInt));
  }
  
  private void preloadWebProcess()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.6(this));
  }
  
  public void aKN()
  {
    if (ThemeUtil.isNowThemeIsNight(kxm.getAppRuntime(), false, null))
    {
      if (this.kf == null) {
        this.kf = ((ViewStub)this.mRoot.findViewById(2131365575)).inflate();
      }
      if (this.kf != null) {
        this.kf.setVisibility(0);
      }
    }
    while (this.kf == null) {
      return;
    }
    this.kf.setVisibility(8);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("launch_from")))
    {
      int i = getActivity().getIntent().getIntExtra("launch_from", 0);
      if ((i == 9) || (i == 6))
      {
        Intent localIntent = new Intent(getActivity(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", MainFragment.bIk);
        localIntent.putExtra("open_kandian_tab_fragment", true);
        localIntent.putExtra("arg_channel_cover_id", 0);
        localIntent.setFlags(335544320);
        getActivity().startActivity(localIntent);
      }
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kys.aIj();
    kvs.d(getActivity().app);
    kvs.aHz();
    gh.add(String.valueOf(hashCode()));
    meu.a().cQ(meu.aQO, 1);
    oax.bcY();
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      localObject = paramBundle.getIntent();
      if (localObject != null) {
        this.aIV = ((Intent)localObject).getIntExtra("launch_from", 5);
      }
      aR((Intent)localObject);
    }
    ThreadManager.getFileThreadHandler().postDelayed(this.cv, 20000L);
    lwg.a().onCreate();
    oO(0);
    preloadWebProcess();
    Object localObject = getArguments();
    if (this.aIV == 15)
    {
      kxm.isFromAIO = true;
      QLog.d("ReadInJoyDailyFragment", 1, "from aio share");
    }
    for (int i = 1;; i = 0)
    {
      if ((localObject != null) && (paramBundle != null))
      {
        if (((Bundle)localObject).getBoolean("open_floating_window", false)) {
          i = 1;
        }
        if (i != 0)
        {
          QLog.d("ReadInJoyDailyFragment", 1, "openFloatingWindow is true");
          i = ((Bundle)localObject).getInt("floating_window_business");
          int j = ((Bundle)localObject).getInt("floating_window_scene");
          awix.a(paramBundle, j, i, (Bundle)localObject, kys.getChannelId());
          if ((j == 1) && ((i != 1) || (awix.J((Bundle)localObject)))) {
            kvs.oT(32);
          }
        }
      }
      aKL();
      kxm.aIb();
      aKO();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    kzw.init();
    this.mRoot = paramLayoutInflater.inflate(2131560337, paramViewGroup, false);
    lcm.b(0, kvs.z(), 0);
    this.jdField_b_of_type_Kge = new kge(getActivity());
    this.jdField_b_of_type_Kge.oD(kys.getChannelId());
    paramLayoutInflater = (ViewGroup)this.mRoot.findViewById(2131376777);
    this.jdField_b_of_type_Kge.i(paramLayoutInflater);
    this.jdField_b_of_type_Kge.onCreate();
    this.a = new kfa(this.jdField_b_of_type_Kge.getVafContext());
    this.a.setOnTitleClickListener(this.ck);
    this.a.bW(this.mRoot);
    aKN();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.mRoot, "8014");
    VideoReport.setPageParams(this.mRoot, new lal().a(kys.getChannelId()).a());
    paramLayoutInflater = this.mRoot;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gh.remove(String.valueOf(hashCode()));
    oax.bcZ();
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.onDestroy();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.cv);
    lwg.a().onDestroy();
    oO(5);
    aKM();
  }
  
  public void onDestroyView()
  {
    this.a.onDestroyView();
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getActivity().setIntent(paramIntent);
    if (paramIntent != null) {
      this.aIV = paramIntent.getIntExtra("launch_from", 5);
    }
    aR(paramIntent);
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.refreshList();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.onPause();
    }
    ApngImage.pauseByTag(31);
    oO(3);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.onResume();
    }
    RecommendFeedsDiandianEntranceManager.a().aXU();
    ApngImage.playByTag(31);
    oO(2);
    kbp.a(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.onStart();
    }
    if (jdField_b_of_type_Kxy != null) {
      jdField_b_of_type_Kxy.wakeUp();
    }
    oO(1);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_Kge != null) {
      this.jdField_b_of_type_Kge.onStop();
    }
    if ((!BaseActivity.mAppForground) && (jdField_b_of_type_Kxy != null)) {
      jdField_b_of_type_Kxy.aIc();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_b_of_type_Kge != null) {
        this.jdField_b_of_type_Kge.aBZ();
      }
      meu.a().aOS();
      lcm.b(1, kvs.z(), kvs.nM());
      if (!this.ajD) {
        nb(kvs.iL());
      }
      kvs.aHy();
      kxm.isFromAIO = false;
      kys.aIk();
    }
    oO(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */