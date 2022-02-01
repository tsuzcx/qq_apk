import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aech
  implements aebx
{
  private Bundle mBundle;
  
  public aech() {}
  
  public aech(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public void b(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_floatwin");
    localIntent.putExtra("url", paramColorNote.getSubType());
    if (paramColorNote.getReserve() != null) {}
    try
    {
      localIntent.putExtra("key_scroll_y", new JSONObject(new String(paramColorNote.getReserve())).getInt("key_scroll_y"));
      localIntent.putExtra("subType", paramColorNote.mSubType);
      localIntent.addFlags(268435456);
      if (this.mBundle != null) {
        localIntent.putExtra("isFromFavourite", this.mBundle.getBoolean("isFromFavourite", false));
      }
      paramContext.startActivity(localIntent);
      nns.b(paramColorNote);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("WebLauncher", 1, localJSONException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aech
 * JD-Core Version:    0.7.0.1
 */