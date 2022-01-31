import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

public class vce
  implements ProgressPieDrawable.OnProgressListener
{
  public vce(ScribbleItemBuilder paramScribbleItemBuilder) {}
  
  public void a(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
    ScribbleItemBuilder.a(this.a).postDelayed(new vcf(this, paramProgressPieDrawable), 100L);
  }
  
  public void a(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vce
 * JD-Core Version:    0.7.0.1
 */