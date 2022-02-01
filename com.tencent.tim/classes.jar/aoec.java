import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import java.util.Comparator;

public class aoec
  implements Comparator<PadInfo>
{
  public aoec(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
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
 * Qualified Name:     aoec
 * JD-Core Version:    0.7.0.1
 */