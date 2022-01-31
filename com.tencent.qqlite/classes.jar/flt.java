import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QzonePerformanceTracer;

public class flt
  implements View.OnClickListener
{
  public flt(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    QzonePerformanceTracer.c(this.a);
    QzonePerformanceTracer.a(this.a, false);
    QzonePerformanceTracer.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     flt
 * JD-Core Version:    0.7.0.1
 */