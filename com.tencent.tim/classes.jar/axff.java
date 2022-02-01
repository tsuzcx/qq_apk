import android.content.Context;
import com.tencent.mobileqq.widget.GifAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class axff
  extends GifAnimationDrawable
{
  public axff(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    super(paramContext, paramArrayList, paramLong);
  }
  
  public void start()
  {
    if (!this.mIsRunning)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zswp20pro", 2, "start");
      }
      this.mIsRunning = true;
      this.mStarted = true;
      this.mIsLoading = false;
      loadNextFrame();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("zswp20pro", 2, "start but isRunning");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axff
 * JD-Core Version:    0.7.0.1
 */