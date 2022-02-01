import android.text.TextUtils;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class vhd
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vhd jdField_a_of_type_Vhd;
  private SoftReference<ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>>> jdField_a_of_type_JavaLangRefSoftReference;
  private SoftReference<ConcurrentHashMap<vhe, SoftReference<vhf>>> b;
  
  private ConcurrentHashMap<vhe, SoftReference<vhf>> a()
  {
    if (this.b != null) {
      ??? = (ConcurrentHashMap)this.b.get();
    }
    for (;;)
    {
      if (??? == null) {}
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((this.b == null) || (this.b.get() == null)) {
          this.b = new SoftReference(new ConcurrentHashMap());
        }
        return (ConcurrentHashMap)this.b.get();
        ??? = null;
      }
    }
  }
  
  public static vhd a()
  {
    if (jdField_a_of_type_Vhd == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Vhd == null) {
        jdField_a_of_type_Vhd = new vhd();
      }
      return jdField_a_of_type_Vhd;
    }
  }
  
  private ConcurrentHashMap<Integer, SoftReference<ArrayList<TextCell>>> b()
  {
    if (this.jdField_a_of_type_JavaLangRefSoftReference != null) {}
    for (ConcurrentHashMap localConcurrentHashMap1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaLangRefSoftReference.get();; localConcurrentHashMap1 = null)
    {
      ConcurrentHashMap localConcurrentHashMap2 = localConcurrentHashMap1;
      if (localConcurrentHashMap1 == null)
      {
        localConcurrentHashMap2 = new ConcurrentHashMap();
        this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localConcurrentHashMap2);
      }
      return localConcurrentHashMap2;
    }
  }
  
  public ArrayList<TextCell> a(int paramInt)
  {
    Object localObject = (SoftReference)b().get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = (ArrayList)((SoftReference)localObject).get();
      if (localObject == null) {
        b().remove(Integer.valueOf(paramInt));
      }
      return localObject;
    }
    return null;
  }
  
  public vhf a(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new vhe(paramInt1, paramInt2, paramString);
    ConcurrentHashMap localConcurrentHashMap = a();
    Object localObject = (SoftReference)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      localObject = (vhf)((SoftReference)localObject).get();
      if (localObject != null) {
        return ((vhf)localObject).a();
      }
      localConcurrentHashMap.remove(paramString);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, vhf paramvhf)
  {
    paramString = new vhe(paramInt1, paramInt2, paramString);
    a().put(paramString, new SoftReference(paramvhf));
  }
  
  public void a(int paramInt, ArrayList<TextCell> paramArrayList)
  {
    try
    {
      b().put(Integer.valueOf(paramInt), new SoftReference(paramArrayList));
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhd
 * JD-Core Version:    0.7.0.1
 */