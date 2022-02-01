import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;

class amee
  implements MessageQueue.IdleHandler
{
  amee(amea paramamea) {}
  
  public boolean queueIdle()
  {
    AIOPictureData localAIOPictureData = this.this$0.a();
    amcs localamcs = new amcs();
    if ((localAIOPictureData != null) && (localamcs.a(localAIOPictureData, 4)) && (localamcs.a(localAIOPictureData, 4) == null))
    {
      this.this$0.OS(true);
      this.this$0.updateUI();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amee
 * JD-Core Version:    0.7.0.1
 */