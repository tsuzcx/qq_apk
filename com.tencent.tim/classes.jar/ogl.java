import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.UiThread;
import android.view.View;

public abstract class ogl<T>
  implements Handler.Callback
{
  protected Context mContext;
  protected T mData;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper(), this);
  protected View mParentView;
  protected int mPosition = -1;
  protected int mViewType = -1;
  
  public ogl(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void updateUI()
  {
    this.mMainHandler.sendEmptyMessage(1);
  }
  
  protected abstract void Hp();
  
  protected Context getContext()
  {
    return this.mContext;
  }
  
  public T getData()
  {
    return this.mData;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  protected Resources getResources()
  {
    if (this.mContext != null) {
      return this.mContext.getResources();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      onUpdateUI();
      return true;
    }
    return false;
  }
  
  protected abstract void onRecycle();
  
  @UiThread
  protected abstract void onUpdateUI();
  
  public void recycle()
  {
    onRecycle();
    setPosition(-1);
  }
  
  public void setData(T paramT)
  {
    this.mData = paramT;
    Hp();
    updateUI();
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogl
 * JD-Core Version:    0.7.0.1
 */