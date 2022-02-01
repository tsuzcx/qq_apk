package com.tencent.biz.pubaccount.ecshopassit.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class EcshopWebview
  extends TouchWebView
{
  private static EcshopWebview c;
  public static int sPoolSize;
  private static final Object sPoolSync = new Object();
  private int aIq;
  private EcshopWebview b;
  public int flag = 0;
  
  public EcshopWebview(Context paramContext)
  {
    super(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("parasons333", 2, "---EcshopWebview---");
    }
  }
  
  public static EcshopWebview a(Context paramContext)
  {
    EcshopWebview localEcshopWebview = null;
    synchronized (sPoolSync)
    {
      QLog.i("EcshopWebview", 1, "sPool acquire:" + c);
      if (c != null)
      {
        localEcshopWebview = c;
        c = localEcshopWebview.b;
        localEcshopWebview.b = null;
        sPoolSize -= 1;
      }
      if (localEcshopWebview == null) {
        return new EcshopWebview(new MutableContextWrapper(paramContext));
      }
    }
    localEcshopWebview.clearHistory();
    localEcshopWebview.flag = 1;
    localEcshopWebview.aIq += 1;
    localEcshopWebview.onResume();
    ((MutableContextWrapper)localEcshopWebview.getContext()).setBaseContext(paramContext);
    return localEcshopWebview;
  }
  
  public boolean canGoBack()
  {
    if (1 == this.flag)
    {
      Object localObject = copyBackForwardList();
      if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
      {
        localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
        if ((localObject != null) && ("about:blank".equals(((WebHistoryItem)localObject).getUrl()))) {
          return super.canGoBackOrForward(-2);
        }
      }
      return super.canGoBack();
    }
    return super.canGoBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview
 * JD-Core Version:    0.7.0.1
 */