package cooperation.comic.utils;

import aveb.b;
import avec;
import avfw;

public final class QQComicPluginBridge$1
  implements Runnable
{
  public QQComicPluginBridge$1(avfw paramavfw, aveb.b paramb) {}
  
  public void run()
  {
    this.val$pluginManager.installPlugin("comic_plugin.apk", new avec(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.utils.QQComicPluginBridge.1
 * JD-Core Version:    0.7.0.1
 */