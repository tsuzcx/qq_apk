import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable.DownloadListener;

public class snv
  implements URLDrawable.DownloadListener
{
  public snv(TroopGiftPanel paramTroopGiftPanel, TextView paramTextView) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.val$tv.setCompoundDrawables(null, null, null, null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snv
 * JD-Core Version:    0.7.0.1
 */