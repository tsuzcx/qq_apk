import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class slk
  extends sli.i
{
  public slk(VideoCombineHelper.3 param3)
  {
    super(param3.this$0);
  }
  
  public void a(sli.h paramh)
  {
    do
    {
      synchronized (this.a.this$0.bA)
      {
        this.a.this$0.fO.remove(paramh.key);
        if ((paramh instanceof sli.e))
        {
          this.a.a.e("", false, "download failed! msg = " + paramh.msg);
          return;
        }
      }
      if ((paramh instanceof sli.d))
      {
        this.a.a.e("", false, "combine failed! msg = " + paramh.msg);
        return;
      }
    } while (!(paramh instanceof sli.g));
    this.a.a.e("", false, "sending failed! msg = " + paramh.msg);
  }
  
  public void b(sli.h paramh)
  {
    sli.c localc = paramh.a();
    if (((paramh instanceof sli.d)) || (localc.isStop)) {}
    synchronized (this.a.this$0.bA)
    {
      this.a.this$0.fO.remove(paramh.key);
      this.a.a.e(localc.aED, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.val$startTime));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slk
 * JD-Core Version:    0.7.0.1
 */