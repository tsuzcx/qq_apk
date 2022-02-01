import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormTableData;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
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

public class tmc
{
  private static Map<Integer, String> a(tmc.a parama, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((parama != null) && (paramJSONObject != null)) {}
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
          catch (JSONException parama)
          {
            for (;;)
            {
              Object localObject;
              tkw.e("GdtFormUpdateRegexUtil", "parseRegex", parama);
            }
            return localHashMap;
          }
          catch (Throwable parama)
          {
            for (;;)
            {
              tkw.e("GdtFormUpdateRegexUtil", "parseRegex", parama);
            }
          }
          tkw.e("GdtFormUpdateRegexUtil", "parseRegex error");
          return null;
          parama.returnCode = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          tkw.i("GdtFormUpdateRegexUtil", "onResponse code:" + parama.returnCode + " message:" + (String)localObject);
        } while (parama.returnCode != 0);
        parama = paramJSONObject.getJSONObject("data");
      } while ((parama == null) || (parama == JSONObject.NULL));
      parama = parama.getJSONObject("regexMap");
    } while ((parama == null) || (parama == JSONObject.NULL));
    paramJSONObject = parama.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = parama.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static tmc.a a()
  {
    tmc.a locala = new tmc.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    locala.method = "GET";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    return locala;
  }
  
  private static void a(WeakReference<AdFormData> paramWeakReference, tmc.a parama)
  {
    if ((parama == null) || (!parama.isSuccess()) || (parama.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      tkw.e("GdtFormUpdateRegexUtil", "parseResponse error");
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
        localObject = new String(parama.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        parama = a(parama, new JSONObject((String)localObject));
        if (parama == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          tkw.e("GdtFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof GdtFormItemTextBoxData))
        {
          localObject = (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localObject);
          if (localObject == null) {
            tkw.e("GdtFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        tkw.e("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((GdtFormItemTextBoxData)localObject).regexType == -2147483648) {
          break label262;
        }
        if (parama.containsKey(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType))) {
          break label242;
        }
        tkw.e("GdtFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        tkw.e("GdtFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((GdtFormItemTextBoxData)localObject).regex = ((String)parama.get(Integer.valueOf(((GdtFormItemTextBoxData)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  public static void d(WeakReference<AdFormData> paramWeakReference)
  {
    ThreadManager.post(new GdtFormUpdateRegexUtil.1(paramWeakReference), 5, null, true);
  }
  
  private static void e(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      tmc.a locala;
      if (i < 3)
      {
        locala = a();
        if (locala != null) {}
      }
      else
      {
        tkw.e("GdtFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(locala);
        a(paramWeakReference, locala);
      } while ((locala.isSuccess()) && (locala.returnCode == 0));
      i += 1;
    }
  }
  
  static class a
    extends AdHttp.Params
  {
    public int returnCode = -2147483648;
    
    public boolean isSuccess()
    {
      return (super.isSuccess()) && (this.responseData != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmc
 * JD-Core Version:    0.7.0.1
 */