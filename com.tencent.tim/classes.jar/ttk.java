import java.util.List;

public class ttk
  extends ttl<Integer>
{
  public ttk(List<tsl<Integer>> paramList)
  {
    super(paramList);
  }
  
  Integer a(tsl<Integer> paramtsl, float paramFloat)
  {
    if ((paramtsl.startValue == null) || (paramtsl.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(twx.lerp(((Integer)paramtsl.startValue).intValue(), ((Integer)paramtsl.endValue).intValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttk
 * JD-Core Version:    0.7.0.1
 */