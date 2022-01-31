import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;

public class ybd
  implements AdapterView.OnItemClickListener
{
  public ybd(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ResultRecord)paramView.getTag();
    paramView = paramAdapterView.a;
    if (this.a.a(paramView))
    {
      this.a.e(paramView);
      this.a.a(paramAdapterView, false);
      this.a.j();
      paramInt = this.a.a.a();
      if ((paramInt == 6) || (paramInt == 7) || (paramInt == 5) || (paramInt == 4) || (paramInt == 1) || (paramInt == 0) || (paramInt == 8) || (paramInt == 9)) {
        ((SelectMemberInnerFrame)this.a.a.getCurrentView()).f();
      }
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ybd
 * JD-Core Version:    0.7.0.1
 */