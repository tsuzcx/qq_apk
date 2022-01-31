import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import java.util.TimerTask;

public class ycy
  extends TimerTask
{
  public ycy(SubtitleLayout paramSubtitleLayout) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      if (SubtitleLayout.a(this.a) == -1L)
      {
        SubtitleLayout.c(this.a);
        return;
      }
      this.a.postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycy
 * JD-Core Version:    0.7.0.1
 */