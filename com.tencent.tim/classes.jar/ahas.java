import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

final class ahas
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return (int)(paramFileInfo2.getDate() / 1000L - paramFileInfo1.getDate() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahas
 * JD-Core Version:    0.7.0.1
 */