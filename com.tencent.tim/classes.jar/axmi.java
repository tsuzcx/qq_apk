import android.widget.TextView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class axmi
  implements IPlayer.PlayerListener
{
  public axmi(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (AEEditorVideoEditFragment.a(this.this$0) == 0L)
    {
      CMTime localCMTime = AEEditorVideoEditFragment.a(this.this$0).getDuration();
      AEEditorVideoEditFragment.a(this.this$0, ((float)(localCMTime.value * 1000L) / localCMTime.timeScale));
    }
    float f = (float)(paramCMTime.value * 1000L) / paramCMTime.timeScale;
    paramCMTime = axoh.cv(f) + "/" + axoh.cv(AEEditorVideoEditFragment.a(this.this$0));
    AEEditorVideoEditFragment.a(this.this$0).setText(paramCMTime);
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    axiy.i(AEEditorVideoEditFragment.access$500(), "play status changed, current status = " + paramPlayerStatus);
    if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
    {
      AEEditorVideoEditFragment.a(this.this$0, true);
      return;
    }
    AEEditorVideoEditFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmi
 * JD-Core Version:    0.7.0.1
 */