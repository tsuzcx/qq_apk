import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class arck
  implements MessageQueue.IdleHandler
{
  arck(arcj paramarcj) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!arcj.access$000().isEmpty())
    {
      localObject = (arcj.a)arcj.access$000().remove(0);
      i = ((arcj.a)localObject).run();
      if (2 == i) {
        arcj.access$000().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.b;
      if (arcj.access$000().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((arcj)localObject).sIsIdleHandlerInQueue = bool;
      return this.b.sIsIdleHandlerInQueue;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arck
 * JD-Core Version:    0.7.0.1
 */