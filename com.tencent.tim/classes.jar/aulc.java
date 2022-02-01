import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public class aulc
  extends aukz
{
  FileManagerEntity entity;
  private agie f = new auld(this);
  
  public aulc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    if ((this.c != null) && (paramQQAppInterface != null))
    {
      if ((!this.c.cKX) || (this.c.peerType != 3000) || (TextUtils.isEmpty(this.c.peerUin))) {
        break label198;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.b().b(this.c.peerUin, this.c.peerType, this.c.msgUniseq);
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForFile))) {
        break label198;
      }
      this.entity = audx.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      if ((this.entity == null) || (TextUtils.isEmpty(this.entity.Uuid))) {
        break label198;
      }
      paramQQAppInterface.a().a(this.entity.nSessionId, this.entity.fileName, Long.parseLong(this.entity.peerUin), this.entity.Uuid, this.f);
    }
    label198:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.c.cKX = false;
        this.a.h(this.c);
      }
      this.a.d(this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulc
 * JD-Core Version:    0.7.0.1
 */