import android.app.Activity;
import android.os.Build.VERSION;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public class alxd
  implements QQPermissionCallback
{
  private alxd.a a;
  private Activity mActivity;
  
  public alxd(Activity paramActivity, alxd.a parama)
  {
    this.mActivity = paramActivity;
    this.a = parama;
  }
  
  public void Qj()
  {
    if (Build.VERSION.SDK_INT < 23) {
      if (this.a != null) {
        this.a.bsH();
      }
    }
    label119:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.mActivity == null);
        if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label119;
          }
          if (!(this.mActivity instanceof AppActivity)) {
            break;
          }
          ((AppActivity)this.mActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
      } while (!(this.mActivity instanceof BaseActivity));
      ((BaseActivity)this.mActivity).requestPermissions(this, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    } while (this.a == null);
    this.a.bsH();
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    aqha.a(this.mActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a != null) {
      this.a.bsH();
    }
  }
  
  public static abstract interface a
  {
    public abstract void bsH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxd
 * JD-Core Version:    0.7.0.1
 */