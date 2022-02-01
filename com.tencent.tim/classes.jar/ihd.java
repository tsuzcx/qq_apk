import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import java.util.Comparator;

public class ihd
  implements Comparator<VideoController.b>
{
  public ihd(VideoController paramVideoController) {}
  
  public int a(VideoController.b paramb1, VideoController.b paramb2)
  {
    return (int)(paramb1.timeStamp - paramb2.timeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihd
 * JD-Core Version:    0.7.0.1
 */