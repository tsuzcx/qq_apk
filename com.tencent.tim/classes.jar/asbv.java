import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asbv
  extends asbu
{
  private List<asbs> JK = new ArrayList();
  private HashSet<String> bL = new HashSet();
  public String cEh = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  private HashMap<String, asbr> pS = new HashMap();
  
  private asbr a(String paramString1, String paramString2, asbs paramasbs)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramasbs == null)) {}
    String[] arrayOfString;
    do
    {
      int i;
      do
      {
        return null;
        i = paramString2.lastIndexOf("/") + 1;
      } while (i < 2);
      str1 = paramString2.substring(i);
      paramString2 = paramString2.substring(0, i).split("/");
      arrayOfString = str1.split(paramasbs.cEg);
      if ((paramString2.length >= paramasbs.ely) && (arrayOfString.length >= paramasbs.elB)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WadlCommConfig", 1, "interrupt url fail, pathInfo.length=" + paramString2.length + ",fileInfo.length=" + arrayOfString.length);
    return null;
    String str2 = paramString2[paramasbs.elz];
    if (paramasbs.elA > -1)
    {
      paramString2 = paramString2[paramasbs.elA];
      if (paramasbs.elC <= -1) {
        break label192;
      }
    }
    label192:
    for (String str1 = arrayOfString[paramasbs.elC];; str1 = "")
    {
      return new asbr(str2, paramString2, str1, arrayOfString[paramasbs.elD], paramString1);
      paramString2 = "";
      break;
    }
  }
  
  /* Error */
  public asbr a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	asbv:pS	Ljava/util/HashMap;
    //   4: aload_1
    //   5: invokevirtual 134	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 119	asbr
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: ifnonnull +70 -> 85
    //   18: aload_0
    //   19: getfield 33	asbv:JK	Ljava/util/List;
    //   22: invokeinterface 140 1 0
    //   27: astore 4
    //   29: aload_2
    //   30: astore_3
    //   31: aload 4
    //   33: invokeinterface 145 1 0
    //   38: ifeq +47 -> 85
    //   41: aload 4
    //   43: invokeinterface 149 1 0
    //   48: checkcast 68	asbs
    //   51: astore_3
    //   52: aload_3
    //   53: getfield 152	asbs:pattern	Ljava/lang/String;
    //   56: invokestatic 158	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   59: aload_1
    //   60: invokevirtual 162	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   63: astore 5
    //   65: aload 5
    //   67: invokevirtual 167	java/util/regex/Matcher:find	()Z
    //   70: ifeq -41 -> 29
    //   73: aload_0
    //   74: aload_1
    //   75: aload 5
    //   77: invokevirtual 170	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   80: aload_3
    //   81: invokespecial 172	asbv:a	(Ljava/lang/String;Ljava/lang/String;Lasbs;)Lasbr;
    //   84: astore_3
    //   85: aload_3
    //   86: areturn
    //   87: astore_1
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_1
    //   91: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: areturn
    //   96: astore_1
    //   97: goto -7 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	asbv
    //   0	100	1	paramString	String
    //   11	84	2	localasbr	asbr
    //   13	73	3	localObject	Object
    //   27	15	4	localIterator	java.util.Iterator
    //   63	13	5	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   0	12	87	java/lang/Exception
    //   18	29	96	java/lang/Exception
    //   31	85	96	java/lang/Exception
  }
  
  public HashSet<String> i()
  {
    return this.bL;
  }
  
  public void parse(String arg1)
  {
    boolean bool = true;
    super.parse(???);
    Object localObject3;
    int j;
    int i;
    Object localObject4;
    try
    {
      JSONObject localJSONObject = new JSONObject(new JSONObject(???).optString(this.key));
      this.cEh = localJSONObject.optString("download_mgr_url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
      localObject3 = localJSONObject.optJSONArray("websso_cmds");
      if (localObject3 == null) {
        break label137;
      }
      j = ((JSONArray)localObject3).length();
      if (j <= 0) {
        break label137;
      }
      synchronized (this.bL)
      {
        this.bL.clear();
        i = 0;
        if (i >= j) {
          break label135;
        }
        localObject4 = ((JSONArray)localObject3).optString(i);
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label535;
        }
        this.bL.add(localObject4);
      }
      return;
    }
    catch (JSONException ???)
    {
      ???.printStackTrace();
    }
    label134:
    label135:
    label137:
    if (localObject1.optInt("providerSwitch", 1) == 1) {}
    for (;;)
    {
      cooperation.wadl.WadlProvider.dqY = bool;
      cooperation.wadl.WadlProvider.cRN = localObject1.optString("providerSignKey", "");
      ??? = localObject1.optJSONObject("url_match_rule");
      if (??? == null) {
        break label134;
      }
      Object localObject2 = ???.optJSONArray("reg_list");
      if (localObject2 != null)
      {
        j = ((JSONArray)localObject2).length();
        if (j > 0) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          localObject3 = ((JSONArray)localObject2).getJSONObject(i);
          localObject4 = new asbs();
          ((asbs)localObject4).pattern = ((JSONObject)localObject3).getString("pattern");
          ((asbs)localObject4).ely = ((JSONObject)localObject3).getInt("path_node_num");
          ((asbs)localObject4).elz = ((JSONObject)localObject3).getInt("appid_index");
          ((asbs)localObject4).elA = ((JSONObject)localObject3).optInt("app_name_index", -1);
          ((asbs)localObject4).cEg = ((JSONObject)localObject3).getString("split_name_char");
          ((asbs)localObject4).elB = ((JSONObject)localObject3).getInt("name_node_num");
          ((asbs)localObject4).elC = ((JSONObject)localObject3).optInt("channel_index", -1);
          ((asbs)localObject4).elD = ((JSONObject)localObject3).getInt("pkg_name_index");
          if ((((asbs)localObject4).elz < ((asbs)localObject4).ely) && (((asbs)localObject4).elA < ((asbs)localObject4).ely) && (((asbs)localObject4).elC < ((asbs)localObject4).elB) && (((asbs)localObject4).elD < ((asbs)localObject4).elB)) {
            this.JK.add(localObject4);
          }
        }
        else
        {
          ??? = ???.optJSONArray("replace_list");
          if (??? == null) {
            break label134;
          }
          j = ???.length();
          if (j <= 0) {
            break label134;
          }
          i = 0;
          while (i < j)
          {
            Object localObject5 = ???.getJSONObject(i);
            localObject2 = ((JSONObject)localObject5).getString("url");
            localObject3 = ((JSONObject)localObject5).getString("appid");
            localObject4 = ((JSONObject)localObject5).optString("app_name", "");
            String str1 = ((JSONObject)localObject5).optString("channel", "");
            String str2 = ((JSONObject)localObject5).getString("pkg_name");
            localObject5 = ((JSONObject)localObject5).optString("replace_url", "");
            this.pS.put(localObject2, new asbr((String)localObject3, (String)localObject4, str1, str2, (String)localObject5));
            i += 1;
          }
          break label134;
          label535:
          i += 1;
          break;
        }
        i += 1;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbv
 * JD-Core Version:    0.7.0.1
 */