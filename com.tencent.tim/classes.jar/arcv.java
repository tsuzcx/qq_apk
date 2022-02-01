import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.utils.WebStateReporter.1;
import com.tencent.mobileqq.webview.utils.WebStateReporter.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arcv
{
  public static int eep = 6;
  public static HashMap<String, Integer> pE = new HashMap();
  public long aiB;
  public long avs;
  public boolean cYW;
  public String czB;
  public int eeA;
  public long mClickTime;
  public int mCurrentStep;
  
  public void a(Context paramContext, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramLong <= 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.cYW)
    {
      this.mCurrentStep = this.eeA;
      this.aiB = this.avs;
      this.cYW = false;
    }
    try
    {
      i = aqiw.getSystemNetwork(paramContext);
      switch (i)
      {
      default: 
        String str1 = "Unknown";
        ThreadManager.post(new WebStateReporter.1(this, paramBoolean, paramString, paramContext, paramLong, str1), 5, null, false);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        String str2 = "2G";
        continue;
        str2 = "3G";
        continue;
        str2 = "4G";
        continue;
        str2 = "wifi";
      }
    }
  }
  
  public void d(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      if (paramAppInterface == null) {}
      for (long l = 0L; !TextUtils.isEmpty(paramString); l = paramAppInterface.getLongAccountUin())
      {
        ThreadManager.post(new WebStateReporter.2(this, paramString, l, paramInt), 5, null, false);
        return;
      }
    }
  }
  
  public void fM(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), aqpi.e.cuN);
    if (!paramContext.exists()) {}
    do
    {
      do
      {
        return;
        paramContext = aqhq.readFileContent(paramContext);
      } while (TextUtils.isEmpty(paramContext));
      try
      {
        paramContext = new JSONObject(paramContext);
        int i = paramContext.getInt("sample_rate");
        pE.put("sample_rate", Integer.valueOf(i));
        JSONArray localJSONArray = paramContext.getJSONArray("rules");
        int j = localJSONArray.length();
        i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          pE.put(localJSONObject.getString("distUrl"), Integer.valueOf(localJSONObject.getInt("rate")));
          i += 1;
        }
        eep = paramContext.getInt("tail_number");
        return;
      }
      catch (JSONException paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("WebStateReporter", 2, "" + paramContext);
  }
  
  public void mh(long paramLong)
  {
    this.mClickTime = paramLong;
  }
  
  public void os(String paramString)
  {
    this.czB = paramString;
  }
  
  public void setCurrentState(int paramInt)
  {
    this.mCurrentStep = paramInt;
    this.aiB = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("WebStateReporter_report", 2, "Current State = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcv
 * JD-Core Version:    0.7.0.1
 */