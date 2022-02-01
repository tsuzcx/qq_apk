import android.os.Handler;
import android.os.Message;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.concurrent.atomic.AtomicInteger;

class zjy
  implements zjt.c
{
  zjy(zju paramzju) {}
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool = true;
    Object localObject = this.this$0.ce.obtainMessage(1);
    ((Message)localObject).obj = paramRedTypeInfo;
    this.this$0.ce.sendMessage((Message)localObject);
    localObject = lcm.a();
    if (paramRedTypeInfo != null) {}
    for (;;)
    {
      ((lcm)localObject).nh(bool);
      return;
      bool = false;
    }
  }
  
  public void onFinish()
  {
    this.this$0.aG.decrementAndGet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjy
 * JD-Core Version:    0.7.0.1
 */