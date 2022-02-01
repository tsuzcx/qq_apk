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

public abstract class zgn<T>
  implements Handler.Callback, zgp
{
  private int jdField_a_of_type_Int = 1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private WeakHashMap<ImageView, Drawable> jdField_a_of_type_JavaUtilWeakHashMap;
  private yfa jdField_a_of_type_Yfa;
  private boolean jdField_a_of_type_Boolean;
  private Handler b;
  
  public zgn()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Yfa = new yfa();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  public zgn(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("ImageLoader_" + paramString);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Yfa = new yfa();
    this.jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  }
  
  private void a(int paramInt, zgo paramzgo)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageAtFrontOfQueue(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramzgo));
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt, paramzgo));
  }
  
  public abstract LruCache<T, Drawable> a();
  
  public abstract zgo a(ImageView paramImageView, T paramT);
  
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
    zgo localzgo = this.jdField_a_of_type_Yfa.a(paramImageView);
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (localzgo != null)
    {
      yew.b("Q.qqstory.newImageLoader", new Object[] { "ImageView have been set,cancal task for this:", Integer.valueOf(paramImageView.hashCode()), " source:", localzgo.jdField_a_of_type_JavaLangObject });
      localzgo.b();
    }
  }
  
  public void a(ImageView paramImageView, T paramT)
  {
    a(paramImageView, paramT, new ColorDrawable(-3289651), 0);
  }
  
  public void a(ImageView paramImageView, T paramT, Drawable paramDrawable, int paramInt)
  {
    yew.b("Q.qqstory.newImageLoader", new Object[] { "attachView:", paramT, " ----hash:", Integer.valueOf(paramImageView.hashCode()) });
    this.jdField_a_of_type_JavaUtilWeakHashMap.remove(paramImageView);
    if (paramT.toString().equals(paramImageView.getTag(2131369720))) {
      yew.b("Q.qqstory.newImageLoader", new Object[] { "target have been set view,so dont need attach view" });
    }
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Yfa.b(paramImageView);
      if (localObject != null)
      {
        if (paramT.equals(((zgo)localObject).jdField_a_of_type_JavaLangObject))
        {
          yew.b("Q.qqstory.newImageLoader", new Object[] { "task running no need to do again:", ((zgo)localObject).jdField_a_of_type_JavaLangObject });
          return;
        }
        this.jdField_a_of_type_Yfa.a(paramImageView);
        yew.b("Q.qqstory.newImageLoader", new Object[] { "cancel: ", ((zgo)localObject).jdField_a_of_type_JavaLangObject });
        ((zgo)localObject).b();
      }
      localObject = (Drawable)a().get(paramT);
      if (localObject != null)
      {
        yew.b("Q.qqstory.newImageLoader", new Object[] { "hit the cache:", paramT });
        if ((localObject instanceof BitmapDrawable))
        {
          Bitmap localBitmap = ((BitmapDrawable)localObject).getBitmap();
          if (localBitmap != null) {
            yew.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(localBitmap.getRowBytes() * localBitmap.getHeight()), ",h=", Integer.valueOf(localBitmap.getHeight()), ",w=", Integer.valueOf(localBitmap.getWidth()), ",key=", paramT });
          }
        }
        while ((this.jdField_a_of_type_Boolean) && (paramInt == 0))
        {
          yew.b("Q.qqstory.newImageLoader", new Object[] { "save to waiting queue:", paramT });
          paramImageView.setImageDrawable(paramDrawable);
          yew.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def o= ", paramImageView.getTag(2131369720), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
          paramImageView.setTag(2131369720, null);
          this.jdField_a_of_type_JavaUtilWeakHashMap.put(paramImageView, localObject);
          return;
          yew.b("Q.qqstory.newImageLoader", new Object[] { "cache size=", Integer.valueOf(1024), ",key= ", paramT });
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        yew.b("Q.qqstory.newImageLoader", new Object[] { "postToUI cache o= ", paramImageView.getTag(2131369720), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
        paramImageView.setTag(2131369720, paramT.toString());
        return;
      }
      paramImageView.setImageDrawable(paramDrawable);
      yew.b("Q.qqstory.newImageLoader", new Object[] { "postToUI def 2 o= ", paramImageView.getTag(2131369720), " and change to: ", paramT.toString(), " view hash:" + paramImageView.hashCode() });
      paramImageView.setTag(2131369720, null);
      localObject = a(paramImageView, paramT);
      if (localObject == null)
      {
        yew.a("Q.qqstory.newImageLoader", new Object[] { "generateTask failed!!" });
        return;
      }
      ((zgo)localObject).jdField_a_of_type_Zgn = this;
      ((zgo)localObject).b = paramDrawable;
      ((zgo)localObject).jdField_a_of_type_Int = paramInt;
      ((zgo)localObject).a(this);
      ((zgo)localObject).jdField_a_of_type_JavaLangObject = paramT;
      yew.c("Q.qqstory.newImageLoader", new Object[] { "this need request hash:", Integer.valueOf(paramImageView.hashCode()) });
      this.jdField_a_of_type_Yfa.a(paramImageView, (zgo)localObject);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Yfa.a((zgo)localObject);
    a(1, (zgo)localObject);
  }
  
  public void a(zgo paramzgo)
  {
    this.b.sendMessage(this.b.obtainMessage(3, paramzgo));
  }
  
  public void a(zgo paramzgo, String paramString)
  {
    yew.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:,case:", paramzgo.a(), paramString });
    this.b.sendMessage(this.b.obtainMessage(2, paramzgo));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.clear();
    this.jdField_a_of_type_Yfa.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    yew.b("Q.qqstory.newImageLoader", new Object[] { "pause ui task" });
    this.b.removeMessages(4);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    yew.b("Q.qqstory.newImageLoader", new Object[] { "resume ui task" });
    this.b.removeMessages(4);
    if (this.jdField_a_of_type_JavaUtilWeakHashMap.size() > 0) {
      this.b.sendMessage(this.b.obtainMessage(4));
    }
    if (this.jdField_a_of_type_Yfa.a() > 0)
    {
      ListIterator localListIterator = this.jdField_a_of_type_Yfa.a();
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
          ((zgo)localEntry.getKey()).b();
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
        paramMessage = (zgo)paramMessage.obj;
        if (!paramMessage.a())
        {
          paramMessage.a();
          return true;
        }
        yew.c("Q.qqstory.newImageLoader", new Object[] { anvx.a(2131705214), paramMessage.a() });
        paramMessage.c();
        return true;
        paramMessage = (zgo)paramMessage.obj;
        yew.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED:", paramMessage.a() });
        if (!paramMessage.a())
        {
          yew.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED post ui:", paramMessage.a() });
          paramMessage.a(this.jdField_a_of_type_JavaUtilWeakHashMap, this.jdField_a_of_type_Boolean);
          localObject = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject != null)
          {
            yew.a("Q.qqstory.newImageLoader", new Object[] { "completed the request,hash: ", Integer.valueOf(localObject.hashCode()) });
            this.jdField_a_of_type_Yfa.a((ImageView)localObject);
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
          yew.c("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_COMPLETED have been cancel:", paramMessage.a() });
        }
        paramMessage = (zgo)paramMessage.obj;
        yew.a("Q.qqstory.newImageLoader", new Object[] { "EXECUTE_TASK_ERROR:", paramMessage.a() });
        localObject = (ImageView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          this.jdField_a_of_type_Yfa.a((ImageView)localObject);
          ((ImageView)localObject).setImageDrawable(paramMessage.b);
          yew.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", ((ImageView)localObject).getTag(2131369720), " and change to: default", " view hash:" + localObject.hashCode() });
          ((ImageView)localObject).setTag(2131369720, null);
        }
        paramMessage.c();
        return true;
        yew.b("Q.qqstory.newImageLoader", new Object[] { "HANDLE_WAITING_UI_TASK" });
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
            yew.b("Q.qqstory.newImageLoader", new Object[] { "postToUI o= ", localImageView.getTag(2131369720), " and change to: wait", " view hash:" + localImageView.hashCode() });
            localImageView.setTag(2131369720, null);
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
    } while (this.jdField_a_of_type_Yfa.a() <= 0);
    paramMessage = this.jdField_a_of_type_Yfa.a();
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
      ((zgo)((Map.Entry)localObject).getKey()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgn
 * JD-Core Version:    0.7.0.1
 */