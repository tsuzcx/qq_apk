package com.tencent.mobileqq.richmedia.capture.view;

import aaqi;
import aath;
import acfp;
import aeah;
import akxe;
import alwb;
import alwy;
import alxf;
import alxu;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import anhq;
import anii;
import aqhq;
import atao;
import awtj;
import axiy;
import axov;
import axpa;
import aywy;
import ayzs;
import azaj;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.MovieMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import spp;

@TargetApi(17)
public class EffectsCameraCaptureView
  extends CameraCaptureView
  implements CameraInterFace
{
  private static QQFilterRenderManager b;
  protected azaj a;
  private a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$b;
  private c jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c;
  private d jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$d;
  private e jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$e;
  private f jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$f = new f();
  private long ahV;
  private String bZs;
  private String bZt;
  protected boolean cAR;
  private boolean cAS;
  private boolean cAT;
  private boolean cAU;
  private boolean cAV;
  private boolean cAW;
  public boolean cAX;
  private boolean cAY;
  private boolean cAZ;
  private boolean cAi = true;
  private boolean cAj = true;
  private boolean cAk = true;
  private boolean cBa;
  private boolean cBb;
  private boolean cBc;
  private volatile boolean cBd;
  private int dzC;
  private int dzD;
  private int dzE;
  private GroupVideoFilterList groupVideoFilterList;
  private QQDanceEventHandler mDanceEventHandler;
  protected QQFilterRenderManager mQQFilterRenderManager;
  private long py = ((Long)spp.a().getValue("SmartCutPicSpacing", Long.valueOf(500L))).longValue();
  private int shookHeadCount;
  private boolean soLoaded;
  private int triggerType;
  
  static
  {
    atao.init();
    awtj.init();
    VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.z());
    BadcaseReportUtils.registerReport(new alxf());
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Azaj = new azaj();
  }
  
  public EffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Azaj = new azaj();
  }
  
  private MovieMaterial a()
  {
    ayzs localayzs = (ayzs)axov.a(3);
    if (localayzs != null) {
      return localayzs.b();
    }
    return null;
  }
  
  private void a(MovieMaterial paramMovieMaterial)
  {
    ayzs localayzs = (ayzs)axov.a(3);
    if (localayzs != null) {
      localayzs.b(paramMovieMaterial);
    }
  }
  
  private void a(VideoMaterial paramVideoMaterial)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.a(paramVideoMaterial);
    }
  }
  
  public static boolean a(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc != null)
    {
      int i = QQAVImageFilterConstants.getFilterType(paramFilterDesc.id);
      if ((i == 2) || (i == 1)) {}
      while ("MANHUA".equals(paramFilterDesc.name)) {
        return true;
      }
    }
    return false;
  }
  
  public static QQFilterRenderManager b()
  {
    if ((b == null) && (QLog.isColorLevel())) {
      QLog.d("EffectsCameraCaptureView", 2, "getCurrentRenderManager null");
    }
    return b;
  }
  
  private boolean b(alxu paramalxu)
  {
    this.cBd = false;
    if ((paramalxu != null) && (paramalxu.kind == 20))
    {
      com.tencent.mobileqq.shortvideo.bighead.BigHeadFilter.sGBigHeadModelPath = paramalxu.bZq + paramalxu.bZr + File.separator;
      this.cBd = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.bk(this.cBd)) && (this.mQQFilterRenderManager != null)) {
      this.mQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
    }
    return this.cBd;
  }
  
  private boolean b(VideoMaterial paramVideoMaterial)
  {
    boolean bool = true;
    if (paramVideoMaterial != null) {
      bool = paramVideoMaterial.needFaceInfo();
    }
    return bool;
  }
  
  private String cW(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return acfp.m(2131705757);
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return acfp.m(2131705759);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return acfp.m(2131705753);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return acfp.m(2131705758);
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return acfp.m(2131705756);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return acfp.m(2131705762);
    }
    return null;
  }
  
  public static short[] toShortArray(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    return arrayOfShort;
  }
  
  public void OA(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.OC(paramBoolean);
  }
  
  protected void Op(boolean paramBoolean)
  {
    super.Op(paramBoolean);
    if ((this.cAR) && (this.mQQFilterRenderManager != null)) {
      this.mQQFilterRenderManager.surfaceChange(this.dzc, this.dzd, getWidth(), getHeight());
    }
  }
  
  public void Oz(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.OD(paramBoolean);
  }
  
  public boolean WW()
  {
    return !TextUtils.isEmpty(this.bZs);
  }
  
  public QQFilterRenderManager a()
  {
    return this.mQQFilterRenderManager;
  }
  
  public void a(boolean paramBoolean, alxu paramalxu)
  {
    if (this.mDanceEventHandler != null) {
      this.mDanceEventHandler.enterSilhouette();
    }
    super.queueEvent(new EffectsCameraCaptureView.10(this, paramBoolean, paramalxu));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    boolean bool2 = false;
    this.cAS = paramBoolean1;
    this.cAT = paramBoolean2;
    this.cAV = paramBoolean3;
    this.cAW = paramBoolean4;
    this.dzC = 0;
    this.dzD = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c != null)
    {
      c localc = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c;
      boolean bool1 = bool2;
      if (!anhq.a().axb())
      {
        bool1 = bool2;
        if (paramBoolean1) {
          bool1 = true;
        }
      }
      localc.e(bool1, paramBoolean2, paramBoolean3, paramBoolean4);
    }
  }
  
  public boolean a(alxu paramalxu)
  {
    alxu localalxu = paramalxu;
    if (paramalxu == null) {
      localalxu = alxu.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c);
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c instanceof QIMEffectCameraCaptureUnit;
    if ((this.mQQFilterRenderManager != null) && (localalxu != null) && (localalxu.usable) && (anhq.b(3, localalxu.kind, bool2)))
    {
      if (this.mDanceEventHandler == null) {
        break label226;
      }
      paramalxu = localalxu.bZq + localalxu.name + File.separator;
    }
    label165:
    label226:
    for (boolean bool1 = this.mDanceEventHandler.changeDanceStatus(true, paramalxu);; bool1 = false)
    {
      if (bool1)
      {
        if (!anhq.b(1, localalxu.kind, bool2)) {
          break label165;
        }
        BadcaseReportUtils.sDanceFilterID = localalxu.id;
        BadcaseReportUtils.sDanceFilterName = localalxu.name;
        alxf.On(this.cBc);
        a(false, localalxu);
        anhq.a().PK(true);
      }
      while (!anhq.b(2, localalxu.kind, bool2)) {
        return true;
      }
      a(true, localalxu);
      anhq.a().PK(true);
      return true;
      if (this.mDanceEventHandler != null) {
        this.mDanceEventHandler.changeDanceStatus(false, null);
      }
      dLm();
      anhq.a().PK(false);
      return false;
    }
  }
  
  protected boolean auO()
  {
    boolean bool2 = true;
    if (this.cBb) {
      return false;
    }
    int i;
    if (this.mQQFilterRenderManager != null)
    {
      bool1 = this.mQQFilterRenderManager.hasActiveFilter();
      if ((this.dyL != 1) || (!anii.notSupportCameraFrontSysPhoto())) {
        break label65;
      }
      i = 1;
      label42:
      if ((!aeah.afY()) || (bool1) || (i != 0)) {
        break label70;
      }
    }
    label65:
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
      i = 0;
      break label42;
    }
  }
  
  protected boolean auS()
  {
    return (this.cAR) && (this.mQQFilterRenderManager != null) && ((this.mQQFilterRenderManager.isFilterWork(90)) || (this.mQQFilterRenderManager.getBusinessOperation().isSegmentRequired()) || (this.mQQFilterRenderManager.getBusinessOperation().isVoiceToTextMaterial()));
  }
  
  protected boolean auT()
  {
    if (aywy.a().aRl()) {}
    do
    {
      do
      {
        return true;
      } while ((this.cAR) && (this.mQQFilterRenderManager != null) && (this.mQQFilterRenderManager.getBusinessOperation().isVoiceToTextMaterial()));
      if (this.cBb) {
        return false;
      }
      if ((!this.cAR) || (this.mQQFilterRenderManager == null)) {
        break;
      }
    } while (aywy.a().b(this.mQQFilterRenderManager.getAllActiveFilters()) >= aywy.a().co());
    return false;
    return false;
  }
  
  public boolean auV()
  {
    return a() != null;
  }
  
  public boolean auW()
  {
    return this.cAZ;
  }
  
  public boolean auX()
  {
    return (this.mQQFilterRenderManager != null) && (this.mQQFilterRenderManager.hasActiveFilter());
  }
  
  public boolean auY()
  {
    return this.cBd;
  }
  
  public void dKM()
  {
    if (auV())
    {
      dLf();
      aaqi.ao("", "0X80083BA", axpa.cVC);
    }
    resetShookHeadCount();
    if (this.mQQFilterRenderManager != null)
    {
      this.mQQFilterRenderManager.getBusinessOperation().startRecord();
      a(this.cAS, this.cAT, this.cAV, this.cAW, this.dzD);
    }
    super.dKM();
  }
  
  protected void dKX()
  {
    super.dKX();
    ThreadManager.excute(new EffectsCameraCaptureView.1(this), 64, null, false);
  }
  
  protected void dKZ()
  {
    if (this.mQQFilterRenderManager != null)
    {
      this.shookHeadCount = this.mQQFilterRenderManager.getBusinessOperation().getShookHeadCount();
      if (QLog.isColorLevel()) {
        QLog.i("EffectsCameraCaptureView", 2, "onMediaCodecStopRecord shookHeadCount:" + this.shookHeadCount);
      }
    }
  }
  
  public void dKe()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      aath.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture);
    }
  }
  
  public void dKf()
  {
    aath.a().a(null);
  }
  
  public void dLe()
  {
    if ((this.mQQFilterRenderManager != null) && (auV()))
    {
      if (this.mQQFilterRenderManager.getBusinessOperation().isRunningMovieFilter()) {
        this.mQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.hg(null, null);
      }
    }
  }
  
  public void dLf()
  {
    MovieMaterial localMovieMaterial = a();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "playMovieFilter, movieMaterial = " + localMovieMaterial);
    }
    if ((localMovieMaterial == null) || (!this.cAu)) {
      dLe();
    }
    while (this.mQQFilterRenderManager == null) {
      return;
    }
    if (localMovieMaterial.isTouchable) {
      if (!TextUtils.isEmpty(localMovieMaterial.atmosphereName)) {
        if (!aqhq.fileExistsAndNotEmpty(localMovieMaterial.atmosphereVideoPath)) {
          break label368;
        }
      }
    }
    label368:
    for (Object localObject = new File(localMovieMaterial.atmosphereVideoPath);; localObject = null)
    {
      if (aqhq.fileExistsAndNotEmpty(localMovieMaterial.atmosphereAudioPath)) {}
      for (File localFile = new File(localMovieMaterial.atmosphereAudioPath);; localFile = null)
      {
        FilterBusinessOperation localFilterBusinessOperation;
        String str;
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.hg(null, null);
          localFilterBusinessOperation = this.mQQFilterRenderManager.getBusinessOperation();
          str = ((File)localObject).getAbsolutePath();
          if (localFile == null)
          {
            localObject = "";
            localFilterBusinessOperation.playMovie(str, (String)localObject, localMovieMaterial.loopAtmosphere, null, 0.0F, 0.0F, 0.0F, 0.0F);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.hg(localMovieMaterial.hintsContent, localMovieMaterial.hintImagePath);
          return;
          localObject = localFile.getAbsolutePath();
          break;
          this.mQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
          continue;
          this.mQQFilterRenderManager.getBusinessOperation().playMovie(null, null, false, null, 0.0F, 0.0F, 0.0F, 0.0F);
        }
        if (aqhq.fileExists(localMovieMaterial.doodleVideoPath)) {}
        for (localObject = new File(localMovieMaterial.doodleVideoPath);; localObject = null)
        {
          if (aqhq.fileExists(localMovieMaterial.doodleAudioPath)) {}
          for (localFile = new File(localMovieMaterial.doodleAudioPath); localObject != null; localFile = null)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.hg(null, null);
            localFilterBusinessOperation = this.mQQFilterRenderManager.getBusinessOperation();
            str = ((File)localObject).getAbsolutePath();
            if (localFile == null) {}
            for (localObject = "";; localObject = localFile.getAbsolutePath())
            {
              localFilterBusinessOperation.playMovie(str, (String)localObject, localMovieMaterial.loopDoodle, null, 0.0F, 0.0F, 0.0F, 0.0F);
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  public void dLg()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c != null) && (auV())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.hg(null, null);
    }
  }
  
  public void dLh()
  {
    if (!this.cAR)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EffectsCameraCaptureView", 2, "QQFilterRenderManager initQQFilterManger");
      }
      this.soLoaded = alwy.bi(true);
      axiy.e("EffectsCameraCaptureView", "initQQFilterManger: soLoaded = " + this.soLoaded);
      Object localObject = new QQFilterRenderManager();
      this.mQQFilterRenderManager = ((QQFilterRenderManager)localObject);
      b = (QQFilterRenderManager)localObject;
      localObject = this.mQQFilterRenderManager.getChainBuilder();
      ((QQFilterRenderManager.ChainBuilder)localObject).setUseSort(false);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(10, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(25, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(186, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(40, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(70, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(80, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(90, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(100, null);
      ((QQFilterRenderManager.ChainBuilder)localObject).addFilter(184, null);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$e != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$e.a((QQFilterRenderManager.ChainBuilder)localObject);
      }
      if (this.soLoaded) {
        ((QQFilterRenderManager.ChainBuilder)localObject).commit();
      }
      this.mQQFilterRenderManager.cameraInterFace = this;
      LogUtils.setEnable(false);
      if (this.soLoaded) {
        AEModule.updateDeviceAttr(true);
      }
      VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    }
    queueEvent(new EffectsCameraCaptureView.2(this));
  }
  
  public void dLi()
  {
    this.cAU = true;
  }
  
  public void dLj()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.auZ();
  }
  
  public void dLk()
  {
    if ((this.cAR) && (this.mQQFilterRenderManager != null) && (this.bZs != null)) {
      setFaceEffect(this.bZs);
    }
  }
  
  public void dLl()
  {
    super.queueEvent(new EffectsCameraCaptureView.8(this));
  }
  
  public void dLm()
  {
    super.queueEvent(new EffectsCameraCaptureView.9(this));
  }
  
  public int getBeautyLevel()
  {
    int j = 0;
    int i = j;
    if (this.cAR)
    {
      i = j;
      if (this.cAi)
      {
        i = j;
        if (this.mQQFilterRenderManager != null) {
          i = this.mQQFilterRenderManager.getBusinessOperation().getPtuBeautyLevel();
        }
      }
    }
    return i;
  }
  
  public int getCameraID()
  {
    return Is();
  }
  
  public int getShookHeadCount()
  {
    return this.shookHeadCount;
  }
  
  protected int iU(int paramInt)
  {
    int i = paramInt;
    QQFilterRenderManager localQQFilterRenderManager;
    boolean bool;
    if (this.cAR)
    {
      i = paramInt;
      if (this.mQQFilterRenderManager != null)
      {
        localQQFilterRenderManager = this.mQQFilterRenderManager;
        GLES20.glViewport(0, 0, this.dzc, this.dzd);
        localQQFilterRenderManager.setParam("key_orientation_degree", String.valueOf(this.dzn));
        if (Is() != 1) {
          break label375;
        }
        bool = true;
        localQQFilterRenderManager.setParam("key_front_camera", String.valueOf(bool));
        localQQFilterRenderManager.setParam("key_draw_screen", String.valueOf(true));
        localQQFilterRenderManager.setParam("key_enable_beauty", String.valueOf(this.cAi));
        localQQFilterRenderManager.setParam("key_enable_filter", String.valueOf(this.cAj));
        localQQFilterRenderManager.setParam("key_enable_ptv", String.valueOf(this.cAk));
        localQQFilterRenderManager.setParam("key_width", String.valueOf(this.dzc));
        localQQFilterRenderManager.setParam("key_height", String.valueOf(this.dzd));
        localQQFilterRenderManager.setBackCameraDetectEnable(aywy.a().aRn());
        localQQFilterRenderManager.setCaptureMode(this.cAv);
        paramInt = localQQFilterRenderManager.drawFrame(paramInt);
        if (this.dzD != this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$f.type)
        {
          this.cAT = false;
          this.cAS = false;
          this.cAV = false;
          this.cAW = false;
          this.dzC = 0;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$f.type != 0) {
          break label449;
        }
        if ((!localQQFilterRenderManager.mNeedDoFaceDetect) || (localQQFilterRenderManager.mDetectedFace) || (!this.cAT)) {
          break label393;
        }
        if (this.dzC < 4) {
          break label380;
        }
        a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, false, false, 0);
      }
    }
    for (;;)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$b != null)
      {
        long l = System.currentTimeMillis();
        i = paramInt;
        if (l - this.ahV >= this.py)
        {
          akxe.M("Q.videostory", "Q.videostory.capture", "capturebitmap", "start");
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$b.w(GlUtil.captureFrame(paramInt, this.dzc, this.dzd, 0));
          this.ahV = l;
          i = paramInt;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c.kR(System.currentTimeMillis());
      return i;
      label375:
      bool = false;
      break;
      label380:
      this.dzC += 1;
      continue;
      label393:
      if ((this.cAS != localQQFilterRenderManager.mNeedDoFaceDetect) || (this.cAT != localQQFilterRenderManager.mDetectedFace) || (this.cAU))
      {
        this.cAU = false;
        a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, false, false, 0);
        continue;
        label449:
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$f.type == 1)
        {
          if ((localQQFilterRenderManager.mNeedDoGestureDetect) && (!localQQFilterRenderManager.mDetectedGesture) && (this.cAW))
          {
            a(false, false, localQQFilterRenderManager.mNeedDoGestureDetect, localQQFilterRenderManager.mDetectedGesture, 1);
          }
          else if ((this.cAV != localQQFilterRenderManager.mNeedDoGestureDetect) || (this.cAW != localQQFilterRenderManager.mDetectedGesture) || (this.cAU))
          {
            this.cAU = false;
            a(false, false, localQQFilterRenderManager.mNeedDoGestureDetect, localQQFilterRenderManager.mDetectedGesture, 1);
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$f.type == 2) && (localQQFilterRenderManager.mNeedDoFaceDetect) && (localQQFilterRenderManager.mNeedDoGestureDetect) && ((localQQFilterRenderManager.mDetectedFace != this.cAT) || (localQQFilterRenderManager.mDetectedGesture != this.cAW) || (this.cAU)))
        {
          this.cAU = false;
          a(localQQFilterRenderManager.mNeedDoFaceDetect, localQQFilterRenderManager.mDetectedFace, localQQFilterRenderManager.mNeedDoGestureDetect, localQQFilterRenderManager.mDetectedGesture, 2);
          if (QLog.isColorLevel()) {
            QLog.d("EffectsCameraCaptureView", 2, "onDrawFrameAfterCamera mDetectedFace:" + localQQFilterRenderManager.mDetectedFace + "mFilterProcess.mDetectedGesture:" + localQQFilterRenderManager.mDetectedGesture);
          }
        }
      }
    }
  }
  
  public void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (aath.a().isEnable()) {
      aath.a().k(paramArrayOfByte, paramInt1, paramInt2);
    }
    short[] arrayOfShort = toShortArray(paramArrayOfByte);
    double d = 0.0D;
    int i = 0;
    while (i < arrayOfShort.length)
    {
      d += arrayOfShort[i] * arrayOfShort[i];
      i += 1;
    }
    d = Math.log10(d / arrayOfShort.length);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$a.w(d * 10.0D);
    }
    this.jdField_a_of_type_Alwb.o(paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Azaj.o(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.cAR) && (this.mQQFilterRenderManager != null))
    {
      VideoPrefsUtil.setMaterialMute(true);
      queueEvent(new EffectsCameraCaptureView.7(this));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoPrefsUtil.setMaterialMute(this.cAY);
    if ((this.cAR) && (this.mQQFilterRenderManager != null)) {
      queueEvent(new EffectsCameraCaptureView.6(this));
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    b = this.mQQFilterRenderManager;
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceChanged " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.cAR);
    }
    if (this.cAR)
    {
      if (this.mQQFilterRenderManager != null) {
        this.mQQFilterRenderManager.surfaceChange(this.dzc, this.dzd, getWidth(), getHeight());
      }
      if (this.bZs != null) {
        setFaceEffect(this.bZs);
      }
      if (this.dzE != 0) {
        setBeauty(this.dzE);
      }
      if (this.mQQFilterRenderManager != null)
      {
        paramGL10 = new CopyOnWriteArrayList();
        paramGL10.addAll(this.mQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdList());
        this.mQQFilterRenderManager.getBusinessOperation().setFilterEffectList(paramGL10);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceCreated " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.cAR);
    }
    if (this.cAR) {
      dLh();
    }
  }
  
  public void onSurfaceDestroy()
  {
    super.onSurfaceDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("EffectsCameraCaptureView", 2, "onSurfaceDestroy " + Thread.currentThread().getName() + " mFilterProcessInited=" + this.cAR);
    }
    if (b == this.mQQFilterRenderManager) {
      b = null;
    }
    if (this.cAR)
    {
      if (this.mQQFilterRenderManager != null) {
        this.mQQFilterRenderManager.surfaceDestroyed();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$e != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$e.dLn();
      }
      this.mQQFilterRenderManager = null;
      this.cAR = false;
    }
  }
  
  public void release()
  {
    super.release();
    this.jdField_a_of_type_Azaj.eUC();
  }
  
  public void resetShookHeadCount()
  {
    if (this.mQQFilterRenderManager != null)
    {
      this.mQQFilterRenderManager.getBusinessOperation().resetShookHeadCount();
      this.shookHeadCount = 0;
    }
  }
  
  public void setAudioVolumeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$a = parama;
  }
  
  public void setBeauty(int paramInt)
  {
    if ((this.cAR) && (this.cAi) && (this.mQQFilterRenderManager != null)) {
      this.mQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramInt);
    }
    this.dzE = paramInt;
  }
  
  public void setBeauty(int[] paramArrayOfInt)
  {
    if ((this.cAR) && (this.cAi)) {
      this.mQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(paramArrayOfInt[0]);
    }
    this.dzE = paramArrayOfInt[0];
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.cAi = paramBoolean;
  }
  
  public void setCaptureRequest(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$b = paramb;
  }
  
  public void setDanceFilterEventHandler(QQDanceEventHandler paramQQDanceEventHandler)
  {
    this.mDanceEventHandler = paramQQDanceEventHandler;
  }
  
  public void setEffectMute(boolean paramBoolean)
  {
    this.cAY = paramBoolean;
    if ((this.cAR) && (this.mQQFilterRenderManager != null)) {
      this.mQQFilterRenderManager.getBusinessOperation().setEffectMute(this.cAY);
    }
  }
  
  public void setEnableBadCaseReport(boolean paramBoolean)
  {
    this.cBc = paramBoolean;
  }
  
  public void setFaceEffect(String paramString)
  {
    this.bZs = paramString;
    if ((isRecording()) || (!FeatureManager.Features.FACE_DETECT.isFunctionReady())) {
      QLog.d("EffectsCameraCaptureView", 1, new Object[] { "setFaceEffect fail ", Boolean.valueOf(isRecording()) });
    }
    while ((!this.cAR) || (!this.cAk)) {
      return;
    }
    this.groupVideoFilterList = null;
    ThreadManager.getUIHandler().post(new EffectsCameraCaptureView.3(this, paramString));
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.cAk = paramBoolean;
  }
  
  public void setFaceEffectListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$c = paramc;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if ((this.cAR) && (this.cAj) && (this.mQQFilterRenderManager != null))
    {
      FilterCategoryItem localFilterCategoryItem = null;
      if (paramFilterCategoryItem != null)
      {
        paramFilterCategoryItem = paramFilterCategoryItem.a();
        localFilterCategoryItem = paramFilterCategoryItem;
        if (a(paramFilterCategoryItem))
        {
          dLj();
          localFilterCategoryItem = paramFilterCategoryItem;
        }
      }
      this.mQQFilterRenderManager.getBusinessOperation().setFilterEffect(localFilterCategoryItem);
    }
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.cAj = paramBoolean;
  }
  
  public void setFilterInitedListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$d = paramd;
  }
  
  public void setFiltersChainListener(e parame)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView$e = parame;
  }
  
  public void setHasStoryWaterMark(boolean paramBoolean)
  {
    this.cBa = paramBoolean;
  }
  
  public void setIntercepPreviewCheck(boolean paramBoolean)
  {
    this.cBb = paramBoolean;
  }
  
  public void setMovieEffect(String paramString)
  {
    if ((this.cAR) && (this.mQQFilterRenderManager != null))
    {
      if (!aqhq.fileExistsAndNotEmpty(paramString))
      {
        dLe();
        a(null);
        this.mQQFilterRenderManager.getBusinessOperation().setMovieMaterial(null);
      }
    }
    else {
      return;
    }
    MovieMaterial localMovieMaterial = QQTemplateParser.parseMovieMaterial(paramString, "params");
    if (localMovieMaterial == null)
    {
      QLog.e("PtvFilterUtils", 2, "setMovieFilter parseMovieMaterial params.json failed");
      return;
    }
    if (!TextUtils.isEmpty(localMovieMaterial.atmosphereName))
    {
      localMovieMaterial.atmosphereVideoPath = (paramString + File.separator + localMovieMaterial.atmosphereName + ".mp4");
      localMovieMaterial.atmosphereAudioPath = (paramString + File.separator + localMovieMaterial.atmosphereName + ".mp3");
    }
    if (!TextUtils.isEmpty(localMovieMaterial.doodleName))
    {
      localMovieMaterial.doodleVideoPath = (paramString + File.separator + localMovieMaterial.doodleName + ".mp4");
      localMovieMaterial.doodleAudioPath = (paramString + File.separator + localMovieMaterial.doodleName + ".mp3");
    }
    if (!TextUtils.isEmpty(localMovieMaterial.hintsImageName)) {
      localMovieMaterial.hintImagePath = (paramString + File.separator + localMovieMaterial.hintsImageName + ".png");
    }
    a(localMovieMaterial);
    this.mQQFilterRenderManager.getBusinessOperation().setMovieMaterial(localMovieMaterial);
    dLf();
  }
  
  public void setSharpFaceEnable(boolean paramBoolean)
  {
    this.cAX = paramBoolean;
    if (this.cAX) {
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = AdvancedProviderView.QV();
    }
  }
  
  public void setUpCosmeticsAlpha(int paramInt)
  {
    queueEvent(new EffectsCameraCaptureView.5(this, paramInt));
  }
  
  public void updateSharpFace(int paramInt)
  {
    queueEvent(new EffectsCameraCaptureView.4(this, paramInt));
  }
  
  public String yJ()
  {
    if (this.groupVideoFilterList != null) {
      return this.groupVideoFilterList.getTriggerTips();
    }
    return this.bZt;
  }
  
  public static abstract interface a
  {
    public abstract void w(double paramDouble);
  }
  
  public static abstract interface b
  {
    public abstract void w(Bitmap paramBitmap);
  }
  
  public static abstract interface c
  {
    public abstract void OB(boolean paramBoolean);
    
    public abstract void OC(boolean paramBoolean);
    
    public abstract void OD(boolean paramBoolean);
    
    public abstract void a(VideoMaterial paramVideoMaterial);
    
    public abstract boolean auZ();
    
    public abstract boolean bk(boolean paramBoolean);
    
    public abstract void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
    
    public abstract void hg(String paramString1, String paramString2);
    
    public abstract void kR(long paramLong);
  }
  
  public static abstract interface d
  {
    public abstract void OE(boolean paramBoolean);
  }
  
  public static abstract interface e
  {
    public abstract void a(QQFilterRenderManager.ChainBuilder paramChainBuilder);
    
    public abstract void dLn();
  }
  
  public static class f
  {
    public boolean cBf;
    public boolean cBg = true;
    public int type;
    
    public void clear()
    {
      this.cBf = false;
      this.cBg = false;
      this.type = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */