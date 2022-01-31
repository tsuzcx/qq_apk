import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.videostory.capture.VideoStoryCapturePart.3;
import com.tencent.biz.videostory.capture.VideoStoryCapturePart.4;
import com.tencent.biz.videostory.capture.VideoStoryCapturePart.5;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import dov.com.qq.im.AECamera.qudong.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class wuh
  extends wug
{
  private final float jdField_a_of_type_Float = 147.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bhcw jdField_a_of_type_Bhcw;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView;
  private final String jdField_a_of_type_JavaLangString = "VideoStoryCapturePart";
  public List<FrameVideoHelper.FrameBuffer> a;
  private wsi jdField_a_of_type_Wsi;
  private wth jdField_a_of_type_Wth;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)wwt.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private final int jdField_d_of_type_Int = 700;
  private View jdField_d_of_type_AndroidViewView;
  private final int jdField_e_of_type_Int = 600;
  private View jdField_e_of_type_AndroidViewView;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private int g;
  
  public wuh(Activity paramActivity, AppInterface paramAppInterface, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
  }
  
  private int a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getIntent() != null) && (bjeg.k(paramActivity.getIntent()))) {
      return 2;
    }
    return 14;
  }
  
  private void a(Runnable paramRunnable)
  {
    wqa.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { this.jdField_c_of_type_AndroidViewView.getWidth(), 0.0F }).a(new View[] { this.jdField_e_of_type_AndroidViewView }).c(new float[] { this.jdField_e_of_type_AndroidViewView.getHeight(), 0.0F }).a(new View[] { this.jdField_f_of_type_AndroidViewView }).c(new float[] { this.jdField_f_of_type_AndroidViewView.getHeight(), 0.0F }).a().a(300L).a(new wup(this)).a(new wuo(this, paramRunnable)).a();
  }
  
  private void a(@NotNull wsh paramwsh)
  {
    if ((paramwsh == wsh.a) && (this.jdField_a_of_type_Wth != null)) {
      this.jdField_a_of_type_Wth.b().a(Boolean.valueOf(false));
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    CameraCaptureView.VideoCaptureResult localVideoCaptureResult;
    LocalMediaInfo localLocalMediaInfo;
    bhyu localbhyu;
    Object localObject1;
    Bundle localBundle1;
    Bundle localBundle2;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localVideoCaptureResult = (CameraCaptureView.VideoCaptureResult)paramArrayOfObject[0];
      localLocalMediaInfo = (LocalMediaInfo)paramArrayOfObject[1];
      Object localObject2 = (Integer)paramArrayOfObject[2];
      localbhyu = (bhyu)paramArrayOfObject[3];
      localObject1 = (QIMFilterCategoryItem)paramArrayOfObject[4];
      localBundle1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      paramArrayOfObject = new bhza().a(localbhyu.jdField_c_of_type_Int).c(10).j(true);
      if (bjeg.k(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        paramArrayOfObject.c(0);
      }
      localbhyu.a(paramArrayOfObject.a());
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra_transiton_src_from", -1);
      localBundle2 = new Bundle();
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", ((Integer)localObject2).intValue());
      localObject2 = wvh.a().a();
      paramArrayOfObject = "";
      if (localObject2 != null) {
        paramArrayOfObject = ((bgya)localObject2).e;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (TextUtils.isEmpty(paramArrayOfObject)) {
        break label339;
      }
      ((VideoStoryDataBean)localObject2).setWatermarkId(paramArrayOfObject);
      localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (localObject1 == null) {
        break label346;
      }
      paramArrayOfObject = ((QIMFilterCategoryItem)localObject1).b;
      label236:
      ((VideoStoryDataBean)localObject2).setFilterId(paramArrayOfObject);
      localObject1 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (bgxx.a() != null) {
        break label353;
      }
      paramArrayOfObject = "empty";
      label258:
      ((VideoStoryDataBean)localObject1).setLensId(paramArrayOfObject);
      localObject1 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (bgxx.a() != null) {
        break label363;
      }
    }
    label339:
    label346:
    label353:
    label363:
    for (paramArrayOfObject = "empty";; paramArrayOfObject = Integer.valueOf(bgxx.a().jdField_a_of_type_Int))
    {
      ((VideoStoryDataBean)localObject1).setLensTabId(String.valueOf(paramArrayOfObject));
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
      bjeg.a(this.jdField_a_of_type_AndroidAppActivity, localVideoCaptureResult, localLocalMediaInfo, localbhyu, localBundle2, 11, localBundle1);
      p();
      return;
      paramArrayOfObject = "empty";
      break;
      paramArrayOfObject = "empty";
      break label236;
      paramArrayOfObject = bgxx.a().jdField_a_of_type_JavaLangString;
      break label258;
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    float f1;
    if (this.jdField_a_of_type_Bhcw != null) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int != 0)) {
        f1 = this.jdField_f_of_type_Int;
      }
    }
    for (;;)
    {
      wqa.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { 0.0F, (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) / 2 }).a(new View[] { this.jdField_e_of_type_AndroidViewView }).c(new float[] { 0.0F, f1 }).a(new View[] { this.jdField_f_of_type_AndroidViewView }).c(new float[] { 0.0F, this.jdField_a_of_type_AndroidViewView.getHeight() - f1 - this.jdField_a_of_type_Int + 1.0F }).a(1.5F).a(500L).a(new wuj(this)).a(new wuq(this, paramRunnable)).a();
      return;
      f1 = azvv.a(this.jdField_a_of_type_Bhcw.a(), 147.0F);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        f1 = (int)(0.0724138F * this.jdField_a_of_type_AndroidViewView.getHeight());
      } else {
        f1 = (int)(0.1810345F * this.jdField_a_of_type_AndroidViewView.getHeight());
      }
    }
  }
  
  private void b(@NotNull wsh paramwsh)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("VideoStoryCapturePart", 4, "in checkAniByMode: " + paramwsh);
    }
    if (this.jdField_a_of_type_Wsi.d())
    {
      this.jdField_a_of_type_Wsi.a(false);
      return;
    }
    if (paramwsh == wsh.a)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.n();
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setBlockCameraFlag(false);
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.p();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_Wsi.b(true);
      a(new VideoStoryCapturePart.3(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a = paramwsh;
      return;
      if (paramwsh == wsh.c)
      {
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.n();
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setBlockCameraFlag(false);
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.c(1);
        this.jdField_a_of_type_Wsi.b(true);
        b(new VideoStoryCapturePart.4(this));
      }
      else if (paramwsh == wsh.b)
      {
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.n();
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setBlockCameraFlag(true);
        this.jdField_a_of_type_Wsi.b(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        ThreadManager.getUIHandler().postDelayed(new VideoStoryCapturePart.5(this), 200L);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label80;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131690181);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label80:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    auuy localauuy;
    if (bjeg.k(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
      }
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
      {
        localauuy = (auuy)paramArrayOfObject[0];
        paramArrayOfObject = (bhyu)paramArrayOfObject[1];
        b(false);
        bjeg.a(this.jdField_a_of_type_AndroidAppActivity, localauuy, paramArrayOfObject, null, 1);
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 2));
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "arg len = 2");
      }
      localauuy = (auuy)paramArrayOfObject[0];
      paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[1];
      localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if ((bjeg.j((Intent)localObject)) || (bjeg.a((Intent)localObject)) || (bjeg.b((Intent)localObject)) || (!bjeg.c(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
        }
        paramArrayOfObject = new Bundle();
        paramArrayOfObject.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localauuy.jdField_a_of_type_JavaLangString);
        localObject = new LocalMediaInfo();
        ((LocalMediaInfo)localObject).mMimeType = "pic";
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
        biys.a(this.jdField_a_of_type_AndroidAppActivity, localauuy.jdField_a_of_type_JavaLangString, (LocalMediaInfo)localObject, 0, (int)((LocalMediaInfo)localObject).mDuration, -1, 10023, 0, null, null, false, 11, 14, paramArrayOfObject);
        b(false);
        return;
      }
      if ((bjeg.l(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (bjeg.m(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
      {
        AETakeFacePhotoPreviewFragment.a(this.jdField_a_of_type_AndroidAppActivity, localauuy.jdField_a_of_type_JavaLangString, 1024);
        b(false);
        return;
      }
      localObject = wyf.a().a(localauuy.jdField_a_of_type_JavaLangString, "2");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    azvq.a(localauuy.jdField_a_of_type_JavaLangString, localOptions);
    wyf.a().a(localauuy.jdField_a_of_type_JavaLangString, (String)localObject, "2", localOptions.outWidth, localOptions.outHeight, false, localauuy.jdField_c_of_type_Int, new wul(this, (String)localObject, localauuy, paramArrayOfObject, localOptions));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wui(this));
    this.jdField_a_of_type_Wth = ((wth)bhur.a(this.jdField_a_of_type_Bhcw).a(wth.class));
    this.jdField_a_of_type_Wth.b().a(this.jdField_a_of_type_Bhcw, new wum(this));
  }
  
  private void f()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  private void g()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams.width = (this.jdField_a_of_type_Int + 1);
    localLayoutParams.height = (this.jdField_a_of_type_Int + 1);
    if (this.g == 0) {}
    for (localLayoutParams.topMargin = azvv.a(this.jdField_a_of_type_Bhcw.a(), 147.0F);; localLayoutParams.topMargin = (this.g + 1))
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams1.width = this.jdField_a_of_type_Int;
    localLayoutParams1.height = this.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.jdField_a_of_type_Bhcw != null)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        View localView = this.jdField_a_of_type_Bhcw.a().findViewById(2131300241);
        if (localView != null)
        {
          localLayoutParams2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          if ((!this.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Int == 0)) {
            break label154;
          }
          localLayoutParams2.topMargin = (this.jdField_f_of_type_Int + azvv.a(this.jdField_a_of_type_Bhcw.a(), 62.0F));
          localView.setLayoutParams(localLayoutParams2);
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int != 0)) {
        localLayoutParams1.topMargin = this.jdField_f_of_type_Int;
      }
    }
    for (;;)
    {
      if (this.g == 0) {
        this.g = localLayoutParams1.topMargin;
      }
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setLayoutParams(localLayoutParams1);
      return;
      label154:
      localLayoutParams2.topMargin = azvv.a(this.jdField_a_of_type_Bhcw.a(), 209.0F);
      break;
      localLayoutParams1.topMargin = azvv.a(this.jdField_a_of_type_Bhcw.a(), 147.0F);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        localLayoutParams1.topMargin = ((int)(0.0724138F * this.jdField_c_of_type_Int));
      } else {
        localLayoutParams1.topMargin = ((int)(0.1810345F * this.jdField_c_of_type_Int));
      }
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setOnSurfaceChangedListener(new wun(this));
  }
  
  private void l()
  {
    int i = 200;
    Object localObject = this.jdField_a_of_type_Bhcw.a().getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("AECAMERA_MODE", 200);
    }
    switch (i)
    {
    default: 
      m();
      return;
    case 203: 
      this.jdField_b_of_type_Boolean = false;
      j();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    case 202: 
      this.jdField_b_of_type_Boolean = true;
      j();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    localObject = this.jdField_a_of_type_Wsi.a();
    if (localObject == wsh.a) {
      m();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.a = ((wsh)localObject);
      return;
      if (localObject == wsh.b) {
        this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setBlockCameraFlag(true);
      }
    }
  }
  
  private void m()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void n()
  {
    b(true);
  }
  
  private void o()
  {
    p();
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setCaptureRequest(new wuk(this));
  }
  
  private void p()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView.setCaptureRequest(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return super.a(paramInt, paramVarArgs);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298277));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296610));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298278);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298274);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298275);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298276);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131298273);
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (bjlo.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    int i;
    if (this.jdField_a_of_type_Bhcw != null)
    {
      this.jdField_a_of_type_Int = azvv.a(this.jdField_a_of_type_Bhcw.a(), 250.0F);
      i = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
      if (this.jdField_c_of_type_Int >= i) {
        break label295;
      }
      this.jdField_a_of_type_Boolean = true;
      label234:
      if (this.jdField_a_of_type_Boolean)
      {
        int j = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F);
        if (this.jdField_c_of_type_Int >= j) {
          break label303;
        }
      }
    }
    label295:
    label303:
    float f1;
    for (this.jdField_f_of_type_Int = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);; this.jdField_f_of_type_Int = azvv.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f1 * 88.199997F))
    {
      e();
      return;
      this.jdField_a_of_type_Int = ((int)(0.6666667F * this.jdField_b_of_type_Int));
      break;
      this.jdField_a_of_type_Boolean = false;
      break label234;
      f1 = (i - this.jdField_c_of_type_Int) / azvv.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      o();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    case 262147: 
      n();
      return;
    case 262148: 
      b(paramVarArgs);
      return;
    }
    l();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    bivm.a().onDestroy();
    super.c();
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wuh
 * JD-Core Version:    0.7.0.1
 */