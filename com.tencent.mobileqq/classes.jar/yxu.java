import android.app.Activity;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.CheckGameListener;
import java.lang.ref.WeakReference;

public final class yxu
  implements Runnable
{
  public yxu(String paramString, Activity paramActivity, ApolloGameWrapper.CheckGameListener paramCheckGameListener) {}
  
  public void run()
  {
    CmGameMainManager localCmGameMainManager = CmGameMainManager.a(this.jdField_a_of_type_JavaLangString);
    if ((localCmGameMainManager == null) || (localCmGameMainManager.a == null) || (localCmGameMainManager.a.get() != this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameWrapper$CheckGameListener.a(false, localCmGameMainManager);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameWrapper$CheckGameListener.a(true, localCmGameMainManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxu
 * JD-Core Version:    0.7.0.1
 */