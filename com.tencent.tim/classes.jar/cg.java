import android.view.View;
import com.dataline.activities.PrinterSubOptionActivity;
import com.tencent.widget.XListView;
import java.util.List;

public class cg
  implements cp.a
{
  public cg(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
  public void E(int paramInt)
  {
    if (this.a.b.b != null)
    {
      List localList = this.a.b.b.i();
      if ((localList == null) || (localList.size() > 0)) {
        break label79;
      }
      this.a.findViewById(2131366421).setVisibility(0);
      this.a.mListView.setVisibility(8);
    }
    for (;;)
    {
      this.a.b.b.ch();
      return;
      label79:
      PrinterSubOptionActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     cg
 * JD-Core Version:    0.7.0.1
 */