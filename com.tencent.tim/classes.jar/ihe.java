import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import java.util.Comparator;

public class ihe
  implements Comparator<VideoController.b>
{
  public ihe(VideoController paramVideoController) {}
  
  public int a(VideoController.b paramb1, VideoController.b paramb2)
  {
    return (int)(paramb1.timeStamp - paramb2.timeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihe
 * JD-Core Version:    0.7.0.1
 */