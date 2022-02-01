package cooperation.qzone.music;

import aiow;
import avzf;
import avzh;
import org.json.JSONObject;

class QzoneWebMusicJsPlugin$6
  implements Runnable
{
  QzoneWebMusicJsPlugin$6(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    avzf.a().a().stopPlay();
    aiow.a(new JSONObject(), "stopMusicBox", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */