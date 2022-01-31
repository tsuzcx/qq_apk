package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.common.galleryactivity.ImageScene;
import ebp;

public class AIOGalleryActivity
  extends PeakActivity
{
  GalleryManager a;
  public IAIOImageProvider a;
  
  public AIOGalleryActivity()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new ebp(this, null);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOConstants.a = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    ImageScene localImageScene = this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    if (localImageScene != null) {
      return localImageScene.a(paramMenuItem);
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    ImageScene localImageScene = this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    if (localImageScene != null) {
      return localImageScene.a(paramMenu);
    }
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */