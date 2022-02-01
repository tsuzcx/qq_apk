import android.os.Bundle;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleBannerView;
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

public class uya
  extends uzx
{
  public static final long a;
  private QCircleBannerView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView;
  private QQCircleDitto.StSinglePicBanner jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  static
  {
    jdField_a_of_type_Long = TimeUnit.SECONDS.toMillis(QzoneConfig.getQQCircleShowBannerInterval());
  }
  
  public uya(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zxu paramzxu)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView = new QCircleBannerView(getContext());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView.setReportBean(a());
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView;
  }
  
  protected String a()
  {
    return "QCircleInviteBannerBlock";
  }
  
  public void a(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    boolean bool1;
    boolean bool2;
    label85:
    QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew;
    if ((paramStFollowPageData != null) && (paramStFollowPageData.has())) {
      if ((!TextUtils.isEmpty(paramStFollowPageData.tipsTitle.get())) && (uwz.a().c()))
      {
        bool1 = true;
        if ((!paramStFollowPageData.dittoFeed.has()) || (paramStFollowPageData.dittoFeed.get() == null) || (paramStFollowPageData.dittoFeed.dittoId.get() != 3) || (paramStFollowPageData.dittoFeed.dittoPatternId.get() != 2)) {
          break label318;
        }
        bool2 = true;
        QLog.d("QCircleInviteBannerBlock", 1, "needShowAuthBanner:" + bool1 + "    needShowDittoBanner:" + bool2);
        if ((bool1) || (!bool2)) {
          break label357;
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
          long l1 = uwz.a().a();
          long l2 = System.currentTimeMillis() - l1;
          if (l1 == 0L) {
            break label363;
          }
          if (l2 > jdField_a_of_type_Long)
          {
            break label363;
            QLog.d("QCircleInviteBannerBlock", 1, "min interval:" + jdField_a_of_type_Long + "    current show interval:" + l2 + "    isValid:" + bool1);
            a(bool1);
            if (!bool1) {
              break label357;
            }
            if (paramStFollowPageData.busiReport.get() != null) {
              this.jdField_a_of_type_ArrayOfByte = paramStFollowPageData.busiReport.get().toByteArray();
            }
            setDatas(new ArrayList(Arrays.asList(new QQCircleDitto.StSinglePicBanner[] { (QQCircleDitto.StSinglePicBanner)localStCircleDittoDataNew.singlePicBanner.get() })));
            return;
            bool1 = false;
            break;
            label318:
            bool2 = false;
            break label85;
          }
          bool1 = false;
          continue;
        }
        a(false);
      }
      catch (Exception paramStFollowPageData)
      {
        QLog.e("QCircleInviteBannerBlock", 1, "getSinglePicBanner error" + paramStFollowPageData.getMessage());
      }
      label357:
      return;
      label363:
      bool1 = true;
    }
  }
  
  protected String b()
  {
    return "banner";
  }
  
  public void loadData(zxz paramzxz) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.mDataList != null) && (this.mDataList.size() > 0))
    {
      this.jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner = ((QQCircleDitto.StSinglePicBanner)this.mDataList.get(paramInt));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView != null) && (this.jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner != null))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView.setReportInfo(this.jdField_a_of_type_ArrayOfByte);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView.setData(this.jdField_a_of_type_QqcircleQQCircleDitto$StSinglePicBanner);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleBannerView.setInviteBannerClickListener(new uyb(this));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uya
 * JD-Core Version:    0.7.0.1
 */