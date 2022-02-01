import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.1;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.2;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.3;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimRenderable.5;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class adds
  implements adcy, adda, Handler.Callback
{
  private adcy jdField_a_of_type_Adcy;
  private addr jdField_a_of_type_Addr;
  private ArVideoResourceInfo jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo;
  private adcy jdField_b_of_type_Adcy;
  private adda jdField_b_of_type_Adda;
  addf.a jdField_b_of_type_Addf$a = null;
  private boolean bLY;
  private boolean bLZ;
  private int mCurrentIndex;
  private Handler mHandler;
  private ReentrantLock n = new ReentrantLock();
  
  public adds(adda paramadda, addr paramaddr)
  {
    this.jdField_b_of_type_Adda = paramadda;
    this.jdField_a_of_type_Addr = paramaddr;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private adcy a(ArVideoResourceInfo paramArVideoResourceInfo, int paramInt)
  {
    addc localaddc = a(paramArVideoResourceInfo);
    adcy localadcy = adde.a(this, localaddc, null);
    QLog.d("AREngine_MultiFragmentAnimRenderable", 1, "create new render here " + localadcy);
    boolean bool;
    if (localadcy != null)
    {
      if ((!TextUtils.isEmpty(paramArVideoResourceInfo.bus)) && (aqhq.fileExists(paramArVideoResourceInfo.bus)) && (this.jdField_a_of_type_Addr.b.uk.size() > paramInt + 1))
      {
        paramArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Addr.b.uk.get(paramInt + 1);
        if ((paramArVideoResourceInfo.videoType == 4) && (!TextUtils.isEmpty(paramArVideoResourceInfo.bus)) && (!aqhq.fileExists(paramArVideoResourceInfo.bus)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "preload next online video, " + paramArVideoResourceInfo.videoUrl + ", " + paramArVideoResourceInfo.bus);
          }
          adkz.a(BaseApplicationImpl.getContext(), paramArVideoResourceInfo);
        }
      }
      if ((localaddc.cCE != 5) || ((localaddc.Sl != 2L) && (localaddc.Sl != 2048L))) {
        break label292;
      }
      bool = true;
      this.jdField_b_of_type_Adda.a().reset();
      this.jdField_b_of_type_Adda.a().a(bool, localaddc);
      if (localaddc.cCE != 0) {
        break label297;
      }
      paramArVideoResourceInfo = (addm)localaddc;
      this.jdField_b_of_type_Adda.a().a(localaddc.cCF, localaddc.cCE, paramArVideoResourceInfo.a);
    }
    label292:
    label297:
    do
    {
      return localadcy;
      bool = false;
      break;
      if ((localaddc.cCE == 2) || (localaddc.cCE == 3))
      {
        paramArVideoResourceInfo = (addv)localaddc;
        this.jdField_b_of_type_Adda.a().a(localaddc.cCF, localaddc.cCE, paramArVideoResourceInfo.a);
        return localadcy;
      }
    } while (localaddc.cCE != 4);
    paramArVideoResourceInfo = (addy)localaddc;
    this.jdField_b_of_type_Adda.a().a(localaddc.cCF, localaddc.cCE, paramArVideoResourceInfo.a);
    return localadcy;
  }
  
  private addc a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    ArCloudConfigInfo localArCloudConfigInfo = new ArCloudConfigInfo();
    localArCloudConfigInfo.type = paramArVideoResourceInfo.videoType;
    if ((QLog.isDebugVersion()) && (paramArVideoResourceInfo.videoType != 2) && (paramArVideoResourceInfo.videoType != 3) && (paramArVideoResourceInfo.videoType != 4))
    {
      ThreadManager.getUIHandler().post(new MultiFragmentAnimRenderable.1(this));
      QLog.i("AREngine_MultiFragmentAnimRenderable", 2, "buildARRenderResourceInfoForFragmentAnim animInfo.type=" + paramArVideoResourceInfo.videoType);
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramArVideoResourceInfo);
    localArCloudConfigInfo.uk = ((ArrayList)localObject);
    localObject = new ArFeatureInfo();
    ((ArFeatureInfo)localObject).buc = paramArVideoResourceInfo.videoMd5;
    ((ArFeatureInfo)localObject).buf = this.jdField_a_of_type_Addr.b.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.buf;
    localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = ((ArFeatureInfo)localObject);
    localArCloudConfigInfo.cCF = this.jdField_a_of_type_Addr.b.cCF;
    return adku.a(localArCloudConfigInfo, true, this.jdField_a_of_type_Addr.Sl, this.jdField_a_of_type_Addr.markerType, this.jdField_a_of_type_Addr.sY, this.jdField_a_of_type_Addr.sZ, this.jdField_a_of_type_Addr.ta);
  }
  
  private void cQH()
  {
    ArVideoResourceInfo localArVideoResourceInfo;
    adcy localadcy;
    if ((!this.jdField_a_of_type_Addr.b.uk.isEmpty()) && (this.jdField_a_of_type_Addr.b.uk.size() > this.mCurrentIndex + 1))
    {
      localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Addr.b.uk.get(this.mCurrentIndex + 1);
      localadcy = a(localArVideoResourceInfo, this.mCurrentIndex + 1);
      if (localadcy == null) {
        this.mHandler.sendEmptyMessageDelayed(0, 100L);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Adcy = this.jdField_a_of_type_Adcy;
    this.jdField_a_of_type_Adcy = localadcy;
    this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    this.mCurrentIndex += 1;
    this.jdField_b_of_type_Adda.Z(new MultiFragmentAnimRenderable.2(this, localadcy));
  }
  
  public int Bx()
  {
    if (this.jdField_a_of_type_Adcy != null)
    {
      if ((this.jdField_b_of_type_Adcy != null) && (!this.jdField_a_of_type_Adcy.adF())) {
        return this.jdField_b_of_type_Adcy.Bx();
      }
      return this.jdField_a_of_type_Adcy.Bx();
    }
    return 2;
  }
  
  public void Gr(String paramString) {}
  
  public void Z(Runnable paramRunnable)
  {
    this.jdField_b_of_type_Adda.Z(paramRunnable);
  }
  
  public addf a()
  {
    return this.jdField_b_of_type_Adda.a();
  }
  
  public adkx a()
  {
    return null;
  }
  
  public void a(adcy paramadcy, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void a(addf.a parama)
  {
    if (this.jdField_a_of_type_Adcy != null)
    {
      if ((!this.jdField_a_of_type_Adcy.adF()) && (this.jdField_b_of_type_Adcy != null) && (this.jdField_b_of_type_Addf$a != null))
      {
        this.n.lock();
        if (this.jdField_b_of_type_Adcy != null) {
          this.jdField_b_of_type_Adcy.a(this.jdField_b_of_type_Addf$a);
        }
        this.n.unlock();
      }
    }
    else {
      return;
    }
    if (this.jdField_b_of_type_Adcy != null) {
      this.jdField_b_of_type_Adda.Z(new MultiFragmentAnimRenderable.3(this));
    }
    this.jdField_a_of_type_Adcy.a(parama);
    this.jdField_b_of_type_Addf$a = parama;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo)
  {
    cQH();
    this.bLZ = false;
  }
  
  public boolean adF()
  {
    if (this.jdField_a_of_type_Adcy != null)
    {
      if ((this.jdField_b_of_type_Adcy != null) && (!this.jdField_a_of_type_Adcy.adF())) {
        return this.jdField_b_of_type_Adcy.adF();
      }
      return this.jdField_a_of_type_Adcy.adF();
    }
    return false;
  }
  
  public void b(ArVideoResourceInfo paramArVideoResourceInfo, adda paramadda) {}
  
  public boolean canRender()
  {
    if (this.jdField_a_of_type_Adcy != null)
    {
      if ((!this.jdField_a_of_type_Adcy.adF()) && (this.jdField_b_of_type_Adcy != null)) {
        return this.jdField_b_of_type_Adcy.canRender();
      }
      return this.jdField_a_of_type_Adcy.canRender();
    }
    return false;
  }
  
  public int getType()
  {
    if (this.jdField_a_of_type_Adcy != null)
    {
      if ((!this.jdField_a_of_type_Adcy.adF()) && (this.jdField_b_of_type_Adcy != null)) {
        return this.jdField_b_of_type_Adcy.getType();
      }
      return this.jdField_a_of_type_Adcy.getType();
    }
    return 5;
  }
  
  public String getUniqueKey()
  {
    return this.jdField_a_of_type_Addr.key;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_b_of_type_Adda != null) {
        this.jdField_b_of_type_Adda.Z(new MultiFragmentAnimRenderable.5(this));
      }
    }
  }
  
  public void hg(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_MultiFragmentAnimRenderable", 2, "notifyAnimationPlayStatusChange state:" + paramInt1 + " remainTimes:" + paramInt2);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.mCurrentIndex != 0);
          this.jdField_b_of_type_Adda.hg(paramInt1, paramInt2);
          return;
          this.mHandler.sendEmptyMessage(0);
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || ((!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.aeM()) && (this.jdField_a_of_type_Addr.b.uk.size() != this.mCurrentIndex + 1))) {
            break;
          }
        } while (((this.jdField_a_of_type_Addr.b.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_a_of_type_Addr.b.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.bNZ) && (paramInt2 > 0)) || (this.bLY) || (this.jdField_b_of_type_Adcy != null));
        this.bLY = true;
        this.jdField_b_of_type_Adda.hg(paramInt1, 0);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.aeL())) {
          break;
        }
      } while (this.bLZ);
      this.bLZ = true;
      this.jdField_b_of_type_Adda.b(this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo, this);
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo.aeK()) || (paramInt2 > 0));
    cQH();
  }
  
  public void init()
  {
    if (!this.jdField_a_of_type_Addr.b.uk.isEmpty())
    {
      this.mCurrentIndex = 0;
      ArVideoResourceInfo localArVideoResourceInfo = (ArVideoResourceInfo)this.jdField_a_of_type_Addr.b.uk.get(this.mCurrentIndex);
      this.jdField_a_of_type_Adcy = a(localArVideoResourceInfo, this.mCurrentIndex);
      this.jdField_a_of_type_ComTencentMobileqqArModelArVideoResourceInfo = localArVideoResourceInfo;
    }
    if (this.jdField_a_of_type_Adcy == null) {
      this.mHandler.sendEmptyMessageDelayed(0, 100L);
    }
    for (;;)
    {
      this.bLY = false;
      return;
      this.jdField_a_of_type_Adcy.init();
    }
  }
  
  public Object m(int paramInt)
  {
    return this.jdField_b_of_type_Adda.m(paramInt);
  }
  
  public Context n()
  {
    return this.jdField_b_of_type_Adda.n();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.w("AREngine_MultiFragmentAnimRenderable", 2, "onDestroy currentRenderable " + this.jdField_a_of_type_Adcy + "  lastRenderable " + this.jdField_b_of_type_Adcy);
    }
    if (this.jdField_a_of_type_Adcy != null)
    {
      this.jdField_a_of_type_Adcy.onDestroy();
      this.jdField_a_of_type_Adcy = null;
    }
    if (this.jdField_b_of_type_Adcy != null)
    {
      this.jdField_b_of_type_Adcy.onDestroy();
      this.jdField_b_of_type_Adcy = null;
    }
    this.jdField_b_of_type_Addf$a = null;
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    this.bLY = false;
    this.bLZ = false;
  }
  
  public void onUpdate()
  {
    if (this.jdField_a_of_type_Adcy != null) {
      this.jdField_a_of_type_Adcy.onUpdate();
    }
  }
  
  public void requestRender()
  {
    this.jdField_b_of_type_Adda.requestRender();
  }
  
  public void setWidthAndHeight(int paramInt1, int paramInt2) {}
  
  public void start()
  {
    if (this.jdField_a_of_type_Adcy != null) {
      this.jdField_a_of_type_Adcy.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adds
 * JD-Core Version:    0.7.0.1
 */