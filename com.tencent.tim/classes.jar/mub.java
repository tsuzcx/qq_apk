import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class mub
  implements kxv.a
{
  public mub(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void b(kxz paramkxz)
  {
    if (QLog.isColorLevel()) {
      QLog.d(mua.access$600(), 2, "UUIDToUrlCallback Callback vid=" + paramkxz.vid + ", url=" + paramkxz.url + ", isH265=" + paramkxz.aiJ + ", isHWCodec=" + paramkxz.Tx + ", fileBitRate=" + paramkxz.adD);
    }
    if ((!TextUtils.isEmpty(paramkxz.url)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.I(paramkxz.url, paramkxz.vid))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.d(paramkxz.url, paramkxz.vid, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.h.duration);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mub
 * JD-Core Version:    0.7.0.1
 */