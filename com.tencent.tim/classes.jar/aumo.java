import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aumo
  extends aulm
{
  public aumo(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void t(boolean paramBoolean, int paramInt, String paramString)
  {
    GroupTeamWorkListActivity.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.i("GroupTeamWorkListActivity", 2, " onDeletePad success: " + paramBoolean);
    }
  }
  
  public void u(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupTeamWorkListActivity", 2, "onGetTipFlag isSuccess = " + paramBoolean + ",type: " + paramInt1 + ",flag: " + paramInt2);
    }
    if ((paramBoolean) && (paramInt1 == 1))
    {
      if (paramInt2 != 0) {
        break label186;
      }
      if (GroupTeamWorkListActivity.e(this.this$0) == null)
      {
        GroupTeamWorkListActivity.a(this.this$0, LayoutInflater.from(this.this$0).inflate(2131563167, null));
        GroupTeamWorkListActivity.e(this.this$0).findViewById(2131368236).setOnClickListener(this.this$0);
        GroupTeamWorkListActivity.e(this.this$0).findViewById(2131368228).setOnClickListener(this.this$0);
      }
      if (!GroupTeamWorkListActivity.e(this.this$0))
      {
        GroupTeamWorkListActivity.a(this.this$0, this.this$0, GroupTeamWorkListActivity.e(this.this$0));
        GroupTeamWorkListActivity.a(this.this$0, GroupTeamWorkListActivity.e(this.this$0), 200);
        GroupTeamWorkListActivity.d(this.this$0, true);
      }
    }
    return;
    label186:
    QLog.i("GroupTeamWorkListActivity", 1, "onGetTipFlag flag: " + paramInt2 + ", type: " + paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumo
 * JD-Core Version:    0.7.0.1
 */