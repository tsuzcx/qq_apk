import com.tencent.av.VideoController.b;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import java.util.Comparator;

public class jbv
  implements Comparator<VideoController.b>
{
  public jbv(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity) {}
  
  public int a(VideoController.b paramb1, VideoController.b paramb2)
  {
    if ((paramb2.Ph) && (paramb1.Ph)) {
      return paramb2.level - paramb1.level;
    }
    if ((!paramb2.Ph) && (!paramb1.Ph)) {
      return paramb2.level - paramb1.level;
    }
    if ((paramb2.Ph) && (!paramb1.Ph)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jbv
 * JD-Core Version:    0.7.0.1
 */