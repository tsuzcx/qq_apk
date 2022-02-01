import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class aobb
  extends aoau
{
  private smq.m a;
  FileManagerEntity entity;
  
  public aobb(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramTeamWorkFileImportInfo, paramQQAppInterface);
    this.jdField_a_of_type_Smq$m = new aobc(this);
  }
  
  private FileManagerEntity a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null) || (paramString2.length() == 0)) {
      paramQQAppInterface = null;
    }
    Object localObject;
    do
    {
      do
      {
        return paramQQAppInterface;
        paramQQAppInterface = paramQQAppInterface.a();
        localObject = paramQQAppInterface.eW();
        if (localObject == null) {
          paramQQAppInterface.init();
        }
        if (localObject == null) {
          return null;
        }
        paramQQAppInterface = ((List)localObject).iterator();
        do
        {
          if (!paramQQAppInterface.hasNext()) {
            break;
          }
          localObject = (FileManagerEntity)paramQQAppInterface.next();
        } while ((((FileManagerEntity)localObject).peerUin == null) || (!TextUtils.equals(paramString1, ((FileManagerEntity)localObject).strTroopFileID)) || (!((FileManagerEntity)localObject).peerUin.equals(paramString2)));
        paramQQAppInterface = (QQAppInterface)localObject;
      } while (((FileManagerEntity)localObject).cloudType != 1);
      paramQQAppInterface = (QQAppInterface)localObject;
    } while (!ahav.o((FileManagerEntity)localObject));
    ((FileManagerEntity)localObject).status = 16;
    return localObject;
    return null;
  }
  
  private boolean v(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while ((TextUtils.isEmpty(paramJSONObject.optString("groupuin"))) || (TextUtils.isEmpty(paramJSONObject.optString("businesstype")))) {
      return false;
    }
    return true;
  }
  
  public void ei(QQAppInterface paramQQAppInterface)
  {
    int j = 1;
    int i;
    if ((this.e != null) && (paramQQAppInterface != null))
    {
      if ((!this.e.cKX) || (this.e.peerType != 1) || (TextUtils.isEmpty(this.e.cjE)) || (this.e.dNP == 0) || (TextUtils.isEmpty(this.e.peerUin))) {
        break label417;
      }
      Object localObject = new apbr();
      ((apbr)localObject).Id = UUID.nameUUIDFromBytes(this.e.cjE.getBytes());
      ((apbr)localObject).mFileId = this.e.cjE;
      ((apbr)localObject).str_file_name = this.e.fileName;
      ((apbr)localObject).dTg = this.e.dNP;
      localObject = new TroopFileTransferManager.Item((apbr)localObject);
      ((TroopFileTransferManager.Item)localObject).FileName = this.e.fileName;
      smq.a(paramQQAppInterface, Long.valueOf(this.e.peerUin).longValue(), (TroopFileTransferManager.Item)localObject, 0, false, false, this.jdField_a_of_type_Smq$m);
      localObject = paramQQAppInterface.b().b(this.e.peerUin, this.e.peerType, this.e.msgUniseq);
      if (localObject == null) {
        break label404;
      }
      this.entity = paramQQAppInterface.a().b(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop);
      if (this.entity == null) {
        this.entity = paramQQAppInterface.a().b(this.e.nSessionId);
      }
      if ((this.entity != null) && (TextUtils.isEmpty(this.entity.strFileMd5))) {
        this.entity = a(paramQQAppInterface, this.entity.strTroopFileID, ((MessageRecord)localObject).frienduin);
      }
      if (this.entity != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.entity.strFileMd5)) {}
      }
      else
      {
        this.entity = paramQQAppInterface.a().a(((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).frienduin, this.e.peerType, this.e.nSessionId);
        i = j;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.e.cKX = false;
        this.jdField_a_of_type_Aoar.o(this.e);
      }
      this.jdField_a_of_type_Aoar.k(this.e);
      return;
      label404:
      QLog.w("TeamWorkFileImportJobForGroup", 2, "can not find message");
      i = j;
      continue;
      label417:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobb
 * JD-Core Version:    0.7.0.1
 */