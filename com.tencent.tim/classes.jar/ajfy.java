import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupSelectionFragment;
import java.util.HashSet;

public class ajfy
  implements ajfl.b
{
  public ajfy(MsgBackupSelectionFragment paramMsgBackupSelectionFragment) {}
  
  public void a(boolean paramBoolean, RecentBaseData paramRecentBaseData)
  {
    if (paramBoolean) {
      MsgBackupSelectionFragment.a(this.a).bi.add(paramRecentBaseData);
    }
    for (;;)
    {
      int i = MsgBackupSelectionFragment.a(this.a).bi.size();
      MsgBackupSelectionFragment.a(this.a, i);
      return;
      MsgBackupSelectionFragment.a(this.a).bi.remove(paramRecentBaseData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfy
 * JD-Core Version:    0.7.0.1
 */