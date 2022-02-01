import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aegx
  implements aduk.a
{
  public aegx(ConfessPlugin paramConfessPlugin) {}
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("ConfessPlugin", 4, "preLoadQQSelfHeaderBitmap onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
      if ((this.this$0.bs != null) && (this.this$0.mRuntime != null) && (this.this$0.mRuntime.a() != null) && (TextUtils.equals(paramString1, this.this$0.mRuntime.a().getCurrentAccountUin())))
      {
        ThreadManager.getUIHandler().removeCallbacks(ConfessPlugin.a(this.this$0));
        ThreadManager.getUIHandler().post(ConfessPlugin.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegx
 * JD-Core Version:    0.7.0.1
 */