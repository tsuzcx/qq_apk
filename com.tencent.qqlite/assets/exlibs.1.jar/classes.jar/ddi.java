import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoji.EmojiJsHandler;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class ddi
  extends AsyncTask
{
  private int jdField_a_of_type_Int = -1;
  public IndividuationSetActivity.EmojiJsBridgeListener a;
  private int b = 0;
  private int c = 1;
  private int d = 2;
  
  public ddi(EmojiJsHandler paramEmojiJsHandler, IndividuationSetActivity.EmojiJsBridgeListener paramEmojiJsBridgeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener = paramEmojiJsBridgeListener;
  }
  
  protected JSONObject a(Object... paramVarArgs)
  {
    paramVarArgs = new JSONObject();
    label398:
    do
    {
      for (;;)
      {
        try
        {
          paramVarArgs.put("ret", this.jdField_a_of_type_Int);
          paramVarArgs.put("msg", "emoji option exception");
          String str2 = EmojiUtil.a(this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_AndroidContentContext);
          str1 = EmojiUtil.a();
          localFile1 = new File(str1);
          localFile2 = new File(str2);
        }
        catch (JSONException localJSONException)
        {
          String str1;
          File localFile1;
          File localFile2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask JSONException:" + localJSONException.getMessage());
          localJSONException.printStackTrace();
          continue;
          if (!localFile2.exists()) {
            break label398;
          }
          if (!EmojiUtil.a(localFile2)) {
            continue;
          }
          FileUtils.a(localJSONException, localIOException, false);
          if (!new File(localIOException).exists()) {
            continue;
          }
          paramVarArgs.put("ret", this.b);
          paramVarArgs.put("msg", "unzip emoji and set ok");
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask find emoji ok:" + paramVarArgs.toString());
          return paramVarArgs;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask Exception:" + localException.getMessage());
          localException.printStackTrace();
          continue;
          paramVarArgs.put("msg", "unzip emoji error");
          paramVarArgs.put("ret", this.d);
          FileUtils.d(localException);
          return paramVarArgs;
        }
        try
        {
          if (!localFile1.exists())
          {
            paramVarArgs.put("msg", "pkg file not exists");
            paramVarArgs.put("ret", this.c);
            if (QLog.isColorLevel()) {
              QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask:" + paramVarArgs.toString());
            }
            return paramVarArgs;
          }
          if (localFile1.length() != 521705L)
          {
            paramVarArgs.put("msg", "pkg file not complete");
            paramVarArgs.put("ret", this.c);
          }
        }
        catch (IOException localIOException)
        {
          paramVarArgs.put("msg", "unzip emoji io exception");
          paramVarArgs.put("ret", this.d);
          FileUtils.d(str1);
          localIOException.printStackTrace();
        }
      }
      FileUtils.a(localException, localIOException, false);
      if (!new File(localIOException).exists()) {
        break;
      }
      paramVarArgs.put("ret", this.b);
      paramVarArgs.put("msg", "unzip emoji and set ok");
    } while (!QLog.isColorLevel());
    QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask find emoji ok:" + paramVarArgs.toString());
    return paramVarArgs;
    paramVarArgs.put("msg", "unzip emoji error");
    paramVarArgs.put("ret", this.d);
    FileUtils.d(localException);
    return paramVarArgs;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    int i = 0;
    if (paramString != null) {
      try
      {
        if (paramString.length() > 0)
        {
          paramString = new File(paramString.substring(0, paramString.lastIndexOf(File.separator))).listFiles();
          if ((paramString != null) && (paramString.length > 0)) {
            while (i < paramString.length)
            {
              paramString[i].getName();
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask result:" + paramJSONObject.toString());
    }
    try
    {
      int i = paramJSONObject.getInt("ret");
      paramJSONObject = paramJSONObject.getString("msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", i);
      localJSONObject.put("message", paramJSONObject);
      localJSONObject.put("what", 1018);
      if (i == this.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_AndroidContentContext.getSharedPreferences("userEmojiSharedPreferences", 0).edit().putBoolean("emojiDownloaded", true).commit();
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "setup emoji success");
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a(localJSONObject);
        return;
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "emoji_setup error");
        localJSONObject.put("what", 1001);
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler switchEmojiTask JSONException:" + paramJSONObject.getMessage());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a("Parse Result JSONException:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
    }
  }
  
  protected void onPreExecute()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131364528);
    this.jdField_a_of_type_ComTencentMobileqqEmojiEmojiJsHandler.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddi
 * JD-Core Version:    0.7.0.1
 */