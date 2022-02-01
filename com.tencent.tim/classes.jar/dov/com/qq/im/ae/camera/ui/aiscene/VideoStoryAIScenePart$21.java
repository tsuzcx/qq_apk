package dov.com.qq.im.ae.camera.ui.aiscene;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import awxg;

public class VideoStoryAIScenePart$21
  implements Runnable
{
  public VideoStoryAIScenePart$21(awxg paramawxg) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(awxg.a(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(awxg.b(this.this$0), "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(awxg.b(this.this$0), "translationY", new float[] { 0.0F });
    Object localObject = new int[2];
    awxg.a(this.this$0).getLocationInWindow((int[])localObject);
    localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
    ((AnimatorSet)localObject).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.21
 * JD-Core Version:    0.7.0.1
 */