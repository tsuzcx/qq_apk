import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.richmedia.capture.data.SubtitleItem;
import java.util.Comparator;

public class ycv
  implements Comparator
{
  public ycv(SubtitleDataManager paramSubtitleDataManager) {}
  
  public int a(SubtitleItem paramSubtitleItem1, SubtitleItem paramSubtitleItem2)
  {
    if ((paramSubtitleItem1 != null) && (paramSubtitleItem2 != null)) {
      return paramSubtitleItem1.b - paramSubtitleItem2.b;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycv
 * JD-Core Version:    0.7.0.1
 */