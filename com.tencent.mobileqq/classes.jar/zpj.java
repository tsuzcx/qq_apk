import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zpj
  implements oxs
{
  zpj(zpf paramzpf, JSONObject paramJSONObject, String paramString, JSONArray paramJSONArray, Bundle paramBundle) {}
  
  public void a(long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, @Nullable String paramString1, @Nullable String paramString2, int paramInt3, boolean paramBoolean2)
  {
    paramInt3 = 0;
    if (paramBoolean1) {}
    for (paramInt2 = 0;; paramInt2 = -2)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", paramInt2);
        this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramString1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment", this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
          break;
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("linkDataList", this.jdField_a_of_type_OrgJsonJSONArray);
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult put create comment result error.");
          continue;
          paramInt2 = paramInt3;
          if (paramInt1 == -4096) {
            paramInt2 = 1;
          }
        }
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("errorType", paramInt2);
      this.jdField_a_of_type_AndroidOsBundle.putString("BUNDLE_KEY_JS_OBJ", this.jdField_a_of_type_OrgJsonJSONObject.toString());
      this.jdField_a_of_type_Zpf.a.a(154, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpj
 * JD-Core Version:    0.7.0.1
 */