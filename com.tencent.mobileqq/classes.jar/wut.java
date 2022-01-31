import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.videostory.capture.VideoStoryPiecesPart.1;
import com.tencent.biz.videostory.capture.VideoStoryPiecesPart.2;
import com.tencent.biz.videostory.capture.VideoStoryPiecesPart.9;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;

public class wut
  extends wug
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bhcw jdField_a_of_type_Bhcw;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private wsi jdField_a_of_type_Wsi;
  private wsw jdField_a_of_type_Wsw;
  private wsz jdField_a_of_type_Wsz;
  private wth jdField_a_of_type_Wth;
  private wvz jdField_a_of_type_Wvz;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  
  public wut(Activity paramActivity, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
    if (bjeg.k(paramActivity.getIntent()))
    {
      bgxb.a().a("app_alg_aio_camera_type_id", "", 4);
      jdField_a_of_type_Int = 20000;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!bjeg.j(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bjeg.k(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bjeg.l(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bjeg.m(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_AndroidAppActivity != null) && (!bjeg.l(this.jdField_a_of_type_AndroidAppActivity.getIntent())) && (!bjeg.m(this.jdField_a_of_type_AndroidAppActivity.getIntent()));
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300799);
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298277));
    if (((Long)wwt.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297747));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297745));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298325));
    this.jdField_a_of_type_Boolean = ((String)wwt.a().a("enable_click_take_picture", "1")).equals("1");
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if ((bjeg.l(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bjeg.m(this.jdField_a_of_type_AndroidAppActivity.getIntent()))) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ability_flag", 2));
      }
    }
    else
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setMaxDuration(jdField_a_of_type_Int);
      f();
      return;
    }
    AEPituCameraCaptureButtonLayout localAEPituCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 3)
    {
      localAEPituCameraCaptureButtonLayout.setFunctionFlag(i);
      break;
    }
  }
  
  private void f()
  {
    if (awmc.c(this.jdField_a_of_type_AndroidAppActivity) / awmc.e(this.jdField_a_of_type_AndroidAppActivity) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      bjeh.c(this.jdField_a_of_type_AndroidAppActivity);
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303851));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.1(this));
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298123));
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131306378));
      if (!b()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.post(new VideoStoryPiecesPart.2(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.setPartManager(this.jdField_a_of_type_Wus);
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.setAECaptureController(this.jdField_a_of_type_Bhcw.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.setVisibility(8);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131296611)).inflate().findViewById(2131296612));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new wuv(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_Wsw = ((wsw)bhur.a(this.jdField_a_of_type_Bhcw).a(wsw.class));
    this.jdField_a_of_type_Wsw.c().a(this.jdField_a_of_type_Bhcw, new wuw(this));
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wux(this));
    this.jdField_a_of_type_Wth = ((wth)bhur.a(this.jdField_a_of_type_Bhcw).a(wth.class));
    this.jdField_a_of_type_Wth.a().a(this.jdField_a_of_type_Bhcw, new wuy(this));
    this.jdField_a_of_type_Wsz = ((wsz)bhur.a(this.jdField_a_of_type_Bhcw).a(wsz.class));
    this.jdField_a_of_type_Wsz.a().a(this.jdField_a_of_type_Bhcw, new wva(this));
    this.jdField_a_of_type_Wsz.b().a(Boolean.valueOf(false));
    this.jdField_a_of_type_Wsz.c().a(Boolean.valueOf(false));
    ((bhdg)bhur.a(this.jdField_a_of_type_Bhcw).a(bhdg.class)).a.a(this.jdField_a_of_type_Bhcw, new wvb(this));
  }
  
  private void l()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.9(this), 64, null, true);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Wvz != null)
    {
      this.jdField_a_of_type_Wvz.b();
      this.jdField_a_of_type_Wsz.c().a(Boolean.valueOf(true));
    }
  }
  
  private void n()
  {
    int i = vms.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new wuu(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected void a()
  {
    e();
    g();
    k();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 10006)) && (paramInt2 == -1))
    {
      if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel == null) {
        break label51;
      }
      this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.a(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
      label51:
      if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null)
      {
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.setVisibility(0);
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.a(null, null, false);
        this.jdField_a_of_type_Wsz.b().a(Boolean.valueOf(true));
      }
      wye.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
      return;
      m();
      return;
      n();
      return;
    } while (this.jdField_a_of_type_Wvz == null);
    this.jdField_a_of_type_Wvz.h();
  }
  
  public void b()
  {
    super.b();
    l();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bhcw.onClick(paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      wye.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      bhci.a().k();
      return;
      wye.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      bhci.a().n();
    } while (this.jdField_a_of_type_Wus == null);
    this.jdField_a_of_type_Wus.a(131076, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wut
 * JD-Core Version:    0.7.0.1
 */