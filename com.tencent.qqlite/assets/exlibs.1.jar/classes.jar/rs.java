import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Ad;

public class rs
  implements Runnable
{
  public rs(Ad paramAd) {}
  
  public void run()
  {
    if ((this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView != null) && (this.a.d) && (Ad.a(this.a)) && (this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.getView().getScrollY() > 0))
    {
      this.a.i();
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     rs
 * JD-Core Version:    0.7.0.1
 */