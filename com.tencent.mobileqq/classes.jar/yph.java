import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.apollo.store.ApolloBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class yph
  implements Runnable
{
  public yph(ApolloBaseActivity paramApolloBaseActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    ReportController.b(null, "P_CliOper", "WebStatusReport", "", "", this.jdField_a_of_type_JavaLangString, 0, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.jdField_a_of_type_JavaLangString, Build.VERSION.RELEASE, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.f - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.g), String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.g));
    Object localObject1 = ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity).getAll();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.g + " mCurrentStepTime - mClickTime->" + (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.f - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.g) + " mCurrentStep->" + this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.jdField_a_of_type_Int);
    }
    Object localObject2;
    if (this.jdField_a_of_type_Int != 1)
    {
      if (localObject1 != null)
      {
        localObject2 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.jdField_a_of_type_Long);
        if (((Map)localObject1).containsKey(localObject2)) {
          ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity).edit().remove((String)localObject2).commit();
        }
      }
      return;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject2).getValue() instanceof String))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBaseActivity_report", 2, "current url:" + String.valueOf(((Map.Entry)localObject2).getValue()) + "\n current key:" + (String)((Map.Entry)localObject2).getKey());
        }
        if (!((String)((Map.Entry)localObject2).getKey()).equalsIgnoreCase(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity.jdField_a_of_type_Long)))
        {
          localObject2 = String.valueOf(((Map.Entry)localObject2).getValue());
          ReportController.b(null, "P_CliOper", "WebStatusReport", "", "hard code unknown", this.jdField_a_of_type_JavaLangString, 0, 1, 100, (String)localObject2, Build.VERSION.RELEASE, "100", "200");
        }
      }
    }
    ApolloBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBaseActivity).edit().clear().commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yph
 * JD-Core Version:    0.7.0.1
 */