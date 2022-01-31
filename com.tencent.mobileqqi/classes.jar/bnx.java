import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.model.TroopInfoManager;

class bnx
  extends AsyncTask
{
  bnx(bnw parambnw, TroopInfoManager paramTroopInfoManager, Bundle paramBundle, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a();
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    paramVoid = this.jdField_a_of_type_AndroidOsBundle;
    if ((this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b())) {}
    for (boolean bool = true;; bool = false)
    {
      paramVoid.putBoolean("ret", bool);
      TroopMemberApiService.a(this.jdField_a_of_type_Bnw.a, 12, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
  }
  
  protected void onCancelled() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnx
 * JD-Core Version:    0.7.0.1
 */