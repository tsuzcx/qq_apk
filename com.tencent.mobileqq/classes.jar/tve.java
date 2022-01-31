import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class tve
  implements Runnable
{
  public tve(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.a == null) {
      return;
    }
    Object localObject = new JSONObject();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("WebLog_WebViewFragment", 2, "saveTempPadFromQQ: prvurl " + this.jdField_a_of_type_JavaLangString);
      }
      ((JSONObject)localObject).put("prvurl", this.jdField_a_of_type_JavaLangString);
      String str = String.format("https://%s.docs.qq.com/preview/imp/save_to_mylist", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.a.getCurrentAccountUin() });
      localObject = TeamWorkHttpUtils.a((JSONObject)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.a.getCurrentAccountUin(), str, "docs.qq.com");
      this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.c((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tve
 * JD-Core Version:    0.7.0.1
 */