import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class artt
  extends Handler
{
  artt(arts paramarts, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1000: 
      arts localarts = this.this$0;
      if (paramMessage.obj == null) {}
      for (localObject = null;; localObject = (String)paramMessage.obj)
      {
        localarts.Xc((String)localObject);
        break;
      }
    }
    Object localObject = this.this$0;
    if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ((arts)localObject).Ui(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     artt
 * JD-Core Version:    0.7.0.1
 */