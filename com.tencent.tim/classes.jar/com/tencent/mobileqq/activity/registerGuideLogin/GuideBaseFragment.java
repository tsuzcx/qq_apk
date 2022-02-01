package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import vgy;

public class GuideBaseFragment
  extends ReportV4Fragment
{
  protected a a;
  protected vgy a;
  public String bdr;
  public BaseActivity m;
  public QQAppInterface mAppInterface;
  
  public GuideBaseFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public GuideBaseFragment(QQAppInterface paramQQAppInterface)
  {
    this.mAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Vgy = new vgy();
  }
  
  public boolean WJ()
  {
    return false;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$a = parama;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.m = getActivity();
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    return null;
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog) {}
  
  public String qB()
  {
    return this.bdr;
  }
  
  public static abstract interface a
  {
    public abstract void a(GuideBaseFragment paramGuideBaseFragment);
    
    public abstract void bQW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment
 * JD-Core Version:    0.7.0.1
 */