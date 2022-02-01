import android.os.Handler;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;

public class aiws
{
  private static final aixa<Handler, Void> a = new aiwt();
  private static aixa<TimerTaskManager, Void> b = new aiwu();
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.get(null);
  }
  
  public static Handler w()
  {
    return (Handler)a.get(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiws
 * JD-Core Version:    0.7.0.1
 */