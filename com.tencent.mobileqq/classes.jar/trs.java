import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class trs
  implements AdapterView.OnItemClickListener
{
  trs(trr paramtrr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (trr.a(this.a).a().isShowing()) {
      trr.a(this.a).a().dismiss();
    }
    int i = ((bbjv)paramView.getTag()).a.c;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720917;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        wij.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131720918;
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
 * Qualified Name:     trs
 * JD-Core Version:    0.7.0.1
 */