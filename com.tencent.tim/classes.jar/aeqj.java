import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.5;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.6;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.7;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class aeqj
  implements aehx<String>, aepo
{
  private long WG;
  private String bAn = "";
  private String bAx = "";
  private String bAy = "";
  private boolean bVT;
  public String byc = "{}";
  private int cOA;
  private int cOB;
  private int cOC;
  private int cOx = 5;
  private int cOy = 30;
  private int cOz = 10;
  private String mTextContent = "";
  
  public boolean So()
  {
    if (this.cOC >= this.cOz)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.cOC + " >= mMaxClickTimes:" + this.cOz);
      this.bVT = false;
    }
    if (this.cOA >= this.cOx)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.cOA + " >= mOneDayMaxTimes:" + this.cOx);
      this.bVT = false;
    }
    if (this.cOB >= this.cOy)
    {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.cOB + " >= mMaxTimes:" + this.cOy);
      this.bVT = false;
    }
    return this.bVT;
  }
  
  public aepo.a a()
  {
    if (this.bAx.equalsIgnoreCase("url")) {
      return new aeqk(this);
    }
    if (this.bAx.equalsIgnoreCase("mqqapi")) {
      return new aeql(this);
    }
    if (this.bAx.equalsIgnoreCase("system")) {
      return new aeqm(this);
    }
    if (this.bAx.equalsIgnoreCase("custom")) {
      return new aeqn(this);
    }
    return null;
  }
  
  public void cXk()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.5(this));
  }
  
  public void cXl()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.6(this));
  }
  
  public void cXm()
  {
    ThreadManager.getFileThreadHandler().post(new QfileFileAssistantTipsConfigBean.7(this));
  }
  
  public void lR(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "receiveAllConfigs|type: 606configContent is empty");
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, paramString);
    }
    this.byc = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("local_day_times")) {
        this.cOA = paramString.getInt("local_day_times");
      }
      if (paramString.has("local_day_last_time"))
      {
        this.WG = paramString.getLong("local_day_last_time");
        long l = anaz.gQ();
        if (!ahav.a(this.WG * 1000L, l * 1000L, TimeZone.getDefault()))
        {
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "is not one day, set mLocalDayTims:0");
          this.cOA = 0;
        }
      }
      if (paramString.has("local_max_times")) {
        this.cOB = paramString.getInt("local_max_times");
      }
      this.cOy = paramString.getInt("max_count");
      if (this.cOB >= this.cOy)
      {
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalMaxTimes:" + this.cOB + " >= mMaxTimes:" + this.cOy);
        this.bVT = false;
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    if (paramString.has("local_click_times")) {
      this.cOC = paramString.getInt("local_click_times");
    }
    if (this.cOC >= this.cOz)
    {
      this.bVT = false;
      QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalClickTimes:" + this.cOC + " >= mMaxClickTimes:" + this.cOz);
      return;
    }
    if (paramString.getInt("switch") == 1) {}
    for (;;)
    {
      this.bVT = bool;
      this.mTextContent = paramString.getString("txt_content");
      this.bAn = paramString.getString("jump_txt");
      this.cOx = paramString.getInt("one_day_max");
      if (this.cOA >= this.cOx)
      {
        this.bVT = false;
        QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "mLocalDayTims:" + this.cOA + " >= mOneDayMaxTimes:" + this.cOx);
        return;
      }
      this.cOz = paramString.getInt("click_max");
      this.bAx = paramString.getString("jump_type");
      if (this.bAx.equalsIgnoreCase("url"))
      {
        this.bAy = new JSONObject(paramString.getString("url")).getString("url");
        return;
      }
      if (this.bAx.equalsIgnoreCase("mqqapi"))
      {
        this.bAy = new JSONObject(paramString.getString("mqqapi")).getString("url");
        return;
      }
      if (this.bAx.equalsIgnoreCase("custom"))
      {
        this.bAy = new JSONObject(paramString.getString("custom")).toString();
        return;
      }
      if (!this.bAx.equalsIgnoreCase("system")) {
        break;
      }
      this.bAy = new JSONObject(paramString.getString("system")).getString("url");
      return;
      bool = false;
    }
  }
  
  public String tE()
  {
    return this.mTextContent;
  }
  
  public String tF()
  {
    return this.bAn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqj
 * JD-Core Version:    0.7.0.1
 */