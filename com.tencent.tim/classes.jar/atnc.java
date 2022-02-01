import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class atnc
{
  private static String ET()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }
  
  private static JSONObject F(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j;
    String str;
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("cgicode");
      j = paramString.getInt("retcode");
      str = paramString.optString("msg", "");
      if (i != 0)
      {
        QLog.e("CooperationSpaceCGITeamWorkHttpUtils", 2, "服务器返回错误: " + str);
        return null;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("CooperationSpaceCGITeamWorkHttpUtils", 2, paramString, new Object[] { "回包解包失败" });
      return null;
    }
    if (j != 0)
    {
      QLog.e("CooperationSpaceCGITeamWorkHttpUtils", 2, "服务器返回错误: " + str);
      return null;
    }
    return paramString;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt, String paramString3, long paramLong, String paramString4)
  {
    try
    {
      String str2 = ET();
      ArrayList localArrayList = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder().append("src_uin=");
      String str1 = paramString2;
      if (paramString2 == null) {
        str1 = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      }
      localArrayList.add(str1);
      paramString2 = new StringBuilder().append("scene_type=");
      int i = paramInt;
      if (paramInt == 0) {
        i = 3;
      }
      localArrayList.add(i);
      localArrayList.add("src_full_path=" + paramString3);
      localArrayList.add("file_size=" + paramLong);
      localArrayList.add("title=" + URLEncoder.encode(paramString4, "UTF-8"));
      if (!TextUtils.isEmpty(paramString1)) {
        localArrayList.add("team_id=" + paramString1);
      }
      localArrayList.add("xsrf=" + str2);
      paramString1 = F(aulk.a(TextUtils.join("&", localArrayList.toArray(new String[0])), BaseApplicationImpl.getApplication().getRuntime().getAccount(), "https://docs.qq.com/cgi-bin/online_docs/doc_saveto", "docs.qq.com", "TOK=" + str2, false));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      QLog.e("CooperationSpaceCGITeamWorkHttpUtils", 2, paramString1, new Object[] { "URLEncode标题失败 title:" + paramString4 });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnc
 * JD-Core Version:    0.7.0.1
 */