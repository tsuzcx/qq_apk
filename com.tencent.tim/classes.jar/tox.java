import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class tox
  implements agmy.a
{
  public tox(QQMessageFacade paramQQMessageFacade, MessageForFile paramMessageForFile, FileManagerEntity paramFileManagerEntity) {}
  
  public void onError(int paramInt, String paramString)
  {
    if ((paramInt == -6101) || (paramInt == -7003))
    {
      this.b.status = 16;
      QQMessageFacade.a(this.this$0).a().u(this.b);
    }
    QQMessageFacade.a(this.this$0).a().a().g(this.a.frienduin, this.a.istroop, acsb.czz, 0);
  }
  
  public void onSuccess()
  {
    this.this$0.a(this.a.istroop).v(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tox
 * JD-Core Version:    0.7.0.1
 */