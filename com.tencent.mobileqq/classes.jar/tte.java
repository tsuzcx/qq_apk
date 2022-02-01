import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.qphone.base.util.QLog;

public class tte
  extends Handler
{
  public tte(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyPatchAdView", 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      int i = 0;
      if ((paramMessage.obj instanceof Integer)) {
        i = ((Integer)paramMessage.obj).intValue();
      }
      ReadInJoyPatchAdView.a(this.a, i);
      return;
      ReadInJoyPatchAdView.a(this.a);
      return;
    } while (this.a.a == null);
    this.a.a.b(ReadInJoyPatchAdView.a(this.a), ReadInJoyPatchAdView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tte
 * JD-Core Version:    0.7.0.1
 */