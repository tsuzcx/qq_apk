import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.TroopFileZipPreviewActivity;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class atpf
  implements aprb.a
{
  public atpf(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, List paramList, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, FileManagerEntity paramFileManagerEntity, smq.j paramj) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.pv.clear();
    if (paramJSONObject != null) {}
    try
    {
      agxi.a locala;
      if (!paramJSONObject.isNull("dirs"))
      {
        paramBundle = paramJSONObject.getJSONArray("dirs");
        paramInt = 0;
        while (paramInt < paramBundle.length())
        {
          locala = new agxi.a();
          locala.isDir = true;
          locala.name = paramBundle.getString(paramInt);
          this.pv.add(locala);
          paramInt += 1;
        }
      }
      if ((paramJSONObject != null) && (!paramJSONObject.isNull("files")))
      {
        paramBundle = paramJSONObject.getJSONArray("files");
        paramInt = 0;
        if (paramInt < paramBundle.length())
        {
          locala = new agxi.a();
          paramJSONObject = paramBundle.getJSONObject(paramInt);
          locala.name = paramJSONObject.getString("filename");
          locala.size = paramJSONObject.getLong("size");
          if (this.val$filePath.equals("/")) {}
          for (paramJSONObject = "/" + locala.name;; paramJSONObject = this.val$filePath + "/" + locala.name)
          {
            FileManagerEntity localFileManagerEntity = new FileManagerEntity();
            localFileManagerEntity.fileName = locala.name;
            localFileManagerEntity.strFilePath = (audn.a().vZ() + locala.name);
            localFileManagerEntity.fileSize = locala.size;
            localFileManagerEntity.nSessionId = audx.d().longValue();
            if (this.ccV) {
              localFileManagerEntity.WeiYunFileId = this.bGz;
            }
            localFileManagerEntity.strServerPath = ("http://" + this.val$domain + ":" + this.bGC + "/ftn_compress_getfile/rkey=" + this.bGB + "&filetype=" + this.val$fileType + "&path=" + aurr.encodeUrl(paramJSONObject) + "&");
            localFileManagerEntity.zipInnerPath = paramJSONObject;
            localFileManagerEntity.selfUin = this.b.selfUin;
            localFileManagerEntity.peerUin = this.b.peerUin;
            localFileManagerEntity.peerType = this.b.peerType;
            localFileManagerEntity.busId = this.b.busId;
            localFileManagerEntity.cloudType = 1;
            localFileManagerEntity.isZipInnerFile = true;
            localFileManagerEntity.zipFilePath = this.b.strTroopFilePath;
            localFileManagerEntity.zipType = this.val$fileType;
            localFileManagerEntity.TroopUin = this.b.TroopUin;
            locala.sessionId = localFileManagerEntity.nSessionId;
            this.jdField_a_of_type_ComTencentTimFilemanagerActivityTroopFileZipPreviewActivity.app.a().v(localFileManagerEntity);
            this.pv.add(locala);
            paramInt += 1;
            break;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      if (this.jdField_a_of_type_Smq$j != null) {
        this.jdField_a_of_type_Smq$j.fe(this.pv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpf
 * JD-Core Version:    0.7.0.1
 */