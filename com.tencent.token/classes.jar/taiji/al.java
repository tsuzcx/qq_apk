package taiji;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class al<V, O>
  implements ak<O>
{
  final List<o<V>> a;
  final V b;
  
  al(V paramV)
  {
    this(Collections.emptyList(), paramV);
  }
  
  al(List<o<V>> paramList, V paramV)
  {
    this.a = paramList;
    this.b = paramV;
  }
  
  public boolean b()
  {
    return this.a.isEmpty() ^ true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=");
    localStringBuilder.append(this.b);
    if (!this.a.isEmpty())
    {
      localStringBuilder.append(", values=");
      localStringBuilder.append(Arrays.toString(this.a.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.al
 * JD-Core Version:    0.7.0.1
 */