import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.1;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.2;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class abim
  implements BusinessObserver
{
  private static abim a;
  private long Nw;
  private boolean bDe;
  private Runnable fw = new ApolloStoreStabilityReportManager.3(this);
  private ArrayList<HashMap> sJ = new ArrayList();
  
  private void A(HashMap paramHashMap)
  {
    try
    {
      this.sJ.add(paramHashMap);
      return;
    }
    finally
    {
      paramHashMap = finally;
      throw paramHashMap;
    }
  }
  
  public static abim a()
  {
    try
    {
      if (a == null) {
        a = new abim();
      }
      abim localabim = a;
      return localabim;
    }
    finally {}
  }
  
  private void cCd()
  {
    ThreadManagerV2.excute(new ApolloStoreStabilityReportManager.1(this), 64, null, true);
  }
  
  private void clearQueue()
  {
    try
    {
      this.sJ.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if ((localObject instanceof AppInterface)) {
          return (AppInterface)localObject;
        }
      }
    }
    return null;
  }
  
  public void db(String paramString, int paramInt)
  {
    if (paramInt == 1000) {}
    for (int i = 1;; i = 0)
    {
      int j;
      if (paramInt == -1001)
      {
        j = 3001;
        i = 1;
      }
      for (;;)
      {
        if (paramInt == -1002)
        {
          j = 3000;
          i = 1;
        }
        if (i != 0)
        {
          abwh.Il(40);
          abwh.a(40, 1, j, new Object[] { paramString });
          abwh.Im(40);
        }
        return;
        j = 0;
      }
    }
  }
  
  public void j(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errcode", Integer.valueOf(paramInt1));
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("cmd", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("url", paramString2);
    }
    localHashMap.put("cost", Integer.valueOf(paramInt2));
    A(localHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue. add one task. count:" + this.sJ.size());
    }
    db(paramString1, paramInt1);
    if (!aqiw.isNetworkAvailable(null)) {
      QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "reportApolloStoreStabilityData. network not available. cmd:" + paramString1);
    }
    while (this.bDe) {
      return;
    }
    this.bDe = true;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ApolloStoreStabilityReportManager.2(this), 10000L);
  }
  
  public boolean jo(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HashSet localHashSet = abxe.e();
      if (localHashSet != null)
      {
        if (localHashSet.contains(paramString)) {
          break label103;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue. filter one cmd:" + paramString + " cmdSet:" + localHashSet.toString());
        }
      }
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue.  cmdSet is null. filter all reporting cmd");
        }
      } while (System.currentTimeMillis() - this.Nw <= 30000L);
      cCd();
      return false;
    }
    label103:
    return true;
  }
  
  public boolean jp(String paramString)
  {
    HashSet localHashSet;
    if (!TextUtils.isEmpty(paramString))
    {
      localHashSet = abxe.f();
      if (localHashSet != null)
      {
        Iterator localIterator = localHashSet.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!paramString.contains((String)localIterator.next()));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue. filter one url:" + paramString + " urlSet:" + localHashSet.toString());
        }
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "addTaskToApolloStoreStabilityQueue.  urlSet is null. filter all reporting url");
        }
        if (System.currentTimeMillis() - this.Nw > 30000L) {
          cCd();
        }
        return false;
      }
      return true;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          Object localObject = new WebSsoBody.WebSsoResponseBody();
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          if (!QLog.isColorLevel()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceive upload success retcode:");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" retJson:");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, "onReceive upload success. data is null");
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "onReceive upload success. parse response failed.", paramBundle);
        return;
      }
    } else {
      QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "onReceive upload failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abim
 * JD-Core Version:    0.7.0.1
 */