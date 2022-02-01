import android.os.Bundle;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar.a;

public class axlh
  implements AEEditorTopBar.a
{
  public axlh(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void eMh()
  {
    this.a.a().m(this.a.getActivity(), true);
  }
  
  public void eMi()
  {
    axim.a().adV(1);
    Bundle localBundle = new Bundle(this.a.getArguments());
    localBundle.putString("select_path", AEEditorVideoClipFragment.a(this.a));
    if (AEEditorVideoClipFragment.a(this.a) != null)
    {
      localBundle.putLong("starttime", AEEditorVideoClipFragment.a(this.a).getStartUs());
      localBundle.putLong("endtime", AEEditorVideoClipFragment.a(this.a).getEndUs());
    }
    for (;;)
    {
      this.a.getArguments().putString("editor_filter_id", "");
      this.a.a().N(this.a.getModuleId(), localBundle);
      return;
      if ((AEEditorVideoClipFragment.a(this.a) != null) && (AEEditorVideoClipFragment.a(this.a).getDuration().getTimeUs() > 60000000L))
      {
        localBundle.putLong("starttime", 0L);
        localBundle.putLong("endtime", 60000000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axlh
 * JD-Core Version:    0.7.0.1
 */