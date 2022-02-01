import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;

public class wrk
  implements DialogInterface.OnClickListener
{
  public wrk(DoodlePanel paramDoodlePanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    if (DoodlePanel.a(this.b) != null) {
      DoodlePanel.a(this.b).ba(false, false);
    }
    DoodlePanel.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrk
 * JD-Core Version:    0.7.0.1
 */