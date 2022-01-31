import android.content.Context;
import com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener;
import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ddd
  extends QQCustomDialog
{
  public ddd(EmojiJsHandler paramEmojiJsHandler, Context paramContext, int paramInt, IndividuationSetActivity.EmojiJsBridgeListener paramEmojiJsBridgeListener)
  {
    super(paramContext, paramInt);
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Emoji.EmojiJsHandler", 2, "back button clicked");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 2);
      localJSONObject.put("message", "user cancel download emoji in not wifi network");
      localJSONObject.put("what", 1014);
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a(localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      super.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddd
 * JD-Core Version:    0.7.0.1
 */