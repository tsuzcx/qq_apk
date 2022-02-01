import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;
import org.json.JSONObject;

public class aijo
  implements QQPermissionCallback
{
  public aijo(MediaApiPlugin paramMediaApiPlugin, Intent paramIntent, Context paramContext, String paramString, JSONObject paramJSONObject, boolean paramBoolean, BasePluginActivity paramBasePluginActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d(MediaApiPlugin.TAG, 1, "User requestPermissions RECORD_AUDIO denied");
    aqha.a(this.f.getOutActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    try
    {
      this.this$0.startActivityForResult(this.A, (byte)1);
      MediaApiPlugin.i(this.U).edit().putString("camera_photo_path", this.Qu).putString("getMediaParam", this.bD.toString()).putBoolean("calledFromOpenApi", this.cku).commit();
      return;
    }
    catch (Exception paramArrayOfString)
    {
      QLog.e(MediaApiPlugin.TAG, 1, paramArrayOfString, new Object[0]);
      QQToast.a(this.U, 2131691243, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aijo
 * JD-Core Version:    0.7.0.1
 */