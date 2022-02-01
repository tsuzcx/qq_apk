import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.1;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.10;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.2;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.3;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.5;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.8;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class adgy
{
  private static final Object cV = new Object();
  private static boolean loadSoSuccess;
  private static boolean soLoaded;
  int EP;
  private HandlerThread H;
  long SQ;
  long SR;
  long SS;
  long ST;
  long SU;
  long SV;
  long SW;
  long SX = 0L;
  private long SY;
  private long SZ;
  private long Ta;
  private adgy.a jdField_a_of_type_Adgy$a;
  public adhe a;
  adhm jdField_a_of_type_Adhm;
  private adhr jdField_a_of_type_Adhr;
  adgp jdField_b_of_type_Adgp;
  public ARCommonConfigInfo b;
  ArLBSActivity jdField_b_of_type_ComTencentMobileqqArModelArLBSActivity;
  private boolean bMX = true;
  private volatile boolean bMY;
  private boolean bMZ = true;
  private boolean bNa;
  private boolean bNb;
  private boolean bNc;
  private boolean bNd;
  private boolean bNe = true;
  private boolean bNf;
  String bsO;
  private Handler cE;
  int cFB = 10000;
  int cFC;
  int cFD;
  private byte[] df;
  public SosoInterface.a g = new adhc(this, 0, true, true, 3000L, true, false, "QQARScan");
  private boolean isTimeOut = true;
  Activity mActivity;
  AppInterface mAppInterface;
  long mEndTime;
  int mFormat;
  int mHeight;
  private boolean mIsPause;
  int mLatitude;
  int mLongitude;
  int mResult = -1;
  public long mStartTime;
  long mUploadTime;
  int mWidth;
  private ArrayList<String> uq;
  
  private void a(int paramInt, adhr paramadhr)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation.");
    this.jdField_a_of_type_Adhr = paramadhr;
    if (this.cE != null)
    {
      if (this.cE.hasMessages(2)) {
        this.cE.removeMessages(2);
      }
      Message localMessage = Message.obtain(this.cE, new ARCloudControl.8(this));
      localMessage.what = 2;
      this.cE.sendMessageDelayed(localMessage, this.cFB);
    }
    this.jdField_b_of_type_ComTencentMobileqqArModelArLBSActivity = adhr.a(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramadhr);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (((BaseActivity)this.mActivity).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. not grant");
        ((BaseActivity)this.mActivity).requestPermissions(new adhd(this), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. grant");
      grant();
      return;
    }
    SosoInterface.a(this.g);
  }
  
  private void a(adhv paramadhv)
  {
    QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] requestToUploadImg. : ");
    long l = System.currentTimeMillis();
    if (this.jdField_b_of_type_Adgp != null)
    {
      this.isTimeOut = true;
      this.cFC += 1;
    }
    synchronized (cV)
    {
      if (this.cE != null)
      {
        if (this.cE.hasMessages(1)) {
          this.cE.removeMessages(1);
        }
        Message localMessage = Message.obtain(this.cE, new ARCloudControl.5(this));
        localMessage.what = 1;
        this.cE.sendMessageDelayed(localMessage, this.cFB);
      }
      this.jdField_b_of_type_Adgp.a(paramadhv, new adhb(this, l, paramadhv));
      return;
    }
  }
  
  private void aV(byte[] paramArrayOfByte)
  {
    QLog.i("AREngine_ARCloudControl", 1, "saveTmpPreviewData should nerver be called ");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((this.df == null) || (this.df.length != paramArrayOfByte.length)) {
        this.df = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.df, 0, paramArrayOfByte.length);
      this.bNf = true;
      if (this.Ta <= 0L) {
        this.Ta = System.currentTimeMillis();
      }
    }
  }
  
  private void aa(Runnable paramRunnable)
  {
    f(paramRunnable, 0L);
  }
  
  private void ak(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocationInternal.");
    System.currentTimeMillis();
    if (this.jdField_b_of_type_Adgp != null)
    {
      this.bNe = true;
      if (this.cE != null)
      {
        if (this.cE.hasMessages(2)) {
          this.cE.removeMessages(2);
        }
        Message localMessage = Message.obtain(this.cE, new ARCloudControl.10(this));
        localMessage.what = 2;
        this.cE.sendMessageDelayed(localMessage, this.cFB);
      }
      this.jdField_b_of_type_Adgp.a(paramString, paramInt1, paramInt2, new adgz(this));
    }
  }
  
  private void b(byte[] paramArrayOfByte, ArrayList<ARRecognition> paramArrayList)
  {
    if (this.jdField_a_of_type_Adhm != null)
    {
      adhv localadhv = new adhv();
      this.jdField_a_of_type_Adhm.a(paramArrayOfByte, paramArrayList, new adha(this, localadhv), this.mWidth, this.mHeight, this.mFormat);
    }
  }
  
  private void cRG()
  {
    QLog.i("AREngine_ARCloudControl", 1, "startUploadThread.");
    synchronized (cV)
    {
      if (this.H == null)
      {
        this.H = ThreadManager.newFreeHandlerThread("ARCloudEnginePreprocessThread", 0);
        this.H.start();
        this.cE = new Handler(this.H.getLooper());
      }
      return;
    }
  }
  
  private void cRH()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stopUploadThread.");
    synchronized (cV)
    {
      if (this.cE != null) {
        this.cE.removeCallbacksAndMessages(null);
      }
      this.cE = null;
      if (this.H != null)
      {
        this.H.quit();
        this.H.interrupt();
      }
      this.H = null;
      return;
    }
  }
  
  private void cRI()
  {
    this.df = null;
    this.bNf = false;
    this.Ta = 0L;
  }
  
  private void cRJ()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stopUploadingImg.");
    if (this.jdField_b_of_type_Adgp != null) {
      this.jdField_b_of_type_Adgp.BC();
    }
  }
  
  private void f(Runnable paramRunnable, long paramLong)
  {
    synchronized (cV)
    {
      if (this.cE != null) {
        this.cE.postDelayed(paramRunnable, paramLong);
      }
      return;
    }
  }
  
  public static boolean loadNativeLibrary()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudControl", 2, "loadNativeLibrary" + soLoaded + ", loadSoSuccess=" + loadSoSuccess);
        }
        if (soLoaded)
        {
          bool = loadSoSuccess;
          return bool;
        }
        if (adee.kQ(adee.sk()))
        {
          soLoaded = true;
          try
          {
            if (adee.cF(adee.sk()) != 0) {
              break label167;
            }
            loadSoSuccess = bool;
          }
          catch (Throwable localThrowable)
          {
            loadSoSuccess = false;
            QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. err msg = " + localThrowable.getMessage());
            continue;
          }
          QLog.d("AREngine_ARCloudControl", 1, "loadArNativeSo");
          bool = loadSoSuccess;
          continue;
        }
        QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. ARCloud so is not exist!");
      }
      finally {}
      bool = loadSoSuccess;
      continue;
      label167:
      bool = false;
    }
  }
  
  public static void loadSo()
  {
    Object localObject2 = BaseApplicationImpl.sApplication;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject1 = ((Context)localObject2).getApplicationInfo().nativeLibraryDir + "/";
      localObject1 = (String)localObject1 + "libARCloud.so";
      localObject2 = ((Context)localObject2).getFilesDir() + "libARCloud.so";
      if (!new File((String)localObject1).exists()) {
        break label179;
      }
    }
    for (;;)
    {
      if (!((String)localObject1).equals(""))
      {
        try
        {
          System.load((String)localObject1);
          QLog.i("AREngine_ARCloudControl", 1, "load " + (String)localObject1 + " successfully!");
          loadSoSuccess = true;
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          label179:
          QLog.i("AREngine_ARCloudControl", 1, "load " + (String)localObject1 + " failed! " + localUnsatisfiedLinkError.getMessage());
        }
        localObject1 = ((Context)localObject2).getApplicationInfo().dataDir + "/lib/";
        break;
        if (!new File((String)localObject2).exists()) {
          break label258;
        }
        localObject1 = localObject2;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("AREngine_ARCloudControl", 2, "loadSo suc");
      }
      loadSoSuccess = false;
      return;
      label258:
      localObject1 = "";
    }
  }
  
  public void Gd(boolean paramBoolean)
  {
    this.bMX = paramBoolean;
  }
  
  public void Ge(boolean paramBoolean)
  {
    this.bMY = paramBoolean;
  }
  
  public boolean a(adgy.a parama, AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, ARCommonConfigInfo paramARCommonConfigInfo)
  {
    long l2 = System.currentTimeMillis();
    loadSoSuccess = loadNativeLibrary();
    adix.a().aq(System.currentTimeMillis() - l2, loadSoSuccess);
    if (!loadSoSuccess) {
      return false;
    }
    this.jdField_a_of_type_Adhe = new adhe(adhe.cFF);
    this.jdField_a_of_type_Adhm = new adhm();
    this.jdField_a_of_type_Adhe.init(BaseApplicationImpl.getContext().getApplicationContext());
    this.jdField_a_of_type_Adhm.init();
    this.mAppInterface = paramAppInterface;
    this.mActivity = paramActivity;
    this.mLatitude = paramInt1;
    this.mLongitude = paramInt2;
    this.EP = paramInt3;
    this.jdField_a_of_type_Adgy$a = parama;
    this.jdField_b_of_type_Adgp = new adgp(paramAppInterface, true);
    this.jdField_b_of_type_Adgp.preConnect();
    this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {}
    for (long l1 = ARRecognition.c(this.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions);; l1 = 0L)
    {
      this.SQ = l1;
      this.bMZ = true;
      if (this.uq == null) {
        this.uq = new ArrayList();
      }
      this.uq.clear();
      adix.a().ar(System.currentTimeMillis() - l2, loadSoSuccess);
      return true;
    }
  }
  
  public void aL(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mFormat = paramInt3;
  }
  
  public void aW(byte[] paramArrayOfByte)
  {
    if (this.SX == 0L) {
      this.SX = System.currentTimeMillis();
    }
    long l;
    if ((this.bMY) && (this.jdField_a_of_type_Adhe != null))
    {
      l = System.currentTimeMillis();
      bool1 = this.jdField_a_of_type_Adhe.j(paramArrayOfByte);
      this.bMY = false;
      this.jdField_a_of_type_Adgy$a.Gh(bool1);
      QLog.i("AREngine_ARCloudControl", 1, "isSameSceneWithBestImg = " + bool1 + " cost time:" + (System.currentTimeMillis() - l) + "ms");
    }
    if ((!this.bMX) || (this.jdField_a_of_type_Adhe == null)) {
      return;
    }
    if (this.bMZ)
    {
      QLog.i("AREngine_ARCloudControl", 1, "selectImage start");
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "firstTimeStart" }));
      this.bMZ = false;
      if (this.SY == 0L) {
        this.SY = System.currentTimeMillis();
      }
      if (this.bNd) {
        ThreadManager.getUIHandler().post(new ARCloudControl.1(this));
      }
    }
    if (this.jdField_a_of_type_Adgy$a != null) {
      this.jdField_a_of_type_Adgy$a.cRM();
    }
    this.SR = System.currentTimeMillis();
    boolean bool1 = this.jdField_a_of_type_Adhe.c(paramArrayOfByte, this.mWidth, this.mHeight);
    if ((bool1) && (this.SZ == 0L)) {
      this.SZ = System.currentTimeMillis();
    }
    int i;
    if (this.jdField_a_of_type_Adgy$a != null)
    {
      boolean bool2 = this.jdField_a_of_type_Adgy$a.aes();
      l = this.jdField_a_of_type_Adgy$a.fo();
      if ((bool1) && (!this.bNf) && (bool2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudControl", 2, "selectImage save tmp preview data");
        }
        aV(paramArrayOfByte);
        i = 0;
        bool1 = false;
        this.jdField_a_of_type_Adgy$a.Gf(bool1);
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        this.bMX = true;
        return;
        if ((bool1) && (this.bNf) && (System.currentTimeMillis() < this.Ta + l))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudControl", 2, "selectImage update tmp preview data");
          }
          aV(paramArrayOfByte);
          i = 0;
          bool1 = false;
          break;
        }
        if ((bool1) || (!this.bNf) || (System.currentTimeMillis() < l + this.Ta)) {
          break label675;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudControl", 2, "selectImage use tmp preview data");
        }
        paramArrayOfByte = this.df;
        cRI();
        i = 1;
        bool1 = true;
        break;
      }
      this.SS = System.currentTimeMillis();
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.mStartTime) }) + ":select result is " + bool1);
      this.ST = (System.currentTimeMillis() - this.SX);
      this.bMX = false;
      if (this.bNd) {
        ThreadManager.getUIHandler().post(new ARCloudControl.2(this));
      }
      if (i != 0) {}
      for (;;)
      {
        if (this.jdField_a_of_type_Adgy$a != null) {
          this.jdField_a_of_type_Adgy$a.Gg(true);
        }
        if ((!this.bNa) && (this.jdField_a_of_type_Adgy$a != null))
        {
          l = this.jdField_a_of_type_Adgy$a.fp();
          adfx.a().d(l, this.SY, this.SZ, this.jdField_a_of_type_Adhe.cFO);
          adap.a().ah(l, this.SZ);
          this.bNa = true;
        }
        aa(new ARCloudControl.3(this, paramArrayOfByte));
        return;
        paramArrayOfByte = this.jdField_a_of_type_Adhe.T();
      }
      label675:
      i = 0;
      break;
      i = 0;
    }
  }
  
  public ArrayList<String> cL()
  {
    return this.uq;
  }
  
  public void cRK()
  {
    this.mStartTime = 0L;
    this.mEndTime = 0L;
    this.ST = 0L;
    this.cFC = 0;
    this.mUploadTime = 0L;
    this.SU = 0L;
    this.SV = 0L;
    this.bsO = null;
    this.cFD = 0;
    this.mResult = -1;
    this.SR = 0L;
    this.SS = 0L;
    this.SX = 0L;
  }
  
  public void cRL()
  {
    QLog.d("AREngine_ARCloudControl", 2, "arCloudReport mResult:" + this.mResult);
    adix.a().a(this.ST, this.mUploadTime, this.SU, this.cFC, this.bsO, this.cFD, this.SV, this.SW, this.mEndTime - this.mStartTime, this.mResult);
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user denied = ");
    this.jdField_a_of_type_Adhr = null;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user grant = ");
    SosoInterface.a(this.g);
  }
  
  public void pause()
  {
    if (this.mIsPause) {
      return;
    }
    this.mEndTime = System.currentTimeMillis();
    cRL();
    this.mIsPause = true;
    this.bMX = false;
    cRH();
    cRJ();
  }
  
  public void resume()
  {
    if (!this.mIsPause) {
      return;
    }
    cRK();
    this.mStartTime = System.currentTimeMillis();
    this.bMX = true;
    QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "resume" }));
    this.bMZ = true;
    this.mIsPause = false;
    cRG();
    cRI();
  }
  
  public void start()
  {
    this.bMX = true;
    this.bMZ = true;
    this.mIsPause = false;
    this.mStartTime = System.currentTimeMillis();
    cRG();
    cRI();
  }
  
  public void stop()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stop.");
    this.mIsPause = true;
    this.bMX = false;
    cRH();
    cRJ();
  }
  
  public void uninit()
  {
    QLog.i("AREngine_ARCloudControl", 1, "uninit");
    if (this.jdField_a_of_type_Adhe != null)
    {
      this.jdField_a_of_type_Adhe.uninit();
      this.jdField_a_of_type_Adhe = null;
    }
    if (this.jdField_a_of_type_Adhm != null)
    {
      this.jdField_a_of_type_Adhm.uninit();
      this.jdField_a_of_type_Adhm = null;
    }
    this.jdField_a_of_type_Adgy$a = null;
    if ((this.uq != null) && (!this.uq.isEmpty())) {
      this.uq.clear();
    }
    this.uq = null;
    this.jdField_a_of_type_Adhr = null;
    if (this.jdField_b_of_type_Adgp != null) {
      this.jdField_b_of_type_Adgp.destroy();
    }
    this.mActivity = null;
  }
  
  public static abstract interface a
  {
    public abstract void Gf(boolean paramBoolean);
    
    public abstract void Gg(boolean paramBoolean);
    
    public abstract void Gh(boolean paramBoolean);
    
    public abstract boolean a(adin paramadin);
    
    public abstract boolean aes();
    
    public abstract void b(int paramInt, adhr paramadhr);
    
    public abstract void cRM();
    
    public abstract void cRN();
    
    public abstract long fo();
    
    public abstract long fp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgy
 * JD-Core Version:    0.7.0.1
 */