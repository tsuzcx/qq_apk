import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tir
  implements oxs
{
  public tir(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString1, String paramString2) {}
  
  public void a(long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, @Nullable String paramString1, @Nullable String paramString2, int paramInt3, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      paramInt1 = 0;
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", paramInt1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramString1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, this.jdField_a_of_type_OrgJsonJSONObject);
        return;
        paramInt1 = -2;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.e(BridgeModule.TAG, 1, "handleCommentEditorNativeResult put create comment result error.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tir
 * JD-Core Version:    0.7.0.1
 */