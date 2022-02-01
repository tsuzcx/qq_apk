import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsResourceLoader.1;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class mwl
{
  private static int aVA;
  private static LayoutInflateProcessor b;
  private static HashMap<Integer, Drawable> em;
  private Handler mHandler;
  
  public mwl(Context paramContext)
  {
    b = new LayoutInflateProcessor(paramContext.getApplicationContext());
    em = new HashMap();
    this.mHandler = new Handler();
    aVA += 1;
    cc(paramContext);
  }
  
  public static View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    View localView = null;
    if (b != null) {
      localView = b.a(paramInt, paramBoolean, paramLayoutParams);
    }
    while (!paramBoolean) {
      return localView;
    }
    localView = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(paramInt, null, false);
    localView.setLayoutParams(paramLayoutParams);
    return localView;
  }
  
  private LayoutInflateProcessor.a a()
  {
    return new LayoutInflateProcessor.a(2131560519, null, new mwm(this));
  }
  
  private LayoutInflateProcessor.a a(int paramInt)
  {
    return new LayoutInflateProcessor.a(2131560523, paramInt, null, new mwn(this));
  }
  
  public static LayoutInflateProcessor a()
  {
    return b;
  }
  
  private void cc(Context paramContext)
  {
    ThreadManager.excute(new VideoFeedsResourceLoader.1(this, new WeakReference(paramContext)), 16, null, true);
  }
  
  public static Drawable f(Context paramContext, int paramInt)
  {
    if (em == null) {}
    do
    {
      return null;
      if (em.containsKey(Integer.valueOf(paramInt))) {
        return (Drawable)em.get(Integer.valueOf(paramInt));
      }
      try
      {
        paramContext = paramContext.getResources().getDrawable(paramInt);
        em.put(Integer.valueOf(paramInt), paramContext);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("VideoFeedsResourceLoader", 2, "innerGetDrawableFromCache() OutOfMemoryError e=" + paramContext.getMessage());
    return null;
  }
  
  public void onDestroy()
  {
    if (b != null) {
      b.clearCache();
    }
    if (em != null) {
      em.clear();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    aVA -= 1;
    if (aVA <= 0)
    {
      b = null;
      em = null;
    }
  }
  
  public void sI(int paramInt)
  {
    if (paramInt == 0) {}
    for (LayoutInflateProcessor.a locala1 = new LayoutInflateProcessor.a(2131560546, null, null);; locala1 = null)
    {
      LayoutInflateProcessor.a locala2 = new LayoutInflateProcessor.a(2131560287, null, null);
      LayoutInflateProcessor.a locala3 = new LayoutInflateProcessor.a(2131560457, null, null);
      LayoutInflateProcessor.a locala4 = a(1);
      LayoutInflateProcessor.a locala5 = a();
      LayoutInflateProcessor.a locala6 = a(2);
      b.a(new LayoutInflateProcessor.a[] { locala1, locala2, locala3, locala4, locala5, locala6 });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwl
 * JD-Core Version:    0.7.0.1
 */