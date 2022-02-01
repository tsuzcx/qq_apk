import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebviewPool.1;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class kev
{
  private static volatile kev a;
  private HashMap<String, EcshopWebview> dd = new HashMap();
  private byte[] lock = new byte[0];
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  public static kev a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new kev();
      }
      return a;
    }
    finally {}
  }
  
  private void ae(String paramString, boolean paramBoolean)
  {
    if ((!zd()) || (!paramBoolean)) {
      return;
    }
    this.mMainHandler.post(new EcshopWebviewPool.1(this, paramString));
  }
  
  private boolean zd()
  {
    if (BaseApplicationImpl.sProcessId == 7) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("parsons111", 2, "[checkToolProcess] isToolProcess: " + bool);
      return bool;
    }
  }
  
  public EcshopWebview a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        synchronized (this.lock)
        {
          if (QLog.isColorLevel()) {
            QLog.i("parsons111", 2, "【getWebView】= " + this.dd.size() + " preLoadUrl: " + paramString);
          }
          if (this.dd.size() > 0)
          {
            localObject = (EcshopWebview)this.dd.get(paramString);
            if (localObject != null)
            {
              paramString = (ViewGroup)((EcshopWebview)localObject).getParent();
              if (paramString != null) {
                paramString.removeView((View)localObject);
              }
              ((MutableContextWrapper)((EcshopWebview)localObject).getContext()).setBaseContext(paramContext);
              return localObject;
            }
          }
          else
          {
            EcshopWebview localEcshopWebview = EcshopWebview.a(paramContext);
            localObject = localEcshopWebview;
            if (aqmr.isEmpty(paramString)) {
              continue;
            }
            this.dd.put(paramString, localEcshopWebview);
            localObject = localEcshopWebview;
          }
        }
        Object localObject = EcshopWebview.a(paramContext);
      }
      catch (Throwable paramString)
      {
        QLog.e("parsons111", 1, QLog.getStackTraceString(paramString));
        return EcshopWebview.a(paramContext);
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    QLog.i("parsons111", 2, "ecshop recycleWebView  ");
    this.dd.clear();
    if (this.mMainHandler != null) {
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void ad(String paramString, boolean paramBoolean)
  {
    try
    {
      aqyc.Yb(-1);
      if (zd()) {
        ae(paramString, paramBoolean);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("parsons111", 1, paramString, new Object[0]);
    }
  }
  
  public boolean ds(String paramString)
  {
    return (!aqmr.isEmpty(paramString)) && (this.dd.containsKey(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kev
 * JD-Core Version:    0.7.0.1
 */