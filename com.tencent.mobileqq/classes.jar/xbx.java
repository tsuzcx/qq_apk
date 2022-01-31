import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class xbx
  implements NearbyCustomDialog.OnClickListener
{
  xbx(xbw paramxbw, String paramString) {}
  
  public void a(View paramView)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    try
    {
      paramView = new JSONObject();
      paramView.put("viewTag", "goldmsg_open");
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("skip_confirm", "1");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ((JSONObject)localObject).put("returl", this.jdField_a_of_type_JavaLangString);
      }
      paramView.put("extra_data", ((JSONObject)localObject).toString());
      localObject = new Bundle();
      ((Bundle)localObject).putString("json", paramView.toString());
      ((Bundle)localObject).putString("callbackSn", "0");
      PayBridgeActivity.a(BaseActivity.sTopActivity, 5, (Bundle)localObject);
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbx
 * JD-Core Version:    0.7.0.1
 */