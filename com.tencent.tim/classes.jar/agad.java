import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agad
  implements View.OnClickListener
{
  public agad(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.app.getPreferences().edit().putBoolean(this.bGe, true).commit();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new agae(this));
    this.CE.startAnimation(localAlphaAnimation);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agad
 * JD-Core Version:    0.7.0.1
 */