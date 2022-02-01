import java.util.List;

public class ttr
  extends ttl<tuj>
{
  public ttr(List<tsl<tuj>> paramList)
  {
    super(paramList);
  }
  
  public tuj a(tsl<tuj> paramtsl, float paramFloat)
  {
    if ((paramtsl.startValue == null) || (paramtsl.endValue == null)) {
      throw new IllegalStateException("Missing values for keyframe.");
    }
    tuj localtuj = (tuj)paramtsl.startValue;
    paramtsl = (tuj)paramtsl.endValue;
    return new tuj(twx.lerp(localtuj.getScaleX(), paramtsl.getScaleX(), paramFloat), twx.lerp(localtuj.getScaleY(), paramtsl.getScaleY(), paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttr
 * JD-Core Version:    0.7.0.1
 */