import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class aebw
  implements aebx
{
  private void c(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_floatwin");
    localIntent.putExtra("url", paramColorNote.getSubType());
    localIntent.putExtra("subType", paramColorNote.mSubType);
    localIntent.putExtra("fragmentStyle", 1);
    localIntent.putExtra("tabBarStyle", 1);
    localIntent.putExtra("titleBarStyle", 1);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  private void e(Context paramContext, JSONObject paramJSONObject)
  {
    Intent localIntent = new Intent(paramContext, VipComicJumpActivity.class);
    localIntent.addFlags(268435456);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("jumpto", "com.qqcomic.activity.reader.VipComicPortraitReadingActivity");
      localJSONObject.put("comic", paramJSONObject);
      localJSONObject.put("from", Integer.parseInt("1041001"));
      label59:
      localIntent.putExtra("options", localJSONObject.toString());
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label59;
    }
  }
  
  private void f(Context paramContext, JSONObject paramJSONObject)
  {
    Intent localIntent = new Intent(paramContext, VipComicJumpActivity.class);
    localIntent.addFlags(268435456);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("jumpto", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
      localJSONObject.put("comic", paramJSONObject);
      label46:
      localIntent.putExtra("options", localJSONObject.toString());
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label46;
    }
  }
  
  public void b(Context paramContext, ColorNote paramColorNote)
  {
    try
    {
      localObject = paramColorNote.getReserve();
      if (localObject == null)
      {
        QLog.e("BoodoLauncher", 2, "color note reserve is null");
        return;
      }
      localObject = new JSONObject(new String((byte[])localObject));
    }
    catch (JSONException localJSONException)
    {
      int i;
      JSONObject localJSONObject;
      for (;;)
      {
        Object localObject;
        QLog.e("BoodoLauncher", 1, localJSONException, new Object[0]);
        localJSONObject = null;
      }
      if (i != 1) {
        break label92;
      }
      e(paramContext, localJSONObject);
      return;
      label92:
      if (i != 3) {
        return;
      }
      f(paramContext, localJSONObject);
    }
    i = ((JSONObject)localObject).optInt("colorNoteType", 0);
    if (i == 2)
    {
      c(paramContext, paramColorNote);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebw
 * JD-Core Version:    0.7.0.1
 */