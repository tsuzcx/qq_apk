import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class ujp
  implements Runnable
{
  public ujp(AppGuideTipsManager paramAppGuideTipsManager) {}
  
  public void run()
  {
    AppGuideTipsManager.a(this.a);
    this.a.c();
    AppGuideTipsManager.a(this.a).clear();
    ArrayList localArrayList = (ArrayList)AppGuideTipsManager.a(this.a).a(AppGuideTipsConfig.class, AppGuideTipsConfig.class.getSimpleName(), false, null, null, null, null, null, null);
    if ((localArrayList == null) || (localArrayList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      label71:
      AppGuideTipsConfig localAppGuideTipsConfig;
      String[] arrayOfString;
      int j;
      if (i < localArrayList.size())
      {
        localAppGuideTipsConfig = (AppGuideTipsConfig)localArrayList.get(i);
        if ((localAppGuideTipsConfig != null) && (!TextUtils.isEmpty(localAppGuideTipsConfig.tipsType))) {
          if (!TextUtils.isEmpty(localAppGuideTipsConfig.msgTypeStr))
          {
            arrayOfString = localAppGuideTipsConfig.msgTypeStr.split("\\|");
            if (arrayOfString != null)
            {
              j = 0;
              label137:
              if (j >= arrayOfString.length) {}
            }
          }
        }
      }
      try
      {
        int k = Integer.valueOf(arrayOfString[j]).intValue();
        localAppGuideTipsConfig.msgTypeMap.put(Integer.valueOf(k), Boolean.valueOf(true));
        label174:
        j += 1;
        break label137;
        AppGuideTipsManager.a(this.a).put(localAppGuideTipsConfig.tipsType, localAppGuideTipsConfig);
        i += 1;
        break label71;
        AppGuideTipsManager.a(this.a, true);
        this.a.b();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(AppGuideTipsManager.a, 2, "loadConfig, mTipsMap size=" + AppGuideTipsManager.a(this.a).size());
        return;
      }
      catch (Exception localException)
      {
        break label174;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */