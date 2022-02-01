import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class agbn
  extends aobe
{
  public agbn(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.this$0) != null) && (FilePreviewActivity.a(this.this$0).isShowing())) {
      FilePreviewActivity.a(this.this$0).dismiss();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.this$0) != null) && (FilePreviewActivity.a(this.this$0).isShowing())) {
      FilePreviewActivity.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbn
 * JD-Core Version:    0.7.0.1
 */