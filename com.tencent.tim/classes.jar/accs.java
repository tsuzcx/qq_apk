import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class accs
  extends aquy
{
  accs(accr paramaccr) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    paramaquz = paramaquz.getParams();
    if ((paramaquz.containsKey("version")) && (paramaquz.containsKey("json_name")))
    {
      int i = paramaquz.getInt("version", -1);
      paramaquz = paramaquz.getString("json_name");
      if (aqpi.e.cuQ.equals(paramaquz))
      {
        Object localObject = new File(this.this$0.app.getApplication().getApplicationContext().getFilesDir(), aqpi.e.cuN);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = aqhq.readFileContent((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              aqpi.aP(this.this$0.app.getApplication().getApplicationContext(), paramaquz, i);
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update success!");
              }
              boolean bool1 = true;
              if (((JSONObject)localObject).has("enableX5Report"))
              {
                boolean bool2 = ((JSONObject)localObject).getBoolean("enableX5Report");
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.i("ClubContentUpdateHandler", 2, "json file got isEnableX5Report: " + bool2);
                  bool1 = bool2;
                }
              }
              paramaquz = this.this$0.app.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              paramaquz.edit().putBoolean("enableX5Report", bool1).commit();
              paramaquz.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              accr.a(this.this$0, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception paramaquz)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + paramaquz.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accs
 * JD-Core Version:    0.7.0.1
 */