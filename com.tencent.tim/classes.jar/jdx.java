import android.view.View;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class jdx
  implements QQPermissionCallback
{
  public jdx(VideoControlUI paramVideoControlUI, String paramString, long paramLong, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.this$0.TAG, 1, "onClick_Camera, deny, i[" + paramInt + "], mRequestPermissionIng[" + this.this$0.Yk + "], permissions[" + AudioHelper.s(paramArrayOfString) + "], grantResults[" + AudioHelper.s(paramArrayOfInt) + "]");
    this.this$0.Yk = false;
    this.this$0.A(this.kQ, this.RI);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.this$0.TAG, 1, "onClick_Camera, grant, i[" + paramInt + "], mRequestPermissionIng[" + this.this$0.Yk + "], permissions[" + AudioHelper.s(paramArrayOfString) + "], grantResults[" + AudioHelper.s(paramArrayOfInt) + "]");
    this.this$0.Yk = false;
    if ("android.permission.CAMERA".equals(this.RI)) {
      this.this$0.d(this.kQ, this.im);
    }
    do
    {
      return;
      if ("android.permission.RECORD_AUDIO".equals(this.RI))
      {
        this.this$0.c(this.kQ, this.im);
        return;
      }
    } while (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(this.RI));
    this.this$0.cX(this.kQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdx
 * JD-Core Version:    0.7.0.1
 */