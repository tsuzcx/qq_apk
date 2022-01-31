import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class trv
  implements AdapterView.OnItemClickListener
{
  trv(tru paramtru) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (tru.a(this.a).a().isShowing()) {
      tru.a(this.a).a().dismiss();
    }
    int i = ((bbjh)paramView.getTag()).a.c;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720906;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wim.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720907;
        }
      }
      else
      {
        this.a.a(i);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     trv
 * JD-Core Version:    0.7.0.1
 */