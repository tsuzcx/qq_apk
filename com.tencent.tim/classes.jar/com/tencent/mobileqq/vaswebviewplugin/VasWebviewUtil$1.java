package com.tencent.mobileqq.vaswebviewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqhq;
import aqpi;
import aqpi.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

final class VasWebviewUtil$1
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("WebView_X5_Report", 4);
        long l = ((SharedPreferences)localObject1).getLong("read_vas_asyncCookie", 0L);
        if (System.currentTimeMillis() - l < 600000L) {
          return;
        }
        ((SharedPreferences)localObject1).edit().putLong("read_vas_asyncCookie", System.currentTimeMillis()).commit();
        localObject1 = aqhq.readFileContent(new File(BaseApplicationImpl.getContext().getFilesDir(), aqpi.e.cuN));
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          break;
        }
        localObject1 = new JSONObject((String)localObject1);
        if ((localObject1 != null) && (((JSONObject)localObject1).has("cookies")))
        {
          localObject1 = ((JSONObject)localObject1).getJSONObject("cookies");
          if (localObject1 == null) {
            break;
          }
          VasWebviewUtil.mAsyncCookiesForVas.clear();
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (!localIterator.hasNext()) {
            break;
          }
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject1).getString(str1);
          VasWebviewUtil.mAsyncCookiesForVas.put(str1, str2);
          QLog.i("VasWebviewUtil", 1, "use async cookies, vas business id: " + str1 + ", value:" + str2);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasWebviewUtil", 2, "preparePareAsyncCookie UnKnownHost Exception!", localException);
        }
        VasWebviewUtil.mAsyncCookiesForVas.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil.1
 * JD-Core Version:    0.7.0.1
 */