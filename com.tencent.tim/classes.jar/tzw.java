import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class tzw
  extends JobSegment<ajcn, ajcn>
{
  tzw(tzr paramtzr, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, ajcn paramajcn)
  {
    if (paramajcn.aqp())
    {
      notifyResult(paramajcn);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    ajcr.a().a(this.val$appid, this.val$appType, 1, true, new tzx(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzw
 * JD-Core Version:    0.7.0.1
 */