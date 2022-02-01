import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.richstatus.IIconListener;

public class cen
  implements IIconListener
{
  private cen(Contacts paramContacts) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.a) && (paramBitmap != null) && (paramInt2 == 200)) {
      this.a.a(1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cen
 * JD-Core Version:    0.7.0.1
 */