package common.qzone.component.cache.common;

import fjn;
import fjp;
import fjs;
import fjv;
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
  private fjn[] jdField_a_of_type_ArrayOfFjn;
  private final float jdField_b_of_type_Float;
  private volatile transient Set jdField_b_of_type_JavaUtilSet = null;
  private int c;
  private int d;
  private volatile int e;
  
  public SoftHashMap()
  {
    this.jdField_b_of_type_Float = 0.75F;
    this.d = 16;
    this.jdField_a_of_type_ArrayOfFjn = new fjn[16];
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
    this.jdField_a_of_type_ArrayOfFjn = new fjn[paramInt];
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
  
  private fjn a(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; (paramObject != null) && ((fjn.a(paramObject) != i) || (!a(localObject, paramObject.get()))); paramObject = fjn.a(paramObject)) {}
    return paramObject;
  }
  
  private void a()
  {
    fjn localfjn2 = (fjn)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
    if (localfjn2 != null)
    {
      int i = a(fjn.a(localfjn2), this.jdField_a_of_type_ArrayOfFjn.length);
      Object localObject1 = this.jdField_a_of_type_ArrayOfFjn[i];
      Object localObject2 = localObject1;
      while (localObject1 != null)
      {
        fjn localfjn1 = fjn.a((fjn)localObject1);
        if (localObject1 == localfjn2)
        {
          if (localObject2 == localfjn2) {
            this.jdField_a_of_type_ArrayOfFjn[i] = localfjn1;
          }
          for (;;)
          {
            fjn.a(localfjn2, null);
            fjn.a(localfjn2, null);
            this.c -= 1;
            break;
            fjn.a(localObject2, localfjn1);
          }
        }
        localObject2 = localObject1;
        localObject1 = localfjn1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    fjn[] arrayOffjn1 = a();
    if (arrayOffjn1.length == 1073741824)
    {
      this.d = 2147483647;
      return;
    }
    fjn[] arrayOffjn2 = new fjn[paramInt];
    a(arrayOffjn1, arrayOffjn2);
    this.jdField_a_of_type_ArrayOfFjn = arrayOffjn2;
    if (this.c >= this.d / 2)
    {
      this.d = ((int)(paramInt * this.jdField_b_of_type_Float));
      return;
    }
    a();
    a(arrayOffjn2, arrayOffjn1);
    this.jdField_a_of_type_ArrayOfFjn = arrayOffjn1;
  }
  
  private void a(fjn[] paramArrayOffjn1, fjn[] paramArrayOffjn2)
  {
    int i = 0;
    while (i < paramArrayOffjn1.length)
    {
      Object localObject = paramArrayOffjn1[i];
      paramArrayOffjn1[i] = null;
      if (localObject != null)
      {
        fjn localfjn = fjn.a((fjn)localObject);
        if (((fjn)localObject).get() == null)
        {
          fjn.a((fjn)localObject, null);
          fjn.a((fjn)localObject, null);
          this.c -= 1;
        }
        for (;;)
        {
          localObject = localfjn;
          break;
          int j = a(fjn.a((fjn)localObject), paramArrayOffjn2.length);
          fjn.a((fjn)localObject, paramArrayOffjn2[j]);
          paramArrayOffjn2[j] = localObject;
        }
      }
      i += 1;
    }
  }
  
  private boolean a()
  {
    fjn[] arrayOffjn = a();
    int j;
    for (int i = arrayOffjn.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (fjn localfjn = arrayOffjn[j]; localfjn != null; localfjn = fjn.a(localfjn)) {
        if (fjn.a(localfjn) == null) {
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
  
  private fjn[] a()
  {
    a();
    return this.jdField_a_of_type_ArrayOfFjn;
  }
  
  private fjn b(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    for (;;)
    {
      return null;
      fjn[] arrayOffjn = a();
      Map.Entry localEntry = (Map.Entry)paramObject;
      int i = a(b(localEntry.getKey()));
      int j = a(i, arrayOffjn.length);
      paramObject = arrayOffjn[j];
      Object localObject = paramObject;
      while (paramObject != null)
      {
        fjn localfjn = fjn.a(paramObject);
        if ((i == fjn.a(paramObject)) && (paramObject.equals(localEntry)))
        {
          this.e += 1;
          this.c -= 1;
          if (localObject == paramObject) {
            arrayOffjn[j] = localfjn;
          }
          for (;;)
          {
            return paramObject;
            fjn.a(localObject, localfjn);
          }
        }
        localObject = paramObject;
        paramObject = localfjn;
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
    fjn[] arrayOffjn = this.jdField_a_of_type_ArrayOfFjn;
    int i = 0;
    while (i < arrayOffjn.length)
    {
      arrayOffjn[i] = null;
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
    fjn[] arrayOffjn = a();
    int j;
    for (int i = arrayOffjn.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      for (fjn localfjn = arrayOffjn[j]; localfjn != null; localfjn = fjn.a(localfjn)) {
        if (paramObject.equals(fjn.a(localfjn))) {
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
    localObject = new fjp(this);
    this.jdField_a_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object get(Object paramObject)
  {
    Object localObject = b(paramObject);
    int i = a(localObject);
    paramObject = a();
    for (paramObject = paramObject[a(i, paramObject.length)]; paramObject != null; paramObject = fjn.a(paramObject)) {
      if ((fjn.a(paramObject) == i) && (a(localObject, paramObject.get()))) {
        return fjn.a(paramObject);
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
    localObject = new fjs(this);
    this.jdField_b_of_type_JavaUtilSet = ((Set)localObject);
    return localObject;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    Object localObject = b(paramObject1);
    int i = a(localObject);
    fjn[] arrayOffjn = a();
    int j = a(i, arrayOffjn.length);
    for (paramObject1 = arrayOffjn[j]; paramObject1 != null; paramObject1 = fjn.a(paramObject1)) {
      if ((i == fjn.a(paramObject1)) && (a(localObject, paramObject1.get())))
      {
        localObject = fjn.a(paramObject1);
        if (paramObject2 != localObject) {
          fjn.a(paramObject1, paramObject2);
        }
        return localObject;
      }
    }
    this.e += 1;
    paramObject1 = arrayOffjn[j];
    arrayOffjn[j] = new fjn(localObject, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue, i, paramObject1);
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a(arrayOffjn.length * 2);
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
      j = this.jdField_a_of_type_ArrayOfFjn.length;
      while (j < i) {
        j <<= 1;
      }
      if (j > this.jdField_a_of_type_ArrayOfFjn.length) {
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
    fjn[] arrayOffjn = a();
    int j = a(i, arrayOffjn.length);
    paramObject = arrayOffjn[j];
    Object localObject1 = paramObject;
    while (paramObject != null)
    {
      fjn localfjn = fjn.a(paramObject);
      if ((i == fjn.a(paramObject)) && (a(localObject2, paramObject.get())))
      {
        this.e += 1;
        this.c -= 1;
        if (localObject1 == paramObject) {
          arrayOffjn[j] = localfjn;
        }
        for (;;)
        {
          return fjn.a(paramObject);
          fjn.a(localObject1, localfjn);
        }
      }
      localObject1 = paramObject;
      paramObject = localfjn;
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
    localObject = new fjv(this);
    this.jdField_a_of_type_JavaUtilCollection = ((Collection)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     common.qzone.component.cache.common.SoftHashMap
 * JD-Core Version:    0.7.0.1
 */