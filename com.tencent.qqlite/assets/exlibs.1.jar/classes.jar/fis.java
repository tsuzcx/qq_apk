import com.tencent.widget.TipsPopupWindow;

public class fis
  implements Runnable
{
  public fis(TipsPopupWindow paramTipsPopupWindow) {}
  
  public void run()
  {
    TipsPopupWindow.a(this.a);
    TipsPopupWindow.a(this.a, false);
    TipsPopupWindow.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fis
 * JD-Core Version:    0.7.0.1
 */