import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.AEPituCameraUnit.1;
import dov.com.qq.im.ae.AEPituCameraUnit.10;
import dov.com.qq.im.ae.AEPituCameraUnit.11;
import dov.com.qq.im.ae.AEPituCameraUnit.12;
import dov.com.qq.im.ae.AEPituCameraUnit.13;
import dov.com.qq.im.ae.AEPituCameraUnit.14;
import dov.com.qq.im.ae.AEPituCameraUnit.17;
import dov.com.qq.im.ae.AEPituCameraUnit.18;
import dov.com.qq.im.ae.AEPituCameraUnit.19;
import dov.com.qq.im.ae.AEPituCameraUnit.21;
import dov.com.qq.im.ae.AEPituCameraUnit.22;
import dov.com.qq.im.ae.AEPituCameraUnit.23;
import dov.com.qq.im.ae.AEPituCameraUnit.24;
import dov.com.qq.im.ae.AEPituCameraUnit.25;
import dov.com.qq.im.ae.AEPituCameraUnit.26;
import dov.com.qq.im.ae.AEPituCameraUnit.31;
import dov.com.qq.im.ae.AEPituCameraUnit.32;
import dov.com.qq.im.ae.AEPituCameraUnit.33;
import dov.com.qq.im.ae.AEPituCameraUnit.6;
import dov.com.qq.im.ae.AEPituCameraUnit.7;
import dov.com.qq.im.ae.AEPituCameraUnit.8;
import dov.com.qq.im.ae.AEPituCameraUnit.9;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.a;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.b;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.c;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.e;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel.a;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.capture.view.QIMProviderContainerView.b;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.a;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout.a;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar.a;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

@TargetApi(9)
public class awtq
  extends awrx
  implements alxa.a, View.OnClickListener, View.OnTouchListener, awyw.d, ayva.c, AEFilterManager.StickerInnerEffectFilterListener, MediaScanner.OnMediaInfoScannerListener, AECameraGLSurfaceView.a, AECameraGLSurfaceView.b, AECameraGLSurfaceView.c, QIMProviderContainerView.b, VideoFilterViewPager.a, AEPituCameraCaptureButtonLayout.a, BeautyBar.a
{
  private static final LinkedList<Integer> av = new LinkedList();
  public static boolean drV;
  public static boolean dsy;
  private ImageView HQ;
  private ViewStub K;
  private View LT;
  private alwm jdField_a_of_type_Alwm;
  private alwn jdField_a_of_type_Alwn;
  private alwo jdField_a_of_type_Alwo;
  private alwp jdField_a_of_type_Alwp;
  private alwq jdField_a_of_type_Alwq;
  private alwr jdField_a_of_type_Alwr;
  private awtq.b jdField_a_of_type_Awtq$b;
  private final awwa.a jdField_a_of_type_Awwa$a = new awty(this);
  private awwa jdField_a_of_type_Awwa = new awwa();
  private awwk jdField_a_of_type_Awwk;
  private awwp jdField_a_of_type_Awwp;
  private awzw jdField_a_of_type_Awzw;
  private awzz jdField_a_of_type_Awzz;
  private axgf jdField_a_of_type_Axgf;
  private axgg jdField_a_of_type_Axgg;
  private axgi jdField_a_of_type_Axgi;
  private axiu jdField_a_of_type_Axiu = new axiu();
  private axjb jdField_a_of_type_Axjb;
  private ayca jdField_a_of_type_Ayca;
  private aycb jdField_a_of_type_Aycb;
  private AEVideoCaptureResult jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  private final AECameraGLSurfaceView.e jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e = new awua(this);
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel.a jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a = new awtw(this);
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private AEPituCameraCaptureButtonLayout jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private long aBB;
  private boolean apL;
  private aybv jdField_b_of_type_Aybv = new aybv(10000, 100, 2);
  private SessionWrap jdField_b_of_type_DovComQqImAeSessionWrap;
  private AEMaterialPanel jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AECaptureMode jdField_b_of_type_DovComQqImAeModeAECaptureMode;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private RelativeLayout bottom_blackLH;
  private int byT = 11;
  private boolean bzA;
  private volatile boolean cAI;
  private boolean cSH = axiz.aOK();
  private String cTk;
  private boolean drA;
  private boolean dsA;
  private boolean dsB;
  private volatile boolean dsC;
  private boolean dsD;
  private boolean dsE;
  private boolean dsz;
  private int eCU = 0;
  private int eCV;
  private volatile SurfaceTexture f;
  private CountDownLatch g = new CountDownLatch(1);
  private Runnable iI;
  private long ie = -1L;
  private LocalMediaInfo k;
  private GestureDetector mGestureDetector;
  private View mRootView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private LinearLayout top_blackLH;
  
  public awtq()
  {
    axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    axiy.d("AEPituCameraUnit", "unitConstructor--fake");
    axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] + END");
  }
  
  public awtq(aycb paramaycb, ayca paramayca)
  {
    axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] + BEGIN");
    long l = System.currentTimeMillis();
    axgk.a().acy("unitConstructor-begin");
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Ayca = paramayca;
    this.byT = 11;
    arlc.b(BaseApplicationImpl.getContext(), false, 5);
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
    if (axcg.oi(getFrom()))
    {
      this.byT = 13;
      this.jdField_b_of_type_Aybv = new aybv(10023, getActivity().getIntent().getIntExtra("entrance_type", 120), 14);
    }
    for (;;)
    {
      axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] submit unit init");
      ThreadManager.excute(new AEPituCameraUnit.1(this), 16, null, true);
      axiy.i("AEPituCameraUnit", "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
      if (!axcg.e.ob(getFrom()))
      {
        this.byT = 11;
        this.jdField_b_of_type_Aybv = new aybv(10023, getActivity().getIntent().getIntExtra("entrance_type", 120), 14);
      }
      else
      {
        this.byT = 1;
      }
    }
  }
  
  private void Or(boolean paramBoolean)
  {
    try
    {
      QQLowLightFilter.enableNightMode(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void XF(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.dsE)
      {
        if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
        {
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(true);
        }
        Or(true);
        this.dsE = false;
        axiy.i("AEPituCameraUnit", "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
    }
    Or(false);
    this.dsE = false;
  }
  
  private void XH(boolean paramBoolean)
  {
    axiy.i("AEPituCameraUnit", "closeCamera");
    if (!isOnTop())
    {
      axiy.e("AEPituCameraUnit", "closeCamera---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_Awwa.XM(paramBoolean);
  }
  
  private AECaptureMode a(AECaptureMode[] paramArrayOfAECaptureMode, int paramInt)
  {
    String str = getActivity().getIntent().getStringExtra("KEY_CURRENT_TAB");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      AECaptureMode localAECaptureMode2 = AECaptureMode.fromName(str);
      int i;
      if (localAECaptureMode2 != null)
      {
        i = paramArrayOfAECaptureMode.length;
        paramInt = 0;
        label40:
        if (paramInt < i) {
          if (paramArrayOfAECaptureMode[paramInt] != localAECaptureMode2) {}
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        AECaptureMode localAECaptureMode1 = localAECaptureMode2;
        if (paramInt == 0)
        {
          axiy.e("AEPituCameraUnit", "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        axiy.i("AEPituCameraUnit", "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        i = getActivity().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (axcg.c.getId() == i)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!axcg.oe(i))) {
          break label214;
        }
        str = axis.a().t("app_alg_entrance_qzone_id_from833", "", 4);
        break;
        paramInt += 1;
        break label40;
      }
      label214:
      str = null;
    }
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    stopAnim();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.iI = new AEPituCameraUnit.21(this);
    this.mUIHandler.post(new AEPituCameraUnit.22(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = paramAECaptureMode2;
    if (paramAECaptureMode1 == paramAECaptureMode2) {}
    label231:
    label236:
    do
    {
      return;
      axiy.i("AEPituCameraUnit", "onCaptureModeChanged---from " + paramAECaptureMode1 + " to " + paramAECaptureMode2);
      b(paramAECaptureMode1, paramAECaptureMode2);
      if (this.jdField_a_of_type_Alwm != null) {
        this.jdField_a_of_type_Alwm.dKo();
      }
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
      {
        bool1 = true;
        axip.a().Ym(bool1);
        if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
        }
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.19(this));
        paramAECaptureMode1 = this.jdField_a_of_type_Awwp;
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
          break label231;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAECaptureMode1.XR(bool1);
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) {
          break label236;
        }
        if (this.jdField_a_of_type_Awzz != null) {
          this.jdField_a_of_type_Awzz.eIo();
        }
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwn);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwq);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwr);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwp);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwm);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwo);
        return;
        bool1 = false;
        break;
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwn)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwn);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwq)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwq);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwp)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwp);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwr)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwr);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwp)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwp);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwm)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwm);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Alwo));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwo);
  }
  
  private boolean aNG()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    while (axcg.ax(getActivity().getIntent())) {
      return false;
    }
    return true;
  }
  
  private boolean aNH()
  {
    if (Build.VERSION.SDK_INT < 23) {
      axiy.i("AEPituCameraUnit", "checkPermission---below android6.0, no need check");
    }
    int i;
    int j;
    boolean bool;
    do
    {
      return true;
      Activity localActivity = getActivity();
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      bool = aczy.bd(localActivity);
      axiy.i("AEPituCameraUnit", "checkPermission, camera: " + i + " audio: " + j + ", storage=" + bool);
    } while ((i == 0) && (j == 0) && (bool));
    return false;
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (!this.drA) {}
    do
    {
      return;
      if (paramAEVideoCaptureResult.videoFrameCount < 5L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AEPituCameraUnit", 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + 5L);
        }
        eFm();
        return;
      }
      axiy.i("AEPituCameraUnit", "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      axip.a().ob(5L);
      axim.a().eLl();
      long l = iV();
      if (l > 0L)
      {
        paramAEVideoCaptureResult = new Intent(getActivity(), AEStoryGIFPreviewActivity.class);
        paramAEVideoCaptureResult.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
        paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_EMO_COUNT", l);
        Object localObject1 = (axcz)awuh.a(this).b(axcz.class);
        Object localObject2 = (axby)((axcz)localObject1).i().getValue();
        if (localObject2 != null) {}
        for (boolean bool = true;; bool = false)
        {
          paramAEVideoCaptureResult.putExtra("KEY_MATERIAL_APPLIED", bool);
          if (localObject2 != null) {
            paramAEVideoCaptureResult.putExtra("ARG_GIF_MATERIAL_ID", ((axby)localObject2).id);
          }
          paramAEVideoCaptureResult.putExtra("KEY_AVAILABLE_SAVENAME", (String)((axcz)localObject1).j().getValue());
          paramAEVideoCaptureResult.putExtra("ARG_SESSION_INFO", this.jdField_b_of_type_DovComQqImAeSessionWrap);
          paramAEVideoCaptureResult.putExtra("ARG_GIF_SEND_TO_AIO", axcg.av(getActivity().getIntent()));
          localObject1 = getActivity();
          if (localObject1 == null) {
            break;
          }
          localObject2 = ((Activity)localObject1).getIntent();
          if (localObject2 != null)
          {
            int i = ((Intent)localObject2).getIntExtra("AECAMERA_MODE", 200);
            int j = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
            paramAEVideoCaptureResult.putExtra("AECAMERA_MODE", i);
            paramAEVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", j);
          }
          ((Activity)localObject1).startActivityForResult(paramAEVideoCaptureResult, 101);
          return;
        }
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this, paramAEVideoCaptureResult));
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      stopPreview();
    }
    if (!paramAECaptureMode2.shouldStartCamera()) {
      XH(false);
    }
    int i;
    do
    {
      return;
      i = alwt.Ip();
      if (paramAECaptureMode2 == AECaptureMode.GIF) {
        i = 1;
      }
      if (!this.drA)
      {
        this.jdField_a_of_type_Awwa.ads(i);
        return;
      }
    } while (!this.dsC);
    this.jdField_a_of_type_Awwa.a(i, new awtv(this));
  }
  
  private void dLb()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.33(this));
  }
  
  private void eFT()
  {
    int i = getActivity().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
    if (getFrom() != axcg.x.getId())
    {
      String str = getActivity().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (axcg.a(i).isNeedReport()) {
        axip.a().eI(i, str);
      }
      str = getActivity().getIntent().getStringExtra("intent_key_uid_for_report");
      axip.a().setUin(str);
      axip.a().Yl(true);
      axip.a().eLs();
      axip.a().eLr();
      axip.a().acR(axbk.bS(getActivity()));
    }
    axim.a().eLh();
    if (axcg.e.ob(i)) {
      rar.a("check_Android", axcg.e.getId(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void eFY()
  {
    Object localObject = getActivity();
    if (ankt.getRealHeight((Context)localObject) / ankt.aE((Context)localObject) >= 2.0F)
    {
      this.bottom_blackLH.setVisibility(8);
      this.top_blackLH.setVisibility(8);
      if (!axcg.oi(getFrom())) {
        ayxa.resetFullScreen((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    localObject = this.LT.getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new awug(this));
    }
  }
  
  private void eFZ()
  {
    axiy.i("AEPituCameraUnit", "setInitialMode---");
    axgf localaxgf = (axgf)awuh.a(this).b(axgf.class);
    localaxgf.t.setValue(new axfz(null, this.jdField_b_of_type_DovComQqImAeModeAECaptureMode, 1));
    localaxgf.u.setValue(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode);
  }
  
  private void eFm()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
  }
  
  private void eFn()
  {
    this.jdField_a_of_type_Axgg.p().postValue(Boolean.valueOf(false));
  }
  
  private void eFs()
  {
    this.jdField_a_of_type_Awwk.dLp();
    ayxa.a(this.top_blackLH, this.bottom_blackLH, aqnm.dip2px(1.0F));
  }
  
  private void eGa()
  {
    int i = 200;
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
    AECaptureMode.NORMAL.setHasCountDown(false);
    switch (i)
    {
    default: 
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
      boolean bool = getActivity().getIntent().getBooleanExtra("key_has_countdown", false);
      AECaptureMode.NORMAL.setHasCountDown(bool);
    }
    for (;;)
    {
      axiy.i("AEPituCameraUnit", "initCaptureModesAndFirstMode---initialMode=" + this.jdField_b_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
      return;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.PLAY };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.PLAY;
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.PLAY, AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.PLAY;
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, i);
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, i);
      continue;
      this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = new AECaptureMode[] { AECaptureMode.GIF };
      this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.GIF;
    }
  }
  
  private void eGd()
  {
    if (this.dsB) {
      return;
    }
    this.dsB = true;
    axiy.i("AEPituCameraUnit", "actionAfterFirstFrame");
    int i = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.y(axpk.cVE, new Object[] { this, Integer.valueOf(i) });
    if (!this.apL)
    {
      this.apL = true;
      PeakAppInterface.a.aeC(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this));
  }
  
  private void eGg()
  {
    axiy.i("AEPituCameraUnit", "tryStartPreview---ENTER");
    if (!isOnTop())
    {
      axiy.e("AEPituCameraUnit", "tryStartPreview---EXIT, not called by the top unit");
      return;
    }
    if (!this.drA)
    {
      axiy.e("AEPituCameraUnit", "tryStartPreview---EXIT, activity not resumed");
      return;
    }
    Object localObject = this.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
    if ((localObject == null) || (!((AECaptureMode)localObject).shouldStartCamera()))
    {
      axiy.e("AEPituCameraUnit", "tryStartPreview---EXIT, not right mode: " + localObject);
      return;
    }
    if (this.f == null)
    {
      axiy.e("AEPituCameraUnit", "tryStartPreview---EXIT, mPreviewTexture is NULL");
      return;
    }
    if (axix.a() == null)
    {
      axiy.e("AEPituCameraUnit", "tryStartPreview---EXIT, mMaxPreviewSize is NULL");
      return;
    }
    localObject = axix.a((AECaptureMode)localObject, axix.a(), this.dsD, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    this.jdField_a_of_type_Awwa.a(this.jdField_a_of_type_Awwa$a);
    this.jdField_a_of_type_Awwa.a(this.f, (aasq)localObject);
    axiy.i("AEPituCameraUnit", "tryStartPreview---EXIT, normal");
  }
  
  private void eGh()
  {
    axiy.i("AEPituCameraUnit", "tryOpenCamera---ENTER");
    if (!isOnTop())
    {
      axiy.e("AEPituCameraUnit", "tryOpenCamera---EXIT, not called by the top unit");
      return;
    }
    AECaptureMode localAECaptureMode = this.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
    if ((localAECaptureMode == null) || (!localAECaptureMode.shouldStartCamera()))
    {
      axiy.e("AEPituCameraUnit", "tryOpenCamera---EXIT, not right mode: " + localAECaptureMode);
      return;
    }
    this.jdField_a_of_type_Awwa.a(new awtx(this));
  }
  
  private void eGi()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Aycb.getActivity() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Aycb.getActivity();
    int i;
    label51:
    int j;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label176;
      }
      j = 1;
      label64:
      if (aczy.bd(localQIMCameraCaptureActivity)) {
        break label181;
      }
    }
    label176:
    label181:
    for (int m = 1;; m = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (m != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label51;
      j = 0;
      break label64;
    }
  }
  
  private void eGj()
  {
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_Axjb == null) {
      this.jdField_a_of_type_Axjb = new axjb(localActivity);
    }
    this.jdField_a_of_type_Axjb.aF(new AEPituCameraUnit.32(this));
  }
  
  private int getFrom()
  {
    if (getActivity().getIntent() != null) {
      return getActivity().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
    }
    return axcg.a.getId();
  }
  
  private long iV()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = aqft.hE();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    l1 >>>= 20;
    QLog.d("AEPituCameraUnit", 4, "available size = " + l1 + "M");
    return l1 / 30L;
  }
  
  private void initData()
  {
    this.dsD = axcg.ay(getActivity().getIntent());
    if (this.dsD)
    {
      int i = axis.a().l("sp_key_ae_camera_ratio", AEVideoStoryTopBarViewModel.Ratio.R_1_1.code, 0);
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.fromCode(i);
      axiy.i("AEPituCameraUnit", "initData---init ratio=" + this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio + ", from sp code=" + i);
      ((AEVideoStoryTopBarViewModel)awuh.a(this).b(AEVideoStoryTopBarViewModel.class)).d.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    }
    eGa();
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = this.jdField_b_of_type_DovComQqImAeModeAECaptureMode;
  }
  
  private boolean isOnTop()
  {
    Integer localInteger = (Integer)av.peek();
    return (localInteger != null) && (localInteger.intValue() == this.eCV);
  }
  
  private void stopAnim()
  {
    if (this.iI != null)
    {
      this.mUIHandler.removeCallbacks(this.iI);
      this.iI = null;
    }
    if (this.HQ != null) {
      this.mUIHandler.post(new AEPituCameraUnit.23(this));
    }
  }
  
  private void stopPreview()
  {
    axiy.i("AEPituCameraUnit", "stopPreview");
    if (!isOnTop())
    {
      axiy.e("AEPituCameraUnit", "stopPreview---EXIT, not called by the top unit");
      return;
    }
    this.jdField_a_of_type_Awwa.dQk();
  }
  
  public void Bx(boolean paramBoolean)
  {
    this.dsz = paramBoolean;
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
  }
  
  public void CT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!drV)
    {
      drV = true;
      this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new AEPituCameraUnit.24(this));
      return;
    }
    this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new AEPituCameraUnit.25(this));
  }
  
  public void S(@NonNull List<awyu.b> paramList, @NonNull List<awyu.a> paramList1)
  {
    this.jdField_a_of_type_Axgi.p(720897, new Object[] { paramList, paramList1 });
  }
  
  public void XG(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.eUa();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.eUc();
  }
  
  protected awvv a()
  {
    int i = 1;
    Intent localIntent = getActivity().getIntent();
    if (axcg.ax(localIntent)) {
      if ((!localIntent.getBooleanExtra("key_camera_prefer_id", false)) && (aeah.agb())) {}
    }
    label36:
    int j;
    for (i = 2; anki.axO(); i = j)
    {
      return aywy.a().a(this.jdField_a_of_type_Aycb.getActivity(), i);
      j = alwt.Ip();
      if ((this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) && (aeah.agb())) {
        break label36;
      }
    }
    return aywy.a().b(this.jdField_a_of_type_Aycb.getActivity(), i);
  }
  
  public awwk a()
  {
    return this.jdField_a_of_type_Awwk;
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    axip.a().ob(1L);
    axim.a().oa(-1L);
    axiy.i("AEPituCameraUnit", "【Type】Photo");
    Object localObject = getActivity().getIntent();
    if (axcg.ay((Intent)localObject))
    {
      this.jdField_a_of_type_Axgi.p(262148, new Object[] { paramh });
      return;
    }
    if (axcg.av((Intent)localObject))
    {
      localObject = new aybw.a(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.Is()).a(this.jdField_b_of_type_DovComQqImAeSessionWrap).a(this.cTk).a(1).b();
      this.jdField_b_of_type_Aybv.a((aybw)localObject);
      this.jdField_a_of_type_Axgi.p(262148, new Object[] { paramh, this.jdField_b_of_type_Aybv, this.jdField_a_of_type_Axgi.a(196610, new Object[0]) });
      return;
    }
    this.jdField_a_of_type_Axgi.p(262148, new Object[] { paramh, this.jdField_a_of_type_Axgi.a(196610, new Object[0]) });
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    stopAnim();
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      if (paramVideoMaterial == null) {
        axip.a().acS("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        axat.a().setListener();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)) {
        break label102;
      }
      getActivity().runOnUiThread(new AEPituCameraUnit.17(this, paramVideoMaterial));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Awzz != null) {
        this.jdField_a_of_type_Awzz.a(paramVideoMaterial);
      }
      return;
      axip.a().acS(paramVideoMaterial.getId());
      break;
      label102:
      getActivity().runOnUiThread(new AEPituCameraUnit.18(this, paramVideoMaterial));
    }
  }
  
  public void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
    {
      b(paramAEVideoCaptureResult);
      return;
    }
    int i = 500;
    if (this.byT == 13) {
      i = 2000;
    }
    if (ayzc.at(paramAEVideoCaptureResult.videoMp4FilePath) < i)
    {
      this.bzA = false;
      eFm();
      return;
    }
    this.k = new LocalMediaInfo();
    this.k.path = paramAEVideoCaptureResult.videoMp4FilePath;
    this.k.mMimeType = "video";
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.k);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      onBackPressed();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public boolean aNE()
  {
    return (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.aRr());
  }
  
  /* Error */
  public boolean aNF()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 161	awtq:eCU	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpeq +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	awtq
    //   8	4	1	i	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public void acc(String paramString)
  {
    Object localObject = (axbr)axov.a().c(18);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = ((axbr)localObject).a(paramString, apb());
      if (paramString == null) {
        Toast.makeText(getActivity(), 2131689939, 1).show();
      }
    }
    else
    {
      return;
    }
    if (axcg.ay(getActivity().getIntent()))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("ae_editor_bottom_tab_show_hide");
      ((Intent)localObject).putExtra("is_show", false);
      getActivity().sendBroadcast((Intent)localObject);
    }
    a().by(true, 150);
    this.jdField_a_of_type_Axgi.p(327683, new Object[] { paramString });
    this.jdField_a_of_type_Axgi.p(196612, new Object[0]);
  }
  
  public void ada(int paramInt)
  {
    this.jdField_a_of_type_Awwk.setBeautyLevel(paramInt);
  }
  
  public void adj(int paramInt)
  {
    View localView = this.mRootView.findViewById(2131367272);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i("AEPituCameraUnit", 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void adk(int paramInt)
  {
    try
    {
      this.eCU = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean apb()
  {
    return axcg.oi(getFrom());
  }
  
  public void auC()
  {
    this.jdField_a_of_type_Aycb.getActivity().onBackPressed();
  }
  
  public void bSU() {}
  
  public void bSV()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.9(this));
    this.jdField_a_of_type_Axgi.p(196609, new Object[0]);
    this.jdField_a_of_type_Axgi.p(262145, new Object[0]);
  }
  
  protected void biN()
  {
    this.jdField_a_of_type_Axgf = ((axgf)awuh.a(this).b(axgf.class));
    this.jdField_a_of_type_Axgf.t.a(this, new awts(this));
    this.jdField_a_of_type_Axgg = ((axgg)awuh.a(this).b(axgg.class));
    if (axcg.ay(getActivity().getIntent())) {
      ((AEVideoStoryTopBarViewModel)awuh.a(this).b(AEVideoStoryTopBarViewModel.class)).d.a(this, new awtt(this));
    }
  }
  
  public boolean bj(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23)
      {
        Activity localActivity = getActivity();
        bool1 = bool2;
        if (!Settings.System.canWrite(localActivity))
        {
          aqha.b(localActivity, null, null);
          bool1 = false;
        }
      }
    }
    if (bool1) {
      this.jdField_a_of_type_Awwa.XO(paramBoolean);
    }
    return bool1;
  }
  
  public void cQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Awzz != null) {
      this.jdField_a_of_type_Awzz.cQ(paramBoolean1, paramBoolean2);
    }
  }
  
  public void coA()
  {
    this.bzA = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.eGL();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.dKM();
    coy();
    ((axpr)axov.a(5)).YP(true);
    adj(8);
  }
  
  public void coB()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.dKN();
    this.bzA = false;
    ((axpr)axov.a(5)).YP(false);
    adj(0);
  }
  
  public void cox()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (aeah.agb()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      if (!GLVideoClipUtil.aRj()) {
        break label110;
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    for (;;)
    {
      XG(true);
      axip.a().eLy();
      axim.a().reportLaunch();
      if ((!this.jdField_a_of_type_Axgf.aOy()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(0);
      }
      this.jdField_a_of_type_Axgg.p().postValue(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
      break;
      label110:
      if ((this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) && (this.dsE))
      {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
      }
    }
  }
  
  public void coy()
  {
    if (this.jdField_a_of_type_Awzz != null) {
      this.jdField_a_of_type_Awzz.eIp();
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    }
    this.jdField_a_of_type_Axgg.p().postValue(Boolean.valueOf(false));
  }
  
  public void dKK()
  {
    if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != null) && (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) && (axix.a() != null))
    {
      aasq localaasq = axix.a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, axix.a(), this.dsD, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(localaasq);
    }
    eFn();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.setVisibility(8);
    }
    this.jdField_a_of_type_Axgi.p(196609, new Object[0]);
    this.jdField_a_of_type_Axgi.p(262147, new Object[0]);
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int m = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Aycb.getActivity();
    int i;
    int j;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label187;
      }
      j = 1;
      label48:
      if (aczy.bd((Context)localObject)) {
        break label192;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (i != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        axiy.i("AEPituCameraUnit", "【Camera Permission】denied");
      }
      if (j != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        axiy.i("AEPituCameraUnit", "【Audio Permission】denied");
      }
      if (m != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        axiy.i("AEPituCameraUnit", "【External Storage Permission】denied");
      }
      localObject = aqha.i((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.31(this, (String)localObject));
      return;
      i = 0;
      break;
      label187:
      j = 0;
      break label48;
      label192:
      m = 0;
    }
  }
  
  public void eFf()
  {
    coy();
  }
  
  public void eFg()
  {
    eFm();
  }
  
  public void eFt() {}
  
  public void eFx() {}
  
  public void eGb()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.7(this));
    int i = AEBeautyProviderView.QU();
    int j = AEBeautyProviderView.QV();
    this.jdField_a_of_type_Awwk.setBeautyLevel(i);
    this.jdField_a_of_type_Awwk.setSharpFaceLevel(j);
    this.mUIHandler.post(new AEPituCameraUnit.8(this));
  }
  
  public void eGc()
  {
    this.jdField_a_of_type_Axgi.p(786435, new Object[0]);
  }
  
  public void eGe()
  {
    this.jdField_a_of_type_Awwk.eGY();
  }
  
  public void eGf()
  {
    getActivity().getIntent().removeExtra("widgetinfo");
    axja.cQ(getActivity());
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public Activity getActivity()
  {
    if (this.jdField_a_of_type_Aycb == null) {
      return null;
    }
    return this.jdField_a_of_type_Aycb.getActivity();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    axiy.i("AEPituCameraUnit", "【Camera / Audio / Storage Permission】grant");
    this.dsC = true;
    if (this.drA) {
      eGh();
    }
  }
  
  public void lp(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.6(this));
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      adk(1);
      if (this.jdField_a_of_type_Axgi != null) {
        this.jdField_a_of_type_Axgi.p(196609, new Object[0]);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Aycb != null) && (this.jdField_a_of_type_Aycb.getActivity() != null)) {
        this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new AEPituCameraUnit.26(this, paramBoolean));
      }
      return;
      adk(0);
    }
  }
  
  public void onActivityPause()
  {
    axiy.i("AEPituCameraUnit", "onActivityPause");
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onPause();
    super.onActivityPause();
    this.drA = false;
    stopPreview();
    XH(false);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwn);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwq);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwr);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwp);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwm);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwo);
    this.jdField_a_of_type_Awwp.clearState();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.onPause();
    }
    this.jdField_a_of_type_Awwk.onStop();
    this.jdField_a_of_type_Axgi.onActivityPause();
    if (QLog.isDevelopLevel()) {
      axiy.d("AEPituCameraUnit", "onActivityPause, ID=" + this.eCV);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraUnit", 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + dsy);
    }
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    alxg.f(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing())) {
      if (QLog.isColorLevel())
      {
        bool1 = bool2;
        if (localActivity == null) {
          bool1 = true;
        }
        QLog.d("AEPituCameraUnit", 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool1) });
      }
    }
    do
    {
      return;
      if (paramInt1 != 1024) {
        break;
      }
    } while (paramInt2 != -1);
    localActivity.setResult(-1, paramIntent);
    localActivity.finish();
    return;
    String str1;
    if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
    {
      str1 = paramIntent.getStringExtra("file_send_path");
      long l = paramIntent.getLongExtra("file_send_duration", -1L);
      String str2 = paramIntent.getStringExtra("widgetinfo");
      if ((!TextUtils.isEmpty(str1)) && (l > 0L))
      {
        paramIntent = new Intent(localActivity, SendVideoActivity.class);
        paramIntent.putExtra("file_send_path", str1);
        paramIntent.putExtra("file_send_size", new File(str1).length());
        paramIntent.putExtra("file_send_duration", l);
        paramIntent.putExtra("uin", this.jdField_b_of_type_DovComQqImAeSessionWrap.aTl);
        paramIntent.putExtra("uintype", this.jdField_b_of_type_DovComQqImAeSessionWrap.cZ);
        paramIntent.putExtra("file_source", "album");
        paramIntent.putExtra("start_init_activity_after_sended", false);
        if (!TextUtils.isEmpty(str2)) {
          paramIntent.putExtra("widgetinfo", str2);
        }
        localActivity.startActivity(paramIntent);
        localActivity.finish();
        return;
      }
    }
    if ((paramIntent == null) && (paramInt2 == 0) && (dsy))
    {
      dsy = false;
      return;
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_Awwk.apk();
    }
    if (paramInt2 == 0) {
      awte.a(null);
    }
    if ((paramIntent != null) && (this.jdField_b_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_b_of_type_DovComQqImAeSessionWrap.c());
    }
    if ((paramInt1 == 1012) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if ((paramIntent == null) || (!paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
          break label538;
        }
      }
      for (;;)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("input_full_screen_mode_result", str1);
        paramIntent.putExtra("input_full_screen_mode", bool1);
        localActivity.setResult(-1, paramIntent);
        localActivity.finish();
        return;
        str1 = "";
        break;
        label538:
        bool1 = false;
      }
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      awtf.a(this.jdField_a_of_type_Aycb.getActivity(), paramIntent, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, this.jdField_a_of_type_Ayca, null);
      return;
    }
    this.jdField_a_of_type_Axgi.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onActivityResume()
  {
    axiy.i("AEPituCameraUnit", "onActivityResume");
    super.onActivityResume();
    this.drA = true;
    if (dsy)
    {
      axiy.e("AEPituCameraUnit", "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
      return;
    }
    stopPreview();
    XH(false);
    if (this.dsD) {
      this.dsC = aNH();
    }
    label67:
    awrz localawrz;
    if (this.dsC)
    {
      eGh();
      this.jdField_a_of_type_Awwa.eGO();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwn);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwq);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwr);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwp);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwm);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwo);
      this.jdField_a_of_type_Awwk.onResume();
      if (this.dsA)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.onResume();
        }
        cox();
        Bx(false);
      }
      this.jdField_a_of_type_Axgi.onActivityResume();
      localawrz = (awrz)axov.a(13);
      if (!axcg.e.ob(getFrom())) {
        break label279;
      }
      localawrz.Gf(14);
    }
    for (;;)
    {
      XG(false);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      axiy.d("AEPituCameraUnit", "onActivityResume, ID=" + this.eCV);
      return;
      if (!this.cAI)
      {
        this.cAI = true;
        eGi();
        break label67;
      }
      eGj();
      break label67;
      label279:
      localawrz.Gf(this.jdField_b_of_type_Aybv.EP);
    }
  }
  
  public void onActivityStart()
  {
    axiy.i("AEPituCameraUnit", "onActivityStart");
    super.onActivityStart();
    this.jdField_a_of_type_Axgi.onActivityStart();
    this.ie = System.currentTimeMillis();
    axim.a().eKN();
    if (QLog.isDevelopLevel()) {
      axiy.d("AEPituCameraUnit", "onActivityStart, ID=" + this.eCV);
    }
  }
  
  public void onActivityStop()
  {
    axiy.i("AEPituCameraUnit", "onActivityStop");
    super.onActivityStop();
    this.jdField_a_of_type_Axgi.onActivityStop();
    axim.a().nZ(this.ie);
    if (QLog.isDevelopLevel()) {
      axiy.d("AEPituCameraUnit", "onActivityStop, ID=" + this.eCV);
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.jdField_a_of_type_Awwk == null) {
      return false;
    }
    if (this.jdField_a_of_type_Awwk.aOc()) {
      return false;
    }
    if ((this.jdField_a_of_type_Axgi.ol(589824)) && (((Boolean)this.jdField_a_of_type_Axgi.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Axgi.p(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Awwk.onStop();
    this.jdField_a_of_type_Awwk.apk();
    Intent localIntent;
    String str1;
    String str2;
    if (axcg.ay(getActivity().getIntent()))
    {
      localIntent = getActivity().getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 == null) {
        QQToast.a(getActivity(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).show();
      }
    }
    else
    {
      this.jdField_a_of_type_Aycb.eET();
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF) {
        break label269;
      }
    }
    for (;;)
    {
      return true;
      localIntent.setClassName(str2, str1);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
      localIntent.addFlags(603979776);
      if (!localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        getActivity().startActivity(localIntent);
        break;
      }
      localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = localIntent.getStringExtra("PhotoConst.UIN");
      if (!"qzone_plugin.apk".equals(str2)) {
        break;
      }
      QzonePluginProxyActivity.x(localIntent, str1);
      avpw.a(getActivity(), str3, localIntent, 2);
      break;
      label269:
      axim.a().eKO();
      axiy.i("AEPituCameraUnit", "【Click】onBackPressed");
    }
  }
  
  public void onCaptureError(int paramInt)
  {
    this.bzA = false;
    axiy.e("AEPituCameraUnit", "onCaptureError. errorCode = " + paramInt, new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.10(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
      {
        axxe.a(this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.H(), 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.isSelected())
        {
          bool = true;
          label105:
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(bool);
          Or(bool);
          if (bool) {
            break label147;
          }
          this.dsE = true;
          label127:
          alxg.Oo(bool);
          if (!bool) {
            break label155;
          }
        }
        for (;;)
        {
          alwx.TB(i);
          break;
          bool = false;
          break label105;
          label147:
          this.dsE = false;
          break label127;
          label155:
          i = 2;
        }
        if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
          axxe.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.H(), 200L, null);
        }
        this.jdField_a_of_type_Awwk.dKT();
        if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
          if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.isFrontCamera())
          {
            this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131718861));
          }
          else
          {
            this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131718862));
            continue;
            axxe.a(paramView, 200L, null);
            auC();
            continue;
            getActivity().getIntent().removeExtra("widgetinfo");
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    axiy.d("AEPituCameraUnit", "[AE Profiler] AEPituCameraUnit onCreate");
    long l = getActivity().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    axip.a().oc(l);
    super.onCreate(paramBundle);
    this.dsC = aNH();
    atao.dgW = true;
    dsy = false;
    ayva.a().ZP(false);
    this.jdField_b_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Aycb.getActivity().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.cTk = this.jdField_a_of_type_Aycb.getActivity().getIntent().getStringExtra("ARG_AIO_CLASS");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = ((AEVideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
      this.eCV = paramBundle.getInt("KEY_IDENTITY_CODE_SAVE");
      axiy.i("AEPituCameraUnit", "onCreate, restore from background, ID=" + this.eCV);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.cO(this.jdField_a_of_type_Aycb.getActivity());
      this.jdField_a_of_type_Axiu.acV();
      axik.registerModule();
      if (!av.contains(Integer.valueOf(this.eCV))) {
        av.push(Integer.valueOf(this.eCV));
      }
      axiy.i("AEPituCameraUnit", "onCreate, ID=" + this.eCV + ", sUnitStack=" + av);
      return;
      this.eCV = (av.size() + 1);
      axiy.i("AEPituCameraUnit", "onCreate, new created, ID=" + this.eCV);
    }
  }
  
  public View onCreateView()
  {
    axgk.a().acy("unitInflateView-begin");
    Object localObject;
    if (axcg.oi(getFrom()))
    {
      localObject = this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(2131558579, null, false);
      axgk.a().acy("unitInflateView-end");
      this.mRootView = ((View)localObject).findViewById(2131367347);
      initData();
      this.LT = ((View)localObject).findViewById(2131367348);
      this.jdField_a_of_type_Awtq$b = ((awtq.b)awuh.a(this).b(awtq.b.class));
      this.top_blackLH = ((LinearLayout)this.mRootView.findViewById(2131363559));
      this.bottom_blackLH = ((RelativeLayout)this.mRootView.findViewById(2131363557));
      ayxa.a(this.top_blackLH, this.bottom_blackLH, aqnm.dip2px(1.0F));
      eFY();
      this.jdField_a_of_type_Awwk = new awwk(this.mRootView, this);
      this.jdField_a_of_type_Awwp = new awwp((ViewStub)this.mRootView.findViewById(2131378868));
      this.jdField_a_of_type_Awtq$b.b.postValue(this.jdField_a_of_type_Awwp);
      localObject = this.jdField_a_of_type_Awwp;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
        break label958;
      }
      bool = true;
      label216:
      ((awwp)localObject).a(this, bool);
      this.jdField_a_of_type_Axgi = new axgi(this.jdField_a_of_type_Aycb.getActivity(), this.mRootView, this);
      if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
      {
        eFZ();
        this.jdField_a_of_type_Axgi.init();
      }
      this.mGestureDetector = new GestureDetector(this.jdField_a_of_type_Aycb.getActivity(), new awtq.a(null), null, true);
      this.jdField_a_of_type_Awzz = new awzz(this.mRootView, this.jdField_a_of_type_Axgi);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364201));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAEKitInitListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setEventCallback(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$e);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(this.jdField_a_of_type_Awwk);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new awtu(this));
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsVoiceNeedEncode(axcg.ay(getActivity().getIntent()));
      localObject = a();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a(this.jdField_a_of_type_Awwa, (awvv)localObject);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPreExtractFrame(axcg.ok(getFrom()));
      this.jdField_a_of_type_Awwa.a((awvv)localObject);
      this.jdField_a_of_type_Awwa.setDarkModeEnable(true);
      this.jdField_a_of_type_Awwa.setDarkModeListener(this);
      this.jdField_a_of_type_Awwa.a(new alxa());
      this.jdField_a_of_type_Awwa.a(this.jdField_a_of_type_Awwa$a);
      if (!anki.axO()) {
        break label963;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      if (awyu.aOl()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = this;
      }
      this.K = ((ViewStub)this.mRootView.findViewById(2131378863));
      this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2131373750));
      if (this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
      {
        this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$a);
        this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
      }
      this.jdField_a_of_type_Awzw = new awzw((ViewStub)this.mRootView.findViewById(2131378860));
      this.jdField_a_of_type_Awtq$b.a.setValue(this.jdField_a_of_type_Awzw);
      CosFunHelper.setCountDownListener(new awtz(this));
      this.jdField_a_of_type_Alwn = new alwn();
      this.jdField_a_of_type_Alwn.dX(this.mRootView);
      this.jdField_a_of_type_Alwn.a(this.jdField_b_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      this.jdField_a_of_type_Alwn.a(new awuf(this));
      this.jdField_a_of_type_Awzw.a(this.jdField_a_of_type_Alwn);
      this.jdField_a_of_type_Alwq = this.jdField_a_of_type_Awwp.a();
      this.jdField_a_of_type_Alwr = new alwr(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
      this.jdField_a_of_type_Alwp = new alwp();
      this.jdField_a_of_type_Alwm = new alwm(this.K);
      this.jdField_a_of_type_Alwo = new alwo(this.jdField_a_of_type_Aycb.getActivity());
      if ((this.top_blackLH == null) || (this.top_blackLH.getVisibility() != 0)) {
        break label1006;
      }
    }
    label958:
    label963:
    label1006:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AEPituCameraUnit", 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = getActivity().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ajnj.decode(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.mRootView.findViewById(2131363581);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        biN();
        axiy.i("AEPituCameraUnit", "[UnitAsyncInit] before await");
        try
        {
          this.g.await(1000L, TimeUnit.MILLISECONDS);
          axiy.i("AEPituCameraUnit", "[UnitAsyncInit] after await");
          return this.mRootView;
          localObject = this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(2131558578, null, false);
          break;
          bool = false;
          break label216;
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            axiy.e("AEPituCameraUnit", "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    XH(true);
    GLGestureProxy.getInstance().removeAllListener();
    axif.a().aoc();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver.cP(this.jdField_a_of_type_Aycb.getActivity());
    this.jdField_a_of_type_Axgi.onDestroy();
    if (awyu.aOl()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = null;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onDestroy();
    ayzk.cYq = null;
    axaq.a().releaseInstance();
    CosFunHelper.setCountDownListener(null);
    if (this.jdField_a_of_type_Awwk != null) {
      this.jdField_a_of_type_Awwk.onDestroy();
    }
    this.jdField_a_of_type_Awwp.eHe();
    arlc.b(BaseApplicationImpl.getContext(), true, 5);
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
    azbh.nq.clear();
    this.jdField_a_of_type_Axiu.eLC();
    axip.a().eLB();
    axip.a().Yl(false);
    axik.unRegisterModule();
    if ((getActivity() != null) && (axcg.ax(getActivity().getIntent()))) {
      this.jdField_a_of_type_Awwa.ads(alwt.Ip());
    }
    if (isOnTop())
    {
      av.pop();
      axiy.i("AEPituCameraUnit", "onDestroy, is on top, ID=" + this.eCV);
    }
    for (;;)
    {
      axiy.i("AEPituCameraUnit", "onDestroy, ID=" + this.eCV + ", sUnitStack=" + av);
      return;
      axiy.i("AEPituCameraUnit", "onDestroy, is NOT on top, ID=" + this.eCV);
    }
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.bzA = false;
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    axiy.i("AEPituCameraUnit", "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    axip.a().ob(2L);
    axim.a().oa(paramLocalMediaInfo.mDuration);
    this.jdField_a_of_type_Axgi.p(196609, new Object[0]);
    this.jdField_a_of_type_Axgi.p(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.byT), this.jdField_b_of_type_Aybv, this.jdField_a_of_type_Axgi.a(196610, new Object[0]) });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
    paramBundle.putInt("KEY_IDENTITY_CODE_SAVE", this.eCV);
    axiy.i("AEPituCameraUnit", "onSaveInstanceState---destroyed in background, ID=" + this.eCV);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.Ny, this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    }
    return true;
  }
  
  class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if ((awtq.b(awtq.this) != AECaptureMode.GIF) && (System.currentTimeMillis() - awtq.a(awtq.this) > 5000L))
      {
        awtq.a(awtq.this).p(196614, new Object[0]);
        awtq.a(awtq.this, System.currentTimeMillis());
        awtq.this.adk(0);
      }
    }
  }
  
  public static class b
    extends axzy
  {
    public final axzu<awzw> a = new axzu();
    public final axzu<awwp> b = new axzu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awtq
 * JD-Core Version:    0.7.0.1
 */