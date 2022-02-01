import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.gdtad.views.videoimax.GdtImaxData;
import org.json.JSONObject;

public final class tjz
  implements tkm
{
  private static GdtAd a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!paramIntent.hasExtra("gdt_ad")) {
      return null;
    }
    return (GdtAd)paramIntent.getParcelableExtra("gdt_ad");
  }
  
  private static JSONObject a(GdtAd paramGdtAd)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramGdtAd != null) {}
    for (;;)
    {
      try
      {
        boolean bool = paramGdtAd.isValid();
        if (bool) {
          continue;
        }
      }
      catch (Throwable paramGdtAd)
      {
        Object localObject;
        tkw.e("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramGdtAd);
        continue;
      }
      if (localJSONObject.length() <= 0) {
        break label95;
      }
      return localJSONObject;
      localObject = tkv.pbToJson(paramGdtAd.info);
      if ((localObject != null) && (localObject != JSONObject.NULL)) {
        localJSONObject.put("adInfo", localObject.toString());
      }
      paramGdtAd = paramGdtAd.getCanvasForXiJingOffline();
      if (!TextUtils.isEmpty(paramGdtAd)) {
        localJSONObject.put("canvasJson", paramGdtAd);
      }
    }
    label95:
    return null;
  }
  
  private static GdtAd b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return null;
        } while (!paramIntent.hasExtra("data"));
        paramIntent = paramIntent.getSerializableExtra("data");
      } while ((paramIntent == null) || (!(paramIntent instanceof GdtVideoCeilingData)));
      paramIntent = (GdtVideoCeilingData)GdtVideoCeilingData.class.cast(paramIntent);
    } while (paramIntent == null);
    return paramIntent.getAd();
  }
  
  private static GdtAd c(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          return null;
        } while (!paramIntent.hasExtra("data"));
        paramIntent = paramIntent.getSerializableExtra("data");
      } while ((paramIntent == null) || (!(paramIntent instanceof GdtImaxData)));
      paramIntent = (GdtImaxData)GdtImaxData.class.cast(paramIntent);
    } while (paramIntent == null);
    return paramIntent.getAd();
  }
  
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    if (paramtjs != null) {}
    for (Object localObject = paramtjs.getActivity(); (paramtjs == null) || (localObject == null); localObject = null)
    {
      tkw.e("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    paramVarArgs = a(a(((Activity)localObject).getIntent()));
    if ((paramVarArgs != null) && (paramVarArgs != JSONObject.NULL) && (paramVarArgs.length() > 0)) {}
    for (;;)
    {
      if (paramVarArgs != null)
      {
        localObject = paramVarArgs;
        if (paramVarArgs != JSONObject.NULL) {}
      }
      else
      {
        localObject = new JSONObject();
      }
      tkw.i("GdtCanvasJSONJsCallHandler", String.format("result: %s", new Object[] { ((JSONObject)localObject).toString() }));
      try
      {
        paramtjs.callJs(paramString, new String[] { ((JSONObject)localObject).toString() });
        return true;
      }
      catch (Throwable paramtjs)
      {
        tkw.e("GdtCanvasJSONJsCallHandler", "handleJsCallRequest error", paramtjs);
        return true;
      }
      JSONObject localJSONObject = a(b(((Activity)localObject).getIntent()));
      if ((localJSONObject != null) && (localJSONObject != JSONObject.NULL))
      {
        paramVarArgs = localJSONObject;
        if (localJSONObject.length() > 0) {}
      }
      else
      {
        paramVarArgs = a(c(((Activity)localObject).getIntent()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjz
 * JD-Core Version:    0.7.0.1
 */