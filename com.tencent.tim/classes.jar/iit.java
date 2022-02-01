import android.os.IBinder.DeathRecipient;

class iit
  implements IBinder.DeathRecipient
{
  iit(iis.b paramb) {}
  
  public void binderDied()
  {
    igd.aK("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iit
 * JD-Core Version:    0.7.0.1
 */