package com.tencent.token;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class agt
  implements acj<T>
{
  public agt(Constructor paramConstructor) {}
  
  public final T a()
  {
    try
    {
      Object localObject = this.a.newInstance(null);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localStringBuilder = new StringBuilder("Failed to invoke ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInvocationTargetException.getTargetException());
    }
    catch (InstantiationException localInstantiationException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Failed to invoke ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" with no args");
      throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agt
 * JD-Core Version:    0.7.0.1
 */