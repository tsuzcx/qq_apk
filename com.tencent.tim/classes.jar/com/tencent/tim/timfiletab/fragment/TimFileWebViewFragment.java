package com.tencent.tim.timfiletab.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.ViewGroup;
import aobu;
import aobw;
import aqzl;
import araz;
import arbt;
import arcd.a;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import svi;

public class TimFileWebViewFragment
  extends WebViewFragment
{
  private a a;
  
  public static TimFileWebViewFragment a(String paramString1, FragmentActivity paramFragmentActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramFragmentActivity == null)) {
      return null;
    }
    TimFileWebViewFragment localTimFileWebViewFragment = (TimFileWebViewFragment)paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(paramString2);
    Object localObject = new Intent();
    if (localTimFileWebViewFragment == null) {
      try
      {
        ((Intent)localObject).putExtra("url", paramString1);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("webStyle", "noBottomBar");
        ((Intent)localObject).putExtra("isScreenOrientationPortrait", true);
        ((Intent)localObject).putExtra("title", "");
        ((Intent)localObject).putExtra("isFullScreen", paramBoolean1);
        ((Intent)localObject).putExtra("isTitleImmersive", paramBoolean2);
        paramString1 = new Bundle();
        paramString1.putParcelable("intent", (Parcelable)localObject);
        localObject = new TimFileWebViewFragment();
        ((TimFileWebViewFragment)localObject).setArguments(paramString1);
        paramFragmentActivity.getSupportFragmentManager().beginTransaction().add(paramInt, (Fragment)localObject, paramString2).commitAllowingStateLoss();
        QLog.d("WebLog_WebViewFragment", 1, "TimFileWebViewFragment is new");
        return localObject;
      }
      catch (IllegalArgumentException paramString1)
      {
        QLog.e("WebLog_WebViewFragment", 1, "TimFileWebViewFragment error = " + paramString1);
        return null;
      }
    }
    localTimFileWebViewFragment.mUrl = paramString1;
    localTimFileWebViewFragment.aCP();
    QLog.d("WebLog_WebViewFragment", 1, "TimFileWebViewFragment is not new");
    return localTimFileWebViewFragment;
  }
  
  public void Qq()
  {
    arbt localarbt = (arbt)this.jdField_a_of_type_Araz.q(4);
    if (localarbt != null)
    {
      if ((this.jdField_a_of_type_Svi != null) && (aobw.pN(this.jdField_a_of_type_Svi.getShareUrl())))
      {
        aobu localaobu = new aobu(getHostActivity());
        localaobu.s((TeamWorkFileImportInfo)getIntent().getParcelableExtra("key_team_work_file_import_info"));
        localarbt.a = localaobu;
      }
      localarbt.a(this.jdField_a_of_type_Svi, this.jdField_a_of_type_Arcd$a.gK);
    }
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentTimTimfiletabFragmentTimFileWebViewFragment$a = parama;
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    if ((this.jdField_a_of_type_Aqzl == null) || (this.jdField_a_of_type_Aqzl.aK == null)) {
      return i;
    }
    this.jdField_a_of_type_Aqzl.aK.setVisibility(8);
    return i;
  }
  
  public void initWebView()
  {
    super.initWebView();
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timfiletab.fragment.TimFileWebViewFragment
 * JD-Core Version:    0.7.0.1
 */