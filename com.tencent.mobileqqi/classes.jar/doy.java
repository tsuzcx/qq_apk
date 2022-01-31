import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class doy
  extends Thread
{
  public doy(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  public void run()
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(19);
      if (localTroopHandler != null)
      {
        long l = Long.parseLong(this.a.jdField_b_of_type_JavaLangString);
        localTroopHandler.a(l, 0L, 5, null, 6, 1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(l));
        localTroopHandler.a(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.disband", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     doy
 * JD-Core Version:    0.7.0.1
 */