import android.os.Handler;
import com.tencent.tim.teamwork.TeamWorkFileImportActivity;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public class auks
  extends aulg
{
  public auks(TeamWorkFileImportActivity paramTeamWorkFileImportActivity) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (TeamWorkFileImportActivity.a(this.a, TeamWorkFileImportActivity.a(this.a), paramTeamWorkFileImportInfo))
    {
      this.a.handler.removeMessages(7002);
      TeamWorkFileImportActivity.a(this.a);
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (TeamWorkFileImportActivity.a(this.a, TeamWorkFileImportActivity.a(this.a), paramTeamWorkFileImportInfo))
    {
      TeamWorkFileImportActivity.a(this.a, 3);
      this.a.cIx = paramString;
      TeamWorkFileImportActivity.a(this.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auks
 * JD-Core Version:    0.7.0.1
 */