import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;

public class vcn
  implements DialogInterface.OnClickListener
{
  public vcn(ShortVideoItemBuilder paramShortVideoItemBuilder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcn
 * JD-Core Version:    0.7.0.1
 */