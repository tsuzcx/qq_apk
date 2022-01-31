import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PlusPanel;

public class bta
  implements Runnable
{
  public bta(PlusPanel paramPlusPanel) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.a.getCount())
    {
      this.a.a.c(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bta
 * JD-Core Version:    0.7.0.1
 */