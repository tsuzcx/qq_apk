import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class tqa
  implements IIconListener
{
  public tqa(QQSettingMe paramQQSettingMe) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.c) && (paramBitmap != null) && (QQSettingMe.a(this.a).a().actionId == paramInt1) && (paramInt2 == 200)) {
      this.a.B();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqa
 * JD-Core Version:    0.7.0.1
 */