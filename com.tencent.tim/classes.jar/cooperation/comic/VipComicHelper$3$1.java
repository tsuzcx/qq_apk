package cooperation.comic;

import avcx;
import com.tencent.webbundle.sdk.WebBundleManager;

public class VipComicHelper$3$1
  implements Runnable
{
  public VipComicHelper$3$1(avcx paramavcx) {}
  
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicHelper.3.1
 * JD-Core Version:    0.7.0.1
 */