import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aumg
  implements DialogInterface.OnClickListener
{
  public aumg(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((aqju)paramDialogInterface).getCheckBoxState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumg
 * JD-Core Version:    0.7.0.1
 */