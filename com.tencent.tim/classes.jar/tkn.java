import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;

class tkn
  implements tkm
{
  private tgc.a b = new tko(this);
  private WeakReference<tjs> dz;
  private Map<tgc, String> map = new HashMap();
  
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    int i = 0;
    Activity localActivity;
    if (paramtjs != null)
    {
      localActivity = paramtjs.getActivity();
      if ((paramtjs != null) && (localActivity != null)) {
        break label37;
      }
      tkw.e("GdtLoadAdJsCallHandler", "handleJsCallRequest error");
    }
    for (;;)
    {
      return true;
      localActivity = null;
      break;
      try
      {
        label37:
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        tkw.i("GdtLoadAdJsCallHandler", localJSONObject.toString());
        paramVarArgs = new tgc.b();
        paramVarArgs.a = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGet(), localJSONObject)));
        this.dz = new WeakReference(paramtjs);
        paramtjs = new tgc(paramVarArgs, new WeakReference(this.b));
        this.map.put(paramtjs, paramString);
        paramtjs.c(new WeakReference(localActivity));
        paramtjs = new ArrayList();
        if ((paramVarArgs.a == null) || (paramVarArgs.a.position_info.isEmpty())) {
          continue;
        }
        while (i < paramVarArgs.a.position_info.size())
        {
          paramString = ((qq_ad_get.QQAdGet.PositionInfo)paramVarArgs.a.position_info.get(i)).pos_id.get();
          if (TextUtils.isEmpty(paramString)) {
            paramtjs.add(paramString);
          }
          i += 1;
        }
        return true;
      }
      catch (JSONException paramtjs)
      {
        tkw.e("GdtLoadAdJsCallHandler", "handleJsCallRequest error", paramtjs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkn
 * JD-Core Version:    0.7.0.1
 */