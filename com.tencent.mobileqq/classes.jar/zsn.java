import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class zsn
  extends JobSegment<armr, armr>
{
  zsn(zsi paramzsi, String paramString, int paramInt) {}
  
  protected void a(JobContext paramJobContext, armr paramarmr)
  {
    if (paramarmr.b())
    {
      notifyResult(paramarmr);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper", 2, "appBaseInfo cache is valid");
      }
      return;
    }
    armw.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, true, new zso(this, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsn
 * JD-Core Version:    0.7.0.1
 */