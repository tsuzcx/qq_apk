package com.tencent.qqmini.miniapp.core.page;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Iterator;
import java.util.List;

class AppBrandPageContainer$1
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  AppBrandPageContainer$1(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void onSoftKeyboardClosed()
  {
    QMLog.e("minisdk-start-AppBrandPageContainer", "onSoftKeyboardClosed ");
    if ((AppBrandPageContainer.access$100(this.this$0) != null) && (AppBrandPageContainer.access$100(this.this$0).size() > 0))
    {
      Iterator localIterator = AppBrandPageContainer.access$100(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)localIterator.next();
        if (localSoftKeyboardStateListener != null) {
          localSoftKeyboardStateListener.onSoftKeyboardClosed();
        }
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AppBrandPageContainer.1.2(this), 50L);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    QMLog.e("minisdk-start-AppBrandPageContainer", "onSoftKeyboardOpened " + paramInt);
    if (AppBrandPageContainer.access$000(this.this$0) != null) {}
    int i;
    for (Object localObject = AppBrandPageContainer.access$000(this.this$0).getAttachedActivity();; localObject = null)
    {
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (DisplayUtil.hasNavBar((Context)localObject))
        {
          i = paramInt;
          if (DisplayUtil.isNavigationBarExist((Activity)localObject)) {
            i = paramInt - DisplayUtil.getNavigationBarHeight((Context)localObject);
          }
        }
      }
      if ((AppBrandPageContainer.access$100(this.this$0) == null) || (AppBrandPageContainer.access$100(this.this$0).size() <= 0)) {
        break;
      }
      localObject = AppBrandPageContainer.access$100(this.this$0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SoftKeyboardStateHelper.SoftKeyboardStateListener localSoftKeyboardStateListener = (SoftKeyboardStateHelper.SoftKeyboardStateListener)((Iterator)localObject).next();
        if (localSoftKeyboardStateListener != null) {
          localSoftKeyboardStateListener.onSoftKeyboardOpened(i);
        }
      }
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AppBrandPageContainer.1.1(this, i), 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.1
 * JD-Core Version:    0.7.0.1
 */