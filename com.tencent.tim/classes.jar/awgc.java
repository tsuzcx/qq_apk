import android.os.Bundle;
import android.os.Handler;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1;

public class awgc
  implements avzi
{
  awgc(awga paramawga, String[] paramArrayOfString) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      bool = paramString.getBoolean("isOpenVip");
      if ((this.val$args != null) && (this.val$args.length > 0))
      {
        if (!bool) {
          break label64;
        }
        awga.a(this.this$0).post(new QzoneQunFeedJsPlugin.2.1(this));
      }
    }
    return;
    label64:
    paramString.getInt("totalNum");
    int i = paramString.getInt("successNum");
    int j = paramString.getInt("failNum");
    boolean bool = paramString.getBoolean("isDownloadCanceled");
    paramString = paramString.getString("path");
    awga.a(this.this$0, i, j, paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgc
 * JD-Core Version:    0.7.0.1
 */