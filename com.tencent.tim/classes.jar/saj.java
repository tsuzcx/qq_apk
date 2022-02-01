import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;

public abstract class saj<T>
  implements Handler.Callback
{
  protected Context mContext;
  protected Handler mMainHandler = new Handler(Looper.getMainLooper(), this);
  protected View mParentView;
  protected int mPosition = -1;
  protected int mViewType = -1;
  
  public saj(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    if (paramBoolean) {
      initUI();
    }
  }
  
  public abstract void Hp();
  
  protected Context getContext()
  {
    return this.mContext;
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
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    onUpdateUI();
    return true;
  }
  
  protected abstract void initUI();
  
  protected abstract void onRecycle();
  
  protected abstract void onUpdateUI();
  
  public void recycle()
  {
    onRecycle();
    setPosition(-1);
  }
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.mMainHandler.post(paramRunnable);
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public final void updateUI()
  {
    this.mMainHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     saj
 * JD-Core Version:    0.7.0.1
 */