import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;

public class vvk
  implements AdapterView.OnItemSelectedListener
{
  public vvk(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    HorizontalSelectColorLayout.a(this.a, paramInt);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvk
 * JD-Core Version:    0.7.0.1
 */