package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class ProviderView
  extends FrameLayout
{
  protected a a;
  protected boolean cBk = true;
  protected int dzM;
  protected AppInterface mApp;
  protected int mContentHeight = 206;
  Context mContext;
  protected Handler mThreadHandler;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mThreadHandler = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.cBk = paramBoolean;
  }
  
  public void setProviderViewListener(a parama)
  {
    this.a = parama;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.dzM = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */