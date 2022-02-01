import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.1;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.11;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

public class awwq
  extends axgh
  implements View.OnClickListener
{
  private static int eDy = 20000;
  private static int eDz = 4000;
  private View LQ;
  private View Mb;
  private axcz jdField_a_of_type_Axcz;
  private axgg jdField_a_of_type_Axgg;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private TextView agQ;
  private awzw jdField_b_of_type_Awzw;
  private axgf jdField_b_of_type_Axgf;
  private AEPituCameraCaptureButtonLayout jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private awtq jdField_c_of_type_Awtq;
  private AECameraGLSurfaceView jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private boolean cSH = axiz.aOK();
  private AEMaterialPanel jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AECompoundButton jdField_d_of_type_DovComQqImAeViewAECompoundButton;
  private boolean dsD;
  private boolean dtp;
  private boolean dtq;
  private Bitmap er;
  
  public awwq(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
    if (axcg.av(paramActivity.getIntent()))
    {
      axis.a().t("app_alg_aio_camera_type_id", "", 4);
      eDy = 20000;
    }
  }
  
  private void a(@NonNull axjd paramaxjd)
  {
    if (!this.dsD) {}
    do
    {
      return;
      if (this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.a(true, paramaxjd);
      }
    } while (this.jdField_d_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_d_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(paramaxjd.eFC, paramaxjd.eFB);
  }
  
  private boolean aOf()
  {
    return (this.mActivity != null) && (!axcg.au(this.mActivity.getIntent())) && (!axcg.av(this.mActivity.getIntent())) && (!axcg.aw(this.mActivity.getIntent())) && (!axcg.ax(this.mActivity.getIntent())) && (!axcg.ay(this.mActivity.getIntent()));
  }
  
  private boolean aOg()
  {
    return (this.mActivity != null) && (!axcg.aw(this.mActivity.getIntent())) && (!axcg.av(this.mActivity.getIntent())) && (!axcg.ax(this.mActivity.getIntent()));
  }
  
  private void acj(String paramString)
  {
    axiy.d("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.agQ == null) {
      this.agQ = ((TextView)((ViewStub)this.mRootView.findViewById(2131378869)).inflate());
    }
    this.agQ.setVisibility(0);
    this.agQ.setText(this.mActivity.getString(2131689970, new Object[] { paramString }));
  }
  
  private void adw(int paramInt)
  {
    if (this.jdField_d_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      AECompoundButton localAECompoundButton = this.jdField_d_of_type_DovComQqImAeViewAECompoundButton;
      if (axcg.av(this.mActivity.getIntent())) {
        paramInt = 8;
      }
      localAECompoundButton.setVisibility(paramInt);
    }
  }
  
  private void biN()
  {
    this.jdField_a_of_type_Axcz = ((axcz)awuh.a(this.jdField_c_of_type_Awtq).b(axcz.class));
    this.jdField_b_of_type_Axgf = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.jdField_a_of_type_Axgg = ((axgg)awuh.a(this.jdField_c_of_type_Awtq).b(axgg.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)awuh.a(this.jdField_c_of_type_Awtq).b(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_Axcz.i().a(this.jdField_c_of_type_Awtq, new awwu(this));
    this.jdField_b_of_type_Axgf.t.a(this.jdField_c_of_type_Awtq, new awwv(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().a(this.jdField_c_of_type_Awtq, new awww(this));
    if (this.dsD) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.d.a(this.jdField_c_of_type_Awtq, new awwy(this));
    }
    this.jdField_a_of_type_Axgg.p().a(this.jdField_c_of_type_Awtq, new awwz(this));
    this.jdField_a_of_type_Axgg.q().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_Axgg.r().postValue(Boolean.valueOf(false));
    ((awtq.b)awuh.a(this.jdField_c_of_type_Awtq).b(awtq.b.class)).a.a(this.jdField_c_of_type_Awtq, new awwr(this));
  }
  
  private void cFc()
  {
    this.Mb = this.mRootView.findViewById(2131367583);
    this.LQ = this.mRootView.findViewById(2131367263);
    this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364201));
    if (((Long)spp.a().getValue("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.mRootView.findViewById(2131364256));
    this.dtp = ((String)spp.a().getValue("enable_click_take_picture", "1")).equals("1");
    this.dtq = this.mActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    if (this.mActivity != null)
    {
      if ((!axcg.aw(this.mActivity.getIntent())) && (!axcg.ax(this.mActivity.getIntent()))) {
        break label205;
      }
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
    }
    for (;;)
    {
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setMaxDuration(eDy);
      return;
      label205:
      if (!this.dtq) {
        break;
      }
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setFunctionFlag(2);
    }
    AEPituCameraCaptureButtonLayout localAEPituCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
    if (this.dtp) {}
    for (int i = 1;; i = 3)
    {
      localAEPituCameraCaptureButtonLayout.setFunctionFlag(i);
      break;
    }
  }
  
  private void eEY()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.11(this), 64, null, true);
  }
  
  private void eHf()
  {
    String str;
    if (this.dsD)
    {
      str = this.jdField_c_of_type_Awtq.getActivity().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("http"))) {
        break label145;
      }
    }
    label145:
    while (TextUtils.isEmpty(localUnsupportedEncodingException)) {
      try
      {
        Intent localIntent = new Intent(this.jdField_c_of_type_Awtq.getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
        localIntent.putExtra("loc_play_show_material_id", str);
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", axcg.x.getId());
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", axcg.C.getId());
        this.jdField_c_of_type_Awtq.getActivity().startActivityForResult(localIntent, 1025);
        this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return;
      }
    }
    this.mRootView.post(new VideoStoryPiecesPart.1(this, localUnsupportedEncodingException));
  }
  
  private void eHg()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.mRootView.findViewById(2131370836));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.2(this));
    if (aOf())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
    }
    for (;;)
    {
      this.jdField_d_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131364017));
      this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2131373750));
      if (!aOg()) {
        break;
      }
      if (!this.dsD) {
        this.jdField_d_of_type_DovComQqImAeViewAECompoundButton.post(new VideoStoryPiecesPart.3(this));
      }
      this.jdField_d_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      adw(0);
      this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.jdField_c_of_type_Axgi);
      this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setAECaptureController(this.jdField_c_of_type_Awtq.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
    }
    this.jdField_d_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void eHh()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.mRootView.findViewById(2131362282)).inflate().findViewById(2131362283));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new awwt(this));
  }
  
  private void eHi()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      eHj();
      axiy.d("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_Axgg.p().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      eHj();
      axiy.d("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (axby)this.jdField_a_of_type_Axcz.i().getValue();
    if ((localObject == null) || (((axby)localObject).b == null))
    {
      eHj();
      axiy.d("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((axby)localObject).b.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      eHj();
      axiy.d("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    acj((String)localObject);
  }
  
  private void eHj()
  {
    if (this.agQ != null) {
      this.agQ.setVisibility(8);
    }
  }
  
  private void eHk()
  {
    if (this.jdField_b_of_type_Awzw != null)
    {
      this.jdField_b_of_type_Awzw.show();
      this.jdField_a_of_type_Axgg.r().postValue(Boolean.valueOf(true));
    }
  }
  
  private void eHl()
  {
    int i = rpq.dip2px(this.mActivity, this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new awws(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  protected int QN()
  {
    int j = this.mActivity.getResources().getDimensionPixelSize(2131296366);
    int k = this.mRootView.getHeight() - awyk.eEb - rpq.getScreenWidth(this.mActivity) - j;
    int m = rpq.dip2px(this.mActivity, 128.0F);
    int i = 0;
    if (k >= m * 1.5D) {
      i = (k - m) / 3 + j;
    }
    return i;
  }
  
  protected void initView()
  {
    this.dsD = axcg.ay(this.mActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378862);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    cFc();
    eHg();
    biN();
    eHf();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.cjE();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 10006)) && (paramInt2 == -1))
    {
      if (this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null) {
        break label51;
      }
      this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if (this.mActivity != null) {
        this.mActivity.finish();
      }
      return;
      label51:
      if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    eEY();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_c_of_type_Awtq.eGf();
      sqn.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
      axim.a().eKP();
      continue;
      if (this.dsD)
      {
        if (!axiw.Y(paramView))
        {
          Intent localIntent = new Intent();
          localIntent.setAction("ae_editor_bottom_tab_show_hide");
          localIntent.putExtra("is_show", false);
          this.jdField_c_of_type_Awtq.getActivity().sendBroadcast(localIntent);
        }
      }
      else
      {
        if (this.jdField_c_of_type_Axgi != null) {
          this.jdField_c_of_type_Axgi.p(131076, new Object[0]);
        }
        sqn.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
        axim.a().eKS();
      }
    }
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    label97:
    do
    {
      return;
      if (this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
          break label97;
        }
        this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
        this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.ad(null, null, false);
        this.jdField_a_of_type_Axgg.q().postValue(Boolean.valueOf(true));
      }
      for (;;)
      {
        sqn.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
        return;
        if ((paramVarArgs[0] instanceof axbu))
        {
          paramVarArgs = (axbu)paramVarArgs[0];
          this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_d_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.ad(paramVarArgs.cTB, paramVarArgs.id, true);
          this.jdField_a_of_type_Axgg.q().postValue(Boolean.valueOf(true));
        }
      }
      eHk();
      return;
      eHl();
      return;
    } while (this.jdField_b_of_type_Awzw == null);
    this.jdField_b_of_type_Awzw.eHZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awwq
 * JD-Core Version:    0.7.0.1
 */