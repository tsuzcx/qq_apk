import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.qphone.base.util.QLog;

public class cly
  extends TouchDelegate
{
  public cly(DragTextView paramDragTextView, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "DragTouchDelegate.onTouchEvent:" + paramMotionEvent.getAction() + ", " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY());
    }
    if (this.a.getVisibility() != 0) {
      return false;
    }
    if (DragTextView.a(this.a) == -1) {
      return false;
    }
    Object localObject = (ViewGroup)this.a.getParent();
    if (localObject == null) {
      return false;
    }
    Rect localRect = new Rect();
    ((ViewGroup)localObject).getGlobalVisibleRect(localRect);
    localObject = new Rect();
    this.a.getGlobalVisibleRect((Rect)localObject);
    if (DragTextView.a(this.a) == 2)
    {
      ((Rect)localObject).left = ((int)(((Rect)localObject).left - localRect.left - DragTextView.a(this.a) * 0.5D));
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - localRect.top - DragTextView.a(this.a) * 1.5D));
      ((Rect)localObject).right = ((int)(((Rect)localObject).right - localRect.left + DragTextView.a(this.a) * 1.5D));
    }
    for (((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom - localRect.top + DragTextView.a(this.a) * 0.5D)); ((Rect)localObject).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()); ((Rect)localObject).bottom = ((int)(((Rect)localObject).bottom - localRect.top + DragTextView.a(this.a))))
    {
      return this.a.onTouchEvent(paramMotionEvent);
      ((Rect)localObject).left = ((int)(((Rect)localObject).left - localRect.left - DragTextView.a(this.a)));
      ((Rect)localObject).top = ((int)(((Rect)localObject).top - localRect.top - DragTextView.a(this.a)));
      ((Rect)localObject).right = ((int)(((Rect)localObject).right - localRect.left + DragTextView.a(this.a)));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cly
 * JD-Core Version:    0.7.0.1
 */