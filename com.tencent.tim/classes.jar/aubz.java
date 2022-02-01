import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

class aubz
  extends aulg
{
  aubz(auby paramauby) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (this.a.a != null) {
      this.a.a.dkx();
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.isUserClick)) {
      QQToast.a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getApp(), 1, 2131721091, 0).show();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    if (this.a.a != null) {
      this.a.a.dkx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubz
 * JD-Core Version:    0.7.0.1
 */