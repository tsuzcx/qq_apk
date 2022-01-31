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

class xfq
  extends BroadcastReceiver
{
  xfq(xfp paramxfp) {}
  
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
      xfp.a(this.a).a();
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
          localObject = new xgc();
          ((xgc)localObject).jdField_b_of_type_JavaLangString = paramIntent.optString("title");
          ((xgc)localObject).jdField_b_of_type_Int = 2;
          ((xgc)localObject).a = String.valueOf(i);
          ((xgc)localObject).g = paramContext;
          xfp.a(this.a).a((xgc)localObject);
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
        wtb.a("0X80076D6");
        return;
        paramContext = new MusicItemInfo();
        paramContext.mType = 5;
        paramContext.mItemId = i;
        paramContext.mMusicName = paramIntent.optString("title");
        paramContext.mSingername = paramIntent.optString("desc");
        paramContext.mSongMid = paramIntent.optString("mid");
        xfp.a(this.a, paramIntent.optBoolean("is_from_story", false));
        xfp.a(this.a, paramContext.mSongMid);
      }
      if ("action_music_start".equals(localObject))
      {
        xfp.a(this.a).b();
        return;
      }
    } while (!"action_music_refresh_list".equals(localObject));
    xfp.a(this.a).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfq
 * JD-Core Version:    0.7.0.1
 */