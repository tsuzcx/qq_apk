import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class ufl
  implements BusinessObserver
{
  ufl(ufd paramufd, String paramString1, int paramInt, boolean paramBoolean, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      Object localObject = paramBundle.getByteArray("data");
      if (localObject != null)
      {
        paramBundle = new mobileqq_mp.JSApiWebServerResponse();
        label650:
        label807:
        for (;;)
        {
          try
          {
            paramBundle.mergeFrom((byte[])localObject);
            localObject = (mobileqq_mp.RetInfo)paramBundle.ret_info.get();
            paramBundle = paramBundle.body.get();
            int i = ((mobileqq_mp.RetInfo)localObject).ret_code.get();
            localObject = ((mobileqq_mp.RetInfo)localObject).err_info.get();
            new JSONObject();
            if (i != 0) {
              break label650;
            }
            localObject = new JSONObject(paramBundle);
            int j = ((JSONObject)localObject).optInt("ret");
            paramBundle = ((JSONObject)localObject).optString("msg");
            i = ((JSONObject)localObject).optInt("subcmd");
            if (j != 0) {
              break label494;
            }
            j = ((JSONObject)localObject).optInt("type");
            paramBundle = "";
            if (j == 2)
            {
              paramBundle = ((JSONObject)localObject).optString("url");
              localObject = ((JSONObject)localObject).optString("mediaid");
              if (paramBundle.equals(""))
              {
                JSONObject localJSONObject = new JSONObject();
                try
                {
                  localJSONObject.put("retCode", -1);
                  localJSONObject.put("msg", "mediaId for serverId error");
                  this.jdField_a_of_type_Ufd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
                  this.jdField_a_of_type_Ufd.c((String)localObject);
                  bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                  break label807;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("PublicAccountH5AbilityPlugin", 2, "sendMediaIdForUuidRequest serverId = " + paramBundle + "  type = " + paramInt + " subCom=" + i);
                  return;
                }
                catch (JSONException localJSONException4)
                {
                  localJSONException4.printStackTrace();
                  continue;
                }
              }
            }
            if (j != 4) {
              continue;
            }
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
            this.jdField_a_of_type_Ufd.a(this.jdField_a_of_type_Int, paramBundle, (String)localObject, true, this.jdField_a_of_type_JavaLangString);
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          paramBundle = ((JSONObject)localObject).optString("file_uuid");
          if (paramBundle.equals(""))
          {
            localObject = new JSONObject();
            try
            {
              ((JSONObject)localObject).put("retCode", -1);
              ((JSONObject)localObject).put("msg", "mediaId for serverId error");
              this.jdField_a_of_type_Ufd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
              bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
            }
            catch (JSONException localJSONException3)
            {
              for (;;)
              {
                localJSONException3.printStackTrace();
              }
            }
          }
          else
          {
            localObject = ((JSONObject)localObject).optString("mediaid");
            this.jdField_a_of_type_Ufd.a(this.jdField_a_of_type_Int, paramBundle, (String)localObject, false, this.jdField_a_of_type_JavaLangString);
            continue;
            label494:
            if (QLog.isColorLevel()) {
              QLog.i("PublicAccountH5AbilityPlugin", 2, "sendMediaIdForUuidRequest errorMsg = " + paramBundle);
            }
            paramBundle = new JSONObject();
            try
            {
              paramBundle.put("retCode", -1);
              paramBundle.put("msg", "mediaId for serverId error");
              this.jdField_a_of_type_Ufd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_Ufd.c(this.b);
                bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                return;
              }
            }
            catch (JSONException localJSONException1)
            {
              for (;;)
              {
                localJSONException1.printStackTrace();
              }
              bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.i("PublicAccountH5AbilityPlugin", 2, "sendMediaIdForUuidRequest errorMsg = " + localJSONException1);
            }
            paramBundle = new JSONObject();
            try
            {
              paramBundle.put("retCode", -1);
              paramBundle.put("msg", "mediaId for serverId error");
              this.jdField_a_of_type_Ufd.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_Ufd.c(this.b);
                bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, -1, "1", "", "", "");
                return;
              }
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                localJSONException2.printStackTrace();
              }
              bcef.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, -1, "1", "", "", "");
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufl
 * JD-Core Version:    0.7.0.1
 */