import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import mqq.manager.Manager;

public class aops
  implements Handler.Callback, Manager
{
  private ArrayList<aopr> Bv = new ArrayList(10);
  private aopr jdField_a_of_type_Aopr;
  private aops.a jdField_a_of_type_Aops$a = new aops.a(null);
  private long aqt;
  private long aqu;
  private long aqv;
  private long aqw;
  private long aqx;
  private long aqy = 6L;
  private aqda.a b = new aopt(this);
  private ArrayList<aopr> bS = new ArrayList(10);
  private boolean cNQ;
  private boolean cNR;
  private boolean cNS;
  private boolean cNT;
  private boolean cNU;
  private boolean cNV;
  private String cmv;
  private String cmw;
  private String cmx;
  private double da = 0.0D;
  private double db = 0.0D;
  private double dc = 30.0D;
  private double dd = 50.0D;
  private QQAppInterface mApp;
  private boolean mEnable = true;
  private Handler mHandler;
  private Object mLock = new Object();
  private boolean mNeedReport;
  private long mStartTime;
  
  public aops(QQAppInterface paramQQAppInterface)
  {
    z(paramQQAppInterface);
  }
  
  private static String F(QQAppInterface paramQQAppInterface)
  {
    switch (jqi.getNetworkType(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private int KV()
  {
    int i = 0;
    if (BaseApplicationImpl.isFirstLaunchNew) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " getStartUpCondition  condition = " + i);
      }
      return i;
      if (BaseApplicationImpl.isCurrentVersionFirstLaunch) {
        i = 2;
      }
    }
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "department should not be empty");
      }
      paramString = null;
      return paramString;
    }
    String str3 = (String)aopq.nX.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str3))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        String str1 = aqul.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
        File localFile = new File(str1);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        str1 = str1 + paramString + "/" + str3;
        paramString = str1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PreDownloadScheduler", 1, "[getPreDownloadPath] path = " + str1);
        return str1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Exception:", localException);
        }
        str2 = aqul.getSDKPrivatePath("/sdcard/tencent/MobileQQ/pddata/");
        continue;
      }
      String str2 = BaseApplicationImpl.getContext().getFilesDir() + "/pddata/";
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString, long paramLong)
  {
    if (!this.mNeedReport) {
      return;
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("downloadUrl", paramString);
    localHashMap.put("downloadSize", String.valueOf(paramLong));
    localHashMap.put("CPU", String.valueOf(paramDouble2));
    localHashMap.put("FPS", String.valueOf(paramDouble1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report puse info]:");
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramString);
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramLong));
      localStringBuilder.append(", ").append("CPU").append("=").append(String.valueOf(paramDouble2));
      localStringBuilder.append(", ").append("FPS").append("=").append(String.valueOf(paramDouble1));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "PreDownloadReportPause", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(aopr paramaopr)
  {
    int i = jqi.getNetworkType(this.mApp.getApp());
    if ((i <= 1) || (i >= paramaopr.dRf))
    {
      paramaopr.dRj = KV();
      paramaopr.startTime = System.currentTimeMillis();
      paramaopr.cmu = F(this.mApp);
      paramaopr.state = 1;
      paramaopr.b.start();
      this.bS.add(paramaopr);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("[start downloading direct without contrl] begin task :");
        localStringBuilder.append(",businessID=").append(paramaopr.businessID);
        localStringBuilder.append(",businessName=").append(paramaopr.businessName);
        localStringBuilder.append(",downloadUrl=").append(paramaopr.downloadUrl);
        localStringBuilder.append(",fileKey=").append(paramaopr.fileKey);
        QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
      }
      b(paramaopr);
    }
  }
  
  private void b(aopr paramaopr)
  {
    if (!this.mNeedReport) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("businessID", String.valueOf(paramaopr.businessID));
    localHashMap.put("businessName", paramaopr.businessName);
    localHashMap.put("businessEngName", paramaopr.cmt);
    localHashMap.put("department", paramaopr.azm);
    localHashMap.put("fileKey", paramaopr.fileKey);
    localHashMap.put("downloadUrl", paramaopr.downloadUrl);
    localHashMap.put("filePath", paramaopr.filePath);
    localHashMap.put("reqTime", String.valueOf(paramaopr.Tb));
    localHashMap.put("reqNetWork", String.valueOf(paramaopr.dRf));
    localHashMap.put("downNetWork", String.valueOf(paramaopr.cmu));
    localHashMap.put("startTime", String.valueOf(paramaopr.startTime));
    localHashMap.put("downloadTime", String.valueOf(paramaopr.downloadTime));
    localHashMap.put("downloadSize", String.valueOf(paramaopr.downloadSize));
    localHashMap.put("businessPriority", String.valueOf(paramaopr.dRg));
    localHashMap.put("innerPriority", String.valueOf(paramaopr.dRh));
    localHashMap.put("state", String.valueOf(paramaopr.state));
    localHashMap.put("reqCondition", String.valueOf(paramaopr.dRi));
    localHashMap.put("startCondition", String.valueOf(paramaopr.dRj));
    localHashMap.put("saveOnSD", String.valueOf(paramaopr.cNP));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report item]:");
      localStringBuilder.append(", ").append("businessID").append("=").append(paramaopr.businessID);
      localStringBuilder.append(", ").append("businessName").append("=").append(paramaopr.businessName);
      localStringBuilder.append(", ").append("businessEngName").append("=").append(paramaopr.cmt);
      localStringBuilder.append(", ").append("department").append("=").append(paramaopr.azm);
      localStringBuilder.append(", ").append("fileKey").append("=").append(paramaopr.fileKey);
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramaopr.downloadUrl);
      localStringBuilder.append(", ").append("filePath").append("=").append(paramaopr.filePath);
      localStringBuilder.append(", ").append("reqTime").append("=").append(String.valueOf(paramaopr.Tb));
      localStringBuilder.append(", ").append("reqNetWork").append("=").append(String.valueOf(paramaopr.dRf));
      localStringBuilder.append(", ").append("downNetWork").append("=").append(String.valueOf(paramaopr.cmu));
      localStringBuilder.append(", ").append("startTime").append("=").append(String.valueOf(paramaopr.startTime));
      localStringBuilder.append(", ").append("downloadTime").append("=").append(String.valueOf(paramaopr.downloadTime));
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramaopr.downloadSize));
      localStringBuilder.append(", ").append("businessPriority").append("=").append(String.valueOf(paramaopr.dRg));
      localStringBuilder.append(", ").append("innerPriority").append("=").append(String.valueOf(paramaopr.dRh));
      localStringBuilder.append(", ").append("state").append("=").append(String.valueOf(paramaopr.state));
      localStringBuilder.append(", ").append("reqCondition").append("=").append(String.valueOf(paramaopr.dRi));
      localStringBuilder.append(", ").append("startCondition").append("=").append(String.valueOf(paramaopr.dRj));
      localStringBuilder.append(", ").append("saveOnSD").append("=").append(String.valueOf(paramaopr.cNP));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "PreDownloadReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void dWA()
  {
    int j = 0;
    if ((this.jdField_a_of_type_Aopr != null) && (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Aopr.startTime) >= 60000L)) {
      this.jdField_a_of_type_Aopr = null;
    }
    int k;
    int m;
    if ((aAv()) && (this.jdField_a_of_type_Aopr == null) && (this.Bv.size() > 0))
    {
      Collections.sort(this.Bv, this.jdField_a_of_type_Aops$a);
      k = KV();
      m = jqi.getNetworkType(this.mApp.getApp());
      if (m != 0) {
        break label108;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " [no network] donot start any task! ");
      }
    }
    return;
    label108:
    Object localObject1 = this.mLock;
    int i = j;
    for (;;)
    {
      Object localObject4;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder("pending task id:");
          i = 0;
          if (i < this.Bv.size())
          {
            localObject4 = (aopr)this.Bv.get(i);
            if (localObject4 == null) {
              break label804;
            }
            ((StringBuilder)localObject2).append(((aopr)localObject4).businessID).append(",");
            break label804;
          }
          QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject2).toString());
          i = j;
        }
        if (i >= this.Bv.size()) {
          break label592;
        }
        Object localObject2 = (aopr)this.Bv.get(i);
        if ((localObject2 != null) && (((aopr)localObject2).dRi == 1) && (k == 1))
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder("[forbidden on first start] remove task :\n");
            ((StringBuilder)localObject4).append(",businessID=").append(((aopr)localObject2).businessID);
            ((StringBuilder)localObject4).append(",businessName=").append(((aopr)localObject2).businessName);
            ((StringBuilder)localObject4).append(",downloadUrl=").append(((aopr)localObject2).downloadUrl);
            ((StringBuilder)localObject4).append(",reqCondition=").append(((aopr)localObject2).dRi);
            QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject4).toString());
          }
          this.Bv.remove(i);
          return;
        }
      }
      finally {}
      if ((localObject3 != null) && (((localObject3.dRi == 2) && (!this.cNQ)) || ((localObject3.dRf == 1) && (m > 1)) || ((m > 1) && (m < localObject3.dRf)) || ((localObject3.dRi == 3) && (!this.cNR))))
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder("[network or reqconditon not fit] donot download task :\n");
          ((StringBuilder)localObject4).append(",businessID=").append(localObject3.businessID);
          ((StringBuilder)localObject4).append(",businessName=").append(localObject3.businessName);
          ((StringBuilder)localObject4).append(",downloadUrl=").append(localObject3.downloadUrl);
          ((StringBuilder)localObject4).append(",reqCondition=").append(localObject3.dRi);
          ((StringBuilder)localObject4).append(",current appBackground=").append(this.cNQ);
          ((StringBuilder)localObject4).append(",reqNetWork=").append(localObject3.dRf);
          ((StringBuilder)localObject4).append(",current netWorkType=").append(m);
          QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject4).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_Aopr = ((aopr)this.Bv.remove(i));
        label592:
        if ((this.jdField_a_of_type_Aopr != null) && (this.jdField_a_of_type_Aopr.b != null))
        {
          if (this.mStartTime == 0L) {
            this.mStartTime = System.currentTimeMillis();
          }
          this.jdField_a_of_type_Aopr.dRj = k;
          this.jdField_a_of_type_Aopr.startTime = System.currentTimeMillis();
          this.jdField_a_of_type_Aopr.cmu = F(this.mApp);
          this.jdField_a_of_type_Aopr.state = 1;
          this.jdField_a_of_type_Aopr.b.start();
          this.bS.add(this.jdField_a_of_type_Aopr);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder("[start downloading] begin task :");
            localStringBuilder.append(",businessID=").append(this.jdField_a_of_type_Aopr.businessID);
            localStringBuilder.append(",businessName=").append(this.jdField_a_of_type_Aopr.businessName);
            localStringBuilder.append(",downloadUrl=").append(this.jdField_a_of_type_Aopr.downloadUrl);
            localStringBuilder.append(",fileKey=").append(this.jdField_a_of_type_Aopr.fileKey);
            QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
          }
        }
        for (;;)
        {
          return;
          this.jdField_a_of_type_Aopr = null;
        }
        label804:
        i += 1;
        continue;
      }
      i += 1;
    }
  }
  
  private void dWB()
  {
    if (this.cNV)
    {
      if (this.Bv.size() <= 0)
      {
        aqda.a().b(this.b);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback disabled],there is no pending task!");
        }
      }
      if (this.Bv.size() > 0)
      {
        aqda.a().a(this.b);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback enabled],there is pending tasks!");
        }
      }
    }
  }
  
  public void Re(boolean paramBoolean)
  {
    this.cNR = paramBoolean;
  }
  
  public aopm a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ cancelPreDownload ] downloadUrl = " + paramString);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject3 = this.mLock;
      i = 0;
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (i < this.Bv.size())
        {
          localObject2 = (aopr)this.Bv.get(i);
          if (paramString.equals(((aopr)localObject2).downloadUrl)) {
            localObject1 = ((aopr)localObject2).b;
          }
        }
        else
        {
          localObject2 = new Message();
          ((Message)localObject2).what = 1003;
          ((Message)localObject2).obj = paramString;
          this.mHandler.sendMessage((Message)localObject2);
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a(aopm paramaopm)
  {
    Message localMessage = new Message();
    localMessage.what = 1006;
    localMessage.obj = paramaopm;
    this.mHandler.sendMessage(localMessage);
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, aopm paramaopm)
  {
    if ((anmo.cIz) && (!anmo.cY.contains(Integer.valueOf(paramInt1))) && (!aopq.cY.contains(Integer.valueOf(paramInt1))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "delay pre_download,busindessID:" + paramInt1);
      }
      anmo.amn = System.currentTimeMillis();
      return false;
    }
    if ((paramInt1 == 0) || (TextUtils.isEmpty(paramString3)) || (paramaopm == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "requestPreDownload param error! busindessID=0 or downloadUrl is empty or task is empty\n");
      }
      return false;
    }
    String str1 = (String)aopq.nW.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define name in PreDownloadConstants.BUSINESS_NAME for business");
      }
      return false;
    }
    String str2 = (String)aopq.nX.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return false;
    }
    Object localObject = (Integer)aopq.nY.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define priority in PreDownloadConstants.BUSINESS_PRIORITY for business");
      }
      return false;
    }
    int i = ((Integer)localObject).intValue();
    if ((i < 0) || (i > 4))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " requestPreDownload param priority error,priority value should be in[0,1,2,3,4]!");
      }
      return false;
    }
    localObject = new aopr();
    ((aopr)localObject).businessID = paramInt1;
    ((aopr)localObject).businessName = str1;
    ((aopr)localObject).cmt = str2;
    ((aopr)localObject).azm = paramString1;
    ((aopr)localObject).fileKey = paramString2;
    ((aopr)localObject).downloadUrl = paramString3;
    ((aopr)localObject).dRf = paramInt3;
    ((aopr)localObject).dRh = paramInt2;
    ((aopr)localObject).filePath = paramString4;
    ((aopr)localObject).state = 0;
    ((aopr)localObject).Tb = System.currentTimeMillis();
    ((aopr)localObject).dRg = i;
    ((aopr)localObject).dRi = paramInt4;
    ((aopr)localObject).cNP = paramBoolean;
    ((aopr)localObject).b = paramaopm;
    paramString1 = new Message();
    paramString1.what = 1002;
    paramString1.obj = localObject;
    this.mHandler.sendMessage(paramString1);
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ requestPreDownload ]  downloadUrl = " + paramString3);
    }
    return aAv();
  }
  
  public boolean aAv()
  {
    if ((this.mEnable) && (!this.cNS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, "[System busy] dowload not ready!");
      }
      if ((this.Bv.size() > 0) && (Math.abs(System.currentTimeMillis() - this.aqx) >= 60000L) && (this.mStartTime == 0L))
      {
        this.aqy -= 2L;
        this.dd += 10.0D;
        this.dc -= 10.0D;
        this.cNT = true;
        this.cNU = true;
        this.cNS = true;
        QLog.d("PreDownloadScheduler", 2, "[System busy] for 60 seconds after pull msg, set download enable");
        QLog.d("PreDownloadScheduler", 2, "mCPUThreshold = " + this.dd + ",mFPSThreshold=" + this.dc);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public void aSU()
  {
    this.aqx = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ startPreDownload ] enable time = " + this.aqx);
    }
    if (this.mEnable)
    {
      this.mHandler.sendEmptyMessageDelayed(1001, 10000L);
      return;
    }
    this.mHandler.sendEmptyMessage(1001);
  }
  
  public void be(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ preDownloadSuccess ] downloadUrl = " + paramString + ",size = " + paramLong);
    }
    this.cmv = paramString;
    this.aqw = paramLong;
    Message localMessage = new Message();
    localMessage.what = 1004;
    localMessage.obj = paramString;
    localMessage.arg1 = ((int)paramLong);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void dWz()
  {
    this.cNU = false;
    this.cNT = false;
    this.cNQ = false;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppForground ] mAppBackground = " + this.cNQ);
    }
    Message localMessage = new Message();
    localMessage.what = 1008;
    this.mHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1001: 
      this.cNS = true;
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "startPreDownload mBeReady set true, all pre download will start ");
      }
      paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
      i = paramMessage.getInt("sp_key_pre_download_version", 0);
      if (i != 0)
      {
        localObject1 = aopo.i(i, 0);
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
        {
          i = 0;
          while (i < ((ArrayList)localObject1).size())
          {
            if (QLog.isColorLevel()) {
              QLog.e("PreDownloadScheduler", 1, "[onVersionUpdate PreDownloadScheduler]  delete file: " + (String)((ArrayList)localObject1).get(i));
            }
            aqhq.delete((String)((ArrayList)localObject1).get(i), false);
            i += 1;
          }
        }
      }
      paramMessage.edit().putInt("sp_key_pre_download_version", 0).commit();
      dWA();
      dWB();
      return true;
    case 1002: 
      localObject1 = (aopr)paramMessage.obj;
      if (this.mEnable)
      {
        paramMessage = this.mLock;
        i = 0;
        label255:
        aopr localaopr2;
        label366:
        try
        {
          if (i >= this.Bv.size()) {
            break label1003;
          }
          localaopr2 = (aopr)this.Bv.get(i);
          if (!((aopr)localObject1).downloadUrl.equals(localaopr2.downloadUrl)) {
            break label1008;
          }
          if ((!((aopr)localObject1).downloadUrl.contains("doodle")) || (((aopr)localObject1).filePath == null) || (((aopr)localObject1).filePath.equals(localaopr2.filePath))) {
            break label1015;
          }
          if (!QLog.isColorLevel()) {
            break label1008;
          }
          QLog.d("PreDownloadScheduler", 2, new Object[] { "mPendingList, same url, filePath diff, ", ((aopr)localObject1).downloadUrl });
        }
        finally {}
        k = i;
        if (j < this.bS.size())
        {
          localaopr2 = (aopr)this.bS.get(j);
          if (!((aopr)localObject1).downloadUrl.equals(localaopr2.downloadUrl)) {
            break label1020;
          }
          if ((!((aopr)localObject1).downloadUrl.contains("doodle")) || (((aopr)localObject1).filePath == null) || (((aopr)localObject1).filePath.equals(localaopr2.filePath))) {
            break label1027;
          }
          if (!QLog.isColorLevel()) {
            break label1020;
          }
          QLog.d("PreDownloadScheduler", 2, new Object[] { "downloadUrl, same url, filePath diff, ", ((aopr)localObject1).downloadUrl });
        }
      }
      break;
    }
    for (;;)
    {
      if (k == 0) {
        this.Bv.add(localObject1);
      }
      for (;;)
      {
        dWA();
        dWB();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PreDownloadScheduler", 1, " [msg request add to list]  mPendingList size = " + this.Bv.size());
        return true;
        a(localaopr1);
      }
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        i = k;
        while (i < this.Bv.size())
        {
          localObject2 = (aopr)this.Bv.get(i);
          if (paramMessage.equals(((aopr)localObject2).downloadUrl))
          {
            this.Bv.remove(localObject2);
            ((aopr)localObject2).state = 3;
            b((aopr)localObject2);
            if (QLog.isColorLevel()) {
              QLog.e("PreDownloadScheduler", 1, "[ msg cancel] task.url = " + ((aopr)localObject2).downloadUrl);
            }
            if (localObject2 == this.jdField_a_of_type_Aopr) {
              this.jdField_a_of_type_Aopr = null;
            }
            dWB();
          }
          i += 1;
        }
      }
      dWA();
      return true;
      Object localObject2 = (String)paramMessage.obj;
      j = paramMessage.arg1;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        while (i < this.bS.size())
        {
          paramMessage = (aopr)this.bS.get(i);
          if (((String)localObject2).equals(paramMessage.downloadUrl))
          {
            paramMessage.downloadSize = j;
            paramMessage.downloadTime = (System.currentTimeMillis() - paramMessage.startTime);
            paramMessage.state = 2;
            if (QLog.isColorLevel()) {
              QLog.e("PreDownloadScheduler", 1, "[msg download sucess] task.url = " + paramMessage.downloadUrl);
            }
            b(paramMessage);
            this.bS.remove(i);
            if (paramMessage == this.jdField_a_of_type_Aopr) {
              this.jdField_a_of_type_Aopr = null;
            }
          }
          i += 1;
        }
      }
      dWA();
      return true;
      dWA();
      dWB();
      return true;
      paramMessage = (Bundle)paramMessage.obj;
      a(paramMessage.getDouble("FPS"), paramMessage.getDouble("CPU"), this.cmv, this.aqw);
      return true;
      paramMessage = (aopm)paramMessage.obj;
      if ((this.jdField_a_of_type_Aopr != null) && (this.jdField_a_of_type_Aopr.b != null) && (paramMessage != null) && (this.jdField_a_of_type_Aopr.b == paramMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, " pre download onTaskEnd task key = " + this.jdField_a_of_type_Aopr.b.key);
        }
        this.jdField_a_of_type_Aopr = null;
      }
      dWA();
      return true;
      dWA();
      return true;
      label1003:
      i = 0;
      break label366;
      label1008:
      i += 1;
      break label255;
      label1015:
      i = 1;
      break label366;
      label1020:
      j += 1;
      break label366;
      label1027:
      k = 1;
    }
  }
  
  public void onAppBackground()
  {
    this.cNQ = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppBackground ] mAppBackground = " + this.cNQ);
    }
    Message localMessage = new Message();
    localMessage.what = 1009;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void onDestroy()
  {
    if (this.cNV) {
      aqda.a().b(this.b);
    }
    this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    synchronized (this.mLock)
    {
      this.Bv.removeAll(this.Bv);
      this.bS.removeAll(this.bS);
      return;
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[setEnable] enable = " + this.mEnable);
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.cmw = (BaseApplicationImpl.getContext().getFilesDir() + "/pddata/");
    paramQQAppInterface = new File(this.cmw);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.cmx = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
    this.cmx = aqul.getSDKPrivatePath(this.cmx);
    paramQQAppInterface = new File(this.cmx);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.aqy = 6L;
    this.dc = 30.0D;
    this.dd = 50.0D;
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
    boolean bool2 = paramQQAppInterface.getBoolean("sp_key_pre_sample_mark", false);
    QLog.e("PreDownloadScheduler", 1, " pre download bSampledLastTime = " + bool2);
    double d = Math.random();
    boolean bool1;
    if (9.999999747378752E-006D >= d)
    {
      bool1 = true;
      this.mNeedReport = bool1;
      QLog.e("PreDownloadScheduler", 1, " pre download random = " + d);
      if (!bool2) {
        break label330;
      }
      this.mNeedReport = true;
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", false).commit();
      QLog.e("PreDownloadScheduler", 1, " pre download last time sampled, also sampled this time");
    }
    for (;;)
    {
      QLog.e("PreDownloadScheduler", 1, " pre download set mNeedReport = " + this.mNeedReport);
      return;
      bool1 = false;
      break;
      label330:
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", this.mNeedReport).commit();
    }
  }
  
  static class a
    implements Comparator
  {
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (aopr)paramObject1;
      paramObject2 = (aopr)paramObject2;
      if (paramObject1.dRg > paramObject2.dRg) {}
      do
      {
        return -1;
        if (paramObject1.dRg < paramObject2.dRg) {
          return 1;
        }
      } while (paramObject1.dRh > paramObject2.dRh);
      if (paramObject1.dRh < paramObject2.dRh) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aops
 * JD-Core Version:    0.7.0.1
 */