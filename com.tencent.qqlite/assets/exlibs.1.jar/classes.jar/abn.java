import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class abn
  extends AsyncTask
{
  private int jdField_a_of_type_Int = -1;
  private int b = 0;
  private int c = 1;
  private int d = 2;
  
  public abn(ChatActivity paramChatActivity) {}
  
  protected JSONObject a(Object... paramVarArgs)
  {
    paramVarArgs = new JSONObject();
    try
    {
      paramVarArgs.put("ret", this.d);
      if ((EmojiUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity) != EmotcationConstants.f) && (!EmojiUtil.a(521705)) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).getBoolean("emojiDownloaded", false)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", false).commit();
        paramVarArgs.put("ret", this.jdField_a_of_type_Int);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, "ChatActivity CheckEmojiTask:" + paramVarArgs.toString());
        }
        return paramVarArgs;
        if ((EmojiUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity) != EmotcationConstants.f) && (EmojiUtil.a(521705)))
        {
          String str2 = EmojiUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity);
          String str1 = EmojiUtil.a();
          File localFile = new File(str2);
          try
          {
            if (!localFile.exists()) {
              break label450;
            }
            if (!EmojiUtil.a(localFile)) {
              break label402;
            }
            FileUtils.a(str1, str2, false);
            if (!new File(str2).exists()) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", true).commit();
            paramVarArgs.put("ret", this.b);
          }
          catch (Exception localException2)
          {
            FileUtils.d(str1);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", false).commit();
            paramVarArgs.put("ret", this.d);
            localException2.printStackTrace();
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, "ChatActivity CheckEmojiTask JSONException:" + localJSONException.getMessage());
        }
        localJSONException.printStackTrace();
        continue;
        FileUtils.d(localJSONException);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", false).commit();
        paramVarArgs.put("ret", this.c);
        continue;
        FileUtils.d(localJSONException);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", false).commit();
        paramVarArgs.put("ret", this.d);
        continue;
        FileUtils.a(localJSONException, localException2, false);
        if (new File(localException2).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", true).commit();
          paramVarArgs.put("ret", this.b);
        }
        else
        {
          FileUtils.d(localJSONException);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", false).commit();
          paramVarArgs.put("ret", this.c);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label402:
        label450:
        if (QLog.isColorLevel()) {
          QLog.i("qqBaseActivity", 2, "ChatActivity CheckEmojiTask Exception:" + localException1.getMessage());
        }
        localException1.printStackTrace();
      }
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i;
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.dismiss();
      }
      i = paramJSONObject.getInt("ret");
      if (i == this.b)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131364519), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getTitleBarHeight());
        return;
      }
      if (i == this.jdField_a_of_type_Int)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131364520), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getTitleBarHeight());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131364522), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getTitleBarHeight());
      paramJSONObject.printStackTrace();
      return;
    }
    if ((i == this.c) || (i == this.d)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getString(2131364521), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getTitleBarHeight());
    }
  }
  
  protected void onPreExecute()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.b(2131364518);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a.show();
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     abn
 * JD-Core Version:    0.7.0.1
 */