import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.qphone.base.util.QLog;

class agao
  implements Animation.AnimationListener
{
  agao(agan paramagan, agba paramagba1, int paramInt1, double paramDouble, boolean paramBoolean1, boolean paramBoolean2, agba paramagba2, boolean paramBoolean3, boolean paramBoolean4, Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((Face2FaceAddFriendActivity)this.b.mContext).b(this.jdField_a_of_type_Agba, this.val$isPush, this.ccq);
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceFriendBubbleView.setStatusWithAnimation(this.Is);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendInAnimation currentUin ( " + this.c.bGh.substring(0, 4) + ", " + this.cWg + " ) Animation Start  ");
    }
    double d2 = Math.atan(this.cF) * 180.0D / 3.141592653589793D * this.b.flag;
    double d1 = d2;
    if (this.cco) {
      d1 = 180.0D - d2;
    }
    this.b.wo = ((float)d1);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.TAG, 2, "startFriendInAnimation uinToHoleIndex add( " + this.c.bGh.substring(0, 4) + ", " + this.cWg + " )");
    }
    this.b.bz(2, this.ccp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agao
 * JD-Core Version:    0.7.0.1
 */