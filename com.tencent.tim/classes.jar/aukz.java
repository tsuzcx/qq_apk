import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public class aukz
{
  protected aukx a;
  TeamWorkFileImportInfo c;
  
  public aukz(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    this.c = paramTeamWorkFileImportInfo;
    if (paramQQAppInterface != null) {
      this.a = ((aukx)paramQQAppInterface.getBusinessHandler(120));
    }
  }
  
  protected void QI(boolean paramBoolean)
  {
    int i = 0;
    if ((paramBoolean) && (aqhq.fileExistsAndNotEmpty(this.c.filePath)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportJob", 2, "---notifyUIFailed try local fileName: " + this.c.fileName);
      }
      this.a.e(this.c);
      this.c.cKX = false;
      this.a.d(this.c);
      this.a.h(this.c);
    }
    for (;;)
    {
      if (i != 0) {
        this.a.f(this.c);
      }
      return;
      i = 1;
    }
  }
  
  public void ei(QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukz
 * JD-Core Version:    0.7.0.1
 */