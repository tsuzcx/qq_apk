import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class sea
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final View activityRootView;
  private int bwv;
  private boolean isSoftKeyboardOpened;
  private int lastSoftKeyboardHeightInPx;
  private final List<sea.a> listeners = new LinkedList();
  
  public sea(View paramView)
  {
    this(paramView, false);
  }
  
  public sea(View paramView, boolean paramBoolean)
  {
    this.activityRootView = paramView;
    this.isSoftKeyboardOpened = paramBoolean;
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void notifyOnSoftKeyboardClosed()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      sea.a locala = (sea.a)localIterator.next();
      if (locala != null) {
        locala.onSoftKeyboardClosed();
      }
    }
  }
  
  private void notifyOnSoftKeyboardOpened(int paramInt)
  {
    this.lastSoftKeyboardHeightInPx = paramInt;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      sea.a locala = (sea.a)localIterator.next();
      if (locala != null) {
        locala.onSoftKeyboardOpened(paramInt);
      }
    }
  }
  
  public void a(sea.a parama)
  {
    this.listeners.add(parama);
  }
  
  public void bya()
  {
    this.listeners.clear();
    if (Build.VERSION.SDK_INT < 16)
    {
      this.activityRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
    }
    this.activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.activityRootView.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    if (this.bwv == 0) {
      this.bwv = i;
    }
    do
    {
      return;
      i = this.bwv - i;
      if ((!this.isSoftKeyboardOpened) && (i >= 250))
      {
        this.isSoftKeyboardOpened = true;
        notifyOnSoftKeyboardOpened(i);
        return;
      }
    } while ((!this.isSoftKeyboardOpened) || (i >= 100));
    this.isSoftKeyboardOpened = false;
    notifyOnSoftKeyboardClosed();
  }
  
  public static abstract interface a
  {
    public abstract void onSoftKeyboardClosed();
    
    public abstract void onSoftKeyboardOpened(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sea
 * JD-Core Version:    0.7.0.1
 */