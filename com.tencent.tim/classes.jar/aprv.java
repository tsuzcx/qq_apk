import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.Pic_list;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class aprv
{
  protected static SimpleDateFormat F;
  protected static final String cqQ = acfp.m(2131715585);
  protected static final String cqR = acfp.m(2131715595);
  protected static final String cqS;
  public static final HashMap<String, aprv.a> ot = new HashMap();
  public static final HashMap<String, aprv.a> ou = new HashMap();
  public static final HashMap<String, String> ov = new HashMap();
  protected static final String sW = acfp.m(2131715576);
  public static Hashtable<String, TroopBarPublishActivity.Pic_list> w;
  
  static
  {
    cqS = acfp.m(2131715572);
    F = new SimpleDateFormat();
    w = new Hashtable();
  }
  
  public static boolean Z(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (-1 != paramString.indexOf('/'));
  }
  
  public static int a(String paramString, char paramChar)
  {
    int j = 0;
    if (paramString != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= paramString.length()) {
          break;
        }
        k = i;
        if (paramString.charAt(j) == paramChar) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public static final Uri a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext())) {}
    do
    {
      return null;
      paramString = new File(paramString);
      if (paramString.exists()) {}
      for (boolean bool = true; (bool) && (paramString.canWrite()); bool = paramString.mkdirs()) {
        try
        {
          paramString = new Intent();
          Uri localUri = FileProvider7Helper.setSystemCapture(paramBaseActivity, new File(acbn.oM + System.currentTimeMillis() + ".jpg"), paramString);
          paramString.addFlags(3);
          paramBaseActivity.startActivityForResult(paramString, paramInt);
          return localUri;
        }
        catch (Exception paramBaseActivity)
        {
          paramBaseActivity.printStackTrace();
          return null;
        }
      }
    } while ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()));
    QQToast.a(paramBaseActivity, 2131698505, 1).show(paramBaseActivity.getTitleBarHeight());
    return null;
  }
  
  public static final JSONObject a(String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (ahbj.isFileExists(paramString2))
    {
      localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "https://www.qq.com");
      localHashMap2 = new HashMap();
      localHashMap2.put("file", paramString2);
      if (paramMap != null) {
        break label249;
      }
    }
    label249:
    for (paramContext = new HashMap();; paramContext = paramMap)
    {
      paramContext.put("file", paramString2);
      long l = System.currentTimeMillis();
      paramString1 = jqc.a(paramString1, paramString3, paramString4, paramContext, localHashMap2, localHashMap1);
      if (QLog.isColorLevel())
      {
        QLog.d("TroopBar", 2, "singleUploadImage t = " + (System.currentTimeMillis() - l) + ", path = " + paramString2 + ", size = " + ahbj.getFileSize(paramString2));
        QLog.d("TroopBar", 2, "urlResult: " + paramString1);
      }
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString1.optInt("retcode", -1) == 0) || (paramString1.optInt("ret", -1) == 0))
        {
          paramString1 = paramString1.getJSONObject("result");
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramString1.getMessage());
        }
      }
      return null;
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    int i = aqiw.getNetworkType(paramContext);
    anot.a(null, "P_CliOper", "BizTechReport", "", paramString1, paramString2, 0, paramInt, "" + i, paramString3, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, int paramInt, Bundle paramBundle2, aprb.a parama, String paramString4)
  {
    if ((paramBundle1 != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramBundle1.putString("version", "3.4.4");
      paramBundle1.putString("platform", "android");
      paramBundle1.putString("mType", "qb_troop_bar");
      paramBundle1.putString("Cookie", "uin=" + paramString1 + ";skey=" + paramString2);
      paramBundle1.putString("Referer", "https://buluo.qq.com");
      paramString1 = new HashMap();
      paramString1.put("BUNDLE", paramBundle1);
      paramString1.put("CONTEXT", paramContext.getApplicationContext());
      new aprb(paramString3, paramString4, parama, paramInt, paramBundle2).execute(new HashMap[] { paramString1 });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopBar", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, aprb.a parama)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, parama, "GET");
  }
  
  protected static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString1, int paramInt, Bundle paramBundle2, aprb.a parama, String paramString2)
  {
    AppRuntime localAppRuntime = paramBaseActivity.getAppRuntime();
    String str = localAppRuntime.getAccount();
    a(paramBaseActivity, str, ((TicketManager)localAppRuntime.getManager(2)).getSkey(str), paramBundle1, paramString1, paramInt, paramBundle2, parama, paramString2);
  }
  
  public static void b(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, aprb.a parama)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, parama, "POST");
  }
  
  public static final void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    anot.a(null, "P_CliOper", paramString1, "", paramString2, paramString3, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static String ep(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = "";
      return str;
    }
    for (;;)
    {
      try
      {
        boolean bool = Z(paramString);
        if (!bool) {
          return paramString;
        }
        i = 0;
        str = paramString;
      }
      catch (Exception localException1)
      {
        try
        {
          if (i >= aoff.hj.length) {
            break;
          }
          str = paramString;
          if (paramString.indexOf(aoff.hj[i]) != -1) {
            str = paramString.replace(aoff.hj[i], "\024" + (char)i);
          }
          i += 1;
          paramString = str;
        }
        catch (Exception localException2)
        {
          int i;
          StringBuilder localStringBuilder;
          continue;
        }
        localException1 = localException1;
        localException1.printStackTrace();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("convertFaceStringTextToIndex:");
          if (paramString.length() > 200)
          {
            i = 200;
            QLog.e("TroopBar", 2, paramString.substring(0, i));
          }
        }
        else
        {
          return paramString;
        }
      }
      i = paramString.length() - 1;
    }
    return paramString;
  }
  
  public static final String f(EditText paramEditText)
  {
    int j = 0;
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof aofr))
    {
      aofr localaofr = (aofr)paramEditText.getEditableText();
      if (localaofr != null)
      {
        int i = localaofr.length();
        Object localObject1 = new char[i];
        localaofr.getChars(0, i, (char[])localObject1, 0);
        paramEditText = new StringBuffer();
        paramEditText.append((char[])localObject1);
        localObject1 = (aofk.a[])localaofr.getSpans(0, i, aofk.a.class);
        if (((localaofr instanceof Spanned)) && (Build.VERSION.SDK_INT >= 24)) {
          Arrays.sort((Object[])localObject1, new aprw(localaofr));
        }
        int k = 0;
        if (j < localObject1.length)
        {
          Object localObject2 = localObject1[j];
          int m;
          if (((aofk.a)localObject2).emojiType == 1)
          {
            i = localaofr.getSpanStart(localObject2);
            m = localaofr.getSpanEnd(localObject2);
            localObject2 = afky.ea(((aofk.a)localObject2).index & 0x7FFFFFFF);
            paramEditText.replace(i + k, m + k, (String)localObject2);
            i = k + (((String)localObject2).length() - (m - i));
          }
          for (;;)
          {
            j += 1;
            k = i;
            break;
            i = k;
            if (((aofk.a)localObject2).emojiType == 2)
            {
              i = localaofr.getSpanStart(localObject2);
              m = localaofr.getSpanEnd(localObject2);
              localObject2 = ((aofk.a)localObject2).getDescription();
              paramEditText.replace(i + k, m + k, (String)localObject2);
              i = k + (((String)localObject2).length() - (m - i));
            }
          }
        }
        return paramEditText.toString();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public static final void l(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(null, "dc00899", "Grp_tribe", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static final void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    d("Grp_tribe", paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static class a
  {
    public AudioInfo a;
    public TroopBarPOI a;
    public String bwy;
    public int cLN;
    public int cLO;
    public String cmM;
    public ArrayList<String> cu;
    public int dRw;
    public int dRx;
    public ArrayList<TroopBarPOI> kd;
    public String mContent;
    public String mTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aprv
 * JD-Core Version:    0.7.0.1
 */