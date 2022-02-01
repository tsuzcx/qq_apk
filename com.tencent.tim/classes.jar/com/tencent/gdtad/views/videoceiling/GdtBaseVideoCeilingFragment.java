package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import tkw;
import tls;

public abstract class GdtBaseVideoCeilingFragment
  extends PublicBaseFragment
{
  public static String KEY_FROM_PROCESS_NAME = "key_from_process_name";
  public static String KEY_RESULT_RECEIVER = "key_result_receiver";
  public static String aJA = "key_ad_position";
  private GdtVideoCeilingView a;
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseVideoCeilingFragment> paramClass, GdtVideoCeilingData paramGdtVideoCeilingData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()))
    {
      tkw.e("GdtBaseVideoCeilingFragment", "start error");
      return;
    }
    tkw.i("GdtBaseVideoCeilingFragment", "start");
    Object localObject = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      ((Bundle)localObject).putAll(paramBundle);
    }
    ((Bundle)localObject).putSerializable("data", paramGdtVideoCeilingData);
    paramBundle = new Intent();
    if ((paramGdtVideoCeilingData.getAd() != null) && (paramGdtVideoCeilingData.getAd().getNocoId() != 0L)) {
      paramBundle.putExtra("GdtNocoId", paramGdtVideoCeilingData.getAd().getNocoId());
    }
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras((Bundle)localObject);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      tkw.e("GdtBaseVideoCeilingFragment", "start gdt empty refId");
    }
    localObject = AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity);
    if (paramGdtVideoCeilingData.getStyle() == 4) {
      AdProcessManager.INSTANCE.getMainProcessName();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBundle.putExtra(KEY_FROM_PROCESS_NAME, (String)localObject);
      }
      if (paramGdtVideoCeilingData.getStyle() != 4) {
        break;
      }
      PublicFragmentActivity.b.start(paramActivity, paramBundle, PublicFragmentActivity.class, paramClass);
      return;
      AdProcessManager.INSTANCE.getWebProcessName();
    }
    PublicFragmentActivity.b.start(paramActivity, paramBundle, PublicFragmentActivityForTool.class, paramClass);
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    Object localObject = getArguments();
    if (localObject != null)
    {
      localObject = (ResultReceiver)((Bundle)localObject).getParcelable(KEY_RESULT_RECEIVER);
      if ((localObject != null) && (this.a != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong(aJA, this.a.getCurrentPosition());
        ((ResultReceiver)localObject).send(-1, localBundle);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    return (this.a != null) && (this.a.back());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559400, paramViewGroup, false);
    this.a = ((GdtVideoCeilingView)paramLayoutInflater.findViewById(2131381839));
    tls.e(this.a);
    this.a.onCreate(paramBundle);
    if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof GdtVideoCeilingData))) {
      this.a.setData((GdtVideoCeilingData)getArguments().getSerializable("data"));
    }
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(16);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.a != null) {
      this.a.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment
 * JD-Core Version:    0.7.0.1
 */