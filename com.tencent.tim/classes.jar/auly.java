import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.teamworkforgroup.GroupTeamAddLinkDlg;

public class auly
  implements DialogInterface.OnClickListener
{
  public auly(GroupTeamAddLinkDlg paramGroupTeamAddLinkDlg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GroupTeamAddLinkDlg.a(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auly
 * JD-Core Version:    0.7.0.1
 */