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

public class yaz
  implements wsp, wsq
{
  private int jdField_a_of_type_Int = Math.min(zps.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), 200);
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private final LruCache<String, yas> jdField_a_of_type_AndroidUtilLruCache = new yba(this, 40);
  private AtomicReference<Drawable> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private ybh jdField_a_of_type_Ybh = new ybe();
  private AtomicReference<Bitmap> b = new AtomicReference();
  
  private Bitmap a()
  {
    this.b.compareAndSet(null, Bitmap.createBitmap(bhmq.c()));
    return (Bitmap)this.b.get();
  }
  
  private Stream<Bitmap> a(List<String> paramList, String paramString)
  {
    return Stream.of(paramList).map(new ThreadOffFunction("story.icon.ShareGroupIconManager", 2)).map(new ybg(paramString)).map(new ybj(a(), paramString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ybh)).map(new yap(this.jdField_a_of_type_AndroidContentContext, paramString, this.jdField_a_of_type_Int)).map(new UIThreadOffFunction(null));
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
      yaq.c("story.icon.ShareGroupIconManager", "getIconDrawable unionIdList is empty");
      return a();
    }
    String str = a(localList);
    yas localyas = (yas)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    paramList = localyas;
    if (localyas == null) {}
    synchronized (this.jdField_a_of_type_AndroidUtilLruCache)
    {
      localyas = (yas)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
      paramList = localyas;
      if (localyas == null)
      {
        paramList = new yas(str, this.jdField_a_of_type_AndroidContentContext, a());
        paramList.a(new ybc(this, localList, String.valueOf(System.identityHashCode(paramList)) + "." + paramString));
        this.jdField_a_of_type_AndroidUtilLruCache.put(str, paramList);
        yaq.c("story.icon.ShareGroupIconManager", "create share group state for uid list, state=%s, uid=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      return paramList.newDrawable();
    }
  }
  
  @Nullable
  public yar a(List<String> paramList)
  {
    paramList = a(paramList);
    if (paramList.isEmpty())
    {
      yaq.c("story.icon.ShareGroupIconManager", "getBitmap unionIdList is empty");
      return new yar(a());
    }
    paramList = a(paramList);
    paramList = (yas)this.jdField_a_of_type_AndroidUtilLruCache.get(paramList);
    if (paramList != null)
    {
      paramList = paramList.a();
      if (paramList != null) {
        return new yar(paramList);
      }
    }
    return null;
  }
  
  public void a()
  {
    yaq.a("story.icon.ShareGroupIconManager", "onInit");
    ((wtn)wth.a(26)).a(this);
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
        yuk.d("story.icon.ShareGroupIconManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      this.jdField_a_of_type_AndroidUtilLruCache.trimToSize(5);
      return;
    }
    yuk.d("story.icon.ShareGroupIconManager", "clearAllMemory");
    c();
  }
  
  public void a(List<String> paramList, @NonNull ybd paramybd)
  {
    List localList = a(paramList);
    if (localList.isEmpty())
    {
      yaq.c("story.icon.ShareGroupIconManager", "addLoadBitmapCallBack unionIdList is empty");
      paramybd.a(new yar(a()));
      return;
    }
    String str = a(a(paramList));
    yas localyas = (yas)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
    paramList = localyas;
    if (localyas == null) {}
    synchronized (this.jdField_a_of_type_AndroidUtilLruCache)
    {
      localyas = (yas)this.jdField_a_of_type_AndroidUtilLruCache.get(str);
      paramList = localyas;
      if (localyas == null)
      {
        paramList = new yas(str, this.jdField_a_of_type_AndroidContentContext, a());
        paramList.a(new ybb(this, localList, String.valueOf(System.identityHashCode(paramList))));
        this.jdField_a_of_type_AndroidUtilLruCache.put(str, paramList);
        yaq.c("story.icon.ShareGroupIconManager", "create share group state for uin list for callback, state=%s, uin=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      paramList.a(paramybd);
      paramList.b();
      return;
    }
  }
  
  public void b()
  {
    yaq.a("story.icon.ShareGroupIconManager", "onDestroy");
    c();
    ((wtn)wth.a(26)).b(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
    this.b.set(null);
    this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaz
 * JD-Core Version:    0.7.0.1
 */