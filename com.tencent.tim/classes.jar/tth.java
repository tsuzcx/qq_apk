import java.util.List;

public class tth
  extends ttl<Integer>
{
  public tth(List<tsl<Integer>> paramList)
  {
    super(paramList);
  }
  
  public Integer a(tsl<Integer> paramtsl, float paramFloat)
  {
    if ((paramtsl.startValue == null) || (paramtsl.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Integer.valueOf(twr.evaluate(paramFloat, ((Integer)paramtsl.startValue).intValue(), ((Integer)paramtsl.endValue).intValue()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tth
 * JD-Core Version:    0.7.0.1
 */