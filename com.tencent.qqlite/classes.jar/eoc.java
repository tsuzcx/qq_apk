import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class eoc
  implements DialogInterface.OnClickListener
{
  public eoc(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoPlayLogic.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eoc
 * JD-Core Version:    0.7.0.1
 */