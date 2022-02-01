import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2;
import java.io.File;
import java.util.Comparator;

public class zze
  implements Comparator<File>
{
  public zze(AnimationDrawableFactory.2 param2) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zze
 * JD-Core Version:    0.7.0.1
 */