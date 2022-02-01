import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.qphone.base.util.QLog;

public class algu
  extends GestureDetector.SimpleOnGestureListener
{
  public algu(ProfileTagView paramProfileTagView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll invoked");
    }
    this.this$0.cwM = true;
    paramFloat1 = paramFloat2;
    if (paramMotionEvent1 != null)
    {
      paramFloat1 = paramFloat2;
      if (paramMotionEvent2 != null) {
        paramFloat1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onScroll distance = " + paramFloat1);
    }
    if (Math.abs(paramFloat1) > ProfileTagView.a(this.this$0))
    {
      if ((paramFloat1 > 0.0F) && (this.this$0.mIsFullScreen)) {
        if (this.this$0.atA())
        {
          this.this$0.dFN();
          this.this$0.b.b(null);
        }
      }
      while ((paramFloat1 >= 0.0F) || (this.this$0.mIsFullScreen)) {
        return true;
      }
      this.this$0.atA();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algu
 * JD-Core Version:    0.7.0.1
 */