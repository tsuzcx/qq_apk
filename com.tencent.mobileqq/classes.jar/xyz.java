import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.selectmember.TroopListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;

public class xyz
  extends TroopObserver
{
  public xyz(TroopListAdapter paramTroopListAdapter) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.a(113, paramString, false, 0);
    if (localBitmap != null) {
      TroopListAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyz
 * JD-Core Version:    0.7.0.1
 */