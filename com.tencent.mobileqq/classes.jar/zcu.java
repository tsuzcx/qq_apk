import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zcu
{
  public static zct a(Context paramContext, String paramString)
  {
    paramContext = PatchSharedPreUtil.getPatchConfig(paramContext, paramString);
    paramString = new ArrayList();
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONArray();
          break label125;
          if (i < paramContext.length())
          {
            JSONObject localJSONObject = paramContext.getJSONObject(i);
            if (localJSONObject == null) {
              break label130;
            }
            paramString.add(new zct(localJSONObject));
            break label130;
          }
        }
        else
        {
          paramContext = new JSONArray(paramContext);
        }
      }
      catch (JSONException paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchConfigManager getLatestPatchConfig", paramContext);
        if (paramString.size() > 1) {
          Collections.sort(paramString, new zcv());
        }
        if (paramString.size() > 0) {
          return (zct)paramString.get(0);
        }
        return null;
      }
      label125:
      int i = 0;
      continue;
      label130:
      i += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = new HashMap();
        if (TextUtils.isEmpty(paramString))
        {
          paramString = new JSONArray();
          break label291;
          if (i >= paramString.length()) {
            break label159;
          }
          localObject2 = paramString.getJSONObject(i);
          if (localObject2 == null) {
            break label296;
          }
          localObject3 = new zct((JSONObject)localObject2).a();
          if ((!"dex".equals(localObject3)) && (!"Native".equals(localObject3))) {
            break label296;
          }
          if (((HashMap)localObject1).containsKey(localObject3))
          {
            ((ArrayList)((HashMap)localObject1).get(localObject3)).add(localObject2);
            break label296;
          }
        }
        else
        {
          paramString = new JSONArray(paramString);
          break label291;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject2);
        ((HashMap)localObject1).put(localObject3, localArrayList);
      }
      catch (JSONException paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchConfigManager appendPatchConfigToDisk", paramContext);
        return;
      }
      label159:
      Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        paramString = PatchSharedPreUtil.getPatchConfig(paramContext, (String)localObject2);
        if (TextUtils.isEmpty(paramString)) {}
        for (paramString = new JSONArray();; paramString = new JSONArray(paramString))
        {
          localObject3 = ((ArrayList)((Map.Entry)localObject3).getValue()).iterator();
          while (((Iterator)localObject3).hasNext()) {
            paramString.put((JSONObject)((Iterator)localObject3).next());
          }
        }
        PatchSharedPreUtil.updatePatchConfig(paramContext, (String)localObject2, paramString.toString());
      }
      continue;
      label291:
      int i = 0;
      continue;
      label296:
      i += 1;
    }
  }
  
  public static void a(Context paramContext, zct paramzct)
  {
    int i = 0;
    if (paramzct == null) {
      return;
    }
    for (;;)
    {
      try
      {
        String str = paramzct.a();
        localObject = PatchSharedPreUtil.getPatchConfig(paramContext, str);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          localObject = new JSONArray();
          ((JSONArray)localObject).put(new JSONObject(paramzct.e()));
          PatchSharedPreUtil.updatePatchConfig(paramContext, str, ((JSONArray)localObject).toString());
          return;
        }
      }
      catch (JSONException paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchConfigManager updatePatchConfigToDisk", paramContext);
        return;
      }
      Object localObject = new JSONArray((String)localObject);
      if (((JSONArray)localObject).length() == 1)
      {
        localObject = new zct(((JSONArray)localObject).getJSONObject(0));
        if (localObject != null)
        {
          int j = ((zct)localObject).a();
          int k = paramzct.a();
          if (j >= k) {}
        }
        else
        {
          i = 1;
        }
      }
      else
      {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcu
 * JD-Core Version:    0.7.0.1
 */