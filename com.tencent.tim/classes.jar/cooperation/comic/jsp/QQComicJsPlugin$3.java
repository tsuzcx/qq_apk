package cooperation.comic.jsp;

import android.os.SystemClock;
import android.text.TextUtils;
import avdn;
import aveb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQComicJsPlugin$3
  implements Runnable
{
  public QQComicJsPlugin$3(avdn paramavdn, long paramLong, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall start");
    }
    if (!aveb.dmO)
    {
      aveb.gl(BaseApplication.getContext());
      for (long l = 0L; (!aveb.dmO) && (l < this.val$timeout); l += 50L) {
        SystemClock.sleep(50L);
      }
    }
    if (aveb.dmO) {
      ThreadManager.getUIHandler().post(new QQComicJsPlugin.3.1(this));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall end");
      }
      return;
      if (TextUtils.isEmpty(this.val$callbackId)) {
        continue;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 2001);
        localJSONObject.put("message", "QQComic is not ready");
        avdn.a(this.this$0, this.val$callbackId, new String[] { localJSONObject.toString() });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.jsp.QQComicJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */