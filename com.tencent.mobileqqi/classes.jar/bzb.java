import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.ChatActivity;

public class bzb
  implements Runnable
{
  public bzb(ChatActivity paramChatActivity, Activity paramActivity) {}
  
  public void run()
  {
    ChatActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity, new View(this.jdField_a_of_type_AndroidAppActivity));
    ChatActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity).setOnTouchListener(new bzc(this));
    this.jdField_a_of_type_AndroidAppActivity.addContentView(ChatActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity), new ViewGroup.LayoutParams(-1, -1));
    View localView = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView()).getChildAt(0);
    AnimationSet localAnimationSet = new AnimationSet(false);
    long[] arrayOfLong = new long[6];
    long[] tmp97_95 = arrayOfLong;
    tmp97_95[0] = 200L;
    long[] tmp103_97 = tmp97_95;
    tmp103_97[1] = 300L;
    long[] tmp109_103 = tmp103_97;
    tmp109_103[2] = 200L;
    long[] tmp115_109 = tmp109_103;
    tmp115_109[3] = 300L;
    long[] tmp121_115 = tmp115_109;
    tmp121_115[4] = 200L;
    long[] tmp127_121 = tmp121_115;
    tmp127_121[5] = 300L;
    tmp127_121;
    int i = 0;
    long l = 0L;
    while (i < arrayOfLong.length)
    {
      if (i % 2 != 0)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 10.0F);
        localTranslateAnimation.setDuration(arrayOfLong[i]);
        localTranslateAnimation.setStartOffset(l);
        localTranslateAnimation.setInterpolator(new CycleInterpolator((float)localTranslateAnimation.getDuration() / 60.0F));
        localAnimationSet.addAnimation(localTranslateAnimation);
      }
      l += arrayOfLong[i];
      i += 1;
    }
    localAnimationSet.setAnimationListener(new bzd(this));
    localView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzb
 * JD-Core Version:    0.7.0.1
 */