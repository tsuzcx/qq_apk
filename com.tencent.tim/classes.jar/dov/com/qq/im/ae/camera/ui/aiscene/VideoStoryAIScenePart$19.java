package dov.com.qq.im.ae.camera.ui.aiscene;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import awxg;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;

public class VideoStoryAIScenePart$19
  implements Runnable
{
  public VideoStoryAIScenePart$19(awxg paramawxg, AEMaterialPanel paramAEMaterialPanel, int paramInt) {}
  
  public void run()
  {
    int i = this.f.getHeight();
    int j = this.eDL;
    int k = awxg.a(this.this$0).getMeasuredHeight();
    Object localObject = new int[2];
    awxg.a(this.this$0).getLocationInWindow((int[])localObject);
    i = j - i - k - 10 - localObject[1];
    localObject = ObjectAnimator.ofFloat(awxg.a(this.this$0), "translationY", new float[] { 0.0F, i });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(awxg.b(this.this$0), "translationY", new float[] { 0.0F, i });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(awxg.b(this.this$0), "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).with(localObjectAnimator1).with(localObjectAnimator2);
    localAnimatorSet.setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.19
 * JD-Core Version:    0.7.0.1
 */