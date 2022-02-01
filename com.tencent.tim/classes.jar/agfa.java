import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1;
import java.util.Comparator;

public class agfa
  implements Comparator<Long>
{
  public agfa(QfileLocalFileDelPicTabView.1 param1) {}
  
  public int compare(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.equals(paramLong2)) {
      return 1;
    }
    return (int)(paramLong1.longValue() - paramLong2.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfa
 * JD-Core Version:    0.7.0.1
 */