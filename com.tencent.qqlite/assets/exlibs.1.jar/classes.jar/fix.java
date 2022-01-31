import com.tencent.widget.TipsPopupWindow;

public class fix
  implements Runnable
{
  public fix(TipsPopupWindow paramTipsPopupWindow) {}
  
  public void run()
  {
    TipsPopupWindow.a(this.a);
    TipsPopupWindow.a(this.a, false);
    TipsPopupWindow.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fix
 * JD-Core Version:    0.7.0.1
 */