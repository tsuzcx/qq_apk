package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import bvw;
import bvx;
import bvy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ViscousFluidInterpolator;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.Gallery;
import com.tencent.widget.Gallery.OnItemRotateListener;
import com.tencent.widget.Gallery.OnScollListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractGalleryScene
  extends ImageScene
  implements AnimationLister, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener, Gallery.OnItemRotateListener, Gallery.OnScollListener
{
  private static final String jdField_a_of_type_JavaLangString = "AbstractGalleryScene";
  public Activity a;
  protected RelativeLayout a;
  public AbstractGalleryPageView a;
  protected AbstractImageAdapter a;
  protected AbstractImageListModel a;
  public AbstractProgressView a;
  AnimationLister jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = new bvw(this);
  public Gallery a;
  protected int b;
  View b;
  boolean f = false;
  
  public AbstractGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  private void a(ActionBarActivity paramActionBarActivity)
  {
    try
    {
      Field localField = ActionBarActivity.class.getDeclaredField("mImpl");
      localField.setAccessible(true);
      Object localObject = Class.forName("android.support.v7.app.ActionBarActivityDelegate");
      return;
    }
    catch (NoSuchFieldException paramActionBarActivity)
    {
      try
      {
        localObject = ((Class)localObject).getDeclaredMethod("createDelegate", new Class[] { ActionBarActivity.class });
        ((Method)localObject).setAccessible(true);
        localField.set(paramActionBarActivity, ((Method)localObject).invoke(null, new Object[] { paramActionBarActivity }));
        return;
      }
      catch (NoSuchMethodException paramActionBarActivity)
      {
        paramActionBarActivity.printStackTrace();
        return;
        paramActionBarActivity = paramActionBarActivity;
        paramActionBarActivity.printStackTrace();
        return;
      }
      catch (InvocationTargetException paramActionBarActivity)
      {
        paramActionBarActivity.printStackTrace();
        return;
      }
    }
    catch (IllegalAccessException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
    }
  }
  
  private void b(ActionBarActivity paramActionBarActivity)
  {
    try
    {
      Field localField = ActionBarActivity.class.getDeclaredField("mImpl");
      localField.setAccessible(true);
      paramActionBarActivity = localField.get(paramActionBarActivity);
      localField = Class.forName("android.support.v7.app.ActionBarActivityDelegate").getDeclaredField("mHasActionBar");
      localField.setAccessible(true);
      localField.setBoolean(paramActionBarActivity, false);
      return;
    }
    catch (NoSuchFieldException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
      return;
    }
    catch (IllegalArgumentException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
      return;
    }
    catch (ClassNotFoundException paramActionBarActivity)
    {
      paramActionBarActivity.printStackTrace();
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903598, null);
  }
  
  protected AbstractGalleryPageView a(Context paramContext)
  {
    return new GalleryPageView();
  }
  
  protected abstract AbstractImageAdapter a(Context paramContext);
  
  protected AbstractProgressView a()
  {
    return new GalleryProgressView();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a()) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b();
    }
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b()) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollStart:" + paramInt);
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
    if (paramViewGroup == null)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof ActionBarActivity)) {
        a((ActionBarActivity)this.jdField_a_of_type_AndroidAppActivity);
      }
      if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
      {
        paramViewGroup = ((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
        if ((paramViewGroup instanceof ActionBarActivity)) {
          b((ActionBarActivity)paramViewGroup);
        }
      }
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131231116));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131231775));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131230991);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView = a(this.jdField_a_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView = a();
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a(this.jdField_a_of_type_AndroidAppActivity, this);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel);
      if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null)
      {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView);
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setRotateEnable(true);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427408));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.b());
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemRotateListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnScollListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.jdField_b_of_type_AndroidViewView.getAnimation() != null) {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery.getAnimation() != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean2)
    {
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new bvx(this));
    a().startAnimation(localAlphaAnimation);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView != null) && (a())) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(paramAdapterView, paramInt);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a(paramInt);
      if ((!c()) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (!this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(paramView, paramInt);
    } while (!QLog.isColorLevel());
    QLog.i("AbstractGalleryScene", 2, "AbstractGalleryScene.onItemSelected(): position=" + paramInt);
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (!this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollEnd:" + paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (b())
    {
      a(paramBoolean, this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().b());
      return;
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.b();
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramBoolean2);
    if (this.jdField_b_of_type_AndroidViewView.getAnimation() != null) {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
    }
    if (a().getAnimation() != null) {
      a().clearAnimation();
    }
    if (paramBoolean2)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new ViscousFluidInterpolator());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.jdField_a_of_type_AndroidViewViewGroup.getWidth() / 2, this.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new bvy(this));
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a();
  }
  
  public void d() {}
  
  public boolean d()
  {
    i();
    if (this.f) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    }
    for (;;)
    {
      return true;
      if (b()) {
        b(false, this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().c());
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister.e();
      }
    }
  }
  
  public void e() {}
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstart");
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstop");
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene
 * JD-Core Version:    0.7.0.1
 */