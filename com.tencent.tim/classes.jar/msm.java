import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.concurrent.ConcurrentHashMap;

class msm
  extends Handler
{
  msm(msl parammsl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      return;
      paramMessage = this.a.a(false);
    } while (paramMessage == null);
    msl.a(this.a).remove(Integer.valueOf(paramMessage.position));
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramMessage.d;
    if (localAdvertisementInfo != null) {
      localAdvertisementInfo.isShowingGuide = false;
    }
    this.a.b(null, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msm
 * JD-Core Version:    0.7.0.1
 */