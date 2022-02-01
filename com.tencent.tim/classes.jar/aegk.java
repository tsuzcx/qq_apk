import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class aegk
  implements AdapterView.e
{
  public aegk(TimeSelectView paramTimeSelectView) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TimeSelectView.a(this.b, paramView, 1);
    TimeSelectView.a(this.b, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          TimeSelectView.a(this.b, paramAdapterView.getChildAt(paramInt), 0);
          TimeSelectView.a(this.b, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegk
 * JD-Core Version:    0.7.0.1
 */