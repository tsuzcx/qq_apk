import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class awug
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int eCW;
  
  awug(awtq paramawtq) {}
  
  public void onGlobalLayout()
  {
    int i = this.eCW + 1;
    this.eCW = i;
    ViewTreeObserver localViewTreeObserver;
    if (i > 1)
    {
      localViewTreeObserver = awtq.a(this.this$0).getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label105;
        }
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    for (;;)
    {
      axix.c(new aasq(awtq.a(this.this$0).getMeasuredWidth(), awtq.a(this.this$0).getMeasuredHeight()));
      axiy.i("AEPituCameraUnit", "mMaxPreviewSize set: " + axix.a());
      return;
      label105:
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awug
 * JD-Core Version:    0.7.0.1
 */