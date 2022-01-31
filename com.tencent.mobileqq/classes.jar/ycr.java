import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.SubtitleDataManagerListener;
import java.lang.ref.WeakReference;

public class ycr
  implements Runnable
{
  public ycr(SubtitleDataManager paramSubtitleDataManager) {}
  
  public void run()
  {
    if (this.a.a != null) {
      ((SubtitleDataManager.SubtitleDataManagerListener)this.a.a.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycr
 * JD-Core Version:    0.7.0.1
 */