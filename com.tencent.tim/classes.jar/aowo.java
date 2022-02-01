import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity.a;

public class aowo
  implements URLDrawable.DownloadListener
{
  public aowo(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, TroopCreateLogicActivity.a parama) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$a.ah(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = arwr.e(this.g, 100, 100);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$a.ah(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowo
 * JD-Core Version:    0.7.0.1
 */