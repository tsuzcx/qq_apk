import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.c;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class wrs
  implements LoadDataJob.c
{
  public wrs(LoadDataJob paramLoadDataJob, Map paramMap, List paramList) {}
  
  public void a(int paramInt, wsa paramwsa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "unmarshall task finish id:" + paramInt);
    }
    synchronized (this.hD)
    {
      this.hD.remove(Integer.valueOf(paramInt));
      this.hD.notifyAll();
    }
    synchronized (this.rP)
    {
      this.rP.add(paramwsa);
      if (this.rP.size() == LoadDataJob.a(this.this$0)) {
        this.rP.notifyAll();
      }
      return;
      paramwsa = finally;
      throw paramwsa;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrs
 * JD-Core Version:    0.7.0.1
 */