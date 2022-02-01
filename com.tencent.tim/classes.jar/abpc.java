import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class abpc
{
  public SparseArray<WeakReference<abpc.a>> cc;
  private ConcurrentHashMap<String, String> du = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, String> dv = new ConcurrentHashMap();
  private int mGameId;
  
  public abpc(int paramInt)
  {
    this.mGameId = paramInt;
  }
  
  public static String b(long paramLong, String paramString1, String paramString2)
  {
    if (!jw(paramString1)) {}
    for (;;)
    {
      return paramString2;
      try
      {
        if (abmt.a() != null)
        {
          paramString1 = new JSONObject(paramString2);
          String str = paramString1.optString("openId");
          paramString1.optInt("gameId");
          abpc localabpc = abmt.a(paramLong);
          if (localabpc != null)
          {
            str = localabpc.iD(str);
            if (!TextUtils.isEmpty(str))
            {
              paramString1.put("uin", str);
              return paramString1.toString();
            }
            QLog.w("cmgame_process.CmGameOpenIdFinder", 1, "logic error happens.");
            return paramString2;
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmgame_process.CmGameOpenIdFinder", 1, paramString1, new Object[0]);
      }
    }
    return paramString2;
  }
  
  public static void b(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("uin", paramString1);
    paramString1 = new abpd(paramString2, paramLong);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_get_accountInfo", localBundle, paramString1);
  }
  
  public static void j(long paramLong, int paramInt, String paramString)
  {
    Object localObject;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      abpc localabpc = abmt.a(paramLong);
      if (localabpc == null) {
        return;
      }
      localObject = localabpc.iD(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", paramInt);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramString);
        localabpc.a(2, localArrayList, null, 3, paramLong, true, ((JSONObject)localObject).toString(), "");
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, paramString, new Object[0]);
      return;
    }
    b(paramLong, paramInt, (String)localObject, paramString);
  }
  
  public static boolean jw(String paramString)
  {
    return ("cs.join_room.local".equals(paramString)) || ("cs.get_dress_path.local".equals(paramString));
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt2, long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameOpenIdFinder", 2, new Object[] { "[getOpenIdOrUinInfo], type:", Integer.valueOf(paramInt1), ",from:", Integer.valueOf(paramInt2), ",param:", paramString1 });
    }
    abpu localabpu = abmt.a();
    if (localabpu == null) {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, "sSoHandler is null.");
    }
    JSONObject localJSONObject;
    for (;;)
    {
      return;
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("from", "cmGame_" + paramInt2);
        localJSONObject.put("gameId", this.mGameId);
        localJSONObject.put("opType", paramInt1);
        if (2 != paramInt1) {
          break label307;
        }
        if ((paramArrayList != null) && (paramArrayList.size() != 0))
        {
          paramArrayList1 = new JSONArray();
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext()) {
            paramArrayList1.put((String)paramArrayList.next());
          }
          localabpu.a("apollo_aio_game.get_user_uin_or_openid", localJSONObject.toString(), -1L, paramInt2, false, null);
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        QLog.w("cmgame_process.CmGameOpenIdFinder", 1, "[getOpenIdOrUinInfo], errInfo->" + paramArrayList.getMessage());
      }
    }
    label217:
    return;
    localJSONObject.put("openIdList", paramArrayList1);
    for (;;)
    {
      localJSONObject.put("async", paramBoolean);
      localJSONObject.put("jsState", paramLong);
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("extraParam", paramString1);
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label217;
      }
      localJSONObject.put("bidCmd", paramString2);
      break label217;
      label307:
      if (1 == paramInt1)
      {
        if ((paramArrayList1 == null) || (paramArrayList1.size() == 0)) {
          break;
        }
        paramArrayList = new JSONArray();
        paramArrayList1 = paramArrayList1.iterator();
        while (paramArrayList1.hasNext()) {
          paramArrayList.put((Long)paramArrayList1.next());
        }
        localJSONObject.put("uinList", paramArrayList);
      }
    }
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, ArrayList<Long> paramArrayList1, int paramInt2, long paramLong, boolean paramBoolean, String paramString1, String paramString2, abpc.a parama)
  {
    a(paramInt1, paramArrayList, paramArrayList1, paramInt2, paramLong, paramBoolean, paramString1, paramString2);
    if (this.cc == null) {
      this.cc = new SparseArray();
    }
    this.cc.put(paramInt2, new WeakReference(parama));
  }
  
  public void a(ArrayList<Long> paramArrayList, ArrayList<String> paramArrayList1, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameOpenIdFinder", 2, new Object[] { "[onIdentifierResp], tinyids=" + paramArrayList.toString() + ",identifiers:", paramArrayList1.toString() });
    }
    if ((paramArrayList == null) || (paramArrayList1 == null) || (paramArrayList.size() <= 0) || (paramArrayList1.size() <= 0) || (this.dv == null)) {
      return;
    }
    if (paramArrayList.size() != paramArrayList1.size()) {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 2, "onIdentifierResp size is error");
    }
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    int i = 0;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        this.dv.put(paramArrayList.get(i), paramArrayList1.get(i));
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("identifier", paramArrayList1.get(i));
          localJSONArray.put(localJSONObject2);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("cmgame_process.CmGameOpenIdFinder", 2, "tinyId json error" + localException.toString());
          }
        }
      }
    }
    try
    {
      localJSONObject1.put("eventId", paramInt);
      localJSONObject1.put("userInfo", localJSONArray);
      label252:
      abmt.a().callbackFromRequest(paramLong, 0, "cs.audioRoom_update_userinfo.local", localJSONObject1.toString());
      return;
    }
    catch (Exception paramArrayList)
    {
      break label252;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameOpenIdFinder", 2, new Object[] { "[onOpenIdResp], callFrom:", Integer.valueOf(paramInt), ",reqData:", paramString });
    }
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      int i;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      long l;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("data").getJSONArray("list");
        int j = paramJSONObject.length();
        i = 0;
        if (i < j)
        {
          localObject2 = paramJSONObject.getJSONObject(i);
          if ((!((JSONObject)localObject2).has("uin")) || (!((JSONObject)localObject2).has("openId"))) {
            break label738;
          }
          localObject1 = ((JSONObject)localObject2).getString("uin");
          localObject2 = ((JSONObject)localObject2).getString("openId");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            QLog.w("cmgame_process.CmGameOpenIdFinder", 1, "[onOpenIdResp], openId or uin is empty");
          }
          else
          {
            ew((String)localObject2, (String)localObject1);
            localObject3 = new JSONObject(paramString);
            if (paramInt == 9)
            {
              localObject2 = new JSONObject(((JSONObject)localObject3).optString("extraParam"));
              boolean bool = ((JSONObject)localObject3).optBoolean("async");
              l = ((JSONObject)localObject3).optLong("jsState");
              localObject3 = ((JSONObject)localObject3).optString("bidCmd");
              ((JSONObject)localObject2).put("uin", localObject1);
              localObject1 = abmt.a();
              ((JSONObject)localObject2).put("gameId", this.mGameId);
              if (localObject1 == null) {
                break label738;
              }
              ((ApolloCmdChannel)localObject1).requestData(l, (String)localObject3, ((JSONObject)localObject2).toString(), bool, true);
            }
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.w("cmgame_process.CmGameOpenIdFinder", 1, "errInfo->" + paramJSONObject.getMessage());
      }
      if (paramInt == 8) {
        try
        {
          if (!TextUtils.isEmpty(paramString))
          {
            paramString = new JSONObject(new JSONObject(paramString).optString("extraParam"));
            paramInt = 0;
            if (paramString.has("eventId")) {
              paramInt = paramString.optInt("eventId");
            }
            paramJSONObject = "";
            if (paramString.has("identifierList")) {
              paramJSONObject = paramString.optString("identifierList");
            }
            localObject1 = new JSONArray(paramJSONObject);
            if (((JSONArray)localObject1).length() > 0)
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("eventId", paramInt);
              new JSONObject();
              localObject3 = new JSONArray();
              paramJSONObject = new ArrayList();
              i = 0;
              if (i < ((JSONArray)localObject1).length())
              {
                JSONObject localJSONObject = new JSONObject();
                String str1 = ((JSONArray)localObject1).get(i).toString();
                String str2 = iC(str1);
                if (TextUtils.isEmpty(str2)) {
                  paramJSONObject.add(Long.valueOf(Long.parseLong(str1)));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (paramInt == 3)
                  {
                    int k = new JSONObject(((JSONObject)localObject3).optString("extraParam")).optInt("type");
                    b(((JSONObject)localObject3).optLong("jsState"), k, (String)localObject1, (String)localObject2);
                    break label738;
                  }
                  if ((paramInt != 10) || (this.cc == null)) {
                    break label738;
                  }
                  localObject2 = (WeakReference)this.cc.get(paramInt);
                  if (localObject2 == null) {
                    break label738;
                  }
                  localObject2 = (abpc.a)((WeakReference)localObject2).get();
                  if (localObject2 == null) {
                    break label738;
                  }
                  ((abpc.a)localObject2).x(0, "", (String)localObject1);
                  this.cc.remove(paramInt);
                  break label738;
                  localJSONObject.put("openId", str2);
                  ((JSONArray)localObject3).put(localJSONObject);
                }
              }
              ((JSONObject)localObject2).put("userInfo", localObject3);
              if (paramString.has("lState"))
              {
                l = paramString.getLong("lState");
                if (((JSONArray)localObject3).length() > 0) {
                  abmt.a().callbackFromRequest(l, 0, "cs.audioRoom_update_userinfo.local", ((JSONObject)localObject2).toString());
                }
                if ((paramJSONObject.size() > 0) && (paramInt == 3))
                {
                  paramString = abmt.a();
                  if (paramString != null)
                  {
                    paramString.a(paramJSONObject, paramInt, l, this.mGameId);
                    return;
                    label738:
                    i += 1;
                  }
                }
              }
            }
          }
        }
        catch (Exception paramJSONObject) {}
      }
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (!jw(paramString1)) {
      return false;
    }
    try
    {
      Object localObject = new JSONObject(paramString2);
      String str1 = ((JSONObject)localObject).optString("openId");
      if (TextUtils.isEmpty(str1)) {
        return false;
      }
      String str2 = iD(str1);
      if (TextUtils.isEmpty(str2))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(str1);
        a(2, (ArrayList)localObject, null, 9, paramLong, paramBoolean, paramString2, paramString1);
        return true;
      }
      ((JSONObject)localObject).put("uin", str2);
      return false;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.CmGameOpenIdFinder", 1, paramString1, new Object[0]);
    }
    return false;
  }
  
  public String bh(long paramLong)
  {
    if (this.dv == null) {
      return null;
    }
    return (String)this.dv.get(Long.valueOf(paramLong));
  }
  
  public void ew(String arg1, String paramString2)
  {
    if ((TextUtils.isEmpty(???)) || (this.du == null)) {
      return;
    }
    String str = ??? + "_" + this.mGameId;
    synchronized (this.du)
    {
      this.du.put(str, paramString2);
      return;
    }
  }
  
  public String iB(String paramString)
  {
    if (this.dv == null) {
      return "";
    }
    Iterator localIterator = this.dv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = ((String)localEntry.getValue()).trim();
      if ((!TextUtils.isEmpty(paramString)) && (str.equals(paramString))) {
        return "" + localEntry.getKey();
      }
    }
    return "";
  }
  
  public String iC(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.du == null)) {
      return "";
    }
    synchronized (this.du)
    {
      Iterator localIterator = this.du.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = ((String)((Map.Entry)localObject).getValue()).trim();
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString)))
        {
          localObject = (String)((Map.Entry)localObject).getKey();
          int i = ((String)localObject).indexOf("_");
          if ((i != -1) && (i + 1 < ((String)localObject).length()))
          {
            str = ((String)localObject).substring(i + 1);
            if (String.valueOf(this.mGameId).equals(str))
            {
              paramString = ((String)localObject).substring(0, i);
              return paramString;
            }
          }
        }
      }
    }
    return "";
  }
  
  public String iD(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.du == null)) {
      return "";
    }
    paramString = paramString + "_" + this.mGameId;
    return (String)this.du.get(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void x(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpc
 * JD-Core Version:    0.7.0.1
 */