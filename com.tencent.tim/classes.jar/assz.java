import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

public class assz
  implements avzi
{
  assz(assx paramassx, String paramString) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      if (paramString.getBoolean("isOpenVip")) {
        assx.a(this.a).post(new TroopAlbumPlugin.2.1(this));
      }
    }
    else
    {
      return;
    }
    paramString.getInt("totalNum");
    int i = paramString.getInt("successNum");
    int j = paramString.getInt("failNum");
    boolean bool = paramString.getBoolean("isDownloadCanceled");
    paramString = paramString.getString("path");
    assx.a(this.a, assx.h(this.a).getAttachedActivity(), i, j, paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     assz
 * JD-Core Version:    0.7.0.1
 */