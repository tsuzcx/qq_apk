import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class aoap
  extends aoau
{
  FileManagerEntity entity;
  private agie f = new aoaq(this);
  
  public aoap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    if ((this.e != null) && (paramQQAppInterface != null))
    {
      if ((!this.e.cKX) || (TextUtils.isEmpty(this.e.peerUin))) {
        break label197;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.b().b(this.e.peerUin, this.e.peerType, this.e.msgUniseq);
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForFile))) {
        break label176;
      }
      this.entity = ahav.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      if ((this.entity == null) || (TextUtils.isEmpty(this.entity.Uuid))) {
        break label197;
      }
      paramQQAppInterface.a().a(this.entity.Uuid, this.entity.fileIdCrc, this.entity.bSend, false, this.f);
    }
    label176:
    label197:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.e.cKX = false;
        this.a.r(this.e);
      }
      this.a.k(this.e);
      return;
      this.entity = paramQQAppInterface.a().c(this.e.nSessionId);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoap
 * JD-Core Version:    0.7.0.1
 */