package com.tencent.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ahb
  extends ahu
  implements Iterable<ahu>
{
  public final List<ahu> a = new ArrayList();
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof ahb)) && (((ahb)paramObject).a.equals(this.a)));
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final Iterator<ahu> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahb
 * JD-Core Version:    0.7.0.1
 */