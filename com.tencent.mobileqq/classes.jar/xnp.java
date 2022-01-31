import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class xnp
  extends BroadcastReceiver
{
  public xnp(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if (paramIntent != null) {
      if (paramIntent.getAction().equals("action_music_info_js_to_qzone"))
      {
        if (paramIntent.getIntExtra("key_is_paly_music", 0) != 1) {
          break label116;
        }
        paramContext = paramIntent.getStringExtra("key_music_url");
        EditLocalVideoActivity.b(this.a, paramIntent.getStringExtra("key_song_id"));
        EditLocalVideoActivity.c(this.a, paramIntent.getStringExtra("key_song_interval"));
        if (i == 0) {
          break label121;
        }
        if (!TextUtils.isEmpty(paramContext))
        {
          paramIntent = new Message();
          paramIntent.what = 1006;
          paramIntent.obj = paramContext;
          EditLocalVideoActivity.a(this.a).sendMessage(paramIntent);
        }
      }
    }
    for (;;)
    {
      LpReportInfo_pf00064.allReport(664, 3, 3);
      return;
      label116:
      i = 0;
      break;
      label121:
      EditLocalVideoActivity.a(this.a).sendEmptyMessage(1007);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnp
 * JD-Core Version:    0.7.0.1
 */