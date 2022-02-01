import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.views.image.GdtDrawableLoader.2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class tmi
{
  private WeakReference<tmi.a> listener;
  private boolean notified;
  private URLDrawable p;
  private int retryTimes;
  private URL url;
  
  public tmi(String paramString, WeakReference<tmi.a> paramWeakReference)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.url = new URL(paramString);
        this.listener = paramWeakReference;
      }
      return;
    }
    catch (MalformedURLException paramWeakReference)
    {
      tkw.e("GdtDrawableLoader", "GdtDrawableLoader error " + paramString, paramWeakReference);
    }
  }
  
  private URLDrawable.URLDrawableListener a()
  {
    return new tmj(this);
  }
  
  private String getUrl()
  {
    if ((this.p != null) && (this.p.getURL() != null)) {
      return this.p.getURL().toString();
    }
    if (isValid()) {
      return this.url.toString();
    }
    return null;
  }
  
  private boolean isValid()
  {
    return this.url != null;
  }
  
  private boolean retry()
  {
    if ((!isValid()) || (this.p == null) || (this.retryTimes >= 3)) {
      return false;
    }
    tkw.i("GdtDrawableLoader", "retry " + getUrl());
    this.retryTimes += 1;
    this.p.restartDownload();
    return true;
  }
  
  private void update()
  {
    int j = 1;
    if ((!isValid()) || (this.p == null)) {
      tkw.i("GdtDrawableLoader", "update error " + getUrl());
    }
    for (;;)
    {
      return;
      int i;
      if (this.p.getStatus() == 0)
      {
        tkw.i("GdtDrawableLoader", "drawable status is loading " + getUrl());
        i = j;
        if (!this.p.isDownloadStarted())
        {
          this.p.startDownload(true);
          i = j;
        }
      }
      while ((i != 0) && (!this.notified))
      {
        new Handler(Looper.getMainLooper()).postDelayed(new GdtDrawableLoader.2(this), 100L);
        return;
        if (this.p.getStatus() == 4)
        {
          tkw.i("GdtDrawableLoader", "drawable status is file downloaded " + getUrl());
          i = j;
        }
        else if (this.p.getStatus() == 1)
        {
          tkw.i("GdtDrawableLoader", "drawable status is successed " + getUrl());
          vw(true);
          i = 0;
        }
        else if (this.p.getStatus() == 2)
        {
          tkw.e("GdtDrawableLoader", "drawable status is failed " + getUrl());
          i = j;
          if (!retry())
          {
            vw(false);
            i = 0;
          }
        }
        else if (this.p.getStatus() == 3)
        {
          tkw.e("GdtDrawableLoader", "drawable status is cancled " + getUrl());
          vw(false);
          i = 0;
        }
        else
        {
          tkw.e("GdtDrawableLoader", "drawable status is " + this.p.getStatus() + " " + getUrl());
          i = 0;
        }
      }
    }
  }
  
  private void vw(boolean paramBoolean)
  {
    if ((this.notified) || (this.listener == null) || (this.listener.get() == null)) {
      return;
    }
    tkw.i("GdtDrawableLoader", "notify " + paramBoolean + " " + getUrl());
    this.notified = true;
    if (paramBoolean)
    {
      ((tmi.a)this.listener.get()).e(this.p);
      return;
    }
    ((tmi.a)this.listener.get()).f(this.p);
  }
  
  public URLDrawable a()
  {
    return this.p;
  }
  
  public void load()
  {
    if (!isValid())
    {
      tkw.e("GdtDrawableLoader", "load error");
      return;
    }
    tkw.i("GdtDrawableLoader", "load " + getUrl());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mUseMemoryCache = true;
    this.p = URLDrawable.getDrawable(this.url, localURLDrawableOptions);
    if (this.p == null)
    {
      tkw.e("GdtDrawableLoader", "load error " + getUrl());
      return;
    }
    this.p.setURLDrawableListener(a());
    update();
  }
  
  public static abstract interface a
  {
    public abstract void e(URLDrawable paramURLDrawable);
    
    public abstract void f(URLDrawable paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmi
 * JD-Core Version:    0.7.0.1
 */