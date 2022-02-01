import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

class uun
  implements TVK_ICacheMgr.IPreloadCallback
{
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private String jdField_a_of_type_JavaLangString;
  
  uun(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    upe.a("WSVerticalForHomePresenter", "onPreLoadFailed");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    upe.a("WSVerticalForHomePresenter", "onPreLoadSucess");
    if (TextUtils.equals(paramString1, ukd.a(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      upe.a("WSVerticalForHomePresenter", "videoPreDownloadManager destroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uun
 * JD-Core Version:    0.7.0.1
 */