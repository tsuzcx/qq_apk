package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import wjw;

public class AppGuideTipsManager$1
  implements Runnable
{
  public AppGuideTipsManager$1(wjw paramwjw) {}
  
  public void run()
  {
    wjw.a(this.this$0);
    this.this$0.bYy();
    wjw.a(this.this$0).clear();
    ArrayList localArrayList = (ArrayList)wjw.a(this.this$0).query(AppGuideTipsConfig.class, AppGuideTipsConfig.class.getSimpleName(), false, null, null, null, null, null, null);
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
        wjw.a(this.this$0).put(localAppGuideTipsConfig.tipsType, localAppGuideTipsConfig);
        i += 1;
        break label71;
        wjw.a(this.this$0, true);
        this.this$0.bYw();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(wjw.TAG, 2, "loadConfig, mTipsMap size=" + wjw.a(this.this$0).size());
        return;
      }
      catch (Exception localException)
      {
        break label174;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AppGuideTipsManager.1
 * JD-Core Version:    0.7.0.1
 */