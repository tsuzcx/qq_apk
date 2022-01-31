import android.os.Handler;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.widget.YellowTipsLayout;
import org.json.JSONObject;

public class xdn
  implements Runnable
{
  public xdn(CommonHbFragment paramCommonHbFragment, String paramString) {}
  
  public void run()
  {
    JSONObject localJSONObject = YellowTipsLayout.getYellowTipsConfig(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment.a.getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    Handler localHandler = CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment);
    if (localHandler == null) {
      return;
    }
    localHandler.post(new xdo(this, localJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdn
 * JD-Core Version:    0.7.0.1
 */