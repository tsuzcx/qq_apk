import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.a;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.qphone.base.util.QLog;

public class agau
  implements Animation.AnimationListener
{
  public agau(Face2FaceDetailBaseView paramFace2FaceDetailBaseView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(4);
    this.a.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.deI();
    this.a.CH.setBackgroundDrawable(null);
    this.a.jdField_b_of_type_ComTencentMobileqqFacetofaceFace2FaceDetailBaseView$a.deC();
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationEnd " + hashCode());
    }
    Face2FaceDetailBaseView.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationStart " + hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agau
 * JD-Core Version:    0.7.0.1
 */