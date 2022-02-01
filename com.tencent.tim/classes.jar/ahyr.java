import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ahyr
  extends aquy
{
  public ahyr(String paramString) {}
  
  public void onDone(aquz paramaquz)
  {
    PayLikeFloatViewBuilder.access$002(false);
    if (paramaquz.errCode == 0)
    {
      paramaquz = new File(this.val$path + ".tmp");
      if (paramaquz.exists()) {
        paramaquz.renameTo(new File(this.val$path));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahyr
 * JD-Core Version:    0.7.0.1
 */