import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class aedv
  implements ViewTreeObserver.OnPreDrawListener
{
  public aedv(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public boolean onPreDraw()
  {
    this.this$0.getViewTreeObserver().removeOnPreDrawListener(this);
    ColorNoteSmallScreenRelativeLayout.a(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedv
 * JD-Core Version:    0.7.0.1
 */