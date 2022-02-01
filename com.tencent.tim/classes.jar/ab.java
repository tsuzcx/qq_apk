import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.dataline.activities.LiteActivity.14.1;
import com.dataline.activities.LiteActivity.b;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public final class ab
  implements LiteActivity.b
{
  public ab(IphoneTitleBarActivity paramIphoneTitleBarActivity, String paramString, ViewGroup paramViewGroup) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap != null) || (paramBoolean)) {
      new Handler(Looper.getMainLooper()).post(new LiteActivity.14.1(this, paramBoolean, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ab
 * JD-Core Version:    0.7.0.1
 */