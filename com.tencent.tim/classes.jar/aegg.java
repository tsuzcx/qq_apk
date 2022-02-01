import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class aegg
  implements AdapterView.e
{
  public aegg(IphonePickerView paramIphonePickerView) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IphonePickerView.a(this.g, paramView, 1);
    IphonePickerView.a(this.g, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          IphonePickerView.a(this.g, paramAdapterView.getChildAt(paramInt), 0);
          IphonePickerView.a(this.g, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegg
 * JD-Core Version:    0.7.0.1
 */