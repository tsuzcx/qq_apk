import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QzonePerformanceTracer;

public class fny
  implements View.OnClickListener
{
  public fny(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    QzonePerformanceTracer.a(this.a, false);
    QzonePerformanceTracer.b(this.a).setVisibility(0);
    QzonePerformanceTracer.c(this.a).setVisibility(0);
    QzonePerformanceTracer.d(this.a).setVisibility(8);
    QzonePerformanceTracer.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fny
 * JD-Core Version:    0.7.0.1
 */