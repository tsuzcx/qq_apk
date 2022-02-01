import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.a;
import com.tencent.mobileqq.activity.TroopMemberListActivity.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class wbd
  implements View.OnClickListener
{
  public wbd(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    rom.checkNotNull(this.this$0.a);
    rom.checkNotNull(this.this$0.a.rt);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.this$0.a.rt.size())
    {
      localArrayList.add(((TroopMemberListActivity.a)this.this$0.a.rt.get(i)).uin);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.this$0.setResult(-1, localIntent);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbd
 * JD-Core Version:    0.7.0.1
 */