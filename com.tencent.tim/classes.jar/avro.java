import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity.4.1;
import cooperation.qzone.QzonePluginProxyActivity.a;
import mqq.os.MqqHandler;

public final class avro
  implements avpw.c
{
  public avro(Intent paramIntent, String paramString, ahyh paramahyh, int paramInt, boolean paramBoolean, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void cK(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = QzonePluginProxyActivity.i(this.val$intent);
    Class localClass = QzonePluginProxyActivity.a.g(str);
    this.val$intent.putExtra("userQqResources", 2);
    this.val$intent.putExtra("click_time", System.currentTimeMillis());
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qzone_plugin.apk";
    locald.mPluginName = "QZone";
    locald.mUin = this.val$uin;
    locald.a = this.b;
    locald.cKu = str;
    locald.K = localClass;
    locald.mIntent = this.val$intent;
    locald.mRequestCode = this.val$requestCode;
    if (this.dov)
    {
      locald.ewU = 2130772162;
      locald.ewV = 2130772162;
    }
    locald.mTimeOut = 60000;
    locald.cKv = null;
    locald.dmV = false;
    ThreadManager.getUIHandler().post(new QzonePluginProxyActivity.4.1(this, str, paramBoolean1, paramBoolean2, locald));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avro
 * JD-Core Version:    0.7.0.1
 */