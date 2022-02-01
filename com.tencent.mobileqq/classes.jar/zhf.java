import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class zhf
  extends BroadcastReceiver
{
  zhf(zhe paramzhe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(localObject))
    {
      localObject = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onReceive:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic")) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
    }
    do
    {
      return;
      zhe.a(this.a).a();
      for (;;)
      {
        try
        {
          paramIntent = new JSONObject((String)localObject);
          i = paramIntent.optInt("id");
          paramContext = paramContext.getSharedPreferences("VideoMusicCache", 0).getString(String.valueOf(i), null);
          if ((paramContext == null) || (!new File(paramContext).exists())) {
            continue;
          }
          localObject = new zhr();
          ((zhr)localObject).jdField_b_of_type_JavaLangString = paramIntent.optString("title");
          ((zhr)localObject).jdField_b_of_type_Int = 2;
          ((zhr)localObject).a = String.valueOf(i);
          ((zhr)localObject).g = paramContext;
          zhe.a(this.a).a((zhr)localObject);
        }
        catch (JSONException paramContext)
        {
          int i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MusicCache", 2, "on receiver error, ", paramContext);
          continue;
        }
        yuq.a("0X80076D6");
        return;
        paramContext = new MusicItemInfo();
        paramContext.mType = 5;
        paramContext.mItemId = i;
        paramContext.mMusicName = paramIntent.optString("title");
        paramContext.mSingername = paramIntent.optString("desc");
        paramContext.mSongMid = paramIntent.optString("mid");
        zhe.a(this.a, paramIntent.optBoolean("is_from_story", false));
        zhe.a(this.a, paramContext.mSongMid);
      }
      if ("action_music_start".equals(localObject))
      {
        zhe.a(this.a).b();
        return;
      }
    } while (!"action_music_refresh_list".equals(localObject));
    zhe.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhf
 * JD-Core Version:    0.7.0.1
 */