import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;

public class arja
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public arja(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  @SuppressLint({"NewApi"})
  public void onGlobalLayout()
  {
    int m;
    int j;
    int k;
    if (Build.VERSION.SDK_INT < 16)
    {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      m = this.a.getWidth();
      j = 0;
      k = 0;
      label32:
      if (j >= SimpleSlidingIndicator.a(this.a)) {
        break label122;
      }
      localObject = SimpleSlidingIndicator.a(this.a).getChildAt(j);
      i = k;
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        if (j >= 5) {
          break label109;
        }
      }
    }
    label109:
    for (int i = k + ((TextView)localObject).getWidth();; i = k + ((TextView)localObject).getWidth() / 2)
    {
      j += 1;
      k = i;
      break label32;
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      break;
    }
    label122:
    i = (m - k) / 11;
    if (i > 0)
    {
      SimpleSlidingIndicator.b(this.a, i);
      i = 0;
      while (i < SimpleSlidingIndicator.a(this.a))
      {
        localObject = SimpleSlidingIndicator.a(this.a).getChildAt(i);
        if ((localObject instanceof TextView)) {
          ((TextView)localObject).setPadding(SimpleSlidingIndicator.b(this.a), 0, SimpleSlidingIndicator.b(this.a), 0);
        }
        i += 1;
      }
    }
    SimpleSlidingIndicator.a(this.a, SimpleSlidingIndicator.c(this.a));
    SimpleSlidingIndicator.b(this.a, SimpleSlidingIndicator.c(this.a));
    Object localObject = SimpleSlidingIndicator.a(this.a).getChildAt(SimpleSlidingIndicator.c(this.a));
    SimpleSlidingIndicator.a(this.a, ((View)localObject).getLeft());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arja
 * JD-Core Version:    0.7.0.1
 */