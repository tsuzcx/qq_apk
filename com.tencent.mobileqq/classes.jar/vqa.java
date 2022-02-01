import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import java.lang.ref.WeakReference;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData;
import qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiRspData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import qqcircle.QQCircleFeedBase.StRewardData;

public class vqa
  implements zxl<QCircleReportBean>
{
  private static String jdField_a_of_type_JavaLangString = "QCirclePolyRequestManager";
  private Context jdField_a_of_type_AndroidContentContext;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private zxl<QCircleReportBean> jdField_a_of_type_Zxl;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private WeakReference<QCirclePolyLikeAniView> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_b_of_type_Boolean;
  private WeakReference<View> c;
  
  public vqa(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    int j = 0;
    int i = 0;
    vrr localvrr;
    vrt localvrt;
    if (paramInt == 0) {
      if (a())
      {
        vrg.a(39, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        localvrr = vrr.a();
        localvrt = new vrt().a("likebutton").b("unlike").a(a()).a(paramStFeed);
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo != null) {
          paramInt = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition;
        }
        localvrr.a(localvrt.a(paramInt).c(paramStFeed.poster.id.get()));
      }
    }
    do
    {
      return;
      vrc.a(39, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, a());
      break;
      if (paramInt == 1)
      {
        if (a()) {
          vrg.a(36, 3, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        }
        for (;;)
        {
          localvrr = vrr.a();
          localvrt = new vrt().a("liketype").b("like").a(a()).a(paramStFeed);
          paramInt = j;
          if (this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo != null) {
            paramInt = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition;
          }
          localvrr.a(localvrt.a(paramInt).c(paramStFeed.poster.id.get()));
          zwp.a().a(new QCircleFuelAnimationEvent());
          return;
          vrc.a(36, 3, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, a());
        }
      }
    } while ((paramInt == 21) || (paramInt != 22));
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2, int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    Object localObject = uxx.a(paramStFeed.likeInfo);
    QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData localStDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData();
    localStDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(paramStPolyLike1);
    localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(paramStPolyLike2);
    localObject = new QCircleDoLikeRequest(paramStFeed, paramInt, (FeedCloudMeta.StLike)localObject, localStDoLikeReqDoPolyLikeBusiReqData, a(), paramBoolean);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new vqd(this, (QCircleDoLikeRequest)localObject, paramInt, paramStFeed, paramStPolyLike1, paramStPolyLike2));
  }
  
  private void a(FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiRspData localStDoLikeReqDoPolyLikeBusiRspData;
    if (paramStDoLikeRsp != null) {
      localStDoLikeReqDoPolyLikeBusiRspData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiRspData();
    }
    try
    {
      localStDoLikeReqDoPolyLikeBusiRspData.mergeFrom(paramStDoLikeRsp.busiRspData.get().toByteArray());
      if (localStDoLikeReqDoPolyLikeBusiRspData.rewardData.myMoney.get() >= 0L) {
        vpp.a().a((float)localStDoLikeReqDoPolyLikeBusiRspData.rewardData.myMoney.get());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStDoLikeRsp)
    {
      paramStDoLikeRsp.printStackTrace();
    }
  }
  
  private boolean a()
  {
    return QCircleReportBean.isContentDetailPage(a());
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getPageId(jdField_a_of_type_JavaLangString, (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(jdField_a_of_type_JavaLangString, paramQCircleReportBean);
  }
  
  public void a(ReportExtraTypeInfo paramReportExtraTypeInfo, View paramView1, View paramView2, QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = paramReportExtraTypeInfo;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView1);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQCirclePolyLikeAniView);
    this.c = new WeakReference(paramView2);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    Object localObject2 = new QQCircleFeedBase.StLikeBusiData();
    for (;;)
    {
      try
      {
        Object localObject1 = new QQCircleFeedBase.StLikeBusiData();
        ((InvalidProtocolBufferMicroException)localObject2).printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        try
        {
          ((QQCircleFeedBase.StLikeBusiData)localObject1).mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
          if (((QQCircleFeedBase.StLikeBusiData)localObject1).rewardstatus.get() != 1) {
            break label181;
          }
          bool = true;
          QLog.d(jdField_a_of_type_JavaLangString, 1, "hasReward:" + bool);
          j = paramStFeed.likeInfo.count.get();
          if (paramInt != 21) {
            break label187;
          }
          i = j;
          if (!bool) {
            i = j + 1;
          }
          paramStFeed.likeInfo.count.set(i);
          paramStFeed.likeInfo.status.set(paramInt);
          zwp.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, paramStPolyLike2, paramInt, i));
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          boolean bool;
          int j;
          int i;
          break label173;
        }
        localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
        localObject1 = localObject2;
        localObject2 = localInvalidProtocolBufferMicroException2;
      }
      label173:
      continue;
      label181:
      bool = false;
      continue;
      label187:
      if (paramInt == 1)
      {
        i = j + 1;
      }
      else
      {
        i = j;
        if (paramInt == 0) {
          i = j - 1;
        }
      }
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    int i = 1;
    if (!nmd.a(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anni.a(2131693951), 0).a();
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      Object localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
      boolean bool;
      if (TextUtils.isEmpty(((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get())) {
        if (paramStPolyLike.articleType.get() == 0)
        {
          bool = false;
          break label226;
        }
      }
      for (;;)
      {
        paramStPolyLike = new QQCircleFeedBase.StPolyLike();
        label111:
        a(paramStFeed, (QQCircleFeedBase.StPolyLike)localObject, paramStPolyLike, i, bool);
        QLog.d(jdField_a_of_type_JavaLangString, 4, " request type:" + i);
        a(i, paramStFeed);
        return;
        if (paramStPolyLike.articleType.get() == 1)
        {
          bool = true;
          i = 21;
          break label226;
          if (((QQCircleFeedBase.StPolyLike)localObject).articleType.get() == 0)
          {
            i = 0;
            bool = false;
            break label226;
          }
          i = ((QQCircleFeedBase.StPolyLike)localObject).articleType.get();
          if (i == 1)
          {
            bool = true;
            i = 22;
            break label226;
          }
        }
        label226:
        do
        {
          break label111;
          i = -1;
          bool = false;
          if (i == 0) {
            break;
          }
        } while (i != 22);
      }
      return;
    }
    catch (Exception paramStFeed) {}
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    ((QCirclePolyLikeAniView)this.jdField_b_of_type_JavaLangRefWeakReference.get()).startRewardAni(paramStPolyLike, (View)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (View)this.c.get(), a(), new vqc(this, paramStFeed, paramInt, paramStPolyLike), true);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike1, View paramView, int paramInt, int[] paramArrayOfInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    ((QCirclePolyLikeAniView)this.jdField_b_of_type_JavaLangRefWeakReference.get()).startZanAni(paramStPolyLike1, paramView, (View)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (View)this.c.get(), paramArrayOfInt, a(), new vqb(this, paramStFeed, paramInt, paramStPolyLike2, paramStPolyLike1));
  }
  
  public void a(zxl<QCircleReportBean> paramzxl)
  {
    this.jdField_a_of_type_Zxl = paramzxl;
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Zxl != null) {
      return QCircleReportBean.getParentPageId(jdField_a_of_type_JavaLangString, (QCircleReportBean)this.jdField_a_of_type_Zxl.getReportBean());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */