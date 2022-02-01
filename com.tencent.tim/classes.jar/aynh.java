import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public abstract class aynh<PACKAGE extends aymz>
  extends BaseAdapter
{
  protected FaceListPage a;
  public int brY;
  protected PACKAGE c;
  protected Context context;
  protected axqg f;
  
  public aynh(Context paramContext, FaceListPage paramFaceListPage)
  {
    this.context = paramContext;
    this.a = paramFaceListPage;
  }
  
  public void a(axqg paramaxqg)
  {
    this.f = paramaxqg;
  }
  
  protected boolean aQR()
  {
    return this.a.isShowing;
  }
  
  public void d(PACKAGE paramPACKAGE)
  {
    this.c = paramPACKAGE;
  }
  
  public int getCount()
  {
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceList", 2, "facePkg is null");
      }
      return 0;
    }
    int i = this.c.getFaceCount();
    int j = this.c.tu();
    if (j < 1) {
      throw new IllegalArgumentException("per item count < 1 :" + j);
    }
    if ((QLog.isColorLevel()) && (i == 0)) {
      QLog.d("FaceList", 2, "totalFaceCount = 0");
    }
    if (i % j == 0) {
      return i / j;
    }
    return i / j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static class a<K, V>
  {
    private ReferenceQueue<V> e = new ReferenceQueue();
    private HashMap<K, a<K, V>.a> rz = new HashMap();
    
    public void eSR()
    {
      for (;;)
      {
        Reference localReference = this.e.poll();
        if (localReference == null) {
          break;
        }
        this.rz.remove(((aynh.a.a)localReference).getKey());
      }
    }
    
    @Nullable
    public V get(K paramK)
    {
      if (this.rz.containsKey(paramK))
      {
        paramK = (aynh.a.a)this.rz.get(paramK);
        if (paramK.get() != null) {
          return paramK.get();
        }
      }
      return null;
    }
    
    public void h(@NonNull K paramK, @NonNull V paramV)
    {
      if ((paramK == null) || (paramV == null)) {
        throw new IllegalArgumentException("key-value cannot be null");
      }
      if ((this.rz.containsKey(paramK)) && (((aynh.a.a)this.rz.get(paramK)).get() != null)) {
        return;
      }
      this.rz.put(paramK, new aynh.a.a(paramK, paramV, this.e));
    }
    
    class a
      extends SoftReference<V>
    {
      private K mKey;
      
      public a(V paramV, ReferenceQueue<? super V> paramReferenceQueue)
      {
        super(localReferenceQueue);
        this.mKey = paramV;
      }
      
      public K getKey()
      {
        return this.mKey;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynh
 * JD-Core Version:    0.7.0.1
 */