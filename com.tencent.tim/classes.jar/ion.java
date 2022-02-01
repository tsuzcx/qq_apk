import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ion
  implements iom
{
  private boolean Ty;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private final ior jdField_a_of_type_Ior = new ior();
  private final ipj jdField_a_of_type_Ipj;
  private int aqT;
  private int aqU;
  private int aqV;
  private FilterDesc b;
  private PendantItem d;
  private final List<ior.a> fl = new ArrayList(11);
  private int mHeight;
  private volatile int mState;
  private VideoMaterial mVideoMaterial;
  private int mWidth;
  
  public ion(ipj paramipj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "AEFilterAVWrapperImpl");
    }
    this.jdField_a_of_type_Ipj = paramipj;
    this.mState = 0;
    li(1);
  }
  
  private String a(FilterDesc paramFilterDesc)
  {
    Object localObject2;
    if (paramFilterDesc == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
      if (!TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        localObject1 = paramFilterDesc.resRootPath;
      }
      localObject2 = paramFilterDesc.getResFold((String)localObject1);
      QQPtColorFilterInfo localQQPtColorFilterInfo = QQPtColorFilter.getColorFilterInfo((String)localObject2);
      localObject1 = localObject2;
      if (localQQPtColorFilterInfo != null) {
        localObject1 = (String)localObject2 + localQQPtColorFilterInfo.getColorPng();
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.i("AEFilterAVWrapperImpl", 2, "getLutPath, name[" + paramFilterDesc.name + "], out[" + (String)localObject1 + "]");
    return localObject1;
  }
  
  private void aoK()
  {
    if (this.mState >= 2) {
      return;
    }
    String str;
    label93:
    boolean bool;
    if (this.mState < 3)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.mWidth, this.mHeight);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(108, false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
      str = a(this.b);
      if ((!TextUtils.isEmpty(str)) && (!aqhq.fileExists(str))) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.mVideoMaterial);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.Ty);
      bool = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited();
      if (!bool) {
        break label256;
      }
      this.mState = 2;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 101, 108, 106, 102, 104, 105, 103 });
    }
    for (;;)
    {
      ipi.iE(bool);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AEFilterAVWrapperImpl", 2, "initAEFilterInGL, state[" + this.mState + "]");
      return;
      label223:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEFilterInGL, fail path[" + str + "]");
      break label93;
      label256:
      this.mState = 3;
    }
  }
  
  private void aoL()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {}
    do
    {
      return;
      localAEFilterManager.setSmoothSharpenSize(this.aqT, this.aqU);
      localAEFilterManager.setSmoothSharpenStrength(0.0F);
      this.jdField_a_of_type_Ior.f(0, this.fl);
      Iterator localIterator = this.fl.iterator();
      while (localIterator.hasNext())
      {
        ior.a locala = (ior.a)localIterator.next();
        if (locala != null) {
          switch (locala.type)
          {
          default: 
            break;
          case 1: 
            localAEFilterManager.setSmoothLevel(locala.level);
            break;
          case 2: 
          case 3: 
            localAEFilterManager.setBeautyOrTransformLevel(locala.a, locala.level);
          }
        }
      }
    } while ((this.d == null) || (!PendantItem.isBeautyMakeup(this.d.getCategory())));
    if ((this.d.extraParam instanceof Integer)) {
      this.aqV = ((Integer)this.d.extraParam).intValue();
    }
    localAEFilterManager.setCosmeticsAlpha(this.aqV);
  }
  
  private PTFaceAttr getFaceAttr()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      AIAttr localAIAttr = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getAIAttr();
      localObject1 = localObject2;
      if (localAIAttr != null) {
        localObject1 = (PTFaceAttr)localAIAttr.getFaceAttr();
      }
    }
    return localObject1;
  }
  
  private double getFaceDetectScale()
  {
    double d1 = 0.16666667163372D;
    PTFaceAttr localPTFaceAttr = getFaceAttr();
    if (localPTFaceAttr != null) {
      d1 = localPTFaceAttr.getFaceDetectScale();
    }
    return d1;
  }
  
  private void li(int paramInt)
  {
    if (this.mState >= 1) {}
    boolean bool;
    do
    {
      return;
      bool = AEFilterSupport.cp(paramInt);
      if ((bool) && (this.mState < 1)) {
        this.mState = 1;
      }
    } while ((paramInt == 0) || (!QLog.isColorLevel()));
    QLog.i("AEFilterAVWrapperImpl", 2, "prepare ret[" + bool + "], state[" + this.mState + "], flag[" + paramInt + "]");
  }
  
  public int a(int paramInt, boolean paramBoolean1, ioy paramioy, boolean paramBoolean2)
  {
    int i;
    if (this.mState < 1)
    {
      li(0);
      i = paramInt;
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (this.mState < 2) {
            aoK();
          }
          i = paramInt;
        } while (this.mState >= 3);
        i = paramInt;
      } while (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null);
      aoL();
      paramInt = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(paramInt, paramBoolean1, System.currentTimeMillis() * 1000000L);
      i = paramInt;
    } while (paramioy == null);
    paramioy.a(getFaceAttr(), (float)getFaceDetectScale(), paramBoolean2);
    return paramInt;
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    boolean bool;
    if ((!ipi.a(this.d, paramPendantItem)) || (this.mVideoMaterial != paramVideoMaterial))
    {
      if (QLog.isColorLevel())
      {
        if ((this.d == null) || (!this.d.hasGesture())) {
          break label181;
        }
        bool = true;
        QLog.d("AEFilterAVWrapperImpl", 2, "setPendant, pendantItem[" + paramPendantItem + "], isPendantHasGesture[" + bool + "]");
      }
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited())) {
        break label186;
      }
      this.d = paramPendantItem;
      this.mVideoMaterial = paramVideoMaterial;
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.mVideoMaterial);
      }
    }
    for (;;)
    {
      if ((this.d != null) && (PendantItem.isBeautyMakeup(this.d.getCategory())) && ((this.d.extraParam instanceof Integer))) {
        this.aqV = ((Integer)this.d.extraParam).intValue();
      }
      return;
      label181:
      bool = false;
      break;
      label186:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!ipi.a(this.b, paramFilterDesc))
    {
      this.b = paramFilterDesc;
      str = a(this.b);
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) || ((!TextUtils.isEmpty(str)) && (!aqhq.fileExists(str)))) {
        break label112;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("setFilterDesc, name[");
        if (paramFilterDesc != null) {
          break label146;
        }
      }
    }
    label146:
    for (paramFilterDesc = "null";; paramFilterDesc = paramFilterDesc.name)
    {
      QLog.i("AEFilterAVWrapperImpl", 2, paramFilterDesc + "], path[" + str + "]");
      return;
      label112:
      QLog.i("AEFilterAVWrapperImpl", 1, "setFilterDesc, fail path[" + str + "]");
      break;
    }
  }
  
  public void a(iow paramiow, ioy paramioy)
  {
    String str2 = "";
    String str1 = "";
    VideoMaterial localVideoMaterial = this.mVideoMaterial;
    PendantItem localPendantItem = this.d;
    if (localPendantItem != null)
    {
      str2 = localPendantItem.getGestureType();
      str1 = localPendantItem.getGestureWording();
    }
    for (boolean bool1 = localPendantItem.hasFace();; bool1 = false)
    {
      boolean bool2 = ikg.a().tD();
      if ((ikl.a(localVideoMaterial)) && (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        this.jdField_a_of_type_Ipj.a(paramiow, paramioy.facecount, false, bool1, str1, str2);
        return;
      }
    }
  }
  
  public boolean a(ior paramior)
  {
    if (paramior == null) {
      this.jdField_a_of_type_Ior.clear();
    }
    for (;;)
    {
      return this.jdField_a_of_type_Ior.uT();
      this.jdField_a_of_type_Ior.a(paramior);
    }
  }
  
  public void aoH()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(null);
    }
    this.b = null;
    this.d = null;
    this.mVideoMaterial = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "uninitInGL");
    }
  }
  
  public void aoI()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    this.mState = 4;
    this.b = null;
    this.mVideoMaterial = null;
    this.d = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "destroyInGL");
    }
  }
  
  public void aoJ() {}
  
  public void bE(int paramInt1, int paramInt2) {}
  
  public void cp(long paramLong)
  {
    QLog.w("AEFilterAVWrapperImpl", 1, "clearState, seq[" + paramLong + "]");
    this.jdField_a_of_type_Ipj.cp(paramLong);
  }
  
  public void iC(boolean paramBoolean)
  {
    this.Ty = paramBoolean;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.Ty);
    }
  }
  
  public void initInGL(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.aqT = ((int)(paramInt1 * 1.0F));
    this.aqU = ((int)(paramInt2 * 1.0F));
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "initInGL");
    }
  }
  
  public boolean isNeedFaceDetect()
  {
    return (this.Ty) || (this.d != null);
  }
  
  public boolean uN()
  {
    return (this.d != null) && (this.d.hasGesture());
  }
  
  public boolean uO()
  {
    return false;
  }
  
  public void updateWidthHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.aqT = ((int)(paramInt1 * 1.0F));
    this.aqU = ((int)(paramInt2 * 1.0F));
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ion
 * JD-Core Version:    0.7.0.1
 */