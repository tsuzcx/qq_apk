import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder.3.1;
import com.tencent.qphone.base.util.QLog;

public final class xmo
  implements arht.b
{
  public xmo(Handler paramHandler) {}
  
  public void a(arht paramarht)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribbleItemBuilder", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramarht);
    }
    this.val$handler.postDelayed(new ScribbleItemBuilder.3.1(this, paramarht), 100L);
  }
  
  public void a(arht paramarht, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xmo
 * JD-Core Version:    0.7.0.1
 */