import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.qphone.base.util.QLog;

public class bar
  extends LBSObserver
{
  public bar(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateGetSwitch| isSuc = " + paramBoolean1 + ", userType = " + paramInt + ", curSwitch = " + paramBoolean2);
    }
    if (paramBoolean1)
    {
      if (paramInt != 1) {
        break label67;
      }
      this.a.a(paramBoolean2);
    }
    label67:
    while (paramInt != 64) {
      return;
    }
    this.a.b(paramBoolean2);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateSetShareStatus| isSuc = " + paramBoolean1 + ", beShare = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.a.a(2131364034, 1);
    }
    this.a.b(paramBoolean2);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onUpdateSetPeopleVisible| isSuc = " + paramBoolean1 + ", isVisible = " + paramBoolean2);
    }
    if (!paramBoolean1) {
      this.a.a(2131364034, 1);
    }
    this.a.a(paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bar
 * JD-Core Version:    0.7.0.1
 */