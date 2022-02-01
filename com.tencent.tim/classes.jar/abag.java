import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class abag
  implements DialogInterface.OnClickListener
{
  public abag(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.fp.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abag
 * JD-Core Version:    0.7.0.1
 */