import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.4;
import java.io.File;
import java.util.Comparator;

public class ylg
  implements Comparator<File>
{
  public ylg(AnimationDrawableFactory.4 param4) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylg
 * JD-Core Version:    0.7.0.1
 */