import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView.MovingImg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class uek
  implements Animator.AnimatorListener
{
  public uek(QCirclePolymorphicAniView paramQCirclePolymorphicAniView, yyi paramyyi, View paramView, QCirclePolymorphicAniView.MovingImg paramMovingImg, ueq paramueq) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Yyi != null) {
      this.jdField_a_of_type_Yyi.a();
    }
    if ((this.jdField_a_of_type_AndroidViewView instanceof URLImageView))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView$MovingImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramAnimator = URLDrawable.URLDrawableOptions.obtain();
      paramAnimator.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843582);
      paramAnimator.mRequestWidth = this.jdField_a_of_type_AndroidViewView.getWidth();
      paramAnimator.mRequestHeight = this.jdField_a_of_type_AndroidViewView.getHeight();
      tql.a(this.jdField_a_of_type_Ueq.a().polyIconUrl.get(), (URLImageView)this.jdField_a_of_type_AndroidViewView, paramAnimator, false);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView.removeAllViews();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView.setVisibility(8);
    QLog.d("QCirclePolymorphicAniView", 1, "poly ani end");
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uek
 * JD-Core Version:    0.7.0.1
 */