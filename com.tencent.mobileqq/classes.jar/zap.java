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

public class zap
{
  private static Map<Integer, String> a(zaq paramzaq, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramzaq != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramzaq)
          {
            for (;;)
            {
              Object localObject;
              yxp.d("GdtFormUpdateRegexUtil", "parseRegex", paramzaq);
            }
            return localHashMap;
          }
          catch (Throwable paramzaq)
          {
            for (;;)
            {
              yxp.d("GdtFormUpdateRegexUtil", "parseRegex", paramzaq);
            }
          }
          yxp.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramzaq.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          yxp.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramzaq.a + " message:" + (String)localObject);
        } while (paramzaq.a != 0);
        paramzaq = paramJSONObject.getJSONObject("data");
      } while ((paramzaq == null) || (paramzaq == JSONObject.NULL));
      paramzaq = paramzaq.getJSONObject("regexMap");
    } while ((paramzaq == null) || (paramzaq == JSONObject.NULL));
    paramJSONObject = paramzaq.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramzaq.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static zaq a()
  {
    zaq localzaq = new zaq(null);
    localzaq.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localzaq.method = "GET";
    localzaq.contentType = "application/json";
    localzaq.connectTimeoutMillis = 5000;
    localzaq.readTimeoutMillis = 5000;
    return localzaq;
  }
  
  public static void a(WeakReference<GdtFormData> paramWeakReference)
  {
    ThreadManager.post(new GdtFormUpdateRegexUtil.1(paramWeakReference), 5, null, true);
  }
  
  private static void a(WeakReference<GdtFormData> paramWeakReference, zaq paramzaq)
  {
    if ((paramzaq == null) || (!paramzaq.isSuccess()) || (paramzaq.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((GdtFormData)paramWeakReference.get()).isValid()))
    {
      yxp.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramzaq.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramzaq = a(paramzaq, new JSONObject((String)localObject));
        if (paramzaq == null) {
          break;
        }
        i = 0;
        if (i >= ((GdtFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((GdtFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((GdtFormItemData)localObject).isValid()))
        {
          yxp.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            yxp.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        yxp.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramzaq.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        yxp.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        yxp.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramzaq.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<GdtFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      zaq localzaq;
      if (i < 3)
      {
        localzaq = a();
        if (localzaq != null) {}
      }
      else
      {
        yxp.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localzaq);
        a(paramWeakReference, localzaq);
      } while ((localzaq.isSuccess()) && (localzaq.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zap
 * JD-Core Version:    0.7.0.1
 */