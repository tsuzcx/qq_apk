import android.os.Handler;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.1;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class aavi
  implements aaqo.c
{
  private static aavi jdField_a_of_type_Aavi;
  public static AppInterface f;
  private long MK;
  private aavi.b jdField_a_of_type_Aavi$b;
  private INetInfoHandler b = new aavj(this);
  private boolean bAp = true;
  private boolean bAq;
  private SparseArray<aavi.a> bS = new SparseArray(1);
  private int clu = 2;
  private PtvTemplateManager.PtvTemplateInfo e;
  private AppInterface mApp;
  private Handler mUIHandler;
  
  private aavi(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      throw new RuntimeException("new LbsFilterStatusManager app==null");
    }
    this.mApp = paramAppInterface;
    this.mUIHandler = new Handler();
    this.bS.put(1, aavi.a.a());
    this.MK = Thread.currentThread().getId();
    AppNetConnInfo.registerConnectionChangeReceiver(VideoEnvironment.getContext(), this.b);
  }
  
  private void AV(String paramString)
  {
    String str1 = this.e.name;
    int i = this.e.activityType;
    String str2 = this.e.getLbsActivityType(i);
    log("reportLbsSendData", String.format("[%s-%s]acitvityName=%s,White[%s]", new Object[] { paramString, str1, str2, "" + this.bAp }), null);
    if ((paramString == null) || (str1.equals(paramString)))
    {
      if ((aavi.a)this.bS.get(i) != null)
      {
        if (this.clu != 2) {
          break label121;
        }
        ef("", "0X8008139");
      }
      label121:
      while (this.clu != 3) {
        return;
      }
      ef("", "0X8008137");
      return;
    }
    log("reportLbsSendData", String.format("filterName=%s,currentName=%s [%s]", new Object[] { paramString, str1, str2 }), null);
  }
  
  private void GC(int paramInt)
  {
    String str = this.e.getLbsActivityType(paramInt);
    log("sendLoadingFilterMsg", String.format("[%s]acitvityName=%s", new Object[] { this.e.name, str }), null);
    if ((this.e.usable) && (hI(this.e.activityType)) && (this.e.activityType == paramInt))
    {
      boolean bool = hJ(paramInt);
      log("sendLoadingFilterMsg", String.format("needRefresh=%s", new Object[] { "" + bool }), null);
      if ((this.jdField_a_of_type_Aavi$b != null) && (bool))
      {
        log("sendLoadingFilterMsg", "refreshed filterName=" + this.e.name, null);
        this.jdField_a_of_type_Aavi$b.AN(this.e.name);
      }
    }
  }
  
  public static aavi a(AppInterface paramAppInterface)
  {
    try
    {
      if (jdField_a_of_type_Aavi == null)
      {
        AppInterface localAppInterface = paramAppInterface;
        if (paramAppInterface == null) {
          localAppInterface = f;
        }
        jdField_a_of_type_Aavi = new aavi(localAppInterface);
        aaqo.a(localAppInterface).a(jdField_a_of_type_Aavi);
      }
      paramAppInterface = jdField_a_of_type_Aavi;
      return paramAppInterface;
    }
    finally {}
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface).AV(paramString);
  }
  
  private void bf(int paramInt, boolean paramBoolean)
  {
    aavi.a locala = (aavi.a)this.bS.get(paramInt);
    if (locala != null)
    {
      log("processLocationPermission", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.e.getLbsActivityType(paramInt) }), null);
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
    aavi.a locala = (aavi.a)this.bS.get(this.e.activityType);
    log("startLocationUsingActivity", String.format("activityType=%s", new Object[] { this.e.getLbsActivityType(this.e.activityType) }), null);
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
      aaqo.a(this.mApp).Gh(this.e.activityType);
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
    if (this.e != null)
    {
      log("processMobile2WifiNet", String.format("activityType=%s", new Object[] { this.e.getLbsActivityType(this.e.activityType) }), null);
      if (!this.bAq) {
        czo();
      }
    }
  }
  
  private void d(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    aavi.a locala = (aavi.a)this.bS.get(paramInt);
    if (locala != null)
    {
      log("processLocationForTemplate", String.format("[%s]acitvityName=%s", new Object[] { "" + paramBoolean, this.e.getLbsActivityType(paramInt) }), null);
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
      if (jdField_a_of_type_Aavi != null)
      {
        jdField_a_of_type_Aavi.czr();
        jdField_a_of_type_Aavi = null;
      }
      aaqo.destroyInstance();
      return;
    }
    finally {}
  }
  
  public static long eN()
  {
    return -1L;
  }
  
  private static void ef(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!"".equals(paramString2))) {
      aaqi.ec(paramString1, paramString2);
    }
  }
  
  private boolean hI(int paramInt)
  {
    return this.bS.get(paramInt) != null;
  }
  
  private boolean hJ(int paramInt)
  {
    aavi.a locala = (aavi.a)this.bS.get(paramInt);
    if ((locala.bAs) && (locala.iV(this.e.id))) {}
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
  
  private String q(String paramString, boolean paramBoolean)
  {
    String str2 = "paramsspecial";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (new File(paramString, "paramsspecialback.json").exists()) {
        str1 = "paramsspecialback";
      }
    }
    if (new File(paramString, str1 + ".json").exists())
    {
      ef("", "0X8008136");
      this.clu = 3;
      return str1;
    }
    log("getLbsParamsFileName", String.format("LBS_FILTER_SPECIAL not eixst", new Object[0]), null);
    return null;
  }
  
  public static String qI()
  {
    return acfp.m(2131707635);
  }
  
  public String a(String paramString, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int j = 1;
    log("getLbsParamsFileName", "filerPath=" + paramString, null);
    paramArrayOfBoolean[0] = false;
    this.clu = 0;
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i != -1) {}
    for (Object localObject = paramString.substring(i + 1);; localObject = null)
    {
      log("getLbsParamsFileName", String.format("index=%s,name=%s", new Object[] { "" + i, "" + (String)localObject }), null);
      if ((localObject == null) || ("".equals(localObject))) {
        break;
      }
      if (Thread.currentThread().getId() != this.MK) {
        throw new RuntimeException("getLbsParamsFileName must called in main thread");
      }
      if ((this.e != null) && (this.e.name.equals(localObject)))
      {
        if (!this.e.usable) {
          throw new RuntimeException(String.format("filterName=%s , usable=false", new Object[] { localObject }));
        }
        i = this.e.activityType;
        log("getLbsParamsFileName", String.format("[%s]acitvityName=%s,White[%s]", new Object[] { localObject, this.e.getLbsActivityType(i), "" + this.bAp }), null);
        localObject = (aavi.a)this.bS.get(i);
        if (localObject == null) {
          break;
        }
        if (this.bAp)
        {
          log("getLbsParamsFileName", String.format("mRequestStatus=%s", new Object[] { "" + ((aavi.a)localObject).clw }), null);
          log("getLbsParamsFileName", String.format("mHaveLocationPermission=%s", new Object[] { "" + ((aavi.a)localObject).bAs }), null);
          log("getLbsParamsFileName", String.format("mLocateInLbsRegion=%s", new Object[] { "" + ((aavi.a)localObject).iV(this.e.id) }), null);
          if (((aavi.a)localObject).clw == 3)
          {
            if (!((aavi.a)localObject).bAs) {}
            for (;;)
            {
              paramArrayOfBoolean[0] = j;
              if ((!((aavi.a)localObject).bAs) || (!((aavi.a)localObject).iV(this.e.id))) {
                break;
              }
              paramArrayOfBoolean = q(paramString, paramBoolean);
              if (paramArrayOfBoolean == null) {
                break;
              }
              return paramArrayOfBoolean;
              j = 0;
            }
          }
          log("getLbsParamsFileName", String.format("[cache]mRequestStatus=%s", new Object[] { "" + ((aavi.a)localObject).a.clw }), null);
          log("getLbsParamsFileName", String.format("[cache]mHaveLocationPermission=%s", new Object[] { "" + ((aavi.a)localObject).a.bAs }), null);
          if ((((aavi.a)localObject).a.clw == 3) && (((aavi.a)localObject).a.bAs))
          {
            log("getLbsParamsFileName", String.format("[cache]mLocateInLbsRegion=%s", new Object[] { "" + ((aavi.a)localObject).a.iV(this.e.id) }), null);
            if (((aavi.a)localObject).a.iV(this.e.id))
            {
              paramArrayOfBoolean = q(paramString, paramBoolean);
              if (paramArrayOfBoolean != null) {
                return paramArrayOfBoolean;
              }
            }
          }
          else
          {
            log("getLbsParamsFileName", String.format("LBS_FILTER_LOADING status...", new Object[0]), null);
            if (new File(paramString, "paramsloading.json").exists())
            {
              this.clu = 1;
              return "paramsloading";
            }
            log("getLbsParamsFileName", String.format("LBS_FILTER_LOADING not eixst", new Object[0]), null);
          }
        }
        log("getLbsParamsFileName", String.format("LBS_FILTER_NOMAL status...", new Object[0]), null);
        localObject = "params";
        paramArrayOfBoolean = (boolean[])localObject;
        if (paramBoolean)
        {
          paramArrayOfBoolean = (boolean[])localObject;
          if (new File(paramString, "paramsback.json").exists()) {
            paramArrayOfBoolean = "paramsback";
          }
        }
        ef("", "0X8008138");
        this.clu = 2;
        return paramArrayOfBoolean;
      }
      if (this.e != null) {}
      for (paramString = this.e.name;; paramString = "null")
      {
        log("getLbsParamsFileName", String.format("[name error]filterName=%s,mCurrentFilterInfo.name=%s", new Object[] { localObject, paramString }), null);
        return null;
      }
    }
  }
  
  public void a(aavi.b paramb)
  {
    this.jdField_a_of_type_Aavi$b = paramb;
  }
  
  public void b(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    this.e = paramPtvTemplateInfo;
    log("startLocation", String.format("activityType=%s", new Object[] { this.e.getLbsActivityType(this.e.activityType) }), null);
    czo();
  }
  
  public void bb(int paramInt, boolean paramBoolean)
  {
    long l = Thread.currentThread().getId();
    if (this.MK == l)
    {
      bf(paramInt, paramBoolean);
      return;
    }
    this.mUIHandler.post(new LbsFilterStatusManager.1(this, paramInt, paramBoolean));
  }
  
  public void c(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    long l = Thread.currentThread().getId();
    if (this.MK == l)
    {
      d(paramInt, paramBoolean, paramArrayList);
      return;
    }
    this.mUIHandler.post(new LbsFilterStatusManager.2(this, paramInt, paramBoolean, paramArrayList));
  }
  
  public void czp()
  {
    if (this.e != null)
    {
      log("refreshLocateInfoFromBack", String.format("activityType=%s", new Object[] { this.e.getLbsActivityType(this.e.activityType) }), null);
      if (this.bAq)
      {
        this.bAq = false;
        czo();
      }
    }
  }
  
  public void czq()
  {
    this.bAq = true;
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
      aavi.log("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.sn.toString() }), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavi
 * JD-Core Version:    0.7.0.1
 */