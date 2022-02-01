import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class agtv
  implements aprb.a
{
  agtv(agts paramagts, List paramList, String paramString1, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3, String paramString4, short paramShort, String paramString5, int paramInt, String paramString6, smq.j paramj) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.BH.clear();
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
          this.BH.add(locala);
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
          label186:
          FileManagerEntity localFileManagerEntity;
          if (this.val$filePath.equals("/"))
          {
            paramJSONObject = "/" + locala.name;
            localFileManagerEntity = new FileManagerEntity();
            localFileManagerEntity.fileName = locala.name;
            localFileManagerEntity.fileSize = locala.size;
            localFileManagerEntity.nRelatedSessionId = this.b.nSessionId;
            localFileManagerEntity.mContext = this.b.Uuid;
            localFileManagerEntity.nSessionId = ahav.d().longValue();
            if (this.ccV)
            {
              localFileManagerEntity.WeiYunFileId = this.bGz;
              localFileManagerEntity.mContext = this.b.WeiYunFileId;
              localFileManagerEntity.nRelatedSessionId = ahav.N(this.b.fileSize);
            }
            localFileManagerEntity.zipFileId = this.b.WeiYunFileId;
            if (localFileManagerEntity.mContext == null) {
              QLog.i("FileBrowserModelBase", 1, "zip list file content is empty. zipSessionId[" + this.b.nSessionId + "] zipIsWeiyunFile[" + this.ccV + "] zipCouldType[" + this.b.cloudType + "] fileSessionId[" + localFileManagerEntity.nSessionId + "]");
            }
            if ((this.ccV) || (!this.ccW) || (TextUtils.isEmpty(this.bGA))) {
              break label679;
            }
            localFileManagerEntity.strServerPath = ("https://" + this.val$domain + ":" + this.ad + "/ftn_compress_getfile/rkey=" + this.bGB + "&filetype=" + this.val$fileType + "&path=" + aurr.encodeUrl(paramJSONObject) + "&");
            localFileManagerEntity.httpsDomain = this.bGA;
          }
          for (;;)
          {
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
            this.jdField_a_of_type_Agts.mAppInterface.a().v(localFileManagerEntity);
            this.BH.add(locala);
            paramInt += 1;
            break;
            paramJSONObject = this.val$filePath + "/" + locala.name;
            break label186;
            label679:
            localFileManagerEntity.strServerPath = ("http://" + this.val$domain + ":" + this.bGC + "/ftn_compress_getfile/rkey=" + this.bGB + "&filetype=" + this.val$fileType + "&path=" + aurr.encodeUrl(paramJSONObject) + "&");
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      if (this.jdField_a_of_type_Smq$j != null) {
        this.jdField_a_of_type_Smq$j.fe(this.BH);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agtv
 * JD-Core Version:    0.7.0.1
 */