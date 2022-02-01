import android.graphics.PointF;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.10;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.11;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.12;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.13;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.2;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.3;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.4;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.6;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.7;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.8;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.9;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class adbn
  implements adbi.a
{
  public static final String TAG = adbn.class.getSimpleName();
  private long RS;
  private adbi jdField_a_of_type_Adbi;
  private adbn.a jdField_a_of_type_Adbn$a;
  volatile adbo.a jdField_a_of_type_Adbo$a = null;
  private adbp jdField_a_of_type_Adbp;
  private adii jdField_a_of_type_Adii = new adii();
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  public ARScanEntryView b;
  private boolean bLd;
  private boolean bLe = true;
  private boolean bLf = true;
  private String brI = "";
  private String brJ;
  private String brK = "";
  public int cBM = 1;
  private volatile int cBN = -1;
  private int cBO;
  private int cBP = 15;
  public final int cBQ = 1;
  public final int cBR = 2;
  public final int cBS = 3;
  public final int cBT = 4;
  public final int cBU = 5;
  public final int cBV = 6;
  public WeakReference<adku> gl;
  private RelativeLayout jE;
  private AppInterface mApp;
  MqqHandler mUIHandler;
  
  public int Bu()
  {
    return this.cBN;
  }
  
  public int Bv()
  {
    if (this.jdField_a_of_type_Adbn$a != null) {
      return this.jdField_a_of_type_Adbn$a.Bv();
    }
    return 0;
  }
  
  public void FR(boolean paramBoolean)
  {
    adq();
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Adbn$a != null) && (this.cBM == 1)) {
        if (this.jdField_a_of_type_Adbn$a.ads())
        {
          Kx(6);
          this.jdField_a_of_type_Adbn$a.cPQ();
          this.cBN = -1;
        }
      }
      for (;;)
      {
        QLog.d(TAG, 2, "onPhonePoseChaned standBy SUCCESS with mode: " + this.cBM + "-mCurrentPoseStatus:" + this.cBN);
        return;
        this.cBN = 0;
        continue;
        if ((this.jdField_a_of_type_Adbn$a != null) && (this.cBM == 2))
        {
          Kx(2);
          this.cBN = 0;
        }
        else if (this.jdField_a_of_type_Adbn$a == null)
        {
          Kx(2);
          this.cBN = 0;
        }
      }
    }
    if ((this.jdField_a_of_type_Adbn$a != null) && (this.jdField_a_of_type_Adbn$a.ads()) && (this.cBM == 1)) {
      Kx(1);
    }
    for (;;)
    {
      this.cBN = 1;
      QLog.d(TAG, 2, "onPhonePoseChaned standBy FAIL with mode: " + this.cBM + "-mCurrentPoseStatus:" + this.cBN);
      return;
      if (this.cBM == 2) {
        Kx(1);
      }
    }
  }
  
  public void FT(boolean paramBoolean)
  {
    if (this.mUIHandler != null) {
      this.mUIHandler.post(new ARTransferDoorLogicManager.5(this, paramBoolean));
    }
  }
  
  public void K(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i(TAG, 1, "setRecogRes");
    if (this.jdField_a_of_type_Adbn$a != null)
    {
      this.jdField_a_of_type_Adbn$a.K(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    QLog.i(TAG, 1, "setRecogRes failed.");
  }
  
  public void Kv(int paramInt)
  {
    this.cBM = paramInt;
    QLog.d(TAG, 2, "setGamePlayMode mode " + paramInt);
  }
  
  public void Kw(int paramInt)
  {
    boolean bool = true;
    QLog.d(TAG, 2, "switchGameStatus " + paramInt);
    if (this.jdField_a_of_type_Adbn$a != null)
    {
      this.jdField_a_of_type_Adbn$a.gN(paramInt);
      return;
    }
    String str = TAG;
    if ("switchGameStatus " + paramInt + "|" + this.jdField_a_of_type_Adbn$a != null) {}
    for (;;)
    {
      QLog.d(str, 2, new Object[] { Boolean.valueOf(bool) });
      return;
      bool = false;
    }
  }
  
  public void Kx(int paramInt)
  {
    QLog.d(TAG, 2, "OnARTransferStatusChanged status changeTo " + paramInt);
    if ((this.mUIHandler == null) || (this.b == null) || ((this.b != null) && (!this.b.aff()))) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mUIHandler.post(new ARTransferDoorLogicManager.8(this));
      return;
    case 2: 
      this.mUIHandler.post(new ARTransferDoorLogicManager.9(this));
      return;
    case 3: 
      this.mUIHandler.post(new ARTransferDoorLogicManager.10(this));
      return;
    case 4: 
      this.mUIHandler.post(new ARTransferDoorLogicManager.11(this));
      return;
    case 5: 
      this.mUIHandler.post(new ARTransferDoorLogicManager.12(this));
      return;
    }
    this.mUIHandler.post(new ARTransferDoorLogicManager.13(this));
  }
  
  public void a(adbn.a parama)
  {
    if (parama != null)
    {
      this.jdField_a_of_type_Adbn$a = parama;
      if (this.jE != null) {
        this.jdField_a_of_type_Adbn$a.gp(this.jE);
      }
      this.brJ = this.jdField_a_of_type_Adbn$a.sg();
      if (!this.jdField_a_of_type_Adbn$a.adt()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 2)
    {
      this.cBM = i;
      this.brK = this.jdField_a_of_type_Adbn$a.sf();
      return;
    }
  }
  
  public void a(adii paramadii, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d(TAG, 2, "processInternalGestureRecogResult");
    if (!adq()) {
      QLog.d(TAG, 2, "processInternalGestureRecogResult into Error status");
    }
    this.jdField_a_of_type_Adii = paramadii;
    int i = 1;
    if (this.RS > 0L) {
      i = 0;
    }
    int j;
    boolean bool;
    if ((this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGw == 0) && (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv > 0))
    {
      cPO();
      if (i != 0)
      {
        Kx(4);
        QLog.d(TAG, 2, "processInternalGestureRecogResult start draw circle");
      }
      paramadii = ARLocalGestureCircleRecog.a(paramInt1, paramInt2, paramInt3, paramInt4, new PointF(this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.a.x, this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.a.y));
      j = (int)(this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.a.r / paramInt2 * paramInt3);
      int k = (int)paramadii.x;
      int m = (int)paramadii.y;
      if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.a.bNu)
      {
        i = 1;
        K(j, k, m, i);
        Kw(1);
        adcl.a().KA(6);
        this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGz = 0;
      }
    }
    else
    {
      if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv <= this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGw) {
        break label550;
      }
      j = 0;
      if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$c.mode != 1) {
        break label481;
      }
      if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGw != 0) {
        break label460;
      }
      i = 0;
      j = 1;
      bool = true;
    }
    for (;;)
    {
      label294:
      if (j != 0)
      {
        if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$c.mode != 1) {
          break label782;
        }
        paramadii = new int[this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv - i];
        int[] arrayOfInt1 = new int[this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv - i];
        int[] arrayOfInt2 = new int[this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv - i];
        paramInt2 = i;
        for (;;)
        {
          if (paramInt2 < this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv)
          {
            PointF localPointF = ARLocalGestureCircleRecog.a(paramInt1, paramInt1, paramInt3, paramInt4, this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.b[paramInt2]);
            paramadii[(paramInt2 - i)] = ((int)localPointF.x);
            arrayOfInt1[(paramInt2 - i)] = ((int)localPointF.y);
            arrayOfInt2[(paramInt2 - i)] = this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.kw[paramInt2];
            paramInt2 += 1;
            continue;
            i = -1;
            break;
            label460:
            i = this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGw;
            j = 1;
            bool = false;
            break label294;
            label481:
            if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv >= 1) {
              j = 1;
            }
            if (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGw < 1)
            {
              bool = true;
              i = 0;
              break label294;
            }
            bool = false;
            i = this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGw;
            break label294;
          }
        }
        a(paramadii, arrayOfInt1, arrayOfInt2, bool);
      }
    }
    for (;;)
    {
      label550:
      if ((this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.state == -1) && (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.lastState != -1) && (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGv > 0))
      {
        this.bLf = true;
        cPM();
        Kx(3);
        this.RS = System.currentTimeMillis();
        if ((this.gl != null) && (this.gl.get() != null)) {
          ((adku)this.gl.get()).g(new ARTransferDoorLogicManager.2(this), 1000L);
        }
      }
      QLog.i(TAG, 1, "zoomOutWorldCupSparks curent state " + this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.state);
      if ((this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.state == 0) && (this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.lastState != 0))
      {
        Kx(5);
        Kw(2);
        ThreadManager.getSubThreadHandler().post(new ARTransferDoorLogicManager.3(this));
        if ((this.gl != null) && (this.gl.get() != null)) {
          ((adku)this.gl.get()).g(new ARTransferDoorLogicManager.4(this), 1500L);
        }
      }
      return;
      label782:
      this.cBO = 0;
      if (this.bLf)
      {
        this.bLf = false;
        paramadii = new ARTransferDoorLogicManager.1(this, paramInt1, paramInt2, paramInt3, paramInt4);
        QLog.i(TAG, 1, "DrawCircle. resume. mDrawCirclePuase = " + this.bLf + ", genIdx = " + this.jdField_a_of_type_Adii.jdField_a_of_type_Adii$b.cGz);
        if ((this.gl != null) && (this.gl.get() != null) && (!this.bLf)) {
          ((adku)this.gl.get()).g(paramadii, this.cBP);
        }
      }
    }
  }
  
  public void a(adku paramadku)
  {
    this.gl = new WeakReference(paramadku);
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity, RelativeLayout paramRelativeLayout)
  {
    this.mApp = paramAppInterface;
    this.jE = paramRelativeLayout;
    this.mUIHandler = ThreadManager.getUIHandler();
    this.jdField_a_of_type_Adbi = new adbi(paramScanTorchActivity);
    this.jdField_a_of_type_Adbi.a(this);
    if ((this.jdField_a_of_type_Adbn$a != null) && (paramRelativeLayout != null))
    {
      QLog.d(TAG, 2, "init " + paramRelativeLayout.getChildCount());
      this.jdField_a_of_type_Adbn$a.gp(this.jE);
      this.jdField_a_of_type_Adbp = new adbp(paramScanTorchActivity);
      return;
    }
    paramAppInterface = TAG;
    paramRelativeLayout = new StringBuilder().append("init ");
    if (this.jdField_a_of_type_Adbn$a != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d(paramAppInterface, 2, bool);
      break;
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.d(TAG, 2, "startRenderTransferGame config " + paramArCloudConfigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
    }
    ArCloudConfigInfo localArCloudConfigInfo = paramArCloudConfigInfo;
    if (paramArCloudConfigInfo == null)
    {
      localArCloudConfigInfo = paramArCloudConfigInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)
      {
        localArCloudConfigInfo = paramArCloudConfigInfo;
        if (adp()) {
          localArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        }
      }
    }
    if ((this.gl != null) && (this.gl.get() != null)) {
      ((adku)this.gl.get()).a(4096L, localArCloudConfigInfo);
    }
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    QLog.i(TAG, 1, "insertWorldCupSpark start.");
    if ((this.jdField_a_of_type_Adbn$a != null) && (this.jdField_a_of_type_Adbn$a.adr()))
    {
      this.jdField_a_of_type_Adbn$a.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramBoolean);
      return;
    }
    QLog.i(TAG, 1, "insertWorldCupSpark failed.");
  }
  
  public boolean adp()
  {
    return this.cBM == 2;
  }
  
  public boolean adq()
  {
    if (this.jdField_a_of_type_Adbn$a == null) {}
    int i;
    do
    {
      return true;
      i = Bv();
    } while ((i == 0) || (i == 1));
    return false;
  }
  
  public void ay(boolean paramBoolean, String paramString)
  {
    QLog.d(TAG, 2, "updateUITipsMessage " + paramBoolean + ";" + paramString);
    if ((this.bLd == paramBoolean) && (this.brI.equalsIgnoreCase(paramString))) {
      return;
    }
    this.bLd = paramBoolean;
    this.brI = paramString;
    if (this.bLd)
    {
      this.mUIHandler.post(new ARTransferDoorLogicManager.6(this, paramString));
      return;
    }
    this.mUIHandler.post(new ARTransferDoorLogicManager.7(this));
  }
  
  public void cPK()
  {
    if (this.jdField_a_of_type_Adbp != null) {
      this.jdField_a_of_type_Adbp.y(this.jE);
    }
    this.jdField_a_of_type_Adbn$a = null;
    cPO();
    this.cBN = -1;
  }
  
  public void cPL()
  {
    QLog.d(TAG, 2, "notifyEnterIntoTransferDoorStatus");
    if ((this.gl != null) && (this.gl.get() != null)) {
      ((adku)this.gl.get()).Lg(1);
    }
  }
  
  public void cPM()
  {
    this.RS = 0L;
    this.bLf = true;
    this.cBO = 0;
    this.cBP = 15;
  }
  
  public void cPN()
  {
    QLog.d(TAG, 2, "startPhonePoseDetect");
    this.jdField_a_of_type_Adbi.cPF();
    this.cBN = -1;
  }
  
  public void cPO()
  {
    QLog.d(TAG, 2, "stopPhonePoseDetect");
    this.jdField_a_of_type_Adbi.cPG();
  }
  
  public void cPP()
  {
    QLog.i(TAG, 1, "zoomOutWorldCupSparks .");
    if (this.jdField_a_of_type_Adbn$a != null)
    {
      this.jdField_a_of_type_Adbn$a.cPP();
      return;
    }
    QLog.i(TAG, 1, "zoomOutWorldCupSparks failed.");
  }
  
  public void doOnPause()
  {
    QLog.d(TAG, 2, "doOnPause");
    if (this.jdField_a_of_type_Adbn$a == null)
    {
      QLog.d(TAG, 2, "doOnPause but do nothing here");
      return;
    }
    if (this.jdField_a_of_type_Adbp != null) {
      this.jdField_a_of_type_Adbp.y(this.jE);
    }
    this.jE.setVisibility(8);
    Kx(6);
    cPO();
    this.cBN = -1;
  }
  
  public void doOnResume()
  {
    QLog.d(TAG, 2, "doOnResume");
    if (this.cBM == 1) {}
  }
  
  public void uninit()
  {
    QLog.d(TAG, 2, "ARWorldGC ARWorldCupGameLogicManager uninit");
    this.jdField_a_of_type_Adbn$a = null;
    if (this.jE != null)
    {
      this.jE.setOnTouchListener(null);
      this.jE = null;
    }
    this.b = null;
    this.mApp = null;
    this.jdField_a_of_type_Adbo$a = null;
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Adbp = null;
    if (this.jdField_a_of_type_Adbi != null)
    {
      this.jdField_a_of_type_Adbi.cPG();
      this.jdField_a_of_type_Adbi = null;
    }
    this.cBN = -1;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public static abstract interface a
  {
    public abstract int Bv();
    
    public abstract void K(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean);
    
    public abstract boolean adr();
    
    public abstract boolean ads();
    
    public abstract boolean adt();
    
    public abstract void cPP();
    
    public abstract void cPQ();
    
    public abstract int gN(int paramInt);
    
    public abstract void gp(View paramView);
    
    public abstract String sf();
    
    public abstract String sg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbn
 * JD-Core Version:    0.7.0.1
 */