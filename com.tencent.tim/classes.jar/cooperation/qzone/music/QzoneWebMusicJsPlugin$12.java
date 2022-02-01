package cooperation.qzone.music;

import aiow;
import avzf;
import avzh;
import org.json.JSONObject;

class QzoneWebMusicJsPlugin$12
  implements Runnable
{
  QzoneWebMusicJsPlugin$12(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    avzf.a().a().resumePlay();
    aiow.a(new JSONObject(), "showFloatView", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */