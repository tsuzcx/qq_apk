import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.List;

public class vpe
  implements uyy
{
  public vpe(WSVerticalDataManager paramWSVerticalDataManager, vos paramvos) {}
  
  public void a(JceStruct paramJceStruct)
  {
    vmp.a("WSVerticalDataManagerLog", "onReadCacheCompleted");
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {
      vmp.a("WSVerticalDataManagerLog", "struct not instanceof stSimpleGetFeedListRsp");
    }
    do
    {
      stSimpleMetaFeed localstSimpleMetaFeed;
      do
      {
        do
        {
          return;
          paramJceStruct = ((stSimpleGetFeedListRsp)paramJceStruct).feeds;
        } while ((paramJceStruct == null) || (paramJceStruct.size() <= 0));
        localstSimpleMetaFeed = (stSimpleMetaFeed)paramJceStruct.get(0);
      } while (!TextUtils.equals(localstSimpleMetaFeed.id, WSVerticalDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalDataManager)));
      WSPublicAccReport.getInstance().getRecommendFullScreenInfo().a(localstSimpleMetaFeed.video_url);
      vmp.a("WSVerticalDataManagerLog", "onReadCacheCompleted feeds.size() = " + paramJceStruct.size());
    } while (this.jdField_a_of_type_Vos == null);
    this.jdField_a_of_type_Vos.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataWSVerticalDataManager.a(paramJceStruct), false, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpe
 * JD-Core Version:    0.7.0.1
 */