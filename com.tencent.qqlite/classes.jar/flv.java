import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.util.QzonePerformanceTracer;

public class flv
  implements View.OnClickListener
{
  public flv(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    QzonePerformanceTracer.a(this.a, true);
    this.a.b();
    QzonePerformanceTracer.b(this.a).setVisibility(8);
    QzonePerformanceTracer.c(this.a).setVisibility(8);
    QzonePerformanceTracer.d(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     flv
 * JD-Core Version:    0.7.0.1
 */