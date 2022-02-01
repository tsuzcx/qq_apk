import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.teamwork.TeamWorkFileImportActivity;

public class aukt
  implements DialogInterface.OnClickListener
{
  public aukt(TeamWorkFileImportActivity paramTeamWorkFileImportActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aqmj.e(this.a.app.getApp(), this.a.app.getCurrentAccountUin(), "team_work_file_importing_tips_show", false);
    TeamWorkFileImportActivity.b(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukt
 * JD-Core Version:    0.7.0.1
 */