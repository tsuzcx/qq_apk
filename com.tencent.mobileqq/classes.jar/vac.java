import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class vac
  implements Observer<vxq<FeedCloudRead.StGetMainPageRsp>>
{
  vac(vaa paramvaa) {}
  
  public void a(@Nullable vxq<FeedCloudRead.StGetMainPageRsp> paramvxq)
  {
    if ((paramvxq == null) || (paramvxq.a() == null)) {
      QLog.d("QCirclePersonalBottomBlock", 1, "uiStateData is null or getData is null");
    }
    for (;;)
    {
      return;
      if (vaa.a(this.a) == null) {
        QLog.d("QCirclePersonalBottomBlock", 1, "mWidgetView is null");
      }
      try
      {
        QLog.d("QCirclePersonalBottomBlock", 1, "personDetail uiStateData is " + paramvxq.a());
        if ((paramvxq.a() != 2) && (paramvxq.a() != 3)) {
          continue;
        }
        vaa.a(this.a).setFeedCount(((FeedCloudRead.StGetMainPageRsp)paramvxq.a()).feedCount.get());
        if ((((FeedCloudRead.StGetMainPageRsp)paramvxq.a()).busiRspData.get() == null) || (paramvxq.b())) {
          continue;
        }
        QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        try
        {
          localStMainPageBusiRspData.mergeFrom(((FeedCloudRead.StGetMainPageRsp)paramvxq.a()).busiRspData.get().toByteArray());
          return;
        }
        catch (Exception paramvxq)
        {
          QLog.e("QCirclePersonalBottomBlock", 1, "mergeFrom stMainPageBusiRspData error");
          return;
        }
        return;
      }
      catch (Exception paramvxq)
      {
        paramvxq.printStackTrace();
        QLog.e("QCirclePersonalBottomBlock", 1, "personDetail setData error" + paramvxq.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vac
 * JD-Core Version:    0.7.0.1
 */