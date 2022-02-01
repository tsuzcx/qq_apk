import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView.MovingImg;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class pgf
  implements Animator.AnimatorListener
{
  public pgf(QCirclePolymorphicAniView paramQCirclePolymorphicAniView, spe.d paramd, View paramView, QCirclePolymorphicAniView.MovingImg paramMovingImg, QCirclePolymorphicLikePopWindow.a parama) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Spe$d != null) {
      this.jdField_a_of_type_Spe$d.onStop();
    }
    if ((this.nT instanceof URLImageView))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView$MovingImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramAnimator = URLDrawable.URLDrawableOptions.obtain();
      paramAnimator.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844799);
      paramAnimator.mRequestWidth = this.nT.getWidth();
      paramAnimator.mRequestHeight = this.nT.getHeight();
      ous.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow$a.a().polyIconUrl.get(), (URLImageView)this.nT, paramAnimator, false);
    }
    this.c.removeAllViews();
    this.c.setVisibility(8);
    QLog.d("QCirclePolymorphicAniView", 1, "poly ani end");
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgf
 * JD-Core Version:    0.7.0.1
 */