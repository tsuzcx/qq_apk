import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.1;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class aptl
{
  public static aptl a;
  public static final HashMap<String, String> ox = new HashMap();
  public boolean cSl = false;
  public Object mLock = new Object();
  
  static
  {
    ox.put("troop_create", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    ox.put("troop_create_for_school", "https://admin.qun.qq.com/mcreatev3/school_new.html?_bid=206&_wv=3&_wwv=128&_nativeFrom=<$FROM>");
    ox.put("troop_create_for_game", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    ox.put("troop_gift", "https://qun.qq.com/qunpay/gifts/index.html?troopUin=<$GC>&uin=<$UIN>&name=<$NICK>&from=<$FROM>&_wv=1031&_bid=2204&_wvSb=1&_nav_alpha=0");
    ox.put("troop_rank", "https://qun.qq.com/qqweb/m/qun/rank/rank.html?gc=<$GC>&uin=<$UIN>&from=<$FROM>&_wv=1031&_bid=2468");
    ox.put("troop_level", "https://qinfo.clt.qq.com/qlevel/level.html?gc=<$GC>&type=<$TYPE>");
    ox.put("troop_unique_title", "https://qun.qq.com/qqweb/m/qun/medal/index.html?_wv=16777223&_bid=2504&gc=<$GC>&uin=<$UIN>&from=<$FROM>");
    ox.put("troop_create_notice", "https://web.qun.qq.com/mannounce/edit.html?_bid=148&_wv=1031&gc=<$GC>&title=<$TITLE>&content=<$CONTENT>&from=<$FROM>&school=1");
    ox.put("troop_create_homework", "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>");
    ox.put("troop_list_homework", "https://qun.qq.com/homework/features/v2/index.html?_wv=1027&_bid=3089&gc=<$GC>&from=<$FROM>");
    ox.put("troop_homework_create_notice", "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>");
    ox.put("troop_bind_game", "https://imgcache.qq.com/gc/gamecenterV2/dist/index/qqbindGroup/index.html?_wvx=10&_wvxBclr=0xffffff&_wv=1027");
    ox.put("troop_honor_page", "https://qun.qq.com/interactive/qunhonor?gc=<$GC>&_wv=3&&_wwv=128");
    ox.put("troop_member_honor_page", "https://qun.qq.com/interactive/userhonor?uin=<$UIN>&gc=<$GC>&_wv=3&&_wwv=128");
    ox.put("troop_honor_setting", "https://qinfo.clt.qq.com/qlevel/setting.html?_wv=4&_bid=125#gc=<$GC>&type=102&grayscale=<$GRAY>");
  }
  
  private aptl()
  {
    ThreadManager.post(new TroopLinkManager.1(this, BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "troop_link_config.json"), 5, null, false);
  }
  
  public static aptl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aptl();
      }
      return a;
    }
    finally {}
  }
  
  public String D(String paramString, boolean paramBoolean)
  {
    Object localObject = aptl.a.a().a(paramString);
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      paramString = ((aptl.a)localObject).f(paramString);
      localObject = a().b("troop_honor_setting", paramString);
      if (!anlm.ayn()) {
        break;
      }
      paramString = "&mode_color=000000";
      int i = anlm.Kb();
      if (i != 0)
      {
        paramString = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
        paramString = "&mode_color=" + paramString;
      }
      return (String)localObject + paramString;
    }
    return localObject;
  }
  
  public String a(String paramString, aptl.a parama)
  {
    String str1 = paramString;
    if (parama.from != null) {
      str1 = paramString.replace("<$FROM>", parama.from);
    }
    paramString = str1;
    if (parama.crf != null) {
      paramString = str1.replace("<$GC>", parama.crf);
    }
    str1 = paramString;
    if (parama.nick != null) {
      str1 = paramString.replace("<$NICK>", parama.nick);
    }
    paramString = str1;
    if (parama.type != null) {
      paramString = str1.replace("<$TYPE>", parama.type);
    }
    str1 = paramString;
    if (parama.uin != null) {
      str1 = paramString.replace("<$UIN>", parama.uin);
    }
    paramString = str1;
    if (parama.crg != null) {
      paramString = str1.replace("<$CATEID>", parama.crg);
    }
    str1 = paramString;
    if (parama.subId != null) {
      str1 = paramString.replace("<$SUBID>", parama.subId);
    }
    paramString = str1;
    if (parama.crh != null) {
      paramString = str1.replace("<$GRAY>", parama.crh);
    }
    str1 = paramString;
    if (parama.title != null) {}
    try
    {
      str1 = paramString.replace("<$TITLE>", URLEncoder.encode(parama.title, "UTF-8").replaceAll("\\+", "%20"));
      paramString = str1;
      if (parama.content == null) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2;
      for (;;)
      {
        try
        {
          paramString = str1.replace("<$CONTENT>", URLEncoder.encode(parama.content, "UTF-8").replaceAll("\\+", "%20"));
          return paramString;
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString.printStackTrace();
        }
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
        str2 = paramString;
      }
      return str2;
    }
  }
  
  public String aF(String paramString, int paramInt)
  {
    paramString = aptl.a.a().a(paramString);
    String str = a().b("troop_honor_page", paramString);
    if (anlm.ayn())
    {
      paramString = "&mode_color=000000";
      int i = anlm.Kb();
      if (i != 0)
      {
        paramString = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
        paramString = "&mode_color=" + paramString;
      }
    }
    for (paramString = str + paramString;; paramString = str) {
      return paramString + "&dragon_gray" + paramInt;
    }
  }
  
  public String b(String paramString, aptl.a parama)
  {
    String str = getUrl(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (parama != null) {
        paramString = a(str, parama);
      }
    }
    return paramString;
  }
  
  public String bQ(String paramString1, String paramString2)
  {
    paramString1 = aptl.a.a().b(paramString2).a(paramString1);
    return a().b("troop_member_honor_page", paramString1);
  }
  
  public String d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString3 = aptl.a.a().a(paramString1).b(paramString2).e(paramString3).d("3").c("aio");
    paramString4 = a().b("troop_unique_title", paramString3);
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4))
    {
      paramString3 = new StringBuilder();
      paramString3.append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      paramString3.append("gc=").append(paramString1).append("&");
      paramString3.append("uin=").append(paramString2).append("&");
      paramString3.append("type=").append(3).append("&");
      paramString3.append("from=").append("aio").append("&");
      paramString3.append("_wv=").append("16777223");
      paramString3.append("&_wwv=1");
      paramString3 = paramString3.toString();
    }
    return paramString3;
  }
  
  public String getUrl(String paramString)
  {
    synchronized (this.mLock)
    {
      paramString = (String)ox.get(paramString);
      return paramString;
    }
  }
  
  public boolean qT(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trooplink", 2, "config update:" + paramString);
    }
    try
    {
      localObject2 = new JSONObject(paramString);
      Iterator localIterator = ((JSONObject)localObject2).keys();
      synchronized (this.mLock)
      {
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject2).getString(str1);
          ox.put(str1, str2);
        }
      }
      this.cSl = true;
    }
    catch (Exception paramString)
    {
      QLog.e(".troop.trooplink", 1, "parseConfig failed!", paramString);
      return false;
    }
    ??? = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "troop_link_config.json";
    Object localObject2 = new File((String)???);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    ThreadManager.post(new TroopLinkManager.2(this, (String)???, paramString), 5, null, false);
    return true;
  }
  
  public static class a
  {
    public String content;
    public String crf;
    public String crg;
    public String crh;
    public String from;
    public String nick;
    public String subId;
    public String title;
    public String type;
    public String uin;
    
    public static a a()
    {
      return new a();
    }
    
    public a a(String paramString)
    {
      this.crf = paramString;
      return this;
    }
    
    public a b(String paramString)
    {
      this.uin = paramString;
      return this;
    }
    
    public a c(String paramString)
    {
      this.from = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.type = paramString;
      return this;
    }
    
    public a e(String paramString)
    {
      this.nick = paramString;
      return this;
    }
    
    public a f(String paramString)
    {
      this.crh = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptl
 * JD-Core Version:    0.7.0.1
 */