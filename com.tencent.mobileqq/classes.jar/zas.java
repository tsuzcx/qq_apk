import android.text.TextUtils;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.gdtad.views.form.GdtFormData;
import com.tencent.gdtad.views.form.framework.GdtFormItemData;
import com.tencent.gdtad.views.form.framework.GdtFormTableData;
import com.tencent.gdtad.views.form.framework.GdtFormUpdateRegexUtil.1;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class zas
{
  private static Map<Integer, String> a(zat paramzat, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramzat != null) && (paramJSONObject != null)) {}
    label34:
    do
    {
      do
      {
        do
        {
          try
          {
            localObject = JSONObject.NULL;
            if (paramJSONObject != localObject) {
              break label34;
            }
          }
          catch (JSONException paramzat)
          {
            for (;;)
            {
              Object localObject;
              yxs.d("GdtFormUpdateRegexUtil", "parseRegex", paramzat);
            }
            return localHashMap;
          }
          catch (Throwable paramzat)
          {
            for (;;)
            {
              yxs.d("GdtFormUpdateRegexUtil", "parseRegex", paramzat);
            }
          }
          yxs.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramzat.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          yxs.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramzat.a + " message:" + (String)localObject);
        } while (paramzat.a != 0);
        paramzat = paramJSONObject.getJSONObject("data");
      } while ((paramzat == null) || (paramzat == JSONObject.NULL));
      paramzat = paramzat.getJSONObject("regexMap");
    } while ((paramzat == null) || (paramzat == JSONObject.NULL));
    paramJSONObject = paramzat.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramzat.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static zat a()
  {
    zat localzat = new zat(null);
    localzat.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localzat.method = "GET";
    localzat.contentType = "application/json";
    localzat.connectTimeoutMillis = 5000;
    localzat.readTimeoutMillis = 5000;
    return localzat;
  }
  
  public static void a(WeakReference<GdtFormData> paramWeakReference)
  {
    ThreadManager.post(new GdtFormUpdateRegexUtil.1(paramWeakReference), 5, null, true);
  }
  
  private static void a(WeakReference<GdtFormData> paramWeakReference, zat paramzat)
  {
    if ((paramzat == null) || (!paramzat.isSuccess()) || (paramzat.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((GdtFormData)paramWeakReference.get()).isValid()))
    {
      yxs.d("GdtFormUpdateRegexUtil", "parseResponse error");
      label49:
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = Charset.forName("UTF-8");
        if (localObject == null) {
          break;
        }
        localObject = new String(paramzat.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramzat = a(paramzat, new JSONObject((String)localObject));
        if (paramzat == null) {
          break;
        }
        i = 0;
        if (i >= ((GdtFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((GdtFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((GdtFormItemData)localObject).isValid()))
        {
          yxs.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            yxs.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        yxs.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramzat.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        yxs.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        yxs.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramzat.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<GdtFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      zat localzat;
      if (i < 3)
      {
        localzat = a();
        if (localzat != null) {}
      }
      else
      {
        yxs.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localzat);
        a(paramWeakReference, localzat);
      } while ((localzat.isSuccess()) && (localzat.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zas
 * JD-Core Version:    0.7.0.1
 */