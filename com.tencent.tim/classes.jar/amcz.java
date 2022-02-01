import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class amcz
  extends MqqHandler
{
  amcz(amcy paramamcy) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.b.mContext, 2131720241, 0).show();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    aqhu.cn(this.a.b.mContext, paramMessage);
    QQToast.a(this.a.b.mContext, 2, acfp.m(2131702189), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcz
 * JD-Core Version:    0.7.0.1
 */