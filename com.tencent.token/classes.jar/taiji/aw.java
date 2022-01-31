package taiji;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class aw
  implements av
{
  final List a;
  final Object b;
  
  aw(Object paramObject)
  {
    this(Collections.emptyList(), paramObject);
  }
  
  aw(List paramList, Object paramObject)
  {
    this.a = paramList;
    this.b = paramObject;
  }
  
  public boolean b()
  {
    return !this.a.isEmpty();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=").append(this.b);
    if (!this.a.isEmpty()) {
      localStringBuilder.append(", values=").append(Arrays.toString(this.a.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.aw
 * JD-Core Version:    0.7.0.1
 */