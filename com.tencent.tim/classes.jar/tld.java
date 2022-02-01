import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class tld
  implements Handler.Callback
{
  private static tld a = new tld();
  private ConcurrentHashMap<String, WeakReference<View>> cH = new ConcurrentHashMap();
  private Handler mHandler;
  
  private tld()
  {
    HandlerThread localHandlerThread = new HandlerThread("GdtImpressionPolicy");
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private boolean K(View paramView)
  {
    Object localObject = this.cH.values();
    if (localObject != null)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((paramView != null) && (localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private GdtAd a(View paramView)
  {
    if (paramView == null) {
      paramView = null;
    }
    GdtAd localGdtAd;
    do
    {
      return paramView;
      paramView = paramView.getTag(2131381958);
      if (paramView == null) {
        return null;
      }
      if (!(paramView instanceof GdtAd)) {
        return null;
      }
      localGdtAd = (GdtAd)paramView;
      if (TextUtils.isEmpty(localGdtAd.getTraceId())) {
        return null;
      }
      paramView = localGdtAd;
    } while (!TextUtils.isEmpty(localGdtAd.getUrlForImpression()));
    return null;
  }
  
  public static tld a()
  {
    try
    {
      tld localtld = a;
      return localtld;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, int paramInt)
  {
    int i = 0;
    paramSharedPreferences = paramSharedPreferences.getAll();
    if (paramSharedPreferences != null)
    {
      Object localObject = paramSharedPreferences.keySet();
      if (((Set)localObject).size() - paramInt > 0)
      {
        int k = Math.abs((int)(((Set)localObject).size() - paramInt * 0.5F));
        paramSharedPreferences = new String[k];
        localObject = ((Set)localObject).iterator();
        int j;
        for (paramInt = 0;; paramInt = j) {
          if (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            j = paramInt + 1;
            paramSharedPreferences[paramInt] = str;
            if (j < k) {}
          }
          else
          {
            j = paramSharedPreferences.length;
            paramInt = i;
            while (paramInt < j)
            {
              paramEditor.remove(paramSharedPreferences[paramInt]);
              paramInt += 1;
            }
          }
        }
      }
    }
  }
  
  private void a(View paramView, GdtAd paramGdtAd)
  {
    Object localObject = this.cH.keySet();
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        WeakReference localWeakReference = (WeakReference)this.cH.get(str);
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (paramView == localWeakReference.get())) {
          if ((paramGdtAd.getTraceId() != null) && (!paramGdtAd.getTraceId().equals(str))) {
            uv(str);
          }
        }
      }
    }
  }
  
  private void aK(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("GdtImpressionPolicyReported", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    a(localSharedPreferences, localEditor, 8192);
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.apply();
  }
  
  private void b(String paramString, WeakReference<View> paramWeakReference)
  {
    this.cH.put(paramString, paramWeakReference);
  }
  
  private boolean gH(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("GdtImpressionPolicyReported", 0).getBoolean(paramString, false);
  }
  
  public static boolean isVisibleAreaSatisfied(View paramView)
  {
    return tls.getPercentageOfGlobalVisibleRect(paramView) > 0.5D;
  }
  
  private void uv(String paramString)
  {
    this.cH.remove(paramString);
  }
  
  public void bDG()
  {
    this.cH.clear();
  }
  
  public void g(View paramView)
  {
    tkw.d("GdtImpressionPolicy", "report view: " + paramView.hashCode());
    GdtAd localGdtAd = a(paramView);
    if (localGdtAd == null)
    {
      tkw.d("GdtImpressionPolicy", "break: statistics == null");
      return;
    }
    if (localGdtAd.reportState == 2)
    {
      tkw.d("GdtImpressionPolicy", "break: already report " + localGdtAd.getTraceId());
      return;
    }
    if (!isVisibleAreaSatisfied(paramView))
    {
      tkw.d("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not");
      return;
    }
    a(paramView, localGdtAd);
    Message localMessage = this.mHandler.obtainMessage();
    WeakReference localWeakReference = new WeakReference(paramView);
    localMessage.obj = localWeakReference;
    if (!K(paramView))
    {
      tkw.d("GdtImpressionPolicy", "inCountingMap not " + localGdtAd.getTraceId());
      b(localGdtAd.getTraceId(), localWeakReference);
    }
    localGdtAd.reportState = 1;
    this.mHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    tkw.d("GdtImpressionPolicy", "handleMessage : ");
    if ((paramMessage == null) || (paramMessage.obj == null)) {}
    GdtAd localGdtAd;
    Object localObject;
    for (;;)
    {
      return false;
      paramMessage = (WeakReference)paramMessage.obj;
      if (paramMessage.get() != null)
      {
        paramMessage = (View)paramMessage.get();
        localGdtAd = a(paramMessage);
        if (localGdtAd == null)
        {
          tkw.d("GdtImpressionPolicy", "break: statistics == null");
        }
        else if (localGdtAd.reportState != 1)
        {
          tkw.d("GdtImpressionPolicy", "break: statistics.reportState != 1 " + localGdtAd.getTraceId());
        }
        else if (!isVisibleAreaSatisfied(paramMessage))
        {
          tkw.d("GdtImpressionPolicy", "break: isVisibleAreaSatisfied not " + localGdtAd.getTraceId());
          localGdtAd.reportState = -1;
        }
        else if (!K(paramMessage))
        {
          tkw.d("GdtImpressionPolicy", "break: inCountingMap not " + localGdtAd.getTraceId());
        }
        else
        {
          localObject = paramMessage.getTag(2131381957);
          if (localObject == null)
          {
            tkw.d("GdtImpressionPolicy", "break: o2 == null " + localGdtAd.getTraceId());
          }
          else if (!(localObject instanceof tld.a))
          {
            tkw.d("GdtImpressionPolicy", "break: o2 instanceof ReportListener not " + localGdtAd.getTraceId());
          }
          else
          {
            if (!gH(localGdtAd.getTraceId())) {
              break;
            }
            tkw.d("GdtImpressionPolicy", "break: already reported " + localGdtAd.getTraceId());
          }
        }
      }
    }
    ((tld.a)localObject).reportImpression(paramMessage);
    localGdtAd.reportState = 2;
    aK(localGdtAd.getTraceId(), true);
    tkw.d("GdtImpressionPolicy", "report " + localGdtAd.getTraceId());
    uv(localGdtAd.getTraceId());
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void reportImpression(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tld
 * JD-Core Version:    0.7.0.1
 */