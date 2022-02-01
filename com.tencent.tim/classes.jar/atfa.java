import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import java.util.Comparator;

class atfa
  implements Comparator<OfflineFileInfo>
{
  atfa(ateh paramateh) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    long l = paramOfflineFileInfo1.Zm;
    return Long.valueOf(paramOfflineFileInfo2.Zm).compareTo(Long.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfa
 * JD-Core Version:    0.7.0.1
 */