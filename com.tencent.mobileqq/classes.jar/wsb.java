import com.tencent.biz.subscribe.utils.AnimationDrawableFactory.1;
import java.io.File;
import java.util.Comparator;

public class wsb
  implements Comparator<File>
{
  public wsb(AnimationDrawableFactory.1 param1) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsb
 * JD-Core Version:    0.7.0.1
 */