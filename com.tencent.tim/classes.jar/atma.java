import com.tencent.tim.cloudfile.feeds.CloudUploadingListActivity;
import java.util.Comparator;

public class atma
  implements Comparator<atmh.a>
{
  public atma(CloudUploadingListActivity paramCloudUploadingListActivity) {}
  
  public int a(atmh.a parama1, atmh.a parama2)
  {
    int i = 0;
    if ((parama1.uploadStatus == 1) && (parama2.uploadStatus != 1)) {
      i = -1;
    }
    while (parama1.uploadStatus != 1) {
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atma
 * JD-Core Version:    0.7.0.1
 */