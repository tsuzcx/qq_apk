import android.os.Handler;
import android.os.Looper;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.gdtad.adapter.GdtThreadManagerAdapter.1;

public final class yji
  implements AdThreadManagerAdapter
{
  public boolean postDelayed(Runnable paramRunnable, int paramInt, long paramLong)
  {
    int j = 16;
    int i;
    if (paramInt == 4) {
      i = 128;
    }
    do
    {
      do
      {
        return new Handler(Looper.getMainLooper()).postDelayed(new GdtThreadManagerAdapter.1(this, paramRunnable, i), paramLong);
        i = j;
      } while (paramInt == 3);
      i = j;
    } while (paramInt != 0);
    return new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yji
 * JD-Core Version:    0.7.0.1
 */