package com.tencent.mobileqq.ar.view;

import adkl;
import admh;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import aqfy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public abstract class ScanEntryProviderView
  extends FrameLayout
{
  public adkl a;
  public admh a;
  private boolean bPR = true;
  public AppInterface mAppInterface;
  protected View mContentView;
  public Context mContext;
  public boolean mInited;
  protected boolean mIsPaused;
  public boolean uA;
  
  public ScanEntryProviderView(Context paramContext, admh paramadmh)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.jdField_a_of_type_Admh = paramadmh;
  }
  
  protected void GB(boolean paramBoolean)
  {
    if (this.bPR != paramBoolean)
    {
      this.bPR = paramBoolean;
      if (this.jdField_a_of_type_Admh != null) {
        this.jdField_a_of_type_Admh.Gz(paramBoolean);
      }
    }
  }
  
  public void Gs(boolean paramBoolean) {}
  
  public void Gz(String paramString) {}
  
  public void Wv()
  {
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.mContext;
    Intent localIntent = new Intent(localScanTorchActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 45);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanTorchActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
    localScanTorchActivity.startActivity(localIntent);
    aqfy.anim(localScanTorchActivity, false, true);
  }
  
  public boolean afl()
  {
    return ((ScanTorchActivity)this.mContext).isResume();
  }
  
  public void b(ARCommonConfigInfo paramARCommonConfigInfo) {}
  
  public void cSR()
  {
    this.uA = true;
    this.mIsPaused = false;
    if (this.jdField_a_of_type_Adkl != null) {
      this.jdField_a_of_type_Adkl.resume();
    }
  }
  
  public void cSS()
  {
    this.uA = false;
    this.mIsPaused = true;
    if (this.jdField_a_of_type_Adkl != null) {
      this.jdField_a_of_type_Adkl.pause();
    }
  }
  
  public void cTs()
  {
    ((ScanTorchActivity)this.mContext).doOnBackPressed(false);
  }
  
  public abstract void onCreate(Bundle paramBundle);
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Adkl != null) {
      this.jdField_a_of_type_Adkl.uninit();
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Adkl != null) {
      this.jdField_a_of_type_Adkl.pause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_Adkl != null) {
      this.jdField_a_of_type_Adkl.resume();
    }
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.mAppInterface = paramAppInterface;
  }
  
  public void setRectAreas(Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderView
 * JD-Core Version:    0.7.0.1
 */