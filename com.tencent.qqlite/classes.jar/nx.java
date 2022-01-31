import com.tencent.biz.pubaccount.CustomWebView;

public class nx
  implements Runnable
{
  public nx(CustomWebView paramCustomWebView, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a) {
      return;
    }
    try
    {
      CustomWebView.a(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, "javascript:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     nx
 * JD-Core Version:    0.7.0.1
 */