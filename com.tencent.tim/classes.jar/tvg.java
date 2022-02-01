import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class tvg<V, O>
  implements tve<V, O>
{
  final V bH;
  final List<tsl<V>> keyframes;
  
  tvg(V paramV)
  {
    this(Collections.emptyList(), paramV);
  }
  
  tvg(List<tsl<V>> paramList, V paramV)
  {
    this.keyframes = paramList;
    this.bH = paramV;
  }
  
  public O K()
  {
    return f(this.bH);
  }
  
  public boolean Os()
  {
    return !this.keyframes.isEmpty();
  }
  
  O f(V paramV)
  {
    return paramV;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseInitialValue=").append(this.bH);
    if (!this.keyframes.isEmpty()) {
      localStringBuilder.append(", values=").append(Arrays.toString(this.keyframes.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvg
 * JD-Core Version:    0.7.0.1
 */