import android.view.View;
import com.dataline.activities.PrinterActivity;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;

public class cb
  implements auuo
{
  public cb(PrinterActivity paramPrinterActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramInt = PrinterActivity.a(this.a).a.AD();
    if (paramInt > 0)
    {
      PrinterActivity.a(this.a).a.b.cj();
      this.a.mListView.setSelectionFromBottom(paramInt, 0);
      PrinterActivity.a(this.a).a.b.notifyDataSetChanged();
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     cb
 * JD-Core Version:    0.7.0.1
 */