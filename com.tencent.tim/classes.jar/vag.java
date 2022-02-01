import android.graphics.PointF;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity.a;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.qphone.base.util.QLog;

public class vag
  implements VipProfileCardDiyActivity.a
{
  public vag(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void fb(int paramInt1, int paramInt2)
  {
    this.this$0.a.setActualViewSize(paramInt1, paramInt2);
    this.this$0.a.invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "updateDiyText: x=" + this.this$0.a.d().x + ", y=" + this.this$0.a.d().y + ", width=" + paramInt1 + ", height=" + paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vag
 * JD-Core Version:    0.7.0.1
 */