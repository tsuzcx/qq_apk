import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.5.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public final class laj
  extends aquy
{
  laj(long paramLong, String paramString, File paramFile1, File paramFile2, WeakReference paramWeakReference) {}
  
  public void onCancel(aquz paramaquz)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyLottieDrawable", 1, this.tk + " download lottie resource fail!");
    }
  }
  
  public void onDone(aquz paramaquz)
  {
    if ((paramaquz != null) && (paramaquz.getParams().getLong("bgLottieResId") == this.tk) && (paramaquz.errCode == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoyLottieDrawable", 1, "download success " + this.adV);
      }
      ThreadManager.excute(new ReadInJoyLottieDrawable.5.1(this), 64, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     laj
 * JD-Core Version:    0.7.0.1
 */