import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class nak
  implements Handler.Callback
{
  nak(nai paramnai) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(nai.access$200(), 2, "mUIHandler handleMessage() msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      label175:
      label181:
      do
      {
        return false;
        nai.a(this.a).sendEmptyMessageDelayed(0, 3000L);
        long l2 = this.a.jdField_a_of_type_Nba.cY();
        long l1;
        if (this.a.isFullScreen)
        {
          l1 = nai.a(this.a).cU();
          if (l1 <= l2) {
            break label175;
          }
        }
        for (;;)
        {
          l1 = 3000L - (System.currentTimeMillis() - l1);
          if (l1 <= 0L) {
            break label181;
          }
          nai.a(this.a).removeMessages(0);
          nai.a(this.a).sendEmptyMessageDelayed(0, l1);
          return false;
          l1 = this.a.jdField_a_of_type_Naq$a.cX();
          break;
          l1 = l2;
        }
      } while (this.a.jdField_a_of_type_Naq$d.a() == null);
      if (this.a.jdField_a_of_type_Naq$d.a().isPlaying())
      {
        nai.a(this.a, false);
        return false;
      }
      nai.b(this.a, true);
      return false;
    }
    muj.I(nai.a(this.a), 0);
    nai.a(this.a).setAlpha(0.2F);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nak
 * JD-Core Version:    0.7.0.1
 */