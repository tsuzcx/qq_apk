import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class xpf
  extends xqb
  implements bfpt, bfpu, bfpv, bfsc, bfsd, xps
{
  protected Activity a;
  protected RelativeLayout a;
  protected AbstractImageAdapter a;
  protected Gallery a;
  protected xpe a;
  protected xpj a;
  protected xpr a;
  xps a;
  protected int b;
  protected View d;
  public boolean f;
  
  public xpf(Activity paramActivity, xpj paramxpj)
  {
    this.jdField_a_of_type_Xps = new xpg(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Xpj = paramxpj;
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560957, null);
  }
  
  public AbstractImageAdapter a()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected abstract AbstractImageAdapter a(Context paramContext);
  
  public Gallery a()
  {
    return this.jdField_a_of_type_ComTencentWidgetGallery;
  }
  
  protected xpe a(Context paramContext)
  {
    return new xpx();
  }
  
  protected xpr a()
  {
    return new xqa();
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Xpr != null) && (this.jdField_a_of_type_Xpr.a())) {
      this.jdField_a_of_type_Xpr.b();
    }
    if ((this.jdField_a_of_type_Xpr != null) && (this.jdField_a_of_type_Xpr.b())) {
      this.jdField_a_of_type_Xpr.c();
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
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375493));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131366897));
      this.d = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362998);
      this.jdField_a_of_type_Xpe = a(this.jdField_a_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_Xpe != null) {
        this.jdField_a_of_type_Xpe.a(this.jdField_a_of_type_AndroidAppActivity, this, this.b);
      }
      this.jdField_a_of_type_Xpr = a();
      if (this.jdField_a_of_type_Xpr != null) {
        this.jdField_a_of_type_Xpr.a(this.jdField_a_of_type_AndroidAppActivity, this);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Xpj);
      if (this.jdField_a_of_type_Xpr != null)
      {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Xpr);
        this.jdField_a_of_type_Xpr.a();
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297009));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Xpj.b());
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
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Xpe != null) && (a())) {
        this.jdField_a_of_type_Xpe.a(paramAdapterView, paramInt);
      }
      this.jdField_a_of_type_Xpj.a(paramInt);
      if ((!d()) && (this.jdField_a_of_type_Xpr != null) && (!this.jdField_a_of_type_Xpr.a())) {
        this.jdField_a_of_type_Xpr.a();
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(paramView, paramInt);
    } while (!QLog.isColorLevel());
    QLog.i("AbstractGalleryScene", 2, "AbstractGalleryScene.onItemSelected(): position=" + paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.d.getAnimation() != null) {
      this.d.clearAnimation();
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery.getAnimation() != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_Xpw.a().a());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean2)
    {
      this.d.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new xph(this));
    a().startAnimation(localAlphaAnimation);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Xpr != null) && (!this.jdField_a_of_type_Xpr.a())) {
      this.jdField_a_of_type_Xpr.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollEnd:" + paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (b())
    {
      a(paramBoolean, this.jdField_a_of_type_Xpw.a().b());
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setBackgroundColor(-16777216);
    }
    this.jdField_a_of_type_Xps.b();
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.b(paramBoolean1, paramBoolean2);
    if (this.d.getAnimation() != null) {
      this.d.clearAnimation();
    }
    if (a().getAnimation() != null) {
      a().clearAnimation();
    }
    if (paramBoolean2)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.d.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(this.jdField_a_of_type_Xpw.a().a());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new bfoa());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_Xpw.a().a());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.jdField_a_of_type_AndroidViewViewGroup.getWidth() / 2, this.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(this.jdField_a_of_type_Xpw.a().a());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new xpi(this));
    this.d.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void c() {}
  
  protected boolean c()
  {
    return true;
  }
  
  public void d() {}
  
  public boolean d()
  {
    return this.jdField_a_of_type_Xpw.a().a();
  }
  
  public void e() {}
  
  public boolean e()
  {
    j();
    if (this.f)
    {
      this.jdField_a_of_type_Xpw.a();
      return true;
    }
    if (c()) {
      b(false, this.jdField_a_of_type_Xpw.a().c());
    }
    for (;;)
    {
      QQLiveImage.pauseAll(this.jdField_a_of_type_AndroidAppActivity);
      QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
      break;
      this.jdField_a_of_type_Xps.e();
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Xpw.a().a(this.jdField_a_of_type_Xps);
  }
  
  public void j()
  {
    this.jdField_a_of_type_Xpw.a().a(this.jdField_a_of_type_Xps);
  }
  
  @TargetApi(11)
  public void k()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "gallery setColor black");
      }
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
        q();
      }
      if (((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a != null)
      {
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a.setStatusColor(-16777216);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a.setStatusBarColor(-16777216);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstart");
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstop");
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_Xpw.a().a(this.jdField_a_of_type_Xps);
  }
  
  public void n()
  {
    this.jdField_a_of_type_Xpw.a().a(this.jdField_a_of_type_Xps);
    this.f = true;
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Xpw.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Xpw.jdField_a_of_type_Boolean = false;
      return;
    }
    b(true, this.jdField_a_of_type_Xpw.jdField_a_of_type_Xpd.c());
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onItemClick");
    }
    e();
  }
  
  public void p() {}
  
  protected void q()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(4);
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentWidgetGallery.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xpf
 * JD-Core Version:    0.7.0.1
 */