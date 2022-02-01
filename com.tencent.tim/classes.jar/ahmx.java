import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahmx
  implements aiak.a
{
  public ahmx(DeleteFaceFragment paramDeleteFaceFragment, String paramString1, String paramString2) {}
  
  public void a(FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    if (DeleteFaceFragment.a(this.a))
    {
      QLog.e("DeleteFaceFragment", 1, "getConfSuccess, activity is null");
      return;
    }
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (DeleteFaceFragment.a(this.a).checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        DeleteFaceFragment.a(this.a).requestPermissions(new ahmy(this, paramAppConf), 1, new String[] { "android.permission.CAMERA" });
        return;
        i = 0;
      }
      else
      {
        DeleteFaceFragment.a(this.a, this.bKX, this.val$openId, paramAppConf);
        return;
        i = 1;
      }
    }
  }
  
  public void cz(int paramInt, String paramString)
  {
    if (DeleteFaceFragment.a(this.a))
    {
      QLog.e("DeleteFaceFragment", 1, "getConfFailed, activity is null");
      return;
    }
    this.a.bSZ();
    QLog.e("DeleteFaceFragment", 1, new Object[] { "sendGetTmpKeyRequest error, ", paramString });
    QQToast.a(DeleteFaceFragment.a(this.a), paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmx
 * JD-Core Version:    0.7.0.1
 */