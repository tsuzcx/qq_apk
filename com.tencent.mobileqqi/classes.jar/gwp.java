import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;

public class gwp
  implements TroopMemberApiClient.Callback
{
  public gwp(TroopAssistantFeedsJsHandler paramTroopAssistantFeedsJsHandler, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("ret", false)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopJspTroopAssistantFeedsJsHandler.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopJspTroopAssistantFeedsJsHandler.c(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gwp
 * JD-Core Version:    0.7.0.1
 */