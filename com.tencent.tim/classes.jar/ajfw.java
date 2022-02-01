import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;
import java.util.List;
import mqq.os.MqqHandler;

public class ajfw
  implements ajdx
{
  public ajfw(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void lq(List<RecentBaseData> paramList)
  {
    MsgBackupSelectionFragment.a(this.a, true);
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a.mDataList.clear();
      this.a.mDataList.addAll(paramList);
    }
    for (;;)
    {
      paramList = MsgBackupSelectionFragment.a(this.a).obtainMessage(10000);
      MsgBackupSelectionFragment.a(this.a).sendMessage(paramList);
      return;
      if (MsgBackupSelectionFragment.a(this.a) == 0) {
        ajgt.report("0X800A232");
      } else if (ajee.cnI) {
        ajgt.report("0X800A257");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfw
 * JD-Core Version:    0.7.0.1
 */