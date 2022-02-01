import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.MovingImg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vrt
  implements Animator.AnimatorListener
{
  public vrt(QCirclePolyLikeAniView paramQCirclePolyLikeAniView, aazo paramaazo, View paramView, QCirclePolyLikeAniView.MovingImg paramMovingImg, QQCircleFeedBase.StPolyLike paramStPolyLike) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Aazo != null) {
      this.jdField_a_of_type_Aazo.a();
    }
    if ((this.jdField_a_of_type_AndroidViewView instanceof URLImageView))
    {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView$MovingImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramAnimator = URLDrawable.URLDrawableOptions.obtain();
      paramAnimator.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844012);
      paramAnimator.mRequestWidth = this.jdField_a_of_type_AndroidViewView.getWidth();
      paramAnimator.mRequestHeight = this.jdField_a_of_type_AndroidViewView.getHeight();
      uys.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyIconUrl.get(), (URLImageView)this.jdField_a_of_type_AndroidViewView, paramAnimator, false);
    }
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView.removeAllViews();
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView.setVisibility(8);
    QLog.d("QCirclePolymorphicAniView", 1, "poly ani end");
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrt
 * JD-Core Version:    0.7.0.1
 */