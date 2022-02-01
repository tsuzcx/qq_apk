import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class txd
  implements qhl
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  private List<ReadInJoyUserInfo> b = new ArrayList();
  
  txd(List paramList, String paramString, BridgeModule paramBridgeModule) {}
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int == 0) {
      b(paramString);
    }
  }
  
  private void b(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)localIterator.next();
        String str = ReadInJoyUserInfoModule.a(localReadInJoyUserInfo);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("headUrl", str).put("nickName", localReadInJoyUserInfo.nick).put("uin", localReadInJoyUserInfo.uin).put("vIconUrl", localReadInJoyUserInfo.smallIconUrl);
        localJSONArray.put(localJSONObject2);
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(paramString, localJSONObject1);
      }
    }
    catch (Exception localException)
    {
      QLog.e("BridgeModuleHelper", 1, localException.getMessage());
    }
    for (;;)
    {
      return;
      localJSONObject1.put("list", localException);
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    a(this.jdField_a_of_type_JavaLangString);
    QLog.e("BridgeModuleHelper", 1, "[onLoadUserInfoFailed]: " + paramString2 + ", uin: " + paramString1);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    this.b.add(paramReadInJoyUserInfo);
    a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txd
 * JD-Core Version:    0.7.0.1
 */