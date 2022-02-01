import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;

public class gcy
  extends BroadcastReceiver
{
  public gcy(MusicGeneQQBrowserActivity paramMusicGeneQQBrowserActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            String str1;
            String str2;
            String str3;
            if ("BROAD_CAST_SHARE_MUSIC_GENE".equals(paramContext))
            {
              paramContext = paramIntent.getStringExtra("BUNDLE_KEY_TITLE");
              str1 = paramIntent.getStringExtra("BUNDLE_KEY_DESC");
              str2 = paramIntent.getStringExtra("BUDNLE_KEY_IMG_URL");
              str3 = paramIntent.getStringExtra("BUNDLE_KEY_SRC");
              paramIntent = paramIntent.getStringExtra("BUNDLE_KEY_ICON_URL");
              MusicGeneQQBrowserActivity.a(this.a, str2, str3, "", str1, paramContext, paramIntent, 1101244924L);
              return;
            }
            if ("BROAD_CAST_SHARE_SONG".equals(paramContext))
            {
              paramContext = paramIntent.getStringExtra("BUNDLE_KEY_TITLE");
              str1 = paramIntent.getStringExtra("BUNDLE_KEY_DESC");
              str2 = paramIntent.getStringExtra("BUDNLE_KEY_IMG_URL");
              str3 = paramIntent.getStringExtra("BUNDLE_KEY_SRC");
              String str4 = paramIntent.getStringExtra("BUNDLE_KEY_AUDIO_URL");
              paramIntent = paramIntent.getStringExtra("BUNDLE_KEY_ICON_URL");
              MusicGeneQQBrowserActivity.a(this.a, str2, str3, str4, str1, paramContext, paramIntent, 1101244924L);
              return;
            }
          } while (!"BROAD_CAST_UPDATE_TITLE".equals(paramContext));
          paramContext = paramIntent.getStringExtra("BUNDLE_KEY_URL");
        } while (paramContext == null);
        if (!paramContext.contains("http://y.qq.com/m/gene/play.html")) {
          break;
        }
      } while (!MusicGeneQQBrowserActivity.a(this.a));
      return;
    } while (!MusicGeneQQBrowserActivity.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gcy
 * JD-Core Version:    0.7.0.1
 */