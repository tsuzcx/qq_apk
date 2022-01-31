import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.json.JSONObject;

public class bng
  extends Thread
{
  public bng(ScannerActivity paramScannerActivity) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.a.edit();
    localEditor.putLong("lastCheckOrientation", System.currentTimeMillis());
    localEditor.commit();
    Object localObject = "http://qm.qq.com/cgi-bin/check_orientation?product=" + Build.PRODUCT + "&os=" + Build.VERSION.RELEASE;
    try
    {
      String str = HttpUtil.a(this.a, (String)localObject, "GET", null, null);
      QLog.d("QRHttpUtil", 2, "open :" + (String)localObject + ", result: " + str);
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).getInt("r") == 0)
      {
        if (((JSONObject)localObject).getInt("orientation") == 1)
        {
          localEditor.putBoolean("needLandScape", true);
          localEditor.commit();
        }
      }
      else {
        throw new IOException();
      }
    }
    catch (Exception localException)
    {
      localEditor.putLong("lastCheckOrientation", 0L);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bng
 * JD-Core Version:    0.7.0.1
 */