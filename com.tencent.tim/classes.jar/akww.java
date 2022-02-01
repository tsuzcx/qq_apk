import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class akww
  extends Handler
{
  akww(akwv paramakwv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    akxe.M(this.this$0.logTag, this.this$0.bUB, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.this$0.a == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        i = paramMessage.arg1;
        paramMessage = (akxr)paramMessage.obj;
        this.this$0.a.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (akxr)paramMessage.obj;
      }
    } while (!(paramMessage.en instanceof Integer));
    this.this$0.a.aO(((Integer)paramMessage.en).intValue(), paramMessage.Wl);
    return;
    int i = paramMessage.arg1;
    paramMessage = (akxr)paramMessage.obj;
    this.this$0.a.b(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (akxr)paramMessage.obj;
    this.this$0.a.c(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (akxr)paramMessage.obj;
    this.this$0.a.d(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)paramMessage.obj;
        this.this$0.a.o(paramMessage.arg1, localArrayList);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
      }
      paramMessage = (akxr)paramMessage.obj;
      this.this$0.a.Nc(((Integer)paramMessage.en).intValue());
      return;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akww
 * JD-Core Version:    0.7.0.1
 */