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

public class yra
{
  private static Map<Integer, String> a(yrb paramyrb, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((paramyrb != null) && (paramJSONObject != null)) {}
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
          catch (JSONException paramyrb)
          {
            for (;;)
            {
              Object localObject;
              yny.d("GdtFormUpdateRegexUtil", "parseRegex", paramyrb);
            }
            return localHashMap;
          }
          catch (Throwable paramyrb)
          {
            for (;;)
            {
              yny.d("GdtFormUpdateRegexUtil", "parseRegex", paramyrb);
            }
          }
          yny.d("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          paramyrb.a = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          yny.b("GdtFormUpdateRegexUtil", "onResponse code:" + paramyrb.a + " message:" + (String)localObject);
        } while (paramyrb.a != 0);
        paramyrb = paramJSONObject.getJSONObject("data");
      } while ((paramyrb == null) || (paramyrb == JSONObject.NULL));
      paramyrb = paramyrb.getJSONObject("regexMap");
    } while ((paramyrb == null) || (paramyrb == JSONObject.NULL));
    paramJSONObject = paramyrb.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = paramyrb.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static yrb a()
  {
    yrb localyrb = new yrb(null);
    localyrb.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    localyrb.method = "GET";
    localyrb.contentType = "application/json";
    localyrb.connectTimeoutMillis = 5000;
    localyrb.readTimeoutMillis = 5000;
    return localyrb;
  }
  
  public static void a(WeakReference<GdtFormData> paramWeakReference)
  {
    ThreadManager.post(new GdtFormUpdateRegexUtil.1(paramWeakReference), 5, null, true);
  }
  
  private static void a(WeakReference<GdtFormData> paramWeakReference, yrb paramyrb)
  {
    if ((paramyrb == null) || (!paramyrb.isSuccess()) || (paramyrb.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((GdtFormData)paramWeakReference.get()).isValid()))
    {
      yny.d("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(paramyrb.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramyrb = a(paramyrb, new JSONObject((String)localObject));
        if (paramyrb == null) {
          break;
        }
        i = 0;
        if (i >= ((GdtFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((GdtFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((GdtFormItemData)localObject).isValid()))
        {
          yny.d("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            yny.d("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        yny.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (paramyrb.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        yny.d("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        yny.d("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)paramyrb.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void c(WeakReference<GdtFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      yrb localyrb;
      if (i < 3)
      {
        localyrb = a();
        if (localyrb != null) {}
      }
      else
      {
        yny.d("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(localyrb);
        a(paramWeakReference, localyrb);
      } while ((localyrb.isSuccess()) && (localyrb.a == 0));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yra
 * JD-Core Version:    0.7.0.1
 */