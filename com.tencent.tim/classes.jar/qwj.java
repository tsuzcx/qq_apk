import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class qwj
  extends rru<qwj.a>
{
  private LruCache<qwj.a, Drawable> mCache = new qwk(this, 5242880);
  
  public rrv a(ImageView paramImageView, qwj.a parama)
  {
    return new qwj.b(paramImageView, parama);
  }
  
  public LruCache<qwj.a, Drawable> c()
  {
    return this.mCache;
  }
  
  public void clearCache()
  {
    super.clearCache();
    try
    {
      this.mCache.evictAll();
      return;
    }
    catch (Exception localException)
    {
      this.mCache = new qwl(this, 5242880);
    }
  }
  
  public void release()
  {
    super.release();
    clearCache();
  }
  
  public static class a
  {
    public qwi a;
    public Drawable dg;
    public int imageHeight;
    public int imageWidth;
    public String url;
    
    public boolean equals(Object paramObject)
    {
      return key().equals(((a)paramObject).key());
    }
    
    public int hashCode()
    {
      return key().hashCode();
    }
    
    public String key()
    {
      if (this.url == null) {
        return "?";
      }
      if (this.a == null) {
        return this.url;
      }
      return qwr.b(new Object[] { this.url, "/", this.a.key() });
    }
    
    public String toString()
    {
      return key();
    }
  }
  
  public static class b
    extends rrv
    implements URLDrawable.URLDrawableListener
  {
    private qwj.a a;
    private URLDrawable p;
    
    public b(ImageView paramImageView, qwj.a parama)
    {
      super();
      this.a = parama;
    }
    
    public void bri()
    {
      qwp.w("Q.qqstory.newImageLoader", new Object[] { "runOnBackGround url= ", this.a.url });
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      try
      {
        new URL(this.a.url);
        this.p = URLDrawable.getDrawable(this.a.url, localURLDrawableOptions);
        this.p.setURLDrawableListener(this);
        if (this.p.getStatus() == 1)
        {
          qwp.w("Q.qqstory.newImageLoader", new Object[] { "drawable have urlDrawable cache" });
          onLoadSuccessed(this.p);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        qwp.e("Q.qqstory.newImageLoader", new Object[] { localMalformedURLException.getMessage() });
        f(this.a.dg, "url is error:" + localMalformedURLException);
        return;
      }
      if ((this.p.getStatus() == 2) || (this.p.getStatus() == 3))
      {
        qwp.w("Q.qqstory.newImageLoader", new Object[] { "drawable restartDownload" });
        this.p.restartDownload();
        return;
      }
      qwp.w("Q.qqstory.newImageLoader", new Object[] { "drawable startDownload" });
      this.p.startDownload(true);
    }
    
    public String key()
    {
      return this.a.url;
    }
    
    public void onLoadCanceled(URLDrawable paramURLDrawable)
    {
      qwp.w("Q.qqstory.newImageLoader", new Object[] { "onLoadCanceled url= ", paramURLDrawable.getURL() });
      super.f(paramURLDrawable, "task have been cancel!");
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      qwp.w("Q.qqstory.newImageLoader", new Object[] { "onLoadFialed url= ", paramURLDrawable.getURL() });
      super.f(paramURLDrawable, paramThrowable.getMessage());
    }
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      qwp.w("Q.qqstory.newImageLoader", new Object[] { "onLoadSuccessed url= ", paramURLDrawable.getURL() });
      if (this.aJw)
      {
        super.L(paramURLDrawable);
        return;
      }
      if (this.a.a != null)
      {
        Bitmap localBitmap = qwq.a(paramURLDrawable.getCurrDrawable(), this.a.imageWidth, this.a.imageHeight, rpq.fy, this.a.a);
        if ((localBitmap == null) || (localBitmap.isRecycled()))
        {
          super.f(paramURLDrawable, "drawable transform failed!");
          return;
        }
        paramURLDrawable = (ImageView)this.dl.get();
        if (paramURLDrawable != null) {
          paramURLDrawable.setTag(2131370079, localBitmap);
        }
        super.L(new BitmapDrawable(localBitmap));
        return;
      }
      super.L(paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwj
 * JD-Core Version:    0.7.0.1
 */