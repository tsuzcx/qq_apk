import android.view.View;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class alvg
  implements AdapterView.e
{
  public alvg(IosTimepicker paramIosTimepicker) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IosTimepicker.a(this.b, paramView, 1);
    if (paramView.getTag() != null)
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt) {
          IosTimepicker.a(this.b, paramAdapterView.getChildAt(paramInt), 0);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvg
 * JD-Core Version:    0.7.0.1
 */