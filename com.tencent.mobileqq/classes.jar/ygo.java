import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ygo
  extends DownloadListener
{
  public ygo(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, ygq paramygq, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    int i = 0;
    super.onDone(paramDownloadTask);
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Ygq.b) {
          return;
        }
        this.jdField_a_of_type_Ygq.b();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0))
        {
          VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->onDone,complete callback:" + this.jdField_a_of_type_JavaLangString + ",status:" + paramDownloadTask.a() + ",errCode:" + paramDownloadTask.jdField_a_of_type_Int + ",download result:" + i);
          localJSONObject2.put("status", i);
          localJSONObject1.put("code", 0);
          localJSONObject1.put("data", localJSONObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject1.toString() });
          return;
        }
      }
      catch (JSONException paramDownloadTask)
      {
        VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->json execption:" + paramDownloadTask.toString());
        return;
      }
      i = -1;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->onProgress");
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, "-->onStart");
    if (VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin).get(paramDownloadTask.jdField_a_of_type_JavaLangString) == null) {
      VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin).put(paramDownloadTask.jdField_a_of_type_JavaLangString, paramDownloadTask);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ygo
 * JD-Core Version:    0.7.0.1
 */