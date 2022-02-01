import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class amxm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int KEY_BOARD_HIGH_DIFF = 200;
  private final View activityRootView;
  private boolean isSoftKeyboardOpened;
  private int lastSoftKeyboardHeightInPx;
  private final List<amxm.a> listeners = new LinkedList();
  
  public amxm(View paramView)
  {
    this(paramView, false);
  }
  
  public amxm(View paramView, boolean paramBoolean)
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
      amxm.a locala = (amxm.a)localIterator.next();
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
      amxm.a locala = (amxm.a)localIterator.next();
      if (locala != null) {
        locala.onSoftKeyboardOpened(paramInt);
      }
    }
  }
  
  public void a(amxm.a parama)
  {
    this.listeners.add(parama);
  }
  
  public void b(amxm.a parama)
  {
    this.listeners.remove(parama);
  }
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.activityRootView.getWindowVisibleDisplayFrame(localRect);
    int i = this.activityRootView.getRootView().getHeight() - (localRect.bottom - localRect.top) - ImmersiveUtils.getStatusBarHeight(this.activityRootView.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("SoftKeyboardStateHelper", 2, "onGlobalLayout , activityRootView.Height = " + this.activityRootView.getRootView().getHeight() + " heightDiff = " + i + " (r.bottom - r.top) = " + (localRect.bottom - localRect.top));
    }
    if ((!this.isSoftKeyboardOpened) && (i > this.KEY_BOARD_HIGH_DIFF))
    {
      this.isSoftKeyboardOpened = true;
      notifyOnSoftKeyboardOpened(i);
    }
    while ((!this.isSoftKeyboardOpened) || (i >= this.KEY_BOARD_HIGH_DIFF)) {
      return;
    }
    this.isSoftKeyboardOpened = false;
    notifyOnSoftKeyboardClosed();
  }
  
  public static abstract interface a
  {
    public abstract void onSoftKeyboardClosed();
    
    public abstract void onSoftKeyboardOpened(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amxm
 * JD-Core Version:    0.7.0.1
 */