import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.4;
import java.io.File;
import java.util.Comparator;

public class sgp
  implements Comparator<File>
{
  public sgp(AnimationDrawableFactory.4 param4) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgp
 * JD-Core Version:    0.7.0.1
 */