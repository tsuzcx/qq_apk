import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;
import java.util.Comparator;

public class aumd
  implements Comparator<PadInfo>
{
  public aumd(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public int a(PadInfo paramPadInfo1, PadInfo paramPadInfo2)
  {
    long l = paramPadInfo2.lastEditTime - paramPadInfo1.lastEditTime;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumd
 * JD-Core Version:    0.7.0.1
 */