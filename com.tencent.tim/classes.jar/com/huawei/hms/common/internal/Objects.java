package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects
{
  private Objects()
  {
    throw new AssertionError("Uninstantiable");
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  public static int hashCode(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(paramObject, null);
  }
  
  public static final class ToStringHelper
  {
    private final List<String> a;
    private final Object b;
    
    private ToStringHelper(Object paramObject)
    {
      this.b = Preconditions.checkNotNull(paramObject);
      this.a = new ArrayList();
    }
    
    public final ToStringHelper add(String paramString, Object paramObject)
    {
      paramString = (String)Preconditions.checkNotNull(paramString);
      paramObject = String.valueOf(paramObject);
      paramString = paramString.length() + paramObject.length() + 1 + paramString + "=" + paramObject;
      this.a.add(paramString);
      return this;
    }
    
    public final String toString()
    {
      Object localObject = this.b.getClass().getSimpleName();
      localObject = new StringBuilder(100).append((String)localObject).append('{');
      int j = this.a.size();
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append((String)this.a.get(i));
        if (i < j - 1) {
          ((StringBuilder)localObject).append(", ");
        }
        i += 1;
      }
      return '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.Objects
 * JD-Core Version:    0.7.0.1
 */