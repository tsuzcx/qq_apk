import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.mobileqq.app.QQAppInterface;

public class zcn
  extends acnd
{
  public zcn(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  protected void h(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.this$0.mApp.a(113, paramString, false, 0);
    if (localBitmap != null) {
      ContactsTroopAdapter.a(this.this$0, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcn
 * JD-Core Version:    0.7.0.1
 */