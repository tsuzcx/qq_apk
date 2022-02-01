import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.comic.ui.QQComicTabBarView;

public class avdu
  extends Handler
{
  public avdu(QQComicTabBarView paramQQComicTabBarView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.this$0.ki = 0.0F;
      QQComicTabBarView.a(this.this$0);
      super.sendMessageDelayed(this.this$0.mHandler.obtainMessage(1), 16L);
      return;
    case 1: 
      if (this.this$0.ki < 1.0F)
      {
        paramMessage = this.this$0;
        paramMessage.ki += 0.05F;
        QQComicTabBarView.b(this.this$0);
        super.sendMessageDelayed(this.this$0.mHandler.obtainMessage(1), 16L);
        return;
      }
      super.sendMessageDelayed(this.this$0.mHandler.obtainMessage(2), 16L);
      return;
    }
    this.this$0.ki = 1.0F;
    this.this$0.df(this.this$0.aXA, this.this$0.aXz);
    this.this$0.aXA = this.this$0.aXz;
    QQComicTabBarView.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdu
 * JD-Core Version:    0.7.0.1
 */