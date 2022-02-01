import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qphone.base.util.QLog;

public class vlb
  extends ahpp
{
  public vlb(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void Z(boolean paramBoolean, String paramString)
  {
    super.Z(paramBoolean, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onBandIntimateRelationship");
    }
    PermisionPrivacyActivity.a(this.this$0);
  }
  
  protected void k(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    super.k(paramBoolean1, paramString, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onDisbandIntimateRelationship");
    }
    PermisionPrivacyActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlb
 * JD-Core Version:    0.7.0.1
 */