import android.os.Handler;
import android.os.Looper;
import com.dataline.activities.LiteActivity.19.1;
import com.dataline.activities.LiteActivity.a;
import com.tencent.mobileqq.app.QQAppInterface;

public final class af
  implements LiteActivity.a
{
  public af(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onResult(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new LiteActivity.19.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */