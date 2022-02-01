import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tnj
  implements pea
{
  public tnj(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString) {}
  
  public void a(long paramLong, boolean paramBoolean1, int paramInt1, @Nullable String paramString1, @Nullable String paramString2, int paramInt2, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", -2);
      this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramString1);
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
        return;
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", 0);
        this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramString1);
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
 * Qualified Name:     tnj
 * JD-Core Version:    0.7.0.1
 */