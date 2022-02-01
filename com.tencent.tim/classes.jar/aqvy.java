import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Card;
import org.json.JSONException;
import org.json.JSONObject;

public class aqvy
{
  public static aqvx a(Activity paramActivity, @NonNull JSONObject paramJSONObject, alcn paramalcn, String paramString)
    throws JSONException
  {
    if ((paramalcn == null) || (paramalcn.d == null)) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal card info is null");
    }
    long l1 = paramalcn.d.lCurrentStyleId;
    if (l1 < 0L) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id=" + l1);
    }
    long l2 = paramJSONObject.optLong("id");
    if (l2 != l1) {
      throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal style id(" + l1 + ") and json id(" + l2 + ") not match");
    }
    if (l2 == alcs.ago) {}
    for (paramActivity = new aqvz(paramActivity, paramJSONObject, paramalcn);; paramActivity = new aqwa(paramActivity, paramJSONObject, paramalcn))
    {
      paramActivity.VL(paramString);
      return paramActivity;
      if (l2 != alcs.agp) {
        break;
      }
    }
    throw new JSONException("DIYProfileTemplate.QVipProfileTemplateCreator illegal id=" + l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvy
 * JD-Core Version:    0.7.0.1
 */