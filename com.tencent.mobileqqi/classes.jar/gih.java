import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloader;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class gih
  extends TimerTask
{
  public gih(PicPreDownloader paramPicPreDownloader) {}
  
  public void run()
  {
    if (!this.a.a.get())
    {
      this.a.a.set(true);
      Logger.b("PIC_TAG_PRELOAD", "timer count off,picPreDownload set on", "mIsPicPreloadSuitable" + this.a.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gih
 * JD-Core Version:    0.7.0.1
 */