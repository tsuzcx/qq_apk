import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import java.util.Comparator;

public class atru
  implements Comparator<OfflineFileInfo>
{
  public atru(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    return Long.valueOf(paramOfflineFileInfo1.Zm).compareTo(Long.valueOf(paramOfflineFileInfo2.Zm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atru
 * JD-Core Version:    0.7.0.1
 */