import com.dataline.util.file.ImageInfo;
import java.util.Comparator;

public final class fxk
  implements Comparator
{
  public int a(ImageInfo paramImageInfo1, ImageInfo paramImageInfo2)
  {
    return -Long.valueOf(paramImageInfo1.a()).compareTo(Long.valueOf(paramImageInfo2.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fxk
 * JD-Core Version:    0.7.0.1
 */