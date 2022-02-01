import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

class igt
  implements DialogInterface.OnClickListener
{
  igt(igs paramigs, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      igs.a(this.a);
      paramDialogInterface = new Intent(this.u, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", "https://ti.qq.com/realname/index.html?source=watchtogether");
      this.u.startActivityForResult(paramDialogInterface, 21001);
      if (QLog.isColorLevel()) {
        QLog.i("RealNameVideoProcessHelper", 2, "showRealNameDialog click confirm.");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igt
 * JD-Core Version:    0.7.0.1
 */