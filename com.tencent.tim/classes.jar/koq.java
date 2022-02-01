import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyPatchAdView.a;
import com.tencent.qphone.base.util.QLog;

public class koq
  extends Handler
{
  public koq(ReadInJoyPatchAdView paramReadInJoyPatchAdView, Looper paramLooper)
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
      ReadInJoyPatchAdView.a(this.b, i);
      return;
      ReadInJoyPatchAdView.a(this.b);
      return;
    } while (this.b.a == null);
    this.b.a.b(ReadInJoyPatchAdView.a(this.b), ReadInJoyPatchAdView.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koq
 * JD-Core Version:    0.7.0.1
 */