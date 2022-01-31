import com.tencent.widget.TipsPopupWindow;

public class ibr
  implements Runnable
{
  public ibr(TipsPopupWindow paramTipsPopupWindow) {}
  
  public void run()
  {
    TipsPopupWindow.a(this.a);
    TipsPopupWindow.a(this.a, false);
    TipsPopupWindow.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ibr
 * JD-Core Version:    0.7.0.1
 */