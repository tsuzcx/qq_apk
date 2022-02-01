import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public class ahat
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.isDirectory())
    {
      if (!paramFileInfo2.isDirectory()) {
        return -1000;
      }
    }
    else if (paramFileInfo2.isDirectory()) {
      return 1000;
    }
    return paramFileInfo1.getName().compareToIgnoreCase(paramFileInfo2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahat
 * JD-Core Version:    0.7.0.1
 */