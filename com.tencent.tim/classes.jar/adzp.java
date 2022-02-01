import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;

public class adzp
  implements DialogInterface.OnClickListener
{
  public adzp(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    CardPicGalleryActivity.a(this.a, this.x, this.val$targetPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzp
 * JD-Core Version:    0.7.0.1
 */