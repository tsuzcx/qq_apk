import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Arrays;

class wef
  implements Handler.Callback
{
  private wef(wed paramwed) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      wed.a(this.a, new Error((Throwable)paramMessage.obj));
      return true;
    }
    paramMessage = (Bitmap[])paramMessage.obj;
    int m = paramMessage.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (paramMessage[i] == null) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          wed.a(this.a, Arrays.asList(paramMessage));
        }
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wef
 * JD-Core Version:    0.7.0.1
 */