import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;

class agqo
  implements ahal.a
{
  agqo(agqn paramagqn) {}
  
  public void aD()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.a().a(this.a.bIW, null, localQQAppInterface.getAccount(), 0, false);
    ahav.getFileName(this.a.bIW);
    ahao.JG(BaseActivity.sTopActivity.getString(2131694101));
    if (this.a.c != null) {
      this.a.c.au(1);
    }
    if (this.a.c.bY())
    {
      long l = this.a.c.a().fR();
      ahav.l(this.a.c.getApp(), l);
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqo
 * JD-Core Version:    0.7.0.1
 */