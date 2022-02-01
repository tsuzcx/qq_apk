import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class fme
  implements AdapterView.OnItemSelectedListener
{
  public fme(IphonePickerView paramIphonePickerView) {}
  
  public void a(AdapterView paramAdapterView) {}
  
  public void a_(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IphonePickerView.a(this.a, paramView, 1);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt) {
          IphonePickerView.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fme
 * JD-Core Version:    0.7.0.1
 */