import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.utils.JsonORM.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class pty
{
  @JsonORM.a(key="capture")
  public ptu a;
  @JsonORM.a(key="comp")
  public ptv a;
  @JsonORM.a(key="gameinfo")
  public ptw a;
  @JsonORM.a(key="game")
  public ptx a;
  @JsonORM.a(key="videoShare")
  public pty.a a;
  @JsonORM.a(key="app")
  public String avn;
  @JsonORM.a(key="parseState")
  public int bkq;
  @JsonORM.a(key="body")
  public String body;
  @JsonORM.a(key="picUrl")
  public String iconUrl;
  @JsonORM.a(key="linkUrl")
  public String linkUrl;
  @JsonORM.a(key="type")
  public int styleType;
  @JsonORM.a(key="title")
  public String title;
  
  @Nullable
  public static pty a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = (pty)JsonORM.parseFrom(new JSONObject(paramString), pty.class);
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
  
  public static pty a(String paramString1, String paramString2, String paramString3, @Nullable String paramString4, @Nullable String paramString5)
  {
    pty localpty = new pty();
    localpty.linkUrl = paramString1;
    localpty.title = paramString2;
    localpty.body = paramString3;
    localpty.iconUrl = paramString4;
    localpty.avn = paramString5;
    localpty.styleType = 1;
    localpty.bkq = 2;
    return localpty;
  }
  
  public static pty a(String paramString1, boolean paramBoolean, @Nullable String paramString2, @Nullable String paramString3)
  {
    pty localpty = new pty();
    localpty.linkUrl = paramString1;
    localpty.iconUrl = paramString2;
    localpty.avn = paramString3;
    if (paramBoolean) {}
    for (localpty.bkq = 0;; localpty.bkq = 2)
    {
      localpty.styleType = 1;
      return localpty;
    }
  }
  
  public boolean IX()
  {
    return (this.styleType == 5) && (this.a != null);
  }
  
  public String aL()
  {
    String str3 = this.linkUrl;
    String str2 = str3;
    if (aqjb.WEB_URL.matcher(str3).find())
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
  
  public String i(boolean paramBoolean)
  {
    try
    {
      Object localObject = JsonORM.toJSON(this);
      if (paramBoolean) {
        ((JSONObject)localObject).remove("parseState");
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      ram.w("Q.qqstory.tag", "VideoLinkInfo", localJsonParseException);
    }
    return "";
  }
  
  public String mD()
  {
    String str1;
    String str2;
    label30:
    String str3;
    if (this.title != null)
    {
      str1 = this.title.trim();
      if (this.body == null) {
        break label57;
      }
      str2 = this.body.trim();
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        break label63;
      }
      str3 = this.linkUrl;
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
  
  public static class a
  {
    @JsonORM.a(key="unionID")
    public String avo;
    @JsonORM.a(key="fwReason")
    public String avp;
    @JsonORM.a(key="isNewFw")
    public String avq;
    @JsonORM.a(key="feedID")
    public String feedID;
    public String headUrl;
    public String nickName;
    @JsonORM.a(key="vid")
    public String vid;
    
    public boolean IY()
    {
      return "1".equals(this.avq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pty
 * JD-Core Version:    0.7.0.1
 */