import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;

public class cmv
  implements AdapterView.OnItemClickListener
{
  public cmv(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((SelectMemberActivity.ResultRecord)paramView.getTag()).a;
    if (this.a.a(paramAdapterView))
    {
      this.a.a(paramAdapterView);
      this.a.c();
      paramInt = this.a.a.a();
      if ((paramInt == 8) || (paramInt == 9) || (paramInt == 6) || (paramInt == 5) || (paramInt == 2)) {
        ((SelectMemberInnerFrame)this.a.a.getCurrentView()).f();
      }
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmv
 * JD-Core Version:    0.7.0.1
 */