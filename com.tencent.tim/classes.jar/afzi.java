import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import java.io.File;
import java.util.Comparator;

public class afzi
  implements Comparator<File>
{
  public afzi(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareToIgnoreCase(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzi
 * JD-Core Version:    0.7.0.1
 */