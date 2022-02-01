import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfSwitchStrategy;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport.BoyItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class alwz
{
  private static alwz a;
  private int dyH = -1;
  
  public static alwz a()
  {
    if (a == null) {
      a = new alwz();
    }
    return a;
  }
  
  public void b(BoyDataReport paramBoyDataReport)
  {
    HashMap localHashMap = new HashMap();
    paramBoyDataReport = paramBoyDataReport.mBoyData.iterator();
    Object localObject2;
    while (paramBoyDataReport.hasNext())
    {
      localObject1 = (BoyDataReport.BoyItem)paramBoyDataReport.next();
      if (localHashMap.containsKey(((BoyDataReport.BoyItem)localObject1).mId))
      {
        localObject2 = (alwz.a)localHashMap.get(((BoyDataReport.BoyItem)localObject1).mId);
        ((alwz.a)localObject2).dKA();
        if (((BoyDataReport.BoyItem)localObject1).status >= 1) {
          ((alwz.a)localObject2).dKz();
        }
      }
      else
      {
        localObject2 = ((BoyDataReport.BoyItem)localObject1).mId;
        if (((BoyDataReport.BoyItem)localObject1).status >= 1) {}
        for (int i = 1;; i = 0)
        {
          localObject2 = new alwz.a((String)localObject2, 1, i);
          localHashMap.put(((BoyDataReport.BoyItem)localObject1).mId, localObject2);
          break;
        }
      }
    }
    paramBoyDataReport = new HashMap();
    paramBoyDataReport.put("param_manufacture", Build.MANUFACTURER);
    paramBoyDataReport.put("param_model", Build.MODEL);
    paramBoyDataReport.put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
    Object localObject1 = localHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      paramBoyDataReport.put(localObject2, String.valueOf(((alwz.a)localHashMap.get(localObject2)).Ir()));
    }
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "dg_action_match", true, 0L, 0L, paramBoyDataReport, "");
  }
  
  public void cs(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.dyH == -1) {
      this.dyH = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).getInt("entranceReportAlready", 0);
    }
    Object localObject;
    int i;
    int j;
    anpc localanpc;
    if (this.dyH == 0)
    {
      this.dyH = 1;
      localObject = SdkContext.getInstance().getApplication().getSharedPreferences("QmcfConfig", 4).edit();
      ((SharedPreferences.Editor)localObject).putInt("entranceReportAlready", this.dyH);
      ((SharedPreferences.Editor)localObject).commit();
      i = QmcfManager.getInstance().getCurrSwitchStrategy().getEntranceState();
      j = QmcfManager.getInstance().getCurrFrameType();
      localObject = new HashMap();
      ((HashMap)localObject).put("param_hasPoseEntrance", String.valueOf(paramBoolean1));
      ((HashMap)localObject).put("param_hasFaceEntrance", String.valueOf(paramBoolean2));
      ((HashMap)localObject).put("param_entanceState", String.valueOf(i));
      ((HashMap)localObject).put("param_frameType", String.valueOf(j));
      ((HashMap)localObject).put("param_manufacture", Build.MANUFACTURER);
      ((HashMap)localObject).put("param_model", Build.MODEL);
      ((HashMap)localObject).put("param_sdk", String.valueOf(Build.VERSION.SDK_INT));
      localanpc = anpc.a(BaseApplicationImpl.getContext());
      if ((!paramBoolean1) || (!paramBoolean2)) {
        break label283;
      }
    }
    label283:
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(null, "dg_entrance_state", bool, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.d("DanceGameReporter", 2, String.format("reportDGEntranceState, hasPose[%s], hasFace[%s], state[%s], frameTpye[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(i), Integer.valueOf(j) }));
      }
      return;
    }
  }
  
  class a
  {
    int dyI;
    String mId;
    int totalCount;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.mId = paramString;
      this.totalCount = paramInt1;
      this.dyI = paramInt2;
    }
    
    public int Ir()
    {
      if (this.totalCount > 0) {
        return this.dyI * 100 / this.totalCount;
      }
      return 0;
    }
    
    public void dKA()
    {
      this.totalCount += 1;
    }
    
    public void dKz()
    {
      this.dyI += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwz
 * JD-Core Version:    0.7.0.1
 */