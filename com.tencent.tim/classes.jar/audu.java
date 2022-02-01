import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

final class audu
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return -Long.valueOf(paramFileInfo1.getDate()).compareTo(Long.valueOf(paramFileInfo2.getDate()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audu
 * JD-Core Version:    0.7.0.1
 */