import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.PrinterSubOptionActivity;
import com.dataline.activities.PrinterSubOptionActivity.a;
import com.dataline.activities.PrinterSubOptionActivity.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ch
  implements View.OnClickListener
{
  public ch(PrinterSubOptionActivity.b paramb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView.findViewById(2131364342);
    PrinterSubOptionActivity.a locala;
    if (localObject != null)
    {
      locala = (PrinterSubOptionActivity.a)this.b.a.M.get(((Integer)((TextView)localObject).getTag()).intValue());
      if (locala.din == 0L) {
        break label150;
      }
    }
    label150:
    for (localObject = this.b.a.b.b.a(locala.din);; localObject = this.b.a.b.b.b(locala.name))
    {
      this.b.a.b.b.a = ((co)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("sPrinterName", locala.name);
      ((Intent)localObject).putExtra("sPrintDin", locala.din);
      this.b.a.setResult(-1, (Intent)localObject);
      this.b.a.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ch
 * JD-Core Version:    0.7.0.1
 */