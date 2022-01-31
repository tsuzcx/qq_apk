import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zim
  implements Runnable
{
  public zim(ConditionSearchManager paramConditionSearchManager) {}
  
  public void run()
  {
    int i = -1;
    int j = this.a.a();
    if (j != 0) {
      i = this.a.a(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "pendCardParseRequest | check reuslt = " + j + " | update result = " + i);
    }
    if (j == 0) {
      ConditionSearchManager.a(this.a).a(new zin(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zim
 * JD-Core Version:    0.7.0.1
 */