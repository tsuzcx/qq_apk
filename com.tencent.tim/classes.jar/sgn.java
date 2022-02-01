import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.2;
import java.io.File;
import java.util.Comparator;

public class sgn
  implements Comparator<File>
{
  public sgn(AnimationDrawableFactory.2 param2) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgn
 * JD-Core Version:    0.7.0.1
 */