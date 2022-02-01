package com.tencent.token;

import com.tencent.turingfd.sdk.qps.switch;

public final class ada
  implements ahk
{
  public final ahn a;
  
  public ada(ahn paramahn)
  {
    this.a = paramahn;
  }
  
  public static ahh<?> a(ahn paramahn, ahx paramahx, aek<?> paramaek, ahp paramahp)
  {
    Object localObject = paramahn.a(new aek(paramahp.a())).a();
    if ((localObject instanceof ahh))
    {
      paramahn = (ahh)localObject;
    }
    else if ((localObject instanceof ahk))
    {
      paramahn = ((ahk)localObject).a(paramahx, paramaek);
    }
    else
    {
      boolean bool = localObject instanceof aht;
      if ((!bool) && (!(localObject instanceof ahe)))
      {
        paramahn = new StringBuilder("Invalid attempt to bind an instance of ");
        paramahn.append(localObject.getClass().getName());
        paramahn.append(" as a @JsonAdapter for ");
        paramahn.append(switch.c(paramaek.b));
        paramahn.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        throw new IllegalArgumentException(paramahn.toString());
      }
      ahe localahe = null;
      if (bool) {
        paramahn = (aht)localObject;
      } else {
        paramahn = null;
      }
      if ((localObject instanceof ahe)) {
        localahe = (ahe)localObject;
      }
      paramahn = new ads(paramahn, localahe, paramahx, paramaek);
    }
    paramahx = paramahn;
    if (paramahn != null)
    {
      paramahx = paramahn;
      if (paramahp.b()) {
        paramahx = new ahz(paramahn);
      }
    }
    return paramahx;
  }
  
  public final <T> ahh<T> a(ahx paramahx, aek<T> paramaek)
  {
    ahp localahp = (ahp)paramaek.a.getAnnotation(ahp.class);
    if (localahp == null) {
      return null;
    }
    return a(this.a, paramahx, paramaek, localahp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ada
 * JD-Core Version:    0.7.0.1
 */