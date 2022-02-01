import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class utf
  implements TVK_ICacheMgr.IPreloadCallback, usn<TVK_UserInfo, TVK_PlayerVideoInfo>
{
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private uso jdField_a_of_type_Uso;
  
  public utf(TVK_ICacheMgr paramTVK_ICacheMgr)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = paramTVK_ICacheMgr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(urv.a);
  }
  
  public void a(usj<TVK_UserInfo, TVK_PlayerVideoInfo> paramusj)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) || (paramusj == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramusj.b, (TVK_UserInfo)paramusj.b(), (TVK_PlayerVideoInfo)paramusj.d());
  }
  
  public void a(uso paramuso)
  {
    this.jdField_a_of_type_Uso = paramuso;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(this);
    }
  }
  
  public boolean a(usj<TVK_UserInfo, TVK_PlayerVideoInfo> paramusj)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) || (paramusj == null)) {
      return false;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.isVideoCached(BaseApplicationImpl.getContext(), paramusj.b, (TVK_UserInfo)paramusj.b(), (TVK_PlayerVideoInfo)paramusj.d(), "");
      if ((i == 2) || (i == 1)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      uya.d("TVKPlayerPreDownloader", "[WSVideoPreDownloadManager.java][checkIsCached] Exception url:" + paramusj.b + ", cacheMgr.isVideoCached Exception:" + localException.getMessage());
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(urv.a);
  }
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Uso == null) {
      return;
    }
    this.jdField_a_of_type_Uso.a(paramString1, paramInt, paramString2);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Uso == null) {
      return;
    }
    this.jdField_a_of_type_Uso.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utf
 * JD-Core Version:    0.7.0.1
 */