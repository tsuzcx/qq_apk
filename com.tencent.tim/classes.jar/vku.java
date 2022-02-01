import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qphone.base.util.QLog;

public class vku
  extends acgs
{
  public vku(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateSetShareStatus| isSuc = " + paramBoolean1 + ", beShare = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.this$0.cf(2131719890, 1);
    }
    this.this$0.xL(paramBoolean2);
  }
  
  protected void i(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateGetSwitch| isSuc = " + paramBoolean1 + ", userType = " + paramInt + ", curSwitch = " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramInt == 64)) {
      this.this$0.xL(paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vku
 * JD-Core Version:    0.7.0.1
 */