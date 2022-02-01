import java.util.List;

public class tti
  extends ttl<Float>
{
  public tti(List<tsl<Float>> paramList)
  {
    super(paramList);
  }
  
  Float a(tsl<Float> paramtsl, float paramFloat)
  {
    if ((paramtsl.startValue == null) || (paramtsl.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    return Float.valueOf(twx.lerp(((Float)paramtsl.startValue).floatValue(), ((Float)paramtsl.endValue).floatValue(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tti
 * JD-Core Version:    0.7.0.1
 */