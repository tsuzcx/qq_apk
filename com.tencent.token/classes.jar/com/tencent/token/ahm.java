package com.tencent.token;

import java.lang.reflect.Type;

public final class ahm
  implements acj<T>
{
  public final ack a = ack.a();
  
  public ahm(Class paramClass, Type paramType) {}
  
  public final T a()
  {
    try
    {
      Object localObject = this.a.b(this.b);
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Unable to invoke no-args constructor for ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahm
 * JD-Core Version:    0.7.0.1
 */