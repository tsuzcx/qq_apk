import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

public class qph
  implements psj, psk
{
  private AtomicReference<Drawable> a = new AtomicReference();
  private AtomicReference<Bitmap> jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private qpm jdField_b_of_type_Qpm = new qph.b();
  private int bnv = Math.min(rpq.dip2px(this.context, 50.0F), 200);
  private Context context = BaseApplicationImpl.getContext();
  private final LruCache<String, qpd> h = new qpi(this, 40);
  
  private Bitmap L()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(null, Bitmap.createBitmap(aqhu.aI()));
    return (Bitmap)this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
  }
  
  private Stream<Bitmap> a(List<String> paramList, String paramString)
  {
    return Stream.of(paramList).map(new ThreadOffFunction("story.icon.ShareGroupIconManager", 2)).map(new qpl(paramString)).map(new qpn(L(), paramString, this.bnv, this.jdField_b_of_type_Qpm)).map(new qpa(this.context, paramString, this.bnv)).map(new UIThreadOffFunction(null));
  }
  
  private List<String> at(List<String> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("unionIdList should not be null");
    }
    if (paramList.size() <= 5) {
      return Collections.unmodifiableList(paramList);
    }
    return Collections.unmodifiableList(paramList.subList(0, 5));
  }
  
  @NonNull
  public static String s(List<String> paramList)
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
  
  public Drawable a(List<String> paramList, String paramString)
  {
    List localList = at(paramList);
    if (localList.isEmpty())
    {
      qpb.e("story.icon.ShareGroupIconManager", "getIconDrawable unionIdList is empty");
      return at();
    }
    String str = s(localList);
    qpd localqpd = (qpd)this.h.get(str);
    paramList = localqpd;
    if (localqpd == null) {}
    synchronized (this.h)
    {
      localqpd = (qpd)this.h.get(str);
      paramList = localqpd;
      if (localqpd == null)
      {
        paramList = new qpd(str, this.context, at());
        paramList.a(new qpk(this, localList, String.valueOf(System.identityHashCode(paramList)) + "." + paramString));
        this.h.put(str, paramList);
        qpb.c("story.icon.ShareGroupIconManager", "create share group state for uid list, state=%s, uid=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      return paramList.newDrawable();
    }
  }
  
  @Nullable
  public qpc a(List<String> paramList)
  {
    paramList = at(paramList);
    if (paramList.isEmpty())
    {
      qpb.e("story.icon.ShareGroupIconManager", "getBitmap unionIdList is empty");
      return new qpc(L());
    }
    paramList = s(paramList);
    paramList = (qpd)this.h.get(paramList);
    if (paramList != null)
    {
      paramList = paramList.T();
      if (paramList != null) {
        return new qpc(paramList);
      }
    }
    return null;
  }
  
  public void a(List<String> paramList, @NonNull qph.a parama)
  {
    List localList = at(paramList);
    if (localList.isEmpty())
    {
      qpb.e("story.icon.ShareGroupIconManager", "addLoadBitmapCallBack unionIdList is empty");
      parama.b(new qpc(L()));
      return;
    }
    String str = s(at(paramList));
    qpd localqpd = (qpd)this.h.get(str);
    paramList = localqpd;
    if (localqpd == null) {}
    synchronized (this.h)
    {
      localqpd = (qpd)this.h.get(str);
      paramList = localqpd;
      if (localqpd == null)
      {
        paramList = new qpd(str, this.context, at());
        paramList.a(new qpj(this, localList, String.valueOf(System.identityHashCode(paramList))));
        this.h.put(str, paramList);
        qpb.c("story.icon.ShareGroupIconManager", "create share group state for uin list for callback, state=%s, uin=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
      }
      paramList.a(parama);
      paramList.startLoad();
      return;
    }
  }
  
  public Drawable at()
  {
    this.a.compareAndSet(null, new BitmapDrawable(this.context.getResources(), L()));
    return (Drawable)this.a.get();
  }
  
  public Drawable b(List<String> paramList)
  {
    return a(paramList, null);
  }
  
  public void bpx()
  {
    this.a.set(null);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicReference.set(null);
    this.h.evictAll();
  }
  
  public void onDestroy()
  {
    qpb.d("story.icon.ShareGroupIconManager", "onDestroy");
    bpx();
    ((ptb)psx.a(26)).b(this);
  }
  
  public void onInit()
  {
    qpb.d("story.icon.ShareGroupIconManager", "onInit");
    ((ptb)psx.a(26)).a(this);
  }
  
  public void trimMemory(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
      do
      {
        return;
        ram.w("story.icon.ShareGroupIconManager", "trimMemory to be 5");
      } while (Build.VERSION.SDK_INT < 17);
      this.h.trimToSize(5);
      return;
    }
    ram.w("story.icon.ShareGroupIconManager", "clearAllMemory");
    bpx();
  }
  
  public static abstract class a
    implements qpd.a
  {
    public final void a(@NonNull qpd paramqpd)
    {
      b(new qpc(paramqpd.T()));
    }
    
    protected void b(Error paramError) {}
    
    protected void b(qpc paramqpc) {}
    
    public final void b(@NonNull qpd paramqpd)
    {
      b(paramqpd.a());
    }
  }
  
  public static class b
    implements qpm
  {
    private final HashSet<URLDrawable> ah = new HashSet();
    private final ConcurrentHashMap<String, HashSet<qpm.a>> cg = new ConcurrentHashMap();
    
    private Bitmap a(@NonNull URLDrawable paramURLDrawable, int paramInt1, int paramInt2)
    {
      Object localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        if (localObject != null) {
          return localObject;
        }
      }
      return aqhu.f(paramURLDrawable, paramInt1, paramInt2);
    }
    
    public void a(String paramString, int paramInt1, int paramInt2, qpm.a parama)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(1073741824);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable;
      try
      {
        URL localURL = new URL(paramString);
        localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setURLDrawableListener(new qph.b.a(paramString, paramInt1, paramInt2, (URLDrawable)localObject));
        ((URLDrawable)localObject).setAutoDownload(true);
        if (((URLDrawable)localObject).getStatus() != 1) {
          break label177;
        }
        ram.b("story.icon.ShareGroupIconManager", "download url success directly. %s", paramString);
        localObject = a((URLDrawable)localObject, paramInt1, paramInt2);
        if (localObject != null)
        {
          parama.m(paramString, (Bitmap)localObject);
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        ram.d("story.icon.ShareGroupIconManager", localMalformedURLException, "can not download url. %s", new Object[] { paramString });
        parama.h(paramString, new Throwable("getBitmapFromDrawable failed"));
        return;
      }
      ram.e("story.icon.ShareGroupIconManager", "download url success directly. but OOM occur !");
      parama.h(paramString, new Throwable("getBitmapFromDrawable failed"));
      return;
      label177:
      ram.b("story.icon.ShareGroupIconManager", "download url pending. %s", paramString);
      this.cg.putIfAbsent(paramString, new HashSet());
      ((HashSet)this.cg.get(paramString)).add(parama);
      this.ah.add(localMalformedURLException);
      localMalformedURLException.startDownload();
    }
    
    class a
      implements URLDrawable.URLDrawableListener
    {
      private final int bnw;
      private final int bnx;
      private final URLDrawable o;
      private final String url;
      
      public a(@NonNull String paramString, int paramInt1, int paramInt2, URLDrawable paramURLDrawable)
      {
        this.url = paramString;
        this.bnw = paramInt1;
        this.bnx = paramInt2;
        this.o = paramURLDrawable;
      }
      
      public void onLoadCanceled(URLDrawable paramURLDrawable)
      {
        qph.b.a(qph.b.this).remove(this.o);
      }
      
      public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
      {
        qph.b.a(qph.b.this).remove(this.o);
        ram.w("story.icon.ShareGroupIconManager", "download url failed. %s", new Object[] { this.url });
        paramURLDrawable = (HashSet)qph.b.a(qph.b.this).remove(this.url);
        if (paramURLDrawable != null)
        {
          paramURLDrawable = paramURLDrawable.iterator();
          while (paramURLDrawable.hasNext()) {
            ((qpm.a)paramURLDrawable.next()).h(this.url, paramThrowable);
          }
        }
      }
      
      public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
      
      public void onLoadSuccessed(URLDrawable paramURLDrawable)
      {
        qph.b.a(qph.b.this).remove(this.o);
        ram.b("story.icon.ShareGroupIconManager", "download url success. %s", this.url);
        Bitmap localBitmap = qph.b.a(qph.b.this, paramURLDrawable, this.bnw, this.bnx);
        if (localBitmap != null)
        {
          paramURLDrawable = (HashSet)qph.b.a(qph.b.this).remove(this.url);
          if (paramURLDrawable != null)
          {
            paramURLDrawable = paramURLDrawable.iterator();
            while (paramURLDrawable.hasNext()) {
              ((qpm.a)paramURLDrawable.next()).m(this.url, localBitmap);
            }
          }
        }
        else
        {
          ram.e("story.icon.ShareGroupIconManager", "download url success directly. but OOM occur !");
          onLoadFialed(paramURLDrawable, new Throwable("getBitmapFromDrawable failed"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qph
 * JD-Core Version:    0.7.0.1
 */