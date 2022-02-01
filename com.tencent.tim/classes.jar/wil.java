import android.os.Bundle;
import mqq.observer.BusinessObserver;

class wil
  implements BusinessObserver
{
  wil(wii paramwii, wii.b paramb) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.a != null)) {
      this.a.z(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wil
 * JD-Core Version:    0.7.0.1
 */