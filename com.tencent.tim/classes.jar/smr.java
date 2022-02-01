import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class smr
  implements aprb.a
{
  smr(List paramList, String paramString, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, smq.j paramj) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.pv.clear();
    if (paramJSONObject != null) {}
    for (;;)
    {
      agxi.a locala;
      UUID localUUID;
      try
      {
        Object localObject;
        if (!paramJSONObject.isNull("dirs"))
        {
          paramBundle = paramJSONObject.getJSONArray("dirs");
          paramInt = 0;
          if (paramInt < paramBundle.length())
          {
            localObject = new agxi.a();
            ((agxi.a)localObject).isDir = true;
            ((agxi.a)localObject).name = paramBundle.getString(paramInt);
            this.pv.add(localObject);
            paramInt += 1;
            continue;
          }
        }
        if ((paramJSONObject != null) && (!paramJSONObject.isNull("files")))
        {
          JSONArray localJSONArray = paramJSONObject.getJSONArray("files");
          paramInt = 0;
          if (paramInt < localJSONArray.length())
          {
            locala = new agxi.a();
            paramJSONObject = localJSONArray.getJSONObject(paramInt);
            locala.name = paramJSONObject.getString("filename");
            locala.size = paramJSONObject.getLong("size");
            if (this.val$filePath.equals("/"))
            {
              paramJSONObject = "/" + locala.name;
              localUUID = UUID.nameUUIDFromBytes((this.b.strTroopFilePath + this.val$filePath + locala.name).getBytes());
              localObject = apef.oD(this.b.strTroopFilePath);
              if (localObject == null) {
                break label690;
              }
              paramBundle = (Bundle)localObject;
              if (((String)localObject).length() == 0) {
                break label690;
              }
              paramBundle = UUID.nameUUIDFromBytes((paramBundle + this.val$filePath + locala.name).getBytes());
              localObject = TroopFileTransferManager.a(this.val$app, this.b.TroopUin);
              apcy localapcy = ((TroopFileTransferManager)localObject).a(localUUID);
              if (localapcy != null)
              {
                paramBundle = ahav.a(localapcy);
                paramBundle.zipFilePath = this.b.strTroopFilePath;
                paramBundle.zipInnerPath = paramJSONObject;
                paramBundle.isZipInnerFile = true;
                paramBundle.zipType = this.val$fileType;
                paramBundle.selfUin = this.b.selfUin;
                paramJSONObject = paramBundle;
                paramJSONObject.isZipInnerFile = true;
                locala.sessionId = paramJSONObject.nSessionId;
                this.pv.add(locala);
                paramInt += 1;
              }
            }
            else
            {
              paramJSONObject = this.val$filePath + "/" + locala.name;
              continue;
            }
            paramBundle = ((TroopFileTransferManager)localObject).a(paramBundle);
            if (paramBundle == null) {
              break label531;
            }
            paramBundle = ahav.a(paramBundle);
            paramBundle.zipFilePath = this.b.strTroopFilePath;
            paramBundle.zipInnerPath = paramJSONObject;
            paramBundle.isZipInnerFile = true;
            paramBundle.zipType = this.val$fileType;
            paramBundle.selfUin = this.b.selfUin;
            paramJSONObject = paramBundle;
            continue;
          }
        }
        paramBundle = new FileManagerEntity();
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        if (this.a != null) {
          this.a.fe(this.pv);
        }
        return;
      }
      label531:
      paramBundle.fileName = locala.name;
      paramBundle.fileSize = locala.size;
      paramBundle.nSessionId = ahav.d().longValue();
      paramBundle.strTroopFilePath = localUUID.toString();
      paramBundle.strTroopFileID = localUUID.toString();
      paramBundle.zipInnerPath = paramJSONObject;
      paramBundle.selfUin = this.b.selfUin;
      paramBundle.peerUin = this.b.peerUin;
      paramBundle.peerType = this.b.peerType;
      paramBundle.busId = this.b.busId;
      paramBundle.cloudType = 4;
      paramBundle.isZipInnerFile = true;
      paramBundle.zipFilePath = this.b.strTroopFilePath;
      paramBundle.zipType = this.val$fileType;
      paramBundle.TroopUin = this.b.TroopUin;
      this.val$app.a().v(paramBundle);
      paramJSONObject = paramBundle;
      continue;
      label690:
      paramBundle = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smr
 * JD-Core Version:    0.7.0.1
 */