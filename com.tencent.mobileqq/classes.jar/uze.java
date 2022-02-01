import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;

class uze
  implements vgz
{
  private WSVideoPreDownloadManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager;
  private String jdField_a_of_type_JavaLangString;
  
  uze(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager = paramWSVideoPreDownloadManager;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    vmp.a("WSVideoPreloadManager", "onPreloadFailed");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    vmp.a("WSVideoPreloadManager", "onPreloadSuccess");
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.equals(paramString1, vgd.a(this.jdField_a_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager.a();
      vmp.a("WSVideoPreloadManager", "videoPreDownloadManager destroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uze
 * JD-Core Version:    0.7.0.1
 */