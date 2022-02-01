package cooperation.qzone.music;

import aiow;
import avzf;
import avzh;
import org.json.JSONObject;

class QzoneWebMusicJsPlugin$14
  implements Runnable
{
  QzoneWebMusicJsPlugin$14(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    avzf.a().a().stopPlay();
    aiow.a(new JSONObject(), "pauseFloatView", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */