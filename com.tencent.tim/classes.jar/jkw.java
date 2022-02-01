import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class jkw
{
  protected static aolm.a b = new jky();
  
  public static long C(String paramString)
  {
    long[] arrayOfLong = new long[4];
    paramString = paramString.split("\\.");
    int k = paramString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      arrayOfLong[j] = Long.parseLong(paramString[i]);
      j += 1;
      i += 1;
    }
    return (arrayOfLong[0] << 24) + (arrayOfLong[1] << 16) + (arrayOfLong[2] << 8) + arrayOfLong[3];
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    b(paramQQAppInterface, paramString1, paramString2);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, jkw.a parama)
  {
    paramQQAppInterface = paramQQAppInterface.getNetEngine(0);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "requestToDownload");
    }
    if (parama == null) {
      return false;
    }
    jkx localjkx = new jkx(parama);
    aoll localaoll = new aoll();
    localaoll.f = localjkx;
    localaoll.bZ = parama.url;
    localaoll.mHttpMethod = 0;
    localaoll.atY = parama.fileName;
    localaoll.dPo = 1;
    localaoll.a = b;
    paramQQAppInterface.a(localaoll);
    parama.e = localaoll;
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 1, "submitDownloadTask. url = " + parama.url);
    }
    return true;
  }
  
  static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      igd.aJ("ScoreManager", "parse config: " + paramString1 + ", curUin : " + paramString2);
      paramString2 = aqmj.i(paramString2);
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        int i;
        if (((JSONObject)localObject).has("scoreSwitch"))
        {
          i = ((JSONObject)localObject).getInt("scoreSwitch");
          paramString2.edit().putInt("qav_score_switch", i).commit();
        }
        if (((JSONObject)localObject).has("scoreTime"))
        {
          i = ((JSONObject)localObject).getInt("scoreTime");
          paramString2.edit().putInt("qav_score_time", i).commit();
        }
        if (((JSONObject)localObject).has("scoreRate"))
        {
          i = ((JSONObject)localObject).getInt("scoreRate");
          paramString2.edit().putInt("qav_score_rate", i).commit();
        }
        if (!((JSONObject)localObject).has("scoreIconUrl")) {
          break label393;
        }
        paramString1 = ((JSONObject)localObject).getString("scoreIconUrl");
        paramString2 = "";
        if (((JSONObject)localObject).has("scoreIconMd5")) {
          paramString2 = ((JSONObject)localObject).getString("scoreIconMd5");
        }
        if ((paramString1 != null) && (!paramString1.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ScoreManager", 2, "parse|down load icons!");
          }
          localObject = new jkw.a();
          ((jkw.a)localObject).url = paramString1;
          ((jkw.a)localObject).fileName = (jjy.ht() + ((jkw.a)localObject).url.substring(((jkw.a)localObject).url.lastIndexOf(".")));
          ((jkw.a)localObject).md5 = paramString2;
          a(paramQQAppInterface, (jkw.a)localObject);
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        igd.aJ("ScoreManager", "parse exception: " + paramQQAppInterface.toString());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ScoreManager", 2, "parse exception: " + paramQQAppInterface.toString());
        return;
      }
      igd.aJ("ScoreManager", "parse|config is empty!");
      if (QLog.isColorLevel())
      {
        QLog.i("ScoreManager", 2, "parse|config is empty!");
        return;
        label393:
        paramString1 = "";
      }
    }
  }
  
  public static String hw()
  {
    String str = EffectConfigBase.a(270, EffectConfigBase.Nk).getString("scoreInfos", null);
    if (QLog.isColorLevel()) {
      QLog.i("ScoreManager", 2, "getScoreInfos:" + str);
    }
    return str;
  }
  
  public static void kN(String paramString)
  {
    if (paramString == null) {
      igd.aJ("ScoreManager", "saveAVChatInfosForScore error ");
    }
    do
    {
      return;
      if (igl.cm(270) != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("ScoreManager", 1, "saveAVChatInfosForScore, 没有配置, infos[" + paramString + "]");
    return;
    SharedPreferences.Editor localEditor = EffectConfigBase.a(270, EffectConfigBase.Nk).edit();
    localEditor.putString("scoreInfos", paramString);
    localEditor.commit();
  }
  
  public static class a
  {
    public aoll e;
    public String fileName = "";
    public String md5 = "";
    public String url = "";
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("DownloadInfo{");
      localStringBuffer.append(", url='").append(this.url).append('\'');
      localStringBuffer.append(", md5='").append(this.md5).append('\'');
      localStringBuffer.append(", fileName='").append(this.fileName).append('\'');
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkw
 * JD-Core Version:    0.7.0.1
 */