import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class xtf
  extends MqqHandler
{
  xtf(xsk paramxsk) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          return;
          QQToast.a(xsk.e(this.this$0), 2131720241, 0).show();
          return;
          xsk.f(this.this$0).getString(2131720242);
          paramMessage = (String)paramMessage.obj;
          aqhu.cn(xsk.g(this.this$0), paramMessage);
          QQToast.a(xsk.h(this.this$0), 2, acfp.m(2131702215), 0).show();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = aqha.a(xsk.i(this.this$0), 232, xsk.j(this.this$0).getResources().getString(2131720274), xsk.k(this.this$0).getResources().getString(2131720273), 2131720256, 2131718798, new xtg(this, paramMessage), new xth(this));
      try
      {
        paramMessage.show();
        return;
      }
      catch (Throwable paramMessage)
      {
        return;
      }
    case 10001: 
      this.this$0.dismissProgressDialog();
      QQToast.a(xsk.l(this.this$0), 1, acfp.m(2131702233), 0).show();
      NativeVideoImage.resumeAll();
      xsk.a(this.this$0);
      return;
    case 10000: 
      this.this$0.aGH = true;
      this.this$0.updateProgress(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.this$0.dismissProgressDialog();
    QQToast.a(xsk.m(this.this$0), 2, acfp.m(2131702222), 0).show();
    NativeVideoImage.resumeAll();
    xsk.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtf
 * JD-Core Version:    0.7.0.1
 */