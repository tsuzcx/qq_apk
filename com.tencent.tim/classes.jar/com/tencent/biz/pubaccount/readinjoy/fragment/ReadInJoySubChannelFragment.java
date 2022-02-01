package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import kfs;
import kfv;
import lal;

public class ReadInJoySubChannelFragment
  extends ReadInJoyBaseFragment
{
  public static final String TAG = ReadInJoySubChannelFragment.class.getName();
  protected kfs a;
  protected int mChannelID = -1;
  protected String mChannelName;
  protected int mChannelType;
  protected View mContentView;
  
  public static ReadInJoySubChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoySubChannelFragment localReadInJoySubChannelFragment = new ReadInJoySubChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoySubChannelFragment.setArguments(localBundle);
    return localReadInJoySubChannelFragment;
  }
  
  private void initUI()
  {
    Object localObject = TAG;
    if (this.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d((String)localObject, 2, new Object[] { "initUI, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
      localObject = (ViewGroup)this.mContentView.findViewById(2131376777);
      this.a = new kfs(getActivity());
      this.a.oD(this.mChannelID);
      this.a.setChannelType(this.mChannelType);
      this.a.i((ViewGroup)localObject);
      this.a.onCreate();
      localObject = (ViewGroup)this.a.af();
      int i = ox();
      if (i > 0) {
        ((ViewGroup)localObject).setPadding(0, i, 0, 0);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.a != null)
    {
      this.a.onResume();
      paramActivity = (KandianMergeManager)this.mApp.getManager(162);
      if (paramActivity != null)
      {
        paramBundle = paramActivity.c();
        if ((paramActivity.Bw()) && (paramBundle != null)) {
          this.a.lP(true);
        }
      }
    }
  }
  
  public void aCc()
  {
    super.aCc();
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void aCe()
  {
    if (this.a != null) {
      this.a.aCe();
    }
  }
  
  public void aIq()
  {
    if (this.a != null) {
      this.a.lP(true);
    }
  }
  
  public int nh()
  {
    return this.mChannelID;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.a != null) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.mChannelID = ((Bundle)localObject).getInt("channel_id");
      this.mChannelType = ((Bundle)localObject).getInt("channel_type");
      this.mChannelName = ((Bundle)localObject).getString("channel_name");
    }
    localObject = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onCreate, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    this.mInflater = LayoutInflater.from(getActivity());
    this.mContentView = this.mInflater.inflate(2131560381, paramViewGroup, false);
    initUI();
    VideoReport.setPageId(this.mContentView, "8014");
    VideoReport.setPageParams(this.mContentView, new lal().a(this.mChannelID).a());
    paramLayoutInflater = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(paramLayoutInflater, 2, new Object[] { "onCreateView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
    paramLayoutInflater = this.mContentView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    String str = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onDestroy, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
    super.onDestroy();
    if (this.a != null) {
      this.a.onDestroy();
    }
    this.a = null;
  }
  
  public void onDestroyView()
  {
    boolean bool = false;
    String str = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onDestroyView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
    super.onDestroyView();
    this.mContentView = null;
  }
  
  public void onPause()
  {
    boolean bool = false;
    String str = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onPause, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID), ", mIsShowingSelf = ", Boolean.valueOf(this.ajy) });
    super.onPause();
    if ((this.a != null) && (this.ajy)) {
      this.a.onPause();
    }
  }
  
  public void onResume()
  {
    boolean bool = false;
    String str = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onResume, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID), ", mIsShowingSelf = ", Boolean.valueOf(this.ajy) });
    super.onResume();
    if ((this.a != null) && (this.ajy)) {
      this.a.onResume();
    }
  }
  
  public void onStart()
  {
    boolean bool = false;
    String str = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onStart, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
    super.onStart();
    if (this.a != null) {
      this.a.onStart();
    }
  }
  
  public void onStop()
  {
    boolean bool = false;
    String str = TAG;
    if (this.a != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onStop, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.mChannelID) });
    super.onStop();
    if (this.a != null) {
      this.a.onStop();
    }
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    if (this.a != null)
    {
      this.a.lP(true);
      return;
    }
    kfv.oK(nh());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment
 * JD-Core Version:    0.7.0.1
 */