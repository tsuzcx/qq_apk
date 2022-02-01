import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.1;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.2;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;

public class aywa
  implements aytr.c
{
  private static aywa jdField_a_of_type_Aywa;
  private aywa.b jdField_a_of_type_Aywa$b;
  private INetInfoHandler b = new aywb(this);
  private boolean bAp = true;
  private boolean bAq;
  private SparseArray<aywa.a> bS = new SparseArray(1);
  private int clu = 2;
  private PtvTemplateManager.PtvTemplateInfo g;
  private AppInterface mApp;
  private Handler mUIHandler;
  
  private aywa(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      throw new RuntimeException("new LbsFilterStatusManager app==null");
    }
    this.mApp = paramAppInterface;
    this.mUIHandler = ThreadManager.getUIHandlerV2();
    this.bS.put(1, aywa.a.a());
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.b);
  }
  
  private void GC(int paramInt)
  {
    String str = this.g.getLbsActivityType(paramInt);
    log("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.g.name, str }), null);
    if ((this.g.usable) && (hI(this.g.activityType)) && (this.g.activityType == paramInt))
    {
      boolean bool = hJ(paramInt);
      log("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { "" + bool }), null);
      if ((this.jdField_a_of_type_Aywa$b != null) && (bool))
      {
        log("sendLoadingFilterMsg", "refreshed filterName=" + this.g.name, null);
        this.jdField_a_of_type_Aywa$b.AN(this.g.name);
      }
    }
  }
  
  public static aywa a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_Aywa == null)
      {
        jdField_a_of_type_Aywa = new aywa(paramAppInterface);
        aytr.a(paramAppInterface).a(jdField_a_of_type_Aywa);
      }
      paramAppInterface = jdField_a_of_type_Aywa;
      return paramAppInterface;
    }
    finally {}
  }
  
  private void bf(int paramInt, boolean paramBoolean)
  {
    aywa.a locala = (aywa.a)this.bS.get(paramInt);
    if (locala != null)
    {
      log("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.g.getLbsActivityType(paramInt) }), null);
      if (locala.clw == 3) {
        break label98;
      }
      locala.bAs = paramBoolean;
      if (paramBoolean) {
        locala.clw = 2;
      }
    }
    else
    {
      return;
    }
    locala.clw = 3;
    GC(paramInt);
    return;
    label98:
    log("processLocationPermission", String.format("[Error]Status=%s", new Object[] { locala.qJ() }), null);
    locala.bAs = paramBoolean;
    locala.sn.clear();
    locala.a.sn.clear();
    GC(paramInt);
  }
  
  private String cZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "LBS_FILTER_UNINIT_KIND";
    case 1: 
      return "LBS_FILTER_LOADING_KIND";
    case 2: 
      return "LBS_FILTER_NOMAL_KIND";
    }
    return "LBS_FILTER_SPECIAL_KIND";
  }
  
  private void czo()
  {
    aywa.a locala = (aywa.a)this.bS.get(this.g.activityType);
    log("startLocationUsingActivity", String.format("activityType=%s", new Object[] { this.g.getLbsActivityType(this.g.activityType) }), null);
    if ((locala == null) || (!this.bAp)) {}
    do
    {
      return;
      log("startLocationUsingActivity", String.format("mRequestStatus=%s", new Object[] { locala.qJ() }), null);
    } while (locala.clw != 3);
    log("startLocationUsingActivity", String.format("mRequestBeginTime=%s", new Object[] { "" + locala.ML }), null);
    if (locala.ML > 0L)
    {
      long l = System.currentTimeMillis() - locala.ML;
      log("startLocationUsingActivity", String.format("diffTime=%s", new Object[] { "" + l }), null);
      if (l >= 30000L) {}
    }
    for (boolean bool = false;; bool = true)
    {
      log("startLocationUsingActivity", String.format("timeOK=%s", new Object[] { "" + bool }), null);
      if (!bool) {
        break;
      }
      locala.czv();
      locala.czu();
      locala.clw = 1;
      locala.ML = System.currentTimeMillis();
      aytr.a(this.mApp).Gh(this.g.activityType);
      return;
    }
  }
  
  private void czr()
  {
    this.bAq = false;
    AppNetConnInfo.unregisterNetInfoHandler(this.b);
  }
  
  private void czs()
  {
    if (this.g != null)
    {
      log("processMobile2WifiNet", String.format("activityType=%s", new Object[] { this.g.getLbsActivityType(this.g.activityType) }), null);
      if (!this.bAq) {
        czo();
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    aywa.a locala = (aywa.a)this.bS.get(paramInt);
    if (locala != null)
    {
      log("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.g.getLbsActivityType(paramInt) }), null);
      if (locala.clw != 3)
      {
        if (paramBoolean)
        {
          locala.sn.addAll(paramArrayList);
          log("processLocationForTemplate", String.format("templateIds= %s", new Object[] { paramArrayList.toString() }), null);
        }
        locala.clw = 3;
        GC(paramInt);
      }
    }
    else
    {
      return;
    }
    log("processLocationForTemplate", String.format("[Error]templateIds= %s,Status=%s", new Object[] { paramArrayList.toString(), locala.qJ() }), null);
  }
  
  public static void destroyInstance()
  {
    try
    {
      if (jdField_a_of_type_Aywa != null)
      {
        jdField_a_of_type_Aywa.czr();
        jdField_a_of_type_Aywa = null;
      }
      aytr.destroyInstance();
      return;
    }
    finally {}
  }
  
  private boolean hI(int paramInt)
  {
    return this.bS.get(paramInt) != null;
  }
  
  private boolean hJ(int paramInt)
  {
    aywa.a locala = (aywa.a)this.bS.get(paramInt);
    if ((locala.bAs) && (locala.iV(this.g.id))) {}
    for (paramInt = 3;; paramInt = 2)
    {
      log("filterNeedRefresh", String.format("newKindName=%s,currentKindName=%s", new Object[] { cZ(paramInt), cZ(this.clu) }), null);
      if (paramInt == this.clu) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void log(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i("LbsFilterStatusManager", 2, paramString1 + "_" + paramString2);
  }
  
  public void bb(int paramInt, boolean paramBoolean)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      bf(paramInt, paramBoolean);
      return;
    }
    this.mUIHandler.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void c(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Thread.currentThread().getId();
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.mUIHandler.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
  
  static class a
  {
    long ML = 0L;
    a a = null;
    boolean bAs = false;
    int clw = 3;
    ArrayList<String> sn = new ArrayList(1);
    
    static a a()
    {
      a locala = new a();
      locala.czt();
      return locala;
    }
    
    void czt()
    {
      if (this.a == null) {
        this.a = new a();
      }
    }
    
    void czu()
    {
      this.bAs = false;
      this.sn.clear();
      this.ML = 0L;
      this.clw = 3;
    }
    
    void czv()
    {
      this.a.bAs = this.bAs;
      this.a.sn.clear();
      this.a.sn.addAll(this.sn);
      this.a.clw = this.clw;
      this.a.ML = this.ML;
    }
    
    boolean iV(String paramString)
    {
      aywa.log("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.sn.toString() }), null);
      return this.sn.contains(paramString);
    }
    
    String qJ()
    {
      switch (this.clw)
      {
      default: 
        return "LBS_REQ_OK";
      case 1: 
        return "LBS_REQ_PENDING";
      }
      return "LBS_REQ_PERM_OK";
    }
  }
  
  public static abstract interface b
  {
    public abstract void AN(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywa
 * JD-Core Version:    0.7.0.1
 */