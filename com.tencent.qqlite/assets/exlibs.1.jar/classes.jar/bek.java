import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class bek
  implements IIconListener
{
  public bek(QQSetting paramQQSetting) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((QQSetting.d(this.a)) && (paramBitmap != null) && (QQSetting.a(this.a).a().b == paramInt1) && (paramInt2 == 201)) {
      this.a.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bek
 * JD-Core Version:    0.7.0.1
 */