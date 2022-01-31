import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable.DownloadListener;

public class ywf
  implements URLDrawable.DownloadListener
{
  public ywf(TroopGiftPanel paramTroopGiftPanel, TextView paramTextView) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ywf
 * JD-Core Version:    0.7.0.1
 */