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

public abstract class xqu<T>
  implements Handler.Callback, xqw
{
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private WeakHashMap<ImageView, Drawable> jdField_a_of_type_JavaUtilWeakHashMap;
  private wnf jdField_a_of_type_Wnf;
  private boolean jdField_a_of_type_Boolean;
  private Handler b;
  
  public xqu()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Wnf = new wnf();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  public xqu(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ImageLoader_" + paramString);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Wnf = new wnf();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  private void a(int paramInt, xqv paramxqv)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageAtFrontOfQueue(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramxqv));
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramxqv));
  }
  
  public abstract LruCache<T, Drawable> a();
  
  public abstract xqv a(ImageView paramImageView, T paramT);
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ImageView paramImageView)
  {
    xqv localxqv = this.jdField_a_of_type_Wnf.a(paramImageView);
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (localxqv != null)
    {
      wnb.b("Q.qqstory.newImageLoader", new Object[] { "ImageView have been set,cancal task for this:", Integer.valueOf(paramImageView.hashCode()), " source:", localxqv.jdField_a_of_type_JavaLangObject });
      localxqv.b();
    }
  }
  
  public void a(ImageView paramImageView, T paramT)
  {
    a(paramImageView, paramT, new ColorDrawable(-3289651), 0);
  }
  
  public void a(ImageView paramImageView, T paramT, Drawable paramDrawable, int paramInt)
  {
    wnb.b("Q.qqstory.newImageLoader", new Object[] { "attachView:", paramT, " ----hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (paramT.toString().equals(paramImageView.getTag(2131369070))) {
      wnb.b("Q.qqstory.newImageLoader", new Object[] { "target have been set view,so dont need attach view" });
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Wnf.b(paramImageView);
      if (localObject != null)
      {
        if (paramT.equals(((xqv)localObject).jdField_a_of_type_JavaLangObject))
        {
          wnb.b("Q.qqstory.newImageLoader", new Object[] { "task running no need to do again:", ((xqv)localObject).jdField_a_of_type_JavaLangObject });
          return;
        }
        this.jdField_a_of_type_Wnf.a(paramImageView);
        wnb.b("Q.qqstory.newImageLoader", new Object[] { "cancel: ", ((xqv)localObject).jdField_a_of_type_JavaLangObject });
        ((xqv)localObject).b();
      }
      localObject = (Drawable)a().get(paramT);
      if (localObject != null)
      {
        wnb.b("Q.qqstory.newImageLoader", new Object[] { "hit the cache:", paramT });
        if ((localObject instanceof BitmapDrawable))
        {
          Bitmap localBitmap = ((BitmapDrawable)localObject).getBitmap();
          if (localBitmap != null) {
            wnb.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(localBitmap.getRowBytes() * localBitmap.getHeight()), ",h=", Integer.valueOf(localBitmap.getHeight()), ",w=", Integer.valueOf(localBitmap.getWidth()), ",key=", paramT });
          }
        }
        while ((this.jdField_a_of_type_Boolean) && (paramInt == 0))
        {
          wnb.b("Q.qqstory.newImageLoader", new Object[] { "save to waiting queue:", paramT });
          paramImageView.setImageDrawable(paramDrawable);
          wnb.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def o= ", paramImageView.getTag(2131369070), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
          paramImageView.setTag(2131369070, null);
          this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, localObject);
          return;
          wnb.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(1024), ",key= ", paramT });
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        wnb.b("Q.qqstory.newImageLoader", new Object[] { "postToUI cache o= ", paramImageView.getTag(2131369070), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
        paramImageView.setTag(2131369070, paramT.toString());
        return;
      }
      paramImageView.setImageDrawable(paramDrawable);
      wnb.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def 2 o= ", paramImageView.getTag(2131369070), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
      paramImageView.setTag(2131369070, null);
      localObject = a(paramImageView, paramT);
      if (localObject == null)
      {
        wnb.a("Q.qqstory.newImageLoader", new Object[] { "generateTask failed!!" });
        return;
      }
      ((xqv)localObject).jdField_a_of_type_Xqu = this;
      ((xqv)localObject).b = paramDrawable;
      ((xqv)localObject).jdField_a_of_type_Int = paramInt;
      ((xqv)localObject).a(this);
      ((xqv)localObject).jdField_a_of_type_JavaLangObject = paramT;
      wnb.c("Q.qqstory.newImageLoader", new Object[] { "this need request hash:", Integer.valueOf(paramImageView.hashCode()) });
      this.jdField_a_of_type_Wnf.a(paramImageView, (xqv)localObject);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Wnf.a((xqv)localObject);
    a(1, (xqv)localObject);
  }
  
  public void a(xqv paramxqv)
  {
    this.b.sendMessage(this.b.obtainMessage(3, paramxqv));
  }
  
  public void a(xqv paramxqv, String paramString)
  {
    wnb.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:,case:", paramxqv.a(), paramString });
    this.b.sendMessage(this.b.obtainMessage(2, paramxqv));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    this.jdField_a_of_type_Wnf.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    wnb.b("Q.qqstory.newImageLoader", new Object[] { "pause ui task" });
    this.b.removeMessages(4);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    wnb.b("Q.qqstory.newImageLoader", new Object[] { "resume ui task" });
    this.b.removeMessages(4);
    if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() > 0) {
      this.b.sendMessage(this.b.obtainMessage(4));
    }
    if (this.jdField_a_of_type_Wnf.a() > 0)
    {
      ListIterator localListIterator = this.jdField_a_of_type_Wnf.a();
      int i = 2;
      if ((localListIterator.hasPrevious()) && (i > 0))
      {
        Map.Entry localEntry = (Map.Entry)localListIterator.previous();
        localListIterator.remove();
        if (((WeakReference)localEntry.getValue()).get() != null) {
          this.b.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localEntry.getKey()));
        }
        for (;;)
        {
          i -= 1;
          break;
          ((xqv)localEntry.getKey()).b();
        }
      }
    }
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
        paramMessage = (xqv)paramMessage.obj;
        if (!paramMessage.a())
        {
          paramMessage.a();
          return true;
        }
        wnb.c("Q.qqstory.newImageLoader", new Object[] { alpo.a(2131706113), paramMessage.a() });
        paramMessage.c();
        return true;
        paramMessage = (xqv)paramMessage.obj;
        wnb.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED:", paramMessage.a() });
        if (!paramMessage.a())
        {
          wnb.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED post ui:", paramMessage.a() });
          paramMessage.a(this.jdField_a_of_type_JavaUtilWeakHashMap, this.jdField_a_of_type_Boolean);
          localObject = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null)
          {
            wnb.a("Q.qqstory.newImageLoader", new Object[] { "completed the request,hash: ", Integer.valueOf(localObject.hashCode()) });
            this.jdField_a_of_type_Wnf.a((ImageView)localObject);
          }
          if (paramMessage.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            a().put(paramMessage.jdField_a_of_type_JavaLangObject, paramMessage.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        for (;;)
        {
          paramMessage.c();
          if (this.jdField_a_of_type_Boolean) {
            break;
          }
          this.b.sendMessage(this.b.obtainMessage(5));
          return true;
          wnb.c("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED have been cancel:", paramMessage.a() });
        }
        paramMessage = (xqv)paramMessage.obj;
        wnb.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:", paramMessage.a() });
        localObject = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          this.jdField_a_of_type_Wnf.a((ImageView)localObject);
          ((ImageView)localObject).setImageDrawable(paramMessage.b);
          wnb.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", ((ImageView)localObject).getTag(2131369070), " and change to: default", " view hash:" + localObject.hashCode() });
          ((ImageView)localObject).setTag(2131369070, null);
        }
        paramMessage.c();
        return true;
        wnb.b("Q.qqstory.newImageLoader", new Object[] { "HANDLE_WAITING_UI_TASK" });
      } while (this.jdField_a_of_type_Boolean);
      paramMessage = this.jdField_a_of_type_JavaUtilWeakHashMap.entrySet().iterator();
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
            wnb.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131369070), " and change to: wait", " view hash:" + localImageView.hashCode() });
            localImageView.setTag(2131369070, null);
            paramMessage.remove();
          }
          i -= 1;
          if (i > 0) {}
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() <= 0) {
            break;
          }
          this.b.sendMessageDelayed(this.b.obtainMessage(4), 16L);
          return true;
        }
      }
    } while (this.jdField_a_of_type_Wnf.a() <= 0);
    paramMessage = this.jdField_a_of_type_Wnf.a();
    int i = 2;
    label640:
    if ((paramMessage.hasPrevious()) && (i > 0))
    {
      localObject = (Map.Entry)paramMessage.previous();
      paramMessage.remove();
      if (((WeakReference)((Map.Entry)localObject).getValue()).get() == null) {
        break label713;
      }
      this.b.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, ((Map.Entry)localObject).getKey()));
    }
    for (;;)
    {
      i -= 1;
      break label640;
      break;
      label713:
      ((xqv)((Map.Entry)localObject).getKey()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xqu
 * JD-Core Version:    0.7.0.1
 */