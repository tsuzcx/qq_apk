import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;

@TargetApi(17)
public class awwk
{
  private View LX;
  private View LY;
  private View LZ;
  private View Ma;
  private axpu a = new awwm(this);
  private awzw jdField_b_of_type_Awzw;
  private final AECameraGLSurfaceView jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private VideoFilterViewPager jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  public AEMaterialPanel c;
  private boolean dtm = true;
  private ViewGroup fb;
  public View mRootView;
  
  public awwk(View paramView, awrx paramawrx)
  {
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.mRootView = paramView;
    this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364201));
    this.c = ((AEMaterialPanel)this.mRootView.findViewById(2131373750));
    this.Ma = this.mRootView.findViewById(2131362312);
    this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.mRootView.findViewById(2131367272));
    a(paramawrx);
  }
  
  private void a(awrx paramawrx)
  {
    ((awtq.b)awuh.a(paramawrx).b(awtq.b.class)).a.a(paramawrx, new awwl(this));
  }
  
  public boolean aOc()
  {
    if (isRecording()) {
      return true;
    }
    if (aOd())
    {
      dLp();
      return true;
    }
    return false;
  }
  
  public boolean aOd()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.c != null) || (this.jdField_b_of_type_Awzw != null))
    {
      if (this.c != null) {
        bool2 = false | this.c.aOd();
      }
      bool1 = bool2;
      if (this.jdField_b_of_type_Awzw != null) {
        bool1 = bool2 | this.jdField_b_of_type_Awzw.aOd();
      }
    }
    return bool1;
  }
  
  public void apk()
  {
    dLp();
    if (this.jdField_b_of_type_Awzw != null) {
      this.jdField_b_of_type_Awzw.apk();
    }
  }
  
  public void b(axbu paramaxbu)
  {
    if (VideoPrefsUtil.getDefaultPrefs() != null) {
      VideoPrefsUtil.setMaterialMute(false);
    }
    if (this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
      this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(paramaxbu);
    }
  }
  
  public void by(boolean paramBoolean, int paramInt)
  {
    if ((this.fb == null) || (this.LX == null) || (this.LZ == null)) {
      return;
    }
    float f1 = this.fb.getHeight() + this.LZ.getHeight();
    if ((this.LY == null) && (this.mRootView != null)) {
      this.LY = this.mRootView.findViewById(2131364195);
    }
    if ((this.LY != null) && (this.LY.getVisibility() == 0)) {
      f1 += this.LY.getHeight() + azbx.dip2px(8.0F);
    }
    for (;;)
    {
      Object localObject = this.fb.getLayoutParams();
      float f2 = f1;
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        f2 = f1 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      }
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        spf.b(new View[] { this.fb, this.LZ }).a(new float[] { 0.0F, f2 }).a(paramInt).b();
        if ((this.Ma != null) && (this.Ma.getVisibility() == 0))
        {
          localObject = new int[2];
          this.Ma.getLocationOnScreen((int[])localObject);
          i = this.mRootView.getHeight();
          j = localObject[1];
          k = rpq.dip2px(this.mRootView.getContext(), 100.0F);
          spf.b(new View[] { this.Ma }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
        }
      }
      for (localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
      {
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        this.LX.startAnimation((Animation)localObject);
        return;
        spf.b(new View[] { this.fb, this.LZ }).a(new float[] { f2, 0.0F }).a(paramInt).b();
        if ((this.Ma != null) && (this.Ma.getVisibility() == 0))
        {
          localObject = new int[2];
          this.Ma.getLocationOnScreen((int[])localObject);
          i = this.mRootView.getHeight();
          j = localObject[1];
          k = rpq.dip2px(this.mRootView.getContext(), 100.0F);
          spf.b(new View[] { this.Ma }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
        }
      }
    }
  }
  
  public void dKT()
  {
    this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.dKT();
  }
  
  public void dLp()
  {
    if (this.c != null) {
      this.c.XW(true);
    }
    if (this.jdField_b_of_type_Awzw != null) {
      this.jdField_b_of_type_Awzw.dLp();
    }
    if (this.fb != null) {
      this.fb.setVisibility(0);
    }
  }
  
  public void eGY()
  {
    b(axbr.b());
  }
  
  public void eGZ()
  {
    ayva.a().afK(0);
    axpr localaxpr = (axpr)axov.a(5);
    if (this.dtm) {
      localaxpr.a[0].cU((Activity)this.mRootView.getContext());
    }
  }
  
  public void eGd()
  {
    this.fb = ((ViewGroup)this.mRootView.findViewById(2131367583));
    this.LX = this.mRootView.findViewById(2131365505);
    this.LY = this.mRootView.findViewById(2131364195);
    this.LZ = this.mRootView.findViewById(2131377403);
  }
  
  public void eHa()
  {
    Object localObject = this.mRootView.findViewById(2131370820);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        if (this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
          this.jdField_b_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.eTS();
        }
      }
    }
  }
  
  public boolean isRecording()
  {
    return (this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) && (this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.isRecording());
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.onDestroy();
    }
    if (this.jdField_b_of_type_Awzw != null) {
      this.jdField_b_of_type_Awzw.onDestroy();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_b_of_type_Awzw != null) {
      this.jdField_b_of_type_Awzw.onResume();
    }
    ayva.a().afK(0);
    NativeGifImage.resumeAll();
    ApngImage.playByTag(13);
  }
  
  public void onStop()
  {
    if (this.c != null) {
      this.c.onStop();
    }
    if (this.jdField_b_of_type_Awzw != null) {
      this.jdField_b_of_type_Awzw.onStop();
    }
    if (awwf.a() != null)
    {
      this.dtm = awwf.a().dtj;
      return;
    }
    this.dtm = true;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if (this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSmoothLevel() == paramInt) {
      return;
    }
    if (GLVideoClipUtil.aRj())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBeautyLevel(paramInt);
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    this.jdField_b_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceLevel(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwk
 * JD-Core Version:    0.7.0.1
 */