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
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.Gallery;
import com.tencent.widget.Gallery.a;
import com.tencent.widget.Gallery.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class sxi
  extends sye
  implements AdapterView.c, AdapterView.d, AdapterView.e, Gallery.a, Gallery.b, sxv
{
  protected AbstractImageAdapter a;
  protected sxh a;
  protected sxm a;
  protected sxu a;
  sxv a;
  public boolean aOa;
  protected Gallery b;
  protected View bgView;
  protected int bottomBarHeight;
  protected Activity mContext;
  protected RelativeLayout mRoot;
  
  public sxi(Activity paramActivity, sxm paramsxm)
  {
    this.jdField_a_of_type_Sxv = new sxj(this);
    this.mContext = paramActivity;
    this.jdField_a_of_type_Sxm = paramsxm;
  }
  
  public AbstractImageAdapter a()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter;
  }
  
  protected abstract AbstractImageAdapter a(Context paramContext);
  
  public Gallery a()
  {
    return this.b;
  }
  
  protected sxh a(Context paramContext)
  {
    return new sya();
  }
  
  protected sxu a()
  {
    return new syd();
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return true;
  }
  
  public void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.aA(paramBoolean1, paramBoolean2);
    if (this.bgView.getAnimation() != null) {
      this.bgView.clearAnimation();
    }
    if (this.b.getAnimation() != null) {
      this.b.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_Sxz.a().getAnimationDuring());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean2)
    {
      this.bgView.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new sxk(this));
    getRootView().startAnimation(localAlphaAnimation);
  }
  
  public void aB(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.aB(paramBoolean1, paramBoolean2);
    if (this.bgView.getAnimation() != null) {
      this.bgView.clearAnimation();
    }
    if (getRootView().getAnimation() != null) {
      getRootView().clearAnimation();
    }
    if (paramBoolean2)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.bgView.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(this.jdField_a_of_type_Sxz.a().getAnimationDuring());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new aurt());
    localAlphaAnimation.setDuration(this.jdField_a_of_type_Sxz.a().getAnimationDuring());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.rootView.getWidth() / 2, this.rootView.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(this.jdField_a_of_type_Sxz.a().getAnimationDuring());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new sxl(this));
    this.bgView.startAnimation(localAlphaAnimation);
    this.b.startAnimation(localAnimationSet);
  }
  
  public void bBN()
  {
    this.jdField_a_of_type_Sxz.a().a(this.jdField_a_of_type_Sxv);
  }
  
  public void bBO()
  {
    this.jdField_a_of_type_Sxz.a().a(this.jdField_a_of_type_Sxv);
    this.aOa = true;
  }
  
  public boolean back()
  {
    onBack();
    if (this.aOa) {
      this.jdField_a_of_type_Sxz.bBV();
    }
    for (;;)
    {
      return true;
      if (needExitRectAnimation()) {
        aB(false, this.jdField_a_of_type_Sxz.a().startExitAnimation());
      } else {
        this.jdField_a_of_type_Sxv.onExitAnimationEnd();
      }
    }
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131561547, null);
  }
  
  public void exitAnimation()
  {
    if (this.jdField_a_of_type_Sxz.aOd)
    {
      this.jdField_a_of_type_Sxz.aOd = false;
      return;
    }
    aB(true, this.jdField_a_of_type_Sxz.a.startExitAnimation());
  }
  
  public abstract void initData();
  
  public boolean isAnimating()
  {
    return this.jdField_a_of_type_Sxz.a().isAnimating();
  }
  
  protected boolean needEnterRectAnimation()
  {
    return true;
  }
  
  protected boolean needExitRectAnimation()
  {
    return true;
  }
  
  public boolean needShowPageView()
  {
    return true;
  }
  
  public void onBack()
  {
    this.jdField_a_of_type_Sxz.a().a(this.jdField_a_of_type_Sxv);
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    initData();
    this.mRoot = createLayout();
    if (paramViewGroup == null) {
      this.mContext.addContentView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      setRootView((ViewGroup)this.mRoot.findViewById(2131377546));
      this.b = ((Gallery)this.mContext.findViewById(2131367833));
      this.bgView = this.mContext.findViewById(2131363236);
      this.jdField_a_of_type_Sxh = a(this.mContext);
      if (this.jdField_a_of_type_Sxh != null) {
        this.jdField_a_of_type_Sxh.a(this.mContext, this, this.bottomBarHeight);
      }
      this.jdField_a_of_type_Sxu = a();
      if (this.jdField_a_of_type_Sxu != null) {
        this.jdField_a_of_type_Sxu.a(this.mContext, this);
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.mContext);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Sxm);
      if (this.jdField_a_of_type_Sxu != null)
      {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.a(this.jdField_a_of_type_Sxu);
        this.jdField_a_of_type_Sxu.show();
      }
      this.b.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.b.setSpacing(this.mContext.getResources().getDimensionPixelSize(2131297406));
      this.b.setSelection(this.jdField_a_of_type_Sxm.getSelectedIndex());
      this.b.setOnItemSelectedListener(this);
      this.b.setOnItemClickListener(this);
      this.b.setOnItemLongClickListener(this);
      this.b.setOnItemRotateListener(this);
      this.b.setOnScollListener(this);
      this.mRoot.setVisibility(4);
      return;
      paramViewGroup.addView(this.mRoot, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void onEnter()
  {
    this.jdField_a_of_type_Sxz.a().a(this.jdField_a_of_type_Sxv);
  }
  
  public void onEnterAnimationEnd() {}
  
  public void onEnterAnimationStart() {}
  
  public void onExitAnimationEnd() {}
  
  public void onExitAnimationStart() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onItemClick");
    }
    back();
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Sxh != null) && (needShowPageView())) {
        this.jdField_a_of_type_Sxh.a(paramAdapterView, paramInt);
      }
      this.jdField_a_of_type_Sxm.setSelectedIndex(paramInt);
      if ((!isAnimating()) && (this.jdField_a_of_type_Sxu != null) && (!this.jdField_a_of_type_Sxu.isShow())) {
        this.jdField_a_of_type_Sxu.show();
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter.onLoadProgressUpdate(paramView, paramInt);
    } while (!QLog.isColorLevel());
    QLog.i("AbstractGalleryScene", 2, "AbstractGalleryScene.onItemSelected(): position=" + paramInt);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause() {}
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(int paramInt)
  {
    if ((this.jdField_a_of_type_Sxu != null) && (!this.jdField_a_of_type_Sxu.isShow())) {
      this.jdField_a_of_type_Sxu.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollEnd:" + paramInt);
    }
  }
  
  public void onScrollStart(int paramInt)
  {
    if ((this.jdField_a_of_type_Sxu != null) && (this.jdField_a_of_type_Sxu.isShow())) {
      this.jdField_a_of_type_Sxu.hide();
    }
    if ((this.jdField_a_of_type_Sxu != null) && (this.jdField_a_of_type_Sxu.isStarted())) {
      this.jdField_a_of_type_Sxu.stop();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbstractGalleryScene", 2, "onScrollStart:" + paramInt);
    }
  }
  
  @TargetApi(11)
  public void onStart()
  {
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "gallery setColor black");
      }
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mRoot != null)) {
        updateSystemUIVisablity();
      }
      if (((AIOGalleryActivity)this.mContext).mSystemBarComp != null)
      {
        ((AIOGalleryActivity)this.mContext).mSystemBarComp.setStatusColor(-16777216);
        ((AIOGalleryActivity)this.mContext).mSystemBarComp.setStatusBarColor(-16777216);
      }
    }
    if (this.mRoot != null) {
      this.mRoot.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstart");
    }
  }
  
  public void onStop()
  {
    this.mRoot.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onstop");
    }
  }
  
  public void reset()
  {
    this.b.reset();
  }
  
  protected void updateSystemUIVisablity()
  {
    this.mRoot.setSystemUiVisibility(4);
  }
  
  public void vk(boolean paramBoolean)
  {
    if (needEnterRectAnimation())
    {
      aA(paramBoolean, this.jdField_a_of_type_Sxz.a().startEnterAnimation());
      return;
    }
    if (this.b != null) {
      this.b.setBackgroundColor(-16777216);
    }
    this.jdField_a_of_type_Sxv.onEnterAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxi
 * JD-Core Version:    0.7.0.1
 */