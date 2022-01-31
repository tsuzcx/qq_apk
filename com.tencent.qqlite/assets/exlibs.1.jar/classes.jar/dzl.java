import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloader;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class dzl
  extends TimerTask
{
  public dzl(PicPreDownloader paramPicPreDownloader) {}
  
  public void run()
  {
    if (!PicPreDownloader.a(this.a).get())
    {
      PicPreDownloader.a(this.a).set(true);
      Logger.b("PIC_TAG_PRELOAD", "timer count off,picPreDownload set on", "mIsPicPreloadSuitable" + PicPreDownloader.a(this.a).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dzl
 * JD-Core Version:    0.7.0.1
 */