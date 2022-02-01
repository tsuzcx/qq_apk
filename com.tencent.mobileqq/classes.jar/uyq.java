import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

class uyq
  implements Observer<vup<FeedCloudRead.StGetMainPageRsp>>
{
  uyq(uyp paramuyp) {}
  
  public void a(@Nullable vup<FeedCloudRead.StGetMainPageRsp> paramvup)
  {
    if ((paramvup == null) || (paramvup.a() == null)) {
      QLog.d("QCirclePersonalBottomBlock", 1, "uiStateData is null or getData is null");
    }
    for (;;)
    {
      return;
      if (uyp.a(this.a) == null) {
        QLog.d("QCirclePersonalBottomBlock", 1, "mWidgetView is null");
      }
      try
      {
        QLog.d("QCirclePersonalBottomBlock", 1, "personDetail uiStateData is " + paramvup.a());
        if ((paramvup.a() != 2) && (paramvup.a() != 3)) {
          continue;
        }
        uyp.a(this.a).setFeedCount(((FeedCloudRead.StGetMainPageRsp)paramvup.a()).feedCount.get());
        if ((((FeedCloudRead.StGetMainPageRsp)paramvup.a()).busiRspData.get() == null) || (paramvup.b())) {
          continue;
        }
        QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        try
        {
          localStMainPageBusiRspData.mergeFrom(((FeedCloudRead.StGetMainPageRsp)paramvup.a()).busiRspData.get().toByteArray());
          return;
        }
        catch (Exception paramvup)
        {
          QLog.e("QCirclePersonalBottomBlock", 1, "mergeFrom stMainPageBusiRspData error");
          return;
        }
        return;
      }
      catch (Exception paramvup)
      {
        paramvup.printStackTrace();
        QLog.e("QCirclePersonalBottomBlock", 1, "personDetail setData error" + paramvup.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyq
 * JD-Core Version:    0.7.0.1
 */