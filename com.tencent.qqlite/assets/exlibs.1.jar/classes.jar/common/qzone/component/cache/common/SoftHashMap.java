package common.qzone.component.cache.common;

import flt;
import flv;
import fly;
import fmb;
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
  private flt[] jdField_a_of_type_ArrayOfFlt;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfFlt = new flt[16];
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
    this.jdField_a_of_type_ArrayOfFlt = new flt[paramInt];
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
  
  private flt a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((flt.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = flt.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    flt localflt2 = (flt)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localflt2 != null)
    {
      int i = a(flt.a(localflt2), this.jdField_a_of_type_ArrayOfFlt.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfFlt[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        flt localflt1 = flt.a((flt)localObject1);
        if (localObject1 == localflt2)
        {
          if (localObject2 == localflt2) {
            this.jdField_a_of_type_ArrayOfFlt[i] = localflt1;
          }
          for (;;)
          {
            flt.a(localflt2, null);
            flt.a(localflt2, null);
            this.c -= 1;
            break;
            flt.a(localObject2, localflt1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localflt1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    flt[] arrayOfflt1 = a();
    if (arrayOfflt1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    flt[] arrayOfflt2 = new flt[paramInt];
    a(arrayOfflt1, arrayOfflt2);
    this.jdField_a_of_type_ArrayOfFlt = arrayOfflt2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOfflt2, arrayOfflt1);
    this.jdField_a_of_type_ArrayOfFlt = arrayOfflt1;
  }
  
  private void a(flt[] paramArrayOfflt1, flt[] paramArrayOfflt2)
  {
    int i = 0;
    while (i < paramArrayOfflt1.length)
    {
      Object localObject = paramArrayOfflt1[i];
      paramArrayOfflt1[i] = null;
      if (localObject != null)
      {
        flt localflt = flt.a((flt)localObject);
        if (((flt)localObject).get() == null)
        {
          flt.a((flt)localObject, null);
          flt.a((flt)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localflt;
          break;
          int j = a(flt.a((flt)localObject), paramArrayOfflt2.length);
          flt.a((flt)localObject, paramArrayOfflt2[j]);
          paramArrayOfflt2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    flt[] arrayOfflt = a();
    int j;
    for (int i = arrayOfflt.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (flt localflt = arrayOfflt[j]; localflt != null; localflt = flt.a(localflt)) {
        if (flt.a(localflt) == null) {
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
  
  private flt[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfFlt;
  }
  
  private flt b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      flt[] arrayOfflt = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfflt.length);
      paramObject = arrayOfflt[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        flt localflt = flt.a(paramObject);
        if ((i == flt.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOfflt[j] = localflt;
          }
          for (;;)
          {
            return paramObject;
            flt.a(localObject, localflt);
          }
        }
        localObject = paramObject;
        paramObject = localflt;
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
    flt[] arrayOfflt = this.jdField_a_of_type_ArrayOfFlt;
    int i = 0;
    while (i < arrayOfflt.length)
    {
      arrayOfflt[i] = null;
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
    flt[] arrayOfflt = a();
    int j;
    for (int i = arrayOfflt.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (flt localflt = arrayOfflt[j]; localflt != null; localflt = flt.a(localflt)) {
        if (paramObject.equals(flt.a(localflt))) {
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
    localObject = new flv(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = flt.a(paramObject)) {
      if ((flt.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return flt.a(paramObject);
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
    localObject = new fly(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    flt[] arrayOfflt = a();
    int j = a(i, arrayOfflt.length);
    for (paramObject1 = arrayOfflt[j]; paramObject1 != null; paramObject1 = flt.a(paramObject1)) {
      if ((i == flt.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = flt.a(paramObject1);
        if (paramObject2 != localObject) {
          flt.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOfflt[j];
    arrayOfflt[j] = new flt(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOfflt.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfFlt.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfFlt.length) {
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
    flt[] arrayOfflt = a();
    int j = a(i, arrayOfflt.length);
    paramObject = arrayOfflt[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      flt localflt = flt.a(paramObject);
      if ((i == flt.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOfflt[j] = localflt;
        }
        for (;;)
        {
          return flt.a(paramObject);
          flt.a(localObject1, localflt);
        }
      }
      localObject1 = paramObject;
      paramObject = localflt;
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
    localObject = new fmb(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */