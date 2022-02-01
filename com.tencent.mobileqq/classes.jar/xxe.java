import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

public class xxe
  implements wou, wov
{
  private int jdField_a_of_type_Int = Math.min(zlx.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), 200);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private final LruCache<String, xwx> jdField_a_of_type_AndroidUtilLruCache = new xxf(this, 40);
  private AtomicReference<Drawable> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private xxm jdField_a_of_type_Xxm = new xxj();
  private AtomicReference<Bitmap> b = new AtomicReference();
  
  private Bitmap a()
  {
    this.b.compareAndSet(null, Bitmap.createBitmap(bgmo.c()));
    return (Bitmap)this.b.get();
  }
  
  private Stream<Bitmap> a(List<String> paramList, String paramString)
  {
    return Stream.of(paramList).map(new ThreadOffFunction("story.icon.ShareGroupIconManager", 2)).map(new xxl(paramString)).map(new xxo(a(), paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Xxm)).map(new xwu(this.jdField_a_of_type_AndroidContentContext, paramString, this.jdField_a_of_type_Int)).map(new UIThreadOffFunction(null));
  }
  
  @NonNull
  public static String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      throw new IllegalArgumentException("unionIdList should not be null");
    }
    List localList = Collections.unmodifiableList(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while ((i < 5) && (i < localList.size()))
    {
      localStringBuilder.append((String)paramList.get(i)).append('.');
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private List<String> a(List<String> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("unionIdList should not be null");
    }
    if (paramList.size() <= 5) {
      return Collections.unmodifiableList(paramList);
    }
    return Collections.unmodifiableList(paramList.subList(0, 5));
  }
  
  public Drawable a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(null, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), a()));
    return (Drawable)this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
  }
  
  public Drawable a(List<String> paramList)
  {
    return a(paramList, null);
  }
  
  public Drawable a(List<String> paramList, String paramString)
  {
    List localList = a(paramList);
    if (localList.isEmpty())
    {
      xwv.c("story.icon.ShareGroupIconManager", "getIconDrawable unionIdList is empty");
      return a();
    }
    String str = a(localList);
    xwx localxwx = (xwx)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    paramList = localxwx;
    if (localxwx == null) {}
    synchronized (this.jdField_a_of_type_AndroidUtilLruCache)
    {
      localxwx = (xwx)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
      paramList = localxwx;
      if (localxwx == null)
      {
        paramList = new xwx(str, this.jdField_a_of_type_AndroidContentContext, a());
        paramList.a(new xxh(this, localList, String.valueOf(System.identityHashCode(paramList)) + "." + paramString));
        this.jdField_a_of_type_AndroidUtilLruCache.put(str, paramList);
        xwv.c("story.icon.ShareGroupIconManager", "create share group state for uid list, state=%s, uid=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      return paramList.newDrawable();
    }
  }
  
  @Nullable
  public xww a(List<String> paramList)
  {
    paramList = a(paramList);
    if (paramList.isEmpty())
    {
      xwv.c("story.icon.ShareGroupIconManager", "getBitmap unionIdList is empty");
      return new xww(a());
    }
    paramList = a(paramList);
    paramList = (xwx)this.jdField_a_of_type_AndroidUtilLruCache.get(paramList);
    if (paramList != null)
    {
      paramList = paramList.a();
      if (paramList != null) {
        return new xww(paramList);
      }
    }
    return null;
  }
  
  public void a()
  {
    xwv.a("story.icon.ShareGroupIconManager", "onInit");
    ((wps)wpm.a(26)).a(this);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        yqp.d("story.icon.ShareGroupIconManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      this.jdField_a_of_type_AndroidUtilLruCache.trimToSize(5);
      return;
    }
    yqp.d("story.icon.ShareGroupIconManager", "clearAllMemory");
    c();
  }
  
  public void a(List<String> paramList, @NonNull xxi paramxxi)
  {
    List localList = a(paramList);
    if (localList.isEmpty())
    {
      xwv.c("story.icon.ShareGroupIconManager", "addLoadBitmapCallBack unionIdList is empty");
      paramxxi.a(new xww(a()));
      return;
    }
    String str = a(a(paramList));
    xwx localxwx = (xwx)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    paramList = localxwx;
    if (localxwx == null) {}
    synchronized (this.jdField_a_of_type_AndroidUtilLruCache)
    {
      localxwx = (xwx)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
      paramList = localxwx;
      if (localxwx == null)
      {
        paramList = new xwx(str, this.jdField_a_of_type_AndroidContentContext, a());
        paramList.a(new xxg(this, localList, String.valueOf(System.identityHashCode(paramList))));
        this.jdField_a_of_type_AndroidUtilLruCache.put(str, paramList);
        xwv.c("story.icon.ShareGroupIconManager", "create share group state for uin list for callback, state=%s, uin=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      paramList.a(paramxxi);
      paramList.b();
      return;
    }
  }
  
  public void b()
  {
    xwv.a("story.icon.ShareGroupIconManager", "onDestroy");
    c();
    ((wps)wpm.a(26)).b(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
    this.b.set(null);
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxe
 * JD-Core Version:    0.7.0.1
 */