package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import bxq;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.qphone.base.util.QLog;

public class AIOGalleryActivity
  extends PeakActivity
{
  private static AIOGalleryCollector jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector;
  GalleryManager jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new bxq(this, null);
  public IAIOImageProvider a;
  
  public static AIOGalleryCollector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector == null) {
      jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector = new AIOGalleryCollector();
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOConstants.a = getResources().getDisplayMetrics().density;
    jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector = new AIOGalleryCollector();
    try
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(this);
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e(g, 2, "", paramBundle);
      }
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
      label20:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c(this);
      if (jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector != null)
      {
        jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector.a(1);
        jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector.a(15);
        jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryCollector = null;
      }
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */