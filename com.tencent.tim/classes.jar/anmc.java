import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadOptions.a;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadManager.1;
import com.tencent.mobileqq.soload.SoLoadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class anmc
{
  private static volatile anmc a;
  private static final Map<LoadParam, anlv> ni = new HashMap();
  private final Set<LoadParam> cX = new HashSet();
  private final Map<LoadParam, List<anlz>> nh = new HashMap();
  
  private long a(LoadParam paramLoadParam)
  {
    int i = LoadParam.getItemSize(paramLoadParam);
    long l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", LoadParam.getReportStr(paramLoadParam), i, null);
    paramLoadParam.mReportSeq = l;
    return l;
  }
  
  private static anlv a(LoadParam paramLoadParam)
  {
    if (paramLoadParam.mLoadItems.size() > 1) {
      return new anlw();
    }
    return new anlp();
  }
  
  private static anlv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (ni)
    {
      Object localObject2 = new LinkedList(ni.values());
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (anlv)((Iterator)???).next();
        if ((localObject2 != null) && (((anlv)localObject2).pr(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private anlz a(LoadParam paramLoadParam, long paramLong)
  {
    return new anmd(this, paramLoadParam);
  }
  
  public static anmc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new anmc();
      }
      return a;
    }
    finally {}
  }
  
  private LoadExtResult a(LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "loadSync loadParam=" + paramLoadParam);
    }
    long l = a(paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam)) {}
    for (Object localObject = LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam));; localObject = ((anlv)localObject).a(paramLoadParam))
    {
      a(((LoadExtResult)localObject).getResultCode(), (LoadExtResult)localObject, l, null, paramLoadParam);
      if (!((LoadExtResult)localObject).isSucc()) {
        a((LoadExtResult)localObject, paramLoadParam);
      }
      return localObject;
      localObject = a(paramLoadParam);
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_SYNC;
      a(paramLoadParam, (anlv)localObject);
    }
  }
  
  private LoadExtResult a(String paramString, LoadOptions paramLoadOptions)
  {
    return a(a(paramString, paramLoadOptions));
  }
  
  private LoadParam a(LoadParam paramLoadParam, anlz paramanlz)
  {
    synchronized (this.nh)
    {
      Object localObject = this.nh.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        LoadParam localLoadParam = (LoadParam)localEntry.getKey();
        if ((localLoadParam != null) && (localLoadParam.isSame(paramLoadParam)))
        {
          ((List)localEntry.getValue()).add(paramanlz);
          return localLoadParam;
        }
      }
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramanlz);
      this.nh.put(paramLoadParam, localObject);
      return null;
    }
  }
  
  private LoadParam a(String paramString, LoadOptions paramLoadOptions)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.mLoadItems.add(new LoadParam.LoadItem(paramString, paramLoadOptions));
    return localLoadParam;
  }
  
  private LoadParam a(String[] paramArrayOfString, LoadOptions[] paramArrayOfLoadOptions)
  {
    LoadParam localLoadParam = new LoadParam();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        String str = paramArrayOfString[i];
        if (TextUtils.isEmpty(str))
        {
          i += 1;
        }
        else
        {
          if ((paramArrayOfLoadOptions != null) && (paramArrayOfLoadOptions.length > i)) {}
          for (LoadOptions localLoadOptions = paramArrayOfLoadOptions[i];; localLoadOptions = null)
          {
            localLoadParam.mLoadItems.add(new LoadParam.LoadItem(str, localLoadOptions));
            break;
          }
        }
      }
    }
    return localLoadParam;
  }
  
  private static void a(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, anlz paramanlz, LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[LoadResult] resCode：" + paramInt);
    }
    int i;
    if (paramLoadExtResult != null)
    {
      i = paramLoadExtResult.getReportCode();
      if (paramLoadExtResult == null) {
        break label124;
      }
    }
    label124:
    for (String str = paramLoadExtResult.getReportStr();; str = "")
    {
      if (paramInt != 0) {
        VACDReportUtil.endReport(paramLong, "load.end", str, i, null);
      }
      if (paramanlz != null) {
        paramanlz.a(paramInt, paramLoadExtResult);
      }
      a(paramLoadParam);
      anot.a(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  private void a(LoadExtResult arg1, LoadParam paramLoadParam)
  {
    paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC_BY_SYNC;
    long l = ???.getDelayAyncTime();
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[handleLoadSyncFail]delayTime:" + l);
    }
    if (l <= 0L)
    {
      c(paramLoadParam, null);
      return;
    }
    synchronized (this.cX)
    {
      Iterator localIterator = this.cX.iterator();
      while (localIterator.hasNext())
      {
        LoadParam localLoadParam = (LoadParam)localIterator.next();
        if (localLoadParam.isSame(paramLoadParam))
        {
          ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(localLoadParam);
          localIterator.remove();
        }
      }
    }
    ThreadManager.getSubThreadHandler().postAtTime(new SoLoadManager.1(this, paramLoadParam), paramLoadParam, l + NetConnInfoCenter.getServerTimeMillis());
    this.cX.add(paramLoadParam);
  }
  
  private static void a(LoadParam paramLoadParam)
  {
    synchronized (ni)
    {
      ni.remove(paramLoadParam);
      return;
    }
  }
  
  private static void a(LoadParam paramLoadParam, anlv paramanlv)
  {
    if ((paramLoadParam == null) || (paramanlv == null)) {
      return;
    }
    synchronized (ni)
    {
      ni.put(paramLoadParam, paramanlv);
      return;
    }
  }
  
  private void a(LoadParam paramLoadParam, anlz paramanlz)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramLoadParam);
    }
    long l = a(paramLoadParam);
    paramanlz = new anmc.a(paramanlz, l, paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam))
    {
      paramanlz.a(1, LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam)));
      return;
    }
    if ((paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC) && (paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC;
    }
    paramanlz = a(paramLoadParam, paramanlz);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (paramanlz == null) {
        break label189;
      }
    }
    for (;;)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (paramanlz == null) {
        break;
      }
      VACDReportUtil.b(l, null, "load.join.same.queue", "first=" + paramanlz.mReportSeq, 0, null);
      return;
      label189:
      bool = false;
    }
    paramanlz = a(paramLoadParam, l);
    Object localObject = a(paramLoadParam);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramLoadParam, (anlv)localObject);
    ((anlv)localObject).a(paramLoadParam, paramanlz);
  }
  
  private void a(String paramString, anlz paramanlz, LoadOptions paramLoadOptions)
  {
    c(a(paramString, paramLoadOptions), paramanlz);
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    paramString2 = null;
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      return;
      try
      {
        String str = nx(paramString3);
        if (TextUtils.isEmpty(str))
        {
          localObject = a(paramString3);
          paramString2 = (String)localObject;
          if (localObject == null)
          {
            if (!paramString3.contains("com.tencent.mobileqq.soload")) {
              continue;
            }
            paramString2 = (String)localObject;
          }
        }
        Object localObject = BaseApplicationImpl.processName;
        paramString1 = "process:" + (String)localObject + "msg:" + paramString1 + paramString3;
        if (!TextUtils.isEmpty(str))
        {
          VACDReportUtil.a("ver=" + anlp.nw(str), "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    if (paramString2 != null)
    {
      paramString2.QI(paramString1);
      return;
    }
    VACDReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", "SoLoadWidget", 2, paramString1);
  }
  
  private void a(String[] paramArrayOfString, anlz paramanlz, LoadOptions[] paramArrayOfLoadOptions)
  {
    c(a(paramArrayOfString, paramArrayOfLoadOptions), paramanlz);
  }
  
  private void c(LoadParam paramLoadParam, anlz paramanlz)
  {
    ThreadManager.excute(new SoLoadManager.2(this, paramLoadParam, paramanlz), 16, null, false);
  }
  
  private static String nx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = anlp.gn().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = "lib" + str1 + ".so";
      if ((!TextUtils.isEmpty(str2)) && (paramString.contains(str2))) {
        return str1;
      }
    }
    return null;
  }
  
  public LoadExtResult a(String paramString)
  {
    return a(paramString, null);
  }
  
  public void a(String paramString, anlz paramanlz)
  {
    a(paramString, paramanlz, null);
  }
  
  public void a(String[] paramArrayOfString, anlz paramanlz)
  {
    a(paramArrayOfString, paramanlz, null);
  }
  
  public void b(String paramString, anlz paramanlz)
  {
    a(paramString, paramanlz, new LoadOptions.a().a(true).a());
  }
  
  static class a
    implements anlz
  {
    public anlz a;
    public LoadParam a;
    public long mReportSeq;
    
    a(anlz paramanlz, long paramLong, LoadParam paramLoadParam)
    {
      this.mReportSeq = paramLong;
      this.jdField_a_of_type_Anlz = paramanlz;
      this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam = paramLoadParam;
    }
    
    public void a(int paramInt, LoadExtResult paramLoadExtResult)
    {
      anmc.b(paramInt, paramLoadExtResult, this.mReportSeq, this.jdField_a_of_type_Anlz, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmc
 * JD-Core Version:    0.7.0.1
 */