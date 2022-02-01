import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class afns
{
  public static long XC = 86400000L;
  public long XD;
  public boolean bZQ;
  public int cSF;
  
  public static afns a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    paramString = localBaseApplicationImpl.getSharedPreferences("emosm_sp_is_recommend", 4).getString(localBaseApplicationImpl.getRuntime().getAccount() + "_" + paramString, null);
    if (paramString != null) {}
    do
    {
      try
      {
        paramString = new afns().a(new JSONObject(paramString));
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("EmoticonRecDressup", 1, "getEmotionRecommend failed", paramString);
      }
      paramString = localObject;
    } while (!paramBoolean);
    paramString = new afns();
    paramString.bZQ = true;
    return paramString;
  }
  
  private afns a(JSONObject paramJSONObject)
  {
    this.XD = paramJSONObject.optLong("0");
    this.bZQ = paramJSONObject.optBoolean("1");
    this.cSF = paramJSONObject.optInt("2");
    return this;
  }
  
  public static void jd(long paramLong)
  {
    XC = 1000L * paramLong;
    QLog.i("EmoticonRecDressup", 1, "EmotionPanelViewPagerAdapter.RECOMMEND_EXPIRED_TIME update to " + XC);
  }
  
  public void MP(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = localBaseApplicationImpl.getSharedPreferences("emosm_sp_is_recommend", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    long l1 = localSharedPreferences.getLong("createTime", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 2592000000L)
    {
      localEditor.clear();
      localEditor.putLong("createTime", l2);
    }
    this.XD = l2;
    localEditor.putString(localBaseApplicationImpl.getRuntime().getAccount() + "_" + paramInt, toString());
    localEditor.commit();
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("0", this.XD);
      localJSONObject.put("1", this.bZQ);
      localJSONObject.put("2", this.cSF);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("EmoticonRecDressup", 1, "toString failed", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afns
 * JD-Core Version:    0.7.0.1
 */