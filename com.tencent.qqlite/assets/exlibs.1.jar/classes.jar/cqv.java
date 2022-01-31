import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class cqv
  implements Runnable
{
  public cqv(ConditionSearchManager paramConditionSearchManager) {}
  
  public void run()
  {
    int j = this.a.a();
    int i = -1;
    if (j != 0) {
      i = this.a.a(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "pendCardParseRequest | check reuslt = " + j + " | update result = " + i);
    }
    if (j == 0) {
      ConditionSearchManager.a(this.a).a(new cqw(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqv
 * JD-Core Version:    0.7.0.1
 */