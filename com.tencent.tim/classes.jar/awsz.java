import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.FollowCaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.FollowCaptureView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMStoryFollowCaptureUnit.1;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.StoryImageToastView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@TargetApi(18)
public class awsz
  extends awsy
{
  private static int screenHeight;
  private static int screenWidth;
  private FollowCaptureView a;
  private FollowCaptureParam jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam;
  private CameraCaptureView.VideoCaptureResult jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
  private volatile boolean dsq;
  private LocalMediaInfo i;
  private Stack<Integer> n = new Stack();
  
  static
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    screenWidth = localDisplayMetrics.widthPixels;
    screenHeight = localDisplayMetrics.heightPixels;
  }
  
  public awsz(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
  }
  
  private void eFR()
  {
    if (anii.isDualScreenPhone())
    {
      localObject = alwy.getDisplayMetrics(this.jdField_a_of_type_Aycb.getActivity());
      if (localObject != null)
      {
        screenWidth = ((DisplayMetrics)localObject).widthPixels;
        screenHeight = ((DisplayMetrics)localObject).heightPixels;
      }
    }
    Object localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (screenHeight / 2);
    int k = aqnm.dip2px(48.0F);
    int j = aqnm.dip2px(44.0F);
    int m = aqnm.dip2px(118.0F);
    m = screenHeight - m - j - k;
    j = m;
    if (this.dro) {
      j = m - (this.top_blackLH.getLayoutParams().height + this.bottom_blackLH.getLayoutParams().height);
    }
    if (j - ((RelativeLayout.LayoutParams)localObject).height > 0) {}
    for (j = (j - ((RelativeLayout.LayoutParams)localObject).height) / 2 + k;; j = k)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = j;
      this.c.Ou(false);
      return;
    }
  }
  
  public int Qw()
  {
    return 0;
  }
  
  public void Xr(boolean paramBoolean)
  {
    super.Xr(paramBoolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(false);
  }
  
  protected alwm a()
  {
    return new awsz.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.setClipWidth(screenWidth);
    locale.setClipHeight(screenHeight);
    locale.Ov(false);
    return locale;
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    this.i = paramLocalMediaInfo;
    if ((!this.dsq) || (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult == null) || (paramLocalMediaInfo == null)) {
      return;
    }
    this.jdField_a_of_type_Aycb.getActivity().getIntent().putExtra("extra_follow_capture_param", this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam);
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam != null) {
      paramVideoCaptureResult.audioDataFilePath = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.audioPath;
    }
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
  }
  
  protected void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.b(paramVideoCaptureResult, paramLocalMediaInfo);
    this.n.push(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView.Gt()));
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryFollowCaptureUnit", 2, "onSegmentVideoOneCaptured: localMediaInfo.duration = " + paramLocalMediaInfo.mDuration + " ; playPosition = " + this.n.peek());
    }
  }
  
  public void eFb()
  {
    super.eFb();
    this.n.pop();
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().YR(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView.seekTo(((Integer)this.n.peek()).intValue());
  }
  
  protected void eFc()
  {
    Xq(false);
  }
  
  public void eFi()
  {
    super.eFi();
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().YR(true);
  }
  
  public void eFm()
  {
    this.c.dLk();
    if ((this.LX.size() == 0) || (this.LY.size() == 0))
    {
      Xq(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(true);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(false);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setLockStatus(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.ZZ(false);
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
  }
  
  public void eFs()
  {
    super.eFs();
    eFR();
  }
  
  public ArrayList<Integer> eG()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131561120;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryFollowCaptureUnit", 2, "onCreate");
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam = ((FollowCaptureParam)this.jdField_a_of_type_Aycb.getActivity().getIntent().getSerializableExtra("extra_follow_capture_param"));
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataFollowCaptureParam.videoPath)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131711259), 0).show();
      this.jdField_a_of_type_Aycb.getActivity().finish();
      return;
    }
    this.jdField_b_of_type_Aybv.mEntranceType = 108;
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.dxg = true;
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.dxh = true;
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.Zc(true);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(true);
    Xp(true);
    this.drn = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewFollowCaptureView = ((FollowCaptureView)this.c);
    paramBundle = BaseApplicationImpl.getContext().getResources().getString(2131701700);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setIsFollowCaptureTips();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setRecordTipsWording(paramBundle);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.eUo();
    ThreadManagerV2.excute(new QIMStoryFollowCaptureUnit.1(this), 16, null, true);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().YR(false);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eNZ();
    this.n.push(Integer.valueOf(0));
    ayva.a().ZP(false);
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    eFR();
    this.drm = false;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setFunctionFlag(3);
    return localView;
  }
  
  class a
    extends alwm
  {
    public a(CameraFocusView paramCameraFocusView)
    {
      super();
    }
    
    protected void a(CameraCaptureView paramCameraCaptureView, float paramFloat1, float paramFloat2)
    {
      super.a(paramCameraCaptureView, paramFloat1, paramFloat2 - paramCameraCaptureView.getTop());
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("GLGestureListener", 2, "event : (" + paramMotionEvent.getX() + "," + paramMotionEvent.getY() + ")");
        QLog.d("GLGestureListener", 2, "view : (" + awsz.a(awsz.this).getLeft() + "," + awsz.a(awsz.this).getRight() + "," + awsz.a(awsz.this).getTop() + "," + awsz.a(awsz.this).getBottom() + ")");
      }
      if ((paramMotionEvent.getX() > awsz.a(awsz.this).getRight() / 2) || (paramMotionEvent.getY() < awsz.a(awsz.this).getTop()) || (paramMotionEvent.getY() > awsz.a(awsz.this).getBottom()))
      {
        QLog.d("GLGestureListener", 2, "touch out");
        return false;
      }
      QLog.d("GLGestureListener", 2, "touch in");
      return super.onTouchEvent(paramMotionEvent, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsz
 * JD-Core Version:    0.7.0.1
 */