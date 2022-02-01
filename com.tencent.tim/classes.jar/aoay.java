import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class aoay
  extends aoau
{
  FileManagerEntity entity;
  private agie f = new aoaz(this);
  
  public aoay(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
  }
  
  private boolean v(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (TextUtils.isEmpty(paramJSONObject.optString("discussuin"))) {
      return false;
    }
    return true;
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    if ((this.e != null) && (paramQQAppInterface != null))
    {
      if ((!this.e.cKX) || (this.e.peerType != 3000) || (TextUtils.isEmpty(this.e.peerUin))) {
        break label250;
      }
      MessageRecord localMessageRecord = paramQQAppInterface.b().b(this.e.peerUin, this.e.peerType, this.e.msgUniseq);
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForFile))) {
        this.entity = ahav.a(paramQQAppInterface, (MessageForFile)localMessageRecord);
      }
      if (this.entity == null) {
        this.entity = paramQQAppInterface.a().a(this.e.msgUniseq, this.e.peerUin, this.e.peerType);
      }
      if ((this.entity == null) || (TextUtils.isEmpty(this.entity.Uuid)) || (TextUtils.isEmpty(this.entity.peerUin))) {
        break label250;
      }
      paramQQAppInterface.a().a(this.entity.nSessionId, this.entity.fileName, Long.parseLong(this.entity.peerUin), this.entity.Uuid, this.f);
    }
    label250:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.e.cKX = false;
        this.a.o(this.e);
      }
      this.a.k(this.e);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoay
 * JD-Core Version:    0.7.0.1
 */