import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener;
import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class dde
  implements DialogInterface.OnClickListener
{
  public dde(EmojiJsHandler paramEmojiJsHandler, IndividuationSetActivity.EmojiJsBridgeListener paramEmojiJsBridgeListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Emoji.EmojiJsHandler", 2, "not wifi network cancel download");
    }
    try
    {
      paramDialogInterface = new JSONObject();
      paramDialogInterface.put("result", 2);
      paramDialogInterface.put("message", "user cancel download emoji in not wifi network");
      paramDialogInterface.put("what", 1014);
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a(paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dde
 * JD-Core Version:    0.7.0.1
 */