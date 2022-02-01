import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.mostused.MostUsedSearchItem;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class amrk
  implements Manager
{
  private amrg b = new amrg("Cahce_");
  private QQAppInterface mApp;
  
  public amrk(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public ArrayList<amrg.a> S(String paramString)
  {
    if (this.b != null)
    {
      paramString = this.b.a(this.mApp, paramString);
      if ((paramString != null) && (paramString.size() > 10))
      {
        ArrayList localArrayList = new ArrayList(paramString.subList(0, 10));
        QLog.i("MostUsedSearchResultManager", 2, "tmpResult subList 10 ,orglist is " + paramString.size());
        return localArrayList;
      }
      return paramString;
    }
    QLog.e("MostUsedSearchResultManager", 2, "Match with null cache");
    return null;
  }
  
  public void init()
  {
    if (this.b != null)
    {
      this.b.z(this.mApp);
      QLog.d("MostUsedSearchResultManager", 2, "init");
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "init with null cache ");
  }
  
  boolean lj(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
  
  public void onDestroy()
  {
    releaseCache();
    this.b = null;
    QLog.d("MostUsedSearchResultManager", 2, "onDestroy");
  }
  
  public void releaseCache()
  {
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void s(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2))) {}
    for (String str = paramString2;; str = paramString1)
    {
      QLog.d("MostUsedSearchResultManager", 2, "UpdateItemUsed : key= " + paramString1 + " mostusedKey= " + paramString2);
      int i = amrf.jh(paramInt);
      if (!lj(i)) {
        break;
      }
      paramString1 = new MostUsedSearchItem(str, NetConnInfoCenter.getServerTimeMillis(), paramString3, paramInt, i);
      ThreadManager.getSubThreadHandler().post(new MostUsedSearchResultManager.1(this, paramString1));
      return;
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrk
 * JD-Core Version:    0.7.0.1
 */