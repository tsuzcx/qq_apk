import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aekit.api.standard.ai.AEDetector;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.12;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.14;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.15;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.16;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.18;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.20;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.21;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.22;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.23;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.6;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.7;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.9;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.b;
import dov.com.tencent.mobileqq.richmedia.capture.view.AEPituCameraCaptureButtonLayout;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;

public class awxg
  extends axgh
  implements CameraCaptureView.a, VideoFilterViewPager.b
{
  private ImageView AG;
  private AnimationSet G;
  private View Mc;
  private View Md;
  private awxc a = new awxd();
  private TextView agR;
  private TextView agS;
  private awwp b;
  private awtq jdField_c_of_type_Awtq = (awtq)this.jdField_c_of_type_Axgi.a(65537, new Object[0]);
  private QIMFilterCategoryItem jdField_c_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  private AEPituCameraCaptureButtonLayout jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout;
  private final String cTr = "ai_guide_shown";
  private AECameraGLSurfaceView d;
  private boolean dsD;
  private boolean dtt;
  private boolean dtu;
  private boolean dtv;
  private AEMaterialPanel e;
  private final int eDE = 400;
  private final int eDF = 1500;
  private final int eDG = 2000;
  private int eDH;
  private int eDI;
  private int eDJ;
  private int eDK;
  private AtomicBoolean eJ = new AtomicBoolean(false);
  private volatile AtomicBoolean eK = new AtomicBoolean();
  private Handler eh;
  private QQAnimationDrawable h;
  private QQAnimationDrawable i;
  private Runnable iL;
  private Runnable iM;
  private Runnable iN;
  private QQAnimationDrawable j;
  private AtomicReference<CameraCaptureView.a> k = new AtomicReference();
  private long mCurrentTime;
  
  public awxg(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
  }
  
  private void UJ()
  {
    if (axis.a().c("ai_guide_shown", false, 0)) {}
    while (this.d.Is() == 1) {
      return;
    }
    String str2 = awtn.a.a.cSK;
    String str1 = null;
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject2 = new File(str2);
      localObject1 = str1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int m = 0;
            while (m < localObject2.length)
            {
              str1 = str2 + File.separator + "tap_" + m + ".png";
              if (new File(str1).exists()) {
                localObject1[m] = str1;
              }
              m += 1;
            }
          }
        }
      }
    }
    this.j.setDuration(2000L);
    this.j.setOneShot(false);
    this.AG.setVisibility(0);
    this.AG.setImageDrawable(this.j);
    this.Md.setVisibility(0);
    if (localObject1 != null) {
      this.j.Q((String[])localObject1);
    }
    this.j.start();
    this.AG.postDelayed(new VideoStoryAIScenePart.6(this), 10000L);
  }
  
  private void XU(boolean paramBoolean)
  {
    if (this.d != null)
    {
      if (this.d.Is() != 1) {
        break label83;
      }
      eHr();
      a(null);
      if (this.iN != null) {
        this.d.removeCallbacks(this.iN);
      }
      eHp();
    }
    for (;;)
    {
      this.d.postDelayed(new VideoStoryAIScenePart.23(this), 1000L);
      sqn.a("mystatus_shoot", "cam_reverse", 0, 0, new String[0]);
      return;
      label83:
      if (!paramBoolean)
      {
        if (this.iN == null) {
          this.iN = new VideoStoryAIScenePart.22(this);
        }
        this.d.postDelayed(this.iN, 1000L);
      }
    }
  }
  
  private void a(AtomicReference<CameraCaptureView.a> paramAtomicReference, AEFilterManager paramAEFilterManager)
  {
    if (paramAtomicReference.get() == null) {
      akxe.M("Q.videostory", "Q.videostory.capture", "requestAIScene()", "sceneCallback is null");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((paramAEFilterManager != null) && (paramAEFilterManager.getAIAttr() != null)) {
                break;
              }
            } while (paramAtomicReference.get() == null);
            ((CameraCaptureView.a)paramAtomicReference.get()).Ps("mQQFilterRenderManager is null");
            return;
            akxe.M("Q.videostory", "Q.videostory.capture", "requestAIScene()", "start");
            localObject2 = (PTFaceAttr)paramAEFilterManager.getAIAttr().getFaceAttr();
          } while ((paramAEFilterManager.getAEDetector() == null) || (paramAEFilterManager.getAEDetector().getFaceDetector() == null));
          localObject1 = paramAEFilterManager.getAEDetector().getFaceDetector().getFaceDetector();
          paramAEFilterManager = ((PTFaceAttr)localObject2).getData();
        } while ((paramAEFilterManager == null) || (paramAEFilterManager.length == 0));
        Object localObject1 = ((VideoPreviewFaceOutlineDetector)localObject1).getLastDoTrackSize();
        int m = ((Point)localObject1).x;
        int n = ((Point)localObject1).y;
        localObject1 = new ArrayList();
        Object localObject2 = ((PTFaceAttr)localObject2).getAllFacePoints();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (List)((Iterator)localObject2).next();
            float f1 = ((PointF)((List)localObject3).get(18)).x;
            float f2 = ((PointF)((List)localObject3).get(0)).x;
            float f3 = ((PointF)((List)localObject3).get(9)).y;
            float f4 = ((PointF)((List)localObject3).get(87)).y;
            localObject3 = new awxc.a();
            ((awxc.a)localObject3).eDB = ((int)(f3 - f4));
            ((awxc.a)localObject3).eDA = ((int)(f1 - f2));
            ((ArrayList)localObject1).add(localObject3);
          }
        }
        if ((m == 0) || (n == 0)) {
          break;
        }
        localObject2 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
        paramAEFilterManager = ByteBuffer.wrap(paramAEFilterManager);
        try
        {
          ((Bitmap)localObject2).copyPixelsFromBuffer(paramAEFilterManager);
          this.eK.set(false);
          this.eh.sendEmptyMessage(2);
          this.a.a((Bitmap)localObject2, (ArrayList)localObject1, new awxk(this, paramAtomicReference));
          return;
        }
        catch (Exception paramAEFilterManager) {}
      } while ((CameraCaptureView.a)paramAtomicReference.get() == null);
      ((CameraCaptureView.a)paramAtomicReference.get()).Ps(paramAEFilterManager.toString());
      return;
    } while ((CameraCaptureView.a)paramAtomicReference.get() == null);
    ((CameraCaptureView.a)paramAtomicReference.get()).Ps("no bitmap");
  }
  
  private void b(AEMaterialPanel paramAEMaterialPanel)
  {
    Activity localActivity = (Activity)paramAEMaterialPanel.getContext();
    if ((this.Mc != null) && (this.agS != null) && (this.agR != null) && ((this.Mc.getVisibility() == 0) || (this.agR.getVisibility() == 0) || (this.Mc.getVisibility() == 0) || (this.agS.getVisibility() == 0)))
    {
      int m = rpq.getScreenHeight(localActivity);
      this.Mc.post(new VideoStoryAIScenePart.19(this, paramAEMaterialPanel, m));
    }
  }
  
  private void b(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    int m = 0;
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    RelativeLayout.LayoutParams localLayoutParams;
    float f2;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.AG.getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(13, 0);
      localLayoutParams.addRule(6, 2131364201);
      localLayoutParams.topMargin = ((int)(f1 - this.AG.getMeasuredWidth()) >> 1);
      this.AG.setLayoutParams(localLayoutParams);
      if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        break label215;
      }
      f2 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels / f1;
      if (f2 >= 1.78D) {
        break label190;
      }
      m = -20;
    }
    for (;;)
    {
      if (m == 0)
      {
        return;
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL) {
          break;
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.AG.getLayoutParams();
        localLayoutParams.addRule(14);
        localLayoutParams.addRule(13, -1);
        localLayoutParams.addRule(6, 0);
        localLayoutParams.topMargin = 0;
        this.AG.setLayoutParams(localLayoutParams);
        break;
        label190:
        if (f2 < 1.78D) {
          break label349;
        }
        m = -ayom.px2dip(this.mActivity, f1 / 2.0F);
        continue;
        label215:
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL) {
          continue;
        }
        if (!this.jdField_c_of_type_Awtq.aNE()) {
          break label342;
        }
        m = -9;
        continue;
      }
      paramRatio = (ViewGroup.MarginLayoutParams)this.Mc.getLayoutParams();
      paramRatio.bottomMargin = (this.eDI - ankt.dip2px(m));
      this.Mc.setLayoutParams(paramRatio);
      paramRatio = (ViewGroup.MarginLayoutParams)this.agR.getLayoutParams();
      paramRatio.bottomMargin = (this.eDJ - ankt.dip2px(m));
      this.agR.setLayoutParams(paramRatio);
      paramRatio = (ViewGroup.MarginLayoutParams)this.agS.getLayoutParams();
      paramRatio.bottomMargin = (this.eDK - ankt.dip2px(m));
      this.agS.setLayoutParams(paramRatio);
      return;
      label342:
      m = 46;
      continue;
      label349:
      m = 0;
    }
  }
  
  private void biN()
  {
    ((awtq.b)awuh.a(this.jdField_c_of_type_Awtq).b(awtq.b.class)).b.a(this.jdField_c_of_type_Awtq, new awxm(this));
    ((axgf)awuh.a(this.jdField_c_of_type_Awtq).b(axgf.class)).t.a(this.jdField_c_of_type_Awtq, new awxn(this));
    if (this.dsD) {
      ((AEVideoStoryTopBarViewModel)awuh.a(this.jdField_c_of_type_Awtq).b(AEVideoStoryTopBarViewModel.class)).d.a(this.jdField_c_of_type_Awtq, new awxo(this));
    }
  }
  
  private void eG(int paramInt, String paramString)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1000L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(1000L);
    String str1 = "";
    String str2 = awtn.a.a.cSM;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.agS.setText(acfp.m(2131716468) + paramString + acfp.m(2131716467));
      this.agR.setText(paramString);
      this.agR.setVisibility(0);
      this.agR.setAnimation(j());
      if (TextUtils.isEmpty(str2)) {
        break label434;
      }
      str2 = str2 + File.separator + str1;
      paramString = new File(str2);
      if (!paramString.exists()) {
        break label434;
      }
      File[] arrayOfFile = paramString.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
        break label434;
      }
      paramString = new String[arrayOfFile.length];
      paramInt = 0;
      while (paramInt < arrayOfFile.length)
      {
        String str3 = str2 + File.separator + str1 + "_" + (paramInt + 1) + ".png";
        if (new File(str3).exists()) {
          paramString[paramInt] = str3;
        }
        paramInt += 1;
      }
      str1 = "object";
      continue;
      str1 = "food";
      continue;
      str1 = "scene";
      continue;
      str1 = "face";
    }
    for (;;)
    {
      this.h.setDuration(2500L);
      this.h.setOneShot(true);
      this.Mc.setVisibility(0);
      this.Mc.setBackgroundDrawable(this.h);
      if (paramString != null) {
        this.h.Q(paramString);
      }
      this.h.start();
      this.Mc.postDelayed(new VideoStoryAIScenePart.9(this), 2500L);
      localAlphaAnimation1.setAnimationListener(new awxi(this, localAlphaAnimation2));
      localAlphaAnimation2.setAnimationListener(new awxj(this));
      return;
      label434:
      paramString = null;
    }
  }
  
  private void eHo()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams2;
    ViewGroup.MarginLayoutParams localMarginLayoutParams3;
    if (this.mActivity != null)
    {
      localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.Mc.getLayoutParams();
      this.eDI = localMarginLayoutParams1.bottomMargin;
      localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.agR.getLayoutParams();
      this.eDJ = localMarginLayoutParams2.bottomMargin;
      localMarginLayoutParams3 = (ViewGroup.MarginLayoutParams)this.agS.getLayoutParams();
      this.eDK = localMarginLayoutParams3.bottomMargin;
      if (!this.dsD) {
        break label76;
      }
    }
    label76:
    int n;
    do
    {
      return;
      int m = 0;
      if (axcg.av(this.mActivity.getIntent())) {
        m = 76;
      }
      n = m;
      if (this.jdField_c_of_type_Awtq.aNE()) {
        n = m - 55;
      }
    } while (n == 0);
    localMarginLayoutParams1.bottomMargin = (this.eDI - ankt.dip2px(n));
    this.Mc.setLayoutParams(localMarginLayoutParams1);
    localMarginLayoutParams2.bottomMargin = (this.eDJ - ankt.dip2px(n));
    this.agR.setLayoutParams(localMarginLayoutParams2);
    localMarginLayoutParams3.bottomMargin = (this.eDK - ankt.dip2px(n));
    this.agS.setLayoutParams(localMarginLayoutParams3);
  }
  
  private void eHp()
  {
    if ((this.AG != null) && (this.AG.getVisibility() == 0)) {
      this.AG.post(new VideoStoryAIScenePart.7(this));
    }
  }
  
  private void eHt()
  {
    if ((this.jdField_c_of_type_Awtq.getActivity() != null) && (this.dsD))
    {
      MqqHandler localMqqHandler = ThreadManager.getUIHandler();
      VideoStoryAIScenePart.20 local20 = new VideoStoryAIScenePart.20(this);
      this.iM = local20;
      localMqqHandler.postDelayed(local20, 250L);
    }
    if ((this.Mc != null) && (this.agS != null) && (this.agR != null)) {
      this.Mc.post(new VideoStoryAIScenePart.21(this));
    }
  }
  
  private AnimationSet j()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.agR.getMeasuredHeight(), 0.0F);
    if (this.G != null)
    {
      this.G = new AnimationSet(true);
      this.G.setInterpolator(new DecelerateInterpolator());
      this.G.setDuration(400L);
      this.G.addAnimation(localAlphaAnimation);
      this.G.addAnimation(localTranslateAnimation);
    }
    return this.G;
  }
  
  private void showToast(String paramString)
  {
    if ((paramString != null) && (paramString.equals("network error"))) {
      this.mRootView.post(new VideoStoryAIScenePart.16(this));
    }
  }
  
  public void Ps(String paramString)
  {
    if ((this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) && (this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.aRt()))
    {
      a(null);
      return;
    }
    showToast(paramString);
    this.mRootView.post(new VideoStoryAIScenePart.15(this));
    akxe.M("Q.videostory", "Q.videostory.capture", "onAISceneFail", paramString);
  }
  
  public void XT(boolean paramBoolean)
  {
    this.dtv = paramBoolean;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return super.a(paramInt, paramVarArgs);
    }
    return this.jdField_c_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  }
  
  public void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if ((this.k.get() != null) && (this.eJ.compareAndSet(true, false)) && (paramInt == 2))
    {
      if (this.iL == null) {
        this.iL = new VideoStoryAIScenePart.12(this, paramAEFilterManager);
      }
      ThreadManager.removeJobFromThreadPool(this.iL, 128);
      ThreadManager.excute(this.iL, 128, null, true);
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append("");
    String str;
    if (paramQIMFilterCategoryItem != null)
    {
      str = paramQIMFilterCategoryItem.name;
      akxe.M("Q.videostory", "Q.videostory.capture", "onFilterSelect", str);
      if (paramInt != 0) {
        a(null);
      }
      if (!this.dtu) {
        break label102;
      }
      this.dtu = false;
    }
    for (;;)
    {
      this.eDH = paramInt;
      this.jdField_c_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramQIMFilterCategoryItem;
      sqn.a("mystatus_shoot", "filter_change", 0, 0, new String[0]);
      return;
      str = "no filter";
      break;
      label102:
      eHr();
    }
  }
  
  public void a(awxf paramawxf)
  {
    if ((this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout != null) && (this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout.aRt()))
    {
      a(null);
      eHr();
      return;
    }
    if ((paramawxf.eDC == -1) || ((this.jdField_c_of_type_Awtq != null) && (!this.jdField_c_of_type_Awtq.aNF())))
    {
      eHr();
      return;
    }
    Object localObject2 = paramawxf.cTq;
    Object localObject1 = ayva.a().d(0);
    Bundle localBundle;
    axpr localaxpr;
    if (localObject1 != null)
    {
      localObject1 = ((QIMFilterCategoryItem)localObject1).name;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label420;
      }
      akxe.M("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", (String)localObject2 + " " + (String)localObject1);
      localBundle = new Bundle();
      localBundle.putInt("apply_source", axpr.eGC);
      localBundle.putInt("capture_scene", 0);
      localBundle.putBoolean("capture_force_enable", this.dtv);
      localaxpr = (axpr)axov.a(5);
      if (localaxpr.a() != null) {
        break label244;
      }
      paramawxf = new ArrayList();
      eHr();
    }
    for (;;)
    {
      akxe.M("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", "filterLister is empty:" + paramawxf.size());
      return;
      localObject1 = "";
      break;
      label244:
      localObject1 = localaxpr.a().filterList;
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject3).next();
        if (localQIMFilterCategoryItem.name.equals(localObject2))
        {
          localQIMFilterCategoryItem.cVL = ((String)localObject2);
          localObject2 = new Message();
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("sceneName", paramawxf.sceneName);
          ((Bundle)localObject3).putInt("sceneLvOne", paramawxf.eDC);
          ((Message)localObject2).setData((Bundle)localObject3);
          ((Message)localObject2).what = 1;
          long l = this.mCurrentTime % 1500L;
          if (l > 1100L) {}
          for (;;)
          {
            this.eh.sendMessageDelayed((Message)localObject2, 0L);
            this.mRootView.postDelayed(new VideoStoryAIScenePart.14(this, localQIMFilterCategoryItem, localBundle, localaxpr), 500L);
            paramawxf = (awxf)localObject1;
            break;
          }
          label420:
          eHr();
          return;
        }
      }
      paramawxf = (awxf)localObject1;
    }
  }
  
  public void a(CameraCaptureView.a parama)
  {
    this.k.set(parama);
  }
  
  public void eHq()
  {
    this.agR.setText(acfp.m(2131716458));
    this.agR.setVisibility(0);
    j();
    if (this.G != null) {
      this.agR.setAnimation(this.G);
    }
    this.i = new QQAnimationDrawable();
    String str2 = awtn.a.a.cSL;
    String str1 = null;
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject2 = new File(str2);
      localObject1 = str1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int m = 0;
            while (m < localObject2.length)
            {
              str1 = str2 + File.separator + "image_000" + m + ".png";
              if (new File(str1).exists()) {
                localObject1[m] = str1;
              }
              m += 1;
            }
          }
        }
      }
    }
    this.i.setDuration(1500L);
    this.i.setOneShot(false);
    this.Mc.setVisibility(0);
    this.Mc.setBackgroundDrawable(this.i);
    if (localObject1 != null) {
      this.i.Q((String[])localObject1);
    }
    this.mCurrentTime = System.currentTimeMillis();
    this.i.start();
  }
  
  public void eHr()
  {
    z(0, null, false);
  }
  
  public void eHs()
  {
    this.eJ.set(true);
  }
  
  protected void initView()
  {
    this.dsD = axcg.ay(this.mActivity.getIntent());
    this.Mc = this.mRootView.findViewById(2131362359);
    this.agS = ((TextView)this.mRootView.findViewById(2131362363));
    this.agR = ((TextView)this.mRootView.findViewById(2131362362));
    this.AG = ((ImageView)this.mRootView.findViewById(2131362360));
    this.Md = this.mRootView.findViewById(2131362361);
    this.h = new QQAnimationDrawable();
    this.j = new QQAnimationDrawable();
    this.d = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364201));
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378862);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    this.jdField_c_of_type_DovComTencentMobileqqRichmediaCaptureViewAEPituCameraCaptureButtonLayout = ((AEPituCameraCaptureButtonLayout)this.mRootView.findViewById(2131364256));
    this.e = ((AEMaterialPanel)this.mRootView.findViewById(2131373750));
    a(this);
    this.d.setSceneListener(new awxh(this));
    this.eh = new awxl(this, Looper.getMainLooper());
    eHo();
    biN();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.i != null) {
      this.i.stop();
    }
    if (this.j != null) {
      this.j.stop();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (this.i != null) {
      this.i.start();
    }
    if (this.j != null) {
      this.j.start();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.iL != null)
    {
      ThreadManager.removeJobFromThreadPool(this.iL, 128);
      this.iL = null;
    }
    if (this.iM != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.iM);
    }
    this.mActivity = null;
  }
  
  public void p(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 196610: 
    default: 
    case 196609: 
    case 196611: 
    case 196612: 
      do
      {
        return;
        a(null);
        this.eK.set(true);
        this.eh.removeMessages(1);
        this.eh.post(new VideoStoryAIScenePart.18(this));
        return;
        XU(((Boolean)paramVarArgs[0]).booleanValue());
        return;
      } while (this.e == null);
      b(this.e);
      return;
    case 196613: 
      eHt();
      return;
    case 196614: 
      eHp();
      a(this);
      eHs();
      return;
    case 196615: 
      XT(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    }
    eHp();
  }
  
  public void z(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.agR != null) && (this.agR.getVisibility() == 0) && (!this.dtt) && (!this.eK.get()))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.agR.getMeasuredHeight());
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setDuration(400L);
      localAnimationSet.addAnimation(localAlphaAnimation);
      this.agR.startAnimation(localAnimationSet);
      localAnimationSet.setAnimationListener(new awxp(this, paramBoolean, paramInt, paramString));
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, AEFilterManager paramAEFilterManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxg
 * JD-Core Version:    0.7.0.1
 */