import android.graphics.Path;
import java.util.List;

public class tts
  extends ttg<tvv, Path>
{
  private final tvv a = new tvv();
  private final Path tempPath = new Path();
  
  public tts(List<tsl<tvv>> paramList)
  {
    super(paramList);
  }
  
  public Path a(tsl<tvv> paramtsl, float paramFloat)
  {
    tvv localtvv = (tvv)paramtsl.startValue;
    paramtsl = (tvv)paramtsl.endValue;
    this.a.a(localtvv, paramtsl, paramFloat);
    twx.a(this.a, this.tempPath);
    return this.tempPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tts
 * JD-Core Version:    0.7.0.1
 */