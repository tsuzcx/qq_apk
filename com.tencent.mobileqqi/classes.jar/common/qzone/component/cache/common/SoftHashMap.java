package common.qzone.component.cache.common;

import idz;
import ieb;
import iee;
import ieh;
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
  private idz[] jdField_a_of_type_ArrayOfIdz;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfIdz = new idz[16];
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
    this.jdField_a_of_type_ArrayOfIdz = new idz[paramInt];
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
  
  private idz a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((idz.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = idz.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    idz localidz2 = (idz)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localidz2 != null)
    {
      int i = a(idz.a(localidz2), this.jdField_a_of_type_ArrayOfIdz.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfIdz[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        idz localidz1 = idz.a((idz)localObject1);
        if (localObject1 == localidz2)
        {
          if (localObject2 == localidz2) {
            this.jdField_a_of_type_ArrayOfIdz[i] = localidz1;
          }
          for (;;)
          {
            idz.a(localidz2, null);
            idz.a(localidz2, null);
            this.c -= 1;
            break;
            idz.a(localObject2, localidz1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localidz1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    idz[] arrayOfidz1 = a();
    if (arrayOfidz1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    idz[] arrayOfidz2 = new idz[paramInt];
    a(arrayOfidz1, arrayOfidz2);
    this.jdField_a_of_type_ArrayOfIdz = arrayOfidz2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOfidz2, arrayOfidz1);
    this.jdField_a_of_type_ArrayOfIdz = arrayOfidz1;
  }
  
  private void a(idz[] paramArrayOfidz1, idz[] paramArrayOfidz2)
  {
    int i = 0;
    while (i < paramArrayOfidz1.length)
    {
      Object localObject = paramArrayOfidz1[i];
      paramArrayOfidz1[i] = null;
      if (localObject != null)
      {
        idz localidz = idz.a((idz)localObject);
        if (((idz)localObject).get() == null)
        {
          idz.a((idz)localObject, null);
          idz.a((idz)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localidz;
          break;
          int j = a(idz.a((idz)localObject), paramArrayOfidz2.length);
          idz.a((idz)localObject, paramArrayOfidz2[j]);
          paramArrayOfidz2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    idz[] arrayOfidz = a();
    int j;
    for (int i = arrayOfidz.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (idz localidz = arrayOfidz[j]; localidz != null; localidz = idz.a(localidz)) {
        if (idz.a(localidz) == null) {
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
  
  private idz[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfIdz;
  }
  
  private idz b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      idz[] arrayOfidz = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOfidz.length);
      paramObject = arrayOfidz[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        idz localidz = idz.a(paramObject);
        if ((i == idz.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOfidz[j] = localidz;
          }
          for (;;)
          {
            return paramObject;
            idz.a(localObject, localidz);
          }
        }
        localObject = paramObject;
        paramObject = localidz;
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
    idz[] arrayOfidz = this.jdField_a_of_type_ArrayOfIdz;
    int i = 0;
    while (i < arrayOfidz.length)
    {
      arrayOfidz[i] = null;
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
    idz[] arrayOfidz = a();
    int j;
    for (int i = arrayOfidz.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (idz localidz = arrayOfidz[j]; localidz != null; localidz = idz.a(localidz)) {
        if (paramObject.equals(idz.a(localidz))) {
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
    localObject = new ieb(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = idz.a(paramObject)) {
      if ((idz.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return idz.a(paramObject);
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
    localObject = new iee(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    idz[] arrayOfidz = a();
    int j = a(i, arrayOfidz.length);
    for (paramObject1 = arrayOfidz[j]; paramObject1 != null; paramObject1 = idz.a(paramObject1)) {
      if ((i == idz.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = idz.a(paramObject1);
        if (paramObject2 != localObject) {
          idz.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOfidz[j];
    arrayOfidz[j] = new idz(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOfidz.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfIdz.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfIdz.length) {
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
    idz[] arrayOfidz = a();
    int j = a(i, arrayOfidz.length);
    paramObject = arrayOfidz[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      idz localidz = idz.a(paramObject);
      if ((i == idz.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOfidz[j] = localidz;
        }
        for (;;)
        {
          return idz.a(paramObject);
          idz.a(localObject1, localidz);
        }
      }
      localObject1 = paramObject;
      paramObject = localidz;
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
    localObject = new ieh(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */