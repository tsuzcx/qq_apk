import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class uhw
{
  public static final HashMap<String, List<Long>> a = new HashMap();
  
  public static Pair<List<GiftServiceBean>, List<GiftServiceBean>> a(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = "https://ag.qq.com/community/ajax/getAmsAreaInfo?gameId=" + paramString;
      localObject1 = new Bundle();
      HttpUtil.addCookie((Bundle)localObject1);
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), paramString, "GET", null, (Bundle)localObject1);
        if (paramString != null)
        {
          localObject1 = new JSONObject(new String(paramString)).optJSONObject("data");
          if (((JSONObject)localObject1).has("system"))
          {
            paramString = "";
            Object localObject2 = ((JSONObject)localObject1).optJSONArray("system");
            i = 0;
            JSONObject localJSONObject;
            if (i < ((JSONArray)localObject2).length())
            {
              localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
              if (!"android".equalsIgnoreCase(localJSONObject.optString("k"))) {
                break label430;
              }
              paramString = localJSONObject.optString("v");
              break label430;
            }
            if (((JSONObject)localObject1).has("server"))
            {
              localObject2 = ((JSONObject)localObject1).optJSONArray("server");
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
                GiftServiceBean localGiftServiceBean = new GiftServiceBean();
                localGiftServiceBean.t = localJSONObject.optString("t");
                localGiftServiceBean.v = localJSONObject.optString("v");
                localGiftServiceBean.s = localJSONObject.optString("s");
                localGiftServiceBean.c = localJSONObject.optString("c");
                localGiftServiceBean.ck = localJSONObject.optString("ck");
                if (!paramString.equals(localGiftServiceBean.s)) {
                  break label437;
                }
                localArrayList1.add(localGiftServiceBean);
                break label437;
              }
            }
            if (((JSONObject)localObject1).has("channel"))
            {
              paramString = ((JSONObject)localObject1).optJSONArray("channel");
              i = 0;
              if (i < paramString.length())
              {
                localObject1 = paramString.optJSONObject(i);
                localObject2 = new GiftServiceBean();
                ((GiftServiceBean)localObject2).t = ((JSONObject)localObject1).optString("t");
                ((GiftServiceBean)localObject2).v = ((JSONObject)localObject1).optString("v");
                ((GiftServiceBean)localObject2).sk = ((JSONObject)localObject1).optString("sk");
                ((GiftServiceBean)localObject2).ck = ((JSONObject)localObject1).optString("k");
                if (((GiftServiceBean)localObject2).ck.equals("qq")) {
                  localArrayList2.add(localObject2);
                }
                i += 1;
                continue;
              }
            }
          }
        }
        return new Pair(localArrayList2, localArrayList1);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      label430:
      i += 1;
      continue;
      label437:
      i += 1;
    }
  }
  
  public static Pair<Boolean, String> a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    boolean bool5 = false;
    bool3 = false;
    boolean bool4 = false;
    StringBuilder localStringBuilder = new StringBuilder("https://iyouxi3.vip.qq.com/ams3.0.php?_c=page");
    localStringBuilder.append("&rAccountType=1");
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append("&gameId=").append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append("&area=").append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append("&partition=").append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localStringBuilder.append("&actid=").append(paramString5);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localStringBuilder.append("&roleid=").append(paramString4);
    }
    paramString1 = paramString6;
    if (TextUtils.isEmpty(paramString6)) {
      paramString1 = "1";
    }
    localStringBuilder.append("&platid=").append(paramString1);
    paramString1 = pkh.a();
    paramString1 = ((TicketManager)((QQAppInterface)pkh.a()).getManager(2)).getSkey(paramString1);
    if (paramString1 == null) {}
    for (paramString1 = "";; paramString1 = a(paramString1))
    {
      localStringBuilder.append("&g_tk=").append(paramString1);
      paramString1 = new Bundle();
      HttpUtil.addCookie(paramString1);
      bool2 = bool5;
      try
      {
        paramString1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), localStringBuilder.toString(), "GET", null, paramString1);
        if (paramString1 == null) {
          break;
        }
        bool2 = bool5;
        paramString1 = new JSONObject(new String(paramString1));
        bool1 = bool4;
        bool2 = bool5;
        if (paramString1.has("ret"))
        {
          bool1 = bool4;
          bool2 = bool5;
          if (paramString1.optInt("ret") == 0) {
            bool1 = true;
          }
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramString1.has("msg")) {
          break;
        }
        bool2 = bool1;
        paramString1 = paramString1.optString("msg");
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          boolean bool1 = bool2;
          paramString1 = "";
          continue;
          paramString1 = "";
          bool1 = bool3;
        }
      }
      return new Pair(Boolean.valueOf(bool1), paramString1);
    }
  }
  
  public static String a(String paramString)
  {
    long l = 5381L;
    int i = 0;
    while (i < paramString.length())
    {
      l += (l << 5) + paramString.charAt(i);
      i += 1;
    }
    return String.valueOf(0x7FFFFFFF & l);
  }
  
  public static List<GiftServiceBean> a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder("https://iyouxi3.vip.qq.com/ams3.0.php?_c=queryRoleInfoByGameId");
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append("&gameId=").append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append("&area=").append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localStringBuilder.append("&partition=").append(paramString3);
    }
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = "1";
    }
    localStringBuilder.append("&platid=").append(paramString1);
    paramString1 = pkh.a();
    paramString1 = ((TicketManager)((QQAppInterface)pkh.a()).getManager(2)).getSkey(paramString1);
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      localStringBuilder.append("&g_tk=").append(paramString1);
      paramString1 = new Bundle();
      HttpUtil.addCookie(paramString1);
      try
      {
        paramString1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), localStringBuilder.toString(), "GET", null, paramString1);
        if (paramString1 != null)
        {
          paramString1 = new JSONObject(new String(paramString1)).optJSONArray("data");
          int i = 0;
          while (i < paramString1.length())
          {
            paramString2 = paramString1.optJSONObject(i);
            paramString3 = new GiftServiceBean();
            paramString3.t = paramString2.optString("nick");
            paramString3.ck = paramString2.optString("role_id");
            if ((!TextUtils.isEmpty(paramString3.ck)) && (TextUtils.isEmpty(paramString3.t))) {
              paramString3.t = anvx.a(2131704745);
            }
            localArrayList.add(paramString3);
            i += 1;
            continue;
            paramString1 = a(paramString1);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  @NonNull
  public static JSONObject a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("business", 2);
    localJSONObject.put("op_timestamp", System.currentTimeMillis());
    localJSONObject.put("net_type", String.valueOf(ofj.a()));
    localJSONObject.put("plat_id", 1);
    localJSONObject.put("imei", ujw.a());
    if (!TextUtils.isEmpty(pkh.a())) {
      localJSONObject.put("uin", Long.valueOf(pkh.a()));
    }
    localJSONObject.put("oper_type", paramInt1);
    localJSONObject.put("game_pkg", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localJSONObject.put("app_id", paramString2);
    }
    localJSONObject.put("gc_version", "");
    localJSONObject.put("idfa", "");
    localJSONObject.put("guid", "");
    localJSONObject.put("channel_id", "");
    localJSONObject.put("adtag", "");
    if (paramInt2 > 0) {
      localJSONObject.put("oper_module", paramInt2);
    }
    if (paramInt3 > 0) {
      localJSONObject.put("oper_id", paramInt3);
    }
    if (paramInt4 > 0) {
      localJSONObject.put("page_id", paramInt4);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(long paramLong, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("com_id", paramLong);
      localJSONObject2.put("type", paramInt);
      localJSONObject1.put("game_gift_report", localJSONObject2.toString());
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public static JSONObject a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("com_id", paramLong);
      localJSONObject2.put("type", paramInt1);
      localJSONObject2.put("show_inner_floating_bar", paramInt2);
      localJSONObject2.put("app_id", paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject2.put("ext1", paramString2);
      }
      localJSONObject1.put("game_gift_report", localJSONObject2.toString());
      return localJSONObject1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadManager.executeOnNetWorkThread(new GiftPackageManager.1(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    do
    {
      return;
      if (!a.containsKey(paramString)) {
        a.put(paramString, new ArrayList());
      }
      paramString = (List)a.get(paramString);
    } while (paramString.contains(Long.valueOf(paramLong)));
    paramString.add(Long.valueOf(paramLong));
  }
  
  public static boolean a(AppInterface paramAppInterface, long paramLong)
  {
    Object localObject;
    if (paramLong != 0L)
    {
      localObject = paramAppInterface;
      if (paramAppInterface == null)
      {
        localObject = paramAppInterface;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
          localObject = paramAppInterface;
          if (localAppRuntime != null)
          {
            localObject = paramAppInterface;
            if ((localAppRuntime instanceof QQAppInterface)) {
              localObject = (QQAppInterface)localAppRuntime;
            }
          }
        }
      }
      if (localObject != null) {
        break label64;
      }
    }
    label64:
    do
    {
      return false;
      paramAppInterface = ((AppInterface)localObject).getAccount();
    } while (TextUtils.isEmpty(paramAppInterface));
    if ((a.containsKey(paramAppInterface)) && (((List)a.get(paramAppInterface)).contains(Long.valueOf(paramLong)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhw
 * JD-Core Version:    0.7.0.1
 */