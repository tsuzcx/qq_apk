import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.colornote.data.ColorNote;

class ykd
  implements Handler.Callback
{
  ykd(ykc paramykc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((paramMessage.obj instanceof ColorNote))
      {
        paramMessage = (ColorNote)paramMessage.obj;
        ykc.a(this.a, paramMessage);
        ykc.b(this.a, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykd
 * JD-Core Version:    0.7.0.1
 */