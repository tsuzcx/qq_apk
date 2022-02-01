import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleInviteBannerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StDittoFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StSinglePicBanner;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class ovi
  extends ryh
{
  public static final long zk = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleShowBannerInterval());
  private QCircleInviteBannerView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleInviteBannerView;
  private QQCircleDitto.StSinglePicBanner jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner;
  
  public ovi(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleInviteBannerView = new QCircleInviteBannerView(getContext());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleInviteBannerView;
  }
  
  public void a(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    boolean bool1;
    boolean bool2;
    label85:
    QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew;
    if ((paramStFollowPageData != null) && (paramStFollowPageData.has())) {
      if ((!TextUtils.isEmpty(paramStFollowPageData.tipsTitle.get())) && (oue.a().Hv()))
      {
        bool1 = true;
        if ((!paramStFollowPageData.dittoFeed.has()) || (paramStFollowPageData.dittoFeed.get() == null) || (paramStFollowPageData.dittoFeed.dittoId.get() != 3) || (paramStFollowPageData.dittoFeed.dittoPatternId.get() != 2)) {
          break label294;
        }
        bool2 = true;
        QLog.d("QCircleInviteBannerBlock", 1, "needShowAuthBanner:" + bool1 + "    needShowDittoBanner:" + bool2);
        if ((bool1) || (!bool2)) {
          break label333;
        }
        localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
      }
    }
    for (;;)
    {
      try
      {
        localStCircleDittoDataNew.mergeFrom(paramStFollowPageData.dittoFeed.dittoDataNew.get().toByteArray());
        if (localStCircleDittoDataNew.singlePicBanner.get() != null)
        {
          long l1 = oue.a().du();
          long l2 = System.currentTimeMillis() - l1;
          if (l1 == 0L) {
            break label339;
          }
          if (l2 > zk)
          {
            break label339;
            QLog.d("QCircleInviteBannerBlock", 1, "min interval:" + zk + "    current show interval:" + l2 + "    isValid:" + bool1);
            ur(bool1);
            if (!bool1) {
              break label333;
            }
            setDatas(new ArrayList(Arrays.asList(new QQCircleDitto.StSinglePicBanner[] { (QQCircleDitto.StSinglePicBanner)localStCircleDittoDataNew.singlePicBanner.get() })));
            return;
            bool1 = false;
            break;
            label294:
            bool2 = false;
            break label85;
          }
          bool1 = false;
          continue;
        }
        ur(false);
      }
      catch (Exception paramStFollowPageData)
      {
        QLog.e("QCircleInviteBannerBlock", 1, "getSinglePicBanner error" + paramStFollowPageData.getMessage());
      }
      label333:
      return;
      label339:
      bool1 = true;
    }
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner = ((QQCircleDitto.StSinglePicBanner)this.mDataList.get(paramInt));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleInviteBannerView != null) && (this.jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner != null))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleInviteBannerView.setData(this.jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleInviteBannerView.setInviteBannerClickListener(new ovj(this));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovi
 * JD-Core Version:    0.7.0.1
 */