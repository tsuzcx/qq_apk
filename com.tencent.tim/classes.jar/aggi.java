import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import java.util.Comparator;

public class aggi
  implements Comparator<OfflineFileInfo>
{
  public aggi(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    return Long.valueOf(paramOfflineFileInfo1.Zm).compareTo(Long.valueOf(paramOfflineFileInfo2.Zm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggi
 * JD-Core Version:    0.7.0.1
 */