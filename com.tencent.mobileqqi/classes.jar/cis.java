import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.widget.Toast;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.DoodleTextView;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

public class cis
  extends Handler
{
  public cis(DoodleActivity paramDoodleActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
      this.a.a.c();
      return;
    case 1: 
      QQToast.a(this.a, "已达到上限，无法输入", 0).b(this.a.d());
      return;
    case 2: 
      this.a.a.b();
      sendEmptyMessageDelayed(2, 600L);
      return;
    }
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
      {
        this.a.c();
        return;
      }
      Toast.makeText(this.a.b.a(), 2131562046, 0).show();
      return;
    }
    Toast.makeText(this.a.b.a(), 2131562824, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cis
 * JD-Core Version:    0.7.0.1
 */