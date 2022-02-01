import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class jis
  extends jhy
{
  public String Sn;
  public jis.a a;
  public int aAl = 2;
  public int mFromType = 1;
  
  jis(jht paramjht)
  {
    super(paramjht);
  }
  
  public boolean a(int paramInt, Intent paramIntent)
  {
    boolean bool2 = false;
    this.aAl = 3;
    String str = this.TAG;
    Object localObject = new StringBuilder().append("SendRedBag_onResult, resultCode[").append(paramInt).append("], intent[");
    boolean bool1;
    if (paramIntent != null)
    {
      bool1 = true;
      QLog.w(str, 1, bool1 + "]");
      if (paramIntent == null) {
        break label260;
      }
      AudioHelper.I(acfp.m(2131714302), paramIntent.getExtras());
      str = String.valueOf(paramIntent.getExtras().get("result"));
      localObject = paramIntent.getStringExtra("retmsg");
      paramIntent = paramIntent.getStringExtra("data");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.Sn = new JSONObject(paramIntent).getString("send_listid");
        }
        if ("-11001".equals(str)) {
          this.aAl = 4;
        }
        QLog.w(this.TAG, 1, "SendRedBag_onResult, result[" + str + "], data[" + paramIntent + "], retmsg[" + (String)localObject + "], send_listid[" + this.Sn + "], mErrorType[" + this.aAl + "]");
        bool1 = "0".equals(str);
        if (bool1) {
          this.aAl = 0;
        }
        paramIntent = str;
        kE(paramIntent);
        return bool1;
        bool1 = false;
      }
      catch (Exception localException)
      {
        continue;
      }
      label260:
      paramIntent = "null";
      bool1 = bool2;
    }
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface, int paramInt, Activity paramActivity, jis.a parama)
  {
    this.aAl = 2;
    long l1 = jik.b(paramVideoAppInterface);
    if (l1 == 0L) {
      return false;
    }
    long l2 = a(paramVideoAppInterface);
    if (l2 == 0L) {
      return false;
    }
    if (paramActivity == null)
    {
      QLog.w(this.TAG, 1, "SendRedBag, Activity为空");
      return false;
    }
    String str = a(paramVideoAppInterface);
    paramVideoAppInterface = b(paramVideoAppInterface);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("recv_uin", l2);
      localJSONObject.put("recv_name", paramVideoAppInterface);
      localJSONObject.put("bus_type", 2);
      localJSONObject.put("channel", "16384");
      localJSONObject.put("total_num", "2");
      Intent localIntent = new Intent(BaseApplication.getContext(), SendHbActivity.class);
      localIntent.putExtra("userId", l1);
      localIntent.putExtra("userName", str);
      if (paramInt == 2)
      {
        localIntent.putExtra("app_info", "appid#0|bargainor_id#0|channel#bqredpacket2");
        localIntent.putExtra("come_from", 2);
        localIntent.putExtra("extra_data", localJSONObject.toString());
        localIntent.setFlags(536870912);
        paramActivity.startActivityForResult(localIntent, 801);
        if (QLog.isDevelopLevel()) {
          QLog.w(this.TAG, 4, "SendRedBag, userId[" + l1 + "], userName[" + str + "], recv_name[" + paramVideoAppInterface + "], recv_uin[" + l2 + "], fromType[" + paramInt + "]");
        }
        this.a = parama;
        this.aAl = 1;
        this.mFromType = paramInt;
        jij.awM();
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONException.putExtra("app_info", "appid#0|bargainor_id#0|channel#bqredpacket1");
      }
    }
  }
  
  public void cancel()
  {
    QLog.w(this.TAG, 1, "SendRedBag, cancel");
    Intent localIntent = new Intent("com.qwallet.report");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putString("from", "video");
    localIntent.putExtra("type", 999);
    localIntent.putExtra("params", localBundle);
    this.mApp.getApp().getBaseContext().sendBroadcast(localIntent);
    this.aAl = 4;
    kE("cancel");
  }
  
  void kE(String paramString)
  {
    jij.nA(this.mFromType);
    jij.nB(this.aAl);
    if (this.aAl == 0) {}
    for (boolean bool = true;; bool = false)
    {
      irm.b(bool, paramString, String.valueOf(this.aAl));
      if (this.a != null)
      {
        this.a.a(this);
        this.a = null;
      }
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(jis paramjis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jis
 * JD-Core Version:    0.7.0.1
 */