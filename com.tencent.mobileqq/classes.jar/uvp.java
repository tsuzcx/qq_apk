import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

class uvp
  implements TVK_ICacheMgr.IPreloadCallback
{
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private String jdField_a_of_type_JavaLangString;
  
  uvp(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    uqf.a("WSVerticalForHomePresenter", "onPreLoadFailed");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    uqf.a("WSVerticalForHomePresenter", "onPreLoadSucess");
    if (TextUtils.equals(paramString1, ulb.a(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      uqf.a("WSVerticalForHomePresenter", "videoPreDownloadManager destroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvp
 * JD-Core Version:    0.7.0.1
 */