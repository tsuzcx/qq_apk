import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicPanelDialog.1.1;

public class axnh
  implements Animation.AnimationListener
{
  axnh(axng paramaxng) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    axng.a(this.b, false);
    axng.a(this.b).post(new AEEditorMusicPanelDialog.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    axng.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnh
 * JD-Core Version:    0.7.0.1
 */