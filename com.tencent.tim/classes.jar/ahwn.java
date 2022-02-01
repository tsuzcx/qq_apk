import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ahwn
  implements ahwp.a
{
  ahwn(ahwm paramahwm, int paramInt, String paramString) {}
  
  public void f(Uri paramUri)
  {
    QLog.e("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : onFaild= " + paramUri);
    this.b.mActivity.finish();
  }
  
  public void o(String paramString1, String paramString2, long paramLong)
  {
    QLog.d("CheckForward.Security", 1, "system share.prepareFileInfoAndReq : onFinish= " + paramString1);
    try
    {
      if (this.val$type == 2)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.b.h(paramString2, this.val$action);
        return;
      }
      if (this.val$type == 4)
      {
        paramString2 = new ArrayList();
        paramString2.add(paramString1);
        this.b.i(paramString2, this.val$action);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("CheckForward.Security", 1, "system share.prepareFileInfoAndReq exception=", paramString1);
      return;
    }
    if (this.val$type == 3) {
      this.b.gl(paramString1, this.val$action);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahwn
 * JD-Core Version:    0.7.0.1
 */