import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;

public class gdc
  extends BroadcastReceiver
{
  public gdc(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      MusicGeneWebViewPlugin.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gdc
 * JD-Core Version:    0.7.0.1
 */