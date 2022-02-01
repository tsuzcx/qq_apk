import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class auhx
  extends Handler
{
  auhx(auhw paramauhw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    atgc localatgc;
    do
    {
      do
      {
        return;
        paramMessage = (atgc)auhw.a(this.this$0).getManager(373);
      } while (paramMessage == null);
      auhw.a(this.this$0);
      auhw.a(this.this$0).addAll(paramMessage.hi());
      auhw.b(this.this$0);
      this.this$0.VO(true);
      return;
      this.this$0.VO(true);
      return;
      paramMessage = (List)paramMessage.obj;
      auhw.a(this.this$0);
      auhw.a(this.this$0, paramMessage);
      auhw.b(this.this$0);
      this.this$0.VO(true);
      return;
      paramMessage = (List)paramMessage.obj;
      auhw.a(this.this$0, paramMessage);
      this.this$0.VO(true);
      return;
      auhw.a(this.this$0);
      auhw.a(this.this$0, auhw.b(this.this$0));
      auhw.b(this.this$0);
      this.this$0.VO(true);
      auhw.b(this.this$0).clear();
      return;
      paramMessage = (List)paramMessage.obj;
      auhw.a(this.this$0, true);
      if ((paramMessage != null) && (paramMessage.size() > 0))
      {
        auhw.b(this.this$0).clear();
        auhw.b(this.this$0).addAll(paramMessage);
      }
      localatgc = (atgc)auhw.b(this.this$0).getManager(373);
    } while ((localatgc == null) || (paramMessage == null) || (paramMessage.size() <= 0));
    localatgc.nE(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhx
 * JD-Core Version:    0.7.0.1
 */