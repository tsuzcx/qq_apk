package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public abstract class FolderBaseTabFragment
  extends ReportV4Fragment
{
  public static String TAG = "FolderBaseTabFragment";
  public static int bdd;
  public static int bde = 1;
  protected boolean mHasInit;
  protected View mRootView;
  protected String mUin = "";
  
  public abstract void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt);
  
  protected abstract void initViewData();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.mUin = getActivity().app.getAccount();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (!this.mHasInit))
    {
      initViewData();
      this.mHasInit = true;
    }
    QLog.d(TAG, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */