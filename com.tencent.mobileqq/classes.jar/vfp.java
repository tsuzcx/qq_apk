import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;

public class vfp
  implements DialogInterface.OnClickListener
{
  public vfp(ShortVideoItemBuilder paramShortVideoItemBuilder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfp
 * JD-Core Version:    0.7.0.1
 */