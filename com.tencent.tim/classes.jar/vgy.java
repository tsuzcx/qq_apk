import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class vgy
  implements DialogInterface.OnClickListener, QQPermissionCallback
{
  private static final String[] EXPLAINS = { acfp.m(2131703792), "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n请在设置中开启电话权限或存储空间，以正常使用QQ功能。" };
  private static final String[] PERMS = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private vgy.a a;
  private AppActivity mAct;
  
  private void a(AppActivity paramAppActivity, int paramInt)
  {
    String str2 = auri.Fi();
    String str1 = "0X800A9DE";
    if ((paramAppActivity instanceof RegisterPhoneNumActivity)) {
      str1 = "0X800A9DF";
    }
    anot.c(null, "dc00898", "", "", str1, str1, paramInt, 0, "", "", str2, "");
  }
  
  public void a(vgy.a parama)
  {
    this.a = parama;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.reject();
    }
    a(this.mAct, 2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("AutoMonitor", 1, "grant" + paramInt);
    if (this.a != null) {
      this.a.bK();
    }
    a(this.mAct, 1);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.mAct.getPackageName(), null));
      this.mAct.startActivity(paramDialogInterface);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bK();
    
    public abstract void reject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgy
 * JD-Core Version:    0.7.0.1
 */