import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class jov
{
  public int mConfigVersion;
  public Context mContext;
  public String mUin;
  
  public jov(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mUin = paramString;
    this.mConfigVersion = k(paramContext, paramString);
    kX(hL());
  }
  
  public String a(AppInterface paramAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonConfigBase", 2, "handleConfig type = " + paramConfig.type.get());
    }
    if ((paramConfig.msg_content_list == null) || (paramConfig.msg_content_list.size() < 1) || (paramConfig.msg_content_list.get(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleQuickShotShareToStoryConfig data is null!!!");
      }
      aB(this.mContext, paramAppInterface.getCurrentAccountUin());
      return null;
    }
    return a(paramConfig);
  }
  
  protected String a(ConfigurationService.Config paramConfig)
  {
    paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
    if (paramConfig.compress.get() == 1)
    {
      paramConfig = akrf.inflateConfigString(paramConfig.content.get().toByteArray());
      if (paramConfig != null) {
        try
        {
          String str = new String(paramConfig, "UTF-8");
          return str;
        }
        catch (Exception paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramConfig));
          }
          return null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
          System.gc();
          try
          {
            paramConfig = new String(paramConfig, "UTF-8");
            return paramConfig;
          }
          catch (Throwable paramConfig)
          {
            if (QLog.isColorLevel()) {
              QLog.w("CommonConfigBase", 2, QLog.getStackTraceString(paramConfig));
            }
          }
        }
      }
      return null;
    }
    return paramConfig.content.get().toStringUtf8();
  }
  
  public void a(AppInterface paramAppInterface, ConfigurationService.Config paramConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonConfigBase", 2, "handleConfig type = " + paramConfig.type.get());
    }
    this.mConfigVersion = k(this.mContext, paramAppInterface.getCurrentAccountUin());
    int i = paramConfig.version.get();
    if (this.mConfigVersion == i) {
      if (QLog.isColorLevel()) {
        QLog.d("CommonConfigBase", 2, "handleConfig version code not changed .");
      }
    }
    do
    {
      return;
      d(this.mContext, paramAppInterface.getCurrentAccountUin(), i);
      this.mConfigVersion = i;
      paramConfig = a(paramAppInterface, paramConfig);
      if (TextUtils.isEmpty(paramConfig)) {
        break;
      }
    } while (a(paramAppInterface, paramConfig));
    kY(paramConfig);
    kX(paramConfig);
    return;
    kY(paramConfig);
    kX(paramConfig);
  }
  
  public boolean a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString).optString(hM(), "");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      if (!(paramAppInterface instanceof QQAppInterface)) {
        return false;
      }
      paramAppInterface = ((aqva)((QQAppInterface)paramAppInterface).getManager(47)).a(1);
      paramString = acbn.SDCARD_PATH + hJ() + ".tmp";
      localObject = new aquz((String)localObject, new File(paramString));
      ((aquz)localObject).retryCount = 3;
      Bundle localBundle = new Bundle();
      localBundle.putString("file_path", paramString);
      paramAppInterface.a((aquz)localObject, new jow(this), localBundle);
      return true;
    }
    catch (JSONException paramAppInterface) {}
    return false;
  }
  
  public void aB(Context paramContext, String paramString)
  {
    getSharedPreferences(paramContext).edit().remove(paramString + "_" + hK()).commit();
  }
  
  public void d(Context paramContext, String paramString, int paramInt)
  {
    getSharedPreferences(paramContext).edit().putInt(paramString + "_" + hK(), paramInt).commit();
  }
  
  protected SharedPreferences getSharedPreferences(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext);
  }
  
  public abstract String hJ();
  
  public abstract String hK();
  
  public String hL()
  {
    return getSharedPreferences(this.mContext).getString(this.mUin + "_" + hJ(), null);
  }
  
  public String hM()
  {
    return "more_config_url";
  }
  
  public int k(Context paramContext, String paramString)
  {
    return getSharedPreferences(paramContext).getInt(paramString + "_" + hK(), 0);
  }
  
  public abstract void kX(String paramString);
  
  public void kY(String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences(this.mContext);
    if (TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().remove(this.mUin + "_" + hJ());
      return;
    }
    localSharedPreferences.edit().putString(this.mUin + "_" + hJ(), paramString).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jov
 * JD-Core Version:    0.7.0.1
 */