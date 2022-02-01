import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class zjq
{
  private static volatile zjq a;
  public static volatile int cdv;
  private static final Object mLock = new Object();
  public boolean brs;
  public HashMap<String, aevs> hq = new HashMap();
  protected List<aevs> ux = new ArrayList();
  
  private zjq()
  {
    cdv = 0;
  }
  
  public static zjq a()
  {
    if (a == null) {}
    synchronized (mLock)
    {
      if (a == null) {
        a = new zjq();
      }
      return a;
    }
  }
  
  public boolean Vr()
  {
    return anlm.Vr();
  }
  
  public boolean Vs()
  {
    return awit.Vs();
  }
  
  public aevs a(long paramLong)
  {
    Iterator localIterator = dp().iterator();
    while (localIterator.hasNext())
    {
      aevs localaevs = (aevs)localIterator.next();
      if (localaevs.a.uiResId == paramLong) {
        return localaevs;
      }
    }
    return null;
  }
  
  public List<aevs> a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s, %s]", new Object[] { Boolean.valueOf(this.brs), paramContext, paramQQAppInterface }));
    }
    ArrayList localArrayList1 = new ArrayList();
    List localList = paramQQAppInterface.ed();
    ArrayList localArrayList2;
    if (localList != null)
    {
      paramContext = paramQQAppInterface.a().a;
      if ((paramContext == null) && (QLog.isDevelopLevel())) {
        QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeopleChecker is null");
      }
      Object localObject = new ArrayList(localList);
      localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      boolean bool1 = false;
      while (((Iterator)localObject).hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((Iterator)localObject).next();
        if (localLebaPluginInfo != null) {
          if ((localLebaPluginInfo.uiResId == 770L) && (paramContext != null) && (!paramContext.cZl))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "reloadLebaItems wholePeople entry switch is off ");
            }
          }
          else
          {
            boolean bool2 = bool1;
            if (localLebaPluginInfo.uiResId == 770L) {
              bool2 = true;
            }
            aevs localaevs = new aevs();
            try
            {
              localaevs.WP = localLebaPluginInfo.uiResId;
              localaevs.a = localLebaPluginInfo;
              if (!acgw.c(localaevs)) {
                break label298;
              }
              this.hq.put(localaevs.a.strPkgName, localaevs);
              bool1 = bool2;
            }
            catch (Exception localException)
            {
              bool1 = bool2;
            }
            if (QLog.isColorLevel())
            {
              bool1 = bool2;
              if (localException != null)
              {
                QLog.d("Q.lebatab.mgr", 2, localException.toString());
                bool1 = bool2;
                continue;
                label298:
                localArrayList2.add(localaevs);
                bool1 = bool2;
              }
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.TA(bool1);
      }
      Collections.sort(localArrayList2, new acgw.a());
      paramContext = (altq)paramQQAppInterface.getManager(36);
      if (paramContext != null) {
        break label442;
      }
    }
    label442:
    for (paramContext = null;; paramContext = paramContext.fV())
    {
      a(paramQQAppInterface, localArrayList2, paramContext);
      paramContext = e(paramQQAppInterface);
      acgw.F(localArrayList1, paramContext);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "reloadLebaItems, info.size=" + localList.size() + ", alldatasize=" + this.ux.size() + ", pluginShowList=" + paramContext.size());
      }
      return localArrayList1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    int i = 1;
    int k = 1;
    for (;;)
    {
      int j;
      synchronized (this.ux)
      {
        Iterator localIterator = this.ux.iterator();
        j = i;
        if (!localIterator.hasNext()) {
          break label288;
        }
        aevs localaevs = (aevs)localIterator.next();
        if ((localaevs == null) || (localaevs.a == null) || (localaevs.a.uiResId != paramLong1)) {
          continue;
        }
        if (paramBoolean)
        {
          i = 0;
          localaevs.bo = ((byte)i);
          if (paramLong3 == -9223372036854775808L)
          {
            localaevs.WQ = paramLong2;
            i = k;
            j = i;
            if (!QLog.isDevelopLevel()) {
              break label288;
            }
            QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, name = " + localaevs.a.strResName + " status:" + paramBoolean);
            if ((paramQQAppInterface != null) && (i == 1)) {
              ThreadManager.post(new LebaShowListManager.1(this, (altq)paramQQAppInterface.getManager(36), paramLong1, paramBoolean, paramLong3, paramLong2), 5, null, true);
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, ret = " + i);
            }
          }
        }
        else
        {
          i = 1;
          continue;
        }
        if (paramLong2 == localaevs.WQ)
        {
          localaevs.WQ = paramLong3;
          i = k;
        }
      }
      i = -2147483648;
      continue;
      label288:
      i = j;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<aevs> paramList, List<BusinessInfoCheckUpdate.AppSetting> paramList1)
  {
    int i;
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder().append("setAllLebaList, ");
      if (paramList != null) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      QLog.i("Q.lebatab.mgr", 4, i);
      synchronized (this.ux)
      {
        this.ux.clear();
        if (paramList != null) {
          this.ux.addAll(paramList);
        }
        hl(paramList1);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = (ackq)paramQQAppInterface.getBusinessHandler(31);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.notifyUI(1, true, null);
          }
        }
        return;
        label111:
        i = paramList.size();
      }
    }
  }
  
  public void a(boolean paramBoolean, aevs paramaevs, List<aevs> paramList)
  {
    if (paramBoolean) {
      if ((paramaevs.a.showInSimpleMode != 0) || (paramaevs.a.uiResId == 0L)) {
        paramList.add(paramaevs);
      }
    }
    while ((paramaevs.bo != 0) && (paramaevs.a.uiResId != 0L)) {
      return;
    }
    paramList.add(paramaevs);
  }
  
  public void bs(QQAppInterface paramQQAppInterface)
  {
    Object localObject = dp();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aevs localaevs = (aevs)((Iterator)localObject).next();
        if (localaevs != null) {
          if (localaevs.bo == 0)
          {
            if (localaevs.a != null) {
              anot.a(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localaevs.a.uiResId), "", "");
            }
          }
          else if ((localaevs.bo == 1) && (localaevs.a != null)) {
            anot.a(paramQQAppInterface, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localaevs.a.uiResId), "", "");
          }
        }
      }
    }
  }
  
  public List<aevs> dp()
  {
    ArrayList localArrayList = new ArrayList();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    for (;;)
    {
      aevs localaevs;
      boolean bool;
      synchronized (this.ux)
      {
        Iterator localIterator = this.ux.iterator();
        if (!localIterator.hasNext()) {
          break label269;
        }
        localaevs = (aevs)localIterator.next();
        if ((localaevs == null) || (localaevs.a == null) || (localaevs.a.uiResId == 905L)) {
          continue;
        }
        if (localaevs.a.uiResId == jsp.aCT)
        {
          bool = false;
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break label277;
          }
          bool = ((QQAppInterface)localAppRuntime).a().ym();
          break label277;
        }
        if ((localaevs.a.uiResId == 1130L) && (Vs()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList hide leba kandian");
        }
      }
      if (((localAppRuntime instanceof QQAppInterface)) && (acgw.f((QQAppInterface)localAppRuntime, localaevs.a.uiResId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.mgr", 2, "getLebaMgrList, " + localaevs.a.uiResId + " is filtered");
        }
      }
      else if (localaevs.a.cDataType != 1)
      {
        localList2.add(localaevs);
        continue;
        label269:
        acgw.gN(localList2);
        return localList2;
        label277:
        if (!bool) {}
      }
    }
  }
  
  public List<aevs> dq()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.ux)
    {
      Iterator localIterator = this.ux.iterator();
      while (localIterator.hasNext())
      {
        aevs localaevs = (aevs)localIterator.next();
        if ((localaevs != null) && (localaevs.a != null) && (localaevs.a.uiResId != 905L) && ((localaevs.bo == 0) || (localaevs.a.uiResId == 0L))) {
          localArrayList.add(localaevs);
        }
      }
    }
    return localList1;
  }
  
  public List<aevs> e(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = Vr();
    StringBuffer localStringBuffer1;
    for (;;)
    {
      aevs localaevs;
      synchronized (this.ux)
      {
        localStringBuffer1 = new StringBuffer("getLebaShowList,");
        Iterator localIterator = this.ux.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localaevs = (aevs)localIterator.next();
        if ((localaevs == null) || (localaevs.a == null) || (localaevs.a.uiResId == 905L)) {
          continue;
        }
        if ((localaevs.a.uiResId == 1130L) && (Vs())) {
          localStringBuffer1.append("hide leba kandian,");
        }
      }
      if (localaevs.a.uiResId == jsp.aCT)
      {
        StringBuffer localStringBuffer2 = localStringBuffer1.append("isNowTabAdded");
        paramQQAppInterface.a();
        localStringBuffer2.append(jsp.abw).append("  isNowTabShow:").append(paramQQAppInterface.a().abu).append("  isSDKAPISupportStory:").append(pmb.Ir()).append(",");
        if ((!paramQQAppInterface.a().ym()) || (localaevs.bo == 1)) {}
      }
      else if (acgw.f(paramQQAppInterface, localaevs.a.uiResId))
      {
        localStringBuffer1.append(localaevs.a.uiResId).append(" is filtered");
      }
      else
      {
        a(bool, localaevs, localArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuffer1.append("alldatasize=").append(this.ux.size()).append(", result").append(aevs.H(localArrayList));
      QLog.i("Q.lebatab.mgr", 2, localStringBuffer1.toString());
    }
    acgw.gN(localArrayList);
    return localArrayList;
  }
  
  public boolean e(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = dp();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext())
      {
        aevs localaevs = (aevs)paramQQAppInterface.next();
        if ((localaevs.a != null) && (localaevs.a.uiResId == paramLong)) {
          return localaevs.bo == 0;
        }
      }
    }
    return false;
  }
  
  public void hl(List<BusinessInfoCheckUpdate.AppSetting> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      synchronized (this.ux)
      {
        Iterator localIterator1 = this.ux.iterator();
        continue;
        if (!localIterator1.hasNext()) {
          break;
        }
        aevs localaevs = (aevs)localIterator1.next();
        if ((localaevs == null) || (localaevs.a == null)) {
          continue;
        }
        long l = localaevs.a.uiResId;
        if (l == 0L) {
          continue;
        }
        Iterator localIterator2 = paramList.iterator();
        if (!localIterator2.hasNext()) {
          continue;
        }
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator2.next();
        if ((localAppSetting == null) || (localAppSetting.appid.get() != l)) {
          continue;
        }
        if (localAppSetting.setting.get())
        {
          b = 0;
          localaevs.bo = b;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.lebatab.mgr", 4, "updateAllLebaListFlag, name = " + localaevs.a.strResName + " cCurFlag:" + localaevs.bo);
          }
          localaevs.WQ = localAppSetting.modify_ts.get();
        }
      }
      byte b = 1;
    }
  }
  
  public void reset()
  {
    synchronized (this.ux)
    {
      this.ux.clear();
      cdv = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjq
 * JD-Core Version:    0.7.0.1
 */