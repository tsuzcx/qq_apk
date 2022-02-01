import android.content.Context;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class ioo
  implements iom
{
  private boolean TA;
  private boolean TB = true;
  private boolean TC = true;
  private boolean Tz;
  private AESticker jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker;
  private volatile Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private final ipj jdField_a_of_type_Ipj;
  private int aqW;
  private int aqX = -1;
  private int aqY = -1;
  private VideoMaterial b;
  private PendantItem d;
  private Context mContext;
  private int mHeight;
  private QQFilterRenderManager mQQFilterRenderManager;
  private int mWidth;
  
  public ioo(Context paramContext, ipj paramipj)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Ipj = paramipj;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterOldWrapper", 4, "AEFilterOldWrapper, useAVSDKBeauty[" + this.TB + "], useGestureDetect[" + this.TC + "]");
    }
  }
  
  private void a(int paramInt, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.Tz)
      {
        GestureMgrRecognize.getInstance().start();
        this.Tz = true;
        GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_AV;
      }
      GestureFilterManager.sGestureType = paramPendantItem.getGestureType();
      lk(paramInt);
      this.jdField_a_of_type_Ipj.js(paramPendantItem.getGestureType());
      return;
    }
    this.jdField_a_of_type_Ipj.apm();
    if (this.Tz)
    {
      GestureMgrRecognize.getInstance().stop();
      this.Tz = false;
      GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_None;
    }
    GestureFilterManager.sGestureType = "";
  }
  
  private void aoM()
  {
    if (this.mQQFilterRenderManager != null) {
      this.mQQFilterRenderManager.getBusinessOperation().clearPtvVideoActiveFilter();
    }
  }
  
  private void aoN()
  {
    if (this.mQQFilterRenderManager == null) {}
    do
    {
      return;
      this.mQQFilterRenderManager.initAEDetector_sync();
    } while (this.mQQFilterRenderManager.hasAEDetectorInited());
    QLog.e("AEFilterOldWrapper", 1, "initFaceDetectorSDK_Sync failed!");
  }
  
  private void aoO()
  {
    if (this.mQQFilterRenderManager == null) {
      return;
    }
    QQFilterRenderManager.ChainBuilder localChainBuilder = this.mQQFilterRenderManager.getChainBuilder();
    localChainBuilder.setUseSort(true);
    localChainBuilder.addFilter(25, null);
    this.mQQFilterRenderManager.setBackCameraDetectEnable(true);
    localChainBuilder.addFilter(40, null);
    localChainBuilder.addFilter(184, null);
    localChainBuilder.commit();
    QLog.w("AEFilterOldWrapper", 1, "commitChainBuilder");
  }
  
  private void lj(int paramInt)
  {
    if (this.mQQFilterRenderManager != null)
    {
      int i = paramInt;
      if (paramInt > 95) {
        i = 95;
      }
      this.mQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(i);
    }
  }
  
  private void lk(int paramInt)
  {
    GestureMgrRecognize.getInstance().setRecognizeMillis(Long.valueOf(PtvTemplateManager.cdw).longValue());
    GestureMgrRecognize.getInstance().setRecognizeFrameRate(Integer.valueOf(PtvTemplateManager.cdv).intValue());
    int i = (int)(this.mWidth * 0.25F);
    int j = (int)(this.mHeight * 0.25F);
    GestureMgrRecognize.getInstance().transferRGBAbuffer(paramInt, i, j, this.mWidth, this.mHeight);
  }
  
  public int a(int paramInt, boolean paramBoolean1, ioy paramioy, boolean paramBoolean2)
  {
    boolean bool = false;
    if (this.mQQFilterRenderManager == null) {
      return paramInt;
    }
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) || (this.TA))
    {
      if ((!this.mQQFilterRenderManager.hasAEDetectorInited()) || (!this.mQQFilterRenderManager.getFaceDetectFlags())) {
        this.mQQFilterRenderManager.setFaceDetectFlags(true);
      }
      this.mQQFilterRenderManager.getBusinessOperation().setPtvNeedFlip(false);
      ipi.iE(this.mQQFilterRenderManager.hasAEDetectorInited());
    }
    for (;;)
    {
      paramBoolean1 = bool;
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null)
      {
        paramBoolean1 = bool;
        if (this.d != null)
        {
          paramBoolean1 = bool;
          if (this.d.hasGesture()) {
            paramBoolean1 = true;
          }
        }
      }
      a(paramInt, this.d, paramBoolean1);
      int i = this.mQQFilterRenderManager.drawFrame(paramInt);
      if ((!this.mQQFilterRenderManager.needFaceDetect()) && (this.TA))
      {
        aoN();
        if ((this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == null) || (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO() != this.aqX) || (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.width != this.mWidth) || (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.height != this.mHeight)) {
          this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame(this.aqX, this.aqY, this.mWidth, this.mHeight);
        }
        this.mQQFilterRenderManager.setFaceDetectFlags(true);
        this.mQQFilterRenderManager.initDetectFaceSDK(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      }
      paramInt = i;
      if (paramioy == null) {
        break;
      }
      paramioy.a(this.mQQFilterRenderManager.getFaceAttr(), (float)this.mQQFilterRenderManager.getWindowScale(), paramBoolean2);
      return i;
      this.mQQFilterRenderManager.setFaceDetectFlags(false);
    }
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    if ((paramPendantItem != null) && (paramPendantItem.hasGesture()) && (!this.TC)) {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterOldWrapper", 2, "setPendant, not support gesture pendant.");
      }
    }
    do
    {
      do
      {
        return;
      } while ((ipi.a(this.d, paramPendantItem)) && (this.b == paramVideoMaterial));
      QLog.d("AEFilterOldWrapper", 1, "setPendant[" + paramPendantItem + "]");
      if ((this.mQQFilterRenderManager != null) && (this.mQQFilterRenderManager.hasAEDetectorInited())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AEFilterOldWrapper", 2, "initFaceDetectorSDK_Sync failed!");
    return;
    if ((paramPendantItem != null) && (paramPendantItem.hasGesture()) && (paramVideoMaterial != null))
    {
      paramVideoMaterial.mHasGestureFilter = true;
      if (!paramPendantItem.hasFace()) {
        paramVideoMaterial.isNeedDecodeFaceFilter = false;
      }
    }
    this.d = paramPendantItem;
    this.b = paramVideoMaterial;
    if (this.b != null) {
      aoM();
    }
    for (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = new AESticker(this.b, this.mQQFilterRenderManager.getFaceDetector());; this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null)
    {
      this.mQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker, this.b);
      return;
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (!ipi.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramFilterDesc))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      this.mQQFilterRenderManager.getBusinessOperation().setFilterEffect(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
    }
  }
  
  public void a(iow paramiow, ioy paramioy)
  {
    String str2 = "";
    String str1 = "";
    if (this.d != null)
    {
      str2 = this.d.getGestureType();
      str1 = this.d.getGestureWording();
    }
    for (boolean bool1 = this.d.hasFace();; bool1 = false)
    {
      boolean bool2 = ikg.a().tD();
      if ((ikl.a(this.b)) && (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        this.jdField_a_of_type_Ipj.a(paramiow, paramioy.facecount, this.Tz, bool1, str1, str2);
        return;
      }
    }
  }
  
  public boolean a(ior paramior)
  {
    boolean bool = false;
    if (paramior != null) {}
    for (int i = paramior.at("BEAUTY_SKIN");; i = 0)
    {
      if (this.aqW != i)
      {
        lj(i);
        this.aqW = i;
      }
      if (this.aqW == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void aoH()
  {
    if (this.mQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
      this.mQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
      this.d = null;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null;
      this.b = null;
      this.mQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter(null);
    }
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
  }
  
  public void aoI()
  {
    if (this.mQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
      this.mQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
      this.d = null;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null;
      this.mQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter(null);
    }
    GestureMgrRecognize.getInstance().stop();
    this.Tz = false;
    GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_None;
    GestureFilterManager.sGestureType = "";
  }
  
  public void aoJ()
  {
    if (this.mQQFilterRenderManager != null) {
      aoO();
    }
  }
  
  public void bE(int paramInt1, int paramInt2)
  {
    this.aqX = paramInt1;
    this.aqY = paramInt2;
  }
  
  public void cp(long paramLong)
  {
    QLog.w("AEFilterOldWrapper", 1, "clearState, seq[" + paramLong + "]");
    this.jdField_a_of_type_Ipj.cp(paramLong);
    if (this.Tz)
    {
      GestureMgrRecognize.getInstance().stop();
      this.Tz = false;
    }
    GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_None;
    GestureFilterManager.sGestureType = "";
  }
  
  public void iC(boolean paramBoolean)
  {
    this.TA = paramBoolean;
  }
  
  public void initInGL(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.mQQFilterRenderManager == null)
    {
      this.mQQFilterRenderManager = new QQFilterRenderManager();
      if (!ankq.by(BaseApplicationImpl.getContext())) {
        break label69;
      }
      aoO();
    }
    for (;;)
    {
      if ((this.mQQFilterRenderManager != null) && (this.mQQFilterRenderManager.cameraInterFace == null)) {
        this.mQQFilterRenderManager.cameraInterFace = ikg.a();
      }
      return;
      label69:
      QLog.w("AEFilterOldWrapper", 1, "initial, isLoadedSO fail");
    }
  }
  
  public boolean isNeedFaceDetect()
  {
    boolean bool = false;
    if (this.mQQFilterRenderManager != null) {
      bool = this.mQQFilterRenderManager.needFaceDetect();
    }
    return bool;
  }
  
  public boolean uN()
  {
    return (this.d != null) && (this.d.hasGesture());
  }
  
  public boolean uO()
  {
    return this.TB;
  }
  
  public void updateWidthHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    if (this.mQQFilterRenderManager != null)
    {
      this.mQQFilterRenderManager.surfaceCreate(this.mWidth, this.mHeight, this.mWidth, this.mHeight);
      this.mQQFilterRenderManager.surfaceChange(this.mWidth, this.mHeight, this.mWidth, this.mHeight);
      String str = "null camera";
      if (CameraUtils.a(this.mContext).ar(0L))
      {
        str = String.valueOf(CameraUtils.a(this.mContext).isFrontCamera());
        this.mQQFilterRenderManager.setParam("key_front_camera", str);
      }
      igd.aJ("AEFilterOldWrapper", "mQQFilterRenderManager surfaceChange" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioo
 * JD-Core Version:    0.7.0.1
 */