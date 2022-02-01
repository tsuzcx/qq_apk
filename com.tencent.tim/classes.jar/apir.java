import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class apir
{
  public String cpC = "WXARS1005SNG1523440966";
  public int dUo = 2;
  public int dUp = 10;
  public int dUq = 40;
  public int dUr = 50;
  public Context mContext;
  public String mUin;
  
  public apir(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mUin = paramString;
    loadConfig();
  }
  
  private void H(ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReciteConfig", 2, "parseConfig: list.size() " + paramConfig.msg_content_list.size());
      }
      Iterator localIterator = paramConfig.msg_content_list.get().iterator();
      if (!localIterator.hasNext()) {
        break label298;
      }
      paramConfig = (ConfigurationService.Content)localIterator.next();
      if ((paramConfig != null) && (paramConfig.content.has())) {
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = aevk.inflateConfigString(paramConfig.content.get().toByteArray());
          if (paramConfig == null) {
            break label299;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramConfig = new String(paramConfig, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.i("ReciteConfig", 2, "parseConfig: contentitem.content =  " + paramConfig);
        }
        if ((TextUtils.isEmpty(paramConfig)) || (!iU(paramConfig))) {
          break;
        }
        saveConfig();
      }
      catch (Exception paramConfig)
      {
        QLog.e("ReciteConfig", 1, "parseConfig|uncompress failed" + paramConfig);
        paramConfig = null;
        continue;
      }
      paramConfig = paramConfig.content.get().toStringUtf8();
      continue;
      QLog.i("ReciteConfig", 1, "empty contentitem");
      break;
      aB(this.mContext, this.mUin);
      if (QLog.isColorLevel()) {
        QLog.i("ReciteConfig", 2, "handleReceiptConfig:msg_content_list is empty ,version: " + paramConfig.version.get());
      }
      label298:
      return;
      label299:
      paramConfig = null;
    }
  }
  
  private void aB(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().remove(paramString + "_" + "troop_hw_recite_cfg_version").commit();
  }
  
  private void d(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt(paramString + "_" + "troop_hw_recite_cfg_version", paramInt).commit();
  }
  
  private SharedPreferences getSP()
  {
    return this.mContext.getSharedPreferences(this.mUin + "_" + "HWTroopReciteConfig", 0);
  }
  
  private boolean iU(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString)) {}
    while (!QLog.isColorLevel())
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("HWTroopReciteConfig"))
        {
          paramString = paramString.getJSONObject("HWTroopReciteConfig");
          if (paramString.has("max_remind_num")) {
            this.dUo = paramString.getInt("max_remind_num");
          }
          if (paramString.has("max_allow_wrong_num")) {
            this.dUr = paramString.getInt("max_allow_wrong_num");
          }
          if (paramString.has("max_detect_num_in_article")) {
            this.dUp = paramString.getInt("max_detect_num_in_article");
          }
          if (paramString.has("max_detect_num_in_recite")) {
            this.dUq = paramString.getInt("max_detect_num_in_recite");
          }
          if (paramString.has("wx_voice_app_id"))
          {
            paramString = paramString.getString("wx_voice_app_id");
            if (!TextUtils.isEmpty(paramString)) {
              this.cpC = paramString;
            }
          }
        }
        bool = true;
      }
      catch (JSONException paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("ReciteConfig", 2, paramString, new Object[0]);
        return false;
      }
      return bool;
    }
    QLog.i("ReciteConfig", 2, "parseConfig:config_content is null");
    return false;
  }
  
  private void loadConfig()
  {
    SharedPreferences localSharedPreferences = getSP();
    this.dUo = localSharedPreferences.getInt("max_remind_num", this.dUo);
    this.dUr = localSharedPreferences.getInt("max_allow_wrong_num", this.dUr);
    this.dUp = localSharedPreferences.getInt("max_detect_num_in_article", this.dUp);
    this.dUq = localSharedPreferences.getInt("max_detect_num_in_recite", this.dUq);
    this.cpC = localSharedPreferences.getString("wx_voice_app_id", this.cpC);
    if (QLog.isColorLevel()) {
      QLog.i("ReciteConfig", 2, "loadConfig: " + toString());
    }
  }
  
  private void saveConfig()
  {
    getSP().edit().putInt("max_remind_num", this.dUo).putInt("max_allow_wrong_num", this.dUr).putInt("max_detect_num_in_article", this.dUp).putInt("max_detect_num_in_recite", this.dUq).putString("wx_voice_app_id", this.cpC).commit();
    if (QLog.isColorLevel()) {
      QLog.i("ReciteConfig", 2, "saveConfig: " + toString());
    }
  }
  
  public void av(QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = k(this.mContext, this.mUin);
    if (QLog.isColorLevel()) {
      QLog.i("ReciteConfig", 2, "handleConfig: ,version: " + paramConfig.version.get() + "| localVersion: " + j);
    }
    if (i != j)
    {
      d(this.mContext, this.mUin, i);
      H(paramConfig);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("ReciteConfig", 2, "handleConfig:localVersion == version ");
  }
  
  public int k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_hw_recite_cfg_version", 0);
  }
  
  public String toString()
  {
    return "ReciteConfig{mMaxRemindNum=" + this.dUo + ", mMaxDetectNumInArticle=" + this.dUp + ", mMaxDetectNumInRecite=" + this.dUq + ", mMaxAllowWrongNum=" + this.dUr + ", mWXVoiceAppId='" + this.cpC + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apir
 * JD-Core Version:    0.7.0.1
 */