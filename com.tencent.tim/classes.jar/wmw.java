import android.os.SystemClock;
import android.text.Layout;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.qphone.base.util.QLog;

public class wmw
{
  private wmw.a a;
  private aawe mSelectDelegate;
  
  public wmw(@NonNull wmw.a parama, @NonNull aawe paramaawe)
  {
    this.a = parama;
    this.mSelectDelegate = paramaawe;
  }
  
  public static MotionEvent a(int paramInt, float paramFloat1, float paramFloat2)
  {
    return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), paramInt, paramFloat1, paramFloat2, 0);
  }
  
  private int vQ()
  {
    Object localObject = aavp.a().bK();
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "getOneCharWidth");
      }
      return (int)Layout.getDesiredWidth("大", ((TextView)localObject).getPaint());
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, "getOneCharWidth default");
    }
    return BaseChatItemLayout.bNP * 3;
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = this.mSelectDelegate.touchIndex((int)paramFloat1, (int)paramFloat2);
    this.mSelectDelegate.Di(false);
    Object localObject = a(0, this.a.eX(paramInt1), this.a.eY(paramInt1));
    ((MotionEvent)localObject).setSource(-1);
    this.a.onTouchEvent((MotionEvent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatItemLayout", 2, new Object[] { "touchIndex=", Integer.valueOf(i), " cursorType=", Integer.valueOf(paramInt1) });
    }
    if (i == -1)
    {
      localObject = a(3, paramFloat1, paramFloat2);
      ((MotionEvent)localObject).setSource(-1);
      this.a.onTouchEvent((MotionEvent)localObject);
      this.mSelectDelegate.Di(true);
      return i;
    }
    if (paramInt1 == 1) {
      localObject = aofy.b(this.mSelectDelegate.qK(), i, paramInt2, true);
    }
    while (((String)localObject).length() < paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, new Object[] { "cutString is small than request cutString=", localObject });
      }
      localObject = a(3, paramFloat1, paramFloat2);
      ((MotionEvent)localObject).setSource(-1);
      this.a.onTouchEvent((MotionEvent)localObject);
      this.mSelectDelegate.Di(true);
      if (paramInt1 == 1)
      {
        return a(vQ() + paramFloat1, paramFloat2, 2, paramInt2);
        localObject = aofy.j(this.mSelectDelegate.qK(), i, paramInt2);
      }
      else
      {
        return -1;
      }
    }
    this.a.ap(i, ((String)localObject).length(), paramInt1);
    localObject = a(2, paramFloat1, paramFloat2);
    ((MotionEvent)localObject).setSource(-1);
    this.a.onTouchEvent((MotionEvent)localObject);
    localObject = a(1, paramFloat1, paramFloat2);
    ((MotionEvent)localObject).setSource(-1);
    this.a.onTouchEvent((MotionEvent)localObject);
    this.mSelectDelegate.Di(true);
    return i;
  }
  
  public static abstract interface a
  {
    public abstract void ap(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract int eX(int paramInt);
    
    public abstract int eY(int paramInt);
    
    public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wmw
 * JD-Core Version:    0.7.0.1
 */