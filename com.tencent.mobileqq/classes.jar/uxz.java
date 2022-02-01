import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import java.lang.ref.WeakReference;

class uxz
  implements MiniAppLauncher.MiniAppLaunchListener
{
  private WeakReference<uxx> jdField_a_of_type_JavaLangRefWeakReference;
  
  uxz(uxx paramuxx1, uxx paramuxx2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramuxx2);
  }
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("launch mini program ");
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      vmp.d("WSPublisherDialog", str + ", bundle: " + paramBundle.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxz
 * JD-Core Version:    0.7.0.1
 */