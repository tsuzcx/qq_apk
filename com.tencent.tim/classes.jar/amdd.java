import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class amdd
  extends MqqHandler
{
  amdd(amdc paramamdc) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(amdc.a(this.a).mContext, 2131720241, 0).show();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    aqhu.cn(amdc.a(this.a).mContext, paramMessage);
    QQToast.a(amdc.a(this.a).mContext, 2, acfp.m(2131702303), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdd
 * JD-Core Version:    0.7.0.1
 */