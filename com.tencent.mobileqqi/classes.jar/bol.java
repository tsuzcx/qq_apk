import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Ad;

public class bol
  implements Runnable
{
  public bol(Ad paramAd) {}
  
  public void run()
  {
    if ((this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView != null) && (this.a.d) && (Ad.a(this.a)) && (this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getView().getScrollY() > 0))
    {
      this.a.h();
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bol
 * JD-Core Version:    0.7.0.1
 */