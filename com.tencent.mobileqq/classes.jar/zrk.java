import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zrk
  implements bezd
{
  zrk(List paramList, String paramString, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, zrl paramzrl) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramJSONObject != null) {}
    for (;;)
    {
      aswh localaswh;
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
            localObject = new aswh();
            ((aswh)localObject).jdField_a_of_type_Boolean = true;
            ((aswh)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
            this.jdField_a_of_type_JavaUtilList.add(localObject);
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
            localaswh = new aswh();
            paramJSONObject = localJSONArray.getJSONObject(paramInt);
            localaswh.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
            localaswh.jdField_a_of_type_Long = paramJSONObject.getLong("size");
            if (this.jdField_a_of_type_JavaLangString.equals("/"))
            {
              paramJSONObject = "/" + localaswh.jdField_a_of_type_JavaLangString;
              localUUID = UUID.nameUUIDFromBytes((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath + this.jdField_a_of_type_JavaLangString + localaswh.jdField_a_of_type_JavaLangString).getBytes());
              localObject = befa.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath);
              if (localObject == null) {
                break label690;
              }
              paramBundle = (Bundle)localObject;
              if (((String)localObject).length() == 0) {
                break label690;
              }
              paramBundle = UUID.nameUUIDFromBytes((paramBundle + this.jdField_a_of_type_JavaLangString + localaswh.jdField_a_of_type_JavaLangString).getBytes());
              localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
              becp localbecp = ((TroopFileTransferManager)localObject).a(localUUID);
              if (localbecp != null)
              {
                paramBundle = aszt.a(localbecp);
                paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
                paramBundle.zipInnerPath = paramJSONObject;
                paramBundle.isZipInnerFile = true;
                paramBundle.zipType = this.jdField_a_of_type_Int;
                paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
                paramJSONObject = paramBundle;
                paramJSONObject.isZipInnerFile = true;
                localaswh.b = paramJSONObject.nSessionId;
                this.jdField_a_of_type_JavaUtilList.add(localaswh);
                paramInt += 1;
              }
            }
            else
            {
              paramJSONObject = this.jdField_a_of_type_JavaLangString + "/" + localaswh.jdField_a_of_type_JavaLangString;
              continue;
            }
            paramBundle = ((TroopFileTransferManager)localObject).a(paramBundle);
            if (paramBundle == null) {
              break label531;
            }
            paramBundle = aszt.a(paramBundle);
            paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
            paramBundle.zipInnerPath = paramJSONObject;
            paramBundle.isZipInnerFile = true;
            paramBundle.zipType = this.jdField_a_of_type_Int;
            paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
            paramJSONObject = paramBundle;
            continue;
          }
        }
        paramBundle = new FileManagerEntity();
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        if (this.jdField_a_of_type_Zrl != null) {
          this.jdField_a_of_type_Zrl.a(this.jdField_a_of_type_JavaUtilList);
        }
        return;
      }
      label531:
      paramBundle.fileName = localaswh.jdField_a_of_type_JavaLangString;
      paramBundle.fileSize = localaswh.jdField_a_of_type_Long;
      paramBundle.nSessionId = aszt.a().longValue();
      paramBundle.strTroopFilePath = localUUID.toString();
      paramBundle.strTroopFileID = localUUID.toString();
      paramBundle.zipInnerPath = paramJSONObject;
      paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
      paramBundle.peerUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      paramBundle.peerType = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
      paramBundle.busId = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
      paramBundle.cloudType = 4;
      paramBundle.isZipInnerFile = true;
      paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
      paramBundle.zipType = this.jdField_a_of_type_Int;
      paramBundle.TroopUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(paramBundle);
      paramJSONObject = paramBundle;
      continue;
      label690:
      paramBundle = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrk
 * JD-Core Version:    0.7.0.1
 */