package com.tencent.biz.webviewplugin;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.CustomWebView.ScrollInterface;

public class Ad$ScrollListener
  implements CustomWebView.ScrollInterface
{
  public Ad$ScrollListener(Ad paramAd) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.e();
    if (this.a.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!Ad.a(this.a));
      this.a.j();
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
      this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
    } while (!this.a.jdField_a_of_type_Boolean);
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_b_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Ad.ScrollListener
 * JD-Core Version:    0.7.0.1
 */