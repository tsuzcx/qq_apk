import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ddf
  implements DialogInterface.OnClickListener
{
  public ddf(EmojiJsHandler paramEmojiJsHandler, BaseActivity paramBaseActivity, IndividuationSetActivity.EmojiJsBridgeListener paramEmojiJsBridgeListener, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Emoji.EmojiJsHandler", 2, "not wifi network confirm continue to download");
      }
      paramDialogInterface = new JSONObject();
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTransFileControlller();
      String str = EmojiUtil.a();
      EmojiJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler, this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener);
      if ((localTransFileController != null) && (localTransFileController.e(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Emoji.EmojiJsHandler", 2, "start download emoji!");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.a, this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.a.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b.setOnDismissListener(new ddg(this));
        this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b.b(2131364527);
        this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b.show();
        return;
      }
      if ((localTransFileController != null) && (localTransFileController.a(this.jdField_a_of_type_JavaLangString) != null))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("Emoji.EmojiJsHandler", 2, "wifi network is downloading emoji!");
        return;
      }
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
      return;
    }
    paramDialogInterface.put("result", -1);
    paramDialogInterface.put("message", "start downloading error.");
    paramDialogInterface.put("what", 1015);
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a(paramDialogInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b != null) && (this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddf
 * JD-Core Version:    0.7.0.1
 */