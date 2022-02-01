import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class rru<T>
  implements Handler.Callback, rrv.a
{
  private qwt a;
  private Handler bm;
  private int buI = 1;
  private WeakHashMap<ImageView, Drawable> e;
  private boolean isPause;
  private Handler mUIHandler;
  private HandlerThread p;
  
  public rru()
  {
    this.bm = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.a = new qwt();
    this.e = new WeakHashMap();
  }
  
  public rru(String paramString)
  {
    this.p = new HandlerThread("ImageLoader_" + paramString);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    this.a = new qwt();
    this.e = new WeakHashMap();
  }
  
  private void a(int paramInt, rrv paramrrv)
  {
    if (this.buI == 0) {
      this.bm.sendMessageAtFrontOfQueue(this.bm.obtainMessage(paramInt, paramrrv));
    }
    while (this.buI != 1) {
      return;
    }
    this.bm.sendMessage(this.bm.obtainMessage(paramInt, paramrrv));
  }
  
  public abstract rrv a(ImageView paramImageView, T paramT);
  
  public void a(ImageView paramImageView, T paramT)
  {
    a(paramImageView, paramT, new ColorDrawable(-3289651), 0);
  }
  
  public void a(ImageView paramImageView, T paramT, Drawable paramDrawable, int paramInt)
  {
    qwp.d("Q.qqstory.newImageLoader", new Object[] { "attachView:", paramT, " ----hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.e.remove(paramImageView);
    if (paramT.toString().equals(paramImageView.getTag(2131370080))) {
      qwp.d("Q.qqstory.newImageLoader", new Object[] { "target have been set view,so dont need attach view" });
    }
    Object localObject;
    do
    {
      return;
      localObject = this.a.b(paramImageView);
      if (localObject != null)
      {
        if (paramT.equals(((rrv)localObject).source))
        {
          qwp.d("Q.qqstory.newImageLoader", new Object[] { "task running no need to do again:", ((rrv)localObject).source });
          return;
        }
        this.a.a(paramImageView);
        qwp.d("Q.qqstory.newImageLoader", new Object[] { "cancel: ", ((rrv)localObject).source });
        ((rrv)localObject).cancel();
      }
      localObject = (Drawable)c().get(paramT);
      if (localObject != null)
      {
        qwp.d("Q.qqstory.newImageLoader", new Object[] { "hit the cache:", paramT });
        if ((localObject instanceof BitmapDrawable))
        {
          Bitmap localBitmap = ((BitmapDrawable)localObject).getBitmap();
          if (localBitmap != null) {
            qwp.d("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(localBitmap.getRowBytes() * localBitmap.getHeight()), ",h=", Integer.valueOf(localBitmap.getHeight()), ",w=", Integer.valueOf(localBitmap.getWidth()), ",key=", paramT });
          }
        }
        while ((this.isPause) && (paramInt == 0))
        {
          qwp.d("Q.qqstory.newImageLoader", new Object[] { "save to waiting queue:", paramT });
          paramImageView.setImageDrawable(paramDrawable);
          qwp.d("Q.qqstory.newImageLoader", new Object[] { "postToUI def o= ", paramImageView.getTag(2131370080), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
          paramImageView.setTag(2131370080, null);
          this.e.put(paramImageView, localObject);
          return;
          qwp.d("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(1024), ",key= ", paramT });
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        qwp.d("Q.qqstory.newImageLoader", new Object[] { "postToUI cache o= ", paramImageView.getTag(2131370080), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
        paramImageView.setTag(2131370080, paramT.toString());
        return;
      }
      paramImageView.setImageDrawable(paramDrawable);
      qwp.d("Q.qqstory.newImageLoader", new Object[] { "postToUI def 2 o= ", paramImageView.getTag(2131370080), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
      paramImageView.setTag(2131370080, null);
      localObject = a(paramImageView, paramT);
      if (localObject == null)
      {
        qwp.e("Q.qqstory.newImageLoader", new Object[] { "generateTask failed!!" });
        return;
      }
      ((rrv)localObject).a = this;
      ((rrv)localObject).defaultDrawable = paramDrawable;
      ((rrv)localObject).flag = paramInt;
      ((rrv)localObject).a(this);
      ((rrv)localObject).source = paramT;
      qwp.w("Q.qqstory.newImageLoader", new Object[] { "this need request hash:", Integer.valueOf(paramImageView.hashCode()) });
      this.a.a(paramImageView, (rrv)localObject);
    } while (this.isPause);
    this.a.a((rrv)localObject);
    a(1, (rrv)localObject);
  }
  
  public void a(rrv paramrrv, String paramString)
  {
    qwp.e("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:,case:", paramrrv.key(), paramString });
    this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(2, paramrrv));
  }
  
  public void b(rrv paramrrv)
  {
    this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(3, paramrrv));
  }
  
  public abstract LruCache<T, Drawable> c();
  
  public void clearCache()
  {
    this.e.clear();
    this.a.clear();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    do
    {
      do
      {
        return true;
        paramMessage = (rrv)paramMessage.obj;
        if (!paramMessage.LY())
        {
          paramMessage.bri();
          return true;
        }
        qwp.w("Q.qqstory.newImageLoader", new Object[] { acfp.m(2131707387), paramMessage.key() });
        paramMessage.release();
        return true;
        paramMessage = (rrv)paramMessage.obj;
        qwp.e("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED:", paramMessage.key() });
        if (!paramMessage.LY())
        {
          qwp.e("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED post ui:", paramMessage.key() });
          paramMessage.a(this.e, this.isPause);
          localObject = (ImageView)paramMessage.dl.get();
          if (localObject != null)
          {
            qwp.e("Q.qqstory.newImageLoader", new Object[] { "completed the request,hash: ", Integer.valueOf(localObject.hashCode()) });
            this.a.a((ImageView)localObject);
          }
          if (paramMessage.jdField_do != null) {
            c().put(paramMessage.source, paramMessage.jdField_do);
          }
        }
        for (;;)
        {
          paramMessage.release();
          if (this.isPause) {
            break;
          }
          this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(5));
          return true;
          qwp.w("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED have been cancel:", paramMessage.key() });
        }
        paramMessage = (rrv)paramMessage.obj;
        qwp.e("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:", paramMessage.key() });
        localObject = (ImageView)paramMessage.dl.get();
        if (localObject != null)
        {
          this.a.a((ImageView)localObject);
          ((ImageView)localObject).setImageDrawable(paramMessage.defaultDrawable);
          qwp.d("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", ((ImageView)localObject).getTag(2131370080), " and change to: default", " view hash:" + localObject.hashCode() });
          ((ImageView)localObject).setTag(2131370080, null);
        }
        paramMessage.release();
        return true;
        qwp.d("Q.qqstory.newImageLoader", new Object[] { "HANDLE_WAITING_UI_TASK" });
      } while (this.isPause);
      paramMessage = this.e.entrySet().iterator();
      i = 3;
      for (;;)
      {
        if (paramMessage.hasNext())
        {
          localObject = (Map.Entry)paramMessage.next();
          ImageView localImageView = (ImageView)((Map.Entry)localObject).getKey();
          if (localImageView != null)
          {
            localImageView.setImageDrawable((Drawable)((Map.Entry)localObject).getValue());
            qwp.d("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131370080), " and change to: wait", " view hash:" + localImageView.hashCode() });
            localImageView.setTag(2131370080, null);
            paramMessage.remove();
          }
          i -= 1;
          if (i > 0) {}
        }
        else
        {
          if (this.e.size() <= 0) {
            break;
          }
          this.mUIHandler.sendMessageDelayed(this.mUIHandler.obtainMessage(4), 16L);
          return true;
        }
      }
    } while (this.a.sV() <= 0);
    paramMessage = this.a.a();
    int i = 2;
    label640:
    if ((paramMessage.hasPrevious()) && (i > 0))
    {
      localObject = (Map.Entry)paramMessage.previous();
      paramMessage.remove();
      if (((WeakReference)((Map.Entry)localObject).getValue()).get() == null) {
        break label713;
      }
      this.mUIHandler.sendMessage(this.bm.obtainMessage(1, ((Map.Entry)localObject).getKey()));
    }
    for (;;)
    {
      i -= 1;
      break label640;
      break;
      label713:
      ((rrv)((Map.Entry)localObject).getKey()).cancel();
    }
  }
  
  public void pause()
  {
    this.isPause = true;
    qwp.d("Q.qqstory.newImageLoader", new Object[] { "pause ui task" });
    this.mUIHandler.removeMessages(4);
  }
  
  public void prepare()
  {
    this.p.start();
    this.bm = new Handler(this.p.getLooper(), this);
  }
  
  public void q(ImageView paramImageView)
  {
    rrv localrrv = this.a.a(paramImageView);
    this.e.remove(paramImageView);
    if (localrrv != null)
    {
      qwp.d("Q.qqstory.newImageLoader", new Object[] { "ImageView have been set,cancal task for this:", Integer.valueOf(paramImageView.hashCode()), " source:", localrrv.source });
      localrrv.cancel();
    }
  }
  
  public void release()
  {
    this.bm.removeCallbacksAndMessages(null);
    if (this.p != null) {}
    try
    {
      this.p.quit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void resume()
  {
    this.isPause = false;
    qwp.d("Q.qqstory.newImageLoader", new Object[] { "resume ui task" });
    this.mUIHandler.removeMessages(4);
    if (this.e.size() > 0) {
      this.mUIHandler.sendMessage(this.mUIHandler.obtainMessage(4));
    }
    if (this.a.sV() > 0)
    {
      ListIterator localListIterator = this.a.a();
      int i = 2;
      if ((localListIterator.hasPrevious()) && (i > 0))
      {
        Map.Entry localEntry = (Map.Entry)localListIterator.previous();
        localListIterator.remove();
        if (((WeakReference)localEntry.getValue()).get() != null) {
          this.mUIHandler.sendMessage(this.bm.obtainMessage(1, localEntry.getKey()));
        }
        for (;;)
        {
          i -= 1;
          break;
          ((rrv)localEntry.getKey()).cancel();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rru
 * JD-Core Version:    0.7.0.1
 */