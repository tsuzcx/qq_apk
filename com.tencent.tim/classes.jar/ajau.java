import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ajau
  extends Handler
{
  ajau(ajat.a parama, Looper paramLooper, ajat paramajat)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    synchronized (ajat.a(this.jdField_b_of_type_Ajat$a.a))
    {
      ajat.c localc = ajat.a(this.jdField_b_of_type_Ajat$a.a, (String)paramMessage.obj);
      if (localc != null) {
        localc.OC(paramMessage.what);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajau
 * JD-Core Version:    0.7.0.1
 */