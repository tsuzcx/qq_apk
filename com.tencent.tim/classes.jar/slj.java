import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.qphone.base.util.QLog;

public class slj
  extends sli.i
{
  public slj(VideoCombineHelper.2 param2)
  {
    super(param2.this$0);
  }
  
  public void a(sli.h paramh)
  {
    if ((paramh instanceof sli.e)) {
      this.a.a.e("", false, "download failed! msg = " + paramh.msg);
    }
    do
    {
      return;
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
    if ((paramh instanceof sli.g))
    {
      paramh = paramh.a();
      this.a.a.e(paramh.aED, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.val$startTime));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slj
 * JD-Core Version:    0.7.0.1
 */