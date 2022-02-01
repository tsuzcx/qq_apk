import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

public class awyk
  extends axgh
{
  public static int eEb;
  private final float DT = 147.0F;
  private final float DU = 58.799999F;
  private long De = ((Long)spp.a().getValue("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private ImageView HV;
  private View Me;
  public List<FrameVideoHelper.FrameBuffer> Me;
  private View Mf;
  private View Mg;
  private View Mh;
  private View Mi;
  private final String TAG = "VideoStoryCapturePart";
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private long aBI;
  private axgf b;
  private int bWC;
  private awtq jdField_c_of_type_Awtq;
  private AECameraGLSurfaceView jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private boolean dsD;
  private boolean dtC;
  private boolean dtD;
  private final int eDZ = 700;
  private final int eEa = 600;
  private Dialog g;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public awyk(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.jdField_c_of_type_Awtq = ((awtq)paramaxgi.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    eEb = aqnm.dip2px(60.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  private void HN()
  {
    eHR();
    this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new awyt(this));
  }
  
  private void a(int paramInt, aasq paramaasq)
  {
    long l1 = paramaasq.mWidth * paramaasq.mHeight;
    long l2 = this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getWidth() * this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getHeight();
    axiy.d("VideoStoryCapturePart", "smooth2Size---oldArea=" + l2 + ", newArea=" + l1);
    if (l1 == l2) {
      return;
    }
    eHP();
    this.jdField_Me_of_type_AndroidViewView.setVisibility(0);
    Object localObject = spf.b(new View[] { this.Mf, this.Mg }).d(new float[] { this.Mf.getWidth(), (int)Math.ceil((this.mScreenWidth - paramaasq.mWidth) / 2.0D) }).a(new View[] { this.Mh }).c(new float[] { this.Mh.getHeight(), paramInt }).a(new View[] { this.Mi }).c(new float[] { this.Mi.getHeight(), this.mRootView.getHeight() - paramInt - paramaasq.mHeight });
    if (l1 > l2) {}
    for (localObject = ((spa)localObject).a().a(300L);; localObject = ((spa)localObject).a(1.5F).a(500L))
    {
      ((spf)localObject).a(new awys(this)).b();
      localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramaasq.mWidth;
      ((RelativeLayout.LayoutParams)localObject).height = paramaasq.mHeight;
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void a(@NonNull AECaptureMode paramAECaptureMode)
  {
    int j;
    float f;
    int i;
    if ((paramAECaptureMode == AECaptureMode.GIF) || (paramAECaptureMode == AECaptureMode.NORMAL))
    {
      j = 0;
      if (paramAECaptureMode != AECaptureMode.GIF) {
        break label138;
      }
      if (this.jdField_c_of_type_Awtq == null) {
        break label95;
      }
      if ((!this.dtC) || (this.bWC == 0)) {
        break label78;
      }
      f = this.bWC;
      i = (int)f;
    }
    for (;;)
    {
      a(i, axix.a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, axix.a(), this.dsD, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio));
      return;
      label78:
      f = aqcx.dip2px(this.jdField_c_of_type_Awtq.getActivity(), 147.0F);
      break;
      label95:
      if (this.dtC)
      {
        f = (int)(0.0724138F * this.mRootView.getHeight());
        break;
      }
      f = (int)(0.1810345F * this.mRootView.getHeight());
      break;
      label138:
      i = j;
      if (this.dsD)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
          i = eEb;
        }
      }
    }
  }
  
  private void am(Object[] paramArrayOfObject)
  {
    Object localObject1;
    Object localObject2;
    Object localObject4;
    aybv localaybv;
    Object localObject3;
    int i;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localObject1 = (AEVideoCaptureResult)paramArrayOfObject[0];
      localObject2 = (LocalMediaInfo)paramArrayOfObject[1];
      localObject4 = (Integer)paramArrayOfObject[2];
      localaybv = (aybv)paramArrayOfObject[3];
      localObject3 = (QIMFilterCategoryItem)paramArrayOfObject[4];
      if (((Integer)localObject4).intValue() != 13) {
        break label247;
      }
      axiy.i("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
      paramArrayOfObject = awtn.b.b.cSP + File.separator + System.currentTimeMillis() + ".mp4";
      localObject1 = axbg.Q(((AEVideoCaptureResult)localObject1).audioDataFilePath, ((LocalMediaInfo)localObject2).path, paramArrayOfObject);
      paramArrayOfObject = (Object[])localObject1;
      if (localObject1 == null) {
        paramArrayOfObject = ((LocalMediaInfo)localObject2).path;
      }
      localObject1 = new Bundle();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramArrayOfObject);
      ((Bundle)localObject1).putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
      ((Bundle)localObject1).putString("material_id", this.mActivity.getIntent().getStringExtra("widgetinfo"));
      if (Build.VERSION.SDK_INT < 23) {
        break label584;
      }
      if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        break label242;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        axiy.i("VideoStoryCapturePart", "updateWMProps onGetLocation");
        axaq.a().eIt();
      }
      i = getFrom();
      axjh.a(this.mActivity, 1, (Bundle)localObject1, i);
      eHR();
      return;
      label242:
      i = 0;
      continue;
      label247:
      Bundle localBundle1 = this.mActivity.getIntent().getExtras();
      paramArrayOfObject = new ayby.a().a(localaybv.EP).c(10).j(true);
      if (axcg.av(this.mActivity.getIntent())) {
        paramArrayOfObject.c(0);
      }
      localaybv.a(paramArrayOfObject.b());
      this.mActivity.getIntent().putExtra("extra_transiton_src_from", -1);
      Bundle localBundle2 = new Bundle();
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_Me_of_type_JavaUtilList);
      localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.aBI);
      localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", ((Integer)localObject4).intValue());
      localObject4 = axaq.a().a();
      paramArrayOfObject = "";
      if (localObject4 != null) {
        paramArrayOfObject = ((axbu)localObject4).name;
      }
      localObject4 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (!TextUtils.isEmpty(paramArrayOfObject))
      {
        ((VideoStoryDataBean)localObject4).setWatermarkId(paramArrayOfObject);
        localObject4 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (localObject3 == null) {
          break label554;
        }
        paramArrayOfObject = ((QIMFilterCategoryItem)localObject3).name;
        label435:
        ((VideoStoryDataBean)localObject4).setFilterId(paramArrayOfObject);
        localObject3 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (axbr.b() != null) {
          break label561;
        }
        paramArrayOfObject = "empty";
        label457:
        ((VideoStoryDataBean)localObject3).setLensId(paramArrayOfObject);
        localObject3 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (axbr.b() != null) {
          break label571;
        }
      }
      label554:
      label561:
      label571:
      for (paramArrayOfObject = "empty";; paramArrayOfObject = Integer.valueOf(axbr.b().categoryId))
      {
        ((VideoStoryDataBean)localObject3).setLensTabId(String.valueOf(paramArrayOfObject));
        localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
        this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
        axiy.i("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
        aywz.a(this.mActivity, (CameraCaptureView.VideoCaptureResult)localObject1, (LocalMediaInfo)localObject2, localaybv, localBundle2, 11, localBundle1);
        eHR();
        return;
        paramArrayOfObject = "empty";
        break;
        paramArrayOfObject = "empty";
        break label435;
        paramArrayOfObject = axbr.b().id;
        break label457;
      }
      label584:
      i = 1;
    }
  }
  
  private void an(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    if (axcg.av(this.mActivity.getIntent()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
      }
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
      {
        localObject1 = (CameraCaptureView.h)paramArrayOfObject[0];
        paramArrayOfObject = (aybv)paramArrayOfObject[1];
        showLoading(false);
        aywz.a(this.mActivity, (CameraCaptureView.h)localObject1, paramArrayOfObject, null, 1);
      }
    }
    Object localObject2;
    do
    {
      return;
      if (axcg.ay(this.mActivity.getIntent()))
      {
        axiy.i("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
        paramArrayOfObject = (CameraCaptureView.h)paramArrayOfObject[0];
        showLoading(false);
        localObject1 = new Bundle();
        localObject2 = new ArrayList();
        EditorPicInfo localEditorPicInfo = new EditorPicInfo();
        Size localSize = BitmapUtil.getImageSize(paramArrayOfObject.filePath);
        localEditorPicInfo.picPath = paramArrayOfObject.filePath;
        localEditorPicInfo.originPicHeight = localSize.getHeight();
        localEditorPicInfo.originPicWidth = localSize.getWidth();
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.h = 1.0D;
        localEditorPicInfo.w = 1.0D;
        ((ArrayList)localObject2).add(localEditorPicInfo);
        ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject2);
        ((Bundle)localObject1).putString("material_id", this.mActivity.getIntent().getStringExtra("widgetinfo"));
        int i = getFrom();
        axjh.a(this.mActivity, 0, (Bundle)localObject1, i);
        axip.a().a().aCe = axip.aq.longValue();
        axip.a().a().cUU = axip.a().HP();
        axim.a().adV(1);
        return;
      }
    } while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 2));
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "arg len = 2");
    }
    Object localObject1 = (CameraCaptureView.h)paramArrayOfObject[0];
    paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[1];
    paramArrayOfObject = this.mActivity.getIntent();
    if ((axcg.au(paramArrayOfObject)) || (!axcg.am(this.mActivity.getIntent())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
      }
      paramArrayOfObject = new Bundle();
      paramArrayOfObject.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", ((CameraCaptureView.h)localObject1).filePath);
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).mMimeType = "pic";
      this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
      aytv.a(this.mActivity, ((CameraCaptureView.h)localObject1).filePath, (LocalMediaInfo)localObject2, 0, (int)((LocalMediaInfo)localObject2).mDuration, -1, 10023, 0, null, null, false, 11, 14, paramArrayOfObject);
      showLoading(false);
      return;
    }
    if ((axcg.aw(this.mActivity.getIntent())) || (axcg.ax(this.mActivity.getIntent())))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", axcg.i(paramArrayOfObject));
      ((Intent)localObject2).putExtra("photo_path", ((CameraCaptureView.h)localObject1).filePath);
      ((Intent)localObject2).putExtra("key_disable_face_detect", paramArrayOfObject.getBooleanExtra("key_disable_face_detect", false));
      ((Intent)localObject2).putExtra("key_need_check_sensitive", paramArrayOfObject.getBooleanExtra("key_need_check_sensitive", false));
      AETakeFacePhotoPreviewFragment.j(this.mActivity, (Intent)localObject2, 1024);
      showLoading(false);
      return;
    }
    axiy.e("VideoStoryCapturePart", "【onPhotoEnd】wrong entry");
  }
  
  private void b(@NotNull AECaptureMode paramAECaptureMode)
  {
    if ((paramAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel != null)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c().postValue(Boolean.valueOf(false));
    }
  }
  
  private void biN()
  {
    this.b = ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)awuh.a(this.jdField_c_of_type_Awtq).b(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = ((AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.d.getValue());
    this.b.t.a(this.jdField_c_of_type_Awtq, new awyp(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.c().a(this.jdField_c_of_type_Awtq, new awyq(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.d.a(this.jdField_c_of_type_Awtq, new awyr(this));
  }
  
  private void eHP()
  {
    if (this.dtD) {
      return;
    }
    Object localObject = (ViewStub)this.mRootView.findViewById(2131378875);
    ViewStub localViewStub1 = (ViewStub)this.mRootView.findViewById(2131378871);
    ViewStub localViewStub2 = (ViewStub)this.mRootView.findViewById(2131378872);
    ViewStub localViewStub3 = (ViewStub)this.mRootView.findViewById(2131378873);
    ViewStub localViewStub4 = (ViewStub)this.mRootView.findViewById(2131378874);
    ViewStub localViewStub5 = (ViewStub)this.mRootView.findViewById(2131378870);
    ((ViewStub)localObject).inflate();
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    this.HV = ((ImageView)this.mRootView.findViewById(2131362281));
    this.jdField_Me_of_type_AndroidViewView = this.mRootView.findViewById(2131364202);
    this.Mf = this.mRootView.findViewById(2131364198);
    this.Mf.setOnTouchListener(new awyl(this));
    this.Mg = this.mRootView.findViewById(2131364199);
    this.Mg.setOnTouchListener(new awym(this));
    this.Mh = this.mRootView.findViewById(2131364200);
    this.Mh.setOnTouchListener(new awyn(this));
    this.Mi = this.mRootView.findViewById(2131364197);
    this.Mi.setOnTouchListener(new awyo(this));
    if (this.dsD)
    {
      boolean bool = axiz.aOK();
      localObject = this.mActivity.getResources();
      if (!bool) {
        break label350;
      }
    }
    label350:
    for (int i = 2131165240;; i = 2131165242)
    {
      i = ((Resources)localObject).getColor(i);
      this.Mh.setBackgroundColor(i);
      this.Mi.setBackgroundColor(i);
      this.Mf.setBackgroundColor(i);
      this.Mg.setBackgroundColor(i);
      this.dtD = true;
      return;
    }
  }
  
  private void eHQ()
  {
    showLoading(true);
  }
  
  private void eHR()
  {
    this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(null);
    this.jdField_Me_of_type_JavaUtilList.clear();
    this.aBI = 0L;
  }
  
  private int getFrom()
  {
    int i = axcg.x.getId();
    if (this.mActivity.getIntent() != null)
    {
      int j = this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.x.getId());
      i = j;
      if (j == axcg.A.getId()) {
        i = axcg.z.getId();
      }
    }
    return i;
  }
  
  private void showLoading(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label80;
      }
      if (this.g == null)
      {
        this.g = new ReportDialog(this.mActivity, 2131756467);
        this.g.setCancelable(false);
        this.g.setCanceledOnTouchOutside(false);
        this.g.setContentView(2131559761);
      }
      this.g.show();
    }
    label80:
    while ((this.g == null) || (!this.g.isShowing())) {
      return;
    }
    this.g.dismiss();
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return super.a(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    this.dsD = axcg.ay(this.mActivity.getIntent());
    this.jdField_c_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364201));
    this.jdField_Me_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.mScreenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.mScreenHeight = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (azbx.bG(this.mScreenWidth, this.mScreenHeight)) {
      this.mScreenWidth = (this.mScreenHeight * 9 / 16);
    }
    int i = aqcx.dip2px(this.mActivity, 700.0F);
    if (this.mScreenHeight < i)
    {
      this.dtC = true;
      if (this.dtC)
      {
        int j = aqcx.dip2px(this.mActivity, 600.0F);
        if (this.mScreenHeight >= j) {
          break label189;
        }
      }
    }
    label189:
    float f;
    for (this.bWC = aqcx.dip2px(this.mActivity, 58.799999F);; this.bWC = aqcx.dip2px(this.mActivity, 147.0F - f * 88.199997F))
    {
      biN();
      return;
      this.dtC = false;
      break;
      f = (i - this.mScreenHeight) / aqcx.dip2px(this.mActivity, 100.0F);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    ayrl.a().onDestroy();
    super.onDestroy();
    showLoading(false);
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      HN();
      return;
    case 262146: 
      am(paramVarArgs);
      return;
    case 262147: 
      eHQ();
      return;
    }
    an(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awyk
 * JD-Core Version:    0.7.0.1
 */