import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class uxp
{
  @xrk(a="type")
  public int a;
  @xrk(a="linkUrl")
  public String a;
  @xrk(a="capture")
  public uxl a;
  @xrk(a="comp")
  public uxm a;
  @xrk(a="gameinfo")
  public uxn a;
  @xrk(a="game")
  public uxo a;
  @xrk(a="videoShare")
  public uxq a;
  @xrk(a="parseState")
  public int b;
  @xrk(a="title")
  public String b;
  @xrk(a="body")
  public String c;
  @xrk(a="picUrl")
  public String d;
  @xrk(a="app")
  public String e;
  
  @Nullable
  public static uxp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (uxp)JsonORM.a(new JSONObject(paramString), uxp.class);
      return paramString;
    }
    catch (JsonORM.JsonParseException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static uxp a(String paramString1, String paramString2, String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    uxp localuxp = new uxp();
    localuxp.jdField_a_of_type_JavaLangString = paramString1;
    localuxp.jdField_b_of_type_JavaLangString = paramString2;
    localuxp.c = paramString3;
    localuxp.d = paramString4;
    localuxp.e = paramString5;
    localuxp.jdField_a_of_type_Int = 1;
    localuxp.jdField_b_of_type_Int = 2;
    return localuxp;
  }
  
  public static uxp a(String paramString1, boolean paramBoolean, @Nullable String paramString2, @Nullable String paramString3)
  {
    uxp localuxp = new uxp();
    localuxp.jdField_a_of_type_JavaLangString = paramString1;
    localuxp.d = paramString2;
    localuxp.e = paramString3;
    if (paramBoolean) {}
    for (localuxp.jdField_b_of_type_Int = 0;; localuxp.jdField_b_of_type_Int = 2)
    {
      localuxp.jdField_a_of_type_Int = 1;
      return localuxp;
    }
  }
  
  public String a()
  {
    String str3 = this.jdField_a_of_type_JavaLangString;
    String str2 = str3;
    if (bdix.d.matcher(str3).find())
    {
      String str1 = null;
      int i = str3.lastIndexOf("#");
      if (i > 0) {
        str1 = str3.substring(i);
      }
      str3 = URLUtil.guessUrl(str3);
      str2 = str3;
      if (str1 != null) {
        return str3 + str1;
      }
    }
    return str2;
  }
  
  public String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = JsonORM.a(this);
      if (paramBoolean) {
        ((JSONObject)localObject).remove("parseState");
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      wxe.b("Q.qqstory.tag", "VideoLinkInfo", localJsonParseException);
    }
    return "";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_Uxq != null);
  }
  
  public String b()
  {
    String str1;
    String str2;
    label30:
    String str3;
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      str1 = this.jdField_b_of_type_JavaLangString.trim();
      if (this.c == null) {
        break label57;
      }
      str2 = this.c.trim();
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        break label63;
      }
      str3 = this.jdField_a_of_type_JavaLangString;
    }
    label57:
    label63:
    do
    {
      return str3;
      str1 = "";
      break;
      str2 = "";
      break label30;
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        return String.format("%s-%s", new Object[] { str1, str2 });
      }
      str3 = str1;
    } while (!TextUtils.isEmpty(str1));
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uxp
 * JD-Core Version:    0.7.0.1
 */