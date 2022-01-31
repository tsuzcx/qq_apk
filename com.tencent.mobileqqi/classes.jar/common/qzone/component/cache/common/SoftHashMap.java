package common.qzone.component.cache.common;

import hzf;
import hzh;
import hzk;
import hzn;
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
  private hzf[] jdField_a_of_type_ArrayOfHzf;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfHzf = new hzf[16];
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
    this.jdField_a_of_type_ArrayOfHzf = new hzf[paramInt];
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
  
  private hzf a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((hzf.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = hzf.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    hzf localhzf2 = (hzf)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localhzf2 != null)
    {
      int i = a(hzf.a(localhzf2), this.jdField_a_of_type_ArrayOfHzf.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfHzf[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        hzf localhzf1 = hzf.a((hzf)localObject1);
        if (localObject1 == localhzf2)
        {
          if (localObject2 == localhzf2) {
            this.jdField_a_of_type_ArrayOfHzf[i] = localhzf1;
          }
          for (;;)
          {
            hzf.a(localhzf2, null);
            hzf.a(localhzf2, null);
            this.c -= 1;
            break;
            hzf.a(localObject2, localhzf1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localhzf1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    hzf[] arrayOfhzf1 = a();
    if (arrayOfhzf1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    hzf[] arrayOfhzf2 = new hzf[paramInt];
    a(arrayOfhzf1, arrayOfhzf2);
    this.jdField_a_of_type_ArrayOfHzf = arrayOfhzf2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOfhzf2, arrayOfhzf1);
    this.jdField_a_of_type_ArrayOfHzf = arrayOfhzf1;
  }
  
  private void a(hzf[] paramArrayOfhzf1, hzf[] paramArrayOfhzf2)
  {
    int i = 0;
    while (i < paramArrayOfhzf1.length)
    {
      Object localObject = paramArrayOfhzf1[i];
      paramArrayOfhzf1[i] = null;
      if (localObject != null)
      {
        hzf localhzf = hzf.a((hzf)localObject);
        if (((hzf)localObject).get() == null)
        {
          hzf.a((hzf)localObject, null);
          hzf.a((hzf)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localhzf;
          break;
          int j = a(hzf.a((hzf)localObject), paramArrayOfhzf2.length);
          hzf.a((hzf)localObject, paramArrayOfhzf2[j]);
          paramArrayOfhzf2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    hzf[] arrayOfhzf = a();
    int j;
    for (int i = arrayOfhzf.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (hzf localhzf = arrayOfhzf[j]; localhzf != null; localhzf = hzf.a(localhzf)) {
        if (hzf.a(localhzf) == null) {
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
  
  private hzf[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfHzf;
  }
  
  private hzf b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      hzf[] arrayOfhzf = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfhzf.length);
      paramObject = arrayOfhzf[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        hzf localhzf = hzf.a(paramObject);
        if ((i == hzf.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOfhzf[j] = localhzf;
          }
          for (;;)
          {
            return paramObject;
            hzf.a(localObject, localhzf);
          }
        }
        localObject = paramObject;
        paramObject = localhzf;
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
    hzf[] arrayOfhzf = this.jdField_a_of_type_ArrayOfHzf;
    int i = 0;
    while (i < arrayOfhzf.length)
    {
      arrayOfhzf[i] = null;
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
    hzf[] arrayOfhzf = a();
    int j;
    for (int i = arrayOfhzf.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (hzf localhzf = arrayOfhzf[j]; localhzf != null; localhzf = hzf.a(localhzf)) {
        if (paramObject.equals(hzf.a(localhzf))) {
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
    localObject = new hzh(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = hzf.a(paramObject)) {
      if ((hzf.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return hzf.a(paramObject);
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
    localObject = new hzk(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    hzf[] arrayOfhzf = a();
    int j = a(i, arrayOfhzf.length);
    for (paramObject1 = arrayOfhzf[j]; paramObject1 != null; paramObject1 = hzf.a(paramObject1)) {
      if ((i == hzf.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = hzf.a(paramObject1);
        if (paramObject2 != localObject) {
          hzf.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOfhzf[j];
    arrayOfhzf[j] = new hzf(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOfhzf.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfHzf.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfHzf.length) {
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
    hzf[] arrayOfhzf = a();
    int j = a(i, arrayOfhzf.length);
    paramObject = arrayOfhzf[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      hzf localhzf = hzf.a(paramObject);
      if ((i == hzf.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOfhzf[j] = localhzf;
        }
        for (;;)
        {
          return hzf.a(paramObject);
          hzf.a(localObject1, localhzf);
        }
      }
      localObject1 = paramObject;
      paramObject = localhzf;
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
    localObject = new hzn(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */