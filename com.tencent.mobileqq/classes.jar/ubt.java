import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.lang.ref.WeakReference;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class ubt
  implements View.OnClickListener
{
  public ubt(QCirclePolymorphicLikePopWindow paramQCirclePolymorphicLikePopWindow, QQCircleFeedBase.StPolyLike paramStPolyLike, AnimationView paramAnimationView, ubx paramubx) {}
  
  public void onClick(View paramView)
  {
    if (QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow) != null) {
      QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).a();
    }
    if (!tvt.a().a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polySource.get())) {
      QQToast.a((Context)QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get(), 0, 2131698352, 0).a();
    }
    while (QCirclePolymorphicLikePopWindow.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get() == null) {
      return;
    }
    paramView = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.getLocationOnScreen(paramView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.dismiss();
    Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.getContentView().getContext();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.getContentView().getContext();
    ((Vibrator)((Context)localObject).getSystemService("vibrator")).vibrate(50L);
    try
    {
      localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).likeInfo.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
      int i;
      if (ubx.a(this.jdField_a_of_type_Ubx).polyLikeID.get().equals(((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get())) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow), ubx.a(this.jdField_a_of_type_Ubx));
        }
        ((QCirclePolymorphicAniView)QCirclePolymorphicLikePopWindow.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get()).startZanAni(this.jdField_a_of_type_Ubx, (View)QCirclePolymorphicLikePopWindow.c(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get(), (View)QCirclePolymorphicLikePopWindow.d(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get(), paramView, QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow), new ubu(this, i, (QQCircleFeedBase.StPolyLike)localObject));
        return;
        boolean bool = TextUtils.isEmpty(((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get());
        if (bool) {
          i = 1;
        } else {
          i = 2;
        }
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubt
 * JD-Core Version:    0.7.0.1
 */