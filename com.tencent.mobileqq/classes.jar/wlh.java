import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class wlh
{
  @zef(a="type")
  public int a;
  @zef(a="linkUrl")
  public String a;
  @zef(a="capture")
  public wld a;
  @zef(a="comp")
  public wle a;
  @zef(a="gameinfo")
  public wlf a;
  @zef(a="game")
  public wlg a;
  @zef(a="videoShare")
  public wli a;
  @zef(a="parseState")
  public int b;
  @zef(a="title")
  public String b;
  @zef(a="body")
  public String c;
  @zef(a="picUrl")
  public String d;
  @zef(a="app")
  public String e;
  
  @Nullable
  public static wlh a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (wlh)JsonORM.a(new JSONObject(paramString), wlh.class);
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
  
  public String a()
  {
    String str3 = this.jdField_a_of_type_JavaLangString;
    String str2 = str3;
    if (bhfp.d.matcher(str3).find())
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
      ykq.b("Q.qqstory.tag", "VideoLinkInfo", localJsonParseException);
    }
    return "";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_Wli != null);
  }
  
  public String b()
  {
    String str1;
    String str2;
    label30:
    String str3;
    if (this.b != null)
    {
      str1 = this.b.trim();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlh
 * JD-Core Version:    0.7.0.1
 */