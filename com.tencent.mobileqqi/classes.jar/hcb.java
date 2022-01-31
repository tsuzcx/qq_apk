import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.Collection;

public class hcb
  extends Handler
{
  public hcb(TroopFileManager paramTroopFileManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (Collection)arrayOfObject[0];
      boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();
      this.a.b(paramMessage, bool);
      return;
    case 2: 
      paramMessage = (TroopFileInfo)arrayOfObject[0];
      this.a.e(paramMessage);
      return;
    case 3: 
      paramMessage = (TroopFileInfo)arrayOfObject[0];
      this.a.f(paramMessage);
      return;
    case 4: 
      paramMessage = (TroopFileInfo)arrayOfObject[0];
      this.a.g(paramMessage);
      return;
    }
    int i = paramMessage.arg1;
    this.a.b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hcb
 * JD-Core Version:    0.7.0.1
 */