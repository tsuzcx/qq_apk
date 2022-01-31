import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class gwx
  implements DialogInterface.OnClickListener
{
  public gwx(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoPlayLogic.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gwx
 * JD-Core Version:    0.7.0.1
 */