import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import java.util.Comparator;

public class atrl
  implements Comparator<FileManagerEntity>
{
  public atrl(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (paramFileManagerEntity2.srvTime > paramFileManagerEntity1.srvTime) {
      return 1;
    }
    if (paramFileManagerEntity2.srvTime < paramFileManagerEntity1.srvTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrl
 * JD-Core Version:    0.7.0.1
 */