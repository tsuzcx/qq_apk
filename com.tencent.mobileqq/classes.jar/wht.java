import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.StackBlur;

public class wht
  implements Runnable
{
  public wht(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.a(this.a.app.a(this.a.a, (byte)1, true));
    if (localBitmap != null) {}
    try
    {
      StackBlur.a(localBitmap, 10);
      this.a.runOnUiThread(new whu(this, localBitmap));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */