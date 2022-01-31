package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import tu;
import tv;

public abstract class GalleryManager
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public AbstractAnimationManager a;
  public AbstractGalleryScene a;
  protected AbstractImageListModel a;
  public AbstractImageListScene a;
  private ImageScene jdField_a_of_type_ComTencentCommonGalleryactivityImageScene;
  private boolean jdField_a_of_type_Boolean;
  ViewGroup b;
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.h();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    GalleryImage localGalleryImage = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.k();
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.a();
      localGalleryImage.a = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.b(paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.l();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a().a = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.a();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.j();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.b(true, this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager.c());
  }
  
  public RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidAppActivity.addContentView(localRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    return localRelativeLayout;
  }
  
  public AbstractAnimationManager a()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager;
  }
  
  public AbstractAnimationManager a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new AnimationManager(paramActivity, paramAbstractImageListModel);
  }
  
  public abstract AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel);
  
  public abstract AbstractImageListModel a(Activity paramActivity);
  
  public abstract AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel);
  
  public AnimationView a()
  {
    AnimationView localAnimationView = new AnimationView(this.jdField_a_of_type_AndroidAppActivity, null);
    localAnimationView.setId(2131297188);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public ImageScene a()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene;
  }
  
  public void a()
  {
    if (!a()) {}
    label121:
    do
    {
      do
      {
        do
        {
          return;
        } while (a().a());
        if (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene != this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene) {
          break label121;
        }
        if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene != null) {
          break;
        }
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel);
      } while (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene == null);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.a(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.a(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.h();
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.a().post(new tu(this));
      this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene;
      return;
    } while (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene != this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.a().post(new tv(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = a(paramActivity);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager = a(paramActivity, this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel);
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene == null)
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene = a(paramActivity, this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.a();
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene;
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene.a(paramConfiguration);
    }
  }
  
  public void a(AbstractAnimationManager paramAbstractAnimationManager)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager = paramAbstractAnimationManager;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene != null) {
      return this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene == this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene)) {
      a(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene != null)
    {
      if ((!a().a()) && (!this.jdField_a_of_type_ComTencentCommonGalleryactivityImageScene.e())) {}
      return true;
    }
    return false;
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene.f();
    }
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.GalleryManager
 * JD-Core Version:    0.7.0.1
 */