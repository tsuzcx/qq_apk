import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public class aula
  extends aukz
{
  FileManagerEntity entity;
  private agie f = new aulb(this);
  
  public aula(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    int i;
    if ((this.c != null) && (paramQQAppInterface != null))
    {
      if ((!this.c.cKX) || (TextUtils.isEmpty(this.c.peerUin))) {
        break label189;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.b().b(this.c.peerUin, this.c.peerType, this.c.msgUniseq);
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForFile))) {
        break label168;
      }
      this.entity = audx.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      if ((this.entity == null) || (TextUtils.isEmpty(this.entity.Uuid))) {
        break label189;
      }
      i = 1;
      paramQQAppInterface.a().a(this.entity.Uuid, this.entity.bSend, this.f);
    }
    for (;;)
    {
      if (i == 0)
      {
        this.c.cKX = false;
        this.a.h(this.c);
      }
      this.a.d(this.c);
      return;
      label168:
      this.entity = paramQQAppInterface.a().c(this.c.nSessionId);
      break;
      label189:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aula
 * JD-Core Version:    0.7.0.1
 */