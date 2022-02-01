import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;

public class aoau
{
  protected aoar a;
  TeamWorkFileImportInfo e;
  
  public aoau(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    this.e = paramTeamWorkFileImportInfo;
    if (paramQQAppInterface != null) {
      this.a = ((aoar)paramQQAppInterface.getBusinessHandler(120));
    }
  }
  
  protected void QI(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (aqhq.fileExistsAndNotEmpty(this.e.filePath)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJob", 2, "---notifyUIFailed try local fileName: " + this.e.fileName);
      }
      this.a.l(this.e);
      this.e.cKX = false;
      this.a.k(this.e);
      this.a.o(this.e);
    }
    for (;;)
    {
      if (i != 0) {
        this.a.m(this.e);
      }
      return;
      i = 1;
    }
  }
  
  public void ei(QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoau
 * JD-Core Version:    0.7.0.1
 */