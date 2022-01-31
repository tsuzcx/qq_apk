import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;

public final class zto
  implements Runnable
{
  public zto(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = ((TroopManager)localObject2).a(this.jdField_a_of_type_JavaLangString);
    String str;
    if (localObject1 != null)
    {
      ((TroopInfo)localObject1).wClickBAFTipCount += 1;
      ((TroopManager)localObject2).b((TroopInfo)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_a_of_type_JavaLangString;
      if (((TroopInfo)localObject1).wInsertBAFTipCount != 1) {
        break label85;
      }
    }
    label85:
    for (localObject1 = "0";; localObject1 = "1")
    {
      ReportController.b((QQAppInterface)localObject2, "dc00899", "Grp_addFrd", "", "Grp_AIO", "greyTips_clk", 0, 0, str, (String)localObject1, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zto
 * JD-Core Version:    0.7.0.1
 */