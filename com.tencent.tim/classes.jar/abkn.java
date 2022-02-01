import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abkn
  implements AdapterView.OnItemClickListener
{
  public abkn(CmGameDebugView paramCmGameDebugView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    CmGameDebugView.a(this.a, paramInt);
    this.a.Hp(paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkn
 * JD-Core Version:    0.7.0.1
 */