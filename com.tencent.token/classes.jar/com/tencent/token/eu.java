package com.tencent.token;

public final class eu<F, S>
{
  public final F a;
  public final S b;
  
  public eu(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof eu)) {
      return false;
    }
    paramObject = (eu)paramObject;
    return (a(paramObject.a, this.a)) && (a(paramObject.b, this.b));
  }
  
  public final int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Pair{");
    localStringBuilder.append(String.valueOf(this.a));
    localStringBuilder.append(" ");
    localStringBuilder.append(String.valueOf(this.b));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eu
 * JD-Core Version:    0.7.0.1
 */