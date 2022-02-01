package com.tencent.mobileqq.webprocess;

import android.text.TextUtils;
import aqhq;
import aqpi;
import aqpi.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class WebProcessManager$6
  implements Runnable
{
  WebProcessManager$6(List paramList) {}
  
  public void run()
  {
    try
    {
      if (WebProcessManager.access$100() == -1)
      {
        Object localObject = new File(BaseApplicationImpl.getContext().getFilesDir(), aqpi.e.cuN);
        if ((localObject == null) || (!((File)localObject).exists()))
        {
          WebProcessManager.access$102(-1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WebProcessManager", 2, "null == file || !file.exists() = true,return!");
          return;
        }
        localObject = aqhq.readFileContent((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          WebProcessManager.access$102(-1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WebProcessManager", 2, "TextUtils.isEmpty(JsonStr) = true,return!");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("WebProcessManager", 2, "UnKnownHost Exception!", localException);
        return;
        if (new JSONObject(localException).getBoolean("use_dns")) {}
        for (int i = 1;; i = 0)
        {
          WebProcessManager.access$102(i);
          if (QLog.isColorLevel()) {
            QLog.i("WebProcessManager", 2, "isNeedPreparseDns :" + WebProcessManager.access$100());
          }
          if (WebProcessManager.access$100() != 1) {
            break;
          }
          Iterator localIterator = this.val$list.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            long l = System.currentTimeMillis();
            InetAddress.getByName(str);
            l = System.currentTimeMillis() - l;
            if (QLog.isColorLevel()) {
              QLog.i("WebStatusReport", 2, "time used:" + l);
            }
            WebProcessManager.by(str, l);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager.6
 * JD-Core Version:    0.7.0.1
 */