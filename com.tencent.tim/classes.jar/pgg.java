import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCirclePolyLikeFrameLayout.a;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.lang.ref.WeakReference;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class pgg
  implements View.OnClickListener
{
  public pgg(QCirclePolymorphicLikePopWindow paramQCirclePolymorphicLikePopWindow, QQCircleFeedBase.StPolyLike paramStPolyLike, AnimationView paramAnimationView, QCirclePolymorphicLikePopWindow.a parama) {}
  
  public void onClick(View paramView)
  {
    if (QCirclePolymorphicLikePopWindow.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow) != null) {
      QCirclePolymorphicLikePopWindow.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).biF();
    }
    if (!ozq.a().eM(this.jdField_b_of_type_QqcircleQQCircleFeedBase$StPolyLike.polySource.get())) {
      QQToast.a((Context)QCirclePolymorphicLikePopWindow.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get(), 0, 2131700154, 0).show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QCirclePolymorphicLikePopWindow.b(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get() == null) {
        continue;
      }
      int[] arrayOfInt = new int[2];
      this.a.getLocationOnScreen(arrayOfInt);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.dismiss();
      Object localObject = this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.getContentView().getContext();
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.getContentView().getContext();
      ((Vibrator)((Context)localObject).getSystemService("vibrator")).vibrate(50L);
      try
      {
        localObject = new QQCircleFeedBase.StLikeBusiData();
        ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(QCirclePolymorphicLikePopWindow.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).likeInfo.busiData.get().toByteArray());
        localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
        int i;
        if (QCirclePolymorphicLikePopWindow.a.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow$a).polyLikeID.get().equals(((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get())) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(QCirclePolymorphicLikePopWindow.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow), QCirclePolymorphicLikePopWindow.a.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow$a));
          }
          ((QCirclePolymorphicAniView)QCirclePolymorphicLikePopWindow.b(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get()).startZanAni(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow$a, (View)QCirclePolymorphicLikePopWindow.c(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get(), (View)QCirclePolymorphicLikePopWindow.d(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow).get(), arrayOfInt, QCirclePolymorphicLikePopWindow.a(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow), new pgh(this, i, (QQCircleFeedBase.StPolyLike)localObject));
          break;
          boolean bool = TextUtils.isEmpty(((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.get());
          if (bool) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgg
 * JD-Core Version:    0.7.0.1
 */