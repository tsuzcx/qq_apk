package common.qzone.component.cache.common;

import hze;
import hzg;
import hzj;
import hzm;
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
  private hze[] jdField_a_of_type_ArrayOfHze;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfHze = new hze[16];
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
    this.jdField_a_of_type_ArrayOfHze = new hze[paramInt];
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
  
  private hze a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((hze.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = hze.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    hze localhze2 = (hze)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localhze2 != null)
    {
      int i = a(hze.a(localhze2), this.jdField_a_of_type_ArrayOfHze.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfHze[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        hze localhze1 = hze.a((hze)localObject1);
        if (localObject1 == localhze2)
        {
          if (localObject2 == localhze2) {
            this.jdField_a_of_type_ArrayOfHze[i] = localhze1;
          }
          for (;;)
          {
            hze.a(localhze2, null);
            hze.a(localhze2, null);
            this.c -= 1;
            break;
            hze.a(localObject2, localhze1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localhze1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    hze[] arrayOfhze1 = a();
    if (arrayOfhze1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    hze[] arrayOfhze2 = new hze[paramInt];
    a(arrayOfhze1, arrayOfhze2);
    this.jdField_a_of_type_ArrayOfHze = arrayOfhze2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOfhze2, arrayOfhze1);
    this.jdField_a_of_type_ArrayOfHze = arrayOfhze1;
  }
  
  private void a(hze[] paramArrayOfhze1, hze[] paramArrayOfhze2)
  {
    int i = 0;
    while (i < paramArrayOfhze1.length)
    {
      Object localObject = paramArrayOfhze1[i];
      paramArrayOfhze1[i] = null;
      if (localObject != null)
      {
        hze localhze = hze.a((hze)localObject);
        if (((hze)localObject).get() == null)
        {
          hze.a((hze)localObject, null);
          hze.a((hze)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localhze;
          break;
          int j = a(hze.a((hze)localObject), paramArrayOfhze2.length);
          hze.a((hze)localObject, paramArrayOfhze2[j]);
          paramArrayOfhze2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    hze[] arrayOfhze = a();
    int j;
    for (int i = arrayOfhze.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (hze localhze = arrayOfhze[j]; localhze != null; localhze = hze.a(localhze)) {
        if (hze.a(localhze) == null) {
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
  
  private hze[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfHze;
  }
  
  private hze b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      hze[] arrayOfhze = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfhze.length);
      paramObject = arrayOfhze[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        hze localhze = hze.a(paramObject);
        if ((i == hze.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOfhze[j] = localhze;
          }
          for (;;)
          {
            return paramObject;
            hze.a(localObject, localhze);
          }
        }
        localObject = paramObject;
        paramObject = localhze;
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
    hze[] arrayOfhze = this.jdField_a_of_type_ArrayOfHze;
    int i = 0;
    while (i < arrayOfhze.length)
    {
      arrayOfhze[i] = null;
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
    hze[] arrayOfhze = a();
    int j;
    for (int i = arrayOfhze.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (hze localhze = arrayOfhze[j]; localhze != null; localhze = hze.a(localhze)) {
        if (paramObject.equals(hze.a(localhze))) {
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
    localObject = new hzg(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = hze.a(paramObject)) {
      if ((hze.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return hze.a(paramObject);
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
    localObject = new hzj(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    hze[] arrayOfhze = a();
    int j = a(i, arrayOfhze.length);
    for (paramObject1 = arrayOfhze[j]; paramObject1 != null; paramObject1 = hze.a(paramObject1)) {
      if ((i == hze.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = hze.a(paramObject1);
        if (paramObject2 != localObject) {
          hze.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOfhze[j];
    arrayOfhze[j] = new hze(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOfhze.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfHze.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfHze.length) {
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
    hze[] arrayOfhze = a();
    int j = a(i, arrayOfhze.length);
    paramObject = arrayOfhze[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      hze localhze = hze.a(paramObject);
      if ((i == hze.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOfhze[j] = localhze;
        }
        for (;;)
        {
          return hze.a(paramObject);
          hze.a(localObject1, localhze);
        }
      }
      localObject1 = paramObject;
      paramObject = localhze;
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
    localObject = new hzm(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */