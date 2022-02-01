import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask.KandianAdPandentView;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;

public class kob
  implements LiveRoomGiftCallback
{
  public kob(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public void onCall(int paramInt, String paramString)
  {
    if (paramInt == 7)
    {
      QLog.d("KandianAdPandent", 2, "Vpng play completion!");
      KandianAdPandentMask.KandianAdPandentView.a(this.b).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kob
 * JD-Core Version:    0.7.0.1
 */