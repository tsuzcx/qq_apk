import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class vgk
  implements Handler.Callback
{
  vgk(vgj paramvgj) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          vgj.a(this.a, false);
          vgj.a(this.a).removeMessages(0);
        } while (vgj.a(this.a) == null);
        vgj.a(this.a).a(true);
        return true;
        vgj.a(this.a, false);
        vgj.a(this.a).removeMessages(1);
      } while (vgj.a(this.a) == null);
      vgj.a(this.a).a(false);
      return true;
    }
    vgj.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgk
 * JD-Core Version:    0.7.0.1
 */