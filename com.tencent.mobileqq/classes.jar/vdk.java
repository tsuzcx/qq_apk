import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;

class vdk
  implements uso
{
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private String jdField_a_of_type_JavaLangString;
  
  vdk(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    uya.a("WSVerticalForHomePresenter", "onPreloadFailed");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    uya.a("WSVerticalForHomePresenter", "onPreloadSuccess");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.equals(paramString1, urv.a(this.jdField_a_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      uya.a("WSVerticalForHomePresenter", "videoPreDownloadManager destroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdk
 * JD-Core Version:    0.7.0.1
 */