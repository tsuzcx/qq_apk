import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class vhq
  implements TVK_ICacheMgr.IPreloadCallback, vgy<TVK_UserInfo, TVK_PlayerVideoInfo>
{
  private TVK_ICacheMgr jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr;
  private vgz jdField_a_of_type_Vgz;
  
  public vhq(TVK_ICacheMgr paramTVK_ICacheMgr)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr = paramTVK_ICacheMgr;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.stopCacheData(vgd.a);
  }
  
  public void a(vgu<TVK_UserInfo, TVK_PlayerVideoInfo> paramvgu)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) || (paramvgu == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramvgu.b, (TVK_UserInfo)paramvgu.b(), (TVK_PlayerVideoInfo)paramvgu.d());
  }
  
  public void a(vgz paramvgz)
  {
    this.jdField_a_of_type_Vgz = paramvgz;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.setPreloadCallback(this);
    }
  }
  
  public boolean a(vgu<TVK_UserInfo, TVK_PlayerVideoInfo> paramvgu)
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) || (paramvgu == null)) {
      return false;
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.isVideoCached(BaseApplicationImpl.getContext(), paramvgu.b, (TVK_UserInfo)paramvgu.b(), (TVK_PlayerVideoInfo)paramvgu.d(), "");
      if ((i == 2) || (i == 1)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      vmp.d("TVKPlayerPreDownloader", "[WSVideoPreDownloadManager.java][checkIsCached] Exception url:" + paramvgu.b + ", cacheMgr.isVideoCached Exception:" + localException.getMessage());
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.removePreloadCallback();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_ICacheMgr.releasePreload(vgd.a);
  }
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Vgz == null) {
      return;
    }
    this.jdField_a_of_type_Vgz.a(paramString1, paramInt, paramString2);
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Vgz == null) {
      return;
    }
    this.jdField_a_of_type_Vgz.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhq
 * JD-Core Version:    0.7.0.1
 */