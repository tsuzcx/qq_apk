import android.content.Context;
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

public class vsj
  implements aabg<QCircleReportBean>
{
  private static String jdField_a_of_type_JavaLangString = "QCirclePolyRequestManager";
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private Context jdField_a_of_type_AndroidContentContext;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private WeakReference<QCirclePolyLikeAniView> jdField_b_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_b_of_type_Boolean;
  private WeakReference<View> c;
  
  public vsj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, FeedCloudMeta.StFeed paramStFeed)
  {
    int j = 0;
    int i = 0;
    vud localvud;
    vuf localvuf;
    if (paramInt == 0) {
      if (a())
      {
        vtr.a(39, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        localvud = vud.a();
        localvuf = new vuf().a("likebutton").b("unlike").a(a()).a(paramStFeed);
        paramInt = i;
        if (this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo != null) {
          paramInt = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition;
        }
        localvud.a(localvuf.a(paramInt).c(paramStFeed.poster.id.get()));
      }
    }
    do
    {
      return;
      vtn.a(39, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, a());
      break;
      if (paramInt == 1)
      {
        if (a()) {
          vtr.a(36, 3, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        }
        for (;;)
        {
          localvud = vud.a();
          localvuf = new vuf().a("liketype").b("like").a(a()).a(paramStFeed);
          paramInt = j;
          if (this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo != null) {
            paramInt = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition;
          }
          localvud.a(localvuf.a(paramInt).c(paramStFeed.poster.id.get()));
          aaak.a().a(new QCircleFuelAnimationEvent());
          return;
          vtn.a(36, 3, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, a());
        }
      }
    } while ((paramInt == 21) || (paramInt != 22));
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2, int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    Object localObject = uzg.a(paramStFeed.likeInfo);
    QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData localStDoLikeReqDoPolyLikeBusiReqData = new QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData();
    localStDoLikeReqDoPolyLikeBusiReqData.polyLikeInfo.set(paramStPolyLike2);
    if ((paramStPolyLike2.articleType.get() != 0) || (paramStPolyLike1.articleType.get() != 1)) {
      localStDoLikeReqDoPolyLikeBusiReqData.curPolyLikeInfo.set(paramStPolyLike1);
    }
    localObject = new QCircleDoLikeRequest(paramStFeed, paramInt, (FeedCloudMeta.StLike)localObject, localStDoLikeReqDoPolyLikeBusiReqData, a(), paramBoolean);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new vsm(this, (QCircleDoLikeRequest)localObject, paramInt, paramStFeed, paramStPolyLike1, paramStPolyLike2));
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
        vry.a().a((float)localStDoLikeReqDoPolyLikeBusiRspData.rewardData.myMoney.get());
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
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getPageId(jdField_a_of_type_JavaLangString, (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean a()
  {
    return QCircleReportBean.getReportBean(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
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
        localObject1 = new QQCircleFeedBase.StLikeBusiData();
        ((InvalidProtocolBufferMicroException)localObject2).printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        try
        {
          ((QQCircleFeedBase.StLikeBusiData)localObject1).mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
          j = paramStFeed.likeInfo.count.get();
          if (paramInt != 21) {
            break label129;
          }
          i = j + 1;
          paramStFeed.likeInfo.count.set(i);
          paramStFeed.likeInfo.status.set(paramInt);
          aaak.a().a(new QCirclePolyPraiseUpdateEvent(paramStFeed.id.get(), paramStPolyLike1, paramStPolyLike2, paramInt, i));
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          Object localObject1;
          int j;
          int i;
          break label121;
        }
        localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
        localObject1 = localObject2;
        localObject2 = localInvalidProtocolBufferMicroException2;
      }
      label121:
      continue;
      label129:
      i = j;
      if (paramInt == 1)
      {
        i = j;
        if (!uzg.a(paramStPolyLike2, (QQCircleFeedBase.StLikeBusiData)localObject1)) {
          i = j + 1;
        }
      }
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    boolean bool = false;
    int i = 1;
    if (!nny.a(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131693968), 0).a();
    }
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      Object localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
      if (paramStPolyLike.articleType.get() == 0) {}
      for (;;)
      {
        a(paramStFeed, (QQCircleFeedBase.StPolyLike)localObject, paramStPolyLike, i, bool);
        QLog.d(jdField_a_of_type_JavaLangString, 4, " request type:" + i);
        a(i, paramStFeed);
        return;
        i = paramStPolyLike.articleType.get();
        if (i == 1)
        {
          bool = true;
          i = 21;
        }
        else
        {
          i = -1;
        }
      }
      return;
    }
    catch (Exception paramStFeed) {}
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike, int paramInt)
  {
    ((QCirclePolyLikeAniView)this.jdField_b_of_type_JavaLangRefWeakReference.get()).startRewardAni(paramStPolyLike, (View)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (View)this.c.get(), a(), new vsl(this, paramStFeed, paramInt, paramStPolyLike), true);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike1, View paramView, int paramInt, int[] paramArrayOfInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StPolyLike paramStPolyLike2)
  {
    ((QCirclePolyLikeAniView)this.jdField_b_of_type_JavaLangRefWeakReference.get()).startZanAni(paramStPolyLike1, paramView, (View)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (View)this.c.get(), paramArrayOfInt, a(), new vsk(this, paramStFeed, paramInt, paramStPolyLike2, paramStPolyLike1));
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId(jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getParentPageId(jdField_a_of_type_JavaLangString, (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsj
 * JD-Core Version:    0.7.0.1
 */