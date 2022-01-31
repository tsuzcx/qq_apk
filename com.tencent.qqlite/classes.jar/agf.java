import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.richstatus.IIconListener;

public class agf
  implements IIconListener
{
  private agf(Contacts paramContacts) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.a) && (paramBitmap != null) && (paramInt2 == 200)) {
      this.a.a(1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agf
 * JD-Core Version:    0.7.0.1
 */