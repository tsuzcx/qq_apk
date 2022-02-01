import android.widget.Button;
import android.widget.PopupMenu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.b;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class akqx
{
  static final String TAG = adca.TAG + "_Res";
  private adby.a jdField_a_of_type_Adby$a;
  private akqx.a jdField_a_of_type_Akqx$a;
  private anhs.a jdField_a_of_type_Anhs$a;
  private ScanTorchActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity;
  long aee = 0L;
  private boolean cuk;
  private PromotionConfigInfo.a d;
  private AppInterface mApp;
  int[] mj = { 100, 100, 100, 100, 100 };
  
  public akqx(ScanTorchActivity paramScanTorchActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = paramScanTorchActivity;
  }
  
  private void a(String paramString, AppInterface paramAppInterface)
  {
    boolean bool1 = false;
    if (isDestroyed()) {
      QLog.w(TAG, 1, "checkEntryRes, scanTorchActivity为空");
    }
    boolean bool2;
    do
    {
      return;
      paramAppInterface = b();
      if (paramAppInterface == null)
      {
        QLog.w(TAG, 1, "checkEntryRes, promotion为空");
        return;
      }
      bool2 = this.jdField_a_of_type_Akqx$a.afj();
      if (this.mj[0] == 100) {
        bool1 = true;
      }
      QLog.w(TAG, 1, "checkEntryRes, from[" + paramString + "], isReadyShowEntry[" + bool2 + "], isEntryReady[" + bool1 + "], promotionItem[" + paramAppInterface + "]");
    } while ((!bool2) || (!bool1));
    this.jdField_a_of_type_Akqx$a.b(paramAppInterface);
  }
  
  private void a(String paramString, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (isDestroyed()) {
      QLog.w(TAG, 1, "checkAllRes, scanTorchActivity为空, from[" + paramString + "], notify[" + paramBoolean + "]");
    }
    do
    {
      return;
      paramAppInterface = b();
      if (paramAppInterface != null) {
        break;
      }
      QLog.w(TAG, 1, "checkAllRes, promotionItem为空, from[" + paramString + "], notify[" + paramBoolean + "]");
    } while (!paramBoolean);
    this.jdField_a_of_type_Akqx$a.a(paramAppInterface, false);
    return;
    cE("checkAllRes", true);
    if (isDownloading())
    {
      QLog.w(TAG, 1, "checkAllRes, 还在下载中, from[" + paramString + "], notify[" + paramBoolean + "]");
      return;
    }
    if (asE())
    {
      QLog.w(TAG, 1, "checkAllRes, 下载失败, from[" + paramString + "], notify[" + paramBoolean + "]");
      this.jdField_a_of_type_Akqx$a.a(paramAppInterface, false);
      return;
    }
    if (!this.jdField_a_of_type_Akqx$a.BJ())
    {
      QLog.w(TAG, 1, "checkAllRes, ArEngine未准备好, from[" + paramString + "], notify[" + paramBoolean + "]");
      return;
    }
    QLog.w(TAG, 1, "checkAllRes, all ready, from[" + paramString + "], notify[" + paramBoolean + "]");
    dCZ();
    this.jdField_a_of_type_Akqx$a.a(paramAppInterface, true);
  }
  
  private void b(AppInterface paramAppInterface, PromotionConfigInfo.a parama)
  {
    if ((parama != null) && ((!parama.bLh) || (parama.a() != null)))
    {
      this.d = parama;
      v(paramAppInterface);
      adca.a(paramAppInterface).d(paramAppInterface, parama.id);
      c(paramAppInterface, this.jdField_a_of_type_Akqx$a.afk());
      return;
    }
    a("onGetTransferDoorConfig", paramAppInterface, true);
  }
  
  private void c(AppInterface paramAppInterface, boolean paramBoolean)
  {
    boolean bool = l(paramAppInterface);
    if (this.mj[0] == 100) {
      a("tryDownload", paramAppInterface);
    }
    if (bool)
    {
      a("tryDownload", paramAppInterface, false);
      return;
    }
    this.cuk = paramBoolean;
    cE("tryDownload", true);
  }
  
  private void cE(String paramString, boolean paramBoolean)
  {
    if (isDestroyed()) {}
    do
    {
      return;
      if (this.aee == 0L)
      {
        this.aee = (System.currentTimeMillis() + 1500L);
        QLog.w(TAG, 1, "showDownloadProgress, 忽略1, from[" + paramString + "], progress[" + paramBoolean + "]");
        return;
      }
      if (this.aee > System.currentTimeMillis())
      {
        QLog.w(TAG, 1, "showDownloadProgress, 忽略2, from[" + paramString + "], progress[" + paramBoolean + "]");
        return;
      }
    } while ((!paramBoolean) || (!asF()));
    this.jdField_a_of_type_Akqx$a.eh("PromotionRes_" + paramString, 0);
  }
  
  private boolean isDestroyed()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.isDestroyed);
  }
  
  public void Nc(boolean paramBoolean)
  {
    this.cuk = paramBoolean;
  }
  
  public void a(akqx.a parama)
  {
    this.jdField_a_of_type_Akqx$a = parama;
  }
  
  public void a(AppInterface paramAppInterface, PopupMenu paramPopupMenu) {}
  
  public boolean asE()
  {
    if (isDownloading()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mj.length)
      {
        if (this.mj[i] < 0)
        {
          QLog.w(TAG, 1, "isDownloadError, index[" + i + "], errCode[" + this.mj[i] + "]");
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean asF()
  {
    return this.cuk;
  }
  
  public PromotionConfigInfo.a b()
  {
    return this.d;
  }
  
  void dCZ()
  {
    if (AudioHelper.jY(5) != 1) {}
    Button localButton;
    do
    {
      return;
      localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.findViewById(2131365637);
      localButton.setVisibility(0);
    } while (localButton.getTag() != null);
    localButton.setTag(new Object());
    localButton.setOnClickListener(new akrb(this));
  }
  
  public boolean isDownloading()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.mj.length)
      {
        if ((this.mj[i] >= 0) && (this.mj[i] <= 99))
        {
          QLog.w(TAG, 1, "isDownloading, index[" + i + "], Progress[" + this.mj[i] + "]");
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void j(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_Akqx$a.afk())
    {
      QLog.d(TAG, 1, "getRes,  需要显示穿越门进度条");
      this.cuk = true;
    }
    QLog.d(TAG, 1, "getRes, activityID[" + paramString + "], TotalProgress[" + sp() + "]");
    adca.a(paramAppInterface).a(paramAppInterface, new akqy(this, paramString, paramAppInterface));
  }
  
  public boolean l(AppInterface paramAppInterface)
  {
    Object localObject1 = b();
    if (localObject1 == null)
    {
      QLog.w(TAG, 1, "isResReady no promotion Item so reay");
      return true;
    }
    localObject1 = ((PromotionConfigInfo.a)localObject1).b();
    int i = ((TreeMap)localObject1).size();
    Object localObject2;
    if (i + 1 > this.mj.length)
    {
      localObject2 = "checkRes, zip数目不对, itemCount[" + i + "]";
      QLog.w(TAG, 1, (String)localObject2);
      if (AudioHelper.isDev()) {
        throw new IllegalStateException((String)localObject2);
      }
    }
    localObject1 = ((TreeMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PromotionConfigInfo.b)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (adby.a(paramAppInterface.getCurrentAccountUin(), (PromotionConfigInfo.b)localObject2)) {
        this.mj[localObject2.index] = 100;
      } else {
        this.mj[localObject2.index] = 0;
      }
    }
    if (anjg.axx())
    {
      this.mj[3] = 100;
      int j = sp();
      QLog.w(TAG, 1, "checkRes, itemCount[" + i + "], Progress0[" + this.mj[0] + "], Progress1[" + this.mj[1] + "], Progress2[" + this.mj[2] + "], Progress3[" + this.mj[3] + "], TotalProgress[" + j + "]");
      if (j != 100) {
        break label325;
      }
    }
    label325:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.mj[3] = 0;
      break;
    }
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public int sp()
  {
    int i = 0;
    int j = 0;
    while (i < this.mj.length)
    {
      j += this.mj[i];
      i += 1;
    }
    return j / this.mj.length;
  }
  
  public void t(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = null;
    if (this.jdField_a_of_type_Adby$a != null)
    {
      adca.a(paramAppInterface).b(this.jdField_a_of_type_Adby$a);
      this.jdField_a_of_type_Adby$a = null;
    }
    if (this.jdField_a_of_type_Anhs$a != null) {
      anhs.a().a(false, this.jdField_a_of_type_Anhs$a);
    }
    this.d = null;
  }
  
  public void u(AppInterface paramAppInterface)
  {
    PromotionConfigInfo.a locala = b();
    boolean bool2 = isDownloading();
    boolean bool1 = false;
    if (!bool2) {
      bool1 = asE();
    }
    QLog.w(TAG, 1, "reTry, promotionItem[" + locala + "], isDownloading[" + bool2 + "], isDownloadError[" + bool1 + "], needShowDownloadProgress[" + this.cuk + "], TotalProgress[" + sp() + "]");
    this.cuk = true;
    if (locala == null) {}
    while (bool2) {
      return;
    }
    adca.a(paramAppInterface).d(paramAppInterface, locala.id);
    c(paramAppInterface, this.jdField_a_of_type_Akqx$a.afk());
  }
  
  void v(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_Adby$a != null) {
      return;
    }
    this.jdField_a_of_type_Anhs$a = new akqz(this, paramAppInterface);
    anhs.a().a(true, this.jdField_a_of_type_Anhs$a);
    this.jdField_a_of_type_Adby$a = new akra(this, paramAppInterface);
    adca.a(paramAppInterface).a(this.jdField_a_of_type_Adby$a);
  }
  
  public void w(AppInterface paramAppInterface)
  {
    QLog.w(TAG, 1, "onAREngineReady");
    a("onAREngineReady", paramAppInterface, false);
  }
  
  public void x(AppInterface paramAppInterface)
  {
    a("onAREngineReady", paramAppInterface);
  }
  
  public static abstract interface a
  {
    public abstract boolean BJ();
    
    public abstract void a(PromotionConfigInfo.a parama, boolean paramBoolean);
    
    public abstract boolean afj();
    
    public abstract boolean afk();
    
    public abstract void b(PromotionConfigInfo.a parama);
    
    public abstract void bP(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void eh(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqx
 * JD-Core Version:    0.7.0.1
 */