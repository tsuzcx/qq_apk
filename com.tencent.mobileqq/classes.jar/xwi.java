import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.SubtitleDataManagerListener;
import java.lang.ref.WeakReference;

public class xwi
  implements Runnable
{
  public xwi(SubtitleDataManager paramSubtitleDataManager) {}
  
  public void run()
  {
    if (this.a.a != null) {
      ((SubtitleDataManager.SubtitleDataManagerListener)this.a.a.get()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xwi
 * JD-Core Version:    0.7.0.1
 */