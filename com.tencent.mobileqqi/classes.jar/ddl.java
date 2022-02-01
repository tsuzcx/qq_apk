import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class ddl
  implements IIconListener
{
  public ddl(QQSettingMe paramQQSettingMe) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.b) && (paramBitmap != null) && (QQSettingMe.a(this.a).a().b == paramInt1) && (paramInt2 == 200)) {
      this.a.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ddl
 * JD-Core Version:    0.7.0.1
 */