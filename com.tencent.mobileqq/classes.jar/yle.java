import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.2;
import java.io.File;
import java.util.Comparator;

public class yle
  implements Comparator<File>
{
  public yle(AnimationDrawableFactory.2 param2) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yle
 * JD-Core Version:    0.7.0.1
 */