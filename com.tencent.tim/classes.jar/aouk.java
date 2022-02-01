import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.4.1;

public class aouk
  implements Animation.AnimationListener
{
  public aouk(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.this$0.xR == null) {
      return;
    }
    this.this$0.xR.post(new TroopAvatarWallPreviewActivity.4.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.this$0.aab == null) {
      return;
    }
    this.this$0.aab.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouk
 * JD-Core Version:    0.7.0.1
 */