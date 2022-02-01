import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class yyg
  implements yvt.a
{
  public yyg(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof ywu)) {}
    do
    {
      return;
      paramView = (ywu)paramViewHolder;
    } while (paramView.a.msg_type.get() != 2);
    TroopSuspiciousFragment.a(this.this$0, paramView);
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyg
 * JD-Core Version:    0.7.0.1
 */