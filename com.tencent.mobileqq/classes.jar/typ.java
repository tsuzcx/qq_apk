import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;

class typ
  implements LiveRoomGiftCallback
{
  typ(tym paramtym) {}
  
  public void onCall(int paramInt, String paramString)
  {
    if (paramInt == 7)
    {
      QLog.d("ReadInJoySuperMaskAd", 2, "Vpng play completion!");
      tym.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     typ
 * JD-Core Version:    0.7.0.1
 */