import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.timeline.SliderChangeListener;
import com.tencent.tavcut.util.Logger;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;

public class axle
  implements SliderChangeListener
{
  private boolean dvg;
  
  public axle(AEEditorMvClipMenu paramAEEditorMvClipMenu) {}
  
  public void onIndicatorMove(float paramFloat) {}
  
  public void onIndicatorMove(long paramLong)
  {
    CMTime.convertTimeScale(CMTime.fromMs(paramLong), 1000);
  }
  
  public void onIndicatorPress()
  {
    AEEditorMvClipMenu.a(this.a, AEEditorMvClipMenu.b(this.a));
    AEEditorMvClipMenu.a(this.a, false);
    AEEditorMvClipMenu.b(this.a, true);
  }
  
  public void onIndicatorRelease()
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.a;
    if ((AEEditorMvClipMenu.a(this.a) == IPlayer.PlayerStatus.PLAYING) || (AEEditorMvClipMenu.a(this.a) == IPlayer.PlayerStatus.REPLAY)) {}
    for (boolean bool = true;; bool = false)
    {
      AEEditorMvClipMenu.a(localAEEditorMvClipMenu, bool);
      AEEditorMvClipMenu.a(this.a, null);
      AEEditorMvClipMenu.b(this.a, false);
      return;
    }
  }
  
  public void onSelectionChange(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject1 = CMTime.convertTimeScale(CMTime.fromMs(paramLong1), 1000);
    CMTime localCMTime = CMTime.convertTimeScale(CMTime.fromMs(paramLong2), 1000);
    Object localObject2 = localCMTime.sub((CMTime)localObject1);
    if (!paramBoolean)
    {
      if (AEEditorMvClipMenu.a(this.a) == null) {
        AEEditorMvClipMenu.a(this.a, AEEditorMvClipMenu.b(this.a));
      }
      AEEditorMvClipMenu.a(this.a, false);
      AEEditorMvClipMenu.b(this.a, true);
    }
    Logger.i("VideoDemoSlider", "onSelectionChange: seek " + this.dvg + localCMTime.getTimeSeconds());
    AEEditorMvClipMenu.a(this.a, new CMTimeRange((CMTime)localObject1, (CMTime)localObject2));
    localObject2 = this.a;
    if (this.dvg)
    {
      AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject2, (CMTime)localObject1);
      if (paramBoolean)
      {
        AEEditorMvClipMenu.b(this.a, false);
        localObject1 = this.a;
        if ((AEEditorMvClipMenu.a(this.a) != IPlayer.PlayerStatus.PLAYING) && (AEEditorMvClipMenu.a(this.a) != IPlayer.PlayerStatus.REPLAY)) {
          break label224;
        }
      }
    }
    label224:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AEEditorMvClipMenu.a((AEEditorMvClipMenu)localObject1, paramBoolean);
      AEEditorMvClipMenu.a(this.a, null);
      return;
      localObject1 = localCMTime;
      break;
    }
  }
  
  public void onSliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.dvg = paramBoolean;
  }
  
  public void onSliderBarRelease(boolean paramBoolean)
  {
    AEEditorMvClipMenu localAEEditorMvClipMenu = this.a;
    if ((AEEditorMvClipMenu.a(this.a) == IPlayer.PlayerStatus.PLAYING) || (AEEditorMvClipMenu.a(this.a) == IPlayer.PlayerStatus.REPLAY)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      AEEditorMvClipMenu.a(localAEEditorMvClipMenu, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axle
 * JD-Core Version:    0.7.0.1
 */