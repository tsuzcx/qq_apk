import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class aoav
  extends aoau
{
  FileManagerEntity entity;
  private agie f = new aoaw(this);
  
  public aoav(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private boolean v(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (TextUtils.isEmpty(paramJSONObject.optString("ownertype"))) {
      return false;
    }
    return true;
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    if ((this.e != null) && (paramQQAppInterface != null))
    {
      if ((!this.e.cKX) || (TextUtils.isEmpty(this.e.peerUin))) {
        break label247;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.b().b(this.e.peerUin, this.e.peerType, this.e.msgUniseq);
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForFile))) {
        break label226;
      }
      this.e.bxe = localMessageRecord.senderuin;
      this.entity = ahav.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      if (this.entity == null) {
        this.entity = paramQQAppInterface.a().a(this.e.msgUniseq, this.e.peerUin, this.e.peerType);
      }
      if ((this.entity == null) || (TextUtils.isEmpty(this.entity.Uuid))) {
        break label247;
      }
      paramQQAppInterface.a().a(this.entity.Uuid, this.entity.fileIdCrc, this.entity.bSend, false, this.f);
    }
    label226:
    label247:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.e.cKX = false;
        this.a.o(this.e);
      }
      this.a.k(this.e);
      return;
      this.entity = paramQQAppInterface.a().c(this.e.nSessionId);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoav
 * JD-Core Version:    0.7.0.1
 */