import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class wlo
  implements azgl
{
  wlo(List paramList, String paramString, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, int paramInt, wlx paramwlx) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramJSONObject != null) {}
    for (;;)
    {
      aoys localaoys;
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
            localObject = new aoys();
            ((aoys)localObject).jdField_a_of_type_Boolean = true;
            ((aoys)localObject).jdField_a_of_type_JavaLangString = paramBundle.getString(paramInt);
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
            localaoys = new aoys();
            paramJSONObject = localJSONArray.getJSONObject(paramInt);
            localaoys.jdField_a_of_type_JavaLangString = paramJSONObject.getString("filename");
            localaoys.jdField_a_of_type_Long = paramJSONObject.getLong("size");
            if (this.jdField_a_of_type_JavaLangString.equals("/"))
            {
              paramJSONObject = "/" + localaoys.jdField_a_of_type_JavaLangString;
              localUUID = UUID.nameUUIDFromBytes((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath + this.jdField_a_of_type_JavaLangString + localaoys.jdField_a_of_type_JavaLangString).getBytes());
              localObject = ayrz.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath);
              if (localObject == null) {
                break label690;
              }
              paramBundle = (Bundle)localObject;
              if (((String)localObject).length() == 0) {
                break label690;
              }
              paramBundle = UUID.nameUUIDFromBytes((paramBundle + this.jdField_a_of_type_JavaLangString + localaoys.jdField_a_of_type_JavaLangString).getBytes());
              localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
              ayqd localayqd = ((TroopFileTransferManager)localObject).a(localUUID);
              if (localayqd != null)
              {
                paramBundle = apck.a(localayqd);
                paramBundle.zipFilePath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
                paramBundle.zipInnerPath = paramJSONObject;
                paramBundle.isZipInnerFile = true;
                paramBundle.zipType = this.jdField_a_of_type_Int;
                paramBundle.selfUin = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.selfUin;
                paramJSONObject = paramBundle;
                paramJSONObject.isZipInnerFile = true;
                localaoys.b = paramJSONObject.nSessionId;
                this.jdField_a_of_type_JavaUtilList.add(localaoys);
                paramInt += 1;
              }
            }
            else
            {
              paramJSONObject = this.jdField_a_of_type_JavaLangString + "/" + localaoys.jdField_a_of_type_JavaLangString;
              continue;
            }
            paramBundle = ((TroopFileTransferManager)localObject).a(paramBundle);
            if (paramBundle == null) {
              break label531;
            }
            paramBundle = apck.a(paramBundle);
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
        if (this.jdField_a_of_type_Wlx != null) {
          this.jdField_a_of_type_Wlx.a(this.jdField_a_of_type_JavaUtilList);
        }
        return;
      }
      label531:
      paramBundle.fileName = localaoys.jdField_a_of_type_JavaLangString;
      paramBundle.fileSize = localaoys.jdField_a_of_type_Long;
      paramBundle.nSessionId = apck.a().longValue();
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBundle);
      paramJSONObject = paramBundle;
      continue;
      label690:
      paramBundle = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wlo
 * JD-Core Version:    0.7.0.1
 */