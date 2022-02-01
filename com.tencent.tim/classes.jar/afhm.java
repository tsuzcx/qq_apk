import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.widget.QQToast;

class afhm
  implements Handler.Callback
{
  afhm(afhl paramafhl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      QQToast.a(afhl.a(this.this$0), 2131694101, 0).show(2131299627);
      return true;
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (EmoticonFromGroupEntity)paramMessage.obj;
      this.this$0.a(paramMessage);
      return true;
    }
    QQToast.a(afhl.a(this.this$0), 1, 2131689839, 0).show(2131299627);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhm
 * JD-Core Version:    0.7.0.1
 */