import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;

public class eaa
  extends BroadcastReceiver
{
  public eaa(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      MusicGeneWebViewPlugin.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eaa
 * JD-Core Version:    0.7.0.1
 */