import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import tencent.im.confess.common.RedpointInfo;

public class aehb
{
  public long Wd;
  private String bxq;
  public String bxr = "";
  public String bxs = "";
  public String bxt = "";
  public int cMU;
  public boolean isInit;
  private String mAccount;
  public int nTopicId;
  
  public aehb(String paramString)
  {
    this.mAccount = paramString;
  }
  
  public boolean agG()
  {
    return (!TextUtils.isEmpty(this.bxr)) && (!TextUtils.isEmpty(this.bxt));
  }
  
  public void b(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    int i;
    Object localObject;
    if (paramRedTouchItem.unReadFlag)
    {
      i = paramRedTouchItem.count;
      this.cMU = i;
      this.Wd = paramRedTouchItem.lastRecvTime;
      if ((paramRedTouchItem.extMsgs == null) || (paramRedTouchItem.extMsgs.size() <= 0)) {
        break label232;
      }
      localObject = null;
      Iterator localIterator = paramRedTouchItem.extMsgs.iterator();
      i = 0;
      paramRedTouchItem = (RedTouchItem)localObject;
      label67:
      if (!localIterator.hasNext()) {
        break label111;
      }
      localObject = (RedTouchItemExtMsg)localIterator.next();
      if (((RedTouchItemExtMsg)localObject).time <= i) {
        break label258;
      }
      i = ((RedTouchItemExtMsg)localObject).time;
      paramRedTouchItem = (RedTouchItem)localObject;
    }
    label258:
    for (;;)
    {
      break label67;
      i = 0;
      break;
      try
      {
        label111:
        localObject = new RedpointInfo();
        ((RedpointInfo)localObject).mergeFrom(paramRedTouchItem.bytesData);
        if (((RedpointInfo)localObject).data.has())
        {
          paramRedTouchItem = new JSONObject(((RedpointInfo)localObject).data.get());
          if (paramRedTouchItem.has("topicId")) {
            this.nTopicId = paramRedTouchItem.getInt("topicId");
          }
          if (paramRedTouchItem.has("topicDesc")) {
            this.bxt = paramRedTouchItem.getString("topicDesc");
          }
          if (paramRedTouchItem.has("frdUin")) {
            this.bxr = String.valueOf(paramRedTouchItem.getLong("frdUin"));
          }
          if (paramRedTouchItem.has("frdNick")) {
            this.bxs = paramRedTouchItem.getString("frdNick");
          }
        }
      }
      catch (Exception paramRedTouchItem)
      {
        for (;;)
        {
          label232:
          if (QLog.isColorLevel()) {
            QLog.e("FrdConfessInfo", 2, paramRedTouchItem, new Object[0]);
          }
        }
      }
      cWT();
      return;
    }
  }
  
  public void cWT()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nUnReadCnt", this.cMU);
      localJSONObject.put("lLastMsgTime", this.Wd);
      localJSONObject.put("nTopicId", this.nTopicId);
      localJSONObject.put("strTopicDesc", this.bxt);
      localJSONObject.put("strFrdUin", this.bxr);
      localJSONObject.put("strFrdNick", this.bxs);
      this.bxq = localJSONObject.toString();
      aqmj.a(this.mAccount, "confess_config_sp").edit().putString("key_frd_rec_confess_info", this.bxq).apply();
      label112:
      if (QLog.isColorLevel()) {
        QLog.e("FrdConfessInfo", 2, String.format(Locale.getDefault(), "updateJsonStr str: %s", new Object[] { this.bxq }));
      }
      return;
    }
    catch (Exception localException)
    {
      break label112;
    }
  }
  
  public void init()
  {
    if (this.isInit) {}
    label171:
    do
    {
      return;
      this.isInit = true;
      this.bxq = aqmj.a(this.mAccount, "confess_config_sp").getString("key_frd_rec_confess_info", "");
      if (!TextUtils.isEmpty(this.bxq)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(this.bxq);
        if (localJSONObject.has("nUnReadCnt")) {
          this.cMU = localJSONObject.getInt("nUnReadCnt");
        }
        if (localJSONObject.has("lLastMsgTime")) {
          this.Wd = localJSONObject.getLong("lLastMsgTime");
        }
        if (localJSONObject.has("nTopicId")) {
          this.nTopicId = localJSONObject.getInt("nTopicId");
        }
        if (localJSONObject.has("strTopicDesc")) {
          this.bxt = localJSONObject.getString("strTopicDesc");
        }
        if (localJSONObject.has("strFrdUin")) {
          this.bxr = localJSONObject.getString("strFrdUin");
        }
        if (localJSONObject.has("strFrdNick")) {
          this.bxs = localJSONObject.getString("strFrdNick");
        }
      }
      catch (Exception localException)
      {
        break label171;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("FrdConfessInfo", 4, String.format(Locale.getDefault(), "init strJsonStr: %s", new Object[] { this.bxq }));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("{isInit = ").append(this.isInit).append(", nUnReadCnt = ").append(this.cMU).append(", lLastMsgTime = ").append(this.Wd).append(", nTopicId = ").append(this.nTopicId).append(", strTopicDesc = ").append(this.bxt).append(", strFrdUin = ").append(this.bxr).append(", strFrdNick = ").append(this.bxs).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aehb
 * JD-Core Version:    0.7.0.1
 */