import android.graphics.Bitmap;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.util.FaceDecoder;

public class yig
  extends TroopObserver
{
  public yig(ShowExternalTroopListAdapter paramShowExternalTroopListAdapter) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.a(113, paramString);
    if (localBitmap != null) {
      this.a.a(paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */