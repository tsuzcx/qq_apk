import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class aedu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aedu(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.this$0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
    for (;;)
    {
      ColorNoteSmallScreenRelativeLayout.a(this.this$0);
      return;
      this.this$0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedu
 * JD-Core Version:    0.7.0.1
 */