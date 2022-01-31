import android.view.View;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class gkj
  implements AdapterView.OnItemSelectedListener
{
  public gkj(IosTimepicker paramIosTimepicker) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IosTimepicker.a(this.a, paramView, 1);
    if (paramView.getTag() != null)
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt) {
          IosTimepicker.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gkj
 * JD-Core Version:    0.7.0.1
 */