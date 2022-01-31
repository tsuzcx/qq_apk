import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;

public class awm
  implements Handler.Callback
{
  public awm(NearbyActivity paramNearbyActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      int i = paramMessage.arg1;
      switch (i)
      {
      default: 
        break;
      case 0: 
      case 1: 
        NearbyActivity.a(this.a, i);
        break;
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        NearbyActivity.a(this.a, i);
        break;
      case 6: 
        NearbyActivity.a(this.a, i);
        break;
      case 7: 
        int j = paramMessage.arg2;
        if (j == 1001) {
          NearbyActivity.a(this.a, i);
        } else if (j == 1002) {
          NearbyActivity.a(this.a, i, 7, 70L);
        } else if (j == 1003) {
          NearbyActivity.b(this.a, i, 7, 70L);
        }
        break;
      case 8: 
        NearbyActivity.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awm
 * JD-Core Version:    0.7.0.1
 */