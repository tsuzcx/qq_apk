import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup.a;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup.a.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aayj
  implements View.OnClickListener
{
  public aayj(SelectMemberFromFriendGroup.a parama) {}
  
  public void onClick(View paramView)
  {
    SelectMemberFromFriendGroup.a.a locala = (SelectMemberFromFriendGroup.a.a)paramView.getTag();
    if (this.b.a.vB.contains(locala.c))
    {
      this.b.a.vB.remove(locala.c);
      locala.checkBox.setChecked(false);
      this.b.a.a(locala.c, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.b.a.vB.add(locala.c);
      locala.checkBox.setChecked(true);
      this.b.a.a(locala.c, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayj
 * JD-Core Version:    0.7.0.1
 */