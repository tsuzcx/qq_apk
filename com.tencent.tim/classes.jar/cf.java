import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.dataline.activities.PrinterOptionActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class cf
  implements CompoundButton.OnCheckedChangeListener
{
  public cf(PrinterOptionActivity paramPrinterOptionActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131692402);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (PrinterOptionActivity.b(this.a))
      {
        PrinterOptionActivity.a(this.a).setVisibility(0);
        PrinterOptionActivity.a(this.a).setText(2131692382);
      }
      else
      {
        PrinterOptionActivity.a(this.a).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.7.0.1
 */