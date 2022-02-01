import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public class arir
  implements Handler.Callback, ariq
{
  arir.a a = null;
  boolean agj;
  boolean dbx = false;
  Handler mHandler = null;
  int mScrollState = 0;
  int mTouchSlop = 10;
  WeakReference<View> mViewRef;
  
  public arir(arir.a parama, Context paramContext)
  {
    this.a = parama;
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public void P(View paramView, int paramInt)
  {
    iF(paramView);
    this.agj = true;
    this.mHandler.removeMessages(0);
    reportScrollStateChange(2);
  }
  
  public void d(View paramView, float paramFloat1, float paramFloat2)
  {
    iF(paramView);
    this.dbx = false;
    this.mHandler.sendEmptyMessageDelayed(0, 100L);
  }
  
  public void e(View paramView, float paramFloat1, float paramFloat2)
  {
    iF(paramView);
    this.dbx = true;
    this.agj = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      this.mHandler.removeMessages(0);
      this.agj = false;
      reportScrollStateChange(0);
    }
    return true;
  }
  
  void iF(View paramView)
  {
    if (this.mViewRef == null) {}
    for (View localView = null;; localView = (View)this.mViewRef.get())
    {
      if (localView != paramView) {
        this.mViewRef = new WeakReference(paramView);
      }
      return;
    }
  }
  
  public void k(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    iF(paramView);
    paramInt3 = Math.abs(paramInt2 - paramInt4);
    if ((paramInt3 == 0) || (paramInt2 == 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      this.mHandler.removeMessages(0);
      if ((paramInt1 == 0) || (this.dbx)) {
        break;
      }
      this.agj = false;
      reportScrollStateChange(0);
      return;
    }
    if (this.agj)
    {
      if (paramInt3 <= this.mTouchSlop) {
        this.mHandler.sendEmptyMessageDelayed(0, 50L);
      }
      reportScrollStateChange(2);
      return;
    }
    if ((!this.dbx) && (paramInt3 <= this.mTouchSlop)) {
      this.mHandler.sendEmptyMessageDelayed(0, 50L);
    }
    reportScrollStateChange(1);
  }
  
  void reportScrollStateChange(int paramInt)
  {
    int i;
    if (paramInt != this.mScrollState)
    {
      i = this.mScrollState;
      this.mScrollState = paramInt;
      if (this.a != null) {
        if (this.mViewRef != null) {
          break label47;
        }
      }
    }
    label47:
    for (View localView = null;; localView = (View)this.mViewRef.get())
    {
      this.a.y(localView, i, paramInt);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void y(View paramView, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arir
 * JD-Core Version:    0.7.0.1
 */