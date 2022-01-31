import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.widget.ButtonInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class xfb
  implements Runnable
{
  public xfb(GoldMsgPayManager paramGoldMsgPayManager, String paramString) {}
  
  public void run()
  {
    if ((BaseActivity.sTopActivity == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
        Object localObject3 = ((JSONObject)localObject2).optString("agreement_url");
        Object localObject1 = ((JSONObject)localObject2).optString("agreement_text");
        String str3 = ((JSONObject)localObject2).optString("agreement_text_pre");
        String str1 = ((JSONObject)localObject2).optString("agreement_title");
        String str2 = ((JSONObject)localObject2).optString("agreement_guide");
        Object localObject4 = ((JSONObject)localObject2).optString("returl");
        String str4 = ((JSONObject)localObject2).optString("rbutton");
        localObject2 = ((JSONObject)localObject2).optString("agreement_bgurl");
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          xfc localxfc = new xfc(this, (String)localObject4);
          localObject4 = new SpannableString(str3 + (String)localObject1);
          ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(-7829368), 0, str3.length(), 33);
          ((SpannableString)localObject4).setSpan(new ForegroundColorSpan(-16776961), str3.length(), str3.length() + ((String)localObject1).length(), 33);
          localObject3 = new xfd(this, (String)localObject3);
          int i = str3.length();
          int j = str3.length();
          ((SpannableString)localObject4).setSpan(localObject3, i, ((String)localObject1).length() + j, 33);
          localObject1 = new ButtonInfo(str4, new ColorDrawable(-15550475), -1, localxfc);
          GoldMsgChatHelper.a(BaseActivity.sTopActivity, str1, (String)localObject2, str2, (ButtonInfo)localObject1, (SpannableString)localObject4);
          return;
        }
      }
      catch (JSONException localJSONException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfb
 * JD-Core Version:    0.7.0.1
 */