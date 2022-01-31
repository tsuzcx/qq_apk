import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantItemData;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import java.util.Comparator;

public class goc
  implements Comparator
{
  public goc(QZoneShareAlbumAssistantManager paramQZoneShareAlbumAssistantManager) {}
  
  public int a(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData1, QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData2)
  {
    long l1 = paramQZoneShareAlbumAssistantItemData1.lastmsgtime;
    long l2 = paramQZoneShareAlbumAssistantItemData2.lastmsgtime;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     goc
 * JD-Core Version:    0.7.0.1
 */