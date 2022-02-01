import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import java.lang.ref.WeakReference;

class ukc
  implements MiniAppLauncher.MiniAppLaunchListener
{
  private WeakReference<uka> jdField_a_of_type_JavaLangRefWeakReference;
  
  ukc(uka paramuka1, uka paramuka2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuka2);
  }
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      uya.d("WSPublisherDialog", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukc
 * JD-Core Version:    0.7.0.1
 */