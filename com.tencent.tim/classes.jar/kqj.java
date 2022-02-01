import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kqj
  extends ayfh
{
  public kqj(@NonNull aygz paramaygz, long paramLong)
  {
    super(paramaygz, paramLong);
  }
  
  private void aFZ()
  {
    y(2131380030).setVisibility(8);
    TextView localTextView = (TextView)y(2131365426);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    Long localLong = (Long)this.el.get(i);
    if (localLong != null) {
      switch ((int)localLong.longValue())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      kbp.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      continue;
      kbp.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      continue;
      kbp.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    aFZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqj
 * JD-Core Version:    0.7.0.1
 */