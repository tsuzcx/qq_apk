import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class arqb
  implements AdapterView.c
{
  public arqb(BindGroupFragment paramBindGroupFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((arpt.a)paramView.getTag()).troopInfo;
    if (paramAdapterView.isThirdAppBind())
    {
      BindGroupFragment.b(this.a, acfp.m(2131703209));
      return;
    }
    if (paramAdapterView.isNewTroop())
    {
      BindGroupFragment.a(this.a, acfp.m(2131703195), paramAdapterView.troopuin);
      return;
    }
    BindGroupFragment.a(this.a, acfp.m(2131703198));
    ((acms)BindGroupFragment.a(this.a).getBusinessHandler(20)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue(), Long.valueOf(paramAdapterView.troopuin).longValue(), BindGroupFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqb
 * JD-Core Version:    0.7.0.1
 */