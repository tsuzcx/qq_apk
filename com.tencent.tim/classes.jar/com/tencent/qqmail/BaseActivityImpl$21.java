package com.tencent.qqmail;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

class BaseActivityImpl$21
  implements Runnable
{
  BaseActivityImpl$21(BaseActivityImpl paramBaseActivityImpl, BaseActivityImpl.PageProvider paramPageProvider, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    int j = QMMath.hashInt(this.val$page.getClass().getSimpleName());
    String str2 = (String)this.val$tempTags.get(Integer.valueOf(j));
    Object localObject2 = str2;
    Field[] arrayOfField;
    int i;
    if (str2 == null)
    {
      localObject2 = this.val$page.getClass();
      if (localObject2 == null) {
        return;
      }
      arrayOfField = ((Class)localObject2).getDeclaredFields();
      i = 0;
    }
    for (;;)
    {
      for (;;)
      {
        String str1 = str2;
        if (i < arrayOfField.length)
        {
          arrayOfField[i].setAccessible(true);
          if (!arrayOfField[i].getName().equals("TAG")) {}
        }
        else
        {
          try
          {
            str1 = arrayOfField[i].get(localObject2).toString();
            localObject2 = str1;
            if (str1 != null)
            {
              this.val$tempTags.put(Integer.valueOf(j), str1);
              localObject2 = str1;
            }
            if (localObject2 == null) {
              break;
            }
            if (BaseActivityImpl.curActivityName != null) {
              break label187;
            }
            BaseActivityImpl.curActivityName = (String)localObject2;
            return;
          }
          catch (Exception localException)
          {
            QMLog.log(6, "BaseActivityImpl", "log clickstream err:" + localException.toString());
            return;
          }
        }
      }
      i += 1;
    }
    label187:
    Object localObject1 = new StringBuilder().append(BaseActivityImpl.curActivityName).append(";");
    BaseActivityImpl.curActivityName = (String)localObject2;
    localObject1 = (String)localObject2;
    QMLog.log(4, "BaseActivityImpl", "clickstream:" + (String)localObject1);
    DataCollector.logClickStream((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.21
 * JD-Core Version:    0.7.0.1
 */