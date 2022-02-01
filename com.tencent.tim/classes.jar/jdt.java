import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.ArrayList;
import java.util.List;

public final class jdt
{
  private volatile String RF = "";
  private boolean XZ;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private izp[] jdField_a_of_type_ArrayOfIzp = new izp[16];
  private float[] af;
  private int axs;
  private int axt;
  private int axu;
  private volatile ipu b;
  private List<ipw.a> fB = new ArrayList();
  private volatile String mFilterPath;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private long oP;
  private long oQ;
  private long oR;
  
  public jdt(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    int i = 0;
    while (i < 16)
    {
      this.jdField_a_of_type_ArrayOfIzp[i] = new izp();
      i += 1;
    }
  }
  
  private ipu a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {}
    for (int i = 1;; i = 0)
    {
      if (this.b == null)
      {
        this.axt = paramInt1;
        this.axu = paramInt2;
        this.b = new ipu(paramInt1, paramInt2);
        QLog.i("VideoAfterTreatmentManager", 1, "lazyGetMultipleTextureProcessor  realCreate mLastFilterPath:=" + this.RF + ",mFilterPath:=" + this.mFilterPath);
      }
      if ((i != 0) || (!this.RF.equalsIgnoreCase(this.mFilterPath)))
      {
        this.RF = this.mFilterPath;
        this.b.jt(this.mFilterPath);
        QLog.i("VideoAfterTreatmentManager", 1, "lazyGetMultipleTextureProcessor: applyMaterial:=" + this.mFilterPath);
      }
      return this.b;
    }
  }
  
  private void auN()
  {
    if (this.b != null)
    {
      this.b.destroy();
      this.b = null;
      this.RF = "";
      QLog.i("VideoAfterTreatmentManager", 1, "destroyMultipleTextureProcessorIfNeed finish");
    }
  }
  
  public Frame a(int paramInt1, int paramInt2)
  {
    if (this.axs >= 2)
    {
      ird.a().lu(256);
      int i = AudioHelper.jY(29);
      Object localObject = a(paramInt1, paramInt2);
      long l = System.currentTimeMillis();
      localObject = ((ipu)localObject).b(this.fB, System.currentTimeMillis());
      l = System.currentTimeMillis() - l;
      if ((QLog.isDebugVersion()) || (i == 1)) {
        QLog.i("VideoAfterTreatmentManager", 2, "doCallAEModulePostScreenRender, cost[" + l + "]");
      }
      this.oR = Math.max(l, this.oR);
      this.oP = (l + this.oP);
      this.oQ += 1L;
      return localObject;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, List<TTFaceOriginDataModel> paramList, boolean paramBoolean2)
  {
    int i = 1;
    this.jdField_a_of_type_ArrayOfIzp[this.axs].awt = paramInt1;
    this.jdField_a_of_type_ArrayOfIzp[this.axs].awu = paramInt2;
    this.jdField_a_of_type_ArrayOfIzp[this.axs].awv = paramInt3;
    this.axs += 1;
    ipw.a locala = new ipw.a();
    locala.texture = paramInt1;
    locala.width = paramInt2;
    locala.arQ = paramInt3;
    locala.fo = paramList;
    locala.arR = paramInt4;
    locala.arS = paramInt5;
    locala.Tt = paramBoolean1;
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PT)
    {
      paramBoolean1 = true;
      this.XZ = paramBoolean1;
      if (this.XZ)
      {
        paramInt1 = i;
        if (paramBoolean2) {}
      }
      else
      {
        if ((this.XZ) || (paramBoolean2)) {
          break label182;
        }
      }
    }
    label182:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label187;
      }
      this.fB.add(0, locala);
      return;
      paramBoolean1 = false;
      break;
    }
    label187:
    this.fB.add(locala);
  }
  
  public boolean a(jdl paramjdl)
  {
    int j = 1;
    this.mFilterPath = "";
    if (this.jdField_a_of_type_ComTencentAvVideoController.mApp.ch(3))
    {
      paramjdl = ((ijv)this.jdField_a_of_type_ComTencentAvVideoController.mApp.a(3)).a();
      if (paramjdl != null) {
        this.mFilterPath = paramjdl.getDesc();
      }
    }
    for (int i = 1;; i = 0)
    {
      if (TextUtils.isEmpty(this.mFilterPath)) {
        auN();
      }
      if ((i == 0) || (TextUtils.isEmpty(this.mFilterPath))) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {}
      for (i = j;; i = 0)
      {
        boolean bool1 = this.jdField_a_of_type_ComTencentAvVideoController.b().PY;
        boolean bool2 = this.jdField_a_of_type_ComTencentAvVideoController.b().PZ;
        if ((i == 0) || (!bool1) || (!bool2) || (VideoController.a().a() == null)) {
          break;
        }
        return iop.h(VideoController.a().a());
      }
    }
  }
  
  public void auO()
  {
    this.axs = 0;
    this.fB.clear();
  }
  
  public void auP()
  {
    auN();
  }
  
  public void bY(int paramInt1, int paramInt2)
  {
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
  }
  
  public float[] d()
  {
    if (this.af == null) {
      this.af = GPUBaseFilter.caculateCenterCropMvpMatrix(this.axt, this.axu, this.mSurfaceWidth, this.mSurfaceHeight);
    }
    return this.af;
  }
  
  public void doOnDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("doCallAEModulePostScreenRender mMaxDealTime:=").append(this.oR).append(",avgCosts:");
    if (this.oQ == 0L) {}
    for (float f = 0.0F;; f = (float)this.oP * 1.0F / (float)this.oQ)
    {
      QLog.i("VideoAfterTreatmentManager", 1, f);
      this.oQ = 0L;
      this.oR = 0L;
      this.b = null;
      this.RF = "";
      this.af = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdt
 * JD-Core Version:    0.7.0.1
 */