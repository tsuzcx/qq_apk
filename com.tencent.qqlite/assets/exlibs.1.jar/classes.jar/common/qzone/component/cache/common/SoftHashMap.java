package common.qzone.component.cache.common;

import fji;
import fjk;
import fjn;
import fjq;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class SoftHashMap
  extends AbstractMap
{
  private static final float jdField_a_of_type_Float = 0.75F;
  private static final int jdField_a_of_type_Int = 16;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int jdField_b_of_type_Int = 1073741824;
  private final ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private volatile transient Collection jdField_a_of_type_JavaUtilCollection = null;
  private transient Set jdField_a_of_type_JavaUtilSet = null;
  private fji[] jdField_a_of_type_ArrayOfFji;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfFji = new fji[16];
  }
  
  public SoftHashMap(int paramInt, float paramFloat)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Illegal Initial Capacity: " + paramInt);
    }
    int i = paramInt;
    if (paramInt > 1073741824) {
      i = 1073741824;
    }
    if ((paramFloat <= 0.0F) || (Float.isNaN(paramFloat))) {
      throw new IllegalArgumentException("Illegal Load factor: " + paramFloat);
    }
    paramInt = 1;
    while (paramInt < i) {
      paramInt <<= 1;
    }
    this.jdField_a_of_type_ArrayOfFji = new fji[paramInt];
    this.jdField_b_of_type_Float = paramFloat;
    this.d = ((int)(paramInt * paramFloat));
  }
  
  private static int a(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 - 1 & paramInt1;
  }
  
  private static int a(Object paramObject)
  {
    return a(paramObject.hashCode());
  }
  
  private fji a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((fji.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = fji.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    fji localfji2 = (fji)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localfji2 != null)
    {
      int i = a(fji.a(localfji2), this.jdField_a_of_type_ArrayOfFji.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfFji[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        fji localfji1 = fji.a((fji)localObject1);
        if (localObject1 == localfji2)
        {
          if (localObject2 == localfji2) {
            this.jdField_a_of_type_ArrayOfFji[i] = localfji1;
          }
          for (;;)
          {
            fji.a(localfji2, null);
            fji.a(localfji2, null);
            this.c -= 1;
            break;
            fji.a(localObject2, localfji1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localfji1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    fji[] arrayOffji1 = a();
    if (arrayOffji1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    fji[] arrayOffji2 = new fji[paramInt];
    a(arrayOffji1, arrayOffji2);
    this.jdField_a_of_type_ArrayOfFji = arrayOffji2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOffji2, arrayOffji1);
    this.jdField_a_of_type_ArrayOfFji = arrayOffji1;
  }
  
  private void a(fji[] paramArrayOffji1, fji[] paramArrayOffji2)
  {
    int i = 0;
    while (i < paramArrayOffji1.length)
    {
      Object localObject = paramArrayOffji1[i];
      paramArrayOffji1[i] = null;
      if (localObject != null)
      {
        fji localfji = fji.a((fji)localObject);
        if (((fji)localObject).get() == null)
        {
          fji.a((fji)localObject, null);
          fji.a((fji)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localfji;
          break;
          int j = a(fji.a((fji)localObject), paramArrayOffji2.length);
          fji.a((fji)localObject, paramArrayOffji2[j]);
          paramArrayOffji2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    fji[] arrayOffji = a();
    int j;
    for (int i = arrayOffji.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (fji localfji = arrayOffji[j]; localfji != null; localfji = fji.a(localfji)) {
        if (fji.a(localfji) == null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || (paramObject1.equals(paramObject2));
  }
  
  private fji[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfFji;
  }
  
  private fji b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      fji[] arrayOffji = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOffji.length);
      paramObject = arrayOffji[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        fji localfji = fji.a(paramObject);
        if ((i == fji.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOffji[j] = localfji;
          }
          for (;;)
          {
            return paramObject;
            fji.a(localObject, localfji);
          }
        }
        localObject = paramObject;
        paramObject = localfji;
      }
    }
  }
  
  private static Object b(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = jdField_a_of_type_JavaLangObject;
    }
    return localObject;
  }
  
  private static Object c(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == jdField_a_of_type_JavaLangObject) {
      localObject = null;
    }
    return localObject;
  }
  
  public void clear()
  {
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
    this.e += 1;
    fji[] arrayOffji = this.jdField_a_of_type_ArrayOfFji;
    int i = 0;
    while (i < arrayOffji.length)
    {
      arrayOffji[i] = null;
      i += 1;
    }
    this.c = 0;
    while (this.jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null) {}
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) != null;
  }
  
  public boolean containsValue(Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    fji[] arrayOffji = a();
    int j;
    for (int i = arrayOffji.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (fji localfji = arrayOffji[j]; localfji != null; localfji = fji.a(localfji)) {
        if (paramObject.equals(fji.a(localfji))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Set entrySet()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new fjk(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = fji.a(paramObject)) {
      if ((fji.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return fji.a(paramObject);
      }
    }
    return null;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public Set keySet()
  {
    Object localObject = this.jdField_b_of_type_JavaUtilSet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new fjn(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    fji[] arrayOffji = a();
    int j = a(i, arrayOffji.length);
    for (paramObject1 = arrayOffji[j]; paramObject1 != null; paramObject1 = fji.a(paramObject1)) {
      if ((i == fji.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = fji.a(paramObject1);
        if (paramObject2 != localObject) {
          fji.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOffji[j];
    arrayOffji[j] = new fji(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOffji.length * 2);
    }
    return null;
  }
  
  public void putAll(Map paramMap)
  {
    int i = 1073741824;
    int j = paramMap.size();
    if (j == 0) {
      return;
    }
    if (j > this.d)
    {
      j = (int)(j / this.jdField_b_of_type_Float + 1.0F);
      if (j <= 1073741824) {
        break label126;
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ArrayOfFji.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfFji.length) {
        a(j);
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put(localEntry.getKey(), localEntry.getValue());
      }
      break;
      label126:
      i = j;
    }
  }
  
  public Object remove(Object paramObject)
  {
    Object localObject2 = b(paramObject);
    int i = a(localObject2);
    fji[] arrayOffji = a();
    int j = a(i, arrayOffji.length);
    paramObject = arrayOffji[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      fji localfji = fji.a(paramObject);
      if ((i == fji.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOffji[j] = localfji;
        }
        for (;;)
        {
          return fji.a(paramObject);
          fji.a(localObject1, localfji);
        }
      }
      localObject1 = paramObject;
      paramObject = localfji;
    }
    return null;
  }
  
  public int size()
  {
    if (this.c == 0) {
      return 0;
    }
    a();
    return this.c;
  }
  
  public Collection values()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilCollection;
    if (localObject != null) {
      return localObject;
    }
    localObject = new fjq(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */