import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterDefaultActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class cd
  implements View.OnClickListener
{
  public cd(PrinterDefaultActivity paramPrinterDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     cd
 * JD-Core Version:    0.7.0.1
 */