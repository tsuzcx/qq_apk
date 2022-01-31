import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;

public class wea
  implements ConditionSearchManager.IConfigListener
{
  public wea(AddContactsView paramAddContactsView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onGetConfig | isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((paramInt == 2) && (paramBoolean))
    {
      this.a.b = true;
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wea
 * JD-Core Version:    0.7.0.1
 */