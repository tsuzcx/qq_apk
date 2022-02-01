import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask.KandianAdPandentView;
import com.tencent.qphone.base.util.QLog;

public class koa
  implements Handler.Callback
{
  public koa(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (System.currentTimeMillis() - KandianAdPandentMask.KandianAdPandentView.a(this.b) > 1500L)
      {
        KandianAdPandentMask.KandianAdPandentView.a(this.b, false);
        QLog.d("KandianAdPandent", 2, "time up do not update volume");
      }
      if (KandianAdPandentMask.KandianAdPandentView.b(this.b))
      {
        KandianAdPandentMask.KandianAdPandentView.a(this.b).sendEmptyMessageDelayed(1, 300L);
        this.b.aEV();
        return false;
      }
      KandianAdPandentMask.KandianAdPandentView.a(this.b).removeMessages(1);
      return false;
    }
    KandianAdPandentMask.KandianAdPandentView.a(this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koa
 * JD-Core Version:    0.7.0.1
 */