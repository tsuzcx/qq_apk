import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.filemanager.activity.FilePreviewActivity;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public class atoc
  extends aulg
{
  public atoc(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if ((FilePreviewActivity.a(this.this$0) != null) && (FilePreviewActivity.a(this.this$0).isShowing())) {
      FilePreviewActivity.a(this.this$0).dismiss();
    }
    if (paramTeamWorkFileImportInfo != null) {
      QQToast.a(this.this$0.app.getApp(), 1, 2131721091, 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoc
 * JD-Core Version:    0.7.0.1
 */