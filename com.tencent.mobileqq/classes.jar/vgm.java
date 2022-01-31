import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

public class vgm
  implements ProgressPieDrawable.OnProgressListener
{
  public vgm(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoRealItemBuilder", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
    ShortVideoRealItemBuilder.a(this.a).postDelayed(new vgn(this, paramProgressPieDrawable), 100L);
  }
  
  public void a(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgm
 * JD-Core Version:    0.7.0.1
 */