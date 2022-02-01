import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.manager.Manager;
import org.json.JSONObject;

public class avcq
  implements Manager
{
  public AtomicInteger cq;
  private SparseArray<avcr> dX;
  private boolean dmt;
  public AtomicReference<avcn.c> f;
  public AtomicReference<avcn.b> g;
  QQAppInterface mApp;
  
  public avcq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.dX = new SparseArray();
    this.f = new AtomicReference(null);
    this.g = new AtomicReference(null);
    this.cq = new AtomicInteger(-1);
  }
  
  public int PB()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", aqmc.dw()).getInt(this.mApp.getCurrentAccountUin() + "_" + "use_times", 0);
  }
  
  public avcr a(int paramInt)
  {
    avcr localavcr = (avcr)this.dX.get(paramInt, null);
    if (localavcr == null) {}
    switch (paramInt)
    {
    default: 
      return localavcr;
    }
    localavcr = new avcr(paramInt);
    this.dX.put(paramInt, localavcr);
    return localavcr;
  }
  
  public int[] ak()
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", aqmc.dw());
    int i = 0;
    while (i < 24)
    {
      arrayOfInt[i] = localSharedPreferences.getInt(this.mApp.getCurrentAccountUin() + "_" + "use_times" + "_" + i, 0);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void ezt()
  {
    int i = 1;
    if (this.dmt) {
      return;
    }
    try
    {
      if (this.dmt) {
        return;
      }
    }
    finally {}
    localObject2 = new avcn.c(1113, this.mApp.getCurrentAccountUin());
    if (((avcn.c)localObject2).cNR != -1)
    {
      this.f.set(localObject2);
      this.dmt = true;
      localObject2 = ((avcn.c)localObject2).mExt1;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        localObject3 = localObject2;
      }
      catch (Exception localException2)
      {
        Object localObject3;
        localObject2 = null;
        continue;
      }
      try
      {
        if (((JSONObject)localObject2).has("publicaccount"))
        {
          localObject3 = ((JSONObject)localObject2).getJSONObject("publicaccount");
          AtomicInteger localAtomicInteger = this.cq;
          if (((JSONObject)localObject3).getBoolean("switch"))
          {
            localAtomicInteger.set(i);
            localObject3 = localObject2;
          }
        }
        else
        {
          if (localObject3 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQComicPreloadManager", 2, "cannot resolve strategy from server.");
            }
            return;
            return;
            ((Exception)localObject3).printStackTrace();
            localObject3 = localObject2;
            continue;
          }
          localObject3 = avcn.b.a((JSONObject)localObject3);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new avcn.b();
            ((avcn.b)localObject2).dmh = true;
            ((avcn.b)localObject2).ewu = 127;
            ((avcn.b)localObject2).ewv = 16777215;
            ((avcn.b)localObject2).dmo = true;
            ((avcn.b)localObject2).dmi = true;
            ((avcn.b)localObject2).dmk = true;
            ((avcn.b)localObject2).dml = true;
            ((avcn.b)localObject2).dmp = true;
            ((avcn.b)localObject2).ewx = 24;
            ((avcn.b)localObject2).dmq = true;
            ((avcn.b)localObject2).ewy = 20;
            ((avcn.b)localObject2).dmr = true;
            ((avcn.b)localObject2).ewz = 6;
            ((avcn.b)localObject2).ewA = 1;
            ((avcn.b)localObject2).ewB = 3;
          }
          this.g.set(localObject2);
          return;
        }
      }
      catch (Exception localException1)
      {
        continue;
        i = 0;
      }
    }
  }
  
  public void ezu()
  {
    String str = this.mApp.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", aqmc.dw());
    int i = PB();
    localSharedPreferences.edit().putInt(str + "_" + "use_times", i + 1).commit();
    i = Calendar.getInstance().get(11);
    int j = localSharedPreferences.getInt(str + "_" + "use_times" + "_" + i, 0);
    localSharedPreferences.edit().putInt(str + "_" + "use_times" + "_" + i, j + 1).commit();
  }
  
  public long iL()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", aqmc.dw()).getLong(this.mApp.getCurrentAccountUin() + "_" + "active_time", 0L);
  }
  
  public void nC(long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qqcomic_preload_profile", aqmc.dw()).edit().putLong(this.mApp.getCurrentAccountUin() + "_" + "active_time", paramLong).commit();
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    this.dX.clear();
  }
  
  public void sI(int paramInt)
  {
    avco.a(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcq
 * JD-Core Version:    0.7.0.1
 */