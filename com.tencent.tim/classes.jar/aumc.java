import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;
import java.util.ArrayList;

public class aumc
  implements atdt.a
{
  public aumc(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void Vu(boolean paramBoolean)
  {
    TextView localTextView;
    if (GroupTeamWorkListActivity.a(this.this$0))
    {
      GroupTeamWorkListActivity.a(this.this$0, paramBoolean);
      localTextView = this.this$0.leftView;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = this.this$0.getString(2131691566);; str = this.this$0.getString(2131691565))
    {
      localTextView.setText(str);
      return;
    }
  }
  
  public void etm()
  {
    if (this.this$0.b != null) {
      this.this$0.b.dmH();
    }
    if (GroupTeamWorkListActivity.a(this.this$0))
    {
      this.this$0.setTitle(String.format("已选 %d 项", new Object[] { Integer.valueOf(atiz.Ou()) }));
      if (atiz.ek().size() > 0) {
        GroupTeamWorkListActivity.a(this.this$0).setEnabled(true);
      }
    }
    else
    {
      return;
    }
    GroupTeamWorkListActivity.a(this.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumc
 * JD-Core Version:    0.7.0.1
 */